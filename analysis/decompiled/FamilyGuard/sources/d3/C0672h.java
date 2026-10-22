package d3;

import f3.C0719a;
import g3.C0742e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.libpag.BuildConfig;

/* renamed from: d3.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0672h {

    /* renamed from: a, reason: collision with root package name */
    private static final String f16626a = "Utils";

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f16627b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return BuildConfig.FLAVOR;
        }
        char[] cArr = new char[bArr.length * 2];
        int i5 = 0;
        for (byte b6 : bArr) {
            int i6 = i5 + 1;
            char[] cArr2 = f16627b;
            cArr[i5] = cArr2[(b6 >> 4) & 15];
            i5 += 2;
            cArr[i6] = cArr2[b6 & 15];
        }
        return new String(cArr);
    }

    public static byte[] b(byte[] bArr) throws Throwable {
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
            }
        } catch (IOException e6) {
            e = e6;
        }
        try {
            gZIPOutputStream.write(bArr);
        } catch (IOException e7) {
            e = e7;
            gZIPOutputStream2 = gZIPOutputStream;
            C0742e.l(f16626a, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            gZIPOutputStream = gZIPOutputStream2;
            C0719a.a(gZIPOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            C0719a.a(gZIPOutputStream);
            throw th;
        }
        C0719a.a(gZIPOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static String c(byte[] bArr) {
        if (bArr != null && bArr.length >= 1) {
            try {
                return a(MessageDigest.getInstance("MD5").digest(bArr));
            } catch (NoSuchAlgorithmException e6) {
                C0742e.l(f16626a, "Exception: " + e6.toString() + " - Cause: " + e6.getCause());
            }
        }
        return null;
    }

    public static Map<String, Object> d(JSONObject jSONObject) {
        return jSONObject != JSONObject.NULL ? f(jSONObject) : new HashMap();
    }

    private static List<Object> e(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
            Object objF = jSONArray.get(i5);
            if (objF instanceof JSONArray) {
                objF = e((JSONArray) objF);
            } else if (objF instanceof JSONObject) {
                objF = f((JSONObject) objF);
            }
            arrayList.add(objF);
        }
        return arrayList;
    }

    private static Map<String, Object> f(JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objF = jSONObject.get(next);
            if (objF == JSONObject.NULL) {
                objF = null;
            } else if (objF instanceof JSONArray) {
                objF = e((JSONArray) objF);
            } else if (objF instanceof JSONObject) {
                objF = f((JSONObject) objF);
            }
            map.put(next, objF);
        }
        return map;
    }
}
