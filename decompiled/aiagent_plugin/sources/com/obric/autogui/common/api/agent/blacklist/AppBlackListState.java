package com.obric.autogui.common.api.agent.blacklist;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: AppBlackListState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum AppBlackListState extends Enum<AppBlackListState> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ AppBlackListState[] $VALUES = null;
    public static final AppBlackListState CannotObtain = null;
    public static final AppBlackListState HardBlackList = null;
    public static final AppBlackListState SAEPBlackList = null;
    public static final AppBlackListState SoftBlackList = null;
    public static final AppBlackListState Usable = null;
    public static final AppBlackListState UserDefinedBlackList = null;
    public static final AppBlackListState Virus = null;

    private static final /* synthetic */ AppBlackListState[] $values() {
        return new AppBlackListState[]{Usable, HardBlackList, SoftBlackList, UserDefinedBlackList, SAEPBlackList, Virus, CannotObtain};
    }

    public static a<AppBlackListState> getEntries() {
        return $ENTRIES;
    }

    private AppBlackListState(String r1, int r2) {
        super(r1, r2);
    }

    static {
        Usable = new AppBlackListState("Usable", 0);
        HardBlackList = new AppBlackListState("HardBlackList", 1);
        SoftBlackList = new AppBlackListState("SoftBlackList", 2);
        UserDefinedBlackList = new AppBlackListState("UserDefinedBlackList", 3);
        SAEPBlackList = new AppBlackListState("SAEPBlackList", 4);
        Virus = new AppBlackListState("Virus", 5);
        CannotObtain = new AppBlackListState("CannotObtain", 6);
        AppBlackListState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static AppBlackListState valueOf(String r2) {
        return (AppBlackListState) ZeusTransformUtils.preCheckCast(Enum.valueOf(AppBlackListState.class, r2), AppBlackListState.class, "com.obric.aiagent.plugin");
    }

    public static AppBlackListState[] values() {
        return (AppBlackListState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AppBlackListState[].class, "com.obric.aiagent.plugin");
    }
}
