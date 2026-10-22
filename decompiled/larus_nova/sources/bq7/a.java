package bq7;

import android.content.Context;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import aq7.c;
import hq7.d;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile a f20039g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f20040h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dq7.a f20042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fq7.a f20043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final eq7.b f20044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final cq7.a f20045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final aq7.a f20046f;

    public final synchronized a c() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f20041a == true) goto L9;
        boolean r100 = hq7.a.f486512a;     // Catch: Throwable -> L11
        this.f20042b.getClass();     // Catch: Throwable -> L11
        this.f20043c.getClass();     // Catch: Throwable -> L11
        eq7.b r101 = this.f20044d;     // Catch: Throwable -> L11
        if (r101.f473506b == true) goto L8;
        r101.f473506b = true;     // Catch: Throwable -> L11
        r101.a();     // Catch: Throwable -> L11
    L8:
        this.f20041a = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return this;
    }

    public final int a() {
        dq7.a r100 = this.f20042b;
        r100.getClass();
        if (hq7.a.f486512a == true) goto L13;
        BatteryManager r101 = r100.f469680c;
        if (r101 == null) goto L18;
        int r102 = r100.f469682e;
        return (int) r101.getLongProperty(4);
    L9:
        e = move-exception;
        e.getMessage();
        boolean r103 = hq7.a.f486512a;
        return r102;
    L18:
        return r100.f469682e;
    L13:
        return r100.f469682e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3 */
    public final c.a b() {
        c.a r100 = new c.a();
        String r101 = com.bytedance.watson.assist.utils.a.f272582a;
        if (r101 != null) goto L6;
        r101 = d.b("ro.board.platform");
        com.bytedance.watson.assist.utils.a.f272582a = r101;
    L6:
        r100.f15914a = r101;
        r100.f15915b = this.f20042b.f469681d;
        r100.f15916c = a();
        fq7.a r102 = this.f20043c;
        ?? r103 = -1;
        if (Build.VERSION.SDK_INT < 29) goto L11;
        PowerManager r104 = r102.f478441b;
        if (r104 == null) goto L12;
        int r105 = r104.getCurrentThermalStatus();
    L13:
        r100.f15917d = r105;
        PowerManager r106 = this.f20042b.f469679b;
        if (r106 == null) goto L16;
        r103 = r106.isPowerSaveMode();
    L16:
        r100.f15918e = r103;
        r100.f15919f = this.f20042b.f469683f;
        ((a) this.f20044d.f20047a).f20046f.getClass();
        return r100;
    L12:
        r105 = -1;
        goto L13
    L11:
        r102.getClass();
        goto L12
    }

    public a(Context r100, aq7.a r101) {
        this.f20041a = false;
        Context r102 = r100.getApplicationContext();
        if (r101 != null) goto L5;
        aq7.a r103 = aq7.a.f15910d;
    L6:
        this.f20046f = r103;
        this.f20042b = new dq7.a(r102, this);
        this.f20043c = new fq7.a(r102, this);
        this.f20044d = new eq7.b(r102, this);
        this.f20045e = new cq7.a(this);
        f20040h |= 1;
        boolean r104 = hq7.a.f486512a;
        Objects.toString(r101);
        return;
    L5:
        r103 = r101;
        goto L6
    }
}
