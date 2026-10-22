package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\u001f\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u000e\u001a\u00020\u0003*\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001b\u0010\u0013\u001a\u00020\u0003*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010\u001e\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0013\u001a\u00020\u0003*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"ceilAwayFromZero", "", "composeToViewOffset", "", "offset", "reverseAxis", "toViewVelocity", "toOffset", "Landroidx/compose/ui/geometry/Offset;", "consumed", "", "available", "toOffset-Uv8p0NA", "([IJ)J", "toViewType", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "toViewType-GyEprt8", "(I)I", "ScrollingAxesThreshold", "scrollAxes", "getScrollAxes-k-4lQ0M", "(J)I", "Landroidx/compose/ui/unit/Velocity;", "minFlingVelocity", "scrollAxes-sF-c-tU", "(JF)I", "rememberNestedScrollInteropConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "hostView", "Landroid/view/View;", "(Landroid/view/View;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NestedScrollInteropConnectionKt {
    private static final float ScrollingAxesThreshold = 0.5f;

    private static final float reverseAxis(int r100) {
        return r100 * (-1.0f);
    }

    private static final float toViewVelocity(float r100) {
        return r100 * (-1.0f);
    }

    /* JADX INFO: renamed from: access$getScrollAxes-k-4lQ0M, reason: not valid java name */
    public static final /* synthetic */ int m6731access$getScrollAxesk4lQ0M(long r100) {
        return m6734getScrollAxesk4lQ0M(r100);
    }

    /* JADX INFO: renamed from: access$toViewType-GyEprt8, reason: not valid java name */
    public static final /* synthetic */ int m6733access$toViewTypeGyEprt8(int r100) {
        return m6737toViewTypeGyEprt8(r100);
    }

    public static final /* synthetic */ float access$toViewVelocity(float r100) {
        return toViewVelocity(r100);
    }

    private static final float ceilAwayFromZero(float r100) {
        if (r100 < 0.0f) goto L5;
        double r101 = Math.ceil(r100);
    L7:
        return (float) r101;
    L5:
        r101 = Math.floor(r100);
        goto L7
    }

    public static final int composeToViewOffset(float r100) {
        return ((int) ceilAwayFromZero(r100)) * (-1);
    }

    /* JADX INFO: renamed from: getScrollAxes-k-4lQ0M, reason: not valid java name */
    private static final int m6734getScrollAxesk4lQ0M(long r100) {
        if (Math.abs(Float.intBitsToFloat((int) (r100 >> 32))) < 0.5f) goto L5;
        int r101 = 1;
    L7:
        if (Math.abs(Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax))) >= 0.5f) goto L9;
        return r101;
    L9:
        return r101 | 2;
    L5:
        r101 = 0;
        goto L7
    }

    /* JADX INFO: renamed from: toViewType-GyEprt8, reason: not valid java name */
    private static final int m6737toViewTypeGyEprt8(int r100) {
        return !NestedScrollSource.m6006equalsimpl0(r100, NestedScrollSource.Companion.m6018getUserInputWNlRxjI()) ? 1 : 0;
    }

    /* JADX INFO: renamed from: access$toOffset-Uv8p0NA, reason: not valid java name */
    public static final /* synthetic */ long m6732access$toOffsetUv8p0NA(int[] r100, long r101) {
        return m6736toOffsetUv8p0NA(r100, r101);
    }

    /* JADX INFO: renamed from: scrollAxes-sF-c-tU, reason: not valid java name */
    private static final int m6735scrollAxessFctU(long r100, float r101) {
        if (Math.abs(Velocity.m7786getXimpl(r100)) < r101) goto L5;
        int r102 = 1;
    L7:
        if (Math.abs(Velocity.m7787getYimpl(r100)) >= r101) goto L9;
        return r102;
    L9:
        return r102 | 2;
    L5:
        r102 = 0;
        goto L7
    }

    /* JADX INFO: renamed from: toOffset-Uv8p0NA, reason: not valid java name */
    private static final long m6736toOffsetUv8p0NA(int[] r100, long r101) {
        int r102 = (int) (r101 >> 32);
        if (Float.intBitsToFloat(r102) < 0.0f) goto L5;
        float r103 = RangesKt.coerceAtMost(reverseAxis(r100[0]), Float.intBitsToFloat(r102));
    L6:
        int r104 = (int) (r101 & BodyPartID.bodyIdMax);
        if (Float.intBitsToFloat(r104) < 0.0f) goto L9;
        float r105 = RangesKt.coerceAtMost(reverseAxis(r100[1]), Float.intBitsToFloat(r104));
    L11:
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r103) << 32) | (Float.floatToRawIntBits(r105) & BodyPartID.bodyIdMax));
    L9:
        r105 = RangesKt.coerceAtLeast(reverseAxis(r100[1]), Float.intBitsToFloat(r104));
        goto L11
    L5:
        r103 = RangesKt.coerceAtLeast(reverseAxis(r100[0]), Float.intBitsToFloat(r102));
        goto L6
    }

    public static final NestedScrollConnection rememberNestedScrollInteropConnection(View r100, Composer r101, int r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = (View) r101.consume(AndroidCompositionLocals_androidKt.getLocalView());
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(1075877987, r102, -1, "androidx.compose.ui.platform.rememberNestedScrollInteropConnection (NestedScrollInteropConnection.android.kt:354)");
    L8:
        ViewConfiguration r104 = (ViewConfiguration) r101.consume(CompositionLocalsKt.getLocalViewConfiguration());
        boolean r105 = r101.changed(r100) | r101.changed(r104);
        Object r106 = r101.rememberedValue();
        if (r105 == true) goto L13;
        if (r106 == Composer.Companion.getEmpty()) goto L13;
    L17:
        NestedScrollConnection r107 = (NestedScrollConnection) r106;
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventEnd();
    L20:
        return r107;
    L13:
        if (ComposeUiFlags.isNestedScrollInteropPostFlingFixEnabled == false) goto L15;
        r106 = new NestedScrollInteropConnection(r100, r104.getMinimumFlingVelocity());
    L16:
        r101.updateRememberedValue(r106);
        goto L17
    L15:
        r106 = new LegacyNestedScrollInteropConnection(r100);
        goto L16
    }
}
