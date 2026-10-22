package com.stepos.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.stepos.aiengine.R;
import com.stepos.common.animator.g;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StepOSButton extends androidx.appcompat.widget.e {

    /* renamed from: d, reason: collision with root package name */
    public com.stepos.common.animator.g f7054d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7055e;

    public StepOSButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyle);
        this.f7055e = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g8.a.f9087n, R.attr.buttonStyle, 0);
        typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.f7055e = typedArrayObtainStyledAttributes.getBoolean(0, this.f7055e);
        typedArrayObtainStyledAttributes.recycle();
        com.stepos.common.animator.g gVar = new com.stepos.common.animator.g();
        this.f7054d = gVar;
        gVar.b(this, 3, true);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        com.stepos.common.animator.g gVar = this.f7054d;
        gVar.getClass();
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            ArrayList arrayList = gVar.f6471a;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                g.c cVar = (g.c) obj;
                if (this == cVar.f6480a && isEnabled()) {
                    gVar.c(this, motionEvent, cVar.f6481b);
                }
            }
        }
        if (isEnabled() && this.f7055e) {
            motionEvent.getAction();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setPressAnimationEnabled(boolean z) {
        if (this.f7055e != z) {
            this.f7055e = z;
            com.stepos.common.animator.g gVar = new com.stepos.common.animator.g();
            this.f7054d = gVar;
            gVar.b(this, 3, true);
        }
    }
}
