package com.bytedance.reparo.core.g;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: LocalRecordParser.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private static final String TAG = "LocalRecordParser";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.reparo.core.g f9225a;

    /* JADX INFO: renamed from: com.bytedance.reparo.core.g.f$1, reason: invalid class name */
    /* JADX INFO: compiled from: LocalRecordParser.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: LocalRecordParser.java */
    private static class a {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        public e a(String r9) {
            e r8 = new e();
            if (TextUtils.isEmpty(r9) == false) goto L5;
        L15:
            return r8;
        L5:
            if (TextUtils.equals("{}", r9) == true) goto L15;
            JSONObject r0 = new JSONObject(r9);
            r8.a(r0.optString("hostAppVersion"));
            HashSet r1 = new HashSet();
            JSONArray r2 = r0.optJSONArray("patchRecordInfoSet");
            if (r2 != null) goto L10;
            return r8;
        L10:
            int r3 = 0;
        L12:
            if (r3 >= r2.length()) goto L14;
            JSONObject r4 = r2.getJSONObject(r3);
            h r5 = new h();
            r5.a(r4.optBoolean("hasJavaPatch"));
            r5.b(r4.optBoolean("hasSoLibraries"));
            r5.e(r4.optString("hostAppVersion"));
            r5.a(new File(r4.optString("installDirPath")));
            r5.d(r4.optBoolean("isAsyncLoad", true));
            r5.e(r4.optBoolean("isSupportSubProcess", false));
            r5.b(new File(r4.optString("javaPatchRootDirPath")));
            r5.d(r4.optString("patchId"));
            r5.b(r4.optString("issueId"));
            r5.a(r4.optString("patchMd5"));
            r5.c(r4.optString("patchVersion"));
            r5.c(new File(r4.optString("soInfoFilePath")));
            r1.add(r5);
            r3 = r3 + 1;
            goto L12
        L14:
            r8.a(r1);
            goto L15
        }

        public String a(e r4) {
            String r3 = b(r4);     // Catch: JSONException -> L7
            if (TextUtils.equals("{}", r3) == false) goto L6;
            return "";
        L6:
            return r3;
        L7:
            e = move-exception;
            com.bytedance.reparo.core.j.b(f.TAG, "to json error. " + r4.toString(), e);
            return "";
        }

        public String b(e r7) {
            JSONObject r6 = new JSONObject();
            if (TextUtils.isEmpty(r7.b()) == true) goto L5;
            r6.putOpt("hostAppVersion", r7.b());
        L5:
            Set<h> r8 = r7.a();
            if (r8.size() <= 0) goto L13;
            JSONArray r0 = new JSONArray();
            Iterator<h> r9 = r8.iterator();
        L9:
            if (r9.hasNext() == false) goto L11;
            h r2 = (h) ZeusTransformUtils.preCheckCast(r9.next(), h.class, "com.obric.aiagent.plugin");
            JSONObject r3 = new JSONObject();
            r3.putOpt("hostAppVersion", r2.o());
            r3.putOpt("hasJavaPatch", Boolean.valueOf(r2.d()));
            r3.putOpt("hasSoLibraries", Boolean.valueOf(r2.g()));
            r3.putOpt("installDirPath", r2.c());
            r3.putOpt("isAsyncLoad", Boolean.valueOf(r2.r()));
            r3.putOpt("isSupportSubProcess", Boolean.valueOf(r2.s()));
            r3.putOpt("javaPatchRootDirPath", r2.e());
            r3.putOpt("patchId", r2.n());
            r3.putOpt("issueId", r2.l());
            r3.putOpt("patchMd5", r2.k());
            r3.putOpt("patchVersion", r2.m());
            r3.putOpt("soInfoFilePath", r2.j());
            r0.put(r3);
            goto L9
        L11:
            r6.put("patchRecordInfoSet", r0);
        L13:
            return r6.toString();
        }
    }

    public f(com.bytedance.reparo.core.g r1) {
        this.f9225a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e a() {
        String r0 = b();
        e r1 = null;
        r1 = new a(0 == true ? 1 : 0).a(r0);     // Catch: Exception -> L5
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return new e();
    L5:
        com.bytedance.reparo.core.a.b.b.delete(this.f9225a.c());
        com.bytedance.reparo.core.j.d(TAG, "parse local-record.info failed. " + r0);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.reparo.core.g.c] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13, types: [com.bytedance.reparo.core.g.c] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7, types: [com.bytedance.reparo.core.g.c] */
    private String b() {
        File r2 = this.f9225a.c();
        ?? r9 = this.f9225a.d();
        StringBuilder r3 = new StringBuilder();
        ?? r4 = 0;
        r4 = 0;
        com.bytedance.reparo.core.a.b.b.c(r2);     // Catch: Throwable -> L27 IOException -> L29
        FileInputStream r5 = new FileInputStream(r2);     // Catch: Throwable -> L27 IOException -> L29
    L60:
        r9 = c.a(r9);     // Catch: Throwable -> L23 IOException -> L25
        InputStreamReader r6 = new InputStreamReader(r5);     // Catch: Throwable -> L19 IOException -> L21
    L51:
        char[] r7 = new char[1024];     // Catch: IOException -> L17 Throwable -> L39
    L8:
        int r8 = r6.read(r7);     // Catch: IOException -> L17 Throwable -> L39
        if (r8 == (-1)) goto L12;
        r3.append(r7, 0, r8);     // Catch: IOException -> L17 Throwable -> L39
        goto L8
    L12:
        if (r9 != 0) goto L53;
    L37:
        com.bytedance.reparo.core.a.b.c.a(r5);
        com.bytedance.reparo.core.a.b.c.a(r6);
        return r3.toString();
    L53:
        r9.close();     // Catch: IOException -> L15
    L15:
        e = e;
    L36:
        com.bytedance.reparo.core.j.b(TAG, "close lock helper failed.(read)", e);
    L17:
        IOException e2 = e;
    L31:
        com.bytedance.reparo.core.j.b(TAG, "read local record failed.", e2);     // Catch: Throwable -> L39
        if (r9 == 0) goto L37;
        r9.close();     // Catch: IOException -> L35
    L35:
        e = e;
    L21:
        e = move-exception;
        e2 = e;
        r6 = null;
    L19:
        th = th;
        r2 = null;
    L40:
        r4 = r9;
        ?? r10 = r2;
    L41:
        if (r4 != 0) goto L55;
    L46:
        com.bytedance.reparo.core.a.b.c.a(r5);
        com.bytedance.reparo.core.a.b.c.a(r10);
        throw th;
    L55:
        r4.close();     // Catch: IOException -> L44
    L44:
        e = move-exception;
        com.bytedance.reparo.core.j.b(TAG, "close lock helper failed.(read)", e);
        goto L46
    L25:
        e = move-exception;
        r6 = null;
        e2 = e;
        r9 = 0;
    L23:
        th = th;
        r10 = 0;
    L39:
        th = th;
    L29:
        e = move-exception;
        r6 = null;
        r5 = null;
        e2 = e;
        r9 = 0;
    L27:
        th = th;
        r10 = 0;
        r5 = null;
        goto L41
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.reparo.core.g.f$1] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.reparo.core.g.c] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.reparo.core.g.c] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.bytedance.reparo.core.g.c] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    public void a(e r6) {
        ?? r3 = 0;
        r3 = 0;
        r3 = 0;
        r3 = 0;
        String r7 = new a(r3).a(r6);
        File r2 = this.f9225a.c();
        File r5 = this.f9225a.d();
        com.bytedance.reparo.core.a.b.b.c(r2);     // Catch: Throwable -> L12 IOException -> L14
        FileOutputStream r4 = new FileOutputStream(r2);     // Catch: Throwable -> L12 IOException -> L14
        r3 = c.a(r5);     // Catch: IOException -> L10 Throwable -> L24
        r4.write(r7.getBytes());     // Catch: IOException -> L10 Throwable -> L24
        if (r3 != 0) goto L38;
    L22:
        com.bytedance.reparo.core.a.b.c.a(r4);
        return;
    L38:
        r3.close();     // Catch: IOException -> L8
    L8:
        e = e;
    L21:
        com.bytedance.reparo.core.j.b(TAG, "close lock helper failed.(write)", e);
    L10:
        e = e;
    L16:
        com.bytedance.reparo.core.j.b(TAG, "write local record failed. ", e);     // Catch: Throwable -> L24
        if (r3 == 0) goto L22;
        r3.close();     // Catch: IOException -> L20
    L20:
        e = e;
    L24:
        th = th;
    L25:
        if (r3 != 0) goto L36;
    L30:
        com.bytedance.reparo.core.a.b.c.a(r4);
        throw th;
    L36:
        r3.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        com.bytedance.reparo.core.j.b(TAG, "close lock helper failed.(write)", e);
        goto L30
    L14:
        e = e;
        r4 = null;
    L12:
        th = th;
        r4 = null;
        goto L25
    }
}
