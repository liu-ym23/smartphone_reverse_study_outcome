package com.bytedance.android.livesdk.interactivity.api.publicscreen.pin;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/pin/PublicScreenPinType;", "", "ROOM_INTRO", "ROOM_NOTICE", "HOVER_MESSAGE", "MENTION_CHAT", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PublicScreenPinType extends Enum<PublicScreenPinType> {
    public static final PublicScreenPinType HOVER_MESSAGE = null;
    public static final PublicScreenPinType MENTION_CHAT = null;
    public static final PublicScreenPinType ROOM_INTRO = null;
    public static final PublicScreenPinType ROOM_NOTICE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PublicScreenPinType[] f133494a = null;

    static {
        PublicScreenPinType r100 = new PublicScreenPinType("ROOM_INTRO", 0);
        ROOM_INTRO = r100;
        PublicScreenPinType r101 = new PublicScreenPinType("ROOM_NOTICE", 1);
        ROOM_NOTICE = r101;
        PublicScreenPinType r102 = new PublicScreenPinType("HOVER_MESSAGE", 2);
        HOVER_MESSAGE = r102;
        PublicScreenPinType r103 = new PublicScreenPinType("MENTION_CHAT", 3);
        MENTION_CHAT = r103;
        f133494a = new PublicScreenPinType[]{r100, r101, r102, r103};
    }

    public static PublicScreenPinType valueOf(String r100) {
        return (PublicScreenPinType) a.a(PublicScreenPinType.class, r100);
    }

    public static PublicScreenPinType[] values() {
        return (PublicScreenPinType[]) f133494a.clone();
    }

    public PublicScreenPinType(String r100, int r101) {
        super(r100, r101);
    }
}
