package com.android.server.usb;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.XmlResourceParser;
import android.hardware.usb.AccessoryFilter;
import android.hardware.usb.DeviceFilter;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbDevice;
import android.os.UserHandle;
import android.util.Slog;
import com.android.internal.util.XmlUtils;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.internal.util.dump.DumpUtils;
import com.android.server.am.HostingRecord;
import com.android.server.pm.PackageManagerService;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class UsbUserSettingsManager {
    private static final boolean DEBUG = false;
    private static final String TAG = null;
    private final Object mLock;
    private final PackageManager mPackageManager;
    private final UserHandle mUser;
    private final Context mUserContext;

    static {
        TAG = UsbUserSettingsManager.class.getSimpleName();
    }

    UsbUserSettingsManager(Context context, UserHandle user) {
        this.mLock = new Object();
        this.mUserContext = context.createPackageContextAsUser(PackageManagerService.PLATFORM_PACKAGE_NAME, 0, user);     // Catch: PackageManager.NameNotFoundException -> L6
        this.mPackageManager = this.mUserContext.getPackageManager();
        this.mUser = user;
        return;
    L8:
        throw new RuntimeException("Missing android package");
    }

    public List<ResolveInfo> queryIntentActivities(Intent intent) {
        return this.mPackageManager.queryIntentActivitiesAsUser(intent, 128, this.mUser.getIdentifier());
    }

    boolean canBeDefault(UsbDevice device, String packageName) {
        ActivityInfo[] activities = getPackageActivities(packageName);
        if (activities == null) goto L37;
        int numActivities = activities.length;
        int i = 0;
    L5:
        if (i >= numActivities) goto L54;
        ActivityInfo activityInfo = activities[i];
        XmlResourceParser parser = activityInfo.loadXmlMetaData(this.mPackageManager, "android.hardware.usb.action.USB_DEVICE_ATTACHED");     // Catch: Exception -> L12
        if (parser != null) goto L42;
        if (parser == null) goto L36;
        parser.close();     // Catch: Exception -> L12
    L36:
        i = i + 1;
        goto L5
    L42:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L24
    L17:
        if (parser.getEventType() == 1) goto L28;
        if ("usb-device".equals(parser.getName()) == false) goto L26;
        DeviceFilter filter = DeviceFilter.read(parser);     // Catch: Throwable -> L24
        if (filter.matches(device) == false) goto L26;
        parser.close();     // Catch: Exception -> L12
        return true;
    L26:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L24
        goto L17
    L28:
        parser.close();     // Catch: Exception -> L12
    L24:
        th = move-exception;
        parser.close();     // Catch: Throwable -> L32
    L34:
        throw th;     // Catch: Exception -> L12
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        Slog.w(TAG, "Unable to load component info " + activityInfo.toString(), e);
        goto L36
    L54:
        return false;
    L37:
        return false;
    }

    boolean canBeDefault(UsbAccessory accessory, String packageName) {
        ActivityInfo[] activities = getPackageActivities(packageName);
        if (activities == null) goto L37;
        int numActivities = activities.length;
        int i = 0;
    L5:
        if (i >= numActivities) goto L54;
        ActivityInfo activityInfo = activities[i];
        XmlResourceParser parser = activityInfo.loadXmlMetaData(this.mPackageManager, "android.hardware.usb.action.USB_ACCESSORY_ATTACHED");     // Catch: Exception -> L12
        if (parser != null) goto L42;
        if (parser == null) goto L36;
        parser.close();     // Catch: Exception -> L12
    L36:
        i = i + 1;
        goto L5
    L42:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L24
    L17:
        if (parser.getEventType() == 1) goto L28;
        if ("usb-accessory".equals(parser.getName()) == false) goto L26;
        AccessoryFilter filter = AccessoryFilter.read(parser);     // Catch: Throwable -> L24
        if (filter.matches(accessory) == false) goto L26;
        parser.close();     // Catch: Exception -> L12
        return true;
    L26:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L24
        goto L17
    L28:
        parser.close();     // Catch: Exception -> L12
    L24:
        th = move-exception;
        parser.close();     // Catch: Throwable -> L32
    L34:
        throw th;     // Catch: Exception -> L12
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        Slog.w(TAG, "Unable to load component info " + activityInfo.toString(), e);
        goto L36
    L54:
        return false;
    L37:
        return false;
    }

    private ActivityInfo[] getPackageActivities(String packageName) {
        PackageInfo packageInfo = this.mPackageManager.getPackageInfo(packageName, 129);     // Catch: PackageManager.NameNotFoundException -> L4
        return packageInfo.activities;
    L5:
        return null;
    }

    public void dump(DualDumpOutputStream dump, String idName, long id) {
        long token = dump.start(idName, id);
        Object r5 = this.mLock;
        monitor-enter(r5);
        dump.write("user_id", 1120986464257L, this.mUser.getIdentifier());     // Catch: Throwable -> L11
        List<ResolveInfo> deviceAttachedActivities = queryIntentActivities(new Intent("android.hardware.usb.action.USB_DEVICE_ATTACHED"));     // Catch: Throwable -> L11
        int numDeviceAttachedActivities = deviceAttachedActivities.size();     // Catch: Throwable -> L11
        int activityNum = 0;
    L5:
        if (activityNum >= numDeviceAttachedActivities) goto L16;
        ResolveInfo deviceAttachedActivity = deviceAttachedActivities.get(activityNum);     // Catch: Throwable -> L11
        long deviceAttachedActivityToken = dump.start("device_attached_activities", 2246267895812L);     // Catch: Throwable -> L11
        DumpUtils.writeComponentName(dump, HostingRecord.HOSTING_TYPE_ACTIVITY, 1146756268033L, new ComponentName(deviceAttachedActivity.activityInfo.packageName, deviceAttachedActivity.activityInfo.name));     // Catch: Throwable -> L11
        ArrayList<DeviceFilter> deviceFilters = UsbProfileGroupSettingsManager.getDeviceFilters(this.mPackageManager, deviceAttachedActivity);     // Catch: Throwable -> L11
        if (deviceFilters == null) goto L14;
        int numDeviceFilters = deviceFilters.size();     // Catch: Throwable -> L11
        int filterNum = 0;
    L9:
        if (filterNum >= numDeviceFilters) goto L13;
        deviceFilters.get(filterNum).dump(dump, "filters", 2246267895810L);     // Catch: Throwable -> L11
        filterNum = filterNum + 1;     // Catch: Throwable -> L11
        numDeviceAttachedActivities = numDeviceAttachedActivities;
        activityNum = activityNum;
        goto L9
    L13:
        int numDeviceAttachedActivities2 = numDeviceAttachedActivities;
        int activityNum2 = activityNum;
    L15:
        dump.end(deviceAttachedActivityToken);     // Catch: Throwable -> L11
        activityNum = activityNum2 + 1;     // Catch: Throwable -> L11
        numDeviceAttachedActivities = numDeviceAttachedActivities2;
        goto L5
    L14:
        numDeviceAttachedActivities2 = numDeviceAttachedActivities;
        activityNum2 = activityNum;
        goto L15
    L16:
        List<ResolveInfo> accessoryAttachedActivities = queryIntentActivities(new Intent("android.hardware.usb.action.USB_ACCESSORY_ATTACHED"));     // Catch: Throwable -> L11
        int numAccessoryAttachedActivities = accessoryAttachedActivities.size();     // Catch: Throwable -> L11
        int activityNum3 = 0;
    L17:
        if (activityNum3 >= numAccessoryAttachedActivities) goto L27;
        ResolveInfo accessoryAttachedActivity = accessoryAttachedActivities.get(activityNum3);     // Catch: Throwable -> L11
        long accessoryAttachedActivityToken = dump.start("accessory_attached_activities", 2246267895813L);     // Catch: Throwable -> L11
        DumpUtils.writeComponentName(dump, HostingRecord.HOSTING_TYPE_ACTIVITY, 1146756268033L, new ComponentName(accessoryAttachedActivity.activityInfo.packageName, accessoryAttachedActivity.activityInfo.name));     // Catch: Throwable -> L11
        ArrayList<AccessoryFilter> accessoryFilters = UsbProfileGroupSettingsManager.getAccessoryFilters(this.mPackageManager, accessoryAttachedActivity);     // Catch: Throwable -> L11
        if (accessoryFilters == null) goto L24;
        int numAccessoryFilters = accessoryFilters.size();     // Catch: Throwable -> L11
        int filterNum2 = 0;
    L21:
        if (filterNum2 >= numAccessoryFilters) goto L23;
        accessoryFilters.get(filterNum2).dump(dump, "filters", 2246267895810L);     // Catch: Throwable -> L11
        filterNum2 = filterNum2 + 1;     // Catch: Throwable -> L11
        deviceAttachedActivities = deviceAttachedActivities;
        accessoryAttachedActivities = accessoryAttachedActivities;
        numAccessoryAttachedActivities = numAccessoryAttachedActivities;
        goto L21
    L23:
        List<ResolveInfo> deviceAttachedActivities2 = deviceAttachedActivities;
        List<ResolveInfo> accessoryAttachedActivities2 = accessoryAttachedActivities;
        int numAccessoryAttachedActivities2 = numAccessoryAttachedActivities;
    L25:
        dump.end(accessoryAttachedActivityToken);     // Catch: Throwable -> L11
        activityNum3 = activityNum3 + 1;     // Catch: Throwable -> L11
        deviceAttachedActivities = deviceAttachedActivities2;
        accessoryAttachedActivities = accessoryAttachedActivities2;
        numAccessoryAttachedActivities = numAccessoryAttachedActivities2;
        goto L17
    L24:
        deviceAttachedActivities2 = deviceAttachedActivities;
        accessoryAttachedActivities2 = accessoryAttachedActivities;
        numAccessoryAttachedActivities2 = numAccessoryAttachedActivities;
        goto L25
    L27:
        monitor-exit(r5);     // Catch: Throwable -> L11
        dump.end(token);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
