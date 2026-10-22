package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/base/SceneType;", "", "ANCHOR_PORTRAIT", "AUDIENCE_LANDSCAPE", "AUDIENCE_PORTRAIT", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SceneType extends Enum<SceneType> {
    public static final SceneType ANCHOR_PORTRAIT = null;
    public static final SceneType AUDIENCE_LANDSCAPE = null;
    public static final SceneType AUDIENCE_PORTRAIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SceneType[] f112889a = null;

    static {
        SceneType r100 = new SceneType("ANCHOR_PORTRAIT", 0);
        ANCHOR_PORTRAIT = r100;
        SceneType r101 = new SceneType("AUDIENCE_LANDSCAPE", 1);
        AUDIENCE_LANDSCAPE = r101;
        SceneType r102 = new SceneType("AUDIENCE_PORTRAIT", 2);
        AUDIENCE_PORTRAIT = r102;
        f112889a = new SceneType[]{r100, r101, r102};
    }

    public static SceneType valueOf(String r100) {
        return (SceneType) r27.a.a(SceneType.class, r100);
    }

    public static SceneType[] values() {
        return (SceneType[]) f112889a.clone();
    }

    public SceneType(String r100, int r101) {
        super(r100, r101);
    }
}
