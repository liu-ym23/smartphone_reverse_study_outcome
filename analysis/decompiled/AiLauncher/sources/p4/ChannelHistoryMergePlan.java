package p4;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001c\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001d\u0010\u0012R\u0017\u0010\t\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001e\u0010\u0012R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001f\u0010\u0012R\u0017\u0010\u000b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b \u0010\u0012¨\u0006!"}, d2 = {"Lp4/k;", "", "", "Lw4/c;", "toSave", "", "skippedAsDuplicate", "alreadyPresentById", "updatedById", "suppressedByUserStop", "suppressedBySendFailed", "suppressedByAuditBlock", "<init>", "(Ljava/util/List;IIIIII)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "e", "()Ljava/util/List;", "I", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "f", Const.INTENT_KEY_UMID, "c", "getSuppressedByAuditBlock", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: p4.k, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class ChannelHistoryMergePlan {
    private final int alreadyPresentById;
    private final int skippedAsDuplicate;
    private final int suppressedByAuditBlock;
    private final int suppressedBySendFailed;
    private final int suppressedByUserStop;
    private final List<ChatMessage> toSave;
    private final int updatedById;

    public ChannelHistoryMergePlan(List<ChatMessage> toSave, int i10, int i11, int i12, int i13, int i14, int i15) {
        p.i(toSave, "toSave");
        this.toSave = toSave;
        this.skippedAsDuplicate = i10;
        this.alreadyPresentById = i11;
        this.updatedById = i12;
        this.suppressedByUserStop = i13;
        this.suppressedBySendFailed = i14;
        this.suppressedByAuditBlock = i15;
    }

    /* renamed from: a, reason: from getter */
    public final int getAlreadyPresentById() {
        return this.alreadyPresentById;
    }

    /* renamed from: b, reason: from getter */
    public final int getSkippedAsDuplicate() {
        return this.skippedAsDuplicate;
    }

    /* renamed from: c, reason: from getter */
    public final int getSuppressedBySendFailed() {
        return this.suppressedBySendFailed;
    }

    /* renamed from: d, reason: from getter */
    public final int getSuppressedByUserStop() {
        return this.suppressedByUserStop;
    }

    public final List<ChatMessage> e() {
        return this.toSave;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelHistoryMergePlan)) {
            return false;
        }
        ChannelHistoryMergePlan channelHistoryMergePlan = (ChannelHistoryMergePlan) other;
        return p.d(this.toSave, channelHistoryMergePlan.toSave) && this.skippedAsDuplicate == channelHistoryMergePlan.skippedAsDuplicate && this.alreadyPresentById == channelHistoryMergePlan.alreadyPresentById && this.updatedById == channelHistoryMergePlan.updatedById && this.suppressedByUserStop == channelHistoryMergePlan.suppressedByUserStop && this.suppressedBySendFailed == channelHistoryMergePlan.suppressedBySendFailed && this.suppressedByAuditBlock == channelHistoryMergePlan.suppressedByAuditBlock;
    }

    /* renamed from: f, reason: from getter */
    public final int getUpdatedById() {
        return this.updatedById;
    }

    public int hashCode() {
        return (((((((((((this.toSave.hashCode() * 31) + Integer.hashCode(this.skippedAsDuplicate)) * 31) + Integer.hashCode(this.alreadyPresentById)) * 31) + Integer.hashCode(this.updatedById)) * 31) + Integer.hashCode(this.suppressedByUserStop)) * 31) + Integer.hashCode(this.suppressedBySendFailed)) * 31) + Integer.hashCode(this.suppressedByAuditBlock);
    }

    public String toString() {
        return "ChannelHistoryMergePlan(toSave=" + this.toSave + ", skippedAsDuplicate=" + this.skippedAsDuplicate + ", alreadyPresentById=" + this.alreadyPresentById + ", updatedById=" + this.updatedById + ", suppressedByUserStop=" + this.suppressedByUserStop + ", suppressedBySendFailed=" + this.suppressedBySendFailed + ", suppressedByAuditBlock=" + this.suppressedByAuditBlock + ")";
    }

    public /* synthetic */ ChannelHistoryMergePlan(List list, int i10, int i11, int i12, int i13, int i14, int i15, int i16, kotlin.jvm.internal.i iVar) {
        this(list, i10, i11, i12, (i16 & 16) != 0 ? 0 : i13, (i16 & 32) != 0 ? 0 : i14, (i16 & 64) != 0 ? 0 : i15);
    }
}
