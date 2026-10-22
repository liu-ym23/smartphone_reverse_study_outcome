package com.stepos.widget.menu;

import V3.v;
import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import j4.g;
import j4.k;
import l3.C0845c;

/* loaded from: classes.dex */
public final class StepOSMenuPressOverlayView extends View {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuPressOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k.g(context, "context");
    }

    public /* synthetic */ StepOSMenuPressOverlayView(Context context, AttributeSet attributeSet, int i5, int i6, g gVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? 0 : i5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSMenuPressOverlayView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        k.g(context, "context");
        if (context.getResources().getBoolean(C0845c.f18290b)) {
            Paint paint = new Paint(1);
            paint.setBlendMode(BlendMode.PLUS);
            v vVar = v.f5542a;
            setLayerType(2, paint);
        }
    }
}
