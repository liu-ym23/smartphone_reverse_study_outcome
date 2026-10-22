package com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/newcontainer/business/boot/room/PreloadType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "PRE_REQUEST_ROOM_PRELOAD", "PRE_REQUEST_ROOM_BACKEND", "PRE_ENTER_ROOM", "livesdkshell_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PreloadType extends Enum<PreloadType> {
    public static final PreloadType PRE_ENTER_ROOM = null;
    public static final PreloadType PRE_REQUEST_ROOM_BACKEND = null;
    public static final PreloadType PRE_REQUEST_ROOM_PRELOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreloadType[] f107040a = null;
    private final String type;

    static {
        PreloadType r100 = new PreloadType("PRE_REQUEST_ROOM_PRELOAD", 0, "PRE_REQUEST_ROOM_PRELOAD");
        PRE_REQUEST_ROOM_PRELOAD = r100;
        PreloadType r101 = new PreloadType("PRE_REQUEST_ROOM_BACKEND", 1, "PRE_REQUEST_ROOM_BACKEND");
        PRE_REQUEST_ROOM_BACKEND = r101;
        PreloadType r102 = new PreloadType("PRE_ENTER_ROOM", 2, "PRE_ENTER_ROOM");
        PRE_ENTER_ROOM = r102;
        f107040a = new PreloadType[]{r100, r101, r102};
    }

    public static PreloadType valueOf(String r100) {
        return (PreloadType) a.a(PreloadType.class, r100);
    }

    public static PreloadType[] values() {
        return (PreloadType[]) f107040a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public PreloadType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
