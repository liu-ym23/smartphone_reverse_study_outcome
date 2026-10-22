package r3;

import android.os.Trace;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static void a(String r10) {
        if (a.d() == false) goto L6;
        Trace.beginSection(r10);
        return;
    }

    public static void b() {
        if (a.d() == false) goto L6;
        Trace.endSection();
        return;
    }
}
