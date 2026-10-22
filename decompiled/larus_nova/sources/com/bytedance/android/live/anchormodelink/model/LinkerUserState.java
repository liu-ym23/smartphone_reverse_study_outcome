package com.bytedance.android.live.anchormodelink.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/anchormodelink/model/LinkerUserState;", "", "None", "Audience", "Waiting", "Ready", "Linked", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkerUserState extends Enum<LinkerUserState> {
    public static final LinkerUserState Audience = null;
    public static final LinkerUserState Linked = null;
    public static final LinkerUserState None = null;
    public static final LinkerUserState Ready = null;
    public static final LinkerUserState Waiting = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkerUserState[] f58789a = null;

    static {
        LinkerUserState r100 = new LinkerUserState("None", 0);
        None = r100;
        LinkerUserState r101 = new LinkerUserState("Audience", 1);
        Audience = r101;
        LinkerUserState r102 = new LinkerUserState("Waiting", 2);
        Waiting = r102;
        LinkerUserState r103 = new LinkerUserState("Ready", 3);
        Ready = r103;
        LinkerUserState r104 = new LinkerUserState("Linked", 4);
        Linked = r104;
        f58789a = new LinkerUserState[]{r100, r101, r102, r103, r104};
    }

    public static LinkerUserState valueOf(String r100) {
        return (LinkerUserState) a.a(LinkerUserState.class, r100);
    }

    public static LinkerUserState[] values() {
        return (LinkerUserState[]) f58789a.clone();
    }

    public LinkerUserState(String r100, int r101) {
        super(r100, r101);
    }
}
