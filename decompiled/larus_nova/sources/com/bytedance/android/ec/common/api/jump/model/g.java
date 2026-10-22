package com.bytedance.android.ec.common.api.jump.model;

import com.bytedance.android.ec.model.response.StandardEventTrack;
import java.util.Map;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class g extends com.bytedance.android.ec.common.api.jump.model.a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ql.a f42873a;

    public static final class a implements com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0780a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ql.a f42874a;

        public a(ql.a r100) {
            Intrinsics.checkNotNullParameter(r100, "promotion");
            this.f42874a = r100;
        }

        @Override // com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0780a
        public final <T extends com.bytedance.android.ec.common.api.jump.model.a> T a(KClass<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "modelClass");
            if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(g.class)) == false) goto L7;
            return new g(this.f42874a);
        L7:
            return (T) JvmClassMappingKt.getJavaClass(r100).newInstance();
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f42873a, ((g) r100).f42873a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        ql.a r100 = this.f42873a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "PromotionParams(promotion=" + this.f42873a + ")";
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.a
    public final Map<String, String> chainParams() {
        StandardEventTrack r100 = this.f42873a.getStandardEventTrack();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getChainParamsMap();
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.d
    public final JSONObject entranceInfo() {
        JSONObject r100 = new JSONObject();
        Map<String, String> r101 = this.f42873a.getExtraEventParams();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.get("elastic_title_types");
    L6:
        r100.put("elastic_title_types", r103);
        Map<String, String> r104 = this.f42873a.getExtraEventParams();
        if (r104 == null) goto L9;
        r102 = r104.get("sellpoint_bp");
    L9:
        r100.put("sellpoint_bp", r102);
        return r100;
    L5:
        r103 = null;
        goto L6
    }

    public g(ql.a r100) {
        Intrinsics.checkNotNullParameter(r100, "promotion");
        this.f42873a = r100;
    }
}
