package androidx.compose.ui.graphics;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004*\u00020\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u001a\u0014\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"computeDirection", "Landroidx/compose/ui/graphics/Path$Direction;", "Landroidx/compose/ui/graphics/Path;", "divide", "", "contours", "reverse", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "floatCountForType", "", "type", "Landroidx/compose/ui/graphics/PathSegment$Type;", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PathGeometryKt {

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

    public static final Path.Direction computeDirection(Path r210) {
        PathIterator r100 = r210.iterator();
        float[] r101 = new float[8];
        PathSegment.Type r102 = PathIterator.CC.next$default(r100, r101, 0, 2, null);
        boolean r103 = true;
        float r104 = 0.0f;
        float r110 = 0.0f;
        float r111 = 0.0f;
        float r112 = 0.0f;
        float r113 = 0.0f;
    L4:
        if (r102 == PathSegment.Type.Done) goto L29;
        switch(WhenMappings.$EnumSwitchMapping$0[r102.ordinal()]) {
            case 1: goto L24;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L4;
            case 5: goto L20;
            case 6: goto L10;
            case 7: goto L29;
            default: goto L8;
        };
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        if (Math.abs(r110 - r112) >= 1.05E-6f) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L15;
    L19:
        r104 = r104 + BezierKt.cubicArea(r110, r111, r110, r111, r112, r113, r112, r113);
        r110 = r112;
        r111 = r113;
    L27:
        r102 = PathIterator.CC.next$default(r100, r101, 0, 2, null);
        goto L4
    L15:
        if (Math.abs(r111 - r113) >= 1.05E-6f) goto L17;
        boolean r106 = true;
    L18:
        if (r106 == true) goto L27;
    L17:
        r106 = false;
        goto L18
    L12:
        r105 = false;
        goto L13
    L20:
        r104 = r104 + BezierKt.cubicArea(r101[0], r101[1], r101[2], r101[3], r101[4], r101[5], r101[6], r101[7]);
        r110 = r101[6];
        r111 = r101[7];
        goto L27
    L21:
        float r211 = r101[0];
        float r212 = r101[1];
        float r107 = r101[2];
        float r114 = r101[3];
        r110 = r101[4];
        r111 = r101[5];
        float r108 = BezierKt.cubicArea(r211, r212, r211 + ((r107 - r211) * 0.6666667f), r212 + ((r114 - r212) * 0.6666667f), r110 + ((r107 - r110) * 0.6666667f), r111 + ((r114 - r111) * 0.6666667f), r110, r111);
    L23:
        r104 = r104 + r108;
        goto L27
    L22:
        float r213 = r101[0];
        float r214 = r101[1];
        r110 = r101[2];
        r111 = r101[3];
        r108 = BezierKt.cubicArea(r213, r214, r213, r214, r110, r111, r110, r111);
        goto L23
    L24:
        if (r103 == false) goto L29;
        float r109 = r101[0];
        r112 = r109;
        r113 = r101[1];
        r103 = false;
    L29:
        if (r104 < 0.0f) goto L32;
        return Path.Direction.Clockwise;
    L32:
        return Path.Direction.CounterClockwise;
    }

    private static final int floatCountForType(PathSegment.Type r100) {
        switch(WhenMappings.$EnumSwitchMapping$0[r100.ordinal()]) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L11;
            case 7: goto L11;
            default: goto L5;
        };
    L6:
        return 8;
    L7:
        return 6;
    L8:
        return 4;
    L9:
        return 2;
    L11:
        return 0;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static final List<Path> divide(Path r110, List<Path> r111) {
        Path r100 = AndroidPath_androidKt.Path();
        PathIterator r101 = r110.iterator();
        float[] r102 = new float[8];
        PathSegment.Type r103 = PathIterator.CC.next$default(r101, r102, 0, 2, null);
        boolean r104 = true;
        boolean r112 = true;
    L4:
        if (r103 == PathSegment.Type.Done) goto L19;
        switch(WhenMappings.$EnumSwitchMapping$0[r103.ordinal()]) {
            case 1: goto L14;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L4;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L4;
            default: goto L8;
        };
    L8:
        throw new NoWhenBranchMatchedException();
    L9:
        r100.close();
    L18:
        r103 = PathIterator.CC.next$default(r101, r102, 0, 2, null);
        goto L4
    L10:
        Path r105 = r100;
        r105.cubicTo(r102[2], r102[3], r102[4], r102[5], r102[6], r102[7]);
    L13:
        r104 = false;
        goto L18
    L11:
        r100.quadraticTo(r102[2], r102[3], r102[4], r102[5]);
        goto L13
    L12:
        r100.lineTo(r102[2], r102[3]);
        goto L13
    L14:
        if (r112 == true) goto L17;
        if (r104 == true) goto L17;
        r111.add(r100);
        r100 = AndroidPath_androidKt.Path();
    L17:
        r100.moveTo(r102[0], r102[1]);
        r104 = true;
        r112 = false;
        goto L18
    L19:
        if (r112 == true) goto L22;
        if (r104 == true) goto L22;
        r111.add(r100);
    L22:
        return r111;
    }

    public static final Path reverse(Path r110, Path r210) {
        PathIterator r100 = r110.iterator();
        int r101 = r100.calculateSize(false);
        ArrayList r102 = new ArrayList(r101);
        ArrayList r111 = new ArrayList(r101);
        float[] r103 = new float[8];
        PathSegment.Type r104 = PathIterator.CC.next$default(r100, r103, 0, 2, null);
    L4:
        if (r104 == PathSegment.Type.Done) goto L9;
        r102.add(r104);
        if (r104 == PathSegment.Type.Close) goto L8;
        r111.add(Arrays.copyOf(r103, floatCountForType(r104)));
    L8:
        r104 = PathIterator.CC.next$default(r100, r103, 0, 2, null);
        goto L4
    L9:
        int r105 = r111.size();
        int r112 = r102.size() - 1;
        boolean r106 = true;
        boolean r113 = false;
    L11:
        if ((-1) >= r112) goto L29;
        if (r106 == false) goto L14;
        int r107 = r105 - 1;
        float[] r108 = (float[]) ListProtector.get(r111, r107);
        int r109 = ArraysKt.getLastIndex(r108);
        r210.moveTo(r108[r109 - 1], r108[r109]);
        int r114 = r107;
        boolean r115 = false;
    L16:
        switch(WhenMappings.$EnumSwitchMapping$0[((PathSegment.Type) ListProtector.get(r102, r112)).ordinal()]) {
            case 1: goto L25;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L24;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L24;
            default: goto L18;
        };
    L19:
        r105 = r114;
        r106 = r115;
        r113 = true;
    L28:
        r112 = r112 - 1;
        goto L11
    L20:
        r210.cubicTo(r108[4], r108[5], r108[2], r108[3], r108[0], r108[1]);
    L23:
        r114 = r114 - 1;
        goto L24
    L21:
        r210.quadraticTo(r108[2], r108[3], r108[0], r108[1]);
        goto L23
    L22:
        r210.lineTo(r108[0], r108[1]);
    L24:
        r105 = r114;
        r106 = r115;
        goto L28
    L25:
        if (r113 == false) goto L27;
        r210.close();
        r113 = false;
    L27:
        r105 = r114;
        r106 = true;
        goto L28
    L18:
        throw new NoWhenBranchMatchedException();
    L14:
        r114 = r105;
        r115 = r106;
        r108 = (float[]) ListProtector.get(r111, r105);
        goto L16
    L29:
        if (r113 == false) goto L31;
        r210.close();
    L31:
        return r210;
    }

    public static /* synthetic */ List divide$default(Path r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = new ArrayList();
    L6:
        return divide(r100, r101);
    }

    public static /* synthetic */ Path reverse$default(Path r100, Path r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = AndroidPath_androidKt.Path();
    L6:
        return reverse(r100, r101);
    }
}
