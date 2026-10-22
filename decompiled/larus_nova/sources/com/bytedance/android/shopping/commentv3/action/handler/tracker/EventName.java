package com.bytedance.android.shopping.commentv3.action.handler.tracker;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/action/handler/tracker/EventName;", "", "", "event", "Ljava/lang/String;", "getEvent", "()Ljava/lang/String;", "SHOW", "CLICK", "STATE", "ERROR", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EventName extends Enum<EventName> {
    public static final EventName CLICK = null;
    public static final EventName ERROR = null;
    public static final EventName SHOW = null;
    public static final EventName STATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventName[] f172595a = null;
    private final String event;

    static {
        EventName r100 = new EventName("SHOW", 0, "ec_comment_page_entrance_show");
        SHOW = r100;
        EventName r101 = new EventName("CLICK", 1, "ec_comment_page_entrance_click");
        CLICK = r101;
        EventName r102 = new EventName("STATE", 2, "ec_comment_page_entrance_state");
        STATE = r102;
        EventName r103 = new EventName("ERROR", 3, "ec_comment_list_error");
        ERROR = r103;
        f172595a = new EventName[]{r100, r101, r102, r103};
    }

    public static EventName valueOf(String r100) {
        return (EventName) a.a(EventName.class, r100);
    }

    public static EventName[] values() {
        return (EventName[]) f172595a.clone();
    }

    public final String getEvent() {
        return this.event;
    }

    public EventName(String r100, int r101, String r102) {
        super(r100, r101);
        this.event = r102;
    }
}
