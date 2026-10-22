package com.bytedance.android.live.xplay.basic.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/xplay/basic/api/XplayBasicState;", "", "Stopped", "Loading", "Loaded", "Running", "livexplaygamebasic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum XplayBasicState extends Enum<XplayBasicState> {
    public static final XplayBasicState Loaded = null;
    public static final XplayBasicState Loading = null;
    public static final XplayBasicState Running = null;
    public static final XplayBasicState Stopped = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XplayBasicState[] f102772a = null;

    static {
        XplayBasicState r100 = new XplayBasicState("Stopped", 0);
        Stopped = r100;
        XplayBasicState r101 = new XplayBasicState("Loading", 1);
        Loading = r101;
        XplayBasicState r102 = new XplayBasicState("Loaded", 2);
        Loaded = r102;
        XplayBasicState r103 = new XplayBasicState("Running", 3);
        Running = r103;
        f102772a = new XplayBasicState[]{r100, r101, r102, r103};
    }

    public static XplayBasicState valueOf(String r100) {
        return (XplayBasicState) a.a(XplayBasicState.class, r100);
    }

    public static XplayBasicState[] values() {
        return (XplayBasicState[]) f102772a.clone();
    }

    public XplayBasicState(String r100, int r101) {
        super(r100, r101);
    }
}
