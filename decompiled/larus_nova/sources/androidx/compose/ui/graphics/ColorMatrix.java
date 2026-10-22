package androidx.compose.ui.graphics;

import androidx.core.text.util.LocalePreferences;
import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0086\n¢\u0006\u0004\b\r\u0010\u000eJ(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\tH\u0086\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0010H\u0086\b¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019JP\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\t26\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00100\u001dH\u0082\b¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b&\u0010\u0019J\u0015\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\t¢\u0006\u0004\b)\u0010*J-\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t¢\u0006\u0004\b0\u00101J\u0015\u00102\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b3\u0010*J\u0015\u00104\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b5\u0010*J\u0015\u00106\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b7\u0010*J\r\u00108\u001a\u00020\u0010¢\u0006\u0004\b9\u0010\u0016J\r\u0010:\u001a\u00020\u0010¢\u0006\u0004\b;\u0010\u0016J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\u000bHÖ\u0001J\t\u0010@\u001a\u00020AHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006B"}, d2 = {"Landroidx/compose/ui/graphics/ColorMatrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", MonitorConstants.CONNECT_TYPE_GET, "", SlcFlexDirection.FLEX_ROW, "", "column", "get-impl", "([FII)F", "set", "", BaseSwitches.V, "set-impl", "([FIIF)V", BasicTestActionHandler.TEST_ACTION_RESET, "reset-impl", "([F)V", "src", "set-jHG-Opc", "([F[F)V", "rotateInternal", "degrees", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cosine", "sine", "rotateInternal-impl", "([FFLkotlin/jvm/functions/Function2;)V", "timesAssign", "colorMatrix", "timesAssign-jHG-Opc", "setToSaturation", LocalePreferences.FirstDayOfWeek.SATURDAY, "setToSaturation-impl", "([FF)V", "setToScale", "redScale", "greenScale", "blueScale", "alphaScale", "setToScale-impl", "([FFFFF)V", "setToRotateRed", "setToRotateRed-impl", "setToRotateGreen", "setToRotateGreen-impl", "setToRotateBlue", "setToRotateBlue-impl", "convertRgbToYuv", "convertRgbToYuv-impl", "convertYuvToRgb", "convertYuvToRgb-impl", "equals", "", "other", "hashCode", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class ColorMatrix {
    private final float[] values;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ColorMatrix m4882boximpl(float[] r100) {
        return new ColorMatrix(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float[] m4883constructorimpl(float[] r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4887equalsimpl(float[] r100, Object r101) {
        if ((r101 instanceof ColorMatrix) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100, ((ColorMatrix) r101).m4902unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4888equalsimpl0(float[] r100, float[] r101) {
        return Intrinsics.areEqual(r100, r101);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4890hashCodeimpl(float[] r100) {
        return Arrays.hashCode(r100);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4901toStringimpl(float[] r100) {
        return "ColorMatrix(values=" + Arrays.toString(r100) + ')';
    }

    public boolean equals(Object r100) {
        return m4887equalsimpl(this.values, r100);
    }

    public int hashCode() {
        return m4890hashCodeimpl(this.values);
    }

    public String toString() {
        return m4901toStringimpl(this.values);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float[] m4902unboximpl() {
        return this.values;
    }

    public final float[] getValues() {
        return this.values;
    }

    private /* synthetic */ ColorMatrix(float[] r100) {
        this.values = r100;
    }

    /* JADX INFO: renamed from: convertRgbToYuv-impl, reason: not valid java name */
    public static final void m4885convertRgbToYuvimpl(float[] r110) {
        if (r110.length >= 20) goto L5;
        return;
    L5:
        r110[0] = 1.0f;
        r110[1] = 0.0f;
        r110[2] = 0.0f;
        r110[3] = 0.0f;
        r110[4] = 0.0f;
        r110[5] = 0.0f;
        r110[6] = 1.0f;
        r110[7] = 0.0f;
        r110[8] = 0.0f;
        r110[9] = 0.0f;
        r110[10] = 0.0f;
        r110[11] = 0.0f;
        r110[12] = 1.0f;
        r110[13] = 0.0f;
        r110[14] = 0.0f;
        r110[15] = 0.0f;
        r110[16] = 0.0f;
        r110[17] = 0.0f;
        r110[18] = 1.0f;
        r110[19] = 0.0f;
        r110[0] = 0.299f;
        r110[1] = 0.587f;
        r110[2] = 0.114f;
        r110[5] = -0.16874f;
        r110[6] = -0.33126f;
        r110[7] = 0.5f;
        r110[10] = 0.5f;
        r110[11] = -0.41869f;
        r110[12] = -0.08131f;
    }

    /* JADX INFO: renamed from: convertYuvToRgb-impl, reason: not valid java name */
    public static final void m4886convertYuvToRgbimpl(float[] r110) {
        if (r110.length >= 20) goto L5;
        return;
    L5:
        r110[0] = 1.0f;
        r110[1] = 0.0f;
        r110[2] = 0.0f;
        r110[3] = 0.0f;
        r110[4] = 0.0f;
        r110[5] = 0.0f;
        r110[6] = 1.0f;
        r110[7] = 0.0f;
        r110[8] = 0.0f;
        r110[9] = 0.0f;
        r110[10] = 0.0f;
        r110[11] = 0.0f;
        r110[12] = 1.0f;
        r110[13] = 0.0f;
        r110[14] = 0.0f;
        r110[15] = 0.0f;
        r110[16] = 0.0f;
        r110[17] = 0.0f;
        r110[18] = 1.0f;
        r110[19] = 0.0f;
        r110[2] = 1.402f;
        r110[5] = 1.0f;
        r110[6] = -0.34414f;
        r110[7] = -0.71414f;
        r110[10] = 1.0f;
        r110[11] = 1.772f;
        r110[12] = 0.0f;
    }

    /* JADX INFO: renamed from: reset-impl, reason: not valid java name */
    public static final void m4891resetimpl(float[] r100) {
        r100[0] = 1.0f;
        r100[1] = 0.0f;
        r100[2] = 0.0f;
        r100[3] = 0.0f;
        r100[4] = 0.0f;
        r100[5] = 0.0f;
        r100[6] = 1.0f;
        r100[7] = 0.0f;
        r100[8] = 0.0f;
        r100[9] = 0.0f;
        r100[10] = 0.0f;
        r100[11] = 0.0f;
        r100[12] = 1.0f;
        r100[13] = 0.0f;
        r100[14] = 0.0f;
        r100[15] = 0.0f;
        r100[16] = 0.0f;
        r100[17] = 0.0f;
        r100[18] = 1.0f;
        r100[19] = 0.0f;
    }

    /* JADX INFO: renamed from: set-jHG-Opc, reason: not valid java name */
    public static final void m4894setjHGOpc(float[] r100, float[] r101) {
        if (r100.length >= 20) goto L6;
        return;
    L6:
        if (r101.length >= 20) goto L8;
        return;
    L8:
        r100[0] = r101[0];
        r100[1] = r101[1];
        r100[2] = r101[2];
        r100[3] = r101[3];
        r100[4] = r101[4];
        r100[5] = r101[5];
        r100[6] = r101[6];
        r100[7] = r101[7];
        r100[8] = r101[8];
        r100[9] = r101[9];
        r100[10] = r101[10];
        r100[11] = r101[11];
        r100[12] = r101[12];
        r100[13] = r101[13];
        r100[14] = r101[14];
        r100[15] = r101[15];
        r100[16] = r101[16];
        r100[17] = r101[17];
        r100[18] = r101[18];
        r100[19] = r101[19];
    }

    /* JADX INFO: renamed from: setToRotateBlue-impl, reason: not valid java name */
    public static final void m4895setToRotateBlueimpl(float[] r110, float r111) {
        if (r110.length >= 20) goto L5;
        return;
    L5:
        r110[0] = 1.0f;
        r110[1] = 0.0f;
        r110[2] = 0.0f;
        r110[3] = 0.0f;
        r110[4] = 0.0f;
        r110[5] = 0.0f;
        r110[6] = 1.0f;
        r110[7] = 0.0f;
        r110[8] = 0.0f;
        r110[9] = 0.0f;
        r110[10] = 0.0f;
        r110[11] = 0.0f;
        r110[12] = 1.0f;
        r110[13] = 0.0f;
        r110[14] = 0.0f;
        r110[15] = 0.0f;
        r110[16] = 0.0f;
        r110[17] = 0.0f;
        r110[18] = 1.0f;
        r110[19] = 0.0f;
        float r112 = r111 * 0.0027777778f;
        float r100 = 0.25f + r112;
        float r101 = r100 - ((float) Math.floor(r100 + 0.5f));
        float r102 = Math.abs(r101) * 2.0f;
        float r103 = 1.0f - r102;
        float r104 = ((r101 * 8.0f) * r103) / (1.25f - (r102 * r103));
        float r113 = r112 - ((float) Math.floor(0.5f + r112));
        float r105 = Math.abs(r113) * 2.0f;
        float r106 = 1.0f - r105;
        float r114 = ((r113 * 8.0f) * r106) / (1.25f - (r105 * r106));
        r110[0] = r104;
        r110[1] = r114;
        r110[5] = -r114;
        r110[6] = r104;
    }

    /* JADX INFO: renamed from: setToRotateGreen-impl, reason: not valid java name */
    public static final void m4896setToRotateGreenimpl(float[] r110, float r111) {
        if (r110.length >= 20) goto L5;
        return;
    L5:
        r110[0] = 1.0f;
        r110[1] = 0.0f;
        r110[2] = 0.0f;
        r110[3] = 0.0f;
        r110[4] = 0.0f;
        r110[5] = 0.0f;
        r110[6] = 1.0f;
        r110[7] = 0.0f;
        r110[8] = 0.0f;
        r110[9] = 0.0f;
        r110[10] = 0.0f;
        r110[11] = 0.0f;
        r110[12] = 1.0f;
        r110[13] = 0.0f;
        r110[14] = 0.0f;
        r110[15] = 0.0f;
        r110[16] = 0.0f;
        r110[17] = 0.0f;
        r110[18] = 1.0f;
        r110[19] = 0.0f;
        float r112 = r111 * 0.0027777778f;
        float r100 = 0.25f + r112;
        float r101 = r100 - ((float) Math.floor(r100 + 0.5f));
        float r102 = Math.abs(r101) * 2.0f;
        float r103 = 1.0f - r102;
        float r104 = ((r101 * 8.0f) * r103) / (1.25f - (r102 * r103));
        float r113 = r112 - ((float) Math.floor(0.5f + r112));
        float r105 = Math.abs(r113) * 2.0f;
        float r106 = 1.0f - r105;
        float r114 = ((r113 * 8.0f) * r106) / (1.25f - (r105 * r106));
        r110[0] = r104;
        r110[2] = -r114;
        r110[10] = r114;
        r110[12] = r104;
    }

    /* JADX INFO: renamed from: setToRotateRed-impl, reason: not valid java name */
    public static final void m4897setToRotateRedimpl(float[] r110, float r111) {
        if (r110.length >= 20) goto L5;
        return;
    L5:
        r110[0] = 1.0f;
        r110[1] = 0.0f;
        r110[2] = 0.0f;
        r110[3] = 0.0f;
        r110[4] = 0.0f;
        r110[5] = 0.0f;
        r110[6] = 1.0f;
        r110[7] = 0.0f;
        r110[8] = 0.0f;
        r110[9] = 0.0f;
        r110[10] = 0.0f;
        r110[11] = 0.0f;
        r110[12] = 1.0f;
        r110[13] = 0.0f;
        r110[14] = 0.0f;
        r110[15] = 0.0f;
        r110[16] = 0.0f;
        r110[17] = 0.0f;
        r110[18] = 1.0f;
        r110[19] = 0.0f;
        float r112 = r111 * 0.0027777778f;
        float r100 = 0.25f + r112;
        float r101 = r100 - ((float) Math.floor(r100 + 0.5f));
        float r102 = Math.abs(r101) * 2.0f;
        float r103 = 1.0f - r102;
        float r104 = ((r101 * 8.0f) * r103) / (1.25f - (r102 * r103));
        float r113 = r112 - ((float) Math.floor(0.5f + r112));
        float r105 = Math.abs(r113) * 2.0f;
        float r106 = 1.0f - r105;
        float r114 = ((r113 * 8.0f) * r106) / (1.25f - (r105 * r106));
        r110[6] = r104;
        r110[7] = r114;
        r110[11] = -r114;
        r110[12] = r104;
    }

    /* JADX INFO: renamed from: setToSaturation-impl, reason: not valid java name */
    public static final void m4898setToSaturationimpl(float[] r110, float r111) {
        if (r110.length >= 20) goto L5;
        return;
    L5:
        r110[0] = 1.0f;
        r110[1] = 0.0f;
        r110[2] = 0.0f;
        r110[3] = 0.0f;
        r110[4] = 0.0f;
        r110[5] = 0.0f;
        r110[6] = 1.0f;
        r110[7] = 0.0f;
        r110[8] = 0.0f;
        r110[9] = 0.0f;
        r110[10] = 0.0f;
        r110[11] = 0.0f;
        r110[12] = 1.0f;
        r110[13] = 0.0f;
        r110[14] = 0.0f;
        r110[15] = 0.0f;
        r110[16] = 0.0f;
        r110[17] = 0.0f;
        r110[18] = 1.0f;
        r110[19] = 0.0f;
        float r100 = 1 - r111;
        float r101 = 0.213f * r100;
        float r112 = 0.715f * r100;
        float r102 = r100 * 0.072f;
        r110[0] = r101 + r111;
        r110[1] = r112;
        r110[2] = r102;
        r110[5] = r101;
        r110[6] = r112 + r111;
        r110[7] = r102;
        r110[10] = r101;
        r110[11] = r112;
        r110[12] = r102 + r111;
    }

    /* JADX INFO: renamed from: timesAssign-jHG-Opc, reason: not valid java name */
    public static final void m4900timesAssignjHGOpc(float[] r610, float[] r611) {
        if (r610.length >= 20) goto L5;
        return;
    L5:
        float r100 = r610[0];
        float r101 = r611[0];
        float r102 = r610[1];
        float r103 = r611[5];
        float r110 = r610[2];
        float r111 = r611[10];
        float r112 = r610[3];
        float r113 = r611[15];
        float r104 = (((r100 * r101) + (r102 * r103)) + (r110 * r111)) + (r112 * r113);
        float r114 = r611[1];
        float r210 = r611[6];
        float r211 = r611[11];
        float r212 = r611[16];
        float r115 = (((r100 * r114) + (r102 * r210)) + (r110 * r211)) + (r112 * r212);
        float r213 = r611[2];
        float r214 = r611[7];
        float r310 = r611[12];
        float r311 = r611[17];
        float r215 = (((r100 * r213) + (r102 * r214)) + (r110 * r310)) + (r112 * r311);
        float r312 = r611[3];
        float r313 = r611[8];
        float r314 = r611[13];
        float r410 = r611[18];
        float r315 = (((r100 * r312) + (r102 * r313)) + (r110 * r314)) + (r112 * r410);
        float r411 = r611[4];
        float r412 = r611[9];
        float r413 = r611[14];
        float r414 = r611[19];
        float r105 = ((((r100 * r411) + (r102 * r412)) + (r110 * r413)) + (r112 * r414)) + r610[4];
        float r116 = r610[5];
        float r415 = r610[6];
        float r416 = (r116 * r101) + (r415 * r103);
        float r417 = r610[7];
        float r418 = r416 + (r417 * r111);
        float r510 = r610[8];
        float r419 = r418 + (r510 * r113);
        float r511 = (((r116 * r114) + (r415 * r210)) + (r417 * r211)) + (r510 * r212);
        float r512 = (((r116 * r213) + (r415 * r214)) + (r417 * r310)) + (r510 * r311);
        float r513 = (((r116 * r312) + (r415 * r313)) + (r417 * r314)) + (r510 * r410);
        float r117 = ((((r116 * r411) + (r415 * r412)) + (r417 * r413)) + (r510 * r414)) + r610[9];
        float r420 = r610[10];
        float r514 = r610[11];
        float r421 = (r420 * r101) + (r514 * r103);
        float r515 = r610[12];
        float r422 = r421 + (r515 * r111);
        float r516 = r610[13];
        float r423 = r422 + (r516 * r113);
        float r517 = (((r420 * r114) + (r514 * r210)) + (r515 * r211)) + (r516 * r212);
        float r518 = (((r420 * r213) + (r514 * r214)) + (r515 * r310)) + (r516 * r311);
        float r519 = (((r420 * r312) + (r514 * r313)) + (r515 * r314)) + (r516 * r410);
        float r424 = ((((r420 * r411) + (r514 * r412)) + (r515 * r413)) + (r516 * r414)) + r610[14];
        float r520 = r610[15];
        float r521 = r610[16];
        float r106 = (r101 * r520) + (r103 * r521);
        float r107 = r610[17];
        float r108 = r106 + (r111 * r107);
        float r118 = r610[18];
        float r109 = r108 + (r113 * r118);
        float r119 = (((r114 * r520) + (r210 * r521)) + (r211 * r107)) + (r212 * r118);
        float r216 = (((r213 * r520) + (r214 * r521)) + (r310 * r107)) + (r311 * r118);
        float r316 = (((r312 * r520) + (r313 * r521)) + (r314 * r107)) + (r410 * r118);
        float r522 = ((((r520 * r411) + (r521 * r412)) + (r107 * r413)) + (r118 * r414)) + r610[19];
        r610[0] = r104;
        r610[1] = r115;
        r610[2] = r215;
        r610[3] = r315;
        r610[4] = r105;
        r610[5] = r419;
        r610[6] = r511;
        r610[7] = r512;
        r610[8] = r513;
        r610[9] = r117;
        r610[10] = r423;
        r610[11] = r517;
        r610[12] = r518;
        r610[13] = r519;
        r610[14] = r424;
        r610[15] = r109;
        r610[16] = r119;
        r610[17] = r216;
        r610[18] = r316;
        r610[19] = r522;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ float[] m4884constructorimpl$default(float[] r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L6;
        r100 = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    L6:
        return m4883constructorimpl(r100);
    }

    /* JADX INFO: renamed from: get-impl, reason: not valid java name */
    public static final float m4889getimpl(float[] r100, int r101, int r102) {
        return r100[(r101 * 5) + r102];
    }

    /* JADX INFO: renamed from: rotateInternal-impl, reason: not valid java name */
    private static final void m4892rotateInternalimpl(float[] r100, float r101, Function2<? super Float, ? super Float, Unit> r110) {
        r100[0] = 1.0f;
        r100[1] = 0.0f;
        r100[2] = 0.0f;
        r100[3] = 0.0f;
        r100[4] = 0.0f;
        r100[5] = 0.0f;
        r100[6] = 1.0f;
        r100[7] = 0.0f;
        r100[8] = 0.0f;
        r100[9] = 0.0f;
        r100[10] = 0.0f;
        r100[11] = 0.0f;
        r100[12] = 1.0f;
        r100[13] = 0.0f;
        r100[14] = 0.0f;
        r100[15] = 0.0f;
        r100[16] = 0.0f;
        r100[17] = 0.0f;
        r100[18] = 1.0f;
        r100[19] = 0.0f;
        float r102 = r101 * 0.0027777778f;
        float r103 = 0.25f + r102;
        float r104 = r103 - ((float) Math.floor(r103 + 0.5f));
        float r105 = Math.abs(r104) * 2.0f;
        float r106 = 1.0f - r105;
        float r107 = r102 - ((float) Math.floor(0.5f + r102));
        float r108 = Math.abs(r107) * 2.0f;
        float r109 = 1.0f - r108;
        r110.invoke(Float.valueOf(((r104 * 8.0f) * r106) / (1.25f - (r105 * r106))), Float.valueOf(((r107 * 8.0f) * r109) / (1.25f - (r108 * r109))));
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m4893setimpl(float[] r100, int r101, int r102, float r103) {
        r100[(r101 * 5) + r102] = r103;
    }

    /* JADX INFO: renamed from: setToScale-impl, reason: not valid java name */
    public static final void m4899setToScaleimpl(float[] r100, float r101, float r102, float r103, float r110) {
        if (r100.length >= 20) goto L5;
        return;
    L5:
        r100[0] = 1.0f;
        r100[1] = 0.0f;
        r100[2] = 0.0f;
        r100[3] = 0.0f;
        r100[4] = 0.0f;
        r100[5] = 0.0f;
        r100[6] = 1.0f;
        r100[7] = 0.0f;
        r100[8] = 0.0f;
        r100[9] = 0.0f;
        r100[10] = 0.0f;
        r100[11] = 0.0f;
        r100[12] = 1.0f;
        r100[13] = 0.0f;
        r100[14] = 0.0f;
        r100[15] = 0.0f;
        r100[16] = 0.0f;
        r100[17] = 0.0f;
        r100[18] = 1.0f;
        r100[19] = 0.0f;
        r100[0] = r101;
        r100[6] = r102;
        r100[12] = r103;
        r100[18] = r110;
    }
}
