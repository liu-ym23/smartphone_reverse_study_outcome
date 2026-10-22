package com.baidu.mshield.utility;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.room.AbstractC0351g;
import com.baidu.mshield.ac.F;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import kotlin.UByte;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {
    public static String a(Context context, String str, boolean z4, boolean z5) throws Throwable {
        return a(context, str, "", z4, z5, true, null);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return c(bArr, bArr2);
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        byte[] bArrA = a(bArr2);
        byte[] bArr3 = new byte[bArr.length];
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < bArr.length; i6++) {
            i4 = (i4 + 1) & 255;
            byte b4 = bArrA[i4];
            i5 = ((b4 & UByte.MAX_VALUE) + i5) & 255;
            bArrA[i4] = bArrA[i5];
            bArrA[i5] = b4;
            byte b5 = (byte) (bArrA[((bArrA[i4] & UByte.MAX_VALUE) + (b4 & UByte.MAX_VALUE)) & 255] ^ bArr[i6]);
            bArr3[i6] = b5;
            bArr3[i6] = (byte) (b5 ^ 42);
        }
        return bArr3;
    }

    public static String a(Context context, String str, String str2, boolean z4, boolean z5) throws Throwable {
        return a(context, str, str2, z4, z5, false, "");
    }

    public static String a(Context context, String str, String str2, boolean z4, boolean z5, String str3) throws Throwable {
        return a(context, str, str2, z4, z5, false, str3);
    }

    public static String a(Context context, String str, String str2, boolean z4, boolean z5, boolean z6, String str3) throws Throwable {
        byte[] bytes;
        String strA;
        String str4 = "";
        if (!com.baidu.mshield.b.e.a.d(context)) {
            return "";
        }
        String[] strArrI = a.i(context);
        String str5 = strArrI[0];
        String str6 = strArrI[1];
        String strValueOf = String.valueOf(new Date().getTime() / 1000);
        String strA2 = com.baidu.mshield.b.f.e.a(str5 + strValueOf + str6);
        byte[] bArrA = com.baidu.mshield.core.b.a();
        com.baidu.mshield.b.c.a.b("after get aesKey:".concat(new String(bArrA)));
        com.baidu.mshield.b.c.a.b("after get aesKey:base64:" + Base64.encode(bArrA, 0));
        if (!TextUtils.isEmpty(str2)) {
            byte[] bArrA2 = com.baidu.mshield.b.a.c.a(str2.getBytes());
            com.baidu.mshield.b.c.a.b("afterGzipPostBody,length=" + bArrA2.length);
            bytes = F.getInstance().ae(bArrA2, bArrA);
        } else {
            bytes = "".getBytes();
        }
        com.baidu.mshield.b.c.a.b("afterEncryptPostBody length=" + bytes.length + "," + new String(bytes));
        byte[] bytes2 = com.baidu.mshield.b.f.e.a(c.b(context)).getBytes();
        com.baidu.mshield.b.c.a.b("afterLoadRc4Key:".concat(new String(bytes2)));
        byte[] bArrRe = F.getInstance().re(bArrA, bytes2);
        com.baidu.mshield.b.c.a.b("after ar:sKey length=" + bArrRe.length);
        String strEncodeToString = Base64.encodeToString(bArrRe, 0);
        com.baidu.mshield.b.c.a.b("after Base64:sKey=" + strEncodeToString);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("/250/");
        sb.append(str5);
        AbstractC0351g.C(sb, "/", strValueOf, "/", strA2);
        if (!TextUtils.isEmpty(strEncodeToString)) {
            sb.append("?skey=");
            sb.append(URLEncoder.encode(strEncodeToString, "utf-8"));
        }
        com.baidu.mshield.b.c.a.b(sb.toString());
        try {
            if (z6) {
                strA = new com.baidu.mshield.b.d.b(context, null).a(sb.toString());
            } else {
                strA = new com.baidu.mshield.b.d.b(context, null).a(sb.toString(), bytes);
            }
            str4 = strA;
        } catch (Throwable th) {
            a.a(th);
        }
        com.baidu.mshield.b.c.a.b("r:" + str4);
        if (z4 && TextUtils.isEmpty(str4)) {
            a(context);
            throw new NetworkErrorException("response is empty");
        }
        if (!z5) {
            return str4;
        }
        JSONObject jSONObject = new JSONObject(str4);
        String strOptString = jSONObject.optString("skey");
        com.baidu.mshield.b.c.a.b("base sKey from server:" + strOptString);
        byte[] bArrDecode = Base64.decode(strOptString, 0);
        com.baidu.mshield.b.c.a.b("after Base64 decode:server aeskey size=" + bArrDecode.length);
        byte[] bArrRd = F.getInstance().rd(bArrDecode, bytes2);
        com.baidu.mshield.b.c.a.b("after dr aes key:size=".concat(new String(bArrRd)));
        String strOptString2 = jSONObject.optString("response");
        com.baidu.mshield.b.c.a.b("plugins:requestId:" + jSONObject.optString("request_id"));
        com.baidu.mshield.b.c.a.b("plugins:response Base64:" + strOptString2);
        byte[] bArrDecode2 = Base64.decode(strOptString2, 0);
        com.baidu.mshield.b.c.a.b("after Base64 decode:server aeskey size=" + bArrDecode2.length);
        byte[] bArrAd = F.getInstance().ad(bArrDecode2, bArrRd);
        if (bArrDecode2.length > 0 && (bArrAd == null || bArrAd.length == 0)) {
            a.g(context);
            throw new NetworkErrorException("aes is fail");
        }
        String str7 = new String(bArrAd);
        com.baidu.mshield.b.c.a.b("sdk res:".concat(str7));
        return str7;
    }

    public static void a(Context context) {
        try {
            com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(context);
            if (System.currentTimeMillis() - aVarA.y() > 86400000) {
                HashMap map = new HashMap();
                if (com.baidu.mshield.b.a.d.c(context)) {
                    map.put("0", Integer.valueOf(aVarA.A() + 1));
                    map.put("1", Integer.valueOf(aVarA.z()));
                } else {
                    map.put("0", Integer.valueOf(aVarA.A()));
                    map.put("1", Integer.valueOf(aVarA.z() + 1));
                }
                aVarA.d(0);
                aVarA.e(0);
                aVarA.j();
                a.a(context, "1067112", map);
                return;
            }
            if (com.baidu.mshield.b.a.d.c(context)) {
                aVarA.c(aVarA.A() + 1);
            } else {
                aVarA.b(aVarA.z() + 1);
            }
        } catch (Throwable th) {
            a.a(th);
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return c(bArr, bArr2);
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[256];
        for (int i4 = 0; i4 < 256; i4++) {
            bArr2[i4] = (byte) i4;
        }
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int length = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < 256; i6++) {
            int i7 = bArr[length] & UByte.MAX_VALUE;
            byte b4 = bArr2[i6];
            i5 = (i7 + (b4 & UByte.MAX_VALUE) + i5) & 255;
            bArr2[i6] = bArr2[i5];
            bArr2[i5] = b4;
            length = (length + 1) % bArr.length;
        }
        return bArr2;
    }
}
