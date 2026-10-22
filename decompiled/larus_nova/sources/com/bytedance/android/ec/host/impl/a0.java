package com.bytedance.android.ec.host.impl;

import android.content.Context;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a0 implements cj.b {
    public a0() {
    }

    @Override // cj.b
    public final void b() {
    }

    @Override // cj.b
    public final void c() {
    }

    @Override // cj.b
    public final void closeAnimDelay() {
    }

    @Override // cj.b
    public final void d() {
    }

    @Override // cj.b
    public final void e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // cj.b
    public final void f() {
    }

    @Override // cj.b
    public final void h() {
    }

    @Override // cj.b
    public final void i() {
    }

    @Override // cj.b
    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
    }

    @Override // cj.b
    public final void openAnimDelay() {
    }

    @Override // cj.b
    public final void startBlockGc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    @Override // cj.b
    public final void stopBlockGc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    @Override // cj.b
    public final void g() {
        Intrinsics.checkNotNullParameter("AnrOptSliceTemplate", "scene");
    }

    @Override // cj.b
    public final void j(List r100) {
        Intrinsics.checkNotNullParameter(r100, "classLists");
    }

    public static Object l(String r100, Object r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L21
        Object r103 = com.bytedance.android.ec.base.settings.d.f42818c.get(r100);     // Catch: Throwable -> L21
        Object r104 = null;
        if (r103 != null) goto L5;
        r103 = null;
    L5:
        if (r103 != null) goto L19;
        IHybridHostService r105 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L21
        if (r105 == null) goto L12;
        yj.g r106 = r105.getHostAB();     // Catch: Throwable -> L21
        if (r106 == null) goto L12;
        Object r107 = r106.a(r100, r101);     // Catch: Throwable -> L21
    L13:
        if (r107 == null) goto L16;
        r104 = r107;
    L16:
        if (r104 != null) goto L18;
        r103 = r101;
        goto L19
    L18:
        r103 = r104;
    L12:
        r107 = null;
    L19:
        Object r108 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L21
    L24:
        if (Result.m9455isFailureimpl(r108) == false) goto L27;
        return r101;
    L27:
        return r108;
    L21:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    @Override // cj.b
    public final Object a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        return l(r100, r101);
    }
}
