package r;

import android.hardware.camera2.CaptureRequest;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.compat.quirk.PreviewPixelHDRnetQuirk;
import androidx.camera.camera2.impl.a;
import androidx.camera.core.impl.SessionConfig;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\n\"\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/camera/core/impl/SessionConfig$b;", "Landroid/util/Size;", "resolution", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/core/impl/SessionConfig$b;Landroid/util/Size;)V", "Landroid/util/Rational;", "aspectRatio", "", Const.INTENT_KEY_APIKEY, "(Landroid/util/Size;Landroid/util/Rational;)Z", "Landroid/util/Rational;", "ASPECT_RATIO_16_9", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public static final Rational f38724a = new Rational(16, 9);

    public static final boolean a(Size size, Rational rational) {
        return kotlin.jvm.internal.p.d(rational, new Rational(size.getWidth(), size.getHeight()));
    }

    public static final void b(SessionConfig.b bVar, Size resolution) {
        kotlin.jvm.internal.p.i(bVar, "<this>");
        kotlin.jvm.internal.p.i(resolution, "resolution");
        if (((PreviewPixelHDRnetQuirk) q.f.f38470a.c(PreviewPixelHDRnetQuirk.class)) == null || a(resolution, f38724a)) {
            return;
        }
        a.C0131a c0131a = new a.C0131a();
        CaptureRequest.Key TONEMAP_MODE = CaptureRequest.TONEMAP_MODE;
        kotlin.jvm.internal.p.h(TONEMAP_MODE, "TONEMAP_MODE");
        c0131a.g(TONEMAP_MODE, 2);
        bVar.g(c0131a.c());
    }
}
