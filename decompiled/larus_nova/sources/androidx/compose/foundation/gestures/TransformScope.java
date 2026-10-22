package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/TransformScope;", "", "transformBy", "", "zoomChange", "", "panChange", "Landroidx/compose/ui/geometry/Offset;", "rotationChange", "transformBy-d-4ec7I", "(FJF)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface TransformScope {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: transformBy-d-4ec7I$default, reason: not valid java name */
        public static /* synthetic */ void m534transformByd4ec7I$default(TransformScope r100, float r101, long r102, float r103, int r104, Object r105) {
            if (r105 != null) goto L15;
            if ((r104 & 1) == 0) goto L7;
            r101 = 1.0f;
        L7:
            if ((r104 & 2) == 0) goto L10;
            r102 = Offset.Companion.m4598getZeroF1C5BW0();
        L10:
            if ((r104 & 4) == 0) goto L12;
            r103 = 0.0f;
        L12:
            r100.mo409transformByd4ec7I(r101, r102, r103);
            return;
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transformBy-d-4ec7I");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX INFO: renamed from: transformBy-d-4ec7I$default, reason: not valid java name */
        public static /* synthetic */ void m535transformByd4ec7I$default(TransformScope r100, float r101, long r102, float r103, int r104, Object r105) {
            CC.m534transformByd4ec7I$default(r100, r101, r102, r103, r104, r105);
        }
    }

    /* JADX INFO: renamed from: transformBy-d-4ec7I */
    void mo409transformByd4ec7I(float r100, long r101, float r102);
}
