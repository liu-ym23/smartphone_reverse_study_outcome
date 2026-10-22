package I7;

import La.C0953c;
import Z8.r;
import com.autonavi.aps.amapapi.config.Const;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"LI7/b;", "", "<init>", "()V", "", "message", "secret", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f3385a = new b();

    public static final CharSequence c(byte b10) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
        p.h(str, "format(...)");
        return str;
    }

    public final String b(String message, String secret) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        p.i(message, "message");
        p.i(secret, "secret");
        Mac mac = Mac.getInstance("HmacSHA256");
        Charset charset = C0953c.UTF_8;
        byte[] bytes = secret.getBytes(charset);
        p.h(bytes, "getBytes(...)");
        mac.init(new SecretKeySpec(bytes, "HmacSHA256"));
        byte[] bytes2 = message.getBytes(charset);
        p.h(bytes2, "getBytes(...)");
        byte[] bArrDoFinal = mac.doFinal(bytes2);
        p.h(bArrDoFinal, "doFinal(...)");
        return r.v0(bArrDoFinal, "", null, null, 0, null, new InterfaceC5074l() { // from class: I7.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return b.c(((Byte) obj).byteValue());
            }
        }, 30, null);
    }
}
