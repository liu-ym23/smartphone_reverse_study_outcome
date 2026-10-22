package com.android.server.usb;

import android.R;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.content.res.XmlResourceParser;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.hardware.usb.AccessoryFilter;
import android.hardware.usb.DeviceFilter;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbDevice;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import com.android.internal.app.IntentForwarderActivity;
import com.android.internal.content.PackageMonitor;
import com.android.internal.util.XmlUtils;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.Settings;
import com.android.server.pm.verify.domain.DomainVerificationPersistence;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.utils.EventLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class UsbProfileGroupSettingsManager {
    private static final boolean DEBUG = false;
    private static final int DUMPSYS_LOG_BUFFER = 200;
    public static final String PROPERTY_RESTRICT_USB_OVERLAY_ACTIVITIES = "android.app.PROPERTY_RESTRICT_USB_OVERLAY_ACTIVITIES";
    private static final String TAG = null;
    private static EventLogger sEventLogger;
    private static final File sSingleUserSettingsFile = null;
    private final ArrayMap<AccessoryFilter, ArraySet<UserPackage>> mAccessoryPreferenceDeniedMap;
    private final HashMap<AccessoryFilter, UserPackage> mAccessoryPreferenceMap;
    private final ActivityManager mActivityManager;
    private final Context mContext;
    private final ArrayMap<DeviceFilter, ArraySet<UserPackage>> mDevicePreferenceDeniedMap;
    private final HashMap<DeviceFilter, UserPackage> mDevicePreferenceMap;
    private final boolean mDisablePermissionDialogs;
    private boolean mIsWriteSettingsScheduled;
    private final Object mLock;
    private final MtpNotificationManager mMtpNotificationManager;
    private final PackageManager mPackageManager;
    MyPackageMonitor mPackageMonitor;
    private final UserHandle mParentUser;
    private final AtomicFile mSettingsFile;
    private final UsbSettingsManager mSettingsManager;
    private final UsbHandlerManager mUsbHandlerManager;
    private final UserManager mUserManager;

    private class MyPackageMonitor extends PackageMonitor {
        final /* synthetic */ UsbProfileGroupSettingsManager this$0;

        /* synthetic */ MyPackageMonitor(UsbProfileGroupSettingsManager r1, UsbProfileGroupSettingsManagerIA r2) {
            this(r1);
        }

        private MyPackageMonitor(UsbProfileGroupSettingsManager r1) {
            this.this$0 = r1;
        }

        public void onPackageAdded(String packageName, int uid) {
            if (UsbProfileGroupSettingsManager.m9193$$Nest$fgetmUserManager(this.this$0).isSameProfileGroup(UsbProfileGroupSettingsManager.m9192$$Nest$fgetmParentUser(this.this$0).getIdentifier(), UserHandle.getUserId(uid)) == true) goto L5;
            return;
        L5:
            UsbProfileGroupSettingsManager.m9194$$Nest$mhandlePackageAdded(this.this$0, new UserPackage(packageName, UserHandle.getUserHandleForUid(uid), null));
        }

        public void onPackageRemoved(String packageName, int uid) {
            if (UsbProfileGroupSettingsManager.m9193$$Nest$fgetmUserManager(this.this$0).isSameProfileGroup(UsbProfileGroupSettingsManager.m9192$$Nest$fgetmParentUser(this.this$0).getIdentifier(), UserHandle.getUserId(uid)) == true) goto L5;
            return;
        L5:
            this.this$0.clearDefaults(packageName, UserHandle.getUserHandleForUid(uid));
        }
    }

    private static class UserPackage {
        final String packageName;
        final UserHandle user;

        /* synthetic */ UserPackage(String r1, UserHandle r2, UsbProfileGroupSettingsManagerIA r3) {
            this(r1, r2);
        }

        private UserPackage(String packageName, UserHandle user) {
            this.packageName = packageName;
            this.user = user;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof UserPackage) == true) goto L5;
            return false;
        L5:
            UserPackage other = (UserPackage) obj;
            if (this.user.equals(other.user) == true) goto L8;
            return false;
        L8:
            if (this.packageName.equals(other.packageName) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            int result = this.user.hashCode();
            return (result * 31) + this.packageName.hashCode();
        }

        public String toString() {
            return this.user.getIdentifier() + SliceClientPermissions.SliceAuthority.DELIMITER + this.packageName;
        }

        public void dump(DualDumpOutputStream dump, String idName, long id) {
            long token = dump.start(idName, id);
            dump.write("user_id", 1120986464257L, this.user.getIdentifier());
            dump.write("package_name", 1138166333442L, this.packageName);
            dump.end(token);
        }
    }

    public static /* synthetic */ String $r8$lambda$EKwCdBYzxQj5W95WKnbyd41VWkU(PackageInfo r0) {
        return lambda$shouldRestrictOverlayActivities$2(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$b09qUnG1pfDzhz9eyYD5fkLLvnA(UsbProfileGroupSettingsManager r0, String r1) {
        return r0.lambda$shouldRestrictOverlayActivities$3(r1);
    }

    public static /* synthetic */ void $r8$lambda$k98yKEZtMSbKfFWkI0FUSlHIZQQ(UsbProfileGroupSettingsManager r0, UsbDevice r1) {
        r0.lambda$new$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$zyS81w72XzjfJGqYXhapQpp-d10, reason: not valid java name */
    public static /* synthetic */ void m9191$r8$lambda$zyS81w72XzjfJGqYXhapQppd10(UsbProfileGroupSettingsManager r0) {
        r0.lambda$scheduleWriteSettingsLocked$1();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmParentUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserHandle m9192$$Nest$fgetmParentUser(UsbProfileGroupSettingsManager r0) {
        return r0.mParentUser;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserManager m9193$$Nest$fgetmUserManager(UsbProfileGroupSettingsManager r0) {
        return r0.mUserManager;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePackageAdded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9194$$Nest$mhandlePackageAdded(UsbProfileGroupSettingsManager r0, UserPackage r1) {
        r0.handlePackageAdded(r1);
    }

    static {
        TAG = UsbProfileGroupSettingsManager.class.getSimpleName();
        sSingleUserSettingsFile = new File("/data/system/usb_device_manager.xml");
    }

    public UsbProfileGroupSettingsManager(Context context, UserHandle user, UsbSettingsManager settingsManager, UsbHandlerManager usbResolveActivityManager) {
        this.mDevicePreferenceMap = new HashMap();
        this.mDevicePreferenceDeniedMap = new ArrayMap();
        this.mAccessoryPreferenceMap = new HashMap();
        this.mAccessoryPreferenceDeniedMap = new ArrayMap();
        this.mLock = new Object();
        this.mPackageMonitor = new MyPackageMonitor(this, null);
        Context parentUserContext = context.createPackageContextAsUser(PackageManagerService.PLATFORM_PACKAGE_NAME, 0, user);     // Catch: PackageManager.NameNotFoundException -> L17
        this.mContext = context;
        this.mPackageManager = context.getPackageManager();
        this.mActivityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
        this.mSettingsManager = settingsManager;
        this.mUserManager = (UserManager) context.getSystemService("user");
        this.mParentUser = user;
        this.mSettingsFile = new AtomicFile(new File(Environment.getUserSystemDirectory(user.getIdentifier()), "usb_device_manager.xml"), "usb-state");
        this.mDisablePermissionDialogs = context.getResources().getBoolean(R.bool.config_dismissDreamOnActivityStart);
        Object r2 = this.mLock;
        monitor-enter(r2);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (UserHandle.SYSTEM.equals(user) == false) goto L11;
        upgradeSingleUserLocked();     // Catch: Throwable -> L9
    L11:
        readSettingsLocked();     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        this.mPackageMonitor.register(context, null, UserHandle.ALL, true);
        this.mMtpNotificationManager = new MtpNotificationManager(parentUserContext, new UsbProfileGroupSettingsManager$$ExternalSyntheticLambda3(this));
        this.mUsbHandlerManager = usbResolveActivityManager;
        sEventLogger = new EventLogger(200, "UsbProfileGroupSettingsManager activity");
        return;
    L19:
        throw new RuntimeException("Missing android package");
    }

    private /* synthetic */ void lambda$new$0(UsbDevice device) {
        resolveActivity(createDeviceAttachedIntent(device), device, false);
    }

    public void unregisterReceivers() {
        this.mPackageMonitor.unregister();
        this.mMtpNotificationManager.unregister();
    }

    void removeUser(UserHandle userToRemove) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean needToPersist = false;
        Iterator<Map.Entry<DeviceFilter, UserPackage>> devicePreferenceIt = this.mDevicePreferenceMap.entrySet().iterator();     // Catch: Throwable -> L11
    L7:
        if (devicePreferenceIt.hasNext() == false) goto L14;
        Map.Entry<DeviceFilter, UserPackage> entry = devicePreferenceIt.next();     // Catch: Throwable -> L11
        if (entry.getValue().user.equals(userToRemove) == false) goto L7;
        devicePreferenceIt.remove();     // Catch: Throwable -> L11
        needToPersist = true;
        goto L7
    L14:
        Iterator<Map.Entry<AccessoryFilter, UserPackage>> accessoryPreferenceIt = this.mAccessoryPreferenceMap.entrySet().iterator();     // Catch: Throwable -> L11
    L16:
        if (accessoryPreferenceIt.hasNext() == false) goto L21;
        Map.Entry<AccessoryFilter, UserPackage> entry2 = accessoryPreferenceIt.next();     // Catch: Throwable -> L11
        if (entry2.getValue().user.equals(userToRemove) == false) goto L16;
        accessoryPreferenceIt.remove();     // Catch: Throwable -> L11
        needToPersist = true;
        goto L16
    L21:
        int numEntries = this.mDevicePreferenceDeniedMap.size();     // Catch: Throwable -> L11
        int i = 0;
    L22:
        if (i >= numEntries) goto L30;
        ArraySet<UserPackage> userPackages = this.mDevicePreferenceDeniedMap.valueAt(i);     // Catch: Throwable -> L11
        int j = userPackages.size() - 1;     // Catch: Throwable -> L11
    L24:
        if (j < 0) goto L29;
        if (userPackages.valueAt(j).user.equals(userToRemove) == false) goto L28;
        userPackages.removeAt(j);     // Catch: Throwable -> L11
        needToPersist = true;
    L28:
        j = j - 1;     // Catch: Throwable -> L11
        goto L24
    L29:
        i = i + 1;     // Catch: Throwable -> L11
        goto L22
    L30:
        int numEntries2 = this.mAccessoryPreferenceDeniedMap.size();     // Catch: Throwable -> L11
        int i2 = 0;
    L31:
        if (i2 >= numEntries2) goto L40;
        ArraySet<UserPackage> userPackages2 = this.mAccessoryPreferenceDeniedMap.valueAt(i2);     // Catch: Throwable -> L11
        int j2 = userPackages2.size() - 1;     // Catch: Throwable -> L11
    L33:
        if (j2 < 0) goto L38;
        if (userPackages2.valueAt(j2).user.equals(userToRemove) == false) goto L37;
        userPackages2.removeAt(j2);     // Catch: Throwable -> L11
        needToPersist = true;
    L37:
        j2 = j2 - 1;     // Catch: Throwable -> L11
        goto L33
    L38:
        i2 = i2 + 1;     // Catch: Throwable -> L11
        goto L31
    L40:
        if (needToPersist == false) goto L42;
        scheduleWriteSettingsLocked();     // Catch: Throwable -> L11
    L42:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void readPreference(XmlPullParser parser) throws IOException, XmlPullParserException {
        String packageName = null;
        UserHandle user = this.mParentUser;
        int count = parser.getAttributeCount();
        int i = 0;
    L3:
        if (i >= count) goto L11;
        if (Settings.ATTR_PACKAGE.equals(parser.getAttributeName(i)) == false) goto L8;
        packageName = parser.getAttributeValue(i);
    L8:
        if ("user".equals(parser.getAttributeName(i)) == false) goto L10;
        user = this.mUserManager.getUserForSerialNumber(Integer.parseInt(parser.getAttributeValue(i)));
    L10:
        i = i + 1;
        goto L3
    L11:
        XmlUtils.nextElement(parser);
        UsbProfileGroupSettingsManagerIA r4 = null;
        if ("usb-device".equals(parser.getName()) == false) goto L18;
        DeviceFilter filter = DeviceFilter.read(parser);
        if (user == null) goto L22;
        this.mDevicePreferenceMap.put(filter, new UserPackage(packageName, user, r4));
    L22:
        XmlUtils.nextElement(parser);
        return;
    L18:
        if ("usb-accessory".equals(parser.getName()) == false) goto L22;
        AccessoryFilter filter2 = AccessoryFilter.read(parser);
        if (user == null) goto L22;
        this.mAccessoryPreferenceMap.put(filter2, new UserPackage(packageName, user, r4));
        goto L22
    }

    private void readPreferenceDeniedList(XmlPullParser parser) throws IOException, XmlPullParserException {
        int outerDepth = parser.getDepth();
        if (XmlUtils.nextElementWithin(parser, outerDepth) == true) goto L5;
        return;
    L5:
        UsbProfileGroupSettingsManagerIA r3 = null;
        if ("usb-device".equals(parser.getName()) == false) goto L26;
        DeviceFilter filter = DeviceFilter.read(parser);
    L9:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L44;
        if ("user-package".equals(parser.getName()) == false) goto L9;
        int userId = XmlUtils.readIntAttribute(parser, "user");     // Catch: ProtocolException -> L15
        String packageName = XmlUtils.readStringAttribute(parser, Settings.ATTR_PACKAGE);     // Catch: ProtocolException -> L15
        if (packageName != null) goto L17;
        Slog.e(TAG, "Unable to parse package name");     // Catch: ProtocolException -> L15
    L17:
        ArraySet<UserPackage> set = this.mDevicePreferenceDeniedMap.get(filter);     // Catch: ProtocolException -> L15
        if (set != null) goto L20;
        set = new ArraySet();     // Catch: ProtocolException -> L15
        this.mDevicePreferenceDeniedMap.put(filter, set);     // Catch: ProtocolException -> L15
    L20:
        set.add(new UserPackage(packageName, UserHandle.of(userId), r3));     // Catch: ProtocolException -> L15
    L15:
        e = move-exception;
        Slog.e(TAG, "Unable to parse user id", e);
    L44:
        if (parser.getDepth() <= outerDepth) goto L46;
        parser.nextTag();
        goto L44
    L46:
        return;
    L26:
        if ("usb-accessory".equals(parser.getName()) == false) goto L44;
        AccessoryFilter filter2 = AccessoryFilter.read(parser);
    L29:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L44;
        if ("user-package".equals(parser.getName()) == false) goto L29;
        int userId2 = XmlUtils.readIntAttribute(parser, "user");     // Catch: ProtocolException -> L35
        String packageName2 = XmlUtils.readStringAttribute(parser, Settings.ATTR_PACKAGE);     // Catch: ProtocolException -> L35
        if (packageName2 != null) goto L37;
        Slog.e(TAG, "Unable to parse package name");     // Catch: ProtocolException -> L35
    L37:
        ArraySet<UserPackage> set2 = this.mAccessoryPreferenceDeniedMap.get(filter2);     // Catch: ProtocolException -> L35
        if (set2 != null) goto L40;
        set2 = new ArraySet();     // Catch: ProtocolException -> L35
        this.mAccessoryPreferenceDeniedMap.put(filter2, set2);     // Catch: ProtocolException -> L35
    L40:
        set2.add(new UserPackage(packageName2, UserHandle.of(userId2), r3));     // Catch: ProtocolException -> L35
    L35:
        e = move-exception;
        Slog.e(TAG, "Unable to parse user id", e);
        goto L29
    }

    private void upgradeSingleUserLocked() {
        if (sSingleUserSettingsFile.exists() == false) goto L25;
        this.mDevicePreferenceMap.clear();
        this.mAccessoryPreferenceMap.clear();
        FileInputStream fis = null;
        fis = new FileInputStream(sSingleUserSettingsFile);     // Catch: Throwable -> L11 Throwable -> L13
        TypedXmlPullParser parser = Xml.resolvePullParser(fis);     // Catch: Throwable -> L11 Throwable -> L13
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L11 Throwable -> L13
    L6:
        if (parser.getEventType() == 1) goto L18;
        String tagName = parser.getName();     // Catch: Throwable -> L11 Throwable -> L13
        if ("preference".equals(tagName) == true) goto L10;
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L11 Throwable -> L13
        goto L6
    L10:
        readPreference(parser);     // Catch: Throwable -> L11 Throwable -> L13
    L18:
        IoUtils.closeQuietly(fis);
        scheduleWriteSettingsLocked();
        sSingleUserSettingsFile.delete();
        return;
    L11:
        th = move-exception;
        IoUtils.closeQuietly(fis);
        throw th;
    L13:
        e = move-exception;
        Log.wtf(TAG, "Failed to read single-user settings", e);     // Catch: Throwable -> L11
        goto L18
    }

    private void readSettingsLocked() {
        this.mDevicePreferenceMap.clear();
        this.mAccessoryPreferenceMap.clear();
        FileInputStream stream = null;
        stream = this.mSettingsFile.openRead();     // Catch: Throwable -> L9 Exception -> L11 FileNotFoundException -> L13
        TypedXmlPullParser parser = Xml.resolvePullParser(stream);     // Catch: Throwable -> L9 Exception -> L11 FileNotFoundException -> L13
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L9 Exception -> L11 FileNotFoundException -> L13
    L4:
        if (parser.getEventType() == 1) goto L21;
        String tagName = parser.getName();     // Catch: Throwable -> L9 Exception -> L11 FileNotFoundException -> L13
        if ("preference".equals(tagName) == true) goto L8;
        if ("preference-denied-list".equals(tagName) == true) goto L17;
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L9 Exception -> L11 FileNotFoundException -> L13
        goto L4
    L17:
        readPreferenceDeniedList(parser);     // Catch: Throwable -> L9 Exception -> L11 FileNotFoundException -> L13
        goto L4
    L8:
        readPreference(parser);     // Catch: Throwable -> L9 Exception -> L11 FileNotFoundException -> L13
        goto L4
    L9:
        th = move-exception;
        IoUtils.closeQuietly(stream);
        throw th;
    L11:
        e = move-exception;
        Slog.e(TAG, "error reading settings file, deleting to start fresh", e);     // Catch: Throwable -> L9
        this.mSettingsFile.delete();     // Catch: Throwable -> L9
    L21:
        IoUtils.closeQuietly(stream);
    }

    private void scheduleWriteSettingsLocked() {
        if (this.mIsWriteSettingsScheduled == false) goto L5;
        return;
    L5:
        this.mIsWriteSettingsScheduled = true;
        AsyncTask.execute(new UsbProfileGroupSettingsManager$$ExternalSyntheticLambda2(this));
    }

    private /* synthetic */ void lambda$scheduleWriteSettingsLocked$1() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        FileOutputStream fos = null;
        fos = this.mSettingsFile.startWrite();     // Catch: Throwable -> L9 IOException -> L11
        TypedXmlSerializer serializer = Xml.resolveSerializer(fos);     // Catch: Throwable -> L9 IOException -> L11
        serializer.startDocument(null, true);     // Catch: Throwable -> L9 IOException -> L11
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);     // Catch: Throwable -> L9 IOException -> L11
        serializer.startTag(null, "settings");     // Catch: Throwable -> L9 IOException -> L11
        Iterator<DeviceFilter> r3 = this.mDevicePreferenceMap.keySet().iterator();     // Catch: Throwable -> L9 IOException -> L11
    L7:
        if (r3.hasNext() == false) goto L13;
        DeviceFilter filter = r3.next();     // Catch: Throwable -> L9 IOException -> L11
        serializer.startTag(null, "preference");     // Catch: Throwable -> L9 IOException -> L11
        serializer.attribute(null, Settings.ATTR_PACKAGE, this.mDevicePreferenceMap.get(filter).packageName);     // Catch: Throwable -> L9 IOException -> L11
        serializer.attribute(null, "user", String.valueOf(getSerial(this.mDevicePreferenceMap.get(filter).user)));     // Catch: Throwable -> L9 IOException -> L11
        filter.write(serializer);     // Catch: Throwable -> L9 IOException -> L11
        serializer.endTag(null, "preference");     // Catch: Throwable -> L9 IOException -> L11
        goto L7
    L13:
        Iterator<AccessoryFilter> r4 = this.mAccessoryPreferenceMap.keySet().iterator();     // Catch: Throwable -> L9 IOException -> L11
    L15:
        if (r4.hasNext() == false) goto L17;
        AccessoryFilter filter2 = r4.next();     // Catch: Throwable -> L9 IOException -> L11
        serializer.startTag(null, "preference");     // Catch: Throwable -> L9 IOException -> L11
        serializer.attribute(null, Settings.ATTR_PACKAGE, this.mAccessoryPreferenceMap.get(filter2).packageName);     // Catch: Throwable -> L9 IOException -> L11
        serializer.attribute(null, "user", String.valueOf(getSerial(this.mAccessoryPreferenceMap.get(filter2).user)));     // Catch: Throwable -> L9 IOException -> L11
        filter2.write(serializer);     // Catch: Throwable -> L9 IOException -> L11
        serializer.endTag(null, "preference");     // Catch: Throwable -> L9 IOException -> L11
        goto L15
    L17:
        int numEntries = this.mDevicePreferenceDeniedMap.size();     // Catch: Throwable -> L9 IOException -> L11
        int i = 0;
    L18:
        if (i >= numEntries) goto L23;
        DeviceFilter filter3 = this.mDevicePreferenceDeniedMap.keyAt(i);     // Catch: Throwable -> L9 IOException -> L11
        ArraySet<UserPackage> userPackageSet = this.mDevicePreferenceDeniedMap.valueAt(i);     // Catch: Throwable -> L9 IOException -> L11
        serializer.startTag(null, "preference-denied-list");     // Catch: Throwable -> L9 IOException -> L11
        filter3.write(serializer);     // Catch: Throwable -> L9 IOException -> L11
        int numUserPackages = userPackageSet.size();     // Catch: Throwable -> L9 IOException -> L11
        int j = 0;
    L20:
        if (j >= numUserPackages) goto L22;
        UserPackage userPackage = userPackageSet.valueAt(j);     // Catch: Throwable -> L9 IOException -> L11
        serializer.startTag(null, "user-package");     // Catch: Throwable -> L9 IOException -> L11
        serializer.attribute(null, "user", String.valueOf(getSerial(userPackage.user)));     // Catch: Throwable -> L9 IOException -> L11
        serializer.attribute(null, Settings.ATTR_PACKAGE, userPackage.packageName);     // Catch: Throwable -> L9 IOException -> L11
        serializer.endTag(null, "user-package");     // Catch: Throwable -> L9 IOException -> L11
        j = j + 1;     // Catch: Throwable -> L9 IOException -> L11
        goto L20
    L22:
        serializer.endTag(null, "preference-denied-list");     // Catch: Throwable -> L9 IOException -> L11
        i = i + 1;     // Catch: Throwable -> L9 IOException -> L11
        goto L18
    L23:
        int numEntries2 = this.mAccessoryPreferenceDeniedMap.size();     // Catch: Throwable -> L9 IOException -> L11
        int i2 = 0;
    L24:
        if (i2 >= numEntries2) goto L29;
        AccessoryFilter filter4 = this.mAccessoryPreferenceDeniedMap.keyAt(i2);     // Catch: Throwable -> L9 IOException -> L11
        ArraySet<UserPackage> userPackageSet2 = this.mAccessoryPreferenceDeniedMap.valueAt(i2);     // Catch: Throwable -> L9 IOException -> L11
        serializer.startTag(null, "preference-denied-list");     // Catch: Throwable -> L9 IOException -> L11
        filter4.write(serializer);     // Catch: Throwable -> L9 IOException -> L11
        int numUserPackages2 = userPackageSet2.size();     // Catch: Throwable -> L9 IOException -> L11
        int j2 = 0;
    L26:
        if (j2 >= numUserPackages2) goto L28;
        UserPackage userPackage2 = userPackageSet2.valueAt(j2);     // Catch: Throwable -> L9 IOException -> L11
        serializer.startTag(null, "user-package");     // Catch: Throwable -> L9 IOException -> L11
        serializer.attribute(null, "user", String.valueOf(getSerial(userPackage2.user)));     // Catch: Throwable -> L9 IOException -> L11
        serializer.attribute(null, Settings.ATTR_PACKAGE, userPackage2.packageName);     // Catch: Throwable -> L9 IOException -> L11
        serializer.endTag(null, "user-package");     // Catch: Throwable -> L9 IOException -> L11
        j2 = j2 + 1;     // Catch: Throwable -> L9 IOException -> L11
        goto L26
    L28:
        serializer.endTag(null, "preference-denied-list");     // Catch: Throwable -> L9 IOException -> L11
        i2 = i2 + 1;     // Catch: Throwable -> L9 IOException -> L11
        goto L24
    L29:
        serializer.endTag(null, "settings");     // Catch: Throwable -> L9 IOException -> L11
        serializer.endDocument();     // Catch: Throwable -> L9 IOException -> L11
        this.mSettingsFile.finishWrite(fos);     // Catch: Throwable -> L9 IOException -> L11
    L35:
        this.mIsWriteSettingsScheduled = false;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L11:
        e = move-exception;
        Slog.e(TAG, "Failed to write settings", e);     // Catch: Throwable -> L9
        if (fos == null) goto L35;
        this.mSettingsFile.failWrite(fos);     // Catch: Throwable -> L9
        goto L35
    }

    static ArrayList<DeviceFilter> getDeviceFilters(PackageManager pm, ResolveInfo info) {
        ArrayList<DeviceFilter> filters = null;
        ActivityInfo ai = info.activityInfo;
        XmlResourceParser parser = null;
        parser = ai.loadXmlMetaData(pm, "android.hardware.usb.action.USB_DEVICE_ATTACHED");     // Catch: Throwable -> L10 Exception -> L12
        if (parser != null) goto L14;
        Slog.w(TAG, "no meta-data for " + info);     // Catch: Throwable -> L10 Exception -> L12
        if (parser == null) goto L39;
        parser.close();
        return null;
    L39:
        return null;
    L14:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L10 Exception -> L12
    L16:
        if (parser.getEventType() == 1) goto L25;
        String tagName = parser.getName();     // Catch: Throwable -> L10 Exception -> L12
        if ("usb-device".equals(tagName) == false) goto L22;
        if (filters != null) goto L21;
        filters = new ArrayList(1);     // Catch: Throwable -> L10 Exception -> L12
    L21:
        filters.add(DeviceFilter.read(parser));     // Catch: Throwable -> L10 Exception -> L12
    L22:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L10 Exception -> L12
    L25:
        parser.close();
    L30:
        return filters;
    L12:
        e = move-exception;
        Slog.w(TAG, "Unable to load component info " + info.toString(), e);     // Catch: Throwable -> L10
        if (0 == 0) goto L30;
    L10:
        th = move-exception;
        if (0 == 0) goto L33;
        parser.close();
    L33:
        throw th;
    }

    static ArrayList<AccessoryFilter> getAccessoryFilters(PackageManager pm, ResolveInfo info) {
        ArrayList<AccessoryFilter> filters = null;
        ActivityInfo ai = info.activityInfo;
        XmlResourceParser parser = null;
        parser = ai.loadXmlMetaData(pm, "android.hardware.usb.action.USB_ACCESSORY_ATTACHED");     // Catch: Throwable -> L10 Exception -> L12
        if (parser != null) goto L14;
        Slog.w(TAG, "no meta-data for " + info);     // Catch: Throwable -> L10 Exception -> L12
        if (parser == null) goto L39;
        parser.close();
        return null;
    L39:
        return null;
    L14:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L10 Exception -> L12
    L16:
        if (parser.getEventType() == 1) goto L25;
        String tagName = parser.getName();     // Catch: Throwable -> L10 Exception -> L12
        if ("usb-accessory".equals(tagName) == false) goto L22;
        if (filters != null) goto L21;
        filters = new ArrayList(1);     // Catch: Throwable -> L10 Exception -> L12
    L21:
        filters.add(AccessoryFilter.read(parser));     // Catch: Throwable -> L10 Exception -> L12
    L22:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L10 Exception -> L12
    L25:
        parser.close();
    L30:
        return filters;
    L12:
        e = move-exception;
        Slog.w(TAG, "Unable to load component info " + info.toString(), e);     // Catch: Throwable -> L10
        if (0 == 0) goto L30;
    L10:
        th = move-exception;
        if (0 == 0) goto L33;
        parser.close();
    L33:
        throw th;
    }

    private boolean packageMatchesLocked(ResolveInfo info, UsbDevice device, UsbAccessory accessory) {
        if (isForwardMatch(info) == false) goto L5;
        return true;
    L5:
        if (device == null) goto L14;
        ArrayList<DeviceFilter> deviceFilters = getDeviceFilters(this.mPackageManager, info);
        if (deviceFilters == null) goto L14;
        int numDeviceFilters = deviceFilters.size();
        int i = 0;
    L9:
        if (i >= numDeviceFilters) goto L14;
        if (deviceFilters.get(i).matches(device) == true) goto L12;
        i = i + 1;
        goto L9
    L12:
        return true;
    L14:
        if (accessory == null) goto L23;
        ArrayList<AccessoryFilter> accessoryFilters = getAccessoryFilters(this.mPackageManager, info);
        if (accessoryFilters == null) goto L29;
        int numAccessoryFilters = accessoryFilters.size();
        int i2 = 0;
    L18:
        if (i2 >= numAccessoryFilters) goto L30;
        if (accessoryFilters.get(i2).matches(accessory) == true) goto L21;
        i2 = i2 + 1;
        goto L18
    L21:
        return true;
    L30:
        return false;
    L29:
        return false;
    L23:
        return false;
    }

    private ArrayList<ResolveInfo> queryIntentActivitiesForAllProfiles(Intent intent) {
        List<UserInfo> profiles = this.mUserManager.getEnabledProfiles(this.mParentUser.getIdentifier());
        ArrayList<ResolveInfo> resolveInfos = new ArrayList();
        int numProfiles = profiles.size();
        int i = 0;
    L3:
        if (i >= numProfiles) goto L6;
        resolveInfos.addAll(this.mSettingsManager.getSettingsForUser(profiles.get(i).id).queryIntentActivities(intent));
        i = i + 1;
        goto L3
    L6:
        return resolveInfos;
    }

    private boolean isForwardMatch(ResolveInfo match) {
        return match.getComponentInfo().name.equals(IntentForwarderActivity.FORWARD_INTENT_TO_MANAGED_PROFILE);
    }

    private ArrayList<ResolveInfo> preferHighPriority(ArrayList<ResolveInfo> matches) {
        SparseArray<ArrayList<ResolveInfo>> highestPriorityMatchesByUserId = new SparseArray();
        SparseIntArray highestPriorityByUserId = new SparseIntArray();
        ArrayList<ResolveInfo> forwardMatches = new ArrayList();
        int numMatches = matches.size();
        int matchNum = 0;
    L3:
        if (matchNum >= numMatches) goto L17;
        ResolveInfo match = matches.get(matchNum);
        if (isForwardMatch(match) == false) goto L8;
        forwardMatches.add(match);
    L16:
        matchNum = matchNum + 1;
        goto L3
    L8:
        if (highestPriorityByUserId.indexOfKey(match.targetUserId) >= 0) goto L10;
        highestPriorityByUserId.put(match.targetUserId, Integer.MIN_VALUE);
        highestPriorityMatchesByUserId.put(match.targetUserId, new ArrayList());
    L10:
        int highestPriority = highestPriorityByUserId.get(match.targetUserId);
        ArrayList<ResolveInfo> highestPriorityMatches = highestPriorityMatchesByUserId.get(match.targetUserId);
        if (match.priority != highestPriority) goto L14;
        highestPriorityMatches.add(match);
        goto L16
    L14:
        if (match.priority <= highestPriority) goto L16;
        highestPriorityByUserId.put(match.targetUserId, match.priority);
        highestPriorityMatches.clear();
        highestPriorityMatches.add(match);
        goto L16
    L17:
        ArrayList<ResolveInfo> combinedMatches = new ArrayList(forwardMatches);
        int numMatchArrays = highestPriorityMatchesByUserId.size();
        int matchArrayNum = 0;
    L18:
        if (matchArrayNum >= numMatchArrays) goto L21;
        combinedMatches.addAll(highestPriorityMatchesByUserId.valueAt(matchArrayNum));
        matchArrayNum = matchArrayNum + 1;
        goto L18
    L21:
        return combinedMatches;
    }

    private ArrayList<ResolveInfo> removeForwardIntentIfNotNeeded(ArrayList<ResolveInfo> rawMatches) {
        int numRawMatches = rawMatches.size();
        int numParentActivityMatches = 0;
        int numNonParentActivityMatches = 0;
        int i = 0;
    L3:
        if (i >= numRawMatches) goto L12;
        ResolveInfo rawMatch = rawMatches.get(i);
        if (isForwardMatch(rawMatch) == true) goto L10;
        if (UserHandle.getUserHandleForUid(rawMatch.activityInfo.applicationInfo.uid).equals(this.mParentUser) == false) goto L9;
        numParentActivityMatches = numParentActivityMatches + 1;
        goto L10
    L9:
        numNonParentActivityMatches = numNonParentActivityMatches + 1;
    L10:
        i = i + 1;
        goto L3
    L12:
        if (numParentActivityMatches == 0) goto L16;
        if (numNonParentActivityMatches == 0) goto L16;
        return rawMatches;
    L16:
        ArrayList<ResolveInfo> matches = new ArrayList(numParentActivityMatches + numNonParentActivityMatches);
        int i2 = 0;
    L17:
        if (i2 >= numRawMatches) goto L23;
        ResolveInfo rawMatch2 = rawMatches.get(i2);
        if (isForwardMatch(rawMatch2) == true) goto L21;
        matches.add(rawMatch2);
    L21:
        i2 = i2 + 1;
        goto L17
    L23:
        return matches;
    }

    private ArrayList<ResolveInfo> getDeviceMatchesLocked(UsbDevice device, Intent intent) {
        ArrayList<ResolveInfo> matches = new ArrayList();
        List<ResolveInfo> resolveInfos = queryIntentActivitiesForAllProfiles(intent);
        int count = resolveInfos.size();
        int i = 0;
    L3:
        if (i >= count) goto L9;
        ResolveInfo resolveInfo = resolveInfos.get(i);
        if (packageMatchesLocked(resolveInfo, device, null) == false) goto L7;
        matches.add(resolveInfo);
    L7:
        i = i + 1;
        goto L3
    L9:
        return removeForwardIntentIfNotNeeded(preferHighPriority(matches));
    }

    private ArrayList<ResolveInfo> getAccessoryMatchesLocked(UsbAccessory accessory, Intent intent) {
        ArrayList<ResolveInfo> matches = new ArrayList();
        List<ResolveInfo> resolveInfos = queryIntentActivitiesForAllProfiles(intent);
        int count = resolveInfos.size();
        int i = 0;
    L3:
        if (i >= count) goto L9;
        ResolveInfo resolveInfo = resolveInfos.get(i);
        if (packageMatchesLocked(resolveInfo, null, accessory) == false) goto L7;
        matches.add(resolveInfo);
    L7:
        i = i + 1;
        goto L3
    L9:
        return removeForwardIntentIfNotNeeded(preferHighPriority(matches));
    }

    public void deviceAttached(UsbDevice device) {
        Intent intent = createDeviceAttachedIntent(device);
        this.mContext.sendBroadcastAsUser(intent, UserHandle.ALL);
        if (shouldRestrictOverlayActivities() == true) goto L6;
        resolveActivity(intent, device, true);
        return;
    }

    private void resolveActivity(Intent intent, UsbDevice device, boolean showMtpNotification) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        ArrayList<ResolveInfo> matches = getDeviceMatchesLocked(device, intent);     // Catch: Throwable -> L14
        ActivityInfo defaultActivity = getDefaultActivityLocked(matches, this.mDevicePreferenceMap.get(new DeviceFilter(device)));     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        if (showMtpNotification == true) goto L8;
    L12:
        resolveActivity(intent, matches, defaultActivity, device, null);
        return;
    L8:
        if (MtpNotificationManager.shouldShowNotification(this.mPackageManager, device) == false) goto L12;
        if (defaultActivity != null) goto L12;
        this.mMtpNotificationManager.showNotification(device);
        return;
    L14:
        th = th;
    L22:
        throw th;
    L18:
        th = th;
        goto L22
    }

    private boolean shouldRestrictOverlayActivities() {
        if (android.provider.Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "user_setup_complete", 1, UserHandle.CURRENT.getIdentifier()) != 0) goto L6;
        Slog.d(TAG, "restricting usb overlay activities as setup is not complete");
        return true;
    L6:
        List<ActivityManager.RunningAppProcessInfo> appProcessInfos = this.mActivityManager.getRunningAppProcesses();
        List<String> filteredAppProcessInfos = new ArrayList();
        Iterator<ActivityManager.RunningAppProcessInfo> r2 = appProcessInfos.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        ActivityManager.RunningAppProcessInfo processInfo = r2.next();
        if (processInfo.importance > 100) goto L8;
        filteredAppProcessInfos.addAll(List.of(processInfo.pkgList));
        goto L8
    L13:
        List<String> packagesHoldingManageUsbPermission = (List) this.mPackageManager.getPackagesHoldingPermissions(new String[]{"android.permission.MANAGE_USB"}, 1048576).stream().map(new UsbProfileGroupSettingsManager$$ExternalSyntheticLambda0()).collect(Collectors.toList());
        filteredAppProcessInfos.retainAll(packagesHoldingManageUsbPermission);
        boolean shouldRestrictOverlayActivities = filteredAppProcessInfos.stream().anyMatch(new UsbProfileGroupSettingsManager$$ExternalSyntheticLambda1(this));
        if (shouldRestrictOverlayActivities == true) goto L16;
        Slog.d(TAG, "starting of usb overlay activities");
    L16:
        return shouldRestrictOverlayActivities;
    }

    private static /* synthetic */ String lambda$shouldRestrictOverlayActivities$2(PackageInfo packageInfo) {
        return packageInfo.packageName;
    }

    private /* synthetic */ boolean lambda$shouldRestrictOverlayActivities$3(String pkg) {
        boolean restrictUsbOverlayActivitiesForPackage = this.mPackageManager.getProperty(PROPERTY_RESTRICT_USB_OVERLAY_ACTIVITIES, pkg).getBoolean();     // Catch: PackageManager.NameNotFoundException -> L6
        if (restrictUsbOverlayActivitiesForPackage == false) goto L8;
        Slog.d(TAG, "restricting usb overlay activities as package " + pkg + " is in foreground");     // Catch: PackageManager.NameNotFoundException -> L6
    L8:
        return restrictUsbOverlayActivitiesForPackage;
    L9:
        return false;
    }

    public void deviceAttachedForFixedHandler(UsbDevice device, ComponentName component) {
        Intent intent = createDeviceAttachedIntent(device);
        this.mContext.sendBroadcastAsUser(intent, UserHandle.of(ActivityManager.getCurrentUser()));
        ApplicationInfo appInfo = this.mPackageManager.getApplicationInfoAsUser(component.getPackageName(), 0, this.mParentUser.getIdentifier());     // Catch: PackageManager.NameNotFoundException -> L10
        this.mSettingsManager.mUsbService.getPermissionsForUser(UserHandle.getUserId(appInfo.uid)).grantDevicePermission(device, appInfo.uid);
        Intent activityIntent = new Intent(intent);
        activityIntent.setComponent(component);
        this.mContext.startActivityAsUser(activityIntent, this.mParentUser);     // Catch: ActivityNotFoundException -> L7
        return;
    L8:
        Slog.e(TAG, "unable to start activity " + activityIntent);
        return;
    L11:
        Slog.e(TAG, "Default USB handling package (" + component.getPackageName() + ") not found  for user " + this.mParentUser);
    }

    void usbDeviceRemoved(UsbDevice device) {
        this.mMtpNotificationManager.hideNotification(device.getDeviceId());
    }

    public void accessoryAttached(UsbAccessory accessory) {
        Intent intent = new Intent("android.hardware.usb.action.USB_ACCESSORY_ATTACHED");
        intent.putExtra("accessory", accessory);
        intent.addFlags(AudioFormat.EVRCB);
        Object r1 = this.mLock;
        monitor-enter(r1);
        ArrayList<ResolveInfo> matches = getAccessoryMatchesLocked(accessory, intent);     // Catch: Throwable -> L8
        ActivityInfo defaultActivity = getDefaultActivityLocked(matches, this.mAccessoryPreferenceMap.get(new AccessoryFilter(accessory)));     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        sEventLogger.enqueue(new EventLogger.StringEvent("accessoryAttached: " + intent));
        resolveActivity(intent, matches, defaultActivity, null, accessory);
        return;
    L8:
        th = th;
    L14:
        throw th;
    L12:
        th = th;
        goto L14
    }

    private void resolveActivity(Intent intent, ArrayList<ResolveInfo> matches, ActivityInfo defaultActivity, UsbDevice device, UsbAccessory accessory) {
        ArraySet<UserPackage> r0 = null;
        if (device == null) goto L5;
        r0 = this.mDevicePreferenceDeniedMap.get(new DeviceFilter(device));
    L8:
        if (r0 == null) goto L15;
        int i = matches.size() - 1;
    L10:
        if (i < 0) goto L15;
        ResolveInfo match = matches.get(i);
        String packageName = match.activityInfo.packageName;
        UserHandle user = UserHandle.getUserHandleForUid(match.activityInfo.applicationInfo.uid);
        if (r0.contains(new UserPackage(packageName, user, null)) == false) goto L14;
        matches.remove(i);
    L14:
        i = i - 1;
    L15:
        int i2 = matches.size();
        if (i2 != 0) goto L20;
        if (accessory == null) goto L41;
        this.mUsbHandlerManager.showUsbAccessoryUriActivity(accessory, this.mParentUser);
        return;
    L41:
        return;
    L20:
        if (defaultActivity == null) goto L32;
        UsbUserPermissionManager defaultRIUserPermissions = this.mSettingsManager.mUsbService.getPermissionsForUser(UserHandle.getUserId(defaultActivity.applicationInfo.uid));
        if (device == null) goto L24;
        defaultRIUserPermissions.grantDevicePermission(device, defaultActivity.applicationInfo.uid);
    L36:
        intent.setComponent(new ComponentName(defaultActivity.packageName, defaultActivity.name));     // Catch: ActivityNotFoundException -> L28
        UserHandle user2 = UserHandle.getUserHandleForUid(defaultActivity.applicationInfo.uid);     // Catch: ActivityNotFoundException -> L28
        this.mContext.startActivityAsUser(intent, user2);     // Catch: ActivityNotFoundException -> L28
        return;
    L28:
        e = move-exception;
        Slog.e(TAG, "startActivity failed", e);
        return;
    L24:
        if (accessory == null) goto L36;
        defaultRIUserPermissions.grantAccessoryPermission(accessory, defaultActivity.applicationInfo.uid);
        goto L36
    L32:
        if (matches.size() != 1) goto L34;
        this.mUsbHandlerManager.confirmUsbHandler(matches.get(0), device, accessory);
        return;
    L34:
        this.mUsbHandlerManager.selectUsbHandler(matches, this.mParentUser, intent);
        return;
    L5:
        if (accessory == null) goto L8;
        r0 = this.mAccessoryPreferenceDeniedMap.get(new AccessoryFilter(accessory));
        goto L8
    }

    private ActivityInfo getDefaultActivityLocked(ArrayList<ResolveInfo> matches, UserPackage userPackage) {
        UsbProfileGroupSettingsManagerIA r0 = null;
        if (userPackage == null) goto L15;
        Iterator<ResolveInfo> r1 = matches.iterator();
    L6:
        if (r1.hasNext() == false) goto L15;
        ResolveInfo info = r1.next();
        if (info.activityInfo == null) goto L6;
        if (userPackage.equals(new UserPackage(info.activityInfo.packageName, UserHandle.getUserHandleForUid(info.activityInfo.applicationInfo.uid), r0)) == false) goto L6;
        return info.activityInfo;
    L15:
        if (matches.size() != 1) goto L26;
        ActivityInfo activityInfo = matches.get(0).activityInfo;
        if (activityInfo == null) goto L26;
        if (this.mDisablePermissionDialogs == false) goto L22;
        return activityInfo;
    L22:
        if (activityInfo.applicationInfo == null) goto L26;
        if ((1 & activityInfo.applicationInfo.flags) == 0) goto L26;
        return activityInfo;
    L26:
        return null;
    }

    private boolean clearCompatibleMatchesLocked(UserPackage userPackage, DeviceFilter filter) {
        ArrayList<DeviceFilter> keysToRemove = new ArrayList();
        Iterator<DeviceFilter> r1 = this.mDevicePreferenceMap.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        DeviceFilter device = r1.next();
        if (filter.contains(device) == false) goto L4;
        UserPackage currentMatch = this.mDevicePreferenceMap.get(device);
        if (currentMatch.equals(userPackage) == true) goto L4;
        keysToRemove.add(device);
        goto L4
    L12:
        if (keysToRemove.isEmpty() == true) goto L18;
        Iterator<DeviceFilter> r2 = keysToRemove.iterator();
    L15:
        if (r2.hasNext() == false) goto L18;
        DeviceFilter keyToRemove = r2.next();
        this.mDevicePreferenceMap.remove(keyToRemove);
    L18:
        return !keysToRemove.isEmpty();
    }

    private boolean clearCompatibleMatchesLocked(UserPackage userPackage, AccessoryFilter filter) {
        ArrayList<AccessoryFilter> keysToRemove = new ArrayList();
        Iterator<AccessoryFilter> r1 = this.mAccessoryPreferenceMap.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        AccessoryFilter accessory = r1.next();
        if (filter.contains(accessory) == false) goto L4;
        UserPackage currentMatch = this.mAccessoryPreferenceMap.get(accessory);
        if (currentMatch.equals(userPackage) == true) goto L4;
        keysToRemove.add(accessory);
        goto L4
    L12:
        if (keysToRemove.isEmpty() == true) goto L18;
        Iterator<AccessoryFilter> r2 = keysToRemove.iterator();
    L15:
        if (r2.hasNext() == false) goto L18;
        AccessoryFilter keyToRemove = r2.next();
        this.mAccessoryPreferenceMap.remove(keyToRemove);
    L18:
        return !keysToRemove.isEmpty();
    }

    private boolean handlePackageAddedLocked(UserPackage userPackage, ActivityInfo aInfo, String metaDataName) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            r0 = 0
            r1 = 0
            android.content.pm.PackageManager r2 = r6.mPackageManager     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            android.content.res.XmlResourceParser r2 = r8.loadXmlMetaData(r2, r9)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            r0 = r2
            if (r0 != 0) goto L12
            if (r0 == 0) goto L10
            r0.close()
        L10:
            r2 = 0
            return r2
        L12:
            com.android.internal.util.XmlUtils.nextElement(r0)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
        L15:
            int r2 = r0.getEventType()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            r3 = 1
            if (r2 == r3) goto L51
            java.lang.String r2 = r0.getName()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            java.lang.String r3 = "usb-device"
            boolean r3 = r3.equals(r2)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            if (r3 == 0) goto L39
            android.hardware.usb.DeviceFilter r3 = android.hardware.usb.DeviceFilter.read(r0)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            boolean r4 = r6.clearCompatibleMatchesLocked(r7, r3)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            if (r4 == 0) goto L34
            r1 = 1
        L34:
            goto L4d
        L35:
            r2 = move-exception
            goto L76
        L37:
            r2 = move-exception
            goto L56
        L39:
            java.lang.String r3 = "usb-accessory"
            boolean r3 = r3.equals(r2)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            if (r3 == 0) goto L4d
            android.hardware.usb.AccessoryFilter r3 = android.hardware.usb.AccessoryFilter.read(r0)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            boolean r4 = r6.clearCompatibleMatchesLocked(r7, r3)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            if (r4 == 0) goto L4d
            r1 = 1
        L4d:
            com.android.internal.util.XmlUtils.nextElement(r0)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            goto L15
        L51:
        L52:
            r0.close()
            goto L75
        L56:
            java.lang.String r3 = com.android.server.usb.UsbProfileGroupSettingsManager.TAG     // Catch: java.lang.Throwable -> L35
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            r4.<init>()     // Catch: java.lang.Throwable -> L35
            java.lang.String r5 = "Unable to load component info "
            r4.append(r5)     // Catch: java.lang.Throwable -> L35
            java.lang.String r5 = r8.toString()     // Catch: java.lang.Throwable -> L35
            r4.append(r5)     // Catch: java.lang.Throwable -> L35
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L35
            android.util.Slog.w(r3, r4, r2)     // Catch: java.lang.Throwable -> L35
            if (r0 == 0) goto L75
            goto L52
        L75:
            return r1
        L76:
            if (r0 == 0) goto L7b
            r0.close()
        L7b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.usb.UsbProfileGroupSettingsManager.handlePackageAddedLocked(com.android.server.usb.UsbProfileGroupSettingsManager$UserPackage, android.content.pm.ActivityInfo, java.lang.String):boolean");
    }

    private void handlePackageAdded(UserPackage userPackage) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean changed = false;
        PackageInfo info = this.mPackageManager.getPackageInfoAsUser(userPackage.packageName, 129, userPackage.user.getIdentifier());     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L27
        ActivityInfo[] activities = info.activities;     // Catch: Throwable -> L10
        if (activities != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        int i = 0;
    L14:
        if (i >= activities.length) goto L23;
        if (handlePackageAddedLocked(userPackage, activities[i], "android.hardware.usb.action.USB_DEVICE_ATTACHED") == false) goto L19;
        changed = true;
    L19:
        if (handlePackageAddedLocked(userPackage, activities[i], "android.hardware.usb.action.USB_ACCESSORY_ATTACHED") == false) goto L21;
        changed = true;
    L21:
        i = i + 1;     // Catch: Throwable -> L10
        goto L14
    L23:
        if (changed == false) goto L25;
        scheduleWriteSettingsLocked();     // Catch: Throwable -> L10
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L27:
        e = move-exception;
        Slog.e(TAG, "handlePackageUpdate could not find package " + userPackage, e);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private int getSerial(UserHandle user) {
        return this.mUserManager.getUserSerialNumber(user.getIdentifier());
    }

    void setDevicePackage(UsbDevice device, String packageName, UserHandle user) {
        DeviceFilter filter = new DeviceFilter(device);
        Object r1 = this.mLock;
        monitor-enter(r1);
        boolean changed = true;
        if (packageName == null) goto L7;
        UserPackage userPackage = new UserPackage(packageName, user, null);     // Catch: Throwable -> L11
        changed = true ^ userPackage.equals(this.mDevicePreferenceMap.get(filter));     // Catch: Throwable -> L11
        if (changed == false) goto L16;
        this.mDevicePreferenceMap.put(filter, userPackage);     // Catch: Throwable -> L11
    L16:
        if (changed == false) goto L18;
        scheduleWriteSettingsLocked();     // Catch: Throwable -> L11
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.mDevicePreferenceMap.remove(filter) != null) goto L16;
        changed = false;
    L11:
        th = move-exception;
        throw th;
    }

    void addDevicePackagesToDenied(UsbDevice device, String[] packageNames, UserHandle user) {
        if (packageNames.length != 0) goto L5;
        return;
    L5:
        DeviceFilter filter = new DeviceFilter(device);
        Object r1 = this.mLock;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mDevicePreferenceDeniedMap.containsKey(filter) == false) goto L12;
        ArraySet<UserPackage> userPackages = this.mDevicePreferenceDeniedMap.get(filter);     // Catch: Throwable -> L10
    L13:
        boolean shouldWrite = false;
        int r4 = packageNames.length;     // Catch: Throwable -> L10
        int r5 = 0;
    L14:
        if (r5 >= r4) goto L19;
        String packageName = packageNames[r5];     // Catch: Throwable -> L10
        UserPackage userPackage = new UserPackage(packageName, user, null);     // Catch: Throwable -> L10
        if (userPackages.contains(userPackage) == true) goto L18;
        userPackages.add(userPackage);     // Catch: Throwable -> L10
        shouldWrite = true;
    L18:
        r5 = r5 + 1;     // Catch: Throwable -> L10
        goto L14
    L19:
        if (shouldWrite == false) goto L21;
        scheduleWriteSettingsLocked();     // Catch: Throwable -> L10
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L12:
        userPackages = new ArraySet();     // Catch: Throwable -> L10
        this.mDevicePreferenceDeniedMap.put(filter, userPackages);     // Catch: Throwable -> L10
        goto L13
    }

    void addAccessoryPackagesToDenied(UsbAccessory accessory, String[] packageNames, UserHandle user) {
        if (packageNames.length != 0) goto L5;
        return;
    L5:
        AccessoryFilter filter = new AccessoryFilter(accessory);
        Object r1 = this.mLock;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mAccessoryPreferenceDeniedMap.containsKey(filter) == false) goto L12;
        ArraySet<UserPackage> userPackages = this.mAccessoryPreferenceDeniedMap.get(filter);     // Catch: Throwable -> L10
    L13:
        boolean shouldWrite = false;
        int r4 = packageNames.length;     // Catch: Throwable -> L10
        int r5 = 0;
    L14:
        if (r5 >= r4) goto L19;
        String packageName = packageNames[r5];     // Catch: Throwable -> L10
        UserPackage userPackage = new UserPackage(packageName, user, null);     // Catch: Throwable -> L10
        if (userPackages.contains(userPackage) == true) goto L18;
        userPackages.add(userPackage);     // Catch: Throwable -> L10
        shouldWrite = true;
    L18:
        r5 = r5 + 1;     // Catch: Throwable -> L10
        goto L14
    L19:
        if (shouldWrite == false) goto L21;
        scheduleWriteSettingsLocked();     // Catch: Throwable -> L10
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L12:
        userPackages = new ArraySet();     // Catch: Throwable -> L10
        this.mAccessoryPreferenceDeniedMap.put(filter, userPackages);     // Catch: Throwable -> L10
        goto L13
    }

    void removeDevicePackagesFromDenied(UsbDevice device, String[] packageNames, UserHandle user) {
        DeviceFilter filter = new DeviceFilter(device);
        Object r1 = this.mLock;
        monitor-enter(r1);
        ArraySet<UserPackage> userPackages = this.mDevicePreferenceDeniedMap.get(filter);     // Catch: Throwable -> L13
        if (userPackages == null) goto L18;
        boolean shouldWrite = false;
        int r4 = packageNames.length;     // Catch: Throwable -> L13
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L16;
        String packageName = packageNames[r5];     // Catch: Throwable -> L13
        UserPackage userPackage = new UserPackage(packageName, user, null);     // Catch: Throwable -> L13
        if (userPackages.contains(userPackage) == false) goto L15;
        userPackages.remove(userPackage);     // Catch: Throwable -> L13
        shouldWrite = true;
        if (userPackages.size() != 0) goto L15;
        this.mDevicePreferenceDeniedMap.remove(filter);     // Catch: Throwable -> L13
    L15:
        r5 = r5 + 1;     // Catch: Throwable -> L13
    L16:
        if (shouldWrite == false) goto L18;
        scheduleWriteSettingsLocked();     // Catch: Throwable -> L13
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    void removeAccessoryPackagesFromDenied(UsbAccessory accessory, String[] packageNames, UserHandle user) {
        AccessoryFilter filter = new AccessoryFilter(accessory);
        Object r1 = this.mLock;
        monitor-enter(r1);
        ArraySet<UserPackage> userPackages = this.mAccessoryPreferenceDeniedMap.get(filter);     // Catch: Throwable -> L13
        if (userPackages == null) goto L18;
        boolean shouldWrite = false;
        int r4 = packageNames.length;     // Catch: Throwable -> L13
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L16;
        String packageName = packageNames[r5];     // Catch: Throwable -> L13
        UserPackage userPackage = new UserPackage(packageName, user, null);     // Catch: Throwable -> L13
        if (userPackages.contains(userPackage) == false) goto L15;
        userPackages.remove(userPackage);     // Catch: Throwable -> L13
        shouldWrite = true;
        if (userPackages.size() != 0) goto L15;
        this.mAccessoryPreferenceDeniedMap.remove(filter);     // Catch: Throwable -> L13
    L15:
        r5 = r5 + 1;     // Catch: Throwable -> L13
    L16:
        if (shouldWrite == false) goto L18;
        scheduleWriteSettingsLocked();     // Catch: Throwable -> L13
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    void setAccessoryPackage(UsbAccessory accessory, String packageName, UserHandle user) {
        AccessoryFilter filter = new AccessoryFilter(accessory);
        Object r1 = this.mLock;
        monitor-enter(r1);
        boolean changed = true;
        if (packageName == null) goto L7;
        UserPackage userPackage = new UserPackage(packageName, user, null);     // Catch: Throwable -> L11
        changed = true ^ userPackage.equals(this.mAccessoryPreferenceMap.get(filter));     // Catch: Throwable -> L11
        if (changed == false) goto L16;
        this.mAccessoryPreferenceMap.put(filter, userPackage);     // Catch: Throwable -> L11
    L16:
        if (changed == false) goto L18;
        scheduleWriteSettingsLocked();     // Catch: Throwable -> L11
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.mAccessoryPreferenceMap.remove(filter) != null) goto L16;
        changed = false;
    L11:
        th = move-exception;
        throw th;
    }

    boolean hasDefaults(String packageName, UserHandle user) {
        UserPackage userPackage = new UserPackage(packageName, user, null);
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mDevicePreferenceMap.values().contains(userPackage) == false) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return true;
    L11:
        boolean r2 = this.mAccessoryPreferenceMap.values().contains(userPackage);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r2;
    }

    void clearDefaults(String packageName, UserHandle user) {
        UserPackage userPackage = new UserPackage(packageName, user, null);
        Object r1 = this.mLock;
        monitor-enter(r1);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (clearPackageDefaultsLocked(userPackage) == false) goto L9;
        scheduleWriteSettingsLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L7
    }

    private boolean clearPackageDefaultsLocked(UserPackage userPackage) {
        boolean cleared = false;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mDevicePreferenceMap.containsValue(userPackage) == false) goto L16;
        DeviceFilter[] keys = (DeviceFilter[]) this.mDevicePreferenceMap.keySet().toArray(new DeviceFilter[0]);     // Catch: Throwable -> L12
        int i = 0;
    L8:
        if (i >= keys.length) goto L16;
        DeviceFilter key = keys[i];     // Catch: Throwable -> L12
        if (userPackage.equals(this.mDevicePreferenceMap.get(key)) == false) goto L14;
        this.mDevicePreferenceMap.remove(key);     // Catch: Throwable -> L12
        cleared = true;
    L14:
        i = i + 1;     // Catch: Throwable -> L12
    L16:
        if (this.mAccessoryPreferenceMap.containsValue(userPackage) == false) goto L24;
        AccessoryFilter[] keys2 = (AccessoryFilter[]) this.mAccessoryPreferenceMap.keySet().toArray(new AccessoryFilter[0]);     // Catch: Throwable -> L12
        int i2 = 0;
    L19:
        if (i2 >= keys2.length) goto L24;
        AccessoryFilter key2 = keys2[i2];     // Catch: Throwable -> L12
        if (userPackage.equals(this.mAccessoryPreferenceMap.get(key2)) == false) goto L23;
        this.mAccessoryPreferenceMap.remove(key2);     // Catch: Throwable -> L12
        cleared = true;
    L23:
        i2 = i2 + 1;     // Catch: Throwable -> L12
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return cleared;
    }

    public void dump(DualDumpOutputStream dump, String idName, long id) {
        long token = dump.start(idName, id);
        Object r3 = this.mLock;
        monitor-enter(r3);
        dump.write("parent_user_id", 1120986464257L, this.mParentUser.getIdentifier());     // Catch: Throwable -> L8
        Iterator<DeviceFilter> r0 = this.mDevicePreferenceMap.keySet().iterator();     // Catch: Throwable -> L8
    L6:
        if (r0.hasNext() == false) goto L10;
        DeviceFilter filter = r0.next();     // Catch: Throwable -> L8
        long devicePrefToken = dump.start("device_preferences", 2246267895810L);     // Catch: Throwable -> L8
        filter.dump(dump, DomainVerificationPersistence.ATTR_FILTER, 1146756268033L);     // Catch: Throwable -> L8
        this.mDevicePreferenceMap.get(filter).dump(dump, "user_package", 1146756268034L);     // Catch: Throwable -> L8
        dump.end(devicePrefToken);     // Catch: Throwable -> L8
        goto L6
    L10:
        Iterator<AccessoryFilter> r1 = this.mAccessoryPreferenceMap.keySet().iterator();     // Catch: Throwable -> L8
    L12:
        if (r1.hasNext() == false) goto L14;
        AccessoryFilter filter2 = r1.next();     // Catch: Throwable -> L8
        long accessoryPrefToken = dump.start("accessory_preferences", 2246267895811L);     // Catch: Throwable -> L8
        filter2.dump(dump, DomainVerificationPersistence.ATTR_FILTER, 1146756268033L);     // Catch: Throwable -> L8
        this.mAccessoryPreferenceMap.get(filter2).dump(dump, "user_package", 1146756268034L);     // Catch: Throwable -> L8
        dump.end(accessoryPrefToken);     // Catch: Throwable -> L8
        goto L12
    L14:
        monitor-exit(r3);     // Catch: Throwable -> L8
        sEventLogger.dump(new DualOutputStreamDumpSink(dump, 1138166333444L));
        dump.end(token);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static Intent createDeviceAttachedIntent(UsbDevice device) {
        Intent intent = new Intent("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intent.putExtra("device", device);
        intent.addFlags(AudioFormat.EVRCB);
        return intent;
    }
}
