package com.bytedance.android.livesdkapi.depend.room;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/room/EnterRoomRedirect;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "REDIRECT_FROM_COLLABORATE_ENTER_ROOM", "REDIRECT_FROM_COLLABORATE_MESSAGE", "REDIRECT_FROM_OFFICIAL_CHANNEL", "REDIRECT_FROM_NEW_CONNECTION", "liveconstants-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EnterRoomRedirect extends Enum<EnterRoomRedirect> {
    private static final /* synthetic */ EnterRoomRedirect[] $VALUES = null;
    public static final EnterRoomRedirect REDIRECT_FROM_COLLABORATE_ENTER_ROOM = null;
    public static final EnterRoomRedirect REDIRECT_FROM_COLLABORATE_MESSAGE = null;
    public static final EnterRoomRedirect REDIRECT_FROM_NEW_CONNECTION = null;
    public static final EnterRoomRedirect REDIRECT_FROM_OFFICIAL_CHANNEL = null;
    private final int value;

    static {
        EnterRoomRedirect r100 = new EnterRoomRedirect("REDIRECT_FROM_COLLABORATE_ENTER_ROOM", 0, 1);
        REDIRECT_FROM_COLLABORATE_ENTER_ROOM = r100;
        EnterRoomRedirect r101 = new EnterRoomRedirect("REDIRECT_FROM_COLLABORATE_MESSAGE", 1, 2);
        REDIRECT_FROM_COLLABORATE_MESSAGE = r101;
        EnterRoomRedirect r102 = new EnterRoomRedirect("REDIRECT_FROM_OFFICIAL_CHANNEL", 2, 3);
        REDIRECT_FROM_OFFICIAL_CHANNEL = r102;
        EnterRoomRedirect r103 = new EnterRoomRedirect("REDIRECT_FROM_NEW_CONNECTION", 3, 4);
        REDIRECT_FROM_NEW_CONNECTION = r103;
        $VALUES = new EnterRoomRedirect[]{r100, r101, r102, r103};
    }

    public static EnterRoomRedirect valueOf(String r100) {
        return (EnterRoomRedirect) a.a(EnterRoomRedirect.class, r100);
    }

    public static EnterRoomRedirect[] values() {
        return (EnterRoomRedirect[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private EnterRoomRedirect(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
