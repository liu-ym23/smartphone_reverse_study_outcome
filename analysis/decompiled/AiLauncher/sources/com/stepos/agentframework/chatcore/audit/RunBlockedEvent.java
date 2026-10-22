package com.stepos.agentframework.chatcore.audit;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001)Bm\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u0013R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001c\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001d\u0010\u0013R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001e\u0010\u0013R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001f\u0010\u0013R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b \u0010\u0013R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b!\u0010\u0013R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b%\u0010\u0013R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b)\u0010\u0013¨\u0006+"}, d2 = {"Lcom/stepos/agentframework/chatcore/audit/n;", "", "", "kind", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, HomeGestureEligibilityContract.EXTRA_SCENE, "decision", "riskLevel", "presetText", "toast", "", com.stepos.ailauncher.chat.trace.g.END_INTERRUPTED, "reason", "", "blockedAt", "channelMessageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;JLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_COMMAND, "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Z", "c", "()Z", "f", "J", "getBlockedAt", "()J", Const.INTENT_KEY_APIKEY, "Companion", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.audit.n, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class RunBlockedEvent {
    public static final String AUDIT_BLOCKED_REPLY_PREFIX = "audit-blocked-reply-";
    public static final String PRIVACY_BLOCKED_REPLY_PREFIX = "privacy-blocked-reply-";
    public static final String SCENE_PRIVACY_BLOCKED = "privacy_blocked";
    public static final String SCENE_RUN_BLOCKED = "run_blocked";
    public static final String SCENE_USER_BLOCKED = "user_blocked";
    public static final String SCENE_USER_REVERT = "user_revert";
    private final long blockedAt;
    private final String channelMessageId;
    private final String decision;
    private final boolean interrupted;
    private final String kind;
    private final String presetText;
    private final String reason;
    private final String riskLevel;
    private final String runId;
    private final String scene;
    private final String toast;

    public RunBlockedEvent(String kind, String str, String scene, String str2, String str3, String str4, String str5, boolean z10, String str6, long j10, String str7) {
        p.i(kind, "kind");
        p.i(scene, "scene");
        this.kind = kind;
        this.runId = str;
        this.scene = scene;
        this.decision = str2;
        this.riskLevel = str3;
        this.presetText = str4;
        this.toast = str5;
        this.interrupted = z10;
        this.reason = str6;
        this.blockedAt = j10;
        this.channelMessageId = str7;
    }

    /* renamed from: a, reason: from getter */
    public final String getChannelMessageId() {
        return this.channelMessageId;
    }

    /* renamed from: b, reason: from getter */
    public final String getDecision() {
        return this.decision;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getInterrupted() {
        return this.interrupted;
    }

    /* renamed from: d, reason: from getter */
    public final String getKind() {
        return this.kind;
    }

    /* renamed from: e, reason: from getter */
    public final String getPresetText() {
        return this.presetText;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RunBlockedEvent)) {
            return false;
        }
        RunBlockedEvent runBlockedEvent = (RunBlockedEvent) other;
        return p.d(this.kind, runBlockedEvent.kind) && p.d(this.runId, runBlockedEvent.runId) && p.d(this.scene, runBlockedEvent.scene) && p.d(this.decision, runBlockedEvent.decision) && p.d(this.riskLevel, runBlockedEvent.riskLevel) && p.d(this.presetText, runBlockedEvent.presetText) && p.d(this.toast, runBlockedEvent.toast) && this.interrupted == runBlockedEvent.interrupted && p.d(this.reason, runBlockedEvent.reason) && this.blockedAt == runBlockedEvent.blockedAt && p.d(this.channelMessageId, runBlockedEvent.channelMessageId);
    }

    /* renamed from: f, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: g, reason: from getter */
    public final String getRiskLevel() {
        return this.riskLevel;
    }

    /* renamed from: h, reason: from getter */
    public final String getRunId() {
        return this.runId;
    }

    public int hashCode() {
        int iHashCode = this.kind.hashCode() * 31;
        String str = this.runId;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.scene.hashCode()) * 31;
        String str2 = this.decision;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.riskLevel;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.presetText;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.toast;
        int iHashCode6 = (((iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + Boolean.hashCode(this.interrupted)) * 31;
        String str6 = this.reason;
        int iHashCode7 = (((iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + Long.hashCode(this.blockedAt)) * 31;
        String str7 = this.channelMessageId;
        return iHashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getScene() {
        return this.scene;
    }

    /* renamed from: j, reason: from getter */
    public final String getToast() {
        return this.toast;
    }

    public String toString() {
        return "RunBlockedEvent(kind=" + this.kind + ", runId=" + this.runId + ", scene=" + this.scene + ", decision=" + this.decision + ", riskLevel=" + this.riskLevel + ", presetText=" + this.presetText + ", toast=" + this.toast + ", interrupted=" + this.interrupted + ", reason=" + this.reason + ", blockedAt=" + this.blockedAt + ", channelMessageId=" + this.channelMessageId + ")";
    }
}
