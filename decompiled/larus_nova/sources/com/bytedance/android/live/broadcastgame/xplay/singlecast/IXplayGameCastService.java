package com.bytedance.android.live.broadcastgame.xplay.singlecast;

import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes45.dex */
public interface IXplayGameCastService {

    public interface IGameCastSession {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/singlecast/IXplayGameCastService$IGameCastSession$Event;", "", "CastStarted", "CastStopped", "CastMinimized", "CastResumed", "ResumeCastClicked", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum Event extends Enum<Event> {
            public static final Event CastMinimized = null;
            public static final Event CastResumed = null;
            public static final Event CastStarted = null;
            public static final Event CastStopped = null;
            public static final Event ResumeCastClicked = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Event[] f62427a = null;

            static {
                Event r100 = new Event("CastStarted", 0);
                CastStarted = r100;
                Event r101 = new Event("CastStopped", 1);
                CastStopped = r101;
                Event r102 = new Event("CastMinimized", 2);
                CastMinimized = r102;
                Event r103 = new Event("CastResumed", 3);
                CastResumed = r103;
                Event r104 = new Event("ResumeCastClicked", 4);
                ResumeCastClicked = r104;
                f62427a = new Event[]{r100, r101, r102, r103, r104};
            }

            public static Event valueOf(String r100) {
                return (Event) r27.a.a(Event.class, r100);
            }

            public static Event[] values() {
                return (Event[]) f62427a.clone();
            }

            public Event(String r100, int r101) {
                super(r100, r101);
            }
        }

        void stop();
    }

    XplayGameCastService.GameCastSessionImpl a(Pair r100);
}
