package com.android.server.media;

import android.R;
import android.app.ActivityManager;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioPlaybackConfiguration;
import android.media.AudioRoutesInfo;
import android.media.IAudioRoutesObserver;
import android.media.IAudioService;
import android.media.IMediaRouter2;
import android.media.IMediaRouter2Manager;
import android.media.IMediaRouterClient;
import android.media.IMediaRouterService;
import android.media.MediaRoute2Info;
import android.media.MediaRouterClientState;
import android.media.RemoteDisplayState;
import android.media.RouteDiscoveryPreference;
import android.media.RouteListingPreference;
import android.media.RoutingSessionInfo;
import android.media.SuggestedDeviceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.IntArray;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TimeUtils;
import com.android.internal.util.DumpUtils;
import com.android.server.LocalServices;
import com.android.server.Watchdog;
import com.android.server.pm.UserManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaRouterService extends IMediaRouterService.Stub implements Watchdog.Monitor {
    private static final long CONNECTED_TIMEOUT = 60000;
    private static final long CONNECTING_TIMEOUT = 5000;
    private static final boolean DEBUG = false;
    private static final String TAG = "MediaRouterService";
    private static final String WORKER_THREAD_NAME = "MediaRouterServiceThread";
    BluetoothDevice mActiveBluetoothDevice;
    private final IntArray mActivePlayerMinPriorityQueue;
    private final IntArray mActivePlayerUidMinPriorityQueue;
    private final ArrayMap<IBinder, ClientRecord> mAllClientRecords;
    private final AudioPlayerStateMonitor mAudioPlayerStateMonitor;
    int mAudioRouteMainType;
    private final IAudioService mAudioService;
    private final String mBluetoothA2dpRouteId;
    private final Context mContext;
    private int mCurrentActiveUserId;
    private final String mDefaultAudioRouteId;
    boolean mGlobalBluetoothA2dpOn;
    private final Handler mHandler;
    private final Object mLock;
    private final Looper mLooper;
    private final BroadcastReceiver mReceiver;
    private final MediaRouter2ServiceImpl mService2;
    private final UserManagerInternal mUserManagerInternal;
    private final SparseArray<UserRecord> mUserRecords;

    private class AudioPlayerActiveStateChangedListenerImpl implements AudioPlayerStateMonitor.OnAudioPlayerActiveStateChangedListener {
        private static final long WAIT_MS = 500;
        private final Runnable mRestoreBluetoothA2dpRunnable;
        final /* synthetic */ MediaRouterService this$0;

        /* synthetic */ AudioPlayerActiveStateChangedListenerImpl(MediaRouterService r1, MediaRouterServiceIA r2) {
            this(r1);
        }

        private AudioPlayerActiveStateChangedListenerImpl(MediaRouterService r2) {
            this.this$0 = r2;
            final MediaRouterService r3 = this.this$0;
            this.mRestoreBluetoothA2dpRunnable = new MediaRouterService$AudioPlayerActiveStateChangedListenerImpl$$ExternalSyntheticLambda0(r3);
        }

        @Override // com.android.server.media.AudioPlayerStateMonitor.OnAudioPlayerActiveStateChangedListener
        public void onAudioPlayerActiveStateChanged(AudioPlaybackConfiguration config, boolean isRemoved) {
            if (isRemoved == false) goto L5;
        L7:
            boolean active = false;
        L8:
            int uid = config.getClientUid();
            int idx = MediaRouterService.m5603$$Nest$fgetmActivePlayerMinPriorityQueue(this.this$0).indexOf(config.getPlayerInterfaceId());
            if (idx < 0) goto L11;
            MediaRouterService.m5603$$Nest$fgetmActivePlayerMinPriorityQueue(this.this$0).remove(idx);
            MediaRouterService.m5604$$Nest$fgetmActivePlayerUidMinPriorityQueue(this.this$0).remove(idx);
        L11:
            int restoreUid = -1;
            if (active == false) goto L15;
            MediaRouterService.m5603$$Nest$fgetmActivePlayerMinPriorityQueue(this.this$0).add(config.getPlayerInterfaceId());
            MediaRouterService.m5604$$Nest$fgetmActivePlayerUidMinPriorityQueue(this.this$0).add(uid);
            restoreUid = uid;
        L17:
            MediaRouterService.m5606$$Nest$fgetmHandler(this.this$0).removeCallbacks(this.mRestoreBluetoothA2dpRunnable);
            if (restoreUid < 0) goto L22;
            this.this$0.restoreRoute(restoreUid);
            if (MediaRouterService.m5610$$Nest$sfgetDEBUG() == false) goto L26;
            Slog.d(MediaRouterService.TAG, "onAudioPlayerActiveStateChanged: uid=" + uid + ", active=" + active + ", restoreUid=" + restoreUid);
            return;
        L26:
            return;
        L22:
            MediaRouterService.m5606$$Nest$fgetmHandler(this.this$0).postDelayed(this.mRestoreBluetoothA2dpRunnable, 500);
            if (MediaRouterService.m5610$$Nest$sfgetDEBUG() == false) goto L28;
            Slog.d(MediaRouterService.TAG, "onAudioPlayerActiveStateChanged: uid=" + uid + ", active=" + active + ", delaying");
            return;
        L28:
            return;
        L15:
            if (MediaRouterService.m5604$$Nest$fgetmActivePlayerUidMinPriorityQueue(this.this$0).size() <= 0) goto L17;
            restoreUid = MediaRouterService.m5604$$Nest$fgetmActivePlayerUidMinPriorityQueue(this.this$0).get(MediaRouterService.m5604$$Nest$fgetmActivePlayerUidMinPriorityQueue(this.this$0).size() - 1);
            goto L17
        L5:
            if (config.isActive() == false) goto L7;
            active = true;
            goto L8
        }
    }

    private class AudioRoutesObserverImpl extends IAudioRoutesObserver.Stub {
        private static final int HEADSET_FLAGS = 19;
        final /* synthetic */ MediaRouterService this$0;

        /* synthetic */ AudioRoutesObserverImpl(MediaRouterService r1, MediaRouterServiceIA r2) {
            this(r1);
        }

        private AudioRoutesObserverImpl(MediaRouterService r1) {
            this.this$0 = r1;
        }

        public void dispatchAudioRoutesChanged(AudioRoutesInfo newRoutes) {
            Object r0 = MediaRouterService.m5607$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (newRoutes.mainType == this.this$0.mAudioRouteMainType) goto L19;
            boolean r2 = false;
            if ((newRoutes.mainType & 19) != 0) goto L17;
            MediaRouterService r1 = this.this$0;     // Catch: Throwable -> L13
            if (newRoutes.bluetoothName != null) goto L15;
            if (this.this$0.mActiveBluetoothDevice != null) goto L15;
        L16:
            r1.mGlobalBluetoothA2dpOn = r2;     // Catch: Throwable -> L13
        L18:
            MediaRouterService r3 = this.this$0;     // Catch: Throwable -> L13
            r3.mAudioRouteMainType = newRoutes.mainType;     // Catch: Throwable -> L13
        L15:
            r2 = true;
            goto L16
        L17:
            this.this$0.mGlobalBluetoothA2dpOn = false;     // Catch: Throwable -> L13
        L19:
            monitor-exit(r0);     // Catch: Throwable -> L13
        }
    }

    final class ClientGroup {
        public final List<ClientRecord> mClientRecords;
        public String mSelectedRouteId;

        ClientGroup(MediaRouterService this$0) {
            this.mClientRecords = new ArrayList();
        }
    }

    final class ClientRecord implements IBinder.DeathRecipient {
        public boolean mActiveScan;
        public final IMediaRouterClient mClient;
        public List<String> mControlCategories;
        public String mGroupId;
        public final String mPackageName;
        public final int mPid;
        public int mRouteTypes;
        public String mSelectedRouteId;
        public final boolean mTrusted;
        public final int mUid;
        public final UserRecord mUserRecord;
        final /* synthetic */ MediaRouterService this$0;

        ClientRecord(MediaRouterService this$0, UserRecord userRecord, IMediaRouterClient client, int uid, int pid, String packageName, boolean trusted) {
            this.this$0 = this$0;
            this.mUserRecord = userRecord;
            this.mClient = client;
            this.mUid = uid;
            this.mPid = pid;
            this.mPackageName = packageName;
            this.mTrusted = trusted;
        }

        public void dispose() {
            this.mClient.asBinder().unlinkToDeath(this, 0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.clientDied(this);
        }

        MediaRouterClientState getState() {
            if (this.mTrusted == true) goto L7;
            return null;
        L7:
            return this.mUserRecord.mRouterState;
        }

        public void dump(PrintWriter pw, String prefix) {
            pw.println(prefix + this);
            String indent = prefix + "  ";
            pw.println(indent + "mTrusted=" + this.mTrusted);
            pw.println(indent + "mRouteTypes=0x" + Integer.toHexString(this.mRouteTypes));
            pw.println(indent + "mActiveScan=" + this.mActiveScan);
            pw.println(indent + "mSelectedRouteId=" + this.mSelectedRouteId);
        }

        public String toString() {
            return "Client " + this.mPackageName + " (pid " + this.mPid + ")";
        }
    }

    final class MediaRouterServiceBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ MediaRouterService this$0;

        MediaRouterServiceBroadcastReceiver(MediaRouterService this$0) {
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.bluetooth.a2dp.profile.action.ACTIVE_DEVICE_CHANGED") == false) goto L16;
            BluetoothDevice btDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE", BluetoothDevice.class);
            Object r1 = MediaRouterService.m5607$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            this.this$0.mActiveBluetoothDevice = btDevice;     // Catch: Throwable -> L13
            MediaRouterService r2 = this.this$0;     // Catch: Throwable -> L13
            if (btDevice == null) goto L9;
            boolean r3 = true;
        L10:
            r2.mGlobalBluetoothA2dpOn = r3;     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            return;
        L9:
            r3 = false;
        L13:
            th = move-exception;
            throw th;
        }
    }

    static final class UserHandler extends Handler implements RemoteDisplayProviderWatcher.Callback, RemoteDisplayProviderProxy.Callback {
        private static final int MSG_CONNECTION_TIMED_OUT = 9;
        private static final int MSG_NOTIFY_GROUP_ROUTE_SELECTED = 10;
        public static final int MSG_REQUEST_SET_VOLUME = 6;
        public static final int MSG_REQUEST_UPDATE_VOLUME = 7;
        public static final int MSG_SELECT_ROUTE = 4;
        public static final int MSG_START = 1;
        public static final int MSG_STOP = 2;
        public static final int MSG_UNSELECT_ROUTE = 5;
        private static final int MSG_UPDATE_CLIENT_STATE = 8;
        public static final int MSG_UPDATE_DISCOVERY_REQUEST = 3;
        private static final int PHASE_CONNECTED = 2;
        private static final int PHASE_CONNECTING = 1;
        private static final int PHASE_NOT_AVAILABLE = -1;
        private static final int PHASE_NOT_CONNECTED = 0;
        private static final int TIMEOUT_REASON_CONNECTION_LOST = 2;
        private static final int TIMEOUT_REASON_NOT_AVAILABLE = 1;
        private static final int TIMEOUT_REASON_WAITING_FOR_CONNECTED = 4;
        private static final int TIMEOUT_REASON_WAITING_FOR_CONNECTING = 3;
        private boolean mClientStateUpdateScheduled;
        private int mConnectionPhase;
        private int mConnectionTimeoutReason;
        private long mConnectionTimeoutStartTime;
        private int mDiscoveryMode;
        private final ArrayList<ProviderRecord> mProviderRecords;
        private boolean mRunning;
        private RouteRecord mSelectedRouteRecord;
        private final MediaRouterService mService;
        private final ArrayList<IMediaRouterClient> mTempClients;
        private final UserRecord mUserRecord;
        private final RemoteDisplayProviderWatcher mWatcher;

        static final class ProviderRecord {
            private RemoteDisplayState mDescriptor;
            private final RemoteDisplayProviderProxy mProvider;
            private final ArrayList<RouteRecord> mRoutes;
            private final String mUniquePrefix;

            public ProviderRecord(RemoteDisplayProviderProxy provider) {
                this.mRoutes = new ArrayList();
                this.mProvider = provider;
                this.mUniquePrefix = provider.getFlattenedComponentName() + ":";
            }

            public RemoteDisplayProviderProxy getProvider() {
                return this.mProvider;
            }

            public String getUniquePrefix() {
                return this.mUniquePrefix;
            }

            public boolean updateDescriptor(RemoteDisplayState descriptor) {
                boolean changed = false;
                if (this.mDescriptor == descriptor) goto L22;
                this.mDescriptor = descriptor;
                int targetIndex = 0;
                if (descriptor != null) goto L7;
            L19:
                int i = this.mRoutes.size() - 1;
            L20:
                if (i < targetIndex) goto L22;
                RouteRecord route = this.mRoutes.remove(i);
                route.updateDescriptor(null);
                changed = true;
                i = i - 1;
                goto L20
            L7:
                if (descriptor.isValid() == false) goto L18;
                List<RemoteDisplayState.RemoteDisplayInfo> routeDescriptors = descriptor.displays;
                int routeCount = routeDescriptors.size();
                int i2 = 0;
            L9:
                if (i2 >= routeCount) goto L19;
                RemoteDisplayState.RemoteDisplayInfo routeDescriptor = routeDescriptors.get(i2);
                String descriptorId = routeDescriptor.id;
                int sourceIndex = findRouteByDescriptorId(descriptorId);
                if (sourceIndex >= 0) goto L13;
                String uniqueId = assignRouteUniqueId(descriptorId);
                RouteRecord route2 = new RouteRecord(this, descriptorId, uniqueId);
                this.mRoutes.add(targetIndex, route2);
                route2.updateDescriptor(routeDescriptor);
                changed = true;
                targetIndex = targetIndex + 1;
            L16:
                i2 = i2 + 1;
                goto L9
            L13:
                if (sourceIndex >= targetIndex) goto L15;
                Slog.w(MediaRouterService.TAG, "Ignoring route descriptor with duplicate id: " + routeDescriptor);
                goto L16
            L15:
                RouteRecord route3 = this.mRoutes.get(sourceIndex);
                Collections.swap(this.mRoutes, sourceIndex, targetIndex);
                changed = changed | route3.updateDescriptor(routeDescriptor);
                targetIndex = targetIndex + 1;
                goto L16
            L18:
                Slog.w(MediaRouterService.TAG, "Ignoring invalid descriptor from media route provider: " + this.mProvider.getFlattenedComponentName());
            L22:
                return changed;
            }

            public void appendClientState(MediaRouterClientState state) {
                int routeCount = this.mRoutes.size();
                int i = 0;
            L3:
                if (i >= routeCount) goto L6;
                state.routes.add(this.mRoutes.get(i).getInfo());
                i = i + 1;
                goto L3
            }

            public RouteRecord findRouteByUniqueId(String uniqueId) {
                int routeCount = this.mRoutes.size();
                int i = 0;
            L3:
                if (i >= routeCount) goto L8;
                RouteRecord route = this.mRoutes.get(i);
                if (route.getUniqueId().equals(uniqueId) == true) goto L6;
                i = i + 1;
                goto L3
            L6:
                return route;
            L8:
                return null;
            }

            private int findRouteByDescriptorId(String descriptorId) {
                int routeCount = this.mRoutes.size();
                int i = 0;
            L3:
                if (i >= routeCount) goto L8;
                RouteRecord route = this.mRoutes.get(i);
                if (route.getDescriptorId().equals(descriptorId) == true) goto L6;
                i = i + 1;
                goto L3
            L6:
                return i;
            L8:
                return -1;
            }

            public void dump(PrintWriter pw, String prefix) {
                pw.println(prefix + this);
                String indent = prefix + "  ";
                this.mProvider.dump(pw, indent);
                int routeCount = this.mRoutes.size();
                if (routeCount == 0) goto L8;
                int i = 0;
            L5:
                if (i >= routeCount) goto L11;
                this.mRoutes.get(i).dump(pw, indent);
                i = i + 1;
                goto L5
            L11:
                return;
            L8:
                pw.println(indent + "<no routes>");
            }

            public String toString() {
                return "Provider " + this.mProvider.getFlattenedComponentName();
            }

            private String assignRouteUniqueId(String descriptorId) {
                return this.mUniquePrefix + descriptorId;
            }
        }

        static final class RouteRecord {
            private RemoteDisplayState.RemoteDisplayInfo mDescriptor;
            private final String mDescriptorId;
            private MediaRouterClientState.RouteInfo mImmutableInfo;
            private final MediaRouterClientState.RouteInfo mMutableInfo;
            private final ProviderRecord mProviderRecord;

            public RouteRecord(ProviderRecord providerRecord, String descriptorId, String uniqueId) {
                this.mProviderRecord = providerRecord;
                this.mDescriptorId = descriptorId;
                this.mMutableInfo = new MediaRouterClientState.RouteInfo(uniqueId);
            }

            public RemoteDisplayProviderProxy getProvider() {
                return this.mProviderRecord.getProvider();
            }

            public ProviderRecord getProviderRecord() {
                return this.mProviderRecord;
            }

            public String getDescriptorId() {
                return this.mDescriptorId;
            }

            public String getUniqueId() {
                return this.mMutableInfo.id;
            }

            public MediaRouterClientState.RouteInfo getInfo() {
                if (this.mImmutableInfo != null) goto L6;
                this.mImmutableInfo = new MediaRouterClientState.RouteInfo(this.mMutableInfo);
            L6:
                return this.mImmutableInfo;
            }

            public boolean isValid() {
                if (this.mDescriptor == null) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean isEnabled() {
                return this.mMutableInfo.enabled;
            }

            public int getStatus() {
                return this.mMutableInfo.statusCode;
            }

            public boolean updateDescriptor(RemoteDisplayState.RemoteDisplayInfo descriptor) {
                boolean changed = false;
                if (this.mDescriptor == descriptor) goto L39;
                this.mDescriptor = descriptor;
                if (descriptor == null) goto L39;
                String name = computeName(descriptor);
                if (Objects.equals(this.mMutableInfo.name, name) == true) goto L9;
                this.mMutableInfo.name = name;
                changed = true;
            L9:
                String description = computeDescription(descriptor);
                if (Objects.equals(this.mMutableInfo.description, description) == true) goto L12;
                this.mMutableInfo.description = description;
                changed = true;
            L12:
                int supportedTypes = computeSupportedTypes(descriptor);
                if (this.mMutableInfo.supportedTypes == supportedTypes) goto L15;
                this.mMutableInfo.supportedTypes = supportedTypes;
                changed = true;
            L15:
                boolean enabled = computeEnabled(descriptor);
                if (this.mMutableInfo.enabled == enabled) goto L18;
                this.mMutableInfo.enabled = enabled;
                changed = true;
            L18:
                int statusCode = computeStatusCode(descriptor);
                if (this.mMutableInfo.statusCode == statusCode) goto L21;
                this.mMutableInfo.statusCode = statusCode;
                changed = true;
            L21:
                int playbackType = computePlaybackType(descriptor);
                if (this.mMutableInfo.playbackType == playbackType) goto L24;
                this.mMutableInfo.playbackType = playbackType;
                changed = true;
            L24:
                int playbackStream = computePlaybackStream(descriptor);
                if (this.mMutableInfo.playbackStream == playbackStream) goto L27;
                this.mMutableInfo.playbackStream = playbackStream;
                changed = true;
            L27:
                int volume = computeVolume(descriptor);
                if (this.mMutableInfo.volume == volume) goto L30;
                this.mMutableInfo.volume = volume;
                changed = true;
            L30:
                int volumeMax = computeVolumeMax(descriptor);
                if (this.mMutableInfo.volumeMax == volumeMax) goto L33;
                this.mMutableInfo.volumeMax = volumeMax;
                changed = true;
            L33:
                int volumeHandling = computeVolumeHandling(descriptor);
                if (this.mMutableInfo.volumeHandling == volumeHandling) goto L36;
                this.mMutableInfo.volumeHandling = volumeHandling;
                changed = true;
            L36:
                int presentationDisplayId = computePresentationDisplayId(descriptor);
                if (this.mMutableInfo.presentationDisplayId == presentationDisplayId) goto L39;
                this.mMutableInfo.presentationDisplayId = presentationDisplayId;
                changed = true;
            L39:
                if (changed == false) goto L41;
                this.mImmutableInfo = null;
            L41:
                return changed;
            }

            public void dump(PrintWriter pw, String prefix) {
                pw.println(prefix + this);
                String indent = prefix + "  ";
                pw.println(indent + "mMutableInfo=" + this.mMutableInfo);
                pw.println(indent + "mDescriptorId=" + this.mDescriptorId);
                pw.println(indent + "mDescriptor=" + this.mDescriptor);
            }

            public String toString() {
                return "Route " + this.mMutableInfo.name + " (" + this.mMutableInfo.id + ")";
            }

            private static String computeName(RemoteDisplayState.RemoteDisplayInfo descriptor) {
                return descriptor.name;
            }

            private static String computeDescription(RemoteDisplayState.RemoteDisplayInfo descriptor) {
                String description = descriptor.description;
                if (TextUtils.isEmpty(description) == false) goto L6;
                return null;
            L6:
                return description;
            }

            private static int computeSupportedTypes(RemoteDisplayState.RemoteDisplayInfo descriptor) {
                return 7;
            }

            private static boolean computeEnabled(RemoteDisplayState.RemoteDisplayInfo descriptor) {
                switch(descriptor.status) {
                    case 2: goto L6;
                    case 3: goto L6;
                    case 4: goto L6;
                    default: goto L4;
                };
            L4:
                return false;
            L6:
                return true;
            }

            private static int computeStatusCode(RemoteDisplayState.RemoteDisplayInfo descriptor) {
                switch(descriptor.status) {
                    case 0: goto L14;
                    case 1: goto L12;
                    case 2: goto L10;
                    case 3: goto L8;
                    case 4: goto L6;
                    default: goto L4;
                };
            L4:
                return 0;
            L6:
                return 6;
            L8:
                return 2;
            L10:
                return 3;
            L12:
                return 5;
            L14:
                return 4;
            }

            private static int computePlaybackType(RemoteDisplayState.RemoteDisplayInfo descriptor) {
                return 1;
            }

            private static int computePlaybackStream(RemoteDisplayState.RemoteDisplayInfo descriptor) {
                return 3;
            }

            private static int computeVolume(RemoteDisplayState.RemoteDisplayInfo descriptor) {
                int volume = descriptor.volume;
                int volumeMax = descriptor.volumeMax;
                if (volume >= 0) goto L6;
                return 0;
            L6:
                if (volume <= volumeMax) goto L8;
                return volumeMax;
            L8:
                return volume;
            }

            private static int computeVolumeMax(RemoteDisplayState.RemoteDisplayInfo descriptor) {
                int volumeMax = descriptor.volumeMax;
                if (volumeMax > 0) goto L7;
                return 0;
            L7:
                return volumeMax;
            }

            private static int computeVolumeHandling(RemoteDisplayState.RemoteDisplayInfo descriptor) {
                int volumeHandling = descriptor.volumeHandling;
                switch(volumeHandling) {
                    case 1: goto L6;
                    default: goto L4;
                };
            L4:
                return 0;
            L6:
                return 1;
            }

            private static int computePresentationDisplayId(RemoteDisplayState.RemoteDisplayInfo descriptor) {
                int displayId = descriptor.presentationDisplayId;
                if (displayId >= 0) goto L6;
                return -1;
            L6:
                return displayId;
            }
        }

        /* synthetic */ UserHandler(MediaRouterService r1, UserRecord r2, Looper r3, MediaRouterServiceIA r4) {
            this(r1, r2, r3);
        }

        private UserHandler(MediaRouterService service, UserRecord userRecord, Looper looper) {
            super(looper, null, true);
            this.mProviderRecords = new ArrayList();
            this.mTempClients = new ArrayList();
            this.mDiscoveryMode = 0;
            this.mConnectionPhase = -1;
            this.mService = service;
            this.mUserRecord = userRecord;
            this.mWatcher = new RemoteDisplayProviderWatcher(MediaRouterService.m5605$$Nest$fgetmContext(service), this, this, this.mUserRecord.mUserId);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                case 10: goto L5;
                default: goto L25;
            };
        L5:
            notifyGroupRouteSelected((String) msg.obj);
            return;
        L6:
            connectionTimedOut();
            return;
        L7:
            updateClientState();
            return;
        L8:
            requestUpdateVolume((String) msg.obj, msg.arg1);
            return;
        L9:
            requestSetVolume((String) msg.obj, msg.arg1);
            return;
        L10:
            unselectRoute((String) msg.obj);
            return;
        L11:
            selectRoute((String) msg.obj);
            return;
        L12:
            updateDiscoveryRequest();
            return;
        L13:
            stop();
            return;
        L14:
            start();
            return;
        }

        public void dump(PrintWriter pw, String prefix) {
            pw.println(prefix + "Handler");
            String indent = prefix + "  ";
            pw.println(indent + "mRunning=" + this.mRunning);
            pw.println(indent + "mDiscoveryMode=" + this.mDiscoveryMode);
            pw.println(indent + "mSelectedRouteRecord=" + this.mSelectedRouteRecord);
            pw.println(indent + "mConnectionPhase=" + this.mConnectionPhase);
            pw.println(indent + "mConnectionTimeoutReason=" + this.mConnectionTimeoutReason);
            StringBuilder r1 = new StringBuilder();
            r1.append(indent);
            r1.append("mConnectionTimeoutStartTime=");
            if (this.mConnectionTimeoutReason == 0) goto L5;
            String r2 = TimeUtils.formatUptime(this.mConnectionTimeoutStartTime);
        L6:
            r1.append(r2);
            pw.println(r1.toString());
            this.mWatcher.dump(pw, prefix);
            int providerCount = this.mProviderRecords.size();
            if (providerCount == 0) goto L12;
            int i = 0;
        L9:
            if (i >= providerCount) goto L15;
            this.mProviderRecords.get(i).dump(pw, prefix);
            i = i + 1;
            goto L9
        L15:
            return;
        L12:
            pw.println(indent + "<no providers>");
            return;
        L5:
            r2 = "<n/a>";
            goto L6
        }

        private void start() {
            if (this.mRunning == true) goto L6;
            this.mRunning = true;
            this.mWatcher.start();
            return;
        }

        private void stop() {
            if (this.mRunning == false) goto L6;
            this.mRunning = false;
            unselectSelectedRoute();
            this.mWatcher.stop();
            return;
        }

        private void updateDiscoveryRequest() {
            int routeTypes = 0;
            boolean activeScan = false;
            Object r2 = MediaRouterService.m5607$$Nest$fgetmLock(this.mService);
            monitor-enter(r2);
            int count = this.mUserRecord.mClientRecords.size();     // Catch: Throwable -> L7
            int i = 0;
        L5:
            if (i >= count) goto L10;
            ClientRecord clientRecord = this.mUserRecord.mClientRecords.get(i);     // Catch: Throwable -> L7
            routeTypes = routeTypes | clientRecord.mRouteTypes;     // Catch: Throwable -> L7
            activeScan = activeScan | clientRecord.mActiveScan;     // Catch: Throwable -> L7
            i = i + 1;     // Catch: Throwable -> L7
            goto L5
        L10:
            monitor-exit(r2);     // Catch: Throwable -> L7
            if ((routeTypes & 4) == 0) goto L16;
            if (activeScan == false) goto L15;
            int newDiscoveryMode = 2;
        L18:
            if (this.mDiscoveryMode == newDiscoveryMode) goto L22;
            this.mDiscoveryMode = newDiscoveryMode;
            int count2 = this.mProviderRecords.size();
            int i2 = 0;
        L20:
            if (i2 >= count2) goto L29;
            this.mProviderRecords.get(i2).getProvider().setDiscoveryMode(this.mDiscoveryMode);
            i2 = i2 + 1;
            goto L20
        L29:
            return;
        L22:
            return;
        L15:
            newDiscoveryMode = 1;
            goto L18
        L16:
            newDiscoveryMode = 0;
        L7:
            th = move-exception;
            throw th;
        }

        private void selectRoute(String routeId) {
            if (routeId != null) goto L4;
            return;
        L4:
            if (this.mSelectedRouteRecord != null) goto L6;
        L7:
            RouteRecord routeRecord = findRouteRecord(routeId);
            if (routeRecord == null) goto L13;
            unselectSelectedRoute();
            Slog.i(MediaRouterService.TAG, "Selected route:" + routeRecord);
            this.mSelectedRouteRecord = routeRecord;
            checkSelectedRouteState();
            routeRecord.getProvider().setSelectedDisplay(routeRecord.getDescriptorId());
            scheduleUpdateClientState();
            return;
        L13:
            return;
        L6:
            if (routeId.equals(this.mSelectedRouteRecord.getUniqueId()) == false) goto L7;
        }

        private void unselectRoute(String routeId) {
            if (routeId != null) goto L4;
            return;
        L4:
            if (this.mSelectedRouteRecord != null) goto L6;
            return;
        L6:
            if (routeId.equals(this.mSelectedRouteRecord.getUniqueId()) == false) goto L11;
            unselectSelectedRoute();
            return;
        }

        private void unselectSelectedRoute() {
            if (this.mSelectedRouteRecord == null) goto L6;
            Slog.i(MediaRouterService.TAG, "Unselected route:" + this.mSelectedRouteRecord);
            this.mSelectedRouteRecord.getProvider().setSelectedDisplay(null);
            this.mSelectedRouteRecord = null;
            checkSelectedRouteState();
            scheduleUpdateClientState();
            return;
        }

        private void requestSetVolume(String routeId, int volume) {
            if (this.mSelectedRouteRecord != null) goto L5;
            return;
        L5:
            if (routeId.equals(this.mSelectedRouteRecord.getUniqueId()) == false) goto L9;
            this.mSelectedRouteRecord.getProvider().setDisplayVolume(volume);
            return;
        }

        private void requestUpdateVolume(String routeId, int direction) {
            if (this.mSelectedRouteRecord != null) goto L5;
            return;
        L5:
            if (routeId.equals(this.mSelectedRouteRecord.getUniqueId()) == false) goto L9;
            this.mSelectedRouteRecord.getProvider().adjustDisplayVolume(direction);
            return;
        }

        @Override // com.android.server.media.RemoteDisplayProviderWatcher.Callback
        public void addProvider(RemoteDisplayProviderProxy provider) {
            provider.setCallback(this);
            provider.setDiscoveryMode(this.mDiscoveryMode);
            provider.setSelectedDisplay(null);
            ProviderRecord providerRecord = new ProviderRecord(provider);
            this.mProviderRecords.add(providerRecord);
            providerRecord.updateDescriptor(provider.getDisplayState());
            scheduleUpdateClientState();
        }

        @Override // com.android.server.media.RemoteDisplayProviderWatcher.Callback
        public void removeProvider(RemoteDisplayProviderProxy provider) {
            int index = findProviderRecord(provider);
            if (index < 0) goto L6;
            ProviderRecord providerRecord = this.mProviderRecords.remove(index);
            providerRecord.updateDescriptor(null);
            provider.setCallback(null);
            provider.setDiscoveryMode(0);
            checkSelectedRouteState();
            scheduleUpdateClientState();
            return;
        }

        @Override // com.android.server.media.RemoteDisplayProviderProxy.Callback
        public void onDisplayStateChanged(RemoteDisplayProviderProxy provider, RemoteDisplayState state) {
            updateProvider(provider, state);
        }

        private void updateProvider(RemoteDisplayProviderProxy provider, RemoteDisplayState state) {
            int index = findProviderRecord(provider);
            if (index < 0) goto L8;
            ProviderRecord providerRecord = this.mProviderRecords.get(index);
            if (providerRecord.updateDescriptor(state) == false) goto L9;
            checkSelectedRouteState();
            scheduleUpdateClientState();
            return;
        L9:
            return;
        }

        private void checkSelectedRouteState() {
            if (this.mSelectedRouteRecord != null) goto L7;
            this.mConnectionPhase = -1;
            updateConnectionTimeout(0);
            return;
        L7:
            if (this.mSelectedRouteRecord.isValid() == true) goto L9;
        L28:
            updateConnectionTimeout(1);
            return;
        L9:
            if (this.mSelectedRouteRecord.isEnabled() == false) goto L28;
            int oldPhase = this.mConnectionPhase;
            this.mConnectionPhase = getConnectionPhase(this.mSelectedRouteRecord.getStatus());
            if (oldPhase < 1) goto L18;
            if (this.mConnectionPhase >= 1) goto L18;
            updateConnectionTimeout(2);
            return;
        L18:
            switch(this.mConnectionPhase) {
                case 0: goto L26;
                case 1: goto L23;
                case 2: goto L20;
                default: goto L19;
            };
        L19:
            updateConnectionTimeout(1);
            return;
        L20:
            if (oldPhase == 2) goto L22;
            Slog.i(MediaRouterService.TAG, "Connected to route: " + this.mSelectedRouteRecord);
        L22:
            updateConnectionTimeout(0);
            return;
        L23:
            if (oldPhase == 1) goto L25;
            Slog.i(MediaRouterService.TAG, "Connecting to route: " + this.mSelectedRouteRecord);
        L25:
            updateConnectionTimeout(4);
            return;
        L26:
            updateConnectionTimeout(3);
        }

        private void updateConnectionTimeout(int reason) {
            if (reason != this.mConnectionTimeoutReason) goto L5;
            return;
        L5:
            if (this.mConnectionTimeoutReason == 0) goto L7;
            removeMessages(9);
        L7:
            this.mConnectionTimeoutReason = reason;
            this.mConnectionTimeoutStartTime = SystemClock.uptimeMillis();
            switch(reason) {
                case 1: goto L12;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                default: goto L17;
            };
        L10:
            sendEmptyMessageDelayed(9, 60000);
            return;
        L11:
            sendEmptyMessageDelayed(9, MediaRouterService.CONNECTING_TIMEOUT);
            return;
        L12:
            sendEmptyMessage(9);
            return;
        }

        private void connectionTimedOut() {
            if (this.mConnectionTimeoutReason != 0) goto L5;
        L16:
            Log.wtf(MediaRouterService.TAG, "Handled connection timeout for no reason.");
            return;
        L5:
            if (this.mSelectedRouteRecord == null) goto L16;
            switch(this.mConnectionTimeoutReason) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                default: goto L14;
            };
        L10:
            Slog.i(MediaRouterService.TAG, "Selected route timed out while connecting after " + (SystemClock.uptimeMillis() - this.mConnectionTimeoutStartTime) + " ms: " + this.mSelectedRouteRecord);
            goto L14
        L11:
            Slog.i(MediaRouterService.TAG, "Selected route timed out while waiting for connection attempt to begin after " + (SystemClock.uptimeMillis() - this.mConnectionTimeoutStartTime) + " ms: " + this.mSelectedRouteRecord);
            goto L14
        L12:
            Slog.i(MediaRouterService.TAG, "Selected route connection lost: " + this.mSelectedRouteRecord);
            goto L14
        L13:
            Slog.i(MediaRouterService.TAG, "Selected route no longer available: " + this.mSelectedRouteRecord);
        L14:
            this.mConnectionTimeoutReason = 0;
            unselectSelectedRoute();
        }

        private void scheduleUpdateClientState() {
            if (this.mClientStateUpdateScheduled == true) goto L6;
            this.mClientStateUpdateScheduled = true;
            sendEmptyMessage(8);
            return;
        }

        private void updateClientState() {
            this.mClientStateUpdateScheduled = false;
            MediaRouterClientState routerState = new MediaRouterClientState();
            int providerCount = this.mProviderRecords.size();
            int i = 0;
        L3:
            if (i >= providerCount) goto L31;
            this.mProviderRecords.get(i).appendClientState(routerState);
            i = i + 1;
            goto L3
        L31:
            Object r2 = MediaRouterService.m5607$$Nest$fgetmLock(this.mService);     // Catch: Throwable -> L20
            monitor-enter(r2);     // Catch: Throwable -> L20
            this.mUserRecord.mRouterState = routerState;     // Catch: Throwable -> L11
            int count = this.mUserRecord.mClientRecords.size();     // Catch: Throwable -> L11
            int i2 = 0;
        L9:
            if (i2 >= count) goto L14;
            this.mTempClients.add(this.mUserRecord.mClientRecords.get(i2).mClient);     // Catch: Throwable -> L11
            i2 = i2 + 1;     // Catch: Throwable -> L11
            goto L9
        L14:
            monitor-exit(r2);     // Catch: Throwable -> L11
            int count2 = this.mTempClients.size();     // Catch: Throwable -> L20
            int i3 = 0;
        L17:
            if (i3 >= count2) goto L25;
            this.mTempClients.get(i3).onStateChanged();     // Catch: Throwable -> L20 RemoteException -> L22
        L24:
            i3 = i3 + 1;
        L23:
            Slog.w(MediaRouterService.TAG, "Failed to call onStateChanged. Client probably died.");     // Catch: Throwable -> L20
            goto L24
        L25:
            this.mTempClients.clear();
            return;
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            this.mTempClients.clear();
            throw th;
        }

        private void notifyGroupRouteSelected(String groupId) {
            Object r0 = MediaRouterService.m5607$$Nest$fgetmLock(this.mService);     // Catch: Throwable -> L24
            monitor-enter(r0);     // Catch: Throwable -> L24
            ClientGroup group = (ClientGroup) UserRecord.m5611$$Nest$fgetmClientGroupMap(this.mUserRecord).get(groupId);     // Catch: Throwable -> L9
            if (group != null) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L9
            this.mTempClients.clear();
            return;
        L11:
            String selectedRouteId = group.mSelectedRouteId;     // Catch: Throwable -> L9
            int count = group.mClientRecords.size();     // Catch: Throwable -> L9
            int i = 0;
        L12:
            if (i >= count) goto L18;
            ClientRecord clientRecord = group.mClientRecords.get(i);     // Catch: Throwable -> L9
            if (TextUtils.equals(selectedRouteId, clientRecord.mSelectedRouteId) == true) goto L16;
            this.mTempClients.add(clientRecord.mClient);     // Catch: Throwable -> L9
        L16:
            i = i + 1;     // Catch: Throwable -> L9
            goto L12
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L9
            int count2 = this.mTempClients.size();     // Catch: Throwable -> L24
            int i2 = 0;
        L21:
            if (i2 >= count2) goto L29;
            this.mTempClients.get(i2).onGroupRouteSelected(selectedRouteId);     // Catch: Throwable -> L24 RemoteException -> L26
        L28:
            i2 = i2 + 1;
        L27:
            Slog.w(MediaRouterService.TAG, "Failed to call onSelectedRouteChanged. Client probably died.");     // Catch: Throwable -> L24
            goto L28
        L29:
            this.mTempClients.clear();
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            this.mTempClients.clear();
            throw th;
        }

        private int findProviderRecord(RemoteDisplayProviderProxy provider) {
            int count = this.mProviderRecords.size();
            int i = 0;
        L3:
            if (i >= count) goto L8;
            ProviderRecord record = this.mProviderRecords.get(i);
            if (record.getProvider() == provider) goto L6;
            i = i + 1;
            goto L3
        L6:
            return i;
        L8:
            return -1;
        }

        private RouteRecord findRouteRecord(String uniqueId) {
            int count = this.mProviderRecords.size();
            int i = 0;
        L3:
            if (i >= count) goto L8;
            RouteRecord record = this.mProviderRecords.get(i).findRouteByUniqueId(uniqueId);
            if (record != null) goto L6;
            i = i + 1;
            goto L3
        L6:
            return record;
        L8:
            return null;
        }

        private static int getConnectionPhase(int status) {
            switch(status) {
                case 0: goto L9;
                case 1: goto L7;
                case 2: goto L5;
                case 3: goto L7;
                case 4: goto L3;
                case 5: goto L3;
                case 6: goto L9;
                default: goto L3;
            };
        L3:
            return -1;
        L5:
            return 1;
        L7:
            return 0;
        L9:
            return 2;
        }
    }

    final class UserRecord {
        private final ArrayMap<String, ClientGroup> mClientGroupMap;
        public final ArrayList<ClientRecord> mClientRecords;
        public final UserHandler mHandler;
        public MediaRouterClientState mRouterState;
        public final int mUserId;
        final /* synthetic */ MediaRouterService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmClientGroupMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayMap m5611$$Nest$fgetmClientGroupMap(UserRecord r0) {
            return r0.mClientGroupMap;
        }

        public UserRecord(MediaRouterService this$0, int userId) {
            this.this$0 = this$0;
            this.mClientRecords = new ArrayList();
            this.mClientGroupMap = new ArrayMap();
            this.mUserId = userId;
            this.mHandler = new UserHandler(this$0, this, MediaRouterService.m5608$$Nest$fgetmLooper(this$0), null);
        }

        public void dump(final PrintWriter pw, String prefix) {
            pw.println(prefix + this);
            final String indent = prefix + "  ";
            int clientCount = this.mClientRecords.size();
            if (clientCount == 0) goto L8;
            int i = 0;
        L5:
            if (i >= clientCount) goto L9;
            this.mClientRecords.get(i).dump(pw, indent);
            i = i + 1;
        L9:
            pw.println(indent + "State");
            pw.println(indent + "mRouterState=" + this.mRouterState);
            if (this.mHandler.runWithScissors(new AnonymousClass1(this, pw, indent), 1000) == true) goto L14;
            pw.println(indent + "<could not dump handler state>");
            return;
        L14:
            return;
        L8:
            pw.println(indent + "<no clients>");
            goto L9
        }

        public void addToGroup(String groupId, ClientRecord clientRecord) {
            ClientGroup group = this.mClientGroupMap.get(groupId);
            if (group != null) goto L5;
            group = new ClientGroup(this.this$0);
            this.mClientGroupMap.put(groupId, group);
        L5:
            group.mClientRecords.add(clientRecord);
        }

        public void removeFromGroup(String groupId, ClientRecord clientRecord) {
            ClientGroup group = this.mClientGroupMap.get(groupId);
            if (group == null) goto L8;
            group.mClientRecords.remove(clientRecord);
            if (group.mClientRecords.size() != 0) goto L9;
            this.mClientGroupMap.remove(groupId);
            return;
        L9:
            return;
        }

        public String toString() {
            return "User " + this.mUserId;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivePlayerMinPriorityQueue, reason: not valid java name */
    static /* bridge */ /* synthetic */ IntArray m5603$$Nest$fgetmActivePlayerMinPriorityQueue(MediaRouterService r0) {
        return r0.mActivePlayerMinPriorityQueue;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivePlayerUidMinPriorityQueue, reason: not valid java name */
    static /* bridge */ /* synthetic */ IntArray m5604$$Nest$fgetmActivePlayerUidMinPriorityQueue(MediaRouterService r0) {
        return r0.mActivePlayerUidMinPriorityQueue;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m5605$$Nest$fgetmContext(MediaRouterService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m5606$$Nest$fgetmHandler(MediaRouterService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m5607$$Nest$fgetmLock(MediaRouterService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLooper, reason: not valid java name */
    static /* bridge */ /* synthetic */ Looper m5608$$Nest$fgetmLooper(MediaRouterService r0) {
        return r0.mLooper;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateRunningUserAndProfiles, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5609$$Nest$mupdateRunningUserAndProfiles(MediaRouterService r0, int r1) {
        r0.updateRunningUserAndProfiles(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5610$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public MediaRouterService(Context context) {
        this.mLock = new Object();
        this.mUserRecords = new SparseArray();
        this.mAllClientRecords = new ArrayMap();
        this.mCurrentActiveUserId = -1;
        this.mActivePlayerMinPriorityQueue = new IntArray();
        this.mActivePlayerUidMinPriorityQueue = new IntArray();
        this.mReceiver = new MediaRouterServiceBroadcastReceiver(this);
        this.mAudioRouteMainType = 0;
        this.mGlobalBluetoothA2dpOn = false;
        HandlerThread handlerThread = new HandlerThread(WORKER_THREAD_NAME);
        handlerThread.start();
        this.mLooper = handlerThread.getLooper();
        this.mHandler = new Handler(this.mLooper);
        this.mService2 = new MediaRouter2ServiceImpl(context, this.mLooper);
        this.mContext = context;
        Watchdog.getInstance().addMonitor(this);
        Resources res = context.getResources();
        this.mDefaultAudioRouteId = res.getString(R.string.duration_minutes_shortest_future);
        this.mBluetoothA2dpRouteId = res.getString(R.string.car_loading_profile);
        this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        this.mAudioService = IAudioService.Stub.asInterface(ServiceManager.getService("audio"));
        this.mAudioPlayerStateMonitor = AudioPlayerStateMonitor.getInstance(context);
        MediaRouterServiceIA r3 = null;
        this.mAudioPlayerStateMonitor.registerListener(new AudioPlayerActiveStateChangedListenerImpl(this, r3), this.mHandler);
        this.mAudioService.startWatchingRoutes(new AudioRoutesObserverImpl(this, r3));     // Catch: RemoteException -> L5
    L7:
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.a2dp.profile.action.ACTIVE_DEVICE_CHANGED");
        context.registerReceiverAsUser(this.mReceiver, UserHandle.ALL, intentFilter, null, null);
        return;
    L6:
        Slog.w(TAG, "RemoteException in the audio service.");
        goto L7
    }

    public void systemRunning() throws RemoteException {
        ActivityManager.getService().registerUserSwitchObserver(new AnonymousClass1(this), TAG);
        updateRunningUserAndProfiles(ActivityManager.getCurrentUser());
    }

    @Override // com.android.server.Watchdog.Monitor
    public void monitor() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void registerClientAsUser(IMediaRouterClient client, String packageName, int userId) {
        int uid = Binder.getCallingUid();
        if (validatePackageName(uid, packageName) == false) goto L31;
        int pid = Binder.getCallingPid();
        int resolvedUserId = ActivityManager.handleIncomingUser(pid, uid, userId, false, true, "registerClientAsUser", packageName);
        if (this.mContext.checkCallingOrSelfPermission("android.permission.CONFIGURE_WIFI_DISPLAY") != 0) goto L8;
        boolean r13 = true;
    L7:
        boolean trusted = r13;
        long token = Binder.clearCallingIdentity();
        Object r14 = this.mLock;     // Catch: Throwable -> L26
        monitor-enter(r14);     // Catch: Throwable -> L26
        registerClientLocked(client, uid, pid, packageName, resolvedUserId, trusted);     // Catch: Throwable -> L20
        monitor-exit(r14);     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(token);
        return;
    L20:
        th = move-exception;
        Throwable r11 = th;
    L22:
        monitor-exit(r14);     // Catch: Throwable -> L18
        throw r11;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Throwable r12 = th;
    L28:
        Binder.restoreCallingIdentity(token);
        throw r12;
    L18:
        th = move-exception;
        r11 = th;
    L26:
        th = move-exception;
        r12 = th;
        goto L28
    L8:
        r13 = false;
        goto L7
    L31:
        throw new SecurityException("packageName must match the calling uid");
    }

    public void registerClientGroupId(IMediaRouterClient client, String groupId) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.CONFIGURE_WIFI_DISPLAY") == 0) goto L6;
        Log.w(TAG, "Ignoring client group request because the client doesn't have the CONFIGURE_WIFI_DISPLAY permission.");
        return;
    L6:
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L16
        monitor-enter(r2);     // Catch: Throwable -> L16
        registerClientGroupIdLocked(client, groupId);     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(token);
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void unregisterClient(IMediaRouterClient client) {
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L13
        monitor-enter(r2);     // Catch: Throwable -> L13
        unregisterClientLocked(client, false);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(token);
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public MediaRouterClientState getState(IMediaRouterClient client) {
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        MediaRouterClientState r3 = getStateLocked(client);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return r3;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean isPlaybackActive(IMediaRouterClient client) {
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L11
        monitor-enter(r2);     // Catch: Throwable -> L11
        ClientRecord clientRecord = this.mAllClientRecords.get(client.asBinder());     // Catch: Throwable -> L15
        monitor-exit(r2);     // Catch: Throwable -> L15
        if (clientRecord == null) goto L13;
        boolean r3 = this.mAudioPlayerStateMonitor.isPlaybackActive(clientRecord.mUid);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(token);
        return r3;
    L13:
        Binder.restoreCallingIdentity(token);
        return false;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void setBluetoothA2dpOn(IMediaRouterClient client, boolean on) {
        if (client == null) goto L15;
        long token = Binder.clearCallingIdentity();
        this.mAudioService.setBluetoothA2dpOn(on);     // Catch: Throwable -> L6 RemoteException -> L8
    L5:
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L9:
        Slog.w(TAG, "RemoteException while calling setBluetoothA2dpOn. on=" + on);     // Catch: Throwable -> L6
        goto L5
    L15:
        throw new IllegalArgumentException("client must not be null");
    }

    public void setDiscoveryRequest(IMediaRouterClient client, int routeTypes, boolean activeScan) {
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        setDiscoveryRequestLocked(client, routeTypes, activeScan);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void setSelectedRoute(IMediaRouterClient client, String routeId, boolean explicit) {
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        setSelectedRouteLocked(client, routeId, explicit);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void requestSetVolume(IMediaRouterClient client, String routeId, int volume) {
        routeId.getClass();
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        requestSetVolumeLocked(client, routeId, volume);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void requestUpdateVolume(IMediaRouterClient client, String routeId, int direction) {
        routeId.getClass();
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        requestUpdateVolumeLocked(client, routeId, direction);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        pw.println("MEDIA ROUTER SERVICE (dumpsys media_router)");
        pw.println();
        pw.println("Global state");
        pw.println("  mCurrentUserId=" + this.mCurrentActiveUserId);
        Object r0 = this.mLock;
        monitor-enter(r0);
        int count = this.mUserRecords.size();     // Catch: Throwable -> L10
        int i = 0;
    L8:
        if (i >= count) goto L13;
        UserRecord userRecord = this.mUserRecords.valueAt(i);     // Catch: Throwable -> L10
        pw.println();     // Catch: Throwable -> L10
        userRecord.dump(pw, "");     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        pw.println();
        this.mService2.dump(pw, "");
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public List<MediaRoute2Info> getSystemRoutes(String callerPackageName, boolean isProxyRouter) {
        if (validatePackageName(Binder.getCallingUid(), callerPackageName) == false) goto L7;
        return this.mService2.getSystemRoutes(callerPackageName, isProxyRouter);
    L7:
        throw new SecurityException("callerPackageName does not match calling uid.");
    }

    public RoutingSessionInfo getSystemSessionInfo() {
        return this.mService2.getSystemSessionInfo(null, null, false);
    }

    public boolean showMediaOutputSwitcherWithRouter2(String packageName) {
        int uid = Binder.getCallingUid();
        if (validatePackageName(uid, packageName) == false) goto L7;
        return this.mService2.showMediaOutputSwitcherWithRouter2(packageName);
    L7:
        throw new SecurityException("packageName must match the calling identity");
    }

    public void registerRouter2(IMediaRouter2 router, String packageName) {
        int uid = Binder.getCallingUid();
        if (validatePackageName(uid, packageName) == false) goto L7;
        this.mService2.registerRouter2(router, packageName);
        return;
    L7:
        throw new SecurityException("packageName must match the calling uid");
    }

    public void unregisterRouter2(IMediaRouter2 router) {
        this.mService2.unregisterRouter2(router);
    }

    public void updateScanningStateWithRouter2(IMediaRouter2 router, int scanningState) {
        this.mService2.updateScanningState(router, scanningState);
    }

    public void setDiscoveryRequestWithRouter2(IMediaRouter2 router, RouteDiscoveryPreference request) {
        this.mService2.setDiscoveryRequestWithRouter2(router, request);
    }

    public void setRouteListingPreference(IMediaRouter2 router, RouteListingPreference routeListingPreference) {
        this.mService2.setRouteListingPreference(router, routeListingPreference);
    }

    public void setRouteVolumeWithRouter2(IMediaRouter2 router, MediaRoute2Info route, int volume) {
        this.mService2.setRouteVolumeWithRouter2(router, route, volume);
    }

    public void requestCreateSessionWithRouter2(IMediaRouter2 router, int requestId, long managerRequestId, RoutingSessionInfo oldSession, MediaRoute2Info route, Bundle sessionHints) {
        this.mService2.requestCreateSessionWithRouter2(router, requestId, managerRequestId, oldSession, route, sessionHints);
    }

    public void selectRouteWithRouter2(IMediaRouter2 router, String sessionId, MediaRoute2Info route) {
        this.mService2.selectRouteWithRouter2(router, sessionId, route);
    }

    public void deselectRouteWithRouter2(IMediaRouter2 router, String sessionId, MediaRoute2Info route) {
        this.mService2.deselectRouteWithRouter2(router, sessionId, route);
    }

    public void transferToRouteWithRouter2(IMediaRouter2 router, String sessionId, MediaRoute2Info route) {
        this.mService2.transferToRouteWithRouter2(router, sessionId, route);
    }

    public void setSessionVolumeWithRouter2(IMediaRouter2 router, String sessionId, int volume) {
        this.mService2.setSessionVolumeWithRouter2(router, sessionId, volume);
    }

    public void releaseSessionWithRouter2(IMediaRouter2 router, String sessionId) {
        this.mService2.releaseSessionWithRouter2(router, sessionId);
    }

    public void setDeviceSuggestionsWithRouter2(IMediaRouter2 router, List<SuggestedDeviceInfo> suggestedDeviceInfo) {
        this.mService2.setDeviceSuggestionsWithRouter2(router, suggestedDeviceInfo);
    }

    public Map<String, List<SuggestedDeviceInfo>> getDeviceSuggestionsWithRouter2(IMediaRouter2 router) {
        return this.mService2.getDeviceSuggestionsWithRouter2(router);
    }

    public List<RoutingSessionInfo> getRemoteSessions(IMediaRouter2Manager manager) {
        return this.mService2.getRemoteSessions(manager);
    }

    public RoutingSessionInfo getSystemSessionInfoForPackage(String callerPackageName, String targetPackageName) {
        int uid = Binder.getCallingUid();
        int userId = UserHandle.getUserHandleForUid(uid).getIdentifier();
        if (validatePackageName(uid, callerPackageName) == false) goto L27;
        boolean setDeviceRouteSelected = false;
        Object r3 = this.mLock;
        monitor-enter(r3);
        UserRecord userRecord = this.mUserRecords.get(userId);     // Catch: Throwable -> L9
        if (userRecord == null) goto L11;
        List<ClientRecord> userClientRecords = userRecord.mClientRecords;     // Catch: Throwable -> L9
    L12:
        Iterator<ClientRecord> r6 = userClientRecords.iterator();     // Catch: Throwable -> L9
    L14:
        if (r6.hasNext() == false) goto L21;
        ClientRecord clientRecord = r6.next();     // Catch: Throwable -> L9
        if (TextUtils.equals(clientRecord.mPackageName, targetPackageName) == false) goto L14;
        if (this.mDefaultAudioRouteId.equals(clientRecord.mSelectedRouteId) == false) goto L14;
        setDeviceRouteSelected = true;
    L21:
        monitor-exit(r3);     // Catch: Throwable -> L9
        return this.mService2.getSystemSessionInfo(callerPackageName, targetPackageName, setDeviceRouteSelected);
    L11:
        userClientRecords = Collections.emptyList();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L27:
        throw new SecurityException("callerPackageName does not match calling uid.");
    }

    public void registerManager(IMediaRouter2Manager manager, String callerPackageName) {
        int uid = Binder.getCallingUid();
        if (validatePackageName(uid, callerPackageName) == false) goto L7;
        this.mService2.registerManager(manager, callerPackageName);
        return;
    L7:
        throw new SecurityException("callerPackageName must match the calling uid");
    }

    public void registerProxyRouter(IMediaRouter2Manager manager, String callerPackageName, String targetPackageName, UserHandle targetUser) {
        int uid = Binder.getCallingUid();
        if (validatePackageName(uid, callerPackageName) == false) goto L7;
        this.mService2.registerProxyRouter(manager, callerPackageName, targetPackageName, targetUser);
        return;
    L7:
        throw new SecurityException("callerPackageName must match the calling uid");
    }

    public void unregisterManager(IMediaRouter2Manager manager) {
        this.mService2.unregisterManager(manager);
    }

    public void updateScanningState(IMediaRouter2Manager manager, int scanningState) {
        this.mService2.updateScanningState(manager, scanningState);
    }

    public void setRouteVolumeWithManager(IMediaRouter2Manager manager, int requestId, MediaRoute2Info route, int volume) {
        this.mService2.setRouteVolumeWithManager(manager, requestId, route, volume);
    }

    public void requestCreateSessionWithManager(IMediaRouter2Manager manager, int requestId, RoutingSessionInfo oldSession, MediaRoute2Info route) {
        this.mService2.requestCreateSessionWithManager(manager, requestId, oldSession, route);
    }

    public void selectRouteWithManager(IMediaRouter2Manager manager, int requestId, String sessionId, MediaRoute2Info route) {
        this.mService2.selectRouteWithManager(manager, requestId, sessionId, route);
    }

    public void deselectRouteWithManager(IMediaRouter2Manager manager, int requestId, String sessionId, MediaRoute2Info route) {
        this.mService2.deselectRouteWithManager(manager, requestId, sessionId, route);
    }

    public void transferToRouteWithManager(IMediaRouter2Manager manager, int requestId, String sessionId, MediaRoute2Info route, UserHandle transferInitiatorUserHandle, String transferInitiatorPackageName) {
        this.mService2.transferToRouteWithManager(manager, requestId, sessionId, route, transferInitiatorUserHandle, transferInitiatorPackageName);
    }

    public void setSessionVolumeWithManager(IMediaRouter2Manager manager, int requestId, String sessionId, int volume) {
        this.mService2.setSessionVolumeWithManager(manager, requestId, sessionId, volume);
    }

    public void releaseSessionWithManager(IMediaRouter2Manager manager, int requestId, String sessionId) {
        this.mService2.releaseSessionWithManager(manager, requestId, sessionId);
    }

    public boolean showMediaOutputSwitcherWithProxyRouter(IMediaRouter2Manager proxyRouter) {
        return this.mService2.showMediaOutputSwitcherWithProxyRouter(proxyRouter);
    }

    public void setDeviceSuggestionsWithManager(IMediaRouter2Manager manager, List<SuggestedDeviceInfo> suggestedDeviceInfo) {
        this.mService2.setDeviceSuggestionsWithManager(manager, suggestedDeviceInfo);
    }

    public Map<String, List<SuggestedDeviceInfo>> getDeviceSuggestionsWithManager(IMediaRouter2Manager manager) {
        return this.mService2.getDeviceSuggestionsWithManager(manager);
    }

    void restoreBluetoothA2dp() {
        Object r0 = this.mLock;     // Catch: RemoteException -> L10
        monitor-enter(r0);     // Catch: RemoteException -> L10
        boolean a2dpOn = this.mGlobalBluetoothA2dpOn;     // Catch: Throwable -> L14
        BluetoothDevice btDevice = this.mActiveBluetoothDevice;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        if (btDevice != null) goto L8;
        return;
    L8:
        if (DEBUG == false) goto L12;
        Slog.d(TAG, "restoreBluetoothA2dp(" + a2dpOn + ")");     // Catch: RemoteException -> L10
    L12:
        this.mAudioService.setBluetoothA2dpOn(a2dpOn);     // Catch: RemoteException -> L10
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L10
    L17:
        Slog.w(TAG, "RemoteException while calling setBluetoothA2dpOn.");
    }

    void restoreRoute(int uid) {
        ClientRecord clientRecord = null;
        Object r1 = this.mLock;
        monitor-enter(r1);
        UserRecord userRecord = this.mUserRecords.get(UserHandle.getUserHandleForUid(uid).getIdentifier());     // Catch: Throwable -> L15
        if (userRecord != null) goto L7;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L15
        if (clientRecord != null) goto L27;
        restoreBluetoothA2dp();
        return;
    L27:
        clientRecord.mClient.onRestoreRoute();     // Catch: RemoteException -> L21
        return;
    L22:
        Slog.w(TAG, "Failed to call onRestoreRoute. Client probably died.");
        return;
    L7:
        if (userRecord.mClientRecords == null) goto L17;
        Iterator<ClientRecord> r3 = userRecord.mClientRecords.iterator();     // Catch: Throwable -> L15
    L10:
        if (r3.hasNext() == false) goto L17;
        ClientRecord cr = r3.next();     // Catch: Throwable -> L15
        if (validatePackageName(uid, cr.mPackageName) == false) goto L10;
        clientRecord = cr;
    L15:
        th = move-exception;
        throw th;
    }

    private void updateRunningUserAndProfiles(int newActiveUserId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentActiveUserId == newActiveUserId) goto L16;
        this.mCurrentActiveUserId = newActiveUserId;     // Catch: Throwable -> L12
        SparseArray<UserRecord> userRecords = this.mUserRecords.clone();     // Catch: Throwable -> L12
        int i = 0;
    L8:
        if (i >= userRecords.size()) goto L16;
        int userId = userRecords.keyAt(i);     // Catch: Throwable -> L12
        UserRecord userRecord = userRecords.valueAt(i);     // Catch: Throwable -> L12
        if (isUserActiveLocked(userId) == false) goto L14;
        userRecord.mHandler.sendEmptyMessage(1);     // Catch: Throwable -> L12
    L15:
        i = i + 1;     // Catch: Throwable -> L12
        goto L8
    L14:
        userRecord.mHandler.sendEmptyMessage(2);     // Catch: Throwable -> L12
        disposeUserIfNeededLocked(userRecord);     // Catch: Throwable -> L12
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        this.mService2.updateRunningUserAndProfiles(newActiveUserId);
    }

    void clientDied(ClientRecord clientRecord) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        unregisterClientLocked(clientRecord.mClient, true);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void registerClientLocked(IMediaRouterClient client, int uid, int pid, String packageName, int userId, boolean trusted) {
        IBinder binder = client.asBinder();
        if (this.mAllClientRecords.get(binder) != null) goto L16;
        boolean newUser = false;
        UserRecord userRecord = this.mUserRecords.get(userId);
        if (userRecord != null) goto L7;
        newUser = true;
        UserRecord userRecord2 = new UserRecord(this, userId);
    L8:
        ClientRecord clientRecord = new ClientRecord(this, userRecord2, client, uid, pid, packageName, trusted);
        binder.linkToDeath(clientRecord, 0);     // Catch: RemoteException -> L13
        if (newUser == false) goto L12;
        this.mUserRecords.put(userId, userRecord2);
        initializeUserLocked(userRecord2);
    L12:
        userRecord2.mClientRecords.add(clientRecord);
        this.mAllClientRecords.put(binder, clientRecord);
        initializeClientLocked(clientRecord);
        return;
    L13:
        ex = move-exception;
        throw new RuntimeException("Media router client died prematurely.", ex);
    L7:
        userRecord2 = userRecord;
        goto L8
    }

    private void registerClientGroupIdLocked(IMediaRouterClient client, String groupId) {
        IBinder binder = client.asBinder();
        ClientRecord clientRecord = this.mAllClientRecords.get(binder);
        if (clientRecord != null) goto L7;
        Log.w(TAG, "Ignoring group id register request of a unregistered client.");
        return;
    L7:
        if (TextUtils.equals(clientRecord.mGroupId, groupId) == false) goto L9;
        return;
    L9:
        UserRecord userRecord = clientRecord.mUserRecord;
        if (clientRecord.mGroupId == null) goto L12;
        userRecord.removeFromGroup(clientRecord.mGroupId, clientRecord);
    L12:
        clientRecord.mGroupId = groupId;
        if (groupId == null) goto L16;
        userRecord.addToGroup(groupId, clientRecord);
        userRecord.mHandler.obtainMessage(10, groupId).sendToTarget();
        return;
    }

    private void unregisterClientLocked(IMediaRouterClient client, boolean died) {
        ClientRecord clientRecord = this.mAllClientRecords.remove(client.asBinder());
        if (clientRecord == null) goto L9;
        UserRecord userRecord = clientRecord.mUserRecord;
        userRecord.mClientRecords.remove(clientRecord);
        if (clientRecord.mGroupId == null) goto L7;
        userRecord.removeFromGroup(clientRecord.mGroupId, clientRecord);
        clientRecord.mGroupId = null;
    L7:
        disposeClientLocked(clientRecord, died);
        disposeUserIfNeededLocked(userRecord);
        return;
    }

    private MediaRouterClientState getStateLocked(IMediaRouterClient client) {
        ClientRecord clientRecord = this.mAllClientRecords.get(client.asBinder());
        if (clientRecord != null) goto L5;
        return null;
    L5:
        return clientRecord.getState();
    }

    private void setDiscoveryRequestLocked(IMediaRouterClient client, int routeTypes, boolean activeScan) {
        IBinder binder = client.asBinder();
        ClientRecord clientRecord = this.mAllClientRecords.get(binder);
        if (clientRecord != null) goto L5;
        return;
    L5:
        if (clientRecord.mTrusted == true) goto L8;
        routeTypes = routeTypes & (-5);
    L8:
        if (clientRecord.mRouteTypes != routeTypes) goto L12;
        if (clientRecord.mActiveScan != activeScan) goto L12;
        return;
    L12:
        if (DEBUG == false) goto L14;
        Slog.d(TAG, clientRecord + ": Set discovery request, routeTypes=0x" + Integer.toHexString(routeTypes) + ", activeScan=" + activeScan);
    L14:
        clientRecord.mRouteTypes = routeTypes;
        clientRecord.mActiveScan = activeScan;
        clientRecord.mUserRecord.mHandler.sendEmptyMessage(3);
    }

    private void setSelectedRouteLocked(IMediaRouterClient client, String routeId, boolean explicit) {
        ClientRecord clientRecord = this.mAllClientRecords.get(client.asBinder());
        if (clientRecord != null) goto L5;
        return;
    L5:
        if (this.mDefaultAudioRouteId.equals(clientRecord.mSelectedRouteId) == false) goto L7;
    L10:
        String oldRouteId = null;
    L11:
        clientRecord.mSelectedRouteId = routeId;
        if (this.mDefaultAudioRouteId.equals(routeId) == false) goto L14;
    L15:
        routeId = null;
    L17:
        if (Objects.equals(routeId, oldRouteId) == false) goto L19;
        return;
    L19:
        if (DEBUG == false) goto L21;
        Slog.d(TAG, clientRecord + ": Set selected route, routeId=" + routeId + ", oldRouteId=" + oldRouteId + ", explicit=" + explicit);
    L21:
        if (explicit == true) goto L23;
        return;
    L23:
        if (clientRecord.mTrusted == false) goto L37;
        if (oldRouteId == null) goto L26;
        clientRecord.mUserRecord.mHandler.obtainMessage(5, oldRouteId).sendToTarget();
    L26:
        if (routeId == null) goto L29;
        clientRecord.mUserRecord.mHandler.obtainMessage(4, routeId).sendToTarget();
    L29:
        if (clientRecord.mGroupId == null) goto L38;
        ClientGroup group = (ClientGroup) UserRecord.m5611$$Nest$fgetmClientGroupMap(clientRecord.mUserRecord).get(clientRecord.mGroupId);
        if (group == null) goto L39;
        group.mSelectedRouteId = routeId;
        clientRecord.mUserRecord.mHandler.obtainMessage(10, clientRecord.mGroupId).sendToTarget();
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L14:
        if (this.mBluetoothA2dpRouteId.equals(routeId) == false) goto L17;
    L7:
        if (this.mBluetoothA2dpRouteId.equals(clientRecord.mSelectedRouteId) == true) goto L10;
        oldRouteId = clientRecord.mSelectedRouteId;
        goto L11
    }

    private void requestSetVolumeLocked(IMediaRouterClient client, String routeId, int volume) {
        IBinder binder = client.asBinder();
        ClientRecord clientRecord = this.mAllClientRecords.get(binder);
        if (clientRecord == null) goto L6;
        clientRecord.mUserRecord.mHandler.obtainMessage(6, volume, 0, routeId).sendToTarget();
        return;
    }

    private void requestUpdateVolumeLocked(IMediaRouterClient client, String routeId, int direction) {
        IBinder binder = client.asBinder();
        ClientRecord clientRecord = this.mAllClientRecords.get(binder);
        if (clientRecord == null) goto L6;
        clientRecord.mUserRecord.mHandler.obtainMessage(7, direction, 0, routeId).sendToTarget();
        return;
    }

    private void initializeUserLocked(UserRecord userRecord) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, userRecord + ": Initialized");
    L6:
        if (isUserActiveLocked(userRecord.mUserId) == false) goto L9;
        userRecord.mHandler.sendEmptyMessage(1);
        return;
    }

    private void disposeUserIfNeededLocked(UserRecord userRecord) {
        if (isUserActiveLocked(userRecord.mUserId) == false) goto L5;
        return;
    L5:
        if (userRecord.mClientRecords.isEmpty() == true) goto L7;
        return;
    L7:
        if (DEBUG == false) goto L9;
        Slog.d(TAG, userRecord + ": Disposed");
    L9:
        this.mUserRecords.remove(userRecord.mUserId);
    }

    private boolean isUserActiveLocked(int userId) {
        if (this.mUserManagerInternal.getProfileParentId(userId) != this.mCurrentActiveUserId) goto L5;
        return true;
    L5:
        return false;
    }

    private void initializeClientLocked(ClientRecord clientRecord) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, clientRecord + ": Registered");
        return;
    }

    private void disposeClientLocked(ClientRecord clientRecord, boolean died) {
        if (DEBUG == false) goto L9;
        if (died == false) goto L7;
        Slog.d(TAG, clientRecord + ": Died!");
        goto L9
    L7:
        Slog.d(TAG, clientRecord + ": Unregistered");
    L9:
        if (clientRecord.mRouteTypes == 0) goto L11;
    L12:
        clientRecord.mUserRecord.mHandler.sendEmptyMessage(3);
    L13:
        clientRecord.dispose();
        return;
    L11:
        if (clientRecord.mActiveScan == false) goto L13;
        goto L12
    }

    private boolean validatePackageName(int uid, String packageName) {
        if (packageName == null) goto L14;
        String[] packageNames = this.mContext.getPackageManager().getPackagesForUid(uid);
        if (packageNames == null) goto L14;
        int r2 = packageNames.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L14;
        String n = packageNames[r3];
        if (n.equals(packageName) == true) goto L11;
        r3 = r3 + 1;
        goto L8
    L11:
        return true;
    L14:
        return false;
    }
}
