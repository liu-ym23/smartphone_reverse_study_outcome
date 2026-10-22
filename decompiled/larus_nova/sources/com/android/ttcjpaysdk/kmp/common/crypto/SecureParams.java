package com.android.ttcjpaysdk.kmp.common.crypto;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.List;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import nuc.b2;
import nuc.f;
import nuc.q2;
import nuc.v2;
import y0.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bBK\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003JA\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\tHÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/crypto/SecureParams;", "", "version", "", "type1", "type2", "check", SlcCommonAction.KEY_PARAMS, "", "", "<init>", "(IIIILjava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIIILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVersion", "()I", "getType1", "getType2", "getCheck", "getFields", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cj_common_release", "$serializer", "Companion", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class SecureParams {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final int check;
    private final List<String> fields;
    private final int type1;
    private final int type2;
    private final int version;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/crypto/SecureParams$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/android/ttcjpaysdk/kmp/common/crypto/SecureParams;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<SecureParams> serializer() {
            return SecureParams$$serializer.INSTANCE;
        }
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new f(v2.f520790a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SecureParams copy$default(SecureParams r100, int r101, int r102, int r103, int r104, List r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.version;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.type1;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.type2;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.check;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.fields;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.version;
    }

    public final int component2() {
        return this.type1;
    }

    public final int component3() {
        return this.type2;
    }

    public final int component4() {
        return this.check;
    }

    public final List<String> component5() {
        return this.fields;
    }

    public final SecureParams copy(int r100, int r101, int r110, int r111, List<String> r112) {
        Intrinsics.checkNotNullParameter(r112, SlcCommonAction.KEY_PARAMS);
        return new SecureParams(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SecureParams) == true) goto L8;
        return false;
    L8:
        SecureParams r101 = (SecureParams) r100;
        if (this.version == r101.version) goto L12;
        return false;
    L12:
        if (this.type1 == r101.type1) goto L15;
        return false;
    L15:
        if (this.type2 == r101.type2) goto L18;
        return false;
    L18:
        if (this.check == r101.check) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fields, r101.fields) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.version * 31) + this.type1) * 31) + this.type2) * 31) + this.check) * 31) + this.fields.hashCode();
    }

    public String toString() {
        return "SecureParams(version=" + this.version + ", type1=" + this.type1 + ", type2=" + this.type2 + ", check=" + this.check + ", fields=" + this.fields + ')';
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        $childSerializers = new Lazy[]{null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new a())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final int getCheck() {
        return this.check;
    }

    public final List<String> getFields() {
        return this.fields;
    }

    public final int getType1() {
        return this.type1;
    }

    public final int getType2() {
        return this.type2;
    }

    public final int getVersion() {
        return this.version;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cj_common_release(SecureParams r100, muc.d r101, luc.f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeIntElement(r102, 0, r100.version);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeIntElement(r102, 1, r100.type1);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeIntElement(r102, 2, r100.type2);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        r104 = true;
    L35:
        if (r104 == false) goto L37;
        r101.encodeIntElement(r102, 3, r100.check);
    L37:
        r101.encodeSerializableElement(r102, 4, r103[4].getValue(), r100.fields);
        return;
    L33:
        if (r100.check == 1) goto L35;
    L24:
        if (r100.type2 != 1) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.type1 != 2) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.version != 20) goto L4;
        r105 = false;
        goto L9
    }

    public SecureParams(int r100, int r101, int r102, int r103, List<String> r104) {
        Intrinsics.checkNotNullParameter(r104, SlcCommonAction.KEY_PARAMS);
        this.version = r100;
        this.type1 = r101;
        this.type2 = r102;
        this.check = r103;
        this.fields = r104;
    }

    public /* synthetic */ SecureParams(int r100, int r101, int r102, int r103, int r104, List r105, q2 r106) {
        if (16 == (r100 & 16)) goto L5;
        b2.b(r100, 16, SecureParams$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = 20;
    L7:
        this.version = r101;
        if ((r100 & 2) != 0) goto L10;
        this.type1 = 2;
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.type2 = 1;
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.check = 1;
    L19:
        this.fields = r105;
        return;
    L18:
        this.check = r104;
        goto L19
    L14:
        this.type2 = r103;
        goto L16
    L10:
        this.type1 = r102;
        goto L12
    }

    public /* synthetic */ SecureParams(int r100, int r101, int r102, int r110, List r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        int r103 = 20;
    L7:
        if ((r112 & 2) == 0) goto L9;
        int r104 = 2;
    L11:
        if ((r112 & 4) == 0) goto L13;
        int r105 = 1;
    L15:
        if ((r112 & 8) == 0) goto L17;
        int r106 = 1;
    L18:
        this(r103, r104, r105, r106, r111);
        return;
    L17:
        r106 = r110;
        goto L18
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r103 = r100;
        goto L7
    }
}
