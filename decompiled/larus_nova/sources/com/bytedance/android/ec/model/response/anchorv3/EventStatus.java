package com.bytedance.android.ec.model.response.anchorv3;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/EventStatus;", "", "", "value", "I", "getValue", "()I", "IN_PROGRESS", "DONE", "FINISHED", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum EventStatus extends Enum<EventStatus> {
    public static final EventStatus DONE = null;
    public static final EventStatus FINISHED = null;
    public static final EventStatus IN_PROGRESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventStatus[] f47931a = null;
    private final int value;

    static {
        EventStatus r100 = new EventStatus("IN_PROGRESS", 0, 1);
        IN_PROGRESS = r100;
        EventStatus r101 = new EventStatus("DONE", 1, 2);
        DONE = r101;
        EventStatus r102 = new EventStatus("FINISHED", 2, 3);
        FINISHED = r102;
        f47931a = new EventStatus[]{r100, r101, r102};
    }

    public static EventStatus valueOf(String r100) {
        return (EventStatus) r27.a.a(EventStatus.class, r100);
    }

    public static EventStatus[] values() {
        return (EventStatus[]) f47931a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public EventStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
