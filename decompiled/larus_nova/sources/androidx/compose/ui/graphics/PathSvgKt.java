package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.vector.PathParser;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¨\u0006\f"}, d2 = {"addSvg", "", "Landroidx/compose/ui/graphics/Path;", "pathData", "", "toSvg", "asDocument", "", "command", "type", "Landroidx/compose/ui/graphics/PathSegment$Type;", "lastType", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PathSvgKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[PathSegment.Type.values().length];
            r100[PathSegment.Type.Move.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[PathSegment.Type.Line.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[PathSegment.Type.Quadratic.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[PathSegment.Type.Conic.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[PathSegment.Type.Cubic.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[PathSegment.Type.Close.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[PathSegment.Type.Done.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public static final void addSvg(Path r100, String r101) {
        new PathParser().parsePathString(r101).toPath(r100);
    }

    private static final String command(PathSegment.Type r100, PathSegment.Type r101) {
        if (r100 == r101) goto L19;
        int r102 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        if (r102 != 1) goto L6;
        return "M";
    L6:
        if (r102 != 2) goto L8;
        return "L";
    L8:
        if (r102 != 3) goto L10;
        return "Q";
    L10:
        if (r102 != 5) goto L12;
        return "C";
    L12:
        if (r102 == 6) goto L14;
        return "";
    L14:
        return "Z";
    L19:
        return " ";
    }

    public static final String toSvg(Path r110, boolean r111) {
        StringBuilder r100 = new StringBuilder();
        Rect r101 = r110.getBounds();
        if (r111 == false) goto L5;
        r100.append("<svg xmlns=\"http://www.w3.org/2000/svg\" ");
        r100.append("viewBox=\"" + r101.getLeft() + ' ' + r101.getTop() + ' ' + (r101.getRight() - r101.getLeft()) + ' ' + (r101.getBottom() - r101.getTop()) + "\">");
        r100.append('\n');
    L5:
        PathIterator r102 = r110.iterator();
        float[] r103 = new float[8];
        PathSegment.Type r104 = PathSegment.Type.Done;
        if (r102.hasNext() == false) goto L26;
        if (r111 == false) goto L13;
        if (PathFillType.m5126equalsimpl0(r110.mo4716getFillTypeRgk1Os(), PathFillType.Companion.m5130getEvenOddRgk1Os()) == false) goto L11;
        r100.append("  <path fill-rule=\"evenodd\" d=\"");
        goto L13
    L11:
        r100.append("  <path d=\"");
    L13:
        if (r102.hasNext() == false) goto L24;
        PathSegment.Type r112 = PathIterator.CC.next$default(r102, r103, 0, 2, null);
        switch(WhenMappings.$EnumSwitchMapping$0[r112.ordinal()]) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L13;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L13;
            default: goto L17;
        };
    L17:
        throw new NoWhenBranchMatchedException();
    L18:
        r100.append(command(PathSegment.Type.Close, r104));
    L23:
        r104 = r112;
        goto L13
    L19:
        r100.append(command(PathSegment.Type.Cubic, r104));
        StringBuilder r105 = new StringBuilder();
        r105.append(r103[2]);
        r105.append(' ');
        r105.append(r103[3]);
        r105.append(' ');
        r100.append(r105.toString());
        StringBuilder r106 = new StringBuilder();
        r106.append(r103[4]);
        r106.append(' ');
        r106.append(r103[5]);
        r106.append(' ');
        r100.append(r106.toString());
        StringBuilder r107 = new StringBuilder();
        r107.append(r103[6]);
        r107.append(' ');
        r107.append(r103[7]);
        r100.append(r107.toString());
        goto L23
    L20:
        r100.append(command(PathSegment.Type.Quadratic, r104));
        StringBuilder r108 = new StringBuilder();
        r108.append(r103[2]);
        r108.append(' ');
        r108.append(r103[3]);
        r108.append(' ');
        r108.append(r103[4]);
        r108.append(' ');
        r108.append(r103[5]);
        r100.append(r108.toString());
        goto L23
    L21:
        r100.append(command(PathSegment.Type.Line, r104) + r103[2] + ' ' + r103[3]);
        goto L23
    L22:
        r100.append(command(PathSegment.Type.Move, r104) + r103[0] + ' ' + r103[1]);
        goto L23
    L24:
        if (r111 == false) goto L26;
        r100.append("\"/>\n");
    L26:
        if (r111 == false) goto L29;
        r100.append("</svg>\n");
    L29:
        return r100.toString();
    }

    public static /* synthetic */ String toSvg$default(Path r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = false;
    L6:
        return toSvg(r100, r101);
    }
}
