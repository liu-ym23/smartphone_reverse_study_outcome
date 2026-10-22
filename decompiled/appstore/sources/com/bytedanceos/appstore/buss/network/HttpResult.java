package com.bytedanceos.appstore.buss.network;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\bJ*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedanceos/appstore/buss/network/HttpResult;", "T", "", ServerElements.HEAD, "Lcom/bytedanceos/appstore/buss/network/HttpResultHead;", ServerElements.BODY, "(Lcom/bytedanceos/appstore/buss/network/HttpResultHead;Ljava/lang/Object;)V", "getBody", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getHead", "()Lcom/bytedanceos/appstore/buss/network/HttpResultHead;", "component1", "component2", "copy", "(Lcom/bytedanceos/appstore/buss/network/HttpResultHead;Ljava/lang/Object;)Lcom/bytedanceos/appstore/buss/network/HttpResult;", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HttpResult<T> {

    @Nullable
    private final T body;

    @NotNull
    private final HttpResultHead head;

    public HttpResult(@NotNull HttpResultHead r10, @Nullable T r11) {
        q.g(r10, ServerElements.HEAD);
        this.head = r10;
        this.body = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HttpResult copy$default(HttpResult r10, HttpResultHead r11, Object r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.head;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.body;
    L9:
        return r10.copy(r11, r12);
    }

    @NotNull
    public final HttpResultHead component1() {
        return this.head;
    }

    @Nullable
    public final T component2() {
        return this.body;
    }

    @NotNull
    public final HttpResult<T> copy(@NotNull HttpResultHead r10, @Nullable T r11) {
        q.g(r10, ServerElements.HEAD);
        return new HttpResult(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof HttpResult) == true) goto L8;
        return false;
    L8:
        HttpResult r11 = (HttpResult) r10;
        if (q.b(this.head, r11.head) == true) goto L12;
        return false;
    L12:
        if (q.b(this.body, r11.body) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final T getBody() {
        return this.body;
    }

    @NotNull
    public final HttpResultHead getHead() {
        return this.head;
    }

    public int hashCode() {
        int r10 = this.head.hashCode() * 31;
        T r11 = this.body;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    @NotNull
    public String toString() {
        return "HttpResult(head=" + this.head + ", body=" + this.body + ')';
    }
}
