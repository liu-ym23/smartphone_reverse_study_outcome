package com.stepos.stepclaw.protocol;

import com.stepos.stepclaw.SecurePrefs;
import i5.a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/stepos/stepclaw/protocol/OpenClawAbilityCommand;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "rawValue", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "Call", "List", "Companion", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OpenClawAbilityCommand {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ OpenClawAbilityCommand[] $VALUES;
    public static final String NamespacePrefix = "ability.";
    private final String rawValue;
    public static final OpenClawAbilityCommand Call = new OpenClawAbilityCommand("Call", 0, "ability.call");
    public static final OpenClawAbilityCommand List = new OpenClawAbilityCommand("List", 1, "ability.list");

    private static final /* synthetic */ OpenClawAbilityCommand[] $values() {
        return new OpenClawAbilityCommand[]{Call, List};
    }

    static {
        OpenClawAbilityCommand[] openClawAbilityCommandArr$values = $values();
        $VALUES = openClawAbilityCommandArr$values;
        $ENTRIES = a.a.F(openClawAbilityCommandArr$values);
        INSTANCE = new Companion(null);
    }

    private OpenClawAbilityCommand(String str, int i8, String str2) {
        this.rawValue = str2;
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static OpenClawAbilityCommand valueOf(String str) {
        return (OpenClawAbilityCommand) Enum.valueOf(OpenClawAbilityCommand.class, str);
    }

    public static OpenClawAbilityCommand[] values() {
        return (OpenClawAbilityCommand[]) $VALUES.clone();
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
