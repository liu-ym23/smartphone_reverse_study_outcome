package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ne extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ne f120825a = null;

    static {
        f120825a = new ne();
    }

    public ne() {
        Boolean r100 = Boolean.FALSE;
        super("live_asynclayoutinflater_fix_leakmode", "fix AsyncLayoutInflater leak", r100, r100);
    }
}
