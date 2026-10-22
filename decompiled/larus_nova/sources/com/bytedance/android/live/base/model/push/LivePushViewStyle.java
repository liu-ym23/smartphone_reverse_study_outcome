package com.bytedance.android.live.base.model.push;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/base/model/push/LivePushViewStyle;", "", "Normal", "Custom", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LivePushViewStyle extends Enum<LivePushViewStyle> {
    public static final LivePushViewStyle Custom = null;
    public static final LivePushViewStyle Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LivePushViewStyle[] f58924a = null;

    static {
        LivePushViewStyle r100 = new LivePushViewStyle("Normal", 0);
        Normal = r100;
        LivePushViewStyle r101 = new LivePushViewStyle("Custom", 1);
        Custom = r101;
        f58924a = new LivePushViewStyle[]{r100, r101};
    }

    public static LivePushViewStyle valueOf(String r100) {
        return (LivePushViewStyle) r27.a.a(LivePushViewStyle.class, r100);
    }

    public static LivePushViewStyle[] values() {
        return (LivePushViewStyle[]) f58924a.clone();
    }

    public LivePushViewStyle(String r100, int r101) {
        super(r100, r101);
    }
}
