package com.android.ttcjpaysdk.base.service.bean;

import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¨\u0006\u0007"}, d2 = {"toStringList", "", "Lorg/json/JSONArray;", "list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "base-context_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ReuseHostDomainKt {
    public static final void toStringList(JSONArray r100, ArrayList<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "list");
        int r102 = r100.length();     // Catch: Exception -> L7
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L13;
        r101.add(r100.optString(r103));     // Catch: Exception -> L7
        r103 = r103 + 1;
        goto L4
    L13:
        return;
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("ReuseHostDomain#fromJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "ReuseHostDomain#fromJson", e);
        e.printStackTrace();
    }
}
