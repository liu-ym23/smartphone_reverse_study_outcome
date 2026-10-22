package com.bytedance.applog.monitor.v3;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StageEventType.java */
/* JADX INFO: loaded from: classes.dex */
public final enum i extends Enum<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f5806a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f5807b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f5808c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f5809d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i f5810e = null;
    public static final i f = null;
    private static final /* synthetic */ i[] h = null;
    private final int g;

    public static i valueOf(String r2) {
        return (i) ZeusTransformUtils.preCheckCast(Enum.valueOf(i.class, r2), i.class, "com.obric.aiagent.plugin");
    }

    public static i[] values() {
        return (i[]) ZeusTransformUtils.preCheckCast(h.clone(), i[].class, "com.obric.aiagent.plugin");
    }

    static {
        i r0 = new i("V3_EVENT", 0, 0);
        f5806a = r0;
        i r1 = new i("V1_EVENT", 1, 1);
        f5807b = r1;
        i r3 = new i("LOG_DATA", 2, 2);
        f5808c = r3;
        i r5 = new i("LAUNCH", 3, 3);
        f5809d = r5;
        i r7 = new i("TERMINATE", 4, 4);
        f5810e = r7;
        i r9 = new i("ITEM_IMPRESSION", 5, 5);
        f = r9;
        h = new i[]{r0, r1, r3, r5, r7, r9};
    }

    private i(String r1, int r2, int r3) {
        super(r1, r2);
        this.g = r3;
    }

    public int a() {
        return this.g;
    }

    public static i a(String r5) {
        i[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        i r3 = r0[r2];
        if (r3.name().equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        return f5806a;
    }

    public static i a(int r1) {
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 == 4) goto L13;
        return f5806a;
    L13:
        return f5810e;
    L15:
        return f5809d;
    L17:
        return f5808c;
    L19:
        return f5807b;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + "-" + this.g;
    }
}
