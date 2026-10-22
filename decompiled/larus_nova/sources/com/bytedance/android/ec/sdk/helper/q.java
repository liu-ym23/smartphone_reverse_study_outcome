package com.bytedance.android.ec.sdk.helper;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class q implements mj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f48131a = null;

    public q() {
    }

    static {
        f48131a = new q();
    }

    public static mj.a g() {
        return d.f48119b.getIECSPService();
    }

    public static long f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r101 = String.valueOf(d.f48119b.getIECHostUserService().a());
        return g().getLong(r100 + '_' + r101, 0);
    }

    @Override // mj.a
    public final void erase(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        g().erase(r100);
    }

    public static void h(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r102 = String.valueOf(d.f48119b.getIECHostUserService().a());
        g().e(r100 + '_' + r102, r101);
    }

    @Override // mj.a
    public final List<String> a(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "default");
        return g().a(r100, r101);
    }

    @Override // mj.a
    public final void b(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        g().b(r100, r101);
    }

    @Override // mj.a
    public final void c(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        g().c(r100, r101);
    }

    @Override // mj.a
    public final void d(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        g().d(r100, r101);
    }

    @Override // mj.a
    public final void e(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        g().e(r100, r101);
    }

    @Override // mj.a
    public final boolean getBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return g().getBoolean(r100, r101);
    }

    @Override // mj.a
    public final int getInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return g().getInt(r100, r101);
    }

    @Override // mj.a
    public final long getLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return g().getLong(r100, r101);
    }

    @Override // mj.a
    public final String getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "default");
        return g().getString(r100, r101);
    }

    @Override // mj.a
    public final void putString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        g().putString(r100, r101);
    }
}
