package com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.hihonor.honorid.core.data.UserInfo;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000234B?\u0012\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\f\b\u0002\u0010\u0005\u001a\u00060\u0003j\u0002`\u0006\u0012\f\b\u0002\u0010\u0007\u001a\u00060\u0003j\u0002`\b\u0012\f\b\u0002\u0010\t\u001a\u00060\u0003j\u0002`\n¢\u0006\u0004\b\u000b\u0010\fBC\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\r\u0010!\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\r\u0010\"\u001a\u00060\u0003j\u0002`\u0006HÆ\u0003J\r\u0010#\u001a\u00060\u0003j\u0002`\bHÆ\u0003J\r\u0010$\u001a\u00060\u0003j\u0002`\nHÆ\u0003JA\u0010%\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\f\b\u0002\u0010\u0005\u001a\u00060\u0003j\u0002`\u00062\f\b\u0002\u0010\u0007\u001a\u00060\u0003j\u0002`\b2\f\b\u0002\u0010\t\u001a\u00060\u0003j\u0002`\nHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u000eHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R(\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0005\u001a\u00060\u0003j\u0002`\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R(\u0010\u0007\u001a\u00060\u0003j\u0002`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R(\u0010\t\u001a\u00060\u0003j\u0002`\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017¨\u00065"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainContactInfo;", "", "process", "", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainContactInfoProcess;", "function", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainContactInfoFunc;", "behavior", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainContactInfoBehavior;", UserInfo.USERSTATE, "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainContactInfoUserState;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProcess$annotations", "()V", "getProcess", "()Ljava/lang/String;", "setProcess", "(Ljava/lang/String;)V", "getFunction$annotations", "getFunction", "setFunction", "getBehavior$annotations", "getBehavior", "setBehavior", "getUserState$annotations", "getUserState", "setUserState", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cj_common_release", "$serializer", "Companion", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class CJPayRetainContactInfo {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private String behavior;
    private String function;
    private String process;
    private String userState;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainContactInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainContactInfo;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<CJPayRetainContactInfo> serializer() {
            return CJPayRetainContactInfo$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public CJPayRetainContactInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CJPayRetainContactInfo copy$default(CJPayRetainContactInfo r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.process;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.function;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.behavior;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.userState;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    @SerialName("behavior")
    public static /* synthetic */ void getBehavior$annotations() {
    }

    @SerialName("function")
    public static /* synthetic */ void getFunction$annotations() {
    }

    @SerialName("process")
    public static /* synthetic */ void getProcess$annotations() {
    }

    @SerialName(UserInfo.USERSTATE)
    public static /* synthetic */ void getUserState$annotations() {
    }

    public final String component1() {
        return this.process;
    }

    public final String component2() {
        return this.function;
    }

    public final String component3() {
        return this.behavior;
    }

    public final String component4() {
        return this.userState;
    }

    public final CJPayRetainContactInfo copy(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "process");
        Intrinsics.checkNotNullParameter(r101, "function");
        Intrinsics.checkNotNullParameter(r102, "behavior");
        Intrinsics.checkNotNullParameter(r103, UserInfo.USERSTATE);
        return new CJPayRetainContactInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPayRetainContactInfo) == true) goto L8;
        return false;
    L8:
        CJPayRetainContactInfo r101 = (CJPayRetainContactInfo) r100;
        if (Intrinsics.areEqual(this.process, r101.process) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.function, r101.function) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.behavior, r101.behavior) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.userState, r101.userState) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.process.hashCode() * 31) + this.function.hashCode()) * 31) + this.behavior.hashCode()) * 31) + this.userState.hashCode();
    }

    public String toString() {
        return "CJPayRetainContactInfo(process=" + this.process + ", function=" + this.function + ", behavior=" + this.behavior + ", userState=" + this.userState + ')';
    }

    public final String getBehavior() {
        return this.behavior;
    }

    public final String getFunction() {
        return this.function;
    }

    public final String getProcess() {
        return this.process;
    }

    public final String getUserState() {
        return this.userState;
    }

    public final void setBehavior(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.behavior = r100;
    }

    public final void setFunction(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.function = r100;
    }

    public final void setProcess(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.process = r100;
    }

    public final void setUserState(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.userState = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cj_common_release(CJPayRetainContactInfo r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeStringElement(r102, 0, r100.process);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeStringElement(r102, 1, r100.function);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeStringElement(r102, 2, r100.behavior);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        r103 = true;
    L35:
        if (r103 == false) goto L38;
        r101.encodeStringElement(r102, 3, r100.userState);
        return;
    L38:
        return;
    L33:
        if (Intrinsics.areEqual(r100.userState, "Default") == true) goto L35;
    L24:
        if (Intrinsics.areEqual(r100.behavior, "Default") == false) goto L22;
        r106 = false;
        goto L27
    L15:
        if (Intrinsics.areEqual(r100.function, "Default") == false) goto L13;
        r105 = false;
        goto L18
    L6:
        if (Intrinsics.areEqual(r100.process, "Default") == false) goto L4;
        r104 = false;
        goto L9
    }

    public CJPayRetainContactInfo(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "process");
        Intrinsics.checkNotNullParameter(r101, "function");
        Intrinsics.checkNotNullParameter(r102, "behavior");
        Intrinsics.checkNotNullParameter(r103, UserInfo.USERSTATE);
        this.process = r100;
        this.function = r101;
        this.behavior = r102;
        this.userState = r103;
    }

    public /* synthetic */ CJPayRetainContactInfo(int r100, String r101, String r102, String r103, String r104, q2 r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, CJPayRetainContactInfo$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.process = "Default";
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.function = "Default";
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.behavior = "Default";
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.userState = "Default";
        return;
    L19:
        this.userState = r104;
        return;
    L15:
        this.behavior = r103;
        goto L17
    L11:
        this.function = r102;
        goto L13
    L7:
        this.process = r101;
        goto L9
    }

    public /* synthetic */ CJPayRetainContactInfo(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "Default";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "Default";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "Default";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "Default";
    L14:
        this(r100, r101, r102, r103);
    }
}
