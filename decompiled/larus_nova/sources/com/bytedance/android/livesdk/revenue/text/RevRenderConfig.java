package com.bytedance.android.livesdk.revenue.text;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/text/RevRenderConfig;", "", "SyncDecodeContext", "ASyncDecodeContext", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevRenderConfig extends Enum<RevRenderConfig> {
    public static final RevRenderConfig ASyncDecodeContext = null;
    public static final RevRenderConfig SyncDecodeContext = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevRenderConfig[] f157517a = null;

    static {
        RevRenderConfig r100 = new RevRenderConfig("SyncDecodeContext", 0);
        SyncDecodeContext = r100;
        RevRenderConfig r101 = new RevRenderConfig("ASyncDecodeContext", 1);
        ASyncDecodeContext = r101;
        f157517a = new RevRenderConfig[]{r100, r101};
    }

    public static RevRenderConfig valueOf(String r100) {
        return (RevRenderConfig) a.a(RevRenderConfig.class, r100);
    }

    public static RevRenderConfig[] values() {
        return (RevRenderConfig[]) f157517a.clone();
    }

    public RevRenderConfig(String r100, int r101) {
        super(r100, r101);
    }
}
