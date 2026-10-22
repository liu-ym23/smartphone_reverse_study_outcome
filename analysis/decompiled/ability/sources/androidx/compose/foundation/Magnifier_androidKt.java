package androidx.compose.foundation;

import S7.k;
import S7.n;
import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u008a\u0001\u0010\u0013\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00012\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a¢\u0001\u0010\u0013\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00012\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0019\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001b\u0010\u001f\u001a\u00020\u000f*\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0000¢\u0006\u0004\b\u001f\u0010 \"&\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"0!8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Offset;", "sourceCenter", "magnifierCenter", "Landroidx/compose/ui/unit/DpSize;", "LC7/r;", "onSizeChanged", "", "zoom", "size", "Landroidx/compose/ui/unit/Dp;", "cornerRadius", "elevation", "", "clip", "magnifier-UpNRX3w", "(Landroidx/compose/ui/Modifier;LS7/k;LS7/k;LS7/k;FJFFZ)Landroidx/compose/ui/Modifier;", "magnifier", "useTextDefault", "clippingEnabled", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "platformMagnifierFactory", "magnifier-jPUL71Q", "(Landroidx/compose/ui/Modifier;LS7/k;LS7/k;LS7/k;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;)Landroidx/compose/ui/Modifier;", "", "sdkVersion", "isPlatformMagnifierSupported", "(I)Z", "other", "equalsIncludingNaN", "(FF)Z", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Lkotlin/Function0;", "MagnifierPositionInRoot", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "getMagnifierPositionInRoot", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Magnifier_androidKt {
    private static final SemanticsPropertyKey<S7.a> MagnifierPositionInRoot = new SemanticsPropertyKey<>("MagnifierPositionInRoot", (n) null, 2, (e) null);

    public static final boolean equalsIncludingNaN(float f, float f7) {
        return (Float.isNaN(f) && Float.isNaN(f7)) || f == f7;
    }

    public static final SemanticsPropertyKey<S7.a> getMagnifierPositionInRoot() {
        return MagnifierPositionInRoot;
    }

    @ChecksSdkIntAtLeast(api = 28)
    public static final boolean isPlatformMagnifierSupported(int i) {
        return i >= 28;
    }

    public static /* synthetic */ boolean isPlatformMagnifierSupported$default(int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = Build.VERSION.SDK_INT;
        }
        return isPlatformMagnifierSupported(i);
    }

    /* renamed from: magnifier-UpNRX3w, reason: not valid java name */
    public static final Modifier m310magnifierUpNRX3w(Modifier modifier, k kVar, k kVar2, k kVar3, float f, long j5, float f7, float f9, boolean z10) {
        return m313magnifierjPUL71Q$default(modifier, kVar, kVar2, kVar3, f, false, j5, f7, f9, z10, null, 512, null);
    }

    /* renamed from: magnifier-UpNRX3w$default, reason: not valid java name */
    public static /* synthetic */ Modifier m311magnifierUpNRX3w$default(Modifier modifier, k kVar, k kVar2, k kVar3, float f, long j5, float f7, float f9, boolean z10, int i, Object obj) {
        if ((i & 2) != 0) {
            kVar2 = null;
        }
        if ((i & 4) != 0) {
            kVar3 = null;
        }
        if ((i & 8) != 0) {
            f = Float.NaN;
        }
        if ((i & 16) != 0) {
            j5 = DpSize.INSTANCE.m6951getUnspecifiedMYxV2XQ();
        }
        if ((i & 32) != 0) {
            f7 = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        if ((i & 64) != 0) {
            f9 = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        if ((i & 128) != 0) {
            z10 = true;
        }
        return m310magnifierUpNRX3w(modifier, kVar, kVar2, kVar3, f, j5, f7, f9, z10);
    }

    /* renamed from: magnifier-jPUL71Q, reason: not valid java name */
    public static final Modifier m312magnifierjPUL71Q(Modifier modifier, k kVar, k kVar2, k kVar3, float f, boolean z10, long j5, float f7, float f9, boolean z11, PlatformMagnifierFactory platformMagnifierFactory) {
        if (isPlatformMagnifierSupported$default(0, 1, null)) {
            return modifier.then(new MagnifierElement(kVar, kVar2, kVar3, f, z10, j5, f7, f9, z11, platformMagnifierFactory == null ? PlatformMagnifierFactory.INSTANCE.getForCurrentPlatform() : platformMagnifierFactory, null));
        }
        return modifier;
    }

    /* renamed from: magnifier-jPUL71Q$default, reason: not valid java name */
    public static /* synthetic */ Modifier m313magnifierjPUL71Q$default(Modifier modifier, k kVar, k kVar2, k kVar3, float f, boolean z10, long j5, float f7, float f9, boolean z11, PlatformMagnifierFactory platformMagnifierFactory, int i, Object obj) {
        if ((i & 2) != 0) {
            kVar2 = null;
        }
        if ((i & 4) != 0) {
            kVar3 = null;
        }
        if ((i & 8) != 0) {
            f = Float.NaN;
        }
        if ((i & 16) != 0) {
            z10 = false;
        }
        if ((i & 32) != 0) {
            j5 = DpSize.INSTANCE.m6951getUnspecifiedMYxV2XQ();
        }
        if ((i & 64) != 0) {
            f7 = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        if ((i & 128) != 0) {
            f9 = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        if ((i & 256) != 0) {
            z11 = true;
        }
        if ((i & 512) != 0) {
            platformMagnifierFactory = null;
        }
        return m312magnifierjPUL71Q(modifier, kVar, kVar2, kVar3, f, z10, j5, f7, f9, z11, platformMagnifierFactory);
    }
}
