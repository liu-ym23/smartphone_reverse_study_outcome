package com.bytedance.android.ec.sdk.helper;

import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.local.api.ErrorType;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements cl.d {
    public a() {
    }

    @Override // cl.d
    public final void a(String r100, Object r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        Intrinsics.checkNotNullParameter(r102, PlayerResolution.SDKKEY.ORIGIN);
    }

    @Override // cl.d
    public final void b() {
    }

    @Override // cl.d
    public final void c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // cl.d
    public final void d(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // cl.d
    public final void e() {
    }

    @Override // cl.d
    public final void f() {
    }

    @Override // cl.d
    public final void g() {
    }

    @Override // cl.d
    public final void i() {
    }

    @Override // cl.d
    public final void k() {
    }

    @Override // cl.d
    public final void l() {
    }

    @Override // cl.d
    public final void m() {
    }

    @Override // cl.d
    public final void n() {
    }

    @Override // cl.d
    public final void o(String r100, String r101, ErrorType r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "type");
    }

    @Override // cl.d
    public final void p() {
    }

    @Override // cl.d
    public final void q() {
    }

    @Override // cl.d
    public final void r() {
    }

    @Override // cl.d
    public final void h(Map r110) {
        Intrinsics.checkNotNullParameter(r110, "entry");
        dm.a.b r100 = dm.a.a("LocalService");
        StringBuilder r101 = new StringBuilder("[reportPageInfo]\n ");
        ArrayList r102 = new ArrayList(r110.size());
        Iterator r111 = r110.entrySet().iterator();
    L4:
        if (r111.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r111.next();
        r102.add(((String) r103.getKey()) + ":" + ((String) r103.getValue()));
        goto L4
    L6:
        r101.append(CollectionsKt.joinToString$default(r102, null, null, null, 0, null, null, 63, null));
        r100.i(r101.toString());
    }

    @Override // cl.d
    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
    }
}
