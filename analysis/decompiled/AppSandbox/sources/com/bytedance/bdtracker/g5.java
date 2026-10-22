package com.bytedance.bdtracker;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.encryptor.IEncryptorType;
import com.stepos.cloudsdk.Constants;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class g5 {
    public static final String[] b = {"tt_data", "device_platform"};
    public static final String[] c = {"aid", "version_code", "ab_version", "iid", "device_platform"};
    public static final String[] d = {"aid", "app_version", "tt_data", "device_id"};
    public final d a;

    public g5(d dVar) {
        this.a = dVar;
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; bArr != null && i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i] & UByte.MAX_VALUE);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static void a(IAppLogInstance iAppLogInstance, JSONObject jSONObject) {
        String[] strArrA;
        boolean encryptAndCompress = iAppLogInstance.getEncryptAndCompress();
        InitConfig initConfig = iAppLogInstance.getInitConfig();
        boolean zIsResponseEncryptEnabled = initConfig != null ? initConfig.isResponseEncryptEnabled() : true;
        if (encryptAndCompress && zIsResponseEncryptEnabled && (strArrA = a()) != null) {
            try {
                jSONObject.put(Constants.COLUMN_KEY, strArrA[0]);
                jSONObject.put("iv", strArrA[1]);
            } catch (Throwable unused) {
            }
        }
    }

    public static byte[] a(byte[] bArr, String str, String str2) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
            int length = str.length();
            byte[] bArr2 = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr2[i] = (byte) str.charAt(i);
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            int length2 = str2.length();
            byte[] bArr3 = new byte[length2];
            for (int i2 = 0; i2 < length2; i2++) {
                bArr3[i2] = (byte) str2.charAt(i2);
            }
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String[] a() {
        String[] strArr = new String[2];
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = new SecureRandom();
            keyGenerator.init(128, secureRandom);
            strArr[0] = a(keyGenerator.generateKey().getEncoded());
            byte[] bArr = new byte[8];
            secureRandom.nextBytes(bArr);
            strArr[1] = a(bArr);
            if (TextUtils.isEmpty(strArr[0]) || strArr[0].length() != 32 || TextUtils.isEmpty(strArr[1])) {
                return null;
            }
            if (strArr[1].length() == 16) {
                return strArr;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] b(java.lang.String r7) {
        /*
            r6 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r1 = 8192(0x2000, float:1.148E-41)
            r0.<init>(r1)
            r1 = 0
            com.bytedance.bdtracker.d r2 = r6.a     // Catch: java.lang.Throwable -> L2c
            boolean r2 = r2.E     // Catch: java.lang.Throwable -> L2c
            java.lang.String r3 = "UTF-8"
            if (r2 == 0) goto L21
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L2c
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L2c
            byte[] r7 = r7.getBytes(r3)     // Catch: java.lang.Throwable -> L1e
            r2.write(r7)     // Catch: java.lang.Throwable -> L1e
            r1 = r2
            goto L28
        L1e:
            r7 = move-exception
            r1 = r2
            goto L2d
        L21:
            byte[] r7 = r7.getBytes(r3)     // Catch: java.lang.Throwable -> L2c
            r0.write(r7)     // Catch: java.lang.Throwable -> L2c
        L28:
            com.bytedance.bdtracker.r.a(r1)
            goto L42
        L2c:
            r7 = move-exception
        L2d:
            com.bytedance.bdtracker.d r2 = r6.a     // Catch: java.lang.Throwable -> L76
            com.bytedance.applog.log.IAppLogLogger r2 = r2.D     // Catch: java.lang.Throwable -> L76
            java.lang.String r3 = "EncryptUtils"
            java.util.List r3 = java.util.Collections.singletonList(r3)     // Catch: java.lang.Throwable -> L76
            java.lang.String r4 = "Convert string to bytes failed"
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L76
            r2.error(r3, r4, r7, r5)     // Catch: java.lang.Throwable -> L76
            com.bytedance.bdtracker.r.a(r1)
        L42:
            byte[] r7 = r0.toByteArray()
            com.bytedance.bdtracker.d r0 = r6.a
            boolean r0 = r0.E
            if (r0 == 0) goto L75
            com.bytedance.bdtracker.d r0 = r6.a
            com.bytedance.applog.InitConfig r0 = r0.getInitConfig()
            if (r0 == 0) goto L70
            com.bytedance.bdtracker.d r0 = r6.a
            com.bytedance.applog.InitConfig r0 = r0.getInitConfig()
            com.bytedance.mpaas.IEncryptor r0 = r0.getEncryptor()
            if (r0 == 0) goto L70
            com.bytedance.bdtracker.d r6 = r6.a
            com.bytedance.applog.InitConfig r6 = r6.getInitConfig()
            com.bytedance.mpaas.IEncryptor r6 = r6.getEncryptor()
            int r0 = r7.length
            byte[] r7 = r6.encrypt(r7, r0)
            goto L75
        L70:
            int r6 = r7.length
            byte[] r7 = com.bytedance.applog.encryptor.EncryptorUtil.encrypt(r7, r6)
        L75:
            return r7
        L76:
            r6 = move-exception
            com.bytedance.bdtracker.r.a(r1)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.g5.b(java.lang.String):byte[]");
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str) || !this.a.E) {
            return str;
        }
        Uri uri = Uri.parse(str);
        String encodedQuery = uri.getEncodedQuery();
        ArrayList<Pair> arrayList = new ArrayList();
        for (String str2 : d) {
            String queryParameter = uri.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                arrayList.add(new Pair(str2, queryParameter));
            }
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (Pair pair : arrayList) {
            builderBuildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
        }
        builderBuildUpon.appendQueryParameter("tt_info", new String(Base64.encode(b(encodedQuery), 8)));
        return builderBuildUpon.build().toString();
    }

    public static HashMap<String, String> a(HashMap<String, String> map, d dVar) {
        String str;
        String strEncryptorType = (dVar.getInitConfig() == null || dVar.getInitConfig().getEncryptor() == null || !(dVar.getInitConfig().getEncryptor() instanceof z)) ? IEncryptorType.DEFAULT_ENCRYPTOR : ((z) dVar.getInitConfig().getEncryptor()).encryptorType();
        if (dVar.E) {
            str = "application/octet-stream;tt-data=" + strEncryptorType;
        } else {
            str = "application/json; charset=utf-8";
        }
        map.put("Content-Type", str);
        return map;
    }
}
