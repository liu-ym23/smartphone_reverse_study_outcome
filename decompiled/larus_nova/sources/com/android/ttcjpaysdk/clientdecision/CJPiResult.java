package com.android.ttcjpaysdk.clientdecision;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/clientdecision/CJPiResult;", "", "success", "", "data", "Lorg/json/JSONObject;", "(ZLorg/json/JSONObject;)V", "getData", "()Lorg/json/JSONObject;", "getSuccess", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPiResult {
    private final JSONObject data;
    private final boolean success;

    public static /* synthetic */ CJPiResult copy$default(CJPiResult r100, boolean r101, JSONObject r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.success;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.data;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.success;
    }

    public final JSONObject component2() {
        return this.data;
    }

    public final CJPiResult copy(boolean r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        return new CJPiResult(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPiResult) == true) goto L8;
        return false;
    L8:
        CJPiResult r101 = (CJPiResult) r100;
        if (this.success == r101.success) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.success == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.data.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "CJPiResult(success=" + this.success + ", data=" + this.data + ')';
    }

    public final JSONObject getData() {
        return this.data;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public CJPiResult(boolean r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        this.success = r100;
        this.data = r101;
    }
}
