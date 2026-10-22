package z4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.longtext.LongTextEntryReason;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, d2 = {"Lz4/a;", "", "Lz4/c;", "candidate", "Lcom/stepos/agentframework/chatui/longtext/LongTextEntryReason;", "reason", "", "partIndex", "<init>", "(Lz4/c;Lcom/stepos/agentframework/chatui/longtext/LongTextEntryReason;I)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lz4/c;", Const.INTENT_KEY_APIKEY, "()Lz4/c;", "Lcom/stepos/agentframework/chatui/longtext/LongTextEntryReason;", "c", "()Lcom/stepos/agentframework/chatui/longtext/LongTextEntryReason;", "I", Const.INTENT_KEY_PKGNAME, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: z4.a, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class LongTextAdmission {
    private final C6357c candidate;
    private final int partIndex;
    private final LongTextEntryReason reason;

    public LongTextAdmission(C6357c c6357c, LongTextEntryReason reason, int i10) {
        p.i(reason, "reason");
        this.candidate = c6357c;
        this.reason = reason;
        this.partIndex = i10;
    }

    /* renamed from: a, reason: from getter */
    public final C6357c getCandidate() {
        return this.candidate;
    }

    /* renamed from: b, reason: from getter */
    public final int getPartIndex() {
        return this.partIndex;
    }

    /* renamed from: c, reason: from getter */
    public final LongTextEntryReason getReason() {
        return this.reason;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LongTextAdmission)) {
            return false;
        }
        LongTextAdmission longTextAdmission = (LongTextAdmission) other;
        return p.d(this.candidate, longTextAdmission.candidate) && this.reason == longTextAdmission.reason && this.partIndex == longTextAdmission.partIndex;
    }

    public int hashCode() {
        C6357c c6357c = this.candidate;
        return ((((c6357c == null ? 0 : c6357c.hashCode()) * 31) + this.reason.hashCode()) * 31) + Integer.hashCode(this.partIndex);
    }

    public String toString() {
        return "LongTextAdmission(candidate=" + this.candidate + ", reason=" + this.reason + ", partIndex=" + this.partIndex + ")";
    }

    public /* synthetic */ LongTextAdmission(C6357c c6357c, LongTextEntryReason longTextEntryReason, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? null : c6357c, longTextEntryReason, (i11 & 4) != 0 ? -1 : i10);
    }
}
