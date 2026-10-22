package z0;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* renamed from: z0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC1340f {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f24045a = Charset.forName("UTF-8");

    void b(MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
