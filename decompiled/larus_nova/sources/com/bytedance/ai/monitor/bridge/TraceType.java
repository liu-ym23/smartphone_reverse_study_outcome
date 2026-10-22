package com.bytedance.ai.monitor.bridge;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/monitor/bridge/TraceType;", "", "<init>", "(Ljava/lang/String;I)V", "FE_CALL_FE", "FE_CALL_NATIVE", "NATIVE_EVENT", UserProfileEvent.POSITION_NONE, "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TraceType extends Enum<TraceType> {
    public static final TraceType FE_CALL_FE = null;
    public static final TraceType FE_CALL_NATIVE = null;
    public static final TraceType NATIVE_EVENT = null;
    public static final TraceType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TraceType[] f37201a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f37202b = null;

    public static EnumEntries<TraceType> getEntries() {
        return f37202b;
    }

    static {
        TraceType r100 = new TraceType("FE_CALL_FE", 0);
        FE_CALL_FE = r100;
        TraceType r101 = new TraceType("FE_CALL_NATIVE", 1);
        FE_CALL_NATIVE = r101;
        TraceType r102 = new TraceType("NATIVE_EVENT", 2);
        NATIVE_EVENT = r102;
        TraceType r103 = new TraceType(UserProfileEvent.POSITION_NONE, 3);
        NONE = r103;
        TraceType[] r104 = {r100, r101, r102, r103};
        f37201a = r104;
        f37202b = EnumEntriesKt.enumEntries(r104);
    }

    public static TraceType[] values() {
        return (TraceType[]) f37201a.clone();
    }

    public static TraceType valueOf(String r100) {
        return (TraceType) a.a(TraceType.class, r100);
    }

    public TraceType(String r100, int r101) {
        super(r100, r101);
    }
}
