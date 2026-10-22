package ga;

import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import org.json.JSONException;
import p5.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public long f4670a;

    /* renamed from: b, reason: collision with root package name */
    public int f4671b;

    /* renamed from: c, reason: collision with root package name */
    public String f4672c;

    /* renamed from: d, reason: collision with root package name */
    public String f4673d;

    /* renamed from: e, reason: collision with root package name */
    public String f4674e;

    public static c a(int i, TrackerPayload trackerPayload) throws JSONException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String string;
        l lVar;
        String string2;
        String string3;
        c cVar = new c();
        cVar.f4671b = i;
        HashMap map = trackerPayload.f2842c;
        String str = (String) map.get("sid");
        String str2 = (String) map.get("source");
        cVar.f4672c = str;
        cVar.f4673d = str2;
        map.remove("sid");
        map.remove("source");
        int i3 = cVar.f4671b;
        if (i3 != 0) {
            try {
                lVar = na.a.f8798a;
                string2 = trackerPayload.toString();
            } catch (Exception e10) {
                e = e10;
                string = null;
            }
            try {
                if (i3 == 1) {
                    "262t1#x23&^ya1bk".getBytes();
                } else {
                    if (i3 == 2) {
                        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                        cipher.init(1, lVar.e(), new IvParameterSpec((byte[]) lVar.f9739f));
                        byte[] bArrDoFinal = cipher.doFinal(string2.getBytes());
                        if (bArrDoFinal == null) {
                            string3 = "";
                        } else {
                            StringBuffer stringBuffer = new StringBuffer(bArrDoFinal.length * 2);
                            for (int i10 = 0; i10 < bArrDoFinal.length; i10++) {
                                stringBuffer.append("0123456789ABCDEF".charAt((bArrDoFinal[i10] >> 4) & 15));
                                stringBuffer.append("0123456789ABCDEF".charAt(bArrDoFinal[i10] & 15));
                            }
                            string3 = stringBuffer.toString();
                        }
                        string = string3;
                    }
                    ua.c.a("EventBean", "SimpleCryptoAES encrypt[" + i3 + "] done");
                }
                ua.c.a("EventBean", "SimpleCryptoAES encrypt[" + i3 + "] done");
            } catch (Exception e11) {
                e = e11;
                StringBuilder sbT = k0.a.t(i3, "SimpleCryptoAES encrypt[", "], Exception: ");
                sbT.append(e.toString());
                sbT.append(" - Cause: ");
                sbT.append(e.getCause());
                ua.c.f("EventBean", sbT.toString());
                cVar.f4674e = string;
                trackerPayload.a(str, "sid");
                trackerPayload.a(str2, "source");
                return cVar;
            }
            string = null;
        } else {
            string = trackerPayload.toString();
        }
        cVar.f4674e = string;
        trackerPayload.a(str, "sid");
        trackerPayload.a(str2, "source");
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload b(ga.c r11) throws org.json.JSONException, javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            java.lang.String r0 = "EventBean"
            java.lang.String r1 = "SimpleCryptoAES decrypt["
            int r2 = r11.f4671b
            r3 = 0
            if (r2 == 0) goto L97
            p5.l r4 = na.a.f8798a     // Catch: java.lang.Exception -> L74
            java.lang.String r5 = "262t1#x23&^ya1bk"
            java.lang.String r6 = r11.f4674e     // Catch: java.lang.Exception -> L74
            r7 = 1
            if (r2 != r7) goto L17
            r5.getBytes()     // Catch: java.lang.Exception -> L74
        L15:
            r5 = r3
            goto L5d
        L17:
            r5 = 2
            if (r2 != r5) goto L15
            java.lang.String r7 = "AES/CBC/PKCS5Padding"
            javax.crypto.Cipher r7 = javax.crypto.Cipher.getInstance(r7)     // Catch: java.lang.Exception -> L74
            javax.crypto.spec.SecretKeySpec r8 = r4.e()     // Catch: java.lang.Exception -> L74
            javax.crypto.spec.IvParameterSpec r9 = new javax.crypto.spec.IvParameterSpec     // Catch: java.lang.Exception -> L74
            java.lang.Object r4 = r4.f9739f     // Catch: java.lang.Exception -> L74
            byte[] r4 = (byte[]) r4     // Catch: java.lang.Exception -> L74
            r9.<init>(r4)     // Catch: java.lang.Exception -> L74
            r7.init(r5, r8, r9)     // Catch: java.lang.Exception -> L74
            int r4 = r6.length()     // Catch: java.lang.Exception -> L74
            int r4 = r4 / r5
            byte[] r5 = new byte[r4]     // Catch: java.lang.Exception -> L74
            r8 = 0
        L38:
            if (r8 >= r4) goto L51
            int r9 = r8 * 2
            int r10 = r9 + 2
            java.lang.String r9 = r6.substring(r9, r10)     // Catch: java.lang.Exception -> L74
            r10 = 16
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9, r10)     // Catch: java.lang.Exception -> L74
            byte r9 = r9.byteValue()     // Catch: java.lang.Exception -> L74
            r5[r8] = r9     // Catch: java.lang.Exception -> L74
            int r8 = r8 + 1
            goto L38
        L51:
            byte[] r4 = r7.doFinal(r5)     // Catch: java.lang.Exception -> L74
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Exception -> L74
            r5.<init>(r4)     // Catch: java.lang.Exception -> L74
            goto L5d
        L5b:
            r5 = r3
            goto L76
        L5d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L72
            r4.<init>(r1)     // Catch: java.lang.Exception -> L72
            r4.append(r2)     // Catch: java.lang.Exception -> L72
            java.lang.String r6 = "] done"
            r4.append(r6)     // Catch: java.lang.Exception -> L72
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L72
            ua.c.a(r0, r4)     // Catch: java.lang.Exception -> L72
            goto L99
        L72:
            r4 = move-exception
            goto L76
        L74:
            r4 = move-exception
            goto L5b
        L76:
            java.lang.String r6 = "], Exception: "
            java.lang.StringBuilder r1 = k0.a.t(r2, r1, r6)
            java.lang.String r2 = r4.toString()
            r1.append(r2)
            java.lang.String r2 = " - Cause: "
            r1.append(r2)
            java.lang.Throwable r2 = r4.getCause()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            ua.c.f(r0, r1)
            goto L99
        L97:
            java.lang.String r5 = r11.f4674e
        L99:
            com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload r0 = com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload.c(r5)
            if (r0 == 0) goto Lae
            java.lang.String r1 = r11.f4672c
            java.lang.String r2 = "sid"
            r0.a(r1, r2)
            java.lang.String r11 = r11.f4673d
            java.lang.String r1 = "source"
            r0.a(r11, r1)
            return r0
        Lae:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ga.c.b(ga.c):com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload");
    }
}
