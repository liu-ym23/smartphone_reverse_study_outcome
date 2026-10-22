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

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/base/metadata/FollowerUser.$serializer", "LB9/A;", "Lcom/uxsense/base/metadata/FollowerUser;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/base/metadata/FollowerUser;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/base/metadata/FollowerUser;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class FollowerUser$$serializer implements A {
    public static final FollowerUser$$serializer INSTANCE;
    private static final g descriptor;

    static {
        FollowerUser$$serializer followerUser$$serializer = new FollowerUser$$serializer();
        INSTANCE = followerUser$$serializer;
        V v10 = new V("com.uxsense.base.metadata.FollowerUser", followerUser$$serializer, 5);
        v10.j(BffConstant.Role.User, false);
        v10.j("followedAt", true);
        v10.j("isFollowing", true);
        v10.j("type", true);
        v10.j("hasChat", true);
        descriptor = v10;
    }

    private FollowerUser$$serializer() {
    }

    @Override // B9.A
    public final b[] childSerializers() {
        C0180g c0180g = C0180g.f239a;
        return new b[]{User$$serializer.INSTANCE, L.f223a, c0180g, h0.f242a, c0180g};
    }

    @Override // x9.InterfaceC2123a
    public final FollowerUser deserialize(e decoder) {
        boolean zDecodeBooleanElement;
        boolean z10;
        long j5;
        int i;
        User user;
        String strDecodeStringElement;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        if (cVarBeginStructure.decodeSequentially()) {
            User user2 = (User) cVarBeginStructure.decodeSerializableElement(gVar, 0, User$$serializer.INSTANCE, null);
            long jDecodeLongElement = cVarBeginStructure.decodeLongElement(gVar, 1);
            boolean zDecodeBooleanElement2 = cVarBeginStructure.decodeBooleanElement(gVar, 2);
            user = user2;
            strDecodeStringElement = cVarBeginStructure.decodeStringElement(gVar, 3);
            zDecodeBooleanElement = cVarBeginStructure.decodeBooleanElement(gVar, 4);
            z10 = zDecodeBooleanElement2;
            j5 = jDecodeLongElement;
            i = 31;
        } else {
            long jDecodeLongElement2 = 0;
            boolean z11 = true;
            boolean zDecodeBooleanElement3 = false;
            int i6 = 0;
            User user3 = null;
            String strDecodeStringElement2 = null;
            boolean zDecodeBooleanElement4 = false;
            while (z11) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                if (iDecodeElementIndex == -1) {
                    z11 = false;
                } else if (iDecodeElementIndex == 0) {
                    user3 = (User) cVarBeginStructure.decodeSerializableElement(gVar, 0, User$$serializer.INSTANCE, user3);
                    i6 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(gVar, 1);
                    i6 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    zDecodeBooleanElement4 = cVarBeginStructure.decodeBooleanElement(gVar, 2);
                    i6 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(gVar, 3);
                    i6 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    zDecodeBooleanElement3 = cVarBeginStructure.decodeBooleanElement(gVar, 4);
                    i6 |= 16;
                }
            }
            zDecodeBooleanElement = zDecodeBooleanElement3;
            z10 = zDecodeBooleanElement4;
            j5 = jDecodeLongElement2;
            i = i6;
            user = user3;
            strDecodeStringElement = strDecodeStringElement2;
        }
        cVarBeginStructure.endStructure(gVar);
        return new FollowerUser(i, user, j5, z10, strDecodeStringElement, zDecodeBooleanElement, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(f encoder, FollowerUser value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        FollowerUser.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ b[] typeParametersSerializers() {
        return T.b;
    }
}
