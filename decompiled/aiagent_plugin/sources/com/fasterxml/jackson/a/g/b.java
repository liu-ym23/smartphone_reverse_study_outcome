package com.fasterxml.jackson.a.g;

import com.fasterxml.jackson.a.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: WritableTypeId.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f12067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class<?> f12068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f12069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f12070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f12071e;
    public n f;
    public boolean g;

    /* JADX INFO: compiled from: WritableTypeId.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12072a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f12073b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f12074c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f12075d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f12076e = null;
        private static final /* synthetic */ a[] f = null;

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("WRAPPER_ARRAY", 0);
            f12072a = r0;
            a r1 = new a("WRAPPER_OBJECT", 1);
            f12073b = r1;
            a r3 = new a("METADATA_PROPERTY", 2);
            f12074c = r3;
            a r5 = new a("PAYLOAD_PROPERTY", 3);
            f12075d = r5;
            a r7 = new a("PARENT_PROPERTY", 4);
            f12076e = r7;
            f = new a[]{r0, r1, r3, r5, r7};
        }

        public boolean a() {
            if (this != f12074c) goto L5;
        L8:
            return true;
        L5:
            if (this == f12075d) goto L8;
            return false;
        }
    }

    public b() {
    }

    public b(Object r2, n r3) {
        this(r2, r3, null);
    }

    public b(Object r1, n r2, Object r3) {
        this.f12067a = r1;
        this.f12069c = r3;
        this.f = r2;
    }
}
