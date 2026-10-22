package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: DnsResult.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f8497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f8498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f8499c;

    /* JADX INFO: compiled from: DnsResult.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8500a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f8501b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f8502c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f8503d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f8504e = null;
        public static final a f = null;
        public static final a g = null;
        private static final /* synthetic */ a[] h = null;

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(h.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("UNKNOWN", 0);
            f8500a = r0;
            a r1 = new a("HTTPDNS_CACHE", 1);
            f8501b = r1;
            a r3 = new a("HTTPDNS_STALE_CACHE", 2);
            f8502c = r3;
            a r5 = new a("HTTPDNS_REQUEST", 3);
            f8503d = r5;
            a r7 = new a("LOCALDNS_REQUEST", 4);
            f8504e = r7;
            a r9 = new a("LOCALDNS_CACHE", 5);
            f = r9;
            a r11 = new a("HARDCODE_IPS", 6);
            g = r11;
            h = new a[]{r0, r1, r3, r5, r7, r9, r11};
        }
    }

    public b() {
        this.f8497a = new ArrayList();
        this.f8498b = new ArrayList();
        this.f8499c = a.f8501b;
    }
}
