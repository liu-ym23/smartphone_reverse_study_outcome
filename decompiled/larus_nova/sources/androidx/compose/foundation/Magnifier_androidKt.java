package androidx.compose.foundation;

import android.os.Build;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0091\u0001\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\b\u000b2\u001b\b\u0002\u0010\f\u001a\u0015\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0002\b\u000b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019\u001a©\u0001\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\b\u000b2\u001b\b\u0002\u0010\f\u001a\u0015\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0002\b\u000b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00172\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u00172\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0012\u0010 \u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\"H\u0001\u001a\u0014\u0010#\u001a\u00020\u0017*\u00020\u00112\u0006\u0010$\u001a\u00020\u0011H\u0000\" \u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006%"}, d2 = {"MagnifierPositionInRoot", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Offset;", "getMagnifierPositionInRoot", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "magnifier", "Landroidx/compose/ui/Modifier;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", GestureAction.zoom, "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clip", "", "magnifier-UpNRX3w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FJFFZ)Landroidx/compose/ui/Modifier;", "useTextDefault", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "magnifier-jPUL71Q", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;)Landroidx/compose/ui/Modifier;", "isPlatformMagnifierSupported", com.heytap.mcssdk.constant.b.C, "", "equalsIncludingNaN", "other", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Magnifier_androidKt {
    private static final SemanticsPropertyKey<Function0<Offset>> MagnifierPositionInRoot = null;

    public static final boolean isPlatformMagnifierSupported(int r100) {
        if (r100 < 28) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        MagnifierPositionInRoot = new SemanticsPropertyKey("MagnifierPositionInRoot", null, 2, null);
    }

    public static final SemanticsPropertyKey<Function0<Offset>> getMagnifierPositionInRoot() {
        return MagnifierPositionInRoot;
    }

    public static final boolean equalsIncludingNaN(float r100, float r101) {
        if (Float.isNaN(r100) == false) goto L8;
        if (Float.isNaN(r101) == false) goto L8;
        return true;
    L8:
        if (r100 == r101) goto L12;
        return false;
    L12:
        return true;
    }

    public static /* synthetic */ boolean isPlatformMagnifierSupported$default(int r100, int r101, Object r102) {
        if ((r101 & 1) == 0) goto L6;
        r100 = Build.VERSION.SDK_INT;
    L6:
        return isPlatformMagnifierSupported(r100);
    }

    /* JADX INFO: renamed from: magnifier-UpNRX3w, reason: not valid java name */
    public static final Modifier m298magnifierUpNRX3w(Modifier r110, Function1<? super Density, Offset> r111, Function1<? super Density, Offset> r112, Function1<? super DpSize, Unit> r113, float r114, long r115, float r210, float r211, boolean r212) {
        return m301magnifierjPUL71Q$default(r110, r111, r112, r113, r114, false, r115, r210, r211, r212, null, 512, null);
    }

    /* JADX INFO: renamed from: magnifier-UpNRX3w$default, reason: not valid java name */
    public static /* synthetic */ Modifier m299magnifierUpNRX3w$default(Modifier r100, Function1 r101, Function1 r110, Function1 r111, float r112, long r113, float r114, float r115, boolean r116, int r117, Object r118) {
        Function1 r102 = null;
        if ((r117 & 2) == 0) goto L5;
        Function1 r103 = null;
    L7:
        if ((r117 & 4) != 0) goto L11;
        r102 = r111;
    L11:
        if ((r117 & 8) == 0) goto L13;
        float r104 = Float.NaN;
    L15:
        if ((r117 & 16) == 0) goto L17;
        long r105 = DpSize.Companion.m7651getUnspecifiedMYxV2XQ();
    L19:
        if ((r117 & 32) == 0) goto L21;
        float r106 = Dp.Companion.m7564getUnspecifiedD9Ej5fM();
    L23:
        if ((r117 & 64) == 0) goto L25;
        float r107 = Dp.Companion.m7564getUnspecifiedD9Ej5fM();
    L27:
        if ((r117 & 128) == 0) goto L29;
        boolean r108 = true;
    L31:
        return m298magnifierUpNRX3w(r100, r101, r103, r102, r104, r105, r106, r107, r108);
    L29:
        r108 = r116;
        goto L31
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L5:
        r103 = r110;
        goto L7
    }

    /* JADX INFO: renamed from: magnifier-jPUL71Q, reason: not valid java name */
    public static final Modifier m300magnifierjPUL71Q(Modifier r110, Function1<? super Density, Offset> r111, Function1<? super Density, Offset> r112, Function1<? super DpSize, Unit> r113, float r114, boolean r115, long r210, float r211, float r212, boolean r213, PlatformMagnifierFactory r214) {
        if (isPlatformMagnifierSupported$default(0, 1, null) == false) goto L9;
        if (r214 != null) goto L6;
        PlatformMagnifierFactory r116 = PlatformMagnifierFactory.Companion.getForCurrentPlatform();
    L10:
        return r110.then(new MagnifierElement(r111, r112, r113, r114, r115, r210, r211, r212, r213, r116, null));
    L6:
        r116 = r214;
        goto L10
    L9:
        return r110;
    }

    /* JADX INFO: renamed from: magnifier-jPUL71Q$default, reason: not valid java name */
    public static /* synthetic */ Modifier m301magnifierjPUL71Q$default(Modifier r110, Function1 r111, Function1 r112, Function1 r113, float r114, boolean r115, long r116, float r117, float r210, boolean r211, PlatformMagnifierFactory r212, int r213, Object r214) {
        PlatformMagnifierFactory r100 = null;
        if ((r213 & 2) == 0) goto L5;
        Function1 r101 = null;
    L7:
        if ((r213 & 4) == 0) goto L9;
        Function1 r102 = null;
    L11:
        if ((r213 & 8) == 0) goto L13;
        float r103 = Float.NaN;
    L15:
        if ((r213 & 16) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r213 & 32) == 0) goto L21;
        long r105 = DpSize.Companion.m7651getUnspecifiedMYxV2XQ();
    L23:
        if ((r213 & 64) == 0) goto L25;
        float r106 = Dp.Companion.m7564getUnspecifiedD9Ej5fM();
    L27:
        if ((r213 & 128) == 0) goto L29;
        float r107 = Dp.Companion.m7564getUnspecifiedD9Ej5fM();
    L31:
        if ((r213 & 256) == 0) goto L33;
        boolean r118 = true;
    L35:
        if ((r213 & 512) != 0) goto L39;
        r100 = r212;
    L39:
        return m300magnifierjPUL71Q(r110, r111, r101, r102, r103, r104, r105, r106, r107, r118, r100);
    L33:
        r118 = r211;
        goto L35
    L29:
        r107 = r210;
        goto L31
    L25:
        r106 = r117;
        goto L27
    L21:
        r105 = r116;
        goto L23
    L17:
        r104 = r115;
        goto L19
    L13:
        r103 = r114;
        goto L15
    L9:
        r102 = r113;
        goto L11
    L5:
        r101 = r112;
        goto L7
    }
}
