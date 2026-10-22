package com.bytedance.android.livesdk.chatroom.gamestickerv2.componentv2;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/gamestickerv2/componentv2/ComponentState;", "", UserProfileEvent.POSITION_NONE, "LOADING", "SUCCESS", "FAIL", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ComponentState extends Enum<ComponentState> {
    public static final ComponentState FAIL = null;
    public static final ComponentState LOADING = null;
    public static final ComponentState NONE = null;
    public static final ComponentState SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComponentState[] f106305a = null;

    static {
        ComponentState r100 = new ComponentState(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        ComponentState r101 = new ComponentState("LOADING", 1);
        LOADING = r101;
        ComponentState r102 = new ComponentState("SUCCESS", 2);
        SUCCESS = r102;
        ComponentState r103 = new ComponentState("FAIL", 3);
        FAIL = r103;
        f106305a = new ComponentState[]{r100, r101, r102, r103};
    }

    public static ComponentState valueOf(String r100) {
        return (ComponentState) r27.a.a(ComponentState.class, r100);
    }

    public static ComponentState[] values() {
        return (ComponentState[]) f106305a.clone();
    }

    public ComponentState(String r100, int r101) {
        super(r100, r101);
    }
}
