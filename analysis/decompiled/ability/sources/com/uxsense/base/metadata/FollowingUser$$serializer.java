package com.uxsense.base.metadata;

import A9.d;
import A9.e;
import A9.f;
import B9.A;
import B9.C0180g;
import B9.L;
import B9.T;
import B9.V;
import B9.d0;
import B9.h0;
import C7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/base/metadata/FollowingUser.$serializer", "LB9/A;", "Lcom/uxsense/base/metadata/FollowingUser;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/base/metadata/FollowingUser;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/base/metadata/FollowingUser;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class FollowingUser$$serializer implements A {
    public static final FollowingUser$$serializer INSTANCE;
    private static final g descriptor;

    static {
        FollowingUser$$serializer followingUser$$serializer = new FollowingUser$$serializer();
        INSTANCE = followingUser$$serializer;
        V v10 = new V("com.uxsense.base.metadata.FollowingUser", followingUser$$serializer, 6);
        v10.j(BffConstant.Role.User, false);
        v10.j("followedAt", true);
        v10.j("isFollower", true);
        v10.j("isStar", true);
        v10.j("type", true);
        v10.j("hasChat", true);
        descriptor = v10;
    }

    private FollowingUser$$serializer() {
    }

    @Override // B9.A
    public final b[] childSerializers() {
        C0180g c0180g = C0180g.f239a;
        return new b[]{User$$serializer.INSTANCE, L.f223a, c0180g, c0180g, h0.f242a, c0180g};
    }

    @Override // x9.InterfaceC2123a
    public final FollowingUser deserialize(e decoder) {
        boolean zDecodeBooleanElement;
        boolean z10;
        boolean z11;
        long j5;
        int i;
        User user;
        String str;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        int i6 = 5;
        if (cVarBeginStructure.decodeSequentially()) {
            User user2 = (User) cVarBeginStructure.decodeSerializableElement(gVar, 0, User$$serializer.INSTANCE, null);
            long jDecodeLongElement = cVarBeginStructure.decodeLongElement(gVar, 1);
            boolean zDecodeBooleanElement2 = cVarBeginStructure.decodeBooleanElement(gVar, 2);
            boolean zDecodeBooleanElement3 = cVarBeginStructure.decodeBooleanElement(gVar, 3);
            String strDecodeStringElement = cVarBeginStructure.decodeStringElement(gVar, 4);
            user = user2;
            zDecodeBooleanElement = cVarBeginStructure.decodeBooleanElement(gVar, 5);
            z10 = zDecodeBooleanElement3;
            str = strDecodeStringElement;
            z11 = zDecodeBooleanElement2;
            j5 = jDecodeLongElement;
            i = 63;
        } else {
            boolean z12 = true;
            boolean zDecodeBooleanElement4 = false;
            int i10 = 0;
            User user3 = null;
            String strDecodeStringElement2 = null;
            long jDecodeLongElement2 = 0;
            boolean zDecodeBooleanElement5 = false;
            boolean zDecodeBooleanElement6 = false;
            while (z12) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                switch (iDecodeElementIndex) {
                    case -1:
                        z12 = false;
                        i6 = 5;
                    case 0:
                        user3 = (User) cVarBeginStructure.decodeSerializableElement(gVar, 0, User$$serializer.INSTANCE, user3);
                        i10 |= 1;
                        i6 = 5;
                    case 1:
                        jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(gVar, 1);
                        i10 |= 2;
                    case 2:
                        zDecodeBooleanElement6 = cVarBeginStructure.decodeBooleanElement(gVar, 2);
                        i10 |= 4;
                    case 3:
                        zDecodeBooleanElement5 = cVarBeginStructure.decodeBooleanElement(gVar, 3);
                        i10 |= 8;
                    case 4:
                        strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(gVar, 4);
                        i10 |= 16;
                    case 5:
                        zDecodeBooleanElement4 = cVarBeginStructure.decodeBooleanElement(gVar, i6);
                        i10 |= 32;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            zDecodeBooleanElement = zDecodeBooleanElement4;
            z10 = zDecodeBooleanElement5;
            z11 = zDecodeBooleanElement6;
            j5 = jDecodeLongElement2;
            i = i10;
            user = user3;
            str = strDecodeStringElement2;
        }
        cVarBeginStructure.endStructure(gVar);
        return new FollowingUser(i, user, j5, z11, z10, str, zDecodeBooleanElement, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(f encoder, FollowingUser value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        FollowingUser.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ b[] typeParametersSerializers() {
        return T.b;
    }
}
