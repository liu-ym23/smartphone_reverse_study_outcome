package com.bytedance.android.livesdk.utils.guide;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/utils/guide/LongPressGuideScene;", "", "", "toString", "", "priority", "I", "getPriority", "()I", "RECOMMEND_LIVE", "STREAM_RECOGNITION", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LongPressGuideScene extends Enum<LongPressGuideScene> {
    public static final LongPressGuideScene RECOMMEND_LIVE = null;
    public static final LongPressGuideScene STREAM_RECOGNITION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LongPressGuideScene[] f158965a = null;
    private final int priority;

    static {
        LongPressGuideScene r100 = new LongPressGuideScene("RECOMMEND_LIVE", 0, 100);
        RECOMMEND_LIVE = r100;
        LongPressGuideScene r101 = new LongPressGuideScene("STREAM_RECOGNITION", 1, 50);
        STREAM_RECOGNITION = r101;
        f158965a = new LongPressGuideScene[]{r100, r101};
    }

    public static LongPressGuideScene valueOf(String r100) {
        return (LongPressGuideScene) a.a(LongPressGuideScene.class, r100);
    }

    public static LongPressGuideScene[] values() {
        return (LongPressGuideScene[]) f158965a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "LongPressGuideScene(name=" + name() + ", priority=" + this.priority + ')';
    }

    public final int getPriority() {
        return this.priority;
    }

    public LongPressGuideScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.priority = r102;
    }
}
