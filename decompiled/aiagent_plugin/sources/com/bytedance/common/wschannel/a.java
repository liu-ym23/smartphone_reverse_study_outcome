package com.bytedance.common.wschannel;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ChannelInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f6756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f6757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f6758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Map<String, String> f6759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Map<String, String> f6760e;
    List<String> f;
    int g;
    int h;
    String i;
    int j;
    boolean k;
    List<Integer> l;
    String m;
    h n;
    boolean o;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ChannelInfo.java */
    public static class C0152a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Map<String, String> f6761a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map<String, String> f6762b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<String> f6763c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f6764d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        List<Integer> f6765e;
        String f;
        h g;
        boolean h;
        private final int i;
        private int j;
        private int k;
        private int l;
        private String m;
        private String n;
        private String o;

        C0152a(int r2) {
            this.f6761a = new HashMap();
            this.f6762b = new HashMap();
            this.f6763c = new ArrayList();
            this.f6765e = new ArrayList();
            this.g = h.f6958a;
            this.i = r2;
        }

        public static C0152a a(int r1) {
            return new C0152a(r1);
        }

        public C0152a b(int r1) {
            this.k = r1;
            return this;
        }

        public C0152a c(int r1) {
            this.j = r1;
            return this;
        }

        public C0152a d(int r1) {
            this.l = r1;
            return this;
        }

        public C0152a a(String r1) {
            this.m = r1;
            return this;
        }

        public C0152a b(String r1) {
            this.n = r1;
            return this;
        }

        public C0152a c(String r1) {
            this.o = r1;
            return this;
        }

        public C0152a a(Map<String, String> r3) {
            Map<? extends String, ? extends String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L5;
            this.f6761a.putAll(r4);
        L5:
            return this;
        }

        public C0152a b(Map<String, String> r3) {
            Map<? extends String, ? extends String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L5;
            this.f6762b.putAll(r4);
        L5:
            return this;
        }

        public C0152a a(List<String> r3) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L5;
            this.f6763c.addAll(r4);
        L5:
            return this;
        }

        public a a() {
            return new a(this.k, this.j, this.l, this.m, this.i, this.n, this.o, this.f6763c, this.f6761a, this.f6764d, this.f6765e, this.f, this.g, this.h, this);
        }
    }

    public a(int r8, int r9, int r10, String r11, int r12, String r13, String r14, List<String> r15, Map<String, String> r16, boolean r17, List<Integer> r18, String r19, h r20, boolean r21, C0152a r22) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        Map<? extends String, ? extends String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.aiagent.plugin");
        List<Integer> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        this.f6759d = new HashMap();
        this.f6760e = new HashMap();
        this.f = new ArrayList();
        this.l = new ArrayList();
        this.f6756a = r12;
        this.f6757b = r13;
        this.f6758c = r14;
        this.j = r10;
        if (r2 == null) goto L5;
        this.f.addAll(r2);
    L5:
        if (r4 == null) goto L8;
        this.f6759d.putAll(r4);
    L8:
        if (r22.f6762b == null) goto L11;
        this.f6760e.putAll(r22.f6762b);
    L11:
        if (com.bytedance.common.wschannel.server.c.b() == false) goto L13;
        this.f6760e.put("x-support-qos2", "1");
    L13:
        this.g = r8;
        this.h = r9;
        this.i = r11;
        this.l = r3;
        this.k = r17;
        this.m = r19;
        this.n = r20;
        if (TextUtils.isEmpty(r19) == false) goto L16;
        this.k = false;
    L16:
        this.o = r21;
    }

    public String toString() {
        return "ChannelInfo{channelId = " + this.f6756a + ", deviceId = " + this.f6757b + ", installId = " + this.f6758c + ", fpid = " + this.g + ", aid = " + this.h + ", updateVersionCode = " + this.j + ", appKey = " + this.i + ", header = " + this.f6760e + ", extra = " + this.f6759d + ", urls = " + this.f + "}";
    }
}
