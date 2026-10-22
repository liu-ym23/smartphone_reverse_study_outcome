package com.bytedance.android.live.profit.player.profilepreview;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;
import uu0.b;

/* JADX INFO: loaded from: classes47.dex */
public final class ProfilePreviewEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventType f88352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f88353b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profit/player/profilepreview/ProfilePreviewEvent$EventType;", "", "EnterStart", "EnterEnd", "ExitStart", "ExitEnd", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum EventType extends Enum<EventType> {
        public static final EventType EnterEnd = null;
        public static final EventType EnterStart = null;
        public static final EventType ExitEnd = null;
        public static final EventType ExitStart = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventType[] f88354a = null;

        static {
            EventType r100 = new EventType("EnterStart", 0);
            EnterStart = r100;
            EventType r101 = new EventType("EnterEnd", 1);
            EnterEnd = r101;
            EventType r102 = new EventType("ExitStart", 2);
            ExitStart = r102;
            EventType r103 = new EventType("ExitEnd", 3);
            ExitEnd = r103;
            f88354a = new EventType[]{r100, r101, r102, r103};
        }

        public static EventType valueOf(String r100) {
            return (EventType) a.a(EventType.class, r100);
        }

        public static EventType[] values() {
            return (EventType[]) f88354a.clone();
        }

        public EventType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ProfilePreviewEvent) == false) goto L10;
        ProfilePreviewEvent r101 = (ProfilePreviewEvent) r100;
        if (Intrinsics.areEqual(this.f88352a, r101.f88352a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f88353b, r101.f88353b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        EventType r100 = this.f88352a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        b r104 = this.f88353b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ProfilePreviewEvent(type=" + this.f88352a + ", data=" + this.f88353b + ")";
    }

    public final EventType getType() {
        return this.f88352a;
    }

    public ProfilePreviewEvent(EventType r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f88352a = r100;
        this.f88353b = r101;
    }
}
