package com.stepos.widget.panel;

import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetGeometry;", "", "height", "", "safeTop", "imeBottom", "margin", "halfRatio", "topRatio", "expandedOnly", "", "<init>", "(FFFFFFZ)V", "bottom", "expandedTop", "getExpandedTop", "()F", "expandedHeight", "getExpandedHeight", "outerGap", "halfHeight", "getHalfHeight", "halfTop", "getHalfTop", "hiddenTop", "getHiddenTop", "top", "position", "inset", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSLiteSheetGeometry {
    private final float bottom;
    private final float expandedHeight;
    private final boolean expandedOnly;
    private final float expandedTop;
    private final float halfHeight;
    private final float halfTop;
    private final float hiddenTop;
    private final float margin;
    private final float outerGap;

    public StepOSLiteSheetGeometry(float f10, float f11, float f12, float f13, float f14, float f15, boolean z10) {
        this.margin = f13;
        this.expandedOnly = z10;
        float fM = C5685n.m(f10 - f12, 0.0f, C5685n.e(f10, 0.0f));
        this.bottom = fM;
        float fI = C5685n.i(C5685n.e(f15 * f10, f11), fM);
        this.expandedTop = fI;
        float fE = C5685n.e(fM - fI, 0.0f);
        this.expandedHeight = fE;
        float fMin = Math.min(f13, 0.1f * fE);
        this.outerGap = fMin;
        float fMin2 = Math.min(f14 * f10, C5685n.e(fE - fMin, 0.0f) * 0.8f);
        this.halfHeight = fMin2;
        this.halfTop = (fM - fMin) - fMin2;
        this.hiddenTop = f10;
    }

    public final float getExpandedHeight() {
        return this.expandedHeight;
    }

    public final float getExpandedTop() {
        return this.expandedTop;
    }

    public final float getHalfHeight() {
        return this.halfHeight;
    }

    public final float getHalfTop() {
        return this.halfTop;
    }

    public final float getHiddenTop() {
        return this.hiddenTop;
    }

    public final float height(float position) {
        if (this.expandedOnly) {
            return this.expandedHeight;
        }
        if (position > 1.0f) {
            return this.halfHeight;
        }
        float f10 = this.expandedHeight;
        return f10 + ((this.halfHeight - f10) * position);
    }

    public final float inset(float position) {
        if (this.expandedOnly) {
            return 0.0f;
        }
        return this.outerGap * C5685n.m(position, 0.0f, 1.0f);
    }

    public final float position(float top) {
        if (this.expandedOnly) {
            float f10 = this.expandedTop;
            return ((top - f10) * 2.0f) / C5685n.e(this.hiddenTop - f10, 1.0f);
        }
        float f11 = this.halfTop;
        if (top > f11) {
            return ((top - f11) / C5685n.e(this.hiddenTop - f11, 1.0f)) + 1.0f;
        }
        float f12 = this.expandedTop;
        return (top - f12) / C5685n.e(f11 - f12, 1.0f);
    }

    public final float top(float position) {
        float f10;
        float f11;
        if (this.expandedOnly) {
            f10 = this.expandedTop;
            f11 = ((this.hiddenTop - f10) * position) / 2.0f;
        } else {
            if (position > 1.0f) {
                float f12 = this.halfTop;
                return f12 + ((this.hiddenTop - f12) * (position - 1.0f));
            }
            f10 = this.expandedTop;
            f11 = (this.halfTop - f10) * position;
        }
        return f10 + f11;
    }

    public /* synthetic */ StepOSLiteSheetGeometry(float f10, float f11, float f12, float f13, float f14, float f15, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this(f10, f11, f12, f13, f14, f15, (i10 & 64) != 0 ? false : z10);
    }
}
