package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0000J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/node/LayerPositionalProperties;", "", "<init>", "()V", LiveDegradeFpsAnimator.SCALE_X, "", LiveDegradeFpsAnimator.SCALE_Y, LiveDegradeFpsAnimator.TRANSLATION_X, LiveDegradeFpsAnimator.TRANSLATION_Y, "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "copyFrom", "", "other", "scope", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "hasSameValuesAs", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class LayerPositionalProperties {
    private float cameraDistance;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private long transformOrigin;
    private float translationX;
    private float translationY;

    public LayerPositionalProperties() {
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.cameraDistance = 8.0f;
        this.transformOrigin = TransformOrigin.Companion.m5244getCenterSzJe1aQ();
    }

    public final void copyFrom(GraphicsLayerScope r100) {
        this.scaleX = r100.getScaleX();
        this.scaleY = r100.getScaleY();
        this.translationX = r100.getTranslationX();
        this.translationY = r100.getTranslationY();
        this.rotationX = r100.getRotationX();
        this.rotationY = r100.getRotationY();
        this.rotationZ = r100.getRotationZ();
        this.cameraDistance = r100.getCameraDistance();
        this.transformOrigin = r100.mo5002getTransformOriginSzJe1aQ();
    }

    public final boolean hasSameValuesAs(LayerPositionalProperties r100) {
        if (this.scaleX != r100.scaleX) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
    L45:
        return false;
    L8:
        if (this.scaleY != r100.scaleY) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L45;
        if (this.translationX != r100.translationX) goto L15;
        boolean r103 = true;
    L16:
        if (r103 == false) goto L45;
        if (this.translationY != r100.translationY) goto L20;
        boolean r104 = true;
    L21:
        if (r104 == false) goto L45;
        if (this.rotationX != r100.rotationX) goto L25;
        boolean r105 = true;
    L26:
        if (r105 == false) goto L45;
        if (this.rotationY != r100.rotationY) goto L30;
        boolean r106 = true;
    L31:
        if (r106 == false) goto L45;
        if (this.rotationZ != r100.rotationZ) goto L35;
        boolean r107 = true;
    L36:
        if (r107 == false) goto L45;
        if (this.cameraDistance != r100.cameraDistance) goto L40;
        boolean r108 = true;
    L41:
        if (r108 == false) goto L45;
        if (TransformOrigin.m5238equalsimpl0(this.transformOrigin, r100.transformOrigin) == false) goto L45;
        return true;
    L40:
        r108 = false;
        goto L41
    L35:
        r107 = false;
        goto L36
    L30:
        r106 = false;
        goto L31
    L25:
        r105 = false;
        goto L26
    L20:
        r104 = false;
        goto L21
    L15:
        r103 = false;
        goto L16
    L10:
        r102 = false;
        goto L11
    L5:
        r101 = false;
        goto L6
    }

    public final void copyFrom(LayerPositionalProperties r100) {
        this.scaleX = r100.scaleX;
        this.scaleY = r100.scaleY;
        this.translationX = r100.translationX;
        this.translationY = r100.translationY;
        this.rotationX = r100.rotationX;
        this.rotationY = r100.rotationY;
        this.rotationZ = r100.rotationZ;
        this.cameraDistance = r100.cameraDistance;
        this.transformOrigin = r100.transformOrigin;
    }
}
