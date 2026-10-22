package com.bytedance.android.shopping.store.home.presenter;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/AnimationStatus;", "", "DEFAULT", "RUNNING", "FINISHED", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnimationStatus extends Enum<AnimationStatus> {
    public static final AnimationStatus DEFAULT = null;
    public static final AnimationStatus FINISHED = null;
    public static final AnimationStatus RUNNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimationStatus[] f183835a = null;

    static {
        AnimationStatus r100 = new AnimationStatus("DEFAULT", 0);
        DEFAULT = r100;
        AnimationStatus r101 = new AnimationStatus("RUNNING", 1);
        RUNNING = r101;
        AnimationStatus r102 = new AnimationStatus("FINISHED", 2);
        FINISHED = r102;
        f183835a = new AnimationStatus[]{r100, r101, r102};
    }

    public static AnimationStatus valueOf(String r100) {
        return (AnimationStatus) r27.a.a(AnimationStatus.class, r100);
    }

    public static AnimationStatus[] values() {
        return (AnimationStatus[]) f183835a.clone();
    }

    public AnimationStatus(String r100, int r101) {
        super(r100, r101);
    }
}
