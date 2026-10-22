package androidx.compose.foundation.gestures;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u0010*\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0086\u0004¢\u0006\u0002\u0010\u0013J\r\u0010\u0014\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0015J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0000¢\u0006\u0002\b\u0018J\b\u0010\u0019\u001a\u00020\u0010H\u0002R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/gestures/DraggableAnchorsConfig;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "keys", "", "getKeys$foundation_release", "()Ljava/util/List;", "positions", "", "getPositions$foundation_release", "()[F", "setPositions$foundation_release", "([F)V", INotificationHitPoint.NoticeType.AT, "", "position", "", "(Ljava/lang/Object;F)V", "buildPositions", "buildPositions$foundation_release", "buildKeys", "", "buildKeys$foundation_release", "expandPositions", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DraggableAnchorsConfig<T> {
    public static final int $stable = 8;
    private final List<T> keys;
    private float[] positions;

    private final void expandPositions() {
        this.positions = Arrays.copyOf(this.positions, this.keys.size() + 2);
    }

    public final float[] buildPositions$foundation_release() {
        return ArraysKt.copyOfRange(this.positions, 0, this.keys.size());
    }

    public DraggableAnchorsConfig() {
        this.keys = new ArrayList();
        float[] r100 = new float[5];
        int r101 = 0;
    L3:
        if (r101 >= 5) goto L5;
        r100[r101] = Float.NaN;
        r101 = r101 + 1;
        goto L3
    L5:
        this.positions = r100;
    }

    public final List<T> buildKeys$foundation_release() {
        return this.keys;
    }

    public final List<T> getKeys$foundation_release() {
        return this.keys;
    }

    public final float[] getPositions$foundation_release() {
        return this.positions;
    }

    public final void setPositions$foundation_release(float[] r100) {
        this.positions = r100;
    }

    public final void at(T r100, float r101) {
        this.keys.add(r100);
        if (this.positions.length >= this.keys.size()) goto L5;
        expandPositions();
    L5:
        this.positions[this.keys.size() - 1] = r101;
    }
}
