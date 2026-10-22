package androidx.camera.camera2.pipe;

import androidx.camera.camera2.pipe.t;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import w.K;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\u0015R\u0014\u0010\u0006\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\nR\u001c\u0010\u0014\u001a\u00020\u000f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/l;", "TCaptureRequest", "", "", "l", "()Z", "repeating", "", "Lw/K;", "n", "()Ljava/util/List;", "captureMetadataList", "Landroidx/camera/camera2/pipe/t$a;", "o", "listeners", "", "getSequenceNumber", "()I", "m", "(I)V", "sequenceNumber", Const.INTENT_KEY_APIKEY, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface l<TCaptureRequest> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/l$a;", "", "Landroidx/camera/camera2/pipe/l;", "captureSequence", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/l;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        void a(l<?> captureSequence);
    }

    boolean l();

    void m(int i10);

    List<K> n();

    List<t.a> o();
}
