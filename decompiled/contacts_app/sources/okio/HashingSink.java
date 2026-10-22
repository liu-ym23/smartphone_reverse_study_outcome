package okio;

import com.bytedance.common.utility.StringEncryptUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public final class HashingSink extends ForwardingSink {

    @Nullable
    private final Mac mac;

    @Nullable
    private final MessageDigest messageDigest;

    public static HashingSink md5(Sink r2) {
        return new HashingSink(r2, StringEncryptUtils.MD5);
    }

    public static HashingSink sha1(Sink r2) {
        return new HashingSink(r2, StringEncryptUtils.SHA_1);
    }

    public static HashingSink sha256(Sink r2) {
        return new HashingSink(r2, "SHA-256");
    }

    public static HashingSink sha512(Sink r2) {
        return new HashingSink(r2, "SHA-512");
    }

    public static HashingSink hmacSha1(Sink r2, ByteString r3) {
        return new HashingSink(r2, r3, "HmacSHA1");
    }

    public static HashingSink hmacSha256(Sink r2, ByteString r3) {
        return new HashingSink(r2, r3, "HmacSHA256");
    }

    public static HashingSink hmacSha512(Sink r2, ByteString r3) {
        return new HashingSink(r2, r3, "HmacSHA512");
    }

    private HashingSink(Sink r1, String r2) {
        super(r1);
        this.messageDigest = MessageDigest.getInstance(r2);     // Catch: NoSuchAlgorithmException -> L5
        this.mac = null;     // Catch: NoSuchAlgorithmException -> L5
        return;
    L6:
        throw new AssertionError();
    }

    private HashingSink(Sink r2, ByteString r3, String r4) {
        super(r2);
        Mac r5 = Mac.getInstance(r4);     // Catch: InvalidKeyException -> L5 NoSuchAlgorithmException -> L8
        this.mac = r5;     // Catch: InvalidKeyException -> L5 NoSuchAlgorithmException -> L8
        r5.init(new SecretKeySpec(r3.toByteArray(), r4));     // Catch: InvalidKeyException -> L5 NoSuchAlgorithmException -> L8
        this.messageDigest = null;     // Catch: InvalidKeyException -> L5 NoSuchAlgorithmException -> L8
        return;
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L9:
        throw new AssertionError();
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer r8, long r9) throws IOException {
        Util.checkOffsetAndCount(r8.size, 0, r9);
        Segment r0 = r8.head;
        long r1 = 0;
    L4:
        if (r1 >= r9) goto L10;
        int r3 = (int) Math.min(r9 - r1, r0.limit - r0.pos);
        MessageDigest r4 = this.messageDigest;
        if (r4 == null) goto L8;
        r4.update(r0.data, r0.pos, r3);
    L9:
        r1 = r1 + ((long) r3);
        r0 = r0.next;
        goto L4
    L8:
        this.mac.update(r0.data, r0.pos, r3);
        goto L9
    L10:
        super.write(r8, r9);
    }

    public final ByteString hash() {
        MessageDigest r0 = this.messageDigest;
        if (r0 == null) goto L5;
        byte[] r1 = r0.digest();
    L7:
        return ByteString.of(r1);
    L5:
        r1 = this.mac.doFinal();
        goto L7
    }
}
