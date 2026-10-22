package androidx.compose.ui.graphics.colorspace;

import D7.q;
import S7.k;
import X6.h;
import androidx.annotation.Size;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.text.selection.SingleSelectionLayout;
import androidx.compose.ui.graphics.ColorKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b!\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b#\u0018\u0000 m2\u00020\u0001:\u0001mB]\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014BE\b\u0016\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0004\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u0013\u0010\u0018B]\b\u0016\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0019B%\b\u0016\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u001bB-\b\u0016\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u001cB1\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u001dB%\b\u0016\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0017¢\u0006\u0004\b\u0013\u0010\u001fB-\b\u0016\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u001e\u001a\u00020\u0017¢\u0006\u0004\b\u0013\u0010 BA\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u001e\u001a\u00020\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010!B!\b\u0010\u0012\u0006\u0010\"\u001a\u00020\u0000\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010#J\u000f\u0010$\u001a\u00020\u0004H\u0007¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0004H\u0007¢\u0006\u0004\b&\u0010%J\u000f\u0010'\u001a\u00020\u0004H\u0007¢\u0006\u0004\b'\u0010%J\u0019\u0010$\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b$\u0010(J\u0019\u0010&\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b&\u0010(J\u0019\u0010'\u001a\u00020\u00042\b\b\u0001\u0010)\u001a\u00020\u0004H\u0007¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u0011H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u0011H\u0016¢\u0006\u0004\b-\u0010,J'\u00101\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\fH\u0007¢\u0006\u0004\b1\u00102J\u0019\u00101\u001a\u00020\u00042\b\b\u0001\u00103\u001a\u00020\u0004H\u0007¢\u0006\u0004\b1\u0010(J'\u00104\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\fH\u0007¢\u0006\u0004\b4\u00102J\u0019\u00104\u001a\u00020\u00042\b\b\u0001\u00103\u001a\u00020\u0004H\u0007¢\u0006\u0004\b4\u0010(J\u0017\u00105\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0004H\u0016¢\u0006\u0004\b5\u0010(J'\u0010<\u001a\u0002092\u0006\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH\u0010¢\u0006\u0004\b:\u0010;J'\u0010?\u001a\u00020\f2\u0006\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH\u0010¢\u0006\u0004\b=\u0010>J7\u0010G\u001a\u00020D2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\f2\u0006\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0001H\u0010¢\u0006\u0004\bE\u0010FJ\u0017\u0010H\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0004H\u0016¢\u0006\u0004\bH\u0010(J\u001a\u0010L\u001a\u00020K2\b\u0010J\u001a\u0004\u0018\u00010IH\u0096\u0002¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\u0011H\u0016¢\u0006\u0004\bN\u0010OR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010P\u001a\u0004\bQ\u0010RR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010SR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010SR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010T\u001a\u0004\bU\u0010VR\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010W\u001a\u0004\bX\u0010%R\u001a\u0010\b\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010W\u001a\u0004\bY\u0010%R\u001a\u0010)\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b)\u0010W\u001a\u0004\bZ\u0010%R\u001a\u0010[\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u00168\u0006¢\u0006\f\n\u0004\b\n\u0010_\u001a\u0004\b`\u0010aR\u001a\u0010b\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bb\u0010\\\u001a\u0004\bc\u0010^R\u001a\u0010d\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bd\u0010\\\u001a\u0004\be\u0010^R#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u00168\u0006¢\u0006\f\n\u0004\b\u000b\u0010_\u001a\u0004\bf\u0010aR\u001a\u0010g\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bg\u0010\\\u001a\u0004\bh\u0010^R\u001a\u0010i\u001a\u00020K8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bi\u0010kR\u001a\u0010l\u001a\u00020K8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bl\u0010j\u001a\u0004\bl\u0010k¨\u0006n"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Rgb;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "", HintConstants.AUTOFILL_HINT_NAME, "", "primaries", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "whitePoint", "transform", "Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "oetf", "eotf", "", "min", "max", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "transferParameters", "", "id", AppAgent.CONSTRUCT, "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;[FLandroidx/compose/ui/graphics/colorspace/DoubleFunction;Landroidx/compose/ui/graphics/colorspace/DoubleFunction;FFLandroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "toXYZ", "Lkotlin/Function1;", "", "(Ljava/lang/String;[FLS7/k;LS7/k;)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;LS7/k;LS7/k;FF)V", "function", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "gamma", "(Ljava/lang/String;[FD)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;D)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;DFFI)V", "colorSpace", "(Landroidx/compose/ui/graphics/colorspace/Rgb;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;)V", "getPrimaries", "()[F", "getTransform", "getInverseTransform", "([F)[F", "inverseTransform", "component", "getMinValue", "(I)F", "getMaxValue", "r", "g", "b", "toLinear", "(FFF)[F", "v", "fromLinear", "toXyz", "v0", "v1", "v2", "", "toXy$ui_graphics_release", "(FFF)J", "toXy", "toZ$ui_graphics_release", "(FFF)F", "toZ", "x", "y", "z", "a", "Landroidx/compose/ui/graphics/Color;", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "xyzaToColor", "fromXyz", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "getWhitePoint", "()Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "F", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "getTransferParameters", "()Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "[F", "getPrimaries$ui_graphics_release", "getTransform$ui_graphics_release", "getInverseTransform$ui_graphics_release", "oetfOrig", "Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "getOetfOrig$ui_graphics_release", "()Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "LS7/k;", "getOetf", "()LS7/k;", "oetfFunc", "getOetfFunc$ui_graphics_release", "eotfOrig", "getEotfOrig$ui_graphics_release", "getEotf", "eotfFunc", "getEotfFunc$ui_graphics_release", "isWideGamut", "Z", "()Z", "isSrgb", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Rgb extends ColorSpace {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DoubleFunction DoubleIdentity = new h(17);
    private final k eotf;
    private final DoubleFunction eotfFunc;
    private final DoubleFunction eotfOrig;
    private final float[] inverseTransform;
    private final boolean isSrgb;
    private final boolean isWideGamut;
    private final float max;
    private final float min;
    private final k oetf;
    private final DoubleFunction oetfFunc;
    private final DoubleFunction oetfOrig;
    private final float[] primaries;
    private final TransferParameters transferParameters;
    private final float[] transform;
    private final WhitePoint whitePoint;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J \u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J)\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000fH\u0082\bJ\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0002J\u0015\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0000¢\u0006\u0002\b$J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\tH\u0002J\u0010\u0010&\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010'\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Rgb$Companion;", "", AppAgent.CONSTRUCT, "()V", "DoubleIdentity", "Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "isSrgb", "", "primaries", "", "whitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "OETF", "EOTF", "min", "", "max", "id", "", "compare", "point", "", "a", "b", "isWideGamut", "area", "cross", "ax", "ay", "bx", "by", "contains", "p1", "p2", "computePrimaries", "toXYZ", "computePrimaries$ui_graphics_release", "computeWhitePoint", "xyPrimaries", "computeXYZMatrix", "generateOetf", "function", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "generateEotf", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private final float area(float[] primaries) {
            if (primaries.length < 6) {
                return 0.0f;
            }
            float f = primaries[0];
            float f7 = primaries[1];
            float f9 = primaries[2];
            float f10 = primaries[3];
            float f11 = primaries[4];
            float f12 = primaries[5];
            float fA = androidx.compose.foundation.b.a(f, f12, (((f9 * f12) + ((f7 * f11) + (f * f10))) - (f10 * f11)) - (f7 * f9), 0.5f);
            return fA < 0.0f ? -fA : fA;
        }

        private final boolean compare(double point, DoubleFunction a3, DoubleFunction b) {
            return Math.abs(a3.invoke(point) - b.invoke(point)) <= 0.001d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final WhitePoint computeWhitePoint(float[] toXYZ) {
            float[] fArrMul3x3Float3 = ColorSpaceKt.mul3x3Float3(toXYZ, new float[]{1.0f, 1.0f, 1.0f});
            float f = fArrMul3x3Float3[0];
            float f7 = fArrMul3x3Float3[1];
            float f9 = f + f7 + fArrMul3x3Float3[2];
            return new WhitePoint(f / f9, f7 / f9);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] computeXYZMatrix(float[] primaries, WhitePoint whitePoint) {
            float f = primaries[0];
            float f7 = primaries[1];
            float f9 = primaries[2];
            float f10 = primaries[3];
            float f11 = primaries[4];
            float f12 = primaries[5];
            float x10 = whitePoint.getX();
            float y = whitePoint.getY();
            float f13 = 1;
            float f14 = (f13 - f) / f7;
            float f15 = (f13 - f9) / f10;
            float f16 = (f13 - f11) / f12;
            float f17 = (f13 - x10) / y;
            float f18 = f / f7;
            float f19 = (f9 / f10) - f18;
            float f20 = (x10 / y) - f18;
            float f21 = f15 - f14;
            float f22 = (f11 / f12) - f18;
            float f23 = (((f17 - f14) * f19) - (f20 * f21)) / (((f16 - f14) * f19) - (f21 * f22));
            float f24 = (f20 - (f22 * f23)) / f19;
            float f25 = (1.0f - f24) - f23;
            float f26 = f25 / f7;
            float f27 = f24 / f10;
            float f28 = f23 / f12;
            return new float[]{f26 * f, f25, ((1.0f - f) - f7) * f26, f27 * f9, f24, ((1.0f - f9) - f10) * f27, f28 * f11, f23, ((1.0f - f11) - f12) * f28};
        }

        private final boolean contains(float[] p1, float[] p22) {
            float f = p1[0];
            float f7 = p22[0];
            float f9 = p1[1];
            float f10 = p22[1];
            float f11 = p1[2];
            float f12 = p22[2];
            float f13 = p1[3];
            float f14 = p22[3];
            float f15 = p1[4];
            float f16 = p22[4];
            float f17 = p1[5];
            float f18 = p22[5];
            float[] fArr = {f - f7, f9 - f10, f11 - f12, f13 - f14, f15 - f16, f17 - f18};
            float f19 = fArr[0];
            float f20 = fArr[1];
            if (((f10 - f18) * f19) - ((f7 - f16) * f20) >= 0.0f && ((f7 - f12) * f20) - ((f10 - f14) * f19) >= 0.0f) {
                float f21 = fArr[2];
                float f22 = fArr[3];
                if (((f14 - f10) * f21) - ((f12 - f7) * f22) >= 0.0f && ((f12 - f16) * f22) - ((f14 - f18) * f21) >= 0.0f) {
                    float f23 = fArr[4];
                    float f24 = fArr[5];
                    if (((f18 - f14) * f23) - ((f16 - f12) * f24) >= 0.0f && ((f16 - f7) * f24) - ((f18 - f10) * f23) >= 0.0f) {
                        return true;
                    }
                }
            }
            return false;
        }

        private final float cross(float ax, float ay, float bx, float by) {
            return (ax * by) - (ay * bx);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DoubleFunction generateEotf(TransferParameters function) {
            return function.isHLGish$ui_graphics_release() ? new c(function, 0) : function.isPQish$ui_graphics_release() ? new c(function, 1) : (function.getE() == 0.0d && function.getF() == 0.0d) ? new c(function, 2) : new c(function, 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double generateEotf$lambda$4(TransferParameters transferParameters, double d) {
            return ColorSpaces.INSTANCE.transferHlgEotf$ui_graphics_release(transferParameters, d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double generateEotf$lambda$5(TransferParameters transferParameters, double d) {
            return ColorSpaces.INSTANCE.transferSt2048Eotf$ui_graphics_release(transferParameters, d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double generateEotf$lambda$6(TransferParameters transferParameters, double d) {
            return ColorSpaceKt.response(d, transferParameters.getA(), transferParameters.getB(), transferParameters.getC(), transferParameters.getD(), transferParameters.getGamma());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double generateEotf$lambda$7(TransferParameters transferParameters, double d) {
            return ColorSpaceKt.response(d, transferParameters.getA(), transferParameters.getB(), transferParameters.getC(), transferParameters.getD(), transferParameters.getE(), transferParameters.getF(), transferParameters.getGamma());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DoubleFunction generateOetf(TransferParameters function) {
            return function.isHLGish$ui_graphics_release() ? new c(function, 4) : function.isPQish$ui_graphics_release() ? new c(function, 5) : (function.getE() == 0.0d && function.getF() == 0.0d) ? new c(function, 6) : new c(function, 7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double generateOetf$lambda$0(TransferParameters transferParameters, double d) {
            return ColorSpaces.INSTANCE.transferHlgOetf$ui_graphics_release(transferParameters, d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double generateOetf$lambda$1(TransferParameters transferParameters, double d) {
            return ColorSpaces.INSTANCE.transferSt2048Oetf$ui_graphics_release(transferParameters, d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double generateOetf$lambda$2(TransferParameters transferParameters, double d) {
            return ColorSpaceKt.rcpResponse(d, transferParameters.getA(), transferParameters.getB(), transferParameters.getC(), transferParameters.getD(), transferParameters.getGamma());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final double generateOetf$lambda$3(TransferParameters transferParameters, double d) {
            return ColorSpaceKt.rcpResponse(d, transferParameters.getA(), transferParameters.getB(), transferParameters.getC(), transferParameters.getD(), transferParameters.getE(), transferParameters.getF(), transferParameters.getGamma());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSrgb(float[] primaries, WhitePoint whitePoint, DoubleFunction OETF, DoubleFunction EOTF, float min, float max, int id) {
            if (id == 0) {
                return true;
            }
            ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
            if (!ColorSpaceKt.compare(primaries, colorSpaces.getSrgbPrimaries$ui_graphics_release()) || !ColorSpaceKt.compare(whitePoint, Illuminant.INSTANCE.getD65()) || min != 0.0f || max != 1.0f) {
                return false;
            }
            Rgb srgb = colorSpaces.getSrgb();
            for (double d = 0.0d; d <= 1.0d; d += 0.00392156862745098d) {
                if (!compare(d, OETF, srgb.getOetfOrig()) || !compare(d, EOTF, srgb.getEotfOrig())) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isWideGamut(float[] primaries, float min, float max) {
            float fArea = area(primaries);
            ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
            if (fArea / area(colorSpaces.getNtsc1953Primaries$ui_graphics_release()) <= 0.9f || !contains(primaries, colorSpaces.getSrgbPrimaries$ui_graphics_release())) {
                return min < 0.0f && max > 1.0f;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] xyPrimaries(float[] primaries) {
            float[] fArr = new float[6];
            if (primaries.length != 9) {
                q.Z(primaries, 0, fArr, 6);
                return fArr;
            }
            float f = primaries[0];
            float f7 = primaries[1];
            float f9 = f + f7 + primaries[2];
            fArr[0] = f / f9;
            fArr[1] = f7 / f9;
            float f10 = primaries[3];
            float f11 = primaries[4];
            float f12 = f10 + f11 + primaries[5];
            fArr[2] = f10 / f12;
            fArr[3] = f11 / f12;
            float f13 = primaries[6];
            float f14 = primaries[7];
            float f15 = f13 + f14 + primaries[8];
            fArr[4] = f13 / f15;
            fArr[5] = f14 / f15;
            return fArr;
        }

        public final float[] computePrimaries$ui_graphics_release(float[] toXYZ) {
            float[] fArrMul3x3Float3 = ColorSpaceKt.mul3x3Float3(toXYZ, new float[]{1.0f, 0.0f, 0.0f});
            float[] fArrMul3x3Float32 = ColorSpaceKt.mul3x3Float3(toXYZ, new float[]{0.0f, 1.0f, 0.0f});
            float[] fArrMul3x3Float33 = ColorSpaceKt.mul3x3Float3(toXYZ, new float[]{0.0f, 0.0f, 1.0f});
            float f = fArrMul3x3Float3[0];
            float f7 = fArrMul3x3Float3[1];
            float f9 = f + f7 + fArrMul3x3Float3[2];
            float f10 = fArrMul3x3Float32[0];
            float f11 = fArrMul3x3Float32[1];
            float f12 = f10 + f11 + fArrMul3x3Float32[2];
            float f13 = fArrMul3x3Float33[0];
            float f14 = fArrMul3x3Float33[1];
            float f15 = f13 + f14 + fArrMul3x3Float33[2];
            return new float[]{f / f9, f7 / f9, f10 / f12, f11 / f12, f13 / f15, f14 / f15};
        }

        private Companion() {
        }
    }

    public Rgb(String str, float[] fArr, WhitePoint whitePoint, float[] fArr2, DoubleFunction doubleFunction, DoubleFunction doubleFunction2, float f, float f7, TransferParameters transferParameters, int i) {
        super(str, ColorModel.INSTANCE.m4570getRgbxdoWZVw(), i, null);
        this.whitePoint = whitePoint;
        this.min = f;
        this.max = f7;
        this.transferParameters = transferParameters;
        this.oetfOrig = doubleFunction;
        this.oetf = new k() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$oetf$1
            {
                super(1);
            }

            public final Double invoke(double d) {
                return Double.valueOf(AbstractC1451a.s(this.this$0.getOetfOrig().invoke(d), this.this$0.min, this.this$0.max));
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).doubleValue());
            }
        };
        final int i6 = 0;
        this.oetfFunc = new DoubleFunction(this) { // from class: androidx.compose.ui.graphics.colorspace.a
            public final /* synthetic */ Rgb b;

            {
                this.b = this;
            }

            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double invoke(double d) {
                int i10 = i6;
                Rgb rgb = this.b;
                switch (i10) {
                    case 0:
                        return Rgb.oetfFunc$lambda$0(rgb, d);
                    default:
                        return Rgb.eotfFunc$lambda$1(rgb, d);
                }
            }
        };
        this.eotfOrig = doubleFunction2;
        this.eotf = new k() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$eotf$1
            {
                super(1);
            }

            public final Double invoke(double d) {
                return Double.valueOf(this.this$0.getEotfOrig().invoke(AbstractC1451a.s(d, this.this$0.min, this.this$0.max)));
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).doubleValue());
            }
        };
        final int i10 = 1;
        this.eotfFunc = new DoubleFunction(this) { // from class: androidx.compose.ui.graphics.colorspace.a
            public final /* synthetic */ Rgb b;

            {
                this.b = this;
            }

            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double invoke(double d) {
                int i102 = i10;
                Rgb rgb = this.b;
                switch (i102) {
                    case 0:
                        return Rgb.oetfFunc$lambda$0(rgb, d);
                    default:
                        return Rgb.eotfFunc$lambda$1(rgb, d);
                }
            }
        };
        if (fArr.length != 6 && fArr.length != 9) {
            throw new IllegalArgumentException("The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
        }
        if (f >= f7) {
            throw new IllegalArgumentException("Invalid range: min=" + f + ", max=" + f7 + "; min must be strictly < max");
        }
        Companion companion = INSTANCE;
        float[] fArrXyPrimaries = companion.xyPrimaries(fArr);
        this.primaries = fArrXyPrimaries;
        if (fArr2 == null) {
            this.transform = companion.computeXYZMatrix(fArrXyPrimaries, whitePoint);
        } else {
            if (fArr2.length != 9) {
                throw new IllegalArgumentException("Transform must have 9 entries! Has " + fArr2.length);
            }
            this.transform = fArr2;
        }
        this.inverseTransform = ColorSpaceKt.inverse3x3(this.transform);
        this.isWideGamut = companion.isWideGamut(fArrXyPrimaries, f, f7);
        this.isSrgb = companion.isSrgb(fArrXyPrimaries, whitePoint, doubleFunction, doubleFunction2, f, f7, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double DoubleIdentity$lambda$8(double d) {
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$2(k kVar, double d) {
        return ((Number) kVar.invoke(Double.valueOf(d))).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$3(k kVar, double d) {
        return ((Number) kVar.invoke(Double.valueOf(d))).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$4(k kVar, double d) {
        return ((Number) kVar.invoke(Double.valueOf(d))).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$5(k kVar, double d) {
        return ((Number) kVar.invoke(Double.valueOf(d))).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$6(double d, double d6) {
        if (d6 < 0.0d) {
            d6 = 0.0d;
        }
        return Math.pow(d6, 1.0d / d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$7(double d, double d6) {
        if (d6 < 0.0d) {
            d6 = 0.0d;
        }
        return Math.pow(d6, d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double eotfFunc$lambda$1(Rgb rgb, double d) {
        return rgb.eotfOrig.invoke(AbstractC1451a.s(d, rgb.min, rgb.max));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double oetfFunc$lambda$0(Rgb rgb, double d) {
        return AbstractC1451a.s(rgb.oetfOrig.invoke(d), rgb.min, rgb.max);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || Rgb.class != other.getClass() || !super.equals(other)) {
            return false;
        }
        Rgb rgb = (Rgb) other;
        if (Float.compare(rgb.min, this.min) != 0 || Float.compare(rgb.max, this.max) != 0 || !kotlin.jvm.internal.k.b(this.whitePoint, rgb.whitePoint) || !Arrays.equals(this.primaries, rgb.primaries)) {
            return false;
        }
        TransferParameters transferParameters = this.transferParameters;
        if (transferParameters != null) {
            return kotlin.jvm.internal.k.b(transferParameters, rgb.transferParameters);
        }
        if (rgb.transferParameters == null) {
            return true;
        }
        if (kotlin.jvm.internal.k.b(this.oetfOrig, rgb.oetfOrig)) {
            return kotlin.jvm.internal.k.b(this.eotfOrig, rgb.eotfOrig);
        }
        return false;
    }

    @Size(3)
    public final float[] fromLinear(float r5, float g, float b) {
        return fromLinear(new float[]{r5, g, b});
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] v10) {
        ColorSpaceKt.mul3x3Float3(this.inverseTransform, v10);
        if (v10.length < 3) {
            return v10;
        }
        v10[0] = (float) this.oetfFunc.invoke(v10[0]);
        v10[1] = (float) this.oetfFunc.invoke(v10[1]);
        v10[2] = (float) this.oetfFunc.invoke(v10[2]);
        return v10;
    }

    public final k getEotf() {
        return this.eotf;
    }

    /* renamed from: getEotfFunc$ui_graphics_release, reason: from getter */
    public final DoubleFunction getEotfFunc() {
        return this.eotfFunc;
    }

    /* renamed from: getEotfOrig$ui_graphics_release, reason: from getter */
    public final DoubleFunction getEotfOrig() {
        return this.eotfOrig;
    }

    @Size(9)
    public final float[] getInverseTransform() {
        float[] fArr = this.inverseTransform;
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.k.e(fArrCopyOf, "copyOf(...)");
        return fArrCopyOf;
    }

    /* renamed from: getInverseTransform$ui_graphics_release, reason: from getter */
    public final float[] getInverseTransform() {
        return this.inverseTransform;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return this.max;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return this.min;
    }

    public final k getOetf() {
        return this.oetf;
    }

    /* renamed from: getOetfFunc$ui_graphics_release, reason: from getter */
    public final DoubleFunction getOetfFunc() {
        return this.oetfFunc;
    }

    /* renamed from: getOetfOrig$ui_graphics_release, reason: from getter */
    public final DoubleFunction getOetfOrig() {
        return this.oetfOrig;
    }

    @Size(6)
    public final float[] getPrimaries() {
        float[] fArr = this.primaries;
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.k.e(fArrCopyOf, "copyOf(...)");
        return fArrCopyOf;
    }

    /* renamed from: getPrimaries$ui_graphics_release, reason: from getter */
    public final float[] getPrimaries() {
        return this.primaries;
    }

    public final TransferParameters getTransferParameters() {
        return this.transferParameters;
    }

    @Size(9)
    public final float[] getTransform() {
        float[] fArr = this.transform;
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.k.e(fArrCopyOf, "copyOf(...)");
        return fArrCopyOf;
    }

    /* renamed from: getTransform$ui_graphics_release, reason: from getter */
    public final float[] getTransform() {
        return this.transform;
    }

    public final WhitePoint getWhitePoint() {
        return this.whitePoint;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public int hashCode() {
        int iHashCode = (Arrays.hashCode(this.primaries) + ((this.whitePoint.hashCode() + (super.hashCode() * 31)) * 31)) * 31;
        float f = this.min;
        int iFloatToIntBits = (iHashCode + (f == 0.0f ? 0 : Float.floatToIntBits(f))) * 31;
        float f7 = this.max;
        int iFloatToIntBits2 = (iFloatToIntBits + (f7 == 0.0f ? 0 : Float.floatToIntBits(f7))) * 31;
        TransferParameters transferParameters = this.transferParameters;
        int iHashCode2 = iFloatToIntBits2 + (transferParameters != null ? transferParameters.hashCode() : 0);
        if (this.transferParameters != null) {
            return iHashCode2;
        }
        return this.eotfOrig.hashCode() + ((this.oetfOrig.hashCode() + (iHashCode2 * 31)) * 31);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: isSrgb, reason: from getter */
    public boolean getIsSrgb() {
        return this.isSrgb;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: isWideGamut, reason: from getter */
    public boolean getIsWideGamut() {
        return this.isWideGamut;
    }

    @Size(3)
    public final float[] toLinear(float r5, float g, float b) {
        return toLinear(new float[]{r5, g, b});
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float v02, float v12, float v22) {
        float fInvoke = (float) this.eotfFunc.invoke(v02);
        float fInvoke2 = (float) this.eotfFunc.invoke(v12);
        float fInvoke3 = (float) this.eotfFunc.invoke(v22);
        float[] fArr = this.transform;
        if (fArr.length < 9) {
            return 0L;
        }
        float f = (fArr[6] * fInvoke3) + (fArr[3] * fInvoke2) + (fArr[0] * fInvoke);
        float f7 = (fArr[7] * fInvoke3) + (fArr[4] * fInvoke2) + (fArr[1] * fInvoke);
        return (Float.floatToRawIntBits(f) << 32) | (4294967295L & Float.floatToRawIntBits(f7));
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] v10) {
        if (v10.length < 3) {
            return v10;
        }
        v10[0] = (float) this.eotfFunc.invoke(v10[0]);
        v10[1] = (float) this.eotfFunc.invoke(v10[1]);
        v10[2] = (float) this.eotfFunc.invoke(v10[2]);
        return ColorSpaceKt.mul3x3Float3(this.transform, v10);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float v02, float v12, float v22) {
        float fInvoke = (float) this.eotfFunc.invoke(v02);
        float fInvoke2 = (float) this.eotfFunc.invoke(v12);
        float fInvoke3 = (float) this.eotfFunc.invoke(v22);
        float[] fArr = this.transform;
        return (fArr[8] * fInvoke3) + (fArr[5] * fInvoke2) + (fArr[2] * fInvoke);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo4573xyzaToColorJlNiLsg$ui_graphics_release(float x10, float y, float z10, float a3, ColorSpace colorSpace) {
        float[] fArr = this.inverseTransform;
        return ColorKt.Color((float) this.oetfFunc.invoke((fArr[6] * z10) + (fArr[3] * y) + (fArr[0] * x10)), (float) this.oetfFunc.invoke((fArr[7] * z10) + (fArr[4] * y) + (fArr[1] * x10)), (float) this.oetfFunc.invoke((fArr[8] * z10) + (fArr[5] * y) + (fArr[2] * x10)), a3, colorSpace);
    }

    @Size(min = 3)
    public final float[] fromLinear(@Size(min = 3) float[] v10) {
        if (v10.length < 3) {
            return v10;
        }
        v10[0] = (float) this.oetfFunc.invoke(v10[0]);
        v10[1] = (float) this.oetfFunc.invoke(v10[1]);
        v10[2] = (float) this.oetfFunc.invoke(v10[2]);
        return v10;
    }

    @Size(min = 9)
    public final float[] getInverseTransform(@Size(min = 9) float[] inverseTransform) {
        q.Z(this.inverseTransform, 0, inverseTransform, 14);
        return inverseTransform;
    }

    @Size(min = 6)
    public final float[] getPrimaries(@Size(min = 6) float[] primaries) {
        q.Z(this.primaries, 0, primaries, 14);
        return primaries;
    }

    @Size(min = 9)
    public final float[] getTransform(@Size(min = 9) float[] transform) {
        q.Z(this.transform, 0, transform, 14);
        return transform;
    }

    @Size(min = 3)
    public final float[] toLinear(@Size(min = 3) float[] v10) {
        if (v10.length < 3) {
            return v10;
        }
        v10[0] = (float) this.eotfFunc.invoke(v10[0]);
        v10[1] = (float) this.eotfFunc.invoke(v10[1]);
        v10[2] = (float) this.eotfFunc.invoke(v10[2]);
        return v10;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Rgb(@Size(min = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) String str, @Size(9) float[] fArr, k kVar, k kVar2) {
        Companion companion = INSTANCE;
        this(str, companion.computePrimaries$ui_graphics_release(fArr), companion.computeWhitePoint(fArr), null, new android.view.result.a(kVar, 2), new android.view.result.a(kVar2, 3), 0.0f, 1.0f, null, -1);
    }

    public Rgb(@Size(min = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) String str, @Size(max = 9, min = 6) float[] fArr, WhitePoint whitePoint, k kVar, k kVar2, float f, float f7) {
        this(str, fArr, whitePoint, null, new android.view.result.a(kVar, 4), new android.view.result.a(kVar2, 5), f, f7, null, -1);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Rgb(@Size(min = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) String str, @Size(9) float[] fArr, TransferParameters transferParameters) {
        Companion companion = INSTANCE;
        this(str, companion.computePrimaries$ui_graphics_release(fArr), companion.computeWhitePoint(fArr), transferParameters, -1);
    }

    public Rgb(@Size(min = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) String str, @Size(max = 9, min = 6) float[] fArr, WhitePoint whitePoint, TransferParameters transferParameters) {
        this(str, fArr, whitePoint, transferParameters, -1);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Rgb(String str, float[] fArr, WhitePoint whitePoint, TransferParameters transferParameters, int i) {
        Companion companion = INSTANCE;
        this(str, fArr, whitePoint, null, companion.generateOetf(transferParameters), companion.generateEotf(transferParameters), 0.0f, 1.0f, transferParameters, i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Rgb(@Size(min = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) String str, @Size(9) float[] fArr, double d) {
        Companion companion = INSTANCE;
        this(str, companion.computePrimaries$ui_graphics_release(fArr), companion.computeWhitePoint(fArr), d, 0.0f, 1.0f, -1);
    }

    public Rgb(@Size(min = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) String str, @Size(max = 9, min = 6) float[] fArr, WhitePoint whitePoint, double d) {
        this(str, fArr, whitePoint, d, 0.0f, 1.0f, -1);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Rgb(String str, float[] fArr, WhitePoint whitePoint, final double d, float f, float f7, int i) {
        DoubleFunction doubleFunction;
        DoubleFunction doubleFunction2;
        if (d == 1.0d) {
            doubleFunction = DoubleIdentity;
        } else {
            final int i6 = 0;
            doubleFunction = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.b
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d6) {
                    switch (i6) {
                        case 0:
                            return Rgb._init_$lambda$6(d, d6);
                        default:
                            return Rgb._init_$lambda$7(d, d6);
                    }
                }
            };
        }
        DoubleFunction doubleFunction3 = doubleFunction;
        if (d == 1.0d) {
            doubleFunction2 = DoubleIdentity;
        } else {
            final int i10 = 1;
            doubleFunction2 = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.b
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d6) {
                    switch (i10) {
                        case 0:
                            return Rgb._init_$lambda$6(d, d6);
                        default:
                            return Rgb._init_$lambda$7(d, d6);
                    }
                }
            };
        }
        this(str, fArr, whitePoint, null, doubleFunction3, doubleFunction2, f, f7, new TransferParameters(d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 96, null), i);
    }

    public Rgb(Rgb rgb, float[] fArr, WhitePoint whitePoint) {
        this(rgb.getName(), rgb.primaries, whitePoint, fArr, rgb.oetfOrig, rgb.eotfOrig, rgb.min, rgb.max, rgb.transferParameters, -1);
    }
}
