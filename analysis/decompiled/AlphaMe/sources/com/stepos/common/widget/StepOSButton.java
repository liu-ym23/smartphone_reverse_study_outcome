package com.stepos.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.C0230v;
import com.stepos.alphame.R;
import i2.AbstractC0620a;
import java.util.Iterator;

/* loaded from: classes.dex */
public class StepOSButton extends C0230v {

    /* renamed from: d, reason: collision with root package name */
    public com.stepos.common.animator.m f11799d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f11800e;

    public StepOSButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyle);
        this.f11800e = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0620a.f13032n, R.attr.buttonStyle, 0);
        typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.f11800e = typedArrayObtainStyledAttributes.getBoolean(0, this.f11800e);
        typedArrayObtainStyledAttributes.recycle();
        com.stepos.common.animator.m mVar = new com.stepos.common.animator.m();
        this.f11799d = mVar;
        mVar.b(this, 3, true);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        com.stepos.common.animator.m mVar = this.f11799d;
        mVar.getClass();
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            Iterator it = mVar.f11307a.iterator();
            while (it.hasNext()) {
                com.stepos.common.animator.l lVar = (com.stepos.common.animator.l) it.next();
                if (this == lVar.f11305a && isEnabled()) {
                    mVar.c(this, motionEvent, lVar.f11306b);
                }
            }
        }
        if (isEnabled() && this.f11800e) {
            motionEvent.getAction();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setPressAnimationEnabled(boolean z4) {
        if (this.f11800e != z4) {
            this.f11800e = z4;
            com.stepos.common.animator.m mVar = new com.stepos.common.animator.m();
            this.f11799d = mVar;
            mVar.b(this, 3, true);
        }
    }
}
