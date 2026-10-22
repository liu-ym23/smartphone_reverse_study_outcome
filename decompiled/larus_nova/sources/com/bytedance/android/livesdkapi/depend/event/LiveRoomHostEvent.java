package com.bytedance.android.livesdkapi.depend.event;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u0003H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/event/LiveRoomHostEvent;", "", "type", "", "extra", "(Ljava/lang/String;Ljava/lang/String;)V", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getType", "setType", "toString", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomHostEvent {
    private String extra;
    private String type;

    /* JADX WARN: Multi-variable type inference failed */
    public LiveRoomHostEvent() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public String toString() {
        return "{type: " + this.type + ", reason: " + this.extra + '}';
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getType() {
        return this.type;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }

    public LiveRoomHostEvent(String r100, String r101) {
        this.type = r100;
        this.extra = r101;
    }

    public /* synthetic */ LiveRoomHostEvent(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
