package androidx.camera.core.internal.compat.quirk;

import K.s0;
import android.os.Build;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public class LowMemoryQuirk implements s0 {

    /* renamed from: b, reason: collision with root package name */
    public static final Set<String> f11600b = new HashSet(Arrays.asList("SM-A520W", "MOTOG3"));

    public static boolean c() {
        return f11600b.contains(Build.MODEL.toUpperCase(Locale.US));
    }
}
