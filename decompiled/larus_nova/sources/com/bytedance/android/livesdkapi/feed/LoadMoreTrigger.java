package com.bytedance.android.livesdkapi.feed;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/LoadMoreTrigger;", "", "source", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getSource", "()Ljava/lang/String;", "RECOMMEND_LOAD_RETRY_TRIGGER", "DATA_NOTIFY_TRIGGER", "START_FIRST_ROOM_TRIGGER", "DO_RETRY_LOAD_TRIGGER", "PAGE_CHANGE_TRIGGER", "MERGE_DRAWER_AUTO_TRIGGER", "OVER_SCROLL_LOAD_TRIGGER", "PAGE_END_STRATEGY_TRIGGER", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LoadMoreTrigger extends Enum<LoadMoreTrigger> {
    private static final /* synthetic */ LoadMoreTrigger[] $VALUES = null;
    public static final LoadMoreTrigger DATA_NOTIFY_TRIGGER = null;
    public static final LoadMoreTrigger DO_RETRY_LOAD_TRIGGER = null;
    public static final LoadMoreTrigger MERGE_DRAWER_AUTO_TRIGGER = null;
    public static final LoadMoreTrigger OVER_SCROLL_LOAD_TRIGGER = null;
    public static final LoadMoreTrigger PAGE_CHANGE_TRIGGER = null;
    public static final LoadMoreTrigger PAGE_END_STRATEGY_TRIGGER = null;
    public static final LoadMoreTrigger RECOMMEND_LOAD_RETRY_TRIGGER = null;
    public static final LoadMoreTrigger START_FIRST_ROOM_TRIGGER = null;
    private final String source;

    public static LoadMoreTrigger valueOf(String r100) {
        return (LoadMoreTrigger) a.a(LoadMoreTrigger.class, r100);
    }

    public static LoadMoreTrigger[] values() {
        return (LoadMoreTrigger[]) $VALUES.clone();
    }

    static {
        LoadMoreTrigger r100 = new LoadMoreTrigger("RECOMMEND_LOAD_RETRY_TRIGGER", 0, "recommend_load_retry");
        RECOMMEND_LOAD_RETRY_TRIGGER = r100;
        LoadMoreTrigger r101 = new LoadMoreTrigger("DATA_NOTIFY_TRIGGER", 1, "data_notify");
        DATA_NOTIFY_TRIGGER = r101;
        LoadMoreTrigger r102 = new LoadMoreTrigger("START_FIRST_ROOM_TRIGGER", 2, "first_room_start");
        START_FIRST_ROOM_TRIGGER = r102;
        LoadMoreTrigger r103 = new LoadMoreTrigger("DO_RETRY_LOAD_TRIGGER", 3, "do_retry_load");
        DO_RETRY_LOAD_TRIGGER = r103;
        LoadMoreTrigger r104 = new LoadMoreTrigger("PAGE_CHANGE_TRIGGER", 4, "page_change");
        PAGE_CHANGE_TRIGGER = r104;
        LoadMoreTrigger r105 = new LoadMoreTrigger("MERGE_DRAWER_AUTO_TRIGGER", 5, "merge_drawer");
        MERGE_DRAWER_AUTO_TRIGGER = r105;
        LoadMoreTrigger r106 = new LoadMoreTrigger("OVER_SCROLL_LOAD_TRIGGER", 6, "over_scroll");
        OVER_SCROLL_LOAD_TRIGGER = r106;
        LoadMoreTrigger r107 = new LoadMoreTrigger("PAGE_END_STRATEGY_TRIGGER", 7, "strategy_trigger");
        PAGE_END_STRATEGY_TRIGGER = r107;
        $VALUES = new LoadMoreTrigger[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final String getSource() {
        return this.source;
    }

    private LoadMoreTrigger(String r100, int r101, String r102) {
        super(r100, r101);
        this.source = r102;
    }
}
