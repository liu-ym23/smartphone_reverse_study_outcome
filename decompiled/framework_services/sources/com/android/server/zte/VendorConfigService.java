package com.android.server.zte;

import android.content.Context;
import android.os.Binder;
import android.os.SystemClock;
import android.util.Log;
import android.util.Slog;
import com.android.server.scene.SceneUtils;
import com.zte.vendorconfig.IVendorConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.compressors.bzip2.BZip2Constants;

/* JADX INFO: loaded from: classes3.dex */
public class VendorConfigService extends IVendorConfig.Stub {
    private static final int KEY_ERR = -1;
    private static final Map<String, List<String>> PERMISSION_PKG_WHITE_LIST = null;
    private static final Map<String, List<Integer>> PERMISSION_WHITE_LIST = null;
    private static final int READ_TYPE = 2;
    private static final String SECURITY_DEVICESIGN = "deviceid.sign";
    private static final String SECURITY_LOG = "log";
    private static final String SECURITY_SEC = "sec";
    public static final String SERVICE_NAME = "vendorconfig";
    private static final String TAG = "VendorConfigService";
    private static final int WRITE_TYPE = 1;
    private Context mContext;

    static native int native_cfg_get_int(String r0, int r1);

    static native String native_cfg_get_str(String r0, String r1);

    static native int native_cfg_set(String r0, String r1);

    static native int native_cfg_set_int(String r0, int r1);

    static native int native_getZoneInfo();

    static native int native_readMinFreeValue(int r0);

    static native int native_unsetcfgbyname(String r0);

    static {
        PERMISSION_WHITE_LIST = new HashMap();
        PERMISSION_PKG_WHITE_LIST = new HashMap();
        List<Integer> ImeiUidList = new ArrayList();
        ImeiUidList.add(1001);
        PERMISSION_WHITE_LIST.put("zte.vendorcfg_imei", ImeiUidList);
        List<Integer> EidUidList = new ArrayList();
        EidUidList.add(1001);
        PERMISSION_WHITE_LIST.put("euicc_eid_first_part0", EidUidList);
        PERMISSION_WHITE_LIST.put("euicc_eid_last_part0", EidUidList);
        PERMISSION_WHITE_LIST.put("euicc_eid_first_part1", EidUidList);
        PERMISSION_WHITE_LIST.put("euicc_eid_last_part1", EidUidList);
        PERMISSION_WHITE_LIST.put("wipe_euicc_flag", EidUidList);
        PERMISSION_WHITE_LIST.put("active_mcc", EidUidList);
        List<String> TransPkgList = new ArrayList();
        TransPkgList.add(SceneUtils.PKG_SYS_UI);
        TransPkgList.add("cn.nubia.colorfullight");
        TransPkgList.add("cn.nubia.cloud");
        TransPkgList.add("com.zte.devicemanager.client");
        PERMISSION_PKG_WHITE_LIST.put("zte_variantflag_switch", TransPkgList);
        PERMISSION_PKG_WHITE_LIST.put("zte_variantflag_ctrl", TransPkgList);
        PERMISSION_PKG_WHITE_LIST.put("zte_variantflag_backup", TransPkgList);
        PERMISSION_PKG_WHITE_LIST.put("zte_variantflag", TransPkgList);
        PERMISSION_PKG_WHITE_LIST.put("nubia_charge_lamp_mode", TransPkgList);
        PERMISSION_PKG_WHITE_LIST.put("nubia_shutdown_charge_enable", TransPkgList);
        PERMISSION_PKG_WHITE_LIST.put("phone_retrieve_status_guide", TransPkgList);
        PERMISSION_PKG_WHITE_LIST.put("phone_retrieve_number", TransPkgList);
        PERMISSION_PKG_WHITE_LIST.put("run_payjoy_state", TransPkgList);
        PERMISSION_PKG_WHITE_LIST.put("disallow.factory.reset", TransPkgList);
    }

