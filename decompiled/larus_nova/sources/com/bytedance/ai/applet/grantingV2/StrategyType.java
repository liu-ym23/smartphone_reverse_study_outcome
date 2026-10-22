package com.bytedance.ai.applet.grantingV2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/applet/grantingV2/StrategyType;", "", "<init>", "(Ljava/lang/String;I)V", "PRIVACY", "LOGIN", "QS_MUSIC_LOGIN", "FIRST_PARTY_LOGIN", "PERMISSION", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StrategyType extends Enum<StrategyType> {
    public static final StrategyType FIRST_PARTY_LOGIN = null;
    public static final StrategyType LOGIN = null;
    public static final StrategyType PERMISSION = null;
    public static final StrategyType PRIVACY = null;
    public static final StrategyType QS_MUSIC_LOGIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StrategyType[] f34663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34664b = null;

    public static EnumEntries<StrategyType> getEntries() {
        return f34664b;
    }

    static {
        StrategyType r100 = new StrategyType("PRIVACY", 0);
        PRIVACY = r100;
        StrategyType r101 = new StrategyType("LOGIN", 1);
        LOGIN = r101;
        StrategyType r102 = new StrategyType("QS_MUSIC_LOGIN", 2);
        QS_MUSIC_LOGIN = r102;
        StrategyType r103 = new StrategyType("FIRST_PARTY_LOGIN", 3);
        FIRST_PARTY_LOGIN = r103;
        StrategyType r104 = new StrategyType("PERMISSION", 4);
        PERMISSION = r104;
        StrategyType[] r105 = {r100, r101, r102, r103, r104};
        f34663a = r105;
        f34664b = EnumEntriesKt.enumEntries(r105);
    }

    public static StrategyType[] values() {
        return (StrategyType[]) f34663a.clone();
    }

    public static StrategyType valueOf(String r100) {
        return (StrategyType) r27.a.a(StrategyType.class, r100);
    }

    public StrategyType(String r100, int r101) {
        super(r100, r101);
    }
}
