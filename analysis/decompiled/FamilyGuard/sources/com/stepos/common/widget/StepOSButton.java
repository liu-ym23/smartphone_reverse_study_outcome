package com.stepos.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.C0436f;
import g.C0728a;

/* loaded from: classes.dex */
public class StepOSButton extends C0436f {

    /* renamed from: d, reason: collision with root package name */
    private I1.f f14201d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f14202e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f14203f;

    public StepOSButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16842s);
    }

    private void a() {
        I1.f fVar = new I1.f();
        this.f14201d = fVar;
        fVar.f(this, true, I1.f.f2929e | I1.f.f2930f);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f14201d.i(this, motionEvent);
        if (isEnabled() && this.f14203f) {
            motionEvent.getAction();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setPressAnimationEnabled(boolean z5) {
        if (this.f14203f != z5) {
            this.f14203f = z5;
            a();
        }
    }

    public StepOSButton(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f14202e = false;
        this.f14203f = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H1.m.f2468N4, i5, 0);
        this.f14202e = typedArrayObtainStyledAttributes.getBoolean(H1.m.f2480P4, this.f14202e);
        this.f14203f = typedArrayObtainStyledAttributes.getBoolean(H1.m.f2474O4, this.f14203f);
        typedArrayObtainStyledAttributes.recycle();
        a();
    }
}
