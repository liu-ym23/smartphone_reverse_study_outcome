package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u001a-\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"compareEquals", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroidx/collection/MutableObjectIntMap;", "Landroidx/compose/ui/layout/AlignmentLine;", "b", "", "", "nextUntil", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "type", "Landroidx/compose/ui/node/NodeKind;", "stopType", "nextUntil-hw7D004", "(Landroidx/compose/ui/node/DelegatableNode;II)Landroidx/compose/ui/Modifier$Node;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NodeCoordinatorKt {
    public static final /* synthetic */ boolean access$compareEquals(MutableObjectIntMap r100, Map r101) {
        return compareEquals(r100, r101);
    }

    private static final boolean compareEquals(MutableObjectIntMap<AlignmentLine> r110, Map<AlignmentLine, Integer> r111) {
        if (r110 != null) goto L6;
        return false;
    L6:
        if (r110.getSize() == r111.size()) goto L8;
        return false;
    L8:
        Object[] r100 = r110.keys;
        int[] r101 = r110.values;
        long[] r102 = r110.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L34;
        int r104 = 0;
    L11:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L32;
        int r106 = 8 - ((~(r104 - r103)) >>> 31);
        int r112 = 0;
    L14:
        if (r112 >= r106) goto L29;
        if ((255 & r105) >= 128) goto L18;
        boolean r113 = true;
    L19:
        if (r113 == false) goto L27;
        int r114 = (r104 << 3) + r112;
        Object r115 = r100[r114];
        int r116 = r101[r114];
        Integer r117 = r111.get((AlignmentLine) r115);
        if (r117 == null) goto L25;
        if (r117.intValue() == r116) goto L27;
    L25:
        return false;
    L27:
        r105 = r105 >> 8;
        r112 = r112 + 1;
        goto L14
    L18:
        r113 = false;
        goto L19
    L29:
        if (r106 != 8) goto L34;
    L32:
        if (r104 == r103) goto L34;
        r104 = r104 + 1;
    L34:
        return true;
    }

    /* JADX INFO: renamed from: access$nextUntil-hw7D004, reason: not valid java name */
    public static final /* synthetic */ Modifier.Node m6553access$nextUntilhw7D004(DelegatableNode r100, int r101, int r102) {
        return m6554nextUntilhw7D004(r100, r101, r102);
    }

    /* JADX INFO: renamed from: nextUntil-hw7D004, reason: not valid java name */
    private static final Modifier.Node m6554nextUntilhw7D004(DelegatableNode r100, int r101, int r102) {
        Modifier.Node r103 = r100.getNode().getChild$ui_release();
        if (r103 != null) goto L6;
        return null;
    L6:
        if ((r103.getAggregateChildKindSet$ui_release() & r101) != 0) goto L8;
        return null;
    L8:
        if (r103 == null) goto L16;
        int r104 = r103.getKindSet$ui_release();
        if ((r104 & r102) != 0) goto L11;
        if ((r104 & r101) != 0) goto L14;
        r103 = r103.getChild$ui_release();
        goto L8
    L14:
        return r103;
    L11:
        return null;
    L16:
        return null;
    }
}
