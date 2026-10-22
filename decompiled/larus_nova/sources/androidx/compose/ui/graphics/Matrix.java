package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0086\n¢\u0006\u0004\b\r\u0010\u000eJ(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\tH\u0086\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001d¢\u0006\u0004\b\u001b\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u0010¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u0010¢\u0006\u0004\b+\u0010)J\u0015\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0000¢\u0006\u0004\b.\u0010\"J\u0015\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\t¢\u0006\u0004\b1\u00102J\u0015\u00103\u001a\u00020\u00102\u0006\u00100\u001a\u00020\t¢\u0006\u0004\b4\u00102J\u0015\u00105\u001a\u00020\u00102\u0006\u00100\u001a\u00020\t¢\u0006\u0004\b6\u00102J+\u00107\u001a\u00020\u00102\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\t2\b\b\u0002\u0010:\u001a\u00020\t¢\u0006\u0004\b;\u0010<J+\u0010=\u001a\u00020\u00102\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\t2\b\b\u0002\u0010:\u001a\u00020\t¢\u0006\u0004\b>\u0010<J{\u0010?\u001a\u00020\u00102\b\b\u0002\u0010@\u001a\u00020\t2\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010B\u001a\u00020\t2\b\b\u0002\u0010C\u001a\u00020\t2\b\b\u0002\u0010D\u001a\u00020\t2\b\b\u0002\u0010E\u001a\u00020\t2\b\b\u0002\u0010F\u001a\u00020\t2\b\b\u0002\u0010G\u001a\u00020\t2\b\b\u0002\u0010H\u001a\u00020\t2\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t¢\u0006\u0004\bK\u0010LJ\u0013\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010P\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006R"}, d2 = {"Landroidx/compose/ui/graphics/Matrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", MonitorConstants.CONNECT_TYPE_GET, "", SlcFlexDirection.FLEX_ROW, "", "column", "get-impl", "([FII)F", "set", "", BaseSwitches.V, "set-impl", "([FIIF)V", "map", "Landroidx/compose/ui/geometry/Offset;", "point", "map-MK-Hz9U", "([FJ)J", "Landroidx/compose/ui/geometry/Rect;", SVGRenderEngine.RECT, "map-impl", "([FLandroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/MutableRect;", "([FLandroidx/compose/ui/geometry/MutableRect;)V", "timesAssign", "m", "timesAssign-58bKbWc", "([F[F)V", "toString", "", "toString-impl", "([F)Ljava/lang/String;", "invert", "invert-impl", "([F)V", BasicTestActionHandler.TEST_ACTION_RESET, "reset-impl", "setFrom", "matrix", "setFrom-58bKbWc", "rotateX", "degrees", "rotateX-impl", "([FF)V", "rotateY", "rotateY-impl", "rotateZ", "rotateZ-impl", "scale", "x", "y", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "scale-impl", "([FFFF)V", "translate", "translate-impl", "resetToPivotedTransform", "pivotX", "pivotY", LiveDegradeFpsAnimator.TRANSLATION_X, LiveDegradeFpsAnimator.TRANSLATION_Y, "translationZ", "rotationX", "rotationY", "rotationZ", LiveDegradeFpsAnimator.SCALE_X, LiveDegradeFpsAnimator.SCALE_Y, "scaleZ", "resetToPivotedTransform-impl", "([FFFFFFFFFFFF)V", "equals", "", "other", "hashCode", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class Matrix {
    public static final Companion Companion = null;
    public static final int Perspective0 = 3;
    public static final int Perspective1 = 7;
    public static final int Perspective2 = 15;
    public static final int ScaleX = 0;
    public static final int ScaleY = 5;
    public static final int ScaleZ = 10;
    public static final int SkewX = 4;
    public static final int SkewY = 1;
    public static final int TranslateX = 12;
    public static final int TranslateY = 13;
    public static final int TranslateZ = 14;
    private final float[] values;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/graphics/Matrix$Companion;", "", "<init>", "()V", "ScaleX", "", "SkewY", "Perspective0", "SkewX", "ScaleY", "Perspective1", "ScaleZ", "TranslateX", "TranslateY", "TranslateZ", "Perspective2", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Matrix m5075boximpl(float[] r100) {
        return new Matrix(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float[] m5076constructorimpl(float[] r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5078equalsimpl(float[] r100, Object r101) {
        if ((r101 instanceof Matrix) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100, ((Matrix) r101).m5100unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5079equalsimpl0(float[] r100, float[] r101) {
        return Intrinsics.areEqual(r100, r101);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5081hashCodeimpl(float[] r100) {
        return Arrays.hashCode(r100);
    }

    public boolean equals(Object r100) {
        return m5078equalsimpl(this.values, r100);
    }

    public int hashCode() {
        return m5081hashCodeimpl(this.values);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float[] m5100unboximpl() {
        return this.values;
    }

    public String toString() {
        return m5097toStringimpl(this.values);
    }

    public final float[] getValues() {
        return this.values;
    }

    private /* synthetic */ Matrix(float[] r100) {
        this.values = r100;
    }

    /* JADX INFO: renamed from: invert-impl, reason: not valid java name */
    public static final void m5082invertimpl(float[] r410) {
        if (r410.length >= 16) goto L5;
        return;
    L5:
        float r100 = r410[0];
        float r101 = r410[1];
        float r102 = r410[2];
        float r103 = r410[3];
        float r110 = r410[4];
        float r111 = r410[5];
        float r112 = r410[6];
        float r113 = r410[7];
        float r114 = r410[8];
        float r115 = r410[9];
        float r210 = r410[10];
        float r211 = r410[11];
        float r116 = r410[12];
        float r212 = r410[13];
        float r213 = r410[14];
        float r214 = r410[15];
        float r310 = (r100 * r111) - (r101 * r110);
        float r311 = (r100 * r112) - (r102 * r110);
        float r312 = (r100 * r113) - (r103 * r110);
        float r313 = (r101 * r112) - (r102 * r111);
        float r314 = (r101 * r113) - (r103 * r111);
        float r315 = (r102 * r113) - (r103 * r112);
        float r316 = (r114 * r212) - (r115 * r116);
        float r317 = (r114 * r213) - (r210 * r116);
        float r318 = (r114 * r214) - (r211 * r116);
        float r319 = (r115 * r213) - (r210 * r212);
        float r411 = (r115 * r214) - (r211 * r212);
        float r412 = (r210 * r214) - (r211 * r213);
        float r413 = (((((r310 * r412) - (r311 * r411)) + (r312 * r319)) + (r313 * r318)) - (r314 * r317)) + (r315 * r316);
        if (r413 != 0.0f) goto L8;
        boolean r414 = true;
    L9:
        if (r414 == false) goto L11;
        return;
    L11:
        float r415 = 1.0f / r413;
        r410[0] = (((r111 * r412) - (r112 * r411)) + (r113 * r319)) * r415;
        r410[1] = ((((-r101) * r412) + (r102 * r411)) - (r103 * r319)) * r415;
        r410[2] = (((r212 * r315) - (r213 * r314)) + (r214 * r313)) * r415;
        r410[3] = ((((-r115) * r315) + (r210 * r314)) - (r211 * r313)) * r415;
        float r104 = -r110;
        r410[4] = (((r104 * r412) + (r112 * r318)) - (r113 * r317)) * r415;
        r410[5] = (((r412 * r100) - (r102 * r318)) + (r103 * r317)) * r415;
        float r105 = -r116;
        r410[6] = (((r105 * r315) + (r213 * r312)) - (r214 * r311)) * r415;
        r410[7] = (((r315 * r114) - (r210 * r312)) + (r211 * r311)) * r415;
        r410[8] = (((r110 * r411) - (r111 * r318)) + (r113 * r316)) * r415;
        r410[9] = ((((-r100) * r411) + (r318 * r101)) - (r103 * r316)) * r415;
        r410[10] = (((r116 * r314) - (r212 * r312)) + (r214 * r310)) * r415;
        r410[11] = ((((-r114) * r314) + (r312 * r115)) - (r211 * r310)) * r415;
        r410[12] = (((r104 * r319) + (r111 * r317)) - (r112 * r316)) * r415;
        r410[13] = (((r100 * r319) - (r101 * r317)) + (r102 * r316)) * r415;
        r410[14] = (((r105 * r313) + (r212 * r311)) - (r213 * r310)) * r415;
        r410[15] = (((r114 * r313) - (r115 * r311)) + (r210 * r310)) * r415;
        return;
    L8:
        r414 = false;
        goto L9
    }

    /* JADX INFO: renamed from: reset-impl, reason: not valid java name */
    public static final void m5086resetimpl(float[] r100) {
        if (r100.length >= 16) goto L5;
        return;
    L5:
        r100[0] = 1.0f;
        r100[1] = 0.0f;
        r100[2] = 0.0f;
        r100[3] = 0.0f;
        r100[4] = 0.0f;
        r100[5] = 1.0f;
        r100[6] = 0.0f;
        r100[7] = 0.0f;
        r100[8] = 0.0f;
        r100[9] = 0.0f;
        r100[10] = 1.0f;
        r100[11] = 0.0f;
        r100[12] = 0.0f;
        r100[13] = 0.0f;
        r100[14] = 0.0f;
        r100[15] = 1.0f;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5097toStringimpl(float[] r100) {
        return StringsKt.trimIndent("\n            |" + r100[0] + ' ' + r100[1] + ' ' + r100[2] + ' ' + r100[3] + "|\n            |" + r100[4] + ' ' + r100[5] + ' ' + r100[6] + ' ' + r100[7] + "|\n            |" + r100[8] + ' ' + r100[9] + ' ' + r100[10] + ' ' + r100[11] + "|\n            |" + r100[12] + ' ' + r100[13] + ' ' + r100[14] + ' ' + r100[15] + "|\n        ");
    }

    /* JADX INFO: renamed from: map-MK-Hz9U, reason: not valid java name */
    public static final long m5083mapMKHz9U(float[] r110, long r111) {
        if (r110.length >= 16) goto L5;
        return r111;
    L5:
        float r100 = r110[0];
        float r101 = r110[1];
        float r102 = r110[3];
        float r103 = r110[4];
        float r104 = r110[5];
        float r105 = r110[7];
        float r106 = r110[12];
        float r112 = r110[13];
        float r107 = r110[15];
        float r113 = Float.intBitsToFloat((int) (r111 >> 32));
        float r108 = Float.intBitsToFloat((int) (r111 & BodyPartID.bodyIdMax));
        float r109 = 1 / (((r102 * r113) + (r105 * r108)) + r107);
        if ((Float.floatToRawIntBits(r109) & Integer.MAX_VALUE) >= 2139095040) goto L8;
        boolean r114 = true;
    L9:
        if (r114 == true) goto L12;
        r109 = 0.0f;
    L12:
        float r115 = (((r100 * r113) + (r103 * r108)) + r106) * r109;
        float r116 = r109 * (((r101 * r113) + (r104 * r108)) + r112);
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r115) << 32) | (Float.floatToRawIntBits(r116) & BodyPartID.bodyIdMax));
    L8:
        r114 = false;
        goto L9
    }

    /* JADX INFO: renamed from: map-impl, reason: not valid java name */
    public static final void m5085mapimpl(float[] r210, MutableRect r211) {
        if (r210.length >= 16) goto L5;
        return;
    L5:
        float r100 = r210[0];
        float r101 = r210[1];
        float r102 = r210[3];
        float r103 = r210[4];
        float r104 = r210[5];
        float r105 = r210[7];
        float r110 = r210[12];
        float r111 = r210[13];
        float r106 = r210[15];
        float r112 = r211.getLeft();
        float r113 = r211.getTop();
        float r114 = r211.getRight();
        float r115 = r211.getBottom();
        float r116 = r102 * r112;
        float r117 = r105 * r113;
        float r118 = 1.0f / ((r116 + r117) + r106);
        if ((Float.floatToRawIntBits(r118) & Integer.MAX_VALUE) >= 2139095040) goto L8;
        boolean r107 = true;
    L9:
        float r212 = 0.0f;
        if (r107 == true) goto L13;
        r118 = 0.0f;
    L13:
        float r108 = r100 * r112;
        float r213 = r103 * r113;
        float r109 = r118 * ((r108 + r213) + r110);
        float r119 = r112 * r101;
        float r120 = r113 * r104;
        float r121 = r118 * ((r119 + r120) + r111);
        float r122 = r105 * r115;
        float r123 = 1.0f / ((r116 + r122) + r106);
        if ((Float.floatToRawIntBits(r123) & Integer.MAX_VALUE) >= 2139095040) goto L16;
        boolean r124 = true;
    L17:
        if (r124 == true) goto L20;
        r123 = 0.0f;
    L20:
        float r125 = r103 * r115;
        float r126 = ((r108 + r125) + r110) * r123;
        float r127 = r104 * r115;
        float r128 = r123 * ((r119 + r127) + r111);
        float r129 = r102 * r114;
        float r130 = 1.0f / ((r129 + r117) + r106);
        if ((Float.floatToRawIntBits(r130) & Integer.MAX_VALUE) >= 2139095040) goto L23;
        boolean r131 = true;
    L24:
        if (r131 == true) goto L27;
        r130 = 0.0f;
    L27:
        float r132 = r100 * r114;
        float r133 = r130 * ((r132 + r213) + r110);
        float r134 = r101 * r114;
        float r135 = r130 * ((r120 + r134) + r111);
        float r136 = 1.0f / ((r129 + r122) + r106);
        if ((Float.floatToRawIntBits(r136) & Integer.MAX_VALUE) >= 2139095040) goto L30;
        boolean r214 = true;
    L31:
        if (r214 == false) goto L33;
        r212 = r136;
    L33:
        float r137 = ((r132 + r125) + r110) * r212;
        float r138 = r212 * ((r134 + r127) + r111);
        r211.setLeft(Math.min(r109, Math.min(r126, Math.min(r133, r137))));
        r211.setTop(Math.min(r121, Math.min(r128, Math.min(r135, r138))));
        r211.setRight(Math.max(r109, Math.max(r126, Math.max(r133, r137))));
        r211.setBottom(Math.max(r121, Math.max(r128, Math.max(r135, r138))));
        return;
    L30:
        r214 = false;
        goto L31
    L23:
        r131 = false;
        goto L24
    L16:
        r124 = false;
        goto L17
    L8:
        r107 = false;
        goto L9
    }

    /* JADX INFO: renamed from: rotateX-impl, reason: not valid java name */
    public static final void m5089rotateXimpl(float[] r210, float r211) {
        if (r210.length >= 16) goto L5;
        return;
    L5:
        double r100 = ((double) r211) * 0.017453292519943295d;
        float r101 = (float) Math.sin(r100);
        float r102 = (float) Math.cos(r100);
        float r103 = r210[1];
        float r104 = r210[2];
        float r105 = (r103 * r102) - (r104 * r101);
        float r106 = r210[5];
        float r110 = r210[6];
        float r111 = (r106 * r102) - (r110 * r101);
        float r112 = r210[9];
        float r113 = r210[10];
        float r114 = (r112 * r102) - (r113 * r101);
        float r115 = r210[13];
        float r116 = r210[14];
        float r117 = (r115 * r102) - (r116 * r101);
        r210[1] = r105;
        r210[2] = (r103 * r101) + (r104 * r102);
        r210[5] = r111;
        r210[6] = (r106 * r101) + (r110 * r102);
        r210[9] = r114;
        r210[10] = (r112 * r101) + (r113 * r102);
        r210[13] = r117;
        r210[14] = (r115 * r101) + (r116 * r102);
    }

    /* JADX INFO: renamed from: rotateY-impl, reason: not valid java name */
    public static final void m5090rotateYimpl(float[] r210, float r211) {
        if (r210.length >= 16) goto L5;
        return;
    L5:
        double r100 = ((double) r211) * 0.017453292519943295d;
        float r101 = (float) Math.sin(r100);
        float r102 = (float) Math.cos(r100);
        float r103 = r210[0];
        float r104 = r210[2];
        float r105 = (r103 * r102) + (r104 * r101);
        float r106 = r210[4];
        float r110 = r210[6];
        float r111 = (r106 * r102) + (r110 * r101);
        float r112 = r210[8];
        float r113 = r210[10];
        float r114 = (r112 * r102) + (r113 * r101);
        float r115 = r210[12];
        float r116 = r210[14];
        float r117 = (r115 * r102) + (r116 * r101);
        r210[0] = r105;
        r210[2] = ((-r103) * r101) + (r104 * r102);
        r210[4] = r111;
        r210[6] = ((-r106) * r101) + (r110 * r102);
        r210[8] = r114;
        r210[10] = ((-r112) * r101) + (r113 * r102);
        r210[12] = r117;
        r210[14] = ((-r115) * r101) + (r116 * r102);
    }

    /* JADX INFO: renamed from: rotateZ-impl, reason: not valid java name */
    public static final void m5091rotateZimpl(float[] r210, float r211) {
        if (r210.length >= 16) goto L5;
        return;
    L5:
        double r100 = ((double) r211) * 0.017453292519943295d;
        float r101 = (float) Math.sin(r100);
        float r102 = (float) Math.cos(r100);
        float r103 = r210[0];
        float r104 = r210[4];
        float r105 = (r102 * r103) + (r101 * r104);
        float r106 = -r101;
        float r107 = (r103 * r106) + (r104 * r102);
        float r108 = r210[1];
        float r110 = r210[5];
        float r111 = (r102 * r108) + (r101 * r110);
        float r109 = (r108 * r106) + (r110 * r102);
        float r112 = r210[2];
        float r113 = r210[6];
        float r114 = (r102 * r112) + (r101 * r113);
        float r115 = (r112 * r106) + (r113 * r102);
        float r116 = r210[3];
        float r117 = r210[7];
        float r212 = (r102 * r116) + (r101 * r117);
        r210[0] = r105;
        r210[1] = r111;
        r210[2] = r114;
        r210[3] = r212;
        r210[4] = r107;
        r210[5] = r109;
        r210[6] = r115;
        r210[7] = (r106 * r116) + (r102 * r117);
    }

    /* JADX INFO: renamed from: setFrom-58bKbWc, reason: not valid java name */
    public static final void m5095setFrom58bKbWc(float[] r100, float[] r101) {
        if (r100.length >= 16) goto L6;
        return;
    L6:
        if (r101.length >= 16) goto L8;
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
    }

    /* JADX INFO: renamed from: timesAssign-58bKbWc, reason: not valid java name */
    public static final void m5096timesAssign58bKbWc(float[] r410, float[] r510) {
        if (r410.length >= 16) goto L6;
        return;
    L6:
        if (r510.length >= 16) goto L8;
        return;
    L8:
        float r100 = r410[0];
        float r101 = r510[0];
        float r102 = r410[1];
        float r103 = r510[4];
        float r110 = r410[2];
        float r111 = r510[8];
        float r112 = r410[3];
        float r113 = r510[12];
        float r104 = (((r100 * r101) + (r102 * r103)) + (r110 * r111)) + (r112 * r113);
        float r114 = r510[1];
        float r210 = r510[5];
        float r211 = r510[9];
        float r212 = r510[13];
        float r115 = (((r100 * r114) + (r102 * r210)) + (r110 * r211)) + (r112 * r212);
        float r213 = r510[2];
        float r214 = r510[6];
        float r310 = r510[10];
        float r311 = r510[14];
        float r215 = (((r100 * r213) + (r102 * r214)) + (r110 * r310)) + (r112 * r311);
        float r312 = r510[3];
        float r313 = r510[7];
        float r314 = r510[11];
        float r105 = r510[15];
        float r106 = (((r100 * r312) + (r102 * r313)) + (r110 * r314)) + (r112 * r105);
        float r116 = r410[4];
        float r315 = r410[5];
        float r316 = (r116 * r101) + (r315 * r103);
        float r411 = r410[6];
        float r317 = r316 + (r411 * r111);
        float r412 = r410[7];
        float r318 = r317 + (r412 * r113);
        float r413 = (((r116 * r114) + (r315 * r210)) + (r411 * r211)) + (r412 * r212);
        float r414 = (((r116 * r213) + (r315 * r214)) + (r411 * r310)) + (r412 * r311);
        float r117 = (((r116 * r312) + (r315 * r313)) + (r411 * r314)) + (r412 * r105);
        float r319 = r410[8];
        float r415 = r410[9];
        float r416 = (r319 * r101) + (r415 * r103);
        float r417 = r410[10];
        float r418 = r416 + (r417 * r111);
        float r419 = r410[11];
        float r420 = r418 + (r419 * r113);
        float r421 = (((r319 * r114) + (r415 * r210)) + (r417 * r211)) + (r419 * r212);
        float r422 = (((r319 * r213) + (r415 * r214)) + (r417 * r310)) + (r419 * r311);
        float r320 = (((r319 * r312) + (r415 * r313)) + (r417 * r314)) + (r419 * r105);
        float r423 = r410[12];
        float r424 = r410[13];
        float r107 = (r101 * r423) + (r103 * r424);
        float r108 = r410[14];
        float r109 = r107 + (r111 * r108);
        float r118 = r410[15];
        float r119 = r109 + (r113 * r118);
        float r120 = (((r114 * r423) + (r210 * r424)) + (r211 * r108)) + (r212 * r118);
        float r216 = (((r213 * r423) + (r214 * r424)) + (r310 * r108)) + (r311 * r118);
        r410[0] = r104;
        r410[1] = r115;
        r410[2] = r215;
        r410[3] = r106;
        r410[4] = r318;
        r410[5] = r413;
        r410[6] = r414;
        r410[7] = r117;
        r410[8] = r420;
        r410[9] = r421;
        r410[10] = r422;
        r410[11] = r320;
        r410[12] = r119;
        r410[13] = r120;
        r410[14] = r216;
        r410[15] = (((r423 * r312) + (r424 * r313)) + (r108 * r314)) + (r118 * r105);
    }

    /* JADX INFO: renamed from: map-impl, reason: not valid java name */
    public static final Rect m5084mapimpl(float[] r210, Rect r211) {
        if (r210.length >= 16) goto L5;
        return r211;
    L5:
        float r100 = r210[0];
        float r101 = r210[1];
        float r102 = r210[3];
        float r103 = r210[4];
        float r104 = r210[5];
        float r105 = r210[7];
        float r106 = r210[12];
        float r110 = r210[13];
        float r107 = r210[15];
        float r111 = r211.getLeft();
        float r112 = r211.getTop();
        float r113 = r211.getRight();
        float r114 = r211.getBottom();
        float r115 = r102 * r111;
        float r116 = r105 * r112;
        float r117 = 1.0f / ((r115 + r116) + r107);
        if ((Float.floatToRawIntBits(r117) & Integer.MAX_VALUE) >= 2139095040) goto L8;
        boolean r108 = true;
    L9:
        float r212 = 0.0f;
        if (r108 == true) goto L13;
        r117 = 0.0f;
    L13:
        float r109 = r100 * r111;
        float r213 = r103 * r112;
        float r118 = r117 * ((r109 + r213) + r106);
        float r119 = r111 * r101;
        float r120 = r112 * r104;
        float r121 = r117 * ((r119 + r120) + r110);
        float r122 = r105 * r114;
        float r123 = 1.0f / ((r115 + r122) + r107);
        if ((Float.floatToRawIntBits(r123) & Integer.MAX_VALUE) >= 2139095040) goto L16;
        boolean r124 = true;
    L17:
        if (r124 == false) goto L19;
        float r125 = r123;
    L20:
        float r126 = r103 * r114;
        float r127 = ((r109 + r126) + r106) * r125;
        float r128 = r104 * r114;
        float r129 = r125 * ((r119 + r128) + r110);
        float r130 = r102 * r113;
        float r131 = 1.0f / ((r130 + r116) + r107);
        if ((Float.floatToRawIntBits(r131) & Integer.MAX_VALUE) >= 2139095040) goto L23;
        boolean r132 = true;
    L24:
        if (r132 == true) goto L27;
        r131 = 0.0f;
    L27:
        float r133 = r100 * r113;
        float r134 = r131 * ((r133 + r213) + r106);
        float r135 = r101 * r113;
        float r136 = r131 * ((r120 + r135) + r110);
        float r137 = 1.0f / ((r130 + r122) + r107);
        if ((Float.floatToRawIntBits(r137) & Integer.MAX_VALUE) >= 2139095040) goto L30;
        boolean r138 = true;
    L31:
        if (r138 == false) goto L33;
        r212 = r137;
    L33:
        float r139 = ((r133 + r126) + r106) * r212;
        float r140 = r212 * ((r135 + r128) + r110);
        return new Rect(Math.min(r118, Math.min(r127, Math.min(r134, r139))), Math.min(r121, Math.min(r129, Math.min(r136, r140))), Math.max(r118, Math.max(r127, Math.max(r134, r139))), Math.max(r121, Math.max(r129, Math.max(r136, r140))));
    L30:
        r138 = false;
        goto L31
    L23:
        r132 = false;
        goto L24
    L19:
        r125 = 0.0f;
        goto L20
    L16:
        r124 = false;
        goto L17
    L8:
        r108 = false;
        goto L9
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ float[] m5077constructorimpl$default(float[] r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L6;
        r100 = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    L6:
        return m5076constructorimpl(r100);
    }

    /* JADX INFO: renamed from: get-impl, reason: not valid java name */
    public static final float m5080getimpl(float[] r100, int r101, int r102) {
        return r100[(r101 * 4) + r102];
    }

    /* JADX INFO: renamed from: scale-impl, reason: not valid java name */
    public static final void m5092scaleimpl(float[] r100, float r101, float r102, float r103) {
        if (r100.length >= 16) goto L5;
        return;
    L5:
        r100[0] = r100[0] * r101;
        r100[1] = r100[1] * r101;
        r100[2] = r100[2] * r101;
        r100[3] = r100[3] * r101;
        r100[4] = r100[4] * r102;
        r100[5] = r100[5] * r102;
        r100[6] = r100[6] * r102;
        r100[7] = r100[7] * r102;
        r100[8] = r100[8] * r103;
        r100[9] = r100[9] * r103;
        r100[10] = r100[10] * r103;
        r100[11] = r100[11] * r103;
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m5094setimpl(float[] r100, int r101, int r102, float r103) {
        r100[(r101 * 4) + r102] = r103;
    }

    /* JADX INFO: renamed from: translate-impl, reason: not valid java name */
    public static final void m5098translateimpl(float[] r100, float r101, float r102, float r110) {
        if (r100.length >= 16) goto L5;
        return;
    L5:
        float r103 = (((r100[0] * r101) + (r100[4] * r102)) + (r100[8] * r110)) + r100[12];
        float r104 = (((r100[1] * r101) + (r100[5] * r102)) + (r100[9] * r110)) + r100[13];
        float r105 = (((r100[2] * r101) + (r100[6] * r102)) + (r100[10] * r110)) + r100[14];
        float r106 = (((r100[3] * r101) + (r100[7] * r102)) + (r100[11] * r110)) + r100[15];
        r100[12] = r103;
        r100[13] = r104;
        r100[14] = r105;
        r100[15] = r106;
    }

    /* JADX INFO: renamed from: scale-impl$default, reason: not valid java name */
    public static /* synthetic */ void m5093scaleimpl$default(float[] r100, float r101, float r102, float r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = 1.0f;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = 1.0f;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = 1.0f;
    L11:
        m5092scaleimpl(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: translate-impl$default, reason: not valid java name */
    public static /* synthetic */ void m5099translateimpl$default(float[] r100, float r101, float r102, float r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = 0.0f;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = 0.0f;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = 0.0f;
    L11:
        m5098translateimpl(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: resetToPivotedTransform-impl, reason: not valid java name */
    public static final void m5087resetToPivotedTransformimpl(float[] r110, float r111, float r210, float r211, float r212, float r213, float r214, float r215, float r216, float r217, float r218, float r219) {
        double r100 = ((double) r214) * 0.017453292519943295d;
        float r101 = (float) Math.sin(r100);
        float r102 = (float) Math.cos(r100);
        float r103 = -r101;
        float r104 = (r212 * r102) - (r213 * r101);
        float r105 = (r212 * r101) + (r213 * r102);
        double r112 = ((double) r215) * 0.017453292519943295d;
        float r113 = (float) Math.sin(r112);
        float r114 = (float) Math.cos(r112);
        float r115 = -r113;
        float r116 = r101 * r113;
        float r106 = r101 * r114;
        float r117 = r102 * r113;
        float r118 = r102 * r114;
        float r119 = (r211 * r114) + (r105 * r113);
        float r107 = ((-r211) * r113) + (r105 * r114);
        double r108 = ((double) r216) * 0.017453292519943295d;
        float r109 = (float) Math.sin(r108);
        float r120 = (float) Math.cos(r108);
        float r121 = -r109;
        float r122 = (r121 * r114) + (r120 * r116);
        float r123 = (r114 * r120) + (r116 * r109);
        float r124 = r109 * r102;
        float r125 = r102 * r120;
        float r126 = (r121 * r115) + (r120 * r106);
        float r127 = r123 * r217;
        float r128 = r124 * r217;
        float r129 = ((r120 * r115) + (r109 * r106)) * r217;
        float r130 = r122 * r218;
        float r131 = r125 * r218;
        float r132 = r126 * r218;
        float r133 = r117 * r219;
        float r134 = r103 * r219;
        float r135 = r118 * r219;
        if (r110.length >= 16) goto L5;
        return;
    L5:
        r110[0] = r127;
        r110[1] = r128;
        r110[2] = r129;
        r110[3] = 0.0f;
        r110[4] = r130;
        r110[5] = r131;
        r110[6] = r132;
        r110[7] = 0.0f;
        r110[8] = r133;
        r110[9] = r134;
        r110[10] = r135;
        r110[11] = 0.0f;
        float r136 = -r111;
        r110[12] = (((r127 * r136) - (r210 * r130)) + r119) + r111;
        r110[13] = (((r128 * r136) - (r210 * r131)) + r104) + r210;
        r110[14] = ((r136 * r129) - (r210 * r132)) + r107;
        r110[15] = 1.0f;
    }

    /* JADX INFO: renamed from: resetToPivotedTransform-impl$default, reason: not valid java name */
    public static /* synthetic */ void m5088resetToPivotedTransformimpl$default(float[] r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107, float r108, float r110, float r111, float r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = 0.0f;
    L6:
        if ((r113 & 2) == 0) goto L9;
        r102 = 0.0f;
    L9:
        if ((r113 & 4) == 0) goto L12;
        r103 = 0.0f;
    L12:
        if ((r113 & 8) == 0) goto L15;
        r104 = 0.0f;
    L15:
        if ((r113 & 16) == 0) goto L18;
        r105 = 0.0f;
    L18:
        if ((r113 & 32) == 0) goto L21;
        r106 = 0.0f;
    L21:
        if ((r113 & 64) == 0) goto L24;
        r107 = 0.0f;
    L24:
        if ((r113 & 128) == 0) goto L27;
        r108 = 0.0f;
    L27:
        if ((r113 & 256) == 0) goto L30;
        r110 = 1.0f;
    L30:
        if ((r113 & 512) == 0) goto L33;
        r111 = 1.0f;
    L33:
        if ((r113 & 1024) == 0) goto L35;
        r112 = 1.0f;
    L35:
        m5087resetToPivotedTransformimpl(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112);
    }
}
