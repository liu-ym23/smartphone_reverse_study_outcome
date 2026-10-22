package androidx.camera.core.internal.compat.quirk;

import D.i0;
import K.s0;
import android.os.Build;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.z;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class ImageCaptureFailedForSpecificCombinationQuirk implements s0 {

    /* renamed from: b, reason: collision with root package name */
    public static final Set<String> f11596b = new HashSet(Arrays.asList("pixel 4a", "pixel 4a (5g)", "pixel 5", "pixel 5a"));

    public static boolean c() {
        return "oneplus".equalsIgnoreCase(Build.BRAND) && "cph2583".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean d() {
        return "google".equalsIgnoreCase(Build.BRAND) && f11596b.contains(Build.MODEL.toLowerCase());
    }

    public static boolean f() {
        return c() || d();
    }

    public final boolean e(Collection<UseCase> collection) {
        if (collection.size() != 3) {
            return false;
        }
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        for (UseCase useCase : collection) {
            if (useCase instanceof i0) {
                z10 = true;
            } else if (useCase instanceof ImageCapture) {
                z12 = true;
            } else if (useCase.l().b(z.f11551L)) {
                z11 = useCase.l().V() == UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE;
            }
        }
        return z10 && z11 && z12;
    }

    public boolean g(String str, Collection<UseCase> collection) {
        if (c()) {
            return h(str, collection);
        }
        if (d()) {
            return i(str, collection);
        }
        return false;
    }

    public final boolean h(String str, Collection<UseCase> collection) {
        return str.equals("1") && e(collection);
    }

    public final boolean i(String str, Collection<UseCase> collection) {
        return str.equals("1") && e(collection);
    }
}
