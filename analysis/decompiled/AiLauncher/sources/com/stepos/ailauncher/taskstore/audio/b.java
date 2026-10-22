package com.stepos.ailauncher.taskstore.audio;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/taskstore/audio/b;", "", "<init>", "()V", Const.INTENT_KEY_APIKEY, "c", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/taskstore/audio/b$a;", "Lcom/stepos/ailauncher/taskstore/audio/b$b;", "Lcom/stepos/ailauncher/taskstore/audio/b$c;", "Lcom/stepos/ailauncher/taskstore/audio/b$d;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class b {

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001d\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/taskstore/audio/b$a;", "Lcom/stepos/ailauncher/taskstore/audio/b;", "", "raw", "", "normalized", "", "timestampMs", "recordedTimeMs", "<init>", "(IFJJ)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getRaw", "F", "getNormalized", "()F", "J", "getTimestampMs", "()J", "getRecordedTimeMs", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.audio.b$a, reason: from toString */
    public static final /* data */ class Amplitude extends b {
        private final float normalized;
        private final int raw;
        private final long recordedTimeMs;
        private final long timestampMs;

        public Amplitude(int i10, float f10, long j10, long j11) {
            super(null);
            this.raw = i10;
            this.normalized = f10;
            this.timestampMs = j10;
            this.recordedTimeMs = j11;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Amplitude)) {
                return false;
            }
            Amplitude amplitude = (Amplitude) other;
            return this.raw == amplitude.raw && Float.compare(this.normalized, amplitude.normalized) == 0 && this.timestampMs == amplitude.timestampMs && this.recordedTimeMs == amplitude.recordedTimeMs;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.raw) * 31) + Float.hashCode(this.normalized)) * 31) + Long.hashCode(this.timestampMs)) * 31) + Long.hashCode(this.recordedTimeMs);
        }

        public String toString() {
            return "Amplitude(raw=" + this.raw + ", normalized=" + this.normalized + ", timestampMs=" + this.timestampMs + ", recordedTimeMs=" + this.recordedTimeMs + ")";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/taskstore/audio/b$b;", "Lcom/stepos/ailauncher/taskstore/audio/b;", "", "connected", "<init>", "(Z)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", Const.INTENT_KEY_APIKEY, "()Z", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.audio.b$b, reason: collision with other inner class name and from toString */
    public static final /* data */ class ConnectionChanged extends b {
        private final boolean connected;

        public ConnectionChanged(boolean z10) {
            super(null);
            this.connected = z10;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getConnected() {
            return this.connected;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ConnectionChanged) && this.connected == ((ConnectionChanged) other).connected;
        }

        public int hashCode() {
            return Boolean.hashCode(this.connected);
        }

        public String toString() {
            return "ConnectionChanged(connected=" + this.connected + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/taskstore/audio/b$c;", "Lcom/stepos/ailauncher/taskstore/audio/b;", "", "taskId", "", VoiceWakeupReceiver.EXTRA_STATE, "<init>", "(Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTaskId", "I", "getState", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.audio.b$c, reason: from toString */
    public static final /* data */ class StateChanged extends b {
        private final int state;
        private final String taskId;

        public StateChanged(String str, int i10) {
            super(null);
            this.taskId = str;
            this.state = i10;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StateChanged)) {
                return false;
            }
            StateChanged stateChanged = (StateChanged) other;
            return p.d(this.taskId, stateChanged.taskId) && this.state == stateChanged.state;
        }

        public int hashCode() {
            String str = this.taskId;
            return ((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.state);
        }

        public String toString() {
            return "StateChanged(taskId=" + this.taskId + ", state=" + this.state + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/taskstore/audio/b$d;", "Lcom/stepos/ailauncher/taskstore/audio/b;", "", "recorderId", VoiceWakeupReceiver.EXTRA_STATE, "", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "<init>", "(IILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getRecorderId", "getState", "Ljava/lang/String;", "getContent", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.audio.b$d, reason: from toString */
    public static final /* data */ class SummaryStateChanged extends b {
        private final String content;
        private final int recorderId;
        private final int state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SummaryStateChanged(int i10, int i11, String content) {
            super(null);
            p.i(content, "content");
            this.recorderId = i10;
            this.state = i11;
            this.content = content;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SummaryStateChanged)) {
                return false;
            }
            SummaryStateChanged summaryStateChanged = (SummaryStateChanged) other;
            return this.recorderId == summaryStateChanged.recorderId && this.state == summaryStateChanged.state && p.d(this.content, summaryStateChanged.content);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.recorderId) * 31) + Integer.hashCode(this.state)) * 31) + this.content.hashCode();
        }

        public String toString() {
            return "SummaryStateChanged(recorderId=" + this.recorderId + ", state=" + this.state + ", content=" + this.content + ")";
        }
    }

    public /* synthetic */ b(i iVar) {
        this();
    }

    public b() {
    }
}
