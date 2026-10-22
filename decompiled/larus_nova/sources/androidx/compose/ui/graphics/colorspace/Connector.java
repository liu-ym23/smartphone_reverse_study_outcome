package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.amap.api.col.s.ce;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000  2\u00020\u0001:\u0002\u001f B;\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fB!\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u000eJ \u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0007J\u0012\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0019\u001a\u00020\nH\u0017J\u0017\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0010¢\u0006\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector;", "", "source", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "transformSource", "transformDestination", "renderIntent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "transform", "", "<init>", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I[FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "intent", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSource", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getDestination", "getRenderIntent-uksYyKA", "()I", "I", "r", "", ce.f26391f, "b", BaseSwitches.V, "transformToColor", "Landroidx/compose/ui/graphics/Color;", "color", "transformToColor-l2rxGTc$ui_graphics_release", "(J)J", "RgbConnector", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class Connector {
    public static final Companion Companion = null;
    private final ColorSpace destination;
    private final int renderIntent;
    private final ColorSpace source;
    private final float[] transform;
    private final ColorSpace transformDestination;
    private final ColorSpace transformSource;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector$Companion;", "", "<init>", "()V", "computeTransform", "", "source", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "computeTransform-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I)[F", DownloadHelper.IDENTITY, "Landroidx/compose/ui/graphics/colorspace/Connector;", "identity$ui_graphics_release", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Connector identity$ui_graphics_release(final ColorSpace r100) {
            final int r101 = RenderIntent.Companion.m5290getRelativeuksYyKA();
            return new Connector$Companion$identity$1(r100, r101);
        }

        /* JADX INFO: renamed from: computeTransform-YBCOT_4, reason: not valid java name */
        private final float[] m5278computeTransformYBCOT_4(ColorSpace r100, ColorSpace r101, int r102) {
            if (RenderIntent.m5284equalsimpl0(r102, RenderIntent.Companion.m5288getAbsoluteuksYyKA()) == true) goto L5;
            return null;
        L5:
            long r103 = r100.m5270getModelxdoWZVw();
            ColorModel.Companion r104 = ColorModel.Companion;
            boolean r105 = ColorModel.m5261equalsimpl0(r103, r104.m5268getRgbxdoWZVw());
            boolean r106 = ColorModel.m5261equalsimpl0(r101.m5270getModelxdoWZVw(), r104.m5268getRgbxdoWZVw());
            if (r105 == false) goto L9;
            if (r106 == false) goto L9;
            return null;
        L9:
            if (r105 == true) goto L13;
            if (r106 == true) goto L13;
            return null;
        L13:
            if (r105 == true) goto L16;
            r100 = r101;
        L16:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            Rgb r107 = (Rgb) r100;
            if (r105 == false) goto L19;
            float[] r108 = r107.getWhitePoint().toXyz$ui_graphics_release();
        L20:
            if (r106 == false) goto L22;
            float[] r109 = r107.getWhitePoint().toXyz$ui_graphics_release();
        L24:
            return new float[]{r108[0] / r109[0], r108[1] / r109[1], r108[2] / r109[2]};
        L22:
            r109 = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
            goto L24
        L19:
            r108 = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
            goto L20
        }

        /* JADX INFO: renamed from: access$computeTransform-YBCOT_4, reason: not valid java name */
        public static final /* synthetic */ float[] m5277access$computeTransformYBCOT_4(Companion r100, ColorSpace r101, ColorSpace r102, int r103) {
            return r100.m5278computeTransformYBCOT_4(r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0017\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0010¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector$RgbConnector;", "Landroidx/compose/ui/graphics/colorspace/Connector;", "mSource", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "mDestination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "<init>", "(Landroidx/compose/ui/graphics/colorspace/Rgb;Landroidx/compose/ui/graphics/colorspace/Rgb;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "mTransform", "", "transform", BaseSwitches.V, "transformToColor", "Landroidx/compose/ui/graphics/Color;", "color", "transformToColor-l2rxGTc$ui_graphics_release", "(J)J", "computeTransform", "source", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "computeTransform-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/Rgb;Landroidx/compose/ui/graphics/colorspace/Rgb;I)[F", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RgbConnector extends Connector {
        private final Rgb mDestination;
        private final Rgb mSource;
        private final float[] mTransform;

        public /* synthetic */ RgbConnector(Rgb r100, Rgb r101, int r102, DefaultConstructorMarker r103) {
            this(r100, r101, r102);
        }

        @Override // androidx.compose.ui.graphics.colorspace.Connector
        public float[] transform(float[] r100) {
            r100[0] = (float) this.mSource.getEotfFunc$ui_graphics_release().invoke(r100[0]);
            r100[1] = (float) this.mSource.getEotfFunc$ui_graphics_release().invoke(r100[1]);
            r100[2] = (float) this.mSource.getEotfFunc$ui_graphics_release().invoke(r100[2]);
            ColorSpaceKt.mul3x3Float3(this.mTransform, r100);
            r100[0] = (float) this.mDestination.getOetfFunc$ui_graphics_release().invoke(r100[0]);
            r100[1] = (float) this.mDestination.getOetfFunc$ui_graphics_release().invoke(r100[1]);
            r100[2] = (float) this.mDestination.getOetfFunc$ui_graphics_release().invoke(r100[2]);
            return r100;
        }

        @Override // androidx.compose.ui.graphics.colorspace.Connector
        /* JADX INFO: renamed from: transformToColor-l2rxGTc$ui_graphics_release */
        public long mo5276transformToColorl2rxGTc$ui_graphics_release(long r100) {
            float r101 = Color.m4833getRedimpl(r100);
            float r102 = Color.m4832getGreenimpl(r100);
            float r103 = Color.m4830getBlueimpl(r100);
            float r104 = Color.m4829getAlphaimpl(r100);
            float r105 = (float) this.mSource.getEotfFunc$ui_graphics_release().invoke(r101);
            float r106 = (float) this.mSource.getEotfFunc$ui_graphics_release().invoke(r102);
            float r107 = (float) this.mSource.getEotfFunc$ui_graphics_release().invoke(r103);
            float[] r108 = this.mTransform;
            return ColorKt.Color((float) this.mDestination.getOetfFunc$ui_graphics_release().invoke(((r108[0] * r105) + (r108[3] * r106)) + (r108[6] * r107)), (float) this.mDestination.getOetfFunc$ui_graphics_release().invoke(((r108[1] * r105) + (r108[4] * r106)) + (r108[7] * r107)), (float) this.mDestination.getOetfFunc$ui_graphics_release().invoke(((r108[2] * r105) + (r108[5] * r106)) + (r108[8] * r107)), r104, this.mDestination);
        }

        private RgbConnector(Rgb r100, Rgb r110, int r111) {
            super(r100, r110, r100, r110, r111, null, null);
            this.mSource = r100;
            this.mDestination = r110;
            this.mTransform = m5279computeTransformYBCOT_4(r100, r110, r111);
        }

        /* JADX INFO: renamed from: computeTransform-YBCOT_4, reason: not valid java name */
        private final float[] m5279computeTransformYBCOT_4(Rgb r100, Rgb r101, int r110) {
            if (ColorSpaceKt.compare(r100.getWhitePoint(), r101.getWhitePoint()) == true) goto L5;
            float[] r102 = r100.getTransform$ui_graphics_release();
            float[] r103 = r101.getInverseTransform$ui_graphics_release();
            float[] r104 = r100.getWhitePoint().toXyz$ui_graphics_release();
            float[] r105 = r101.getWhitePoint().toXyz$ui_graphics_release();
            WhitePoint r106 = r100.getWhitePoint();
            Illuminant r107 = Illuminant.INSTANCE;
            if (ColorSpaceKt.compare(r106, r107.getD50()) == true) goto L10;
            r102 = ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(Adaptation.Companion.getBradford().getTransform$ui_graphics_release(), r104, r107.newD50Xyz$ui_graphics_release()), r100.getTransform$ui_graphics_release());
        L10:
            if (ColorSpaceKt.compare(r101.getWhitePoint(), r107.getD50()) == true) goto L13;
            r103 = ColorSpaceKt.inverse3x3(ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(Adaptation.Companion.getBradford().getTransform$ui_graphics_release(), r105, r107.newD50Xyz$ui_graphics_release()), r101.getTransform$ui_graphics_release()));
        L13:
            if (RenderIntent.m5284equalsimpl0(r110, RenderIntent.Companion.m5288getAbsoluteuksYyKA()) == false) goto L16;
            r102 = ColorSpaceKt.mul3x3Diag(new float[]{r104[0] / r105[0], r104[1] / r105[1], r104[2] / r105[2]}, r102);
        L16:
            return ColorSpaceKt.mul3x3(r103, r102);
        L5:
            return ColorSpaceKt.mul3x3(r101.getInverseTransform$ui_graphics_release(), r100.getTransform$ui_graphics_release());
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ Connector(ColorSpace r100, ColorSpace r101, int r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public /* synthetic */ Connector(ColorSpace r100, ColorSpace r101, ColorSpace r102, ColorSpace r103, int r104, float[] r105, DefaultConstructorMarker r106) {
        this(r100, r101, r102, r103, r104, r105);
    }

    public final ColorSpace getDestination() {
        return this.destination;
    }

    /* JADX INFO: renamed from: getRenderIntent-uksYyKA, reason: not valid java name */
    public final int m5275getRenderIntentuksYyKA() {
        return this.renderIntent;
    }

    public final ColorSpace getSource() {
        return this.source;
    }

    public float[] transform(float[] r100) {
        float[] r101 = this.transformSource.toXyz(r100);
        float[] r102 = this.transform;
        if (r102 == null) goto L6;
        r101[0] = r101[0] * r102[0];
        r101[1] = r101[1] * r102[1];
        r101[2] = r101[2] * r102[2];
    L6:
        return this.transformDestination.fromXyz(r101);
    }

    /* JADX INFO: renamed from: transformToColor-l2rxGTc$ui_graphics_release, reason: not valid java name */
    public long mo5276transformToColorl2rxGTc$ui_graphics_release(long r110) {
        float r100 = Color.m4833getRedimpl(r110);
        float r101 = Color.m4832getGreenimpl(r110);
        float r102 = Color.m4830getBlueimpl(r110);
        float r103 = Color.m4829getAlphaimpl(r110);
        long r111 = this.transformSource.toXy$ui_graphics_release(r100, r101, r102);
        float r104 = Float.intBitsToFloat((int) (r111 >> 32));
        float r112 = Float.intBitsToFloat((int) (r111 & BodyPartID.bodyIdMax));
        float r113 = this.transformSource.toZ$ui_graphics_release(r100, r101, r102);
        float[] r105 = this.transform;
        if (r105 == null) goto L5;
        r104 = r104 * r105[0];
        r112 = r112 * r105[1];
        r113 = r113 * r105[2];
    L5:
        float r106 = r104;
        ColorSpace r107 = this.transformDestination;
        return r107.mo5271xyzaToColorJlNiLsg$ui_graphics_release(r106, r112, r113, r103, this.destination);
    }

    private Connector(ColorSpace r110, ColorSpace r111, int r112) {
        long r100 = r110.m5270getModelxdoWZVw();
        ColorModel.Companion r101 = ColorModel.Companion;
        if (ColorModel.m5261equalsimpl0(r100, r101.m5268getRgbxdoWZVw()) == false) goto L5;
        ColorSpace r102 = ColorSpaceKt.adapt$default(r110, Illuminant.INSTANCE.getD50(), null, 2, null);
    L7:
        if (ColorModel.m5261equalsimpl0(r111.m5270getModelxdoWZVw(), r101.m5268getRgbxdoWZVw()) == false) goto L9;
        ColorSpace r103 = ColorSpaceKt.adapt$default(r111, Illuminant.INSTANCE.getD50(), null, 2, null);
    L10:
        this(r110, r111, r102, r103, r112, Companion.m5277access$computeTransformYBCOT_4(Companion, r110, r111, r112), null);
        return;
    L9:
        r103 = r111;
        goto L10
    L5:
        r102 = r110;
        goto L7
    }

    public final float[] transform(float r100, float r101, float r102) {
        return transform(new float[]{r100, r101, r102});
    }

    private Connector(ColorSpace r100, ColorSpace r101, ColorSpace r102, ColorSpace r103, int r104, float[] r105) {
        this.source = r100;
        this.destination = r101;
        this.transformSource = r102;
        this.transformDestination = r103;
        this.renderIntent = r104;
        this.transform = r105;
    }
}
