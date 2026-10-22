package com.stepos.pps.data.ouc.cloud;

import android.content.Context;
import com.stepos.cloudsdk.CloudClient;
import com.stepos.cloudsdk.CloudSdk;
import com.stepos.cloudsdk.ICloudListener;
import com.stepos.pps.PPSApplication;
import com.stepos.pps.data.stats.helper.exceptioncode.MetricReporter;
import com.stepos.pps.data.util.DeviceUtils;
import com.stepos.pps.data.util.LogUtil;
import com.stepos.pps.data.util.Utils;
import com.stepos.pps.logpull.LogCollectionGate;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CloudUserConfigManager {
    private static final String CONFIG_APPLY_CODE = "8010004001";
    private static final String CONFIG_APPLY_EVENT = "zy_8010004001";
    public static final String CONFIG_KEY = "key_userconfig";
    private static final String TAG = "CloudUserConfigManager";
    private static volatile CloudUserConfigManager sInstance;
    private CloudClient mCloudClient;
    private final Context mContext;
    private volatile UserConfig mUserConfig = new UserConfig();
    private final ICloudListener mConfigListener = new ICloudListener() { // from class: com.stepos.pps.data.ouc.cloud.CloudUserConfigManager.1
        @Override // com.stepos.cloudsdk.ICloudListener
        public ICloudListener.ResultCode applyInputStream(String str, InputStream inputStream) {
            Throwable th;
            int i;
            IOException iOException;
            long jCurrentTimeMillis = System.currentTimeMillis();
            LogUtil.i(CloudUserConfigManager.TAG, "applyInputStream: key=" + str);
            if (inputStream == null) {
                CloudUserConfigManager.this.reportConfigApply(str, "FILE_NOT_EXIST", false, jCurrentTimeMillis, 0, "inputStream null");
                return ICloudListener.ResultCode.FILE_NOT_EXIST;
            }
            try {
                String all = CloudUserConfigManager.readAll(inputStream);
                int length = all.length();
                try {
                    if (all.isEmpty()) {
                        LogUtil.w(CloudUserConfigManager.TAG, "applyInputStream: empty content for key=" + str);
                        CloudUserConfigManager.this.reportConfigApply(str, "VALUE_EMPTY", false, jCurrentTimeMillis, 0, "empty content");
                        return ICloudListener.ResultCode.VALUE_EMPTY;
                    }
                    CloudUserConfigManager.printFull("received config content (" + all.length() + " bytes):", all);
                    CloudUserConfigManager.this.collectExCodeBeforeSwitch();
                    CloudUserConfigManager.this.mUserConfig = UserConfig.fromJson(all);
                    LogUtil.i(CloudUserConfigManager.TAG, "applyInputStream: local updated " + CloudUserConfigManager.this.mUserConfig);
                    CloudUserConfigManager.this.resolveCurrentUserType();
                    UserTypeManager.set(CloudUserConfigManager.currentVersionType());
                    LogCollectionGate.sync(CloudUserConfigManager.this.mContext, true);
                    CloudUserConfigManager.this.notifyUserTypeChanged();
                    ExceptionManagerStepOS.updateUserConfig(all);
                    i = length;
                    try {
                        CloudUserConfigManager.this.reportConfigApply(str, "SUCCESS", true, jCurrentTimeMillis, i, "");
                        return ICloudListener.ResultCode.SUCCESS;
                    } catch (IOException e) {
                        e = e;
                        iOException = e;
                        LogUtil.e(CloudUserConfigManager.TAG, "applyInputStream IO error: " + iOException.getMessage());
                        CloudUserConfigManager.this.reportConfigApply(str, "FILE_IO_ERROR", false, jCurrentTimeMillis, i, String.valueOf(iOException.getMessage()));
                        return ICloudListener.ResultCode.FILE_IO_ERROR;
                    } catch (Throwable th2) {
                        th = th2;
                        th = th;
                        LogUtil.e(CloudUserConfigManager.TAG, "applyInputStream inner error: " + th.getMessage());
                        CloudUserConfigManager.this.reportConfigApply(str, "INNER_ERROR", false, jCurrentTimeMillis, i, String.valueOf(th.getMessage()));
                        return ICloudListener.ResultCode.INNER_ERROR;
                    }
                } catch (IOException e2) {
                    e = e2;
                    i = length;
                } catch (Throwable th3) {
                    th = th3;
                    i = length;
                }
            } catch (IOException e3) {
                iOException = e3;
                i = 0;
            } catch (Throwable th4) {
                th = th4;
                i = 0;
            }
        }
    };

    public static CloudUserConfigManager get() {
        return sInstance;
    }

    public CloudUserConfigManager(Context context) {
        this.mContext = context.getApplicationContext();
        sInstance = this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUserTypeChanged() {
        PPSApplication pPSApplication = PPSApplication.getInstance();
        if (pPSApplication != null) {
            pPSApplication.onUserTypeChanged();
        }
    }

    public void init() {
        loadFromExceptionManager();
        try {
            Context context = this.mContext;
            CloudSdk.init(context, context.getPackageName());
            CloudClient client = CloudSdk.getClient();
            this.mCloudClient = client;
            client.addListener(CONFIG_KEY, this.mConfigListener);
            this.mCloudClient.registerForUpdates();
            LogUtil.i(TAG, "CloudConfig init done, listening key=key_userconfig");
        } catch (Throwable th) {
            LogUtil.e(TAG, "CloudConfig init failed: " + th.getMessage());
        }
    }

    private void loadFromExceptionManager() {
        try {
            String userConfig = ExceptionManagerStepOS.getUserConfig();
            if (userConfig == null || userConfig.isEmpty()) {
                LogUtil.i(TAG, "loadFromExceptionManager: no userconfig from EM yet");
                UserTypeManager.set(UserTypeManager.DEV);
                LogCollectionGate.sync(this.mContext, true);
                return;
            }
            this.mUserConfig = UserConfig.fromJson(userConfig);
            LogUtil.i(TAG, "loadFromExceptionManager: " + this.mUserConfig);
            resolveCurrentUserType();
            UserTypeManager.set(currentVersionType());
            LogCollectionGate.sync(this.mContext, true);
        } catch (Throwable th) {
            LogUtil.e(TAG, "loadFromExceptionManager failed: " + th.getMessage());
        }
    }

    public UserConfig getUserConfig() {
        return this.mUserConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void collectExCodeBeforeSwitch() {
        try {
            PPSApplication pPSApplication = PPSApplication.getInstance();
            if (pPSApplication == null || !Utils.canLogCollect(this.mContext)) {
                return;
            }
            pPSApplication.getExCodeStatsCollector().getMetricsInner();
            LogUtil.i(TAG, "collectExCodeBeforeSwitch done");
        } catch (Throwable th) {
            LogUtil.e(TAG, "collectExCodeBeforeSwitch failed: " + th.getMessage());
        }
    }

    public String resolveCurrentUserType() {
        String publishedType = Utils.getPublishedType();
        String strResolveUserType = this.mUserConfig.resolveUserType(publishedType);
        LogUtil.i(TAG, "resolveCurrentUserType: publishType=" + publishedType + " -> " + strResolveUserType);
        return strResolveUserType;
    }

    public static String currentVersionType() {
        CloudUserConfigManager cloudUserConfigManager = sInstance;
        String strResolveUserType = (cloudUserConfigManager != null ? cloudUserConfigManager.mUserConfig : new UserConfig()).resolveUserType(Utils.getPublishedType());
        if ("beta".equals(strResolveUserType)) {
            return "beta";
        }
        if ("mp".equals(strResolveUserType)) {
            return "mp";
        }
        return UserTypeManager.DEV;
    }

    public void release() {
        try {
            CloudClient cloudClient = this.mCloudClient;
            if (cloudClient != null) {
                cloudClient.unregisterForUpdates();
                this.mCloudClient.removeListener(CONFIG_KEY);
                this.mCloudClient = null;
            }
        } catch (Throwable th) {
            LogUtil.e(TAG, "CloudConfig release failed: " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printFull(String str, String str2) {
        LogUtil.i(TAG, str);
        int length = str2.length();
        if (length <= 3500) {
            LogUtil.i(TAG, str2);
            return;
        }
        int i = (length + 3499) / 3500;
        int i2 = 0;
        int i3 = 1;
        while (i2 < length) {
            int i4 = i2 + 3500;
            LogUtil.i(TAG, "[" + i3 + "/" + i + "] " + str2.substring(i2, Math.min(length, i4)));
            i3++;
            i2 = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String readAll(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportConfigApply(String str, String str2, boolean z, long j, int i, String str3) {
        if (str3 != null) {
            try {
                if (str3.length() > 500) {
                    str3 = str3.substring(0, 500);
                }
            } catch (Throwable th) {
                LogUtil.w(TAG, "reportConfigApply failed: " + th);
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        if (str == null) {
            str = "";
        }
        jSONObject.put("config_key", str);
        jSONObject.put("result", str2);
        jSONObject.put("success", z);
        jSONObject.put("receive_time", String.valueOf(j));
        jSONObject.put("duration_ms", System.currentTimeMillis() - j);
        jSONObject.put("content_bytes", i);
        if (str3 == null) {
            str3 = "";
        }
        jSONObject.put("error_msg", str3);
        jSONObject.put("source_module", "appsandbox");
        jSONObject.put("trigger_time", String.valueOf(System.currentTimeMillis()));
        String deviceId = DeviceUtils.getDeviceId();
        if (deviceId == null) {
            deviceId = "";
        }
        jSONObject.put("deviceOAID", deviceId);
        jSONObject.put("deviceDSID", "");
        jSONObject.put("versionType", currentVersionType());
        MetricReporter.getInstance(this.mContext).report(CONFIG_APPLY_EVENT, jSONObject);
    }
}
