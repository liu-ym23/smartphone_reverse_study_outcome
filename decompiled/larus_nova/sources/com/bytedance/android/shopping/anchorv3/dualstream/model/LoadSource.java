package com.bytedance.android.shopping.anchorv3.dualstream.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/dualstream/model/LoadSource;", "", "FIRST_LOAD", "LOAD_MORE", "REFRESH", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LoadSource extends Enum<LoadSource> {
    public static final LoadSource FIRST_LOAD = null;
    public static final LoadSource LOAD_MORE = null;
    public static final LoadSource REFRESH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadSource[] f165098a = null;

    static {
        LoadSource r100 = new LoadSource("FIRST_LOAD", 0);
        FIRST_LOAD = r100;
        LoadSource r101 = new LoadSource("LOAD_MORE", 1);
        LOAD_MORE = r101;
        LoadSource r102 = new LoadSource("REFRESH", 2);
        REFRESH = r102;
        f165098a = new LoadSource[]{r100, r101, r102};
    }

    public static LoadSource valueOf(String r100) {
        return (LoadSource) a.a(LoadSource.class, r100);
    }

    public static LoadSource[] values() {
        return (LoadSource[]) f165098a.clone();
    }

    public LoadSource(String r100, int r101) {
        super(r100, r101);
    }
}
