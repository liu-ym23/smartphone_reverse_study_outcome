package com.bytedance.ai.applet.base.log;

import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f34529b;

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ThreadLocal<Map<String, String>> r101 = f.f34527a;
        e r102 = this.f34529b;
        if (r102.f34526a.isEmpty() == false) goto L5;
        b r103 = a.f34518a;
        a.a(this.f34528a, r100);
        return;
    L5:
        Map<String, String> r104 = f.f34527a.get();
        f.b(MapsKt.plus(f.a(), r102.f34526a));
        b r105 = a.f34518a;     // Catch: Throwable -> L9
        a.a(this.f34528a, r100);     // Catch: Throwable -> L9
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L9
        f.b(r104);
        return;
    L9:
        th = move-exception;
        f.b(r104);
        throw th;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ThreadLocal<Map<String, String>> r101 = f.f34527a;
        e r102 = this.f34529b;
        if (r102.f34526a.isEmpty() == false) goto L5;
        b r103 = a.f34518a;
        a.c(this.f34528a, r100);
        return;
    L5:
        Map<String, String> r104 = f.f34527a.get();
        f.b(MapsKt.plus(f.a(), r102.f34526a));
        b r105 = a.f34518a;     // Catch: Throwable -> L9
        a.c(this.f34528a, r100);     // Catch: Throwable -> L9
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L9
        f.b(r104);
        return;
    L9:
        th = move-exception;
        f.b(r104);
        throw th;
    }

    public i(String r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "logContext");
        this.f34528a = r100;
        this.f34529b = r101;
    }

    public final void b(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ThreadLocal<Map<String, String>> r102 = f.f34527a;
        e r103 = this.f34529b;
        if (r103.f34526a.isEmpty() == false) goto L5;
        b r104 = a.f34518a;
        a.b(this.f34528a, r100, r101);
        return;
    L5:
        Map<String, String> r105 = f.f34527a.get();
        f.b(MapsKt.plus(f.a(), r103.f34526a));
        b r106 = a.f34518a;     // Catch: Throwable -> L9
        a.b(this.f34528a, r100, r101);     // Catch: Throwable -> L9
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L9
        f.b(r105);
        return;
    L9:
        th = move-exception;
        f.b(r105);
        throw th;
    }
}
