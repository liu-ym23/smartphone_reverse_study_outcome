package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\u001f\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u000e\u001a\u00020\u0003*\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001b\u0010\u0013\u001a\u00020\u0003*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010\u001e\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0013\u001a\u00020\u0003*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"ceilAwayFromZero", "", "composeToViewOffset", "", TypedValues.CycleType.S_WAVE_OFFSET, "reverseAxis", "toViewVelocity", "toOffset", "Landroidx/compose/ui/geometry/Offset;", "consumed", "", "available", "toOffset-Uv8p0NA", "([IJ)J", "toViewType", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "toViewType-GyEprt8", "(I)I", "ScrollingAxesThreshold", "scrollAxes", "getScrollAxes-k-4lQ0M", "(J)I", "Landroidx/compose/ui/unit/Velocity;", "minFlingVelocity", "scrollAxes-sF-c-tU", "(JF)I", "rememberNestedScrollInteropConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "hostView", "Landroid/view/View;", "(Landroid/view/View;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NestedScrollInteropConnectionKt {
    private static final float ScrollingAxesThreshold = 0.5f;

    private static final float ceilAwayFromZero(float f) {
        return (float) (f >= 0.0f ? Math.ceil(f) : Math.floor(f));
    }

    public static final int composeToViewOffset(float f) {
        return ((int) ceilAwayFromZero(f)) * (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getScrollAxes-k-4lQ0M, reason: not valid java name */
    public static final int m6044getScrollAxesk4lQ0M(long j5) {
        int i = Math.abs(Float.intBitsToFloat((int) (j5 >> 32))) >= 0.5f ? 1 : 0;
        return Math.abs(Float.intBitsToFloat((int) (j5 & 4294967295L))) >= 0.5f ? i | 2 : i;
    }

    @Composable
    public static final NestedScrollConnection rememberNestedScrollInteropConnection(View view, Composer composer, int i, int i6) {
        if ((i6 & 1) != 0) {
            view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1075877987, i, -1, "androidx.compose.ui.platform.rememberNestedScrollInteropConnection (NestedScrollInteropConnection.android.kt:354)");
        }
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        boolean zChanged = composer.changed(view) | composer.changed(viewConfiguration);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = ComposeUiFlags.isNestedScrollInteropPostFlingFixEnabled ? new NestedScrollInteropConnection(view, viewConfiguration.getMinimumFlingVelocity()) : new LegacyNestedScrollInteropConnection(view);
            composer.updateRememberedValue(objRememberedValue);
        }
        NestedScrollConnection nestedScrollConnection = (NestedScrollConnection) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return nestedScrollConnection;
    }

    private static final float reverseAxis(int i) {
        return i * (-1.0f);
    }

    /* renamed from: scrollAxes-sF-c-tU, reason: not valid java name */
    private static final int m6045scrollAxessFctU(long j5, float f) {
        int i = Math.abs(Velocity.m7082getXimpl(j5)) >= f ? 1 : 0;
        return Math.abs(Velocity.m7083getYimpl(j5)) >= f ? i | 2 : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c A[PHI: r7
      0x004c: PHI (r7v6 float) = (r7v3 float), (r7v7 float) binds: [B:16:0x005a, B:13:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001d A[PHI: r1
      0x001d: PHI (r1v5 float) = (r1v2 float), (r1v6 float) binds: [B:8:0x002b, B:5:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: toOffset-Uv8p0NA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long m6046toOffsetUv8p0NA(int[] r6, long r7) {
        /*
            r0 = 32
            long r1 = r7 >> r0
            int r1 = (int) r1
            float r2 = java.lang.Float.intBitsToFloat(r1)
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            r4 = 0
            if (r2 < 0) goto L1f
            r2 = r6[r4]
            float r2 = reverseAxis(r2)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L2e
        L1d:
            r2 = r1
            goto L2e
        L1f:
            r2 = r6[r4]
            float r2 = reverseAxis(r2)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 >= 0) goto L2e
            goto L1d
        L2e:
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r7 = r7 & r4
            int r7 = (int) r7
            float r8 = java.lang.Float.intBitsToFloat(r7)
            int r8 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            r1 = 1
            if (r8 < 0) goto L4e
            r6 = r6[r1]
            float r6 = reverseAxis(r6)
            float r7 = java.lang.Float.intBitsToFloat(r7)
            int r8 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r8 <= 0) goto L5d
        L4c:
            r6 = r7
            goto L5d
        L4e:
            r6 = r6[r1]
            float r6 = reverseAxis(r6)
            float r7 = java.lang.Float.intBitsToFloat(r7)
            int r8 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r8 >= 0) goto L5d
            goto L4c
        L5d:
            int r7 = java.lang.Float.floatToRawIntBits(r2)
            long r7 = (long) r7
            int r6 = java.lang.Float.floatToRawIntBits(r6)
            long r1 = (long) r6
            long r6 = r7 << r0
            long r0 = r1 & r4
            long r6 = r6 | r0
            long r6 = androidx.compose.ui.geometry.Offset.m3887constructorimpl(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.NestedScrollInteropConnectionKt.m6046toOffsetUv8p0NA(int[], long):long");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toViewType-GyEprt8, reason: not valid java name */
    public static final int m6047toViewTypeGyEprt8(int i) {
        return !NestedScrollSource.m5300equalsimpl0(i, NestedScrollSource.INSTANCE.m5312getUserInputWNlRxjI()) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float toViewVelocity(float f) {
        return f * (-1.0f);
    }
}
