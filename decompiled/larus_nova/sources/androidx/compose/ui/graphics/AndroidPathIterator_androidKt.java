package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"PathIterator", "Landroidx/compose/ui/graphics/PathIterator;", "path", "Landroidx/compose/ui/graphics/Path;", "conicEvaluation", "Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "tolerance", "", "toPathSegmentType", "Landroidx/compose/ui/graphics/PathSegment$Type;", "Landroidx/graphics/path/PathSegment$Type;", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidPathIterator_androidKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[androidx.graphics.path.PathSegment.Type.values().length];
            r100[androidx.graphics.path.PathSegment.Type.Move.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[androidx.graphics.path.PathSegment.Type.Line.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[androidx.graphics.path.PathSegment.Type.Quadratic.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[androidx.graphics.path.PathSegment.Type.Conic.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[androidx.graphics.path.PathSegment.Type.Cubic.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[androidx.graphics.path.PathSegment.Type.Close.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[androidx.graphics.path.PathSegment.Type.Done.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public static final /* synthetic */ PathSegment.Type access$toPathSegmentType(androidx.graphics.path.PathSegment.Type r100) {
        return toPathSegmentType(r100);
    }

    private static final PathSegment.Type toPathSegmentType(androidx.graphics.path.PathSegment.Type r100) {
        switch(WhenMappings.$EnumSwitchMapping$0[r100.ordinal()]) {
            case 1: goto L13;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L14:
        return PathSegment.Type.Done;
    L15:
        return PathSegment.Type.Close;
    L16:
        return PathSegment.Type.Cubic;
    L17:
        return PathSegment.Type.Conic;
    L18:
        return PathSegment.Type.Quadratic;
    L19:
        return PathSegment.Type.Line;
    L13:
        return PathSegment.Type.Move;
    }

    public static final PathIterator PathIterator(Path r100, PathIterator.ConicEvaluation r101, float r102) {
        return new AndroidPathIterator(r100, r101, r102);
    }

    public static /* synthetic */ PathIterator PathIterator$default(Path r100, PathIterator.ConicEvaluation r101, float r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = PathIterator.ConicEvaluation.AsQuadratics;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r102 = 0.25f;
    L9:
        return PathIterator(r100, r101, r102);
    }
}
