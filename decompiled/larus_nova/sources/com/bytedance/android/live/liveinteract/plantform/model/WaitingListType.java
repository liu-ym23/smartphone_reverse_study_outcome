package com.bytedance.android.live.liveinteract.plantform.model;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/WaitingListType;", "", "UNKNOWN", EffectConstants.NORMAL, "PAID", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum WaitingListType extends Enum<WaitingListType> {
    public static final WaitingListType NORMAL = null;
    public static final WaitingListType PAID = null;
    public static final WaitingListType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WaitingListType[] f77229a = null;

    static {
        WaitingListType r100 = new WaitingListType("UNKNOWN", 0);
        UNKNOWN = r100;
        WaitingListType r101 = new WaitingListType(EffectConstants.NORMAL, 1);
        NORMAL = r101;
        WaitingListType r102 = new WaitingListType("PAID", 2);
        PAID = r102;
        f77229a = new WaitingListType[]{r100, r101, r102};
    }

    public static WaitingListType valueOf(String r100) {
        return (WaitingListType) r27.a.a(WaitingListType.class, r100);
    }

    public static WaitingListType[] values() {
        return (WaitingListType[]) f77229a.clone();
    }

    public WaitingListType(String r100, int r101) {
        super(r100, r101);
    }
}
