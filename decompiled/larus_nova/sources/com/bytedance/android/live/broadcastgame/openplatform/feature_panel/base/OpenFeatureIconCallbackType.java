package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/base/OpenFeatureIconCallbackType;", "", "START_BUTTON", "DEBUG_BUTTON", "ITEM_CONTENT", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OpenFeatureIconCallbackType extends Enum<OpenFeatureIconCallbackType> {
    public static final OpenFeatureIconCallbackType DEBUG_BUTTON = null;
    public static final OpenFeatureIconCallbackType ITEM_CONTENT = null;
    public static final OpenFeatureIconCallbackType START_BUTTON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenFeatureIconCallbackType[] f61408a = null;

    static {
        OpenFeatureIconCallbackType r100 = new OpenFeatureIconCallbackType("START_BUTTON", 0);
        START_BUTTON = r100;
        OpenFeatureIconCallbackType r101 = new OpenFeatureIconCallbackType("DEBUG_BUTTON", 1);
        DEBUG_BUTTON = r101;
        OpenFeatureIconCallbackType r102 = new OpenFeatureIconCallbackType("ITEM_CONTENT", 2);
        ITEM_CONTENT = r102;
        f61408a = new OpenFeatureIconCallbackType[]{r100, r101, r102};
    }

    public static OpenFeatureIconCallbackType valueOf(String r100) {
        return (OpenFeatureIconCallbackType) a.a(OpenFeatureIconCallbackType.class, r100);
    }

    public static OpenFeatureIconCallbackType[] values() {
        return (OpenFeatureIconCallbackType[]) f61408a.clone();
    }

    public OpenFeatureIconCallbackType(String r100, int r101) {
        super(r100, r101);
    }
}
