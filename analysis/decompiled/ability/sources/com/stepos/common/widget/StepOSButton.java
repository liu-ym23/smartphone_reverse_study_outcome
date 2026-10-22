package com.stepos.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatButton;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class StepOSButton extends AppCompatButton {

    /* renamed from: a, reason: collision with root package name */
    public com.stepos.common.animator.m f3769a;
    public boolean b;

    /* JADX WARN: Illegal instructions before constructor call */
    public StepOSButton(Context context, AttributeSet attributeSet) {
        int i = R.attr.buttonStyle;
        super(context, attributeSet, i);
        this.b = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V4.s.n, i, 0);
        typedArrayObtainStyledAttributes.getBoolean(3, false);
        this.b = typedArrayObtainStyledAttributes.getBoolean(0, this.b);
        typedArrayObtainStyledAttributes.recycle();
        com.stepos.common.animator.m mVar = new com.stepos.common.animator.m();
        this.f3769a = mVar;
        mVar.b(this, 3, true);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        com.stepos.common.animator.m mVar = this.f3769a;
        mVar.getClass();
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            Iterator it = mVar.f3570a.iterator();
            while (it.hasNext()) {
                com.stepos.common.animator.l lVar = (com.stepos.common.animator.l) it.next();
                if (this == lVar.f3569a && isEnabled()) {
                    mVar.c(this, motionEvent, lVar.b);
                }
            }
        }
        if (isEnabled() && this.b) {
            motionEvent.getAction();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setPressAnimationEnabled(boolean z10) {
        if (this.b != z10) {
            this.b = z10;
            com.stepos.common.animator.m mVar = new com.stepos.common.animator.m();
            this.f3769a = mVar;
            mVar.b(this, 3, true);
        }
    }
}
