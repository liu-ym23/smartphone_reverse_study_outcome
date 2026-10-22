package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/TriggerKey;", "", "", "id", "J", "getId", "()J", "TopicDismiss", "ComponentShowDismiss", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TriggerKey extends Enum<TriggerKey> {
    public static final TriggerKey ComponentShowDismiss = null;
    public static final TriggerKey TopicDismiss = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TriggerKey[] f133426a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f133427id;

    static {
        TriggerKey r100 = new TriggerKey("TopicDismiss", 0, 1);
        TopicDismiss = r100;
        TriggerKey r101 = new TriggerKey("ComponentShowDismiss", 1, 2);
        ComponentShowDismiss = r101;
        f133426a = new TriggerKey[]{r100, r101};
    }

    public static TriggerKey valueOf(String r100) {
        return (TriggerKey) r27.a.a(TriggerKey.class, r100);
    }

    public static TriggerKey[] values() {
        return (TriggerKey[]) f133426a.clone();
    }

    public final long getId() {
        return this.f133427id;
    }

    public TriggerKey(String r100, int r101, long r102) {
        super(r100, r101);
        this.f133427id = r102;
    }
}
