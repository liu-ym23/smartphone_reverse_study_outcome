package r;

import android.util.Size;
import androidx.camera.camera2.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.core.impl.SurfaceConfig;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\f¨\u0006\u000e"}, d2 = {"Lr/A;", "", "<init>", "()V", "Landroidx/camera/core/impl/SurfaceConfig$ConfigType;", "configType", "", "Landroid/util/Size;", "supportedResolutions", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/core/impl/SurfaceConfig$ConfigType;Ljava/util/List;)Ljava/util/List;", "Landroidx/camera/camera2/compat/quirk/ExtraCroppingQuirk;", "Landroidx/camera/camera2/compat/quirk/ExtraCroppingQuirk;", "extraCroppingQuirk", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: r.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5179A {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ExtraCroppingQuirk extraCroppingQuirk = (ExtraCroppingQuirk) q.f.f38470a.c(ExtraCroppingQuirk.class);

    public final List<Size> a(SurfaceConfig.ConfigType configType, List<Size> supportedResolutions) {
        Size sizeD;
        kotlin.jvm.internal.p.i(configType, "configType");
        kotlin.jvm.internal.p.i(supportedResolutions, "supportedResolutions");
        ExtraCroppingQuirk extraCroppingQuirk = this.extraCroppingQuirk;
        if (extraCroppingQuirk == null || (sizeD = extraCroppingQuirk.d(configType)) == null) {
            return supportedResolutions;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(sizeD);
        for (Size size : supportedResolutions) {
            if (!kotlin.jvm.internal.p.d(size, sizeD)) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }
}
