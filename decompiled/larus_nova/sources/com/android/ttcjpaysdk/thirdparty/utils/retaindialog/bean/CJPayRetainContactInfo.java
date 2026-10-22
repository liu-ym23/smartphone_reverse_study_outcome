package com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.hihonor.honorid.core.data.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020\u001dH\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "process", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayProcess;", "function", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayFunction;", "behavior", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayBehavior;", UserInfo.USERSTATE, "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayUserState;", "(Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayProcess;Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayFunction;Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayBehavior;Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayUserState;)V", "getBehavior", "()Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayBehavior;", "getFunction", "()Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayFunction;", "getProcess", "()Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayProcess;", "getUserState", "()Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayUserState;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "formatString", "", "hashCode", "", "toJsonObject", "Lorg/json/JSONObject;", "toString", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayRetainContactInfo implements CJPayObject {
    private final CJPayBehavior behavior;
    private final CJPayFunction function;
    private final CJPayProcess process;
    private final CJPayUserState userState;

    public static /* synthetic */ CJPayRetainContactInfo copy$default(CJPayRetainContactInfo r100, CJPayProcess r101, CJPayFunction r102, CJPayBehavior r103, CJPayUserState r104, int r105, Object r106) {
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

    public final CJPayProcess component1() {
        return this.process;
    }

    public final CJPayFunction component2() {
        return this.function;
    }

    public final CJPayBehavior component3() {
        return this.behavior;
    }

    public final CJPayUserState component4() {
        return this.userState;
    }

    public final CJPayRetainContactInfo copy(CJPayProcess r100, CJPayFunction r101, CJPayBehavior r102, CJPayUserState r103) {
        Intrinsics.checkNotNullParameter(r100, "process");
        return new CJPayRetainContactInfo(r100, r101, r102, r103);
    }

    public final String formatString() {
        StringBuilder r100 = new StringBuilder();
        Object r101 = this.process;
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.append(r101);
        r100.append('_');
        Object r103 = this.function;
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r100.append(r103);
        r100.append('_');
        Object r104 = this.behavior;
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        r100.append(r104);
        r100.append('_');
        CJPayUserState r105 = this.userState;
        if (r105 == null) goto L17;
        String r106 = r105.formatString();
        if (r106 == null) goto L17;
        r102 = r106;
    L17:
        r100.append(r102);
        return r100.toString();
    }

    public int hashCode() {
        CJPayProcess r100 = this.process;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        CJPayFunction r104 = this.function;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        CJPayBehavior r107 = this.behavior;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        CJPayUserState r110 = this.userState;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final JSONObject toJsonObject() {
        JSONObject r100 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r100, "process", this.process);
        CJPayFunction r101 = this.function;
        if (r101 == null) goto L5;
        KtSafeMethodExtensionKt.safePut(r100, "function", r101);
    L5:
        CJPayBehavior r102 = this.behavior;
        if (r102 == null) goto L8;
        KtSafeMethodExtensionKt.safePut(r100, "behavior", r102);
    L8:
        CJPayUserState r103 = this.userState;
        if (r103 == null) goto L11;
        KtSafeMethodExtensionKt.safePut(r100, UserInfo.USERSTATE, r103.formatString());
    L11:
        return r100;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("CJPayRetainContactInfo(process=");
        r100.append(this.process);
        r100.append(", function=");
        r100.append(this.function);
        r100.append(", behavior=");
        r100.append(this.behavior);
        r100.append(", userState=");
        CJPayUserState r101 = this.userState;
        if (r101 == null) goto L6;
        String r102 = r101.formatString();
        if (r102 == null) goto L6;
    L7:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L6:
        r102 = "";
        goto L7
    }

    public final CJPayBehavior getBehavior() {
        return this.behavior;
    }

    public final CJPayFunction getFunction() {
        return this.function;
    }

    public final CJPayProcess getProcess() {
        return this.process;
    }

    public final CJPayUserState getUserState() {
        return this.userState;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(CJPayRetainContactInfo.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean.CJPayRetainContactInfo");
        CJPayRetainContactInfo r102 = (CJPayRetainContactInfo) r100;
        if (this.process == r102.process) goto L16;
        return false;
    L16:
        if (this.function == r102.function) goto L19;
        return false;
    L19:
        if (this.behavior == r102.behavior) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.userState, r102.userState) == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public CJPayRetainContactInfo(CJPayProcess r100, CJPayFunction r101, CJPayBehavior r102, CJPayUserState r103) {
        Intrinsics.checkNotNullParameter(r100, "process");
        this.process = r100;
        this.function = r101;
        this.behavior = r102;
        this.userState = r103;
    }

    public /* synthetic */ CJPayRetainContactInfo(CJPayProcess r100, CJPayFunction r101, CJPayBehavior r102, CJPayUserState r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        this(r100, r101, r102, r103);
    }
}
