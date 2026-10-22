package com.obric.Intelligentcall.bean;

import com.android.contacts.common.SimContactsConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallForMeBean.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003JU\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010!\u001a\u00020\u0005J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/Intelligentcall/bean/CallDetailData;", "", "canInterruptCall", "", "ext", "", "firstSentence", "option", "", "phoneNumber", "targetPhoneNumber", "name", "(ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCanInterruptCall", "()Z", "getExt", "()Ljava/lang/String;", "getFirstSentence", "getName", "getOption", "()Ljava/util/List;", "getPhoneNumber", "getTargetPhoneNumber", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "getTaskDescription", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallDetailData {

    @SerializedName("canInterruptCall")
    private final boolean canInterruptCall;

    @SerializedName("ext")
    private final String ext;

    @SerializedName("firstSentence")
    private final String firstSentence;

    @SerializedName("name")
    private final String name;

    @SerializedName("option")
    private final List<String> option;

    @SerializedName("phoneNumber")
    private final String phoneNumber;

    @SerializedName("targetPhoneNumber")
    private final String targetPhoneNumber;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallDetailData copy$default(CallDetailData r5, boolean r6, String r7, String r8, List r9, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.canInterruptCall;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.ext;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.firstSentence;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.option;
    L14:
        List r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.phoneNumber;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.targetPhoneNumber;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.name;
    L23:
        boolean r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final boolean component1() {
        return this.canInterruptCall;
    }

    public final String component2() {
        return this.ext;
    }

    public final String component3() {
        return this.firstSentence;
    }

    public final List<String> component4() {
        return this.option;
    }

    public final String component5() {
        return this.phoneNumber;
    }

    public final String component6() {
        return this.targetPhoneNumber;
    }

    public final String component7() {
        return this.name;
    }

    public final CallDetailData copy(boolean r9, String r10, String r11, List<String> r12, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r10, "ext");
        Intrinsics.checkNotNullParameter(r11, "firstSentence");
        Intrinsics.checkNotNullParameter(r12, "option");
        Intrinsics.checkNotNullParameter(r13, "phoneNumber");
        Intrinsics.checkNotNullParameter(r14, "targetPhoneNumber");
        Intrinsics.checkNotNullParameter(r15, "name");
        return new CallDetailData(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CallDetailData) == true) goto L8;
        return false;
    L8:
        CallDetailData r6 = (CallDetailData) r5;
        if (this.canInterruptCall == r6.canInterruptCall) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.firstSentence, r6.firstSentence) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.option, r6.option) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.phoneNumber, r6.phoneNumber) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.targetPhoneNumber, r6.targetPhoneNumber) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L29;
        return false;
    L29:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public int hashCode() {
        boolean r0 = this.canInterruptCall;
        ?? r1 = r0;
        if (r0 == false) goto L6;
        r1 = 1;
    L6:
        return (((((((((((r1 * 31) + this.ext.hashCode()) * 31) + this.firstSentence.hashCode()) * 31) + this.option.hashCode()) * 31) + this.phoneNumber.hashCode()) * 31) + this.targetPhoneNumber.hashCode()) * 31) + this.name.hashCode();
    }

    public String toString() {
        return "CallDetailData(canInterruptCall=" + this.canInterruptCall + ", ext=" + this.ext + ", firstSentence=" + this.firstSentence + ", option=" + this.option + ", phoneNumber=" + this.phoneNumber + ", targetPhoneNumber=" + this.targetPhoneNumber + ", name=" + this.name + ')';
    }

    public CallDetailData(boolean r2, String r3, String r4, List<String> r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r3, "ext");
        Intrinsics.checkNotNullParameter(r4, "firstSentence");
        Intrinsics.checkNotNullParameter(r5, "option");
        Intrinsics.checkNotNullParameter(r6, "phoneNumber");
        Intrinsics.checkNotNullParameter(r7, "targetPhoneNumber");
        Intrinsics.checkNotNullParameter(r8, "name");
        this.canInterruptCall = r2;
        this.ext = r3;
        this.firstSentence = r4;
        this.option = r5;
        this.phoneNumber = r6;
        this.targetPhoneNumber = r7;
        this.name = r8;
    }

    public final boolean getCanInterruptCall() {
        return this.canInterruptCall;
    }

    public final String getExt() {
        return this.ext;
    }

    public final String getFirstSentence() {
        return this.firstSentence;
    }

    public final List<String> getOption() {
        return this.option;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getTargetPhoneNumber() {
        return this.targetPhoneNumber;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTaskDescription() {
        return CollectionsKt.joinToString$default(this.option, SimContactsConstants.EMAIL_SEP, null, null, 0, null, null, 62, null) + ",预留人姓名:" + this.name + ",预留号码:" + this.phoneNumber;
    }
}
