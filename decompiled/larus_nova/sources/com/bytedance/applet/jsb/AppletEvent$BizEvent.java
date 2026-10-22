package com.bytedance.applet.jsb;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/applet/jsb/AppletEvent$BizEvent;", "", "eventName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "NAVIGATION_STATUS_CHANGE", "AUDIO_PLAY_STATUS_CHANGE", "MUSIC_PLAY_STATUS_CHANGE", "MUSIC_ACTION_TRIGGERED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletEvent$BizEvent extends Enum<AppletEvent$BizEvent> {
    public static final AppletEvent$BizEvent AUDIO_PLAY_STATUS_CHANGE = null;
    public static final AppletEvent$BizEvent MUSIC_ACTION_TRIGGERED = null;
    public static final AppletEvent$BizEvent MUSIC_PLAY_STATUS_CHANGE = null;
    public static final AppletEvent$BizEvent NAVIGATION_STATUS_CHANGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppletEvent$BizEvent[] f192035a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f192036b = null;
    private final String eventName;

    public static EnumEntries<AppletEvent$BizEvent> getEntries() {
        return f192036b;
    }

    static {
        AppletEvent$BizEvent r100 = new AppletEvent$BizEvent("NAVIGATION_STATUS_CHANGE", 0, "navigationStatus");
        NAVIGATION_STATUS_CHANGE = r100;
        AppletEvent$BizEvent r101 = new AppletEvent$BizEvent("AUDIO_PLAY_STATUS_CHANGE", 1, "audioPlayStatusChanged");
        AUDIO_PLAY_STATUS_CHANGE = r101;
        AppletEvent$BizEvent r102 = new AppletEvent$BizEvent("MUSIC_PLAY_STATUS_CHANGE", 2, "musicPlayStatusChanged");
        MUSIC_PLAY_STATUS_CHANGE = r102;
        AppletEvent$BizEvent r103 = new AppletEvent$BizEvent("MUSIC_ACTION_TRIGGERED", 3, "musicActionTriggered");
        MUSIC_ACTION_TRIGGERED = r103;
        AppletEvent$BizEvent[] r104 = {r100, r101, r102, r103};
        f192035a = r104;
        f192036b = EnumEntriesKt.enumEntries(r104);
    }

    public static AppletEvent$BizEvent[] values() {
        return (AppletEvent$BizEvent[]) f192035a.clone();
    }

    public final String getEventName() {
        return this.eventName;
    }

    public static AppletEvent$BizEvent valueOf(String r100) {
        return (AppletEvent$BizEvent) r27.a.a(AppletEvent$BizEvent.class, r100);
    }

    public AppletEvent$BizEvent(String r100, int r101, String r102) {
        super(r100, r101);
        this.eventName = r102;
    }
}
