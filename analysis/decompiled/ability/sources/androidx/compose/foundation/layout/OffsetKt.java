package androidx.compose.foundation.layout;

import C7.r;
import S7.k;
import androidx.compose.foundation.b;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a*\u0010\b\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0005\u001a%\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\u0006\u0010\f\u001a%\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Dp;", "x", "y", "offset-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", TypedValues.CycleType.S_WAVE_OFFSET, "absoluteOffset-VpY3zN4", "absoluteOffset", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/IntOffset;", "(Landroidx/compose/ui/Modifier;LS7/k;)Landroidx/compose/ui/Modifier;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OffsetKt {
    public static final Modifier absoluteOffset(Modifier modifier, final k kVar) {
        return modifier.then(new OffsetPxElement(kVar, false, new k() { // from class: androidx.compose.foundation.layout.OffsetKt.absoluteOffset.2
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("absoluteOffset");
                inspectorInfo.getProperties().set(TypedValues.CycleType.S_WAVE_OFFSET, kVar);
            }
        }));
    }

    @Stable
    /* renamed from: absoluteOffset-VpY3zN4, reason: not valid java name */
    public static final Modifier m658absoluteOffsetVpY3zN4(Modifier modifier, final float f, final float f7) {
        return modifier.then(new OffsetElement(f, f7, false, new k() { // from class: androidx.compose.foundation.layout.OffsetKt.absoluteOffset.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("absoluteOffset");
                b.j(f, inspectorInfo.getProperties(), "x", inspectorInfo).set("y", Dp.m6842boximpl(f7));
            }
        }, null));
    }

    /* renamed from: absoluteOffset-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m659absoluteOffsetVpY3zN4$default(Modifier modifier, float f, float f7, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m6844constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f7 = Dp.m6844constructorimpl(0);
        }
        return m658absoluteOffsetVpY3zN4(modifier, f, f7);
    }

    public static final Modifier offset(Modifier modifier, final k kVar) {
        return modifier.then(new OffsetPxElement(kVar, true, new k() { // from class: androidx.compose.foundation.layout.OffsetKt.offset.2
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName(TypedValues.CycleType.S_WAVE_OFFSET);
                inspectorInfo.getProperties().set(TypedValues.CycleType.S_WAVE_OFFSET, kVar);
            }
        }));
    }

    @Stable
    /* renamed from: offset-VpY3zN4, reason: not valid java name */
    public static final Modifier m660offsetVpY3zN4(Modifier modifier, final float f, final float f7) {
        return modifier.then(new OffsetElement(f, f7, true, new k() { // from class: androidx.compose.foundation.layout.OffsetKt.offset.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName(TypedValues.CycleType.S_WAVE_OFFSET);
                b.j(f, inspectorInfo.getProperties(), "x", inspectorInfo).set("y", Dp.m6842boximpl(f7));
            }
        }, null));
    }

    /* renamed from: offset-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m661offsetVpY3zN4$default(Modifier modifier, float f, float f7, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m6844constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f7 = Dp.m6844constructorimpl(0);
        }
        return m660offsetVpY3zN4(modifier, f, f7);
    }
}
