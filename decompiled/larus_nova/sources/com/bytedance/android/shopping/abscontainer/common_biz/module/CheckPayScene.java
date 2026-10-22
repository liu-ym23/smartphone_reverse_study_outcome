package com.bytedance.android.shopping.abscontainer.common_biz.module;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/common_biz/module/CheckPayScene;", "", "BUY", "CONTINUEPAY", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CheckPayScene extends Enum<CheckPayScene> {
    public static final CheckPayScene BUY = null;
    public static final CheckPayScene CONTINUEPAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CheckPayScene[] f164295a = null;

    static {
        CheckPayScene r100 = new CheckPayScene("BUY", 0);
        BUY = r100;
        CheckPayScene r101 = new CheckPayScene("CONTINUEPAY", 1);
        CONTINUEPAY = r101;
        f164295a = new CheckPayScene[]{r100, r101};
    }

    public static CheckPayScene valueOf(String r100) {
        return (CheckPayScene) r27.a.a(CheckPayScene.class, r100);
    }

    public static CheckPayScene[] values() {
        return (CheckPayScene[]) f164295a.clone();
    }

    public CheckPayScene(String r100, int r101) {
        super(r100, r101);
    }
}
