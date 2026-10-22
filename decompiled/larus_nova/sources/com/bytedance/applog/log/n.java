package com.bytedance.applog.log;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class n extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f192481d = null;

    public static class a extends b<i> {
        public a() {
        }

        @Override // com.bytedance.applog.log.b
        public final i a(Object[] r100) {
            return new h();
        }
    }

    static {
        f192481d = new a();
    }

    public static i w() {
        return f192481d.b(new Object[0]);
    }

    public n() {
    }

    @Override // com.bytedance.applog.log.i
    public final void d(Object... r100) {
        p(6, null, "Failed to clean sensitive fields", r100);
    }

    @Override // com.bytedance.applog.log.i
    public final void a(String r100, Object... r101) {
        s(null, r100, null, r101);
    }

    @Override // com.bytedance.applog.log.i
    public final void i(String r100, Object... r101) {
        f(0, null, r100, r101);
    }

    @Override // com.bytedance.applog.log.i
    public final void j(String r100, Object... r101) {
        k(0, null, r100, r101);
    }

    @Override // com.bytedance.applog.log.i
    public final void l(String r100, Object... r101) {
        g(0, null, r100, r101);
    }

    @Override // com.bytedance.applog.log.i
    public final void n(List r100, Object... r101) {
        s(r100, "can't find ET, should compile with ET", null, r101);
    }

    @Override // com.bytedance.applog.log.i
    public final void t(String r100, Object... r101) {
        v(0, 0, null, null, r100, r101);
    }

    @Override // com.bytedance.applog.log.i
    public final void b(int r100, String r101, Object... r102) {
        k(r100, null, r101, r102);
    }

    @Override // com.bytedance.applog.log.i
    public final void c(List<String> r100, String r101, Object... r102) {
        f(0, r100, r101, r102);
    }

    @Override // com.bytedance.applog.log.i
    public final void e(List<String> r100, String r101, Object... r102) {
        g(0, r100, r101, r102);
    }

    @Override // com.bytedance.applog.log.i
    public final void h(List<String> r100, String r101, Object... r102) {
        k(0, r100, r101, r102);
    }

    @Override // com.bytedance.applog.log.i
    public final void m(int r100, String r101, Object... r102) {
        f(r100, null, r101, r102);
    }

    @Override // com.bytedance.applog.log.i
    public final void q(String r100, Throwable r101, Object... r102) {
        s(null, r100, r101, r102);
    }

    @Override // com.bytedance.applog.log.i
    public final void f(int r100, List<String> r101, String r110, Object... r111) {
        v(r100, 3, r101, null, r110, r111);
    }

    @Override // com.bytedance.applog.log.i
    public final void g(int r100, List<String> r101, String r110, Object... r111) {
        v(r100, 2, r101, null, r110, r111);
    }

    @Override // com.bytedance.applog.log.i
    public final void k(int r100, List<String> r101, String r110, Object... r111) {
        v(r100, 1, r101, null, r110, r111);
    }

    @Override // com.bytedance.applog.log.i
    public final void o(int r100, String r101, Throwable r102, Object... r110) {
        r(r100, null, r101, r102, r110);
    }

    @Override // com.bytedance.applog.log.i
    public final void p(int r100, List<String> r101, String r102, Object... r110) {
        r(r100, r101, r102, null, r110);
    }

    @Override // com.bytedance.applog.log.i
    public final void s(List<String> r100, String r101, Throwable r102, Object... r110) {
        r(0, r100, r101, r102, r110);
    }

    @Override // com.bytedance.applog.log.i
    public final void r(int r100, List<String> r101, String r110, Throwable r111, Object... r112) {
        v(r100, 4, r101, r111, r110, r112);
    }
}
