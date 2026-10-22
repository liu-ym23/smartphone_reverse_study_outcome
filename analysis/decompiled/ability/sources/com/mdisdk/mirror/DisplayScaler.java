package com.mdisdk.mirror;

import android.graphics.PointF;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u0004¢\u0006\u0004\b$\u0010#J\r\u0010%\u001a\u00020\n¢\u0006\u0004\b%\u0010\u0003R\u0016\u0010&\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010)R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010,\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010)R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010-R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010-¨\u0006."}, d2 = {"Lcom/mdisdk/mirror/DisplayScaler;", "", AppAgent.CONSTRUCT, "()V", "", "viewWidth", "viewHeight", "", "viewAspect", "displayAspect", "LC7/r;", "calculateFitScale", "(IIFF)V", "calculateFillScale", "Lcom/mdisdk/mirror/ScaleMode;", "mode", "setScaleMode", "(Lcom/mdisdk/mirror/ScaleMode;)V", "getScaleMode", "()Lcom/mdisdk/mirror/ScaleMode;", "displayWidth", "displayHeight", "calculateScale", "(IIII)V", "viewX", "viewY", "Landroid/graphics/PointF;", "scalePoint", "(FF)Landroid/graphics/PointF;", "displayX", "displayY", "", "isInDisplayBounds", "(FF)Z", "getDisplayWidth", "()I", "getDisplayHeight", "reset", "scaleMode", "Lcom/mdisdk/mirror/ScaleMode;", "scaleX", "F", "scaleY", "offsetX", "offsetY", "I", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DisplayScaler {
    private int displayHeight;
    private int displayWidth;
    private float offsetX;
    private float offsetY;
    private ScaleMode scaleMode = ScaleMode.FIT;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScaleMode.values().length];
            try {
                iArr[ScaleMode.FIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScaleMode.FILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScaleMode.CROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void calculateFillScale(int viewWidth, int viewHeight, float viewAspect, float displayAspect) {
        float f;
        float f7;
        if (viewAspect > displayAspect) {
            f7 = viewWidth;
            f = f7 / displayAspect;
            this.offsetX = 0.0f;
            this.offsetY = (viewHeight - f) / 2;
        } else {
            f = viewHeight;
            float f9 = f * displayAspect;
            this.offsetX = (viewWidth - f9) / 2;
            this.offsetY = 0.0f;
            f7 = f9;
        }
        this.scaleX = this.displayWidth / f7;
        this.scaleY = this.displayHeight / f;
    }

    private final void calculateFitScale(int viewWidth, int viewHeight, float viewAspect, float displayAspect) {
        float f;
        float f7;
        if (viewAspect > displayAspect) {
            f7 = viewHeight;
            f = displayAspect * f7;
            this.offsetX = (viewWidth - f) / 2;
            this.offsetY = 0.0f;
        } else {
            float f9 = viewWidth;
            float f10 = f9 / displayAspect;
            this.offsetX = 0.0f;
            this.offsetY = (viewHeight - f10) / 2;
            f = f9;
            f7 = f10;
        }
        this.scaleX = this.displayWidth / f;
        this.scaleY = this.displayHeight / f7;
    }

    public final void calculateScale(int viewWidth, int viewHeight, int displayWidth, int displayHeight) {
        this.displayWidth = displayWidth;
        this.displayHeight = displayHeight;
        if (viewWidth <= 0 || viewHeight <= 0 || displayWidth <= 0 || displayHeight <= 0) {
            reset();
            return;
        }
        float f = viewWidth / viewHeight;
        float f7 = displayWidth / displayHeight;
        int i = WhenMappings.$EnumSwitchMapping$0[this.scaleMode.ordinal()];
        if (i == 1) {
            calculateFitScale(viewWidth, viewHeight, f, f7);
        } else {
            if (i != 2 && i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            calculateFillScale(viewWidth, viewHeight, f, f7);
        }
    }

    public final int getDisplayHeight() {
        return this.displayHeight;
    }

    public final int getDisplayWidth() {
        return this.displayWidth;
    }

    public final ScaleMode getScaleMode() {
        return this.scaleMode;
    }

    public final boolean isInDisplayBounds(float displayX, float displayY) {
        return displayX >= 0.0f && displayX <= ((float) this.displayWidth) && displayY >= 0.0f && displayY <= ((float) this.displayHeight);
    }

    public final void reset() {
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.offsetX = 0.0f;
        this.offsetY = 0.0f;
        this.displayWidth = 0;
        this.displayHeight = 0;
    }

    public final PointF scalePoint(float viewX, float viewY) {
        return new PointF((viewX - this.offsetX) * this.scaleX, (viewY - this.offsetY) * this.scaleY);
    }

    public final void setScaleMode(ScaleMode mode) {
        k.f(mode, "mode");
        this.scaleMode = mode;
    }
}
