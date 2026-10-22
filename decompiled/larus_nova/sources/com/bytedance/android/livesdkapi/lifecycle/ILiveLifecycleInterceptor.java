package com.bytedance.android.livesdkapi.lifecycle;

import com.byted.cast.common.TeaEventTrack;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u000fJH\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/lifecycle/ILiveLifecycleInterceptor;", "", "interceptLifecycleEvent", "", "event", "Lcom/bytedance/android/livesdkapi/lifecycle/ILiveLifecycleInterceptor$Event;", "roomId", "", "params", "", TeaEventTrack.ACTION_DRAMA_NEXT, "Ljava/lang/Runnable;", "error", "Lcom/bytedance/android/livesdkapi/lifecycle/ILiveLifecycleConsumer;", "", "Event", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveLifecycleInterceptor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B3\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\u0005¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0004\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/lifecycle/ILiveLifecycleInterceptor$Event;", "", "description", "", "paramDescription", "", "Lkotlin/Triple;", "Ljava/lang/Class;", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/List;)V", "PreEnterRoom", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Event extends Enum<Event> {
        private static final /* synthetic */ Event[] $VALUES = null;
        public static final Event PreEnterRoom = null;
        private final String description;
        private final List<Triple<String, String, Class<?>>> paramDescription;

        static {
            Event r100 = new Event("PreEnterRoom", 0, "即将进入直播间", CollectionsKt.emptyList());
            PreEnterRoom = r100;
            $VALUES = new Event[]{r100};
        }

        public static Event valueOf(String r100) {
            return (Event) a.a(Event.class, r100);
        }

        public static Event[] values() {
            return (Event[]) $VALUES.clone();
        }

        private Event(String r100, int r101, String r102, List r103) {
            super(r100, r101);
            this.description = r102;
            this.paramDescription = r103;
        }
    }

    void interceptLifecycleEvent(Event r100, String r101, Map<String, ? extends Object> r102, Runnable r103, ILiveLifecycleConsumer<Throwable> r104);
}
