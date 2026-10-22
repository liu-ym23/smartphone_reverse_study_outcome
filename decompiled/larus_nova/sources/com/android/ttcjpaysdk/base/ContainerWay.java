package com.android.ttcjpaysdk.base;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ContainerWay;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SCAN", "NFC", "SDK", "H5", FlowDoraWifiScene.OTHER, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum ContainerWay extends Enum<ContainerWay> {
    private static final /* synthetic */ ContainerWay[] $VALUES = null;
    public static final ContainerWay H5 = null;
    public static final ContainerWay NFC = null;
    public static final ContainerWay OTHER = null;
    public static final ContainerWay SCAN = null;
    public static final ContainerWay SDK = null;
    private final String value;

    private static final /* synthetic */ ContainerWay[] $values() {
        return new ContainerWay[]{SCAN, NFC, SDK, H5, OTHER};
    }

    public static ContainerWay valueOf(String r100) {
        return (ContainerWay) r27.a.a(ContainerWay.class, r100);
    }

    public static ContainerWay[] values() {
        return (ContainerWay[]) $VALUES.clone();
    }

    static {
        SCAN = new ContainerWay("SCAN", 0, "SCAN");
        NFC = new ContainerWay("NFC", 1, "NFC");
        SDK = new ContainerWay("SDK", 2, "SDK");
        H5 = new ContainerWay("H5", 3, "H5");
        OTHER = new ContainerWay(FlowDoraWifiScene.OTHER, 4, "");
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private ContainerWay(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
