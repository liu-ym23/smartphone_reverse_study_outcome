package com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api;

import com.android.ttcjpaysdk.thirdparty.counter.data.QueryPromotionAfterPayInfo;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import juc.d;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u0006\u0010\r\u001a\u00020\u000eJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayGrowthDecisionResponse;", "", "response", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayGrowthDecisionResponseBody;", "<init>", "(Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayGrowthDecisionResponseBody;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayGrowthDecisionResponseBody;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getResponse", "()Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayGrowthDecisionResponseBody;", "isSuccess", "", "component1", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cj_common_release", "$serializer", "Companion", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class CJPayGrowthDecisionResponse {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final CJPayGrowthDecisionResponseBody response;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayGrowthDecisionResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayGrowthDecisionResponse;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<CJPayGrowthDecisionResponse> serializer() {
            return CJPayGrowthDecisionResponse$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CJPayGrowthDecisionResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CJPayGrowthDecisionResponse copy$default(CJPayGrowthDecisionResponse r100, CJPayGrowthDecisionResponseBody r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.response;
    L6:
        return r100.copy(r101);
    }

    public final CJPayGrowthDecisionResponseBody component1() {
        return this.response;
    }

    public final CJPayGrowthDecisionResponse copy(CJPayGrowthDecisionResponseBody r100) {
        return new CJPayGrowthDecisionResponse(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPayGrowthDecisionResponse) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.response, ((CJPayGrowthDecisionResponse) r100).response) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        CJPayGrowthDecisionResponseBody r100 = this.response;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "CJPayGrowthDecisionResponse(response=" + this.response + ')';
    }

    public final boolean isSuccess() {
        String[] r100 = {"CD0000", "CD000000", "UM0000", "MB0000", "MP000000", "CA0000", "PP0000", QueryPromotionAfterPayInfo.SUCCESS_CODE, "QP0000"};
        CJPayGrowthDecisionResponseBody r101 = this.response;
        if (r101 == null) goto L5;
        String r102 = r101.getCode();
    L7:
        return ArraysKt.contains(r100, r102);
    L5:
        r102 = null;
        goto L7
    }

    public final CJPayGrowthDecisionResponseBody getResponse() {
        return this.response;
    }

    public CJPayGrowthDecisionResponse(CJPayGrowthDecisionResponseBody r100) {
        this.response = r100;
    }

    public /* synthetic */ CJPayGrowthDecisionResponse(int r100, CJPayGrowthDecisionResponseBody r101, q2 r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, CJPayGrowthDecisionResponse$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.response = null;
        return;
    L7:
        this.response = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cj_common_release(CJPayGrowthDecisionResponse r100, muc.d r101, f r102) {
        boolean r103 = true;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L9:
        if (r103 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, CJPayGrowthDecisionResponseBody$$serializer.INSTANCE, r100.response);
        return;
    L12:
        return;
    L6:
        if (r100.response != null) goto L9;
        r103 = false;
        goto L9
    }

    public /* synthetic */ CJPayGrowthDecisionResponse(CJPayGrowthDecisionResponseBody r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
