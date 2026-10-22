package com.stepos.ailauncher.contract.model.search;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/contract/model/search/SearchTaskStatus;", "", "<init>", "(Ljava/lang/String;I)V", "WAITING_FOR_USER", "RUNNING", "COMPLETED", "FAILED", "CANCELLED", "OTHER", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SearchTaskStatus {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SearchTaskStatus[] $VALUES;
    public static final SearchTaskStatus WAITING_FOR_USER = new SearchTaskStatus("WAITING_FOR_USER", 0);
    public static final SearchTaskStatus RUNNING = new SearchTaskStatus("RUNNING", 1);
    public static final SearchTaskStatus COMPLETED = new SearchTaskStatus("COMPLETED", 2);
    public static final SearchTaskStatus FAILED = new SearchTaskStatus("FAILED", 3);
    public static final SearchTaskStatus CANCELLED = new SearchTaskStatus("CANCELLED", 4);
    public static final SearchTaskStatus OTHER = new SearchTaskStatus("OTHER", 5);

    private static final /* synthetic */ SearchTaskStatus[] $values() {
        return new SearchTaskStatus[]{WAITING_FOR_USER, RUNNING, COMPLETED, FAILED, CANCELLED, OTHER};
    }

    static {
        SearchTaskStatus[] searchTaskStatusArr$values = $values();
        $VALUES = searchTaskStatusArr$values;
        $ENTRIES = a.a(searchTaskStatusArr$values);
    }

    private SearchTaskStatus(String str, int i10) {
    }

    public static InterfaceC4149a<SearchTaskStatus> getEntries() {
        return $ENTRIES;
    }

    public static SearchTaskStatus valueOf(String str) {
        return (SearchTaskStatus) Enum.valueOf(SearchTaskStatus.class, str);
    }

    public static SearchTaskStatus[] values() {
        return (SearchTaskStatus[]) $VALUES.clone();
    }
}
