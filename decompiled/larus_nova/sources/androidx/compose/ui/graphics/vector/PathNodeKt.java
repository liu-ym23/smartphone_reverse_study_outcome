package androidx.compose.ui.graphics.vector;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000\u001ai\u0010\u000b\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n28\b\u0004\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00050\u000fH\u0082\b\u001a&\u0010\u0014\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a&\u0010\u0015\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\"\u000e\u0010\u0016\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010-\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010.\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010/\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00100\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00101\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00102\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"addPathNodes", "", "", "nodes", "Ljava/util/ArrayList;", "Landroidx/compose/ui/graphics/vector/PathNode;", "Lkotlin/collections/ArrayList;", "args", "", "count", "", "pathNodesFromArgs", "", "numArgs", "nodeFor", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "subArray", "start", "pathMoveNodeFromArgs", "pathRelativeMoveNodeFromArgs", "RelativeCloseKey", "CloseKey", "RelativeMoveToKey", "MoveToKey", "RelativeLineToKey", "LineToKey", "RelativeHorizontalToKey", "HorizontalToKey", "RelativeVerticalToKey", "VerticalToKey", "RelativeCurveToKey", "CurveToKey", "RelativeReflectiveCurveToKey", "ReflectiveCurveToKey", "RelativeQuadToKey", "QuadToKey", "RelativeReflectiveQuadToKey", "ReflectiveQuadToKey", "RelativeArcToKey", "ArcToKey", "NUM_MOVE_TO_ARGS", "NUM_LINE_TO_ARGS", "NUM_HORIZONTAL_TO_ARGS", "NUM_VERTICAL_TO_ARGS", "NUM_CURVE_TO_ARGS", "NUM_REFLECTIVE_CURVE_TO_ARGS", "NUM_QUAD_TO_ARGS", "NUM_REFLECTIVE_QUAD_TO_ARGS", "NUM_ARC_TO_ARGS", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PathNodeKt {
    private static final char ArcToKey = 'A';
    private static final char CloseKey = 'Z';
    private static final char CurveToKey = 'C';
    private static final char HorizontalToKey = 'H';
    private static final char LineToKey = 'L';
    private static final char MoveToKey = 'M';
    private static final int NUM_ARC_TO_ARGS = 7;
    private static final int NUM_CURVE_TO_ARGS = 6;
    private static final int NUM_HORIZONTAL_TO_ARGS = 1;
    private static final int NUM_LINE_TO_ARGS = 2;
    private static final int NUM_MOVE_TO_ARGS = 2;
    private static final int NUM_QUAD_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_CURVE_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_QUAD_TO_ARGS = 2;
    private static final int NUM_VERTICAL_TO_ARGS = 1;
    private static final char QuadToKey = 'Q';
    private static final char ReflectiveCurveToKey = 'S';
    private static final char ReflectiveQuadToKey = 'T';
    private static final char RelativeArcToKey = 'a';
    private static final char RelativeCloseKey = 'z';
    private static final char RelativeCurveToKey = 'c';
    private static final char RelativeHorizontalToKey = 'h';
    private static final char RelativeLineToKey = 'l';
    private static final char RelativeMoveToKey = 'm';
    private static final char RelativeQuadToKey = 'q';
    private static final char RelativeReflectiveCurveToKey = 's';
    private static final char RelativeReflectiveQuadToKey = 't';
    private static final char RelativeVerticalToKey = 'v';
    private static final char VerticalToKey = 'V';

    private static final void pathMoveNodeFromArgs(List<PathNode> r100, float[] r101, int r102) {
        int r103 = 2;
        int r104 = r102 - 2;
        if (r104 < 0) goto L7;
        r100.add(new PathNode.MoveTo(r101[0], r101[1]));
    L5:
        if (r103 > r104) goto L9;
        r100.add(new PathNode.LineTo(r101[r103], r101[r103 + 1]));
        r103 = r103 + 2;
        goto L5
    L9:
        return;
    }

    private static final void pathRelativeMoveNodeFromArgs(List<PathNode> r100, float[] r101, int r102) {
        int r103 = 2;
        int r104 = r102 - 2;
        if (r104 < 0) goto L7;
        r100.add(new PathNode.RelativeMoveTo(r101[0], r101[1]));
    L5:
        if (r103 > r104) goto L9;
        r100.add(new PathNode.RelativeLineTo(r101[r103], r101[r103 + 1]));
        r103 = r103 + 2;
        goto L5
    L9:
        return;
    }

    public static final void addPathNodes(char r110, ArrayList<PathNode> r111, float[] r112, int r113) {
        int r100 = 0;
        switch(r110) {
            case 65: goto L62;
            case 67: goto L59;
            case 72: goto L56;
            case 76: goto L53;
            case 77: goto L52;
            case 81: goto L49;
            case 83: goto L46;
            case 84: goto L43;
            case 86: goto L40;
            case 90: goto L39;
            case 97: goto L28;
            case 99: goto L25;
            case 104: goto L22;
            case 108: goto L19;
            case 109: goto L18;
            case 113: goto L15;
            case 115: goto L12;
            case 116: goto L9;
            case 118: goto L6;
            case 122: goto L39;
            default: goto L5;
        };
    L6:
        int r114 = r113 - 1;
    L7:
        if (r100 > r114) goto L96;
        r111.add(new PathNode.RelativeVerticalTo(r112[r100]));
        r100 = r100 + 1;
        goto L7
    L96:
        return;
    L9:
        int r115 = r113 - 2;
    L10:
        if (r100 > r115) goto L97;
        r111.add(new PathNode.RelativeReflectiveQuadTo(r112[r100], r112[r100 + 1]));
        r100 = r100 + 2;
        goto L10
    L97:
        return;
    L12:
        int r116 = r113 - 4;
    L13:
        if (r100 > r116) goto L98;
        r111.add(new PathNode.RelativeReflectiveCurveTo(r112[r100], r112[r100 + 1], r112[r100 + 2], r112[r100 + 3]));
        r100 = r100 + 4;
        goto L13
    L98:
        return;
    L15:
        int r117 = r113 - 4;
    L16:
        if (r100 > r117) goto L99;
        r111.add(new PathNode.RelativeQuadTo(r112[r100], r112[r100 + 1], r112[r100 + 2], r112[r100 + 3]));
        r100 = r100 + 4;
        goto L16
    L99:
        return;
    L18:
        pathRelativeMoveNodeFromArgs(r111, r112, r113);
        return;
    L19:
        int r118 = r113 - 2;
    L20:
        if (r100 > r118) goto L100;
        r111.add(new PathNode.RelativeLineTo(r112[r100], r112[r100 + 1]));
        r100 = r100 + 2;
        goto L20
    L100:
        return;
    L22:
        int r119 = r113 - 1;
    L23:
        if (r100 > r119) goto L101;
        r111.add(new PathNode.RelativeHorizontalTo(r112[r100]));
        r100 = r100 + 1;
        goto L23
    L101:
        return;
    L25:
        int r120 = r113 - 6;
    L26:
        if (r100 > r120) goto L102;
        r111.add(new PathNode.RelativeCurveTo(r112[r100], r112[r100 + 1], r112[r100 + 2], r112[r100 + 3], r112[r100 + 4], r112[r100 + 5]));
        r100 = r100 + 6;
        goto L26
    L102:
        return;
    L28:
        int r121 = r113 - 7;
        int r122 = 0;
    L29:
        if (r122 > r121) goto L103;
        float r101 = r112[r122];
        float r102 = r112[r122 + 1];
        float r103 = r112[r122 + 2];
        if (Float.compare(r112[r122 + 3], 0.0f) == 0) goto L33;
        boolean r104 = true;
    L35:
        if (Float.compare(r112[r122 + 4], 0.0f) == 0) goto L37;
        boolean r105 = true;
    L38:
        r111.add(new PathNode.RelativeArcTo(r101, r102, r103, r104, r105, r112[r122 + 5], r112[r122 + 6]));
        r122 = r122 + 7;
        goto L29
    L37:
        r105 = false;
        goto L38
    L33:
        r104 = false;
        goto L35
    L103:
        return;
    L39:
        r111.add(PathNode.Close.INSTANCE);
        return;
    L40:
        int r123 = r113 - 1;
    L41:
        if (r100 > r123) goto L104;
        r111.add(new PathNode.VerticalTo(r112[r100]));
        r100 = r100 + 1;
        goto L41
    L104:
        return;
    L43:
        int r124 = r113 - 2;
    L44:
        if (r100 > r124) goto L105;
        r111.add(new PathNode.ReflectiveQuadTo(r112[r100], r112[r100 + 1]));
        r100 = r100 + 2;
        goto L44
    L105:
        return;
    L46:
        int r125 = r113 - 4;
    L47:
        if (r100 > r125) goto L106;
        r111.add(new PathNode.ReflectiveCurveTo(r112[r100], r112[r100 + 1], r112[r100 + 2], r112[r100 + 3]));
        r100 = r100 + 4;
        goto L47
    L106:
        return;
    L49:
        int r126 = r113 - 4;
    L50:
        if (r100 > r126) goto L107;
        r111.add(new PathNode.QuadTo(r112[r100], r112[r100 + 1], r112[r100 + 2], r112[r100 + 3]));
        r100 = r100 + 4;
        goto L50
    L107:
        return;
    L52:
        pathMoveNodeFromArgs(r111, r112, r113);
        return;
    L53:
        int r127 = r113 - 2;
    L54:
        if (r100 > r127) goto L108;
        r111.add(new PathNode.LineTo(r112[r100], r112[r100 + 1]));
        r100 = r100 + 2;
        goto L54
    L108:
        return;
    L56:
        int r128 = r113 - 1;
    L57:
        if (r100 > r128) goto L109;
        r111.add(new PathNode.HorizontalTo(r112[r100]));
        r100 = r100 + 1;
        goto L57
    L109:
        return;
    L59:
        int r129 = r113 - 6;
    L60:
        if (r100 > r129) goto L110;
        r111.add(new PathNode.CurveTo(r112[r100], r112[r100 + 1], r112[r100 + 2], r112[r100 + 3], r112[r100 + 4], r112[r100 + 5]));
        r100 = r100 + 6;
        goto L60
    L110:
        return;
    L62:
        int r130 = r113 - 7;
        int r131 = 0;
    L63:
        if (r131 > r130) goto L111;
        float r106 = r112[r131];
        float r107 = r112[r131 + 1];
        float r108 = r112[r131 + 2];
        if (Float.compare(r112[r131 + 3], 0.0f) == 0) goto L67;
        boolean r109 = true;
    L69:
        if (Float.compare(r112[r131 + 4], 0.0f) == 0) goto L71;
        boolean r132 = true;
    L72:
        r111.add(new PathNode.ArcTo(r106, r107, r108, r109, r132, r112[r131 + 5], r112[r131 + 6]));
        r131 = r131 + 7;
        goto L63
    L71:
        r132 = false;
        goto L72
    L67:
        r109 = false;
        goto L69
    L111:
        return;
    L5:
        throw new IllegalArgumentException("Unknown command for: " + r110);
    }

    private static final void pathNodesFromArgs(List<PathNode> r100, float[] r101, int r102, int r103, Function2<? super float[], ? super Integer, ? extends PathNode> r104) {
        int r105 = r102 - r103;
        int r106 = 0;
    L3:
        if (r106 > r105) goto L5;
        r100.add(r104.invoke(r101, Integer.valueOf(r106)));
        r106 = r106 + r103;
        goto L3
    }
}
