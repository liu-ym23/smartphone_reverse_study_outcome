package com.stepos.ailauncher.mcpservice.risk;

import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import h9.InterfaceC4149a;
import java.util.Locale;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/mcpservice/risk/UnlockSceneResult;", "", "<init>", "(Ljava/lang/String;I)V", AMapLocationStaticsEntity.SUCCESS_STATUS, "ALREADY_UNLOCKED", "CANCELLED", "TIMEOUT", "FAILED", "toJsonValue", "", "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UnlockSceneResult {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ UnlockSceneResult[] $VALUES;
    public static final UnlockSceneResult SUCCESS = new UnlockSceneResult(AMapLocationStaticsEntity.SUCCESS_STATUS, 0);
    public static final UnlockSceneResult ALREADY_UNLOCKED = new UnlockSceneResult("ALREADY_UNLOCKED", 1);
    public static final UnlockSceneResult CANCELLED = new UnlockSceneResult("CANCELLED", 2);
    public static final UnlockSceneResult TIMEOUT = new UnlockSceneResult("TIMEOUT", 3);
    public static final UnlockSceneResult FAILED = new UnlockSceneResult("FAILED", 4);

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UnlockSceneResult.values().length];
            try {
                iArr[UnlockSceneResult.ALREADY_UNLOCKED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ UnlockSceneResult[] $values() {
        return new UnlockSceneResult[]{SUCCESS, ALREADY_UNLOCKED, CANCELLED, TIMEOUT, FAILED};
    }

    static {
        UnlockSceneResult[] unlockSceneResultArr$values = $values();
        $VALUES = unlockSceneResultArr$values;
        $ENTRIES = kotlin.enums.a.a(unlockSceneResultArr$values);
    }

    private UnlockSceneResult(String str, int i10) {
    }

    public static InterfaceC4149a<UnlockSceneResult> getEntries() {
        return $ENTRIES;
    }

    public static UnlockSceneResult valueOf(String str) {
        return (UnlockSceneResult) Enum.valueOf(UnlockSceneResult.class, str);
    }

    public static UnlockSceneResult[] values() {
        return (UnlockSceneResult[]) $VALUES.clone();
    }

    public final String toJsonValue() {
        if (a.$EnumSwitchMapping$0[ordinal()] == 1) {
            return "already_unlocked";
        }
        String lowerCase = name().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
