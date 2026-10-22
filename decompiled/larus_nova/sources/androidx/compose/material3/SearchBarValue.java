package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/material3/SearchBarValue;", "", "<init>", "(Ljava/lang/String;I)V", "Collapsed", "Expanded", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SearchBarValue extends Enum<SearchBarValue> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SearchBarValue[] $VALUES = null;
    public static final SearchBarValue Collapsed = null;
    public static final SearchBarValue Expanded = null;

    private static final /* synthetic */ SearchBarValue[] $values() {
        return new SearchBarValue[]{Collapsed, Expanded};
    }

    public static EnumEntries<SearchBarValue> getEntries() {
        return $ENTRIES;
    }

    static {
        Collapsed = new SearchBarValue("Collapsed", 0);
        Expanded = new SearchBarValue("Expanded", 1);
        SearchBarValue[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static SearchBarValue[] values() {
        return (SearchBarValue[]) $VALUES.clone();
    }

    public static SearchBarValue valueOf(String r100) {
        return (SearchBarValue) r27.a.a(SearchBarValue.class, r100);
    }

    private SearchBarValue(String r100, int r101) {
        super(r100, r101);
    }
}
