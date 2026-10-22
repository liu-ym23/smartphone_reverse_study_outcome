package com.bytedance.android.livesdk.interactivity.api.publicscreen.plugin;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/plugin/FeaturePluginType;", "", "ChatRoomAuth", "AudioMessagePlay", "ChatLike", "FloatMessageExit", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FeaturePluginType extends Enum<FeaturePluginType> {
    public static final FeaturePluginType AudioMessagePlay = null;
    public static final FeaturePluginType ChatLike = null;
    public static final FeaturePluginType ChatRoomAuth = null;
    public static final FeaturePluginType FloatMessageExit = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeaturePluginType[] f133495a = null;

    static {
        FeaturePluginType r100 = new FeaturePluginType("ChatRoomAuth", 0);
        ChatRoomAuth = r100;
        FeaturePluginType r101 = new FeaturePluginType("AudioMessagePlay", 1);
        AudioMessagePlay = r101;
        FeaturePluginType r102 = new FeaturePluginType("ChatLike", 2);
        ChatLike = r102;
        FeaturePluginType r103 = new FeaturePluginType("FloatMessageExit", 3);
        FloatMessageExit = r103;
        f133495a = new FeaturePluginType[]{r100, r101, r102, r103};
    }

    public static FeaturePluginType valueOf(String r100) {
        return (FeaturePluginType) a.a(FeaturePluginType.class, r100);
    }

    public static FeaturePluginType[] values() {
        return (FeaturePluginType[]) f133495a.clone();
    }

    public FeaturePluginType(String r100, int r101) {
        super(r100, r101);
    }
}
