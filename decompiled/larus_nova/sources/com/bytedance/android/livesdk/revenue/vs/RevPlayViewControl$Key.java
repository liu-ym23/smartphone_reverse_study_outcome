package com.bytedance.android.livesdk.revenue.vs;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"com/bytedance/android/livesdk/revenue/vs/RevPlayViewControl$Key", "", "Lcom/bytedance/android/livesdk/revenue/vs/RevPlayViewControl$Key;", "GiftTray", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevPlayViewControl$Key extends Enum<RevPlayViewControl$Key> {
    public static final RevPlayViewControl$Key GiftTray = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevPlayViewControl$Key[] f157546a = null;

    static {
        RevPlayViewControl$Key r100 = new RevPlayViewControl$Key();
        GiftTray = r100;
        f157546a = new RevPlayViewControl$Key[]{r100};
    }

    public static RevPlayViewControl$Key valueOf(String r100) {
        return (RevPlayViewControl$Key) a.a(RevPlayViewControl$Key.class, r100);
    }

    public static RevPlayViewControl$Key[] values() {
        return (RevPlayViewControl$Key[]) f157546a.clone();
    }

    public RevPlayViewControl$Key() {
        super("GiftTray", 0);
    }
}
