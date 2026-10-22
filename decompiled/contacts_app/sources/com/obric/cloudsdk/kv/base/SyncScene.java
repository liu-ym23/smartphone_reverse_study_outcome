package com.obric.cloudsdk.kv.base;

import kotlin.Metadata;

/* JADX INFO: compiled from: SyncScene.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/cloudsdk/kv/base/SyncScene;", "", "desc", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "MANUALLY", "CLIENT_UPDATE", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum SyncScene extends Enum<SyncScene> {
    private static final /* synthetic */ SyncScene[] $VALUES = null;
    public static final SyncScene CLIENT_UPDATE = null;
    public static final SyncScene MANUALLY = null;
    private final String desc;

    private static final /* synthetic */ SyncScene[] $values() {
        return new SyncScene[]{MANUALLY, CLIENT_UPDATE};
    }

    public static SyncScene valueOf(String r1) {
        return (SyncScene) Enum.valueOf(SyncScene.class, r1);
    }

    public static SyncScene[] values() {
        return (SyncScene[]) $VALUES.clone();
    }

    private SyncScene(String r1, int r2, String r3) {
        super(r1, r2);
        this.desc = r3;
    }

    public final String getDesc() {
        return this.desc;
    }

    static {
        MANUALLY = new SyncScene("MANUALLY", 0, "MANUALLY");
        CLIENT_UPDATE = new SyncScene("CLIENT_UPDATE", 1, "APP_STARTED");
        $VALUES = $values();
    }
}
