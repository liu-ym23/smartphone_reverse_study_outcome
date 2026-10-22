package com.smt.obric.appstore.ui.app;

import com.smt.obric.appstore.domain.app.entity.AppStatus;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {
    public static final /* synthetic */ AppUIStatus a(AppUIStatus r10, he.b r11, he.a r12) {
        return b(r10, r11, r12);
    }

    public static final AppUIStatus b(AppUIStatus r10, he.b r11, he.a r12) {
        AppStatus r13 = r11.c();
        if (q.b(r13, AppStatus.k.f17988a) == false) goto L7;
        AppUIStatus.Status r14 = AppUIStatus.Status.NotInstalled;
    L5:
        AppUIStatus.Status r15 = r14;
        return r10.a(false, r12.j(), Long.valueOf(r12.o()), r12.i(), r15, r11.a(), r12);
    L7:
        if (q.b(r13, AppStatus.m.f17992a) == false) goto L10;
        r14 = AppUIStatus.Status.UpdateAvailable;
        goto L5
    L10:
        if (q.b(r13, AppStatus.c.f17972a) == false) goto L13;
        r14 = AppUIStatus.Status.DownloadPending;
        goto L5
    L13:
        if (q.b(r13, AppStatus.d.f17974a) == false) goto L16;
        r14 = AppUIStatus.Status.DownloadRunning;
        goto L5
    L16:
        if (q.b(r13, AppStatus.b.f17970a) == false) goto L19;
        r14 = AppUIStatus.Status.DownloadPaused;
        goto L5
    L19:
        if (q.b(r13, AppStatus.e.f17976a) == false) goto L22;
        r14 = AppUIStatus.Status.Installing;
        goto L5
    L22:
        if (q.b(r13, AppStatus.a.f17968a) == false) goto L25;
        r14 = AppUIStatus.Status.DownloadPaused;
        goto L5
    L25:
        if (q.b(r13, AppStatus.f.f17978a) == false) goto L28;
        r14 = AppUIStatus.Status.DownloadWaitWiFi;
        goto L5
    L28:
        if (q.b(r13, AppStatus.j.f17986a) == false) goto L31;
        r14 = AppUIStatus.Status.Installing;
        goto L5
    L31:
        if (q.b(r13, AppStatus.h.f17982a) == false) goto L34;
        r14 = AppUIStatus.Status.Installing;
        goto L5
    L34:
        if (q.b(r13, AppStatus.i.f17984a) == false) goto L37;
        r14 = AppUIStatus.Status.Installed;
        goto L5
    L37:
        if (q.b(r13, AppStatus.g.f17980a) == false) goto L40;
        r14 = r10.f();
        goto L5
    L40:
        if (q.b(r13, AppStatus.l.f17990a) == false) goto L45;
        r14 = r10.f();
        goto L5
    L45:
        throw new NoWhenBranchMatchedException();
    }
}
