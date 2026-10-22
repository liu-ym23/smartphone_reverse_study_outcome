package r2;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f23718a;

    public a(Context r10) {
        if (this.f23718a != null) goto L14;
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (this.f23718a != null) goto L10;
        this.f23718a = r10.getSharedPreferences("monitor_downgrade", 0);     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    }

    public DowngradeInfo a() {
        String r10 = this.f23718a.getString("rule", null);
        if (r10 != null) goto L15;
    L14:
        return null;
    L15:
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L5:
        if (r3.a.c() == false) goto L9;
        s3.a.d("APM-Downgrade", "DowngradeData-load-" + r10);     // Catch: JSONException -> L7
    L9:
        DowngradeInfo r11 = DowngradeInfo.a(new JSONObject(r10));     // Catch: JSONException -> L7
        if (System.currentTimeMillis() >= r11.f6735a) goto L14;
        return r11;
    }

    public void b(DowngradeInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.f23718a == null) goto L13;
        JSONObject r11 = r10.b();
        if (r11 == null) goto L14;
        String r12 = r11.toString();
        if (r3.a.c() == false) goto L10;
        s3.a.d("APM-Downgrade", "DowngradeData-save-" + r12);
    L10:
        this.f23718a.edit().putString("rule", r11.toString()).apply();
        return;
    L14:
        return;
    }
}
