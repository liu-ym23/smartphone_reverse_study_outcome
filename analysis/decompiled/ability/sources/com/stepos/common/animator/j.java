package com.stepos.common.animator;

import android.view.MotionEvent;
import android.view.View;
import androidx.dynamicanimation.animation.SpringAnimation;

/* loaded from: classes3.dex */
public final class j implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f3567a;
    public final /* synthetic */ SpringAnimation b;
    public final /* synthetic */ m c;

    public j(m mVar, View view, SpringAnimation springAnimation) {
        this.c = mVar;
        this.f3567a = view;
        this.b = springAnimation;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.c.c(this.f3567a, motionEvent, this.b);
        return false;
    }
}
