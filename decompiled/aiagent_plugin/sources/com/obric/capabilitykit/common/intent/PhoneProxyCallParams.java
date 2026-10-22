package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: PhoneProxyCallParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PhoneProxyCallParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<PhoneProxyCallParams> CREATOR = null;
    private Boolean canInterruptCall;
    private String ext;
    private String firstSentence;
    private String name;
    private String[] option;
    private String phoneNumber;
    private String targetPhoneNumber;

    /* JADX INFO: compiled from: PhoneProxyCallParams.kt */
    public static final class Creator implements Parcelable.Creator<PhoneProxyCallParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhoneProxyCallParams createFromParcel(Parcel r13) {
            int r0 = r13.readInt();
            o.e(r13, "parcel");
            int r11 = 1;
            if (r13.readInt() != 0) goto L7;
            Boolean r2 = null;
        L11:
            PhoneProxyCallParams r1 = new PhoneProxyCallParams(r2, r13.createStringArray(), r13.readString(), r13.readString(), r13.readString(), r13.readString(), r13.readString());
            int r3 = Math.min(r0, 0);
            ClassLoader r12 = getClass().getClassLoader();
        L12:
            if (r11 > r3) goto L14;
            r11 = r11 + 1;
        L14:
            if (r11 > r0) goto L16;
            a.a(r13, r12);
            r11 = r11 + 1;
            goto L14
        L16:
            return r1;
        L7:
            if (r13.readInt() == 0) goto L9;
            boolean r4 = true;
        L10:
            r2 = Boolean.valueOf(r4);
            goto L11
        L9:
            r4 = false;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhoneProxyCallParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhoneProxyCallParams[] newArray(int r1) {
            return new PhoneProxyCallParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhoneProxyCallParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public PhoneProxyCallParams() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ PhoneProxyCallParams copy$default(PhoneProxyCallParams r5, Boolean r6, String[] r7, String r8, String r9, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.canInterruptCall;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.option;
    L8:
        String[] r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.phoneNumber;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.name;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.firstSentence;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.targetPhoneNumber;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.ext;
    L23:
        Boolean r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final Boolean component1() {
        return this.canInterruptCall;
    }

    public final String[] component2() {
        return this.option;
    }

    public final String component3() {
        return this.phoneNumber;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.firstSentence;
    }

    public final String component6() {
        return this.targetPhoneNumber;
    }

    public final String component7() {
        return this.ext;
    }

    public final PhoneProxyCallParams copy(Boolean r9, String[] r10, String r11, String r12, String r13, String r14, String r15) {
        return new PhoneProxyCallParams(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PhoneProxyCallParams.class) == true) goto L8;
        return false;
    L8:
        PhoneProxyCallParams r6 = (PhoneProxyCallParams) ZeusTransformUtils.preCheckCast(r5, PhoneProxyCallParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.canInterruptCall, r6.canInterruptCall) == true) goto L12;
        return false;
    L12:
        if (o.a(this.option, r6.option) == true) goto L15;
        return false;
    L15:
        if (o.a(this.phoneNumber, r6.phoneNumber) == true) goto L18;
        return false;
    L18:
        if (o.a(this.name, r6.name) == true) goto L21;
        return false;
    L21:
        if (o.a(this.firstSentence, r6.firstSentence) == true) goto L24;
        return false;
    L24:
        if (o.a(this.targetPhoneNumber, r6.targetPhoneNumber) == true) goto L27;
        return false;
    L27:
        if (o.a(this.ext, r6.ext) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.canInterruptCall;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String[] r4 = this.option;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.phoneNumber;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.name;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.firstSentence;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.targetPhoneNumber;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.ext;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = Arrays.hashCode(r4);
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PhoneProxyCallParams(canInterruptCall=" + this.canInterruptCall + ", option=" + Arrays.toString(this.option) + ", phoneNumber=" + this.phoneNumber + ", name=" + this.name + ", firstSentence=" + this.firstSentence + ", targetPhoneNumber=" + this.targetPhoneNumber + ", ext=" + this.ext + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        ?? r4 = 0;
        r2.writeInt(0);
        o.e(r2, "out");
        Boolean r0 = this.canInterruptCall;
        if (r0 != null) goto L5;
    L4:
        r2.writeInt(r4);
        r2.writeStringArray(this.option);
        r2.writeString(this.phoneNumber);
        r2.writeString(this.name);
        r2.writeString(this.firstSentence);
        r2.writeString(this.targetPhoneNumber);
        r2.writeString(this.ext);
        return;
    L5:
        r2.writeInt(1);
        r4 = r0.booleanValue();
        goto L4
    }

    public PhoneProxyCallParams(Boolean r1, String[] r2, String r3, String r4, String r5, String r6, String r7) {
        this.canInterruptCall = r1;
        this.option = r2;
        this.phoneNumber = r3;
        this.name = r4;
        this.firstSentence = r5;
        this.targetPhoneNumber = r6;
        this.ext = r7;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ PhoneProxyCallParams(Boolean r2, String[] r3, String r4, String r5, String r6, String r7, String r8, int r9, h r10) {
        if ((r9 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r9 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r9 & 64) == 0) goto L23;
        r8 = null;
    L23:
        this(r2, r3, r4, r5, r6, r7, r8);
    }

    public final Boolean getCanInterruptCall() {
        return this.canInterruptCall;
    }

    public final void setCanInterruptCall(Boolean r1) {
        this.canInterruptCall = r1;
    }

    public final String[] getOption() {
        return this.option;
    }

    public final void setOption(String[] r1) {
        this.option = r1;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final void setPhoneNumber(String r1) {
        this.phoneNumber = r1;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final String getFirstSentence() {
        return this.firstSentence;
    }

    public final void setFirstSentence(String r1) {
        this.firstSentence = r1;
    }

    public final String getTargetPhoneNumber() {
        return this.targetPhoneNumber;
    }

    public final void setTargetPhoneNumber(String r1) {
        this.targetPhoneNumber = r1;
    }

    public final String getExt() {
        return this.ext;
    }

    public final void setExt(String r1) {
        this.ext = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.option != null) goto L5;
    L7:
        return false;
    L5:
        if (this.phoneNumber == null) goto L7;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r12) {
        if (ZeusTransformUtils.instanceOf(r12, PhoneProxyCallParams.class) == false) goto L5;
        Boolean r1 = this.canInterruptCall;
        if (r1 != null) goto L9;
        r1 = ((PhoneProxyCallParams) ZeusTransformUtils.preCheckCast(r12, PhoneProxyCallParams.class, "com.obric.aiagent.plugin")).canInterruptCall;
    L9:
        Boolean r4 = r1;
        String[] r2 = this.option;
        if (r2 != null) goto L12;
        r2 = ((PhoneProxyCallParams) ZeusTransformUtils.preCheckCast(r12, PhoneProxyCallParams.class, "com.obric.aiagent.plugin")).option;
    L12:
        String[] r5 = r2;
        String r3 = this.phoneNumber;
        if (r3 != null) goto L15;
        r3 = ((PhoneProxyCallParams) ZeusTransformUtils.preCheckCast(r12, PhoneProxyCallParams.class, "com.obric.aiagent.plugin")).phoneNumber;
    L15:
        String r6 = r3;
        String r7 = this.name;
        if (r7 != null) goto L18;
        r7 = ((PhoneProxyCallParams) ZeusTransformUtils.preCheckCast(r12, PhoneProxyCallParams.class, "com.obric.aiagent.plugin")).name;
    L18:
        String r8 = r7;
        String r9 = this.firstSentence;
        if (r9 != null) goto L21;
        r9 = ((PhoneProxyCallParams) ZeusTransformUtils.preCheckCast(r12, PhoneProxyCallParams.class, "com.obric.aiagent.plugin")).firstSentence;
    L21:
        String r10 = r9;
        String r11 = this.targetPhoneNumber;
        if (r11 != null) goto L24;
        r11 = ((PhoneProxyCallParams) ZeusTransformUtils.preCheckCast(r12, PhoneProxyCallParams.class, "com.obric.aiagent.plugin")).targetPhoneNumber;
    L24:
        String r13 = r11;
        String r14 = this.ext;
        if (r14 != null) goto L28;
        r14 = ((PhoneProxyCallParams) ZeusTransformUtils.preCheckCast(r12, PhoneProxyCallParams.class, "com.obric.aiagent.plugin")).ext;
    L28:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new PhoneProxyCallParams(r4, r5, r6, r8, r10, r13, r14), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
