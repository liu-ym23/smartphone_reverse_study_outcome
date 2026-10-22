package u4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001e\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001f\u0010\u0015R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b \u0010\u0015R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b!\u0010\u0015R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\"\u0010\u0015R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b#\u0010\u0015R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b*\u0010\u0015R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b+\u0010\u0015R%\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010,\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lu4/c;", "", "", "decision", "displayText", "reason", "riskLevel", "kind", "channelMessageId", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "", com.stepos.ailauncher.chat.trace.g.END_INTERRUPTED, "", "blockedAt", "presetText", "toast", "", "rawMetadata", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "f", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Z", "e", "()Z", "Ljava/lang/Long;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Long;", Const.INTENT_KEY_BACKGROUND_COMMAND, "k", "Ljava/util/Map;", "getRawMetadata", "()Ljava/util/Map;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: u4.c, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class AgentModeration {
    private final Long blockedAt;
    private final String channelMessageId;
    private final String decision;
    private final String displayText;
    private final boolean interrupted;
    private final String kind;
    private final String presetText;
    private final Map<String, Object> rawMetadata;
    private final String reason;
    private final String riskLevel;
    private final String runId;
    private final String toast;

    public AgentModeration(String decision, String displayText, String str, String str2, String str3, String str4, String str5, boolean z10, Long l10, String str6, String str7, Map<String, ? extends Object> rawMetadata) {
        p.i(decision, "decision");
        p.i(displayText, "displayText");
        p.i(rawMetadata, "rawMetadata");
        this.decision = decision;
        this.displayText = displayText;
        this.reason = str;
        this.riskLevel = str2;
        this.kind = str3;
        this.channelMessageId = str4;
        this.runId = str5;
        this.interrupted = z10;
        this.blockedAt = l10;
        this.presetText = str6;
        this.toast = str7;
        this.rawMetadata = rawMetadata;
    }

    /* renamed from: a, reason: from getter */
    public final Long getBlockedAt() {
        return this.blockedAt;
    }

    /* renamed from: b, reason: from getter */
    public final String getChannelMessageId() {
        return this.channelMessageId;
    }

    /* renamed from: c, reason: from getter */
    public final String getDecision() {
        return this.decision;
    }

    /* renamed from: d, reason: from getter */
    public final String getDisplayText() {
        return this.displayText;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getInterrupted() {
        return this.interrupted;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentModeration)) {
            return false;
        }
        AgentModeration agentModeration = (AgentModeration) other;
        return p.d(this.decision, agentModeration.decision) && p.d(this.displayText, agentModeration.displayText) && p.d(this.reason, agentModeration.reason) && p.d(this.riskLevel, agentModeration.riskLevel) && p.d(this.kind, agentModeration.kind) && p.d(this.channelMessageId, agentModeration.channelMessageId) && p.d(this.runId, agentModeration.runId) && this.interrupted == agentModeration.interrupted && p.d(this.blockedAt, agentModeration.blockedAt) && p.d(this.presetText, agentModeration.presetText) && p.d(this.toast, agentModeration.toast) && p.d(this.rawMetadata, agentModeration.rawMetadata);
    }

    /* renamed from: f, reason: from getter */
    public final String getKind() {
        return this.kind;
    }

    /* renamed from: g, reason: from getter */
    public final String getPresetText() {
        return this.presetText;
    }

    /* renamed from: h, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    public int hashCode() {
        int iHashCode = ((this.decision.hashCode() * 31) + this.displayText.hashCode()) * 31;
        String str = this.reason;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.riskLevel;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.kind;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.channelMessageId;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.runId;
        int iHashCode6 = (((iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + Boolean.hashCode(this.interrupted)) * 31;
        Long l10 = this.blockedAt;
        int iHashCode7 = (iHashCode6 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str6 = this.presetText;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.toast;
        return ((iHashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31) + this.rawMetadata.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final String getRiskLevel() {
        return this.riskLevel;
    }

    /* renamed from: j, reason: from getter */
    public final String getRunId() {
        return this.runId;
    }

    /* renamed from: k, reason: from getter */
    public final String getToast() {
        return this.toast;
    }

    public String toString() {
        return "AgentModeration(decision=" + this.decision + ", displayText=" + this.displayText + ", reason=" + this.reason + ", riskLevel=" + this.riskLevel + ", kind=" + this.kind + ", channelMessageId=" + this.channelMessageId + ", runId=" + this.runId + ", interrupted=" + this.interrupted + ", blockedAt=" + this.blockedAt + ", presetText=" + this.presetText + ", toast=" + this.toast + ", rawMetadata=" + this.rawMetadata + ")";
    }

    public /* synthetic */ AgentModeration(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z10, Long l10, String str8, String str9, Map map, int i10, kotlin.jvm.internal.i iVar) {
        this(str, str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : str7, (i10 & 128) != 0 ? false : z10, (i10 & 256) != 0 ? null : l10, (i10 & 512) != 0 ? null : str8, (i10 & 1024) != 0 ? null : str9, (i10 & 2048) != 0 ? kotlin.collections.a.i() : map);
    }
}
