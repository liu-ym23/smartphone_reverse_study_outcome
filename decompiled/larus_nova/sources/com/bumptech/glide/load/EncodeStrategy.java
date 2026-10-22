package com.bumptech.glide.load;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum EncodeStrategy extends Enum<EncodeStrategy> {
    private static final /* synthetic */ EncodeStrategy[] $VALUES = null;
    public static final EncodeStrategy NONE = null;
    public static final EncodeStrategy SOURCE = null;
    public static final EncodeStrategy TRANSFORMED = null;

    static {
        EncodeStrategy r100 = new EncodeStrategy("SOURCE", 0);
        SOURCE = r100;
        EncodeStrategy r101 = new EncodeStrategy("TRANSFORMED", 1);
        TRANSFORMED = r101;
        EncodeStrategy r102 = new EncodeStrategy(UserProfileEvent.POSITION_NONE, 2);
        NONE = r102;
        $VALUES = new EncodeStrategy[]{r100, r101, r102};
    }

    public static EncodeStrategy[] values() {
        return (EncodeStrategy[]) $VALUES.clone();
    }

    public static EncodeStrategy valueOf(String r100) {
        return (EncodeStrategy) a.a(EncodeStrategy.class, r100);
    }

    private EncodeStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
