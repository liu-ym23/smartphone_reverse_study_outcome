package com.obric.capabilitykit.search;

import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\bJ\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000eJ6\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/search/Response;", "T", "", ServerElements.CODE, "", "message", "", "data", "(ILjava/lang/String;Ljava/lang/Object;)V", "getCode", "()I", "setCode", "(I)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "(ILjava/lang/String;Ljava/lang/Object;)Lcom/obric/capabilitykit/search/Response;", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Response<T> {
    private int code;

    @Nullable
    private T data;

    @Nullable
    private String message;

    public Response() {
        int r10 = 0;
        String r11 = null;
        Object r12 = null;
        this(r10, r11, r12, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Response copy$default(Response r10, int r11, String r12, Object r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.code;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.message;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.data;
    L12:
        return r10.copy(r11, r12, r13);
    }

    public final int component1() {
        return this.code;
    }

    @Nullable
    public final String component2() {
        return this.message;
    }

    @Nullable
    public final T component3() {
        return this.data;
    }

    @NotNull
    public final Response<T> copy(int r10, @Nullable String r11, @Nullable T r12) {
        return new Response(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Response) == true) goto L8;
        return false;
    L8:
        Response r11 = (Response) r10;
        if (this.code == r11.code) goto L12;
        return false;
    L12:
        if (q.b(this.message, r11.message) == true) goto L15;
        return false;
    L15:
        if (q.b(this.data, r11.data) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final T getData() {
        return this.data;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int r10 = Integer.hashCode(this.code) * 31;
        String r11 = this.message;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        T r15 = this.data;
        if (r15 == null) goto L11;
        r12 = r15.hashCode();
    L11:
        return r14 + r12;
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public final void setCode(int r10) {
        this.code = r10;
    }

    public final void setData(@Nullable T r10) {
        this.data = r10;
    }

    public final void setMessage(@Nullable String r10) {
        this.message = r10;
    }

    @NotNull
    public String toString() {
        return "Response(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }

    public Response(int r10, @Nullable String r11, @Nullable T r12) {
        this.code = r10;
        this.message = r11;
        this.data = r12;
    }

    public /* synthetic */ Response(int r10, String r11, Object r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
