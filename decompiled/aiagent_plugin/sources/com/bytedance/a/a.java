package com.bytedance.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AuthorizedApps.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Vector<C0099a> f3973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Vector<C0099a> f3974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f3976e;

    /* JADX INFO: renamed from: com.bytedance.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AuthorizedApps.java */
    private class C0099a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f3977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f3978b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f3979c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f3980d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f3981e;
        private int f;

        static /* synthetic */ String a(C0099a r0) {
            return r0.f3978b;
        }

        static /* synthetic */ String b(C0099a r0) {
            return r0.f3980d;
        }

        public C0099a(a r1) {
            this.f3977a = r1;
        }

        public void a(String r4, String r5, int r6) {
            PackageInfo r0 = d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.a(this.f3977a), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
            if (r0 != null) goto L5;
            b.e(a.a(), "Get package info failed! package:" + r4);
            this.f3979c = "";
            this.f3981e = "";
        L6:
            this.f = r6;
            this.f3978b = r4;
            this.f3980d = r5;
            return;
        L5:
            this.f3979c = r0.packageName;
            this.f3981e = r0.versionName;
            goto L6
        }
    }

    static {
    }

    static /* synthetic */ Context a(a r0) {
        return r0.f3976e;
    }

    static /* synthetic */ String a() {
        return TAG;
    }

    public a() {
        this.f3972a = -1;
        this.f3973b = new Vector();
        this.f3974c = new Vector();
    }

    public int a(Context r5, String r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L5;
    L23:
        b.e(TAG, "Input init param is invalid!!");
        return 1;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L23;
        if (r7 == 1) goto L10;
        b.e(TAG, "Not supported vendor type!!");
        return 1;
    L10:
        String r0 = TAG;
        b.d(r0, "Init file:" + r6);
        this.f3976e = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        File r9 = new File(r6);
        if (r9.exists() == true) goto L13;
    L21:
        b.e(r0, "File not exist:" + r6);
        return 2;
    L13:
        if (r9.isFile() == false) goto L21;
        int r10 = new c().a(r6, r7);
        if (r10 == 0) goto L20;
        b.e(r0, "Authorized apps file signature verify failed, result:" + r10);
        return r10;
    L20:
        return d(r6);
    }

    public boolean a(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L7;
        b.e(TAG, "Input subject app is invalid!!");
        return false;
    L7:
        if (this.f3973b.isEmpty() == false) goto L10;
        b.e(TAG, "Authorized subject apps are not initialized!!");
        return false;
    L10:
        Iterator<C0099a> r0 = this.f3973b.iterator();
    L12:
        if (r0.hasNext() == false) goto L27;
        C0099a r2 = (C0099a) ZeusTransformUtils.preCheckCast(r0.next(), C0099a.class, "com.obric.aiagent.plugin");
        if (TextUtils.equals(r8, C0099a.a(r2)) == false) goto L12;
        byte[] r3 = d.b(this.f3976e, r8);
        if (r3 == null) goto L25;
        if (r3.length == 0) goto L25;
        String r4 = d.a(r3);
        String r5 = TAG;
        b.c(r5, "packageName:" + r8 + " signHash:" + r4);
        if (TextUtils.equals(r4, C0099a.b(r2)) == true) goto L22;
        b.e(r5, "App signature is invalid:" + r4 + " app:" + r8);
        goto L12
    L22:
        b.c(r5, "Check subject app:" + r8 + " success!");
        return true;
    L25:
        b.e(TAG, "Get subject app signature failed! app:" + r8);
        return false;
    L27:
        b.e(TAG, "Not valid subject app:" + r8);
        return false;
    }

    public boolean b(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L7;
        b.e(TAG, "Input target app is invalid!!");
        return false;
    L7:
        if (this.f3974c.isEmpty() == false) goto L10;
        b.e(TAG, "Authorized target apps are not initialized!!");
        return false;
    L10:
        Iterator<C0099a> r0 = this.f3974c.iterator();
    L12:
        if (r0.hasNext() == false) goto L27;
        C0099a r2 = (C0099a) ZeusTransformUtils.preCheckCast(r0.next(), C0099a.class, "com.obric.aiagent.plugin");
        if (TextUtils.equals(r8, C0099a.a(r2)) == false) goto L12;
        byte[] r3 = d.b(this.f3976e, r8);
        if (r3 == null) goto L25;
        if (r3.length == 0) goto L25;
        String r4 = d.a(r3);
        String r5 = TAG;
        b.c(r5, "packageName:" + r8 + " signHash:" + r4);
        if (TextUtils.equals(r4, C0099a.b(r2)) == true) goto L22;
        b.e(r5, "App signature is invalid:" + r4 + " app:" + r8);
        goto L12
    L22:
        b.c(r5, "Check target app:" + r8 + " success!");
        return true;
    L25:
        b.e(TAG, "Get target app signature failed! app:" + r8);
        return false;
    L27:
        b.e(TAG, "Not valid target app:" + r8);
        return false;
    }

    private void c(String r4) {
        if (b.a() == true) goto L5;
        return;
    L5:
        byte[] r3 = d.b(this.f3976e, r4);
        if (r3 != null) goto L8;
    L12:
        b.e(TAG, "Get subject app signature failed! app:" + r4);
        return;
    L8:
        if (r3.length == 0) goto L12;
        b.c(TAG, "packageName:" + r4 + " signHash:" + d.a(r3));
    }

    private int d(String r10) {
        FileReader r0 = new FileReader(r10);     // Catch: JSONException -> L26 IOException -> L28
        char[] r11 = new char[1024];     // Catch: Throwable -> L20
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L20
    L5:
        int r2 = r0.read(r11);     // Catch: Throwable -> L20
        if (r2 <= 0) goto L8;
        r1.append(r11, 0, r2);     // Catch: Throwable -> L20
        goto L5
    L8:
        JSONObject r12 = new JSONObject(r1.toString());     // Catch: Throwable -> L20
        String r3 = r12.getString("content");     // Catch: Throwable -> L20
        this.f3975d = r12.getString("signature");     // Catch: Throwable -> L20
        JSONObject r13 = new JSONObject(r3);     // Catch: Throwable -> L20
        this.f3972a = r13.getInt("version");     // Catch: Throwable -> L20
        b.d(TAG, "Authorized apps file version:" + this.f3972a);     // Catch: Throwable -> L20
        JSONArray r4 = new JSONArray(r13.getString("subject_apps"));     // Catch: Throwable -> L20
        int r5 = 0;
    L11:
        if (r5 >= r4.length()) goto L13;
        JSONObject r6 = r4.getJSONObject(r5);     // Catch: Throwable -> L20
        String r7 = r6.getString("package");     // Catch: Throwable -> L20
        String r8 = r6.getString("sign");     // Catch: Throwable -> L20
        C0099a r9 = new C0099a(this);     // Catch: Throwable -> L20
        r9.a(r7, r8, 1);     // Catch: Throwable -> L20
        this.f3973b.add(r9);     // Catch: Throwable -> L20
        c(r7);     // Catch: Throwable -> L20
        r5 = r5 + 1;     // Catch: Throwable -> L20
        goto L11
    L13:
        JSONArray r14 = new JSONArray(r13.getString("target_apps"));     // Catch: Throwable -> L20
        int r15 = 0;
    L14:
        if (r15 >= r14.length()) goto L18;
        JSONObject r16 = r14.getJSONObject(r15);     // Catch: Throwable -> L20
        String r17 = r16.getString("package");     // Catch: Throwable -> L20
        String r18 = r16.getString("sign");     // Catch: Throwable -> L20
        C0099a r19 = new C0099a(this);     // Catch: Throwable -> L20
        r19.a(r17, r18, 2);     // Catch: Throwable -> L20
        this.f3974c.add(r19);     // Catch: Throwable -> L20
        c(r17);     // Catch: Throwable -> L20
        r15 = r15 + 1;
        goto L14
    L18:
        r0.close();     // Catch: JSONException -> L26 IOException -> L28
        return 0;
    L20:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: JSONException -> L26 IOException -> L28
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: JSONException -> L26 IOException -> L28
    L28:
        e = move-exception;
        b.e(TAG, "Parse authorized apps failed, IOException error:" + e.getMessage());
        return 3;
    L26:
        e = move-exception;
        b.e(TAG, "Parse authorized apps failed, JSONException error:" + e.getMessage());
        return 3;
    }
}
