package com.android.ttcjpaysdk.kmp.base.util;

import com.bytedance.kmp.network.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.i;
import ouc.k;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bJ\u001a\u0010\f\u001a\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u000bJ\u001a\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u0011\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/util/UrlUtils;", "", "<init>", "()V", "queryList", "", "", "getQueryList", "()Ljava/util/List;", "appendStringQueryParameters", "queryMap", "", "appendJsonQueryParameters", "Lkotlinx/serialization/json/JsonElement;", "appendStringQueryParameter", "key", "value", "appendJsonQueryParameter", "build", "uri", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlUtils {
    public static final int $stable = 8;
    private final List<String> queryList;

    public UrlUtils() {
        this.queryList = new ArrayList();
    }

    public final List<String> getQueryList() {
        return this.queryList;
    }

    public final UrlUtils appendJsonQueryParameters(Map<String, ? extends i> r100) {
        Intrinsics.checkNotNullParameter(r100, "queryMap");
        Iterator<Map.Entry<String, ? extends i>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, ? extends i> r102 = r101.next();
        appendJsonQueryParameter(r102.getKey(), r102.getValue());
        goto L4
    L6:
        return this;
    }

    public final UrlUtils appendStringQueryParameters(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "queryMap");
        Iterator<Map.Entry<String, String>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, String> r102 = r101.next();
        appendStringQueryParameter(r102.getKey(), r102.getValue());
        goto L4
    L6:
        return this;
    }

    public final String build(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        StringBuilder r101 = new StringBuilder(r100);
        Iterator<T> r102 = this.queryList.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L16;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        String r106 = (String) r104;
        if (r103 == 0) goto L11;
    L13:
        r101.append("&");
    L14:
        r101.append(r106);
        r103 = r105;
        goto L4
    L11:
        if (StringsKt.contains$default(r100, "?", false, 2, null) == true) goto L13;
        r101.append("?");
        goto L14
    L16:
        return r101.toString();
    }

    public final UrlUtils appendJsonQueryParameter(String r100, i r101) {
        if (r100 == null) goto L9;
        if (r101 == null) goto L9;
        StringBuilder r102 = new StringBuilder();
        r102.append(f.b(r100));
        r102.append(com.alipay.sdk.m.n.a.f25612h);
        String r103 = k.o(r101).a();
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r102.append(f.b(r103));
        String r104 = r102.toString();
        this.queryList.add(r104);
    L9:
        return this;
    }

    public final UrlUtils appendStringQueryParameter(String r100, String r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        this.queryList.add(f.b(r100) + com.alipay.sdk.m.n.a.f25612h + f.b(r101));
    L6:
        return this;
    }
}
