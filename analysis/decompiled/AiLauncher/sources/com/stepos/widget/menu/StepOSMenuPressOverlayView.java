package com.stepos.widget.menu;

import Y8.t;
import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.stepos.widget.R;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/widget/menu/StepOSMenuPressOverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSMenuPressOverlayView extends View {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuPressOverlayView(Context context) {
        this(context, null, 0, 6, null);
        p.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuPressOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        p.i(context, "context");
    }

    public /* synthetic */ StepOSMenuPressOverlayView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSMenuPressOverlayView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
        if (context.getResources().getBoolean(R.bool.stepos_menu_item_press_plus_blend)) {
            Paint paint = new Paint(1);
            paint.setBlendMode(BlendMode.PLUS);
            t tVar = t.f7040a;
            setLayerType(2, paint);
        }
    }
}
