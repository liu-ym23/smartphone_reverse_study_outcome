package com.bytedance.applog;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;

/* JADX INFO: loaded from: classes3.dex */
public final enum EventType extends Enum<EventType> {
    public static final EventType FORWARD_V3 = null;
    public static final EventType IMPRESSION = null;
    public static final EventType Launch = null;
    public static final EventType LogData = null;
    public static final EventType Terminate = null;
    public static final EventType UNKNOWN = null;
    public static final EventType V1 = null;
    public static final EventType V3 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventType[] f192391a = null;
    final int value;

    static {
        EventType r100 = new EventType("V3", 0, 0);
        V3 = r100;
        EventType r101 = new EventType(OuterPayLoginWrapper.LOGIN_STYLE_V1, 1, 1);
        V1 = r101;
        EventType r102 = new EventType("LogData", 2, 2);
        LogData = r102;
        EventType r103 = new EventType("Launch", 3, 3);
        Launch = r103;
        EventType r104 = new EventType("Terminate", 4, 4);
        Terminate = r104;
        EventType r105 = new EventType("IMPRESSION", 5, 5);
        IMPRESSION = r105;
        EventType r110 = new EventType("FORWARD_V3", 6, 6);
        FORWARD_V3 = r110;
        EventType r111 = new EventType("UNKNOWN", 7, 99);
        UNKNOWN = r111;
        f192391a = new EventType[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static EventType[] values() {
        return (EventType[]) f192391a.clone();
    }

    public int value() {
        return this.value;
    }

    public static EventType valueOf(String r100) {
        return (EventType) r27.a.a(EventType.class, r100);
    }

    public EventType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
