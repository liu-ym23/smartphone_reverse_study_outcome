package jc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.obric.olog.OLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f20987a;

    public a(Context r10) {
        this.f20987a = r10;
    }

    @Override // android.os.Handler
    public void handleMessage(Message r12) {
        if (r12.what == 1011) goto L6;
        return;
    L6:
        if (r12.sendingUid == 1000) goto L8;
        return;
    L8:
        Bundle r10 = r12.getData();
        if (r10 != null) goto L12;
        Log.e("olog ConfigHandler", "receive null data");
        return;
    L12:
        Log.i("olog ConfigHandler", "receive config data");
        String r11 = r10.getString("data");     // Catch: JSONException -> L17
        Log.i("olog ConfigHandler", r11);     // Catch: JSONException -> L17
        JSONObject r13 = new JSONObject(r11);     // Catch: JSONException -> L17
        Context r14 = this.f20987a;     // Catch: JSONException -> L17
        if (r14 != null) goto L19;
        Log.e("olog ConfigHandler", "context is null");     // Catch: JSONException -> L17
        return;
    L19:
        SharedPreferences.Editor r15 = r14.getSharedPreferences("olog_config", 0).edit();     // Catch: JSONException -> L17
        if (r13.has("report") == false) goto L25;
        boolean r16 = r13.getBoolean("report");     // Catch: JSONException -> L17
        r15.putBoolean("report", r16);     // Catch: JSONException -> L17
        if (OLog.j() == false) goto L25;
        OLog.o(r16);     // Catch: JSONException -> L17
    L25:
        if (r13.has("output_to_logd") == false) goto L30;
        boolean r17 = r13.getBoolean("output_to_logd");     // Catch: JSONException -> L17
        r15.putBoolean("output_to_logd", r17);     // Catch: JSONException -> L17
        if (OLog.j() == false) goto L30;
        OLog.n(r17);     // Catch: JSONException -> L17
    L30:
        if (r13.has("log_level") == false) goto L35;
        int r18 = r13.getInt("log_level");     // Catch: JSONException -> L17
        r15.putInt("log_level", r18);     // Catch: JSONException -> L17
        if (OLog.j() == false) goto L35;
        OLog.m(r18);     // Catch: JSONException -> L17
    L35:
        if (r13.has("save_to_disk") == false) goto L38;
        r15.putBoolean("save_to_disk", r13.getBoolean("save_to_disk"));     // Catch: JSONException -> L17
    L38:
        if (r13.has("max_dir_size") == false) goto L41;
        r15.putInt("max_dir_size", r13.getInt("max_dir_size"));     // Catch: JSONException -> L17
    L41:
        if (r13.has("log_expired_days") == false) goto L43;
        r15.putInt("log_expired_days", r13.getInt("log_expired_days"));     // Catch: JSONException -> L17
    L43:
        r15.apply();     // Catch: JSONException -> L17
    L46:
        super.handleMessage(r12);
        return;
    L17:
        e = move-exception;
        Log.e("olog ConfigHandler", e.getMessage());
        goto L46
    }
}
