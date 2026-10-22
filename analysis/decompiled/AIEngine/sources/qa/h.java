package qa;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f11645a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length >= 1) {
            try {
                byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(bArr);
                if (bArrDigest == null) {
                    return "";
                }
                char[] cArr = new char[bArrDigest.length * 2];
                int i10 = 0;
                for (byte b10 : bArrDigest) {
                    int i11 = i10 + 1;
                    char[] cArr2 = f11645a;
                    cArr[i10] = cArr2[(b10 >> 4) & 15];
                    i10 += 2;
                    cArr[i11] = cArr2[b10 & 15];
                }
                return new String(cArr);
            } catch (NoSuchAlgorithmException e10) {
                ta.c.f("Utils", "Exception: " + e10.toString() + " - Cause: " + e10.getCause());
            }
        }
        return null;
    }

    public static ArrayList b(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Object objC = jSONArray.get(i10);
            if (objC instanceof JSONArray) {
                objC = b((JSONArray) objC);
            } else if (objC instanceof JSONObject) {
                objC = c((JSONObject) objC);
            }
            arrayList.add(objC);
        }
        return arrayList;
    }

    public static HashMap c(JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objC = jSONObject.get(next);
            if (objC == JSONObject.NULL) {
                objC = null;
            } else if (objC instanceof JSONArray) {
                objC = b((JSONArray) objC);
            } else if (objC instanceof JSONObject) {
                objC = c((JSONObject) objC);
            }
            map.put(next, objC);
        }
        return map;
    }
}
