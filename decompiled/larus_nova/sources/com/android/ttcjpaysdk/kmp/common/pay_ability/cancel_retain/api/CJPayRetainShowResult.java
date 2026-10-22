package com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J0\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainShowResult;", "", "isShown", "", "errorCode", "", "errorMsg", "", "<init>", "(ZLjava/lang/Integer;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "()Z", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrorMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(ZLjava/lang/Integer;Ljava/lang/String;)Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainShowResult;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cj_common_release", "$serializer", "Companion", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class CJPayRetainShowResult {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final Integer errorCode;
    private final String errorMsg;
    private final boolean isShown;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainShowResult$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainShowResult;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<CJPayRetainShowResult> serializer() {
            return CJPayRetainShowResult$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ CJPayRetainShowResult copy$default(CJPayRetainShowResult r100, boolean r101, Integer r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.isShown;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.errorCode;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.errorMsg;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.isShown;
    }

    public final Integer component2() {
        return this.errorCode;
    }

    public final String component3() {
        return this.errorMsg;
    }

    public final CJPayRetainShowResult copy(boolean r100, Integer r101, String r102) {
        return new CJPayRetainShowResult(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPayRetainShowResult) == true) goto L8;
        return false;
    L8:
        CJPayRetainShowResult r101 = (CJPayRetainShowResult) r100;
        if (this.isShown == r101.isShown) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorCode, r101.errorCode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.errorMsg, r101.errorMsg) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.isShown == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        Integer r102 = this.errorCode;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.errorMsg;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "CJPayRetainShowResult(isShown=" + this.isShown + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ')';
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final boolean isShown() {
        return this.isShown;
    }

    public CJPayRetainShowResult(boolean r100, Integer r101, String r102) {
        this.isShown = r100;
        this.errorCode = r101;
        this.errorMsg = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cj_common_release(CJPayRetainShowResult r100, muc.d r101, f r102) {
        boolean r103 = false;
        r101.encodeBooleanElement(r102, 0, r100.isShown);
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 1, w0.f520792a, r100.errorCode);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L15;
    L13:
        r103 = true;
    L17:
        if (r103 == false) goto L20;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.errorMsg);
        return;
    L20:
        return;
    L15:
        if (r100.errorMsg == null) goto L17;
    L6:
        if (r100.errorCode != null) goto L4;
        r104 = false;
        goto L9
    }

    public /* synthetic */ CJPayRetainShowResult(int r100, boolean r101, Integer r102, String r103, q2 r104) {
        if (1 != (r100 & 1)) goto L13;
        this.isShown = r101;
        if ((r100 & 2) != 0) goto L7;
        this.errorCode = null;
    L9:
        if ((r100 & 4) != 0) goto L11;
        this.errorMsg = null;
        return;
    L11:
        this.errorMsg = r103;
        return;
    L7:
        this.errorCode = r102;
        goto L9
    L13:
        b2.b(r100, 1, CJPayRetainShowResult$$serializer.INSTANCE.getDescriptor());
        throw null;
    }

    public /* synthetic */ CJPayRetainShowResult(boolean r100, Integer r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
