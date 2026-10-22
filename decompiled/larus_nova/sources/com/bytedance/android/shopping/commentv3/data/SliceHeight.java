package com.bytedance.android.shopping.commentv3.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/SliceHeight;", "", "", "height", "I", "getHeight", "()I", "NA_CUSTOM", "MATCH_PARENT", "WRAP_CONTENT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SliceHeight extends Enum<SliceHeight> {
    public static final SliceHeight MATCH_PARENT = null;
    public static final SliceHeight NA_CUSTOM = null;
    public static final SliceHeight WRAP_CONTENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SliceHeight[] f172730a = null;
    private final int height;

    static {
        SliceHeight r100 = new SliceHeight("NA_CUSTOM", 0, -2);
        NA_CUSTOM = r100;
        SliceHeight r101 = new SliceHeight("MATCH_PARENT", 1, -1);
        MATCH_PARENT = r101;
        SliceHeight r102 = new SliceHeight("WRAP_CONTENT", 2, 0);
        WRAP_CONTENT = r102;
        f172730a = new SliceHeight[]{r100, r101, r102};
    }

    public static SliceHeight valueOf(String r100) {
        return (SliceHeight) r27.a.a(SliceHeight.class, r100);
    }

    public static SliceHeight[] values() {
        return (SliceHeight[]) f172730a.clone();
    }

    public final int getHeight() {
        return this.height;
    }

    public SliceHeight(String r100, int r101, int r102) {
        super(r100, r101);
        this.height = r102;
    }
}
