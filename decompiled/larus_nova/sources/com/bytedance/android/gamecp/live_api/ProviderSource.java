package com.bytedance.android.gamecp.live_api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/live_api/ProviderSource;", "", "PREVIEW", "DEFAULT", "gamecp-live-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ProviderSource extends Enum<ProviderSource> {
    public static final ProviderSource DEFAULT = null;
    public static final ProviderSource PREVIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProviderSource[] f57734a = null;

    static {
        ProviderSource r100 = new ProviderSource("PREVIEW", 0);
        PREVIEW = r100;
        ProviderSource r101 = new ProviderSource("DEFAULT", 1);
        DEFAULT = r101;
        f57734a = new ProviderSource[]{r100, r101};
    }

    public static ProviderSource valueOf(String r100) {
        return (ProviderSource) a.a(ProviderSource.class, r100);
    }

    public static ProviderSource[] values() {
        return (ProviderSource[]) f57734a.clone();
    }

    public ProviderSource(String r100, int r101) {
        super(r100, r101);
    }
}
