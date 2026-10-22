package com.obric.olog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ConfigHandler extends Handler {
    private static final String TAG = "olog ConfigHandler";
    private Context mContext;

    public ConfigHandler(Context r1) {
        this.mContext = r1;
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
        Log.e(TAG, "receive null data");
        return;
    L12:
        Log.i(TAG, "receive config data");
        String r7 = r6.getString("data");     // Catch: JSONException -> L43
        Log.i(TAG, r7);     // Catch: JSONException -> L43
        JSONObject r8 = new JSONObject(r7);     // Catch: JSONException -> L43
        Context r9 = this.mContext;     // Catch: JSONException -> L43
        if (r9 != null) goto L17;
        Log.e(TAG, "context is null");     // Catch: JSONException -> L43
        return;
    L17:
        SharedPreferences.Editor r10 = r9.getSharedPreferences(Constants.CONFIG_FIELD, 0).edit();     // Catch: JSONException -> L43
        if (r8.has(Constants.REPORT_FIELD) == false) goto L23;
        boolean r11 = r8.getBoolean(Constants.REPORT_FIELD);     // Catch: JSONException -> L43
        r10.putBoolean(Constants.REPORT_FIELD, r11);     // Catch: JSONException -> L43
        if (OLog.isInited() == false) goto L23;
        OLog.setReport(r11);     // Catch: JSONException -> L43
    L23:
        if (r8.has(Constants.OUTPUT_TO_LOGD_FIELD) == false) goto L28;
        boolean r5 = r8.getBoolean(Constants.OUTPUT_TO_LOGD_FIELD);     // Catch: JSONException -> L43
        r10.putBoolean(Constants.OUTPUT_TO_LOGD_FIELD, r5);     // Catch: JSONException -> L43
        if (OLog.isInited() == false) goto L28;
        OLog.setOutputToLogd(r5);     // Catch: JSONException -> L43
    L28:
        if (r8.has(Constants.LOG_LEVEL_FIELD) == false) goto L33;
        int r4 = r8.getInt(Constants.LOG_LEVEL_FIELD);     // Catch: JSONException -> L43
        r10.putInt(Constants.LOG_LEVEL_FIELD, r4);     // Catch: JSONException -> L43
        if (OLog.isInited() == false) goto L33;
        OLog.setLogLevel(r4);     // Catch: JSONException -> L43
    L33:
        if (r8.has(Constants.SAVE_TO_DISK_FIELD) == false) goto L36;
        r10.putBoolean(Constants.SAVE_TO_DISK_FIELD, r8.getBoolean(Constants.SAVE_TO_DISK_FIELD));     // Catch: JSONException -> L43
    L36:
        if (r8.has(Constants.MAX_DIR_SIZE_FIELD) == false) goto L39;
        r10.putInt(Constants.MAX_DIR_SIZE_FIELD, r8.getInt(Constants.MAX_DIR_SIZE_FIELD));     // Catch: JSONException -> L43
    L39:
        if (r8.has(Constants.LOG_EXPIRED_DAYS_FIELD) == false) goto L41;
        r10.putInt(Constants.LOG_EXPIRED_DAYS_FIELD, r8.getInt(Constants.LOG_EXPIRED_DAYS_FIELD));     // Catch: JSONException -> L43
    L41:
        r10.apply();     // Catch: JSONException -> L43
    L45:
        super.handleMessage(r12);
        return;
    L43:
        e = move-exception;
        Log.e(TAG, e.getMessage());
        goto L45
    }
}
