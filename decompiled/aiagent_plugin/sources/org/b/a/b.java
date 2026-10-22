package org.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Level.java */
/* JADX INFO: loaded from: classes5.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f40266a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f40267b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f40268c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f40269d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f40270e = null;
    private static final /* synthetic */ b[] h = null;
    private final int f;
    private final String g;

    private static /* synthetic */ b[] b() {
        return new b[]{f40266a, f40267b, f40268c, f40269d, f40270e};
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(h.clone(), b[].class, "com.obric.aiagent.plugin");
    }

    static {
        f40266a = new b("ERROR", 0, 40, "ERROR");
        f40267b = new b("WARN", 1, 30, "WARN");
        f40268c = new b("INFO", 2, 20, "INFO");
        f40269d = new b("DEBUG", 3, 10, "DEBUG");
        f40270e = new b("TRACE", 4, 0, "TRACE");
        h = b();
    }

    private b(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.f = r3;
        this.g = r4;
    }

    public int a() {
        return this.f;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.g;
    }
}
