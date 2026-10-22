package com.bytedance.android.ec.host.impl;

import android.content.Context;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.bdlocation.BDLocation;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class w implements wi.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f46222a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ECBaseBridgeMethod.a f46223b;

    static {
        f46222a = new w();
    }

    public w() {
    }

    @Override // wi.c
    public final boolean a() {
        return false;
    }

    @Override // wi.c
    public final void d(String r100, String r101, com.bytedance.android.ec.core.address.m r102) {
        Intrinsics.checkNotNullParameter(r100, "tokenCert");
        Intrinsics.checkNotNullParameter(r101, "auth");
        Intrinsics.checkNotNullParameter(r102, "callback");
    }

    @Override // wi.c
    public final void e(com.bytedance.android.ec.core.address.q r100) {
        Intrinsics.checkNotNullParameter("bpea-ecom_address_sdk_listen_submit", "tokenCert");
        Intrinsics.checkNotNullParameter("nclf", "auth");
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // wi.c
    public final void f() {
    }

    @Override // wi.c
    public final void g(com.bytedance.android.ec.core.address.r r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // wi.c
    public final wi.a h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tokenCert");
        Intrinsics.checkNotNullParameter(r101, "auth");
        return null;
    }

    @Override // wi.c
    public final boolean onActivityResult() {
        return false;
    }

    @Override // wi.c
    public final void release() {
        f46223b = null;
    }

    @Override // wi.c
    public final void b(Context r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "cb");
        f46223b = r101;
        com.bytedance.android.ec.host.utils.b r102 = com.bytedance.android.ec.host.utils.b.f46237a;
        ECLocationService$getLocationWithoutDialog$1 r103 = new ECLocationService$getLocationWithoutDialog$1(this);
        r102.getClass();
        com.bytedance.android.ec.host.utils.b.c(r100, r103);
    }

    @Override // wi.c
    public final void c(Context r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "cb");
        f46223b = r101;
        com.bytedance.android.ec.host.utils.b r102 = com.bytedance.android.ec.host.utils.b.f46237a;
        ECLocationService$getLocationWithDialog$1 r103 = new ECLocationService$getLocationWithDialog$1(this);
        r102.getClass();
        com.bytedance.android.ec.host.utils.b.b(r100, r103);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void i(w r100, boolean r101, BDLocation r102, int r103) {
        r100.getClass();
        ECBaseBridgeMethod.a r104 = f46223b;
        if (r104 == null) goto L16;
        JSONObject r105 = new JSONObject();
        r105.put("permission", r101 ? 1 : 0);
        r105.put("request_permission", r103);
        JSONObject r106 = new JSONObject();
        if (r101 == false) goto L8;
        if (r102 == null) goto L8;
        Object r107 = Double.valueOf(r102.getLatitude());
    L9:
        r106.put("latitude", r107);
        if (r101 == false) goto L13;
        if (r102 == null) goto L13;
        Object r108 = Double.valueOf(r102.getLongitude());
    L14:
        r106.put("longitude", r108);
        Unit r109 = Unit.INSTANCE;
        r105.put("data", r106);
        r104.a(r105);
        return;
    L13:
        r108 = 0;
    L8:
        r107 = 0;
        goto L9
    }
}
