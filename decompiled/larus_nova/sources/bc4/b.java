package bc4;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.setting.e;
import com.bytedance.ee.space.sync.PushAction$ESubType;
import ec4.c;
import ec4.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import qb4.c0;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile b f18583e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<JSONObject> f18584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f18585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.bdturing.senseless.a f18587d;

    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONArray f18588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f18589b;

        @Override // ec4.c
        public final void a(xb4.a r100) {
            if (r100.f563110a != 200) goto L5;
            EventReport.W(true, "");
            return;
        L5:
            EventReport.W(false, r100.f563112c);
            b r101 = this.f18589b;
            int r102 = r101.f18586c;
            if (r102 >= 1) goto L10;
            r101.f18586c = r102 + 1;
            r101.b(this.f18588a);
            return;
        }

        @Override // ec4.c
        public final void onError(Throwable r100) {
            EventReport.W(false, "net work error:" + r100);
            b r101 = this.f18589b;
            int r102 = r101.f18586c;
            if (r102 >= 1) goto L6;
            r101.f18586c = r102 + 1;
            r101.b(this.f18588a);
            return;
        }

        public a(b r100, JSONArray r101) {
            this.f18589b = r100;
            this.f18588a = r101;
        }
    }

    public static b a() {
        if (f18583e != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f18583e != null) goto L9;
        f18583e = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f18583e;
    }

    public final void c() {
        com.bytedance.bdturing.senseless.a r100 = this.f18587d;
        int r101 = 0;
        if (r100 == null) goto L10;
        if (r100.f202027b == false) goto L10;
        r100.f202027b = false;
        c0.b r102 = c0.a.f532328a.f532327b;
        if (r102 == null) goto L10;
        r102.removeCallbacks(r100);
    L10:
        if (((ArrayList) this.f18584a).isEmpty() == false) goto L12;
        return;
    L12:
        this.f18586c = 0;
        monitor-enter(b.class);
        JSONArray r103 = new JSONArray();     // Catch: Throwable -> L21
    L16:
        if (r101 >= ((ArrayList) this.f18584a).size()) goto L18;
        r103.put(((ArrayList) this.f18584a).get(r101));     // Catch: Throwable -> L21
        r101 = r101 + 1;     // Catch: Throwable -> L21
        goto L16
    L18:
        ((ArrayList) this.f18584a).clear();     // Catch: Throwable -> L21
        b(r103);     // Catch: Throwable -> L21
        monitor-exit(b.class);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public b() {
        this.f18584a = new ArrayList();
    }

    public final void b(JSONArray r100) {
        if (TextUtils.isEmpty(this.f18585b) == false) goto L13;
        e r101 = e.f202077a;
        String r102 = e.d("verify");
        StringBuilder r103 = new StringBuilder();
        if (TextUtils.isEmpty(r102) == false) goto L7;
    L12:
        r103.append("captcha/report_client_status");
        this.f18585b = r103.toString();
        goto L13
    L7:
        if (r102.startsWith("https://") == true) goto L9;
        r103.append("https://");
    L9:
        r103.append(r102);
        if (r102.endsWith(HTTP.URL_DEFAULT) == true) goto L12;
        r103.append(HTTP.URL_DEFAULT);
    L13:
        String r104 = this.f18585b;
        HashMap r105 = new HashMap();
        r105.put("Content-Type", "application/json; charset=utf-8");
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L16
        r106.put("data_type", "verify_conflict");     // Catch: Exception -> L16
        r106.put("data", r100);     // Catch: Exception -> L16
        new j(r104, null, null, r106, r105).c(new a(this, r100));     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
    }

    public final void d(jc4.a r100) {
        if (r100 != null) goto L29;
        return;
    L29:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L24
        r101.put("log_id", r100.f498093d);     // Catch: Exception -> L24
        r101.put(PushAction$ESubType.KEY_NAME, r100.g());     // Catch: Exception -> L24
        r101.put("detail", r100.f498099j);     // Catch: Exception -> L24
        monitor-enter(b.class);     // Catch: Exception -> L24
        ((ArrayList) this.f18584a).add(r101);     // Catch: Throwable -> L21
        monitor-exit(b.class);     // Catch: Throwable -> L21
    L9:
        if (((ArrayList) this.f18584a).size() < 5) goto L11;
        c();     // Catch: Exception -> L24
        return;
    L11:
        com.bytedance.bdturing.senseless.a r102 = this.f18587d;     // Catch: Exception -> L24
        if (r102 != null) goto L14;
    L16:
        com.bytedance.bdturing.senseless.a r103 = new com.bytedance.bdturing.senseless.a(new bc4.a(this));     // Catch: Exception -> L24
        this.f18587d = r103;     // Catch: Exception -> L24
        if (r103.f202027b == true) goto L32;
        r103.f202027b = true;     // Catch: Exception -> L24
        c0.a.f532328a.b(r103, 10000);     // Catch: Exception -> L24
        return;
    L32:
        return;
    L14:
        if (r102.f202027b == false) goto L16;
        return;
    L21:
        th = move-exception;
        throw th;     // Catch: Exception -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
    }
}
