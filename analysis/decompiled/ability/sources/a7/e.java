package a7;

import com.volcengine.tos.TosClientException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final DateTimeFormatter f1650a = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter b = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'");
    public static final DateTimeFormatter c = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    public static final char[] d = "0123456789abcdef".toCharArray();

    public static String a(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(512);
        Collections.sort(arrayList, new M.d(10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String strG = f.g((String) entry.getKey(), true);
            if (sb.length() > 0) {
                sb.append('&');
            }
            sb.append(strG);
            sb.append('=');
            sb.append(f.g(entry.getValue() == null ? "" : (String) entry.getValue(), true));
        }
        return sb.toString();
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(bArr, "HmacSHA256"));
            return mac.doFinal(bArr2);
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            throw new TosClientException("tos: compute hmac-sha256 failed", e);
        }
    }

    public static byte[] c(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new TosClientException("tos: compute sha256 failed.", e);
        }
    }

    public static char[] d(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b5 = bArr[i];
            int i6 = i * 2;
            char[] cArr2 = d;
            cArr[i6] = cArr2[(b5 & 255) >>> 4];
            cArr[i6 + 1] = cArr2[b5 & 15];
        }
        return cArr;
    }
}
