package com.stepos.statsapp.v3.lib.plugin.emitter;

import M0.k;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public long f3968a;
    public int b;
    public String c;
    public String d;
    public String e;

    public static d a(int i, TrackerPayload trackerPayload) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String string;
        k kVar;
        String string2;
        String string3;
        d dVar = new d();
        dVar.b = i;
        String str = (String) trackerPayload.getHeaderMap().get("sid");
        String str2 = (String) trackerPayload.getHeaderMap().get(AgentBusWakeContract.EXTRA_SOURCE);
        dVar.c = str;
        dVar.d = str2;
        trackerPayload.getHeaderMap().remove("sid");
        trackerPayload.getHeaderMap().remove(AgentBusWakeContract.EXTRA_SOURCE);
        int i6 = dVar.b;
        if (i6 != 0) {
            try {
                kVar = P5.a.f1089a;
                string2 = trackerPayload.toString();
            } catch (Exception e) {
                e = e;
                string = null;
            }
            try {
                if (i6 == 1) {
                    "262t1#x23&^ya1bk".getBytes();
                } else {
                    if (i6 == 2) {
                        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                        cipher.init(1, kVar.l(), new IvParameterSpec((byte[]) kVar.c));
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
                    W5.c.a("EventBean", "SimpleCryptoAES encrypt[" + i6 + "] done");
                }
                W5.c.a("EventBean", "SimpleCryptoAES encrypt[" + i6 + "] done");
            } catch (Exception e6) {
                e = e6;
                StringBuilder sbU = B7.a.u(i6, "SimpleCryptoAES encrypt[", "], Exception: ");
                sbU.append(e.toString());
                sbU.append(" - Cause: ");
                sbU.append(e.getCause());
                W5.c.f("EventBean", sbU.toString());
                dVar.e = string;
                trackerPayload.addHeader("sid", str);
                trackerPayload.addHeader(AgentBusWakeContract.EXTRA_SOURCE, str2);
                return dVar;
            }
            string = null;
        } else {
            string = trackerPayload.toString();
        }
        dVar.e = string;
        trackerPayload.addHeader("sid", str);
        trackerPayload.addHeader(AgentBusWakeContract.EXTRA_SOURCE, str2);
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload b(com.stepos.statsapp.v3.lib.plugin.emitter.d r11) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            java.lang.String r0 = "EventBean"
            java.lang.String r1 = "SimpleCryptoAES decrypt["
            int r2 = r11.b
            r3 = 0
            if (r2 == 0) goto L97
            M0.k r4 = P5.a.f1089a     // Catch: java.lang.Exception -> L74
            java.lang.String r5 = "262t1#x23&^ya1bk"
            java.lang.String r6 = r11.e     // Catch: java.lang.Exception -> L74
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
            javax.crypto.spec.SecretKeySpec r8 = r4.l()     // Catch: java.lang.Exception -> L74
            javax.crypto.spec.IvParameterSpec r9 = new javax.crypto.spec.IvParameterSpec     // Catch: java.lang.Exception -> L74
            java.lang.Object r4 = r4.c     // Catch: java.lang.Exception -> L74
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
            W5.c.a(r0, r4)     // Catch: java.lang.Exception -> L72
            goto L99
        L72:
            r4 = move-exception
            goto L76
        L74:
            r4 = move-exception
            goto L5b
        L76:
            java.lang.String r6 = "], Exception: "
            java.lang.StringBuilder r1 = B7.a.u(r2, r1, r6)
            java.lang.String r2 = r4.toString()
            r1.append(r2)
            java.lang.String r2 = " - Cause: "
            r1.append(r2)
            java.lang.Throwable r2 = r4.getCause()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            W5.c.f(r0, r1)
            goto L99
        L97:
            java.lang.String r5 = r11.e
        L99:
            com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload r0 = com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload.fromString(r5)
            if (r0 == 0) goto Lae
            java.lang.String r1 = r11.c
            java.lang.String r2 = "sid"
            r0.addHeader(r2, r1)
            java.lang.String r11 = r11.d
            java.lang.String r1 = "source"
            r0.addHeader(r1, r11)
            return r0
        Lae:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.statsapp.v3.lib.plugin.emitter.d.b(com.stepos.statsapp.v3.lib.plugin.emitter.d):com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload");
    }
}
