package androidx.camera.camera2.pipe;

import Ua.Q;
import Z8.C1173v;
import androidx.camera.camera2.pipe.CameraGraph;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import w.C5708n;
import w.InterfaceC5702h;
import w.InterfaceC5703i;
import w.T;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0018\u00010\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0003H&¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b\u000f\u0010\u0010J?\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010!\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0015H\u0096@¢\u0006\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020#8&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R \u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006+À\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/pipe/b;", "", "", "Lw/n;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/List;", "", "c", "()Ljava/util/Set;", "cameraId", "Landroidx/camera/camera2/pipe/g;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/g;", "LUa/Q;", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()LUa/Q;", "Lw/h;", "cameraContext", "Landroidx/camera/camera2/pipe/e;", "graphId", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "graphConfig", "LA/e;", "graphListener", "Landroidx/camera/camera2/pipe/v;", "streamGraph", "Lw/T;", "surfaceTracker", "Lw/i;", Const.INTENT_KEY_UMID, "(Lw/h;Landroidx/camera/camera2/pipe/e;Landroidx/camera/camera2/pipe/CameraGraph$b;LA/e;Landroidx/camera/camera2/pipe/v;Lw/T;)Lw/i;", "Landroidx/camera/camera2/pipe/o;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/camera2/pipe/CameraGraph$b;Le9/c;)Ljava/lang/Object;", "Lw/e;", "e", "()Ljava/lang/String;", "id", "LXa/b;", "f", "()LXa/b;", "cameraIds", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface b {
    static /* synthetic */ Object h(b bVar, CameraGraph.b bVar2, InterfaceC4014c<? super o> interfaceC4014c) {
        return o.c(o.INSTANCE.b());
    }

    g a(String cameraId);

    default Object b(CameraGraph.b bVar, InterfaceC4014c<? super o> interfaceC4014c) {
        return h(this, bVar, interfaceC4014c);
    }

    Set<Set<C5708n>> c();

    InterfaceC5703i d(InterfaceC5702h cameraContext, e graphId, CameraGraph.b graphConfig, A.e graphListener, v streamGraph, T surfaceTracker);

    String e();

    default Xa.b<List<C5708n>> f() {
        List<C5708n> listG = g();
        if (listG == null) {
            listG = C1173v.m();
        }
        return Xa.d.D(listG);
    }

    List<C5708n> g();

    Q<Y8.t> j();
}
