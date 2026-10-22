package com.bytedance.android.livesdk.revenue.experience;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"com/bytedance/android/livesdk/revenue/experience/IRevCardLifecycle$State", "", "Lcom/bytedance/android/livesdk/revenue/experience/IRevCardLifecycle$State;", "Initialized", "Created", "Stored", "Started", "Showed", "EnterAnimStarted", "ExitAnimStarted", "Hidden", "Destroyed", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IRevCardLifecycle$State extends Enum<IRevCardLifecycle$State> {
    public static final IRevCardLifecycle$State Created = null;
    public static final IRevCardLifecycle$State Destroyed = null;
    public static final IRevCardLifecycle$State EnterAnimStarted = null;
    public static final IRevCardLifecycle$State ExitAnimStarted = null;
    public static final IRevCardLifecycle$State Hidden = null;
    public static final IRevCardLifecycle$State Initialized = null;
    public static final IRevCardLifecycle$State Showed = null;
    public static final IRevCardLifecycle$State Started = null;
    public static final IRevCardLifecycle$State Stored = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IRevCardLifecycle$State[] f157148a = null;

    static {
        IRevCardLifecycle$State r100 = new IRevCardLifecycle$State("Initialized", 0);
        Initialized = r100;
        IRevCardLifecycle$State r101 = new IRevCardLifecycle$State("Created", 1);
        Created = r101;
        IRevCardLifecycle$State r102 = new IRevCardLifecycle$State("Stored", 2);
        Stored = r102;
        IRevCardLifecycle$State r103 = new IRevCardLifecycle$State("Started", 3);
        Started = r103;
        IRevCardLifecycle$State r104 = new IRevCardLifecycle$State("Showed", 4);
        Showed = r104;
        IRevCardLifecycle$State r105 = new IRevCardLifecycle$State("EnterAnimStarted", 5);
        EnterAnimStarted = r105;
        IRevCardLifecycle$State r106 = new IRevCardLifecycle$State("ExitAnimStarted", 6);
        ExitAnimStarted = r106;
        IRevCardLifecycle$State r107 = new IRevCardLifecycle$State("Hidden", 7);
        Hidden = r107;
        IRevCardLifecycle$State r108 = new IRevCardLifecycle$State("Destroyed", 8);
        Destroyed = r108;
        f157148a = new IRevCardLifecycle$State[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public static IRevCardLifecycle$State valueOf(String r100) {
        return (IRevCardLifecycle$State) r27.a.a(IRevCardLifecycle$State.class, r100);
    }

    public static IRevCardLifecycle$State[] values() {
        return (IRevCardLifecycle$State[]) f157148a.clone();
    }

    public IRevCardLifecycle$State(String r100, int r101) {
        super(r100, r101);
    }
}
