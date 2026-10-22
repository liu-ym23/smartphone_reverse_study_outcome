package com.android.server.usb;

import android.R;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.hardware.SensorPrivacyManagerInternal;
import android.hardware.usb.AccessoryFilter;
import android.hardware.usb.DeviceFilter;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbDevice;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Environment;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.EventLog;
import android.util.Slog;
import android.util.SparseBooleanArray;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.LocalServices;
import com.android.server.slice.SliceClientPermissions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
class UsbUserPermissionManager {
    private static final boolean DEBUG = false;
    private static final int SNET_EVENT_LOG_ID = 1397638484;
    private static final String TAG = null;
    private final ArrayMap<UsbAccessory, SparseBooleanArray> mAccessoryPermissionMap;
    private final ArrayMap<AccessoryFilter, SparseBooleanArray> mAccessoryPersistentPermissionMap;
    private final Context mContext;
    private final ArrayMap<String, SparseBooleanArray> mDevicePermissionMap;
    private final ArrayMap<DeviceFilter, SparseBooleanArray> mDevicePersistentPermissionMap;
    private final boolean mDisablePermissionDialogs;
    private boolean mIsCopyPermissionsScheduled;
    private final Object mLock;
    private final AtomicFile mPermissionsFile;
    private final SensorPrivacyManagerInternal mSensorPrivacyMgrInternal;
    private final UsbUserSettingsManager mUsbUserSettingsManager;
    private final UserHandle mUser;

    /* JADX INFO: renamed from: $r8$lambda$4L3CwfCCGQzb_hYr5j-rO6zrDEM, reason: not valid java name */
    public static /* synthetic */ void m9202$r8$lambda$4L3CwfCCGQzb_hYr5jrO6zrDEM(UsbUserPermissionManager r0) {
        r0.lambda$scheduleWritePermissionsLocked$0();
    }

    static {
        TAG = UsbUserPermissionManager.class.getSimpleName();
    }

