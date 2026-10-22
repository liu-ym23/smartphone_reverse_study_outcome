package androidx.camera.core.internal.compat.quirk;

import K.s0;
import La.D;
import android.annotation.SuppressLint;
import android.os.Build;
import androidx.camera.core.UseCase;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u000e\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/camera/core/internal/compat/quirk/PreviewGreenTintQuirk;", "LK/s0;", "<init>", "()V", "", Const.INTENT_KEY_UMID, "()Z", "", "cameraId", "", "Landroidx/camera/core/UseCase;", "appUseCases", "e", "(Ljava/lang/String;Ljava/util/Collection;)Z", "f", "c", "isMotoE20", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CameraXQuirksClassDetector"})
/* loaded from: classes.dex */
public final class PreviewGreenTintQuirk implements s0 {

    /* renamed from: b, reason: collision with root package name */
    public static final PreviewGreenTintQuirk f11601b = new PreviewGreenTintQuirk();

    private PreviewGreenTintQuirk() {
    }

    public static final boolean d() {
        return f11601b.c();
    }

    public static final boolean e(String cameraId, Collection<? extends UseCase> appUseCases) {
        p.i(cameraId, "cameraId");
        p.i(appUseCases, "appUseCases");
        PreviewGreenTintQuirk previewGreenTintQuirk = f11601b;
        if (previewGreenTintQuirk.c()) {
            return previewGreenTintQuirk.f(cameraId, appUseCases);
        }
        return false;
    }

    public final boolean c() {
        return D.L("motorola", Build.BRAND, true) && D.L("moto e20", Build.MODEL, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0070 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(java.lang.String r5, java.util.Collection<? extends androidx.camera.core.UseCase> r6) {
        /*
            r4 = this;
            java.lang.String r4 = "0"
            boolean r4 = kotlin.jvm.internal.p.d(r5, r4)
            r5 = 0
            if (r4 == 0) goto L73
            int r4 = r6.size()
            r0 = 2
            if (r4 == r0) goto L11
            goto L73
        L11:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            boolean r4 = r6 instanceof java.util.Collection
            r0 = 1
            if (r4 == 0) goto L23
            r1 = r6
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L23
        L21:
            r1 = r5
            goto L38
        L23:
            java.util.Iterator r1 = r6.iterator()
        L27:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L21
            java.lang.Object r2 = r1.next()
            androidx.camera.core.UseCase r2 = (androidx.camera.core.UseCase) r2
            boolean r2 = r2 instanceof D.i0
            if (r2 == 0) goto L27
            r1 = r0
        L38:
            if (r4 == 0) goto L45
            r4 = r6
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L45
        L43:
            r4 = r5
            goto L6e
        L45:
            java.util.Iterator r4 = r6.iterator()
        L49:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L43
            java.lang.Object r6 = r4.next()
            androidx.camera.core.UseCase r6 = (androidx.camera.core.UseCase) r6
            androidx.camera.core.impl.z r2 = r6.l()
            androidx.camera.core.impl.Config$a<androidx.camera.core.impl.UseCaseConfigFactory$CaptureType> r3 = androidx.camera.core.impl.z.f11551L
            boolean r2 = r2.b(r3)
            if (r2 == 0) goto L49
            androidx.camera.core.impl.z r6 = r6.l()
            androidx.camera.core.impl.UseCaseConfigFactory$CaptureType r6 = r6.V()
            androidx.camera.core.impl.UseCaseConfigFactory$CaptureType r2 = androidx.camera.core.impl.UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE
            if (r6 != r2) goto L49
            r4 = r0
        L6e:
            if (r1 == 0) goto L73
            if (r4 == 0) goto L73
            return r0
        L73:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.compat.quirk.PreviewGreenTintQuirk.f(java.lang.String, java.util.Collection):boolean");
    }
}
