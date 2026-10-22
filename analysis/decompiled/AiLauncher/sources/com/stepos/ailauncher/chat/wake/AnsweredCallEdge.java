package com.stepos.ailauncher.chat.wake;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/i;", "", "", "abort", "seenNotAnswered", "<init>", "(ZZ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", Const.INTENT_KEY_APIKEY, "()Z", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.wake.i, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class AnsweredCallEdge {
    private final boolean abort;
    private final boolean seenNotAnswered;

    public AnsweredCallEdge(boolean z10, boolean z11) {
        this.abort = z10;
        this.seenNotAnswered = z11;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAbort() {
        return this.abort;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getSeenNotAnswered() {
        return this.seenNotAnswered;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnsweredCallEdge)) {
            return false;
        }
        AnsweredCallEdge answeredCallEdge = (AnsweredCallEdge) other;
        return this.abort == answeredCallEdge.abort && this.seenNotAnswered == answeredCallEdge.seenNotAnswered;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.abort) * 31) + Boolean.hashCode(this.seenNotAnswered);
    }

    public String toString() {
        return "AnsweredCallEdge(abort=" + this.abort + ", seenNotAnswered=" + this.seenNotAnswered + ")";
    }
}
