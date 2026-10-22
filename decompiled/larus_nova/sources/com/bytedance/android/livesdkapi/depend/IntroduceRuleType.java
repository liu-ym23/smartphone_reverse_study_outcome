package com.bytedance.android.livesdkapi.depend;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/IntroduceRuleType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "DOWNLOADING", "INSTALL_CANCEL", "INSTALL_UNFINISHED", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IntroduceRuleType extends Enum<IntroduceRuleType> {
    private static final /* synthetic */ IntroduceRuleType[] $VALUES = null;
    public static final IntroduceRuleType DOWNLOADING = null;
    public static final IntroduceRuleType INSTALL_CANCEL = null;
    public static final IntroduceRuleType INSTALL_UNFINISHED = null;
    private final String type;

    static {
        IntroduceRuleType r100 = new IntroduceRuleType("DOWNLOADING", 0, "downloading");
        DOWNLOADING = r100;
        IntroduceRuleType r101 = new IntroduceRuleType("INSTALL_CANCEL", 1, "install_cancel");
        INSTALL_CANCEL = r101;
        IntroduceRuleType r102 = new IntroduceRuleType("INSTALL_UNFINISHED", 2, "install_unfinished");
        INSTALL_UNFINISHED = r102;
        $VALUES = new IntroduceRuleType[]{r100, r101, r102};
    }

    public static IntroduceRuleType valueOf(String r100) {
        return (IntroduceRuleType) a.a(IntroduceRuleType.class, r100);
    }

    public static IntroduceRuleType[] values() {
        return (IntroduceRuleType[]) $VALUES.clone();
    }

    public final String getType() {
        return this.type;
    }

    private IntroduceRuleType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
