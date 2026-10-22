package androidx.camera.camera2.compat.quirk;

import K.s0;
import La.D;
import android.annotation.SuppressLint;
import android.os.Build;
import androidx.camera.camera2.pipe.CameraGraph;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Landroidx/camera/camera2/compat/quirk/FinalizeSessionOnCloseQuirk;", "LK/s0;", "<init>", "()V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CameraXQuirksClassDetector"})
/* loaded from: classes.dex */
public final class FinalizeSessionOnCloseQuirk implements s0 {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/compat/quirk/FinalizeSessionOnCloseQuirk$a;", "", "<init>", "()V", "", Const.INTENT_KEY_PKGNAME, "()Z", "Landroidx/camera/camera2/pipe/CameraGraph$d$a;", Const.INTENT_KEY_APIKEY, "()I", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.quirk.FinalizeSessionOnCloseQuirk$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final int a() {
            String MODEL = Build.MODEL;
            p.h(MODEL, "MODEL");
            Locale locale = Locale.getDefault();
            p.h(locale, "getDefault(...)");
            String lowerCase = MODEL.toLowerCase(locale);
            p.h(lowerCase, "toLowerCase(...)");
            return D.X(lowerCase, "cph", false, 2, null) ? CameraGraph.Flags.a.INSTANCE.a() : CameraGraph.Flags.a.INSTANCE.b();
        }

        public final boolean b() {
            return true;
        }

        public Companion() {
        }
    }
}
