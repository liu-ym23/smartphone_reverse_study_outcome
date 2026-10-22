package com.alibaba.gaiax.render.view.basic.boxshadow;

import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000eH&J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\nH\u0016J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0006H\u0017J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\nH\u0017J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u000eH\u0017R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/boxshadow/GXShadowDrawable;", "Landroid/graphics/drawable/Drawable;", "shadowPath", "Landroid/graphics/Path;", "(Landroid/graphics/Path;)V", "<set-?>", "", "shadowBlur", "getShadowBlur", "()F", "", "shadowColor", "getShadowColor", "()I", "", "shadowInset", "getShadowInset", "()Z", "getShadowPath", "()Landroid/graphics/Path;", "getOpacity", "invalidateCache", "", "onShadowChange", "blur", "color", "inset", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setShadowBlur", "setShadowColor", "setShadowInset", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class GXShadowDrawable extends Drawable {
    private float shadowBlur;
    private int shadowColor;
    private boolean shadowInset;
    private final Path shadowPath;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void invalidateCache() {
    }

    public abstract void onShadowChange(float r100, int r101, boolean r102);

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
    }

    public final float getShadowBlur() {
        return this.shadowBlur;
    }

    public final int getShadowColor() {
        return this.shadowColor;
    }

    public final boolean getShadowInset() {
        return this.shadowInset;
    }

    public final Path getShadowPath() {
        return this.shadowPath;
    }

    public GXShadowDrawable(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "shadowPath");
        this.shadowPath = r100;
    }

    public void setShadowBlur(float r100) {
        this.shadowBlur = r100;
        onShadowChange(r100, this.shadowColor, this.shadowInset);
    }

    public void setShadowColor(int r100) {
        this.shadowColor = r100;
        onShadowChange(this.shadowBlur, r100, this.shadowInset);
    }

    public void setShadowInset(boolean r100) {
        this.shadowInset = r100;
        onShadowChange(this.shadowBlur, this.shadowColor, r100);
    }
}
