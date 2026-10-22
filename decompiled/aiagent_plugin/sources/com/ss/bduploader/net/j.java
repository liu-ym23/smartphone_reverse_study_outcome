package com.ss.bduploader.net;

import android.os.Handler;
import android.text.TextUtils;
import com.ss.bduploader.s;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: HTTPDNS.java */
/* JADX INFO: loaded from: classes4.dex */
public class j extends h {
    private static final String TAG = "HTTPDNS";
    private static String f = "/q?host=";
    private static String g = "/resolve?name=";
    private static String i = "";
    private static String j = "";
    private int h;

    static {
    }

    static /* synthetic */ void a(j r0, JSONObject r1, i r2) {
        r0.a(r1, r2);
    }

    public j(String r1, g r2, int r3, Handler r4) {
        super(r1, r2, r4);
        this.h = 2;
        this.h = r3;
    }

    @Override // com.ss.bduploader.net.h
    public void a() {
        String r1 = d();
        Method[] r0 = this.f37535d.getClass().getDeclaredMethods();
        int r2 = r0.length;
        boolean r3 = false;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L10;
        Method r5 = r0[r4];
        if (r5.getName().equals("startTask") == false) goto L9;
        if (r5.getParameterTypes().length != 5) goto L9;
        r3 = true;
    L9:
        r4 = r4 + 1;
    L10:
        if (r3 == false) goto L12;
        this.f37535d.a(r1, null, null, 0, new AnonymousClass1(this));
        return;
    L12:
        this.f37535d.a(r1, null, new AnonymousClass2(this));
    }

    @Override // com.ss.bduploader.net.h
    public void b() {
        if (this.f37533b == false) goto L5;
        return;
    L5:
        this.f37533b = true;
        this.f37535d.a();
    }

    private String d() {
        StringBuilder r0 = new StringBuilder();
        int r1 = this.h;
        if (r1 != 2) goto L5;
    L10:
        r0.append("https://" + i + f);
    L11:
        r0.append(this.f37534c);
        return r0.toString();
    L5:
        if (r1 == 1) goto L10;
        if (r1 != 3) goto L11;
        r0.append("https://" + j + g);
        goto L11
    }

    private b a(JSONObject r16) {
        int r0 = this.h;
        String r10 = "";
        int r11 = 60;
        if (r0 == 2) goto L7;
        if (r0 == 1) goto L7;
        long r12 = 0;
        String r1 = null;
    L31:
        if (this.h != 3) goto L59;
        JSONArray r2 = r16.getJSONArray("Answer");     // Catch: Exception -> L54
        int r7 = 0;
    L34:
        if (r7 >= r2.length()) goto L52;
        JSONObject r8 = r2.getJSONObject(r7);     // Catch: Exception -> L54
        if (r8.has("type") == false) goto L51;
        if (r8.getInt("type") != 1) goto L51;
        if (r8.has("TTL") == false) goto L43;
        r11 = r8.optInt("TTL");     // Catch: Exception -> L54
    L43:
        if (r8.has("data") == false) goto L46;
        r1 = r8.optString("data");     // Catch: Exception -> L54
    L46:
        if (TextUtils.isEmpty(r1) == true) goto L51;
        if (TextUtils.isEmpty(r10) == false) goto L50;
        r10 = r10 + r1;     // Catch: Exception -> L54
        goto L51
    L50:
        r10 = r10 + "," + r1;     // Catch: Exception -> L54
    L51:
        r7 = r7 + 1;     // Catch: Exception -> L54
        goto L34
    L52:
        r12 = System.currentTimeMillis() + ((long) (r11 * 1000));
    L54:
        e = move-exception;
        e.printStackTrace();
        return null;
    L59:
        return new b(this.h, this.f37534c, r10, r12, this.f37536e);
    L7:
        JSONArray r13 = r16.optJSONArray("ips");
        if (r13 != null) goto L10;
    L60:
        s.c(TAG, String.format("no ips in json, type:%d", new Object[]{Integer.valueOf(this.h)}));
        return null;
    L10:
        if (r13.length() == 0) goto L60;
        if (r16.has("ttl") == false) goto L15;
        r11 = r16.optInt("ttl");
    L15:
        long r9 = ((long) (r11 * 1000)) + System.currentTimeMillis();
        r1 = null;
        int r14 = 0;
    L17:
        if (r14 >= r13.length()) goto L29;
        r1 = r13.getString(r14);     // Catch: Exception -> L20
    L23:
        if (TextUtils.isEmpty(r1) == true) goto L28;
        if (TextUtils.isEmpty(r10) == false) goto L27;
        r10 = r10 + r1;
        goto L28
    L27:
        r10 = r10 + "," + r1;
    L28:
        r14 = r14 + 1;
    L20:
        e = move-exception;
        e.printStackTrace();
        r1 = null;
        goto L23
    L29:
        r12 = r9;
        goto L31
    }

    private void a(JSONObject r12, i r13) {
        s.c(TAG, String.format("****http dns id:%s", new Object[]{this.f37536e}));
        b r1 = new b(this.h, this.f37534c, null, 0, this.f37536e);
        if (r13 == null) goto L5;
        r1.f = r13.f37540d;
    L15:
        a(r1);
        return;
    L5:
        if (r12 != null) goto L7;
    L14:
        s.c(TAG, String.format("http dns json is empty type:%d", new Object[]{Integer.valueOf(this.h)}));
        goto L15
    L7:
        if (r12.length() == 0) goto L14;
        b r14 = a(r12);
        if (r14 == null) goto L15;
        k.a().a(this.f37534c, r14);
        b(r14);
    }
}
