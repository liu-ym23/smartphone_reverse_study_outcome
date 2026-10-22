package androidx.camera.camera2.compat.quirk;

import Z8.C1173v;
import android.annotation.SuppressLint;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ImageCaptureFlashNotFireQuirk;", "Landroidx/camera/camera2/compat/quirk/UseTorchAsFlashQuirk;", "<init>", "()V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CameraXQuirksClassDetector"})
/* loaded from: classes.dex */
public final class ImageCaptureFlashNotFireQuirk implements UseTorchAsFlashQuirk {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final List<String> f9456c = C1173v.p("itel w6004", "sm-j700m");

    /* renamed from: d, reason: collision with root package name */
    public static final List<String> f9457d = C1173v.p("sm-j700f", "sm-j710f");

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ImageCaptureFlashNotFireQuirk$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/g;)Z", "", "", "BUILD_MODELS", "Ljava/util/List;", "BUILD_MODELS_FRONT_CAMERA", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.quirk.ImageCaptureFlashNotFireQuirk$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean a(androidx.camera.camera2.pipe.g r8) {
            /*
                r7 = this;
                java.lang.String r7 = "cameraMetadata"
                kotlin.jvm.internal.p.i(r8, r7)
                java.util.List r7 = androidx.camera.camera2.compat.quirk.ImageCaptureFlashNotFireQuirk.d()
                java.lang.String r0 = android.os.Build.MODEL
                java.lang.String r1 = "MODEL"
                kotlin.jvm.internal.p.h(r0, r1)
                java.util.Locale r2 = java.util.Locale.ROOT
                java.lang.String r3 = r0.toLowerCase(r2)
                java.lang.String r4 = "toLowerCase(...)"
                kotlin.jvm.internal.p.h(r3, r4)
                boolean r7 = r7.contains(r3)
                r3 = 0
                r5 = 1
                if (r7 == 0) goto L3b
                android.hardware.camera2.CameraCharacteristics$Key r7 = android.hardware.camera2.CameraCharacteristics.LENS_FACING
                java.lang.String r6 = "LENS_FACING"
                kotlin.jvm.internal.p.h(r7, r6)
                java.lang.Object r7 = r8.e0(r7)
                java.lang.Integer r7 = (java.lang.Integer) r7
                if (r7 != 0) goto L33
                goto L3b
            L33:
                int r7 = r7.intValue()
                if (r7 != 0) goto L3b
                r7 = r5
                goto L3c
            L3b:
                r7 = r3
            L3c:
                java.util.List r8 = androidx.camera.camera2.compat.quirk.ImageCaptureFlashNotFireQuirk.c()
                kotlin.jvm.internal.p.h(r0, r1)
                java.lang.String r0 = r0.toLowerCase(r2)
                kotlin.jvm.internal.p.h(r0, r4)
                boolean r8 = r8.contains(r0)
                if (r7 != 0) goto L54
                if (r8 == 0) goto L53
                goto L54
            L53:
                return r3
            L54:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.compat.quirk.ImageCaptureFlashNotFireQuirk.Companion.a(androidx.camera.camera2.pipe.g):boolean");
        }

        public Companion() {
        }
    }
}
