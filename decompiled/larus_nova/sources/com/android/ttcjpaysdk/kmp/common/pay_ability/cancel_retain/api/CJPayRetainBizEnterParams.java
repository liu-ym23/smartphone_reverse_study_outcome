package com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api;

import com.alipay.sdk.m.s.a;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.List;
import java.util.Map;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import nuc.a1;
import nuc.b2;
import nuc.f;
import nuc.q2;
import nuc.v2;
import ouc.d0;
import ouc.f0;
import z0.b;
import z0.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0002EFB\u009b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015B«\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0014\u0010\u001aJ\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\t\u00102\u001a\u00020\nHÆ\u0003J\u0015\u00103\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000eHÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003J\t\u00105\u001a\u00020\nHÆ\u0003J\t\u00106\u001a\u00020\u0012HÆ\u0003J\t\u00107\u001a\u00020\u0012HÆ\u0003J\u009d\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0012HÆ\u0001J\u0013\u00109\u001a\u00020\u00122\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0017HÖ\u0001J\t\u0010<\u001a\u00020\nHÖ\u0001J%\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0001¢\u0006\u0002\bDR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0011\u0010\u0010\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010*R\u0011\u0010\u0013\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010*¨\u0006G"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainBizEnterParams;", "", "processInfo", "Lkotlinx/serialization/json/JsonObject;", "assetMetaInfo", "combineAssetMetaInfo", a.f25767y, "selectMetaInfos", "", "merchantId", "", "appId", "tradeNo", "commonTrackParams", "", "currentVerifyType", "primaryCategory", "isBioDegrade", "", "isSupportBio", "<init>", "(Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ZZ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProcessInfo", "()Lkotlinx/serialization/json/JsonObject;", "getAssetMetaInfo", "getCombineAssetMetaInfo", "getExtInfo", "getSelectMetaInfos", "()Ljava/util/List;", "getMerchantId", "()Ljava/lang/String;", "getAppId", "getTradeNo", "getCommonTrackParams", "()Ljava/util/Map;", "getCurrentVerifyType", "getPrimaryCategory", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cj_common_release", "$serializer", "Companion", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class CJPayRetainBizEnterParams {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final String appId;
    private final d0 assetMetaInfo;
    private final d0 combineAssetMetaInfo;
    private final Map<String, String> commonTrackParams;
    private final String currentVerifyType;
    private final d0 extInfo;
    private final boolean isBioDegrade;
    private final boolean isSupportBio;
    private final String merchantId;
    private final String primaryCategory;
    private final d0 processInfo;
    private final List<d0> selectMetaInfos;
    private final String tradeNo;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainBizEnterParams$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainBizEnterParams;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<CJPayRetainBizEnterParams> serializer() {
            return CJPayRetainBizEnterParams$$serializer.INSTANCE;
        }
    }

    public CJPayRetainBizEnterParams() {
        this(null, null, null, null, null, null, null, null, null, null, null, false, false, 8191, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new f(f0.f526848a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_$0();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CJPayRetainBizEnterParams copy$default(CJPayRetainBizEnterParams r110, d0 r111, d0 r112, d0 r113, d0 r114, List r115, String r210, String r211, String r212, Map r213, String r214, String r215, boolean r216, boolean r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        d0 r100 = r110.processInfo;
    L7:
        if ((r218 & 2) == 0) goto L9;
        d0 r101 = r110.assetMetaInfo;
    L11:
        if ((r218 & 4) == 0) goto L13;
        d0 r102 = r110.combineAssetMetaInfo;
    L15:
        if ((r218 & 8) == 0) goto L17;
        d0 r103 = r110.extInfo;
    L19:
        if ((r218 & 16) == 0) goto L21;
        List r104 = r110.selectMetaInfos;
    L23:
        if ((r218 & 32) == 0) goto L25;
        String r105 = r110.merchantId;
    L27:
        if ((r218 & 64) == 0) goto L29;
        String r106 = r110.appId;
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r107 = r110.tradeNo;
    L35:
        if ((r218 & 256) == 0) goto L37;
        Map r116 = r110.commonTrackParams;
    L39:
        if ((r218 & 512) == 0) goto L41;
        String r117 = r110.currentVerifyType;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        String r118 = r110.primaryCategory;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        boolean r119 = r110.isBioDegrade;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        boolean r108 = r110.isSupportBio;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r217;
        goto L55
    L49:
        r119 = r216;
        goto L51
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final d0 component1() {
        return this.processInfo;
    }

    public final String component10() {
        return this.currentVerifyType;
    }

    public final String component11() {
        return this.primaryCategory;
    }

    public final boolean component12() {
        return this.isBioDegrade;
    }

    public final boolean component13() {
        return this.isSupportBio;
    }

    public final d0 component2() {
        return this.assetMetaInfo;
    }

    public final d0 component3() {
        return this.combineAssetMetaInfo;
    }

    public final d0 component4() {
        return this.extInfo;
    }

    public final List<d0> component5() {
        return this.selectMetaInfos;
    }

    public final String component6() {
        return this.merchantId;
    }

    public final String component7() {
        return this.appId;
    }

    public final String component8() {
        return this.tradeNo;
    }

    public final Map<String, String> component9() {
        return this.commonTrackParams;
    }

    public final CJPayRetainBizEnterParams copy(d0 r110, d0 r111, d0 r112, d0 r113, List<d0> r210, String r211, String r212, String r213, Map<String, String> r214, String r215, String r216, boolean r217, boolean r218) {
        Intrinsics.checkNotNullParameter(r110, "processInfo");
        Intrinsics.checkNotNullParameter(r111, "assetMetaInfo");
        Intrinsics.checkNotNullParameter(r112, "combineAssetMetaInfo");
        Intrinsics.checkNotNullParameter(r113, a.f25767y);
        Intrinsics.checkNotNullParameter(r210, "selectMetaInfos");
        Intrinsics.checkNotNullParameter(r211, "merchantId");
        Intrinsics.checkNotNullParameter(r212, "appId");
        Intrinsics.checkNotNullParameter(r213, "tradeNo");
        Intrinsics.checkNotNullParameter(r214, "commonTrackParams");
        Intrinsics.checkNotNullParameter(r215, "currentVerifyType");
        Intrinsics.checkNotNullParameter(r216, "primaryCategory");
        return new CJPayRetainBizEnterParams(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPayRetainBizEnterParams) == true) goto L8;
        return false;
    L8:
        CJPayRetainBizEnterParams r101 = (CJPayRetainBizEnterParams) r100;
        if (Intrinsics.areEqual(this.processInfo, r101.processInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.assetMetaInfo, r101.assetMetaInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.combineAssetMetaInfo, r101.combineAssetMetaInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extInfo, r101.extInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.selectMetaInfos, r101.selectMetaInfos) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.merchantId, r101.merchantId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.tradeNo, r101.tradeNo) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.commonTrackParams, r101.commonTrackParams) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.currentVerifyType, r101.currentVerifyType) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.primaryCategory, r101.primaryCategory) == true) goto L42;
        return false;
    L42:
        if (this.isBioDegrade == r101.isBioDegrade) goto L45;
        return false;
    L45:
        if (this.isSupportBio == r101.isSupportBio) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((((((((((((((this.processInfo.hashCode() * 31) + this.assetMetaInfo.hashCode()) * 31) + this.combineAssetMetaInfo.hashCode()) * 31) + this.extInfo.hashCode()) * 31) + this.selectMetaInfos.hashCode()) * 31) + this.merchantId.hashCode()) * 31) + this.appId.hashCode()) * 31) + this.tradeNo.hashCode()) * 31) + this.commonTrackParams.hashCode()) * 31) + this.currentVerifyType.hashCode()) * 31) + this.primaryCategory.hashCode()) * 31;
        int r101 = 1231;
        if (this.isBioDegrade == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.isSupportBio == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "CJPayRetainBizEnterParams(processInfo=" + this.processInfo + ", assetMetaInfo=" + this.assetMetaInfo + ", combineAssetMetaInfo=" + this.combineAssetMetaInfo + ", extInfo=" + this.extInfo + ", selectMetaInfos=" + this.selectMetaInfos + ", merchantId=" + this.merchantId + ", appId=" + this.appId + ", tradeNo=" + this.tradeNo + ", commonTrackParams=" + this.commonTrackParams + ", currentVerifyType=" + this.currentVerifyType + ", primaryCategory=" + this.primaryCategory + ", isBioDegrade=" + this.isBioDegrade + ", isSupportBio=" + this.isSupportBio + ')';
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, null, null, LazyKt.lazy(r100, new b()), null, null, null, LazyKt.lazy(r100, new c()), null, null, null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final d0 getAssetMetaInfo() {
        return this.assetMetaInfo;
    }

    public final d0 getCombineAssetMetaInfo() {
        return this.combineAssetMetaInfo;
    }

    public final Map<String, String> getCommonTrackParams() {
        return this.commonTrackParams;
    }

    public final String getCurrentVerifyType() {
        return this.currentVerifyType;
    }

    public final d0 getExtInfo() {
        return this.extInfo;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final String getPrimaryCategory() {
        return this.primaryCategory;
    }

    public final d0 getProcessInfo() {
        return this.processInfo;
    }

    public final List<d0> getSelectMetaInfos() {
        return this.selectMetaInfos;
    }

    public final String getTradeNo() {
        return this.tradeNo;
    }

    public final boolean isBioDegrade() {
        return this.isBioDegrade;
    }

    public final boolean isSupportBio() {
        return this.isSupportBio;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cj_common_release(CJPayRetainBizEnterParams r100, muc.d r101, luc.f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeSerializableElement(r102, 0, f0.f526848a, r100.processInfo);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeSerializableElement(r102, 1, f0.f526848a, r100.assetMetaInfo);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeSerializableElement(r102, 2, f0.f526848a, r100.combineAssetMetaInfo);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeSerializableElement(r102, 3, f0.f526848a, r100.extInfo);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeSerializableElement(r102, 4, r103[4].getValue(), r100.selectMetaInfos);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r110 = true;
    L54:
        if (r110 == false) goto L57;
        r101.encodeStringElement(r102, 5, r100.merchantId);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeStringElement(r102, 6, r100.appId);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r101.encodeStringElement(r102, 7, r100.tradeNo);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r101.encodeSerializableElement(r102, 8, r103[8].getValue(), r100.commonTrackParams);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r101.encodeStringElement(r102, 9, r100.currentVerifyType);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        boolean r115 = true;
    L99:
        if (r115 == false) goto L102;
        r101.encodeStringElement(r102, 10, r100.primaryCategory);
    L102:
        if (r101.shouldEncodeElementDefault(r102, 11) == false) goto L105;
    L103:
        boolean r116 = true;
    L108:
        if (r116 == false) goto L111;
        r101.encodeBooleanElement(r102, 11, r100.isBioDegrade);
    L111:
        if (r101.shouldEncodeElementDefault(r102, 12) == false) goto L114;
    L112:
        r104 = true;
    L116:
        if (r104 == false) goto L119;
        r101.encodeBooleanElement(r102, 12, r100.isSupportBio);
        return;
    L119:
        return;
    L114:
        if (r100.isSupportBio == false) goto L116;
    L105:
        if (r100.isBioDegrade == true) goto L103;
        r116 = false;
        goto L108
    L96:
        if (Intrinsics.areEqual(r100.primaryCategory, "") == false) goto L94;
        r115 = false;
        goto L99
    L87:
        if (Intrinsics.areEqual(r100.currentVerifyType, "") == false) goto L85;
        r114 = false;
        goto L90
    L78:
        if (Intrinsics.areEqual(r100.commonTrackParams, MapsKt.emptyMap()) == false) goto L76;
        r113 = false;
        goto L81
    L69:
        if (Intrinsics.areEqual(r100.tradeNo, "") == false) goto L67;
        r112 = false;
        goto L72
    L60:
        if (Intrinsics.areEqual(r100.appId, "") == false) goto L58;
        r111 = false;
        goto L63
    L51:
        if (Intrinsics.areEqual(r100.merchantId, "") == false) goto L49;
        r110 = false;
        goto L54
    L42:
        if (Intrinsics.areEqual(r100.selectMetaInfos, CollectionsKt.emptyList()) == false) goto L40;
        r109 = false;
        goto L45
    L33:
        if (Intrinsics.areEqual(r100.extInfo, new d0(MapsKt.emptyMap())) == false) goto L31;
        r108 = false;
        goto L36
    L24:
        if (Intrinsics.areEqual(r100.combineAssetMetaInfo, new d0(MapsKt.emptyMap())) == false) goto L22;
        r107 = false;
        goto L27
    L15:
        if (Intrinsics.areEqual(r100.assetMetaInfo, new d0(MapsKt.emptyMap())) == false) goto L13;
        r106 = false;
        goto L18
    L6:
        if (Intrinsics.areEqual(r100.processInfo, new d0(MapsKt.emptyMap())) == false) goto L4;
        r105 = false;
        goto L9
    }

    public CJPayRetainBizEnterParams(d0 r100, d0 r101, d0 r102, d0 r103, List<d0> r104, String r105, String r106, String r107, Map<String, String> r110, String r111, String r112, boolean r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "processInfo");
        Intrinsics.checkNotNullParameter(r101, "assetMetaInfo");
        Intrinsics.checkNotNullParameter(r102, "combineAssetMetaInfo");
        Intrinsics.checkNotNullParameter(r103, a.f25767y);
        Intrinsics.checkNotNullParameter(r104, "selectMetaInfos");
        Intrinsics.checkNotNullParameter(r105, "merchantId");
        Intrinsics.checkNotNullParameter(r106, "appId");
        Intrinsics.checkNotNullParameter(r107, "tradeNo");
        Intrinsics.checkNotNullParameter(r110, "commonTrackParams");
        Intrinsics.checkNotNullParameter(r111, "currentVerifyType");
        Intrinsics.checkNotNullParameter(r112, "primaryCategory");
        this.processInfo = r100;
        this.assetMetaInfo = r101;
        this.combineAssetMetaInfo = r102;
        this.extInfo = r103;
        this.selectMetaInfos = r104;
        this.merchantId = r105;
        this.appId = r106;
        this.tradeNo = r107;
        this.commonTrackParams = r110;
        this.currentVerifyType = r111;
        this.primaryCategory = r112;
        this.isBioDegrade = r113;
        this.isSupportBio = r114;
    }

    public /* synthetic */ CJPayRetainBizEnterParams(int r100, d0 r101, d0 r102, d0 r103, d0 r110, List r111, String r112, String r113, String r114, Map r115, String r116, String r117, boolean r118, boolean r119, q2 r210) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, CJPayRetainBizEnterParams$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        d0 r104 = new d0(MapsKt.emptyMap());
    L8:
        this.processInfo = r104;
        if ((r100 & 2) != 0) goto L11;
        d0 r105 = new d0(MapsKt.emptyMap());
    L12:
        this.assetMetaInfo = r105;
        if ((r100 & 4) != 0) goto L15;
        d0 r106 = new d0(MapsKt.emptyMap());
    L16:
        this.combineAssetMetaInfo = r106;
        if ((r100 & 8) != 0) goto L19;
        d0 r107 = new d0(MapsKt.emptyMap());
    L20:
        this.extInfo = r107;
        if ((r100 & 16) != 0) goto L23;
        List r108 = CollectionsKt.emptyList();
    L24:
        this.selectMetaInfos = r108;
        if ((r100 & 32) != 0) goto L27;
        this.merchantId = "";
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.appId = "";
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.tradeNo = "";
    L37:
        if ((r100 & 256) != 0) goto L39;
        Map r109 = MapsKt.emptyMap();
    L40:
        this.commonTrackParams = r109;
        if ((r100 & 512) != 0) goto L43;
        this.currentVerifyType = "";
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.primaryCategory = "";
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.isBioDegrade = false;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.isSupportBio = false;
        return;
    L55:
        this.isSupportBio = r119;
        return;
    L51:
        this.isBioDegrade = r118;
        goto L53
    L47:
        this.primaryCategory = r117;
        goto L49
    L43:
        this.currentVerifyType = r116;
        goto L45
    L39:
        r109 = r115;
        goto L40
    L35:
        this.tradeNo = r114;
        goto L37
    L31:
        this.appId = r113;
        goto L33
    L27:
        this.merchantId = r112;
        goto L29
    L23:
        r108 = r111;
        goto L24
    L19:
        r107 = r110;
        goto L20
    L15:
        r106 = r103;
        goto L16
    L11:
        r105 = r102;
        goto L12
    L7:
        r104 = r101;
        goto L8
    }

    public /* synthetic */ CJPayRetainBizEnterParams(d0 r110, d0 r111, d0 r112, d0 r113, List r114, String r210, String r211, String r212, Map r213, String r214, String r215, boolean r216, boolean r217, int r218, DefaultConstructorMarker r219) {
        if ((r218 & 1) == 0) goto L5;
        d0 r100 = new d0(MapsKt.emptyMap());
    L7:
        if ((r218 & 2) == 0) goto L9;
        d0 r101 = new d0(MapsKt.emptyMap());
    L11:
        if ((r218 & 4) == 0) goto L13;
        d0 r102 = new d0(MapsKt.emptyMap());
    L15:
        if ((r218 & 8) == 0) goto L17;
        d0 r103 = new d0(MapsKt.emptyMap());
    L19:
        if ((r218 & 16) == 0) goto L21;
        List r104 = CollectionsKt.emptyList();
    L22:
        String r105 = "";
        if ((r218 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r218 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r108 = "";
    L35:
        if ((r218 & 256) == 0) goto L37;
        Map r115 = MapsKt.emptyMap();
    L39:
        if ((r218 & 512) == 0) goto L41;
        String r116 = "";
    L43:
        if ((r218 & 1024) != 0) goto L46;
        r105 = r215;
    L46:
        boolean r117 = false;
        if ((r218 & 2048) == 0) goto L49;
        boolean r118 = false;
    L51:
        if ((r218 & 4096) != 0) goto L54;
        r117 = r217;
    L54:
        this(r100, r101, r102, r103, r104, r106, r107, r108, r115, r116, r105, r118, r117);
        return;
    L49:
        r118 = r216;
        goto L51
    L41:
        r116 = r214;
        goto L43
    L37:
        r115 = r213;
        goto L39
    L33:
        r108 = r212;
        goto L35
    L29:
        r107 = r211;
        goto L31
    L25:
        r106 = r210;
        goto L27
    L21:
        r104 = r114;
        goto L22
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
