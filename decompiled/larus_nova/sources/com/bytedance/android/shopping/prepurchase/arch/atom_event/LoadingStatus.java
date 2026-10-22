package com.bytedance.android.shopping.prepurchase.arch.atom_event;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/atom_event/LoadingStatus;", "", "SHOW", "HIDE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LoadingStatus extends Enum<LoadingStatus> {
    public static final LoadingStatus HIDE = null;
    public static final LoadingStatus SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadingStatus[] f180677a = null;

    static {
        LoadingStatus r100 = new LoadingStatus("SHOW", 0);
        SHOW = r100;
        LoadingStatus r101 = new LoadingStatus("HIDE", 1);
        HIDE = r101;
        f180677a = new LoadingStatus[]{r100, r101};
    }

    public static LoadingStatus valueOf(String r100) {
        return (LoadingStatus) r27.a.a(LoadingStatus.class, r100);
    }

    public static LoadingStatus[] values() {
        return (LoadingStatus[]) f180677a.clone();
    }

    public LoadingStatus(String r100, int r101) {
        super(r100, r101);
    }
}
