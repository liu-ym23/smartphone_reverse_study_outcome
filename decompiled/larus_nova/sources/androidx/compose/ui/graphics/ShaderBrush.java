package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0011\u001a\u00060\u0012j\u0002`\u00132\u0006\u0010\u0014\u001a\u00020\u0007H&¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0002J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR*\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/Brush;", "<init>", "()V", "internalTransformShader", "Landroidx/compose/ui/graphics/TransformShader;", "createdSize", "Landroidx/compose/ui/geometry/Size;", "J", "value", "Landroidx/compose/ui/graphics/Matrix;", "transform", "getTransform-3i98HWw", "()[F", "setTransform-Q8lPUPs", "([F)V", "[F", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "obtainTransformShader", "applyTo", "", "p", "Landroidx/compose/ui/graphics/Paint;", "alpha", "", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ShaderBrush extends Brush {
    private long createdSize;
    private TransformShader internalTransformShader;
    private float[] transform;

    public ShaderBrush() {
        super(null);
        this.createdSize = Size.Companion.m4659getUnspecifiedNHjbRc();
    }

    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public abstract Shader mo4796createShaderuvyYCjk(long r100);

    private final TransformShader obtainTransformShader() {
        TransformShader r100 = this.internalTransformShader;
        if (r100 != null) goto L6;
        TransformShader r101 = new TransformShader();
        this.internalTransformShader = r101;
        return r101;
    L6:
        return r100;
    }

    /* JADX INFO: renamed from: getTransform-3i98HWw, reason: not valid java name */
    public final float[] m5161getTransform3i98HWw() {
        return this.transform;
    }

    /* JADX INFO: renamed from: setTransform-Q8lPUPs, reason: not valid java name */
    public final void m5162setTransformQ8lPUPs(float[] r100) {
        this.transform = r100;
        TransformShader r101 = this.internalTransformShader;
        if (r101 == null) goto L6;
        r101.m5245transformQ8lPUPs(r100);
        return;
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: applyTo-Pq9zytI */
    public final void mo4773applyToPq9zytI(long r100, Paint r101, float r102) {
        TransformShader r103 = this.internalTransformShader;
        Shader r104 = null;
        if (r103 == null) goto L7;
        if (Size.m4647equalsimpl0(this.createdSize, r100) == false) goto L7;
    L13:
        long r105 = r101.mo4698getColor0d7_KjU();
        Color.Companion r106 = Color.Companion;
        if (Color.m4828equalsimpl0(r105, r106.m4853getBlack0d7_KjU()) == true) goto L16;
        r101.mo4704setColor8_81llA(r106.m4853getBlack0d7_KjU());
    L16:
        Shader r107 = r101.getShader();
        if (r103 == null) goto L19;
        Shader r108 = r103.getShader();
    L21:
        if (Intrinsics.areEqual(r107, r108) == true) goto L26;
        if (r103 == null) goto L24;
        r104 = r103.getShader();
    L24:
        r101.setShader(r104);
    L26:
        if (r101.getAlpha() != r102) goto L28;
        boolean r109 = true;
    L29:
        if (r109 == true) goto L32;
        r101.setAlpha(r102);
        return;
    L32:
        return;
    L28:
        r109 = false;
        goto L29
    L19:
        r108 = null;
    L7:
        if (Size.m4653isEmptyimpl(r100) == false) goto L9;
        this.internalTransformShader = null;
        this.createdSize = Size.Companion.m4659getUnspecifiedNHjbRc();
        r103 = null;
        goto L13
    L9:
        r103 = obtainTransformShader();
        float[] r110 = this.transform;
        if (r110 == null) goto L12;
        r103.m5245transformQ8lPUPs(r110);
    L12:
        r103.setShader(mo4796createShaderuvyYCjk(r100));
        this.internalTransformShader = r103;
        this.createdSize = r100;
        goto L13
    }
}
