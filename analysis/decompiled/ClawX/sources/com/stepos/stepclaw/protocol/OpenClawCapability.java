package com.stepos.stepclaw.protocol;

import com.stepos.stepclaw.SecurePrefs;
import i5.a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/stepclaw/protocol/OpenClawCapability;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "rawValue", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "Ability", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OpenClawCapability {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ OpenClawCapability[] $VALUES;
    public static final OpenClawCapability Ability = new OpenClawCapability("Ability", 0, "ability");
    private final String rawValue;

    private static final /* synthetic */ OpenClawCapability[] $values() {
        return new OpenClawCapability[]{Ability};
    }

    static {
        OpenClawCapability[] openClawCapabilityArr$values = $values();
        $VALUES = openClawCapabilityArr$values;
        $ENTRIES = a.a.F(openClawCapabilityArr$values);
    }

    private OpenClawCapability(String str, int i8, String str2) {
        this.rawValue = str2;
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static OpenClawCapability valueOf(String str) {
        return (OpenClawCapability) Enum.valueOf(OpenClawCapability.class, str);
    }

    public static OpenClawCapability[] values() {
        return (OpenClawCapability[]) $VALUES.clone();
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
