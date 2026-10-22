package com.ss.android.deviceregister;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONArray;

/* JADX INFO: compiled from: DeviceParamsProvider.java */
/* JADX INFO: loaded from: classes4.dex */
public class e extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f37424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static JSONArray f37425e;
    private static String[] f;
    private static String g;

    e(Context r3, boolean r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // com.ss.android.deviceregister.a
    public void a(c r11, com.ss.android.deviceregister.a.a.a.b r12) {
        StringBuilder r0 = new StringBuilder().append("device_parameters");
        if (k.a() == false) goto L5;
        String r1 = "_i18n";
    L6:
        String r2 = r0.append(r1).toString();
        if (this.f37298b == false) goto L9;
        r2 = r2 + "_local";
    L9:
        String r3 = r2 + ".dat";
        String r7 = a(this.f37297a);
    L16:
        e = move-exception;
        e.printStackTrace();
    L18:
        boolean r8 = !com.ss.android.deviceregister.base.b.b();
        com.ss.android.deviceregister.a.a.a.d r9 = new com.ss.android.deviceregister.a.a.a.d(this.f37297a, r8, Environment.getExternalStorageDirectory().getPath() + com.ss.android.deviceregister.a.a.a.c.a("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U="), r3, r7);     // Catch: Exception -> L21
        r12.a(r9);     // Catch: Exception -> L21
        r12 = r9;
    L30:
        r12.a(new com.ss.android.deviceregister.a.a.a.d(this.f37297a, r8, Environment.getExternalStorageDirectory().getPath() + "/" + com.ss.android.deviceregister.a.a.a.c.a(), r3, r7));     // Catch: Exception -> L25
        return;
    L25:
        e = move-exception;
        e.printStackTrace();
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L30
    L11:
        if (com.ss.android.deviceregister.base.b.b() == false) goto L13;
        String r4 = "device_id";
    L14:
        com.ss.android.deviceregister.a.a.a.d r10 = new com.ss.android.deviceregister.a.a.a.d(this.f37297a, true, this.f37297a.getExternalCacheDir().getParent() + "/" + r4, r3, r7);     // Catch: Exception -> L16
        r12.a(r10);     // Catch: Exception -> L16
        r12 = r10;
        goto L18
    L13:
        r4 = com.ss.android.deviceregister.a.a.a.c.a();     // Catch: Exception -> L16
        goto L14
    L5:
        r1 = "";
        goto L6
    }

    @Override // com.ss.android.deviceregister.a.a.a
    public String c() {
        if (com.bytedance.common.utility.j.a(g) == false) goto L5;
        String r0 = com.ss.android.deviceregister.c.c.a(this.f37297a);     // Catch: Exception -> L11
        if (com.bytedance.common.utility.j.a(r0) == true) goto L9;
        r0 = r0 + this.f37299c;     // Catch: Exception -> L11
    L9:
        g = r0;     // Catch: Exception -> L11
        return r0;
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return g;
    }

    @Override // com.ss.android.deviceregister.a.a.a
    public String[] d() {
        String[] r0 = f;
        if (r0 != null) goto L5;
    L18:
        String[] r1 = com.ss.android.deviceregister.c.c.b(this.f37297a);     // Catch: Exception -> L15
        int r2 = 0;
        if (r1 != null) goto L11;
        r1 = new String[0];     // Catch: Exception -> L15
    L11:
        if (r2 >= r1.length) goto L13;
        r1[r2] = r1[r2] + this.f37299c;     // Catch: Exception -> L15
        r2 = r2 + 1;     // Catch: Exception -> L15
        goto L11
    L13:
        f = r1;     // Catch: Exception -> L15
        return r1;
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        if (r0.length <= 0) goto L18;
        return r0;
    }

    @Override // com.ss.android.deviceregister.a.a.a
    public String e() {
        if (com.bytedance.common.utility.j.a(f37424d) == false) goto L5;
        String r0 = com.ss.android.deviceregister.c.c.g(this.f37297a);     // Catch: Exception -> L11
        if (com.bytedance.common.utility.j.a(r0) == true) goto L9;
        r0 = r0 + this.f37299c;     // Catch: Exception -> L11
    L9:
        f37424d = r0;     // Catch: Exception -> L11
        return r0;
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return f37424d;
    }

    @Override // com.ss.android.deviceregister.a.a.a
    public JSONArray f() {
        JSONArray r0 = f37425e;
        if (r0 == null) goto L13;
        return r0;
    L13:
        JSONArray r1 = com.ss.android.deviceregister.c.c.i(this.f37297a);     // Catch: Exception -> L10
        if (TextUtils.isEmpty(this.f37299c) == true) goto L8;
        a(r1, this.f37299c);     // Catch: Exception -> L10
    L8:
        f37425e = r1;     // Catch: Exception -> L10
        return r1;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
