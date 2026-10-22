package com.bytedance.android.ec.core.monitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/core/monitor/SceneType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "LYNX_CARD", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SceneType extends Enum<SceneType> {
    public static final SceneType LYNX_CARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SceneType[] f45131a = null;
    private final String type;

    static {
        SceneType r100 = new SceneType();
        LYNX_CARD = r100;
        f45131a = new SceneType[]{r100};
    }

    public static SceneType valueOf(String r100) {
        return (SceneType) r27.a.a(SceneType.class, r100);
    }

    public static SceneType[] values() {
        return (SceneType[]) f45131a.clone();
    }

    public SceneType() {
        super("LYNX_CARD", 0);
        this.type = "lynxcard";
    }

    public final String getType() {
        return this.type;
    }
}
