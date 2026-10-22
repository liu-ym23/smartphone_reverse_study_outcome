package com.obric.matrix.a;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NETWORK_METHOD.java */
/* JADX INFO: loaded from: classes4.dex */
public final enum s extends Enum<s> implements WireEnum {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f33544a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f33545b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ProtoAdapter<s> f33546c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ s[] f33547e = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f33548d;

    public static s valueOf(String r2) {
        return (s) ZeusTransformUtils.preCheckCast(Enum.valueOf(s.class, r2), s.class, "com.obric.aiagent.plugin");
    }

    public static s[] values() {
        return (s[]) ZeusTransformUtils.preCheckCast(f33547e.clone(), s[].class, "com.obric.aiagent.plugin");
    }

    static {
        s r0 = new s("METHOD_GET", 0, 0);
        f33544a = r0;
        s r1 = new s("METHOD_POST", 1, 1);
        f33545b = r1;
        f33547e = new s[]{r0, r1};
        f33546c = new a();
    }

    private s(String r1, int r2, int r3) {
        super(r1, r2);
        this.f33548d = r3;
    }

    public static s a(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return f33545b;
    L10:
        return f33544a;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.f33548d;
    }
}
