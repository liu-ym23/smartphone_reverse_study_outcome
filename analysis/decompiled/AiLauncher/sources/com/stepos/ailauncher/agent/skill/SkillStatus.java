package com.stepos.ailauncher.agent.skill;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.a;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import x5.d;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "", "<init>", "(Ljava/lang/String;I)V", "UNINSTALLED", "INSTALLING", "INSTALLED_ENABLED", "INSTALLED_DISABLED", "QUEUED", "TOGGLING", "UNINSTALLING", "INSTALL_FAILED", "INSTALLED", "REVIEWING", "CONNECTING", "IDLE", "CONNECTED", "DISCONNECTED", "isInFlight", "", "()Z", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SkillStatus {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SkillStatus[] $VALUES;

    @SerializedName(a.INSTALL_UNINSTALLED)
    public static final SkillStatus UNINSTALLED = new SkillStatus("UNINSTALLED", 0);

    @SerializedName("installing")
    public static final SkillStatus INSTALLING = new SkillStatus("INSTALLING", 1);

    @SerializedName(d.EXTRA_ENABLED)
    public static final SkillStatus INSTALLED_ENABLED = new SkillStatus("INSTALLED_ENABLED", 2);

    @SerializedName("disabled")
    public static final SkillStatus INSTALLED_DISABLED = new SkillStatus("INSTALLED_DISABLED", 3);

    @SerializedName(AuthSessionDto.STATUS_PENDING)
    public static final SkillStatus QUEUED = new SkillStatus("QUEUED", 4);

    @SerializedName("toggling")
    public static final SkillStatus TOGGLING = new SkillStatus("TOGGLING", 5);

    @SerializedName("uninstalling")
    public static final SkillStatus UNINSTALLING = new SkillStatus("UNINSTALLING", 6);

    @SerializedName("install_failed")
    public static final SkillStatus INSTALL_FAILED = new SkillStatus("INSTALL_FAILED", 7);

    @SerializedName("installed")
    public static final SkillStatus INSTALLED = new SkillStatus("INSTALLED", 8);

    @SerializedName("reviewing")
    public static final SkillStatus REVIEWING = new SkillStatus("REVIEWING", 9);

    @SerializedName("connecting")
    public static final SkillStatus CONNECTING = new SkillStatus("CONNECTING", 10);

    @SerializedName("idle")
    public static final SkillStatus IDLE = new SkillStatus("IDLE", 11);

    @SerializedName("connected")
    public static final SkillStatus CONNECTED = new SkillStatus("CONNECTED", 12);

    @SerializedName("disconnected")
    public static final SkillStatus DISCONNECTED = new SkillStatus("DISCONNECTED", 13);

    private static final /* synthetic */ SkillStatus[] $values() {
        return new SkillStatus[]{UNINSTALLED, INSTALLING, INSTALLED_ENABLED, INSTALLED_DISABLED, QUEUED, TOGGLING, UNINSTALLING, INSTALL_FAILED, INSTALLED, REVIEWING, CONNECTING, IDLE, CONNECTED, DISCONNECTED};
    }

    static {
        SkillStatus[] skillStatusArr$values = $values();
        $VALUES = skillStatusArr$values;
        $ENTRIES = kotlin.enums.a.a(skillStatusArr$values);
    }

    private SkillStatus(String str, int i10) {
    }

    public static InterfaceC4149a<SkillStatus> getEntries() {
        return $ENTRIES;
    }

    public static SkillStatus valueOf(String str) {
        return (SkillStatus) Enum.valueOf(SkillStatus.class, str);
    }

    public static SkillStatus[] values() {
        return (SkillStatus[]) $VALUES.clone();
    }

    public final boolean isInFlight() {
        return this == INSTALLING || this == QUEUED || this == TOGGLING || this == UNINSTALLING;
    }
}
