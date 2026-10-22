package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/base/OpenFeatureIconCallbackFrom;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "RECENT_USE", "TAB_LIST", "SEARCH", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OpenFeatureIconCallbackFrom extends Enum<OpenFeatureIconCallbackFrom> {
    public static final OpenFeatureIconCallbackFrom RECENT_USE = null;
    public static final OpenFeatureIconCallbackFrom SEARCH = null;
    public static final OpenFeatureIconCallbackFrom TAB_LIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenFeatureIconCallbackFrom[] f61407a = null;
    private final String value;

    static {
        OpenFeatureIconCallbackFrom r100 = new OpenFeatureIconCallbackFrom("RECENT_USE", 0, "use_recently");
        RECENT_USE = r100;
        OpenFeatureIconCallbackFrom r101 = new OpenFeatureIconCallbackFrom("TAB_LIST", 1, "tab");
        TAB_LIST = r101;
        OpenFeatureIconCallbackFrom r102 = new OpenFeatureIconCallbackFrom("SEARCH", 2, "search");
        SEARCH = r102;
        f61407a = new OpenFeatureIconCallbackFrom[]{r100, r101, r102};
    }

    public static OpenFeatureIconCallbackFrom valueOf(String r100) {
        return (OpenFeatureIconCallbackFrom) a.a(OpenFeatureIconCallbackFrom.class, r100);
    }

    public static OpenFeatureIconCallbackFrom[] values() {
        return (OpenFeatureIconCallbackFrom[]) f61407a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public OpenFeatureIconCallbackFrom(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
