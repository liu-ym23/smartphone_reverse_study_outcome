package com.stepos.widget.menu;

import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RestrictTo;
import com.stepos.ability.R;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/menu/StepOSMenuPressOverlayView;", "Landroid/view/View;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public final class StepOSMenuPressOverlayView extends View {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSMenuPressOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        k.f(context, "context");
        if (context.getResources().getBoolean(R.bool.stepos_menu_item_press_plus_blend)) {
            Paint paint = new Paint(1);
            paint.setBlendMode(BlendMode.PLUS);
            setLayerType(2, paint);
        }
    }
}
