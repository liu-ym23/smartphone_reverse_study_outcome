package com.obric.aivoice.sdk.response;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Response.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BE\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003JV\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0017\"\u0004\b\u001a\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Lcom/obric/aivoice/sdk/response/Response;", ExifInterface.GPS_DIRECTION_TRUE, "", AccountConst.KEY_ERROR_CODE, "", "errorInfo", "", "data", "isFinish", "", "isTaskId", "timeLog", "Landroid/os/Bundle;", "(ILjava/lang/String;Ljava/lang/Object;ZZLandroid/os/Bundle;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getErrorCode", "()I", "getErrorInfo", "()Ljava/lang/String;", "()Z", "setFinish", "(Z)V", "setTaskId", "getTimeLog", "()Landroid/os/Bundle;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Ljava/lang/Object;ZZLandroid/os/Bundle;)Lcom/obric/aivoice/sdk/response/Response;", "equals", "other", "hashCode", "toString", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Response<T> {
    private T data;
    private final int errorCode;
    private final String errorInfo;
    private boolean isFinish;
    private boolean isTaskId;
    private final Bundle timeLog;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Response copy$default(Response r4, int r5, String r6, Object r7, boolean r8, boolean r9, Bundle r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.errorCode;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.errorInfo;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.data;
    L11:
        Object r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.isFinish;
    L14:
        boolean r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.isTaskId;
    L17:
        boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.timeLog;
    L20:
        int r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final int component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.errorInfo;
    }

    public final T component3() {
        return this.data;
    }

    public final boolean component4() {
        return this.isFinish;
    }

    public final boolean component5() {
        return this.isTaskId;
    }

    public final Bundle component6() {
        return this.timeLog;
    }

    public final Response<T> copy(int r8, String r9, T r10, boolean r11, boolean r12, Bundle r13) {
        return new Response(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Response) == true) goto L8;
        return false;
    L8:
        Response r6 = (Response) r5;
        if (this.errorCode == r6.errorCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorInfo, r6.errorInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L18;
        return false;
    L18:
        if (this.isFinish == r6.isFinish) goto L21;
        return false;
    L21:
        if (this.isTaskId == r6.isTaskId) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.timeLog, r6.timeLog) == true) goto L26;
        return false;
    L26:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int r0 = Integer.hashCode(this.errorCode) * 31;
        String r1 = this.errorInfo;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        T r5 = this.data;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        boolean r8 = this.isFinish;
        ?? r9 = 1;
        ?? r10 = r8;
        if (r8 == false) goto L13;
        r10 = 1;
    L13:
        int r11 = (r7 + r10) * 31;
        boolean r12 = this.isTaskId;
        if (r12 == true) goto L17;
        r9 = r12;
    L17:
        int r13 = (r11 + r9) * 31;
        Bundle r14 = this.timeLog;
        if (r14 == null) goto L22;
        r2 = r14.hashCode();
    L22:
        return r13 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "Response(errorCode=" + this.errorCode + ", errorInfo=" + this.errorInfo + ", data=" + this.data + ", isFinish=" + this.isFinish + ", isTaskId=" + this.isTaskId + ", timeLog=" + this.timeLog + ')';
    }

    public Response(int r1, String r2, T r3, boolean r4, boolean r5, Bundle r6) {
        this.errorCode = r1;
        this.errorInfo = r2;
        this.data = r3;
        this.isFinish = r4;
        this.isTaskId = r5;
        this.timeLog = r6;
    }

    public /* synthetic */ Response(int r7, String r8, Object r9, boolean r10, boolean r11, Bundle r12, int r13, DefaultConstructorMarker r14) {
        Bundle r1 = null;
        if ((r13 & 2) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        Object r2 = null;
    L10:
        boolean r4 = false;
        if ((r13 & 8) == 0) goto L13;
        boolean r3 = false;
    L15:
        if ((r13 & 16) != 0) goto L19;
        r4 = r11;
    L19:
        if ((r13 & 32) != 0) goto L22;
        r1 = r12;
    L22:
        this(r7, r0, r2, r3, r4, r1);
        return;
    L13:
        r3 = r10;
        goto L15
    L9:
        r2 = r9;
        goto L10
    L5:
        r0 = r8;
        goto L7
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorInfo() {
        return this.errorInfo;
    }

    public final T getData() {
        return this.data;
    }

    public final void setData(T r1) {
        this.data = r1;
    }

    public final boolean isFinish() {
        return this.isFinish;
    }

    public final void setFinish(boolean r1) {
        this.isFinish = r1;
    }

    public final boolean isTaskId() {
        return this.isTaskId;
    }

    public final void setTaskId(boolean r1) {
        this.isTaskId = r1;
    }

    public final Bundle getTimeLog() {
        return this.timeLog;
    }
}
