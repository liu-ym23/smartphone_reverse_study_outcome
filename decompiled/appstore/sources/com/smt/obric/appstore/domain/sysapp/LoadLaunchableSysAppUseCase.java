package com.smt.obric.appstore.domain.sysapp;

import android.content.Context;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes4.dex */
public final class LoadLaunchableSysAppUseCase {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f18072b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18073a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f18072b = new a(null);
    }

    public LoadLaunchableSysAppUseCase(Context r10) {
        q.g(r10, "context");
        this.f18073a = r10;
    }

    public static final /* synthetic */ Context a(LoadLaunchableSysAppUseCase r10) {
        return r10.f18073a;
    }

    public final Object b(Continuation r10) {
        if ((r10 instanceof LoadLaunchableSysAppUseCase$invoke$1) == false) goto L7;
        LoadLaunchableSysAppUseCase$invoke$1 r11 = (LoadLaunchableSysAppUseCase$invoke$1) r10;
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
    L18:
        return ((Result) r13).m44unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r13);
        CoroutineDispatcher r16 = l0.b();
        LoadLaunchableSysAppUseCase$invoke$2 r17 = new LoadLaunchableSysAppUseCase$invoke$2(this, null);
        r11.label = 1;
        r13 = h.g(r16, r17, r11);
        if (r13 != r14) goto L18;
        return r14;
    L7:
        r11 = new LoadLaunchableSysAppUseCase$invoke$1(this, r10);
        goto L8
    }
}
