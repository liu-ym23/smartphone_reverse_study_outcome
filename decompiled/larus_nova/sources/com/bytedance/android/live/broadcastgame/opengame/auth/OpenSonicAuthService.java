package com.bytedance.android.live.broadcastgame.opengame.auth;

import b94.b;
import com.alipay.sdk.m.p.e;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameDataReportHelper;
import com.bytedance.android.live.broadcastgame.opengame.openapi.v;
import com.bytedance.android.live.broadcastgame.opengame.openapi.x;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.g;
import com.bytedance.android.live.broadcastgame.opengame.runtime.j;
import com.bytedance.android.live.broadcastgame.opengame.t;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.bdp.live.livecontainer.sonicgame.c;
import com.bytedance.bdp.live.livecontainer.sonicgame.f;
import com.bytedance.bdp.serviceapi.hostimpl.hostmethod.BdpInteractHostMethodService;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/auth/OpenSonicAuthService;", "Lcom/bytedance/android/live/broadcastgame/opengame/auth/OpenBaseAuthService;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenSonicAuthService extends OpenBaseAuthService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PluginContext f59725a;

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenSonicAuthService f59726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f59727b;

        @Override // com.bytedance.bdp.live.livecontainer.sonicgame.c
        public final void a(JSONObject r110) {
            Intrinsics.checkNotNullParameter("onSettingClick", "status");
            Intrinsics.checkNotNullParameter(r110, "data");
            int r100 = GameDataReportHelper.f59290a;
            PluginContext r101 = this.f59726a.f59725a;
            t r102 = r101.f60809m;
            long r103 = r102.f61082h;
            String r104 = r102.b(r101.f60811o);
            String r105 = ((BootInfoService) this.f59726a.f59725a.o(BootInfoService.class)).e();
            String r106 = r110.optString("status");
            String r107 = r110.optString("authScope");
            Intrinsics.checkNotNullParameter(r104, "gameName");
            Intrinsics.checkNotNullParameter(r105, "gameCategory");
            Intrinsics.checkNotNullParameter(r106, "status");
            Intrinsics.checkNotNullParameter(r107, "authScope");
            u.l().sendLog("livesdk_little_game_authority_setting", MapsKt.mapOf(new Pair[]{TuplesKt.to("game_id", String.valueOf(r103)), TuplesKt.to(EventConstants.ExtraJson.GAME_NAME, r104), TuplesKt.to(BdpAppEventConstant.PARAMS_GAME_CATEGORY, r105), TuplesKt.to("user_id", ((IUserService) k.n(IUserService.class)).user().n()), TuplesKt.to("certification_mode", GameDataReportHelper.a(r107)), TuplesKt.to("button_clicked", GameDataReportHelper.a(r107)), TuplesKt.to("status", r106)}), new Object[]{Room.class});
            this.f59727b.a(r110);
        }

        @Override // com.bytedance.bdp.live.livecontainer.sonicgame.c
        public final void onFail(String r100) {
            Intrinsics.checkNotNullParameter(r100, "errMsg");
            this.f59727b.onFail(r100);
        }

        @Override // com.bytedance.bdp.live.livecontainer.sonicgame.c
        public final void onSuccess(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            this.f59727b.onSuccess(r100);
        }

        public a(OpenSonicAuthService r100, c r101) {
            this.f59726a = r100;
            this.f59727b = r101;
        }
    }

    public OpenSonicAuthService(PluginContext r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        super(r100);
        this.f59725a = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.auth.OpenBaseAuthService
    public final void a(String r100, v.a r101) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        f.a(r100, r101);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.auth.OpenBaseAuthService
    public final void b(String r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        f.b(r100, new a(this, r101));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.auth.OpenBaseAuthService
    public final void c(String r110, List r111, JSONObject r112, x r113) {
        Intrinsics.checkNotNullParameter(r110, "appId");
        Intrinsics.checkNotNullParameter(r111, "requestList");
        Intrinsics.checkNotNullParameter(r112, "extra");
        Intrinsics.checkNotNullParameter(r113, "callback");
        JSONObject r114 = new JSONObject();
        List r100 = CollectionsKt.toMutableList(r111);
        Iterator r101 = r111.iterator();
    L4:
        if (r101.hasNext() == false) goto L28;
        String r102 = (String) r101.next();
        BootInfoService r103 = (BootInfoService) this.f59725a.o(BootInfoService.class);
        Intrinsics.checkNotNullParameter(r102, "authScope");
        Intrinsics.checkNotNullParameter("getUserInfoV2", e.f25671s);
        g r104 = r103.c();
        if (r104 == null) goto L21;
        j r105 = r104.f60835b;
        if (r105 == null) goto L21;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a> r106 = r105.f60839a;
        if (r106 == null) goto L21;
        Iterator<T> r107 = r106.iterator();
    L13:
        if (r107.hasNext() == false) goto L21;
        com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a r108 = (com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a) r107.next();
        if (Intrinsics.areEqual("getUserInfoV2", r108.c()) == false) goto L13;
        if (r108.a() == null) goto L13;
        Long r109 = r108.a().get(r102);
        if (r109 == null) goto L21;
        long r115 = r109.longValue();
    L23:
        if (r115 == 2) goto L24;
        if (r115 != 0) goto L4;
        r100.remove(r102);
        goto L4
    L24:
        r114.put(r102, true);
    L21:
        r115 = 0;
        goto L23
    L28:
        r112.put("strictPermission", r114);
        if (r100.isEmpty() == false) goto L36;
        Iterator r116 = r111.iterator();
    L32:
        if (r116.hasNext() == false) goto L34;
        String r117 = (String) r116.next();
        int r118 = GameDataReportHelper.f59290a;
        PluginContext r119 = this.f59725a;
        t r120 = r119.f60809m;
        GameDataReportHelper.d(r120.f61082h, r120.b(r119.f60811o), ((BootInfoService) this.f59725a.o(BootInfoService.class)).e(), false, "not_authorized", r117);
        goto L32
    L34:
        r113.b(new ArrayList());
        return;
    L36:
        BdpInteractHostMethodService r121 = f.f201520a;
        l10.a r122 = new l10.a(this, r113, r114);
        ArrayList r123 = new ArrayList();
        Iterator r124 = r100.iterator();
    L38:
        if (r124.hasNext() == false) goto L47;
        String r125 = (String) r124.next();
        Iterator r126 = CollectionsKt.listOf(new b[]{b94.c.f18247a, b94.c.f18249c, b94.c.f18257k, b94.c.f18259m, b94.c.f18260n, b94.c.f18248b, b94.c.f18250d, b94.c.f18256j, b94.c.f18261o, b94.c.f18263q, b94.c.f18251e, b94.c.f18252f, b94.c.f18253g, b94.c.f18254h, b94.c.f18255i, b94.c.f18258l, b94.c.f18262p, b94.c.f18264r}).iterator();
    L41:
        if (r126.hasNext() == false) goto L38;
        b r127 = (b) r126.next();
        if (Intrinsics.areEqual(r125, r127.f18246a) == false) goto L41;
        if (Intrinsics.areEqual(r127, b94.c.f18248b) == false) goto L41;
        r123.add(r127);
        goto L41
    L47:
        if (r112 != null) goto L49;
        new JSONObject();
    L49:
        BdpInteractHostMethodService r128 = f.f201520a;
        if (r128 == null) goto L76;
        new com.bytedance.bdp.live.livecontainer.sonicgame.e(r122);
        r128.S1();
        return;
    }
}
