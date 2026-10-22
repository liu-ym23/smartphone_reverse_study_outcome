package wa;

import android.util.Base64;
import com.bytedanceos.common.toolbox.k;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static final /* synthetic */ String a(RequestBody r10) {
        return e(r10);
    }

    public static final String b(byte[] r10) {
        if (r10 != null) goto L4;
    L7:
        return "";
    L4:
        if (r10.length == 0) goto L7;
        return Base64.encodeToString(r10, 2);
    }

    public static final byte[] c(byte[] r10, byte[] r11) {
        return d(r10, r11, "HmacSHA256");
    }

    public static final byte[] d(byte[] r10, byte[] r11, String r12) {
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.length == 0) goto L25;
        if (r11 != null) goto L9;
        return null;
    L9:
        if (r11.length == 0) goto L26;
        SecretKeySpec r13 = new SecretKeySpec(r11, r12);     // Catch: NoSuchAlgorithmException -> L13 InvalidKeyException -> L15
        Mac r14 = Mac.getInstance(r12);     // Catch: NoSuchAlgorithmException -> L13 InvalidKeyException -> L15
        r14.init(r13);     // Catch: NoSuchAlgorithmException -> L13 InvalidKeyException -> L15
    L27:
        return r14.doFinal(r10);
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    L26:
        return null;
    L25:
        return null;
    }

    public static final String e(RequestBody r10) {
        Buffer r11 = new Buffer();
        r10.g(r11);
        MediaType r12 = r10.b();
        if (r12 == null) goto L5;
        Charset r13 = r12.b(StandardCharsets.UTF_8);
    L6:
        if (r13 != null) goto L9;
        r13 = StandardCharsets.UTF_8;
        q.f(r13, "UTF_8");
    L9:
        if (va.b.a(r11) == false) goto L14;
        String r14 = r11.readString(r13);
        if (o.r(r14) == false) goto L13;
        return null;
    L13:
        return k.f(r14);
    L14:
        return null;
    L5:
        r13 = null;
        goto L6
    }
}
