package androidx.camera.camera2.compat.quirk;

import D.C0761b0;
import K.s0;
import Y8.h;
import Z8.C1168p;
import Z8.C1173v;
import Z8.F;
import android.annotation.SuppressLint;
import android.util.Log;
import android.util.Size;
import androidx.camera.camera2.compat.quirk.CamcorderProfileResolutionQuirk;
import androidx.camera.camera2.pipe.g;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p.q;
import p9.InterfaceC5063a;
import t.C5473b;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\t¨\u0006\u0011"}, d2 = {"Landroidx/camera/camera2/compat/quirk/CamcorderProfileResolutionQuirk;", "LK/s0;", "Lp/q;", "streamConfigurationMapCompat", "<init>", "(Lp/q;)V", "", "Landroid/util/Size;", "e", "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "Lp/q;", "c", "LY8/h;", Const.INTENT_KEY_UMID, "supportedResolution", Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CameraXQuirksClassDetector"})
/* loaded from: classes.dex */
public final class CamcorderProfileResolutionQuirk implements s0 {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final q streamConfigurationMapCompat;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final h supportedResolution;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/compat/quirk/CamcorderProfileResolutionQuirk$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/g;)Z", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.quirk.CamcorderProfileResolutionQuirk$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final boolean a(g cameraMetadata) {
            p.i(cameraMetadata, "cameraMetadata");
            return g.INSTANCE.l(cameraMetadata);
        }

        public Companion() {
        }
    }

    public CamcorderProfileResolutionQuirk(q streamConfigurationMapCompat) {
        p.i(streamConfigurationMapCompat, "streamConfigurationMapCompat");
        this.streamConfigurationMapCompat = streamConfigurationMapCompat;
        this.supportedResolution = C4848b.b(new InterfaceC5063a() { // from class: q.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CamcorderProfileResolutionQuirk.f(this.f38467a);
            }
        });
    }

    public static final List f(CamcorderProfileResolutionQuirk camcorderProfileResolutionQuirk) {
        List listM;
        Size[] sizeArrF = camcorderProfileResolutionQuirk.streamConfigurationMapCompat.f(34);
        if (sizeArrF == null || (listM = C1168p.d(sizeArrF)) == null) {
            listM = C1173v.m();
        }
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "supportedResolutions = " + listM);
        }
        return listM;
    }

    public final List<Size> d() {
        return (List) this.supportedResolution.getValue();
    }

    public final List<Size> e() {
        return F.m1(d());
    }
}
