package com.android.ttcjpaysdk.integrated.counter.component.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/utils/PayComponentUtils;", "", "()V", "standardAmount", "", "amount", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayComponentUtils {
    public static final PayComponentUtils INSTANCE = null;

    static {
        INSTANCE = new PayComponentUtils();
    }

    private PayComponentUtils() {
    }

    public final String standardAmount(String r100) {
        Intrinsics.checkNotNullParameter(r100, "amount");
        List r101 = StringsKt.split$default(r100, new String[]{"."}, false, 0, 6, null);
        if (r101.size() != 2) goto L20;
        CharSequence r102 = (CharSequence) CollectionsKt.last(r101);
        int r103 = 0;
    L6:
        if (r103 >= r102.length()) goto L17;
        char r104 = r102.charAt(r103);
        if ('1' <= r104) goto L10;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == true) goto L14;
        r103 = r103 + 1;
        goto L6
    L14:
        return r100;
    L10:
        if (r104 >= ':') goto L12;
        r105 = true;
        goto L13
    L17:
        return (String) CollectionsKt.first(r101);
    L20:
        return r100;
    }
}
