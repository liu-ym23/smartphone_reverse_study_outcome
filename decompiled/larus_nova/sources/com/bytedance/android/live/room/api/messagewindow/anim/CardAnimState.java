package com.bytedance.android.live.room.api.messagewindow.anim;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
public final class CardAnimState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final State f98919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CardAnimType f98920b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/anim/CardAnimState$State;", "", GXAnimation.STATE_START, GXAnimation.STATE_END, "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State END = null;
        public static final State START = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f98921a = null;

        static {
            State r100 = new State(GXAnimation.STATE_START, 0);
            START = r100;
            State r101 = new State(GXAnimation.STATE_END, 1);
            END = r101;
            f98921a = new State[]{r100, r101};
        }

        public static State valueOf(String r100) {
            return (State) a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f98921a.clone();
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public CardAnimState(State r100, CardAnimType r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "animType");
        this.f98919a = r100;
        this.f98920b = r101;
    }
}
