package com.bytedance.mobsec.metasec.a;

import android.text.TextUtils;
import com.google.protobuf.DescriptorProtos;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import ms.bd.c.s1;
import ms.bd.c.y0;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f8851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f8852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f8853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f8854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f8855e;
    protected String f;
    protected String g;
    protected String h;
    protected String i;
    protected String j;
    protected String k;
    protected int l;
    protected int m;
    protected int n;
    protected Map<String, String> o;
    protected Map<String, String> p;
    protected com.bytedance.mobsec.metasec.ml.b.a.InterfaceC0200a q;
    protected String r;
    protected int s;

    public static abstract class a<T extends b> extends c implements b {
        public a(String r1, String r2, int r3) {
            this.f8851a = r1;
            this.i = r2;
            this.n = r3;
            if (TextUtils.isEmpty(r1) == true) goto L10;
            if ("0".equals(r1) == true) goto L10;
            if (TextUtils.isEmpty(r2) == true) goto L10;
            return;
        L10:
            throw new IllegalArgumentException("appID or license must be set.");
        }

        public T a(int r1) {
            this.l = r1;
            return this;
        }

        public T a(com.bytedance.mobsec.metasec.ml.b.a.InterfaceC0201b r3) {
            com.bytedance.mobsec.metasec.ml.b.a.InterfaceC0201b r4 = (com.bytedance.mobsec.metasec.ml.b.a.InterfaceC0201b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.mobsec.metasec.ml.b.a.InterfaceC0201b.class, "com.obric.aiagent.plugin");
            y0.a().a(r4);
            return this;
        }

        public T a(String r2, String r3) {
            this.p.put(r2, r3);
            return this;
        }

        public T b(String r1) {
            this.f8852b = r1;
            return this;
        }

        public c b() {
            if (this.l == (-1)) goto L6;
            return this;
        L6:
            throw new IllegalArgumentException("MSConfig init error");
        }

        public T c(String r1) {
            this.j = r1;
            return this;
        }

        public T d(String r1) {
            this.f8853c = r1;
            return this;
        }

        public T e(String r1) {
            this.f8855e = r1;
            return this;
        }
    }

    public interface b {
    }

    public c() {
        this.f8851a = "";
        this.f8852b = "";
        this.f8853c = "";
        this.f8854d = "";
        this.f8855e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = -1;
        this.m = -1;
        this.n = DescriptorProtos.Edition.EDITION_99999_TEST_ONLY_VALUE;
        this.o = new HashMap();
        this.p = new HashMap();
    }

    synchronized String a() {
        monitor-enter(this);
        JSONArray r0 = new JSONArray();     // Catch: Throwable -> L18
        r0.put(a(this.f8851a));     // Catch: Throwable -> L18
        r0.put(a(this.h));     // Catch: Throwable -> L18
        r0.put(a(this.g));     // Catch: Throwable -> L18
        r0.put(a(this.i));     // Catch: Throwable -> L18
        r0.put(a(s1.a()));     // Catch: Throwable -> L18
        r0.put(a(this.f8852b));     // Catch: Throwable -> L18
        r0.put(a(this.f8853c));     // Catch: Throwable -> L18
        r0.put(a(this.f8854d));     // Catch: Throwable -> L18
        r0.put(a(this.f8855e));     // Catch: Throwable -> L18
        r0.put(a(this.f));     // Catch: Throwable -> L18
        r0.put(String.valueOf(this.l));     // Catch: Throwable -> L18
        r0.put(String.valueOf(this.m));     // Catch: Throwable -> L18
        r0.put(String.valueOf(this.n));     // Catch: Throwable -> L18
        r0.put(a(this.r));     // Catch: Throwable -> L18
        r0.put(String.valueOf(this.s));     // Catch: Throwable -> L18
        JSONArray r1 = new JSONArray();     // Catch: Throwable -> L18
        Iterator<Map.Entry<String, String>> r2 = this.o.entrySet().iterator();     // Catch: Throwable -> L18
    L5:
        if (r2.hasNext() == false) goto L9;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r3.getKey(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L5;
        r1.put(a(r3.getKey()));     // Catch: Throwable -> L18
        r1.put(a(r3.getValue()));     // Catch: Throwable -> L18
        goto L5
    L9:
        r0.put(r1);     // Catch: Throwable -> L18
        JSONArray r4 = new JSONArray();     // Catch: Throwable -> L18
        Iterator<Map.Entry<String, String>> r5 = this.p.entrySet().iterator();     // Catch: Throwable -> L18
    L11:
        if (r5.hasNext() == false) goto L15;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r6.getKey(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L11;
        r4.put(a(r6.getKey()));     // Catch: Throwable -> L18
        r4.put(a(r6.getValue()));     // Catch: Throwable -> L18
        goto L11
    L15:
        r0.put(r4);     // Catch: Throwable -> L18
        String r7 = r0.toString();     // Catch: Throwable -> L18
        monitor-exit(this);
        return r7;
    L18:
        th = move-exception;
        throw th;
    }

    String a(Object r2) {
        if (r2 != null) goto L4;
        return "";
    L4:
        if (ZeusTransformUtils.instanceOf(r2, String.class) == true) goto L6;
        return "";
    L6:
        return ((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin")).trim();
    }

    public synchronized void a(String r1) {
        monitor-enter(this);
        this.r = r1;     // Catch: Throwable -> L6
        this.s = 1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
