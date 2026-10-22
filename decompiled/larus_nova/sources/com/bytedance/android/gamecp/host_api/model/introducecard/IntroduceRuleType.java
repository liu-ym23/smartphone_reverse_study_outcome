package com.bytedance.android.gamecp.host_api.model.introducecard;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/introducecard/IntroduceRuleType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "DOWNLOADING", "INSTALL_CANCEL", "INSTALL_UNFINISHED", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IntroduceRuleType extends Enum<IntroduceRuleType> {
    public static final IntroduceRuleType DOWNLOADING = null;
    public static final IntroduceRuleType INSTALL_CANCEL = null;
    public static final IntroduceRuleType INSTALL_UNFINISHED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IntroduceRuleType[] f57379a = null;
    private final String type;

    static {
        IntroduceRuleType r100 = new IntroduceRuleType("DOWNLOADING", 0, "downloading");
        DOWNLOADING = r100;
        IntroduceRuleType r101 = new IntroduceRuleType("INSTALL_CANCEL", 1, "install_cancel");
        INSTALL_CANCEL = r101;
        IntroduceRuleType r102 = new IntroduceRuleType("INSTALL_UNFINISHED", 2, "install_unfinished");
        INSTALL_UNFINISHED = r102;
        f57379a = new IntroduceRuleType[]{r100, r101, r102};
    }

    public static IntroduceRuleType valueOf(String r100) {
        return (IntroduceRuleType) r27.a.a(IntroduceRuleType.class, r100);
    }

    public static IntroduceRuleType[] values() {
        return (IntroduceRuleType[]) f57379a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public IntroduceRuleType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
