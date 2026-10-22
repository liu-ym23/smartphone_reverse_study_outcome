package com.stepos.pps.data.ouc.ems;

import android.os.PersistableBundle;
import android.text.TextUtils;
import com.stepos.pps.data.util.LogUtil;
import com.stepos.pps.push.DataSyncManager;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class EmsConfigSyncManager {
    private static final String TAG = "EmsConfigSyncManager";
    private List<EmsUpdateCallback> callbackList;

    public interface EmsUpdateCallback {
        void onUpdateConfig();
    }

    private static final class ExceptionManagerBuilder {
        static EmsConfigSyncManager sExceptionManager = new EmsConfigSyncManager();

        private ExceptionManagerBuilder() {
        }
    }

    public static EmsConfigSyncManager getInstance() {
        return ExceptionManagerBuilder.sExceptionManager;
    }

    private EmsConfigSyncManager() {
        this.callbackList = new ArrayList();
    }

    public void syncEmsConfig() {
        LogUtil.i(TAG, "Start Sync EMS config...");
        PersistableBundle emsConfigUpdateInfo = getEmsConfigUpdateInfo();
        if (emsConfigUpdateInfo != null) {
            LogUtil.i(TAG, "Begin getEmsConfigFromServer");
            getEmsConfigFromServer(emsConfigUpdateInfo, new DataSyncManager.DownloadListener() { // from class: com.stepos.pps.data.ouc.ems.EmsConfigSyncManager.1
                @Override // com.stepos.pps.push.DataSyncManager.DownloadListener
                public void downSucceeded(String str) throws JSONException {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (!jSONObject.has("code") || jSONObject.getInt("code") != 200) {
                            LogUtil.w(EmsConfigSyncManager.TAG, "get ems config error = " + (jSONObject.has("message") ? jSONObject.getString("message") : ""));
                            return;
                        }
                        if (jSONObject.has(ExceptionManagerStepOS.USER_CONFIG_BUNDLE_DATA)) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject(ExceptionManagerStepOS.USER_CONFIG_BUNDLE_DATA);
                            if (jSONObject2.has("content")) {
                                EmsConfigSyncManager.this.updateEmsConfig(jSONObject2.getString("content"));
                            } else {
                                LogUtil.i(EmsConfigSyncManager.TAG, "No need to update ems config!!!");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override // com.stepos.pps.push.DataSyncManager.DownloadListener
                public void downFailed() {
                    LogUtil.e(EmsConfigSyncManager.TAG, "download ems config failed!!!");
                }
            });
        }
    }

    private PersistableBundle getEmsConfigUpdateInfo() {
        return ExceptionManagerStepOS.getEmsConfigUpdateInfo();
    }

    private void getEmsConfigFromServer(PersistableBundle persistableBundle, DataSyncManager.DownloadListener downloadListener) {
        DataSyncManager.getInstance().fetchEmsConfig(persistableBundle, downloadListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEmsConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            LogUtil.w(TAG, "updateEmsConfig data is empty!!!");
            return;
        }
        LogUtil.i(TAG, "updateEmsConfig data len = " + str.length());
        ExceptionManagerStepOS.updateConfig(str);
        Iterator<EmsUpdateCallback> it = this.callbackList.iterator();
        while (it.hasNext()) {
            it.next().onUpdateConfig();
        }
    }

    public void registerEmsConfigUpdateCallback(EmsUpdateCallback emsUpdateCallback) {
        if (this.callbackList.contains(emsUpdateCallback)) {
            return;
        }
        this.callbackList.add(emsUpdateCallback);
    }

    public void unRegisterEmsConfigUpdateCallback(EmsUpdateCallback emsUpdateCallback) {
        this.callbackList.remove(emsUpdateCallback);
    }
}
