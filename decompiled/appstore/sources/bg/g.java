package bg;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class g {
    public static final void a(boolean r10, Number r11) {
        q.g(r11, "step");
        if (r10 == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Step must be positive, was: " + r11 + '.');
    }
}
