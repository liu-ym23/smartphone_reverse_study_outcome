package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Immutable
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\r\u001a\u00060\tj\u0002`\n2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0015\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R.\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/Brush;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/graphics/TransformShader;", "obtainTransformShader", "()Landroidx/compose/ui/graphics/TransformShader;", "Landroidx/compose/ui/geometry/Size;", "size", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "createShader", "Landroidx/compose/ui/graphics/Paint;", "p", "", "alpha", "LC7/r;", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "applyTo", "internalTransformShader", "Landroidx/compose/ui/graphics/TransformShader;", "createdSize", "J", "Landroidx/compose/ui/graphics/Matrix;", "value", "transform", "[F", "getTransform-3i98HWw", "()[F", "setTransform-Q8lPUPs", "([F)V", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ShaderBrush extends Brush {
    private long createdSize;
    private TransformShader internalTransformShader;
    private float[] transform;

    public ShaderBrush() {
        super(null);
        this.createdSize = Size.INSTANCE.m3972getUnspecifiedNHjbRc();
    }

    private final TransformShader obtainTransformShader() {
        TransformShader transformShader = this.internalTransformShader;
        if (transformShader != null) {
            return transformShader;
        }
        TransformShader transformShader2 = new TransformShader();
        this.internalTransformShader = transformShader2;
        return transformShader2;
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* renamed from: applyTo-Pq9zytI */
    public final void mo4085applyToPq9zytI(long size, Paint p, float alpha) {
        TransformShader transformShaderObtainTransformShader = this.internalTransformShader;
        if (transformShaderObtainTransformShader == null || !Size.m3960equalsimpl0(this.createdSize, size)) {
            if (Size.m3966isEmptyimpl(size)) {
                this.internalTransformShader = null;
                this.createdSize = Size.INSTANCE.m3972getUnspecifiedNHjbRc();
                transformShaderObtainTransformShader = null;
            } else {
                transformShaderObtainTransformShader = obtainTransformShader();
                float[] fArr = this.transform;
                if (fArr != null) {
                    transformShaderObtainTransformShader.m4547transformQ8lPUPs(fArr);
                }
                transformShaderObtainTransformShader.setShader(mo4108createShaderuvyYCjk(size));
                this.internalTransformShader = transformShaderObtainTransformShader;
                this.createdSize = size;
            }
        }
        long jMo4010getColor0d7_KjU = p.mo4010getColor0d7_KjU();
        Color.Companion companion = Color.INSTANCE;
        if (!Color.m4140equalsimpl0(jMo4010getColor0d7_KjU, companion.m4165getBlack0d7_KjU())) {
            p.mo4016setColor8_81llA(companion.m4165getBlack0d7_KjU());
        }
        if (!k.b(p.getShader(), transformShaderObtainTransformShader != null ? transformShaderObtainTransformShader.getShader() : null)) {
            p.setShader(transformShaderObtainTransformShader != null ? transformShaderObtainTransformShader.getShader() : null);
        }
        if (p.getAlpha() == alpha) {
            return;
        }
        p.setAlpha(alpha);
    }

    /* renamed from: createShader-uvyYCjk */
    public abstract Shader mo4108createShaderuvyYCjk(long size);

    /* renamed from: getTransform-3i98HWw, reason: not valid java name and from getter */
    public final float[] getTransform() {
        return this.transform;
    }

    /* renamed from: setTransform-Q8lPUPs, reason: not valid java name */
    public final void m4464setTransformQ8lPUPs(float[] fArr) {
        this.transform = fArr;
        TransformShader transformShader = this.internalTransformShader;
        if (transformShader != null) {
            transformShader.m4547transformQ8lPUPs(fArr);
        }
    }
}
