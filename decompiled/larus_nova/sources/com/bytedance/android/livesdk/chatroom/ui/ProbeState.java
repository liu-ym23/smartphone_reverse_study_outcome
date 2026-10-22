package com.bytedance.android.livesdk.chatroom.ui;

import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/ProbeState;", "", UserProfileEvent.POSITION_NONE, GXAnimation.STATE_START, "STOP", "ERROR", "SUCCESS", "RELEASE", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ProbeState extends Enum<ProbeState> {
    public static final ProbeState ERROR = null;
    public static final ProbeState NONE = null;
    public static final ProbeState RELEASE = null;
    public static final ProbeState START = null;
    public static final ProbeState STOP = null;
    public static final ProbeState SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProbeState[] f112446a = null;

    static {
        ProbeState r100 = new ProbeState(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        ProbeState r101 = new ProbeState(GXAnimation.STATE_START, 1);
        START = r101;
        ProbeState r102 = new ProbeState("STOP", 2);
        STOP = r102;
        ProbeState r103 = new ProbeState("ERROR", 3);
        ERROR = r103;
        ProbeState r104 = new ProbeState("SUCCESS", 4);
        SUCCESS = r104;
        ProbeState r105 = new ProbeState("RELEASE", 5);
        RELEASE = r105;
        f112446a = new ProbeState[]{r100, r101, r102, r103, r104, r105};
    }

    public static ProbeState valueOf(String r100) {
        return (ProbeState) r27.a.a(ProbeState.class, r100);
    }

    public static ProbeState[] values() {
        return (ProbeState[]) f112446a.clone();
    }

    public ProbeState(String r100, int r101) {
        super(r100, r101);
    }
}
