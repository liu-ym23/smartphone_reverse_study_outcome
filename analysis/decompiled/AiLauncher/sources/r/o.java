package r;

import android.util.Size;
import androidx.camera.camera2.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.core.impl.SurfaceConfig;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n¨\u0006\u000b"}, d2 = {"Lr/o;", "", "Landroidx/camera/camera2/compat/quirk/ExtraCroppingQuirk;", "extraCroppingQuirk", "<init>", "(Landroidx/camera/camera2/compat/quirk/ExtraCroppingQuirk;)V", "Landroid/util/Size;", "defaultMaxPreviewResolution", Const.INTENT_KEY_APIKEY, "(Landroid/util/Size;)Landroid/util/Size;", "Landroidx/camera/camera2/compat/quirk/ExtraCroppingQuirk;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ExtraCroppingQuirk extraCroppingQuirk;

    public o(ExtraCroppingQuirk extraCroppingQuirk) {
        this.extraCroppingQuirk = extraCroppingQuirk;
    }

    public final Size a(Size defaultMaxPreviewResolution) {
        Size sizeD;
        kotlin.jvm.internal.p.i(defaultMaxPreviewResolution, "defaultMaxPreviewResolution");
        ExtraCroppingQuirk extraCroppingQuirk = this.extraCroppingQuirk;
        return (extraCroppingQuirk == null || (sizeD = extraCroppingQuirk.d(SurfaceConfig.ConfigType.PRIV)) == null || sizeD.getWidth() * sizeD.getHeight() <= defaultMaxPreviewResolution.getWidth() * defaultMaxPreviewResolution.getHeight()) ? defaultMaxPreviewResolution : sizeD;
    }

    public /* synthetic */ o(ExtraCroppingQuirk extraCroppingQuirk, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? (ExtraCroppingQuirk) q.f.f38470a.c(ExtraCroppingQuirk.class) : extraCroppingQuirk);
    }
}
