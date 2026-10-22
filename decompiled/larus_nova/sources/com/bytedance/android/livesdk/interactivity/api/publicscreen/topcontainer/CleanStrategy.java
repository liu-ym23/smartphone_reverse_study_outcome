package com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/topcontainer/CleanStrategy;", "", UserProfileEvent.POSITION_NONE, "REMOVE_VIEWS", "REMOVE_WRAP_VIEW", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CleanStrategy extends Enum<CleanStrategy> {
    public static final CleanStrategy NONE = null;
    public static final CleanStrategy REMOVE_VIEWS = null;
    public static final CleanStrategy REMOVE_WRAP_VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CleanStrategy[] f133546a = null;

    static {
        CleanStrategy r100 = new CleanStrategy(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        CleanStrategy r101 = new CleanStrategy("REMOVE_VIEWS", 1);
        REMOVE_VIEWS = r101;
        CleanStrategy r102 = new CleanStrategy("REMOVE_WRAP_VIEW", 2);
        REMOVE_WRAP_VIEW = r102;
        f133546a = new CleanStrategy[]{r100, r101, r102};
    }

    public static CleanStrategy valueOf(String r100) {
        return (CleanStrategy) a.a(CleanStrategy.class, r100);
    }

    public static CleanStrategy[] values() {
        return (CleanStrategy[]) f133546a.clone();
    }

    public CleanStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
