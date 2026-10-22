package a5;

import android.content.Context;
import com.bytedance.apm.constant.ReportProtocal;
import com.bytedance.framwork.core.sdklib.net.ILogSendImpl;
import com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask;
import com.bytedance.framwork.core.sdklib.util.ListUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements IMonitorTimeTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f29a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f30b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f31c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f32d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f33e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f34f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f35g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f36h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f37i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f38j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f39k;

    public b(Context r10, String r11) {
        this.f29a = 0;
        this.f30b = 120;
        this.f31c = 100;
        this.f36h = true;
        this.f37i = false;
        this.f34f = r10;
        this.f32d = c.e(r10);
        this.f33e = r11;
    }

    public int a() {
        return b(2147483647L);
    }

    public final int b(long r10) {
        return this.f32d.d(this.f33e, r10);
    }

    public void c() {
        this.f37i = true;
    }

    public final List d(int r10) {
        int r11 = Integer.parseInt(this.f33e);
        return this.f32d.i(r11, r10);
    }

    public final long e() {
        return this.f32d.f(this.f33e);
    }

    public void f() {
        e5.b.e().d(this);
        String r10 = this.f33e;
        d5.b.e(r10, new d5.a(this.f34f, r10));
    }

    public boolean g(boolean r10) {
        if (this.f36h == true) goto L5;
    L20:
        return true;
    L5:
        if (this.f37i == true) goto L20;
        long r11 = System.currentTimeMillis();
        long r12 = e();
        if (r12 > 0) goto L10;
        return true;
    L10:
        if (r10 == false) goto L12;
    L18:
        this.f29a = r11;
        return h();
    L12:
        if (r12 > this.f31c) goto L18;
        if (((r11 - this.f29a) / 1000) > this.f30b) goto L18;
        return false;
    }

    public boolean h() {
        List r10 = d(this.f31c);
        if (ListUtils.a(r10) == false) goto L6;
        return true;
    L6:
        boolean r11 = false;
        JSONArray r12 = new JSONArray();     // Catch: Throwable -> L21
        LinkedList r13 = new LinkedList();     // Catch: Throwable -> L21
        Iterator r14 = r10.iterator();     // Catch: Throwable -> L21
        long r15 = -1;
    L9:
        if (r14.hasNext() == false) goto L16;
        c5.a r16 = (c5.a) r14.next();     // Catch: Throwable -> L21
        long r17 = r16.f6056a;     // Catch: Throwable -> L21
        if (r17 <= r15) goto L13;
        r15 = r17;
    L13:
        String r18 = r16.f6060e;     // Catch: Throwable -> L21
        r13.add(r16);     // Catch: Throwable -> L21
        JSONObject r19 = new JSONObject(r18);     // Catch: Throwable -> L20
        r19.put(ReportProtocal.KEY_LOG_ID, r17);     // Catch: Throwable -> L20
        r19.put("d_s_t", System.currentTimeMillis());     // Catch: Throwable -> L20
        r12.put(r19);     // Catch: Throwable -> L20
        goto L9
    L16:
        r11 = j(r12, false);     // Catch: Throwable -> L21
        if (r11 == false) goto L19;
        b(r15);     // Catch: Throwable -> L21
    L19:
        return r11;
    }

    public void i() {
        this.f36h = true;
        this.f39k = 0;
    }

    public final boolean j(JSONArray r10, boolean r11) {
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L12
        if (com.bytedance.framwork.core.sdklib.util.b.a(r10) == false) goto L6;
        return false;
    L6:
        r12.put("data", r10);     // Catch: Throwable -> L12
        JSONObject r13 = this.f35g;     // Catch: Throwable -> L12
        if (r13 == null) goto L10;
        r12.put("header", r13);     // Catch: Throwable -> L12
        return d5.b.c(this.f33e, r12.toString());
    L10:
        return true;
    L12:
        return false;
    }

    public void k(long r10) {
        this.f36h = false;
        this.f38j = System.currentTimeMillis();
        this.f39k = r10;
    }

    public final void l(JSONObject r10) {
        this.f35g = r10;
    }

    public final void m(int r10) {
        if (r10 > 0) goto L4;
        return;
    L4:
        this.f31c = r10;
    }

    public final void n(int r10) {
        if (r10 > 0) goto L4;
        return;
    L4:
        this.f30b = r10;
    }

    public void o() {
        n(b5.b.e(this.f33e));
        m(b5.b.b(this.f33e));
        l(b5.b.f(this.f33e));
        ILogSendImpl r10 = d5.b.b(this.f33e);
        if ((r10 instanceof d5.a) == false) goto L6;
        ((d5.a) r10).r(null);
        return;
    }

    @Override // com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask
    public void onTimeEvent(long r10) {
        long r11 = this.f39k;
        if (r11 > 0) goto L5;
    L7:
        g(false);
        return;
    L5:
        if ((r10 - this.f38j) <= r11) goto L7;
        i();
        goto L7
    }
}
