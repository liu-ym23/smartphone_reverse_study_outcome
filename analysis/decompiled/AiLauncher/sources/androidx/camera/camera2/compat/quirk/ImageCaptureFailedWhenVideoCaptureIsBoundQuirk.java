package androidx.camera.camera2.compat.quirk;

import K.s0;
import La.D;
import android.annotation.SuppressLint;
import android.os.Build;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import q.d;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00062\u00020\u00012\u00020\u0002:\u0001\bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ImageCaptureFailedWhenVideoCaptureIsBoundQuirk;", "Landroidx/camera/camera2/compat/quirk/CaptureIntentPreviewQuirk;", "", "<init>", "()V", "", Const.INTENT_KEY_PKGNAME, "()Z", Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CameraXQuirksClassDetector"})
/* loaded from: classes.dex */
public final class ImageCaptureFailedWhenVideoCaptureIsBoundQuirk implements CaptureIntentPreviewQuirk, s0 {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0014\u0010\u0012\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0014\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006R\u0014\u0010\u0016\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0017"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ImageCaptureFailedWhenVideoCaptureIsBoundQuirk$a;", "", "<init>", "()V", "", "f", "()Z", "e", "isBluStudioX10", Const.INTENT_KEY_BACKGROUND_COMMAND, "isItelW6004", "m", "isVivo1805", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "isPositivoTwist2Pro", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "isPixel4XLApi29", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "isMotoE13", "l", "isSamsungTabA8", "k", "isSamsungA53", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.quirk.ImageCaptureFailedWhenVideoCaptureIsBoundQuirk$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final boolean e() {
            return d.f38469a.b() && D.L("studio x10", Build.MODEL, true);
        }

        public final boolean f() {
            return e() || g() || m() || j() || i() || h() || l() || k() || d.f38469a.r();
        }

        public final boolean g() {
            return d.f38469a.f() && D.L("itel w6004", Build.MODEL, true);
        }

        public final boolean h() {
            return d.f38469a.h() && D.L("moto e13", Build.MODEL, true);
        }

        public final boolean i() {
            D.L("pixel 4 xl", Build.MODEL, true);
            return false;
        }

        public final boolean j() {
            return d.f38469a.m() && D.L("twist 2 pro", Build.MODEL, true);
        }

        public final boolean k() {
            if (d.f38469a.o()) {
                String MODEL = Build.MODEL;
                p.h(MODEL, "MODEL");
                if (D.X(MODEL, "SM-A536", false, 2, null)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean l() {
            if (!d.f38469a.o()) {
                return false;
            }
            String str = Build.DEVICE;
            return D.L("gta8", str, true) || D.L("gta8wifi", str, true);
        }

        public final boolean m() {
            return d.f38469a.s() && D.L("vivo 1805", Build.MODEL, true);
        }

        public Companion() {
        }
    }

    @Override // androidx.camera.camera2.compat.quirk.CaptureIntentPreviewQuirk
    public boolean b() {
        Companion companion = INSTANCE;
        return companion.e() || companion.g() || companion.m() || companion.j();
    }
}
