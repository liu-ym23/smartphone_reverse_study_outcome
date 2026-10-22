package com.bytedance.android.ec.host.api.split;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/host/api/split/ECFoldScene;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "UNKNOWN", "LIVE", "VIDEO", "MALL", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECFoldScene extends Enum<ECFoldScene> {
    public static final ECFoldScene LIVE = null;
    public static final ECFoldScene MALL = null;
    public static final ECFoldScene UNKNOWN = null;
    public static final ECFoldScene VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECFoldScene[] f46186a = null;
    private final String value;

    static {
        ECFoldScene r100 = new ECFoldScene("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        ECFoldScene r101 = new ECFoldScene("LIVE", 1, "live");
        LIVE = r101;
        ECFoldScene r102 = new ECFoldScene("VIDEO", 2, "video");
        VIDEO = r102;
        ECFoldScene r103 = new ECFoldScene("MALL", 3, "mall");
        MALL = r103;
        f46186a = new ECFoldScene[]{r100, r101, r102, r103};
    }

    public static ECFoldScene valueOf(String r100) {
        return (ECFoldScene) a.a(ECFoldScene.class, r100);
    }

    public static ECFoldScene[] values() {
        return (ECFoldScene[]) f46186a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ECFoldScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
