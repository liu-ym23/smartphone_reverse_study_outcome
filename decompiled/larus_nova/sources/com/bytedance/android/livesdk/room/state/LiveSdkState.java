package com.bytedance.android.livesdk.room.state;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;
import ts2.b;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/room/state/LiveSdkState;", "", "Lts2/b;", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "SDK_START_LOAD", "SDK_START_LOAD_FINISH", "SDK_UN_INSTALL", "room-flow_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveSdkState extends Enum<LiveSdkState> implements b {
    public static final LiveSdkState SDK_START_LOAD = null;
    public static final LiveSdkState SDK_START_LOAD_FINISH = null;
    public static final LiveSdkState SDK_UN_INSTALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveSdkState[] f157818a = null;
    private final String des;

    static {
        LiveSdkState r100 = new LiveSdkState("SDK_START_LOAD", 0, null, 1, null);
        SDK_START_LOAD = r100;
        LiveSdkState r101 = new LiveSdkState("SDK_START_LOAD_FINISH", 1, null, 1, null);
        SDK_START_LOAD_FINISH = r101;
        LiveSdkState r102 = new LiveSdkState("SDK_UN_INSTALL", 2, null, 1, null);
        SDK_UN_INSTALL = r102;
        f157818a = new LiveSdkState[]{r100, r101, r102};
    }

    public LiveSdkState() {
        throw null;
    }

    public static LiveSdkState valueOf(String r100) {
        return (LiveSdkState) a.a(LiveSdkState.class, r100);
    }

    public static LiveSdkState[] values() {
        return (LiveSdkState[]) f157818a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public LiveSdkState(String r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = "";
    L5:
        super(r100, r101);
        this.des = r102;
    }
}
