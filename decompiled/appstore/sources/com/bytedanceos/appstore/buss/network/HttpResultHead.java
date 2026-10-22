package com.bytedanceos.appstore.buss.network;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\fJ0\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedanceos/appstore/buss/network/HttpResultHead;", "", ServerElements.CODE, "", "message", "", ServerElements.HAS_MORE, "", "(ILjava/lang/String;Ljava/lang/Boolean;)V", "getCode", "()I", "getHas_more", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(ILjava/lang/String;Ljava/lang/Boolean;)Lcom/bytedanceos/appstore/buss/network/HttpResultHead;", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HttpResultHead {
    private final int code;

    @Nullable
    private final Boolean has_more;

    @Nullable
    private final String message;

    public HttpResultHead(int r10, @Nullable String r11, @Nullable Boolean r12) {
        this.code = r10;
        this.message = r11;
        this.has_more = r12;
    }

    public static /* synthetic */ HttpResultHead copy$default(HttpResultHead r10, int r11, String r12, Boolean r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.code;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.message;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.has_more;
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
    public final Boolean component3() {
        return this.has_more;
    }

    @NotNull
    public final HttpResultHead copy(int r10, @Nullable String r11, @Nullable Boolean r12) {
        return new HttpResultHead(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof HttpResultHead) == true) goto L8;
        return false;
    L8:
        HttpResultHead r11 = (HttpResultHead) r10;
        if (this.code == r11.code) goto L12;
        return false;
    L12:
        if (q.b(this.message, r11.message) == true) goto L15;
        return false;
    L15:
        if (q.b(this.has_more, r11.has_more) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final Boolean getHas_more() {
        return this.has_more;
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
        Boolean r15 = this.has_more;
        if (r15 == null) goto L11;
        r12 = r15.hashCode();
    L11:
        return r14 + r12;
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    @NotNull
    public String toString() {
        return "HttpResultHead(code=" + this.code + ", message=" + this.message + ", has_more=" + this.has_more + ')';
    }
}
