package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/StageUpdateType;", "", "INSERT", "REMOVE", "UPDATE", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum StageUpdateType extends Enum<StageUpdateType> {
    public static final StageUpdateType INSERT = null;
    public static final StageUpdateType REMOVE = null;
    public static final StageUpdateType UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StageUpdateType[] f77082a = null;

    static {
        StageUpdateType r100 = new StageUpdateType("INSERT", 0);
        INSERT = r100;
        StageUpdateType r101 = new StageUpdateType("REMOVE", 1);
        REMOVE = r101;
        StageUpdateType r102 = new StageUpdateType("UPDATE", 2);
        UPDATE = r102;
        f77082a = new StageUpdateType[]{r100, r101, r102};
    }

    public static StageUpdateType valueOf(String r100) {
        return (StageUpdateType) a.a(StageUpdateType.class, r100);
    }

    public static StageUpdateType[] values() {
        return (StageUpdateType[]) f77082a.clone();
    }

    public StageUpdateType(String r100, int r101) {
        super(r100, r101);
    }
}
