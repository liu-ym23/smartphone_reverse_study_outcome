package com.uxsense.core.pattern;

import A9.d;
import A9.e;
import A9.f;
import B9.A;
import B9.F;
import B9.T;
import B9.V;
import B9.d0;
import B9.h0;
import C7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/core/pattern/ParentFilter.$serializer", "LB9/A;", "Lcom/uxsense/core/pattern/ParentFilter;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/core/pattern/ParentFilter;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/core/pattern/ParentFilter;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class ParentFilter$$serializer implements A {
    public static final ParentFilter$$serializer INSTANCE;
    private static final g descriptor;

    static {
        ParentFilter$$serializer parentFilter$$serializer = new ParentFilter$$serializer();
        INSTANCE = parentFilter$$serializer;
        V v10 = new V("com.uxsense.core.pattern.ParentFilter", parentFilter$$serializer, 5);
        v10.j("className", true);
        v10.j("classNameContains", true);
        v10.j("classNameRegex", true);
        v10.j("minChildCount", true);
        v10.j("maxChildCount", true);
        descriptor = v10;
    }

    private ParentFilter$$serializer() {
    }

    @Override // B9.A
    public final b[] childSerializers() {
        h0 h0Var = h0.f242a;
        b bVarG = AbstractC1451a.G(h0Var);
        b bVarG2 = AbstractC1451a.G(h0Var);
        b bVarG3 = AbstractC1451a.G(h0Var);
        F f = F.f218a;
        return new b[]{bVarG, bVarG2, bVarG3, AbstractC1451a.G(f), AbstractC1451a.G(f)};
    }

    @Override // x9.InterfaceC2123a
    public final ParentFilter deserialize(e decoder) {
        int i;
        String str;
        String str2;
        String str3;
        Integer num;
        Integer num2;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        String str4 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            h0 h0Var = h0.f242a;
            String str5 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 0, h0Var, null);
            String str6 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 1, h0Var, null);
            String str7 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 2, h0Var, null);
            F f = F.f218a;
            str3 = str7;
            num = (Integer) cVarBeginStructure.decodeNullableSerializableElement(gVar, 3, f, null);
            num2 = (Integer) cVarBeginStructure.decodeNullableSerializableElement(gVar, 4, f, null);
            i = 31;
            str2 = str6;
            str = str5;
        } else {
            boolean z10 = true;
            int i6 = 0;
            String str8 = null;
            String str9 = null;
            Integer num3 = null;
            Integer num4 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    str4 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 0, h0.f242a, str4);
                    i6 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    str8 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 1, h0.f242a, str8);
                    i6 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    str9 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 2, h0.f242a, str9);
                    i6 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    num3 = (Integer) cVarBeginStructure.decodeNullableSerializableElement(gVar, 3, F.f218a, num3);
                    i6 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    num4 = (Integer) cVarBeginStructure.decodeNullableSerializableElement(gVar, 4, F.f218a, num4);
                    i6 |= 16;
                }
            }
            i = i6;
            str = str4;
            str2 = str8;
            str3 = str9;
            num = num3;
            num2 = num4;
        }
        cVarBeginStructure.endStructure(gVar);
        return new ParentFilter(i, str, str2, str3, num, num2, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(f encoder, ParentFilter value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        ParentFilter.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ b[] typeParametersSerializers() {
        return T.b;
    }
}
