package com.bytedance.android.live.broadcast.api.stable;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/stable/AnchorStrategy;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "StableMode", "livebroadcast-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnchorStrategy extends Enum<AnchorStrategy> {
    public static final AnchorStrategy StableMode = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnchorStrategy[] f59074a = null;
    private final String key;

    static {
        AnchorStrategy r100 = new AnchorStrategy();
        StableMode = r100;
        f59074a = new AnchorStrategy[]{r100};
    }

    public static AnchorStrategy valueOf(String r100) {
        return (AnchorStrategy) r27.a.a(AnchorStrategy.class, r100);
    }

    public static AnchorStrategy[] values() {
        return (AnchorStrategy[]) f59074a.clone();
    }

    public AnchorStrategy() {
        super("StableMode", 0);
        this.key = "android_anchor_stable_mode";
    }

    public final String getKey() {
        return this.key;
    }
}
