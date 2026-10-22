package androidx.compose.ui.graphics;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0007H&J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u0007H&J\u0017\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H&¢\u0006\u0004\b\u0017\u0010\u0015R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/PathMeasure;", "", "length", "", "getLength", "()F", "getSegment", "", "startDistance", "stopDistance", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "Landroidx/compose/ui/graphics/Path;", "startWithMoveTo", "setPath", "", "path", "forceClosed", "getPosition", "Landroidx/compose/ui/geometry/Offset;", "distance", "getPosition-tuRUvjQ", "(F)J", "getTangent", "getTangent-tuRUvjQ", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PathMeasure {

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.PathMeasure$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ boolean getSegment$default(PathMeasure r100, float r101, float r102, Path r103, boolean r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L7;
            r104 = true;
        L7:
            return r100.getSegment(r101, r102, r103, r104);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSegment");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ boolean getSegment$default(PathMeasure r100, float r101, float r102, Path r103, boolean r104, int r105, Object r106) {
            return CC.getSegment$default(r100, r101, r102, r103, r104, r105, r106);
        }
    }

    float getLength();

    /* JADX INFO: renamed from: getPosition-tuRUvjQ */
    long mo4723getPositiontuRUvjQ(float r100);

    boolean getSegment(float r100, float r101, Path r102, boolean r103);

    /* JADX INFO: renamed from: getTangent-tuRUvjQ */
    long mo4724getTangenttuRUvjQ(float r100);

    void setPath(Path r100, boolean r101);
}
