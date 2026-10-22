package com.bytedance.android.livesdkapi.depend.model.live.linker;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ReplyReason;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "MANUAL", "TIMEOUT", "TOUCH_OUTSIDE", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ReplyReason extends Enum<ReplyReason> {
    private static final /* synthetic */ ReplyReason[] $VALUES = null;
    public static final Companion Companion = null;
    public static final ReplyReason MANUAL = null;
    public static final ReplyReason TIMEOUT = null;
    public static final ReplyReason TOUCH_OUTSIDE = null;
    public static final ReplyReason UNKNOWN = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ReplyReason$Companion;", "", "()V", "fromString", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ReplyReason;", "value", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final ReplyReason fromString(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            ReplyReason[] r101 = ReplyReason.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            ReplyReason r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getValue(), r100) == true) goto L9;
            r103 = r103 + 1;
        L9:
            if (r104 == null) goto L11;
            return r104;
        L11:
            return ReplyReason.UNKNOWN;
        L8:
            r104 = null;
            goto L9
        }
    }

    static {
        ReplyReason r100 = new ReplyReason("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        ReplyReason r101 = new ReplyReason("MANUAL", 1, "manual");
        MANUAL = r101;
        ReplyReason r102 = new ReplyReason("TIMEOUT", 2, "timeout");
        TIMEOUT = r102;
        ReplyReason r103 = new ReplyReason("TOUCH_OUTSIDE", 3, "touch_outside");
        TOUCH_OUTSIDE = r103;
        $VALUES = new ReplyReason[]{r100, r101, r102, r103};
        Companion = new Companion(null);
    }

    public static ReplyReason valueOf(String r100) {
        return (ReplyReason) a.a(ReplyReason.class, r100);
    }

    public static ReplyReason[] values() {
        return (ReplyReason[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    private ReplyReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
