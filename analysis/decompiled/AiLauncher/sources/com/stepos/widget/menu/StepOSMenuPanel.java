package com.stepos.widget.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR&\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/widget/menu/StepOSMenuPanel;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UxipConstants.f30680s, "", "cornerRadius", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSMenuPanel extends FrameLayout {
    private float cornerRadius;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuPanel(Context context) {
        this(context, null, 0, 6, null);
        p.i(context, "context");
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final void setCornerRadius(float f10) {
        if (this.cornerRadius == f10) {
            return;
        }
        this.cornerRadius = f10;
        invalidateOutline();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        p.i(context, "context");
    }

    public /* synthetic */ StepOSMenuPanel(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSMenuPanel(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
        this.cornerRadius = context.getResources().getDimension(R.dimen.stepos_menu_corner_radius);
    }
}
