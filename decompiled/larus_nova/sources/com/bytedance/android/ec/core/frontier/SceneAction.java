package com.bytedance.android.ec.core.frontier;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/core/frontier/SceneAction;", "", "", "num", "I", "getNum", "()I", "SceneActionEnter", "SceneActionLeave", "SceneMessageAck", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SceneAction extends Enum<SceneAction> {
    public static final SceneAction SceneActionEnter = null;
    public static final SceneAction SceneActionLeave = null;
    public static final SceneAction SceneMessageAck = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SceneAction[] f44023a = null;
    private final int num;

    static {
        SceneAction r100 = new SceneAction("SceneActionEnter", 0, 10);
        SceneActionEnter = r100;
        SceneAction r101 = new SceneAction("SceneActionLeave", 1, 20);
        SceneActionLeave = r101;
        SceneAction r102 = new SceneAction("SceneMessageAck", 2, 40);
        SceneMessageAck = r102;
        f44023a = new SceneAction[]{r100, r101, r102};
    }

    public static SceneAction valueOf(String r100) {
        return (SceneAction) r27.a.a(SceneAction.class, r100);
    }

    public static SceneAction[] values() {
        return (SceneAction[]) f44023a.clone();
    }

    public final int getNum() {
        return this.num;
    }

    public SceneAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.num = r102;
    }
}
