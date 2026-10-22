package com.stepos.widget.list;

import android.R;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0000¨\u0006\n"}, d2 = {"buildCardStateBackground", "Landroid/graphics/drawable/StateListDrawable;", "context", "Landroid/content/Context;", "radii", "", "normalColor", "", "pressFeedback", "", "StepOSWidget_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSListItemKt {
    public static final StateListDrawable buildCardStateBackground(Context context, float[] radii, int i10, boolean z10) {
        p.i(context, "context");
        p.i(radii, "radii");
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (z10) {
            stateListDrawable.addState(new int[]{R.attr.state_enabled, R.attr.state_pressed}, new LayerDrawable(new GradientDrawable[]{buildCardStateBackground$shape(radii, i10), buildCardStateBackground$shape(radii, context.getColor(com.stepos.widget.R.color.stepos_list_item_pressed))}));
        }
        stateListDrawable.addState(new int[0], buildCardStateBackground$shape(radii, i10));
        return stateListDrawable;
    }

    public static /* synthetic */ StateListDrawable buildCardStateBackground$default(Context context, float[] fArr, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z10 = true;
        }
        return buildCardStateBackground(context, fArr, i10, z10);
    }

    private static final GradientDrawable buildCardStateBackground$shape(float[] fArr, int i10) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii((float[]) fArr.clone());
        gradientDrawable.setColor(i10);
        return gradientDrawable;
    }
}
