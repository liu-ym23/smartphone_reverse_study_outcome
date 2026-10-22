package com.android.ttcjpaysdk.kmp.base.http;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/http/CJResponse;", "", "code", "", "msg", "", ContainerPosition.BODY, "headers", "", "Lcom/android/ttcjpaysdk/kmp/base/http/CJHeader;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getBody", "getHeaders", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJResponse {
    public static final int $stable = 8;
    private final String body;
    private final int code;
    private final List<CJHeader> headers;
    private final String msg;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CJResponse copy$default(CJResponse r100, int r101, String r102, String r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.msg;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.body;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.headers;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final String component3() {
        return this.body;
    }

    public final List<CJHeader> component4() {
        return this.headers;
    }

    public final CJResponse copy(int r100, String r101, String r102, List<CJHeader> r103) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r103, "headers");
        return new CJResponse(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJResponse) == true) goto L8;
        return false;
    L8:
        CJResponse r101 = (CJResponse) r100;
        if (this.code == r101.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.body, r101.body) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.headers, r101.headers) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.code * 31) + this.msg.hashCode()) * 31) + this.body.hashCode()) * 31) + this.headers.hashCode();
    }

    public String toString() {
        return "CJResponse(code=" + this.code + ", msg=" + this.msg + ", body=" + this.body + ", headers=" + this.headers + ')';
    }

    public final String getBody() {
        return this.body;
    }

    public final int getCode() {
        return this.code;
    }

    public final List<CJHeader> getHeaders() {
        return this.headers;
    }

    public final String getMsg() {
        return this.msg;
    }

    public CJResponse(int r100, String r101, String r102, List<CJHeader> r103) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r103, "headers");
        this.code = r100;
        this.msg = r101;
        this.body = r102;
        this.headers = r103;
    }

    public /* synthetic */ CJResponse(int r100, String r101, String r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = "";
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = new ArrayList();
    L11:
        this(r100, r101, r102, r103);
    }
}
