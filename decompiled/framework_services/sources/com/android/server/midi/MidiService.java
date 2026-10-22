package com.android.server.midi;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothUuid;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.media.MediaMetrics;
import android.media.midi.IMidiDeviceListener;
import android.media.midi.IMidiDeviceOpenCallback;
import android.media.midi.IMidiDeviceServer;
import android.media.midi.IMidiManager;
import android.media.midi.MidiDevice;
import android.media.midi.MidiDeviceInfo;
import android.media.midi.MidiDeviceStatus;
import android.media.midi.MidiManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.EventLog;
import android.util.Log;
import android.util.Slog;
import com.android.internal.content.PackageMonitor;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.SystemService;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class MidiService extends IMidiManager.Stub {
    private static final MidiDeviceInfo[] EMPTY_DEVICE_INFO_ARRAY = null;
    private static final String[] EMPTY_STRING_ARRAY = null;
    private static final int MAX_CONNECTIONS_PER_CLIENT = 64;
    private static final int MAX_DEVICE_SERVERS_PER_UID = 16;
    private static final int MAX_LISTENERS_PER_CLIENT = 16;
    private static final String MIDI_LEGACY_STRING = "MIDI 1.0";
    private static final UUID MIDI_SERVICE = null;
    private static final String MIDI_UNIVERSAL_STRING = "MIDI 2.0";
    private static final String TAG = "MidiService";
    private final HashMap<BluetoothDevice, MidiDevice> mBleMidiDeviceMap;
    private final BroadcastReceiver mBleMidiReceiver;
    private final HashMap<BluetoothDevice, Device> mBluetoothDevices;
    private int mBluetoothServiceUid;
    private final HashMap<IBinder, Client> mClients;
    private final Context mContext;
    private final HashMap<MidiDeviceInfo, Device> mDevicesByInfo;
    private final HashMap<IBinder, Device> mDevicesByServer;
    private int mNextDeviceId;
    private final HashSet<ParcelUuid> mNonMidiUUIDs;
    private final PackageManager mPackageManager;
    private final PackageMonitor mPackageMonitor;
    private final HashMap<String, Integer> mUsbMidiLegacyDeviceOpenCount;
    private final Object mUsbMidiLock;
    private final HashSet<String> mUsbMidiUniversalDeviceInUse;
    private final UserManager mUserManager;

    private final class Client implements IBinder.DeathRecipient {
        private static final String TAG = "MidiService.Client";
        private final HashMap<IBinder, DeviceConnection> mDeviceConnections;
        private final HashMap<IBinder, IMidiDeviceListener> mListeners;
        private final int mPid;
        private final IBinder mToken;
        private final int mUid;
        final /* synthetic */ MidiService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m5918$$Nest$fgetmUid(Client r0) {
            return r0.mUid;
        }

        public Client(MidiService r1, IBinder token) {
            this.this$0 = r1;
            this.mListeners = new HashMap();
            this.mDeviceConnections = new HashMap();
            this.mToken = token;
            this.mUid = Binder.getCallingUid();
            this.mPid = Binder.getCallingPid();
        }

        public int getUid() {
            return this.mUid;
        }

        private int getUserId() {
            return UserHandle.getUserId(this.mUid);
        }

        public void addListener(IMidiDeviceListener listener) {
            if (this.mListeners.size() >= 16) goto L7;
            this.mListeners.put(listener.asBinder(), listener);
            return;
        L7:
            throw new SecurityException("too many MIDI listeners for UID = " + this.mUid);
        }

        public void removeListener(IMidiDeviceListener listener) {
            this.mListeners.remove(listener.asBinder());
            if (this.mListeners.size() == 0) goto L5;
            return;
        L5:
            if (this.mDeviceConnections.size() != 0) goto L9;
            close();
            return;
        }

        public void addDeviceConnection(Device device, IMidiDeviceOpenCallback callback, int userId) {
            Log.d(TAG, "addDeviceConnection() device:" + device + " userId:" + userId);
            if (this.mDeviceConnections.size() >= 64) goto L6;
            DeviceConnection connection = new DeviceConnection(this.this$0, device, this, callback);
            this.mDeviceConnections.put(connection.getToken(), connection);
            device.addDeviceConnection(connection, userId);
            return;
        L6:
            Log.i(TAG, "too many MIDI connections for UID = " + this.mUid);
            throw new SecurityException("too many MIDI connections for UID = " + this.mUid);
        }

        public void removeDeviceConnection(IBinder token) {
            DeviceConnection connection = this.mDeviceConnections.remove(token);
            if (connection == null) goto L6;
            connection.getDevice().removeDeviceConnection(connection);
        L6:
            if (this.mListeners.size() == 0) goto L8;
            return;
        L8:
            if (this.mDeviceConnections.size() != 0) goto L12;
            close();
            return;
        }

        public void removeDeviceConnection(DeviceConnection connection) {
            this.mDeviceConnections.remove(connection.getToken());
            if (this.mListeners.size() == 0) goto L5;
            return;
        L5:
            if (this.mDeviceConnections.size() != 0) goto L9;
            close();
            return;
        }

        public void deviceAdded(Device device) {
            Log.d(TAG, "deviceAdded() " + device.getUserId() + " userId:" + getUserId());
            if (device.isUidAllowed(this.mUid) == true) goto L5;
            return;
        L5:
            if (device.isUserIdAllowed(getUserId()) == false) goto L24;
            MidiDeviceInfo deviceInfo = device.getDeviceInfo();
            Iterator<IMidiDeviceListener> r2 = this.mListeners.values().iterator();     // Catch: RemoteException -> L13
        L10:
            if (r2.hasNext() == false) goto L23;
            IMidiDeviceListener listener = r2.next();     // Catch: RemoteException -> L13
            listener.onDeviceAdded(deviceInfo);     // Catch: RemoteException -> L13
            goto L10
        L23:
            return;
        L13:
            e = move-exception;
            Log.e(TAG, "remote exception", e);
            return;
        }

        public void deviceRemoved(Device device) {
            Log.d(TAG, "deviceRemoved() " + device.getUserId() + " userId:" + getUserId());
            if (device.isUidAllowed(this.mUid) == true) goto L5;
            return;
        L5:
            if (device.isUserIdAllowed(getUserId()) == false) goto L24;
            MidiDeviceInfo deviceInfo = device.getDeviceInfo();
            Iterator<IMidiDeviceListener> r2 = this.mListeners.values().iterator();     // Catch: RemoteException -> L13
        L10:
            if (r2.hasNext() == false) goto L23;
            IMidiDeviceListener listener = r2.next();     // Catch: RemoteException -> L13
            listener.onDeviceRemoved(deviceInfo);     // Catch: RemoteException -> L13
            goto L10
        L23:
            return;
        L13:
            e = move-exception;
            Log.e(TAG, "remote exception", e);
            return;
        }

        public void deviceStatusChanged(Device device, MidiDeviceStatus status) {
            Log.d(TAG, "deviceStatusChanged() " + device.getUserId() + " userId:" + getUserId());
            if (device.isUidAllowed(this.mUid) == true) goto L5;
            return;
        L5:
            if (device.isUserIdAllowed(getUserId()) == false) goto L23;
            Iterator<IMidiDeviceListener> r0 = this.mListeners.values().iterator();     // Catch: RemoteException -> L12
        L9:
            if (r0.hasNext() == false) goto L22;
            IMidiDeviceListener listener = r0.next();     // Catch: RemoteException -> L12
            listener.onDeviceStatusChanged(status);     // Catch: RemoteException -> L12
            goto L9
        L22:
            return;
        L12:
            e = move-exception;
            Log.e(TAG, "remote exception", e);
            return;
        }

        private void close() {
            HashMap r0 = MidiService.m5901$$Nest$fgetmClients(this.this$0);
            monitor-enter(r0);
            MidiService.m5901$$Nest$fgetmClients(this.this$0).remove(this.mToken);     // Catch: Throwable -> L11
            this.mToken.unlinkToDeath(this, 0);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            Iterator<DeviceConnection> r1 = this.mDeviceConnections.values().iterator();
        L8:
            if (r1.hasNext() == false) goto L10;
            DeviceConnection connection = r1.next();
            connection.getDevice().removeDeviceConnection(connection);
            goto L8
        L10:
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Log.d(TAG, "Client died: " + this);
            close();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Client: UID: ");
            sb.append(this.mUid);
            sb.append(" PID: ");
            sb.append(this.mPid);
            sb.append(" listener count: ");
            sb.append(this.mListeners.size());
            sb.append(" Device Connections:");
            Iterator<DeviceConnection> r1 = this.mDeviceConnections.values().iterator();
        L4:
            if (r1.hasNext() == false) goto L7;
            DeviceConnection connection = r1.next();
            sb.append(" <device ");
            sb.append(connection.getDevice().getDeviceInfo().getId());
            sb.append(">");
            goto L4
        L7:
            return sb.toString();
        }
    }

    private final class Device implements IBinder.DeathRecipient {
        private static final String TAG = "MidiService.Device";
        private final BluetoothDevice mBluetoothDevice;
        private final ArrayList<DeviceConnection> mDeviceConnections;
        private AtomicInteger mDeviceConnectionsAdded;
        private AtomicInteger mDeviceConnectionsRemoved;
        private MidiDeviceInfo mDeviceInfo;
        private MidiDeviceStatus mDeviceStatus;
        private Instant mPreviousCounterInstant;
        private IMidiDeviceServer mServer;
        private ServiceConnection mServiceConnection;
        private final ServiceInfo mServiceInfo;
        private AtomicInteger mTotalInputBytes;
        private AtomicInteger mTotalOutputBytes;
        private AtomicLong mTotalTimeConnectedNs;
        private final int mUid;
        private final int mUserId;
        final /* synthetic */ MidiService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmBluetoothDevice, reason: not valid java name */
        static /* bridge */ /* synthetic */ BluetoothDevice m5919$$Nest$fgetmBluetoothDevice(Device r0) {
            return r0.mBluetoothDevice;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmServiceConnection, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5920$$Nest$fputmServiceConnection(Device r0, ServiceConnection r1) {
            r0.mServiceConnection = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$msetDeviceServer, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5921$$Nest$msetDeviceServer(Device r0, IMidiDeviceServer r1) {
            r0.setDeviceServer(r1);
        }

        public Device(MidiService r3, IMidiDeviceServer server, MidiDeviceInfo deviceInfo, ServiceInfo serviceInfo, int uid, int userId) {
            this.this$0 = r3;
            this.mDeviceConnections = new ArrayList();
            this.mDeviceConnectionsAdded = new AtomicInteger();
            this.mDeviceConnectionsRemoved = new AtomicInteger();
            this.mTotalTimeConnectedNs = new AtomicLong();
            this.mPreviousCounterInstant = null;
            this.mTotalInputBytes = new AtomicInteger();
            this.mTotalOutputBytes = new AtomicInteger();
            this.mDeviceInfo = deviceInfo;
            this.mServiceInfo = serviceInfo;
            this.mUid = uid;
            this.mUserId = userId;
            this.mBluetoothDevice = (BluetoothDevice) deviceInfo.getProperties().getParcelable("bluetooth_device", BluetoothDevice.class);
            setDeviceServer(server);
        }

        public Device(MidiService r3, BluetoothDevice bluetoothDevice) {
            this.this$0 = r3;
            this.mDeviceConnections = new ArrayList();
            this.mDeviceConnectionsAdded = new AtomicInteger();
            this.mDeviceConnectionsRemoved = new AtomicInteger();
            this.mTotalTimeConnectedNs = new AtomicLong();
            this.mPreviousCounterInstant = null;
            this.mTotalInputBytes = new AtomicInteger();
            this.mTotalOutputBytes = new AtomicInteger();
            this.mBluetoothDevice = bluetoothDevice;
            this.mServiceInfo = null;
            this.mUid = MidiService.m5900$$Nest$fgetmBluetoothServiceUid(r3);
            this.mUserId = UserHandle.getUserId(this.mUid);
        }

        private void setDeviceServer(IMidiDeviceServer server) {
            Log.i(TAG, "setDeviceServer()");
            if (server == null) goto L16;
            if (this.mServer == null) goto L8;
            Log.e(TAG, "mServer already set in setDeviceServer");
            return;
        L8:
            IBinder binder = server.asBinder();
            binder.linkToDeath(this, 0);     // Catch: RemoteException -> L12
            this.mServer = server;     // Catch: RemoteException -> L12
            MidiService.m5904$$Nest$fgetmDevicesByServer(this.this$0).put(binder, this);
        L22:
            if (this.mDeviceConnections == null) goto L35;
            ArrayList<DeviceConnection> r0 = this.mDeviceConnections;
            monitor-enter(r0);
            Iterator<DeviceConnection> r1 = this.mDeviceConnections.iterator();     // Catch: Throwable -> L29
        L27:
            if (r1.hasNext() == false) goto L31;
            DeviceConnection connection = r1.next();     // Catch: Throwable -> L29
            connection.notifyClient(server);     // Catch: Throwable -> L29
            goto L27
        L31:
            monitor-exit(r0);     // Catch: Throwable -> L29
            return;
        L29:
            th = move-exception;
            throw th;
        L35:
            return;
        L13:
            this.mServer = null;
            return;
        L16:
            if (this.mServer == null) goto L22;
            server = this.mServer;
            this.mServer = null;
            IBinder binder2 = server.asBinder();
            MidiService.m5904$$Nest$fgetmDevicesByServer(this.this$0).remove(binder2);
            this.mDeviceStatus = null;
            server.closeDevice();     // Catch: RemoteException -> L20
            binder2.unlinkToDeath(this, 0);     // Catch: RemoteException -> L20
            goto L22
        }

        public MidiDeviceInfo getDeviceInfo() {
            return this.mDeviceInfo;
        }

        public void setDeviceInfo(MidiDeviceInfo deviceInfo) {
            this.mDeviceInfo = deviceInfo;
        }

        public MidiDeviceStatus getDeviceStatus() {
            return this.mDeviceStatus;
        }

        public void setDeviceStatus(MidiDeviceStatus status) {
            this.mDeviceStatus = status;
        }

        public IMidiDeviceServer getDeviceServer() {
            return this.mServer;
        }

        public ServiceInfo getServiceInfo() {
            return this.mServiceInfo;
        }

        public String getPackageName() {
            if (this.mServiceInfo != null) goto L6;
            return null;
        L6:
            return this.mServiceInfo.packageName;
        }

        public int getUid() {
            return this.mUid;
        }

        public int getUserId() {
            return this.mUserId;
        }

        public boolean isUidAllowed(int uid) {
            if (this.mDeviceInfo.isPrivate() == true) goto L5;
        L8:
            return true;
        L5:
            if (this.mUid == uid) goto L8;
            return false;
        }

        public boolean isUserIdAllowed(int userId) {
            if (this.mDeviceInfo.getType() == 2) goto L5;
        L8:
            return true;
        L5:
            if (this.mUserId == userId) goto L8;
            return false;
        }

        public void addDeviceConnection(DeviceConnection connection, int userId) {
            Log.d(TAG, "addDeviceConnection() [A] connection:" + connection);
            ArrayList<DeviceConnection> r0 = this.mDeviceConnections;
            monitor-enter(r0);
            this.mDeviceConnectionsAdded.incrementAndGet();     // Catch: Throwable -> L7
            if (this.mPreviousCounterInstant != null) goto L9;
            this.mPreviousCounterInstant = Instant.now();     // Catch: Throwable -> L7
        L9:
            Log.d(TAG, "  mServer:" + this.mServer);     // Catch: Throwable -> L7
            if (this.mServer == null) goto L13;
            Log.i(TAG, "++++ A");     // Catch: Throwable -> L7
            this.mDeviceConnections.add(connection);     // Catch: Throwable -> L7
            connection.notifyClient(this.mServer);     // Catch: Throwable -> L7
        L30:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L13:
            if (this.mServiceConnection == null) goto L15;
        L29:
            Log.e(TAG, "No way to connect to device in addDeviceConnection");     // Catch: Throwable -> L7
            connection.notifyClient(null);     // Catch: Throwable -> L7
            goto L30
        L15:
            if (this.mServiceInfo == null) goto L17;
        L18:
            Log.i(TAG, "++++ B");     // Catch: Throwable -> L7
            this.mDeviceConnections.add(connection);     // Catch: Throwable -> L7
            this.mServiceConnection = new AnonymousClass1(this);     // Catch: Throwable -> L7
            if (this.mBluetoothDevice == null) goto L22;
            Intent intent = new Intent("android.media.midi.BluetoothMidiService");     // Catch: Throwable -> L7
            intent.setComponent(new ComponentName("com.android.bluetoothmidiservice", "com.android.bluetoothmidiservice.BluetoothMidiService"));     // Catch: Throwable -> L7
        L26:
            if (MidiService.m5902$$Nest$fgetmContext(this.this$0).bindServiceAsUser(intent, this.mServiceConnection, 1, UserHandle.of(this.mUserId)) == true) goto L30;
            Log.e(TAG, "Unable to bind service: " + intent);     // Catch: Throwable -> L7
            setDeviceServer(null);     // Catch: Throwable -> L7
            this.mServiceConnection = null;     // Catch: Throwable -> L7
            goto L30
        L22:
            if (MidiService.m5911$$Nest$misUmpDevice(this.this$0, this.mDeviceInfo) == true) goto L24;
            intent = new Intent("android.media.midi.MidiDeviceService");     // Catch: Throwable -> L7
            intent.setComponent(new ComponentName(this.mServiceInfo.packageName, this.mServiceInfo.name));     // Catch: Throwable -> L7
            goto L26
        L24:
            intent = new Intent("android.media.midi.MidiUmpDeviceService");     // Catch: Throwable -> L7
            intent.setComponent(new ComponentName(this.mServiceInfo.packageName, this.mServiceInfo.name));     // Catch: Throwable -> L7
            goto L26
        L17:
            if (this.mBluetoothDevice == null) goto L29;
        L7:
            th = move-exception;
            throw th;
        }

        public void removeDeviceConnection(DeviceConnection connection) {
            HashMap r0 = MidiService.m5903$$Nest$fgetmDevicesByInfo(this.this$0);
            monitor-enter(r0);
            ArrayList<DeviceConnection> r1 = this.mDeviceConnections;     // Catch: Throwable -> L36
            monitor-enter(r1);     // Catch: Throwable -> L36
            int numRemovedConnections = this.mDeviceConnectionsRemoved.incrementAndGet();     // Catch: Throwable -> L9
            if (this.mPreviousCounterInstant == null) goto L12;
            this.mTotalTimeConnectedNs.addAndGet(Duration.between(this.mPreviousCounterInstant, Instant.now()).toNanos());     // Catch: Throwable -> L9
        L12:
            if (numRemovedConnections < this.mDeviceConnectionsAdded.get()) goto L14;
            this.mPreviousCounterInstant = null;     // Catch: Throwable -> L9
        L15:
            logMetrics(false);     // Catch: Throwable -> L9
            this.mDeviceConnections.remove(connection);     // Catch: Throwable -> L9
            if (connection.getDevice().getDeviceInfo().getType() != 1) goto L26;
            Object r3 = MidiService.m5905$$Nest$fgetmUsbMidiLock(this.this$0);     // Catch: Throwable -> L9
            monitor-enter(r3);     // Catch: Throwable -> L9
            this.this$0.removeUsbMidiDeviceLocked(connection.getDevice().getDeviceInfo());     // Catch: Throwable -> L22
            monitor-exit(r3);     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            throw th;     // Catch: Throwable -> L9
        L26:
            if (this.mDeviceConnections.size() == 0) goto L28;
        L33:
            monitor-exit(r1);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L36
            return;
        L28:
            if (this.mServiceConnection == null) goto L33;
            MidiService.m5902$$Nest$fgetmContext(this.this$0).unbindService(this.mServiceConnection);     // Catch: Throwable -> L9
            this.mServiceConnection = null;     // Catch: Throwable -> L9
            if (this.mBluetoothDevice == null) goto L32;
            closeLocked();     // Catch: Throwable -> L9
            goto L33
        L32:
            setDeviceServer(null);     // Catch: Throwable -> L9
            goto L33
        L14:
            this.mPreviousCounterInstant = Instant.now();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            throw th;
        }

        public void closeLocked() {
            ArrayList<DeviceConnection> r0 = this.mDeviceConnections;
            monitor-enter(r0);
            Iterator<DeviceConnection> r1 = this.mDeviceConnections.iterator();     // Catch: Throwable -> L17
        L6:
            if (r1.hasNext() == false) goto L20;
            DeviceConnection connection = r1.next();     // Catch: Throwable -> L17
            if (connection.getDevice().getDeviceInfo().getType() != 1) goto L19;
            Object r3 = MidiService.m5905$$Nest$fgetmUsbMidiLock(this.this$0);     // Catch: Throwable -> L17
            monitor-enter(r3);     // Catch: Throwable -> L17
            this.this$0.removeUsbMidiDeviceLocked(connection.getDevice().getDeviceInfo());     // Catch: Throwable -> L14
            monitor-exit(r3);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17
        L19:
            connection.getClient().removeDeviceConnection(connection);     // Catch: Throwable -> L17
            goto L6
        L20:
            this.mDeviceConnections.clear();     // Catch: Throwable -> L17
            if (this.mPreviousCounterInstant == null) goto L23;
            Instant currentInstant = Instant.now();     // Catch: Throwable -> L17
            this.mTotalTimeConnectedNs.addAndGet(Duration.between(this.mPreviousCounterInstant, currentInstant).toNanos());     // Catch: Throwable -> L17
            this.mPreviousCounterInstant = currentInstant;     // Catch: Throwable -> L17
        L23:
            logMetrics(true);     // Catch: Throwable -> L17
            monitor-exit(r0);     // Catch: Throwable -> L17
            setDeviceServer(null);
            if (this.mServiceInfo != null) goto L28;
            MidiService.m5914$$Nest$mremoveDeviceLocked(this.this$0, this);
        L30:
            if (this.mBluetoothDevice == null) goto L41;
            MidiService.m5899$$Nest$fgetmBluetoothDevices(this.this$0).remove(this.mBluetoothDevice);
            return;
        L41:
            return;
        L28:
            this.mDeviceStatus = new MidiDeviceStatus(this.mDeviceInfo);
        L17:
            th = move-exception;
            throw th;
        }

        private void logMetrics(boolean isDeviceDisconnected) {
            int numDeviceConnectionAdded = this.mDeviceConnectionsAdded.get();
            if (this.mDeviceInfo == null) goto L23;
            if (numDeviceConnectionAdded <= 0) goto L24;
            MediaMetrics.Item r1 = new MediaMetrics.Item("audio.midi").setUid(this.mUid).set(MediaMetrics.Property.DEVICE_ID, Integer.valueOf(this.mDeviceInfo.getId())).set(MediaMetrics.Property.INPUT_PORT_COUNT, Integer.valueOf(this.mDeviceInfo.getInputPortCount())).set(MediaMetrics.Property.OUTPUT_PORT_COUNT, Integer.valueOf(this.mDeviceInfo.getOutputPortCount())).set(MediaMetrics.Property.HARDWARE_TYPE, Integer.valueOf(this.mDeviceInfo.getType())).set(MediaMetrics.Property.DURATION_NS, Long.valueOf(this.mTotalTimeConnectedNs.get())).set(MediaMetrics.Property.OPENED_COUNT, Integer.valueOf(numDeviceConnectionAdded)).set(MediaMetrics.Property.CLOSED_COUNT, Integer.valueOf(this.mDeviceConnectionsRemoved.get()));
            MediaMetrics.Key r2 = MediaMetrics.Property.DEVICE_DISCONNECTED;
            String r3 = "false";
            if (isDeviceDisconnected == false) goto L8;
            Object r5 = "true";
        L9:
            MediaMetrics.Item r4 = r1.set(r2, r5);
            MediaMetrics.Key r6 = MediaMetrics.Property.IS_SHARED;
            if (this.mDeviceInfo.isPrivate() == true) goto L12;
            Object r7 = "true";
        L13:
            MediaMetrics.Item r8 = r4.set(r6, r7);
            MediaMetrics.Key r9 = MediaMetrics.Property.SUPPORTS_MIDI_UMP;
            if (MidiService.m5911$$Nest$misUmpDevice(this.this$0, this.mDeviceInfo) == false) goto L16;
            Object r10 = "true";
        L17:
            MediaMetrics.Item r11 = r8.set(r9, r10);
            MediaMetrics.Key r12 = MediaMetrics.Property.USING_ALSA;
            if (this.mDeviceInfo.getProperties().get("alsa_card") == null) goto L21;
            r3 = "true";
        L21:
            r11.set(r12, r3).set(MediaMetrics.Property.EVENT, "deviceClosed").set(MediaMetrics.Property.TOTAL_INPUT_BYTES, Integer.valueOf(this.mTotalInputBytes.get())).set(MediaMetrics.Property.TOTAL_OUTPUT_BYTES, Integer.valueOf(this.mTotalOutputBytes.get())).record();
            return;
        L16:
            r10 = "false";
            goto L17
        L12:
            r7 = "false";
            goto L13
        L8:
            r5 = "false";
            goto L9
        L24:
            return;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Log.d(TAG, "Device died: " + this);
            HashMap r0 = MidiService.m5903$$Nest$fgetmDevicesByInfo(this.this$0);
            monitor-enter(r0);
            closeLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void updateTotalBytes(int totalInputBytes, int totalOutputBytes) {
            this.mTotalInputBytes.set(totalInputBytes);
            this.mTotalOutputBytes.set(totalOutputBytes);
        }

        public String toString() {
            return "Device Info: " + this.mDeviceInfo + " Status: " + this.mDeviceStatus + " UID: " + this.mUid + " DeviceConnection count: " + this.mDeviceConnections.size() + " mServiceConnection: " + this.mServiceConnection;
        }
    }

    private final class DeviceConnection {
        private static final String TAG = "MidiService.DeviceConnection";
        private IMidiDeviceOpenCallback mCallback;
        private final Client mClient;
        private final Device mDevice;
        private final IBinder mToken;

        public DeviceConnection(MidiService r1, Device device, Client client, IMidiDeviceOpenCallback callback) {
            this.mToken = new Binder();
            this.mDevice = device;
            this.mClient = client;
            this.mCallback = callback;
        }

        public Device getDevice() {
            return this.mDevice;
        }

        public Client getClient() {
            return this.mClient;
        }

        public IBinder getToken() {
            return this.mToken;
        }

        public void notifyClient(IMidiDeviceServer deviceServer) {
            Log.d(TAG, "notifyClient");
            if (this.mCallback != null) goto L14;
            return;
        L14:
            IMidiDeviceOpenCallback r1 = this.mCallback;     // Catch: RemoteException -> L11
            if (deviceServer != null) goto L8;
            IBinder r2 = null;
        L9:
            r1.onDeviceOpened(deviceServer, r2);     // Catch: RemoteException -> L11
            goto L12
        L8:
            r2 = this.mToken;     // Catch: RemoteException -> L11
        L12:
            this.mCallback = null;
        }

        public String toString() {
            if (this.mDevice != null) goto L5;
        L7:
            return "null";
        L5:
            if (this.mDevice.getDeviceInfo() == null) goto L7;
            return "" + this.mDevice.getDeviceInfo().getId();
        }
    }

    public static class Lifecycle extends SystemService {
        private MidiService mMidiService;

        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            this.mMidiService = new MidiService(getContext());
            publishBinderService("midi", this.mMidiService);
        }

        @Override // com.android.server.SystemService
        public void onUserStarting(SystemService.TargetUser user) {
            MidiService.m5912$$Nest$monStartOrUnlockUser(this.mMidiService, user, false);
        }

        @Override // com.android.server.SystemService
        public void onUserUnlocking(SystemService.TargetUser user) {
            MidiService.m5912$$Nest$monStartOrUnlockUser(this.mMidiService, user, true);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBleMidiDeviceMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m5898$$Nest$fgetmBleMidiDeviceMap(MidiService r0) {
        return r0.mBleMidiDeviceMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBluetoothDevices, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m5899$$Nest$fgetmBluetoothDevices(MidiService r0) {
        return r0.mBluetoothDevices;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBluetoothServiceUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5900$$Nest$fgetmBluetoothServiceUid(MidiService r0) {
        return r0.mBluetoothServiceUid;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClients, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m5901$$Nest$fgetmClients(MidiService r0) {
        return r0.mClients;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m5902$$Nest$fgetmContext(MidiService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDevicesByInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m5903$$Nest$fgetmDevicesByInfo(MidiService r0) {
        return r0.mDevicesByInfo;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDevicesByServer, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m5904$$Nest$fgetmDevicesByServer(MidiService r0) {
        return r0.mDevicesByServer;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUsbMidiLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m5905$$Nest$fgetmUsbMidiLock(MidiService r0) {
        return r0.mUsbMidiLock;
    }

    /* JADX INFO: renamed from: -$$Nest$maddPackageDeviceServers, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5906$$Nest$maddPackageDeviceServers(MidiService r0, String r1, int r2) {
        r0.addPackageDeviceServers(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mcloseBluetoothDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5907$$Nest$mcloseBluetoothDevice(MidiService r0, BluetoothDevice r1) {
        r0.closeBluetoothDevice(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpUuids, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5908$$Nest$mdumpUuids(MidiService r0, BluetoothDevice r1) {
        r0.dumpUuids(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhasNonMidiUuids, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5909$$Nest$mhasNonMidiUuids(MidiService r0, BluetoothDevice r1) {
        return r0.hasNonMidiUuids(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misBLEMIDIDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5910$$Nest$misBLEMIDIDevice(MidiService r0, BluetoothDevice r1) {
        return r0.isBLEMIDIDevice(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misUmpDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5911$$Nest$misUmpDevice(MidiService r0, MidiDeviceInfo r1) {
        return r0.isUmpDevice(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monStartOrUnlockUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5912$$Nest$monStartOrUnlockUser(MidiService r0, SystemService.TargetUser r1, boolean r2) {
        r0.onStartOrUnlockUser(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mopenBluetoothDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5913$$Nest$mopenBluetoothDevice(MidiService r0, BluetoothDevice r1) {
        r0.openBluetoothDevice(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveDeviceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5914$$Nest$mremoveDeviceLocked(MidiService r0, Device r1) {
        r0.removeDeviceLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremovePackageDeviceServers, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5915$$Nest$mremovePackageDeviceServers(MidiService r0, String r1, int r2) {
        r0.removePackageDeviceServers(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smdumpIntentExtras, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5916$$Nest$smdumpIntentExtras(Intent r0) {
        dumpIntentExtras(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisBleTransport, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5917$$Nest$smisBleTransport(Intent r0) {
        return isBleTransport(r0);
    }

    static {
        MIDI_SERVICE = UUID.fromString("03B80E5A-EDE8-4B33-A751-6CE34EC4C700");
        EMPTY_DEVICE_INFO_ARRAY = new MidiDeviceInfo[0];
        EMPTY_STRING_ARRAY = new String[0];
    }

    private Client getClient(IBinder token) {
        HashMap<IBinder, Client> r0 = this.mClients;
        monitor-enter(r0);
        Client client = this.mClients.get(token);     // Catch: Throwable -> L10
        if (client == null) goto L7;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return client;
    L7:
        client = new Client(this, token);     // Catch: Throwable -> L10
        token.linkToDeath(client, 0);     // Catch: Throwable -> L10 RemoteException -> L12
        this.mClients.put(token, client);     // Catch: Throwable -> L10
        goto L16
    L14:
        return null;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean isBLEMIDIDevice(BluetoothDevice btDevice) {
        ParcelUuid[] uuids = btDevice.getUuids();
        if (uuids == null) goto L12;
        int r2 = uuids.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        ParcelUuid uuid = uuids[r3];
        if (uuid.getUuid().equals(MIDI_SERVICE) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private static void dumpIntentExtras(Intent intent) {
        String action = intent.getAction();
        Log.d(TAG, "Intent: " + action);
        Bundle bundle = intent.getExtras();
        if (bundle == null) goto L12;
        Iterator<String> r3 = bundle.keySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L16;
        String key = r3.next();
        StringBuilder r5 = new StringBuilder();
        r5.append("  ");
        r5.append(key);
        r5.append(" : ");
        if (bundle.get(key) == null) goto L10;
        Object r6 = bundle.get(key);
    L11:
        r5.append(r6);
        Log.d(TAG, r5.toString());
        goto L6
    L10:
        r6 = "NULL";
        goto L11
    L16:
        return;
    }

    private static boolean isBleTransport(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle == null) goto L9;
        boolean r3 = false;
        if (bundle.getInt("android.bluetooth.device.extra.TRANSPORT", 0) != 2) goto L7;
        r3 = true;
    L7:
        boolean isBle = r3;
        return isBle;
    L9:
        return false;
    }

    private void dumpUuids(BluetoothDevice btDevice) {
        ParcelUuid[] uuidParcels = btDevice.getUuids();
        StringBuilder r1 = new StringBuilder();
        r1.append("dumpUuids(");
        r1.append(btDevice);
        r1.append(") numParcels:");
        int r2 = 0;
        if (uuidParcels == null) goto L5;
        int r3 = uuidParcels.length;
    L6:
        r1.append(r3);
        Log.d(TAG, r1.toString());
        if (uuidParcels != null) goto L10;
        Log.d(TAG, "No UUID Parcels");
        return;
    L10:
        int r4 = uuidParcels.length;
    L11:
        if (r2 >= r4) goto L13;
        ParcelUuid parcel = uuidParcels[r2];
        UUID uuid = parcel.getUuid();
        Log.d(TAG, " uuid:" + uuid);
        r2 = r2 + 1;
        goto L11
    L13:
        return;
    L5:
        r3 = 0;
        goto L6
    }

    private boolean hasNonMidiUuids(BluetoothDevice btDevice) {
        ParcelUuid[] uuidParcels = btDevice.getUuids();
        if (uuidParcels == null) goto L12;
        int r2 = uuidParcels.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        ParcelUuid parcel = uuidParcels[r3];
        if (this.mNonMidiUUIDs.contains(parcel) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public MidiService(Context context) {
        this.mClients = new HashMap();
        this.mDevicesByInfo = new HashMap();
        this.mBluetoothDevices = new HashMap();
        this.mBleMidiDeviceMap = new HashMap();
        this.mDevicesByServer = new HashMap();
        this.mNextDeviceId = 1;
        this.mUsbMidiLock = new Object();
        this.mUsbMidiLegacyDeviceOpenCount = new HashMap();
        this.mUsbMidiUniversalDeviceInUse = new HashSet();
        this.mNonMidiUUIDs = new HashSet();
        this.mPackageMonitor = new AnonymousClass1(this);
        this.mBleMidiReceiver = new AnonymousClass2(this);
        this.mContext = context;
        this.mPackageManager = context.getPackageManager();
        this.mUserManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        this.mPackageMonitor.register(this.mContext, null, UserHandle.ALL, true);
        this.mBluetoothServiceUid = -1;
        this.mNonMidiUUIDs.add(BluetoothUuid.A2DP_SINK);
        this.mNonMidiUUIDs.add(BluetoothUuid.A2DP_SOURCE);
        this.mNonMidiUUIDs.add(BluetoothUuid.ADV_AUDIO_DIST);
        this.mNonMidiUUIDs.add(BluetoothUuid.AVRCP_CONTROLLER);
        this.mNonMidiUUIDs.add(BluetoothUuid.HFP);
        this.mNonMidiUUIDs.add(BluetoothUuid.HSP);
        this.mNonMidiUUIDs.add(BluetoothUuid.HID);
        this.mNonMidiUUIDs.add(BluetoothUuid.LE_AUDIO);
        this.mNonMidiUUIDs.add(BluetoothUuid.HOGP);
        this.mNonMidiUUIDs.add(BluetoothUuid.HEARING_AID);
    }

    private void onStartOrUnlockUser(SystemService.TargetUser user, boolean matchDirectBootUnaware) {
        Log.d(TAG, "onStartOrUnlockUser " + user.getUserIdentifier() + " matchDirectBootUnaware: " + matchDirectBootUnaware);
        int resolveFlags = 128;
        if (matchDirectBootUnaware == false) goto L5;
        resolveFlags = 128 | 262144;
    L5:
        Intent intent = new Intent("android.media.midi.MidiDeviceService");
        List<ResolveInfo> resolveInfos = this.mPackageManager.queryIntentServicesAsUser(intent, resolveFlags, user.getUserIdentifier());
        if (resolveInfos == null) goto L13;
        int count = resolveInfos.size();
        int i = 0;
    L8:
        if (i >= count) goto L13;
        ServiceInfo serviceInfo = resolveInfos.get(i).serviceInfo;
        if (serviceInfo == null) goto L12;
        addLegacyPackageDeviceServer(serviceInfo, user.getUserIdentifier());
    L12:
        i = i + 1;
    L13:
        Intent intent2 = new Intent("android.media.midi.MidiUmpDeviceService");
        List<ResolveInfo> resolveInfos2 = this.mPackageManager.queryIntentServicesAsUser(intent2, resolveFlags, user.getUserIdentifier());
        if (resolveInfos2 == null) goto L21;
        int count2 = resolveInfos2.size();
        int i2 = 0;
    L16:
        if (i2 >= count2) goto L21;
        ServiceInfo serviceInfo2 = resolveInfos2.get(i2).serviceInfo;
        if (serviceInfo2 == null) goto L20;
        addUmpPackageDeviceServer(serviceInfo2, user.getUserIdentifier());
    L20:
        i2 = i2 + 1;
    L21:
        UserHandle mainUser = this.mUserManager.getMainUser();
        if (mainUser != null) goto L24;
    L34:
        PackageInfo info = this.mPackageManager.getPackageInfoAsUser("com.android.bluetoothmidiservice", 0, user.getUserIdentifier());     // Catch: PackageManager.NameNotFoundException -> L27
    L29:
        if (info != null) goto L31;
        return;
    L31:
        if (info.applicationInfo == null) goto L44;
        this.mBluetoothServiceUid = info.applicationInfo.uid;
        return;
    L44:
        return;
    L28:
        info = null;
        goto L29
    L24:
        if (user.getUserIdentifier() == mainUser.getIdentifier()) goto L34;
    }

    public void registerListener(IBinder token, IMidiDeviceListener listener) {
        Client client = getClient(token);
        if (client != null) goto L5;
        return;
    L5:
        client.addListener(listener);
        updateStickyDeviceStatus(Client.m5918$$Nest$fgetmUid(client), listener);
    }

    public void unregisterListener(IBinder token, IMidiDeviceListener listener) {
        Client client = getClient(token);
        if (client != null) goto L5;
        return;
    L5:
        client.removeListener(listener);
    }

    private void updateStickyDeviceStatus(int uid, IMidiDeviceListener listener) {
        int userId = UserHandle.getUserId(uid);
        HashMap<MidiDeviceInfo, Device> r1 = this.mDevicesByInfo;
        monitor-enter(r1);
        Iterator<Device> r2 = this.mDevicesByInfo.values().iterator();     // Catch: Throwable -> L15
    L6:
        if (r2.hasNext() == false) goto L23;
        Device device = r2.next();     // Catch: Throwable -> L15
        if (device.isUidAllowed(uid) == false) goto L6;
        if (device.isUserIdAllowed(userId) == false) goto L6;
        MidiDeviceStatus status = device.getDeviceStatus();     // Catch: Throwable -> L15 RemoteException -> L17
        if (status == null) goto L6;
        listener.onDeviceStatusChanged(status);     // Catch: Throwable -> L15 RemoteException -> L17
    L17:
        e = move-exception;
        Log.e(TAG, "remote exception", e);     // Catch: Throwable -> L15
        goto L6
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public MidiDeviceInfo[] getDevices() {
        return getDevicesForTransport(1);
    }

    public MidiDeviceInfo[] getDevicesForTransport(int transport) {
        ArrayList<MidiDeviceInfo> deviceInfos = new ArrayList();
        int uid = Binder.getCallingUid();
        int userId = getCallingUserId();
        HashMap<MidiDeviceInfo, Device> r3 = this.mDevicesByInfo;
        monitor-enter(r3);
        Iterator<Device> r4 = this.mDevicesByInfo.values().iterator();     // Catch: Throwable -> L16
    L6:
        if (r4.hasNext() == false) goto L24;
        Device device = r4.next();     // Catch: Throwable -> L16
        if (device.isUidAllowed(uid) == false) goto L6;
        if (device.isUserIdAllowed(userId) == false) goto L6;
        if (transport != 2) goto L19;
        if (isUmpDevice(device.getDeviceInfo()) == false) goto L6;
        deviceInfos.add(device.getDeviceInfo());     // Catch: Throwable -> L16
        goto L6
    L19:
        if (transport != 1) goto L6;
        if (isUmpDevice(device.getDeviceInfo()) == true) goto L6;
        deviceInfos.add(device.getDeviceInfo());     // Catch: Throwable -> L16
        goto L6
    L24:
        monitor-exit(r3);     // Catch: Throwable -> L16
        return (MidiDeviceInfo[]) deviceInfos.toArray(EMPTY_DEVICE_INFO_ARRAY);
    L16:
        th = move-exception;
        throw th;
    }

    public void openDevice(IBinder token, MidiDeviceInfo deviceInfo, IMidiDeviceOpenCallback callback) {
        Client client = getClient(token);
        Log.d(TAG, "openDevice() client:" + client);
        if (client != null) goto L5;
        return;
    L5:
        HashMap<MidiDeviceInfo, Device> r1 = this.mDevicesByInfo;
        monitor-enter(r1);
        Device device = this.mDevicesByInfo.get(deviceInfo);     // Catch: Throwable -> L36
        Log.d(TAG, "  device:" + device);     // Catch: Throwable -> L36
        if (device == null) goto L43;
        if (device.isUidAllowed(Binder.getCallingUid()) == false) goto L41;
        if (device.isUserIdAllowed(getCallingUserId()) == false) goto L39;
        monitor-exit(r1);     // Catch: Throwable -> L36
        if (deviceInfo.getType() != 1) goto L29;
        Object r2 = this.mUsbMidiLock;
        monitor-enter(r2);
    L23:
        th = move-exception;
        throw th;
    L19:
        if (isUsbMidiDeviceInUseLocked(deviceInfo) == true) goto L26;
        addUsbMidiDeviceLocked(deviceInfo);     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        goto L29
    L26:
        throw new IllegalArgumentException("device already in use: " + deviceInfo);     // Catch: Throwable -> L23
    L29:
        long identity = Binder.clearCallingIdentity();
        Log.i(TAG, "addDeviceConnection() [B] device:" + device);     // Catch: Throwable -> L33
        client.addDeviceConnection(device, callback, getCallingUserId());     // Catch: Throwable -> L33
        Binder.restoreCallingIdentity(identity);
        return;
    L33:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L39:
        throw new SecurityException("Attempt to open virtual device with wrong user id");     // Catch: Throwable -> L36
    L41:
        throw new SecurityException("Attempt to open private device with wrong UID");     // Catch: Throwable -> L36
    L43:
        throw new IllegalArgumentException("device does not exist: " + deviceInfo);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    }

    private void openBluetoothDevice(final BluetoothDevice bluetoothDevice) {
        Log.d(TAG, "openBluetoothDevice() device: " + bluetoothDevice);
        MidiManager midiManager = (MidiManager) this.mContext.getSystemService(MidiManager.class);
        midiManager.openBluetoothDevice(bluetoothDevice, new AnonymousClass3(this, bluetoothDevice), null);
    }

    private void closeBluetoothDevice(BluetoothDevice bluetoothDevice) {
        Log.d(TAG, "closeBluetoothDevice() device: " + bluetoothDevice);
        HashMap<BluetoothDevice, MidiDevice> r0 = this.mBleMidiDeviceMap;
        monitor-enter(r0);
        MidiDevice midiDevice = this.mBleMidiDeviceMap.remove(bluetoothDevice);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (midiDevice == null) goto L19;
        midiDevice.close();     // Catch: IOException -> L9
        return;
    L9:
        ex = move-exception;
        Log.e(TAG, "Exception closing BLE-MIDI device" + ex);
        return;
    L19:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void openBluetoothDevice(IBinder token, BluetoothDevice bluetoothDevice, IMidiDeviceOpenCallback callback) {
        Log.d(TAG, "openBluetoothDevice()");
        Client client = getClient(token);
        if (client != null) goto L5;
        return;
    L5:
        Log.i(TAG, "alloc device...");
        HashMap<MidiDeviceInfo, Device> r1 = this.mDevicesByInfo;
        monitor-enter(r1);
        Device device = this.mBluetoothDevices.get(bluetoothDevice);     // Catch: Throwable -> L10
        if (device != null) goto L12;
        device = new Device(this, bluetoothDevice);     // Catch: Throwable -> L10
        this.mBluetoothDevices.put(bluetoothDevice, device);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L10
        Log.i(TAG, "device: " + device);
        long identity = Binder.clearCallingIdentity();
        Log.i(TAG, "addDeviceConnection() [C] device:" + device);     // Catch: Throwable -> L17
        client.addDeviceConnection(device, callback, getCallingUserId());     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(identity);
        return;
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L10:
        th = move-exception;
        throw th;
    }

    public void closeDevice(IBinder clientToken, IBinder deviceToken) {
        Client client = getClient(clientToken);
        if (client != null) goto L5;
        return;
    L5:
        client.removeDeviceConnection(deviceToken);
    }

    public MidiDeviceInfo registerDeviceServer(IMidiDeviceServer server, int numInputPorts, int numOutputPorts, String[] inputPortNames, String[] outputPortNames, Bundle properties, int type, int defaultProtocol) {
        int uid = Binder.getCallingUid();
        int userId = getCallingUserId();
        if (type != 1) goto L10;
        if (uid == 1000) goto L10;
        throw new SecurityException("only system can create USB devices");
    L10:
        if (type == 3) goto L12;
    L16:
        HashMap<MidiDeviceInfo, Device> r14 = this.mDevicesByInfo;
        monitor-enter(r14);
        MidiDeviceInfo r0 = addDeviceLocked(type, numInputPorts, numOutputPorts, inputPortNames, outputPortNames, properties, server, null, false, uid, defaultProtocol, userId);     // Catch: Throwable -> L22
        monitor-exit(r14);     // Catch: Throwable -> L22
        return r0;
    L22:
        th = move-exception;
        throw th;
    L12:
        if (uid == this.mBluetoothServiceUid) goto L16;
        throw new SecurityException("only MidiBluetoothService can create Bluetooth devices");
    }

    public void unregisterDeviceServer(IMidiDeviceServer server) {
        HashMap<MidiDeviceInfo, Device> r0 = this.mDevicesByInfo;
        monitor-enter(r0);
        Device device = this.mDevicesByServer.get(server.asBinder());     // Catch: Throwable -> L7
        if (device == null) goto L9;
        device.closeLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public MidiDeviceInfo getServiceDeviceInfo(String packageName, String className) {
        int uid = Binder.getCallingUid();
        HashMap<MidiDeviceInfo, Device> r1 = this.mDevicesByInfo;
        monitor-enter(r1);
        Iterator<Device> r2 = this.mDevicesByInfo.values().iterator();     // Catch: Throwable -> L18
    L6:
        if (r2.hasNext() == false) goto L24;
        Device device = r2.next();     // Catch: Throwable -> L18
        ServiceInfo serviceInfo = device.getServiceInfo();     // Catch: Throwable -> L18
        if (serviceInfo == null) goto L6;
        if (packageName.equals(serviceInfo.packageName) == false) goto L6;
        if (className.equals(serviceInfo.name) == false) goto L6;
        if (device.isUidAllowed(uid) == false) goto L20;
        MidiDeviceInfo r3 = device.getDeviceInfo();     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return r3;
    L20:
        EventLog.writeEvent(1397638484, new Object[]{"185796676", -1, ""});     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return null;
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L18
        return null;
    L18:
        th = move-exception;
        throw th;
    }

    public MidiDeviceStatus getDeviceStatus(MidiDeviceInfo deviceInfo) {
        Device device = this.mDevicesByInfo.get(deviceInfo);
        if (device == null) goto L11;
        int uid = Binder.getCallingUid();
        if (device.isUidAllowed(uid) == true) goto L7;
        Log.e(TAG, "getDeviceStatus() invalid UID = " + uid);
        EventLog.writeEvent(1397638484, new Object[]{"203549963", Integer.valueOf(uid), "getDeviceStatus: invalid uid"});
        return null;
    L7:
        return device.getDeviceStatus();
    L11:
        throw new IllegalArgumentException("no such device for " + deviceInfo);
    }

    public void setDeviceStatus(IMidiDeviceServer server, MidiDeviceStatus status) {
        Device device = this.mDevicesByServer.get(server.asBinder());
        if (device != null) goto L5;
        return;
    L5:
        if (Binder.getCallingUid() != device.getUid()) goto L8;
        device.setDeviceStatus(status);
        notifyDeviceStatusChanged(device, status);
        return;
    L8:
        throw new SecurityException("setDeviceStatus() caller UID " + Binder.getCallingUid() + " does not match device's UID " + device.getUid());
    }

    private void notifyDeviceStatusChanged(Device device, MidiDeviceStatus status) {
        HashMap<IBinder, Client> r0 = this.mClients;
        monitor-enter(r0);
        Iterator<Client> r1 = this.mClients.values().iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        Client c = r1.next();     // Catch: Throwable -> L8
        c.deviceStatusChanged(device, status);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private MidiDeviceInfo addDeviceLocked(int type, int numInputPorts, int numOutputPorts, String[] inputPortNames, String[] outputPortNames, Bundle properties, IMidiDeviceServer server, ServiceInfo serviceInfo, boolean isPrivate, int uid, int defaultProtocol, int userId) {
        Log.d(TAG, "addDeviceLocked() " + uid + " type:" + type + " userId:" + userId);
        Iterator<Device> r2 = this.mDevicesByInfo.values().iterator();
        int deviceCountForApp = 0;
    L4:
        if (r2.hasNext() == false) goto L10;
        Device device = r2.next();
        if (device.getUid() != uid) goto L4;
        deviceCountForApp = deviceCountForApp + 1;
        goto L4
    L10:
        if (deviceCountForApp >= 16) goto L44;
        int id = this.mNextDeviceId;
        this.mNextDeviceId = id + 1;
        MidiDeviceInfo deviceInfo = new MidiDeviceInfo(type, id, numInputPorts, numOutputPorts, inputPortNames, outputPortNames, properties, isPrivate, defaultProtocol);
        if (server == null) goto L19;
        server.setDeviceInfo(deviceInfo);     // Catch: RemoteException -> L15
    L16:
        Log.e(TAG, "RemoteException in setDeviceInfo()");
        return null;
    L19:
        if (type != 3) goto L24;
        BluetoothDevice bluetoothDevice = (BluetoothDevice) properties.getParcelable("bluetooth_device", BluetoothDevice.class);
        Device device2 = this.mBluetoothDevices.get(bluetoothDevice);
        Device device3 = device2;
        if (device3 == null) goto L23;
        device3.setDeviceInfo(deviceInfo);
    L23:
        Device device4 = device3;
        BluetoothDevice bluetoothDevice2 = bluetoothDevice;
    L25:
        if (device4 != null) goto L28;
        device4 = new Device(this, server, deviceInfo, serviceInfo, uid, userId);
    L28:
        this.mDevicesByInfo.put(deviceInfo, device4);
        if (bluetoothDevice2 == null) goto L31;
        this.mBluetoothDevices.put(bluetoothDevice2, device4);
    L31:
        HashMap<IBinder, Client> r3 = this.mClients;
        monitor-enter(r3);
        Iterator<Client> r0 = this.mClients.values().iterator();     // Catch: Throwable -> L37
    L35:
        if (r0.hasNext() == false) goto L39;
        Client c = r0.next();     // Catch: Throwable -> L37
        c.deviceAdded(device4);     // Catch: Throwable -> L37
        goto L35
    L39:
        monitor-exit(r3);     // Catch: Throwable -> L37
        return deviceInfo;
    L37:
        th = move-exception;
        throw th;
    L24:
        device4 = null;
        bluetoothDevice2 = null;
        goto L25
    L44:
        throw new SecurityException("too many MIDI devices already created for UID = " + uid);
    }

    private void removeDeviceLocked(Device device) {
        IMidiDeviceServer server = device.getDeviceServer();
        if (server == null) goto L5;
        this.mDevicesByServer.remove(server.asBinder());
    L5:
        this.mDevicesByInfo.remove(device.getDeviceInfo());
        HashMap<IBinder, Client> r1 = this.mClients;
        monitor-enter(r1);
        Iterator<Client> r2 = this.mClients.values().iterator();     // Catch: Throwable -> L11
    L9:
        if (r2.hasNext() == false) goto L13;
        Client c = r2.next();     // Catch: Throwable -> L11
        c.deviceRemoved(device);     // Catch: Throwable -> L11
        goto L9
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void addPackageDeviceServers(String packageName, int userId) {
        PackageInfo info = this.mPackageManager.getPackageInfoAsUser(packageName, 262276, userId);     // Catch: PackageManager.NameNotFoundException -> L12
        ServiceInfo[] services = info.services;
        if (services != null) goto L6;
        return;
    L6:
        int i = 0;
    L8:
        if (i >= services.length) goto L11;
        addLegacyPackageDeviceServer(services[i], userId);
        addUmpPackageDeviceServer(services[i], userId);
        i = i + 1;
        goto L8
    L11:
        return;
    L12:
        e = move-exception;
        Log.e(TAG, "handlePackageUpdate could not find package " + packageName, e);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:116:? -> B:93:0x01f0). Please report as a decompilation issue!!! */
    private void addLegacyPackageDeviceServer(ServiceInfo serviceInfo, int userId) {
        MidiService this = this;
        XmlResourceParser parser = null;
        if (serviceInfo != null) goto L13;
        Log.w(TAG, "Skipping null service info");     // Catch: Throwable -> L8 Exception -> L10
        if (0 == 0) goto L146;
        parser.close();
        return;
    L146:
        return;
    L13:
        if ("android.permission.BIND_MIDI_DEVICE_SERVICE".equals(serviceInfo.permission) == true) goto L17;
        if (0 == 0) goto L147;
        parser.close();
        return;
    L147:
        return;
    L17:
        XmlResourceParser parser2 = serviceInfo.loadXmlMetaData(this.mPackageManager, "android.media.midi.MidiDeviceService");     // Catch: Throwable -> L8 Exception -> L10
        if (parser2 != null) goto L29;
        Log.w(TAG, "loading xml metadata failed");     // Catch: Throwable -> L24 Exception -> L26
        if (parser2 == null) goto L148;
        parser2.close();
        return;
    L148:
        return;
    L29:
        ArrayList<String> inputPortNames = new ArrayList();     // Catch: Throwable -> L24 Exception -> L26
        ArrayList<String> outputPortNames = new ArrayList();     // Catch: Throwable -> L24 Exception -> L26
        Bundle properties = null;
        boolean isPrivate = false;
        int numOutputPorts = 0;
        int numInputPorts = 0;
    L30:
        int eventType = parser2.next();     // Catch: Throwable -> L24 Exception -> L26
        if (eventType == 1) goto L33;
        if (eventType != 2) goto L75;
        String tagName = parser2.getName();     // Catch: Throwable -> L24 Exception -> L26
        if ("device".equals(tagName) == false) goto L49;
        if (properties != null) goto L39;
        properties = new Bundle();     // Catch: Throwable -> L24 Exception -> L26
        properties.putParcelable("service_info", serviceInfo);     // Catch: Throwable -> L24 Exception -> L26
        numInputPorts = 0;
        numOutputPorts = 0;
        boolean isPrivate2 = false;
        int count = parser2.getAttributeCount();     // Catch: Throwable -> L24 Exception -> L26
        int i = 0;
    L41:
        if (i >= count) goto L47;
        String name = parser2.getAttributeName(i);     // Catch: Throwable -> L24 Exception -> L26
        String value = parser2.getAttributeValue(i);     // Catch: Throwable -> L24 Exception -> L26
        if ("private".equals(name) == false) goto L45;
        isPrivate2 = "true".equals(value);     // Catch: Throwable -> L24 Exception -> L26
    L46:
        i = i + 1;     // Catch: Throwable -> L24 Exception -> L26
        goto L41
    L45:
        properties.putString(name, value);     // Catch: Throwable -> L24 Exception -> L26
        goto L46
    L47:
        isPrivate = isPrivate2;
    L73:
        ArrayList<String> outputPortNames2 = outputPortNames;
    L105:
        outputPortNames = outputPortNames2;
        goto L30
    L39:
        Log.w(TAG, "nested <device> elements in metadata for " + serviceInfo.packageName);     // Catch: Throwable -> L24 Exception -> L26
    L101:
        outputPortNames = outputPortNames;
        goto L30
    L49:
        if ("input-port".equals(tagName) == false) goto L61;
        if (properties == null) goto L51;
        int numInputPorts2 = numInputPorts + 1;     // Catch: Throwable -> L24 Exception -> L26
        String portName = null;
        int count2 = parser2.getAttributeCount();     // Catch: Throwable -> L24 Exception -> L26
        int i2 = 0;
    L53:
        if (i2 >= count2) goto L58;
        String name2 = parser2.getAttributeName(i2);     // Catch: Throwable -> L24 Exception -> L26
        String value2 = parser2.getAttributeValue(i2);     // Catch: Throwable -> L24 Exception -> L26
        int numInputPorts3 = numInputPorts2;
        if ("name".equals(name2) == true) goto L56;
        i2 = i2 + 1;     // Catch: Throwable -> L24 Exception -> L26
        numInputPorts2 = numInputPorts3;
        goto L53
    L56:
        portName = value2;
    L59:
        inputPortNames.add(portName);     // Catch: Throwable -> L24 Exception -> L26
        numInputPorts = numInputPorts3;
        goto L73
    L58:
        numInputPorts3 = numInputPorts2;
        goto L59
    L51:
        Log.w(TAG, "<input-port> outside of <device> in metadata for " + serviceInfo.packageName);     // Catch: Throwable -> L24 Exception -> L26
        goto L101
    L61:
        if ("output-port".equals(tagName) == false) goto L73;
        if (properties == null) goto L63;
        numOutputPorts = numOutputPorts + 1;     // Catch: Throwable -> L24 Exception -> L26
        String portName2 = null;
        int count3 = parser2.getAttributeCount();     // Catch: Throwable -> L24 Exception -> L26
        int i3 = 0;
    L65:
        if (i3 >= count3) goto L71;
        String name3 = parser2.getAttributeName(i3);     // Catch: Throwable -> L24 Exception -> L26
        String value3 = parser2.getAttributeValue(i3);     // Catch: Throwable -> L24 Exception -> L26
        String tagName2 = tagName;
        if ("name".equals(name3) == true) goto L68;
        i3 = i3 + 1;     // Catch: Throwable -> L24 Exception -> L26
        tagName = tagName2;
        goto L65
    L68:
        portName2 = value3;
    L71:
        outputPortNames.add(portName2);     // Catch: Throwable -> L24 Exception -> L26
        goto L73
    L63:
        Log.w(TAG, "<output-port> outside of <device> in metadata for " + serviceInfo.packageName);     // Catch: Throwable -> L24 Exception -> L26
        goto L101
    L75:
        if (eventType != 3) goto L104;
        if ("device".equals(parser2.getName()) == false) goto L103;
        if (properties == null) goto L102;
        if (numInputPorts != 0) goto L120;
        if (numOutputPorts != 0) goto L120;
        Log.w(TAG, "<device> with no ports in metadata for " + serviceInfo.packageName);     // Catch: Throwable -> L24 Exception -> L26
    L120:
        ApplicationInfo appInfo = this.mPackageManager.getApplicationInfoAsUser(serviceInfo.packageName, 0, userId);     // Catch: Throwable -> L24 Exception -> L26 PackageManager.NameNotFoundException -> L99
        int uid = appInfo.uid;     // Catch: Throwable -> L24 Exception -> L26 PackageManager.NameNotFoundException -> L99
        goto L100
    L84:
        HashMap<MidiDeviceInfo, Device> r8 = this.mDevicesByInfo;     // Catch: Throwable -> L24 Exception -> L26
        monitor-enter(r8);     // Catch: Throwable -> L24 Exception -> L26
        HashMap<MidiDeviceInfo, Device> r19 = r8;
        outputPortNames2 = outputPortNames;
        this.addDeviceLocked(2, numInputPorts, numOutputPorts, (String[]) inputPortNames.toArray(EMPTY_STRING_ARRAY), (String[]) outputPortNames.toArray(EMPTY_STRING_ARRAY), properties, null, serviceInfo, isPrivate, uid, -1, userId);     // Catch: Throwable -> L93
        monitor-exit(r19);     // Catch: Throwable -> L93
        inputPortNames.clear();     // Catch: Throwable -> L24 Exception -> L26
        outputPortNames2.clear();     // Catch: Throwable -> L24 Exception -> L26
        properties = null;
    L93:
        th = th;
    L97:
        monitor-exit(r19);     // Catch: Throwable -> L93
        throw th;     // Catch: Throwable -> L24 Exception -> L26
    L95:
        th = th;
        r19 = r8;
    L100:
        Log.e(TAG, "could not fetch ApplicationInfo for " + serviceInfo.packageName);     // Catch: Throwable -> L24 Exception -> L26
        goto L101
    L102:
        outputPortNames2 = outputPortNames;
        goto L105
    L103:
        outputPortNames2 = outputPortNames;
        goto L105
    L104:
        outputPortNames2 = outputPortNames;
        goto L105
    L33:
        parser2.close();
        return;
    L26:
        e = e;
        parser = parser2;
    L107:
        Log.w(TAG, "Unable to load component info " + serviceInfo.toString(), e);     // Catch: Throwable -> L8
        if (parser == null) goto L111;
        parser.close();
    L111:
        return;
    L24:
        th = th;
        parser = parser2;
    L112:
        if (parser == null) goto L114;
        parser.close();
    L114:
        throw th;
    L8:
        th = th;
    L10:
        e = e;
        goto L107
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:138:? -> B:103:0x023b). Please report as a decompilation issue!!! */
    private void addUmpPackageDeviceServer(ServiceInfo serviceInfo, int userId) {
        MidiService this = this;
        XmlResourceParser parser = null;
        if (serviceInfo != null) goto L15;
        Log.w(TAG, "Skipping null service info");     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        if (0 == 0) goto L164;
        parser.close();
        return;
    L164:
        return;
    L15:
        if ("android.permission.BIND_MIDI_DEVICE_SERVICE".equals(serviceInfo.permission) == true) goto L20;
        if (0 == 0) goto L165;
        parser.close();
        return;
    L165:
        return;
    L20:
        ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        PackageManager.Property property = this.mPackageManager.getProperty("android.media.midi.MidiUmpDeviceService", componentName);     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        if (property != null) goto L26;
        Log.w(TAG, "Getting MidiUmpDeviceService property failed");     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        if (0 == 0) goto L166;
        parser.close();
        return;
    L166:
        return;
    L26:
        int resId = property.getResourceId();     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        if (resId != 0) goto L32;
        Log.w(TAG, "Getting MidiUmpDeviceService resourceId failed");     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        if (0 == 0) goto L167;
        parser.close();
        return;
    L167:
        return;
    L32:
        Resources resources = this.mPackageManager.getResourcesForApplication(serviceInfo.packageName);     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        if (resources != null) goto L38;
        Log.w(TAG, "Getting resource failed " + serviceInfo.packageName);     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        if (0 == 0) goto L168;
        parser.close();
        return;
    L168:
        return;
    L38:
        parser = resources.getXml(resId);     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        if (parser != null) goto L134;
        Log.w(TAG, "Getting XML failed " + resId);     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        if (parser == null) goto L169;
        parser.close();
        return;
    L169:
        return;
    L134:
        ArrayList<String> portNames = new ArrayList();     // Catch: Throwable -> L109 Exception -> L111 PackageManager.NameNotFoundException -> L113
        boolean isPrivate = false;
        int resId2 = resId;
        int numPorts = 0;
        Bundle properties = null;
    L46:
        int eventType = parser.next();     // Catch: Throwable -> L109 Exception -> L111 PackageManager.NameNotFoundException -> L113
        if (eventType == 1) goto L49;
        if (eventType != 2) goto L79;
        String tagName = parser.getName();     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        if ("device".equals(tagName) == false) goto L64;
        if (properties != null) goto L55;
        properties = new Bundle();     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        properties.putParcelable("service_info", serviceInfo);     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        numPorts = 0;
        isPrivate = false;
        int count = parser.getAttributeCount();     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        int i = 0;
    L57:
        if (i >= count) goto L63;
        String name = parser.getAttributeName(i);     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        String value = parser.getAttributeValue(i);     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        int numPorts2 = numPorts;
        if ("private".equals(name) == false) goto L61;
        isPrivate = "true".equals(value);     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
    L62:
        i = i + 1;     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        numPorts = numPorts2;
        resources = resources;
        goto L57
    L61:
        properties.putString(name, value);     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        goto L62
    L63:
        Resources resources2 = resources;
    L78:
        parser = parser;
        resId2 = resId2;
        portNames = portNames;
    L122:
        resId2 = resId2;
        parser = parser;
        resources = resources2;
        portNames = portNames;
        goto L46
    L55:
        Log.w(TAG, "nested <device> elements in metadata for " + serviceInfo.packageName);     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        resources2 = resources;
    L117:
        properties = properties;
        resId2 = resId2;
        parser = parser;
        resources = resources2;
        portNames = portNames;
        goto L46
    L64:
        resources2 = resources;
        if ("port".equals(tagName) == false) goto L78;
        if (properties == null) goto L67;
        numPorts = numPorts + 1;     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        String portName = null;
        int count2 = parser.getAttributeCount();     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        int i2 = 0;
    L69:
        if (i2 >= count2) goto L75;
        String name2 = parser.getAttributeName(i2);     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        String value2 = parser.getAttributeValue(i2);     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        String tagName2 = tagName;
        if ("name".equals(name2) == true) goto L72;
        i2 = i2 + 1;     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        tagName = tagName2;
        goto L69
    L72:
        portName = value2;
    L75:
        portNames.add(portName);     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        goto L78
    L67:
        Log.w(TAG, "<port> outside of <device> in metadata for " + serviceInfo.packageName);     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
        goto L117
    L79:
        resources2 = resources;
        if (eventType != 3) goto L121;
        if ("device".equals(parser.getName()) == false) goto L121;
        if (properties == null) goto L121;
        if (numPorts == 0) goto L85;
        ApplicationInfo appInfo = this.mPackageManager.getApplicationInfoAsUser(serviceInfo.packageName, 0, userId);     // Catch: Throwable -> L109 Exception -> L111 PackageManager.NameNotFoundException -> L115
        int uid = appInfo.uid;     // Catch: Throwable -> L109 Exception -> L111 PackageManager.NameNotFoundException -> L115
        HashMap<MidiDeviceInfo, Device> r12 = this.mDevicesByInfo;     // Catch: Throwable -> L109 Exception -> L111 PackageManager.NameNotFoundException -> L113
        monitor-enter(r12);     // Catch: Throwable -> L109 Exception -> L111 PackageManager.NameNotFoundException -> L113
        goto L131
    L139:
        parser = parser;
        HashMap<MidiDeviceInfo, Device> r22 = r12;
        portNames = portNames;
        resId2 = resId2;
        this.addDeviceLocked(2, numPorts, numPorts, (String[]) portNames.toArray(EMPTY_STRING_ARRAY), (String[]) portNames.toArray(EMPTY_STRING_ARRAY), properties, null, serviceInfo, isPrivate, uid, 17, userId);     // Catch: Throwable -> L103
        monitor-exit(r22);     // Catch: Throwable -> L103
        portNames.clear();     // Catch: Throwable -> L97 Exception -> L99 PackageManager.NameNotFoundException -> L101
        properties = null;
    L99:
        e = e;
        parser = parser;
    L124:
        Log.w(TAG, "Unable to load component info " + serviceInfo.toString(), e);     // Catch: Throwable -> L8
        if (parser != null) goto L49;
        return;
    L97:
        th = th;
        parser = parser;
    L127:
        if (parser == null) goto L129;
        parser.close();
    L129:
        throw th;
    L102:
        parser = parser;
    L103:
        th = th;
    L107:
        monitor-exit(r22);     // Catch: Throwable -> L103
        throw th;     // Catch: Throwable -> L97 Exception -> L99 PackageManager.NameNotFoundException -> L101
    L105:
        th = th;
        parser = parser;
        r22 = r12;
    L116:
        Log.e(TAG, "could not fetch ApplicationInfo for " + serviceInfo.packageName);     // Catch: Throwable -> L97 Exception -> L99 PackageManager.NameNotFoundException -> L101
        goto L117
    L85:
        Log.w(TAG, "<device> with no ports in metadata for " + serviceInfo.packageName);     // Catch: Throwable -> L8 Exception -> L10 PackageManager.NameNotFoundException -> L12
    L121:
        properties = properties;
    L49:
        parser.close();
        return;
    L111:
        e = e;
    L109:
        th = th;
    L8:
        th = th;
    L10:
        e = e;
    L131:
        if (parser != null) goto L49;
    }

    private void removePackageDeviceServers(String packageName, int userId) {
        HashMap<MidiDeviceInfo, Device> r0 = this.mDevicesByInfo;
        monitor-enter(r0);
        Iterator<Device> iterator = this.mDevicesByInfo.values().iterator();     // Catch: Throwable -> L12
    L6:
        if (iterator.hasNext() == false) goto L16;
        Device device = iterator.next();     // Catch: Throwable -> L12
        if (packageName.equals(device.getPackageName()) == false) goto L6;
        if (device.getUserId() != userId) goto L6;
        iterator.remove();     // Catch: Throwable -> L12
        removeDeviceLocked(device);     // Catch: Throwable -> L12
        goto L6
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void updateTotalBytes(IMidiDeviceServer server, int totalInputBytes, int totalOutputBytes) {
        HashMap<MidiDeviceInfo, Device> r0 = this.mDevicesByInfo;
        monitor-enter(r0);
        Device device = this.mDevicesByServer.get(server.asBinder());     // Catch: Throwable -> L7
        if (device == null) goto L9;
        device.updateTotalBytes(totalInputBytes, totalOutputBytes);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, writer) == true) goto L5;
        return;
    L5:
        IndentingPrintWriter pw = new IndentingPrintWriter(writer, "  ");
        pw.println("MIDI Manager State:");
        pw.increaseIndent();
        pw.println("Devices:");
        pw.increaseIndent();
        HashMap<MidiDeviceInfo, Device> r1 = this.mDevicesByInfo;
        monitor-enter(r1);
        Iterator<Device> r2 = this.mDevicesByInfo.values().iterator();     // Catch: Throwable -> L11
    L9:
        if (r2.hasNext() == false) goto L13;
        Device device = r2.next();     // Catch: Throwable -> L11
        pw.println(device.toString());     // Catch: Throwable -> L11
        goto L9
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L11
        pw.decreaseIndent();
        pw.println("Clients:");
        pw.increaseIndent();
        HashMap<IBinder, Client> r3 = this.mClients;
        monitor-enter(r3);
        Iterator<Client> r4 = this.mClients.values().iterator();     // Catch: Throwable -> L20
    L18:
        if (r4.hasNext() == false) goto L22;
        Client client = r4.next();     // Catch: Throwable -> L20
        pw.println(client.toString());     // Catch: Throwable -> L20
        goto L18
    L22:
        monitor-exit(r3);     // Catch: Throwable -> L20
        pw.decreaseIndent();
        return;
    L20:
        th = move-exception;
        throw th;
    L11:
        th = move-exception;
        throw th;
    }

    protected void onUnhandledException(int code, int flags, Exception e) {
        Slog.wtf(TAG, "Uncaught exception in AudioService: " + code + ", " + flags, e);
    }

    private boolean isUsbMidiDeviceInUseLocked(MidiDeviceInfo info) {
        String name = info.getProperties().getString("name");
        if (name.length() >= MIDI_LEGACY_STRING.length()) goto L5;
        return false;
    L5:
        String deviceName = extractUsbDeviceName(name);
        String tagName = extractUsbDeviceTag(name);
        Log.i(TAG, "Checking " + deviceName + " " + tagName);
        if (this.mUsbMidiUniversalDeviceInUse.contains(deviceName) == false) goto L8;
        return true;
    L8:
        if (tagName.equals(MIDI_UNIVERSAL_STRING) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.mUsbMidiLegacyDeviceOpenCount.containsKey(deviceName) == false) goto L12;
        return true;
    }

    void addUsbMidiDeviceLocked(MidiDeviceInfo info) {
        String name = info.getProperties().getString("name");
        if (name.length() >= MIDI_LEGACY_STRING.length()) goto L5;
        return;
    L5:
        String deviceName = extractUsbDeviceName(name);
        String tagName = extractUsbDeviceTag(name);
        Log.i(TAG, "Adding " + deviceName + " " + tagName);
        if (tagName.equals(MIDI_UNIVERSAL_STRING) == false) goto L9;
        this.mUsbMidiUniversalDeviceInUse.add(deviceName);
        return;
    L9:
        if (tagName.equals(MIDI_LEGACY_STRING) == false) goto L13;
        int count = this.mUsbMidiLegacyDeviceOpenCount.getOrDefault(deviceName, 0).intValue() + 1;
        this.mUsbMidiLegacyDeviceOpenCount.put(deviceName, Integer.valueOf(count));
        return;
    }

    void removeUsbMidiDeviceLocked(MidiDeviceInfo info) {
        String name = info.getProperties().getString("name");
        if (name.length() >= MIDI_LEGACY_STRING.length()) goto L5;
        return;
    L5:
        String deviceName = extractUsbDeviceName(name);
        String tagName = extractUsbDeviceTag(name);
        Log.i(TAG, "Removing " + deviceName + " " + tagName);
        if (tagName.equals(MIDI_UNIVERSAL_STRING) == false) goto L9;
        this.mUsbMidiUniversalDeviceInUse.remove(deviceName);
        return;
    L9:
        if (tagName.equals(MIDI_LEGACY_STRING) == true) goto L11;
        return;
    L11:
        if (this.mUsbMidiLegacyDeviceOpenCount.containsKey(deviceName) == false) goto L19;
        int count = this.mUsbMidiLegacyDeviceOpenCount.get(deviceName).intValue();
        if (count <= 1) goto L15;
        this.mUsbMidiLegacyDeviceOpenCount.put(deviceName, Integer.valueOf(count - 1));
        return;
    L15:
        this.mUsbMidiLegacyDeviceOpenCount.remove(deviceName);
        return;
    }

    String extractUsbDeviceName(String propertyName) {
        return propertyName.substring(0, propertyName.length() - MIDI_LEGACY_STRING.length());
    }

    String extractUsbDeviceTag(String propertyName) {
        return propertyName.substring(propertyName.length() - MIDI_LEGACY_STRING.length());
    }

    private int getCallingUserId() {
        return UserHandle.getUserId(Binder.getCallingUid());
    }

    private boolean isUmpDevice(MidiDeviceInfo deviceInfo) {
        if (deviceInfo.getDefaultProtocol() == (-1)) goto L5;
        return true;
    L5:
        return false;
    }
}
