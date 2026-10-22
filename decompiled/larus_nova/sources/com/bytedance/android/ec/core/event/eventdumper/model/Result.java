package com.bytedance.android.ec.core.event.eventdumper.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0007\"\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/core/event/eventdumper/model/Result;", "Ljava/io/Serializable;", "isSuccess", "", "msg", "", "(ZLjava/lang/String;)V", "()Z", "setSuccess", "(Z)V", "getMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Result implements Serializable {

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("msg")
    private final String msg;

    /* JADX WARN: Multi-variable type inference failed */
    public Result() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Result copy$default(Result r100, boolean r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.isSuccess;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.msg;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.isSuccess;
    }

    public final String component2() {
        return this.msg;
    }

    public final Result copy(boolean r100, String r101) {
        return new Result(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Result) == false) goto L10;
        Result r101 = (Result) r100;
        if (this.isSuccess == r101.isSuccess) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean r100 = this.isSuccess;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.msg;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public String toString() {
        return "Result(isSuccess=" + this.isSuccess + ", msg=" + this.msg + ")";
    }

    public final String getMsg() {
        return this.msg;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public final void setSuccess(boolean r100) {
        this.isSuccess = r100;
    }

    public Result(boolean r100, String r101) {
        this.isSuccess = r100;
        this.msg = r101;
    }

    public /* synthetic */ Result(boolean r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
