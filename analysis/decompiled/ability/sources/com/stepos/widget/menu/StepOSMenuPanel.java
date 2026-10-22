package com.stepos.widget.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.stepos.ability.R;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028G@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/stepos/widget/menu/StepOSMenuPanel;", "Landroid/widget/FrameLayout;", "", "value", "a", "F", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "cornerRadius", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public final class StepOSMenuPanel extends FrameLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public float cornerRadius;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSMenuPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        k.f(context, "context");
        this.cornerRadius = context.getResources().getDimension(R.dimen.stepos_menu_corner_radius);
    }

    @Px
    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final void setCornerRadius(float f) {
        if (this.cornerRadius == f) {
            return;
        }
        this.cornerRadius = f;
        invalidateOutline();
    }
}
