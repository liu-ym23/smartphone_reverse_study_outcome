package com.obric.callsummary.bean;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SummaryData.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/obric/callsummary/bean/SummaryData;", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "data", "Lcom/obric/callsummary/bean/SummaryAndTodo;", TraceStatsConsts.STATS_BASE_MODULE, "(ILjava/lang/String;Lcom/obric/callsummary/bean/SummaryAndTodo;Ljava/lang/String;)V", "getBase", "()Ljava/lang/String;", "getCode", "()I", "getData", "()Lcom/obric/callsummary/bean/SummaryAndTodo;", "getMsg", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SummaryData {

    @SerializedName(TraceStatsConsts.STATS_BASE_MODULE)
    private final String base;

    @SerializedName("code")
    private final int code;

    @SerializedName("data")
    private final SummaryAndTodo data;

    @SerializedName(NotificationCompat.CATEGORY_MESSAGE)
    private final String msg;

    public SummaryData() {
        this(0, null, null, null, 15, null);
    }

    public static /* synthetic */ SummaryData copy$default(SummaryData r0, int r1, String r2, SummaryAndTodo r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.msg;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.data;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.base;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final SummaryAndTodo component3() {
        return this.data;
    }

    public final String component4() {
        return this.base;
    }

    public final SummaryData copy(int r1, String r2, SummaryAndTodo r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        return new SummaryData(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SummaryData) == true) goto L8;
        return false;
    L8:
        SummaryData r6 = (SummaryData) r5;
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r6.msg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.base, r6.base) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.code) * 31) + this.msg.hashCode()) * 31;
        SummaryAndTodo r1 = this.data;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.base;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SummaryData(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", base=" + this.base + ')';
    }

    public SummaryData(int r2, String r3, SummaryAndTodo r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        this.code = r2;
        this.msg = r3;
        this.data = r4;
        this.base = r5;
    }

    public /* synthetic */ SummaryData(int r2, String r3, SummaryAndTodo r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final SummaryAndTodo getData() {
        return this.data;
    }

    public final String getBase() {
        return this.base;
    }
}
