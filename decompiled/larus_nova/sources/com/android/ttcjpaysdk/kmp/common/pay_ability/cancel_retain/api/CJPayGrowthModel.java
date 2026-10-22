package com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import java.util.List;
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
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import nuc.b2;
import nuc.f;
import nuc.q2;
import nuc.v2;
import ouc.d0;
import ouc.f0;
import z0.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bBI\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J9\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\rHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\b/R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u001d¨\u00062"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayGrowthModel;", "", "growthType", "", "viewModelList", "", "Lkotlinx/serialization/json/JsonObject;", "exts", "contactInfo", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainContactInfo;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/json/JsonObject;Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainContactInfo;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/json/JsonObject;Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainContactInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGrowthType$annotations", "()V", "getGrowthType", "()Ljava/lang/String;", "getViewModelList$annotations", "getViewModelList", "()Ljava/util/List;", "getExts$annotations", "getExts", "()Lkotlinx/serialization/json/JsonObject;", "getContactInfo$annotations", "getContactInfo", "()Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainContactInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cj_common_release", "$serializer", "Companion", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class CJPayGrowthModel {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final CJPayRetainContactInfo contactInfo;
    private final d0 exts;
    private final String growthType;
    private final List<d0> viewModelList;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayGrowthModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayGrowthModel;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<CJPayGrowthModel> serializer() {
            return CJPayGrowthModel$$serializer.INSTANCE;
        }
    }

    public CJPayGrowthModel() {
        this(null, null, null, null, 15, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new f(f0.f526848a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CJPayGrowthModel copy$default(CJPayGrowthModel r100, String r101, List r102, d0 r103, CJPayRetainContactInfo r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.growthType;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.viewModelList;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.exts;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.contactInfo;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    @SerialName(DocCallbackImpl.KEY_CONTACT_INFO)
    public static /* synthetic */ void getContactInfo$annotations() {
    }

    @SerialName("exts")
    public static /* synthetic */ void getExts$annotations() {
    }

    @SerialName("growth_type")
    public static /* synthetic */ void getGrowthType$annotations() {
    }

    @SerialName("view_model_list")
    public static /* synthetic */ void getViewModelList$annotations() {
    }

    public final String component1() {
        return this.growthType;
    }

    public final List<d0> component2() {
        return this.viewModelList;
    }

    public final d0 component3() {
        return this.exts;
    }

    public final CJPayRetainContactInfo component4() {
        return this.contactInfo;
    }

    public final CJPayGrowthModel copy(String r100, List<d0> r101, d0 r102, CJPayRetainContactInfo r103) {
        Intrinsics.checkNotNullParameter(r101, "viewModelList");
        Intrinsics.checkNotNullParameter(r102, "exts");
        Intrinsics.checkNotNullParameter(r103, "contactInfo");
        return new CJPayGrowthModel(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPayGrowthModel) == true) goto L8;
        return false;
    L8:
        CJPayGrowthModel r101 = (CJPayGrowthModel) r100;
        if (Intrinsics.areEqual(this.growthType, r101.growthType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.viewModelList, r101.viewModelList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.exts, r101.exts) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.contactInfo, r101.contactInfo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.growthType;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((r101 * 31) + this.viewModelList.hashCode()) * 31) + this.exts.hashCode()) * 31) + this.contactInfo.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "CJPayGrowthModel(growthType=" + this.growthType + ", viewModelList=" + this.viewModelList + ", exts=" + this.exts + ", contactInfo=" + this.contactInfo + ')';
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        $childSerializers = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new a()), null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final CJPayRetainContactInfo getContactInfo() {
        return this.contactInfo;
    }

    public final d0 getExts() {
        return this.exts;
    }

    public final String getGrowthType() {
        return this.growthType;
    }

    public final List<d0> getViewModelList() {
        return this.viewModelList;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cj_common_release(CJPayGrowthModel r110, muc.d r111, luc.f r112) {
        Lazy<d<Object>>[] r100 = $childSerializers;
        boolean r101 = false;
        if (r111.shouldEncodeElementDefault(r112, 0) == false) goto L6;
    L4:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        r111.encodeNullableSerializableElement(r112, 0, v2.f520790a, r110.growthType);
    L12:
        if (r111.shouldEncodeElementDefault(r112, 1) == false) goto L15;
    L13:
        boolean r103 = true;
    L18:
        if (r103 == false) goto L21;
        r111.encodeSerializableElement(r112, 1, r100[1].getValue(), r110.viewModelList);
    L21:
        if (r111.shouldEncodeElementDefault(r112, 2) == false) goto L24;
    L22:
        boolean r104 = true;
    L27:
        if (r104 == false) goto L30;
        r111.encodeSerializableElement(r112, 2, f0.f526848a, r110.exts);
    L30:
        if (r111.shouldEncodeElementDefault(r112, 3) == false) goto L33;
    L31:
        r101 = true;
    L35:
        if (r101 == false) goto L38;
        r111.encodeSerializableElement(r112, 3, CJPayRetainContactInfo$$serializer.INSTANCE, r110.contactInfo);
        return;
    L38:
        return;
    L33:
        if (Intrinsics.areEqual(r110.contactInfo, new CJPayRetainContactInfo(null, null, null, null, 15, null)) == true) goto L35;
    L24:
        if (Intrinsics.areEqual(r110.exts, new d0(MapsKt.emptyMap())) == false) goto L22;
        r104 = false;
        goto L27
    L15:
        if (Intrinsics.areEqual(r110.viewModelList, CollectionsKt.emptyList()) == false) goto L13;
        r103 = false;
        goto L18
    L6:
        if (r110.growthType != null) goto L4;
        r102 = false;
        goto L9
    }

    public CJPayGrowthModel(String r100, List<d0> r101, d0 r102, CJPayRetainContactInfo r103) {
        Intrinsics.checkNotNullParameter(r101, "viewModelList");
        Intrinsics.checkNotNullParameter(r102, "exts");
        Intrinsics.checkNotNullParameter(r103, "contactInfo");
        this.growthType = r100;
        this.viewModelList = r101;
        this.exts = r102;
        this.contactInfo = r103;
    }

    public /* synthetic */ CJPayGrowthModel(int r100, String r101, List r110, d0 r111, CJPayRetainContactInfo r112, q2 r113) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, CJPayGrowthModel$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.growthType = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.viewModelList = CollectionsKt.emptyList();
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.exts = new d0(MapsKt.emptyMap());
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.contactInfo = new CJPayRetainContactInfo(null, null, null, null, 15, null);
        return;
    L19:
        this.contactInfo = r112;
        return;
    L15:
        this.exts = r111;
        goto L17
    L11:
        this.viewModelList = r110;
        goto L13
    L7:
        this.growthType = r101;
        goto L9
    }

    public /* synthetic */ CJPayGrowthModel(String r100, List r101, d0 r110, CJPayRetainContactInfo r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r112 & 2) == 0) goto L9;
        r101 = CollectionsKt.emptyList();
    L9:
        if ((r112 & 4) == 0) goto L12;
        r110 = new d0(MapsKt.emptyMap());
    L12:
        if ((r112 & 8) == 0) goto L14;
        r111 = new CJPayRetainContactInfo(null, null, null, null, 15, null);
    L14:
        this(r100, r101, r110, r111);
    }
}
