package com.bytedance.android.livesdk.chatroom.model.interact;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/SubtitleEventType;", "", "UNKNOWN", "CONTENT", "HIDE", "CLEAR", "GUEST_SUBTITLE_OPTION", "SHOW_LYRICS", "STATE_START", "STATE_STOP", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SubtitleEventType extends Enum<SubtitleEventType> {
    public static final SubtitleEventType CLEAR = null;
    public static final SubtitleEventType CONTENT = null;
    public static final SubtitleEventType GUEST_SUBTITLE_OPTION = null;
    public static final SubtitleEventType HIDE = null;
    public static final SubtitleEventType SHOW_LYRICS = null;
    public static final SubtitleEventType STATE_START = null;
    public static final SubtitleEventType STATE_STOP = null;
    public static final SubtitleEventType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SubtitleEventType[] f106940a = null;

    static {
        SubtitleEventType r100 = new SubtitleEventType("UNKNOWN", 0);
        UNKNOWN = r100;
        SubtitleEventType r101 = new SubtitleEventType("CONTENT", 1);
        CONTENT = r101;
        SubtitleEventType r102 = new SubtitleEventType("HIDE", 2);
        HIDE = r102;
        SubtitleEventType r103 = new SubtitleEventType("CLEAR", 3);
        CLEAR = r103;
        SubtitleEventType r104 = new SubtitleEventType("GUEST_SUBTITLE_OPTION", 4);
        GUEST_SUBTITLE_OPTION = r104;
        SubtitleEventType r105 = new SubtitleEventType("SHOW_LYRICS", 5);
        SHOW_LYRICS = r105;
        SubtitleEventType r106 = new SubtitleEventType("STATE_START", 6);
        STATE_START = r106;
        SubtitleEventType r107 = new SubtitleEventType("STATE_STOP", 7);
        STATE_STOP = r107;
        f106940a = new SubtitleEventType[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public static SubtitleEventType valueOf(String r100) {
        return (SubtitleEventType) r27.a.a(SubtitleEventType.class, r100);
    }

    public static SubtitleEventType[] values() {
        return (SubtitleEventType[]) f106940a.clone();
    }

    public SubtitleEventType(String r100, int r101) {
        super(r100, r101);
    }
}
