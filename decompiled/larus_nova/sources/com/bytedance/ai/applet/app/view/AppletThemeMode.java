package com.bytedance.ai.applet.app.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/applet/app/view/AppletThemeMode;", "", "<init>", "(Ljava/lang/String;I)V", "FOLLOW_SYSTEM", "LIGHT", "DARK", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletThemeMode extends Enum<AppletThemeMode> {
    public static final AppletThemeMode DARK = null;
    public static final AppletThemeMode FOLLOW_SYSTEM = null;
    public static final AppletThemeMode LIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppletThemeMode[] f34482a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34483b = null;

    public static EnumEntries<AppletThemeMode> getEntries() {
        return f34483b;
    }

    static {
        AppletThemeMode r100 = new AppletThemeMode("FOLLOW_SYSTEM", 0);
        FOLLOW_SYSTEM = r100;
        AppletThemeMode r101 = new AppletThemeMode("LIGHT", 1);
        LIGHT = r101;
        AppletThemeMode r102 = new AppletThemeMode("DARK", 2);
        DARK = r102;
        AppletThemeMode[] r103 = {r100, r101, r102};
        f34482a = r103;
        f34483b = EnumEntriesKt.enumEntries(r103);
    }

    public static AppletThemeMode[] values() {
        return (AppletThemeMode[]) f34482a.clone();
    }

    public static AppletThemeMode valueOf(String r100) {
        return (AppletThemeMode) r27.a.a(AppletThemeMode.class, r100);
    }

    public AppletThemeMode(String r100, int r101) {
        super(r100, r101);
    }
}
