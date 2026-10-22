package com.obric.olog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ConfigHandler extends Handler {
    private static final String TAG = "olog ConfigHandler";
    private Context mContext;

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public ConfigHandler(Context r3) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    @Override // android.os.Handler
    public void handleMessage(Message r12) {
        if (r12.what == 1011) goto L6;
        return;
    L6:
        if (r12.sendingUid == 1000) goto L8;
        return;
    L8:
        Bundle r6 = r12.getData();
        if (r6 != null) goto L12;
        INVOKESTATIC_com_obric_olog_ConfigHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "receive null data");
        return;
    L12:
        INVOKESTATIC_com_obric_olog_ConfigHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "receive config data");
        String r7 = r6.getString("data");     // Catch: JSONException -> L43
        INVOKESTATIC_com_obric_olog_ConfigHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, r7);     // Catch: JSONException -> L43
        JSONObject r8 = new JSONObject(r7);     // Catch: JSONException -> L43
        Context r9 = this.mContext;     // Catch: JSONException -> L43
        if (r9 != null) goto L17;
        INVOKESTATIC_com_obric_olog_ConfigHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "context is null");     // Catch: JSONException -> L43
        return;
    L17:
        SharedPreferences.Editor r10 = r9.getSharedPreferences("olog_config", 0).edit();     // Catch: JSONException -> L43
        if (r8.has("report") == false) goto L23;
        boolean r11 = r8.getBoolean("report");     // Catch: JSONException -> L43
        r10.putBoolean("report", r11);     // Catch: JSONException -> L43
        if (OLog.isInited() == false) goto L23;
        OLog.setReport(r11);     // Catch: JSONException -> L43
    L23:
        if (r8.has("output_to_logd") == false) goto L28;
        boolean r5 = r8.getBoolean("output_to_logd");     // Catch: JSONException -> L43
        r10.putBoolean("output_to_logd", r5);     // Catch: JSONException -> L43
        if (OLog.isInited() == false) goto L28;
        OLog.setOutputToLogd(r5);     // Catch: JSONException -> L43
    L28:
        if (r8.has("log_level") == false) goto L33;
        int r4 = r8.getInt("log_level");     // Catch: JSONException -> L43
        r10.putInt("log_level", r4);     // Catch: JSONException -> L43
        if (OLog.isInited() == false) goto L33;
        OLog.setLogLevel(r4);     // Catch: JSONException -> L43
    L33:
        if (r8.has("save_to_disk") == false) goto L36;
        r10.putBoolean("save_to_disk", r8.getBoolean("save_to_disk"));     // Catch: JSONException -> L43
    L36:
        if (r8.has("max_dir_size") == false) goto L39;
        r10.putInt("max_dir_size", r8.getInt("max_dir_size"));     // Catch: JSONException -> L43
    L39:
        if (r8.has("log_expired_days") == false) goto L41;
        r10.putInt("log_expired_days", r8.getInt("log_expired_days"));     // Catch: JSONException -> L43
    L41:
        r10.apply();     // Catch: JSONException -> L43
    L45:
        super.handleMessage(r12);
        return;
    L43:
        e = move-exception;
        INVOKESTATIC_com_obric_olog_ConfigHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, e.getMessage());
        goto L45
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_olog_ConfigHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_olog_ConfigHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
