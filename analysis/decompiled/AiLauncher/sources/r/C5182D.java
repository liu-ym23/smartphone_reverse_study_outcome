package r;

import androidx.camera.camera2.compat.quirk.AspectRatioLegacyApi21Quirk;
import androidx.camera.camera2.compat.quirk.Nexus4AndroidLTargetAspectRatioQuirk;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lr/D;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "Lp/q;", "streamConfigurationMapCompat", "", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/g;Lp/q;)I", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: r.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5182D {
    public final int a(androidx.camera.camera2.pipe.g cameraMetadata, p.q streamConfigurationMapCompat) {
        kotlin.jvm.internal.p.i(cameraMetadata, "cameraMetadata");
        kotlin.jvm.internal.p.i(streamConfigurationMapCompat, "streamConfigurationMapCompat");
        androidx.camera.camera2.compat.quirk.a aVar = new androidx.camera.camera2.compat.quirk.a(cameraMetadata, streamConfigurationMapCompat);
        Nexus4AndroidLTargetAspectRatioQuirk nexus4AndroidLTargetAspectRatioQuirk = (Nexus4AndroidLTargetAspectRatioQuirk) q.f.f38470a.c(Nexus4AndroidLTargetAspectRatioQuirk.class);
        if (nexus4AndroidLTargetAspectRatioQuirk != null) {
            return nexus4AndroidLTargetAspectRatioQuirk.c();
        }
        AspectRatioLegacyApi21Quirk aspectRatioLegacyApi21Quirk = (AspectRatioLegacyApi21Quirk) aVar.b().b(AspectRatioLegacyApi21Quirk.class);
        if (aspectRatioLegacyApi21Quirk != null) {
            return aspectRatioLegacyApi21Quirk.c();
        }
        return 3;
    }
}
