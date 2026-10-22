package com.bytedance.android.live.core.utils;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.liveinteract.animator.LiveAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class l2 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f66215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f66216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f66217c;

    public l2(View r100, float r101, long r102) {
        this.f66215a = r100;
        this.f66216b = r101;
        this.f66217c = r102;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101 == null) goto L4;
        Integer r102 = Integer.valueOf(r101.getAction());
    L6:
        if (r102 != null) goto L9;
    L15:
        if (r102 != null) goto L18;
    L24:
        if (r102 != null) goto L27;
    L33:
        return false;
    L27:
        if (r102.intValue() != 3) goto L33;
        if (this.f66215a.isEnabled() == false) goto L33;
        if (Intrinsics.areEqual(this.f66215a.getTag(), Boolean.TRUE) == false) goto L33;
        fd0.f r103 = LiveAnimator.a(new View[]{r100});
        r103.c("alpha", new float[]{this.f66216b, 1.0f});
        r103.f476453a.f71418b = this.f66217c;
        r103.e();
        goto L33
    L18:
        if (r102.intValue() != 1) goto L24;
        if (this.f66215a.isEnabled() == false) goto L33;
        if (Intrinsics.areEqual(this.f66215a.getTag(), Boolean.TRUE) == false) goto L33;
        fd0.f r104 = LiveAnimator.a(new View[]{r100});
        r104.c("alpha", new float[]{this.f66216b, 1.0f});
        r104.f476453a.f71418b = this.f66217c;
        r104.e();
        goto L33
    L9:
        if (r102.intValue() != 0) goto L15;
        if (this.f66215a.isEnabled() == false) goto L33;
        if (Intrinsics.areEqual(this.f66215a.getTag(), Boolean.TRUE) == false) goto L33;
        fd0.f r105 = LiveAnimator.a(new View[]{r100});
        r105.c("alpha", new float[]{1.0f, this.f66216b});
        r105.f476453a.f71418b = this.f66217c;
        r105.e();
        goto L33
    L4:
        r102 = null;
        goto L6
    }
}
