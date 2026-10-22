package com.android.ttcjpaysdk.kmp.base.http;

import com.alipay.sdk.m.p.e;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JU\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/http/CJRequest;", "", "url", "", e.f25671s, "Lcom/android/ttcjpaysdk/kmp/base/http/CJHttpMethod;", "headers", "", "queries", ContainerPosition.BODY, "<init>", "(Ljava/lang/String;Lcom/android/ttcjpaysdk/kmp/base/http/CJHttpMethod;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getMethod", "()Lcom/android/ttcjpaysdk/kmp/base/http/CJHttpMethod;", "getHeaders", "()Ljava/util/Map;", "getQueries", "getBody", "setBody", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJRequest {
    public static final int $stable = 8;
    private String body;
    private final Map<String, String> headers;
    private final CJHttpMethod method;
    private final Map<String, String> queries;
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CJRequest copy$default(CJRequest r100, String r101, CJHttpMethod r102, Map r103, Map r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.method;
    L8:
        CJHttpMethod r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.headers;
    L11:
        Map r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.queries;
    L14:
        Map r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.body;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.url;
    }

    public final CJHttpMethod component2() {
        return this.method;
    }

    public final Map<String, String> component3() {
        return this.headers;
    }

    public final Map<String, String> component4() {
        return this.queries;
    }

    public final String component5() {
        return this.body;
    }

    public final CJRequest copy(String r100, CJHttpMethod r101, Map<String, String> r110, Map<String, String> r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        Intrinsics.checkNotNullParameter(r110, "headers");
        Intrinsics.checkNotNullParameter(r111, "queries");
        return new CJRequest(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJRequest) == true) goto L8;
        return false;
    L8:
        CJRequest r101 = (CJRequest) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (this.method == r101.method) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.headers, r101.headers) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.queries, r101.queries) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.body, r101.body) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.url.hashCode() * 31) + this.method.hashCode()) * 31) + this.headers.hashCode()) * 31) + this.queries.hashCode()) * 31;
        String r101 = this.body;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "CJRequest(url=" + this.url + ", method=" + this.method + ", headers=" + this.headers + ", queries=" + this.queries + ", body=" + this.body + ')';
    }

    public final String getBody() {
        return this.body;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final CJHttpMethod getMethod() {
        return this.method;
    }

    public final Map<String, String> getQueries() {
        return this.queries;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setBody(String r100) {
        this.body = r100;
    }

    public CJRequest(String r100, CJHttpMethod r101, Map<String, String> r102, Map<String, String> r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        Intrinsics.checkNotNullParameter(r102, "headers");
        Intrinsics.checkNotNullParameter(r103, "queries");
        this.url = r100;
        this.method = r101;
        this.headers = r102;
        this.queries = r103;
        this.body = r104;
    }

    public /* synthetic */ CJRequest(String r100, CJHttpMethod r101, Map r102, Map r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 2) == 0) goto L5;
        r101 = CJHttpMethod.POST;
    L5:
        CJHttpMethod r103 = r101;
        if ((r112 & 4) == 0) goto L8;
        r102 = new LinkedHashMap();
    L8:
        Map r104 = r102;
        if ((r112 & 8) == 0) goto L11;
        r110 = new LinkedHashMap();
    L11:
        Map r105 = r110;
        if ((r112 & 16) == 0) goto L14;
        r111 = null;
    L14:
        this(r100, r103, r104, r105, r111);
    }
}
