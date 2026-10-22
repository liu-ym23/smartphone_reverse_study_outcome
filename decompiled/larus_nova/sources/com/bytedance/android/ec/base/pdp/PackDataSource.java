package com.bytedance.android.ec.base.pdp;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/base/pdp/PackDataSource;", "", "STANDARD", "FORCE_NET", "ec-base_release"}, k = 1, mv = {1, 4, 3})
public final enum PackDataSource extends Enum<PackDataSource> {
    public static final PackDataSource FORCE_NET = null;
    public static final PackDataSource STANDARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PackDataSource[] f42804a = null;

    static {
        PackDataSource r100 = new PackDataSource("STANDARD", 0);
        STANDARD = r100;
        PackDataSource r101 = new PackDataSource("FORCE_NET", 1);
        FORCE_NET = r101;
        f42804a = new PackDataSource[]{r100, r101};
    }

    public static PackDataSource valueOf(String r100) {
        return (PackDataSource) a.a(PackDataSource.class, r100);
    }

    public static PackDataSource[] values() {
        return (PackDataSource[]) f42804a.clone();
    }

    public PackDataSource(String r100, int r101) {
        super(r100, r101);
    }
}
