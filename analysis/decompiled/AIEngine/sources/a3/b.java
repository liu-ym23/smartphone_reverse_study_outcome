package a3;

import a3.j;
import java.lang.ref.SoftReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final j f12a;

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<SoftReference<a>> f13b;

    static {
        boolean zEquals;
        try {
            zEquals = "true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers"));
        } catch (SecurityException unused) {
            zEquals = false;
        }
        f12a = zEquals ? j.a.f36a : null;
        f13b = new ThreadLocal<>();
    }
}
