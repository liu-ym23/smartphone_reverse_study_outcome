package androidx.compose.material3.carousel;

import S7.k;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a>\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001aC\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0000¢\u0006\u0004\b\u000e\u0010\u0012\u001a'\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0017\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Landroidx/compose/material3/carousel/KeylineList;", "emptyKeylineList", "()Landroidx/compose/material3/carousel/KeylineList;", "", "carouselMainAxisSize", "itemSpacing", "Landroidx/compose/material3/carousel/CarouselAlignment;", "carouselAlignment", "Lkotlin/Function1;", "Landroidx/compose/material3/carousel/KeylineListScope;", "LC7/r;", "keylines", "keylineListOf-WNYm7Xg", "(FFILS7/k;)Landroidx/compose/material3/carousel/KeylineList;", "keylineListOf", "", "pivotIndex", "pivotOffset", "(FFIFLS7/k;)Landroidx/compose/material3/carousel/KeylineList;", "Landroidx/compose/material3/carousel/Keyline;", "start", "end", "fraction", "lerp", "(Landroidx/compose/material3/carousel/Keyline;Landroidx/compose/material3/carousel/Keyline;F)Landroidx/compose/material3/carousel/Keyline;", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "(Landroidx/compose/material3/carousel/KeylineList;Landroidx/compose/material3/carousel/KeylineList;F)Landroidx/compose/material3/carousel/KeylineList;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeylineListKt {
    public static final KeylineList emptyKeylineList() {
        return KeylineList.INSTANCE.getEmpty();
    }

    public static final KeylineList keylineListOf(float f, float f7, int i, float f9, k kVar) {
        KeylineListScopeImpl keylineListScopeImpl = new KeylineListScopeImpl();
        kVar.invoke(keylineListScopeImpl);
        return keylineListScopeImpl.createWithPivot(f, f7, i, f9);
    }

    /* renamed from: keylineListOf-WNYm7Xg, reason: not valid java name */
    public static final KeylineList m2661keylineListOfWNYm7Xg(float f, float f7, int i, k kVar) {
        KeylineListScopeImpl keylineListScopeImpl = new KeylineListScopeImpl();
        kVar.invoke(keylineListScopeImpl);
        return keylineListScopeImpl.m2662createWithAlignmentwaks0t8(f, f7, i);
    }

    public static final Keyline lerp(Keyline keyline, Keyline keyline2, float f) {
        return new Keyline(MathHelpersKt.lerp(keyline.getSize(), keyline2.getSize(), f), MathHelpersKt.lerp(keyline.getOffset(), keyline2.getOffset(), f), MathHelpersKt.lerp(keyline.getUnadjustedOffset(), keyline2.getUnadjustedOffset(), f), f < 0.5f ? keyline.isFocal() : keyline2.isFocal(), f < 0.5f ? keyline.isAnchor() : keyline2.isAnchor(), f < 0.5f ? keyline.isPivot() : keyline2.isPivot(), MathHelpersKt.lerp(keyline.getCutoff(), keyline2.getCutoff(), f));
    }

    public static final KeylineList lerp(KeylineList keylineList, KeylineList keylineList2, float f) {
        ArrayList arrayList = new ArrayList(keylineList.size());
        int size = keylineList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(lerp(keylineList.get(i), keylineList2.get(i), f));
        }
        return new KeylineList(arrayList);
    }
}
