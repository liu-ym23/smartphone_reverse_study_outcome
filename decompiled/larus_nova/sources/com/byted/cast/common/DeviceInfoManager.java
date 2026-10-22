package com.byted.cast.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.byted.cast.common.bean.DeviceInfo;
import com.byted.cast.common.bean.SinkDeviceInfo;
import com.byted.cast.common.bean.SourceDeviceInfo;
import com.byted.cast.common.source.ServiceInfo;
import com.byted.cast.common.utils.FIFOMap;
import com.byted.cast.common.utils.GsonUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class DeviceInfoManager {
    private static final String TAG = "DeviceInfoManager";
    private static volatile DeviceInfoManager sInstance;
    private DeviceInfo localDeviceInfo;
    private final ContextManager.CastContext mCastContext;
    private final FIFOMap<String, SourceDeviceInfo> sourceDeviceInfoMap;
    private SinkDeviceInfo tempSinkDeviceInfo;

    public void resetSinkDeviceInfo() {
        this.tempSinkDeviceInfo = null;
    }

    public static DeviceInfoManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(DeviceInfoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new DeviceInfoManager(null);     // Catch: Throwable -> L11
    L9:
        monitor-exit(DeviceInfoManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public DeviceInfo getLocalDeviceInfo() {
        DeviceInfo r100 = this.localDeviceInfo;
        if (r100 == null) goto L8;
        if ((r100 instanceof SourceDeviceInfo) == false) goto L8;
        TeaEventTrack r101 = ContextManager.getTeaEventTrack(this.mCastContext);
        DeviceInfo r102 = this.localDeviceInfo;
        String r103 = r101.browseId;
        ((SourceDeviceInfo) r102).browseId = r103;
        String r104 = r101.connectId;
        ((SourceDeviceInfo) r102).connectId = r104;
    L8:
        return this.localDeviceInfo;
    }

    public List<SourceDeviceInfo> getSourceDeviceInfo() {
        ArrayList r100 = new ArrayList();
        Iterator<Map.Entry<String, SourceDeviceInfo>> r101 = this.sourceDeviceInfoMap.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.add(r101.next().getValue());
        goto L4
    L6:
        return r100;
    }

    public SinkDeviceInfo getSinkDeviceInfo() {
        return this.tempSinkDeviceInfo;
    }

    public DeviceInfoManager(ContextManager.CastContext r100) {
        this.sourceDeviceInfoMap = new FIFOMap(5);
        this.mCastContext = r100;
    }

    public static DeviceInfoManager createInstance(ContextManager.CastContext r100) {
        if (r100 != null) goto L6;
        return getInstance();
    L6:
        return new DeviceInfoManager(r100);
    }

    public boolean isSinkDeviceInfoExist(ServiceInfo r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.tempSinkDeviceInfo == null) goto L6;
        return true;
    }

    public void saveSinkDeviceInfo(SinkDeviceInfo r100) {
        Logger.i(TAG, "sinkDeviceInfo:" + r100);
        if (r100 != null) goto L6;
        Logger.e(TAG, "sinkDeviceInfo is null");
        return;
    L6:
        this.tempSinkDeviceInfo = r100;
        TeaEventTrack r101 = ContextManager.getTeaEventTrack(this.mCastContext);
        TeaEventTrack.DeviceTrackInfo r102 = new TeaEventTrack.DeviceTrackInfo();
        r102.did = r100.deviceId;
        r102.userId = r100.userId;
        r102.f33699os = r100.platform;
        r102.deviceModel = r100.deviceModel;
        r102.deviceBrand = r100.deviceBrand;
        r102.deviceName = r100.name;
        r101.setDeviceTrackInfo(r102);
    }

    public void fillSystemInfo(Context r100, DeviceInfo r101) {
        if (r101 == null) goto L11;
        r101.platform = "android";
        r101.osVersion = Build.VERSION.RELEASE;
        r101.deviceModel = Build.MODEL;
        r101.deviceBrand = Build.BRAND;
        r101.supportGetDeviceInfo = true;
        ApplicationInfo r102 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 0);     // Catch: Exception -> L6
        r101.appName = (String) r100.getPackageManager().getApplicationLabel(r102);     // Catch: Exception -> L6
        PackageInfo r103 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0);     // Catch: Exception -> L6
        r101.appVersion = r103.versionName;     // Catch: Exception -> L6
        r101.packageName = r103.packageName;     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void saveLocalSinkDeviceInfo(Context r100, SinkDeviceInfo r101) {
        fillSystemInfo(r100, r101);
        DisplayMetrics r102 = new DisplayMetrics();
        WindowManager r103 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L5
        r103.getDefaultDisplay().getMetrics(r102);     // Catch: Exception -> L5
        r101.width = r102.widthPixels;     // Catch: Exception -> L5
        r101.height = r102.heightPixels;     // Catch: Exception -> L5
        r101.fps = (int) r103.getDefaultDisplay().getRefreshRate();     // Catch: Exception -> L5
    L7:
        r101.ping = 1;
        r101.googleSinkInfo = "Sink Application";
        this.localDeviceInfo = r101;
        return;
    L5:
        e = move-exception;
        Logger.e(TAG, "getDefaultDisplay error:" + e.getMessage());
        goto L7
    }

    public void saveLocalSourceDeviceInfo(Context r100, SourceDeviceInfo r101) {
        fillSystemInfo(r100, r101);
        this.localDeviceInfo = r101;
    }

    public void saveSourceDeviceInfo(String r100, SourceDeviceInfo r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        this.sourceDeviceInfoMap.put(r100, r101);
        ArrayList r102 = new ArrayList();
        Iterator<Map.Entry<String, SourceDeviceInfo>> r103 = this.sourceDeviceInfoMap.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<String, SourceDeviceInfo> r104 = r103.next();
        TeaEventTrack.DeviceTrackInfo r105 = new TeaEventTrack.DeviceTrackInfo();
        r105.did = r104.getValue().deviceId;
        r105.userId = r104.getValue().userId;
        r105.f33699os = r104.getValue().platform;
        r105.deviceModel = r104.getValue().deviceModel;
        r105.deviceBrand = r104.getValue().deviceBrand;
        r105.deviceName = r104.getValue().name;
        r102.add(r105);
        goto L6
    L8:
        ContextManager.getTeaEventTrack(this.mCastContext).setSourceDeviceTrackInfoListStr(GsonUtils.toJsonIgnoreException(r102));
    }
}
