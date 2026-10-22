package androidx.lifecycle;

import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.x1;

/* JADX INFO: loaded from: classes.dex */
public abstract class l0 {
    public static final CoroutineScope a(k0 r10) {
        CoroutineScope r11 = (CoroutineScope) r10.c("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
        if (r11 == null) goto L6;
        return r11;
    L6:
        return (CoroutineScope) r10.e("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new d(x1.b(null, 1, null).plus(kotlinx.coroutines.l0.c().e())));
    }
}
