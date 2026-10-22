package com.stepos.ailauncher.agent.skill.essential;

import Z8.C1173v;
import c5.x;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0092\u0001\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u0003\u0010\u001fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b \u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b!\u0010\u001fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\"\u001a\u0004\b$\u0010\u0018R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b%\u0010\u001fR\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010)\u001a\u0004\b*\u0010\u001aR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b+\u0010\u001fR\u0017\u0010\u0010\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0010\u0010)\u001a\u0004\b,\u0010\u001aR\u0017\u0010\u0011\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b-\u0010\u001aR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b.\u0010\u0018¨\u0006/"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/essential/k;", "", "", "isLoading", "isRefreshing", "isLoadingMore", "", "error", "searchQuery", "isSearching", "", "Lc5/x;", "entries", "", "page", "hasMore", "loadedCount", "totalCount", "transientToastMessage", "<init>", "(ZZZLjava/lang/String;Ljava/lang/String;ZLjava/util/List;IZIILjava/lang/String;)V", Const.INTENT_KEY_APIKEY, "(ZZZLjava/lang/String;Ljava/lang/String;ZLjava/util/List;IZIILjava/lang/String;)Lcom/stepos/ailauncher/agent/skill/essential/k;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Ljava/lang/String;", "getError", Const.INTENT_KEY_BACKGROUND_COMMAND, "l", "Ljava/util/List;", "c", "()Ljava/util/List;", "I", "f", Const.INTENT_KEY_UMID, "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.skill.essential.k, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SkillEssentialUiState {
    private final List<x> entries;
    private final String error;
    private final boolean hasMore;
    private final boolean isLoading;
    private final boolean isLoadingMore;
    private final boolean isRefreshing;
    private final boolean isSearching;
    private final int loadedCount;
    private final int page;
    private final String searchQuery;
    private final int totalCount;
    private final String transientToastMessage;

    public SkillEssentialUiState() {
        this(false, false, false, null, null, false, null, 0, false, 0, 0, null, 4095, null);
    }

    public static /* synthetic */ SkillEssentialUiState b(SkillEssentialUiState skillEssentialUiState, boolean z10, boolean z11, boolean z12, String str, String str2, boolean z13, List list, int i10, boolean z14, int i11, int i12, String str3, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            z10 = skillEssentialUiState.isLoading;
        }
        if ((i13 & 2) != 0) {
            z11 = skillEssentialUiState.isRefreshing;
        }
        if ((i13 & 4) != 0) {
            z12 = skillEssentialUiState.isLoadingMore;
        }
        if ((i13 & 8) != 0) {
            str = skillEssentialUiState.error;
        }
        if ((i13 & 16) != 0) {
            str2 = skillEssentialUiState.searchQuery;
        }
        if ((i13 & 32) != 0) {
            z13 = skillEssentialUiState.isSearching;
        }
        if ((i13 & 64) != 0) {
            list = skillEssentialUiState.entries;
        }
        if ((i13 & 128) != 0) {
            i10 = skillEssentialUiState.page;
        }
        if ((i13 & 256) != 0) {
            z14 = skillEssentialUiState.hasMore;
        }
        if ((i13 & 512) != 0) {
            i11 = skillEssentialUiState.loadedCount;
        }
        if ((i13 & 1024) != 0) {
            i12 = skillEssentialUiState.totalCount;
        }
        if ((i13 & 2048) != 0) {
            str3 = skillEssentialUiState.transientToastMessage;
        }
        int i14 = i12;
        String str4 = str3;
        boolean z15 = z14;
        int i15 = i11;
        List list2 = list;
        int i16 = i10;
        String str5 = str2;
        boolean z16 = z13;
        return skillEssentialUiState.a(z10, z11, z12, str, str5, z16, list2, i16, z15, i15, i14, str4);
    }

    public final SkillEssentialUiState a(boolean isLoading, boolean isRefreshing, boolean isLoadingMore, String error, String searchQuery, boolean isSearching, List<? extends x> entries, int page, boolean hasMore, int loadedCount, int totalCount, String transientToastMessage) {
        p.i(searchQuery, "searchQuery");
        p.i(entries, "entries");
        return new SkillEssentialUiState(isLoading, isRefreshing, isLoadingMore, error, searchQuery, isSearching, entries, page, hasMore, loadedCount, totalCount, transientToastMessage);
    }

    public final List<x> c() {
        return this.entries;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    /* renamed from: e, reason: from getter */
    public final int getLoadedCount() {
        return this.loadedCount;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillEssentialUiState)) {
            return false;
        }
        SkillEssentialUiState skillEssentialUiState = (SkillEssentialUiState) other;
        return this.isLoading == skillEssentialUiState.isLoading && this.isRefreshing == skillEssentialUiState.isRefreshing && this.isLoadingMore == skillEssentialUiState.isLoadingMore && p.d(this.error, skillEssentialUiState.error) && p.d(this.searchQuery, skillEssentialUiState.searchQuery) && this.isSearching == skillEssentialUiState.isSearching && p.d(this.entries, skillEssentialUiState.entries) && this.page == skillEssentialUiState.page && this.hasMore == skillEssentialUiState.hasMore && this.loadedCount == skillEssentialUiState.loadedCount && this.totalCount == skillEssentialUiState.totalCount && p.d(this.transientToastMessage, skillEssentialUiState.transientToastMessage);
    }

    /* renamed from: f, reason: from getter */
    public final int getPage() {
        return this.page;
    }

    /* renamed from: g, reason: from getter */
    public final String getSearchQuery() {
        return this.searchQuery;
    }

    /* renamed from: h, reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    public int hashCode() {
        int iHashCode = ((((Boolean.hashCode(this.isLoading) * 31) + Boolean.hashCode(this.isRefreshing)) * 31) + Boolean.hashCode(this.isLoadingMore)) * 31;
        String str = this.error;
        int iHashCode2 = (((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.searchQuery.hashCode()) * 31) + Boolean.hashCode(this.isSearching)) * 31) + this.entries.hashCode()) * 31) + Integer.hashCode(this.page)) * 31) + Boolean.hashCode(this.hasMore)) * 31) + Integer.hashCode(this.loadedCount)) * 31) + Integer.hashCode(this.totalCount)) * 31;
        String str2 = this.transientToastMessage;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getTransientToastMessage() {
        return this.transientToastMessage;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsLoadingMore() {
        return this.isLoadingMore;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsRefreshing() {
        return this.isRefreshing;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsSearching() {
        return this.isSearching;
    }

    public String toString() {
        return "SkillEssentialUiState(isLoading=" + this.isLoading + ", isRefreshing=" + this.isRefreshing + ", isLoadingMore=" + this.isLoadingMore + ", error=" + this.error + ", searchQuery=" + this.searchQuery + ", isSearching=" + this.isSearching + ", entries=" + this.entries + ", page=" + this.page + ", hasMore=" + this.hasMore + ", loadedCount=" + this.loadedCount + ", totalCount=" + this.totalCount + ", transientToastMessage=" + this.transientToastMessage + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SkillEssentialUiState(boolean z10, boolean z11, boolean z12, String str, String searchQuery, boolean z13, List<? extends x> entries, int i10, boolean z14, int i11, int i12, String str2) {
        p.i(searchQuery, "searchQuery");
        p.i(entries, "entries");
        this.isLoading = z10;
        this.isRefreshing = z11;
        this.isLoadingMore = z12;
        this.error = str;
        this.searchQuery = searchQuery;
        this.isSearching = z13;
        this.entries = entries;
        this.page = i10;
        this.hasMore = z14;
        this.loadedCount = i11;
        this.totalCount = i12;
        this.transientToastMessage = str2;
    }

    public /* synthetic */ SkillEssentialUiState(boolean z10, boolean z11, boolean z12, String str, String str2, boolean z13, List list, int i10, boolean z14, int i11, int i12, String str3, int i13, kotlin.jvm.internal.i iVar) {
        this((i13 & 1) != 0 ? false : z10, (i13 & 2) != 0 ? false : z11, (i13 & 4) != 0 ? false : z12, (i13 & 8) != 0 ? null : str, (i13 & 16) != 0 ? "" : str2, (i13 & 32) != 0 ? false : z13, (i13 & 64) != 0 ? C1173v.m() : list, (i13 & 128) != 0 ? 0 : i10, (i13 & 256) != 0 ? true : z14, (i13 & 512) != 0 ? 0 : i11, (i13 & 1024) == 0 ? i12 : 0, (i13 & 2048) != 0 ? null : str3);
    }
}
