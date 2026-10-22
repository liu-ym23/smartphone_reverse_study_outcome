package com.obric.appstore.network.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\fJ6\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0007\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/appstore/network/entity/HttpResp;", "T", "", ServerElements.CODE, "", "msg", "", "data", "(ILjava/lang/String;Ljava/lang/Object;)V", "getCode", "()I", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(ILjava/lang/String;Ljava/lang/Object;)Lcom/obric/appstore/network/entity/HttpResp;", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HttpResp<T> {

    @SerializedName(ServerElements.CODE)
    private final int code;

    @SerializedName("data")
    @Nullable
    private final T data;

    @SerializedName("msg")
    @Nullable
    private final String msg;

    public HttpResp(int r10, @Nullable String r11, @Nullable T r12) {
        this.code = r10;
        this.msg = r11;
        this.data = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HttpResp copy$default(HttpResp r10, int r11, String r12, Object r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.code;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.msg;
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
        return this.msg;
    }

    @Nullable
    public final T component3() {
        return this.data;
    }

    @NotNull
    public final HttpResp<T> copy(int r10, @Nullable String r11, @Nullable T r12) {
        return new HttpResp(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof HttpResp) == true) goto L8;
        return false;
    L8:
        HttpResp r11 = (HttpResp) r10;
        if (this.code == r11.code) goto L12;
        return false;
    L12:
        if (q.b(this.msg, r11.msg) == true) goto L15;
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
    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        int r10 = Integer.hashCode(this.code) * 31;
        String r11 = this.msg;
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

    @NotNull
    public String toString() {
        return "HttpResp(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
    }
}
