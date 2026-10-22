package okhttp3.internal.g;

import d.h.b.o;
import java.io.IOException;

/* JADX INFO: compiled from: StreamResetException.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class n extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f40087a;

    public n(b r3) {
        o.e(r3, "errorCode");
        super("stream was reset: " + r3);
        this.f40087a = r3;
    }
}
