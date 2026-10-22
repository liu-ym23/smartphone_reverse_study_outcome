package r;

import K.B0;
import Z8.C1173v;
import androidx.camera.camera2.compat.quirk.ExtraSupportedSurfaceCombinationsQuirk;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000b¨\u0006\r"}, d2 = {"Lr/i;", "", "<init>", "()V", "", "cameraId", "", "LK/B0;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/util/List;", "Landroidx/camera/camera2/compat/quirk/ExtraSupportedSurfaceCombinationsQuirk;", "Landroidx/camera/camera2/compat/quirk/ExtraSupportedSurfaceCombinationsQuirk;", "quirk", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: r.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5191i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ExtraSupportedSurfaceCombinationsQuirk quirk = (ExtraSupportedSurfaceCombinationsQuirk) q.f.f38470a.c(ExtraSupportedSurfaceCombinationsQuirk.class);

    public final List<B0> a(String cameraId) {
        List<B0> listE;
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        ExtraSupportedSurfaceCombinationsQuirk extraSupportedSurfaceCombinationsQuirk = this.quirk;
        return (extraSupportedSurfaceCombinationsQuirk == null || (listE = extraSupportedSurfaceCombinationsQuirk.e(cameraId)) == null) ? C1173v.m() : listE;
    }
}
