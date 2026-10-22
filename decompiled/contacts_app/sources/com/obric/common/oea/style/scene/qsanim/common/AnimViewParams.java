package com.obric.common.oea.style.scene.qsanim.common;

import kotlin.Metadata;

/* JADX INFO: compiled from: AnimViewParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/common/AnimViewParams;", "", "viewWidth", "", "viewHeight", "viewX", "viewY", "(FFFF)V", "getViewHeight", "()F", "getViewWidth", "getViewX", "getViewY", "toString", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AnimViewParams {
    private final float viewHeight;
    private final float viewWidth;
    private final float viewX;
    private final float viewY;

    public AnimViewParams(float r1, float r2, float r3, float r4) {
        this.viewWidth = r1;
        this.viewHeight = r2;
        this.viewX = r3;
        this.viewY = r4;
    }

    public final float getViewWidth() {
        return this.viewWidth;
    }

    public final float getViewHeight() {
        return this.viewHeight;
    }

    public final float getViewX() {
        return this.viewX;
    }

    public final float getViewY() {
        return this.viewY;
    }

    public String toString() {
        return "AnimViewParams(viewWidth: " + this.viewWidth + ", viewHeight: " + this.viewHeight + ", viewX: " + this.viewX + ", viewY: " + this.viewY + ')';
    }
}
