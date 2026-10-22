package okio;

import com.bytedance.common.utility.StringEncryptUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public final class HashingSource extends ForwardingSource {
    private final Mac mac;
    private final MessageDigest messageDigest;

    public static HashingSource md5(Source r2) {
        return new HashingSource(r2, StringEncryptUtils.MD5);
    }

    public static HashingSource sha1(Source r2) {
        return new HashingSource(r2, StringEncryptUtils.SHA_1);
    }

    public static HashingSource sha256(Source r2) {
        return new HashingSource(r2, "SHA-256");
    }

    public static HashingSource hmacSha1(Source r2, ByteString r3) {
        return new HashingSource(r2, r3, "HmacSHA1");
    }

    public static HashingSource hmacSha256(Source r2, ByteString r3) {
        return new HashingSource(r2, r3, "HmacSHA256");
    }

    private HashingSource(Source r1, String r2) {
        super(r1);
        this.messageDigest = MessageDigest.getInstance(r2);     // Catch: NoSuchAlgorithmException -> L5
        this.mac = null;     // Catch: NoSuchAlgorithmException -> L5
        return;
    L6:
        throw new AssertionError();
    }

    private HashingSource(Source r2, ByteString r3, String r4) {
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

    @Override // okio.ForwardingSource, okio.Source
    public long read(Buffer r8, long r9) throws IOException {
        long r10 = super.read(r8, r9);
        if (r10 == (-1)) goto L15;
        long r0 = r8.size - r10;
        long r2 = r8.size;
        Segment r4 = r8.head;
    L6:
        if (r2 <= r0) goto L9;
        r4 = r4.prev;
        r2 = r2 - ((long) (r4.limit - r4.pos));
    L9:
        if (r2 >= r8.size) goto L15;
        int r1 = (int) ((((long) r4.pos) + r0) - r2);
        MessageDigest r3 = this.messageDigest;
        if (r3 == null) goto L13;
        r3.update(r4.data, r1, r4.limit - r1);
    L14:
        r2 = r2 + ((long) (r4.limit - r4.pos));
        r4 = r4.next;
        r0 = r2;
        goto L9
    L13:
        this.mac.update(r4.data, r1, r4.limit - r1);
    L15:
        return r10;
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
