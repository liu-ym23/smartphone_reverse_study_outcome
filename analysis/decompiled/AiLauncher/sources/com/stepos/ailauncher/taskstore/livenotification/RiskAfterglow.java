package com.stepos.ailauncher.taskstore.livenotification;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/n;", "", "", "title", "", "startedAt", "<init>", "(Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "J", Const.INTENT_KEY_APIKEY, "()J", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.livenotification.n, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class RiskAfterglow {
    private final long startedAt;
    private final String title;

    public RiskAfterglow(String title, long j10) {
        kotlin.jvm.internal.p.i(title, "title");
        this.title = title;
        this.startedAt = j10;
    }

    /* renamed from: a, reason: from getter */
    public final long getStartedAt() {
        return this.startedAt;
    }

    /* renamed from: b, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RiskAfterglow)) {
            return false;
        }
        RiskAfterglow riskAfterglow = (RiskAfterglow) other;
        return kotlin.jvm.internal.p.d(this.title, riskAfterglow.title) && this.startedAt == riskAfterglow.startedAt;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + Long.hashCode(this.startedAt);
    }

    public String toString() {
        return "RiskAfterglow(title=" + this.title + ", startedAt=" + this.startedAt + ")";
    }
}
