package com.bytedance.android.ec.opt.session;

import bm.b;
import com.bytedance.android.ec.opt.session.settings.ECPerfSettings;
import com.google.gson.Gson;
import defpackage.n;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECPerfSessionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f48095a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, a> f48096b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f48097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ECPerfSessionManager f48098d = null;

    public ECPerfSessionManager() {
    }

    static {
        f48098d = new ECPerfSessionManager();
        Gson r100 = ECPerfSettings.f48103a;
        f48095a = ((Boolean) ECPerfSettings.f48104b.getValue()).booleanValue();
        f48096b = new LinkedHashMap();
        int r101 = n.f516542a;
        Intrinsics.checkNotNullParameter(AnonymousClass1.INSTANCE, "onChanged");
    }

    public final bm.a b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        if (f48095a == true) goto L5;
        return null;
    L5:
        a r101 = a(r100, false);
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.a();
    }

    public final synchronized a a(String r100, boolean r101) {
        monitor-enter(this);
        Map<String, a> r102 = f48096b;     // Catch: Throwable -> L19
        a r103 = (a) ((LinkedHashMap) r102).get(r100);     // Catch: Throwable -> L19
        a r104 = null;
        if (r103 != null) goto L12;
        Boolean r105 = Boolean.valueOf(r101);     // Catch: Throwable -> L19
        if (r105.booleanValue() == true) goto L9;
        r105 = null;
    L9:
        if (r105 == null) goto L11;
        r105.booleanValue();     // Catch: Throwable -> L19
        r103 = new a(r100);     // Catch: Throwable -> L19
        r102.put(r100, r103);     // Catch: Throwable -> L19
        goto L12
    L11:
        r103 = null;
    L12:
        if (r103 != null) goto L14;
    L17:
        monitor-exit(this);
        return r104;
    L14:
        if (r103.f48101c >= f48097c) goto L16;
        r103.f48100b = "1";     // Catch: Throwable -> L19
    L16:
        r104 = r103;
    L19:
        th = move-exception;
        throw th;
    }

    public final bm.a c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "stage");
        bm.a r102 = null;
        if (f48095a == true) goto L5;
        return null;
    L5:
        a r103 = a(r100, false);
        if (r103 == null) goto L14;
        monitor-enter(r103);
        Intrinsics.checkNotNullParameter(r101, "stage");     // Catch: Throwable -> L11
        r102 = r103.f48099a.a(r101);     // Catch: Throwable -> L11
        monitor-exit(r103);
    L11:
        th = move-exception;
        throw th;
    L14:
        return r102;
    }

    public final void d(String r100, String r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "stage");
        Intrinsics.checkNotNullParameter(r102, "data");
        if (f48095a == true) goto L5;
        return;
    L5:
        a r103 = a(r100, true);
        if (r103 == null) goto L19;
        monitor-enter(r103);
        Intrinsics.checkNotNullParameter(r101, "name");     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r102, "stage");     // Catch: Throwable -> L16
        if (r103.f48099a.f19539c.containsKey(r101) == false) goto L13;
        b r104 = r103.f48099a.f19539c.get(r101);     // Catch: Throwable -> L16
        if (r104 == null) goto L14;
        Intrinsics.checkNotNullParameter(r102, "other");     // Catch: Throwable -> L16
        r104.f19541b.putAll(r102.f19541b);     // Catch: Throwable -> L16
        r103.c(r101, r104);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r103);
        return;
    L13:
        r103.f48099a.f19539c.put(r101, r102);     // Catch: Throwable -> L16
        r103.c(r101, r102);     // Catch: Throwable -> L16
        r103.b();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }
}
