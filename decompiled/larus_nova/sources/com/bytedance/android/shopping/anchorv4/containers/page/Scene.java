package com.bytedance.android.shopping.anchorv4.containers.page;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/containers/page/Scene;", "", "HALF", "FULL", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final enum Scene extends Enum<Scene> {
    public static final Scene FULL = null;
    public static final Scene HALF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Scene[] f166284a = null;

    static {
        Scene r100 = new Scene("HALF", 0);
        HALF = r100;
        Scene r101 = new Scene("FULL", 1);
        FULL = r101;
        f166284a = new Scene[]{r100, r101};
    }

    public static Scene valueOf(String r100) {
        return (Scene) r27.a.a(Scene.class, r100);
    }

    public static Scene[] values() {
        return (Scene[]) f166284a.clone();
    }

    public Scene(String r100, int r101) {
        super(r100, r101);
    }
}
