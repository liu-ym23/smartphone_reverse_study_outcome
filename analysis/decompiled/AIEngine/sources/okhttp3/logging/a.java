package okhttp3.logging;

import kd.h;
import kotlin.jvm.internal.g;
import okhttp3.logging.HttpLoggingInterceptor;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements HttpLoggingInterceptor.a {
    @Override // okhttp3.logging.HttpLoggingInterceptor.a
    public final void c(String message) {
        g.f(message, "message");
        h.Companion.getClass();
        h.log$default(h.platform, message, 0, null, 6, null);
    }
}
