package androidx.camera.camera2.pipe.compat;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5074l;
import x.AbstractC5822j0;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class PruningCamera2DeviceManager$queue$1 extends FunctionReferenceImpl implements InterfaceC5074l<List<AbstractC5822j0>, Y8.t> {
    public PruningCamera2DeviceManager$queue$1(Object obj) {
        super(1, obj, PruningCamera2DeviceManager.class, "prune", "prune$camera_camera2_pipe(Ljava/util/List;)V", 0);
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Y8.t invoke(List<AbstractC5822j0> list) {
        l(list);
        return Y8.t.f7040a;
    }

    public final void l(List<AbstractC5822j0> p02) {
        kotlin.jvm.internal.p.i(p02, "p0");
        ((PruningCamera2DeviceManager) this.receiver).y(p02);
    }
}
