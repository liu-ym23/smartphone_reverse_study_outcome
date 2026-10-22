package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class s extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f121170a = null;

    static {
        f121170a = new s();
    }

    public s() {
        if (tb1.c.f545229a == false) goto L5;
        int r100 = 120;
    L6:
        super("audience_ping_interval", Integer.valueOf(r100), "观众ping间隔");
        return;
    L5:
        r100 = 60;
        goto L6
    }
}
