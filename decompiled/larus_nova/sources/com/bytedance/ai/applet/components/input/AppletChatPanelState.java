package com.bytedance.ai.applet.components.input;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/applet/components/input/AppletChatPanelState;", "", "<init>", "(Ljava/lang/String;I)V", "COLLAPSED", "PREVIEW", "EXPANDED", "INVISIBLE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletChatPanelState extends Enum<AppletChatPanelState> {
    public static final AppletChatPanelState COLLAPSED = null;
    public static final AppletChatPanelState EXPANDED = null;
    public static final AppletChatPanelState INVISIBLE = null;
    public static final AppletChatPanelState PREVIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppletChatPanelState[] f34542a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34543b = null;

    public static EnumEntries<AppletChatPanelState> getEntries() {
        return f34543b;
    }

    static {
        AppletChatPanelState r100 = new AppletChatPanelState("COLLAPSED", 0);
        COLLAPSED = r100;
        AppletChatPanelState r101 = new AppletChatPanelState("PREVIEW", 1);
        PREVIEW = r101;
        AppletChatPanelState r102 = new AppletChatPanelState("EXPANDED", 2);
        EXPANDED = r102;
        AppletChatPanelState r103 = new AppletChatPanelState("INVISIBLE", 3);
        INVISIBLE = r103;
        AppletChatPanelState[] r104 = {r100, r101, r102, r103};
        f34542a = r104;
        f34543b = EnumEntriesKt.enumEntries(r104);
    }

    public static AppletChatPanelState[] values() {
        return (AppletChatPanelState[]) f34542a.clone();
    }

    public static AppletChatPanelState valueOf(String r100) {
        return (AppletChatPanelState) a.a(AppletChatPanelState.class, r100);
    }

    public AppletChatPanelState(String r100, int r101) {
        super(r100, r101);
    }
}
