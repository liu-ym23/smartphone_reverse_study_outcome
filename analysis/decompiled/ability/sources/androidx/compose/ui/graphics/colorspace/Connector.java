package androidx.compose.ui.graphics.colorspace;

import androidx.annotation.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 #2\u00020\u0001:\u0002$#B;\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fB!\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\u000eJ'\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\n\u0010\u0013J\u0019\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0014\u001a\u00020\tH\u0017¢\u0006\u0004\b\n\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0010¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\"¨\u0006%"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector;", "", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", AgentBusWakeContract.EXTRA_SOURCE, "destination", "transformSource", "transformDestination", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "renderIntent", "", "transform", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I[FLkotlin/jvm/internal/e;)V", "intent", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;ILkotlin/jvm/internal/e;)V", "", "r", "g", "b", "(FFF)[F", "v", "([F)[F", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "transformToColor-l2rxGTc$ui_graphics_release", "(J)J", "transformToColor", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getSource", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getDestination", "I", "getRenderIntent-uksYyKA", "()I", "[F", "Companion", "RgbConnector", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public class Connector {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ColorSpace destination;
    private final int renderIntent;
    private final ColorSpace source;
    private final float[] transform;
    private final ColorSpace transformDestination;
    private final ColorSpace transformSource;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector$Companion;", "", AppAgent.CONSTRUCT, "()V", "computeTransform", "", AgentBusWakeContract.EXTRA_SOURCE, "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "destination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "computeTransform-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I)[F", "identity", "Landroidx/compose/ui/graphics/colorspace/Connector;", "identity$ui_graphics_release", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: computeTransform-YBCOT_4, reason: not valid java name */
        public final float[] m4580computeTransformYBCOT_4(ColorSpace source, ColorSpace destination, int intent) {
            if (!RenderIntent.m4586equalsimpl0(intent, RenderIntent.INSTANCE.m4590getAbsoluteuksYyKA())) {
                return null;
            }
            long model = source.getModel();
            ColorModel.Companion companion = ColorModel.INSTANCE;
            boolean zM4563equalsimpl0 = ColorModel.m4563equalsimpl0(model, companion.m4570getRgbxdoWZVw());
            boolean zM4563equalsimpl02 = ColorModel.m4563equalsimpl0(destination.getModel(), companion.m4570getRgbxdoWZVw());
            if (zM4563equalsimpl0 && zM4563equalsimpl02) {
                return null;
            }
            if (!zM4563equalsimpl0 && !zM4563equalsimpl02) {
                return null;
            }
            if (!zM4563equalsimpl0) {
                source = destination;
            }
            Rgb rgb = (Rgb) source;
            float[] xyz$ui_graphics_release = zM4563equalsimpl0 ? rgb.getWhitePoint().toXyz$ui_graphics_release() : Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
            float[] xyz$ui_graphics_release2 = zM4563equalsimpl02 ? rgb.getWhitePoint().toXyz$ui_graphics_release() : Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
            return new float[]{xyz$ui_graphics_release[0] / xyz$ui_graphics_release2[0], xyz$ui_graphics_release[1] / xyz$ui_graphics_release2[1], xyz$ui_graphics_release[2] / xyz$ui_graphics_release2[2]};
        }

        public final Connector identity$ui_graphics_release(final ColorSpace source) {
            final int iM4592getRelativeuksYyKA = RenderIntent.INSTANCE.m4592getRelativeuksYyKA();
            return new Connector(source, iM4592getRelativeuksYyKA) { // from class: androidx.compose.ui.graphics.colorspace.Connector$Companion$identity$1
                {
                    super(source, source, iM4592getRelativeuksYyKA, null);
                }

                @Override // androidx.compose.ui.graphics.colorspace.Connector
                public float[] transform(float[] v10) {
                    return v10;
                }

                @Override // androidx.compose.ui.graphics.colorspace.Connector
                /* renamed from: transformToColor-l2rxGTc$ui_graphics_release */
                public long mo4578transformToColorl2rxGTc$ui_graphics_release(long color) {
                    return color;
                }
            };
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0010¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector$RgbConnector;", "Landroidx/compose/ui/graphics/colorspace/Connector;", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "mSource", "mDestination", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "intent", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/graphics/colorspace/Rgb;Landroidx/compose/ui/graphics/colorspace/Rgb;ILkotlin/jvm/internal/e;)V", AgentBusWakeContract.EXTRA_SOURCE, "destination", "", "computeTransform-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/Rgb;Landroidx/compose/ui/graphics/colorspace/Rgb;I)[F", "computeTransform", "v", "transform", "([F)[F", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "transformToColor-l2rxGTc$ui_graphics_release", "(J)J", "transformToColor", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "mTransform", "[F", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RgbConnector extends Connector {
        private final Rgb mDestination;
        private final Rgb mSource;
        private final float[] mTransform;

        public /* synthetic */ RgbConnector(Rgb rgb, Rgb rgb2, int i, e eVar) {
            this(rgb, rgb2, i);
        }

        /* renamed from: computeTransform-YBCOT_4, reason: not valid java name */
        private final float[] m4581computeTransformYBCOT_4(Rgb source, Rgb destination, int intent) {
            if (ColorSpaceKt.compare(source.getWhitePoint(), destination.getWhitePoint())) {
                return ColorSpaceKt.mul3x3(destination.getInverseTransform(), source.getTransform());
            }
            float[] transform = source.getTransform();
            float[] inverseTransform = destination.getInverseTransform();
            float[] xyz$ui_graphics_release = source.getWhitePoint().toXyz$ui_graphics_release();
            float[] xyz$ui_graphics_release2 = destination.getWhitePoint().toXyz$ui_graphics_release();
            WhitePoint whitePoint = source.getWhitePoint();
            Illuminant illuminant = Illuminant.INSTANCE;
            if (!ColorSpaceKt.compare(whitePoint, illuminant.getD50())) {
                transform = ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(Adaptation.INSTANCE.getBradford().getTransform(), xyz$ui_graphics_release, illuminant.newD50Xyz$ui_graphics_release()), source.getTransform());
            }
            if (!ColorSpaceKt.compare(destination.getWhitePoint(), illuminant.getD50())) {
                inverseTransform = ColorSpaceKt.inverse3x3(ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(Adaptation.INSTANCE.getBradford().getTransform(), xyz$ui_graphics_release2, illuminant.newD50Xyz$ui_graphics_release()), destination.getTransform()));
            }
            if (RenderIntent.m4586equalsimpl0(intent, RenderIntent.INSTANCE.m4590getAbsoluteuksYyKA())) {
                transform = ColorSpaceKt.mul3x3Diag(new float[]{xyz$ui_graphics_release[0] / xyz$ui_graphics_release2[0], xyz$ui_graphics_release[1] / xyz$ui_graphics_release2[1], xyz$ui_graphics_release[2] / xyz$ui_graphics_release2[2]}, transform);
            }
            return ColorSpaceKt.mul3x3(inverseTransform, transform);
        }

        @Override // androidx.compose.ui.graphics.colorspace.Connector
        public float[] transform(float[] v10) {
            v10[0] = (float) this.mSource.getEotfFunc().invoke(v10[0]);
            v10[1] = (float) this.mSource.getEotfFunc().invoke(v10[1]);
            v10[2] = (float) this.mSource.getEotfFunc().invoke(v10[2]);
            ColorSpaceKt.mul3x3Float3(this.mTransform, v10);
            v10[0] = (float) this.mDestination.getOetfFunc().invoke(v10[0]);
            v10[1] = (float) this.mDestination.getOetfFunc().invoke(v10[1]);
            v10[2] = (float) this.mDestination.getOetfFunc().invoke(v10[2]);
            return v10;
        }

        @Override // androidx.compose.ui.graphics.colorspace.Connector
        /* renamed from: transformToColor-l2rxGTc$ui_graphics_release */
        public long mo4578transformToColorl2rxGTc$ui_graphics_release(long color) {
            float fM4145getRedimpl = Color.m4145getRedimpl(color);
            float fM4144getGreenimpl = Color.m4144getGreenimpl(color);
            float fM4142getBlueimpl = Color.m4142getBlueimpl(color);
            float fM4141getAlphaimpl = Color.m4141getAlphaimpl(color);
            float fInvoke = (float) this.mSource.getEotfFunc().invoke(fM4145getRedimpl);
            float fInvoke2 = (float) this.mSource.getEotfFunc().invoke(fM4144getGreenimpl);
            float fInvoke3 = (float) this.mSource.getEotfFunc().invoke(fM4142getBlueimpl);
            float[] fArr = this.mTransform;
            return ColorKt.Color((float) this.mDestination.getOetfFunc().invoke((fArr[6] * fInvoke3) + (fArr[3] * fInvoke2) + (fArr[0] * fInvoke)), (float) this.mDestination.getOetfFunc().invoke((fArr[7] * fInvoke3) + (fArr[4] * fInvoke2) + (fArr[1] * fInvoke)), (float) this.mDestination.getOetfFunc().invoke((fArr[8] * fInvoke3) + (fArr[5] * fInvoke2) + (fArr[2] * fInvoke)), fM4141getAlphaimpl, this.mDestination);
        }

        private RgbConnector(Rgb rgb, Rgb rgb2, int i) {
            super(rgb, rgb2, rgb, rgb2, i, null, null);
            this.mSource = rgb;
            this.mDestination = rgb2;
            this.mTransform = m4581computeTransformYBCOT_4(rgb, rgb2, i);
        }
    }

    public /* synthetic */ Connector(ColorSpace colorSpace, ColorSpace colorSpace2, int i, e eVar) {
        this(colorSpace, colorSpace2, i);
    }

    public final ColorSpace getDestination() {
        return this.destination;
    }

    /* renamed from: getRenderIntent-uksYyKA, reason: not valid java name and from getter */
    public final int getRenderIntent() {
        return this.renderIntent;
    }

    public final ColorSpace getSource() {
        return this.source;
    }

    @Size(3)
    public final float[] transform(float r5, float g, float b) {
        return transform(new float[]{r5, g, b});
    }

    /* renamed from: transformToColor-l2rxGTc$ui_graphics_release, reason: not valid java name */
    public long mo4578transformToColorl2rxGTc$ui_graphics_release(long color) {
        float fM4145getRedimpl = Color.m4145getRedimpl(color);
        float fM4144getGreenimpl = Color.m4144getGreenimpl(color);
        float fM4142getBlueimpl = Color.m4142getBlueimpl(color);
        float fM4141getAlphaimpl = Color.m4141getAlphaimpl(color);
        long xy$ui_graphics_release = this.transformSource.toXy$ui_graphics_release(fM4145getRedimpl, fM4144getGreenimpl, fM4142getBlueimpl);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (xy$ui_graphics_release >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (xy$ui_graphics_release & 4294967295L));
        float z$ui_graphics_release = this.transformSource.toZ$ui_graphics_release(fM4145getRedimpl, fM4144getGreenimpl, fM4142getBlueimpl);
        float[] fArr = this.transform;
        if (fArr != null) {
            fIntBitsToFloat *= fArr[0];
            fIntBitsToFloat2 *= fArr[1];
            z$ui_graphics_release *= fArr[2];
        }
        float f = fIntBitsToFloat;
        return this.transformDestination.mo4573xyzaToColorJlNiLsg$ui_graphics_release(f, fIntBitsToFloat2, z$ui_graphics_release, fM4141getAlphaimpl, this.destination);
    }

    public /* synthetic */ Connector(ColorSpace colorSpace, ColorSpace colorSpace2, ColorSpace colorSpace3, ColorSpace colorSpace4, int i, float[] fArr, e eVar) {
        this(colorSpace, colorSpace2, colorSpace3, colorSpace4, i, fArr);
    }

    @Size(min = 3)
    public float[] transform(@Size(min = 3) float[] v10) {
        float[] xyz = this.transformSource.toXyz(v10);
        float[] fArr = this.transform;
        if (fArr != null) {
            xyz[0] = xyz[0] * fArr[0];
            xyz[1] = xyz[1] * fArr[1];
            xyz[2] = xyz[2] * fArr[2];
        }
        return this.transformDestination.fromXyz(xyz);
    }

    private Connector(ColorSpace colorSpace, ColorSpace colorSpace2, ColorSpace colorSpace3, ColorSpace colorSpace4, int i, float[] fArr) {
        this.source = colorSpace;
        this.destination = colorSpace2;
        this.transformSource = colorSpace3;
        this.transformDestination = colorSpace4;
        this.renderIntent = i;
        this.transform = fArr;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private Connector(ColorSpace colorSpace, ColorSpace colorSpace2, int i) {
        long model = colorSpace.getModel();
        ColorModel.Companion companion = ColorModel.INSTANCE;
        this(colorSpace, colorSpace2, ColorModel.m4563equalsimpl0(model, companion.m4570getRgbxdoWZVw()) ? ColorSpaceKt.adapt$default(colorSpace, Illuminant.INSTANCE.getD50(), null, 2, null) : colorSpace, ColorModel.m4563equalsimpl0(colorSpace2.getModel(), companion.m4570getRgbxdoWZVw()) ? ColorSpaceKt.adapt$default(colorSpace2, Illuminant.INSTANCE.getD50(), null, 2, null) : colorSpace2, i, INSTANCE.m4580computeTransformYBCOT_4(colorSpace, colorSpace2, i), null);
    }
}
