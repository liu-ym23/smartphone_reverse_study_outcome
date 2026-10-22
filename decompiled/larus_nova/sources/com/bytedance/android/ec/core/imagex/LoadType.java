package com.bytedance.android.ec.core.imagex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/LoadType;", "", "FIRST_CACHE", "FIRST_REAL_DATA", "SECOND_REAL_DATA", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LoadType extends Enum<LoadType> {
    public static final LoadType FIRST_CACHE = null;
    public static final LoadType FIRST_REAL_DATA = null;
    public static final LoadType SECOND_REAL_DATA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadType[] f44477a = null;

    static {
        LoadType r100 = new LoadType("FIRST_CACHE", 0);
        FIRST_CACHE = r100;
        LoadType r101 = new LoadType("FIRST_REAL_DATA", 1);
        FIRST_REAL_DATA = r101;
        LoadType r102 = new LoadType("SECOND_REAL_DATA", 2);
        SECOND_REAL_DATA = r102;
        f44477a = new LoadType[]{r100, r101, r102};
    }

    public static LoadType valueOf(String r100) {
        return (LoadType) r27.a.a(LoadType.class, r100);
    }

    public static LoadType[] values() {
        return (LoadType[]) f44477a.clone();
    }

    public LoadType(String r100, int r101) {
        super(r100, r101);
    }
}
