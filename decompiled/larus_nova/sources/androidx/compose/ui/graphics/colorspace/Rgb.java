package androidx.compose.ui.graphics.colorspace;

import androidx.camera.video.AudioStats;
import androidx.compose.ui.graphics.ColorKt;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 _2\u00020\u0001:\u0001_B]\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014BE\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u0013\u0010\u0018B]\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0019B%\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u001bB-\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u001cB1\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u001dB%\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u0017¢\u0006\u0004\b\u0013\u0010\u001fB-\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u0017¢\u0006\u0004\b\u0013\u0010 BA\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u0017\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010!B!\b\u0010\u0012\u0006\u0010\"\u001a\u00020\u0000\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010#J\b\u0010=\u001a\u00020\u0005H\u0007J\b\u0010>\u001a\u00020\u0005H\u0007J\b\u0010?\u001a\u00020\u0005H\u0007J\u0012\u0010=\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0007J\u0012\u0010>\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u0005H\u0007J\u0012\u0010?\u001a\u00020\u00052\b\b\u0001\u0010+\u001a\u00020\u0005H\u0007J\u0010\u0010@\u001a\u00020\r2\u0006\u0010A\u001a\u00020\u0012H\u0016J\u0010\u0010B\u001a\u00020\r2\u0006\u0010A\u001a\u00020\u0012H\u0016J \u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\r2\u0006\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020\rH\u0007J\u0012\u0010C\u001a\u00020\u00052\b\b\u0001\u0010G\u001a\u00020\u0005H\u0007J \u0010H\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\r2\u0006\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020\rH\u0007J\u0012\u0010H\u001a\u00020\u00052\b\b\u0001\u0010G\u001a\u00020\u0005H\u0007J\u0010\u0010I\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0005H\u0016J%\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\r2\u0006\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020\rH\u0010¢\u0006\u0002\bOJ%\u0010P\u001a\u00020\r2\u0006\u0010L\u001a\u00020\r2\u0006\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020\rH\u0010¢\u0006\u0002\bQJ7\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010V\u001a\u00020\r2\u0006\u0010W\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0001H\u0010¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0005H\u0016J\u0013\u0010[\u001a\u00020:2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0096\u0002J\b\u0010^\u001a\u00020\u0012H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010\b\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0014\u0010+\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010)R\u0014\u0010-\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u0014\u00104\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010/R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b6\u00101R\u0014\u00107\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010/R\u0014\u00109\u001a\u00020:X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010;R\u0014\u0010<\u001a\u00020:X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010;¨\u0006`"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Rgb;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "primaries", "", "whitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "transform", "oetf", "Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "eotf", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "transferParameters", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "id", "", "<init>", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;[FLandroidx/compose/ui/graphics/colorspace/DoubleFunction;Landroidx/compose/ui/graphics/colorspace/DoubleFunction;FFLandroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "toXYZ", "Lkotlin/Function1;", "", "(Ljava/lang/String;[FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FF)V", "function", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "gamma", "(Ljava/lang/String;[FD)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;D)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;DFFI)V", "colorSpace", "(Landroidx/compose/ui/graphics/colorspace/Rgb;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;)V", "getWhitePoint", "()Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "getTransferParameters", "()Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "getPrimaries$ui_graphics_release", "()[F", "getTransform$ui_graphics_release", "inverseTransform", "getInverseTransform$ui_graphics_release", "oetfOrig", "getOetfOrig$ui_graphics_release", "()Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "getOetf", "()Lkotlin/jvm/functions/Function1;", "oetfFunc", "getOetfFunc$ui_graphics_release", "eotfOrig", "getEotfOrig$ui_graphics_release", "getEotf", "eotfFunc", "getEotfFunc$ui_graphics_release", "isWideGamut", "", "()Z", "isSrgb", "getPrimaries", "getTransform", "getInverseTransform", "getMinValue", "component", "getMaxValue", "toLinear", "r", ce.f26391f, "b", BaseSwitches.V, "fromLinear", "toXyz", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "fromXyz", "equals", "other", "", "hashCode", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Rgb extends ColorSpace {
    public static final Companion Companion = null;
    private static final DoubleFunction DoubleIdentity = null;
    private final Function1<Double, Double> eotf;
    private final DoubleFunction eotfFunc;
    private final DoubleFunction eotfOrig;
    private final float[] inverseTransform;
    private final boolean isSrgb;
    private final boolean isWideGamut;
    private final float max;
    private final float min;
    private final Function1<Double, Double> oetf;
    private final DoubleFunction oetfFunc;
    private final DoubleFunction oetfOrig;
    private final float[] primaries;
    private final TransferParameters transferParameters;
    private final float[] transform;
    private final WhitePoint whitePoint;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J \u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J)\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000fH\u0082\bJ\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0002J\u0015\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0000¢\u0006\u0002\b$J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\tH\u0002J\u0010\u0010&\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010'\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Rgb$Companion;", "", "<init>", "()V", "DoubleIdentity", "Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "isSrgb", "", "primaries", "", "whitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "OETF", "EOTF", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "id", "", "compare", "point", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "isWideGamut", "area", "cross", "ax", "ay", "bx", "by", "contains", "p1", "p2", "computePrimaries", "toXYZ", "computePrimaries$ui_graphics_release", "computeWhitePoint", "xyPrimaries", "computeXYZMatrix", "generateOetf", "function", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "generateEotf", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ double a(TransferParameters r100, double r101) {
            return generateEotf$lambda$7(r100, r101);
        }

        public static /* synthetic */ double b(TransferParameters r100, double r101) {
            return generateEotf$lambda$6(r100, r101);
        }

        public static /* synthetic */ double c(TransferParameters r100, double r101) {
            return generateEotf$lambda$5(r100, r101);
        }

        private final float cross(float r100, float r101, float r102, float r103) {
            return (r100 * r103) - (r101 * r102);
        }

        public static /* synthetic */ double d(TransferParameters r100, double r101) {
            return generateOetf$lambda$2(r100, r101);
        }

        public static /* synthetic */ double e(TransferParameters r100, double r101) {
            return generateOetf$lambda$0(r100, r101);
        }

        public static /* synthetic */ double f(TransferParameters r100, double r101) {
            return generateOetf$lambda$3(r100, r101);
        }

        public static /* synthetic */ double g(TransferParameters r100, double r101) {
            return generateOetf$lambda$1(r100, r101);
        }

        public static /* synthetic */ double h(TransferParameters r100, double r101) {
            return generateEotf$lambda$4(r100, r101);
        }

        private final float area(float[] r100) {
            if (r100.length >= 6) goto L5;
            return 0.0f;
        L5:
            float r101 = r100[0];
            float r102 = r100[1];
            float r103 = r100[2];
            float r104 = r100[3];
            float r105 = r100[4];
            float r106 = r100[5];
            float r107 = ((((((r101 * r104) + (r102 * r105)) + (r103 * r106)) - (r104 * r105)) - (r102 * r103)) - (r101 * r106)) * 0.5f;
            if (r107 < 0.0f) goto L8;
            return r107;
        L8:
            return -r107;
        }

        private final WhitePoint computeWhitePoint(float[] r100) {
            float[] r101 = ColorSpaceKt.mul3x3Float3(r100, new float[]{1.0f, 1.0f, 1.0f});
            float r102 = r101[0];
            float r103 = r101[1];
            float r104 = (r102 + r103) + r101[2];
            return new WhitePoint(r102 / r104, r103 / r104);
        }

        private final DoubleFunction generateEotf(final TransferParameters r100) {
            if (r100.isHLGish$ui_graphics_release() == false) goto L6;
            return new t(r100);
        L6:
            if (r100.isPQish$ui_graphics_release() == true) goto L22;
            boolean r101 = true;
            if (r100.getE() != AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
            boolean r102 = true;
        L12:
            if (r102 == false) goto L20;
            if (r100.getF() == AudioStats.AUDIO_AMPLITUDE_NONE) goto L17;
            r101 = false;
        L17:
            if (r101 == false) goto L20;
            return new v(r100);
        L20:
            return new w(r100);
        L11:
            r102 = false;
            goto L12
        L22:
            return new u(r100);
        }

        private final DoubleFunction generateOetf(final TransferParameters r100) {
            if (r100.isHLGish$ui_graphics_release() == false) goto L6;
            return new p(r100);
        L6:
            if (r100.isPQish$ui_graphics_release() == true) goto L22;
            boolean r101 = true;
            if (r100.getE() != AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
            boolean r102 = true;
        L12:
            if (r102 == false) goto L20;
            if (r100.getF() == AudioStats.AUDIO_AMPLITUDE_NONE) goto L17;
            r101 = false;
        L17:
            if (r101 == false) goto L20;
            return new r(r100);
        L20:
            return new s(r100);
        L11:
            r102 = false;
            goto L12
        L22:
            return new q(r100);
        }

        private final float[] xyPrimaries(float[] r110) {
            float[] r100 = new float[6];
            if (r110.length != 9) goto L5;
            float r101 = r110[0];
            float r102 = r110[1];
            float r103 = (r101 + r102) + r110[2];
            r100[0] = r101 / r103;
            r100[1] = r102 / r103;
            float r104 = r110[3];
            float r105 = r110[4];
            float r106 = (r104 + r105) + r110[5];
            r100[2] = r104 / r106;
            r100[3] = r105 / r106;
            float r107 = r110[6];
            float r108 = r110[7];
            float r109 = (r107 + r108) + r110[8];
            r100[4] = r107 / r109;
            r100[5] = r108 / r109;
        L6:
            return r100;
        L5:
            ArraysKt.copyInto$default(r110, r100, 0, 0, 6, 6, null);
            goto L6
        }

        public final float[] computePrimaries$ui_graphics_release(float[] r110) {
            float[] r100 = ColorSpaceKt.mul3x3Float3(r110, new float[]{1.0f, 0.0f, 0.0f});
            float[] r101 = ColorSpaceKt.mul3x3Float3(r110, new float[]{0.0f, 1.0f, 0.0f});
            float[] r111 = ColorSpaceKt.mul3x3Float3(r110, new float[]{0.0f, 0.0f, 1.0f});
            float r102 = r100[0];
            float r103 = r100[1];
            float r104 = (r102 + r103) + r100[2];
            float r105 = (r101[0] + r101[1]) + r101[2];
            float r106 = (r111[0] + r111[1]) + r111[2];
            return new float[]{r102 / r104, r103 / r104, r101[0] / r105, r101[1] / r105, r111[0] / r106, r111[1] / r106};
        }

        public static final /* synthetic */ WhitePoint access$computeWhitePoint(Companion r100, float[] r101) {
            return r100.computeWhitePoint(r101);
        }

        public static final /* synthetic */ DoubleFunction access$generateEotf(Companion r100, TransferParameters r101) {
            return r100.generateEotf(r101);
        }

        public static final /* synthetic */ DoubleFunction access$generateOetf(Companion r100, TransferParameters r101) {
            return r100.generateOetf(r101);
        }

        public static final /* synthetic */ float[] access$xyPrimaries(Companion r100, float[] r101) {
            return r100.xyPrimaries(r101);
        }

        private final float[] computeXYZMatrix(float[] r210, WhitePoint r211) {
            float r100 = r210[0];
            float r101 = r210[1];
            float r102 = r210[2];
            float r103 = r210[3];
            float r104 = r210[4];
            float r110 = r210[5];
            float r111 = r211.getX();
            float r112 = r211.getY();
            float r113 = 1;
            float r114 = (r113 - r100) / r101;
            float r115 = (r113 - r102) / r103;
            float r116 = (r113 - r104) / r110;
            float r117 = (r113 - r111) / r112;
            float r118 = r100 / r101;
            float r119 = (r102 / r103) - r118;
            float r120 = (r111 / r112) - r118;
            float r121 = r115 - r114;
            float r212 = (r104 / r110) - r118;
            float r122 = (((r117 - r114) * r119) - (r120 * r121)) / (((r116 - r114) * r119) - (r121 * r212));
            float r123 = (r120 - (r212 * r122)) / r119;
            float r124 = (1.0f - r123) - r122;
            float r125 = r124 / r101;
            float r126 = r123 / r103;
            float r127 = r122 / r110;
            return new float[]{r125 * r100, r124, r125 * ((1.0f - r100) - r101), r126 * r102, r123, r126 * ((1.0f - r102) - r103), r127 * r104, r122, r127 * ((1.0f - r104) - r110)};
        }

        private final boolean contains(float[] r110, float[] r111) {
            float r100 = r110[0] - r111[0];
            float r101 = r110[1] - r111[1];
            float r102 = r110[2] - r111[2];
            float r103 = r110[3] - r111[3];
            float r104 = r110[4] - r111[4];
            float r112 = r110[5] - r111[5];
            float r113 = r111[0];
            float r105 = r111[4];
            float r114 = r111[1];
            float r115 = r111[5];
            if ((((r114 - r115) * r100) - ((r113 - r105) * r101)) < 0.0f) goto L18;
            float r106 = r111[2];
            float r107 = r111[3];
            if ((((r113 - r106) * r101) - ((r114 - r107) * r100)) >= 0.0f) goto L8;
            return false;
        L8:
            if ((((r107 - r114) * r102) - ((r106 - r113) * r103)) >= 0.0f) goto L10;
            return false;
        L10:
            if ((((r106 - r105) * r103) - ((r107 - r115) * r102)) >= 0.0f) goto L13;
            return false;
        L13:
            if ((((r115 - r107) * r104) - ((r105 - r106) * r112)) >= 0.0f) goto L15;
            return false;
        L15:
            if ((((r105 - r113) * r112) - ((r115 - r114) * r104)) < 0.0f) goto L21;
            return true;
        L21:
            return false;
        L18:
            return false;
        }

        private static final double generateEotf$lambda$4(TransferParameters r100, double r101) {
            return ColorSpaces.INSTANCE.transferHlgEotf$ui_graphics_release(r100, r101);
        }

        private static final double generateEotf$lambda$5(TransferParameters r100, double r101) {
            return ColorSpaces.INSTANCE.transferSt2048Eotf$ui_graphics_release(r100, r101);
        }

        private static final double generateEotf$lambda$6(TransferParameters r110, double r111) {
            return ColorSpaceKt.response(r111, r110.getA(), r110.getB(), r110.getC(), r110.getD(), r110.getGamma());
        }

        private static final double generateEotf$lambda$7(TransferParameters r110, double r111) {
            return ColorSpaceKt.response(r111, r110.getA(), r110.getB(), r110.getC(), r110.getD(), r110.getE(), r110.getF(), r110.getGamma());
        }

        private static final double generateOetf$lambda$0(TransferParameters r100, double r101) {
            return ColorSpaces.INSTANCE.transferHlgOetf$ui_graphics_release(r100, r101);
        }

        private static final double generateOetf$lambda$1(TransferParameters r100, double r101) {
            return ColorSpaces.INSTANCE.transferSt2048Oetf$ui_graphics_release(r100, r101);
        }

        private static final double generateOetf$lambda$2(TransferParameters r110, double r111) {
            return ColorSpaceKt.rcpResponse(r111, r110.getA(), r110.getB(), r110.getC(), r110.getD(), r110.getGamma());
        }

        private static final double generateOetf$lambda$3(TransferParameters r110, double r111) {
            return ColorSpaceKt.rcpResponse(r111, r110.getA(), r110.getB(), r110.getC(), r110.getD(), r110.getE(), r110.getF(), r110.getGamma());
        }

        public static final /* synthetic */ float[] access$computeXYZMatrix(Companion r100, float[] r101, WhitePoint r102) {
            return r100.computeXYZMatrix(r101, r102);
        }

        private final boolean compare(double r100, DoubleFunction r101, DoubleFunction r102) {
            if (Math.abs(r101.invoke(r100) - r102.invoke(r100)) > 0.001d) goto L5;
            return true;
        L5:
            return false;
        }

        private final boolean isWideGamut(float[] r100, float r101, float r102) {
            float r103 = area(r100);
            ColorSpaces r104 = ColorSpaces.INSTANCE;
            if ((r103 / area(r104.getNtsc1953Primaries$ui_graphics_release())) <= 0.9f) goto L7;
            if (contains(r100, r104.getSrgbPrimaries$ui_graphics_release()) == false) goto L7;
        L10:
            return true;
        L7:
            if (r101 < 0.0f) goto L9;
        L11:
            return false;
        L9:
            if (r102 <= 1.0f) goto L11;
            goto L10
        }

        public static final /* synthetic */ boolean access$isWideGamut(Companion r100, float[] r101, float r102, float r103) {
            return r100.isWideGamut(r101, r102, r103);
        }

        private final boolean isSrgb(float[] r100, WhitePoint r101, DoubleFunction r102, DoubleFunction r103, float r104, float r110, int r111) {
            if (r111 != 0) goto L5;
            return true;
        L5:
            ColorSpaces r112 = ColorSpaces.INSTANCE;
            if (ColorSpaceKt.compare(r100, r112.getSrgbPrimaries$ui_graphics_release()) == true) goto L9;
            return false;
        L9:
            if (ColorSpaceKt.compare(r101, Illuminant.INSTANCE.getD65()) == true) goto L12;
            return false;
        L12:
            if (r104 != 0.0f) goto L14;
            boolean r105 = true;
        L15:
            if (r105 == true) goto L18;
            return false;
        L18:
            if (r110 != 1.0f) goto L20;
            boolean r106 = true;
        L21:
            if (r106 == true) goto L23;
            return false;
        L23:
            Rgb r107 = r112.getSrgb();
            double r108 = AudioStats.AUDIO_AMPLITUDE_NONE;
        L25:
            if (r108 > 1.0d) goto L33;
            if (compare(r108, r102, r107.getOetfOrig$ui_graphics_release()) == false) goto L28;
            if (compare(r108, r103, r107.getEotfOrig$ui_graphics_release()) == false) goto L31;
            r108 = r108 + 0.00392156862745098d;
            goto L25
        L31:
            return false;
        L28:
            return false;
        L33:
            return true;
        L20:
            r106 = false;
            goto L21
        L14:
            r105 = false;
            goto L15
        }

        public static final /* synthetic */ boolean access$isSrgb(Companion r100, float[] r101, WhitePoint r102, DoubleFunction r103, DoubleFunction r104, float r105, float r106, int r107) {
            return r100.isSrgb(r101, r102, r103, r104, r105, r106, r107);
        }
    }

    private static final double DoubleIdentity$lambda$8(double r100) {
        return r100;
    }

    public static /* synthetic */ double a(double r100, double r101) {
        return _init_$lambda$7(r100, r101);
    }

    public static /* synthetic */ double b(Rgb r100, double r101) {
        return oetfFunc$lambda$0(r100, r101);
    }

    public static /* synthetic */ double c(Rgb r100, double r101) {
        return eotfFunc$lambda$1(r100, r101);
    }

    public static /* synthetic */ double d(double r100) {
        return DoubleIdentity$lambda$8(r100);
    }

    public static /* synthetic */ double e(Function1 r100, double r101) {
        return _init_$lambda$3(r100, r101);
    }

    public static /* synthetic */ double f(Function1 r100, double r101) {
        return _init_$lambda$5(r100, r101);
    }

    public static /* synthetic */ double g(Function1 r100, double r101) {
        return _init_$lambda$2(r100, r101);
    }

    public static /* synthetic */ double h(double r100, double r101) {
        return _init_$lambda$6(r100, r101);
    }

    public static /* synthetic */ double i(Function1 r100, double r101) {
        return _init_$lambda$4(r100, r101);
    }

    static {
        Companion = new Companion(null);
        DoubleIdentity = new m();
    }

    public final float[] getInverseTransform() {
        float[] r100 = this.inverseTransform;
        return Arrays.copyOf(r100, r100.length);
    }

    public final float[] getPrimaries() {
        float[] r100 = this.primaries;
        return Arrays.copyOf(r100, r100.length);
    }

    public final float[] getTransform() {
        float[] r100 = this.transform;
        return Arrays.copyOf(r100, r100.length);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public int hashCode() {
        int r100 = ((((super.hashCode() * 31) + this.whitePoint.hashCode()) * 31) + Arrays.hashCode(this.primaries)) * 31;
        float r101 = this.min;
        boolean r102 = true;
        int r103 = 0;
        if (r101 != 0.0f) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L8;
        int r105 = Float.floatToIntBits(r101);
    L9:
        int r106 = (r100 + r105) * 31;
        float r107 = this.max;
        if (r107 == 0.0f) goto L13;
        r102 = false;
    L13:
        if (r102 == true) goto L15;
        int r108 = Float.floatToIntBits(r107);
    L16:
        int r109 = (r106 + r108) * 31;
        TransferParameters r110 = this.transferParameters;
        if (r110 == null) goto L19;
        r103 = r110.hashCode();
    L19:
        int r111 = r109 + r103;
        if (this.transferParameters == null) goto L22;
        return r111;
    L22:
        return (((r111 * 31) + this.oetfOrig.hashCode()) * 31) + this.eotfOrig.hashCode();
    L15:
        r108 = 0;
        goto L16
    L8:
        r105 = 0;
        goto L9
    L5:
        r104 = false;
        goto L6
    }

    public final Function1<Double, Double> getEotf() {
        return this.eotf;
    }

    public final DoubleFunction getEotfFunc$ui_graphics_release() {
        return this.eotfFunc;
    }

    public final DoubleFunction getEotfOrig$ui_graphics_release() {
        return this.eotfOrig;
    }

    public final float[] getInverseTransform$ui_graphics_release() {
        return this.inverseTransform;
    }

    public final Function1<Double, Double> getOetf() {
        return this.oetf;
    }

    public final DoubleFunction getOetfFunc$ui_graphics_release() {
        return this.oetfFunc;
    }

    public final DoubleFunction getOetfOrig$ui_graphics_release() {
        return this.oetfOrig;
    }

    public final float[] getPrimaries$ui_graphics_release() {
        return this.primaries;
    }

    public final TransferParameters getTransferParameters() {
        return this.transferParameters;
    }

    public final float[] getTransform$ui_graphics_release() {
        return this.transform;
    }

    public final WhitePoint getWhitePoint() {
        return this.whitePoint;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean isSrgb() {
        return this.isSrgb;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean isWideGamut() {
        return this.isWideGamut;
    }

    public static final /* synthetic */ float access$getMax$p(Rgb r100) {
        return r100.max;
    }

    public static final /* synthetic */ float access$getMin$p(Rgb r100) {
        return r100.min;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
        return false;
    L8:
        if (Rgb.class == r100.getClass()) goto L11;
        return false;
    L11:
        if (super.equals(r100) == true) goto L13;
        return false;
    L13:
        Rgb r101 = (Rgb) r100;
        if (Float.compare(r101.min, this.min) == 0) goto L17;
        return false;
    L17:
        if (Float.compare(r101.max, this.max) == 0) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.whitePoint, r101.whitePoint) == true) goto L23;
        return false;
    L23:
        if (Arrays.equals(this.primaries, r101.primaries) == true) goto L25;
        return false;
    L25:
        TransferParameters r102 = this.transferParameters;
        if (r102 == null) goto L30;
        return Intrinsics.areEqual(r102, r101.transferParameters);
    L30:
        if (r101.transferParameters != null) goto L33;
        return true;
    L33:
        if (Intrinsics.areEqual(this.oetfOrig, r101.oetfOrig) == true) goto L36;
        return false;
    L36:
        return Intrinsics.areEqual(this.eotfOrig, r101.eotfOrig);
    }

    public final float[] fromLinear(float[] r100) {
        if (r100.length >= 3) goto L5;
        return r100;
    L5:
        r100[0] = (float) this.oetfFunc.invoke(r100[0]);
        r100[1] = (float) this.oetfFunc.invoke(r100[1]);
        r100[2] = (float) this.oetfFunc.invoke(r100[2]);
        return r100;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] r100) {
        ColorSpaceKt.mul3x3Float3(this.inverseTransform, r100);
        if (r100.length >= 3) goto L5;
        return r100;
    L5:
        r100[0] = (float) this.oetfFunc.invoke(r100[0]);
        r100[1] = (float) this.oetfFunc.invoke(r100[1]);
        r100[2] = (float) this.oetfFunc.invoke(r100[2]);
        return r100;
    }

    public final float[] getInverseTransform(float[] r100) {
        return ArraysKt.copyInto$default(this.inverseTransform, r100, 0, 0, 0, 14, null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int r100) {
        return this.max;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int r100) {
        return this.min;
    }

    public final float[] getPrimaries(float[] r100) {
        return ArraysKt.copyInto$default(this.primaries, r100, 0, 0, 0, 14, null);
    }

    public final float[] getTransform(float[] r100) {
        return ArraysKt.copyInto$default(this.transform, r100, 0, 0, 0, 14, null);
    }

    public final float[] toLinear(float[] r100) {
        if (r100.length >= 3) goto L5;
        return r100;
    L5:
        r100[0] = (float) this.eotfFunc.invoke(r100[0]);
        r100[1] = (float) this.eotfFunc.invoke(r100[1]);
        r100[2] = (float) this.eotfFunc.invoke(r100[2]);
        return r100;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] r100) {
        if (r100.length >= 3) goto L5;
        return r100;
    L5:
        r100[0] = (float) this.eotfFunc.invoke(r100[0]);
        r100[1] = (float) this.eotfFunc.invoke(r100[1]);
        r100[2] = (float) this.eotfFunc.invoke(r100[2]);
        return ColorSpaceKt.mul3x3Float3(this.transform, r100);
    }

    private static final double _init_$lambda$2(Function1 r100, double r101) {
        return ((Number) r100.invoke(Double.valueOf(r101))).doubleValue();
    }

    private static final double _init_$lambda$3(Function1 r100, double r101) {
        return ((Number) r100.invoke(Double.valueOf(r101))).doubleValue();
    }

    private static final double _init_$lambda$4(Function1 r100, double r101) {
        return ((Number) r100.invoke(Double.valueOf(r101))).doubleValue();
    }

    private static final double _init_$lambda$5(Function1 r100, double r101) {
        return ((Number) r100.invoke(Double.valueOf(r101))).doubleValue();
    }

    private static final double _init_$lambda$6(double r100, double r101) {
        if (r101 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        r101 = 0.0d;
    L6:
        return Math.pow(r101, 1.0d / r100);
    }

    private static final double _init_$lambda$7(double r100, double r101) {
        if (r101 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        r101 = 0.0d;
    L6:
        return Math.pow(r101, r100);
    }

    private static final double eotfFunc$lambda$1(Rgb r100, double r101) {
        return r100.eotfOrig.invoke(RangesKt.coerceIn(r101, r100.min, r100.max));
    }

    private static final double oetfFunc$lambda$0(Rgb r100, double r101) {
        return RangesKt.coerceIn(r100.oetfOrig.invoke(r101), r100.min, r100.max);
    }

    public Rgb(Rgb r110, float[] r111, WhitePoint r112) {
        this(r110.getName(), r110.primaries, r112, r111, r110.oetfOrig, r110.eotfOrig, r110.min, r110.max, r110.transferParameters, -1);
    }

    public final float[] fromLinear(float r100, float r101, float r102) {
        return fromLinear(new float[]{r100, r101, r102});
    }

    public final float[] toLinear(float r100, float r101, float r102) {
        return toLinear(new float[]{r100, r101, r102});
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float r100, float r101, float r102) {
        float r103 = (float) this.eotfFunc.invoke(r100);
        float r104 = (float) this.eotfFunc.invoke(r101);
        float r105 = (float) this.eotfFunc.invoke(r102);
        float[] r106 = this.transform;
        if (r106.length >= 9) goto L6;
        return 0;
    L6:
        float r107 = ((r106[0] * r103) + (r106[3] * r104)) + (r106[6] * r105);
        float r108 = ((r106[1] * r103) + (r106[4] * r104)) + (r106[7] * r105);
        return (Float.floatToRawIntBits(r107) << 32) | (((long) Float.floatToRawIntBits(r108)) & BodyPartID.bodyIdMax);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float r100, float r101, float r102) {
        float r103 = (float) this.eotfFunc.invoke(r100);
        float r104 = (float) this.eotfFunc.invoke(r101);
        float r105 = (float) this.eotfFunc.invoke(r102);
        float[] r106 = this.transform;
        return ((r106[2] * r103) + (r106[5] * r104)) + (r106[8] * r105);
    }

    public Rgb(String r110, float[] r111, double r112) {
        Companion r100 = Companion;
        this(r110, r100.computePrimaries$ui_graphics_release(r111), Companion.access$computeWhitePoint(r100, r111), r112, 0.0f, 1.0f, -1);
    }

    public Rgb(String r100, float[] r101, TransferParameters r110) {
        Companion r102 = Companion;
        this(r100, r102.computePrimaries$ui_graphics_release(r101), Companion.access$computeWhitePoint(r102, r101), r110, -1);
    }

    public Rgb(String r110, float[] r111, final Function1<? super Double, Double> r112, final Function1<? super Double, Double> r113) {
        Companion r100 = Companion;
        this(r110, r100.computePrimaries$ui_graphics_release(r111), Companion.access$computeWhitePoint(r100, r111), null, new i(r112), new j(r113), 0.0f, 1.0f, null, -1);
    }

    public Rgb(String r110, float[] r111, WhitePoint r112, double r113) {
        this(r110, r111, r112, r113, 0.0f, 1.0f, -1);
    }

    public Rgb(String r100, float[] r101, WhitePoint r102, TransferParameters r110) {
        this(r100, r101, r102, r110, -1);
    }

    public Rgb(String r110, float[] r111, WhitePoint r112, TransferParameters r113, int r114) {
        Companion r100 = Companion;
        this(r110, r111, r112, null, Companion.access$generateOetf(r100, r113), Companion.access$generateEotf(r100, r113), 0.0f, 1.0f, r113, r114);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* JADX INFO: renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo5271xyzaToColorJlNiLsg$ui_graphics_release(float r100, float r101, float r102, float r103, ColorSpace r104) {
        float[] r105 = this.inverseTransform;
        return ColorKt.Color((float) this.oetfFunc.invoke(((r105[0] * r100) + (r105[3] * r101)) + (r105[6] * r102)), (float) this.oetfFunc.invoke(((r105[1] * r100) + (r105[4] * r101)) + (r105[7] * r102)), (float) this.oetfFunc.invoke(((r105[2] * r100) + (r105[5] * r101)) + (r105[8] * r102)), r103, r104);
    }

    public Rgb(String r210, float[] r211, WhitePoint r212, final double r213, float r214, float r215, int r216) {
        boolean r100 = true;
        if (r213 != 1.0d) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        DoubleFunction r102 = DoubleIdentity;
    L9:
        DoubleFunction r110 = r102;
        if (r213 == 1.0d) goto L13;
        r100 = false;
    L13:
        if (r100 == false) goto L15;
        DoubleFunction r103 = DoubleIdentity;
    L16:
        this(r210, r211, r212, null, r110, r103, r214, r215, new TransferParameters(r213, 1.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 96, null), r216);
        return;
    L15:
        r103 = new o(r213);
        goto L16
    L8:
        r102 = new n(r213);
        goto L9
    L5:
        r101 = false;
        goto L6
    }

    public Rgb(String r110, float[] r111, WhitePoint r112, final Function1<? super Double, Double> r113, final Function1<? super Double, Double> r114, float r115, float r116) {
        this(r110, r111, r112, null, new g(r113), new h(r114), r115, r116, null, -1);
    }

    public Rgb(String r110, float[] r111, WhitePoint r112, float[] r113, DoubleFunction r210, DoubleFunction r211, float r212, float r213, TransferParameters r214, int r215) {
        super(r110, ColorModel.Companion.m5268getRgbxdoWZVw(), r215, null);
        this.whitePoint = r112;
        this.min = r212;
        this.max = r213;
        this.transferParameters = r214;
        this.oetfOrig = r210;
        this.oetf = new Rgb$oetf$1(this);
        this.oetfFunc = new k(this);
        this.eotfOrig = r211;
        this.eotf = new Rgb$eotf$1(this);
        this.eotfFunc = new l(this);
        if (r111.length == 6) goto L10;
        if (r111.length == 9) goto L10;
        throw new IllegalArgumentException("The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
    L10:
        if (r212 >= r213) goto L22;
        Companion r100 = Companion;
        float[] r101 = Companion.access$xyPrimaries(r100, r111);
        this.primaries = r101;
        if (r113 != null) goto L15;
        this.transform = Companion.access$computeXYZMatrix(r100, r101, r112);
    L17:
        this.inverseTransform = ColorSpaceKt.inverse3x3(this.transform);
        this.isWideGamut = Companion.access$isWideGamut(r100, r101, r212, r213);
        this.isSrgb = Companion.access$isSrgb(r100, r101, r112, r210, r211, r212, r213, r215);
        return;
    L15:
        if (r113.length != 9) goto L20;
        this.transform = r113;
        goto L17
    L20:
        throw new IllegalArgumentException("Transform must have 9 entries! Has " + r113.length);
    L22:
        throw new IllegalArgumentException("Invalid range: min=" + r212 + ", max=" + r213 + "; min must be strictly < max");
    }
}