    UsbUserPermissionManager(Context context, UsbUserSettingsManager usbUserSettingsManager) {
        this.mDevicePermissionMap = new ArrayMap();
        this.mAccessoryPermissionMap = new ArrayMap();
        this.mDevicePersistentPermissionMap = new ArrayMap();
        this.mAccessoryPersistentPermissionMap = new ArrayMap();
        this.mLock = new Object();
        this.mContext = context;
        this.mUser = context.getUser();
        this.mUsbUserSettingsManager = usbUserSettingsManager;
        this.mSensorPrivacyMgrInternal = (SensorPrivacyManagerInternal) LocalServices.getService(SensorPrivacyManagerInternal.class);
        this.mDisablePermissionDialogs = context.getResources().getBoolean(R.bool.config_dismissDreamOnActivityStart);
        this.mPermissionsFile = new AtomicFile(new File(Environment.getUserSystemDirectory(this.mUser.getIdentifier()), "usb_permissions.xml"), "usb-permissions");
        Object r0 = this.mLock;
        monitor-enter(r0);
        readPermissionsLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void removeAccessoryPermissions(UsbAccessory accessory) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAccessoryPermissionMap.remove(accessory);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void removeDevicePermissions(UsbDevice device) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDevicePermissionMap.remove(device.getDeviceName());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void grantDevicePermission(UsbDevice device, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String deviceName = device.getDeviceName();     // Catch: Throwable -> L7
        SparseBooleanArray uidList = this.mDevicePermissionMap.get(deviceName);     // Catch: Throwable -> L7
        if (uidList != null) goto L9;
        uidList = new SparseBooleanArray(1);     // Catch: Throwable -> L7
        this.mDevicePermissionMap.put(deviceName, uidList);     // Catch: Throwable -> L7
    L9:
        uidList.put(uid, true);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void grantAccessoryPermission(UsbAccessory accessory, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SparseBooleanArray uidList = this.mAccessoryPermissionMap.get(accessory);     // Catch: Throwable -> L7
        if (uidList != null) goto L9;
        uidList = new SparseBooleanArray(1);     // Catch: Throwable -> L7
        this.mAccessoryPermissionMap.put(accessory, uidList);     // Catch: Throwable -> L7
    L9:
        uidList.put(uid, true);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean hasPermission(UsbDevice device, String packageName, int pid, int uid) {
        if (device.getHasVideoCapture() == false) goto L9;
        boolean isCameraPrivacyEnabled = this.mSensorPrivacyMgrInternal.isSensorPrivacyEnabled(UserHandle.getUserId(uid), 2);
        if (isCameraPrivacyEnabled == false) goto L7;
    L8:
        return false;
    L7:
        if (isCameraPermissionGranted(packageName, pid, uid) == false) goto L8;
    L9:
        boolean isCameraPrivacyEnabled2 = device.getHasAudioCapture();
        if (isCameraPrivacyEnabled2 == true) goto L12;
    L14:
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (uid == 1000) goto L37;
    L28:
        th = move-exception;
        throw th;
    L19:
        if (this.mDisablePermissionDialogs == true) goto L37;
        DeviceFilter filter = new DeviceFilter(device);     // Catch: Throwable -> L28
        SparseBooleanArray permissionsForDevice = this.mDevicePersistentPermissionMap.get(filter);     // Catch: Throwable -> L28
        if (permissionsForDevice == null) goto L30;
        int idx = permissionsForDevice.indexOfKey(uid);     // Catch: Throwable -> L28
        if (idx < 0) goto L30;
        boolean r1 = permissionsForDevice.valueAt(idx);     // Catch: Throwable -> L28
        monitor-exit(r0);     // Catch: Throwable -> L28
        return r1;
    L30:
        SparseBooleanArray uidList = this.mDevicePermissionMap.get(device.getDeviceName());     // Catch: Throwable -> L28
        if (uidList != null) goto L34;
        monitor-exit(r0);     // Catch: Throwable -> L28
        return false;
    L34:
        boolean r2 = uidList.get(uid);     // Catch: Throwable -> L28
        monitor-exit(r0);     // Catch: Throwable -> L28
        return r2;
    L37:
        monitor-exit(r0);     // Catch: Throwable -> L28
        return true;
    L12:
        if (this.mSensorPrivacyMgrInternal.isSensorPrivacyEnabled(UserHandle.getUserId(uid), 1) == false) goto L14;
        return false;
    }

    boolean hasPermission(UsbAccessory accessory, int pid, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (uid != 1000) goto L33;
    L28:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return true;
    L33:
    L18:
        th = move-exception;
        throw th;
    L7:
        if (this.mDisablePermissionDialogs == true) goto L28;
        if (this.mContext.checkPermission("android.permission.MANAGE_USB", pid, uid) == 0) goto L28;
        AccessoryFilter filter = new AccessoryFilter(accessory);     // Catch: Throwable -> L18
        SparseBooleanArray permissionsForAccessory = this.mAccessoryPersistentPermissionMap.get(filter);     // Catch: Throwable -> L18
        if (permissionsForAccessory == null) goto L20;
        int idx = permissionsForAccessory.indexOfKey(uid);     // Catch: Throwable -> L18
        if (idx < 0) goto L20;
        boolean r4 = permissionsForAccessory.valueAt(idx);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r4;
    L20:
        SparseBooleanArray uidList = this.mAccessoryPermissionMap.get(accessory);     // Catch: Throwable -> L18
        if (uidList != null) goto L25;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return false;
    L25:
        boolean r5 = uidList.get(uid);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r5;
    }

    void setDevicePersistentPermission(UsbDevice device, int uid, boolean isGranted) {
        DeviceFilter filter = new DeviceFilter(device);
        Object r1 = this.mLock;
        monitor-enter(r1);
        SparseBooleanArray permissionsForDevice = this.mDevicePersistentPermissionMap.get(filter);     // Catch: Throwable -> L7
        if (permissionsForDevice != null) goto L9;
        permissionsForDevice = new SparseBooleanArray();     // Catch: Throwable -> L7
        this.mDevicePersistentPermissionMap.put(filter, permissionsForDevice);     // Catch: Throwable -> L7
    L9:
        int idx = permissionsForDevice.indexOfKey(uid);     // Catch: Throwable -> L7
        if (idx >= 0) goto L12;
        boolean isChanged = true;
        permissionsForDevice.put(uid, isGranted);     // Catch: Throwable -> L7
    L17:
        if (isChanged == false) goto L19;
        scheduleWritePermissionsLocked();     // Catch: Throwable -> L7
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L12:
        if (permissionsForDevice.valueAt(idx) == isGranted) goto L14;
        isChanged = true;
    L15:
        permissionsForDevice.setValueAt(idx, isGranted);     // Catch: Throwable -> L7
        goto L17
    L14:
        isChanged = false;
    L7:
        th = move-exception;
        throw th;
    }

    void setAccessoryPersistentPermission(UsbAccessory accessory, int uid, boolean isGranted) {
        AccessoryFilter filter = new AccessoryFilter(accessory);
        Object r1 = this.mLock;
        monitor-enter(r1);
        SparseBooleanArray permissionsForAccessory = this.mAccessoryPersistentPermissionMap.get(filter);     // Catch: Throwable -> L7
        if (permissionsForAccessory != null) goto L9;
        permissionsForAccessory = new SparseBooleanArray();     // Catch: Throwable -> L7
        this.mAccessoryPersistentPermissionMap.put(filter, permissionsForAccessory);     // Catch: Throwable -> L7
    L9:
        int idx = permissionsForAccessory.indexOfKey(uid);     // Catch: Throwable -> L7
        if (idx >= 0) goto L12;
        boolean isChanged = true;
        permissionsForAccessory.put(uid, isGranted);     // Catch: Throwable -> L7
    L17:
        if (isChanged == false) goto L19;
        scheduleWritePermissionsLocked();     // Catch: Throwable -> L7
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L12:
        if (permissionsForAccessory.valueAt(idx) == isGranted) goto L14;
        isChanged = true;
    L15:
        permissionsForAccessory.setValueAt(idx, isGranted);     // Catch: Throwable -> L7
        goto L17
    L14:
        isChanged = false;
    L7:
        th = move-exception;
        throw th;
    }

    private void readPermission(XmlPullParser parser) throws XmlPullParserException, IOException {
        int uid = XmlUtils.readIntAttribute(parser, "uid");     // Catch: NumberFormatException -> L26
        String isGrantedString = parser.getAttributeValue(null, "granted");
        if (isGrantedString != null) goto L6;
    L24:
        Slog.e(TAG, "error reading usb permission granted state");
        XmlUtils.skipCurrentTag(parser);
        return;
    L6:
        if (isGrantedString.equals(Boolean.TRUE.toString()) == false) goto L8;
    L10:
        boolean isGranted = isGrantedString.equals(Boolean.TRUE.toString());
        XmlUtils.nextElement(parser);
        if ("usb-device".equals(parser.getName()) == false) goto L18;
        DeviceFilter filter = DeviceFilter.read(parser);
        int idx = this.mDevicePersistentPermissionMap.indexOfKey(filter);
        if (idx < 0) goto L15;
        this.mDevicePersistentPermissionMap.valueAt(idx).put(uid, isGranted);
        return;
    L15:
        SparseBooleanArray permissionsForDevice = new SparseBooleanArray();
        this.mDevicePersistentPermissionMap.put(filter, permissionsForDevice);
        permissionsForDevice.put(uid, isGranted);
        return;
    L18:
        if ("usb-accessory".equals(parser.getName()) == false) goto L34;
        AccessoryFilter filter2 = AccessoryFilter.read(parser);
        int idx2 = this.mAccessoryPersistentPermissionMap.indexOfKey(filter2);
        if (idx2 < 0) goto L22;
        this.mAccessoryPersistentPermissionMap.valueAt(idx2).put(uid, isGranted);
        return;
    L22:
        SparseBooleanArray permissionsForAccessory = new SparseBooleanArray();
        this.mAccessoryPersistentPermissionMap.put(filter2, permissionsForAccessory);
        permissionsForAccessory.put(uid, isGranted);
        return;
    L34:
        return;
    L8:
        if (isGrantedString.equals(Boolean.FALSE.toString()) == true) goto L10;
    L26:
        e = move-exception;
        Slog.e(TAG, "error reading usb permission uid", e);
        XmlUtils.skipCurrentTag(parser);
    }

    private void readPermissionsLocked() {
        this.mDevicePersistentPermissionMap.clear();
        this.mAccessoryPersistentPermissionMap.clear();
        FileInputStream in = this.mPermissionsFile.openRead();     // Catch: Exception -> L18 FileNotFoundException -> L20
        TypedXmlPullParser parser = Xml.resolvePullParser(in);     // Catch: Throwable -> L10
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L10
    L5:
        if (parser.getEventType() == 1) goto L15;
        String tagName = parser.getName();     // Catch: Throwable -> L10
        if ("permission".equals(tagName) == true) goto L9;
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L10
        goto L5
    L9:
        readPermission(parser);     // Catch: Throwable -> L10
        goto L5
    L15:
        if (in == null) goto L43;
        in.close();     // Catch: Exception -> L18 FileNotFoundException -> L20
        return;
    L43:
        return;
    L10:
        th = move-exception;
        if (in != null) goto L31;
    L28:
        throw th;     // Catch: Exception -> L18 FileNotFoundException -> L20
    L31:
        in.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L18 FileNotFoundException -> L20
    L18:
        e = move-exception;
        Slog.e(TAG, "error reading usb permissions file, deleting to start fresh", e);
        this.mPermissionsFile.delete();
        return;
    }

    private void scheduleWritePermissionsLocked() {
        if (this.mIsCopyPermissionsScheduled == false) goto L5;
        return;
    L5:
        this.mIsCopyPermissionsScheduled = true;
        AsyncTask.execute(new UsbUserPermissionManager$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$scheduleWritePermissionsLocked$0() {
        Object r2 = this.mLock;
        monitor-enter(r2);
        int numDevices = this.mDevicePersistentPermissionMap.size();     // Catch: Throwable -> L9
        DeviceFilter[] devices = new DeviceFilter[numDevices];     // Catch: Throwable -> L9
        int[][] uidsForDevices = new int[numDevices][];     // Catch: Throwable -> L9
        boolean[][] grantedValuesForDevices = new boolean[numDevices][];     // Catch: Throwable -> L9
        int deviceIdx = 0;
    L5:
        if (deviceIdx >= numDevices) goto L12;
        devices[deviceIdx] = new DeviceFilter(this.mDevicePersistentPermissionMap.keyAt(deviceIdx));     // Catch: Throwable -> L9
        SparseBooleanArray permissions = this.mDevicePersistentPermissionMap.valueAt(deviceIdx);     // Catch: Throwable -> L9
        int numPermissions = permissions.size();     // Catch: Throwable -> L9
        uidsForDevices[deviceIdx] = new int[numPermissions];     // Catch: Throwable -> L9
        grantedValuesForDevices[deviceIdx] = new boolean[numPermissions];     // Catch: Throwable -> L9
        int permissionIdx = 0;
    L7:
        if (permissionIdx >= numPermissions) goto L11;
        uidsForDevices[deviceIdx][permissionIdx] = permissions.keyAt(permissionIdx);     // Catch: Throwable -> L9
        grantedValuesForDevices[deviceIdx][permissionIdx] = permissions.valueAt(permissionIdx);     // Catch: Throwable -> L9
        permissionIdx = permissionIdx + 1;     // Catch: Throwable -> L9
        goto L7
    L11:
        deviceIdx = deviceIdx + 1;     // Catch: Throwable -> L9
        goto L5
    L12:
        int numAccessories = this.mAccessoryPersistentPermissionMap.size();     // Catch: Throwable -> L9
        AccessoryFilter[] accessories = new AccessoryFilter[numAccessories];     // Catch: Throwable -> L9
        int[][] uidsForAccessories = new int[numAccessories][];     // Catch: Throwable -> L9
        boolean[][] grantedValuesForAccessories = new boolean[numAccessories][];     // Catch: Throwable -> L9
        int accessoryIdx = 0;
    L13:
        if (accessoryIdx >= numAccessories) goto L18;
        accessories[accessoryIdx] = new AccessoryFilter(this.mAccessoryPersistentPermissionMap.keyAt(accessoryIdx));     // Catch: Throwable -> L9
        SparseBooleanArray permissions2 = this.mAccessoryPersistentPermissionMap.valueAt(accessoryIdx);     // Catch: Throwable -> L9
        int numPermissions2 = permissions2.size();     // Catch: Throwable -> L9
        uidsForAccessories[accessoryIdx] = new int[numPermissions2];     // Catch: Throwable -> L9
        grantedValuesForAccessories[accessoryIdx] = new boolean[numPermissions2];     // Catch: Throwable -> L9
        int permissionIdx2 = 0;
    L15:
        if (permissionIdx2 >= numPermissions2) goto L17;
        uidsForAccessories[accessoryIdx][permissionIdx2] = permissions2.keyAt(permissionIdx2);     // Catch: Throwable -> L9
        grantedValuesForAccessories[accessoryIdx][permissionIdx2] = permissions2.valueAt(permissionIdx2);     // Catch: Throwable -> L9
        permissionIdx2 = permissionIdx2 + 1;     // Catch: Throwable -> L9
        goto L15
    L17:
        accessoryIdx = accessoryIdx + 1;     // Catch: Throwable -> L9
        goto L13
    L18:
        this.mIsCopyPermissionsScheduled = false;     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        AtomicFile r11 = this.mPermissionsFile;
        monitor-enter(r11);
        FileOutputStream out = null;
        out = this.mPermissionsFile.startWrite();     // Catch: Throwable -> L40 IOException -> L42
        TypedXmlSerializer serializer = Xml.resolveSerializer(out);     // Catch: Throwable -> L40 IOException -> L42
        serializer.startDocument(null, true);     // Catch: Throwable -> L40 IOException -> L42
        serializer.startTag(null, "permissions");     // Catch: Throwable -> L40 IOException -> L42
        int i = 0;
    L24:
        if (i >= numDevices) goto L45;
        int numPermissions3 = uidsForDevices[i].length;     // Catch: Throwable -> L40 IOException -> L42
        int j = 0;
    L26:
        if (j >= numPermissions3) goto L44;
        int numDevices2 = numDevices;
        serializer.startTag(null, "permission");     // Catch: Throwable -> L36 IOException -> L38
        DeviceFilter[] devices2 = devices;
        serializer.attribute(null, "uid", Integer.toString(uidsForDevices[i][j]));     // Catch: Throwable -> L32 IOException -> L34
        serializer.attribute(null, "granted", Boolean.toString(grantedValuesForDevices[i][j]));     // Catch: Throwable -> L32 IOException -> L34
        devices2[i].write(serializer);     // Catch: Throwable -> L32 IOException -> L34
        serializer.endTag(null, "permission");     // Catch: Throwable -> L32 IOException -> L34
        j = j + 1;     // Catch: Throwable -> L32 IOException -> L34
        numDevices = numDevices2;
        devices = devices2;
    L34:
        e = e;
    L54:
        Slog.e(TAG, "Failed to write permissions", e);     // Catch: Throwable -> L32
        if (out == null) goto L57;
        this.mPermissionsFile.failWrite(out);     // Catch: Throwable -> L32
    L57:
        monitor-exit(r11);     // Catch: Throwable -> L32
        return;
    L38:
        e = e;
    L36:
        th = th;
    L59:
        monitor-exit(r11);     // Catch: Throwable -> L32
        throw th;
    L44:
        i = i + 1;     // Catch: Throwable -> L32 IOException -> L34
        goto L24
    L45:
        int i2 = 0;
    L46:
        if (i2 >= numAccessories) goto L51;
        int numPermissions4 = uidsForAccessories[i2].length;     // Catch: Throwable -> L32 IOException -> L34
        int j2 = 0;
    L48:
        if (j2 >= numPermissions4) goto L50;
        serializer.startTag(null, "permission");     // Catch: Throwable -> L32 IOException -> L34
        serializer.attribute(null, "uid", Integer.toString(uidsForAccessories[i2][j2]));     // Catch: Throwable -> L32 IOException -> L34
        serializer.attribute(null, "granted", Boolean.toString(grantedValuesForDevices[i2][j2]));     // Catch: Throwable -> L32 IOException -> L34
        accessories[i2].write(serializer);     // Catch: Throwable -> L32 IOException -> L34
        serializer.endTag(null, "permission");     // Catch: Throwable -> L32 IOException -> L34
        j2 = j2 + 1;     // Catch: Throwable -> L32 IOException -> L34
        goto L48
    L50:
        i2 = i2 + 1;     // Catch: Throwable -> L32 IOException -> L34
        goto L46
    L51:
        serializer.endTag(null, "permissions");     // Catch: Throwable -> L32 IOException -> L34
        serializer.endDocument();     // Catch: Throwable -> L32 IOException -> L34
        this.mPermissionsFile.finishWrite(out);     // Catch: Throwable -> L32 IOException -> L34
    L32:
        th = th;
    L42:
        e = e;
    L40:
        th = th;
    L9:
        th = move-exception;
        throw th;
    }

    void requestPermissionDialog(UsbDevice device, UsbAccessory accessory, boolean canBeDefault, String packageName, int uid, Context userContext, PendingIntent pi) {
        long identity = Binder.clearCallingIdentity();
        Intent intent = new Intent();     // Catch: Throwable -> L6 ActivityNotFoundException -> L8
        if (device == null) goto L10;
        intent.putExtra("device", device);     // Catch: Throwable -> L6 ActivityNotFoundException -> L8
    L11:
        intent.putExtra("android.intent.extra.INTENT", pi);     // Catch: Throwable -> L6 ActivityNotFoundException -> L8
        intent.putExtra("android.intent.extra.UID", uid);     // Catch: Throwable -> L6 ActivityNotFoundException -> L8
        intent.putExtra("android.hardware.usb.extra.CAN_BE_DEFAULT", canBeDefault);     // Catch: Throwable -> L6 ActivityNotFoundException -> L8
        intent.putExtra("android.hardware.usb.extra.PACKAGE", packageName);     // Catch: Throwable -> L6 ActivityNotFoundException -> L8
        intent.setComponent(ComponentName.unflattenFromString(userContext.getResources().getString(R.string.data_usage_limit_snoozed_body)));     // Catch: Throwable -> L6 ActivityNotFoundException -> L8
        intent.addFlags(268435456);     // Catch: Throwable -> L6 ActivityNotFoundException -> L8
        userContext.startActivityAsUser(intent, this.mUser);     // Catch: Throwable -> L6 ActivityNotFoundException -> L8
    L12:
        Binder.restoreCallingIdentity(identity);
        return;
        goto L14
    L10:
        intent.putExtra("accessory", accessory);     // Catch: Throwable -> L6 ActivityNotFoundException -> L8
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L14:
        Slog.e(TAG, "unable to start UsbPermissionActivity");     // Catch: Throwable -> L6
        goto L12
    }

    void dump(DualDumpOutputStream dump, String idName, long id) {
        UsbUserPermissionManager r1 = this;
        long token = dump.start(idName, id);
        Object r5 = r1.mLock;
        monitor-enter(r5);
        dump.write("user_id", 1120986464257L, r1.mUser.getIdentifier());     // Catch: Throwable -> L10
        int numMappings = r1.mDevicePermissionMap.size();     // Catch: Throwable -> L10
        int mappingsIdx = 0;
    L5:
        long r11 = 1138166333441L;
        if (mappingsIdx >= numMappings) goto L13;
        String deviceName = r1.mDevicePermissionMap.keyAt(mappingsIdx);     // Catch: Throwable -> L10
        long devicePermissionToken = dump.start("device_permissions", 2246267895810L);     // Catch: Throwable -> L10
        dump.write("device_name", 1138166333441L, deviceName);     // Catch: Throwable -> L10
        SparseBooleanArray uidList = r1.mDevicePermissionMap.valueAt(mappingsIdx);     // Catch: Throwable -> L10
        int numUids = uidList.size();     // Catch: Throwable -> L10
        int uidsIdx = 0;
    L8:
        if (uidsIdx >= numUids) goto L12;
        dump.write("uids", 2220498092034L, uidList.keyAt(uidsIdx));     // Catch: Throwable -> L10
        uidsIdx = uidsIdx + 1;     // Catch: Throwable -> L10
        uidList = uidList;
        goto L8
    L12:
        dump.end(devicePermissionToken);     // Catch: Throwable -> L10
        mappingsIdx = mappingsIdx + 1;     // Catch: Throwable -> L10
        goto L5
    L13:
        int numMappings2 = r1.mAccessoryPermissionMap.size();     // Catch: Throwable -> L10
        int mappingsIdx2 = 0;
    L14:
        if (mappingsIdx2 >= numMappings2) goto L19;
        UsbAccessory accessory = r1.mAccessoryPermissionMap.keyAt(mappingsIdx2);     // Catch: Throwable -> L10
        long accessoryPermissionToken = dump.start("accessory_permissions", 2246267895811L);     // Catch: Throwable -> L10
        dump.write("accessory_description", r11, accessory.getDescription());     // Catch: Throwable -> L10
        SparseBooleanArray uidList2 = r1.mAccessoryPermissionMap.valueAt(mappingsIdx2);     // Catch: Throwable -> L10
        int numUids2 = uidList2.size();     // Catch: Throwable -> L10
        int uidsIdx2 = 0;
    L16:
        if (uidsIdx2 >= numUids2) goto L18;
        dump.write("uids", 2220498092034L, uidList2.keyAt(uidsIdx2));     // Catch: Throwable -> L10
        uidsIdx2 = uidsIdx2 + 1;     // Catch: Throwable -> L10
        numMappings2 = numMappings2;
        accessory = accessory;
        goto L16
    L18:
        dump.end(accessoryPermissionToken);     // Catch: Throwable -> L10
        mappingsIdx2 = mappingsIdx2 + 1;     // Catch: Throwable -> L10
        numMappings2 = numMappings2;
        r11 = 1138166333441L;
        goto L14
    L19:
        int numMappings3 = r1.mDevicePersistentPermissionMap.size();     // Catch: Throwable -> L10
        int mappingsIdx3 = 0;
    L20:
        long r9 = 1146756268033L;
        if (mappingsIdx3 >= numMappings3) goto L26;
        DeviceFilter filter = r1.mDevicePersistentPermissionMap.keyAt(mappingsIdx3);     // Catch: Throwable -> L10
        long devicePermissionToken2 = dump.start("device_persistent_permissions", 2246267895812L);     // Catch: Throwable -> L10
        filter.dump(dump, "device", 1146756268033L);     // Catch: Throwable -> L10
        SparseBooleanArray permissions = r1.mDevicePersistentPermissionMap.valueAt(mappingsIdx3);     // Catch: Throwable -> L10
        int numPermissions = permissions.size();     // Catch: Throwable -> L10
        int permissionsIdx = 0;
    L23:
        if (permissionsIdx >= numPermissions) goto L25;
        long uidPermissionToken = dump.start("uid_permission", 2246267895810L);     // Catch: Throwable -> L10
        int numMappings4 = numMappings3;
        int numMappings5 = permissions.keyAt(permissionsIdx);     // Catch: Throwable -> L10
        dump.write("uid", 1120986464257L, numMappings5);     // Catch: Throwable -> L10
        dump.write("is_granted", 1133871366146L, permissions.valueAt(permissionsIdx));     // Catch: Throwable -> L10
        dump.end(uidPermissionToken);     // Catch: Throwable -> L10
        permissionsIdx = permissionsIdx + 1;     // Catch: Throwable -> L10
        numMappings3 = numMappings4;
        filter = filter;
        numPermissions = numPermissions;
        goto L23
    L25:
        dump.end(devicePermissionToken2);     // Catch: Throwable -> L10
        mappingsIdx3 = mappingsIdx3 + 1;     // Catch: Throwable -> L10
        numMappings3 = numMappings3;
        goto L20
    L26:
        int numMappings6 = r1.mAccessoryPersistentPermissionMap.size();     // Catch: Throwable -> L10
        int mappingsIdx4 = 0;
    L27:
        if (mappingsIdx4 >= numMappings6) goto L33;
        AccessoryFilter filter2 = r1.mAccessoryPersistentPermissionMap.keyAt(mappingsIdx4);     // Catch: Throwable -> L10
        long accessoryPermissionToken2 = dump.start("accessory_persistent_permissions", 2246267895813L);     // Catch: Throwable -> L10
        filter2.dump(dump, "accessory", r9);     // Catch: Throwable -> L10
        SparseBooleanArray permissions2 = r1.mAccessoryPersistentPermissionMap.valueAt(mappingsIdx4);     // Catch: Throwable -> L10
        int numPermissions2 = permissions2.size();     // Catch: Throwable -> L10
        int permissionsIdx2 = 0;
    L29:
        if (permissionsIdx2 >= numPermissions2) goto L31;
        long uidPermissionToken2 = dump.start("uid_permission", 2246267895810L);     // Catch: Throwable -> L10
        dump.write("uid", 1120986464257L, permissions2.keyAt(permissionsIdx2));     // Catch: Throwable -> L10
        dump.write("is_granted", 1133871366146L, permissions2.valueAt(permissionsIdx2));     // Catch: Throwable -> L10
        dump.end(uidPermissionToken2);     // Catch: Throwable -> L10
        permissionsIdx2 = permissionsIdx2 + 1;     // Catch: Throwable -> L10
        numMappings6 = numMappings6;
        goto L29
    L31:
        dump.end(accessoryPermissionToken2);     // Catch: Throwable -> L10
        mappingsIdx4 = mappingsIdx4 + 1;     // Catch: Throwable -> L10
        r1 = this;
        numMappings6 = numMappings6;
        r9 = 1146756268033L;
        goto L27
    L33:
        monitor-exit(r5);     // Catch: Throwable -> L10
        dump.end(token);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean isCameraPermissionGranted(String packageName, int pid, int uid) {
        ApplicationInfo aInfo = this.mContext.getPackageManager().getApplicationInfo(packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L7
        if (aInfo.uid == uid) goto L9;
        Slog.i(TAG, "Package " + packageName + " does not match caller's uid " + uid);     // Catch: PackageManager.NameNotFoundException -> L7
        return false;
    L9:
        int targetSdkVersion = aInfo.targetSdkVersion;     // Catch: PackageManager.NameNotFoundException -> L7
        if (targetSdkVersion < 28) goto L16;
        int allowed = this.mContext.checkPermission("android.permission.CAMERA", pid, uid);
        if ((-1) != allowed) goto L21;
        Slog.i(TAG, "Camera permission required for USB video class devices");
        return false;
    L21:
        return true;
    L16:
        return true;
    L18:
        Slog.i(TAG, "Package not found, likely due to invalid package name!");
        return false;
    }

    public void checkPermission(UsbDevice device, String packageName, int pid, int uid) {
        if (hasPermission(device, packageName, pid, uid) == false) goto L6;
        return;
    L6:
        throw new SecurityException("User has not given " + uid + SliceClientPermissions.SliceAuthority.DELIMITER + packageName + " permission to access device " + device.getDeviceName());
    }

    public void checkPermission(UsbAccessory accessory, int pid, int uid) {
        if (hasPermission(accessory, pid, uid) == false) goto L6;
        return;
    L6:
        throw new SecurityException("User has not given " + uid + " permission to accessory " + accessory);
    }

    private void requestPermissionDialog(UsbDevice device, UsbAccessory accessory, boolean canBeDefault, String packageName, PendingIntent pi, int uid) {
        boolean throwException = false;
        ApplicationInfo aInfo = this.mContext.getPackageManager().getApplicationInfo(packageName, 0);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L9
        if (aInfo.uid == uid) goto L11;
        Slog.w(TAG, "package " + packageName + " does not match caller's uid " + uid);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L9
        EventLog.writeEvent(SNET_EVENT_LOG_ID, new Object[]{"180104273", -1, ""});     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L9
        throwException = true;
        goto L11
    L11:
        if (throwException == true) goto L14;
    L22:
        requestPermissionDialog(device, accessory, canBeDefault, packageName, uid, this.mContext, pi);
        return;
    L14:
        throw new IllegalArgumentException("package " + packageName + " not found");
    L7:
        th = move-exception;
        if (0 != 0) goto L17;
        throw th;
    L17:
        throw new IllegalArgumentException("package " + packageName + " not found");
    L19:
        throwException = true;
        if (1 == 0) goto L22;
        throw new IllegalArgumentException("package " + packageName + " not found");
    }

    public void requestPermission(UsbDevice device, String packageName, PendingIntent pi, int pid, int uid) {
        Intent intent = new Intent();
        if (hasPermission(device, packageName, pid, uid) == false) goto L10;
        intent.putExtra("device", device);
        intent.putExtra("permission", true);
        pi.send(this.mContext, 0, intent);     // Catch: PendingIntent.CanceledException -> L7
        return;
    L8:
        return;
    L10:
        if (device.getHasVideoCapture() == true) goto L12;
    L18:
        requestPermissionDialog(device, null, this.mUsbUserSettingsManager.canBeDefault(device, packageName), packageName, pi, uid);
        return;
    L12:
        if (isCameraPermissionGranted(packageName, pid, uid) == true) goto L18;
        intent.putExtra("device", device);
        intent.putExtra("permission", false);
        pi.send(this.mContext, 0, intent);     // Catch: PendingIntent.CanceledException -> L16
        return;
    }

    public void requestPermission(UsbAccessory accessory, String packageName, PendingIntent pi, int pid, int uid) {
        if (hasPermission(accessory, pid, uid) == false) goto L9;
        Intent intent = new Intent();
        intent.putExtra("accessory", accessory);
        intent.putExtra("permission", true);
        pi.send(this.mContext, 0, intent);     // Catch: PendingIntent.CanceledException -> L7
        return;
    L8:
        return;
    L9:
        requestPermissionDialog(null, accessory, this.mUsbUserSettingsManager.canBeDefault(accessory, packageName), packageName, pi, uid);
    }
}