    private String getCallingPackagesName(int userId) {
        monitor-enter(this);
        String[] packages = this.mContext.getPackageManager().getPackagesForUid(userId);     // Catch: Throwable -> L10
        if (packages != null) goto L6;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L10
        return null;
    L6:
        if (packages.length <= 0) goto L12;
        String r1 = packages[0];     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean isInPermissionPkgWhiteList(String key, int userId) {
        List<String> pkgList = PERMISSION_PKG_WHITE_LIST.get(key);
        if (pkgList != null) goto L5;
        return false;
    L5:
        Iterator<String> iter = pkgList.iterator();
    L7:
        if (iter.hasNext() == false) goto L13;
        String pkgName = iter.next();
        String callingPkg = getCallingPackagesName(userId);
        Log.w(TAG, "PkgWhiteList: key =" + key + ", pkgName = " + pkgName + ", callingpkg = " + callingPkg);
        if (pkgName != callingPkg) goto L7;
        return true;
    L13:
        return false;
    }

    private boolean isInPermissionWhiteList(String key, int uerId) {
        List<Integer> uidList = PERMISSION_WHITE_LIST.get(key);
        if (uidList != null) goto L5;
        return false;
    L5:
        Iterator<Integer> iter = uidList.iterator();
    L7:
        if (iter.hasNext() == false) goto L13;
        Integer uid = iter.next();
        if (uid.intValue() != uerId) goto L7;
        return true;
    L13:
        return false;
    }

    public VendorConfigService(Context context) {
        this.mContext = context;
        Log.d(TAG, "VendorConfigService Init...");
    }

    private void checkPermission(String key, int type) {
        int callingUid = Binder.getCallingUid() % BZip2Constants.BASEBLOCKSIZE;
        if (callingUid == 1000) goto L25;
        if (callingUid != 0) goto L7;
        return;
    L7:
        if (2 != type) goto L18;
        if (key.indexOf(SECURITY_SEC) == (-1)) goto L11;
    L15:
        Log.w(TAG, "Access denied to process: " + Binder.getCallingPid() + ", only system app can read special vendorcfg " + key);
        throw new SecurityException("Access denied to process: " + Binder.getCallingPid() + ", only system app can read special vendorcfg " + key);
    L11:
        if (key.indexOf(SECURITY_LOG) != (-1)) goto L15;
        if (key.indexOf(SECURITY_DEVICESIGN) != (-1)) goto L15;
        return;
    L18:
        if (isInPermissionWhiteList(key, callingUid) == false) goto L20;
        return;
    L20:
        if (isInPermissionPkgWhiteList(key, callingUid) == true) goto L26;
        Log.w(TAG, "Access denied to process: " + Binder.getCallingPid() + ", only system app can write vendorcfg " + key);
        throw new SecurityException("Access denied to process: " + Binder.getCallingPid() + ", only system app can write vendorcfg " + key);
    L26:
        return;
    }

    public int cfg_set_int(String key, int value) {
        if (key != null) goto L5;
        return -1;
    L5:
        Log.d(TAG, "cfg_set_int key=" + key + " value=" + value);
        checkPermission(key, 1);
        return native_cfg_set_int(key, value);
    }

    public int cfg_set(String key, String value) {
        if (key == null) goto L7;
        if (value == null) goto L9;
        Log.d(TAG, "cfg_set key=" + key + " value=" + value);
        checkPermission(key, 1);
        return native_cfg_set(key, value);
    L9:
        return -1;
    L7:
        return -1;
    }

    public int cfg_get_int(String key, int defaultvalue) {
        if (key != null) goto L5;
        return -1;
    L5:
        Log.d(TAG, "cfg_get_int key=" + key);
        checkPermission(key, 2);
        return native_cfg_get_int(key, defaultvalue);
    }

    public String cfg_get(String key, String defaultvalue) {
        if (key != null) goto L5;
        return null;
    L5:
        Log.d(TAG, "cfg_get key=" + key + " defaultvalue=" + defaultvalue);
        checkPermission(key, 2);
        return native_cfg_get_str(key, defaultvalue);
    }

    public int unsetcfgbyname(String cfgname) {
        if (cfgname != null) goto L5;
        return -1;
    L5:
        Log.d(TAG, "unsetcfgbyname cfgname=" + cfgname);
        checkPermission(cfgname, 1);
        return native_unsetcfgbyname(cfgname);
    }

    public static int getZoneInfo() {
        long startTime = SystemClock.uptimeMillis();
        int free = native_getZoneInfo();
        checkTime(startTime, "getZoneInfo");
        return free;
    }

    public static int readMinFreeValue(int index) {
        Log.d(TAG, "readMinFreeValue index " + index);
        int minfree = native_readMinFreeValue(index);
        Log.d(TAG, "readMinFreeValue minfree " + minfree);
        return minfree;
    }

    private static void checkTime(long startTime, String where) {
        long now = SystemClock.uptimeMillis();
        if ((now - startTime) <= 50) goto L6;
        Slog.w(TAG, "Slow operation: " + (now - startTime) + "ms so far, now at " + where);
        return;
    }
}
