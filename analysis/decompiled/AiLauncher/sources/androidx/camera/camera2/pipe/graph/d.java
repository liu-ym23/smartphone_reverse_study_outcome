package androidx.camera.camera2.pipe.graph;

import androidx.camera.camera2.pipe.graph.GraphLoop;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import w.x;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/graph/d;", "Landroidx/camera/camera2/pipe/graph/GraphLoop$b;", "Lw/L;", "requestNumber", "LY8/t;", "c", "(J)V", "Lw/x;", "frameMetadata", "", Const.INTENT_KEY_APIKEY, "(JLw/x;)Z", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface d extends GraphLoop.b {
    boolean a(long requestNumber, x frameMetadata);

    void c(long requestNumber);
}
