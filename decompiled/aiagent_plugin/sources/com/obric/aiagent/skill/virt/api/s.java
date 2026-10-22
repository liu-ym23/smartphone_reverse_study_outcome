package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ShellApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum s extends Enum<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f21602a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f21603b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ s[] f21604c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f21605d = null;

    private static final /* synthetic */ s[] a() {
        return new s[]{f21602a, f21603b};
    }

    private s(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f21602a = new s("STDOUT", 0);
        f21603b = new s("STDERR", 1);
        s[] r0 = a();
        f21604c = r0;
        f21605d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static s valueOf(String r2) {
        return (s) ZeusTransformUtils.preCheckCast(Enum.valueOf(s.class, r2), s.class, "com.obric.aiagent.plugin");
    }

    public static s[] values() {
        return (s[]) ZeusTransformUtils.preCheckCast(f21604c.clone(), s[].class, "com.obric.aiagent.plugin");
    }
}
