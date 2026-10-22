package com.bytedance.android.livesdk.dslservice.util;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes8.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f123011a = 0;

    static {
    }

    public static void a(View r100) {
        if (r100 != null) goto L17;
        return;
    L17:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L14
        if (r100.getParent() == null) goto L12;
        ViewParent r102 = r100.getParent();     // Catch: Throwable -> L14
        if ((r102 instanceof ViewGroup) == true) goto L9;
        r102 = null;
    L9:
        ViewGroup r103 = (ViewGroup) r102;     // Catch: Throwable -> L14
        if (r103 == null) goto L12;
        r103.removeView(r100);     // Catch: Throwable -> L14
    L12:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
