package com.bytedance.android.shopping.store.tabkit.mixframe;

import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements IDLXBridgeMethod, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f186779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f186780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IDLXBridgeMethod.Compatibility f186781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<String, Unit> f186782d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.tabkit.mixframe.a$a, reason: collision with other inner class name */
    public static final class C2742a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return "ec.negfeedback_click";
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f186780b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return this.f186781c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f186782d = r100;
        this.f186779a = new LinkedHashSet();
        this.f186780b = IDLXBridgeMethod.Access.PUBLIC;
        this.f186781c = IDLXBridgeMethod.Compatibility.Compatible;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r110, Map<String, ? extends Object> r111, IDLXBridgeMethod.a r112) {
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r113 = "";
        LinkedHashMap r100 = new LinkedHashMap();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Set<String> r102 = this.f186779a;     // Catch: Throwable -> L5
        StringBuilder r103 = new StringBuilder();     // Catch: Throwable -> L5
        r103.append(r111.get("type"));     // Catch: Throwable -> L5
        r103.append('_');     // Catch: Throwable -> L5
        r103.append(r111.get("itemType"));     // Catch: Throwable -> L5
        r103.append('_');     // Catch: Throwable -> L5
        r103.append(r111.get("itemId"));     // Catch: Throwable -> L5
        r102.add(r103.toString());     // Catch: Throwable -> L5
        this.f186782d.invoke(CollectionsKt.joinToString$default(this.f186779a, ",", null, null, 0, null, null, 62, null));     // Catch: Throwable -> L5
        Object r114 = Result.m9449constructorimpl(TuplesKt.to(Boolean.TRUE, ""));     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r114);
        if (r104 == null) goto L10;
        String r105 = r104.toString();
    L12:
        if (Result.m9455isFailureimpl(r114) == false) goto L14;
        r114 = null;
    L14:
        Pair r115 = (Pair) r114;
        if (r115 != null) goto L17;
        r115 = new Pair(Boolean.FALSE, "ECMallStatefulJsb Error: " + r105);
    L17:
        boolean r106 = ((Boolean) r115.component1()).booleanValue();
        String r116 = (String) r115.component2();
        Pair[] r107 = new Pair[3];
        r107[0] = TuplesKt.to("code", Integer.valueOf(r106 ? 1 : 0));
        if (r116 == null) goto L21;
        r113 = r116;
    L21:
        r107[1] = TuplesKt.to("msg", r113);
        r107[2] = TuplesKt.to("data", r100);
        r112.invoke(MapsKt.mapOf(r107));
        return;
    L10:
        r105 = null;
    L5:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
