package com.bytedance.applet.debugger;

import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/applet/debugger/DebuggerDebugChannelState;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTED", State.DISCONNECTED, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DebuggerDebugChannelState extends Enum<DebuggerDebugChannelState> {
    public static final DebuggerDebugChannelState CONNECTED = null;
    public static final DebuggerDebugChannelState DISCONNECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DebuggerDebugChannelState[] f191723a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f191724b = null;

    public static EnumEntries<DebuggerDebugChannelState> getEntries() {
        return f191724b;
    }

    static {
        DebuggerDebugChannelState r100 = new DebuggerDebugChannelState("CONNECTED", 0);
        CONNECTED = r100;
        DebuggerDebugChannelState r101 = new DebuggerDebugChannelState(State.DISCONNECTED, 1);
        DISCONNECTED = r101;
        DebuggerDebugChannelState[] r102 = {r100, r101};
        f191723a = r102;
        f191724b = EnumEntriesKt.enumEntries(r102);
    }

    public static DebuggerDebugChannelState[] values() {
        return (DebuggerDebugChannelState[]) f191723a.clone();
    }

    public static DebuggerDebugChannelState valueOf(String r100) {
        return (DebuggerDebugChannelState) r27.a.a(DebuggerDebugChannelState.class, r100);
    }

    public DebuggerDebugChannelState(String r100, int r101) {
        super(r100, r101);
    }
}
