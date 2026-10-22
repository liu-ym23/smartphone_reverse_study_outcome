package com.stepos.datacenter.api;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/datacenter/api/SearchStyle;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO", "KEYWORD", "SEMANTIC", "HYBRID", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SearchStyle {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SearchStyle[] $VALUES;
    public static final SearchStyle AUTO = new SearchStyle("AUTO", 0);
    public static final SearchStyle KEYWORD = new SearchStyle("KEYWORD", 1);
    public static final SearchStyle SEMANTIC = new SearchStyle("SEMANTIC", 2);
    public static final SearchStyle HYBRID = new SearchStyle("HYBRID", 3);

    private static final /* synthetic */ SearchStyle[] $values() {
        return new SearchStyle[]{AUTO, KEYWORD, SEMANTIC, HYBRID};
    }

    static {
        SearchStyle[] searchStyleArr$values = $values();
        $VALUES = searchStyleArr$values;
        $ENTRIES = kotlin.enums.a.a(searchStyleArr$values);
    }

    private SearchStyle(String str, int i10) {
    }

    public static InterfaceC4149a<SearchStyle> getEntries() {
        return $ENTRIES;
    }

    public static SearchStyle valueOf(String str) {
        return (SearchStyle) Enum.valueOf(SearchStyle.class, str);
    }

    public static SearchStyle[] values() {
        return (SearchStyle[]) $VALUES.clone();
    }
}
