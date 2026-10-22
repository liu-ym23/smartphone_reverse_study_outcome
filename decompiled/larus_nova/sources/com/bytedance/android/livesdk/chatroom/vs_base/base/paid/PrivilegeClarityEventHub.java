package com.bytedance.android.livesdk.chatroom.vs_base.base.paid;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
public final class PrivilegeClarityEventHub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NextLiveData<State> f117900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NextLiveData<String> f117901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NextLiveData<String> f117902c;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/paid/PrivilegeClarityEventHub$State;", "", "", "isActive", "showPlayerCard", UserProfileEvent.POSITION_NONE, "CLARITY_GUIDE", "CLARITY_TEMP_WATCH", "CLARITY_TEMP_WATCH_END", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State CLARITY_GUIDE = null;
        public static final State CLARITY_TEMP_WATCH = null;
        public static final State CLARITY_TEMP_WATCH_END = null;
        public static final State NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f117903a = null;

        static {
            State r100 = new State(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            State r101 = new State("CLARITY_GUIDE", 1);
            CLARITY_GUIDE = r101;
            State r102 = new State("CLARITY_TEMP_WATCH", 2);
            CLARITY_TEMP_WATCH = r102;
            State r103 = new State("CLARITY_TEMP_WATCH_END", 3);
            CLARITY_TEMP_WATCH_END = r103;
            f117903a = new State[]{r100, r101, r102, r103};
        }

        public static State valueOf(String r100) {
            return (State) a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f117903a.clone();
        }

        public final boolean isActive() {
            if (this == NONE) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean showPlayerCard() {
            if (this != CLARITY_TEMP_WATCH) goto L5;
            return true;
        L5:
            return false;
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public PrivilegeClarityEventHub() {
        NextLiveData<State> r100 = new NextLiveData();
        r100.setValue(State.NONE);
        Unit r101 = Unit.INSTANCE;
        this.f117900a = r100;
        this.f117901b = new NextLiveData();
        this.f117902c = new NextLiveData();
    }
}
