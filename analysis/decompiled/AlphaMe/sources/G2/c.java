package G2;

import B0.g;
import T2.d;
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

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public long f643a;

    /* renamed from: b, reason: collision with root package name */
    public int f644b;

    /* renamed from: c, reason: collision with root package name */
    public String f645c;

    /* renamed from: d, reason: collision with root package name */
    public String f646d;

    /* renamed from: e, reason: collision with root package name */
    public String f647e;

    public static c a(int i4, TrackerPayload trackerPayload) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String string;
        String string2;
        c cVar = new c();
        cVar.f644b = i4;
        String str = (String) trackerPayload.f12343a.get("sid");
        HashMap map = trackerPayload.f12343a;
        String str2 = (String) map.get("source");
        cVar.f645c = str;
        cVar.f646d = str2;
        map.remove("sid");
        map.remove("source");
        int i5 = cVar.f644b;
        if (i5 != 0) {
            try {
                android.support.v4.media.session.c cVar2 = M2.a.f1437a;
                String string3 = trackerPayload.toString();
                cVar2.getClass();
                try {
                    if (i5 == 1) {
                        "262t1#x23&^ya1bk".getBytes();
                    } else {
                        if (i5 == 2) {
                            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                            cipher.init(1, cVar2.a(), new IvParameterSpec((byte[]) cVar2.f2366d));
                            byte[] bArrDoFinal = cipher.doFinal(string3.getBytes());
                            if (bArrDoFinal == null) {
                                string2 = "";
                            } else {
                                StringBuffer stringBuffer = new StringBuffer(bArrDoFinal.length * 2);
                                for (int i6 = 0; i6 < bArrDoFinal.length; i6++) {
                                    stringBuffer.append("0123456789ABCDEF".charAt((bArrDoFinal[i6] >> 4) & 15));
                                    stringBuffer.append("0123456789ABCDEF".charAt(bArrDoFinal[i6] & 15));
                                }
                                string2 = stringBuffer.toString();
                            }
                            string = string2;
                        }
                        d.a("EventBean", "SimpleCryptoAES encrypt[" + i5 + "] done");
                    }
                    d.a("EventBean", "SimpleCryptoAES encrypt[" + i5 + "] done");
                } catch (Exception e4) {
                    e = e4;
                    StringBuilder sbT = g.t("SimpleCryptoAES encrypt[", i5, "], Exception: ");
                    sbT.append(e.toString());
                    sbT.append(" - Cause: ");
                    sbT.append(e.getCause());
                    d.f("EventBean", sbT.toString());
                    cVar.f647e = string;
                    trackerPayload.c(str, "sid");
                    trackerPayload.c(str2, "source");
                    return cVar;
                }
                string = null;
            } catch (Exception e5) {
                e = e5;
                string = null;
            }
        } else {
            string = trackerPayload.toString();
        }
        cVar.f647e = string;
        trackerPayload.c(str, "sid");
        trackerPayload.c(str2, "source");
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b0 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload b(G2.c r11) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            java.lang.String r0 = "EventBean"
            java.lang.String r1 = "SimpleCryptoAES decrypt["
            int r2 = r11.f644b
            r3 = 0
            if (r2 == 0) goto L99
            android.support.v4.media.session.c r4 = M2.a.f1437a     // Catch: java.lang.Exception -> L76
            java.lang.String r5 = "262t1#x23&^ya1bk"
            java.lang.String r6 = r11.f647e     // Catch: java.lang.Exception -> L76
            r4.getClass()     // Catch: java.lang.Exception -> L76
            r7 = 1
            if (r2 != r7) goto L1a
            r5.getBytes()     // Catch: java.lang.Exception -> L76
        L18:
            r5 = r3
            goto L5d
        L1a:
            r5 = 2
            if (r2 != r5) goto L18
            java.lang.String r7 = "AES/CBC/PKCS5Padding"
            javax.crypto.Cipher r7 = javax.crypto.Cipher.getInstance(r7)     // Catch: java.lang.Exception -> L76
            javax.crypto.spec.SecretKeySpec r8 = r4.a()     // Catch: java.lang.Exception -> L76
            javax.crypto.spec.IvParameterSpec r9 = new javax.crypto.spec.IvParameterSpec     // Catch: java.lang.Exception -> L76
            java.lang.Object r4 = r4.f2366d     // Catch: java.lang.Exception -> L76
            byte[] r4 = (byte[]) r4     // Catch: java.lang.Exception -> L76
            r9.<init>(r4)     // Catch: java.lang.Exception -> L76
            r7.init(r5, r8, r9)     // Catch: java.lang.Exception -> L76
            int r4 = r6.length()     // Catch: java.lang.Exception -> L76
            int r4 = r4 / r5
            byte[] r5 = new byte[r4]     // Catch: java.lang.Exception -> L76
            r8 = 0
        L3b:
            if (r8 >= r4) goto L54
            int r9 = r8 * 2
            int r10 = r9 + 2
            java.lang.String r9 = r6.substring(r9, r10)     // Catch: java.lang.Exception -> L76
            r10 = 16
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9, r10)     // Catch: java.lang.Exception -> L76
            byte r9 = r9.byteValue()     // Catch: java.lang.Exception -> L76
            r5[r8] = r9     // Catch: java.lang.Exception -> L76
            int r8 = r8 + 1
            goto L3b
        L54:
            byte[] r4 = r7.doFinal(r5)     // Catch: java.lang.Exception -> L76
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Exception -> L76
            r5.<init>(r4)     // Catch: java.lang.Exception -> L76
        L5d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L72
            r4.<init>(r1)     // Catch: java.lang.Exception -> L72
            r4.append(r2)     // Catch: java.lang.Exception -> L72
            java.lang.String r6 = "] done"
            r4.append(r6)     // Catch: java.lang.Exception -> L72
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L72
            T2.d.a(r0, r4)     // Catch: java.lang.Exception -> L72
            goto L9b
        L72:
            r4 = move-exception
            goto L78
        L74:
            r5 = r3
            goto L78
        L76:
            r4 = move-exception
            goto L74
        L78:
            java.lang.String r6 = "], Exception: "
            java.lang.StringBuilder r1 = B0.g.t(r1, r2, r6)
            java.lang.String r2 = r4.toString()
            r1.append(r2)
            java.lang.String r2 = " - Cause: "
            r1.append(r2)
            java.lang.Throwable r2 = r4.getCause()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            T2.d.f(r0, r1)
            goto L9b
        L99:
            java.lang.String r5 = r11.f647e
        L9b:
            com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload r0 = com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload.g(r5)
            if (r0 == 0) goto Lb0
            java.lang.String r1 = r11.f645c
            java.lang.String r2 = "sid"
            r0.c(r1, r2)
            java.lang.String r11 = r11.f646d
            java.lang.String r1 = "source"
            r0.c(r11, r1)
            return r0
        Lb0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: G2.c.b(G2.c):com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload");
    }
}
