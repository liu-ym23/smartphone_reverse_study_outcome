package com.byted.cast.sdk;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
public final enum RTCAudioDevice extends Enum<RTCAudioDevice> {
    private static final /* synthetic */ RTCAudioDevice[] $VALUES = null;
    public static final RTCAudioDevice BLUETOOTH = null;
    public static final RTCAudioDevice EARPIECE = null;
    public static final RTCAudioDevice NONE = null;
    public static final RTCAudioDevice SPEAKER = null;
    public static final RTCAudioDevice WIRED_HEADSET = null;
    private final int value;

    static {
        RTCAudioDevice r100 = new RTCAudioDevice("SPEAKER", 0, 0);
        SPEAKER = r100;
        RTCAudioDevice r101 = new RTCAudioDevice("EARPIECE", 1, 1);
        EARPIECE = r101;
        RTCAudioDevice r102 = new RTCAudioDevice("WIRED_HEADSET", 2, 2);
        WIRED_HEADSET = r102;
        RTCAudioDevice r103 = new RTCAudioDevice("BLUETOOTH", 3, 3);
        BLUETOOTH = r103;
        RTCAudioDevice r104 = new RTCAudioDevice(UserProfileEvent.POSITION_NONE, 4, -1);
        NONE = r104;
        $VALUES = new RTCAudioDevice[]{r100, r101, r102, r103, r104};
    }

    public static RTCAudioDevice[] values() {
        return (RTCAudioDevice[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static RTCAudioDevice valueOf(String r100) {
        return (RTCAudioDevice) a.a(RTCAudioDevice.class, r100);
    }

    private RTCAudioDevice(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
