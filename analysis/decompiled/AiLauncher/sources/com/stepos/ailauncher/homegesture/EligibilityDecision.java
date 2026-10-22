package com.stepos.ailauncher.homegesture;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.contract.api.homegesture.HomeRootToken;
import com.stepos.ailauncher.contract.api.homegesture.HomeTopKind;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001\u001dBG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001d\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001e\u0010\u0014R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010\u0012R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u000e\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b'\u0010\u0012¨\u0006)"}, d2 = {"Lcom/stepos/ailauncher/homegesture/b;", "", "", HomeGestureEligibilityContract.EXTRA_CONSUMABLE, "", HomeGestureEligibilityContract.EXTRA_SCENE, "action", "taskId", "", "reason", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "rootToken", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;", "topKind", "topId", "<init>", "(ZIIILjava/lang/String;Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", Const.INTENT_KEY_PKGNAME, "()Z", "I", "e", Const.INTENT_KEY_APIKEY, "f", "Ljava/lang/String;", "c", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Companion", "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.homegesture.b, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class EligibilityDecision {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int action;
    private final boolean consumable;
    private final String reason;
    private final HomeRootToken rootToken;
    private final int scene;
    private final int taskId;
    private final String topId;
    private final HomeTopKind topKind;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/homegesture/b$a;", "", "<init>", "()V", "", "reason", "Lcom/stepos/ailauncher/homegesture/b;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/ailauncher/homegesture/b;", "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.homegesture.b$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final EligibilityDecision a(String reason) {
            kotlin.jvm.internal.p.i(reason, "reason");
            return new EligibilityDecision(false, 0, 0, -1, reason, HomeRootToken.DESKTOP, HomeTopKind.NONE, "");
        }

        public Companion() {
        }
    }

    public EligibilityDecision(boolean z10, int i10, int i11, int i12, String reason, HomeRootToken rootToken, HomeTopKind topKind, String topId) {
        kotlin.jvm.internal.p.i(reason, "reason");
        kotlin.jvm.internal.p.i(rootToken, "rootToken");
        kotlin.jvm.internal.p.i(topKind, "topKind");
        kotlin.jvm.internal.p.i(topId, "topId");
        this.consumable = z10;
        this.scene = i10;
        this.action = i11;
        this.taskId = i12;
        this.reason = reason;
        this.rootToken = rootToken;
        this.topKind = topKind;
        this.topId = topId;
    }

    /* renamed from: a, reason: from getter */
    public final int getAction() {
        return this.action;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getConsumable() {
        return this.consumable;
    }

    /* renamed from: c, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: d, reason: from getter */
    public final HomeRootToken getRootToken() {
        return this.rootToken;
    }

    /* renamed from: e, reason: from getter */
    public final int getScene() {
        return this.scene;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EligibilityDecision)) {
            return false;
        }
        EligibilityDecision eligibilityDecision = (EligibilityDecision) other;
        return this.consumable == eligibilityDecision.consumable && this.scene == eligibilityDecision.scene && this.action == eligibilityDecision.action && this.taskId == eligibilityDecision.taskId && kotlin.jvm.internal.p.d(this.reason, eligibilityDecision.reason) && this.rootToken == eligibilityDecision.rootToken && this.topKind == eligibilityDecision.topKind && kotlin.jvm.internal.p.d(this.topId, eligibilityDecision.topId);
    }

    /* renamed from: f, reason: from getter */
    public final int getTaskId() {
        return this.taskId;
    }

    /* renamed from: g, reason: from getter */
    public final String getTopId() {
        return this.topId;
    }

    /* renamed from: h, reason: from getter */
    public final HomeTopKind getTopKind() {
        return this.topKind;
    }

    public int hashCode() {
        return (((((((((((((Boolean.hashCode(this.consumable) * 31) + Integer.hashCode(this.scene)) * 31) + Integer.hashCode(this.action)) * 31) + Integer.hashCode(this.taskId)) * 31) + this.reason.hashCode()) * 31) + this.rootToken.hashCode()) * 31) + this.topKind.hashCode()) * 31) + this.topId.hashCode();
    }

    public String toString() {
        return "EligibilityDecision(consumable=" + this.consumable + ", scene=" + this.scene + ", action=" + this.action + ", taskId=" + this.taskId + ", reason=" + this.reason + ", rootToken=" + this.rootToken + ", topKind=" + this.topKind + ", topId=" + this.topId + ")";
    }
}
