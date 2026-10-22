package com.stepos.core.ota.remote;

import androidx.datastore.preferences.protobuf.b1;
import com.google.gson.reflect.TypeToken;
import com.stepos.core.ota.data.OtaRemoteModel;
import com.stepos.deepbinder.annotation.BaseConstantsKt;
import d5.l;
import d5.m;
import d5.n;
import d5.o;
import d5.p;
import d5.q;
import d5.r;
import g5.n;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ApiResponseDeserializer implements n<ApiResponse> {
    private final Type modelListType;

    public ApiResponseDeserializer() {
        Type type = new TypeToken<List<? extends OtaRemoteModel>>() { // from class: com.stepos.core.ota.remote.ApiResponseDeserializer$modelListType$1
        }.getType();
        g.e(type, "getType(...)");
        this.modelListType = type;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d5.n
    public ApiResponse deserialize(o json, Type typeOfT, m ctx) {
        List list;
        String strF;
        String strF2;
        g.f(json, "json");
        g.f(typeOfT, "typeOfT");
        g.f(ctx, "ctx");
        q qVarC = json.c();
        o oVarH = qVarC.h("code");
        int iB = oVarH != null ? oVarH.b() : 0;
        o oVarH2 = qVarC.h(BaseConstantsKt.KEY_ERROR_CODE);
        String strF3 = null;
        if (oVarH2 != null) {
            if (oVarH2 instanceof p) {
                oVarH2 = null;
            }
            if (oVarH2 != null) {
                strF3 = oVarH2.f();
            }
        }
        String str = strF3;
        o oVarH3 = qVarC.h("message");
        String str2 = (oVarH3 == null || (strF2 = oVarH3.f()) == null) ? "" : strF2;
        o oVarH4 = qVarC.h("redirect");
        String str3 = (oVarH4 == null || (strF = oVarH4.f()) == null) ? "" : strF;
        o oVarH5 = qVarC.h("value");
        if (oVarH5 == null || (oVarH5 instanceof p)) {
            list = EmptyList.f10001a;
        } else if (oVarH5 instanceof l) {
            Object objA = ((n.a) ctx).a(oVarH5, this.modelListType);
            g.e(objA, "deserialize(...)");
            list = (List) objA;
        } else if (oVarH5 instanceof r) {
            String strF4 = oVarH5.f();
            g.c(strF4);
            if (gc.q.t0(strF4)) {
                list = EmptyList.f10001a;
            } else {
                try {
                    o oVarU = b1.U(strF4);
                    if (oVarU instanceof l) {
                        Object objA2 = ((n.a) ctx).a(oVarU, this.modelListType);
                        g.e(objA2, "deserialize(...)");
                        list = (List) objA2;
                    } else {
                        list = EmptyList.f10001a;
                    }
                } catch (Exception unused) {
                    list = EmptyList.f10001a;
                }
            }
        } else {
            list = EmptyList.f10001a;
        }
        return new ApiResponse(iB, str, str2, str3, list);
    }
}
