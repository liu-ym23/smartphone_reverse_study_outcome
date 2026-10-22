package com.amap.api.col.jmsl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1586o {

    /* renamed from: a, reason: collision with root package name */
    public C1569j2 f16783a;

    /* renamed from: com.amap.api.col.jmsl.o$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static Map<String, C1586o> f16784a = new HashMap();
    }

    /* renamed from: com.amap.api.col.jmsl.o$b */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f16785a;

        /* renamed from: b, reason: collision with root package name */
        public String f16786b;

        /* renamed from: c, reason: collision with root package name */
        public String f16787c;

        public b(String str, String str2, String str3) {
            this.f16785a = str;
            this.f16786b = str2;
            this.f16787c = str3;
        }

        public static List<b> c(String str) {
            b bVar;
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    try {
                        bVar = new b(jSONObject.optString("sdkVersion"), jSONObject.optString("cpuType"), jSONObject.optString(SkillStoreKt.SKILL_DOC_TYPE_CONTENT));
                    } catch (Throwable unused) {
                        bVar = null;
                    }
                    arrayList.add(bVar);
                }
                return arrayList;
            } catch (Throwable unused2) {
                return new ArrayList();
            }
        }

        public static JSONArray d(List<b> list) {
            JSONArray jSONArray = new JSONArray();
            for (b bVar : list) {
                if (bVar != null && !TextUtils.isEmpty(bVar.f16787c)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("sdkVersion", bVar.f16785a);
                        jSONObject.put("cpuType", bVar.f16786b);
                        jSONObject.put(SkillStoreKt.SKILL_DOC_TYPE_CONTENT, bVar.f16787c);
                    } catch (Throwable unused) {
                        jSONObject = new JSONObject();
                    }
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray;
        }

        public final boolean e(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                str = this.f16785a;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f16786b;
            }
            return this.f16785a.equals(str) && this.f16786b.equals(str2);
        }
    }

    public C1586o(C1569j2 c1569j2) {
        this.f16783a = c1569j2;
    }

    public static C1586o a(C1569j2 c1569j2) {
        if (c1569j2 == null || TextUtils.isEmpty(c1569j2.g())) {
            return null;
        }
        if (a.f16784a.get(c1569j2.g()) == null) {
            a.f16784a.put(c1569j2.g(), new C1586o(c1569j2));
        }
        return a.f16784a.get(c1569j2.g());
    }

    public static String b(Context context, String str, String str2) {
        String str3 = "C7ADB20F22F238708BA5EE26D0401DB9" + L1.c(str);
        String strConcat = "ik".concat(String.valueOf(str2));
        return TextUtils.isEmpty(strConcat) ? "" : C1604s2.n(U.b(C1604s2.p(context.getSharedPreferences(str3, 0).getString(strConcat, ""))));
    }

    public static void e(Context context, String str, String str2, String str3) {
        if (str3 == null || TextUtils.isEmpty(str)) {
            return;
        }
        String str4 = "C7ADB20F22F238708BA5EE26D0401DB9" + L1.c(str);
        String strConcat = "ik".concat(String.valueOf(str2));
        if (TextUtils.isEmpty(strConcat) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            return;
        }
        String strD = C1604s2.d(U.c(C1604s2.t(str3)));
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str4, 0).edit();
        editorEdit.putString(strConcat, strD);
        editorEdit.commit();
    }

    public final String c(Context context, String str, String str2, String str3) {
        C1569j2 c1569j2;
        if (context != null && (c1569j2 = this.f16783a) != null && !TextUtils.isEmpty(c1569j2.g())) {
            ArrayList arrayList = (ArrayList) b.c(b(context, this.f16783a.g(), str3));
            if (arrayList.size() == 0) {
                return "";
            }
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                b bVar = (b) arrayList.get(i10);
                if (bVar.e(str, str2)) {
                    return bVar.f16787c;
                }
            }
        }
        return null;
    }

    public final void d(Context context, String str, String str2, String str3, String str4) {
        C1569j2 c1569j2;
        if (context == null || (c1569j2 = this.f16783a) == null || TextUtils.isEmpty(c1569j2.g())) {
            return;
        }
        List<b> listC = b.c(b(context, this.f16783a.g(), str3));
        int i10 = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) listC;
            if (i10 >= arrayList.size()) {
                arrayList.add(new b(str, str2, str4));
                e(context, this.f16783a.g(), str3, b.d(listC).toString());
                return;
            }
            b bVar = (b) arrayList.get(i10);
            if (bVar.e(str, str2)) {
                bVar.f16787c = str4;
                e(context, this.f16783a.g(), str3, b.d(listC).toString());
                return;
            }
            i10++;
        }
    }
}
