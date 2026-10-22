package com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import juc.d;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;
import nuc.v2;
import ouc.d0;
import ouc.f0;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002./B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nBM\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\fHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013¨\u00060"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayGrowthDecisionResponseBody;", "", "growthModelViews", "", "exts", "Lkotlinx/serialization/json/JsonObject;", "commonParams", "code", "msg", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGrowthModelViews$annotations", "()V", "getGrowthModelViews", "()Ljava/lang/String;", "getExts$annotations", "getExts", "()Lkotlinx/serialization/json/JsonObject;", "getCommonParams$annotations", "getCommonParams", "getCode", "getMsg", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cj_common_release", "$serializer", "Companion", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class CJPayGrowthDecisionResponseBody {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final String code;
    private final d0 commonParams;
    private final d0 exts;
    private final String growthModelViews;
    private final String msg;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayGrowthDecisionResponseBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayGrowthDecisionResponseBody;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<CJPayGrowthDecisionResponseBody> serializer() {
            return CJPayGrowthDecisionResponseBody$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public CJPayGrowthDecisionResponseBody() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ CJPayGrowthDecisionResponseBody copy$default(CJPayGrowthDecisionResponseBody r100, String r101, d0 r102, d0 r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.growthModelViews;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.exts;
    L8:
        d0 r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.commonParams;
    L11:
        d0 r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.code;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.msg;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    @SerialName("common_params")
    public static /* synthetic */ void getCommonParams$annotations() {
    }

    @SerialName("exts")
    public static /* synthetic */ void getExts$annotations() {
    }

    @SerialName("growth_model_views")
    public static /* synthetic */ void getGrowthModelViews$annotations() {
    }

    public final String component1() {
        return this.growthModelViews;
    }

    public final d0 component2() {
        return this.exts;
    }

    public final d0 component3() {
        return this.commonParams;
    }

    public final String component4() {
        return this.code;
    }

    public final String component5() {
        return this.msg;
    }

    public final CJPayGrowthDecisionResponseBody copy(String r100, d0 r101, d0 r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r101, "exts");
        Intrinsics.checkNotNullParameter(r110, "commonParams");
        return new CJPayGrowthDecisionResponseBody(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPayGrowthDecisionResponseBody) == true) goto L8;
        return false;
    L8:
        CJPayGrowthDecisionResponseBody r101 = (CJPayGrowthDecisionResponseBody) r100;
        if (Intrinsics.areEqual(this.growthModelViews, r101.growthModelViews) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.exts, r101.exts) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.commonParams, r101.commonParams) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.code, r101.code) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.growthModelViews;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.exts.hashCode()) * 31) + this.commonParams.hashCode()) * 31;
        String r104 = this.code;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.msg;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CJPayGrowthDecisionResponseBody(growthModelViews=" + this.growthModelViews + ", exts=" + this.exts + ", commonParams=" + this.commonParams + ", code=" + this.code + ", msg=" + this.msg + ')';
    }

    public final String getCode() {
        return this.code;
    }

    public final d0 getCommonParams() {
        return this.commonParams;
    }

    public final d0 getExts() {
        return this.exts;
    }

    public final String getGrowthModelViews() {
        return this.growthModelViews;
    }

    public final String getMsg() {
        return this.msg;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cj_common_release(CJPayGrowthDecisionResponseBody r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.growthModelViews);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeSerializableElement(r102, 1, f0.f526848a, r100.exts);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeSerializableElement(r102, 2, f0.f526848a, r100.commonParams);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.code);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        r103 = true;
    L44:
        if (r103 == false) goto L47;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.msg);
        return;
    L47:
        return;
    L42:
        if (r100.msg == null) goto L44;
    L33:
        if (r100.code != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (Intrinsics.areEqual(r100.commonParams, new d0(MapsKt.emptyMap())) == false) goto L22;
        r106 = false;
        goto L27
    L15:
        if (Intrinsics.areEqual(r100.exts, new d0(MapsKt.emptyMap())) == false) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.growthModelViews != null) goto L4;
        r104 = false;
        goto L9
    }

    public CJPayGrowthDecisionResponseBody(String r100, d0 r101, d0 r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "exts");
        Intrinsics.checkNotNullParameter(r102, "commonParams");
        this.growthModelViews = r100;
        this.exts = r101;
        this.commonParams = r102;
        this.code = r103;
        this.msg = r104;
    }

    public /* synthetic */ CJPayGrowthDecisionResponseBody(int r100, String r101, d0 r102, d0 r103, String r104, String r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, CJPayGrowthDecisionResponseBody$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.growthModelViews = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.exts = new d0(MapsKt.emptyMap());
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.commonParams = new d0(MapsKt.emptyMap());
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.code = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.msg = null;
        return;
    L23:
        this.msg = r105;
        return;
    L19:
        this.code = r104;
        goto L21
    L15:
        this.commonParams = r103;
        goto L17
    L11:
        this.exts = r102;
        goto L13
    L7:
        this.growthModelViews = r101;
        goto L9
    }

    public /* synthetic */ CJPayGrowthDecisionResponseBody(String r100, d0 r101, d0 r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        r101 = new d0(MapsKt.emptyMap());
    L9:
        d0 r105 = r101;
        if ((r110 & 4) == 0) goto L12;
        r102 = new d0(MapsKt.emptyMap());
    L12:
        d0 r106 = r102;
        if ((r110 & 8) == 0) goto L15;
        String r107 = null;
    L17:
        if ((r110 & 16) == 0) goto L19;
        String r113 = null;
    L20:
        this(r112, r105, r106, r107, r113);
        return;
    L19:
        r113 = r104;
        goto L20
    L15:
        r107 = r103;
        goto L17
    L5:
        r112 = r100;
        goto L7
    }
}
