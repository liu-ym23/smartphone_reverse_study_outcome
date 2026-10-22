package com.bytedance.android.livesdk.revenue.interactivity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/interactivity/RevPublicScreenHeatState;", "", "DEFAULT", "HOT", "COLD", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevPublicScreenHeatState extends Enum<RevPublicScreenHeatState> {
    public static final RevPublicScreenHeatState COLD = null;
    public static final RevPublicScreenHeatState DEFAULT = null;
    public static final RevPublicScreenHeatState HOT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevPublicScreenHeatState[] f157168a = null;

    static {
        RevPublicScreenHeatState r100 = new RevPublicScreenHeatState("DEFAULT", 0);
        DEFAULT = r100;
        RevPublicScreenHeatState r101 = new RevPublicScreenHeatState("HOT", 1);
        HOT = r101;
        RevPublicScreenHeatState r102 = new RevPublicScreenHeatState("COLD", 2);
        COLD = r102;
        f157168a = new RevPublicScreenHeatState[]{r100, r101, r102};
    }

    public static RevPublicScreenHeatState valueOf(String r100) {
        return (RevPublicScreenHeatState) a.a(RevPublicScreenHeatState.class, r100);
    }

    public static RevPublicScreenHeatState[] values() {
        return (RevPublicScreenHeatState[]) f157168a.clone();
    }

    public RevPublicScreenHeatState(String r100, int r101) {
        super(r100, r101);
    }
}
