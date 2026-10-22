package com.bytedance.common.wschannel.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ChannelType.java */
/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6769a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f6770b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ a[] f6771d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f6772c;

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f6771d.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    static {
        a r0 = new a("CHANNEL_SELF", 0, 1);
        f6769a = r0;
        a r1 = new a("CHANNEL_OK", 1, 2);
        f6770b = r1;
        f6771d = new a[]{r0, r1};
    }

    private a(String r1, int r2, int r3) {
        super(r1, r2);
        this.f6772c = r3;
    }

    public static a a(int r1) {
        if (r1 != 1) goto L7;
        return f6769a;
    L7:
        return f6770b;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ChannelType{Type=" + this.f6772c + '}';
    }
}
