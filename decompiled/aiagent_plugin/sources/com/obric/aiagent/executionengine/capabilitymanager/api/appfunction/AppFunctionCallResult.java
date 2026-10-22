package com.obric.aiagent.executionengine.capabilitymanager.api.appfunction;

import android.app.PendingIntent;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: AppFunctionCallResult.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFunctionCallResult {
    public static final int CODE_INTERNAL_ERROR = -3;
    public static final int CODE_INVALID_ARGUMENT = -2;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_UNSUPPORTED = -1;
    public static final a Companion = null;
    private final int code;
    private final AppEntity[] entities;
    private final String errorMessage;
    private final boolean isStandardResult;
    private final PendingIntent pendingIntent;
    private final String returnJson;
    private final Parcelable returnParcelable;
    private final Integer standardCode;
    private final String standardMessage;

    /* JADX INFO: compiled from: AppFunctionCallResult.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ AppFunctionCallResult copy$default(AppFunctionCallResult r10, int r11, String r12, String r13, Parcelable r14, PendingIntent r15, boolean r16, Integer r17, String r18, AppEntity[] r19, int r20, Object r21) {
        Parcelable r2 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r14, Parcelable.class, "com.obric.aiagent.plugin");
        if ((r20 & 1) == 0) goto L5;
        int r3 = r10.code;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r4 = r10.errorMessage;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r5 = r10.returnJson;
    L15:
        if ((r20 & 8) == 0) goto L18;
        r2 = r10.returnParcelable;
    L18:
        if ((r20 & 16) == 0) goto L20;
        PendingIntent r6 = r10.pendingIntent;
    L22:
        if ((r20 & 32) == 0) goto L24;
        boolean r7 = r10.isStandardResult;
    L26:
        if ((r20 & 64) == 0) goto L28;
        Integer r8 = r10.standardCode;
    L30:
        if ((r20 & 128) == 0) goto L32;
        String r9 = r10.standardMessage;
    L34:
        if ((r20 & 256) == 0) goto L36;
        AppEntity[] r1 = r10.entities;
    L38:
        return r10.copy(r3, r4, r5, r2, r6, r7, r8, r9, r1);
    L36:
        r1 = r19;
        goto L38
    L32:
        r9 = r18;
        goto L34
    L28:
        r8 = r17;
        goto L30
    L24:
        r7 = r16;
        goto L26
    L20:
        r6 = r15;
        goto L22
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final String component3() {
        return this.returnJson;
    }

    public final Parcelable component4() {
        return this.returnParcelable;
    }

    public final PendingIntent component5() {
        return this.pendingIntent;
    }

    public final boolean component6() {
        return this.isStandardResult;
    }

    public final Integer component7() {
        return this.standardCode;
    }

    public final String component8() {
        return this.standardMessage;
    }

    public final AppEntity[] component9() {
        return this.entities;
    }

    public final AppFunctionCallResult copy(int r12, String r13, String r14, Parcelable r15, PendingIntent r16, boolean r17, Integer r18, String r19, AppEntity[] r20) {
        return new AppFunctionCallResult(r12, r13, r14, (Parcelable) ZeusTransformUtils.wrapperContextForParams(r15, Parcelable.class, "com.obric.aiagent.plugin"), r16, r17, r18, r19, r20);
    }

    public String toString() {
        return "AppFunctionCallResult(code=" + this.code + ", errorMessage=" + this.errorMessage + ", returnJson=" + this.returnJson + ", returnParcelable=" + this.returnParcelable + ", pendingIntent=" + this.pendingIntent + ", isStandardResult=" + this.isStandardResult + ", standardCode=" + this.standardCode + ", standardMessage=" + this.standardMessage + ", entities=" + Arrays.toString(this.entities) + ')';
    }

    public AppFunctionCallResult(int r3, String r4, String r5, Parcelable r6, PendingIntent r7, boolean r8, Integer r9, String r10, AppEntity[] r11) {
        Parcelable r12 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r6, Parcelable.class, "com.obric.aiagent.plugin");
        this.code = r3;
        this.errorMessage = r4;
        this.returnJson = r5;
        this.returnParcelable = r12;
        this.pendingIntent = r7;
        this.isStandardResult = r8;
        this.standardCode = r9;
        this.standardMessage = r10;
        this.entities = r11;
    }

    public /* synthetic */ AppFunctionCallResult(int r10, String r11, String r12, Parcelable r13, PendingIntent r14, boolean r15, Integer r16, String r17, AppEntity[] r18, int r19, h r20) {
        Parcelable r1 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r13, Parcelable.class, "com.obric.aiagent.plugin");
        AppEntity[] r3 = null;
        if ((r19 & 2) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r19 & 4) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r19 & 8) == 0) goto L14;
        r1 = null;
    L14:
        if ((r19 & 16) == 0) goto L16;
        PendingIntent r5 = null;
    L18:
        if ((r19 & 32) == 0) goto L20;
        boolean r6 = false;
    L22:
        if ((r19 & 64) == 0) goto L24;
        Integer r7 = null;
    L26:
        if ((r19 & 128) == 0) goto L28;
        String r8 = null;
    L30:
        if ((r19 & 256) != 0) goto L33;
        r3 = r18;
    L33:
        this(r10, r2, r4, r1, r5, r6, r7, r8, r3);
        return;
    L28:
        r8 = r17;
        goto L30
    L24:
        r7 = r16;
        goto L26
    L20:
        r6 = r15;
        goto L22
    L16:
        r5 = r14;
        goto L18
    L9:
        r4 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final int getCode() {
        return this.code;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getReturnJson() {
        return this.returnJson;
    }

    public final Parcelable getReturnParcelable() {
        return this.returnParcelable;
    }

    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public final boolean isStandardResult() {
        return this.isStandardResult;
    }

    public final Integer getStandardCode() {
        return this.standardCode;
    }

    public final String getStandardMessage() {
        return this.standardMessage;
    }

    public final AppEntity[] getEntities() {
        return this.entities;
    }

    public final boolean isSuccess() {
        if (this.code != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, AppFunctionCallResult.class) == true) goto L9;
        return false;
    L9:
        if (this.code != ((AppFunctionCallResult) ZeusTransformUtils.preCheckCast(r7, AppFunctionCallResult.class, "com.obric.aiagent.plugin")).code) goto L26;
        if (o.a(this.errorMessage, ((AppFunctionCallResult) ZeusTransformUtils.preCheckCast(r7, AppFunctionCallResult.class, "com.obric.aiagent.plugin")).errorMessage) == false) goto L26;
        if (o.a(this.returnJson, ((AppFunctionCallResult) ZeusTransformUtils.preCheckCast(r7, AppFunctionCallResult.class, "com.obric.aiagent.plugin")).returnJson) == false) goto L26;
        if (o.a(this.returnParcelable, ((AppFunctionCallResult) ZeusTransformUtils.preCheckCast(r7, AppFunctionCallResult.class, "com.obric.aiagent.plugin")).returnParcelable) == false) goto L26;
        if (this.isStandardResult != ((AppFunctionCallResult) ZeusTransformUtils.preCheckCast(r7, AppFunctionCallResult.class, "com.obric.aiagent.plugin")).isStandardResult) goto L26;
        if (o.a(this.standardCode, ((AppFunctionCallResult) ZeusTransformUtils.preCheckCast(r7, AppFunctionCallResult.class, "com.obric.aiagent.plugin")).standardCode) == false) goto L26;
        if (o.a(this.standardMessage, ((AppFunctionCallResult) ZeusTransformUtils.preCheckCast(r7, AppFunctionCallResult.class, "com.obric.aiagent.plugin")).standardMessage) == false) goto L26;
        if (contentEqualsNullable(this.entities, ((AppFunctionCallResult) ZeusTransformUtils.preCheckCast(r7, AppFunctionCallResult.class, "com.obric.aiagent.plugin")).entities) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r0 = this.code * 31;
        String r1 = this.errorMessage;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.returnJson;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        Parcelable r8 = this.returnParcelable;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (((r7 + r9) * 31) + Boolean.hashCode(this.isStandardResult)) * 31;
        Integer r11 = this.standardCode;
        if (r11 == null) goto L17;
        int r12 = r11.intValue();
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.standardMessage;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        AppEntity[] r17 = this.entities;
        if (r17 == null) goto L26;
        r2 = Arrays.hashCode(r17);
    L26:
        return r16 + r2;
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    private final boolean contentEqualsNullable(AppEntity[] r1, AppEntity[] r2) {
        if (r1 != null) goto L6;
        if (r2 != null) goto L6;
        return true;
    L6:
        if (r1 == null) goto L11;
        if (r2 != null) goto L10;
        return false;
    L10:
        return Arrays.equals(r1, r2);
    L11:
        return false;
    }
}
