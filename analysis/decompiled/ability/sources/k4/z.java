package k4;

import java.security.SecureRandom;
import java.util.Base64;

/* loaded from: classes3.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final String f4820a;

    public z() {
        Base64.Encoder encoderWithoutPadding = Base64.getUrlEncoder().withoutPadding();
        byte[] bArr = new byte[32];
        new SecureRandom().nextBytes(bArr);
        String strEncodeToString = encoderWithoutPadding.encodeToString(bArr);
        kotlin.jvm.internal.k.e(strEncodeToString, "encodeToString(...)");
        this.f4820a = strEncodeToString;
    }
}
