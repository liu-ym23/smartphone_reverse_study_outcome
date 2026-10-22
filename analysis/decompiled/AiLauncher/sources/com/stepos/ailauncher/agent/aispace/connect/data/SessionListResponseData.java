package com.stepos.ailauncher.agent.aispace.connect.data;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\fR\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/B;", "", "", "Lcom/stepos/ailauncher/agent/aispace/connect/data/A;", DidiCardProvider.KEY_ITEMS, "", "nextCursor", "", "hasMore", "<init>", "(Ljava/util/List;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "Ljava/lang/String;", "c", "Z", Const.INTENT_KEY_APIKEY, "()Z", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.data.B, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SessionListResponseData {

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName(DidiCardProvider.KEY_ITEMS)
    private final List<SessionDto> items;

    @SerializedName("next_cursor")
    private final String nextCursor;

    public SessionListResponseData() {
        this(null, null, false, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<SessionDto> b() {
        return this.items;
    }

    /* renamed from: c, reason: from getter */
    public final String getNextCursor() {
        return this.nextCursor;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionListResponseData)) {
            return false;
        }
        SessionListResponseData sessionListResponseData = (SessionListResponseData) other;
        return kotlin.jvm.internal.p.d(this.items, sessionListResponseData.items) && kotlin.jvm.internal.p.d(this.nextCursor, sessionListResponseData.nextCursor) && this.hasMore == sessionListResponseData.hasMore;
    }

    public int hashCode() {
        int iHashCode = this.items.hashCode() * 31;
        String str = this.nextCursor;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.hasMore);
    }

    public String toString() {
        return "SessionListResponseData(items=" + this.items + ", nextCursor=" + this.nextCursor + ", hasMore=" + this.hasMore + ")";
    }

    public SessionListResponseData(List<SessionDto> items, String str, boolean z10) {
        kotlin.jvm.internal.p.i(items, "items");
        this.items = items;
        this.nextCursor = str;
        this.hasMore = z10;
    }

    public /* synthetic */ SessionListResponseData(List list, String str, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? C1173v.m() : list, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? false : z10);
    }
}
