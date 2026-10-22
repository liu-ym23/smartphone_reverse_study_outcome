package androidx.compose.material3.carousel;

import androidx.compose.ui.util.MathHelpersKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a@\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aA\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fH\u0000\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0004H\u0000\u001a \u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0004H\u0000¨\u0006\u0019"}, d2 = {"emptyKeylineList", "Landroidx/compose/material3/carousel/KeylineList;", "keylineListOf", "carouselMainAxisSize", "", "itemSpacing", "carouselAlignment", "Landroidx/compose/material3/carousel/CarouselAlignment;", "keylines", "Lkotlin/Function1;", "Landroidx/compose/material3/carousel/KeylineListScope;", "", "Lkotlin/ExtensionFunctionType;", "keylineListOf-WNYm7Xg", "(FFILkotlin/jvm/functions/Function1;)Landroidx/compose/material3/carousel/KeylineList;", "pivotIndex", "", "pivotOffset", "lerp", "Landroidx/compose/material3/carousel/Keyline;", "start", "end", "fraction", "from", RemoteMessageConst.TO, "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KeylineListKt {
    public static final KeylineList emptyKeylineList() {
        return KeylineList.Companion.getEmpty();
    }

    public static final Keyline lerp(Keyline r100, Keyline r110, float r111) {
        float r101 = MathHelpersKt.lerp(r100.getSize(), r110.getSize(), r111);
        float r102 = MathHelpersKt.lerp(r100.getOffset(), r110.getOffset(), r111);
        float r103 = MathHelpersKt.lerp(r100.getUnadjustedOffset(), r110.getUnadjustedOffset(), r111);
        if (r111 >= 0.5f) goto L5;
        boolean r104 = r100.isFocal();
    L6:
        if (r111 >= 0.5f) goto L8;
        boolean r105 = r100.isAnchor();
    L9:
        if (r111 >= 0.5f) goto L11;
        boolean r106 = r100.isPivot();
    L13:
        return new Keyline(r101, r102, r103, r104, r105, r106, MathHelpersKt.lerp(r100.getCutoff(), r110.getCutoff(), r111));
    L11:
        r106 = r110.isPivot();
        goto L13
    L8:
        r105 = r110.isAnchor();
        goto L9
    L5:
        r104 = r110.isFocal();
        goto L6
    }

    public static final KeylineList lerp(KeylineList r100, KeylineList r101, float r102) {
        ArrayList r103 = new ArrayList(r100.size());
        int r104 = r100.size();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L6;
        r103.add(lerp((Keyline) ListProtector.get(r100, r105), r101.get(r105), r102));
        r105 = r105 + 1;
        goto L3
    L6:
        return new KeylineList(r103);
    }

    /* JADX INFO: renamed from: keylineListOf-WNYm7Xg, reason: not valid java name */
    public static final KeylineList m3119keylineListOfWNYm7Xg(float r100, float r101, int r102, Function1<? super KeylineListScope, Unit> r103) {
        KeylineListScopeImpl r104 = new KeylineListScopeImpl();
        r103.invoke(r104);
        return r104.m3120createWithAlignmentwaks0t8(r100, r101, r102);
    }

    public static final KeylineList keylineListOf(float r100, float r101, int r102, float r103, Function1<? super KeylineListScope, Unit> r104) {
        KeylineListScopeImpl r105 = new KeylineListScopeImpl();
        r104.invoke(r105);
        return r105.createWithPivot(r100, r101, r102, r103);
    }
}
