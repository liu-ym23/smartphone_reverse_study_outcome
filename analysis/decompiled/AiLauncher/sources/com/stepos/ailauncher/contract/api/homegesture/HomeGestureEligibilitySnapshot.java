package com.stepos.ailauncher.contract.api.homegesture;

import android.os.Bundle;
import android.os.SystemClock;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.deepbinder.core.constant.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u0000 92\u00020\u0001:\u00019Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020\fJ\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u000fHÆ\u0003J\t\u00102\u001a\u00020\u0011HÆ\u0003J\t\u00103\u001a\u00020\fHÆ\u0003Jw\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001J\u0013\u00105\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0003HÖ\u0001J\t\u00108\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0012\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001f¨\u0006:"}, d2 = {"Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;", "", Constants.PARAM_PROTOCOL_VERSION, "", HomeGestureEligibilityContract.EXTRA_GENERATION, "", HomeGestureEligibilityContract.EXTRA_CONSUMABLE, "", HomeGestureEligibilityContract.EXTRA_SCENE, "action", "taskId", "reason", "", "updatedAtElapsed", "rootToken", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "topKind", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;", "topId", "<init>", "(IJZIIILjava/lang/String;JLcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;Ljava/lang/String;)V", "getProtocolVersion", "()I", "getGeneration", "()J", "getConsumable", "()Z", "getScene", "getAction", "getTaskId", "getReason", "()Ljava/lang/String;", "getUpdatedAtElapsed", "getRootToken", "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "getTopKind", "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;", "getTopId", "toBundle", "Landroid/os/Bundle;", "fingerprint", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "toString", "Companion", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class HomeGestureEligibilitySnapshot {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int action;
    private final boolean consumable;
    private final long generation;
    private final int protocolVersion;
    private final String reason;
    private final HomeRootToken rootToken;
    private final int scene;
    private final int taskId;
    private final String topId;
    private final HomeTopKind topKind;
    private final long updatedAtElapsed;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot$Companion;", "", "<init>", "()V", "none", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;", HomeGestureEligibilityContract.EXTRA_GENERATION, "", "reason", "", "fromBundle", "bundle", "Landroid/os/Bundle;", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ HomeGestureEligibilitySnapshot none$default(Companion companion, long j10, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = 0;
            }
            if ((i10 & 2) != 0) {
                str = "none";
            }
            return companion.none(j10, str);
        }

        public final HomeGestureEligibilitySnapshot fromBundle(Bundle bundle) {
            if (bundle == null) {
                return none$default(this, 0L, "null-bundle", 1, null);
            }
            int i10 = bundle.getInt(HomeGestureEligibilityContract.EXTRA_PROTOCOL_VERSION, 1);
            long j10 = bundle.getLong(HomeGestureEligibilityContract.EXTRA_GENERATION, 0L);
            boolean z10 = bundle.getBoolean(HomeGestureEligibilityContract.EXTRA_CONSUMABLE, false);
            int i11 = bundle.getInt(HomeGestureEligibilityContract.EXTRA_SCENE, 0);
            int i12 = bundle.getInt("action", 0);
            int i13 = bundle.getInt("task_id", -1);
            String string = bundle.getString("reason");
            if (string == null) {
                string = "";
            }
            return new HomeGestureEligibilitySnapshot(i10, j10, z10, i11, i12, i13, string, bundle.getLong(HomeGestureEligibilityContract.EXTRA_UPDATED_AT_ELAPSED, SystemClock.elapsedRealtime()), null, null, null, 1792, null);
        }

        public final HomeGestureEligibilitySnapshot none(long generation, String reason) {
            p.i(reason, "reason");
            return new HomeGestureEligibilitySnapshot(0, generation, false, 0, 0, -1, reason, SystemClock.elapsedRealtime(), HomeRootToken.DESKTOP, HomeTopKind.NONE, "", 1, null);
        }

        private Companion() {
        }
    }

    public HomeGestureEligibilitySnapshot(int i10, long j10, boolean z10, int i11, int i12, int i13, String reason, long j11, HomeRootToken rootToken, HomeTopKind topKind, String topId) {
        p.i(reason, "reason");
        p.i(rootToken, "rootToken");
        p.i(topKind, "topKind");
        p.i(topId, "topId");
        this.protocolVersion = i10;
        this.generation = j10;
        this.consumable = z10;
        this.scene = i11;
        this.action = i12;
        this.taskId = i13;
        this.reason = reason;
        this.updatedAtElapsed = j11;
        this.rootToken = rootToken;
        this.topKind = topKind;
        this.topId = topId;
    }

    public static /* synthetic */ HomeGestureEligibilitySnapshot copy$default(HomeGestureEligibilitySnapshot homeGestureEligibilitySnapshot, int i10, long j10, boolean z10, int i11, int i12, int i13, String str, long j11, HomeRootToken homeRootToken, HomeTopKind homeTopKind, String str2, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = homeGestureEligibilitySnapshot.protocolVersion;
        }
        return homeGestureEligibilitySnapshot.copy(i10, (i14 & 2) != 0 ? homeGestureEligibilitySnapshot.generation : j10, (i14 & 4) != 0 ? homeGestureEligibilitySnapshot.consumable : z10, (i14 & 8) != 0 ? homeGestureEligibilitySnapshot.scene : i11, (i14 & 16) != 0 ? homeGestureEligibilitySnapshot.action : i12, (i14 & 32) != 0 ? homeGestureEligibilitySnapshot.taskId : i13, (i14 & 64) != 0 ? homeGestureEligibilitySnapshot.reason : str, (i14 & 128) != 0 ? homeGestureEligibilitySnapshot.updatedAtElapsed : j11, (i14 & 256) != 0 ? homeGestureEligibilitySnapshot.rootToken : homeRootToken, (i14 & 512) != 0 ? homeGestureEligibilitySnapshot.topKind : homeTopKind, (i14 & 1024) != 0 ? homeGestureEligibilitySnapshot.topId : str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    /* renamed from: component10, reason: from getter */
    public final HomeTopKind getTopKind() {
        return this.topKind;
    }

    /* renamed from: component11, reason: from getter */
    public final String getTopId() {
        return this.topId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getGeneration() {
        return this.generation;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getConsumable() {
        return this.consumable;
    }

    /* renamed from: component4, reason: from getter */
    public final int getScene() {
        return this.scene;
    }

    /* renamed from: component5, reason: from getter */
    public final int getAction() {
        return this.action;
    }

    /* renamed from: component6, reason: from getter */
    public final int getTaskId() {
        return this.taskId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component8, reason: from getter */
    public final long getUpdatedAtElapsed() {
        return this.updatedAtElapsed;
    }

    /* renamed from: component9, reason: from getter */
    public final HomeRootToken getRootToken() {
        return this.rootToken;
    }

    public final HomeGestureEligibilitySnapshot copy(int protocolVersion, long generation, boolean consumable, int scene, int action, int taskId, String reason, long updatedAtElapsed, HomeRootToken rootToken, HomeTopKind topKind, String topId) {
        p.i(reason, "reason");
        p.i(rootToken, "rootToken");
        p.i(topKind, "topKind");
        p.i(topId, "topId");
        return new HomeGestureEligibilitySnapshot(protocolVersion, generation, consumable, scene, action, taskId, reason, updatedAtElapsed, rootToken, topKind, topId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeGestureEligibilitySnapshot)) {
            return false;
        }
        HomeGestureEligibilitySnapshot homeGestureEligibilitySnapshot = (HomeGestureEligibilitySnapshot) other;
        return this.protocolVersion == homeGestureEligibilitySnapshot.protocolVersion && this.generation == homeGestureEligibilitySnapshot.generation && this.consumable == homeGestureEligibilitySnapshot.consumable && this.scene == homeGestureEligibilitySnapshot.scene && this.action == homeGestureEligibilitySnapshot.action && this.taskId == homeGestureEligibilitySnapshot.taskId && p.d(this.reason, homeGestureEligibilitySnapshot.reason) && this.updatedAtElapsed == homeGestureEligibilitySnapshot.updatedAtElapsed && this.rootToken == homeGestureEligibilitySnapshot.rootToken && this.topKind == homeGestureEligibilitySnapshot.topKind && p.d(this.topId, homeGestureEligibilitySnapshot.topId);
    }

    public final String fingerprint() {
        return this.consumable + "|" + this.scene + "|" + this.action + "|" + this.taskId + "|" + this.rootToken.getWire() + "|" + this.topKind.getWire() + "|" + this.topId;
    }

    public final int getAction() {
        return this.action;
    }

    public final boolean getConsumable() {
        return this.consumable;
    }

    public final long getGeneration() {
        return this.generation;
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final String getReason() {
        return this.reason;
    }

    public final HomeRootToken getRootToken() {
        return this.rootToken;
    }

    public final int getScene() {
        return this.scene;
    }

    public final int getTaskId() {
        return this.taskId;
    }

    public final String getTopId() {
        return this.topId;
    }

    public final HomeTopKind getTopKind() {
        return this.topKind;
    }

    public final long getUpdatedAtElapsed() {
        return this.updatedAtElapsed;
    }

    public int hashCode() {
        return (((((((((((((((((((Integer.hashCode(this.protocolVersion) * 31) + Long.hashCode(this.generation)) * 31) + Boolean.hashCode(this.consumable)) * 31) + Integer.hashCode(this.scene)) * 31) + Integer.hashCode(this.action)) * 31) + Integer.hashCode(this.taskId)) * 31) + this.reason.hashCode()) * 31) + Long.hashCode(this.updatedAtElapsed)) * 31) + this.rootToken.hashCode()) * 31) + this.topKind.hashCode()) * 31) + this.topId.hashCode();
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(HomeGestureEligibilityContract.EXTRA_PROTOCOL_VERSION, this.protocolVersion);
        bundle.putLong(HomeGestureEligibilityContract.EXTRA_GENERATION, this.generation);
        bundle.putBoolean(HomeGestureEligibilityContract.EXTRA_CONSUMABLE, this.consumable);
        bundle.putInt(HomeGestureEligibilityContract.EXTRA_SCENE, this.scene);
        bundle.putInt("action", this.action);
        bundle.putInt("task_id", this.taskId);
        bundle.putString("reason", this.reason);
        bundle.putLong(HomeGestureEligibilityContract.EXTRA_UPDATED_AT_ELAPSED, this.updatedAtElapsed);
        return bundle;
    }

    public String toString() {
        return "HomeGestureEligibilitySnapshot(protocolVersion=" + this.protocolVersion + ", generation=" + this.generation + ", consumable=" + this.consumable + ", scene=" + this.scene + ", action=" + this.action + ", taskId=" + this.taskId + ", reason=" + this.reason + ", updatedAtElapsed=" + this.updatedAtElapsed + ", rootToken=" + this.rootToken + ", topKind=" + this.topKind + ", topId=" + this.topId + ")";
    }

    public /* synthetic */ HomeGestureEligibilitySnapshot(int i10, long j10, boolean z10, int i11, int i12, int i13, String str, long j11, HomeRootToken homeRootToken, HomeTopKind homeTopKind, String str2, int i14, i iVar) {
        this((i14 & 1) != 0 ? 1 : i10, j10, z10, i11, i12, i13, str, j11, (i14 & 256) != 0 ? HomeRootToken.DESKTOP : homeRootToken, (i14 & 512) != 0 ? HomeTopKind.NONE : homeTopKind, (i14 & 1024) != 0 ? "" : str2);
    }
}
