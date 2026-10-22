package com.obric.capabilitykit.entity.utils;

import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/obric/capabilitykit/entity/utils/IndexResult;", "", ServerElements.CODE, "", "message", "", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IndexResult {
    private final int code;

    @NotNull
    private final String message;

    public IndexResult(int r10, @NotNull String r11) {
        q.g(r11, "message");
        this.code = r10;
        this.message = r11;
    }

    public static /* synthetic */ IndexResult copy$default(IndexResult r10, int r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.code;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.message;
    L9:
        return r10.copy(r11, r12);
    }

    public final int component1() {
        return this.code;
    }

    @NotNull
    public final String component2() {
        return this.message;
    }

    @NotNull
    public final IndexResult copy(int r10, @NotNull String r11) {
        q.g(r11, "message");
        return new IndexResult(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof IndexResult) == true) goto L8;
        return false;
    L8:
        IndexResult r11 = (IndexResult) r10;
        if (this.code == r11.code) goto L12;
        return false;
    L12:
        if (q.b(this.message, r11.message) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (Integer.hashCode(this.code) * 31) + this.message.hashCode();
    }

    @NotNull
    public String toString() {
        return "IndexResult(code=" + this.code + ", message=" + this.message + ')';
    }
}
