package com.bytedance.ai.applet.components.input;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/applet/components/input/AppletChatActionBarCapability;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN_CAMERA", "MUSIC_GENERATION", "IMAGE_GENERATION", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletChatActionBarCapability extends Enum<AppletChatActionBarCapability> {
    public static final AppletChatActionBarCapability IMAGE_GENERATION = null;
    public static final AppletChatActionBarCapability MUSIC_GENERATION = null;
    public static final AppletChatActionBarCapability OPEN_CAMERA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppletChatActionBarCapability[] f34530a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34531b = null;

    public static EnumEntries<AppletChatActionBarCapability> getEntries() {
        return f34531b;
    }

    static {
        AppletChatActionBarCapability r100 = new AppletChatActionBarCapability("OPEN_CAMERA", 0);
        OPEN_CAMERA = r100;
        AppletChatActionBarCapability r101 = new AppletChatActionBarCapability("MUSIC_GENERATION", 1);
        MUSIC_GENERATION = r101;
        AppletChatActionBarCapability r102 = new AppletChatActionBarCapability("IMAGE_GENERATION", 2);
        IMAGE_GENERATION = r102;
        AppletChatActionBarCapability[] r103 = {r100, r101, r102};
        f34530a = r103;
        f34531b = EnumEntriesKt.enumEntries(r103);
    }

    public static AppletChatActionBarCapability[] values() {
        return (AppletChatActionBarCapability[]) f34530a.clone();
    }

    public static AppletChatActionBarCapability valueOf(String r100) {
        return (AppletChatActionBarCapability) a.a(AppletChatActionBarCapability.class, r100);
    }

    public AppletChatActionBarCapability(String r100, int r101) {
        super(r100, r101);
    }
}
