package com.bytedance.bdtracker;

import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.s3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class q3 {
    public static final List<String> a = Collections.singletonList("DomPagerHelper");

    public static JSONArray a(m3 m3Var, List<s3> list) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pageKey", m3Var.v);
            jSONObject.put("is_html", false);
            jSONObject.put("frame", m3Var.l());
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(a(m3Var));
            jSONObject.put("dom", jSONArray2);
            jSONArray.put(jSONObject);
            for (s3 s3Var : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pageKey", s3Var.a);
                jSONObject2.put("is_html", true);
                jSONObject2.put("frame", s3Var.c.a());
                jSONObject2.put("element_path", s3Var.d);
                List<s3.b> list2 = s3Var.b;
                JSONArray jSONArray3 = new JSONArray();
                Iterator<s3.b> it = list2.iterator();
                while (it.hasNext()) {
                    jSONArray3.put(a(it.next()));
                }
                jSONObject2.put("dom", jSONArray3);
                jSONArray.put(jSONObject2);
            }
            return jSONArray;
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "getDomPagerArray failed", th, new Object[0]);
            return null;
        }
    }

    public static JSONObject a(m3 m3Var) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("frame", m3Var.l());
            jSONObject.put("element_path", m3Var.x);
            ArrayList<String> arrayList = m3Var.B;
            if (arrayList != null && arrayList.size() > 0) {
                m3Var.H = new ArrayList<>();
                for (int i = 0; i < m3Var.B.size(); i++) {
                    m3Var.H.add("*");
                }
                jSONObject.put("positions", new JSONArray((Collection) m3Var.B));
                jSONObject.put("fuzzy_positions", new JSONArray((Collection) m3Var.H));
            }
            ArrayList<String> arrayList2 = m3Var.A;
            if (arrayList2 != null && arrayList2.size() > 0) {
                jSONObject.put("texts", new JSONArray((Collection) m3Var.A));
            }
            jSONObject.put("zIndex", m3Var.L);
            jSONObject.put("ignore", m3Var.M);
            jSONObject.put("is_html", m3Var.G);
            JSONArray jSONArray = new JSONArray();
            Iterator<m3> it = m3Var.N.iterator();
            while (it.hasNext()) {
                jSONArray.put(a(it.next()));
            }
            jSONObject.put("children", jSONArray);
            return jSONObject;
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "getNativeDom failed", th, new Object[0]);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0138 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e0 A[Catch: all -> 0x0112, IOException -> 0x0114, TRY_ENTER, TRY_LEAVE, TryCatch #11 {IOException -> 0x0114, all -> 0x0112, blocks: (B:52:0x00e0, B:59:0x00ff, B:61:0x0107), top: B:96:0x00de }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ff A[Catch: all -> 0x0112, IOException -> 0x0114, TRY_ENTER, TRY_LEAVE, TryCatch #11 {IOException -> 0x0114, all -> 0x0112, blocks: (B:52:0x00e0, B:59:0x00ff, B:61:0x0107), top: B:96:0x00de }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0128 A[EXC_TOP_SPLITTER, PHI: r0 r4
      0x0128: PHI (r0v5 java.lang.Object) = (r0v4 java.lang.Object), (r0v9 java.lang.Object) binds: [B:74:0x0126, B:63:0x010d] A[DONT_GENERATE, DONT_INLINE]
      0x0128: PHI (r4v7 java.io.ByteArrayOutputStream) = (r4v6 java.io.ByteArrayOutputStream), (r4v10 java.io.ByteArrayOutputStream) binds: [B:74:0x0126, B:63:0x010d] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.bytedance.applog.log.IAppLogLogger] */
    /* JADX WARN: Type inference failed for: r15v0, types: [int] */
    /* JADX WARN: Type inference failed for: r15v12, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(int r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.q3.a(int):java.lang.String");
    }

    public static JSONObject a(s3.b bVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("frame", bVar.b.a());
            jSONObject.put("_element_path", bVar.c);
            jSONObject.put("element_path", bVar.d);
            List<String> list = bVar.e;
            if (list != null && list.size() > 0) {
                jSONObject.put("positions", new JSONArray((Collection) bVar.e));
            }
            List<String> list2 = bVar.g;
            if (list2 != null && list2.size() > 0) {
                jSONObject.put("texts", new JSONArray((Collection) bVar.g));
            }
            List<String> list3 = bVar.k;
            if (list3 != null && list3.size() > 0) {
                jSONObject.put("fuzzy_positions", new JSONArray((Collection) bVar.k));
            }
            jSONObject.put("zIndex", bVar.f);
            List<s3.b> list4 = bVar.h;
            if (list4 != null && !list4.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<s3.b> it = bVar.h.iterator();
                while (it.hasNext()) {
                    jSONArray.put(a(it.next()));
                }
                jSONObject.put("children", jSONArray);
            }
            return jSONObject;
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "getWebViewDom failed", th, new Object[0]);
            return null;
        }
    }
}
