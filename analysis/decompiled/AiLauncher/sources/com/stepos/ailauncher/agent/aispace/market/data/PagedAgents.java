package com.stepos.ailauncher.agent.aispace.market.data;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.aispace.market.AgentMarketItem;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/z;", "", "", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", DidiCardProvider.KEY_ITEMS, "", "total", "<init>", "(Ljava/util/List;I)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "I", Const.INTENT_KEY_PKGNAME, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.data.z, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class PagedAgents {
    private final List<AgentMarketItem> items;
    private final int total;

    public PagedAgents(List<AgentMarketItem> items, int i10) {
        kotlin.jvm.internal.p.i(items, "items");
        this.items = items;
        this.total = i10;
    }

    public final List<AgentMarketItem> a() {
        return this.items;
    }

    /* renamed from: b, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PagedAgents)) {
            return false;
        }
        PagedAgents pagedAgents = (PagedAgents) other;
        return kotlin.jvm.internal.p.d(this.items, pagedAgents.items) && this.total == pagedAgents.total;
    }

    public int hashCode() {
        return (this.items.hashCode() * 31) + Integer.hashCode(this.total);
    }

    public String toString() {
        return "PagedAgents(items=" + this.items + ", total=" + this.total + ")";
    }
}
