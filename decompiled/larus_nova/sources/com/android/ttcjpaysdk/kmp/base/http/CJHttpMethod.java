package com.android.ttcjpaysdk.kmp.base.http;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/http/CJHttpMethod;", "", "<init>", "(Ljava/lang/String;I)V", "GET", "POST", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CJHttpMethod extends Enum<CJHttpMethod> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CJHttpMethod[] $VALUES = null;
    public static final CJHttpMethod GET = null;
    public static final CJHttpMethod POST = null;

    private static final /* synthetic */ CJHttpMethod[] $values() {
        return new CJHttpMethod[]{GET, POST};
    }

    public static EnumEntries<CJHttpMethod> getEntries() {
        return $ENTRIES;
    }

    static {
        GET = new CJHttpMethod("GET", 0);
        POST = new CJHttpMethod("POST", 1);
        CJHttpMethod[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static CJHttpMethod[] values() {
        return (CJHttpMethod[]) $VALUES.clone();
    }

    public static CJHttpMethod valueOf(String r100) {
        return (CJHttpMethod) r27.a.a(CJHttpMethod.class, r100);
    }

    private CJHttpMethod(String r100, int r101) {
        super(r100, r101);
    }
}
