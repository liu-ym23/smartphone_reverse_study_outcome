package ac4;

import android.app.Activity;
import com.bytedance.bdturing.BdTuringConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import kotlin.text.Charsets;
import org.json.JSONObject;
import qb4.n;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f2683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f2684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f2685c;

    public final void a() {
        JSONObject r100 = new JSONObject();
        String r101 = this.f2683a.optString("url");
        String r102 = this.f2683a.optString(com.alipay.sdk.m.p.e.f25671s);
        String r103 = this.f2683a.optString("params");
        JSONObject r104 = this.f2683a.optJSONObject("data");
        boolean r105 = this.f2683a.optBoolean("needCommonParams");
        StringBuilder r106 = null;
        if (r103 != null) goto L37;
    L9:
        JSONObject r107 = null;
    L10:
        if (r105 == false) goto L41;
        if (r107 == null) goto L39;
    L14:
        BdTuringConfig r108 = qb4.b.c.f532315a.f532302a;     // Catch: Exception -> L13
        e r109 = this.f2685c;     // Catch: Exception -> L13
        Activity r110 = r109.f2686a;     // Catch: Exception -> L13
        e.b(r109, r107, r108);     // Catch: Exception -> L13
        goto L41
    L39:
        r107 = new JSONObject();     // Catch: Exception -> L13
    L41:
        if (r107 == null) goto L18;
        StringBuilder r111 = hc4.f.d(r101, r107);     // Catch: Throwable -> L31 Exception -> L36
    L19:
        HashMap r112 = new HashMap();     // Catch: Throwable -> L31 Exception -> L36
        r112.put("Content-Type", "application/x-www-form-urlencoded");     // Catch: Throwable -> L31 Exception -> L36
        ec4.b r113 = qb4.b.c.f532315a.f532302a.getHttpClient();     // Catch: Throwable -> L31 Exception -> L36
        if (MonitorConstants.CONNECT_TYPE_GET.equals(r102) == false) goto L22;
        String r114 = new String(r113.get(r111.toString(), r112), Charsets.UTF_8);     // Catch: Throwable -> L31 Exception -> L36
    L29:
        r100.put("response", r114);     // Catch: Throwable -> L31 Exception -> L36
        goto L34
    L22:
        if (r104 == null) goto L24;
        r106 = hc4.f.e(r104);     // Catch: Throwable -> L31 Exception -> L36
    L24:
        String r115 = r111.toString();     // Catch: Throwable -> L31 Exception -> L36
        if (r106 == null) goto L27;
        String r116 = r106.toString();     // Catch: Throwable -> L31 Exception -> L36
    L28:
        r114 = new String(r113.post(r115, r112, r116.getBytes()), Charsets.UTF_8);     // Catch: Throwable -> L31 Exception -> L36
        goto L29
    L27:
        r116 = "";
        goto L28
    L18:
        r111 = new StringBuilder(r101);     // Catch: Throwable -> L31 Exception -> L36
    L31:
        th = move-exception;
        r100.toString();
        int r117 = n.f532367a;
        this.f2684b.d(1, r100);
        throw th;
    L34:
        r100.toString();
        int r118 = n.f532367a;
        this.f2684b.d(1, r100);
        return;
    L37:
    L8:
        r107 = null;
        goto L41
    L5:
        if (r103.isEmpty() == true) goto L9;
        r107 = new JSONObject(r103);     // Catch: Exception -> L8
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(e r100, JSONObject r101, c r102) {
        this.f2685c = r100;
        this.f2683a = r101;
        this.f2684b = r102;
    }
}
