package com.smt.obric.appstore.domain.app.entity;

import com.bytedanceos.common.toolbox.j;
import java.util.List;
import kotlin.Result;
import kotlin.c;
import kotlin.collections.t;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class Converters {
    public Converters() {
    }

    public final AppInstallMode a(int r10) {
        AppInstallMode r11 = AppInstallMode.Companion.a(r10);
        if (r11 != null) goto L6;
        j.p("[AppInstallMode] deserializeAppInstallMode, unknown val: " + r10);
        return AppInstallMode.c.f17964a;
    L6:
        return r11;
    }

    public final AppStatus b(int r10) {
        AppStatus.k r11 = AppStatus.k.f17988a;
        if (r10 != r11.getOrdinal()) goto L5;
    L4:
        AppStatus r12 = r11;
    L43:
        if (q.b(r12, AppStatus.a.f17968a) == false) goto L45;
    L67:
        return r12;
    L45:
        if (q.b(r12, AppStatus.b.f17970a) == true) goto L67;
        if (q.b(r12, AppStatus.c.f17972a) == true) goto L67;
        if (q.b(r12, AppStatus.d.f17974a) == true) goto L67;
        if (q.b(r12, AppStatus.e.f17976a) == true) goto L67;
        if (q.b(r12, AppStatus.f.f17978a) == true) goto L67;
        if (q.b(r12, AppStatus.g.f17980a) == true) goto L67;
        if (q.b(r12, AppStatus.h.f17982a) == true) goto L67;
        if (q.b(r12, AppStatus.i.f17984a) == true) goto L67;
        if (q.b(r12, AppStatus.j.f17986a) == true) goto L67;
        if (q.b(r12, r11) == true) goto L67;
        if (q.b(r12, AppStatus.m.f17992a) == true) goto L67;
        q.b(r12, AppStatus.l.f17990a);
        goto L67
    L5:
        r12 = AppStatus.m.f17992a;
        if (r10 == r12.getOrdinal()) goto L43;
        r12 = AppStatus.c.f17972a;
        if (r10 == r12.getOrdinal()) goto L43;
        r12 = AppStatus.d.f17974a;
        if (r10 == r12.getOrdinal()) goto L43;
        r12 = AppStatus.b.f17970a;
        if (r10 == r12.getOrdinal()) goto L43;
        r12 = AppStatus.e.f17976a;
        if (r10 == r12.getOrdinal()) goto L43;
        r12 = AppStatus.a.f17968a;
        if (r10 == r12.getOrdinal()) goto L43;
        r12 = AppStatus.f.f17978a;
        if (r10 == r12.getOrdinal()) goto L43;
        r12 = AppStatus.j.f17986a;
        if (r10 == r12.getOrdinal()) goto L43;
        r12 = AppStatus.i.f17984a;
        if (r10 == r12.getOrdinal()) goto L43;
        r12 = AppStatus.h.f17982a;
        if (r10 == r12.getOrdinal()) goto L43;
        r12 = AppStatus.g.f17980a;
        if (r10 == r12.getOrdinal()) goto L43;
        r12 = AppStatus.l.f17990a;
        if (r10 == r12.getOrdinal()) goto L43;
        j.p("[AppStatus] deserializeAppStatus, unknown val: " + r10);
        goto L4
    }

    public final List c(String r10) {
        Object r11 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.length() == 0) goto L23;
        Result.a r12 = Result.Companion;     // Catch: Throwable -> L9
        Object r13 = Result.m35constructorimpl((List) fe.a.a().fromJson(r10, new Converters$deserializeStringList$stringList$1$1().getType()));     // Catch: Throwable -> L9
    L12:
        if (Result.m41isFailureimpl(r13) == true) goto L15;
        r11 = r13;
    L15:
        List r14 = (List) r11;
        if (r14 == null) goto L18;
        return r14;
    L18:
        return t.i();
    L9:
        th = move-exception;
        Result.a r15 = Result.Companion;
        r13 = Result.m35constructorimpl(c.a(th));
        goto L12
    L23:
        return null;
    }

    public final int d(AppInstallMode r10) {
        q.g(r10, "mode");
        return r10.getOrdinal();
    }

    public final int e(AppStatus r10) {
        q.g(r10, "status");
        return r10.getOrdinal();
    }

    public final String f(List r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return fe.a.a().toJson(r10);
    }
}
