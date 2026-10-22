package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"com/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/IPSHighlightCompLifecycle$State", "", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/IPSHighlightCompLifecycle$State;", "state", "", "isAtLeast", "Initialized", "Created", "Started", "Showed", "Hidden", "Destroyed", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IPSHighlightCompLifecycle$State extends Enum<IPSHighlightCompLifecycle$State> {
    public static final IPSHighlightCompLifecycle$State Created = null;
    public static final IPSHighlightCompLifecycle$State Destroyed = null;
    public static final IPSHighlightCompLifecycle$State Hidden = null;
    public static final IPSHighlightCompLifecycle$State Initialized = null;
    public static final IPSHighlightCompLifecycle$State Showed = null;
    public static final IPSHighlightCompLifecycle$State Started = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IPSHighlightCompLifecycle$State[] f133408a = null;

    static {
        IPSHighlightCompLifecycle$State r100 = new IPSHighlightCompLifecycle$State("Initialized", 0);
        Initialized = r100;
        IPSHighlightCompLifecycle$State r101 = new IPSHighlightCompLifecycle$State("Created", 1);
        Created = r101;
        IPSHighlightCompLifecycle$State r102 = new IPSHighlightCompLifecycle$State("Started", 2);
        Started = r102;
        IPSHighlightCompLifecycle$State r103 = new IPSHighlightCompLifecycle$State("Showed", 3);
        Showed = r103;
        IPSHighlightCompLifecycle$State r104 = new IPSHighlightCompLifecycle$State("Hidden", 4);
        Hidden = r104;
        IPSHighlightCompLifecycle$State r105 = new IPSHighlightCompLifecycle$State("Destroyed", 5);
        Destroyed = r105;
        f133408a = new IPSHighlightCompLifecycle$State[]{r100, r101, r102, r103, r104, r105};
    }

    public static IPSHighlightCompLifecycle$State valueOf(String r100) {
        return (IPSHighlightCompLifecycle$State) r27.a.a(IPSHighlightCompLifecycle$State.class, r100);
    }

    public static IPSHighlightCompLifecycle$State[] values() {
        return (IPSHighlightCompLifecycle$State[]) f133408a.clone();
    }

    public final boolean isAtLeast(IPSHighlightCompLifecycle$State r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (compareTo(r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public IPSHighlightCompLifecycle$State(String r100, int r101) {
        super(r100, r101);
    }
}
