package com.bytedance.android.livesdk.interactivity.api.publicscreen.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/model/PublicScreenIndividualPriorityState;", "", "DEFAULT", "HIGH_PROTECT", "LOW_DEGRADE", "HIT_ALL", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PublicScreenIndividualPriorityState extends Enum<PublicScreenIndividualPriorityState> {
    public static final PublicScreenIndividualPriorityState DEFAULT = null;
    public static final PublicScreenIndividualPriorityState HIGH_PROTECT = null;
    public static final PublicScreenIndividualPriorityState HIT_ALL = null;
    public static final PublicScreenIndividualPriorityState LOW_DEGRADE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PublicScreenIndividualPriorityState[] f133479a = null;

    static {
        PublicScreenIndividualPriorityState r100 = new PublicScreenIndividualPriorityState("DEFAULT", 0);
        DEFAULT = r100;
        PublicScreenIndividualPriorityState r101 = new PublicScreenIndividualPriorityState("HIGH_PROTECT", 1);
        HIGH_PROTECT = r101;
        PublicScreenIndividualPriorityState r102 = new PublicScreenIndividualPriorityState("LOW_DEGRADE", 2);
        LOW_DEGRADE = r102;
        PublicScreenIndividualPriorityState r103 = new PublicScreenIndividualPriorityState("HIT_ALL", 3);
        HIT_ALL = r103;
        f133479a = new PublicScreenIndividualPriorityState[]{r100, r101, r102, r103};
    }

    public static PublicScreenIndividualPriorityState valueOf(String r100) {
        return (PublicScreenIndividualPriorityState) r27.a.a(PublicScreenIndividualPriorityState.class, r100);
    }

    public static PublicScreenIndividualPriorityState[] values() {
        return (PublicScreenIndividualPriorityState[]) f133479a.clone();
    }

    public PublicScreenIndividualPriorityState(String r100, int r101) {
        super(r100, r101);
    }
}
