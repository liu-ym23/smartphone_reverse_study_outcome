package com.bytedance.android.ec.core.data;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/core/data/PagingLoadingStatus;", "", "SUCCESS", "ERROR", "LOADING", GXAnimation.STATE_END, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PagingLoadingStatus extends Enum<PagingLoadingStatus> {
    public static final PagingLoadingStatus END = null;
    public static final PagingLoadingStatus ERROR = null;
    public static final PagingLoadingStatus LOADING = null;
    public static final PagingLoadingStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PagingLoadingStatus[] f43964a = null;

    static {
        PagingLoadingStatus r100 = new PagingLoadingStatus("SUCCESS", 0);
        SUCCESS = r100;
        PagingLoadingStatus r101 = new PagingLoadingStatus("ERROR", 1);
        ERROR = r101;
        PagingLoadingStatus r102 = new PagingLoadingStatus("LOADING", 2);
        LOADING = r102;
        PagingLoadingStatus r103 = new PagingLoadingStatus(GXAnimation.STATE_END, 3);
        END = r103;
        f43964a = new PagingLoadingStatus[]{r100, r101, r102, r103};
    }

    public static PagingLoadingStatus valueOf(String r100) {
        return (PagingLoadingStatus) a.a(PagingLoadingStatus.class, r100);
    }

    public static PagingLoadingStatus[] values() {
        return (PagingLoadingStatus[]) f43964a.clone();
    }

    public PagingLoadingStatus(String r100, int r101) {
        super(r100, r101);
    }
}
