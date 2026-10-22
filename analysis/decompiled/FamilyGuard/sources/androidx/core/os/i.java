package androidx.core.os;

import android.os.Trace;

@Deprecated
/* loaded from: classes.dex */
public final class i {
    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
