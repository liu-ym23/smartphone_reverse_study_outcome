package com.bytedance.android.live.broadcast.api.interacttools;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"com/bytedance/android/live/broadcast/api/interacttools/InteractTool$InteractionPluginType", "", "Lcom/bytedance/android/live/broadcast/api/interacttools/InteractTool$InteractionPluginType;", "Unknown", "MiniApp", "Effect", "Lynx", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InteractTool$InteractionPluginType extends Enum<InteractTool$InteractionPluginType> {
    public static final InteractTool$InteractionPluginType Effect = null;
    public static final InteractTool$InteractionPluginType Lynx = null;
    public static final InteractTool$InteractionPluginType MiniApp = null;
    public static final InteractTool$InteractionPluginType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InteractTool$InteractionPluginType[] f59007a = null;

    static {
        InteractTool$InteractionPluginType r100 = new InteractTool$InteractionPluginType("Unknown", 0);
        Unknown = r100;
        InteractTool$InteractionPluginType r101 = new InteractTool$InteractionPluginType("MiniApp", 1);
        MiniApp = r101;
        InteractTool$InteractionPluginType r102 = new InteractTool$InteractionPluginType("Effect", 2);
        Effect = r102;
        InteractTool$InteractionPluginType r103 = new InteractTool$InteractionPluginType("Lynx", 3);
        Lynx = r103;
        f59007a = new InteractTool$InteractionPluginType[]{r100, r101, r102, r103};
    }

    public static InteractTool$InteractionPluginType valueOf(String r100) {
        return (InteractTool$InteractionPluginType) a.a(InteractTool$InteractionPluginType.class, r100);
    }

    public static InteractTool$InteractionPluginType[] values() {
        return (InteractTool$InteractionPluginType[]) f59007a.clone();
    }

    public InteractTool$InteractionPluginType(String r100, int r101) {
        super(r100, r101);
    }
}
