package com.bytedance.android.live.room.api.messagewindow.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0004j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"com/bytedance/android/live/room/api/messagewindow/lifecycle/ICardLifecycle$State", "", "Lcom/bytedance/android/live/room/api/messagewindow/lifecycle/ICardLifecycle$State;", "state", "", "isAtLeast", "isAtMost", "isShowOrHide", "Initialized", "Created", "Stored", "Started", "Showed", "Hidden", "Destroyed", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ICardLifecycle$State extends Enum<ICardLifecycle$State> {
    public static final ICardLifecycle$State Created = null;
    public static final ICardLifecycle$State Destroyed = null;
    public static final ICardLifecycle$State Hidden = null;
    public static final ICardLifecycle$State Initialized = null;
    public static final ICardLifecycle$State Showed = null;
    public static final ICardLifecycle$State Started = null;
    public static final ICardLifecycle$State Stored = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ICardLifecycle$State[] f98990a = null;

    static {
        ICardLifecycle$State r100 = new ICardLifecycle$State("Initialized", 0);
        Initialized = r100;
        ICardLifecycle$State r101 = new ICardLifecycle$State("Created", 1);
        Created = r101;
        ICardLifecycle$State r102 = new ICardLifecycle$State("Stored", 2);
        Stored = r102;
        ICardLifecycle$State r103 = new ICardLifecycle$State("Started", 3);
        Started = r103;
        ICardLifecycle$State r104 = new ICardLifecycle$State("Showed", 4);
        Showed = r104;
        ICardLifecycle$State r105 = new ICardLifecycle$State("Hidden", 5);
        Hidden = r105;
        ICardLifecycle$State r106 = new ICardLifecycle$State("Destroyed", 6);
        Destroyed = r106;
        f98990a = new ICardLifecycle$State[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static ICardLifecycle$State valueOf(String r100) {
        return (ICardLifecycle$State) a.a(ICardLifecycle$State.class, r100);
    }

    public static ICardLifecycle$State[] values() {
        return (ICardLifecycle$State[]) f98990a.clone();
    }

    public final boolean isShowOrHide() {
        ICardLifecycle$State r100 = Hidden;
        if (compareTo(Showed) >= 0) goto L6;
    L8:
        return false;
    L6:
        if (compareTo(r100) > 0) goto L8;
        return true;
    }

    public final boolean isAtLeast(ICardLifecycle$State r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (compareTo(r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isAtMost(ICardLifecycle$State r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (compareTo(r100) > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public ICardLifecycle$State(String r100, int r101) {
        super(r100, r101);
    }
}
