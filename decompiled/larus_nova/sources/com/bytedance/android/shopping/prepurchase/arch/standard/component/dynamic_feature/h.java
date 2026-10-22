package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import android.content.Context;
import android.util.AndroidRuntimeException;
import android.view.View;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ecom.arch.slice.action.p;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.ContainerTrackAbility;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public class h implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<?, ?> f180946a;

    public static final class a {
    }

    static {
    }

    public h(com.bytedance.android.shopping.prepurchase.arch.container.c<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f180946a = r100;
    }

    public static jq.a h(jq.a r100, String r101) {
        String r102 = r100.h();
        if (r102 == null) goto L8;
        String r103 = r100.f();
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        String r104 = StringsKt.replace$default(r102, r103, r101, false, 4, null);
    L10:
        return jq.a.a(r100, r101, r104);
    L8:
        r104 = null;
        goto L10
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.t
    public final void e(Context r100, iq.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "toastParam");
        com.bytedance.android.ec.sdk.helper.i r102 = com.bytedance.android.ec.sdk.helper.i.f48124a;
        String r103 = r101.a();
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102.e(r100, r103, r101.b(), false);
    }

    public final void g(jq.a r100, Map<String, ? extends Object> r101, View r110) {
        LinkedHashMap r102 = new LinkedHashMap();
        if (r101 == null) goto L5;
        r102.putAll(r101);
    L5:
        Integer r103 = r100.d();
        boolean r104 = true;
        if (r103 != null) goto L8;
    L10:
        boolean r105 = false;
    L11:
        if (r105 == false) goto L45;
        if (r110 == null) goto L59;
        String r106 = r100.e();
        if (r106 != null) goto L17;
        r106 = "";
    L17:
        String r107 = r100.f();
        String r108 = r100.h();
        i r109 = new i(this, r100, r101);
        if (r106.length() != 0) goto L20;
        boolean r111 = true;
    L21:
        if (r111 == false) goto L23;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L23:
        com.bytedance.android.bst.api.d r112 = new com.bytedance.android.bst.api.d(r110);
        r112.f41906a = r106;
        if (r107 == null) goto L44;
        r112.f41907b = r107;
        r112.f41908c = r108;
        r112.f41909d = "shopping";
        r112.f41910e = -1;
        r112.f41911f = r109;
        Integer r113 = r100.d();
        if (r113 != null) goto L29;
    L31:
        boolean r114 = false;
    L32:
        if (r114 == false) goto L34;
        com.bytedance.android.bst.api.f.f41925b.getClass();
        com.bytedance.android.bst.api.f.a(r112);
        return;
    L34:
        Integer r115 = r100.d();
        if (r115 != null) goto L38;
    L40:
        r104 = false;
    L41:
        if (r104 == false) goto L57;
        com.bytedance.android.bst.api.f.f41925b.getClass();
        com.bytedance.android.bst.api.f.c(r112);
        return;
    L57:
        return;
    L38:
        if (r115.intValue() != 2) goto L40;
    L29:
        if (r113.intValue() != 1) goto L31;
        r114 = true;
        goto L32
    L44:
        throw new AndroidRuntimeException("event is empty");
    L20:
        r111 = false;
        goto L21
    L59:
        return;
    L45:
        LinkedHashMap r116 = new LinkedHashMap();
        if (r101 == null) goto L48;
        r116.putAll(r101);
    L48:
        Map<String, String> r117 = r100.i();
        if (r117 == null) goto L51;
        r116.putAll(r117);
    L51:
        String r118 = r100.e();
        if (r118 == null) goto L54;
        r116.put("btm", r118);
    L54:
        ContainerTrackAbility.a r119 = this.f180946a.a().m();
        r119.f180701a = r116;
        String r120 = r100.g();
        String r121 = r100.h();
        r119.a(r120, r100.c(), r121, PageFinder.via(r110));
        return;
    L8:
        if (r103.intValue() <= 0) goto L10;
        r105 = true;
        goto L11
    }
}
