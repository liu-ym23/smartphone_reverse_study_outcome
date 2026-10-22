package com.stepos.ailauncher.contract.model.search;

import Z8.C1173v;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/contract/model/search/UnifiedSearchResult;", "", "sessions", "", "Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;", "tasks", "Lcom/stepos/ailauncher/contract/model/search/TaskSearchHit;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getSessions", "()Ljava/util/List;", "getTasks", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UnifiedSearchResult {
    private final List<SessionSearchHit> sessions;
    private final List<TaskSearchHit> tasks;

    /* JADX WARN: Multi-variable type inference failed */
    public UnifiedSearchResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UnifiedSearchResult copy$default(UnifiedSearchResult unifiedSearchResult, List list, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = unifiedSearchResult.sessions;
        }
        if ((i10 & 2) != 0) {
            list2 = unifiedSearchResult.tasks;
        }
        return unifiedSearchResult.copy(list, list2);
    }

    public final List<SessionSearchHit> component1() {
        return this.sessions;
    }

    public final List<TaskSearchHit> component2() {
        return this.tasks;
    }

    public final UnifiedSearchResult copy(List<SessionSearchHit> sessions, List<TaskSearchHit> tasks) {
        p.i(sessions, "sessions");
        p.i(tasks, "tasks");
        return new UnifiedSearchResult(sessions, tasks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnifiedSearchResult)) {
            return false;
        }
        UnifiedSearchResult unifiedSearchResult = (UnifiedSearchResult) other;
        return p.d(this.sessions, unifiedSearchResult.sessions) && p.d(this.tasks, unifiedSearchResult.tasks);
    }

    public final List<SessionSearchHit> getSessions() {
        return this.sessions;
    }

    public final List<TaskSearchHit> getTasks() {
        return this.tasks;
    }

    public int hashCode() {
        return (this.sessions.hashCode() * 31) + this.tasks.hashCode();
    }

    public String toString() {
        return "UnifiedSearchResult(sessions=" + this.sessions + ", tasks=" + this.tasks + ")";
    }

    public UnifiedSearchResult(List<SessionSearchHit> sessions, List<TaskSearchHit> tasks) {
        p.i(sessions, "sessions");
        p.i(tasks, "tasks");
        this.sessions = sessions;
        this.tasks = tasks;
    }

    public /* synthetic */ UnifiedSearchResult(List list, List list2, int i10, i iVar) {
        this((i10 & 1) != 0 ? C1173v.m() : list, (i10 & 2) != 0 ? C1173v.m() : list2);
    }
}
