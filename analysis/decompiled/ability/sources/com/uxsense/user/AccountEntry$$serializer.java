package com.uxsense.user;

import A9.d;
import A9.e;
import A9.f;
import B9.A;
import B9.C0180g;
import B9.F;
import B9.L;
import B9.T;
import B9.V;
import B9.d0;
import B9.h0;
import C7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/user/AccountEntry.$serializer", "LB9/A;", "Lcom/uxsense/user/AccountEntry;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/user/AccountEntry;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/user/AccountEntry;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class AccountEntry$$serializer implements A {
    public static final AccountEntry$$serializer INSTANCE;
    private static final g descriptor;

    static {
        AccountEntry$$serializer accountEntry$$serializer = new AccountEntry$$serializer();
        INSTANCE = accountEntry$$serializer;
        V v10 = new V("com.uxsense.user.AccountEntry", accountEntry$$serializer, 7);
        v10.j("userId", false);
        v10.j("androidUserId", false);
        v10.j("uuid", true);
        v10.j("nickname", true);
        v10.j("loginAt", true);
        v10.j("isLogin", true);
        v10.j("markTemp", true);
        descriptor = v10;
    }

    private AccountEntry$$serializer() {
    }

    @Override // B9.A
    public final x9.b[] childSerializers() {
        L l = L.f223a;
        h0 h0Var = h0.f242a;
        C0180g c0180g = C0180g.f239a;
        return new x9.b[]{l, F.f218a, h0Var, h0Var, l, c0180g, c0180g};
    }

    @Override // x9.InterfaceC2123a
    public final AccountEntry deserialize(e decoder) {
        int iDecodeIntElement;
        boolean zDecodeBooleanElement;
        boolean z10;
        String str;
        int i;
        String str2;
        long j5;
        long j6;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        if (cVarBeginStructure.decodeSequentially()) {
            long jDecodeLongElement = cVarBeginStructure.decodeLongElement(gVar, 0);
            iDecodeIntElement = cVarBeginStructure.decodeIntElement(gVar, 1);
            String strDecodeStringElement = cVarBeginStructure.decodeStringElement(gVar, 2);
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(gVar, 3);
            long jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(gVar, 4);
            boolean zDecodeBooleanElement2 = cVarBeginStructure.decodeBooleanElement(gVar, 5);
            zDecodeBooleanElement = cVarBeginStructure.decodeBooleanElement(gVar, 6);
            z10 = zDecodeBooleanElement2;
            str = strDecodeStringElement2;
            i = 127;
            str2 = strDecodeStringElement;
            j5 = jDecodeLongElement;
            j6 = jDecodeLongElement2;
        } else {
            String strDecodeStringElement3 = null;
            String strDecodeStringElement4 = null;
            boolean z11 = true;
            iDecodeIntElement = 0;
            int i6 = 0;
            long jDecodeLongElement3 = 0;
            long jDecodeLongElement4 = 0;
            boolean zDecodeBooleanElement3 = false;
            boolean zDecodeBooleanElement4 = false;
            while (z11) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                switch (iDecodeElementIndex) {
                    case -1:
                        z11 = false;
                        continue;
                    case 0:
                        jDecodeLongElement3 = cVarBeginStructure.decodeLongElement(gVar, 0);
                        i6 |= 1;
                        continue;
                    case 1:
                        iDecodeIntElement = cVarBeginStructure.decodeIntElement(gVar, 1);
                        i6 |= 2;
                        break;
                    case 2:
                        strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(gVar, 2);
                        i6 |= 4;
                        break;
                    case 3:
                        strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(gVar, 3);
                        i6 |= 8;
                        break;
                    case 4:
                        jDecodeLongElement4 = cVarBeginStructure.decodeLongElement(gVar, 4);
                        i6 |= 16;
                        break;
                    case 5:
                        zDecodeBooleanElement4 = cVarBeginStructure.decodeBooleanElement(gVar, 5);
                        i6 |= 32;
                        break;
                    case 6:
                        zDecodeBooleanElement3 = cVarBeginStructure.decodeBooleanElement(gVar, 6);
                        i6 |= 64;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            zDecodeBooleanElement = zDecodeBooleanElement3;
            z10 = zDecodeBooleanElement4;
            str = strDecodeStringElement3;
            i = i6;
            str2 = strDecodeStringElement4;
            j5 = jDecodeLongElement3;
            j6 = jDecodeLongElement4;
        }
        int i10 = iDecodeIntElement;
        cVarBeginStructure.endStructure(gVar);
        return new AccountEntry(i, j5, i10, str2, str, j6, z10, zDecodeBooleanElement, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(f encoder, AccountEntry value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        AccountEntry.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ x9.b[] typeParametersSerializers() {
        return T.b;
    }
}
