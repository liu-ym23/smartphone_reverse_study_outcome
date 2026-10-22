package androidx.camera.camera2.compat.quirk;

import K.s0;
import La.D;
import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Size;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import q.d;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ExtraSupportedOutputSizeQuirk;", "LK/s0;", "<init>", "()V", "", "format", "", "Landroid/util/Size;", "c", "(I)[Landroid/util/Size;", Const.INTENT_KEY_UMID, "()[Landroid/util/Size;", "motoE5PlayExtraSupportedResolutions", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CameraXQuirksClassDetector"})
/* loaded from: classes.dex */
public final class ExtraSupportedOutputSizeQuirk implements s0 {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ExtraSupportedOutputSizeQuirk$a;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()Z", Const.INTENT_KEY_PKGNAME, "isMotoE5Play", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.quirk.ExtraSupportedOutputSizeQuirk$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final boolean a() {
            return b();
        }

        public final boolean b() {
            return d.f38469a.h() && D.L("moto e5 play", Build.MODEL, true);
        }

        public Companion() {
        }
    }

    public final Size[] c(int format) {
        return (format == 34 && INSTANCE.b()) ? d() : new Size[0];
    }

    public final Size[] d() {
        return new Size[]{new Size(1440, 1080), new Size(960, 720)};
    }
}
