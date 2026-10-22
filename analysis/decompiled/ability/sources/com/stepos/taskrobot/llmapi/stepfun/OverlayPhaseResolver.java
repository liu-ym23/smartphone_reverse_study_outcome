package com.stepos.taskrobot.llmapi.stepfun;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\b¨\u0006\u0011"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/OverlayPhaseResolver;", "", AppAgent.CONSTRUCT, "()V", "resolveResumePhase", "Lcom/stepos/taskrobot/llmapi/stepfun/OverlayPhase;", "current", "manualTakeover", "", "touchEnabled", "passivePromptSnapshot", "", "resolveVisibility", "Lcom/stepos/taskrobot/llmapi/stepfun/OverlayPhaseResolver$Visibility;", TypedValues.CycleType.S_WAVE_PHASE, "dismissed", "Visibility", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OverlayPhaseResolver {
    public static final OverlayPhaseResolver INSTANCE = new OverlayPhaseResolver();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/OverlayPhaseResolver$Visibility;", "", "statusBarVisible", "", "passiveDialogVisible", "ackDialogVisible", "miniBarVisible", AppAgent.CONSTRUCT, "(ZZZZ)V", "getStatusBarVisible", "()Z", "getPassiveDialogVisible", "getAckDialogVisible", "getMiniBarVisible", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Visibility {
        private final boolean ackDialogVisible;
        private final boolean miniBarVisible;
        private final boolean passiveDialogVisible;
        private final boolean statusBarVisible;

        public Visibility(boolean z10, boolean z11, boolean z12, boolean z13) {
            this.statusBarVisible = z10;
            this.passiveDialogVisible = z11;
            this.ackDialogVisible = z12;
            this.miniBarVisible = z13;
        }

        public static /* synthetic */ Visibility copy$default(Visibility visibility, boolean z10, boolean z11, boolean z12, boolean z13, int i, Object obj) {
            if ((i & 1) != 0) {
                z10 = visibility.statusBarVisible;
            }
            if ((i & 2) != 0) {
                z11 = visibility.passiveDialogVisible;
            }
            if ((i & 4) != 0) {
                z12 = visibility.ackDialogVisible;
            }
            if ((i & 8) != 0) {
                z13 = visibility.miniBarVisible;
            }
            return visibility.copy(z10, z11, z12, z13);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getStatusBarVisible() {
            return this.statusBarVisible;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getPassiveDialogVisible() {
            return this.passiveDialogVisible;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getAckDialogVisible() {
            return this.ackDialogVisible;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getMiniBarVisible() {
            return this.miniBarVisible;
        }

        public final Visibility copy(boolean statusBarVisible, boolean passiveDialogVisible, boolean ackDialogVisible, boolean miniBarVisible) {
            return new Visibility(statusBarVisible, passiveDialogVisible, ackDialogVisible, miniBarVisible);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Visibility)) {
                return false;
            }
            Visibility visibility = (Visibility) other;
            return this.statusBarVisible == visibility.statusBarVisible && this.passiveDialogVisible == visibility.passiveDialogVisible && this.ackDialogVisible == visibility.ackDialogVisible && this.miniBarVisible == visibility.miniBarVisible;
        }

        public final boolean getAckDialogVisible() {
            return this.ackDialogVisible;
        }

        public final boolean getMiniBarVisible() {
            return this.miniBarVisible;
        }

        public final boolean getPassiveDialogVisible() {
            return this.passiveDialogVisible;
        }

        public final boolean getStatusBarVisible() {
            return this.statusBarVisible;
        }

        public int hashCode() {
            return Boolean.hashCode(this.miniBarVisible) + androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(Boolean.hashCode(this.statusBarVisible) * 31, 31, this.passiveDialogVisible), 31, this.ackDialogVisible);
        }

        public String toString() {
            return "Visibility(statusBarVisible=" + this.statusBarVisible + ", passiveDialogVisible=" + this.passiveDialogVisible + ", ackDialogVisible=" + this.ackDialogVisible + ", miniBarVisible=" + this.miniBarVisible + ")";
        }
    }

    private OverlayPhaseResolver() {
    }

    public final OverlayPhase resolveResumePhase(OverlayPhase current, boolean manualTakeover, boolean touchEnabled, String passivePromptSnapshot) {
        kotlin.jvm.internal.k.f(current, "current");
        if (manualTakeover && touchEnabled) {
            return passivePromptSnapshot != null ? OverlayPhase.PASSIVE_PROMPT : OverlayPhase.TAKEOVER_ACK;
        }
        return OverlayPhase.RUNNING;
    }

    public final Visibility resolveVisibility(OverlayPhase phase, boolean dismissed) {
        kotlin.jvm.internal.k.f(phase, "phase");
        boolean z10 = false;
        boolean z11 = phase == OverlayPhase.RUNNING && !dismissed;
        boolean z12 = phase == OverlayPhase.PASSIVE_PROMPT && !dismissed;
        boolean z13 = phase == OverlayPhase.TAKEOVER_ACK && !dismissed;
        if (phase == OverlayPhase.MINI && !dismissed) {
            z10 = true;
        }
        return new Visibility(z11, z12, z13, z10);
    }
}
