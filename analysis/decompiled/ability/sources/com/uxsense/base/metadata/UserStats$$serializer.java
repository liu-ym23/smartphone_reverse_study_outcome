package com.uxsense.base.metadata;

import A9.d;
import A9.e;
import B9.A;
import B9.L;
import B9.T;
import B9.V;
import B9.d0;
import C7.c;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import x9.InterfaceC2123a;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/base/metadata/UserStats.$serializer", "LB9/A;", "Lcom/uxsense/base/metadata/UserStats;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/base/metadata/UserStats;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/base/metadata/UserStats;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class UserStats$$serializer implements A {
    public static final UserStats$$serializer INSTANCE;
    private static final g descriptor;

    static {
        UserStats$$serializer userStats$$serializer = new UserStats$$serializer();
        INSTANCE = userStats$$serializer;
        V v10 = new V("com.uxsense.base.metadata.UserStats", userStats$$serializer, 5);
        v10.j("followersCount", true);
        v10.j("followersBucket", true);
        v10.j("followersPageIds", true);
        v10.j("followingCount", true);
        v10.j("followings", true);
        descriptor = v10;
    }

    private UserStats$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // B9.A
    public final b[] childSerializers() {
        f[] fVarArr = UserStats.$childSerializers;
        L l = L.f223a;
        return new b[]{l, fVarArr[1].getF4884a(), fVarArr[2].getF4884a(), l, fVarArr[4].getF4884a()};
    }

    @Override // x9.InterfaceC2123a
    public final UserStats deserialize(e decoder) {
        int i;
        List list;
        long j5;
        List list2;
        List list3;
        long j6;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        f[] fVarArr = UserStats.$childSerializers;
        List list4 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            long jDecodeLongElement = cVarBeginStructure.decodeLongElement(gVar, 0);
            List list5 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 1, (InterfaceC2123a) fVarArr[1].getF4884a(), null);
            List list6 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 2, (InterfaceC2123a) fVarArr[2].getF4884a(), null);
            long jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(gVar, 3);
            list3 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 4, (InterfaceC2123a) fVarArr[4].getF4884a(), null);
            list = list5;
            i = 31;
            list2 = list6;
            j5 = jDecodeLongElement2;
            j6 = jDecodeLongElement;
        } else {
            long jDecodeLongElement3 = 0;
            boolean z10 = true;
            int i6 = 0;
            List list7 = null;
            List list8 = null;
            long jDecodeLongElement4 = 0;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    jDecodeLongElement4 = cVarBeginStructure.decodeLongElement(gVar, 0);
                    i6 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    list4 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 1, (InterfaceC2123a) fVarArr[1].getF4884a(), list4);
                    i6 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    list7 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 2, (InterfaceC2123a) fVarArr[2].getF4884a(), list7);
                    i6 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    jDecodeLongElement3 = cVarBeginStructure.decodeLongElement(gVar, 3);
                    i6 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    list8 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 4, (InterfaceC2123a) fVarArr[4].getF4884a(), list8);
                    i6 |= 16;
                }
            }
            i = i6;
            list = list4;
            j5 = jDecodeLongElement3;
            list2 = list7;
            list3 = list8;
            j6 = jDecodeLongElement4;
        }
        cVarBeginStructure.endStructure(gVar);
        return new UserStats(i, j6, list, list2, j5, list3, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(A9.f encoder, UserStats value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        UserStats.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ b[] typeParametersSerializers() {
        return T.b;
    }
}
