package com.bytedance.apm6.consumer.slardar.header;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.listener.INtpTimeService;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.SlardarProperties;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.foundation.context.ApmContextAdapter;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.RomUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class HeaderManager {
    private static volatile HeaderManager sInstance;
    private HeaderInfo currentHeaderInfo;
    private Map<String, HeaderInfo> headers;
    private long nptOffset;
    private long nptTime;
    private AsyncTask ntpAsyncTask;

    public HeaderManager() {
        this.headers = new ConcurrentHashMap();
        this.nptOffset = -1;
        this.nptTime = -1;
    }

    static /* synthetic */ long access$002(HeaderManager r0, long r1) {
        r0.nptTime = r1;
        return r1;
    }

    static /* synthetic */ long access$102(HeaderManager r0, long r1) {
        r0.nptOffset = r1;
        return r1;
    }

    static /* synthetic */ AsyncTask access$200(HeaderManager r0) {
        return r0.ntpAsyncTask;
    }

    static /* synthetic */ AsyncTask access$202(HeaderManager r0, AsyncTask r1) {
        r0.ntpAsyncTask = r1;
        return r1;
    }

    public static HeaderManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(HeaderManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new HeaderManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(HeaderManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void init() {
        HeaderInfo r5 = new HeaderInfo();
        r5.setOs("Android");
        r5.setDevicePlatform("android");
        r5.setOsVersion(Build.VERSION.RELEASE);
        r5.setApiVersion(Build.VERSION.SDK_INT);
        r5.setDeviceModel(Build.MODEL);
        r5.setDeviceBrand(Build.BRAND);
        r5.setDeviceManufacturer(Build.MANUFACTURER);
        r5.setProcessName(ApmContext.getCurrentProcessName());
        r5.setSid(ApmContext.getStartId());
        r5.setRomVersion(RomUtils.getRomInfo());
        r5.setVerifyInfo(SlardarProperties.getReleaseBuild());
        r5.setPhoneStartTime(ApmContext.getInitTimeStamp());
        r5.setChannel(ApmContext.getChannel());
        r5.setAid(ApmContext.getAid());
        r5.setUid(ApmContext.getUserID());
        r5.setUpdateVersionCode(String.valueOf(ApmContext.getUpdateVersionCode()));
        r5.setVersionName(ApmContext.getVersionName());
        r5.setVersionCode(String.valueOf(ApmContext.getVersionCode()));
        r5.setAppVersion(ApmContext.getAppVersion());
        r5.setReleaseBuild(ApmContext.getReleaseBuild());
        r5.setPackageName(ApmContext.getContext().getPackageName());
        r5.setCurrentUpdateVersionCode(r5.getUpdateVersionCode());
        r5.setManifestVersionCode(ApmContext.getManifestVersionCode());
        r5.setConfigTime(ApmContext.getConfigTime());
        JSONObject r6 = new JSONObject();
        JsonUtils.copyJson2(r6, ApmContext.getStableHeaderExtras());     // Catch: Exception -> L19
        if (r6.has("version_code") == false) goto L7;
        r6.remove("version_code");     // Catch: Exception -> L19
    L7:
        if (r6.has("app_version") == false) goto L10;
        r6.remove("app_version");     // Catch: Exception -> L19
    L10:
        if (r6.has("uid") == false) goto L13;
        r6.remove("uid");     // Catch: Exception -> L19
    L13:
        if (r6.has("update_version_code") == false) goto L16;
        r6.remove("update_version_code");     // Catch: Exception -> L19
    L16:
        if (r6.has("manifest_version_code") == false) goto L21;
        r6.remove("manifest_version_code");     // Catch: Exception -> L19
    L21:
        r5.setStableExtra(r6);
        r5.setMonitorVersion("5.0.21.21");
        if (ApmContext.isMainProcess() == false) goto L24;
        HeaderStoreManager.getInstance().deleteExpireFile();
    L24:
        saveHeaderInfo(r5);
        return;
    L19:
        e = move-exception;
        Logger.e("APM", "header json exception" + e.toString());
        goto L21
    }

    public HeaderInfo getHeaderInfo(String r3) {
        if (this.headers.containsKey(r3) == false) goto L5;
        HeaderInfo r4 = this.headers.get(r3);
    L8:
        updateHeaderInfo(r4);
        return r4;
    L5:
        HeaderInfo r0 = HeaderStoreManager.getInstance().getHeaderInfo(r3);
        if (r0 == null) goto L11;
        this.headers.put(r3, r0);
        r4 = r0;
        goto L8
    L11:
        return this.currentHeaderInfo;
    }

    private void updateHeaderInfo(HeaderInfo r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5.getDeviceId()) == false) goto L7;
        r5.setDeviceId(ApmContext.getDeviceId());
    L7:
        ApmContextAdapter r0 = ApmContext.getApmContextAdapter();
        if (r0 == null) goto L10;
        r5.setDynamicExtra(r0.getDynamicHeaderExtras());
    L10:
        long r1 = this.nptTime;
        if (r1 == (-1)) goto L13;
        r5.setNtpTime(r1);
        r5.setNtpOffset(this.nptOffset);
    L26:
        if (ApmContext.isDebugMode() == false) goto L28;
        Logger.d(Constants.TAG, "nptTime:" + this.nptTime + " nptOffset:" + this.nptOffset);
    L28:
        r5.setUid(ApmContext.getUserID());
        r5.setConfigTime(ApmContext.getConfigTime());
        HeaderInfo r4 = this.currentHeaderInfo;
        if (r4 == null) goto L34;
        r5.setCurrentUpdateVersionCode(r4.getUpdateVersionCode());
        return;
    L34:
        return;
    L13:
        final INtpTimeService r2 = ApmContext.getNtpTimeService();
        if (r2 == null) goto L26;
        if (this.ntpAsyncTask != null) goto L26;
        monitor-enter(HeaderManager.class);
        this.ntpAsyncTask = new AnonymousClass1(this, r2);     // Catch: Throwable -> L22
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.ntpAsyncTask);     // Catch: Throwable -> L22
        monitor-exit(HeaderManager.class);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    private void saveHeaderInfo(HeaderInfo r3) {
        String r0 = String.valueOf(HeaderUtils.getUniqueHeaderId());
        this.headers.put(r0, r3);
        this.currentHeaderInfo = r3;
        HeaderStoreManager.getInstance().saveHeaderInfo(r0, r3);
    }
}
