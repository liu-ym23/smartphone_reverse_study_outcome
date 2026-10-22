package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class MediaBrowserCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final boolean f6a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f7b;

    private static class CallbackHandler extends Handler {
        private final WeakReference<c> mCallbackImplRef;
        private WeakReference<Messenger> mCallbacksMessengerRef;

        public static /* synthetic */ int access$000(String r0, String r1) {
            return Log.w(r0, r1);
        }

        public static /* synthetic */ int access$001(String r0, String r1) {
            return Log.e(r0, r1);
        }

        CallbackHandler(c r3) {
            this.mCallbackImplRef = new WeakReference((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.os.Handler
        public void handleMessage(Message r12) {
            WeakReference<Messenger> r1 = this.mCallbacksMessengerRef;
            if (r1 != null) goto L5;
            return;
        L5:
            if (r1.get() != null) goto L7;
            return;
        L7:
            if (this.mCallbackImplRef.get() == null) goto L33;
            Bundle r2 = r12.getData();
            MediaSessionCompat.a(r2);
            c r3 = (c) ZeusTransformUtils.preCheckCast(this.mCallbackImplRef.get(), c.class, "com.obric.aiagent.plugin");
            Messenger r11 = (Messenger) ZeusTransformUtils.preCheckCast(this.mCallbacksMessengerRef.get(), Messenger.class, "com.obric.aiagent.plugin");
            int r5 = r12.what;     // Catch: BadParcelableException -> L22
            if (r5 != 1) goto L14;
            Bundle r6 = r2.getBundle("data_root_hints");     // Catch: BadParcelableException -> L22
            MediaSessionCompat.a(r6);     // Catch: BadParcelableException -> L22
            r3.onServiceConnected(r11, r2.getString("data_media_item_id"), (MediaSessionCompat.Token) ZeusTransformUtils.preCheckCast(r2.getParcelable("data_media_session_token"), MediaSessionCompat.Token.class, "com.obric.aiagent.plugin"), r6);     // Catch: BadParcelableException -> L22
        L26:
            return;
        L14:
            if (r5 != 2) goto L16;
            r3.onConnectionFailed(r11);     // Catch: BadParcelableException -> L22
            goto L26
        L16:
            if (r5 == 3) goto L18;
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$CallbackHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("MediaBrowserCompat", "Unhandled message: " + r12 + "\n  Client version: 1\n  Service version: " + r12.arg1);     // Catch: BadParcelableException -> L22
            goto L26
        L18:
            Bundle r9 = r2.getBundle("data_options");     // Catch: BadParcelableException -> L22
            MediaSessionCompat.a(r9);     // Catch: BadParcelableException -> L22
            Bundle r10 = r2.getBundle("data_notify_children_changed_options");     // Catch: BadParcelableException -> L22
            MediaSessionCompat.a(r10);     // Catch: BadParcelableException -> L22
            r3.onLoadChildren(r11, r2.getString("data_media_item_id"), r2.getParcelableArrayList("data_media_item_list"), r9, r10);     // Catch: BadParcelableException -> L22
        L22:
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$CallbackHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaBrowserCompat", "Could not unparcel the data.");
            if (r12.what != 1) goto L32;
            r3.onConnectionFailed(r11);
            return;
        L32:
            return;
        }

        void setCallbacksMessenger(Messenger r2) {
            this.mCallbacksMessengerRef = new WeakReference(r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$CallbackHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$CallbackHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    public static class ConnectionCallback {
        a mConnectionCallbackInternal;
        final Object mConnectionCallbackObj;

        private class StubApi21 implements MediaBrowserCompatApi21.a {
            final /* synthetic */ ConnectionCallback this$0;

            StubApi21(ConnectionCallback r1) {
                this.this$0 = r1;
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.a
            public void onConnected() {
                if (this.this$0.mConnectionCallbackInternal == null) goto L5;
                this.this$0.mConnectionCallbackInternal.onConnected();
            L5:
                this.this$0.onConnected();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.a
            public void onConnectionSuspended() {
                if (this.this$0.mConnectionCallbackInternal == null) goto L5;
                this.this$0.mConnectionCallbackInternal.onConnectionSuspended();
            L5:
                this.this$0.onConnectionSuspended();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.a
            public void onConnectionFailed() {
                if (this.this$0.mConnectionCallbackInternal == null) goto L5;
                this.this$0.mConnectionCallbackInternal.onConnectionFailed();
            L5:
                this.this$0.onConnectionFailed();
            }
        }

        interface a {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }

        public ConnectionCallback() {
            if (Build.VERSION.SDK_INT < 21) goto L5;
            this.mConnectionCallbackObj = MediaBrowserCompatApi21.a(new StubApi21(this));
            return;
        L5:
            this.mConnectionCallbackObj = null;
        }

        void setInternalConnectionCallback(a r3) {
            this.mConnectionCallbackInternal = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        }
    }

    private static class CustomActionResultReceiver extends ResultReceiver {
        private final String mAction;
        private final a mCallback;
        private final Bundle mExtras;

        public static /* synthetic */ int access$000(String r0, String r1) {
            return Log.w(r0, r1);
        }

        CustomActionResultReceiver(String r1, Bundle r2, a r3, Handler r4) {
            super(r4);
            this.mAction = r1;
            this.mExtras = r2;
            this.mCallback = r3;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int r3, Bundle r4) {
            if (this.mCallback != null) goto L5;
            return;
        L5:
            MediaSessionCompat.a(r4);
            if (r3 == (-1)) goto L13;
            if (r3 != 0) goto L9;
            this.mCallback.b(this.mAction, this.mExtras, r4);
            return;
        L9:
            if (r3 == 1) goto L11;
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$CustomActionResultReceiver_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("MediaBrowserCompat", "Unknown result code: " + r3 + " (extras=" + this.mExtras + ", resultData=" + r4 + ")");
            return;
        L11:
            this.mCallback.a(this.mAction, this.mExtras, r4);
            return;
        L13:
            this.mCallback.c(this.mAction, this.mExtras, r4);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$CustomActionResultReceiver_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }
    }

    public static abstract class ItemCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f8a;

        private class StubApi23 implements MediaBrowserCompatApi23.a {
            final /* synthetic */ ItemCallback this$0;

            StubApi23(ItemCallback r1) {
                this.this$0 = r1;
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi23.a
            public void onItemLoaded(Parcel r4) {
                if (r4 != null) goto L4;
                this.this$0.a(null);
                return;
            L4:
                r4.setDataPosition(0);
                MediaItem r0 = (MediaItem) ZeusTransformUtils.preCheckCast(MediaItem.CREATOR.createFromParcel(r4), MediaItem.class, "com.obric.aiagent.plugin");
                r4.recycle();
                this.this$0.a(r0);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi23.a
            public void onError(String r1) {
                this.this$0.a(r1);
            }
        }

        public void a(MediaItem r1) {
        }

        public void a(String r1) {
        }
    }

    private static class ItemReceiver extends ResultReceiver {
        private final ItemCallback mCallback;
        private final String mMediaId;

        ItemReceiver(String r1, ItemCallback r2, Handler r3) {
            super(r3);
            this.mMediaId = r1;
            this.mCallback = r2;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int r2, Bundle r3) {
            MediaSessionCompat.a(r3);
            if (r2 != 0) goto L16;
            if (r3 == null) goto L16;
            if (r3.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM) == false) goto L16;
            Parcelable r4 = r3.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (r4 != null) goto L11;
        L14:
            this.mCallback.a((MediaItem) ZeusTransformUtils.preCheckCast(r4, MediaItem.class, "com.obric.aiagent.plugin"));
            return;
        L11:
            if (ZeusTransformUtils.instanceOf(r4, MediaItem.class) == true) goto L14;
            this.mCallback.a(this.mMediaId);
            return;
        L16:
            this.mCallback.a(this.mMediaId);
        }
    }

    static class MediaBrowserImplApi21 implements ConnectionCallback.a, b, c {
        protected final Object mBrowserObj;
        protected Messenger mCallbacksMessenger;
        final Context mContext;
        protected final CallbackHandler mHandler;
        private MediaSessionCompat.Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        protected final Bundle mRootHints;
        protected e mServiceBinderWrapper;
        protected int mServiceVersion;
        private final androidx.b.a<String, f> mSubscriptions;

        public static /* synthetic */ int access$000(String r0, String r1) {
            return Log.i(r0, r1);
        }

        public static /* synthetic */ int access$001(String r0, String r1) {
            return Log.d(r0, r1);
        }

        public static /* synthetic */ int access$002(String r0, String r1, Throwable r2) {
            return Log.i(r0, r1, r2);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.a
        public void onConnectionFailed() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void onConnectionFailed(Messenger r1) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void onServiceConnected(Messenger r1, String r2, MediaSessionCompat.Token r3, Bundle r4) {
        }

        MediaBrowserImplApi21(Context r3, ComponentName r4, ConnectionCallback r5, Bundle r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            this.mHandler = new CallbackHandler(this);
            this.mSubscriptions = new androidx.b.a();
            this.mContext = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
            if (r6 == null) goto L5;
            Bundle r0 = new Bundle(r6);
        L6:
            this.mRootHints = r0;
            r0.putInt("extra_client_version", 1);
            r5.setInternalConnectionCallback(this);
            this.mBrowserObj = MediaBrowserCompatApi21.a(r7, r4, r5.mConnectionCallbackObj, r0);
            return;
        L5:
            r0 = new Bundle();
            goto L6
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void connect() {
            MediaBrowserCompatApi21.a(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void disconnect() {
            e r0 = this.mServiceBinderWrapper;
            if (r0 == null) goto L9;
            Messenger r1 = this.mCallbacksMessenger;
            if (r1 == null) goto L9;
            r0.b(r1);     // Catch: RemoteException -> L8
        L8:
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("MediaBrowserCompat", "Remote error unregistering client messenger.");
        L9:
            MediaBrowserCompatApi21.b(this.mBrowserObj);
        }

        public boolean isConnected() {
            return MediaBrowserCompatApi21.c(this.mBrowserObj);
        }

        public ComponentName getServiceComponent() {
            return MediaBrowserCompatApi21.d(this.mBrowserObj);
        }

        public String getRoot() {
            return MediaBrowserCompatApi21.e(this.mBrowserObj);
        }

        public Bundle getExtras() {
            return MediaBrowserCompatApi21.f(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public MediaSessionCompat.Token getSessionToken() {
            if (this.mMediaSessionToken != null) goto L6;
            this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.g(this.mBrowserObj));
        L6:
            return this.mMediaSessionToken;
        }

        public void subscribe(String r4, Bundle r5, SubscriptionCallback r6) {
            f r0 = (f) ZeusTransformUtils.preCheckCast(this.mSubscriptions.get(r4), f.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
            r0 = new f();
            this.mSubscriptions.put(r4, r0);
        L5:
            r6.a(r0);
            if (r5 != null) goto L8;
            Bundle r7 = null;
        L9:
            r0.a(r7, r6);
            e r1 = this.mServiceBinderWrapper;
            if (r1 != null) goto L16;
            MediaBrowserCompatApi21.a(this.mBrowserObj, r4, r6.f55a);
            return;
        L16:
            r1.a(r4, r6.f56b, r7, this.mCallbacksMessenger);     // Catch: RemoteException -> L14
            return;
        L14:
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("MediaBrowserCompat", "Remote error subscribing media item: " + r4);
            return;
        L8:
            r7 = new Bundle(r5);
            goto L9
        }

        public void unsubscribe(String r8, SubscriptionCallback r9) {
            f r0 = (f) ZeusTransformUtils.preCheckCast(this.mSubscriptions.get(r8), f.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
            return;
        L5:
            e r1 = this.mServiceBinderWrapper;
            if (r1 != null) goto L33;
            if (r9 != null) goto L9;
            MediaBrowserCompatApi21.a(this.mBrowserObj, r8);
        L29:
            if (r0.a() == true) goto L31;
            if (r9 == null) goto L31;
            return;
        L31:
            this.mSubscriptions.remove(r8);
            return;
        L9:
            List<SubscriptionCallback> r2 = r0.c();
            List<Bundle> r3 = r0.b();
            int r4 = r2.size() - 1;
        L10:
            if (r4 < 0) goto L16;
            if (r2.get(r4) != r9) goto L14;
            r2.remove(r4);
            r3.remove(r4);
        L14:
            r4 = r4 - 1;
            goto L10
        L16:
            if (r2.size() != 0) goto L29;
            MediaBrowserCompatApi21.a(this.mBrowserObj, r8);
            goto L29
        L33:
            if (r9 == null) goto L20;
            List<SubscriptionCallback> r5 = r0.c();     // Catch: RemoteException -> L27
            List<Bundle> r6 = r0.b();     // Catch: RemoteException -> L27
            int r7 = r5.size() - 1;     // Catch: RemoteException -> L27
        L22:
            if (r7 < 0) goto L29;
            if (r5.get(r7) != r9) goto L26;
            this.mServiceBinderWrapper.a(r8, r9.f56b, this.mCallbacksMessenger);     // Catch: RemoteException -> L27
            r5.remove(r7);     // Catch: RemoteException -> L27
            r6.remove(r7);     // Catch: RemoteException -> L27
        L26:
            r7 = r7 - 1;
            goto L22
        L20:
            r1.a(r8, null, this.mCallbacksMessenger);     // Catch: RemoteException -> L27
        L27:
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + r8);
            goto L29
        }

        public void getItem(final String r5, final ItemCallback r6) {
            if (TextUtils.isEmpty(r5) == true) goto L21;
            if (r6 == null) goto L19;
            if (MediaBrowserCompatApi21.c(this.mBrowserObj) == true) goto L10;
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
            this.mHandler.post(new AnonymousClass1(this, r6, r5));
            return;
        L10:
            if (this.mServiceBinderWrapper != null) goto L22;
            this.mHandler.post(new AnonymousClass2(this, r6, r5));
            return;
        L22:
            this.mServiceBinderWrapper.a(r5, new ItemReceiver(r5, r6, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L16
            return;
        L16:
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("MediaBrowserCompat", "Remote error getting media item: " + r5);
            this.mHandler.post(new AnonymousClass3(this, r6, r5));
            return;
        L19:
            throw new IllegalArgumentException("cb is null");
        L21:
            throw new IllegalArgumentException("mediaId is empty");
        }

        public void search(final String r5, final Bundle r6, final d r7) {
            if (isConnected() == false) goto L15;
            if (this.mServiceBinderWrapper != null) goto L16;
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("MediaBrowserCompat", "The connected service doesn't support search.");
            this.mHandler.post(new AnonymousClass4(this, r7, r5, r6));
            return;
        L16:
            this.mServiceBinderWrapper.a(r5, r6, new SearchResultReceiver(r5, r6, r7, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L11
            return;
        L11:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("MediaBrowserCompat", "Remote error searching items with query: " + r5, e);
            this.mHandler.post(new AnonymousClass5(this, r7, r5, r6));
            return;
        L15:
            throw new IllegalStateException("search() called while not connected");
        }

        public void sendCustomAction(final String r5, final Bundle r6, final a r7) {
            if (isConnected() == false) goto L18;
            if (this.mServiceBinderWrapper != null) goto L19;
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("MediaBrowserCompat", "The connected service doesn't support sendCustomAction.");
            if (r7 == null) goto L19;
            this.mHandler.post(new AnonymousClass6(this, r7, r5, r6));
        L19:
            this.mServiceBinderWrapper.b(r5, r6, new CustomActionResultReceiver(r5, r6, r7, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L12
            return;
        L12:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("MediaBrowserCompat", "Remote error sending a custom action: action=" + r5 + ", extras=" + r6, e);
            if (r7 == null) goto L21;
            this.mHandler.post(new AnonymousClass7(this, r7, r5, r6));
            return;
        L21:
            return;
        L18:
            throw new IllegalStateException("Cannot send a custom action (" + r5 + ") with extras " + r6 + " because the browser is not connected to the service.");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.a
        public void onConnected() {
            Bundle r0 = MediaBrowserCompatApi21.f(this.mBrowserObj);
            if (r0 != null) goto L5;
            return;
        L5:
            this.mServiceVersion = r0.getInt("extra_service_version", 0);
            IBinder r1 = androidx.core.app.d.a(r0, "extra_messenger");
            if (r1 == null) goto L11;
            this.mServiceBinderWrapper = new e(r1, this.mRootHints);
            Messenger r2 = new Messenger(this.mHandler);
            this.mCallbacksMessenger = r2;
            this.mHandler.setCallbacksMessenger(r2);
            this.mServiceBinderWrapper.b(this.mContext, this.mCallbacksMessenger);     // Catch: RemoteException -> L10
        L10:
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("MediaBrowserCompat", "Remote error registering client messenger.");
        L11:
            IMediaSession r3 = IMediaSession.Stub.asInterface(androidx.core.app.d.a(r0, "extra_session_binder"));
            if (r3 == null) goto L17;
            this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.g(this.mBrowserObj), r3);
            return;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.a
        public void onConnectionSuspended() {
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mMediaSessionToken = null;
            this.mHandler.setCallbacksMessenger(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void onLoadChildren(Messenger r3, String r4, List r5, Bundle r6, Bundle r7) {
            List<MediaItem> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            if (this.mCallbacksMessenger == r3) goto L5;
            return;
        L5:
            f r9 = (f) ZeusTransformUtils.preCheckCast(this.mSubscriptions.get(r4), f.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L8;
            SubscriptionCallback r10 = r9.a(r6);
            if (r10 != null) goto L14;
            return;
        L14:
            if (r6 != null) goto L18;
            if (r8 != null) goto L17;
            r10.a(r4);
            return;
        L17:
            this.mNotifyChildrenChangedOptions = r7;
            r10.a(r4, r8);
            this.mNotifyChildrenChangedOptions = null;
            return;
        L18:
            if (r8 != null) goto L20;
            r10.a(r4, r6);
            return;
        L20:
            this.mNotifyChildrenChangedOptions = r7;
            r10.a(r4, r8, r6);
            this.mNotifyChildrenChangedOptions = null;
            return;
        L8:
            if (MediaBrowserCompat.f6a == false) goto L22;
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + r4);
            return;
        }

        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2, r3);
        }
    }

    static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        MediaBrowserImplApi23(Context r3, ComponentName r4, ConnectionCallback r5, Bundle r6) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5, r6);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21
        public void getItem(String r2, ItemCallback r3) {
            if (this.mServiceBinderWrapper != null) goto L5;
            MediaBrowserCompatApi23.a(this.mBrowserObj, r2, r3.f8a);
            return;
        L5:
            super.getItem(r2, r3);
        }
    }

    static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
        MediaBrowserImplApi26(Context r3, ComponentName r4, ConnectionCallback r5, Bundle r6) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5, r6);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21
        public void subscribe(String r3, Bundle r4, SubscriptionCallback r5) {
            if (this.mServiceBinderWrapper != null) goto L5;
        L8:
            if (r4 != null) goto L10;
            MediaBrowserCompatApi21.a(this.mBrowserObj, r3, r5.f55a);
            return;
        L10:
            MediaBrowserCompatApi26.a(this.mBrowserObj, r3, r4, r5.f55a);
            return;
        L5:
            if (this.mServiceVersion < 2) goto L8;
            super.subscribe(r3, r4, r5);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21
        public void unsubscribe(String r3, SubscriptionCallback r4) {
            if (this.mServiceBinderWrapper != null) goto L5;
        L8:
            if (r4 != null) goto L10;
            MediaBrowserCompatApi21.a(this.mBrowserObj, r3);
            return;
        L10:
            MediaBrowserCompatApi26.a(this.mBrowserObj, r3, r4.f55a);
            return;
        L5:
            if (this.mServiceVersion < 2) goto L8;
            super.unsubscribe(r3, r4);
        }
    }

    static class MediaBrowserImplBase implements b, c {
        static final int CONNECT_STATE_CONNECTED = 3;
        static final int CONNECT_STATE_CONNECTING = 2;
        static final int CONNECT_STATE_DISCONNECTED = 1;
        static final int CONNECT_STATE_DISCONNECTING = 0;
        static final int CONNECT_STATE_SUSPENDED = 4;
        final ConnectionCallback mCallback;
        Messenger mCallbacksMessenger;
        final Context mContext;
        private Bundle mExtras;
        final CallbackHandler mHandler;
        private MediaSessionCompat.Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        final Bundle mRootHints;
        private String mRootId;
        e mServiceBinderWrapper;
        final ComponentName mServiceComponent;
        MediaServiceConnection mServiceConnection;
        int mState;
        private final androidx.b.a<String, f> mSubscriptions;

        private class MediaServiceConnection implements ServiceConnection {
            final /* synthetic */ MediaBrowserImplBase this$0;

            public static /* synthetic */ int access$000(String r0, String r1) {
                return Log.i(r0, r1);
            }

            MediaServiceConnection(MediaBrowserImplBase r1) {
                this.this$0 = r1;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(final ComponentName r3, IBinder r4) {
                final IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin");
                postOrRun(new AnonymousClass1(this, r3, r5));
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(final ComponentName r2) {
                postOrRun(new AnonymousClass2(this, r2));
            }

            private void postOrRun(Runnable r3) {
                Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
                if (Thread.currentThread() != this.this$0.mHandler.getLooper().getThread()) goto L5;
                r4.run();
                return;
            L5:
                this.this$0.mHandler.post(r4);
            }

            boolean isCurrent(String r3) {
                if (this.this$0.mServiceConnection != this) goto L11;
                if (this.this$0.mState == 0) goto L11;
                if (this.this$0.mState == 1) goto L11;
                return true;
            L11:
                if (this.this$0.mState != 0) goto L13;
                return false;
            L13:
                if (this.this$0.mState == 1) goto L18;
                INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("MediaBrowserCompat", r3 + " for " + this.this$0.mServiceComponent + " with mServiceConnection=" + this.this$0.mServiceConnection + " this=" + this);
                return false;
            L18:
                return false;
            }

            @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
            public static int INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
                if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
                return 0;
            L5:
                return Log.i(r1, r2);
            }
        }

        public static /* synthetic */ int access$000(String r0, String r1) {
            return Log.d(r0, r1);
        }

        public static /* synthetic */ int access$001(String r0, String r1) {
            return Log.i(r0, r1);
        }

        public static /* synthetic */ int access$002(String r0, String r1, Throwable r2) {
            return Log.i(r0, r1, r2);
        }

        public static /* synthetic */ int access$003(String r0, String r1) {
            return Log.w(r0, r1);
        }

        public static /* synthetic */ int access$004(String r0, String r1) {
            return Log.e(r0, r1);
        }

        public MediaBrowserImplBase(Context r3, ComponentName r4, ConnectionCallback r5, Bundle r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            this.mHandler = new CallbackHandler(this);
            this.mSubscriptions = new androidx.b.a();
            this.mState = 1;
            if (r7 == null) goto L17;
            if (r4 == null) goto L15;
            if (r5 == null) goto L13;
            this.mContext = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
            this.mServiceComponent = r4;
            this.mCallback = r5;
            if (r6 != null) goto L9;
            Bundle r8 = null;
        L10:
            this.mRootHints = r8;
            return;
        L9:
            r8 = new Bundle(r6);
            goto L10
        L13:
            throw new IllegalArgumentException("connection callback must not be null");
        L15:
            throw new IllegalArgumentException("service component must not be null");
        L17:
            throw new IllegalArgumentException("context must not be null");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void connect() {
            int r0 = this.mState;
            if (r0 != 0) goto L5;
        L9:
            this.mState = 2;
            this.mHandler.post(new AnonymousClass1(this));
            return;
        L5:
            if (r0 == 1) goto L9;
            throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void disconnect() {
            this.mState = 0;
            this.mHandler.post(new AnonymousClass2(this));
        }

        void forceCloseConnection() {
            MediaServiceConnection r0 = this.mServiceConnection;
            if (r0 == null) goto L5;
            ZeusTransformUtils.unbindService(this.mContext, r0, "com.obric.aiagent.plugin");
        L5:
            this.mState = 1;
            this.mServiceConnection = null;
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mHandler.setCallbacksMessenger(null);
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        public boolean isConnected() {
            if (this.mState != 3) goto L5;
            return true;
        L5:
            return false;
        }

        public ComponentName getServiceComponent() {
            if (isConnected() == false) goto L7;
            return this.mServiceComponent;
        L7:
            throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
        }

        public String getRoot() {
            if (isConnected() == false) goto L7;
            return this.mRootId;
        L7:
            throw new IllegalStateException("getRoot() called while not connected(state=" + getStateLabel(this.mState) + ")");
        }

        public Bundle getExtras() {
            if (isConnected() == false) goto L7;
            return this.mExtras;
        L7:
            throw new IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public MediaSessionCompat.Token getSessionToken() {
            if (isConnected() == false) goto L7;
            return this.mMediaSessionToken;
        L7:
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
        }

        public void subscribe(String r4, Bundle r5, SubscriptionCallback r6) {
            f r0 = (f) ZeusTransformUtils.preCheckCast(this.mSubscriptions.get(r4), f.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
            r0 = new f();
            this.mSubscriptions.put(r4, r0);
        L5:
            if (r5 != null) goto L7;
            Bundle r7 = null;
        L8:
            r0.a(r7, r6);
            if (isConnected() == false) goto L16;
            this.mServiceBinderWrapper.a(r4, r6.f56b, r7, this.mCallbacksMessenger);     // Catch: RemoteException -> L12
            return;
        L12:
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + r4);
            return;
        L16:
            return;
        L7:
            r7 = new Bundle(r5);
            goto L8
        }

        public void unsubscribe(String r8, SubscriptionCallback r9) {
            f r0 = (f) ZeusTransformUtils.preCheckCast(this.mSubscriptions.get(r8), f.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L24;
            return;
        L24:
            if (r9 == null) goto L7;
            List<SubscriptionCallback> r1 = r0.c();     // Catch: RemoteException -> L18
            List<Bundle> r2 = r0.b();     // Catch: RemoteException -> L18
            int r3 = r1.size() - 1;     // Catch: RemoteException -> L18
        L10:
            if (r3 < 0) goto L20;
            if (r1.get(r3) != r9) goto L17;
            if (isConnected() == false) goto L16;
            this.mServiceBinderWrapper.a(r8, r9.f56b, this.mCallbacksMessenger);     // Catch: RemoteException -> L18
        L16:
            r1.remove(r3);     // Catch: RemoteException -> L18
            r2.remove(r3);     // Catch: RemoteException -> L18
        L17:
            r3 = r3 - 1;
        L20:
            if (r0.a() == true) goto L22;
            if (r9 == null) goto L22;
            return;
        L22:
            this.mSubscriptions.remove(r8);
            return;
        L7:
            if (isConnected() == false) goto L20;
            this.mServiceBinderWrapper.a(r8, null, this.mCallbacksMessenger);     // Catch: RemoteException -> L18
        L18:
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + r8);
            goto L20
        }

        public void getItem(final String r5, final ItemCallback r6) {
            if (TextUtils.isEmpty(r5) == true) goto L17;
            if (r6 == null) goto L15;
            if (isConnected() == true) goto L18;
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
            this.mHandler.post(new AnonymousClass3(this, r6, r5));
            return;
        L18:
            this.mServiceBinderWrapper.a(r5, new ItemReceiver(r5, r6, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L12
            return;
        L12:
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("MediaBrowserCompat", "Remote error getting media item: " + r5);
            this.mHandler.post(new AnonymousClass4(this, r6, r5));
            return;
        L15:
            throw new IllegalArgumentException("cb is null");
        L17:
            throw new IllegalArgumentException("mediaId is empty");
        }

        public void search(final String r4, final Bundle r5, final d r6) {
            if (isConnected() == false) goto L11;
            this.mServiceBinderWrapper.a(r4, r5, new SearchResultReceiver(r4, r5, r6, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L7
            return;
        L7:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("MediaBrowserCompat", "Remote error searching items with query: " + r4, e);
            this.mHandler.post(new AnonymousClass5(this, r6, r4, r5));
            return;
        L11:
            throw new IllegalStateException("search() called while not connected (state=" + getStateLabel(this.mState) + ")");
        }

        public void sendCustomAction(final String r4, final Bundle r5, final a r6) {
            if (isConnected() == false) goto L13;
            this.mServiceBinderWrapper.b(r4, r5, new CustomActionResultReceiver(r4, r5, r6, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L7
            return;
        L7:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("MediaBrowserCompat", "Remote error sending a custom action: action=" + r4 + ", extras=" + r5, e);
            if (r6 == null) goto L16;
            this.mHandler.post(new AnonymousClass6(this, r6, r4, r5));
            return;
        L16:
            return;
        L13:
            throw new IllegalStateException("Cannot send a custom action (" + r4 + ") with extras " + r5 + " because the browser is not connected to the service.");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void onServiceConnected(Messenger r8, String r9, MediaSessionCompat.Token r10, Bundle r11) {
            if (isCurrent(r8, "onConnect") == true) goto L6;
            return;
        L6:
            if (this.mState == 2) goto L9;
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("MediaBrowserCompat", "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
            return;
        L9:
            this.mRootId = r9;
            this.mMediaSessionToken = r10;
            this.mExtras = r11;
            this.mState = 3;
            if (MediaBrowserCompat.f6a == false) goto L12;
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
            dump();
        L12:
            this.mCallback.onConnected();
            Iterator<Map.Entry<String, f>> r12 = this.mSubscriptions.entrySet().iterator();     // Catch: RemoteException -> L21
        L15:
            if (r12.hasNext() == false) goto L27;
            Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: RemoteException -> L21
            String r14 = (String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: RemoteException -> L21
            f r15 = (f) ZeusTransformUtils.preCheckCast(r13.getValue(), f.class, "com.obric.aiagent.plugin");     // Catch: RemoteException -> L21
            List<SubscriptionCallback> r16 = r15.c();     // Catch: RemoteException -> L21
            List<Bundle> r17 = r15.b();     // Catch: RemoteException -> L21
            int r1 = 0;
        L18:
            if (r1 >= r16.size()) goto L15;
            this.mServiceBinderWrapper.a(r14, ((SubscriptionCallback) ZeusTransformUtils.preCheckCast(r16.get(r1), SubscriptionCallback.class, "com.obric.aiagent.plugin")).f56b, (Bundle) ZeusTransformUtils.preCheckCast(r17.get(r1), Bundle.class, "com.obric.aiagent.plugin"), this.mCallbacksMessenger);     // Catch: RemoteException -> L21
            r1 = r1 + 1;
            goto L18
        L27:
            return;
        L21:
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void onConnectionFailed(Messenger r3) {
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaBrowserCompat", "onConnectFailed for " + this.mServiceComponent);
            if (isCurrent(r3, "onConnectFailed") == true) goto L6;
            return;
        L6:
            if (this.mState == 2) goto L9;
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("MediaBrowserCompat", "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
            return;
        L9:
            forceCloseConnection();
            this.mCallback.onConnectionFailed();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void onLoadChildren(Messenger r4, String r5, List r6, Bundle r7, Bundle r8) {
            List<MediaItem> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            if (isCurrent(r4, "onLoadChildren") == true) goto L6;
            return;
        L6:
            if (MediaBrowserCompat.f6a == false) goto L8;
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("MediaBrowserCompat", "onLoadChildren for " + this.mServiceComponent + " id=" + r5);
        L8:
            f r10 = (f) ZeusTransformUtils.preCheckCast(this.mSubscriptions.get(r5), f.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L11;
            SubscriptionCallback r11 = r10.a(r7);
            if (r11 != null) goto L17;
            return;
        L17:
            if (r7 != null) goto L21;
            if (r9 != null) goto L20;
            r11.a(r5);
            return;
        L20:
            this.mNotifyChildrenChangedOptions = r8;
            r11.a(r5, r9);
            this.mNotifyChildrenChangedOptions = null;
            return;
        L21:
            if (r9 != null) goto L23;
            r11.a(r5, r7);
            return;
        L23:
            this.mNotifyChildrenChangedOptions = r8;
            r11.a(r5, r9, r7);
            this.mNotifyChildrenChangedOptions = null;
            return;
        L11:
            if (MediaBrowserCompat.f6a == false) goto L25;
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + r5);
            return;
        }

        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        private static String getStateLabel(int r2) {
            if (r2 != 0) goto L4;
            return "CONNECT_STATE_DISCONNECTING";
        L4:
            if (r2 != 1) goto L6;
            return "CONNECT_STATE_DISCONNECTED";
        L6:
            if (r2 != 2) goto L8;
            return "CONNECT_STATE_CONNECTING";
        L8:
            if (r2 != 3) goto L10;
            return "CONNECT_STATE_CONNECTED";
        L10:
            if (r2 != 4) goto L12;
            return "CONNECT_STATE_SUSPENDED";
        L12:
            return "UNKNOWN/" + r2;
        }

        private boolean isCurrent(Messenger r3, String r4) {
            if (this.mCallbacksMessenger != r3) goto L9;
            int r5 = this.mState;
            if (r5 == 0) goto L9;
            if (r5 == 1) goto L9;
            return true;
        L9:
            int r6 = this.mState;
            if (r6 == 0) goto L15;
            if (r6 == 1) goto L16;
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("MediaBrowserCompat", r4 + " for " + this.mServiceComponent + " with mCallbacksMessenger=" + this.mCallbacksMessenger + " this=" + this);
            return false;
        L16:
            return false;
        L15:
            return false;
        }

        void dump() {
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("MediaBrowserCompat", "MediaBrowserCompat...");
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("MediaBrowserCompat", "  mServiceComponent=" + this.mServiceComponent);
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("MediaBrowserCompat", "  mCallback=" + this.mCallback);
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("MediaBrowserCompat", "  mRootHints=" + this.mRootHints);
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("MediaBrowserCompat", "  mState=" + getStateLabel(this.mState));
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("MediaBrowserCompat", "  mServiceConnection=" + this.mServiceConnection);
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.mServiceBinderWrapper);
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.mCallbacksMessenger);
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("MediaBrowserCompat", "  mRootId=" + this.mRootId);
            INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("MediaBrowserCompat", "  mMediaSessionToken=" + this.mMediaSessionToken);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2, r3);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_android_support_v4_media_MediaBrowserCompat$MediaBrowserImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = null;
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public static MediaItem fromMediaItem(Object r2) {
            if (r2 != null) goto L4;
            return null;
        L4:
            if (Build.VERSION.SDK_INT < 21) goto L10;
            int r0 = MediaBrowserCompatApi21.b.a(r2);
            return new MediaItem(MediaDescriptionCompat.fromMediaDescription(MediaBrowserCompatApi21.b.b(r2)), r0);
        L10:
            return null;
        }

        public static List<MediaItem> fromMediaItemList(List<?> r2) {
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L5;
            return null;
        L5:
            if (Build.VERSION.SDK_INT < 21) goto L15;
            ArrayList r0 = new ArrayList(r3.size());
            Iterator r4 = r3.iterator();
        L9:
            if (r4.hasNext() == false) goto L11;
            r0.add(fromMediaItem(r4.next()));
            goto L9
        L11:
            return r0;
        L15:
            return null;
        }

        public MediaItem(MediaDescriptionCompat r2, int r3) {
            if (r2 == null) goto L11;
            if (TextUtils.isEmpty(r2.getMediaId()) == true) goto L9;
            this.mFlags = r3;
            this.mDescription = r2;
            return;
        L9:
            throw new IllegalArgumentException("description must have a non-empty media id");
        L11:
            throw new IllegalArgumentException("description cannot be null");
        }

        MediaItem(Parcel r3) {
            this.mFlags = r3.readInt();
            this.mDescription = (MediaDescriptionCompat) ZeusTransformUtils.preCheckCast(MediaDescriptionCompat.CREATOR.createFromParcel(r3), MediaDescriptionCompat.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            r2.writeInt(this.mFlags);
            this.mDescription.writeToParcel(r2, r3);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("MediaItem{");
            r0.append("mFlags=").append(this.mFlags);
            r0.append(", mDescription=").append(this.mDescription);
            r0.append('}');
            return r0.toString();
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public int getFlags() {
            return this.mFlags;
        }

        public boolean isBrowsable() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean isPlayable() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public String getMediaId() {
            return this.mDescription.getMediaId();
        }
    }

    private static class SearchResultReceiver extends ResultReceiver {
        private final d mCallback;
        private final Bundle mExtras;
        private final String mQuery;

        SearchResultReceiver(String r1, Bundle r2, d r3, Handler r4) {
            super(r4);
            this.mQuery = r1;
            this.mExtras = r2;
            this.mCallback = r3;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int r6, Bundle r7) {
            MediaSessionCompat.a(r7);
            if (r6 != 0) goto L15;
            if (r7 == null) goto L15;
            if (r7.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS) == false) goto L15;
            Parcelable[] r8 = r7.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
            ArrayList r9 = null;
            if (r8 == null) goto L13;
            r9 = new ArrayList();
            int r0 = r8.length;
            int r1 = 0;
        L11:
            if (r1 >= r0) goto L13;
            r9.add((MediaItem) ZeusTransformUtils.preCheckCast(r8[r1], MediaItem.class, "com.obric.aiagent.plugin"));
            r1 = r1 + 1;
        L13:
            this.mCallback.a(this.mQuery, this.mExtras, r9);
            return;
        L15:
            this.mCallback.a(this.mQuery, this.mExtras);
        }
    }

    public static abstract class SubscriptionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f55a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final IBinder f56b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        WeakReference<f> f57c;

        private class StubApi21 implements MediaBrowserCompatApi21.c {
            final /* synthetic */ SubscriptionCallback this$0;

            StubApi21(SubscriptionCallback r1) {
                this.this$0 = r1;
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.c
            public void onChildrenLoaded(String r8, List<?> r9) {
                List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
                if (this.this$0.f57c != null) goto L5;
                f r0 = null;
            L6:
                if (r0 != null) goto L8;
                this.this$0.a(r8, MediaItem.fromMediaItemList(r10));
                return;
            L8:
                List<MediaItem> r11 = MediaItem.fromMediaItemList(r10);
                List<SubscriptionCallback> r2 = r0.c();
                List<Bundle> r1 = r0.b();
                int r3 = 0;
            L10:
                if (r3 >= r2.size()) goto L20;
                Bundle r4 = (Bundle) ZeusTransformUtils.preCheckCast(r1.get(r3), Bundle.class, "com.obric.aiagent.plugin");
                if (r4 != null) goto L14;
                this.this$0.a(r8, r11);
            L15:
                r3 = r3 + 1;
                goto L10
            L14:
                this.this$0.a(r8, applyOptions(r11, r4), r4);
                goto L15
            L20:
                return;
            L5:
                r0 = (f) ZeusTransformUtils.preCheckCast(this.this$0.f57c.get(), f.class, "com.obric.aiagent.plugin");
                goto L6
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.c
            public void onError(String r1) {
                this.this$0.a(r1);
            }

            List<MediaItem> applyOptions(List<MediaItem> r3, Bundle r4) {
                List<MediaItem> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
                if (r2 != null) goto L6;
                return null;
            L6:
                int r5 = r4.getInt("android.media.browse.extra.PAGE", -1);
                int r6 = r4.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                if (r5 != (-1)) goto L10;
                if (r6 != (-1)) goto L10;
                return r2;
            L10:
                int r0 = r6 * r5;
                int r1 = r0 + r6;
                if (r5 < 0) goto L23;
                if (r6 < 1) goto L23;
                if (r0 >= r2.size()) goto L23;
                if (r1 <= r2.size()) goto L21;
                r1 = r2.size();
            L21:
                return r2.subList(r0, r1);
            L23:
                return Collections.emptyList();
            }
        }

        private class StubApi26 extends StubApi21 implements MediaBrowserCompatApi26.SubscriptionCallback {
            final /* synthetic */ SubscriptionCallback this$0;

            StubApi26(SubscriptionCallback r1) {
                this.this$0 = r1;
                super(r1);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            public void onChildrenLoaded(String r3, List<?> r4, Bundle r5) {
                List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
                this.this$0.a(r3, MediaItem.fromMediaItemList(r6), r5);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            public void onError(String r1, Bundle r2) {
                this.this$0.a(r1, r2);
            }
        }

        public void a(String r1) {
        }

        public void a(String r1, Bundle r2) {
        }

        public void a(String r1, List<MediaItem> r2) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        }

        public void a(String r1, List<MediaItem> r2, Bundle r3) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        }

        public SubscriptionCallback() {
            this.f56b = new Binder();
            if (Build.VERSION.SDK_INT < 26) goto L6;
            this.f55a = MediaBrowserCompatApi26.a(new StubApi26(this));
            return;
        L6:
            if (Build.VERSION.SDK_INT < 21) goto L8;
            this.f55a = MediaBrowserCompatApi21.a(new StubApi21(this));
            return;
        L8:
            this.f55a = null;
        }

        void a(f r2) {
            this.f57c = new WeakReference(r2);
        }
    }

    public static abstract class a {
        public void a(String r1, Bundle r2, Bundle r3) {
        }

        public void b(String r1, Bundle r2, Bundle r3) {
        }

        public void c(String r1, Bundle r2, Bundle r3) {
        }
    }

    interface b {
        void connect();

        void disconnect();

        MediaSessionCompat.Token getSessionToken();
    }

    interface c {
        void onConnectionFailed(Messenger r1);

        void onLoadChildren(Messenger r1, String r2, List r3, Bundle r4, Bundle r5);

        void onServiceConnected(Messenger r1, String r2, MediaSessionCompat.Token r3, Bundle r4);
    }

    public static abstract class d {
        public void a(String r1, Bundle r2) {
        }

        public void a(String r1, Bundle r2, List<MediaItem> r3) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Messenger f58a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bundle f59b;

        public e(IBinder r3, Bundle r4) {
            this.f58a = new Messenger((IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin"));
            this.f59b = r4;
        }

        void a(Context r3, Messenger r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            Bundle r0 = new Bundle();
            r0.putString("data_package_name", r5.getPackageName());
            r0.putBundle("data_root_hints", this.f59b);
            a(1, r0, r4);
        }

        void a(Messenger r3) {
            a(2, null, r3);
        }

        void a(String r3, IBinder r4, Bundle r5, Messenger r6) {
            IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin");
            Bundle r0 = new Bundle();
            r0.putString("data_media_item_id", r3);
            androidx.core.app.d.a(r0, "data_callback_token", r7);
            r0.putBundle("data_options", r5);
            a(3, r0, r6);
        }

        void a(String r3, IBinder r4, Messenger r5) {
            IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin");
            Bundle r0 = new Bundle();
            r0.putString("data_media_item_id", r3);
            androidx.core.app.d.a(r0, "data_callback_token", r6);
            a(4, r0, r5);
        }

        void a(String r3, ResultReceiver r4, Messenger r5) {
            Bundle r0 = new Bundle();
            r0.putString("data_media_item_id", r3);
            r0.putParcelable("data_result_receiver", r4);
            a(5, r0, r5);
        }

        void b(Context r3, Messenger r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            Bundle r0 = new Bundle();
            r0.putString("data_package_name", r5.getPackageName());
            r0.putBundle("data_root_hints", this.f59b);
            a(6, r0, r4);
        }

        void b(Messenger r3) {
            a(7, null, r3);
        }

        void a(String r3, Bundle r4, ResultReceiver r5, Messenger r6) {
            Bundle r0 = new Bundle();
            r0.putString("data_search_query", r3);
            r0.putBundle("data_search_extras", r4);
            r0.putParcelable("data_result_receiver", r5);
            a(8, r0, r6);
        }

        void b(String r3, Bundle r4, ResultReceiver r5, Messenger r6) {
            Bundle r0 = new Bundle();
            r0.putString("data_custom_action", r3);
            r0.putBundle("data_custom_action_extras", r4);
            r0.putParcelable("data_result_receiver", r5);
            a(9, r0, r6);
        }

        private void a(int r2, Bundle r3, Messenger r4) {
            Message r0 = Message.obtain();
            r0.what = r2;
            r0.arg1 = 1;
            r0.setData(r3);
            r0.replyTo = r4;
            this.f58a.send(r0);
        }
    }

    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<SubscriptionCallback> f60a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<Bundle> f61b;

        public f() {
            this.f60a = new ArrayList();
            this.f61b = new ArrayList();
        }

        public boolean a() {
            return this.f60a.isEmpty();
        }

        public List<Bundle> b() {
            return this.f61b;
        }

        public List<SubscriptionCallback> c() {
            return this.f60a;
        }

        public SubscriptionCallback a(Bundle r5) {
            int r0 = 0;
        L4:
            if (r0 >= this.f61b.size()) goto L10;
            if (androidx.media.a.a((Bundle) ZeusTransformUtils.preCheckCast(this.f61b.get(r0), Bundle.class, "com.obric.aiagent.plugin"), r5) == true) goto L8;
            r0 = r0 + 1;
            goto L4
        L8:
            return (SubscriptionCallback) ZeusTransformUtils.preCheckCast(this.f60a.get(r0), SubscriptionCallback.class, "com.obric.aiagent.plugin");
        L10:
            return null;
        }

        public void a(Bundle r5, SubscriptionCallback r6) {
            int r0 = 0;
        L4:
            if (r0 >= this.f61b.size()) goto L10;
            if (androidx.media.a.a((Bundle) ZeusTransformUtils.preCheckCast(this.f61b.get(r0), Bundle.class, "com.obric.aiagent.plugin"), r5) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            this.f60a.set(r0, r6);
            return;
        L10:
            this.f60a.add(r6);
            this.f61b.add(r5);
        }
    }

    static {
        f6a = a("MediaBrowserCompat", 3);
    }

    public MediaBrowserCompat(Context r3, ComponentName r4, ConnectionCallback r5, Bundle r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L6;
        this.f7b = new MediaBrowserImplApi26(r7, r4, r5, r6);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        this.f7b = new MediaBrowserImplApi23(r7, r4, r5, r6);
        return;
    L9:
        if (Build.VERSION.SDK_INT < 21) goto L11;
        this.f7b = new MediaBrowserImplApi21(r7, r4, r5, r6);
        return;
    L11:
        this.f7b = new MediaBrowserImplBase(r7, r4, r5, r6);
    }

    public void a() {
        this.f7b.connect();
    }

    public void b() {
        this.f7b.disconnect();
    }

    public MediaSessionCompat.Token c() {
        return this.f7b.getSessionToken();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }
}
