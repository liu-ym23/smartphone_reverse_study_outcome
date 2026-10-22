package com.bytedance.ai.monitor.bridge;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/monitor/bridge/BridgeType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", OuterPayLoginWrapper.LOGIN_STYLE_V1, "IVY", "XBridge", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BridgeType extends Enum<BridgeType> {
    public static final BridgeType IVY = null;
    public static final BridgeType V1 = null;
    public static final BridgeType XBridge = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BridgeType[] f37199a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f37200b = null;
    private final String value;

    public static EnumEntries<BridgeType> getEntries() {
        return f37200b;
    }

    static {
        BridgeType r100 = new BridgeType(OuterPayLoginWrapper.LOGIN_STYLE_V1, 0, "v1");
        V1 = r100;
        BridgeType r101 = new BridgeType("IVY", 1, "ivy");
        IVY = r101;
        BridgeType r102 = new BridgeType("XBridge", 2, "xbridge");
        XBridge = r102;
        BridgeType[] r103 = {r100, r101, r102};
        f37199a = r103;
        f37200b = EnumEntriesKt.enumEntries(r103);
    }

    public static BridgeType[] values() {
        return (BridgeType[]) f37199a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static BridgeType valueOf(String r100) {
        return (BridgeType) a.a(BridgeType.class, r100);
    }

    public BridgeType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
