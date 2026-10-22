package androidx.core.os;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;

/* JADX INFO: compiled from: Bundle.kt */
/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f1259a = null;

    static {
        f1259a = new c();
    }

    private c() {
    }

    public static final void a(Bundle r0, String r1, Size r2) {
        r0.putSize(r1, r2);
    }

    public static final void a(Bundle r0, String r1, SizeF r2) {
        r0.putSizeF(r1, r2);
    }
}
