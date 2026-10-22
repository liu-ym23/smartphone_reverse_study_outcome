package com.stepos.ailauncher.contract.model.search;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/contract/model/search/SearchMatchedField;", "", "<init>", "(Ljava/lang/String;I)V", "TITLE", "MESSAGE", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SearchMatchedField {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SearchMatchedField[] $VALUES;
    public static final SearchMatchedField TITLE = new SearchMatchedField("TITLE", 0);
    public static final SearchMatchedField MESSAGE = new SearchMatchedField("MESSAGE", 1);

    private static final /* synthetic */ SearchMatchedField[] $values() {
        return new SearchMatchedField[]{TITLE, MESSAGE};
    }

    static {
        SearchMatchedField[] searchMatchedFieldArr$values = $values();
        $VALUES = searchMatchedFieldArr$values;
        $ENTRIES = a.a(searchMatchedFieldArr$values);
    }

    private SearchMatchedField(String str, int i10) {
    }

    public static InterfaceC4149a<SearchMatchedField> getEntries() {
        return $ENTRIES;
    }

    public static SearchMatchedField valueOf(String str) {
        return (SearchMatchedField) Enum.valueOf(SearchMatchedField.class, str);
    }

    public static SearchMatchedField[] values() {
        return (SearchMatchedField[]) $VALUES.clone();
    }
}
