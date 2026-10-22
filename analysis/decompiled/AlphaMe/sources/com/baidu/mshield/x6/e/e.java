package com.baidu.mshield.x6.e;

import android.content.Context;
import com.baidu.mshield.x6.f.j;
import com.baidu.platform.comapi.map.MapController;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public Context f8488a;

    /* renamed from: b, reason: collision with root package name */
    public com.baidu.mshield.x6.b.c f8489b;

    /* renamed from: c, reason: collision with root package name */
    public int f8490c;

    /* renamed from: d, reason: collision with root package name */
    public int f8491d;

    public e(Context context, int i4) {
        this(context, i4, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0246 A[Catch: all -> 0x0015, TryCatch #3 {all -> 0x0015, blocks: (B:5:0x0006, B:7:0x000e, B:8:0x0013, B:12:0x0018, B:14:0x0074, B:16:0x007a, B:30:0x00a5, B:32:0x00ab, B:36:0x00b3, B:38:0x00c5, B:40:0x00d5, B:42:0x00f7, B:44:0x0107, B:48:0x011e, B:50:0x0125, B:52:0x013f, B:54:0x0148, B:56:0x0156, B:58:0x0164, B:60:0x0174, B:62:0x0181, B:64:0x018e, B:66:0x019f, B:68:0x01a9, B:69:0x01b0, B:71:0x01bb, B:75:0x01c6, B:77:0x01d5, B:83:0x01f4, B:90:0x0209, B:93:0x0211, B:98:0x0230, B:100:0x0246, B:102:0x0251, B:104:0x0264, B:103:0x025e, B:88:0x0204, B:82:0x01f1, B:19:0x0081, B:21:0x0087, B:29:0x00a2, B:79:0x01dd, B:23:0x008d, B:25:0x0099, B:85:0x01fc), top: B:118:0x0006, outer: #4, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x025e A[Catch: all -> 0x0015, TryCatch #3 {all -> 0x0015, blocks: (B:5:0x0006, B:7:0x000e, B:8:0x0013, B:12:0x0018, B:14:0x0074, B:16:0x007a, B:30:0x00a5, B:32:0x00ab, B:36:0x00b3, B:38:0x00c5, B:40:0x00d5, B:42:0x00f7, B:44:0x0107, B:48:0x011e, B:50:0x0125, B:52:0x013f, B:54:0x0148, B:56:0x0156, B:58:0x0164, B:60:0x0174, B:62:0x0181, B:64:0x018e, B:66:0x019f, B:68:0x01a9, B:69:0x01b0, B:71:0x01bb, B:75:0x01c6, B:77:0x01d5, B:83:0x01f4, B:90:0x0209, B:93:0x0211, B:98:0x0230, B:100:0x0246, B:102:0x0251, B:104:0x0264, B:103:0x025e, B:88:0x0204, B:82:0x01f1, B:19:0x0081, B:21:0x0087, B:29:0x00a2, B:79:0x01dd, B:23:0x008d, B:25:0x0099, B:85:0x01fc), top: B:118:0x0006, outer: #4, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x019f A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #3 {all -> 0x0015, blocks: (B:5:0x0006, B:7:0x000e, B:8:0x0013, B:12:0x0018, B:14:0x0074, B:16:0x007a, B:30:0x00a5, B:32:0x00ab, B:36:0x00b3, B:38:0x00c5, B:40:0x00d5, B:42:0x00f7, B:44:0x0107, B:48:0x011e, B:50:0x0125, B:52:0x013f, B:54:0x0148, B:56:0x0156, B:58:0x0164, B:60:0x0174, B:62:0x0181, B:64:0x018e, B:66:0x019f, B:68:0x01a9, B:69:0x01b0, B:71:0x01bb, B:75:0x01c6, B:77:0x01d5, B:83:0x01f4, B:90:0x0209, B:93:0x0211, B:98:0x0230, B:100:0x0246, B:102:0x0251, B:104:0x0264, B:103:0x025e, B:88:0x0204, B:82:0x01f1, B:19:0x0081, B:21:0x0087, B:29:0x00a2, B:79:0x01dd, B:23:0x008d, B:25:0x0099, B:85:0x01fc), top: B:118:0x0006, outer: #4, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01d5 A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #3 {all -> 0x0015, blocks: (B:5:0x0006, B:7:0x000e, B:8:0x0013, B:12:0x0018, B:14:0x0074, B:16:0x007a, B:30:0x00a5, B:32:0x00ab, B:36:0x00b3, B:38:0x00c5, B:40:0x00d5, B:42:0x00f7, B:44:0x0107, B:48:0x011e, B:50:0x0125, B:52:0x013f, B:54:0x0148, B:56:0x0156, B:58:0x0164, B:60:0x0174, B:62:0x0181, B:64:0x018e, B:66:0x019f, B:68:0x01a9, B:69:0x01b0, B:71:0x01bb, B:75:0x01c6, B:77:0x01d5, B:83:0x01f4, B:90:0x0209, B:93:0x0211, B:98:0x0230, B:100:0x0246, B:102:0x0251, B:104:0x0264, B:103:0x025e, B:88:0x0204, B:82:0x01f1, B:19:0x0081, B:21:0x0087, B:29:0x00a2, B:79:0x01dd, B:23:0x008d, B:25:0x0099, B:85:0x01fc), top: B:118:0x0006, outer: #4, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x020f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a() {
        /*
            Method dump skipped, instructions count: 623
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x6.e.e.a():void");
    }

    public e(Context context, int i4, int i5) {
        this.f8488a = context;
        this.f8490c = i4;
        this.f8491d = i5;
        this.f8489b = new com.baidu.mshield.x6.b.c(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fd A[Catch: all -> 0x0103, TryCatch #0 {all -> 0x0103, blocks: (B:29:0x0075, B:34:0x0080, B:38:0x0097, B:41:0x00ca, B:46:0x00f4, B:48:0x00fd, B:52:0x0105, B:56:0x0114, B:57:0x014c, B:21:0x0061, B:26:0x006f, B:23:0x0066), top: B:61:0x0061, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0105 A[Catch: all -> 0x0103, TRY_LEAVE, TryCatch #0 {all -> 0x0103, blocks: (B:29:0x0075, B:34:0x0080, B:38:0x0097, B:41:0x00ca, B:46:0x00f4, B:48:0x00fd, B:52:0x0105, B:56:0x0114, B:57:0x014c, B:21:0x0061, B:26:0x006f, B:23:0x0066), top: B:61:0x0061, inners: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(org.json.JSONObject r15) {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x6.e.e.a(org.json.JSONObject):void");
    }

    public final String a(String str, boolean z4) {
        int iOptInt;
        int iOptInt2;
        String strOptString;
        String strOptString2;
        String strValueOf;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i4);
                    iOptInt = jSONObjectOptJSONObject.optInt("eid");
                    iOptInt2 = jSONObjectOptJSONObject.optInt("pattern");
                    strOptString = jSONObjectOptJSONObject.optString(MapController.ITEM_LAYER_TAG);
                    strOptString2 = jSONObjectOptJSONObject.optString("value");
                } catch (Throwable th) {
                    com.baidu.mshield.x6.f.f.b(th);
                }
                if (iOptInt2 != 0) {
                    str2 = "";
                    if (iOptInt2 == 2 || iOptInt2 == 3) {
                        String[] strArrSplit = strOptString.split("\\|");
                        String str3 = strArrSplit[0];
                        String str4 = strArrSplit[1];
                        str2 = strArrSplit.length == 3 ? strArrSplit[2] : "";
                        if (iOptInt2 == 2) {
                            if (z4) {
                                strValueOf = (String) com.baidu.xclient.gdid.a.a(25, strOptString, strOptString2, (Object) null);
                            } else {
                                strValueOf = j.b(str3, str4, str2, strOptString2);
                            }
                        } else if (z4) {
                            strValueOf = (String) com.baidu.xclient.gdid.a.a(26, strOptString, strOptString2, (Object) null);
                        } else {
                            strValueOf = j.a(str3, str4, str2, strOptString2);
                        }
                    }
                    jSONObject.put(String.valueOf(iOptInt), str2);
                } else if (z4) {
                    strValueOf = (String) com.baidu.xclient.gdid.a.a(24, strOptString, strOptString2, (Object) null);
                } else {
                    strValueOf = String.valueOf(com.baidu.mshield.x6.f.f.c(strOptString));
                }
                str2 = strValueOf;
                jSONObject.put(String.valueOf(iOptInt), str2);
            }
        } catch (Throwable th2) {
            com.baidu.mshield.x6.f.f.b(th2);
        }
        return jSONObject.toString();
    }
}
