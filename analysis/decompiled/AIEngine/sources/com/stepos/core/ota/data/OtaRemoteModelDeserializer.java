package com.stepos.core.ota.data;

import androidx.datastore.preferences.protobuf.b1;
import com.google.gson.reflect.TypeToken;
import d5.l;
import d5.m;
import d5.n;
import d5.o;
import d5.p;
import d5.r;
import g5.n;
import gc.q;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaRemoteModelDeserializer implements n<OtaRemoteModel> {
    private final Type stringListType;

    public OtaRemoteModelDeserializer() {
        Type type = new TypeToken<List<? extends String>>() { // from class: com.stepos.core.ota.data.OtaRemoteModelDeserializer$stringListType$1
        }.getType();
        g.e(type, "getType(...)");
        this.stringListType = type;
    }

    private final List<String> parseStringList(o oVar, m mVar) {
        if (oVar == null || (oVar instanceof p)) {
            return EmptyList.f10001a;
        }
        if (oVar instanceof l) {
            Object objA = ((n.a) mVar).a(oVar, this.stringListType);
            g.e(objA, "deserialize(...)");
            return (List) objA;
        }
        if (!(oVar instanceof r)) {
            return EmptyList.f10001a;
        }
        String strF = oVar.f();
        g.c(strF);
        if (q.t0(strF)) {
            return EmptyList.f10001a;
        }
        try {
            o oVarU = b1.U(strF);
            if (!(oVarU instanceof l)) {
                return EmptyList.f10001a;
            }
            Object objA2 = ((n.a) mVar).a(oVarU, this.stringListType);
            g.e(objA2, "deserialize(...)");
            return (List) objA2;
        } catch (Exception unused) {
            return EmptyList.f10001a;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0085 A[PHI: r0
      0x0085: PHI (r0v18 java.lang.String) = (r0v6 java.lang.String), (r0v19 java.lang.String) binds: [B:34:0x0095, B:27:0x0082] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0144  */
    @Override // d5.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.stepos.core.ota.data.OtaRemoteModel deserialize(d5.o r21, java.lang.reflect.Type r22, d5.m r23) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.data.OtaRemoteModelDeserializer.deserialize(d5.o, java.lang.reflect.Type, d5.m):com.stepos.core.ota.data.OtaRemoteModel");
    }
}
