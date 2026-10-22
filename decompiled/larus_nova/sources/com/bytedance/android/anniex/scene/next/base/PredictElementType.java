package com.bytedance.android.anniex.scene.next.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/anniex/scene/next/base/PredictElementType;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "SceneId", "SceneRepeat", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum PredictElementType extends Enum<PredictElementType> {
    public static final PredictElementType SceneId = null;
    public static final PredictElementType SceneRepeat = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PredictElementType[] f41257a = null;
    private final String tag;

    public static PredictElementType valueOf(String r100) {
        return (PredictElementType) a.a(PredictElementType.class, r100);
    }

    public static PredictElementType[] values() {
        return (PredictElementType[]) f41257a.clone();
    }

    static {
        PredictElementType r100 = new PredictElementType("SceneId", 0, "SceneId");
        SceneId = r100;
        PredictElementType r101 = new PredictElementType("SceneRepeat", 1, "SceneRepeat");
        SceneRepeat = r101;
        f41257a = new PredictElementType[]{r100, r101};
    }

    public final String getTag() {
        return this.tag;
    }

    public PredictElementType(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
