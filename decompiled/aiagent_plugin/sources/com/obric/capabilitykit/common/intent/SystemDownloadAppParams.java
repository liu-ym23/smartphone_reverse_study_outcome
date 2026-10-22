package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SystemDownloadAppParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SystemDownloadAppParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemDownloadAppParams> CREATOR = null;
    private String appName;
    private Boolean isSystemApp;
    Integer operateType;
    Boolean proceed;
    Integer updateRange;

    /* JADX INFO: compiled from: SystemDownloadAppParams.kt */
    public static final class Creator implements Parcelable.Creator<SystemDownloadAppParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemDownloadAppParams createFromParcel(Parcel r12) {
            int r0 = r12.readInt();
            o.e(r12, "parcel");
            String r3 = r12.readString();
            if (r12.readInt() != 0) goto L7;
            Boolean r2 = null;
        L11:
            SystemDownloadAppParams r1 = new SystemDownloadAppParams(r3, r2, null, null, null, 28, null);
            int r4 = Math.min(r0, 3);
            ClassLoader r11 = getClass().getClassLoader();
            int r5 = 1;
        L12:
            if (r5 > r4) goto L28;
            if (r5 != 1) goto L19;
            Object r6 = a.b(r12, r11);
            if (r6 == null) goto L27;
            r1.proceed = (Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin");
        L27:
            r5 = r5 + 1;
            goto L12
        L19:
            if (r5 != 2) goto L23;
            Object r7 = a.b(r12, r11);
            if (r7 == null) goto L27;
            r1.operateType = (Integer) ZeusTransformUtils.preCheckCast(r7, Integer.class, "com.obric.aiagent.plugin");
            goto L27
        L23:
            if (r5 != 3) goto L27;
            Object r8 = a.b(r12, r11);
            if (r8 == null) goto L27;
            r1.updateRange = (Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.aiagent.plugin");
        L28:
            if (r5 > r0) goto L30;
            a.a(r12, r11);
            r5 = r5 + 1;
            goto L28
        L30:
            return r1;
        L7:
            if (r12.readInt() == 0) goto L9;
            boolean r9 = true;
        L10:
            r2 = Boolean.valueOf(r9);
            goto L11
        L9:
            r9 = false;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemDownloadAppParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemDownloadAppParams[] newArray(int r1) {
            return new SystemDownloadAppParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemDownloadAppParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public SystemDownloadAppParams() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SystemDownloadAppParams copy$default(SystemDownloadAppParams r3, String r4, Boolean r5, Boolean r6, Integer r7, Integer r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.appName;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.isSystemApp;
    L8:
        Boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.proceed;
    L11:
        Boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.operateType;
    L14:
        Integer r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.updateRange;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public static /* synthetic */ void getOperateType$annotations() {
    }

    public static /* synthetic */ void getProceed$annotations() {
    }

    public static /* synthetic */ void getUpdateRange$annotations() {
    }

    public final String component1() {
        return this.appName;
    }

    public final Boolean component2() {
        return this.isSystemApp;
    }

    public final Boolean component3() {
        return this.proceed;
    }

    public final Integer component4() {
        return this.operateType;
    }

    public final Integer component5() {
        return this.updateRange;
    }

    public final SystemDownloadAppParams copy(String r7, Boolean r8, Boolean r9, Integer r10, Integer r11) {
        return new SystemDownloadAppParams(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemDownloadAppParams.class) == true) goto L8;
        return false;
    L8:
        SystemDownloadAppParams r6 = (SystemDownloadAppParams) ZeusTransformUtils.preCheckCast(r5, SystemDownloadAppParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.appName, r6.appName) == true) goto L12;
        return false;
    L12:
        if (o.a(this.isSystemApp, r6.isSystemApp) == true) goto L15;
        return false;
    L15:
        if (o.a(this.proceed, r6.proceed) == true) goto L18;
        return false;
    L18:
        if (o.a(this.operateType, r6.operateType) == true) goto L21;
        return false;
    L21:
        if (o.a(this.updateRange, r6.updateRange) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.appName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.isSystemApp;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.proceed;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.operateType;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.updateRange;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SystemDownloadAppParams(appName=" + this.appName + ", isSystemApp=" + this.isSystemApp + ", proceed=" + this.proceed + ", operateType=" + this.operateType + ", updateRange=" + this.updateRange + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(3);
        o.e(r2, "out");
        r2.writeString(this.appName);
        Boolean r4 = this.isSystemApp;
        if (r4 != null) goto L6;
        ?? r5 = 0;
    L5:
        r2.writeInt(r5);
        r2.writeValue(this.proceed);
        r2.writeValue(this.operateType);
        r2.writeValue(this.updateRange);
        return;
    L6:
        r2.writeInt(1);
        r5 = r4.booleanValue();
        goto L5
    }

    public SystemDownloadAppParams(String r1, Boolean r2, Boolean r3, Integer r4, Integer r5) {
        this.appName = r1;
        this.isSystemApp = r2;
        this.proceed = r3;
        this.operateType = r4;
        this.updateRange = r5;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ SystemDownloadAppParams(String r2, Boolean r3, Boolean r4, Integer r5, Integer r6, int r7, h r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = null;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public final String getAppName() {
        return this.appName;
    }

    public final void setAppName(String r1) {
        this.appName = r1;
    }

    public final Boolean isSystemApp() {
        return this.isSystemApp;
    }

    public final void setSystemApp(Boolean r1) {
        this.isSystemApp = r1;
    }

    public final Boolean getProceed() {
        return this.proceed;
    }

    public final void setProceed(Boolean r1) {
        this.proceed = r1;
    }

    public final Integer getOperateType() {
        return this.operateType;
    }

    public final void setOperateType(Integer r1) {
        this.operateType = r1;
    }

    public final Integer getUpdateRange() {
        return this.updateRange;
    }

    public final void setUpdateRange(Integer r1) {
        this.updateRange = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r10) {
        if (ZeusTransformUtils.instanceOf(r10, SystemDownloadAppParams.class) == false) goto L5;
        String r1 = this.appName;
        if (r1 != null) goto L9;
        r1 = ((SystemDownloadAppParams) ZeusTransformUtils.preCheckCast(r10, SystemDownloadAppParams.class, "com.obric.aiagent.plugin")).appName;
    L9:
        String r4 = r1;
        Boolean r2 = this.isSystemApp;
        if (r2 != null) goto L12;
        r2 = ((SystemDownloadAppParams) ZeusTransformUtils.preCheckCast(r10, SystemDownloadAppParams.class, "com.obric.aiagent.plugin")).isSystemApp;
    L12:
        Boolean r5 = r2;
        Boolean r3 = this.proceed;
        if (r3 != null) goto L15;
        r3 = ((SystemDownloadAppParams) ZeusTransformUtils.preCheckCast(r10, SystemDownloadAppParams.class, "com.obric.aiagent.plugin")).proceed;
    L15:
        Boolean r6 = r3;
        Integer r7 = this.operateType;
        if (r7 != null) goto L18;
        r7 = ((SystemDownloadAppParams) ZeusTransformUtils.preCheckCast(r10, SystemDownloadAppParams.class, "com.obric.aiagent.plugin")).operateType;
    L18:
        Integer r8 = r7;
        Integer r9 = this.updateRange;
        if (r9 != null) goto L22;
        r9 = ((SystemDownloadAppParams) ZeusTransformUtils.preCheckCast(r10, SystemDownloadAppParams.class, "com.obric.aiagent.plugin")).updateRange;
    L22:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new SystemDownloadAppParams(r4, r5, r6, r8, r9), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
