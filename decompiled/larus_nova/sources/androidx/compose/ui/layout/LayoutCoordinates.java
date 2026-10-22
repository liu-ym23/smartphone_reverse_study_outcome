package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001e\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0018H&¢\u0006\u0004\b!\u0010\u001bJ\u0017\u0010\"\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018H&¢\u0006\u0004\b#\u0010\u001bJ\u0017\u0010$\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018H&¢\u0006\u0004\b%\u0010\u001bJ\u001f\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0018H&¢\u0006\u0004\b)\u0010*J+\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\u00182\b\b\u0002\u0010+\u001a\u00020\u0011H\u0016¢\u0006\u0004\b,\u0010-J\u001a\u0010.\u001a\u00020/2\u0006\u0010'\u001a\u00020\u00002\b\b\u0002\u00100\u001a\u00020\u0011H&J\u001f\u00101\u001a\u0002022\u0006\u0010'\u001a\u00020\u00002\u0006\u00103\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016¢\u0006\u0004\b8\u00109J\u0011\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\bH¦\u0002R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00118VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006=À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/LayoutCoordinates;", "", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentCoordinates", "getParentCoordinates", "isAttached", "", "()Z", "introducesMotionFrameOfReference", "getIntroducesMotionFrameOfReference$annotations", "()V", "getIntroducesMotionFrameOfReference", "screenToLocal", "Landroidx/compose/ui/geometry/Offset;", "relativeToScreen", "screenToLocal-MK-Hz9U", "(J)J", "localToScreen", "relativeToLocal", "localToScreen-MK-Hz9U", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "localToRoot", "localToRoot-MK-Hz9U", "localPositionOf", "sourceCoordinates", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "includeMotionFrameOfReference", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "clipBounds", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", MonitorConstants.CONNECT_TYPE_GET, "", "alignmentLine", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface LayoutCoordinates {

    /* JADX INFO: renamed from: androidx.compose.ui.layout.LayoutCoordinates$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$getIntroducesMotionFrameOfReference(LayoutCoordinates r100) {
            return false;
        }

        public static /* synthetic */ boolean access$getIntroducesMotionFrameOfReference$jd(LayoutCoordinates r100) {
            return $default$getIntroducesMotionFrameOfReference(r100);
        }

        /* JADX INFO: renamed from: $default$localToScreen-MK-Hz9U, reason: not valid java name */
        public static long m6269$default$localToScreenMKHz9U(LayoutCoordinates r100, long r101) {
            return Offset.Companion.m4597getUnspecifiedF1C5BW0();
        }

        /* JADX INFO: renamed from: $default$screenToLocal-MK-Hz9U, reason: not valid java name */
        public static long m6270$default$screenToLocalMKHz9U(LayoutCoordinates r100, long r101) {
            return Offset.Companion.m4597getUnspecifiedF1C5BW0();
        }

        /* JADX INFO: renamed from: $default$transformToScreen-58bKbWc, reason: not valid java name */
        public static void m6272$default$transformToScreen58bKbWc(LayoutCoordinates r100, float[] r101) {
            throw new UnsupportedOperationException("transformToScreen is not implemented on this LayoutCoordinates");
        }

        /* JADX INFO: renamed from: access$localToScreen-MK-Hz9U$jd, reason: not valid java name */
        public static /* synthetic */ long m6274access$localToScreenMKHz9U$jd(LayoutCoordinates r100, long r101) {
            return m6269$default$localToScreenMKHz9U(r100, r101);
        }

        /* JADX INFO: renamed from: access$screenToLocal-MK-Hz9U$jd, reason: not valid java name */
        public static /* synthetic */ long m6275access$screenToLocalMKHz9U$jd(LayoutCoordinates r100, long r101) {
            return m6270$default$screenToLocalMKHz9U(r100, r101);
        }

        /* JADX INFO: renamed from: access$transformToScreen-58bKbWc$jd, reason: not valid java name */
        public static /* synthetic */ void m6277access$transformToScreen58bKbWc$jd(LayoutCoordinates r100, float[] r101) {
            m6272$default$transformToScreen58bKbWc(r100, r101);
        }

        /* JADX INFO: renamed from: $default$transformFrom-EL8BTi8, reason: not valid java name */
        public static void m6271$default$transformFromEL8BTi8(LayoutCoordinates r100, LayoutCoordinates r101, float[] r102) {
            InlineClassHelperKt.throwUnsupportedOperationException("transformFrom is not implemented on this LayoutCoordinates");
        }

        /* JADX INFO: renamed from: access$transformFrom-EL8BTi8$jd, reason: not valid java name */
        public static /* synthetic */ void m6276access$transformFromEL8BTi8$jd(LayoutCoordinates r100, LayoutCoordinates r101, float[] r102) {
            m6271$default$transformFromEL8BTi8(r100, r101, r102);
        }

        /* JADX INFO: renamed from: $default$localPositionOf-S_NoaFU, reason: not valid java name */
        public static long m6268$default$localPositionOfS_NoaFU(LayoutCoordinates r100, LayoutCoordinates r101, long r102, boolean r103) {
            throw new UnsupportedOperationException("localPositionOf is not implemented on this LayoutCoordinates");
        }

        /* JADX INFO: renamed from: access$localPositionOf-S_NoaFU$jd, reason: not valid java name */
        public static /* synthetic */ long m6273access$localPositionOfS_NoaFU$jd(LayoutCoordinates r100, LayoutCoordinates r101, long r102, boolean r103) {
            return m6268$default$localPositionOfS_NoaFU(r100, r101, r102, r103);
        }

        public static /* synthetic */ Rect localBoundingBoxOf$default(LayoutCoordinates r100, LayoutCoordinates r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = true;
        L7:
            return r100.localBoundingBoxOf(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localBoundingBoxOf");
        }

        /* JADX INFO: renamed from: localPositionOf-S_NoaFU$default, reason: not valid java name */
        public static /* synthetic */ long m6278localPositionOfS_NoaFU$default(LayoutCoordinates r100, LayoutCoordinates r101, long r102, boolean r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = Offset.Companion.m4598getZeroF1C5BW0();
        L7:
            if ((r104 & 4) == 0) goto L10;
            r103 = true;
        L10:
            return r100.mo6260localPositionOfS_NoaFU(r101, r102, r103);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localPositionOf-S_NoaFU");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getIntroducesMotionFrameOfReference$annotations() {
        }

        public static boolean getIntroducesMotionFrameOfReference(LayoutCoordinates r100) {
            return CC.access$getIntroducesMotionFrameOfReference$jd(r100);
        }

        /* JADX INFO: renamed from: localToScreen-MK-Hz9U, reason: not valid java name */
        public static long m6281localToScreenMKHz9U(LayoutCoordinates r100, long r101) {
            return CC.m6274access$localToScreenMKHz9U$jd(r100, r101);
        }

        /* JADX INFO: renamed from: screenToLocal-MK-Hz9U, reason: not valid java name */
        public static long m6282screenToLocalMKHz9U(LayoutCoordinates r100, long r101) {
            return CC.m6275access$screenToLocalMKHz9U$jd(r100, r101);
        }

        /* JADX INFO: renamed from: transformToScreen-58bKbWc, reason: not valid java name */
        public static void m6284transformToScreen58bKbWc(LayoutCoordinates r100, float[] r101) {
            CC.m6277access$transformToScreen58bKbWc$jd(r100, r101);
        }

        /* JADX INFO: renamed from: transformFrom-EL8BTi8, reason: not valid java name */
        public static void m6283transformFromEL8BTi8(LayoutCoordinates r100, LayoutCoordinates r101, float[] r102) {
            CC.m6276access$transformFromEL8BTi8$jd(r100, r101, r102);
        }

        /* JADX INFO: renamed from: localPositionOf-S_NoaFU, reason: not valid java name */
        public static long m6279localPositionOfS_NoaFU(LayoutCoordinates r100, LayoutCoordinates r101, long r102, boolean r103) {
            return CC.m6273access$localPositionOfS_NoaFU$jd(r100, r101, r102, r103);
        }

        public static /* synthetic */ Rect localBoundingBoxOf$default(LayoutCoordinates r100, LayoutCoordinates r101, boolean r102, int r103, Object r104) {
            return CC.localBoundingBoxOf$default(r100, r101, r102, r103, r104);
        }

        /* JADX INFO: renamed from: localPositionOf-S_NoaFU$default, reason: not valid java name */
        public static /* synthetic */ long m6280localPositionOfS_NoaFU$default(LayoutCoordinates r100, LayoutCoordinates r101, long r102, boolean r103, int r104, Object r105) {
            return CC.m6278localPositionOfS_NoaFU$default(r100, r101, r102, r103, r104, r105);
        }
    }

    int get(AlignmentLine r100);

    boolean getIntroducesMotionFrameOfReference();

    LayoutCoordinates getParentCoordinates();

    LayoutCoordinates getParentLayoutCoordinates();

    Set<AlignmentLine> getProvidedAlignmentLines();

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo6258getSizeYbymL2g();

    boolean isAttached();

    Rect localBoundingBoxOf(LayoutCoordinates r100, boolean r101);

    /* JADX INFO: renamed from: localPositionOf-R5De75A, reason: not valid java name */
    long mo6259localPositionOfR5De75A(LayoutCoordinates r100, long r101);

    /* JADX INFO: renamed from: localPositionOf-S_NoaFU, reason: not valid java name */
    long mo6260localPositionOfS_NoaFU(LayoutCoordinates r100, long r101, boolean r102);

    /* JADX INFO: renamed from: localToRoot-MK-Hz9U, reason: not valid java name */
    long mo6261localToRootMKHz9U(long r100);

    /* JADX INFO: renamed from: localToScreen-MK-Hz9U, reason: not valid java name */
    long mo6262localToScreenMKHz9U(long r100);

    /* JADX INFO: renamed from: localToWindow-MK-Hz9U, reason: not valid java name */
    long mo6263localToWindowMKHz9U(long r100);

    /* JADX INFO: renamed from: screenToLocal-MK-Hz9U, reason: not valid java name */
    long mo6264screenToLocalMKHz9U(long r100);

    /* JADX INFO: renamed from: transformFrom-EL8BTi8, reason: not valid java name */
    void mo6265transformFromEL8BTi8(LayoutCoordinates r100, float[] r101);

    /* JADX INFO: renamed from: transformToScreen-58bKbWc, reason: not valid java name */
    void mo6266transformToScreen58bKbWc(float[] r100);

    /* JADX INFO: renamed from: windowToLocal-MK-Hz9U, reason: not valid java name */
    long mo6267windowToLocalMKHz9U(long r100);
}
