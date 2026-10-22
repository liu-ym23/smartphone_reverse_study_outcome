package com.bytedance.android.shopping.buynow.controller;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f170843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f170844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f170845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f170846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f170847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RecyclerView f170848f;

    public m(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f170848f = r100;
        this.f170845c = -1;
        this.f170846d = -1;
        this.f170847e = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
    }

    public final Boolean b(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L32
        int r102 = r100.getActionMasked();     // Catch: Throwable -> L32
        if (r102 != 0) goto L6;
        this.f170843a = r100.getX();     // Catch: Throwable -> L32
        this.f170844b = r100.getY();     // Catch: Throwable -> L32
        this.f170846d = r100.getPointerId(0);     // Catch: Throwable -> L32
    L30:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L34:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L37;
        ECExceptionMonitor.e(r104);
    L37:
        return null;
    L6:
        if (r102 != 1) goto L8;
    L28:
        this.f170846d = this.f170845c;     // Catch: Throwable -> L32
        goto L30
    L8:
        if (r102 != 2) goto L10;
        int r105 = this.f170846d;     // Catch: Throwable -> L32
        if (r105 != this.f170845c) goto L15;
        return null;
    L15:
        int r106 = r100.findPointerIndex(r105);     // Catch: Throwable -> L32
        if (r106 == (-1)) goto L27;
        if (r106 < 0) goto L27;
        if (r106 >= r100.getPointerCount()) goto L27;
        float r107 = r100.getX(r106);     // Catch: Throwable -> L32
        float r108 = r100.getY(r106);     // Catch: Throwable -> L32
        float r109 = r107 - this.f170843a;     // Catch: Throwable -> L32
        float r110 = r108 - this.f170844b;     // Catch: Throwable -> L32
        float r111 = Math.abs(r109);     // Catch: Throwable -> L32
        Math.abs(r110);     // Catch: Throwable -> L32
        if (a(this.f170848f, false, (int) r109, (int) r107, (int) r108) == false) goto L30;
        if (r111 <= this.f170847e) goto L30;
        this.f170843a = r107;     // Catch: Throwable -> L32
        this.f170844b = r108;     // Catch: Throwable -> L32
        return Boolean.FALSE;
    L27:
        return null;
    L10:
        if (r102 == 3) goto L28;
    L32:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    }

    public static boolean a(View r100, boolean r110, int r111, int r112, int r113) {
        if ((r100 instanceof ViewGroup) == false) goto L18;
        int r101 = r100.getScrollX();
        int r102 = r100.getScrollY();
        ViewGroup r103 = (ViewGroup) r100;
        int r104 = r103.getChildCount() - 1;
    L5:
        if (r104 < 0) goto L18;
        View r105 = r103.getChildAt(r104);
        int r106 = r112 + r101;
        if (r106 < r105.getLeft()) goto L17;
        if (r106 >= r105.getRight()) goto L17;
        int r107 = r113 + r102;
        if (r107 < r105.getTop()) goto L17;
        if (r107 >= r105.getBottom()) goto L17;
        if (a(r105, true, r111, r106 - r105.getLeft(), r107 - r105.getTop()) == false) goto L17;
        return true;
    L17:
        r104 = r104 - 1;
    L18:
        if (r110 == true) goto L20;
    L22:
        return false;
    L20:
        if (r100.canScrollHorizontally(-r111) == false) goto L22;
        return true;
    }
}
