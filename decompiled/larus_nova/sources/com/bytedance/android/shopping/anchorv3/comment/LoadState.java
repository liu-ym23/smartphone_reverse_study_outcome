package com.bytedance.android.shopping.anchorv3.comment;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/LoadState;", "", "RESET", "LOADING", "LOADED", "FAIL", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LoadState extends Enum<LoadState> {
    public static final LoadState FAIL = null;
    public static final LoadState LOADED = null;
    public static final LoadState LOADING = null;
    public static final LoadState RESET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadState[] f164496a = null;

    static {
        LoadState r100 = new LoadState("RESET", 0);
        RESET = r100;
        LoadState r101 = new LoadState("LOADING", 1);
        LOADING = r101;
        LoadState r102 = new LoadState("LOADED", 2);
        LOADED = r102;
        LoadState r103 = new LoadState("FAIL", 3);
        FAIL = r103;
        f164496a = new LoadState[]{r100, r101, r102, r103};
    }

    public static LoadState valueOf(String r100) {
        return (LoadState) r27.a.a(LoadState.class, r100);
    }

    public static LoadState[] values() {
        return (LoadState[]) f164496a.clone();
    }

    public LoadState(String r100, int r101) {
        super(r100, r101);
    }
}
