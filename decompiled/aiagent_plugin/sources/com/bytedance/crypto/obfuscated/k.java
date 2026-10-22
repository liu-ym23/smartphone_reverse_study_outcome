package com.bytedance.crypto.obfuscated;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import javax.crypto.spec.SecretKeySpec;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile k f7868a;

    public k() {
    }

    public static k a() {
        if (f7868a != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7868a != null) goto L9;
        f7868a = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return f7868a;
    }

    public a a(Context r9, j r10, Bundle r11) {
        n r8 = n.a((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin"));
        r8.getClass();
        a("a", "addData alias:" + r10.f7863a);
        if (TextUtils.isEmpty(r10.f7863a) == false) goto L5;
        b("a", "input data is invalid!!");
        return new a(-2, "");
    L5:
        j r12 = r8.f7872b.a(r10.f7863a, r8.f7873c.getPackageName());
        if (r12 != null) goto L8;
    L11:
        boolean r13 = false;
    L12:
        if (r13 == false) goto L15;
        b("a", "data already exist, alias: " + r10.f7863a);
        return new a(-7, r10.f7863a);
    L15:
        if (TextUtils.isEmpty(r10.f) == true) goto L17;
    L21:
        j r14 = n.a(r10);
        String r4 = System.currentTimeMillis() + "";
        r14.l = r4;
        r14.m = r4;
        if (TextUtils.isEmpty(r14.f) == true) goto L31;
        if (r14.f.length() <= 4096) goto L26;
        b("a", "input secret data is too long!!");
        return new a(-2, r10.f7863a);
    L26:
        Context r15 = r8.f7873c;
        a("d", "getSecretEncKey");
        byte[] r16 = o.a(r8.f7873c, r.a(r15, "secret_enc_key"), 1, r14.f.getBytes());
        if (r16.length != 0) goto L29;
        b("a", "encrypt secret data fail, alias: " + r14.f7863a);
        return new a(-4, r14.f7863a);
    L29:
        r14.f = q.a(r16);
    L31:
        if (TextUtils.isEmpty(r14.f7867e) == true) goto L40;
        Context r17 = r8.f7873c;
        a("d", "getPrivateEncKey");
        SecretKeySpec r0 = r.f7876a;
        if (r0 != null) goto L36;
        r0 = r.a(r17, "private_enc_key");
        r.f7876a = r0;
    L36:
        byte[] r18 = o.a(r8.f7873c, r0, 1, r14.f7867e.getBytes());
        if (r18.length != 0) goto L39;
        b("a", "encrypt private data fail, alias: " + r14.f7863a);
        return new a(-4, r14.f7863a);
    L39:
        r14.f7867e = q.a(r18);
    L40:
        m r19 = r8.f7872b;
        String r20 = r8.f7873c.getPackageName();
        r19.getClass();
        a("a", "insertData, alias: " + r14.f7863a + ", pkgName: " + r20);
        SQLiteDatabase r110 = r19.getWritableDatabase();
        ContentValues r1 = new ContentValues();
        r1.put("alias", r14.f7863a);
        r1.put("pkg_name", r20);
        r1.put("public_data", r14.f7866d);
        r1.put("private_data", r14.f7867e);
        r1.put("secret_data", r14.f);
        r1.put("data_type", r14.f7864b);
        r1.put("associate", r14.f7865c);
        r1.put("access_limit", "");
        r1.put("auth_limit", "");
        r1.put("sync_limit", 0);
        r1.put("search_info", r14.h);
        r1.put("ext_info", r14.g);
        r1.put("create_time", r14.l);
        r1.put("latest_time", r14.m);
        r1.put("global_id", "");
        r1.put("status", 0);
        r1.put("sync_status", 0);
        long r2 = r110.insert("secret_item", null, r1);
        if (r2 >= 0) goto L44;
        b("a", "insert data fail, ret: " + r2);
        return new a(-6, "insert data fail");
    L44:
        return new a(0, r14.f7863a);
    L17:
        if (TextUtils.isEmpty(r10.f7867e) == false) goto L21;
        if (TextUtils.isEmpty(r10.f7866d) == false) goto L21;
        b("a", "input core data is empty!!");
        return new a(-2, r10.f7863a);
    L8:
        if (TextUtils.isEmpty(r12.f7863a) == true) goto L11;
        r13 = true;
        goto L12
    }

    public i a(Context r8, String r9, Bundle r10) {
        n r7 = n.a((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin"));
        r7.getClass();
        if (TextUtils.isEmpty(r9) == false) goto L5;
        b("a", "query data fail, invalid param!");
        return new i(-2, new ArrayList());
    L5:
        int r11 = r10.getInt("query_mode", 2);
        a("a", "queryData alias:" + r9 + " mode:" + r11);
        if (r11 != 2) goto L27;
        j r12 = r7.f7872b.a(r9, r7.f7873c.getPackageName());
        if (r12 != null) goto L11;
        b("a", "precise query data fail, alias: " + r9);
        return new i(-5, new ArrayList());
    L11:
        if (TextUtils.isEmpty(r12.f) == true) goto L17;
        Context r2 = r7.f7873c;
        a("d", "getSecretEncKey");
        byte[] r3 = o.a(r7.f7873c, r.a(r2, "secret_enc_key"), 2, q.a(r12.f));
        if (r3.length != 0) goto L15;
        b("a", "decrypt secret data fail, alias: " + r9);
        return new i(-4, new ArrayList());
    L15:
        r12.f = new String(r3);
    L17:
        if (TextUtils.isEmpty(r12.f7867e) == true) goto L26;
        Context r4 = r7.f7873c;
        a("d", "getPrivateEncKey");
        SecretKeySpec r5 = r.f7876a;
        if (r5 != null) goto L22;
        r5 = r.a(r4, "private_enc_key");
        r.f7876a = r5;
    L22:
        byte[] r13 = o.a(r7.f7873c, r5, 2, q.a(r12.f7867e));
        if (r13.length != 0) goto L25;
        b("a", "decrypt private data fail, alias: " + r9);
        return new i(-4, new ArrayList());
    L25:
        r12.f7867e = new String(r13);
    L26:
        ArrayList r14 = new ArrayList();
        r14.add(r12);
        return new i(0, r14);
    L27:
        if (r11 != 0) goto L29;
    L32:
        j r15 = r7.f7872b.a(r9, r7.f7873c.getPackageName());
        if (r15 != null) goto L35;
        b("a", "query data if exist fail, alias: " + r9);
        return new i(-5, new ArrayList());
    L35:
        ArrayList r16 = new ArrayList();
        r16.add(r15);
        return new i(0, r16);
    L29:
        if (r11 == 1) goto L32;
        b("a", "unsupported query mode: " + r11);
        return new i(-100, new ArrayList());
    }

    public int b(Context r7, j r8, Bundle r9) {
        n r6 = n.a((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"));
        r6.getClass();
        if (TextUtils.isEmpty(r8.f7863a) == false) goto L7;
        String r10 = "update data fail, invalid param!";
    L5:
        b("a", r10);
        return -2;
    L7:
        if (TextUtils.isEmpty(r8.f) == true) goto L9;
    L21:
        j r11 = n.a(r8);
        a("a", "updateData alias:" + r11.f7863a);
        r11.m = System.currentTimeMillis() + "";
        if (TextUtils.isEmpty(r11.f) == true) goto L32;
        if (r11.f.length() <= 4096) goto L26;
        r10 = "input secret data is too long!!";
        goto L5
    L26:
        Context r12 = r6.f7873c;
        a("d", "getSecretEncKey");
        byte[] r13 = o.a(r6.f7873c, r.a(r12, "secret_enc_key"), 1, r11.f.getBytes());
        if (r13.length != 0) goto L30;
        StringBuilder r14 = new StringBuilder("encrypt secret data fail, alias: ");
    L29:
        b("a", r14.append(r11.f7863a).toString());
        return -4;
    L30:
        r11.f = q.a(r13);
    L32:
        if (TextUtils.isEmpty(r11.f7867e) == true) goto L41;
        Context r15 = r6.f7873c;
        a("d", "getPrivateEncKey");
        SecretKeySpec r1 = r.f7876a;
        if (r1 != null) goto L37;
        r1 = r.a(r15, "private_enc_key");
        r.f7876a = r1;
    L37:
        byte[] r16 = o.a(r6.f7873c, r1, 1, r11.f7867e.getBytes());
        if (r16.length != 0) goto L40;
        r14 = new StringBuilder("encrypt private data fail, alias: ");
        goto L29
    L40:
        r11.f7867e = q.a(r16);
    L41:
        m r17 = r6.f7872b;
        String r18 = r6.f7873c.getPackageName();
        r17.getClass();
        a("a", "updateData, alias: " + r11.f7863a + ", pkgName: " + r18);
        SQLiteDatabase r19 = r17.getWritableDatabase();
        ContentValues r0 = new ContentValues();
        if (TextUtils.isEmpty(r11.f7866d) == true) goto L45;
        r0.put("public_data", r11.f7866d);
    L45:
        if (TextUtils.isEmpty(r11.f7867e) == true) goto L48;
        r0.put("private_data", r11.f7867e);
    L48:
        if (TextUtils.isEmpty(r11.f) == true) goto L51;
        r0.put("secret_data", r11.f);
    L51:
        if (TextUtils.isEmpty(r11.f7864b) == true) goto L54;
        r0.put("data_type", r11.f7864b);
    L54:
        if (TextUtils.isEmpty(r11.f7865c) == true) goto L57;
        r0.put("associate", r11.f7865c);
    L57:
        if (TextUtils.isEmpty(r11.g) == true) goto L60;
        r0.put("ext_info", r11.g);
    L60:
        if (TextUtils.isEmpty(r11.h) == true) goto L63;
        r0.put("search_info", r11.h);
    L63:
        if (TextUtils.isEmpty(r11.m) == true) goto L65;
        r0.put("latest_time", r11.m);
    L65:
        int r20 = r19.update("secret_item", r0, "alias =? AND pkg_name =? ", new String[]{r11.f7863a, r18});
        if (r20 == 1) goto L71;
        b("a", "update data fail, ret: " + r20);
        return -6;
    L71:
        return 0;
    L9:
        if (TextUtils.isEmpty(r8.f7867e) == false) goto L21;
        if (TextUtils.isEmpty(r8.f7866d) == false) goto L21;
        if (TextUtils.isEmpty(r8.g) == false) goto L21;
        if (TextUtils.isEmpty(r8.h) == false) goto L21;
        if (TextUtils.isEmpty(r8.f7864b) == false) goto L21;
        if (TextUtils.isEmpty(r8.f7865c) == false) goto L21;
        r10 = "all data is empty!!";
        goto L5
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
