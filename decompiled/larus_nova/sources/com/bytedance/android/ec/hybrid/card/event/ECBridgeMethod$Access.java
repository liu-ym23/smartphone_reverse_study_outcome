package com.bytedance.android.ec.hybrid.card.event;

import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"com/bytedance/android/ec/hybrid/card/event/ECBridgeMethod$Access", "", "Lcom/bytedance/android/ec/hybrid/card/event/ECBridgeMethod$Access;", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "PUBLIC", "PRIVATE", "PROTECT", "SECURE", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECBridgeMethod$Access extends Enum<ECBridgeMethod$Access> {
    public static final ECBridgeMethod$Access PRIVATE = null;
    public static final ECBridgeMethod$Access PROTECT = null;
    public static final ECBridgeMethod$Access PUBLIC = null;
    public static final ECBridgeMethod$Access SECURE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECBridgeMethod$Access[] f46470a = null;
    private final String value;

    static {
        ECBridgeMethod$Access r100 = new ECBridgeMethod$Access("PUBLIC", 0, "public");
        PUBLIC = r100;
        ECBridgeMethod$Access r101 = new ECBridgeMethod$Access("PRIVATE", 1, BridgePrivilege.PRIVATE);
        PRIVATE = r101;
        ECBridgeMethod$Access r102 = new ECBridgeMethod$Access("PROTECT", 2, "protected");
        PROTECT = r102;
        ECBridgeMethod$Access r103 = new ECBridgeMethod$Access("SECURE", 3, "secure");
        SECURE = r103;
        f46470a = new ECBridgeMethod$Access[]{r100, r101, r102, r103};
    }

    public static ECBridgeMethod$Access valueOf(String r100) {
        return (ECBridgeMethod$Access) r27.a.a(ECBridgeMethod$Access.class, r100);
    }

    public static ECBridgeMethod$Access[] values() {
        return (ECBridgeMethod$Access[]) f46470a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ECBridgeMethod$Access(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
