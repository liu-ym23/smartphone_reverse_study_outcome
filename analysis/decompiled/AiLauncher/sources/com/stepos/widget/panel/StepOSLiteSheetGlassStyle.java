package com.stepos.widget.panel;

import kotlin.Metadata;
import r9.C5227b;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\b\b\u0001\u0010\f\u001a\u00020\u0007J\u0012\u0010\r\u001a\u00020\u00032\b\b\u0001\u0010\f\u001a\u00020\u0007H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetGlassStyle;", "", "halfBlur", "", "expandedBlur", "baseColor", "halfAlpha", "", "expandedAlpha", "<init>", "(IIIFF)V", "blurRadius", "expansion", "tintColor", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSLiteSheetGlassStyle {
    private final int baseColor;
    private final float expandedAlpha;
    private final int expandedBlur;
    private final float halfAlpha;
    private final int halfBlur;

    public StepOSLiteSheetGlassStyle(int i10, int i11, int i12, float f10, float f11) {
        this.halfBlur = i10;
        this.expandedBlur = i11;
        this.baseColor = i12;
        this.halfAlpha = f10;
        this.expandedAlpha = f11;
    }

    public final int blurRadius(float expansion) {
        return C5227b.b(this.halfBlur + ((this.expandedBlur - r0) * expansion));
    }

    public final int tintColor(float expansion) {
        float f10 = this.halfAlpha;
        return (this.baseColor & 16777215) | (C5227b.b((f10 + ((this.expandedAlpha - f10) * expansion)) * 255) << 24);
    }
}
