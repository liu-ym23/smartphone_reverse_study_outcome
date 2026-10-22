package com.bytedance.applog.map.api;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/applog/map/api/IdSource;", "", "", "toString", "Auto", "NxET", "BTM", "Custom", "map-api_release"}, k = 1, mv = {1, 6, 0})
public final enum IdSource extends Enum<IdSource> {
    public static final IdSource Auto = null;
    public static final IdSource BTM = null;
    public static final IdSource Custom = null;
    public static final IdSource NxET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IdSource[] f192482a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f192483a = null;

        static {
            int[] r100 = new int[IdSource.values().length];
            r100[IdSource.Auto.ordinal()] = 1;
            r100[IdSource.NxET.ordinal()] = 2;
            r100[IdSource.BTM.ordinal()] = 3;
            r100[IdSource.Custom.ordinal()] = 4;
            f192483a = r100;
        }
    }

    public static IdSource valueOf(String r100) {
        return (IdSource) r27.a.a(IdSource.class, r100);
    }

    public static IdSource[] values() {
        return (IdSource[]) f192482a.clone();
    }

    static {
        IdSource r100 = new IdSource("Auto", 0);
        Auto = r100;
        IdSource r101 = new IdSource("NxET", 1);
        NxET = r101;
        IdSource r102 = new IdSource("BTM", 2);
        BTM = r102;
        IdSource r103 = new IdSource("Custom", 3);
        Custom = r103;
        f192482a = new IdSource[]{r100, r101, r102, r103};
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = a.f192483a[ordinal()];
        if (r100 != 1) goto L5;
        return "auto";
    L5:
        if (r100 != 2) goto L7;
        return "nxet";
    L7:
        if (r100 != 3) goto L9;
        return "btm";
    L9:
        if (r100 != 4) goto L12;
        return "custom";
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public IdSource(String r100, int r101) {
        super(r100, r101);
    }
}
