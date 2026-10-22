package com.bytedance.android.annie.xbridge.mix;

import android.text.TextUtils;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.ResultCodeEnumSerializer;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import e7.j0;
import e7.k0;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40160a = null;

    public static final class a implements com.bytedance.ies.web.jsbridge2.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.ies.web.jsbridge2.q f40161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Gson f40162b;

        public a() {
            this.f40161a = ((w8.c) Annie.getService$default(w8.c.class, null, 2, null)).n1();
            this.f40162b = new Gson().newBuilder().registerTypeHierarchyAdapter(j0.class, new ResultCodeEnumSerializer()).create();
        }

        @Override // com.bytedance.ies.web.jsbridge2.q
        public final <T> String a(T r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            Class<?> r101 = r100.getClass();
            if (Intrinsics.areEqual(r101, JsonObject.class) == false) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L9;
            return r100.toString();
        L9:
            if (Intrinsics.areEqual(r101, String.class) == false) goto L12;
            return r100.toString();
        L12:
            if ((r100 instanceof k0) == false) goto L15;
            return GsonProtectorUtils.toJson(this.f40162b, r100);
        L15:
            return this.f40161a.a(r100);
        L5:
            r102 = Intrinsics.areEqual(r101, JsonArray.class);
            goto L6
        }

        @Override // com.bytedance.ies.web.jsbridge2.q
        public final <T> T b(String r100, Type r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Intrinsics.checkNotNullParameter(r101, "type");
            return (T) GsonProtectorUtils.fromJson(this.f40162b, r100, r101);
        }
    }

    static {
        f40160a = new a();
    }

    public static void a(String r100) {
        if (StringsKt.startsWith$default(r100, "{", false, 2, null) == true) goto L5;
    L7:
        IllegalArgumentException r101 = new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n " + r100);
        Intrinsics.checkNotNull(r101);
        throw r101;
    L5:
        if (StringsKt.endsWith$default(r100, com.alipay.sdk.m.u.i.f25855d, false, 2, null) == false) goto L7;
    }

    public static JSONObject c(Object r100) {
        if (r100 != null) goto L5;
        String r101 = SliceInitService.DEFAULT_SWITCH;
    L12:
        boolean r102 = true;
        if (TextUtils.isEmpty(r101) == false) goto L16;
        JSONObject r103 = new JSONObject();
        r103.put("code", 1);
        return r103;
    L16:
        String r104 = r101.substring(1, r101.length() - 1);
        String r105 = "{\"code\":1,\"__data\":".concat(r101);
        StringBuilder r106 = new StringBuilder();
        r106.append(r105);
        if (r104.length() == 0) goto L20;
        r102 = false;
    L20:
        if (r102 == true) goto L22;
        String r107 = "," + r104 + '}';
    L23:
        r106.append(r107);
        return new JSONObject(r106.toString());
    L22:
        r107 = com.alipay.sdk.m.u.i.f25855d;
        goto L23
    L5:
        if ((r100 instanceof JSONObject) == false) goto L7;
    L10:
        r101 = r100.toString();
    L11:
        a(r101);
        goto L12
    L7:
        if ((r100 instanceof JSONArray) == true) goto L10;
        r101 = f40160a.a(r100);
        goto L11
    }

    public static Object b(JSONObject r100, Type r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "type");
        s26.d r102 = s26.d.f540305c;
        m0 r103 = (m0) s26.d.f540305c.c(m0.class);
        if (r103 == null) goto L5;
        r103.a0();
    L5:
        String r104 = r100.toString();
        Intrinsics.checkNotNullParameter(r104, "data");
        Intrinsics.checkNotNullParameter(r101, "type");
        a(r104);
        if (Intrinsics.areEqual(r101, JSONObject.class) == true) goto L14;
        if ((r101 instanceof Class) == false) goto L15;
        if (JSONObject.class.isAssignableFrom((Class) r101) == true) goto L14;
    L15:
        return f40160a.b(r104, r101);
    L14:
        return new JSONObject(r104);
    }
}
