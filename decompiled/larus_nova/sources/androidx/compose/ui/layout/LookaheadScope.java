package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0003H&J/\u0010\b\u001a\u00020\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u0003*\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/LookaheadScope;", "", "toLookaheadCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "sourceCoordinates", "relativeToSource", "includeMotionFrameOfReference", "", "localLookaheadPositionOf-au-aQtc", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface LookaheadScope {

    /* JADX INFO: renamed from: androidx.compose.ui.layout.LookaheadScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: $default$localLookaheadPositionOf-au-aQtc, reason: not valid java name */
        public static long m6290$default$localLookaheadPositionOfauaQtc(LookaheadScope r100, LayoutCoordinates r101, LayoutCoordinates r102, long r103, boolean r104) {
            return LookaheadScopeKt.m6292localLookaheadPositionOfFgt4K4Q(r100, r101, r102, r103, r104);
        }

        /* JADX INFO: renamed from: localLookaheadPositionOf-au-aQtc$default, reason: not valid java name */
        public static /* synthetic */ long m6291localLookaheadPositionOfauaQtc$default(LookaheadScope r100, LayoutCoordinates r101, LayoutCoordinates r102, long r103, boolean r110, int r111, Object r112) {
            if (r112 != null) goto L13;
            if ((r111 & 2) == 0) goto L6;
            r103 = Offset.Companion.m4598getZeroF1C5BW0();
        L6:
            long r104 = r103;
            if ((r111 & 4) == 0) goto L9;
            boolean r105 = true;
        L11:
            return r100.mo106localLookaheadPositionOfauaQtc(r101, r102, r104, r105);
        L9:
            r105 = r110;
            goto L11
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localLookaheadPositionOf-au-aQtc");
        }
    }

    LayoutCoordinates getLookaheadScopeCoordinates(Placeable.PlacementScope r100);

    /* JADX INFO: renamed from: localLookaheadPositionOf-au-aQtc */
    long mo106localLookaheadPositionOfauaQtc(LayoutCoordinates r100, LayoutCoordinates r101, long r102, boolean r103);

    LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates r100);
}
