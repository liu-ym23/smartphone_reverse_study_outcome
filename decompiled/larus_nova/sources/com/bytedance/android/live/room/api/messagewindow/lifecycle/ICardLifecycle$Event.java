package com.bytedance.android.live.room.api.messagewindow.lifecycle;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0006\u0010\u0004\u001a\u00020\u0003j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"com/bytedance/android/live/room/api/messagewindow/lifecycle/ICardLifecycle$Event", "", "Lcom/bytedance/android/live/room/api/messagewindow/lifecycle/ICardLifecycle$Event;", "Lcom/bytedance/android/live/room/api/messagewindow/lifecycle/ICardLifecycle$State;", "getTargetState", "OnCreate", "OnStore", "OnShow", "OnStart", "OnHide", "OnDestroy", "OnAny", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ICardLifecycle$Event extends Enum<ICardLifecycle$Event> {
    public static final ICardLifecycle$Event OnAny = null;
    public static final ICardLifecycle$Event OnCreate = null;
    public static final ICardLifecycle$Event OnDestroy = null;
    public static final ICardLifecycle$Event OnHide = null;
    public static final ICardLifecycle$Event OnShow = null;
    public static final ICardLifecycle$Event OnStart = null;
    public static final ICardLifecycle$Event OnStore = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ICardLifecycle$Event[] f98989a = null;

    static {
        ICardLifecycle$Event r100 = new ICardLifecycle$Event("OnCreate", 0);
        OnCreate = r100;
        ICardLifecycle$Event r101 = new ICardLifecycle$Event("OnStore", 1);
        OnStore = r101;
        ICardLifecycle$Event r102 = new ICardLifecycle$Event("OnShow", 2);
        OnShow = r102;
        ICardLifecycle$Event r103 = new ICardLifecycle$Event("OnStart", 3);
        OnStart = r103;
        ICardLifecycle$Event r104 = new ICardLifecycle$Event("OnHide", 4);
        OnHide = r104;
        ICardLifecycle$Event r105 = new ICardLifecycle$Event("OnDestroy", 5);
        OnDestroy = r105;
        ICardLifecycle$Event r106 = new ICardLifecycle$Event("OnAny", 6);
        OnAny = r106;
        f98989a = new ICardLifecycle$Event[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static ICardLifecycle$Event valueOf(String r100) {
        return (ICardLifecycle$Event) a.a(ICardLifecycle$Event.class, r100);
    }

    public static ICardLifecycle$Event[] values() {
        return (ICardLifecycle$Event[]) f98989a.clone();
    }

    public final ICardLifecycle$State getTargetState() {
        switch(c71.a.f22634a[ordinal()]) {
            case 1: goto L12;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L5;
        };
    L5:
        throw new IllegalStateException(this + " has no target state");
    L13:
        return ICardLifecycle$State.Destroyed;
    L14:
        return ICardLifecycle$State.Hidden;
    L15:
        return ICardLifecycle$State.Showed;
    L16:
        return ICardLifecycle$State.Started;
    L17:
        return ICardLifecycle$State.Stored;
    L12:
        return ICardLifecycle$State.Created;
    }

    public ICardLifecycle$Event(String r100, int r101) {
        super(r100, r101);
    }
}
