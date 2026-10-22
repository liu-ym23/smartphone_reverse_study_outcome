package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Placeable;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aF\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\u001d\u0010\u0018\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\b\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015H\u0082\b\u001ae\u0010\u001d\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\u001d\u0010\u0018\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\b\u001a2\u001d\u0010\u001e\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\b\u001a2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015H\u0082\b\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006\"\u001a\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u001a\u0010\u000b\u001a\u00020\f*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u001a\u0010\u0013\u001a\u00020\f*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000e¨\u0006 "}, d2 = {"rowColumnParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getRowColumnParentData", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/layout/Placeable;", "(Landroidx/compose/ui/layout/Placeable;)Landroidx/compose/foundation/layout/RowColumnParentData;", "weight", "", "getWeight", "(Landroidx/compose/foundation/layout/RowColumnParentData;)F", LynxVideoManagerLite.FILL, "", "getFill", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Z", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCrossAxisAlignment", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Landroidx/compose/foundation/layout/CrossAxisAlignment;", "isRelative", "intrinsicMainAxisSize", "", "children", "", "mainAxisSize", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "crossAxisAvailable", "mainAxisSpacing", "intrinsicCrossAxisSize", "crossAxisSize", "mainAxisAvailable", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RowColumnImplKt {
    public static final CrossAxisAlignment getCrossAxisAlignment(RowColumnParentData r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getCrossAxisAlignment();
    }

    public static final boolean getFill(RowColumnParentData r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        return r100.getFill();
    }

    public static final RowColumnParentData getRowColumnParentData(IntrinsicMeasurable r100) {
        Object r101 = r100.getParentData();
        if ((r101 instanceof RowColumnParentData) == true) goto L7;
        return null;
    L7:
        return (RowColumnParentData) r101;
    }

    public static final float getWeight(RowColumnParentData r100) {
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        return r100.getWeight();
    }

    public static final boolean isRelative(RowColumnParentData r100) {
        CrossAxisAlignment r101 = getCrossAxisAlignment(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isRelative$foundation_layout();
    }

    public static final RowColumnParentData getRowColumnParentData(Placeable r100) {
        Object r101 = r100.getParentData();
        if ((r101 instanceof RowColumnParentData) == true) goto L7;
        return null;
    L7:
        return (RowColumnParentData) r101;
    }

    private static final int intrinsicMainAxisSize(List<? extends IntrinsicMeasurable> r110, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> r111, int r112, int r113) {
        if (r110.isEmpty() == false) goto L5;
        return 0;
    L5:
        int r100 = r110.size();
        int r101 = 0;
        int r102 = 0;
        float r103 = 0.0f;
        int r104 = 0;
    L6:
        boolean r105 = true;
        if (r101 >= r100) goto L19;
        IntrinsicMeasurable r106 = (IntrinsicMeasurable) ListProtector.get(r110, r101);
        float r107 = getWeight(getRowColumnParentData(r106));
        int r108 = r111.invoke(r106, Integer.valueOf(r112)).intValue();
        if (r107 == 0.0f) goto L12;
        r105 = false;
    L12:
        if (r105 == false) goto L15;
        r104 = r104 + r108;
    L17:
        r101 = r101 + 1;
        goto L6
    L15:
        if (r107 <= 0.0f) goto L17;
        r103 = r103 + r107;
        r102 = Math.max(r102, Math.round(r108 / r107));
        goto L17
    L19:
        return (Math.round(r102 * r103) + r104) + ((r110.size() - 1) * r113);
    }

    private static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> r110, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> r111, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> r112, int r113, int r210) {
        int r100 = 0;
        if (r110.isEmpty() == false) goto L5;
        return 0;
    L5:
        boolean r101 = true;
        int r102 = Math.min((r110.size() - 1) * r210, r113);
        List<? extends IntrinsicMeasurable> r103 = r110;
        int r104 = r103.size();
        int r105 = 0;
        float r114 = 0.0f;
        int r115 = 0;
    L7:
        if (r105 >= r104) goto L22;
        IntrinsicMeasurable r116 = (IntrinsicMeasurable) ListProtector.get(r110, r105);
        float r117 = getWeight(getRowColumnParentData(r116));
        if (r117 != 0.0f) goto L11;
        boolean r118 = true;
    L12:
        if (r118 == false) goto L18;
        if (r113 != Integer.MAX_VALUE) goto L15;
        int r119 = Integer.MAX_VALUE;
    L16:
        int r120 = Math.min(r111.invoke(r116, Integer.MAX_VALUE).intValue(), r119);
        r102 = r102 + r120;
        r115 = Math.max(r115, r112.invoke(r116, Integer.valueOf(r120)).intValue());
    L20:
        r105 = r105 + 1;
        goto L7
    L15:
        r119 = r113 - r102;
        goto L16
    L18:
        if (r117 <= 0.0f) goto L20;
        r114 = r114 + r117;
        goto L20
    L11:
        r118 = false;
        goto L12
    L22:
        if (r114 == 0.0f) goto L25;
        r101 = false;
    L25:
        if (r101 == false) goto L27;
        int r106 = 0;
    L30:
        int r107 = r103.size();
    L31:
        if (r100 >= r107) goto L39;
        IntrinsicMeasurable r108 = (IntrinsicMeasurable) ListProtector.get(r110, r100);
        float r109 = getWeight(getRowColumnParentData(r108));
        if (r109 <= 0.0f) goto L38;
        if (r106 == Integer.MAX_VALUE) goto L36;
        int r121 = Math.round(r106 * r109);
    L37:
        r115 = Math.max(r115, r112.invoke(r108, Integer.valueOf(r121)).intValue());
        goto L38
    L36:
        r121 = Integer.MAX_VALUE;
    L38:
        r100 = r100 + 1;
        goto L31
    L39:
        return r115;
    L27:
        if (r113 != Integer.MAX_VALUE) goto L29;
        r106 = Integer.MAX_VALUE;
        goto L30
    L29:
        r106 = Math.round(Math.max(r113 - r102, 0) / r114);
        goto L30
    }
}
