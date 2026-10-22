package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J$\u0010\u000b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J$\u0010\f\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J$\u0010\u000e\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J$\u0010\u000f\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J$\u0010\u0010\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J$\u0010\u0011\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J$\u0010\u0012\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/layout/IntrinsicMeasureBlocks;", "", "<init>", "()V", "HorizontalMinWidth", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "availableHeight", "mainAxisSpacing", "VerticalMinWidth", "HorizontalMinHeight", "availableWidth", "VerticalMinHeight", "HorizontalMaxWidth", "VerticalMaxWidth", "HorizontalMaxHeight", "VerticalMaxHeight", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IntrinsicMeasureBlocks {
    public static final int $stable = 0;
    public static final IntrinsicMeasureBlocks INSTANCE = null;

    static {
        INSTANCE = new IntrinsicMeasureBlocks();
    }

    private IntrinsicMeasureBlocks() {
    }

    public final int HorizontalMaxHeight(List<? extends IntrinsicMeasurable> r110, int r111, int r112) {
        int r100 = 0;
        if (r110.isEmpty() == true) goto L48;
        boolean r101 = true;
        int r113 = Math.min((r110.size() - 1) * r112, r111);
        List<? extends IntrinsicMeasurable> r102 = r110;
        int r103 = r102.size();
        int r104 = 0;
        float r105 = 0.0f;
        int r106 = 0;
    L7:
        if (r104 >= r103) goto L22;
        IntrinsicMeasurable r107 = (IntrinsicMeasurable) ListProtector.get(r110, r104);
        float r114 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r107));
        if (r114 != 0.0f) goto L11;
        boolean r115 = true;
    L12:
        if (r115 == false) goto L18;
        if (r111 != Integer.MAX_VALUE) goto L15;
        int r116 = Integer.MAX_VALUE;
    L16:
        int r108 = Math.min(r107.maxIntrinsicWidth(Integer.MAX_VALUE), r116);
        r113 = r113 + r108;
        r106 = Math.max(r106, r107.maxIntrinsicHeight(r108));
    L20:
        r104 = r104 + 1;
        goto L7
    L15:
        r116 = r111 - r113;
        goto L16
    L18:
        if (r114 <= 0.0f) goto L20;
        r105 = r105 + r114;
        goto L20
    L11:
        r115 = false;
        goto L12
    L22:
        if (r105 == 0.0f) goto L25;
        r101 = false;
    L25:
        if (r101 == false) goto L27;
        int r117 = 0;
    L30:
        int r118 = r102.size();
    L31:
        if (r100 >= r118) goto L40;
        IntrinsicMeasurable r109 = (IntrinsicMeasurable) ListProtector.get(r110, r100);
        float r119 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r109));
        if (r119 <= 0.0f) goto L38;
        if (r117 == Integer.MAX_VALUE) goto L36;
        int r120 = Math.round(r117 * r119);
    L37:
        r106 = Math.max(r106, r109.maxIntrinsicHeight(r120));
        goto L38
    L36:
        r120 = Integer.MAX_VALUE;
    L38:
        r100 = r100 + 1;
        goto L31
    L40:
        return r106;
    L27:
        if (r111 != Integer.MAX_VALUE) goto L29;
        r117 = Integer.MAX_VALUE;
        goto L30
    L29:
        r117 = Math.round(Math.max(r111 - r113, 0) / r105);
        goto L30
    L48:
        return 0;
    }

    public final int HorizontalMaxWidth(List<? extends IntrinsicMeasurable> r110, int r111, int r112) {
        if (r110.isEmpty() == true) goto L24;
        int r100 = r110.size();
        int r101 = 0;
        int r102 = 0;
        float r103 = 0.0f;
        int r104 = 0;
    L6:
        boolean r105 = true;
        if (r101 >= r100) goto L19;
        IntrinsicMeasurable r106 = (IntrinsicMeasurable) ListProtector.get(r110, r101);
        float r107 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r106));
        int r108 = r106.maxIntrinsicWidth(r111);
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
        return (Math.round(r102 * r103) + r104) + ((r110.size() - 1) * r112);
    L24:
        return 0;
    }

    public final int HorizontalMinHeight(List<? extends IntrinsicMeasurable> r110, int r111, int r112) {
        int r100 = 0;
        if (r110.isEmpty() == true) goto L48;
        boolean r101 = true;
        int r113 = Math.min((r110.size() - 1) * r112, r111);
        List<? extends IntrinsicMeasurable> r102 = r110;
        int r103 = r102.size();
        int r104 = 0;
        float r105 = 0.0f;
        int r106 = 0;
    L7:
        if (r104 >= r103) goto L22;
        IntrinsicMeasurable r107 = (IntrinsicMeasurable) ListProtector.get(r110, r104);
        float r114 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r107));
        if (r114 != 0.0f) goto L11;
        boolean r115 = true;
    L12:
        if (r115 == false) goto L18;
        if (r111 != Integer.MAX_VALUE) goto L15;
        int r116 = Integer.MAX_VALUE;
    L16:
        int r108 = Math.min(r107.maxIntrinsicWidth(Integer.MAX_VALUE), r116);
        r113 = r113 + r108;
        r106 = Math.max(r106, r107.minIntrinsicHeight(r108));
    L20:
        r104 = r104 + 1;
        goto L7
    L15:
        r116 = r111 - r113;
        goto L16
    L18:
        if (r114 <= 0.0f) goto L20;
        r105 = r105 + r114;
        goto L20
    L11:
        r115 = false;
        goto L12
    L22:
        if (r105 == 0.0f) goto L25;
        r101 = false;
    L25:
        if (r101 == false) goto L27;
        int r117 = 0;
    L30:
        int r118 = r102.size();
    L31:
        if (r100 >= r118) goto L40;
        IntrinsicMeasurable r109 = (IntrinsicMeasurable) ListProtector.get(r110, r100);
        float r119 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r109));
        if (r119 <= 0.0f) goto L38;
        if (r117 == Integer.MAX_VALUE) goto L36;
        int r120 = Math.round(r117 * r119);
    L37:
        r106 = Math.max(r106, r109.minIntrinsicHeight(r120));
        goto L38
    L36:
        r120 = Integer.MAX_VALUE;
    L38:
        r100 = r100 + 1;
        goto L31
    L40:
        return r106;
    L27:
        if (r111 != Integer.MAX_VALUE) goto L29;
        r117 = Integer.MAX_VALUE;
        goto L30
    L29:
        r117 = Math.round(Math.max(r111 - r113, 0) / r105);
        goto L30
    L48:
        return 0;
    }

    public final int HorizontalMinWidth(List<? extends IntrinsicMeasurable> r110, int r111, int r112) {
        if (r110.isEmpty() == true) goto L24;
        int r100 = r110.size();
        int r101 = 0;
        int r102 = 0;
        float r103 = 0.0f;
        int r104 = 0;
    L6:
        boolean r105 = true;
        if (r101 >= r100) goto L19;
        IntrinsicMeasurable r106 = (IntrinsicMeasurable) ListProtector.get(r110, r101);
        float r107 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r106));
        int r108 = r106.minIntrinsicWidth(r111);
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
        return (Math.round(r102 * r103) + r104) + ((r110.size() - 1) * r112);
    L24:
        return 0;
    }

    public final int VerticalMaxHeight(List<? extends IntrinsicMeasurable> r110, int r111, int r112) {
        if (r110.isEmpty() == true) goto L24;
        int r100 = r110.size();
        int r101 = 0;
        int r102 = 0;
        float r103 = 0.0f;
        int r104 = 0;
    L6:
        boolean r105 = true;
        if (r101 >= r100) goto L19;
        IntrinsicMeasurable r106 = (IntrinsicMeasurable) ListProtector.get(r110, r101);
        float r107 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r106));
        int r108 = r106.maxIntrinsicHeight(r111);
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
        return (Math.round(r102 * r103) + r104) + ((r110.size() - 1) * r112);
    L24:
        return 0;
    }

    public final int VerticalMaxWidth(List<? extends IntrinsicMeasurable> r110, int r111, int r112) {
        int r100 = 0;
        if (r110.isEmpty() == true) goto L48;
        boolean r101 = true;
        int r113 = Math.min((r110.size() - 1) * r112, r111);
        List<? extends IntrinsicMeasurable> r102 = r110;
        int r103 = r102.size();
        int r104 = 0;
        float r105 = 0.0f;
        int r106 = 0;
    L7:
        if (r104 >= r103) goto L22;
        IntrinsicMeasurable r107 = (IntrinsicMeasurable) ListProtector.get(r110, r104);
        float r114 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r107));
        if (r114 != 0.0f) goto L11;
        boolean r115 = true;
    L12:
        if (r115 == false) goto L18;
        if (r111 != Integer.MAX_VALUE) goto L15;
        int r116 = Integer.MAX_VALUE;
    L16:
        int r108 = Math.min(r107.maxIntrinsicHeight(Integer.MAX_VALUE), r116);
        r113 = r113 + r108;
        r106 = Math.max(r106, r107.maxIntrinsicWidth(r108));
    L20:
        r104 = r104 + 1;
        goto L7
    L15:
        r116 = r111 - r113;
        goto L16
    L18:
        if (r114 <= 0.0f) goto L20;
        r105 = r105 + r114;
        goto L20
    L11:
        r115 = false;
        goto L12
    L22:
        if (r105 == 0.0f) goto L25;
        r101 = false;
    L25:
        if (r101 == false) goto L27;
        int r117 = 0;
    L30:
        int r118 = r102.size();
    L31:
        if (r100 >= r118) goto L40;
        IntrinsicMeasurable r109 = (IntrinsicMeasurable) ListProtector.get(r110, r100);
        float r119 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r109));
        if (r119 <= 0.0f) goto L38;
        if (r117 == Integer.MAX_VALUE) goto L36;
        int r120 = Math.round(r117 * r119);
    L37:
        r106 = Math.max(r106, r109.maxIntrinsicWidth(r120));
        goto L38
    L36:
        r120 = Integer.MAX_VALUE;
    L38:
        r100 = r100 + 1;
        goto L31
    L40:
        return r106;
    L27:
        if (r111 != Integer.MAX_VALUE) goto L29;
        r117 = Integer.MAX_VALUE;
        goto L30
    L29:
        r117 = Math.round(Math.max(r111 - r113, 0) / r105);
        goto L30
    L48:
        return 0;
    }

    public final int VerticalMinHeight(List<? extends IntrinsicMeasurable> r110, int r111, int r112) {
        if (r110.isEmpty() == true) goto L24;
        int r100 = r110.size();
        int r101 = 0;
        int r102 = 0;
        float r103 = 0.0f;
        int r104 = 0;
    L6:
        boolean r105 = true;
        if (r101 >= r100) goto L19;
        IntrinsicMeasurable r106 = (IntrinsicMeasurable) ListProtector.get(r110, r101);
        float r107 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r106));
        int r108 = r106.minIntrinsicHeight(r111);
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
        return (Math.round(r102 * r103) + r104) + ((r110.size() - 1) * r112);
    L24:
        return 0;
    }

    public final int VerticalMinWidth(List<? extends IntrinsicMeasurable> r110, int r111, int r112) {
        int r100 = 0;
        if (r110.isEmpty() == true) goto L48;
        boolean r101 = true;
        int r113 = Math.min((r110.size() - 1) * r112, r111);
        List<? extends IntrinsicMeasurable> r102 = r110;
        int r103 = r102.size();
        int r104 = 0;
        float r105 = 0.0f;
        int r106 = 0;
    L7:
        if (r104 >= r103) goto L22;
        IntrinsicMeasurable r107 = (IntrinsicMeasurable) ListProtector.get(r110, r104);
        float r114 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r107));
        if (r114 != 0.0f) goto L11;
        boolean r115 = true;
    L12:
        if (r115 == false) goto L18;
        if (r111 != Integer.MAX_VALUE) goto L15;
        int r116 = Integer.MAX_VALUE;
    L16:
        int r108 = Math.min(r107.maxIntrinsicHeight(Integer.MAX_VALUE), r116);
        r113 = r113 + r108;
        r106 = Math.max(r106, r107.minIntrinsicWidth(r108));
    L20:
        r104 = r104 + 1;
        goto L7
    L15:
        r116 = r111 - r113;
        goto L16
    L18:
        if (r114 <= 0.0f) goto L20;
        r105 = r105 + r114;
        goto L20
    L11:
        r115 = false;
        goto L12
    L22:
        if (r105 == 0.0f) goto L25;
        r101 = false;
    L25:
        if (r101 == false) goto L27;
        int r117 = 0;
    L30:
        int r118 = r102.size();
    L31:
        if (r100 >= r118) goto L40;
        IntrinsicMeasurable r109 = (IntrinsicMeasurable) ListProtector.get(r110, r100);
        float r119 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r109));
        if (r119 <= 0.0f) goto L38;
        if (r117 == Integer.MAX_VALUE) goto L36;
        int r120 = Math.round(r117 * r119);
    L37:
        r106 = Math.max(r106, r109.minIntrinsicWidth(r120));
        goto L38
    L36:
        r120 = Integer.MAX_VALUE;
    L38:
        r100 = r100 + 1;
        goto L31
    L40:
        return r106;
    L27:
        if (r111 != Integer.MAX_VALUE) goto L29;
        r117 = Integer.MAX_VALUE;
        goto L30
    L29:
        r117 = Math.round(Math.max(r111 - r113, 0) / r105);
        goto L30
    L48:
        return 0;
    }
}
