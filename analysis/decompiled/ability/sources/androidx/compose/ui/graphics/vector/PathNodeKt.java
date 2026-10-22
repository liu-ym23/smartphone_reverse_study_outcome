package androidx.compose.ui.graphics.vector;

import S7.n;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\u001a;\u0010\n\u001a\u00020\t*\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001aR\u0010\u0010\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u001a\b\u0004\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u000eH\u0082\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a-\u0010\u0012\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a-\u0010\u0014\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0013\"\u0014\u0010\u0015\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u0017\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016\"\u0014\u0010\u0018\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016\"\u0014\u0010\u0019\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016\"\u0014\u0010\u001a\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016\"\u0014\u0010\u001b\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0016\"\u0014\u0010\u001c\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0016\"\u0014\u0010\u001d\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0016\"\u0014\u0010\u001e\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0016\"\u0014\u0010\u001f\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0016\"\u0014\u0010 \u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0016\"\u0014\u0010!\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u0016\"\u0014\u0010\"\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u0016\"\u0014\u0010#\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u0016\"\u0014\u0010$\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u0016\"\u0014\u0010%\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\u0016\"\u0014\u0010&\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\u0016\"\u0014\u0010'\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\u0016\"\u0014\u0010(\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010\u0016\"\u0014\u0010)\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010\u0016\"\u0014\u0010*\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+\"\u0014\u0010,\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010+\"\u0014\u0010-\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010+\"\u0014\u0010.\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010+\"\u0014\u0010/\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010+\"\u0014\u00100\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010+\"\u0014\u00101\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010+\"\u0014\u00102\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u0010+\"\u0014\u00103\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u0010+¨\u00064"}, d2 = {"", "Ljava/util/ArrayList;", "Landroidx/compose/ui/graphics/vector/PathNode;", "Lkotlin/collections/ArrayList;", "nodes", "", "args", "", "count", "LC7/r;", "addPathNodes", "(CLjava/util/ArrayList;[FI)V", "", "numArgs", "Lkotlin/Function2;", "nodeFor", "pathNodesFromArgs", "(Ljava/util/List;[FIILS7/n;)V", "pathMoveNodeFromArgs", "(Ljava/util/List;[FI)V", "pathRelativeMoveNodeFromArgs", "RelativeCloseKey", "C", "CloseKey", "RelativeMoveToKey", "MoveToKey", "RelativeLineToKey", "LineToKey", "RelativeHorizontalToKey", "HorizontalToKey", "RelativeVerticalToKey", "VerticalToKey", "RelativeCurveToKey", "CurveToKey", "RelativeReflectiveCurveToKey", "ReflectiveCurveToKey", "RelativeQuadToKey", "QuadToKey", "RelativeReflectiveQuadToKey", "ReflectiveQuadToKey", "RelativeArcToKey", "ArcToKey", "NUM_MOVE_TO_ARGS", "I", "NUM_LINE_TO_ARGS", "NUM_HORIZONTAL_TO_ARGS", "NUM_VERTICAL_TO_ARGS", "NUM_CURVE_TO_ARGS", "NUM_REFLECTIVE_CURVE_TO_ARGS", "NUM_QUAD_TO_ARGS", "NUM_REFLECTIVE_QUAD_TO_ARGS", "NUM_ARC_TO_ARGS", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
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

    public static final void addPathNodes(char c, ArrayList<PathNode> arrayList, float[] fArr, int i) {
        int i6 = 0;
        switch (c) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                int i10 = i - 7;
                for (int i11 = 0; i11 <= i10; i11 += 7) {
                    arrayList.add(new PathNode.ArcTo(fArr[i11], fArr[i11 + 1], fArr[i11 + 2], Float.compare(fArr[i11 + 3], 0.0f) != 0, Float.compare(fArr[i11 + 4], 0.0f) != 0, fArr[i11 + 5], fArr[i11 + 6]));
                }
                return;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                int i12 = i - 6;
                while (i6 <= i12) {
                    arrayList.add(new PathNode.CurveTo(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3], fArr[i6 + 4], fArr[i6 + 5]));
                    i6 += 6;
                }
                return;
            case 'H':
                int i13 = i - 1;
                while (i6 <= i13) {
                    arrayList.add(new PathNode.HorizontalTo(fArr[i6]));
                    i6++;
                }
                return;
            case 'L':
                int i14 = i - 2;
                while (i6 <= i14) {
                    arrayList.add(new PathNode.LineTo(fArr[i6], fArr[i6 + 1]));
                    i6 += 2;
                }
                return;
            case 'M':
                pathMoveNodeFromArgs(arrayList, fArr, i);
                return;
            case 'Q':
                int i15 = i - 4;
                while (i6 <= i15) {
                    arrayList.add(new PathNode.QuadTo(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3]));
                    i6 += 4;
                }
                return;
            case 'S':
                int i16 = i - 4;
                while (i6 <= i16) {
                    arrayList.add(new PathNode.ReflectiveCurveTo(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3]));
                    i6 += 4;
                }
                return;
            case 'T':
                int i17 = i - 2;
                while (i6 <= i17) {
                    arrayList.add(new PathNode.ReflectiveQuadTo(fArr[i6], fArr[i6 + 1]));
                    i6 += 2;
                }
                return;
            case 'V':
                int i18 = i - 1;
                while (i6 <= i18) {
                    arrayList.add(new PathNode.VerticalTo(fArr[i6]));
                    i6++;
                }
                return;
            case 'Z':
            case 'z':
                arrayList.add(PathNode.Close.INSTANCE);
                return;
            case 'a':
                int i19 = i - 7;
                for (int i20 = 0; i20 <= i19; i20 += 7) {
                    arrayList.add(new PathNode.RelativeArcTo(fArr[i20], fArr[i20 + 1], fArr[i20 + 2], Float.compare(fArr[i20 + 3], 0.0f) != 0, Float.compare(fArr[i20 + 4], 0.0f) != 0, fArr[i20 + 5], fArr[i20 + 6]));
                }
                return;
            case 'c':
                int i21 = i - 6;
                while (i6 <= i21) {
                    arrayList.add(new PathNode.RelativeCurveTo(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3], fArr[i6 + 4], fArr[i6 + 5]));
                    i6 += 6;
                }
                return;
            case LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
                int i22 = i - 1;
                while (i6 <= i22) {
                    arrayList.add(new PathNode.RelativeHorizontalTo(fArr[i6]));
                    i6++;
                }
                return;
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                int i23 = i - 2;
                while (i6 <= i23) {
                    arrayList.add(new PathNode.RelativeLineTo(fArr[i6], fArr[i6 + 1]));
                    i6 += 2;
                }
                return;
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
                pathRelativeMoveNodeFromArgs(arrayList, fArr, i);
                return;
            case 'q':
                int i24 = i - 4;
                while (i6 <= i24) {
                    arrayList.add(new PathNode.RelativeQuadTo(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3]));
                    i6 += 4;
                }
                return;
            case 's':
                int i25 = i - 4;
                while (i6 <= i25) {
                    arrayList.add(new PathNode.RelativeReflectiveCurveTo(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3]));
                    i6 += 4;
                }
                return;
            case 't':
                int i26 = i - 2;
                while (i6 <= i26) {
                    arrayList.add(new PathNode.RelativeReflectiveQuadTo(fArr[i6], fArr[i6 + 1]));
                    i6 += 2;
                }
                return;
            case 'v':
                int i27 = i - 1;
                while (i6 <= i27) {
                    arrayList.add(new PathNode.RelativeVerticalTo(fArr[i6]));
                    i6++;
                }
                return;
            default:
                throw new IllegalArgumentException("Unknown command for: " + c);
        }
    }

    private static final void pathMoveNodeFromArgs(List<PathNode> list, float[] fArr, int i) {
        int i6 = i - 2;
        if (i6 >= 0) {
            list.add(new PathNode.MoveTo(fArr[0], fArr[1]));
            for (int i10 = 2; i10 <= i6; i10 += 2) {
                list.add(new PathNode.LineTo(fArr[i10], fArr[i10 + 1]));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void pathNodesFromArgs(List<PathNode> list, float[] fArr, int i, int i6, n nVar) {
        int i10 = i - i6;
        int i11 = 0;
        while (i11 <= i10) {
            list.add(nVar.invoke(fArr, Integer.valueOf(i11)));
            i11 += i6;
        }
    }

    private static final void pathRelativeMoveNodeFromArgs(List<PathNode> list, float[] fArr, int i) {
        int i6 = i - 2;
        if (i6 >= 0) {
            list.add(new PathNode.RelativeMoveTo(fArr[0], fArr[1]));
            for (int i10 = 2; i10 <= i6; i10 += 2) {
                list.add(new PathNode.RelativeLineTo(fArr[i10], fArr[i10 + 1]));
            }
        }
    }
}
