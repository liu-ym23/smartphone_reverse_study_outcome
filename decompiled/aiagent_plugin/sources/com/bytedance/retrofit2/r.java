package com.bytedance.retrofit2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: InterceptorRecorder.java */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Deque<a> f9580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Deque<a> f9581b;

    /* JADX INFO: compiled from: InterceptorRecorder.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f9583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f9584c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f9585d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f9586e;
        public long f;
        public String g;

        a(String r3, boolean r4, long r5) {
            this.f9584c = -1;
            this.f9585d = -1;
            this.f9586e = -1;
            this.f = -1;
            this.g = null;
            this.f9582a = r3;
            this.f9583b = r4;
            this.f9584c = r5;
        }

        public a a() {
            a r0 = new a(this.f9582a, this.f9583b, this.f9584c);
            r0.f9585d = this.f9585d;
            r0.f9586e = this.f9586e;
            r0.f = this.f;
            r0.g = this.g;
            return r0;
        }
    }

    public r() {
        this.f9580a = new ArrayDeque();
        this.f9581b = new ArrayDeque();
    }

    public void a(a r1) {
        this.f9580a.push(r1);
    }

    public a a() {
        return (a) ZeusTransformUtils.preCheckCast(this.f9580a.peek(), a.class, "com.obric.aiagent.plugin");
    }

    public a b() {
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f9580a.pop(), a.class, "com.obric.aiagent.plugin");     // Catch: NoSuchElementException -> L4
        this.f9581b.push(r0);     // Catch: NoSuchElementException -> L4
        return r0;
    L4:
        return null;
    }

    public JSONObject c() {
        JSONObject r0 = new JSONObject();
        JSONArray r1 = new JSONArray();
        new HashMap();
        Iterator<a> r14 = this.f9581b.iterator();
        long r4 = 0;
        long r6 = 0;
    L4:
        if (r14.hasNext() == false) goto L15;
        a r8 = (a) ZeusTransformUtils.preCheckCast(r14.next(), a.class, "com.obric.aiagent.plugin");
        JSONObject r9 = new JSONObject();
        r9.put("name", r8.f9582a);
        long r10 = am.a(r8.f9584c, r8.f9585d);
        if (r10 <= 0) goto L8;
        r4 = r4 + r10;
    L8:
        r9.put("req", r10);
        long r11 = am.a(r8.f9586e, r8.f);
        if (r11 <= 0) goto L11;
        r6 = r6 + r11;
    L11:
        r9.put("rsp", r11);
        if (r8.g == null) goto L14;
        r9.put("ex", r8.g);
    L14:
        r1.put(r9);
        goto L4
    L15:
        r0.put("detail", r1);
        r0.put("req_total", r4);
        r0.put("rsp_total", r6);
        return r0;
    }

    public r d() {
        r r0 = new r();
        r0.f9580a = new ArrayDeque();
        Iterator<a> r1 = this.f9580a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin");
        r0.f9580a.push(r2.a());
        goto L4
    L6:
        r0.f9581b = new ArrayDeque();
        Iterator<a> r5 = this.f9581b.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r5.next(), a.class, "com.obric.aiagent.plugin");
        r0.f9581b.push(r3.a());
        goto L8
    L10:
        return r0;
    }
}
