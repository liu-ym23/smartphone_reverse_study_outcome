package androidx.compose.material.internal;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1 implements MeasurePolicy {
    public static final ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1 INSTANCE = null;

    static {
        INSTANCE = new ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1();
    }

    public ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1() {
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r100, List r101, int r102) {
        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, r100, r101, r102);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r100, List r101, int r102) {
        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, r100, r101, r102);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r100, List r101, int r102) {
        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, r100, r101, r102);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r100, List r101, int r102) {
        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, r100, r101, r102);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo33measure3p2s80s(MeasureScope r110, List<? extends Measurable> r111, long r112) {
        int r100 = r111.size();
        if (r100 == 0) goto L20;
        int r101 = 0;
        if (r100 == 1) goto L18;
        final ArrayList r102 = new ArrayList(r111.size());
        int r103 = r111.size();
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L9;
        r102.add(((Measurable) ListProtector.get(r111, r104)).mo6256measureBRTryo0(r112));
        r104 = r104 + 1;
        goto L7
    L9:
        int r113 = CollectionsKt.getLastIndex(r102);
        if (r113 < 0) goto L16;
        int r114 = 0;
        int r115 = 0;
    L12:
        Placeable r105 = (Placeable) ListProtector.get(r102, r101);
        r114 = Math.max(r114, r105.getWidth());
        r115 = Math.max(r115, r105.getHeight());
        if (r101 == r113) goto L15;
        r101 = r101 + 1;
        goto L12
    L15:
        int r106 = r114;
        int r107 = r115;
    L23:
        return MeasureScope.CC.layout$default(r110, r106, r107, null, new AnonymousClass3(r102), 4, null);
    L16:
        r106 = 0;
        r107 = 0;
        goto L23
    L18:
        final Placeable r116 = ((Measurable) ListProtector.get(r111, 0)).mo6256measureBRTryo0(r112);
        return MeasureScope.CC.layout$default(r110, r116.getWidth(), r116.getHeight(), null, new AnonymousClass2(r116), 4, null);
    L20:
        return MeasureScope.CC.layout$default(r110, 0, 0, null, AnonymousClass1.INSTANCE, 4, null);
    }
}
