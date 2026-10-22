package org.c.a.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NodeId.java */
/* JADX INFO: loaded from: classes5.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40416a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f40417b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f40418c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f40419d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ a[] f40420e = null;

    private a(String r1, int r2) {
        super(r1, r2);
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f40420e.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    static {
        a r0 = new a("scalar", 0);
        f40416a = r0;
        a r1 = new a("sequence", 1);
        f40417b = r1;
        a r3 = new a("mapping", 2);
        f40418c = r3;
        a r5 = new a("anchor", 3);
        f40419d = r5;
        f40420e = new a[]{r0, r1, r3, r5};
    }
}
