package androidx.compose.ui.graphics;

import com.byted.cast.common.TeaEventTrack;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019J\u0012\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H&J\t\u0010\u0013\u001a\u00020\u0012H¦\u0002J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0010H&J\t\u0010\u0014\u001a\u00020\u0002H¦\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/graphics/PathIterator;", "", "Landroidx/compose/ui/graphics/PathSegment;", "path", "Landroidx/compose/ui/graphics/Path;", "getPath", "()Landroidx/compose/ui/graphics/Path;", "conicEvaluation", "Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "getConicEvaluation", "()Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "tolerance", "", "getTolerance", "()F", "calculateSize", "", "includeConvertedConics", "", "hasNext", TeaEventTrack.ACTION_DRAMA_NEXT, "Landroidx/compose/ui/graphics/PathSegment$Type;", "outPoints", "", "offset", "ConicEvaluation", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PathIterator extends Iterator<PathSegment>, KMappedMarker {

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.PathIterator$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ int calculateSize$default(PathIterator r100, boolean r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L7;
            r101 = true;
        L7:
            return r100.calculateSize(r101);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateSize");
        }

        public static /* synthetic */ PathSegment.Type next$default(PathIterator r100, float[] r101, int r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = 0;
        L7:
            return r100.next(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: next");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "", "<init>", "(Ljava/lang/String;I)V", "AsConic", "AsQuadratics", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum ConicEvaluation extends Enum<ConicEvaluation> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ConicEvaluation[] $VALUES = null;
        public static final ConicEvaluation AsConic = null;
        public static final ConicEvaluation AsQuadratics = null;

        private static final /* synthetic */ ConicEvaluation[] $values() {
            return new ConicEvaluation[]{AsConic, AsQuadratics};
        }

        public static EnumEntries<ConicEvaluation> getEntries() {
            return $ENTRIES;
        }

        static {
            AsConic = new ConicEvaluation("AsConic", 0);
            AsQuadratics = new ConicEvaluation("AsQuadratics", 1);
            ConicEvaluation[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static ConicEvaluation[] values() {
            return (ConicEvaluation[]) $VALUES.clone();
        }

        public static ConicEvaluation valueOf(String r100) {
            return (ConicEvaluation) r27.a.a(ConicEvaluation.class, r100);
        }

        private ConicEvaluation(String r100, int r101) {
            super(r100, r101);
        }
    }

    int calculateSize(boolean r100);

    ConicEvaluation getConicEvaluation();

    Path getPath();

    float getTolerance();

    @Override // java.util.Iterator
    boolean hasNext();

    PathSegment.Type next(float[] r100, int r101);

    @Override // java.util.Iterator
    PathSegment next();
}
