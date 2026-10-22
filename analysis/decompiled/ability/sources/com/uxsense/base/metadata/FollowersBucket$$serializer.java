package com.uxsense.base.metadata;

import A9.d;
import A9.e;
import A9.f;
import B9.A;
import B9.L;
import B9.T;
import B9.V;
import B9.d0;
import C7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/base/metadata/FollowersBucket.$serializer", "LB9/A;", "Lcom/uxsense/base/metadata/FollowersBucket;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/base/metadata/FollowersBucket;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/base/metadata/FollowersBucket;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class FollowersBucket$$serializer implements A {
    public static final FollowersBucket$$serializer INSTANCE;
    private static final g descriptor;

    static {
        FollowersBucket$$serializer followersBucket$$serializer = new FollowersBucket$$serializer();
        INSTANCE = followersBucket$$serializer;
        V v10 = new V("com.uxsense.base.metadata.FollowersBucket", followersBucket$$serializer, 3);
        v10.j("timestamp", false);
        v10.j("gainedCount", true);
        v10.j("lostCount", true);
        descriptor = v10;
    }

    private FollowersBucket$$serializer() {
    }

    @Override // B9.A
    public final b[] childSerializers() {
        L l = L.f223a;
        return new b[]{l, l, l};
    }

    @Override // x9.InterfaceC2123a
    public final FollowersBucket deserialize(e decoder) {
        int i;
        long jDecodeLongElement;
        long j5;
        long j6;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        if (cVarBeginStructure.decodeSequentially()) {
            long jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(gVar, 0);
            long jDecodeLongElement3 = cVarBeginStructure.decodeLongElement(gVar, 1);
            jDecodeLongElement = cVarBeginStructure.decodeLongElement(gVar, 2);
            i = 7;
            j5 = jDecodeLongElement2;
            j6 = jDecodeLongElement3;
        } else {
            long jDecodeLongElement4 = 0;
            boolean z10 = true;
            int i6 = 0;
            long jDecodeLongElement5 = 0;
            long jDecodeLongElement6 = 0;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    jDecodeLongElement5 = cVarBeginStructure.decodeLongElement(gVar, 0);
                    i6 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    jDecodeLongElement6 = cVarBeginStructure.decodeLongElement(gVar, 1);
                    i6 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    jDecodeLongElement4 = cVarBeginStructure.decodeLongElement(gVar, 2);
                    i6 |= 4;
                }
            }
            i = i6;
            jDecodeLongElement = jDecodeLongElement4;
            j5 = jDecodeLongElement5;
            j6 = jDecodeLongElement6;
        }
        cVarBeginStructure.endStructure(gVar);
        return new FollowersBucket(i, j5, j6, jDecodeLongElement, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(f encoder, FollowersBucket value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        FollowersBucket.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ b[] typeParametersSerializers() {
        return T.b;
    }
}
