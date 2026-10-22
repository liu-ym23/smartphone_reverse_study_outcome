package com.bytedance.android.ec.store.widget;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/store/widget/SnapStrategy;", "", "", "getTopDown", "getBottomUp", "topDown", FaceService.girlLabel, "bottomUp", "EASY", "DEFAULT", "HARD", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SnapStrategy extends Enum<SnapStrategy> {
    public static final SnapStrategy DEFAULT = null;
    public static final SnapStrategy EASY = null;
    public static final SnapStrategy HARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SnapStrategy[] f48991a = null;
    private final float bottomUp;
    private final float topDown;

    static {
        SnapStrategy r100 = new SnapStrategy("EASY", 0, 0.1f, 0.1f);
        EASY = r100;
        SnapStrategy r101 = new SnapStrategy("DEFAULT", 1, 0.5f, 0.5f);
        DEFAULT = r101;
        SnapStrategy r102 = new SnapStrategy("HARD", 2, 0.8f, 0.8f);
        HARD = r102;
        f48991a = new SnapStrategy[]{r100, r101, r102};
    }

    public static SnapStrategy valueOf(String r100) {
        return (SnapStrategy) r27.a.a(SnapStrategy.class, r100);
    }

    public static SnapStrategy[] values() {
        return (SnapStrategy[]) f48991a.clone();
    }

    public final float getBottomUp() {
        return this.bottomUp;
    }

    public final float getTopDown() {
        return this.topDown;
    }

    public SnapStrategy(String r100, int r101, float r102, float r103) {
        super(r100, r101);
        this.topDown = r102;
        this.bottomUp = r103;
    }
}
