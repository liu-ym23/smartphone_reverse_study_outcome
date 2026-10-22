package androidx.camera.camera2.pipe;

import androidx.camera.camera2.pipe.k;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import w.G;
import w.Q;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/pipe/v;", "", "Landroidx/camera/camera2/pipe/k$a;", "config", "Landroidx/camera/camera2/pipe/k;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroidx/camera/camera2/pipe/k$a;)Landroidx/camera/camera2/pipe/k;", "Lw/Q;", "streamId", Const.INTENT_KEY_PKGNAME, "(I)Landroidx/camera/camera2/pipe/k;", "Lw/G;", "outputId", "Landroidx/camera/camera2/pipe/s;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Landroidx/camera/camera2/pipe/s;", "", Const.INTENT_KEY_UMID, "()Ljava/util/List;", "streams", "Landroidx/camera/camera2/pipe/p;", "l", "inputs", "e", "outputs", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface v {
    default k b(int streamId) {
        Object next;
        Iterator<T> it = d().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Q.d(((k) next).getId(), streamId)) {
                break;
            }
        }
        return (k) next;
    }

    List<k> d();

    List<s> e();

    default s g(int outputId) {
        Object next;
        Iterator<T> it = e().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (G.d(((s) next).getId(), outputId)) {
                break;
            }
        }
        return (s) next;
    }

    k i(k.a config);

    List<p> l();
}
