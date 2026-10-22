package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.PathSegment;
import androidx.compose.ui.graphics.vector.PathParser;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\b\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\r\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/Path;", "", "pathData", "LC7/r;", "addSvg", "(Landroidx/compose/ui/graphics/Path;Ljava/lang/String;)V", "", "asDocument", "toSvg", "(Landroidx/compose/ui/graphics/Path;Z)Ljava/lang/String;", "Landroidx/compose/ui/graphics/PathSegment$Type;", "type", "lastType", "command", "(Landroidx/compose/ui/graphics/PathSegment$Type;Landroidx/compose/ui/graphics/PathSegment$Type;)Ljava/lang/String;", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PathSvgKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PathSegment.Type.values().length];
            try {
                iArr[PathSegment.Type.Move.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PathSegment.Type.Line.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PathSegment.Type.Quadratic.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PathSegment.Type.Conic.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PathSegment.Type.Cubic.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PathSegment.Type.Close.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PathSegment.Type.Done.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void addSvg(Path path, String str) {
        new PathParser().parsePathString(str).toPath(path);
    }

    private static final String command(PathSegment.Type type, PathSegment.Type type2) {
        if (type == type2) {
            return " ";
        }
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 5 ? i != 6 ? "" : "Z" : "C" : "Q" : "L" : "M";
    }

    public static final String toSvg(Path path, boolean z10) {
        StringBuilder sb = new StringBuilder();
        Rect bounds = path.getBounds();
        if (z10) {
            sb.append("<svg xmlns=\"http://www.w3.org/2000/svg\" ");
            sb.append("viewBox=\"" + bounds.getLeft() + ' ' + bounds.getTop() + ' ' + (bounds.getRight() - bounds.getLeft()) + ' ' + (bounds.getBottom() - bounds.getTop()) + "\">");
            sb.append('\n');
        }
        PathIterator it = path.iterator();
        float[] fArr = new float[8];
        PathSegment.Type type = PathSegment.Type.Done;
        if (it.hasNext()) {
            if (z10) {
                if (PathFillType.m4428equalsimpl0(path.mo4028getFillTypeRgk1Os(), PathFillType.INSTANCE.m4432getEvenOddRgk1Os())) {
                    sb.append("  <path fill-rule=\"evenodd\" d=\"");
                } else {
                    sb.append("  <path d=\"");
                }
            }
            while (it.hasNext()) {
                PathSegment.Type typeNext$default = PathIterator.next$default(it, fArr, 0, 2, null);
                switch (WhenMappings.$EnumSwitchMapping$0[typeNext$default.ordinal()]) {
                    case 1:
                        sb.append(command(PathSegment.Type.Move, type) + fArr[0] + ' ' + fArr[1]);
                        type = typeNext$default;
                        break;
                    case 2:
                        sb.append(command(PathSegment.Type.Line, type) + fArr[2] + ' ' + fArr[3]);
                        type = typeNext$default;
                        break;
                    case 3:
                        sb.append(command(PathSegment.Type.Quadratic, type));
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(fArr[2]);
                        sb2.append(' ');
                        sb2.append(fArr[3]);
                        sb2.append(' ');
                        sb2.append(fArr[4]);
                        sb2.append(' ');
                        sb2.append(fArr[5]);
                        sb.append(sb2.toString());
                        type = typeNext$default;
                        break;
                    case 4:
                    case 7:
                        break;
                    case 5:
                        sb.append(command(PathSegment.Type.Cubic, type));
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(fArr[2]);
                        sb3.append(' ');
                        sb3.append(fArr[3]);
                        sb3.append(' ');
                        sb.append(sb3.toString());
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(fArr[4]);
                        sb4.append(' ');
                        sb4.append(fArr[5]);
                        sb4.append(' ');
                        sb.append(sb4.toString());
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(fArr[6]);
                        sb5.append(' ');
                        sb5.append(fArr[7]);
                        sb.append(sb5.toString());
                        type = typeNext$default;
                        break;
                    case 6:
                        sb.append(command(PathSegment.Type.Close, type));
                        type = typeNext$default;
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            if (z10) {
                sb.append("\"/>\n");
            }
        }
        if (z10) {
            sb.append("</svg>\n");
        }
        String string = sb.toString();
        k.e(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String toSvg$default(Path path, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = false;
        }
        return toSvg(path, z10);
    }
}
