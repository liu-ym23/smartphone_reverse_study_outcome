package com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api;

import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.UnknownFieldException;
import kuc.a;
import luc.f;
import muc.c;
import muc.e;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import ouc.d0;
import ouc.f0;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayGrowthDecisionResponseBody.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayGrowthDecisionResponseBody;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class CJPayGrowthDecisionResponseBody$$serializer implements m0<CJPayGrowthDecisionResponseBody> {
    public static final int $stable = 0;
    public static final CJPayGrowthDecisionResponseBody$$serializer INSTANCE = null;
    private static final f descriptor = null;

    private CJPayGrowthDecisionResponseBody$$serializer() {
    }

    @Override // nuc.m0
    public final d<?>[] childSerializers() {
        v2 r100 = v2.f520790a;
        f0 r101 = f0.f526848a;
        return new d[]{a.d(r100), r101, r101, a.d(r100), a.d(r100)};
    }

    @Override // juc.d, juc.n, juc.c
    public final f getDescriptor() {
        return descriptor;
    }

    static {
        CJPayGrowthDecisionResponseBody$$serializer r100 = new CJPayGrowthDecisionResponseBody$$serializer();
        INSTANCE = r100;
        $stable = 8;
        g2 r101 = new g2("com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CJPayGrowthDecisionResponseBody", r100, 5);
        r101.j("growth_model_views", true);
        r101.j("exts", true);
        r101.j("common_params", true);
        r101.j("code", true);
        r101.j("msg", true);
        descriptor = r101;
    }

    @Override // nuc.m0
    public d<?>[] typeParametersSerializers() {
        return i2.f520710a;
    }

    @Override // juc.c
    public final CJPayGrowthDecisionResponseBody deserialize(e r210) {
        Intrinsics.checkNotNullParameter(r210, "decoder");
        f r100 = descriptor;
        c r101 = r210.beginStructure(r100);
        String r102 = null;
        if (r101.decodeSequentially() == false) goto L5;
        v2 r103 = v2.f520790a;
        String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
        f0 r105 = f0.f526848a;
        d0 r106 = (d0) r101.decodeSerializableElement(r100, 1, r105, null);
        d0 r107 = (d0) r101.decodeSerializableElement(r100, 2, r105, null);
        String r108 = (String) r101.decodeNullableSerializableElement(r100, 3, r103, null);
        String r211 = (String) r101.decodeNullableSerializableElement(r100, 4, r103, null);
        String r110 = r108;
        d0 r111 = r107;
        d0 r112 = r106;
        String r113 = r104;
        int r114 = 31;
    L23:
        r101.endStructure(r100);
        return new CJPayGrowthDecisionResponseBody(r114, r113, r112, r111, r110, r211, null);
    L5:
        d0 r109 = null;
        d0 r115 = null;
        String r116 = null;
        String r117 = null;
        int r118 = 0;
        boolean r119 = true;
    L6:
        if (r119 == false) goto L22;
        int r120 = r101.decodeElementIndex(r100);
        if (r120 != (-1)) goto L9;
        r119 = false;
        goto L6
    L9:
        if (r120 != 0) goto L10;
        r102 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r102);
        r118 = r118 | 1;
        goto L6
    L10:
        if (r120 != 1) goto L11;
        r109 = (d0) r101.decodeSerializableElement(r100, 1, f0.f526848a, r109);
        r118 = r118 | 2;
        goto L6
    L11:
        if (r120 != 2) goto L12;
        r115 = (d0) r101.decodeSerializableElement(r100, 2, f0.f526848a, r115);
        r118 = r118 | 4;
        goto L6
    L12:
        if (r120 != 3) goto L13;
        r116 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r116);
        r118 = r118 | 8;
        goto L6
    L13:
        if (r120 != 4) goto L16;
        r117 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r117);
        r118 = r118 | 16;
        goto L6
    L16:
        throw new UnknownFieldException(r120);
    L22:
        r114 = r118;
        r113 = r102;
        r112 = r109;
        r111 = r115;
        r110 = r116;
        r211 = r117;
        goto L23
    }

    @Override // juc.c
    public /* bridge */ /* synthetic */ Object deserialize(e r100) {
        return deserialize(r100);
    }

    public final void serialize(muc.f r100, CJPayGrowthDecisionResponseBody r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r101, "value");
        f r102 = descriptor;
        muc.d r103 = r100.beginStructure(r102);
        CJPayGrowthDecisionResponseBody.write$Self$cj_common_release(r101, r103, r102);
        r103.endStructure(r102);
    }

    @Override // juc.n
    public /* bridge */ /* synthetic */ void serialize(muc.f r100, Object r101) {
        serialize(r100, (CJPayGrowthDecisionResponseBody) r101);
    }
}
