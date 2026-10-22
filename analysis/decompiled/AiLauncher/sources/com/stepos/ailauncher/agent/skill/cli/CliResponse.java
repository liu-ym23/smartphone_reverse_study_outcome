package com.stepos.ailauncher.agent.skill.cli;

import com.autonavi.aps.amapapi.config.Const;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0007R\u001f\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/cli/CliResponse;", "Ljava/io/Serializable;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "total", "I", Const.INTENT_KEY_PKGNAME, "", "Lcom/stepos/ailauncher/agent/skill/cli/CliItem;", "clis", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CliResponse implements Serializable {
    private final List<CliItem> clis;
    private final int total;

    public final List<CliItem> a() {
        return this.clis;
    }

    /* renamed from: b, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CliResponse)) {
            return false;
        }
        CliResponse cliResponse = (CliResponse) other;
        return this.total == cliResponse.total && p.d(this.clis, cliResponse.clis);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.total) * 31;
        List<CliItem> list = this.clis;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "CliResponse(total=" + this.total + ", clis=" + this.clis + ")";
    }
}
