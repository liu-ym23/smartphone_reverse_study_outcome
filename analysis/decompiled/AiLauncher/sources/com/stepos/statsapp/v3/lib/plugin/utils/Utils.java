package com.stepos.statsapp.v3.lib.plugin.utils;

import com.stepos.statsapp.v3.utils.CommonUtils;
import com.stepos.statsapp.v3.utils.log.Logger;
import io.ktor.util.date.GMTDateParser;
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

/* loaded from: classes2.dex */
public class Utils {
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};
    private static final String TAG = "Utils";

    private static String bytesToHexString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            char[] cArr2 = DIGITS;
            cArr[i10] = cArr2[(b10 >> 4) & 15];
            i10 += 2;
            cArr[i11] = cArr2[b10 & 15];
        }
        return new String(cArr);
    }

    public static byte[] compress(byte[] bArr) throws Throwable {
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
        } catch (IOException e10) {
            e = e10;
        }
        try {
            gZIPOutputStream.write(bArr);
        } catch (IOException e11) {
            e = e11;
            gZIPOutputStream2 = gZIPOutputStream;
            Logger.w(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
            gZIPOutputStream = gZIPOutputStream2;
            CommonUtils.closeQuietly(gZIPOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.closeQuietly(gZIPOutputStream);
            throw th;
        }
        CommonUtils.closeQuietly(gZIPOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static String getMD5(byte[] bArr) {
        if (bArr != null && bArr.length >= 1) {
            try {
                return bytesToHexString(MessageDigest.getInstance("MD5").digest(bArr));
            } catch (NoSuchAlgorithmException e10) {
                Logger.w(TAG, "Exception: " + e10.toString() + " - Cause: " + e10.getCause());
            }
        }
        return null;
    }

    public static Map<String, Object> jsonObjectToMap(JSONObject jSONObject) throws JSONException {
        return jSONObject != JSONObject.NULL ? toMap(jSONObject) : new HashMap();
    }

    private static List<Object> toList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Object map = jSONArray.get(i10);
            if (map instanceof JSONArray) {
                map = toList((JSONArray) map);
            } else if (map instanceof JSONObject) {
                map = toMap((JSONObject) map);
            }
            arrayList.add(map);
        }
        return arrayList;
    }

    private static Map<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object map2 = jSONObject.get(next);
            if (map2 == JSONObject.NULL) {
                map2 = null;
            } else if (map2 instanceof JSONArray) {
                map2 = toList((JSONArray) map2);
            } else if (map2 instanceof JSONObject) {
                map2 = toMap((JSONObject) map2);
            }
            map.put(next, map2);
        }
        return map;
    }
}
