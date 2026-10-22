package com.fasterxml.jackson.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StreamWriteCapability.java */
/* JADX INFO: loaded from: classes.dex */
public final enum s extends Enum<s> implements com.fasterxml.jackson.a.h.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f12163a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f12164b = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ s[] f12165e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f12166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f12167d;

    public static s valueOf(String r2) {
        return (s) ZeusTransformUtils.preCheckCast(Enum.valueOf(s.class, r2), s.class, "com.obric.aiagent.plugin");
    }

    public static s[] values() {
        return (s[]) ZeusTransformUtils.preCheckCast(f12165e.clone(), s[].class, "com.obric.aiagent.plugin");
    }

    static {
        s r0 = new s("CAN_WRITE_BINARY_NATIVELY", 0, false);
        f12163a = r0;
        s r1 = new s("CAN_WRITE_FORMATTED_NUMBERS", 1, false);
        f12164b = r1;
        f12165e = new s[]{r0, r1};
    }

    private s(String r1, int r2, boolean r3) {
        super(r1, r2);
        this.f12166c = r3;
        this.f12167d = 1 << ordinal();
    }

    @Override // com.fasterxml.jackson.a.h.h
    public boolean b() {
        return this.f12166c;
    }

    @Override // com.fasterxml.jackson.a.h.h
    public int c() {
        return this.f12167d;
    }
}
