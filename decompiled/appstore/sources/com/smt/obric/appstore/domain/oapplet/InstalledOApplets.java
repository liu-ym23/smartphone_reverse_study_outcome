package com.smt.obric.appstore.domain.oapplet;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.j0;
import kotlin.collections.u;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.y0;

/* JADX INFO: loaded from: classes4.dex */
public final class InstalledOApplets {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InstalledOApplets f18057a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f18058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Job f18059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f18060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final MutableStateFlow f18061e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final StateFlow f18062f = null;

    static {
        f18057a = new InstalledOApplets();
        MutableStateFlow r10 = f1.a(null);
        f18061e = r10;
        f18062f = c.b(r10);
    }

    public InstalledOApplets() {
    }

    public static /* synthetic */ void a() {
        h();
    }

    public static final /* synthetic */ Context b() {
        return f18058b;
    }

    public static final /* synthetic */ Object c(InstalledOApplets r10, Continuation r11) {
        return r10.i(r11);
    }

    public static final /* synthetic */ void d(Job r10) {
        f18059c = r10;
    }

    public static final /* synthetic */ void e(boolean r10) {
        f18060d = r10;
    }

    public static final void g(Context r10) {
        q.g(r10, "context");
        f18058b = r10;
        Job r11 = f18059c;
        if (r11 == null) goto L8;
        if (r11.isActive() != true) goto L8;
        return;
    L8:
        if (f18060d == false) goto L10;
        return;
    L10:
        f18060d = true;
        new Handler(Looper.getMainLooper()).post(new a());
    }

    public static final void h() {
        f18057a.j();
    }

    public final StateFlow f() {
        return f18062f;
    }

    public final Object i(Continuation r10) {
        if ((r10 instanceof InstalledOApplets$refresh$1) == false) goto L7;
        InstalledOApplets$refresh$1 r11 = (InstalledOApplets$refresh$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = kotlin.coroutines.intrinsics.a.d();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        kotlin.c.b(r13);
    L21:
        Object r16 = ((Result) r13).m44unboximpl();
        if (Result.m42isSuccessimpl(r16) == false) goto L24;
        InstalledOApplets r17 = f18057a;
        r17.k((List) r16);
    L24:
        Throwable r18 = Result.m38exceptionOrNullimpl(r16);
        if (r18 == null) goto L28;
        j.j("InstalledOApplets load failed, err=", r18);
    L28:
        return Unit.f21064a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r13);
        if (f18058b != null) goto L18;
        j.i("InstalledOApplets refresh skipped, context is not initialized");
        return Unit.f21064a;
    L18:
        CoroutineDispatcher r19 = l0.b();
        InstalledOApplets$refresh$result$1 r20 = new InstalledOApplets$refresh$result$1(null);
        r11.label = 1;
        r13 = h.g(r19, r20, r11);
        if (r13 != r14) goto L21;
        return r14;
    L7:
        r11 = new InstalledOApplets$refresh$1(this, r10);
        goto L8
    }

    public final void j() {
        Job r10 = f18059c;
        if (r10 != null) goto L5;
    L7:
        Job r11 = h.d(y0.f21772a, null, null, new InstalledOApplets$startObserve$1(null), 3, null);
        r11.invokeOnCompletion(InstalledOApplets$startObserve$2$1.INSTANCE);
        f18059c = r11;
        return;
    L5:
        if (r10.isActive() != true) goto L7;
    }

    public final void k(List r15) {
        q.g(r15, ServerElements.LIST);
        MutableStateFlow r14 = f18061e;
        ArrayList r10 = new ArrayList(u.r(r15, 10));
        Iterator r16 = r15.iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        OAppletInfo r11 = (OAppletInfo) r16.next();
        r10.add(OAppletInfo.copy$default(r11, null, null, false, null, null, OAppletUtil.f18065a.j(r11.getPackageName()), 0, 95, null));
        goto L4
    L6:
        ArrayList r17 = new ArrayList();
        Iterator r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        Object r13 = r12.next();
        if (((OAppletInfo) r13).getInstalled() == false) goto L8;
        r17.add(r13);
        goto L8
    L12:
        LinkedHashMap r18 = new LinkedHashMap(bg.h.d(j0.e(u.r(r17, 10)), 16));
        Iterator r19 = r17.iterator();
    L14:
        if (r19.hasNext() == false) goto L16;
        Object r20 = r19.next();
        r18.put(((OAppletInfo) r20).getPackageName(), r20);
        goto L14
    L16:
        r14.setValue(r18);
    }
}
