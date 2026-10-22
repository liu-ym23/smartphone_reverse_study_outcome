package com.bytedance.ai.applet.app;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/applet/app/AppletShowMode;", "", "<init>", "(Ljava/lang/String;I)V", "FULL_SCREEN", "EIGHT_SCREEN", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletShowMode extends Enum<AppletShowMode> {
    public static final AppletShowMode EIGHT_SCREEN = null;
    public static final AppletShowMode FULL_SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppletShowMode[] f34136a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34137b = null;

    public static EnumEntries<AppletShowMode> getEntries() {
        return f34137b;
    }

    static {
        AppletShowMode r100 = new AppletShowMode("FULL_SCREEN", 0);
        FULL_SCREEN = r100;
        AppletShowMode r101 = new AppletShowMode("EIGHT_SCREEN", 1);
        EIGHT_SCREEN = r101;
        AppletShowMode[] r102 = {r100, r101};
        f34136a = r102;
        f34137b = EnumEntriesKt.enumEntries(r102);
    }

    public static AppletShowMode[] values() {
        return (AppletShowMode[]) f34136a.clone();
    }

    public static AppletShowMode valueOf(String r100) {
        return (AppletShowMode) r27.a.a(AppletShowMode.class, r100);
    }

    public AppletShowMode(String r100, int r101) {
        super(r100, r101);
    }
}
