package com.uxsense.base.metadata;

import A9.d;
import A9.e;
import B9.A;
import B9.L;
import B9.T;
import B9.V;
import B9.d0;
import B9.h0;
import C7.c;
import C7.f;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import x9.InterfaceC2123a;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/base/metadata/User.$serializer", "LB9/A;", "Lcom/uxsense/base/metadata/User;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/base/metadata/User;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/base/metadata/User;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class User$$serializer implements A {
    public static final User$$serializer INSTANCE;
    private static final g descriptor;

    static {
        User$$serializer user$$serializer = new User$$serializer();
        INSTANCE = user$$serializer;
        V v10 = new V("com.uxsense.base.metadata.User", user$$serializer, 9);
        v10.j("userId", false);
        v10.j("nickname", true);
        v10.j("uuid", true);
        v10.j("avatar", true);
        v10.j("age", true);
        v10.j("bio", true);
        v10.j(HintConstants.AUTOFILL_HINT_GENDER, true);
        v10.j("userStats", false);
        v10.j("screenshots", true);
        descriptor = v10;
    }

    private User$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // B9.A
    public final b[] childSerializers() {
        f[] fVarArr = User.$childSerializers;
        h0 h0Var = h0.f242a;
        return new b[]{L.f223a, h0Var, h0Var, h0Var, h0Var, h0Var, h0Var, UserStats$$serializer.INSTANCE, fVarArr[8].getF4884a()};
    }

    @Override // x9.InterfaceC2123a
    public final User deserialize(e decoder) {
        int i;
        List list;
        UserStats userStats;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        long j5;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        f[] fVarArr = User.$childSerializers;
        int i6 = 7;
        String strDecodeStringElement = null;
        if (cVarBeginStructure.decodeSequentially()) {
            long jDecodeLongElement = cVarBeginStructure.decodeLongElement(gVar, 0);
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(gVar, 1);
            String strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(gVar, 2);
            String strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(gVar, 3);
            String strDecodeStringElement5 = cVarBeginStructure.decodeStringElement(gVar, 4);
            String strDecodeStringElement6 = cVarBeginStructure.decodeStringElement(gVar, 5);
            String strDecodeStringElement7 = cVarBeginStructure.decodeStringElement(gVar, 6);
            UserStats userStats2 = (UserStats) cVarBeginStructure.decodeSerializableElement(gVar, 7, UserStats$$serializer.INSTANCE, null);
            list = (List) cVarBeginStructure.decodeSerializableElement(gVar, 8, (InterfaceC2123a) fVarArr[8].getF4884a(), null);
            str = strDecodeStringElement2;
            userStats = userStats2;
            str6 = strDecodeStringElement7;
            str5 = strDecodeStringElement6;
            str3 = strDecodeStringElement4;
            str4 = strDecodeStringElement5;
            str2 = strDecodeStringElement3;
            i = 511;
            j5 = jDecodeLongElement;
        } else {
            boolean z10 = true;
            int i10 = 0;
            List list2 = null;
            UserStats userStats3 = null;
            String strDecodeStringElement8 = null;
            String strDecodeStringElement9 = null;
            String strDecodeStringElement10 = null;
            long jDecodeLongElement2 = 0;
            String strDecodeStringElement11 = null;
            String strDecodeStringElement12 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                switch (iDecodeElementIndex) {
                    case -1:
                        z10 = false;
                        i6 = 7;
                    case 0:
                        jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(gVar, 0);
                        i10 |= 1;
                        i6 = 7;
                    case 1:
                        i10 |= 2;
                        strDecodeStringElement = cVarBeginStructure.decodeStringElement(gVar, 1);
                    case 2:
                        strDecodeStringElement11 = cVarBeginStructure.decodeStringElement(gVar, 2);
                        i10 |= 4;
                    case 3:
                        strDecodeStringElement12 = cVarBeginStructure.decodeStringElement(gVar, 3);
                        i10 |= 8;
                    case 4:
                        strDecodeStringElement8 = cVarBeginStructure.decodeStringElement(gVar, 4);
                        i10 |= 16;
                    case 5:
                        strDecodeStringElement9 = cVarBeginStructure.decodeStringElement(gVar, 5);
                        i10 |= 32;
                    case 6:
                        strDecodeStringElement10 = cVarBeginStructure.decodeStringElement(gVar, 6);
                        i10 |= 64;
                    case 7:
                        userStats3 = (UserStats) cVarBeginStructure.decodeSerializableElement(gVar, i6, UserStats$$serializer.INSTANCE, userStats3);
                        i10 |= 128;
                    case 8:
                        list2 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 8, (InterfaceC2123a) fVarArr[8].getF4884a(), list2);
                        i10 |= 256;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i10;
            list = list2;
            userStats = userStats3;
            str = strDecodeStringElement;
            str2 = strDecodeStringElement11;
            str3 = strDecodeStringElement12;
            str4 = strDecodeStringElement8;
            str5 = strDecodeStringElement9;
            str6 = strDecodeStringElement10;
            j5 = jDecodeLongElement2;
        }
        cVarBeginStructure.endStructure(gVar);
        return new User(i, j5, str, str2, str3, str4, str5, str6, userStats, list, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(A9.f encoder, User value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        User.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ b[] typeParametersSerializers() {
        return T.b;
    }
}
