package com.bytedance.bdturing.setting;

import com.bytedance.ttnet.TTNetInit;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ConfigProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f6601a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f6602b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f6603c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f6604d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f6605e = null;
    private static final /* synthetic */ e[] f = null;
    private final String g;

    public static e valueOf(String r2) {
        return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
    }

    public static e[] values() {
        return (e[]) ZeusTransformUtils.preCheckCast(f.clone(), e[].class, "com.obric.aiagent.plugin");
    }

    private e(String r1, int r2, String r3) {
        super(r1, r2);
        this.g = r3;
    }

    public final String a() {
        return this.g;
    }

    static {
        e r1 = new e("CN", 0, "cn");
        f6601a = r1;
        e r2 = new e("SINGAPOER", 1, "sg");
        f6602b = r2;
        e r3 = new e("USA_EAST", 2, "va");
        f6603c = r3;
        e r4 = new e("INDIA", 3, "in");
        f6604d = r4;
        e r5 = new e("BOE", 4, TTNetInit.DOMAIN_BOE_KEY);
        f6605e = r5;
        f = new e[]{r1, r2, r3, r4, r5};
    }
}
