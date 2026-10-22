package com.bytedance.android.annie.bridge.method.audio;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/audio/AsrState;", "", UserProfileEvent.POSITION_NONE, "STARTED", "STOPPING", "annie_release"}, k = 1, mv = {1, 4, 3})
public final enum AsrState extends Enum<AsrState> {
    public static final AsrState NONE = null;
    public static final AsrState STARTED = null;
    public static final AsrState STOPPING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsrState[] f38542a = null;

    public static AsrState valueOf(String r100) {
        return (AsrState) r27.a.a(AsrState.class, r100);
    }

    public static AsrState[] values() {
        return (AsrState[]) f38542a.clone();
    }

    static {
        AsrState r100 = new AsrState(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        AsrState r101 = new AsrState("STARTED", 1);
        STARTED = r101;
        AsrState r102 = new AsrState("STOPPING", 2);
        STOPPING = r102;
        f38542a = new AsrState[]{r100, r101, r102};
    }

    public AsrState(String r100, int r101) {
        super(r100, r101);
    }
}
