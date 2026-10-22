package com.bytedance.android.live.link.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/link/data/RevPkState;", "", "DISABLE", "PK", "PENAL", "FINISHED", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevPkState extends Enum<RevPkState> {
    public static final RevPkState DISABLE = null;
    public static final RevPkState FINISHED = null;
    public static final RevPkState PENAL = null;
    public static final RevPkState PK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevPkState[] f70866a = null;

    static {
        RevPkState r100 = new RevPkState("DISABLE", 0);
        DISABLE = r100;
        RevPkState r101 = new RevPkState("PK", 1);
        PK = r101;
        RevPkState r102 = new RevPkState("PENAL", 2);
        PENAL = r102;
        RevPkState r103 = new RevPkState("FINISHED", 3);
        FINISHED = r103;
        f70866a = new RevPkState[]{r100, r101, r102, r103};
    }

    public static RevPkState valueOf(String r100) {
        return (RevPkState) a.a(RevPkState.class, r100);
    }

    public static RevPkState[] values() {
        return (RevPkState[]) f70866a.clone();
    }

    public RevPkState(String r100, int r101) {
        super(r100, r101);
    }
}
