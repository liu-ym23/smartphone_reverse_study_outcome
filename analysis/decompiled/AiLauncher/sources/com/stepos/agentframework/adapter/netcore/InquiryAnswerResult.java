package com.stepos.agentframework.adapter.netcore;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.provider.c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/q;", "", "", "ok", "", c.a.COL_SUMMARY, "<init>", "(ZLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", Const.INTENT_KEY_APIKEY, "()Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.netcore.q, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class InquiryAnswerResult {
    private final boolean ok;
    private final String summary;

    public InquiryAnswerResult(boolean z10, String str) {
        this.ok = z10;
        this.summary = str;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getOk() {
        return this.ok;
    }

    /* renamed from: b, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InquiryAnswerResult)) {
            return false;
        }
        InquiryAnswerResult inquiryAnswerResult = (InquiryAnswerResult) other;
        return this.ok == inquiryAnswerResult.ok && kotlin.jvm.internal.p.d(this.summary, inquiryAnswerResult.summary);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.ok) * 31;
        String str = this.summary;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "InquiryAnswerResult(ok=" + this.ok + ", summary=" + this.summary + ")";
    }

    public /* synthetic */ InquiryAnswerResult(boolean z10, String str, int i10, kotlin.jvm.internal.i iVar) {
        this(z10, (i10 & 2) != 0 ? null : str);
    }
}
