package com.bytedance.android.livesdk.interactivity.publicscreen.repository;

import com.bytedance.android.live.base.model.message.t;
import java.util.List;
import kotlin.Metadata;
import tlc.d;

/* JADX INFO: loaded from: classes9.dex */
public interface IPSMessageRepoManager {

    public interface Listener {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/IPSMessageRepoManager$Listener$Event;", "", "PAUSE", "RESUME", "UPDATE", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum Event extends Enum<Event> {
            public static final Event PAUSE = null;
            public static final Event RESUME = null;
            public static final Event UPDATE = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Event[] f139355a = null;

            static {
                Event r100 = new Event("PAUSE", 0);
                PAUSE = r100;
                Event r101 = new Event("RESUME", 1);
                RESUME = r101;
                Event r102 = new Event("UPDATE", 2);
                UPDATE = r102;
                f139355a = new Event[]{r100, r101, r102};
            }

            public static Event valueOf(String r100) {
                return (Event) r27.a.a(Event.class, r100);
            }

            public static Event[] values() {
                return (Event[]) f139355a.clone();
            }

            public Event(String r100, int r101) {
                super(r100, r101);
            }
        }

        void a(List<? extends d> r100, boolean r101);

        void b(List<? extends d> r100, boolean r101);

        void c(List<? extends d> r100);

        void d(Event r100);

        void e(List r100);

        void f(List<? extends d> r100, boolean r101);

        void onFirstMessage(List<? extends d> r100, boolean r101);

        void onMessage(d r100);
    }

    void bind(Listener r100);

    void dynamicAddMessageType(String r100);

    boolean insertBackendTopMessage(List<? extends d> r100);

    void insertLocalMessage(t r100);

    void unbind(Listener r100);
}
