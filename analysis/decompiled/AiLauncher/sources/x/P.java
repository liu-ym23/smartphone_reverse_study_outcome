package x;

import android.annotation.SuppressLint;
import androidx.camera.camera2.pipe.CameraGraph;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J]\u0010\u0012\u001a\u00020\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lx/P;", "", "<init>", "()V", "LX8/a;", "Landroidx/camera/camera2/pipe/compat/f;", "androidMProvider", "Landroidx/camera/camera2/pipe/compat/e;", "androidMHighSpeedProvider", "Landroidx/camera/camera2/pipe/compat/g;", "androidNProvider", "Landroidx/camera/camera2/pipe/compat/i;", "androidPProvider", "Landroidx/camera/camera2/pipe/compat/c;", "androidExtensionProvider", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "graphConfig", "Landroidx/camera/camera2/pipe/compat/r;", Const.INTENT_KEY_APIKEY, "(LX8/a;LX8/a;LX8/a;LX8/a;LX8/a;Landroidx/camera/camera2/pipe/CameraGraph$b;)Landroidx/camera/camera2/pipe/compat/r;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class P {

    /* renamed from: a, reason: collision with root package name */
    public static final P f43354a = new P();

    @SuppressLint({"ObsoleteSdkInt"})
    public final androidx.camera.camera2.pipe.compat.r a(X8.a<androidx.camera.camera2.pipe.compat.f> androidMProvider, X8.a<androidx.camera.camera2.pipe.compat.e> androidMHighSpeedProvider, X8.a<androidx.camera.camera2.pipe.compat.g> androidNProvider, X8.a<androidx.camera.camera2.pipe.compat.i> androidPProvider, X8.a<androidx.camera.camera2.pipe.compat.c> androidExtensionProvider, CameraGraph.b graphConfig) {
        kotlin.jvm.internal.p.i(androidMProvider, "androidMProvider");
        kotlin.jvm.internal.p.i(androidMHighSpeedProvider, "androidMHighSpeedProvider");
        kotlin.jvm.internal.p.i(androidNProvider, "androidNProvider");
        kotlin.jvm.internal.p.i(androidPProvider, "androidPProvider");
        kotlin.jvm.internal.p.i(androidExtensionProvider, "androidExtensionProvider");
        kotlin.jvm.internal.p.i(graphConfig, "graphConfig");
        if (CameraGraph.e.f(graphConfig.getSessionMode(), CameraGraph.e.INSTANCE.b())) {
            androidx.camera.camera2.pipe.compat.c cVar = androidExtensionProvider.get();
            kotlin.jvm.internal.p.h(cVar, "get(...)");
            return cVar;
        }
        androidx.camera.camera2.pipe.compat.i iVar = androidPProvider.get();
        kotlin.jvm.internal.p.h(iVar, "get(...)");
        return iVar;
    }
}
