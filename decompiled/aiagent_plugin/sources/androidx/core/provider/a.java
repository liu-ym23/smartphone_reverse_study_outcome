package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;

/* JADX INFO: compiled from: CallbackWithHandler.java */
/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FontsContractCompat.c f1291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f1292b;

    a(FontsContractCompat.c r1, Handler r2) {
        this.f1291a = r1;
        this.f1292b = r2;
    }

    private void a(final Typeface r4) {
        final FontsContractCompat.c r0 = this.f1291a;
        this.f1292b.post(new AnonymousClass1(this, r0, r4));
    }

    private void a(final int r4) {
        final FontsContractCompat.c r0 = this.f1291a;
        this.f1292b.post(new AnonymousClass2(this, r0, r4));
    }

    void a(d.a r2) {
        if (r2.a() == false) goto L5;
        a(r2.f1318a);
        return;
    L5:
        a(r2.f1319b);
    }
}
