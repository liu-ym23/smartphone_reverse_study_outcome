package com.bytedance.android.shopping.commentv3.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/MultiPicMode;", "", "", "mode", "I", "getMode", "()I", "LIST", "PIC", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MultiPicMode extends Enum<MultiPicMode> {
    public static final MultiPicMode LIST = null;
    public static final MultiPicMode PIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiPicMode[] f172727a = null;
    private final int mode;

    static {
        MultiPicMode r100 = new MultiPicMode("LIST", 0, 0);
        LIST = r100;
        MultiPicMode r101 = new MultiPicMode("PIC", 1, 1);
        PIC = r101;
        f172727a = new MultiPicMode[]{r100, r101};
    }

    public static MultiPicMode valueOf(String r100) {
        return (MultiPicMode) r27.a.a(MultiPicMode.class, r100);
    }

    public static MultiPicMode[] values() {
        return (MultiPicMode[]) f172727a.clone();
    }

    public final int getMode() {
        return this.mode;
    }

    public MultiPicMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.mode = r102;
    }
}
