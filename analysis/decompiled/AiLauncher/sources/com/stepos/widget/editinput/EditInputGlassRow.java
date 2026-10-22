package com.stepos.widget.editinput;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.glass.StepOSGlassLinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fR.\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/widget/editinput/EditInputGlassRow;", "Lcom/stepos/widget/glass/StepOSGlassLinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "LY8/t;", "drawableStateChanged", "()V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/drawable/Drawable;", UxipConstants.f30680s, "errorRing", "Landroid/graphics/drawable/Drawable;", "getErrorRing", "()Landroid/graphics/drawable/Drawable;", "setErrorRing", "(Landroid/graphics/drawable/Drawable;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
final class EditInputGlassRow extends StepOSGlassLinearLayout {
    private Drawable errorRing;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditInputGlassRow(Context context) {
        super(context, null, 0, 0, 14, null);
        p.i(context, "context");
    }

    @Override // com.stepos.widget.glass.StepOSGlassLinearLayout, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public final Drawable getErrorRing() {
        return this.errorRing;
    }

    @Override // com.stepos.widget.glass.StepOSGlassLinearLayout, android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        p.i(canvas, "canvas");
        super.onDraw(canvas);
        if (!isActivated() || (drawable = this.errorRing) == null) {
            return;
        }
        drawable.setBounds(0, 0, getWidth(), getHeight());
        drawable.draw(canvas);
    }

    public final void setErrorRing(Drawable drawable) {
        if (this.errorRing != drawable) {
            this.errorRing = drawable;
            invalidate();
        }
    }
}
