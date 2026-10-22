package com.bytedance.android.livesdkapi.minigame;

import com.bytedance.android.ec.core.event.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/minigame/StreamErrorExtra;", "Ljava/io/Serializable;", "errorCode", "", a.KEY_EXCEPTION, "Ljava/lang/Exception;", "Lkotlin/Exception;", "(ILjava/lang/Exception;)V", "getErrorCode", "()I", "getException", "()Ljava/lang/Exception;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StreamErrorExtra implements Serializable {
    private final int errorCode;
    private final Exception exception;

    /* JADX WARN: Multi-variable type inference failed */
    public StreamErrorExtra() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ StreamErrorExtra copy$default(StreamErrorExtra r100, int r101, Exception r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.errorCode;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.exception;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.errorCode;
    }

    public final Exception component2() {
        return this.exception;
    }

    public final StreamErrorExtra copy(int r100, Exception r101) {
        return new StreamErrorExtra(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof StreamErrorExtra) == false) goto L10;
        StreamErrorExtra r101 = (StreamErrorExtra) r100;
        if (this.errorCode == r101.errorCode) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.exception, r101.exception) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        int r100 = this.errorCode * 31;
        Exception r101 = this.exception;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "StreamErrorExtra(errorCode=" + this.errorCode + ", exception=" + this.exception + ")";
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final Exception getException() {
        return this.exception;
    }

    public StreamErrorExtra(int r100, Exception r101) {
        this.errorCode = r100;
        this.exception = r101;
    }

    public /* synthetic */ StreamErrorExtra(int r100, Exception r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
