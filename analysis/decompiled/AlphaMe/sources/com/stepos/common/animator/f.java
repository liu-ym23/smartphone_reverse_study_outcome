package com.stepos.common.animator;

import com.stepos.common.widget.C;
import com.stepos.common.widget.w;
import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* loaded from: classes.dex */
public final class f implements W.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11292a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11293b;

    public /* synthetic */ f(int i4, Object obj) {
        this.f11292a = i4;
        this.f11293b = obj;
    }

    @Override // W.j
    public final void a(float f4) {
        int i4 = this.f11292a;
        Object obj = this.f11293b;
        switch (i4) {
            case 0:
                StepOSPressAnimationDrawable stepOSPressAnimationDrawable = (StepOSPressAnimationDrawable) obj;
                stepOSPressAnimationDrawable.f11245e = f4 / 100.0f;
                stepOSPressAnimationDrawable.invalidateSelf();
                break;
            case 1:
                w wVar = ((C) obj).f11447a.f11518h;
                wVar.removeMessages(0);
                wVar.removeMessages(1);
                wVar.removeMessages(2);
                wVar.sendEmptyMessage(2);
                break;
            default:
                PopupNestedScrollingLayout popupNestedScrollingLayout = (PopupNestedScrollingLayout) obj;
                popupNestedScrollingLayout.h(((int) f4) - popupNestedScrollingLayout.f14885p);
                break;
        }
    }
}
