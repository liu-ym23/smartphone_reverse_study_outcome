package com.bytedance.android.livesdk.audiencerecord.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/audiencerecord/api/BacktrackState;", "", "IDLE", "STARTED", "BACKTRACK_DOING", "PREVIEWING", "TIMEOUT", "DONE", "ERROR", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BacktrackState extends Enum<BacktrackState> {
    public static final BacktrackState BACKTRACK_DOING = null;
    public static final BacktrackState DONE = null;
    public static final BacktrackState ERROR = null;
    public static final BacktrackState IDLE = null;
    public static final BacktrackState PREVIEWING = null;
    public static final BacktrackState STARTED = null;
    public static final BacktrackState TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BacktrackState[] f104041a = null;

    static {
        BacktrackState r100 = new BacktrackState("IDLE", 0);
        IDLE = r100;
        BacktrackState r101 = new BacktrackState("STARTED", 1);
        STARTED = r101;
        BacktrackState r102 = new BacktrackState("BACKTRACK_DOING", 2);
        BACKTRACK_DOING = r102;
        BacktrackState r103 = new BacktrackState("PREVIEWING", 3);
        PREVIEWING = r103;
        BacktrackState r104 = new BacktrackState("TIMEOUT", 4);
        TIMEOUT = r104;
        BacktrackState r105 = new BacktrackState("DONE", 5);
        DONE = r105;
        BacktrackState r106 = new BacktrackState("ERROR", 6);
        ERROR = r106;
        f104041a = new BacktrackState[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static BacktrackState valueOf(String r100) {
        return (BacktrackState) a.a(BacktrackState.class, r100);
    }

    public static BacktrackState[] values() {
        return (BacktrackState[]) f104041a.clone();
    }

    public BacktrackState(String r100, int r101) {
        super(r100, r101);
    }
}
