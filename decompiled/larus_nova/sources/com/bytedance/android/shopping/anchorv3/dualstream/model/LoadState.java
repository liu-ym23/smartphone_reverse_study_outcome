package com.bytedance.android.shopping.anchorv3.dualstream.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/dualstream/model/LoadState;", "", "LOADING", "FAILED", "LOADED", "DEFAULT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LoadState extends Enum<LoadState> {
    public static final LoadState DEFAULT = null;
    public static final LoadState FAILED = null;
    public static final LoadState LOADED = null;
    public static final LoadState LOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadState[] f165099a = null;

    static {
        LoadState r100 = new LoadState("LOADING", 0);
        LOADING = r100;
        LoadState r101 = new LoadState("FAILED", 1);
        FAILED = r101;
        LoadState r102 = new LoadState("LOADED", 2);
        LOADED = r102;
        LoadState r103 = new LoadState("DEFAULT", 3);
        DEFAULT = r103;
        f165099a = new LoadState[]{r100, r101, r102, r103};
    }

    public static LoadState valueOf(String r100) {
        return (LoadState) a.a(LoadState.class, r100);
    }

    public static LoadState[] values() {
        return (LoadState[]) f165099a.clone();
    }

    public LoadState(String r100, int r101) {
        super(r100, r101);
    }
}
