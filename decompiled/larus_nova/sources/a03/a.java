package a03;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements yr0.a, lc0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final lc0.a f1246a;

    @Override // lc0.a
    public final boolean V() {
        return this.f1246a.V();
    }

    @Override // yr0.a, lc0.a
    public final boolean a() {
        return this.f1246a.a();
    }

    @Override // yr0.a, lc0.a
    public final void b(int r100) {
        this.f1246a.b(r100);
    }

    @Override // lc0.a
    public final void d(String r100, HashMap<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f1246a.d(r100, r101);
    }

    @Override // lc0.a
    public final Map<String, String> e() {
        return this.f1246a.e();
    }

    @Override // lc0.a
    public final void f(boolean r100) {
        this.f1246a.f(r100);
    }

    @Override // lc0.a
    public final String g() {
        return this.f1246a.g();
    }

    @Override // lc0.a
    public final String getConnectionType() {
        return this.f1246a.getConnectionType();
    }

    @Override // yr0.a, lc0.a
    public final int getCurrentMode() {
        return this.f1246a.getCurrentMode();
    }

    @Override // lc0.a
    public final int getMixStreamType() {
        return this.f1246a.getMixStreamType();
    }

    @Override // lc0.a
    public final Map<String, String> h() {
        return this.f1246a.h();
    }

    @Override // lc0.a
    public final boolean i() {
        return this.f1246a.i();
    }

    @Override // lc0.a
    public final boolean j(String r100, int r101, String r110, String r111, Integer r112) {
        Intrinsics.checkNotNullParameter(r100, "guideType");
        Intrinsics.checkNotNullParameter(r110, "toUserGroup");
        Intrinsics.checkNotNullParameter(r111, "page");
        return this.f1246a.j(r100, r101, r110, r111, r112);
    }

    @Override // lc0.a
    public final void m() {
        this.f1246a.m();
    }

    @Override // yr0.a, lc0.a
    public final boolean p() {
        return this.f1246a.p();
    }

    @Override // yr0.a, lc0.a
    public final void unLoadOtherWidget(int r100) {
        this.f1246a.unLoadOtherWidget(r100);
    }

    @Override // yr0.a, lc0.a
    public final boolean c() {
        return this.f1246a.c();
    }

    public a(lc0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "compat");
        this.f1246a = r100;
    }
}
