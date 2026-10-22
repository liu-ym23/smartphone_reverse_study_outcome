package com.bytedance.android.ec.window.base.dynamicview.common;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.window.base.dynamicview.virtualview.UIViewGroup;
import com.bytedance.android.ec.window.base.dynamicview.virtualview.k;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f49251a = 0;

    static {
        new Gson();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [lo.a] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.util.ArrayList] */
    public static UIViewGroup a(lo.a r100, lo.b r110, List r111) {
        Intrinsics.checkNotNullParameter(r110, "dto");
        Intrinsics.checkNotNullParameter(r111, "siblings");
        String r101 = r110.e();
        a.a(r101, "viewType");
        e r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        String r103 = r110.d();
        a.a(r103, "uniqueId");
        if (r103 != null) goto L8;
        return null;
    L8:
        lo.d r104 = r110.c();
        if (r104 == null) goto L11;
        com.bytedance.android.ec.window.base.dynamicview.virtualview.j r105 = r104.b();
    L12:
        a.a(r105, "vo");
        if (r105 != null) goto L15;
        return null;
    L15:
        if (r100 != null) goto L17;
    L16:
        e r106 = r102;
        JsonArray r107 = r110.g();
        if (r107 != null) goto L23;
    L47:
        ?? r108 = CollectionsKt.emptyList();
    L48:
        ArrayList r109 = new ArrayList();
        Iterator r112 = ((Iterable) r108).iterator();
    L50:
        if (r112.hasNext() == false) goto L54;
        k<? extends View, ? extends ViewGroup.LayoutParams> r113 = ((lo.a) r112.next()).f(r110, r108);
        if (r113 == null) goto L50;
        r109.add(r113);
        goto L50
    L54:
        b r114 = b.f49249c;
        String r115 = r110.b();
        if (r115 != null) goto L57;
        String r116 = "";
    L59:
        return r114.b(r101, r116, r103, r105, r110.h(), r109, r106);
    L57:
        r116 = r115;
        goto L59
    L23:
        if (r107.size() == 0) goto L47;
        ArrayList r117 = new ArrayList();
        Iterator<JsonElement> r118 = r107.iterator();
    L27:
        if (r118.hasNext() == false) goto L31;
        JsonElement r119 = r118.next();
        if ((r119 instanceof JsonObject) == false) goto L27;
        r117.add(r119);
        goto L27
    L31:
        r108 = new ArrayList();
        Iterator r120 = r117.iterator();
    L33:
        if (r120.hasNext() == false) goto L48;
        JsonObject r121 = (JsonObject) r120.next();
        b r122 = b.f49249c;
        JsonElement r123 = r121.get(BytedCertConstant.IntentKey.VIEW_TYPE);
        if (r123.isJsonPrimitive() == true) goto L37;
    L39:
        String r124 = "";
    L41:
        if (r122.d(r124) == false) goto L43;
        Class r125 = lo.b.class;
    L44:
        lo.a r126 = (lo.a) uo.a.a(r121, r125);
        if (r126 == null) goto L33;
        r108.add(r126);
        goto L33
    L43:
        r125 = lo.a.class;
        goto L44
    L37:
        if (r123.getAsJsonPrimitive().isString() == false) goto L39;
        r124 = r123.getAsString();
        goto L41
    L17:
        f r127 = b.f49249c.c(r100.e());
        if (r127 == null) goto L16;
        r102 = r127.a(r110, r111);
        goto L16
    L11:
        r105 = null;
        goto L12
    }
}
