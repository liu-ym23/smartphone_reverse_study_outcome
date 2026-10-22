package com.stepos.ailauncher.agent.skill.opera;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.contract.OperaErrorKind;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.agent.skill.installer.CommandKind;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u001c\b\u0082\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013Jl\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b)\u0010(R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\r\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010*\u001a\u0004\b-\u0010,R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010.\u001a\u0004\b/\u00100R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u00101\u001a\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/opera/a;", "", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "", "oldVersion", "Lcom/stepos/ailauncher/agent/skill/installer/CommandKind;", "commandKind", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "targetStatus", "previousStatus", "", "startElapsedMs", "pollStartElapsedMs", "Lcom/stepos/ailauncher/agent/contract/OperaErrorKind;", "errorKind", "", "pendingAcked", "<init>", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Ljava/lang/String;Lcom/stepos/ailauncher/agent/skill/installer/CommandKind;Lcom/stepos/ailauncher/agent/skill/SkillStatus;Lcom/stepos/ailauncher/agent/skill/SkillStatus;JJLcom/stepos/ailauncher/agent/contract/OperaErrorKind;Z)V", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Ljava/lang/String;Lcom/stepos/ailauncher/agent/skill/installer/CommandKind;Lcom/stepos/ailauncher/agent/skill/SkillStatus;Lcom/stepos/ailauncher/agent/skill/SkillStatus;JJLcom/stepos/ailauncher/agent/contract/OperaErrorKind;Z)Lcom/stepos/ailauncher/agent/skill/opera/a;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "e", "()Lcom/stepos/ailauncher/agent/skill/SkillItem;", "Ljava/lang/String;", "f", "Lcom/stepos/ailauncher/agent/skill/installer/CommandKind;", "c", "()Lcom/stepos/ailauncher/agent/skill/installer/CommandKind;", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "getTargetStatus", "()Lcom/stepos/ailauncher/agent/skill/SkillStatus;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "J", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()J", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lcom/stepos/ailauncher/agent/contract/OperaErrorKind;", Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/agent/contract/OperaErrorKind;", "Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.skill.opera.a, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class InFlightContext {
    private final CommandKind commandKind;
    private final OperaErrorKind errorKind;
    private final SkillItem item;
    private final String oldVersion;
    private final boolean pendingAcked;
    private final long pollStartElapsedMs;
    private final SkillStatus previousStatus;
    private final long startElapsedMs;
    private final SkillStatus targetStatus;

    public InFlightContext(SkillItem item, String str, CommandKind commandKind, SkillStatus targetStatus, SkillStatus previousStatus, long j10, long j11, OperaErrorKind errorKind, boolean z10) {
        p.i(item, "item");
        p.i(commandKind, "commandKind");
        p.i(targetStatus, "targetStatus");
        p.i(previousStatus, "previousStatus");
        p.i(errorKind, "errorKind");
        this.item = item;
        this.oldVersion = str;
        this.commandKind = commandKind;
        this.targetStatus = targetStatus;
        this.previousStatus = previousStatus;
        this.startElapsedMs = j10;
        this.pollStartElapsedMs = j11;
        this.errorKind = errorKind;
        this.pendingAcked = z10;
    }

    public static /* synthetic */ InFlightContext b(InFlightContext inFlightContext, SkillItem skillItem, String str, CommandKind commandKind, SkillStatus skillStatus, SkillStatus skillStatus2, long j10, long j11, OperaErrorKind operaErrorKind, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            skillItem = inFlightContext.item;
        }
        if ((i10 & 2) != 0) {
            str = inFlightContext.oldVersion;
        }
        if ((i10 & 4) != 0) {
            commandKind = inFlightContext.commandKind;
        }
        if ((i10 & 8) != 0) {
            skillStatus = inFlightContext.targetStatus;
        }
        if ((i10 & 16) != 0) {
            skillStatus2 = inFlightContext.previousStatus;
        }
        if ((i10 & 32) != 0) {
            j10 = inFlightContext.startElapsedMs;
        }
        if ((i10 & 64) != 0) {
            j11 = inFlightContext.pollStartElapsedMs;
        }
        if ((i10 & 128) != 0) {
            operaErrorKind = inFlightContext.errorKind;
        }
        if ((i10 & 256) != 0) {
            z10 = inFlightContext.pendingAcked;
        }
        long j12 = j11;
        long j13 = j10;
        SkillStatus skillStatus3 = skillStatus;
        SkillStatus skillStatus4 = skillStatus2;
        CommandKind commandKind2 = commandKind;
        return inFlightContext.a(skillItem, str, commandKind2, skillStatus3, skillStatus4, j13, j12, operaErrorKind, z10);
    }

    public final InFlightContext a(SkillItem item, String oldVersion, CommandKind commandKind, SkillStatus targetStatus, SkillStatus previousStatus, long startElapsedMs, long pollStartElapsedMs, OperaErrorKind errorKind, boolean pendingAcked) {
        p.i(item, "item");
        p.i(commandKind, "commandKind");
        p.i(targetStatus, "targetStatus");
        p.i(previousStatus, "previousStatus");
        p.i(errorKind, "errorKind");
        return new InFlightContext(item, oldVersion, commandKind, targetStatus, previousStatus, startElapsedMs, pollStartElapsedMs, errorKind, pendingAcked);
    }

    /* renamed from: c, reason: from getter */
    public final CommandKind getCommandKind() {
        return this.commandKind;
    }

    /* renamed from: d, reason: from getter */
    public final OperaErrorKind getErrorKind() {
        return this.errorKind;
    }

    /* renamed from: e, reason: from getter */
    public final SkillItem getItem() {
        return this.item;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InFlightContext)) {
            return false;
        }
        InFlightContext inFlightContext = (InFlightContext) other;
        return p.d(this.item, inFlightContext.item) && p.d(this.oldVersion, inFlightContext.oldVersion) && this.commandKind == inFlightContext.commandKind && this.targetStatus == inFlightContext.targetStatus && this.previousStatus == inFlightContext.previousStatus && this.startElapsedMs == inFlightContext.startElapsedMs && this.pollStartElapsedMs == inFlightContext.pollStartElapsedMs && this.errorKind == inFlightContext.errorKind && this.pendingAcked == inFlightContext.pendingAcked;
    }

    /* renamed from: f, reason: from getter */
    public final String getOldVersion() {
        return this.oldVersion;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getPendingAcked() {
        return this.pendingAcked;
    }

    /* renamed from: h, reason: from getter */
    public final long getPollStartElapsedMs() {
        return this.pollStartElapsedMs;
    }

    public int hashCode() {
        int iHashCode = this.item.hashCode() * 31;
        String str = this.oldVersion;
        return ((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.commandKind.hashCode()) * 31) + this.targetStatus.hashCode()) * 31) + this.previousStatus.hashCode()) * 31) + Long.hashCode(this.startElapsedMs)) * 31) + Long.hashCode(this.pollStartElapsedMs)) * 31) + this.errorKind.hashCode()) * 31) + Boolean.hashCode(this.pendingAcked);
    }

    /* renamed from: i, reason: from getter */
    public final SkillStatus getPreviousStatus() {
        return this.previousStatus;
    }

    /* renamed from: j, reason: from getter */
    public final long getStartElapsedMs() {
        return this.startElapsedMs;
    }

    public String toString() {
        return "InFlightContext(item=" + this.item + ", oldVersion=" + this.oldVersion + ", commandKind=" + this.commandKind + ", targetStatus=" + this.targetStatus + ", previousStatus=" + this.previousStatus + ", startElapsedMs=" + this.startElapsedMs + ", pollStartElapsedMs=" + this.pollStartElapsedMs + ", errorKind=" + this.errorKind + ", pendingAcked=" + this.pendingAcked + ")";
    }

    public /* synthetic */ InFlightContext(SkillItem skillItem, String str, CommandKind commandKind, SkillStatus skillStatus, SkillStatus skillStatus2, long j10, long j11, OperaErrorKind operaErrorKind, boolean z10, int i10, i iVar) {
        this(skillItem, (i10 & 2) != 0 ? skillItem.getInstallVersion() : str, commandKind, skillStatus, skillStatus2, j10, (i10 & 64) != 0 ? 0L : j11, operaErrorKind, (i10 & 256) != 0 ? false : z10);
    }
}
