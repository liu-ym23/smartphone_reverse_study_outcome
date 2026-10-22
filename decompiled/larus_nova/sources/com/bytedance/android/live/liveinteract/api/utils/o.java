package com.bytedance.android.live.liveinteract.api.utils;

import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.live.livelink.kmp.api.base.config.Vendor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import uf2.d0;

/* JADX INFO: loaded from: classes46.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f71526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f71527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f71528c;

    public o(p r100, long r101) {
        this.f71526a = r100;
        this.f71527b = 3;
        this.f71528c = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f71526a.getClass();
        int r102 = 0;
        if (m.d() == null) goto L13;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r103 = m.d().s();
        com.bytedance.android.livesdk.chatroom.viewmodel.f r104 = null;
        if (r103 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r105 = r103.getValue();
    L8:
        if (r105 == null) goto L13;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r106 = m.d().s();
        if (r106 == null) goto L12;
        r104 = r106.getValue();
    L12:
        Intrinsics.checkNotNull(r104);
        int r107 = r104.t().f114792a;
    L14:
        JSONObject r108 = new JSONObject();
        r108.put("ver", this.f71527b);
        this.f71526a.getClass();
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r109 = m.d().s();
        if (r109 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r110 = r109.getValue();
        if (r110 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r111 = r110.t();
        if (r111 == null) goto L21;
        int r112 = r111.f114793b;
    L22:
        r108.put("ui_layout", r112);
        r108.put(Constants.OperatorKey.KEY_VENDOR, Vendor.BYTE.getValue());
        r108.put("timestamp", System.currentTimeMillis());
        r108.put("channel_id", String.valueOf(this.f71528c));
        r108.put(BdpAppEventConstant.PARAMS_SUB_SCENE, r107);
        this.f71526a.getClass();
        u r113 = m.d();
        if (r113 == null) goto L31;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r114 = r113.s();
        if (r114 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r115 = r114.getValue();
        if (r115 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r116 = r115.t();
        if (r116 == null) goto L31;
        r102 = r116.f114793b;
    L31:
        r108.put("ui_layout", r102);
        r108.put("grids", new JSONArray());
        com.bytedance.android.live.pushstream.d r117 = this.f71526a.f71530b;
        if (r117 == null) goto L34;
        r117.c1("app_data", r108.toString(), -1, true, true);
    L34:
        if (r107 != 0) goto L40;
        com.bytedance.android.live.pushstream.d r118 = this.f71526a.f71530b;
        if (r118 == null) goto L46;
        d0 r119 = r118.A();
        if (r119 == null) goto L47;
        r119.c0();
        return;
    L47:
        return;
    L46:
        return;
    L40:
        com.bytedance.android.live.pushstream.d r120 = this.f71526a.f71530b;
        if (r120 == null) goto L49;
        d0 r121 = r120.A();
        if (r121 == null) goto L50;
        r121.c0();
        return;
    L50:
        return;
    L49:
        return;
    L21:
        r112 = 0;
        goto L22
    L7:
        r105 = null;
    L13:
        r107 = 0;
        goto L14
    }
}
