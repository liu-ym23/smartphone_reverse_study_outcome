package com.stepos.statsapp.v3.lib.plugin.emitter;

import com.stepos.core.ability.converter.BundleContentBridge;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import ma.a;
import org.json.JSONException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public long f8011a;

    /* renamed from: b, reason: collision with root package name */
    public int f8012b;

    /* renamed from: c, reason: collision with root package name */
    public String f8013c;

    /* renamed from: d, reason: collision with root package name */
    public String f8014d;

    /* renamed from: e, reason: collision with root package name */
    public String f8015e;

    public static e a(int i10, TrackerPayload trackerPayload) throws JSONException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String string;
        ma.a aVar;
        String string2;
        String string3;
        e eVar = new e();
        eVar.f8012b = i10;
        String str = (String) trackerPayload.getHeaderMap().get("sid");
        String str2 = (String) trackerPayload.getHeaderMap().get(BundleContentBridge.ROLE_SOURCE);
        eVar.f8013c = str;
        eVar.f8014d = str2;
        trackerPayload.getHeaderMap().remove("sid");
        trackerPayload.getHeaderMap().remove(BundleContentBridge.ROLE_SOURCE);
        int i11 = eVar.f8012b;
        if (i11 != 0) {
            try {
                aVar = a.C0109a.f10535a;
                string2 = trackerPayload.toString();
            } catch (Exception e10) {
                e = e10;
                string = null;
            }
            try {
                if (i11 == 1) {
                    "262t1#x23&^ya1bk".getBytes();
                } else {
                    if (i11 == 2) {
                        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                        cipher.init(1, aVar.a(), new IvParameterSpec(aVar.f10534b));
                        byte[] bArrDoFinal = cipher.doFinal(string2.getBytes());
                        if (bArrDoFinal == null) {
                            string3 = "";
                        } else {
                            StringBuffer stringBuffer = new StringBuffer(bArrDoFinal.length * 2);
                            for (int i12 = 0; i12 < bArrDoFinal.length; i12++) {
                                stringBuffer.append("0123456789ABCDEF".charAt((bArrDoFinal[i12] >> 4) & 15));
                                stringBuffer.append("0123456789ABCDEF".charAt(bArrDoFinal[i12] & 15));
                            }
                            string3 = stringBuffer.toString();
                        }
                        string = string3;
                    }
                    ta.c.a("EventBean", "SimpleCryptoAES encrypt[" + i11 + "] done");
                }
                ta.c.a("EventBean", "SimpleCryptoAES encrypt[" + i11 + "] done");
            } catch (Exception e11) {
                e = e11;
                StringBuilder sbK = com.stepos.core.ota.d.k(i11, "SimpleCryptoAES encrypt[", "], Exception: ");
                sbK.append(e.toString());
                sbK.append(" - Cause: ");
                sbK.append(e.getCause());
                ta.c.f("EventBean", sbK.toString());
                eVar.f8015e = string;
                trackerPayload.addHeader("sid", str);
                trackerPayload.addHeader(BundleContentBridge.ROLE_SOURCE, str2);
                return eVar;
            }
            string = null;
        } else {
            string = trackerPayload.toString();
        }
        eVar.f8015e = string;
        trackerPayload.addHeader("sid", str);
        trackerPayload.addHeader(BundleContentBridge.ROLE_SOURCE, str2);
        return eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ac A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload b(com.stepos.statsapp.v3.lib.plugin.emitter.e r11) throws org.json.JSONException, javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            java.lang.String r0 = "EventBean"
            java.lang.String r1 = "SimpleCryptoAES decrypt["
            int r2 = r11.f8012b
            r3 = 0
            if (r2 == 0) goto L95
            ma.a r4 = ma.a.C0109a.f10535a     // Catch: java.lang.Exception -> L72
            java.lang.String r5 = "262t1#x23&^ya1bk"
            java.lang.String r6 = r11.f8015e     // Catch: java.lang.Exception -> L72
            r7 = 1
            if (r2 != r7) goto L17
            r5.getBytes()     // Catch: java.lang.Exception -> L72
        L15:
            r5 = r3
            goto L5b
        L17:
            r5 = 2
            if (r2 != r5) goto L15
            java.lang.String r7 = "AES/CBC/PKCS5Padding"
            javax.crypto.Cipher r7 = javax.crypto.Cipher.getInstance(r7)     // Catch: java.lang.Exception -> L72
            javax.crypto.spec.SecretKeySpec r8 = r4.a()     // Catch: java.lang.Exception -> L72
            javax.crypto.spec.IvParameterSpec r9 = new javax.crypto.spec.IvParameterSpec     // Catch: java.lang.Exception -> L72
            byte[] r4 = r4.f10534b     // Catch: java.lang.Exception -> L72
            r9.<init>(r4)     // Catch: java.lang.Exception -> L72
            r7.init(r5, r8, r9)     // Catch: java.lang.Exception -> L72
            int r4 = r6.length()     // Catch: java.lang.Exception -> L72
            int r4 = r4 / r5
            byte[] r5 = new byte[r4]     // Catch: java.lang.Exception -> L72
            r8 = 0
        L36:
            if (r8 >= r4) goto L4f
            int r9 = r8 * 2
            int r10 = r9 + 2
            java.lang.String r9 = r6.substring(r9, r10)     // Catch: java.lang.Exception -> L72
            r10 = 16
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9, r10)     // Catch: java.lang.Exception -> L72
            byte r9 = r9.byteValue()     // Catch: java.lang.Exception -> L72
            r5[r8] = r9     // Catch: java.lang.Exception -> L72
            int r8 = r8 + 1
            goto L36
        L4f:
            byte[] r4 = r7.doFinal(r5)     // Catch: java.lang.Exception -> L72
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Exception -> L72
            r5.<init>(r4)     // Catch: java.lang.Exception -> L72
            goto L5b
        L59:
            r5 = r3
            goto L74
        L5b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L70
            r4.<init>(r1)     // Catch: java.lang.Exception -> L70
            r4.append(r2)     // Catch: java.lang.Exception -> L70
            java.lang.String r6 = "] done"
            r4.append(r6)     // Catch: java.lang.Exception -> L70
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L70
            ta.c.a(r0, r4)     // Catch: java.lang.Exception -> L70
            goto L97
        L70:
            r4 = move-exception
            goto L74
        L72:
            r4 = move-exception
            goto L59
        L74:
            java.lang.String r6 = "], Exception: "
            java.lang.StringBuilder r1 = com.stepos.core.ota.d.k(r2, r1, r6)
            java.lang.String r2 = r4.toString()
            r1.append(r2)
            java.lang.String r2 = " - Cause: "
            r1.append(r2)
            java.lang.Throwable r2 = r4.getCause()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            ta.c.f(r0, r1)
            goto L97
        L95:
            java.lang.String r5 = r11.f8015e
        L97:
            com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload r0 = com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload.fromString(r5)
            if (r0 == 0) goto Lac
            java.lang.String r1 = r11.f8013c
            java.lang.String r2 = "sid"
            r0.addHeader(r2, r1)
            java.lang.String r11 = r11.f8014d
            java.lang.String r1 = "source"
            r0.addHeader(r1, r11)
            return r0
        Lac:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.statsapp.v3.lib.plugin.emitter.e.b(com.stepos.statsapp.v3.lib.plugin.emitter.e):com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload");
    }
}
