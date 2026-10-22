package com.bytedance.android.openlive.realtime.source;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/openlive/realtime/source/UserRealtimeSignalSources;", "", "()V", "PREVIEW", "Lcom/bytedance/android/openlive/realtime/source/IUserRealtimeSignalSource;", "ROOM", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserRealtimeSignalSources {
    public static final UserRealtimeSignalSources INSTANCE = null;
    public static final IUserRealtimeSignalSource PREVIEW = null;
    public static final IUserRealtimeSignalSource ROOM = null;

    private UserRealtimeSignalSources() {
    }

    static {
        INSTANCE = new UserRealtimeSignalSources();
        IUserRealtimeSignalSource.Companion r100 = IUserRealtimeSignalSource.Companion;
        ROOM = r100.from("room");
        PREVIEW = r100.from("preview");
    }
}
