package com.bytedance.android.live.openplatform.api.model.event;

import ko0.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
public final class ToolbarEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventType f83967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f83968b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/event/ToolbarEvent$EventType;", "", "ShowToolbarAnimation", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EventType extends Enum<EventType> {
        public static final EventType ShowToolbarAnimation = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventType[] f83969a = null;

        static {
            EventType r100 = new EventType();
            ShowToolbarAnimation = r100;
            f83969a = new EventType[]{r100};
        }

        public static EventType valueOf(String r100) {
            return (EventType) a.a(EventType.class, r100);
        }

        public static EventType[] values() {
            return (EventType[]) f83969a.clone();
        }

        public EventType() {
            super("ShowToolbarAnimation", 0);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ToolbarEvent) == false) goto L10;
        ToolbarEvent r101 = (ToolbarEvent) r100;
        if (Intrinsics.areEqual(this.f83967a, r101.f83967a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f83968b, r101.f83968b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        EventType r100 = this.f83967a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Object r104 = this.f83968b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ToolbarEvent(eventType=" + this.f83967a + ", data=" + this.f83968b + ")";
    }

    public ToolbarEvent(EventType r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        this.f83967a = r100;
        this.f83968b = r101;
    }
}
