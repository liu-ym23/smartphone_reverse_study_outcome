package com.bytedance.android.live.broadcastgame.opengame.debug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.g0;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/debug/GameReceiver;", "Landroid/content/BroadcastReceiver;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<String> f59960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.api.openplatform.b f59961b;

    public static final class a {
    }

    static {
    }

    public GameReceiver() {
        this(null);
    }

    public GameReceiver(com.bytedance.android.live.broadcastgame.api.openplatform.b r100) {
        this.f59961b = r100;
        this.f59960a = new HashSet();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r210, Intent r211) {
        Intrinsics.checkNotNullParameter(r211, "intent");
        String r100 = r211.getStringExtra("schema");
        String r101 = r211.getStringExtra("cloudgame_order_id");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L20;
        String r110 = URLDecoder.decode(r100, "UTF-8");
        if (r110 == null) goto L20;
        int r103 = q.f60744a;
        q.h("adb pull game ==>  schema: ".concat(r110));
        String r104 = UriProtector.getQueryParameter(UriProtector.parse(r110), "app_id");
        String r212 = "{\"game_id\":123,\"game_type\":1,\"group_type\":1,\"need_game_desc\":false,\"rank\":10,\"show_anchor_float_entrance\":true,\"show_audience_float_entrance\":true,\"app_id\":\"" + r104 + "\",\"app_version\":\"0.1\"}";
        InteractID r213 = InteractID.SonicMiniGame;
        u r105 = new u(r213.getValue(), "调试", CollectionsKt.emptyList(), 1, 1, CollectionsKt.emptyList(), r212);
        r105.f59370b.f59362a = true;
        r r106 = r105.c();
        if (r106 == null) goto L20;
        Map<String, ? extends Object> r111 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_debug", Boolean.TRUE), TuplesKt.to("game", r105), TuplesKt.to("app_version", "0.1"), TuplesKt.to("app_id", r104), TuplesKt.to("game_id", 123)});
        com.bytedance.android.live.broadcastgame.api.openplatform.b r107 = this.f59961b;
        if (r107 == null) goto L19;
        r107.i(r106.p(), r106.b(), r110, r111, true, true);
    L19:
        ImageModel r112 = new ImageModel();
        r112.setUrls(CollectionsKt.emptyList());
        Unit r108 = Unit.INSTANCE;
        InteractEntranceCell r109 = new InteractEntranceCell(r213.getValue(), "调试", "当前直播间本地调试", r112, 1, r212, 130976);
        r109.f59324f.f59362a = true;
        xs2.b.a().post(new g0(true, r109));
    L20:
        if (r101 != null) goto L23;
        return;
    L23:
        if (this.f59960a.contains(r101) == true) goto L28;
        this.f59960a.add(r101);
        xs2.b.a().post(new b(r101));
        return;
    L28:
        return;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }
}
