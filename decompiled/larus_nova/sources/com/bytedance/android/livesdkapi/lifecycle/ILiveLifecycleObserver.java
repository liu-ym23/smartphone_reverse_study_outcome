package com.bytedance.android.livesdkapi.lifecycle;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\nJ2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/lifecycle/ILiveLifecycleObserver;", "", "onLifecycleEvent", "", "event", "Lcom/bytedance/android/livesdkapi/lifecycle/ILiveLifecycleObserver$Event;", "roomId", "", "params", "", "Event", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveLifecycleObserver {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B3\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\u0005¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0004\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/lifecycle/ILiveLifecycleObserver$Event;", "", "description", "", "paramDescription", "", "Lkotlin/Triple;", "Ljava/lang/Class;", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/List;)V", "EnterLiveRoomSuccess", "InteractionFragmentDestroy", "ShowLiveEnd", "EndSession", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Event extends Enum<Event> {
        private static final /* synthetic */ Event[] $VALUES = null;
        public static final Event EndSession = null;
        public static final Event EnterLiveRoomSuccess = null;
        public static final Event InteractionFragmentDestroy = null;
        public static final Event ShowLiveEnd = null;
        private final String description;
        private final List<Triple<String, String, Class<?>>> paramDescription;

        static {
            Event r100 = new Event("EnterLiveRoomSuccess", 0, "进入直播间成功", CollectionsKt.listOf(new Triple("roomOwnerId", "直播间所有者id", String.class)));
            EnterLiveRoomSuccess = r100;
            Event r101 = new Event("InteractionFragmentDestroy", 1, "直播页面上的控件页面销毁。在直播广场上下滑动直播间也会回调。横竖屏切换也会回调", CollectionsKt.emptyList());
            InteractionFragmentDestroy = r101;
            Event r102 = new Event("ShowLiveEnd", 2, "展示直播结束页面", CollectionsKt.emptyList());
            ShowLiveEnd = r102;
            Event r103 = new Event("EndSession", 3, "直播间关闭", CollectionsKt.listOf(new Triple("reason", "退出直播的原因,比如关播", String.class)));
            EndSession = r103;
            $VALUES = new Event[]{r100, r101, r102, r103};
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

    void onLifecycleEvent(Event r100, String r101, Map<String, ? extends Object> r102);
}
