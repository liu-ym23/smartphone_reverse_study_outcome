package com.obric.aikernel.sdk.response;

import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import org.json.JSONObject;

/* JADX INFO: compiled from: Response.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Response<T> {
    private T data;
    private final int errorCode;
    private final String errorInfo;
    private JSONObject extra;
    private boolean isFinish;
    private boolean isTaskId;
    private Bundle src;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Response copy$default(Response r5, int r6, String r7, Object r8, boolean r9, boolean r10, JSONObject r11, Bundle r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.errorCode;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.errorInfo;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.data;
    L11:
        Object r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.isFinish;
    L14:
        boolean r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.isTaskId;
    L17:
        boolean r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.extra;
    L20:
        JSONObject r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.src;
    L23:
        int r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
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

    public final JSONObject component6() {
        return this.extra;
    }

    public final Bundle component7() {
        return this.src;
    }

    public final Response<T> copy(int r9, String r10, T r11, boolean r12, boolean r13, JSONObject r14, Bundle r15) {
        o.e(r14, "extra");
        return new Response(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Response.class) == true) goto L8;
        return false;
    L8:
        Response r6 = (Response) ZeusTransformUtils.preCheckCast(r5, Response.class, "com.obric.aiagent.plugin");
        if (this.errorCode == r6.errorCode) goto L12;
        return false;
    L12:
        if (o.a(this.errorInfo, r6.errorInfo) == true) goto L15;
        return false;
    L15:
        if (o.a(this.data, r6.data) == true) goto L18;
        return false;
    L18:
        if (this.isFinish == r6.isFinish) goto L21;
        return false;
    L21:
        if (this.isTaskId == r6.isTaskId) goto L24;
        return false;
    L24:
        if (o.a(this.extra, r6.extra) == true) goto L27;
        return false;
    L27:
        if (o.a(this.src, r6.src) == true) goto L29;
        return false;
    L29:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
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
        int r13 = (((r11 + r9) * 31) + this.extra.hashCode()) * 31;
        Bundle r14 = this.src;
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
        return "Response(errorCode=" + this.errorCode + ", errorInfo=" + this.errorInfo + ", data=" + this.data + ", isFinish=" + this.isFinish + ", isTaskId=" + this.isTaskId + ", extra=" + this.extra + ", src=" + this.src + ')';
    }

    public Response(int r2, String r3, T r4, boolean r5, boolean r6, JSONObject r7, Bundle r8) {
        o.e(r7, "extra");
        this.errorCode = r2;
        this.errorInfo = r3;
        this.data = r4;
        this.isFinish = r5;
        this.isTaskId = r6;
        this.extra = r7;
        this.src = r8;
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

    public /* synthetic */ Response(int r8, String r9, Object r10, boolean r11, boolean r12, JSONObject r13, Bundle r14, int r15, h r16) {
        Bundle r1 = null;
        if ((r15 & 2) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r15 & 4) == 0) goto L9;
        Object r2 = null;
    L10:
        boolean r4 = false;
        if ((r15 & 8) == 0) goto L13;
        boolean r3 = false;
    L15:
        if ((r15 & 16) != 0) goto L19;
        r4 = r12;
    L19:
        if ((r15 & 32) == 0) goto L21;
        JSONObject r5 = new JSONObject();
    L23:
        if ((r15 & 64) != 0) goto L26;
        r1 = r14;
    L26:
        this(r8, r0, r2, r3, r4, r5, r1);
        return;
    L21:
        r5 = r13;
        goto L23
    L13:
        r3 = r11;
        goto L15
    L9:
        r2 = r10;
        goto L10
    L5:
        r0 = r9;
        goto L7
    }

    public final JSONObject getExtra() {
        return this.extra;
    }

    public final void setExtra(JSONObject r2) {
        o.e(r2, "<set-?>");
        this.extra = r2;
    }

    public final Bundle getSrc() {
        return this.src;
    }

    public final void setSrc(Bundle r1) {
        this.src = r1;
    }
}
