package androidx.camera.camera2.pipe;

import android.view.Surface;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraGraph.f;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00060\u0003j\u0002`\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00028\u0000H¦@¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/d;", "Landroidx/camera/camera2/pipe/CameraGraph$f;", "TSession", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "LY8/t;", "start", "()V", "Lw/Q;", "stream", "Landroid/view/Surface;", "surface", "a0", "(ILandroid/view/Surface;)V", "A0", "(Le9/c;)Ljava/lang/Object;", "Landroidx/camera/camera2/pipe/v;", Const.INTENT_KEY_UMID, "()Landroidx/camera/camera2/pipe/v;", "streams", "", "isForeground", "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Z)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface d<TSession extends CameraGraph.f> extends AutoCloseable {
    Object A0(InterfaceC4014c<? super TSession> interfaceC4014c);

    void a0(int stream, Surface surface);

    v d();

    void h(boolean z10);

    void start();
}
