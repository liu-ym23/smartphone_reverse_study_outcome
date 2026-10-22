package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\b\u0010\u0006\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f\u001a#\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"offset", "Landroidx/compose/ui/Modifier;", "x", "Landroidx/compose/ui/unit/Dp;", "y", "offset-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "absoluteOffset", "absoluteOffset-VpY3zN4", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/IntOffset;", "Lkotlin/ExtensionFunctionType;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class OffsetKt {
    public static /* synthetic */ Unit a(float r100, float r101, InspectorInfo r102) {
        return absoluteOffset_VpY3zN4$lambda$1(r100, r101, r102);
    }

    public static /* synthetic */ Unit b(Function1 r100, InspectorInfo r101) {
        return offset$lambda$2(r100, r101);
    }

    public static /* synthetic */ Unit c(Function1 r100, InspectorInfo r101) {
        return absoluteOffset$lambda$3(r100, r101);
    }

    public static /* synthetic */ Unit d(float r100, float r101, InspectorInfo r102) {
        return offset_VpY3zN4$lambda$0(r100, r101, r102);
    }

    public static final Modifier absoluteOffset(Modifier r100, final Function1<? super Density, IntOffset> r101) {
        return r100.then(new OffsetPxElement(r101, false, new k1(r101)));
    }

    private static final Unit absoluteOffset$lambda$3(Function1 r100, InspectorInfo r101) {
        r101.setName("absoluteOffset");
        r101.getProperties().set("offset", r100);
        return Unit.INSTANCE;
    }

    public static final Modifier offset(Modifier r100, final Function1<? super Density, IntOffset> r101) {
        return r100.then(new OffsetPxElement(r101, true, new j1(r101)));
    }

    private static final Unit offset$lambda$2(Function1 r100, InspectorInfo r101) {
        r101.setName("offset");
        r101.getProperties().set("offset", r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: absoluteOffset-VpY3zN4, reason: not valid java name */
    public static final Modifier m688absoluteOffsetVpY3zN4(Modifier r100, final float r101, final float r102) {
        return r100.then(new OffsetElement(r101, r102, false, new h1(r101, r102), null));
    }

    private static final Unit absoluteOffset_VpY3zN4$lambda$1(float r100, float r101, InspectorInfo r102) {
        r102.setName("absoluteOffset");
        r102.getProperties().set("x", Dp.m7542boximpl(r100));
        r102.getProperties().set("y", Dp.m7542boximpl(r101));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: offset-VpY3zN4, reason: not valid java name */
    public static final Modifier m690offsetVpY3zN4(Modifier r100, final float r101, final float r102) {
        return r100.then(new OffsetElement(r101, r102, true, new i1(r101, r102), null));
    }

    private static final Unit offset_VpY3zN4$lambda$0(float r100, float r101, InspectorInfo r102) {
        r102.setName("offset");
        r102.getProperties().set("x", Dp.m7542boximpl(r100));
        r102.getProperties().set("y", Dp.m7542boximpl(r101));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: absoluteOffset-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m689absoluteOffsetVpY3zN4$default(Modifier r100, float r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Dp.m7544constructorimpl(0);
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = Dp.m7544constructorimpl(0);
    L9:
        return m688absoluteOffsetVpY3zN4(r100, r101, r102);
    }

    /* JADX INFO: renamed from: offset-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m691offsetVpY3zN4$default(Modifier r100, float r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Dp.m7544constructorimpl(0);
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = Dp.m7544constructorimpl(0);
    L9:
        return m690offsetVpY3zN4(r100, r101, r102);
    }
}
