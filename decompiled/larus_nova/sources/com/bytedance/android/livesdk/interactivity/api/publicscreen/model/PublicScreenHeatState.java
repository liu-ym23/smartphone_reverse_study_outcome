package com.bytedance.android.livesdk.interactivity.api.publicscreen.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/model/PublicScreenHeatState;", "", "DEFAULT", "HOT", "COLD", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PublicScreenHeatState extends Enum<PublicScreenHeatState> {
    public static final PublicScreenHeatState COLD = null;
    public static final PublicScreenHeatState DEFAULT = null;
    public static final PublicScreenHeatState HOT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PublicScreenHeatState[] f133478a = null;

    static {
        PublicScreenHeatState r100 = new PublicScreenHeatState("DEFAULT", 0);
        DEFAULT = r100;
        PublicScreenHeatState r101 = new PublicScreenHeatState("HOT", 1);
        HOT = r101;
        PublicScreenHeatState r102 = new PublicScreenHeatState("COLD", 2);
        COLD = r102;
        f133478a = new PublicScreenHeatState[]{r100, r101, r102};
    }

    public static PublicScreenHeatState valueOf(String r100) {
        return (PublicScreenHeatState) r27.a.a(PublicScreenHeatState.class, r100);
    }

    public static PublicScreenHeatState[] values() {
        return (PublicScreenHeatState[]) f133478a.clone();
    }

    public PublicScreenHeatState(String r100, int r101) {
        super(r100, r101);
    }
}
