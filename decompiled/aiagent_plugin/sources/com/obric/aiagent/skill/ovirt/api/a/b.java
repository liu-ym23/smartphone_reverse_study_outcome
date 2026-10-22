package com.obric.aiagent.skill.ovirt.api.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FileAccessException.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f20946a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f20947b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f20948c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f20949d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f20950e = null;
    public static final b f = null;
    public static final b g = null;
    public static final b h = null;
    public static final b i = null;
    public static final b j = null;
    public static final b k = null;
    public static final b l = null;
    private static final /* synthetic */ b[] m = null;
    private static final /* synthetic */ d.d.a n = null;

    private static final /* synthetic */ b[] a() {
        return new b[]{f20946a, f20947b, f20948c, f20949d, f20950e, f, g, h, i, j, k, l};
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f20946a = new b("INVALID_PATH", 0);
        f20947b = new b("PATH_NOT_ALLOWED", 1);
        f20948c = new b("FILE_UNAVAILABLE", 2);
        f20949d = new b("EXPORT_FAILED", 3);
        f20950e = new b("DIRECTORY_NOT_FOUND", 4);
        f = new b("DIRECTORY_UNSAFE", 5);
        g = new b("DIRECTORY_CHANGED", 6);
        h = new b("TOO_MANY_ENTRIES", 7);
        i = new b("ENTRY_TOO_LARGE", 8);
        j = new b("PACKAGE_TOO_LARGE", 9);
        k = new b("ARCHIVE_TOO_LARGE", 10);
        l = new b("UNKNOWN", 11);
        b[] r0 = a();
        m = r0;
        n = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(m.clone(), b[].class, "com.obric.aiagent.plugin");
    }
}
