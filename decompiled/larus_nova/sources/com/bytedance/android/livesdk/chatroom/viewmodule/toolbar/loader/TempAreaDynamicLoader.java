package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcastgame.api.model.SupportLiveMode;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.chatroom.model.w2;
import com.bytedance.android.livesdk.chatroom.model.x;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.ea0;
import com.bytedance.android.livesdk.message.model.TempStateAreaReachMessage;
import com.bytedance.android.livesdk.room.placeholder.behavior.m;
import com.bytedance.android.livesdk.room.placeholder.behavior.n;
import com.bytedance.android.livesdk.room.placeholder.behavior.o;
import com.bytedance.android.livesdk.room.placeholder.behavior.p;
import com.bytedance.android.livesdk.utils.d2;
import com.bytedance.android.livesdk.utils.e2;
import com.bytedance.android.livesdk.utils.v5;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import gd0.v;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vlc.l;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tR\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/TempAreaDynamicLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "Lvlc/l;", "Landroid/content/Context;", "r", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TempAreaDynamicLoader extends AbsDynamicLoader implements l {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f116448t = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f116449h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public o f116450i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<ExtendedToolbarButton.c> f116451j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<ExtendedToolbarButton.c> f116452k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<ExtendedToolbarButton> f116453l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public vlc.d f116454m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CompositeDisposable f116455n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f116456o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f116457p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final x3 f116458q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Context f116459r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Function1<String, Unit> f116460s;

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TempAreaDynamicLoader f116461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f116462b;

        public b(TempAreaDynamicLoader r100, String r101) {
            this.f116461a = r100;
            this.f116462b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final Object apply(Object r310) {
            com.bytedance.android.live.network.response.e r100 = (com.bytedance.android.live.network.response.e) r310;
            Intrinsics.checkNotNullParameter(r100, "resp");
            x r101 = (x) r100.data;
            if (r101 == null) goto L165;
            Intrinsics.checkNotNullParameter(r101, "$this$toLocalCollectModel");
            Boolean r102 = r101.disable;
            boolean r103 = true;
            if (r102 == null) goto L7;
            boolean r104 = r102.booleanValue();
        L8:
            ImageModel r105 = r101.icon;
            if (r105 == null) goto L16;
            List<String> r106 = r105.getUrls();
            if (r106 == null) goto L16;
            String r107 = (String) ListProtector.get(r106, 0);
            if (r107 == null) goto L16;
            String r108 = r107;
        L17:
            String r109 = r101.title;
            if (r109 != null) goto L20;
            String r110 = "";
        L21:
            String r111 = r101.entranceSchema;
            if (r111 != null) goto L24;
            r111 = "";
        L24:
            List<x.a> r112 = r101.items;
            int r113 = 10;
            if (r112 == null) goto L68;
            List<x.a> r114 = r112;
            ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
            Iterator<T> r116 = r114.iterator();
        L28:
            if (r116.hasNext() == false) goto L67;
            x.a r117 = (x.a) r116.next();
            Intrinsics.checkNotNullParameter(r117, "$this$toLocalModel");
            String r118 = r117.appId;
            if (r118 != null) goto L32;
            String r119 = "";
        L33:
            String r120 = r117.name;
            if (r120 != null) goto L36;
            String r121 = "";
        L37:
            ImageModel r122 = r117.iconUrl;
            if (r122 == null) goto L45;
            List<String> r123 = r122.getUrls();
            if (r123 == null) goto L45;
            String r124 = (String) ListProtector.get(r123, 0);
            if (r124 == null) goto L45;
            String r125 = r124;
        L46:
            String r126 = r117.version;
            if (r126 != null) goto L49;
            String r127 = "";
        L50:
            String r128 = r117.config;
            if (r128 != null) goto L53;
            String r129 = "";
        L54:
            String r130 = r117.desc;
            if (r130 != null) goto L57;
            String r210 = "";
        L58:
            Boolean r131 = r117.disabled;
            if (r131 == null) goto L61;
            boolean r211 = !r131.booleanValue();
        L62:
            String r132 = r117.gameCategory;
            if (r132 != null) goto L65;
            String r212 = "";
        L66:
            r115.add(new w2(r119, r121, r125, r127, r129, r210, r211, r212));
            goto L28
        L65:
            r212 = r132;
            goto L66
        L61:
            r211 = false;
            goto L62
        L57:
            r210 = r130;
            goto L58
        L53:
            r129 = r128;
            goto L54
        L49:
            r127 = r126;
        L45:
            r125 = "";
            goto L46
        L36:
            r121 = r120;
            goto L37
        L32:
            r119 = r118;
            goto L33
        L67:
            ArrayList r133 = r115;
        L69:
            Intrinsics.checkNotNullParameter(r108, "icon");
            Intrinsics.checkNotNullParameter(r110, "title");
            Intrinsics.checkNotNullParameter(r111, "entranceSchema");
            if (r104 == false) goto L72;
        L84:
            long r134 = TempStateAreaReachMessage.ELEM_TYPE.OPEN_GAME.getType();
            if (r133 == null) goto L165;
            ArrayList r135 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r133, 10));
            Iterator<T> r136 = r133.iterator();
            int r213 = 0;
        L88:
            if (r136.hasNext() == false) goto L157;
            T r137 = r136.next();
            int r138 = r213 + 1;
            if (r213 >= 0) goto L92;
            CollectionsKt.throwIndexOverflow();
        L92:
            w2 r139 = (w2) r137;
            Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L148
            JsonObject r141 = new JsonParser().parse(r139.f106981e).getAsJsonObject();     // Catch: Throwable -> L148
            long r214 = r141.get("game_id").getAsLong();     // Catch: Throwable -> L148
            String r215 = r141.get("schema").getAsString();     // Catch: Throwable -> L148
            int r216 = r141.get(BdpAppEventConstant.PARAMS_GAME_TYPE).getAsInt();     // Catch: Throwable -> L148
            Long r142 = (Long) this.f116461a.f116377a.get("data_anchor_current_game_id", -1L);     // Catch: Throwable -> L148
            if (r142 != null) goto L97;
        L99:
            boolean r217 = false;
        L100:
            JsonArray r143 = r141.get("support_live_scene").getAsJsonArray();     // Catch: Throwable -> L148
            if (r143 == null) goto L108;
            List r144 = CollectionsKt.toList(r143);     // Catch: Throwable -> L148
            if (r144 == null) goto L108;
            List r145 = r144;     // Catch: Throwable -> L148
            ArrayList r146 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r145, r113));     // Catch: Throwable -> L148
            Iterator<T> r147 = r145.iterator();     // Catch: Throwable -> L148
        L106:
            if (r147.hasNext() == false) goto L109;
            r146.add(Integer.valueOf(((JsonElement) r147.next()).getAsInt()));     // Catch: Throwable -> L148
        L109:
            ALogger.i(this.f116461a.f116457p, String.valueOf(r146));     // Catch: Throwable -> L148
            if (r146 != null) goto L112;
        L115:
            boolean r148 = true;
        L116:
            if (r148 == false) goto L118;
        L143:
            r135 = r135;
            Iterator<T> r218 = r136;
            long r219 = r134;
            int r311 = r138;
            ExtendedToolbarButton.c r149 = null;
        L144:
            Object r150 = Result.m9449constructorimpl(r149);     // Catch: Throwable -> L146
        L153:
            Throwable r151 = Result.m9452exceptionOrNullimpl(r150);
            if (r151 == null) goto L156;
            ALogger.e(this.f116461a.f116457p, "parse collect item config error", r151);
        L156:
            ArrayList r152 = r135;
            r152.add(Result.m9448boximpl(r150));
            r135 = r152;
            r136 = r218;
            r134 = r219;
            r213 = r311;
            r113 = 10;
            goto L88
        L118:
            if (TempAreaDynamicLoader.f(this.f116461a, r146) == false) goto L143;
            TempAreaDynamicLoader r153 = this.f116461a;     // Catch: Throwable -> L148
            String r154 = r139.f106979c;     // Catch: Throwable -> L148
            String r155 = r139.f106978b;     // Catch: Throwable -> L148
            String r156 = r139.f106977a;     // Catch: Throwable -> L148
            boolean r157 = Intrinsics.areEqual(this.f116462b, r156);     // Catch: Throwable -> L148
            r153.getClass();     // Catch: Throwable -> L148
            r149 = TempAreaDynamicLoader.j(r154, r155, "", r156, r134, r214, r157);     // Catch: Throwable -> L148
            if (TextUtils.isEmpty(r139.f106984h) == true) goto L123;
            String r158 = r139.f106984h;     // Catch: Throwable -> L148
        L124:
            r149.f115633o = r158;     // Catch: Throwable -> L148
            TempAreaDynamicLoader r159 = this.f116461a;     // Catch: Throwable -> L148
            if (r159.f116380d == false) goto L127;
            c0 r160 = y3.f(r159.f116377a);     // Catch: Throwable -> L148
        L128:
            c0 r161 = r160;
            DataCenter r162 = this.f116461a.f116377a;     // Catch: Throwable -> L148
            String r163 = r139.f106980d;     // Catch: Throwable -> L148
            String r164 = r139.f106977a;     // Catch: Throwable -> L148
            r218 = r136;
            r219 = r134;
            r135 = r135;
            r311 = r138;
            n r165 = new n(r162, r214, r163, r164, r215, r139.f106978b, r216, r158, r139.f106983g, r213, r217, Intrinsics.areEqual(this.f116462b, r164), r139.f106979c);     // Catch: Throwable -> L146
            if (r139.f106983g == true) goto L138;
            if (r217 == true) goto L138;
            r161.l(r149, "该玩法需要主播发起，您可以去其他直播间或换其他玩法");     // Catch: Throwable -> L146
        L138:
            r161.p(r149, r165);     // Catch: Throwable -> L146
        L146:
            th = th;
        L152:
            Result.Companion r166 = Result.Companion;
            r150 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L139:
            th = th;
            r135 = r135;
        L151:
            r311 = r138;
        L141:
            th = th;
        L150:
            r219 = r134;
            goto L151
        L127:
            r160 = y3.i(r159.f116377a);     // Catch: Throwable -> L148
            goto L128
        L123:
            r158 = null;
            goto L124
        L112:
            if (r146.isEmpty() == true) goto L115;
            r148 = false;
        L108:
            r146 = null;
            goto L109
        L97:
            if (r142.longValue() != r214) goto L99;
            r217 = true;
        L148:
            th = th;
            r218 = r136;
            goto L150
        L157:
            ArrayList r167 = r135;
            ArrayList r168 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r167, 10));
            Iterator r169 = r167.iterator();
        L159:
            if (r169.hasNext() == false) goto L186;
            Object r170 = ((Result) r169.next()).m9458unboximpl();
            if (Result.m9455isFailureimpl(r170) == false) goto L163;
            r170 = null;
        L163:
            r168.add((ExtendedToolbarButton.c) r170);
            goto L159
        L186:
            return CollectionsKt.filterNotNull(r168);
        L72:
            if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r111) == false) goto L84;
            TempAreaDynamicLoader r171 = this.f116461a;
            int r172 = TempAreaDynamicLoader.f116448t;
            r171.getClass();
            ArrayList r173 = new ArrayList();
            ExtendedToolbarButton.c r174 = TempAreaDynamicLoader.j(r108, r110, "", "", TempStateAreaReachMessage.ELEM_TYPE.PROFIT_OPEN_GAME_ENTRANCE.getType(), 8848, true);
            if (r171.f116380d == false) goto L76;
            c0 r175 = y3.f(r171.f116377a);
        L77:
            Context r176 = r171.f116459r;
            if (r133 != null) goto L80;
        L82:
            r103 = false;
        L83:
            r175.p(r174, new m(r176, r174, r111, r103));
            r173.add(r174);
            return r173;
        L80:
            if ((!r133.isEmpty()) != true) goto L82;
        L76:
            r175 = y3.i(r171.f116377a);
            goto L77
        L68:
            r133 = null;
            goto L69
        L20:
            r110 = r109;
        L16:
            r108 = "";
            goto L17
        L7:
            r104 = true;
        L165:
            return null;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TempAreaDynamicLoader f116463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f116464b;

        public c(TempAreaDynamicLoader r100, String r101) {
            this.f116463a = r100;
            this.f116464b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List r101 = (List) r100;
            if (r101 == null) goto L5;
            this.f116463a.f116452k.addAll(r101);
            this.f116463a.f116460s.invoke("collect list fetch success");
        L5:
            String r102 = this.f116464b;
            if (r102 != null) goto L8;
        L13:
            this.f116463a.f116456o = false;
            return;
        L8:
            if (r102.length() <= 0) goto L10;
            boolean r103 = true;
        L11:
            if (r103 != true) goto L13;
            this.f116463a.f116377a.put("cmd_toolbar_click_update_red_dot", "");
            goto L13
        L10:
            r103 = false;
            goto L11
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TempAreaDynamicLoader f116465a;

        public d(TempAreaDynamicLoader r100) {
            this.f116465a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = this.f116465a.f116457p;
            ALogger.e(r101, "fetch collect list error", (Throwable) r100);
            this.f116465a.f116456o = false;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ArrayList r100 = new ArrayList();
        r100.addAll(this.f116453l);
        ArrayList<ExtendedToolbarButton.c> r101 = this.f116451j;
        ArrayList r102 = new ArrayList();
        Iterator<ExtendedToolbarButton.c> r103 = r101.iterator();
    L3:
        boolean r104 = false;
        if (r103.hasNext() == false) goto L10;
        ExtendedToolbarButton.c r105 = r103.next();
        if (r105.f115632n == TempStateAreaReachMessage.ELEM_TYPE.OPEN_GAME.getType()) goto L8;
        r104 = true;
    L8:
        if (r104 == false) goto L3;
        r102.add(r105);
        goto L3
    L10:
        ArrayList r106 = new ArrayList();
        Iterator r107 = r102.iterator();
    L12:
        if (r107.hasNext() == false) goto L22;
        Object r108 = r107.next();
        if (((ExtendedToolbarButton.c) r108).f115632n != TempStateAreaReachMessage.ELEM_TYPE.PREDICTOR.getType()) goto L16;
        boolean r109 = true;
    L17:
        if (r109 == false) goto L19;
        boolean r110 = yx1.a.b(this.f116376g);
    L20:
        if (r110 == false) goto L12;
        r106.add(r108);
        goto L12
    L19:
        r110 = true;
        goto L20
    L16:
        r109 = false;
        goto L17
    L22:
        r100.addAll(r106);
        e2.c(r100, this.f116458q);
        Intrinsics.checkNotNullParameter(r100, "$this$sortBySpecificRule");
        Collections.sort(r100, d2.f158928a);
        if (com.bytedance.android.livesdk.config.setting.o.a() == true) goto L25;
    L27:
        List<ExtendedToolbarButton.c> r111 = this.f116452k;
    L28:
        r100.addAll(r111);
        ArrayList r112 = new ArrayList();
        if (r100.size() <= 16) goto L31;
        r112.addAll(r100.subList(0, (int) 16));
    L32:
        return r112;
    L31:
        r112.addAll(r100);
        goto L32
    L25:
        if (this.f116452k.size() <= 5) goto L27;
        r111 = this.f116452k.subList(0, 5);
        goto L28
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void d() {
        this.f116452k.clear();
        Room r100 = this.f116376g;
        if (r100 != null) goto L5;
        return;
    L5:
        if (g() == false) goto L10;
        long r101 = r100.f162599id;
        this.f116449h = true;
        com.bytedance.android.livesdk.service.l.d().getClass();
        Disposable r102 = ((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).fetchTempStateAreaData(r101).compose(RxUtil.rxSchedulerHelper()).map(new h(this)).subscribe(new i(this), new j(this));
        CompositeDisposable r103 = this.f116455n;
        if (r103 == null) goto L10;
        r103.add(r102);
    L10:
        h();
    }

    public final boolean g() {
        if (tb1.c.f545231c == false) goto L6;
        return false;
    L6:
        if (this.f116379c == false) goto L8;
    L14:
        return false;
    L8:
        if (this.f116376g == null) goto L14;
        if (this.f116449h == true) goto L14;
        return ea0.f120110a.getValue().booleanValue();
    }

    public final void h() {
        if (this.f116380d == true) goto L5;
        return;
    L5:
        if (this.f116456o == true) goto L40;
        this.f116456o = true;
        String r100 = v5.b().getString("live_collect_game_and_should_show_hot_dot", "");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r101 = null;
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L12;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m> r103 = r102.getCompactTbLoader();
        if (r103 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r104 = r103.getValue();
    L14:
        if ((r104 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) == false) goto L17;
        r101 = r104;
    L17:
        int r105 = 0;
        if (r101 == null) goto L20;
        boolean r106 = r101.isComponentShowing(6);
    L21:
        if (r106 == false) goto L38;
        su0.a r107 = yt0.c.g();
        if (r107 == null) goto L25;
        r105 = r107.pf();
    L25:
        com.bytedance.android.livesdk.service.l.d().getClass();
        RoomRetrofitApi r108 = (RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class);
        Room r109 = this.f116376g;
        if (r109 == null) goto L28;
        long r110 = r109.f162599id;
    L29:
        if (r109 == null) goto L32;
        String r111 = r109.getOwnerUserIdString();
        if (r111 == null) goto L32;
    L33:
        Disposable r112 = RxUtilKt.h(r108.fetchProfitCollectList(r110, r111, 1, r105).map(new b(this, r100))).subscribe(new c(this, r100), new d(this));
        CompositeDisposable r113 = this.f116455n;
        if (r113 == null) goto L39;
        r113.add(r112);
        return;
    L39:
        return;
    L32:
        r111 = "-1";
        goto L33
    L28:
        r110 = -1;
        goto L29
    L38:
        return;
    L20:
        r106 = false;
    L12:
        r104 = null;
        goto L14
    }

    public final o i() {
        if (this.f116450i != null) goto L5;
        this.f116450i = new o();
    L5:
        o r100 = this.f116450i;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        this.f116455n = new CompositeDisposable();
        vlc.d r100 = (vlc.d) this.f116377a.get("data_message_manager", null);
        this.f116454m = r100;
        if (r100 == null) goto L5;
        r100.addMessageListener(MessageType.TEMP_STATE_AREA_MESSAGE.getIntType(), this);
    L5:
        com.bytedance.android.livesdk.service.l.d().f().c(this.f116453l, this.f116380d);
        this.f116377a.observe("show_toolbar_red_dot_by_collect_game", this);
        Iterator<ExtendedToolbarButton> r101 = this.f116453l.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().f115622d = 1;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onUnLoad() {
        super.onUnLoad();
        i().b();
        CompositeDisposable r100 = this.f116455n;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f116456o = false;
        this.f116377a.removeObserver(this);
        vlc.d r101 = this.f116454m;
        if (r101 == null) goto L9;
        r101.removeMessageListener(this);
        return;
    }

    public final Context getContext() {
        return this.f116459r;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader
    public final void e(KVData r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getKey();
    L7:
        if (StringsKt.equals$default(r102, "show_toolbar_red_dot_by_collect_game", false, 2, null) == false) goto L13;
        SharedPreferences.Editor r103 = v5.a();
        if (r100 == null) goto L11;
        r101 = (String) r100.getData();
    L11:
        r103.putString("live_collect_game_and_should_show_hot_dot", r101).apply();
        h();
        return;
    L13:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(Object r100) {
        e((KVData) r100);
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r110) {
        if ((r110 instanceof TempStateAreaReachMessage) == true) goto L5;
        return;
    L5:
        if (r110.getIntType() != MessageType.TEMP_STATE_AREA_MESSAGE.getIntType()) goto L93;
        TempStateAreaReachMessage r100 = (TempStateAreaReachMessage) r110;
        if (r100.H() != null) goto L10;
        return;
    L10:
        if (g() == false) goto L95;
        long r101 = r100.getStatus();
        ExtendedToolbarButton.c r102 = null;
        if (r101 != TempStateAreaReachMessage.Status.ADD.getValue()) goto L47;
        ExtendedToolbarButton.c r103 = j(r100.H().b(), r100.H().c(), r100.H().a(), String.valueOf(r100.getItemId()), r100.G(), r100.E(), false);
        DataCenter r104 = this.f116377a;
        long r105 = r100.G();
        Context r111 = this.f116459r;
        boolean r112 = this.f116380d;
        long r113 = r100.getItemId();
        long r114 = r100.E();
        String r115 = r100.H().c();
        r100.H().getClass();
        i().a(r103, new p(r104, r105, r111, r112, r113, r114, r115));
        Iterator<ExtendedToolbarButton.c> r106 = this.f116451j.iterator();
    L16:
        if (r106.hasNext() == false) goto L26;
        ExtendedToolbarButton.c r107 = r106.next();
        if (Intrinsics.areEqual(r107.f115637s, r103.f115637s) == false) goto L16;
        if (r107.f115631m != r103.f115631m) goto L16;
        if (r107.f115632n != r103.f115632n) goto L16;
        if (Intrinsics.areEqual(r107.f115630l, r103.f115630l) == false) goto L16;
        boolean r108 = true;
    L27:
        if (r108 == true) goto L96;
        Iterator<ExtendedToolbarButton.c> r109 = this.f116451j.iterator();
    L31:
        if (r109.hasNext() == false) goto L42;
        ExtendedToolbarButton.c r116 = r109.next();
        ExtendedToolbarButton.c r117 = r116;
        if (r117.f115632n == r103.f115632n) goto L35;
    L39:
        boolean r118 = false;
    L40:
        if (r118 == false) goto L31;
        r102 = r116;
        goto L42
    L35:
        if (r117.f115631m != r103.f115631m) goto L39;
        if ((!Intrinsics.areEqual(r117.f115637s, r103.f115637s)) == false) goto L39;
        r118 = true;
    L42:
        ExtendedToolbarButton.c r119 = r102;
        if (r119 == null) goto L45;
        this.f116451j.remove(r119);
    L45:
        ListProtector.add(this.f116451j, 0, r103);
    L69:
        this.f116460s.invoke("temp area message");
        return;
    L96:
        return;
    L26:
        r108 = false;
        goto L27
    L47:
        if (r101 != TempStateAreaReachMessage.Status.DELETE.getValue()) goto L59;
        Iterator<ExtendedToolbarButton.c> r120 = this.f116451j.iterator();
    L50:
        if (r120.hasNext() == false) goto L54;
        ExtendedToolbarButton.c r121 = r120.next();
        if (Intrinsics.areEqual(r121.f115637s, String.valueOf(r100.getItemId())) == false) goto L50;
        r102 = r121;
    L54:
        ExtendedToolbarButton.c r122 = r102;
        if (r122 == null) goto L57;
        this.f116451j.remove(r122);
    L57:
        i().c(r100.getItemId());
        goto L69
    L59:
        if (r101 != TempStateAreaReachMessage.Status.UPDATE.getValue()) goto L69;
        Iterator<ExtendedToolbarButton.c> r123 = this.f116451j.iterator();
    L62:
        if (r123.hasNext() == false) goto L66;
        ExtendedToolbarButton.c r124 = r123.next();
        if (Intrinsics.areEqual(r124.f115637s, String.valueOf(r100.getItemId())) == false) goto L62;
        r102 = r124;
    L66:
        ExtendedToolbarButton.c r125 = r102;
        if (r125 == null) goto L69;
        ArrayList r126 = new ArrayList();
        r126.add(r100.H().b());
        Intrinsics.checkNotNullParameter(r126, "<set-?>");
        r125.f115634p = r126;
        String r127 = r100.H().c();
        Intrinsics.checkNotNullParameter(r127, "<set-?>");
        r125.f115635q = r127;
        String r128 = r100.H().a();
        Intrinsics.checkNotNullParameter(r128, "<set-?>");
        r125.f115630l = r128;
        goto L69
    L95:
        return;
    }

    public static final boolean f(TempAreaDynamicLoader r100, List r101) {
        LiveMode r102 = (LiveMode) r100.f116377a.get("data_live_mode", LiveMode.VIDEO);
        int r103 = 4;
        if (r102 == null) goto L12;
        int r104 = g.f116476a[r102.ordinal()];
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 == 3) goto L15;
        if (r104 != 4) goto L11;
        int r105 = SupportLiveMode.SCREEN_RECORD.getValue();
    L18:
        Integer r106 = (Integer) r100.f116377a.get("data_link_state", 0);
        if (v.a(r106.intValue(), 4) == false) goto L22;
        r103 = 1;
    L43:
        return com.bytedance.android.live.broadcastgame.api.interactgame.j.b(r101, r103, r105);
    L22:
        if (v.a(r106.intValue(), 2) == false) goto L27;
        if (((com.bytedance.android.live.liveinteract.service.f) ((IInteractService) k.n(IInteractService.class)).getInteractAudienceService()).P() == true) goto L43;
    L27:
        if (v.a(r106.intValue(), 16) == false) goto L30;
        r103 = 3;
        goto L43
    L30:
        if (v.a(r106.intValue(), 32) == false) goto L33;
        r103 = 8;
        goto L43
    L33:
        if (v.a(r106.intValue(), 64) == false) goto L36;
        r103 = 7;
        goto L43
    L36:
        if (v.a(r106.intValue(), 8) == false) goto L38;
        r103 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        goto L43
    L38:
        int r107 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        if (r107 != 4) goto L41;
        r103 = 0;
        goto L43
    L41:
        r103 = r107;
        goto L43
    L11:
        if (r104 != 5) goto L12;
        r105 = SupportLiveMode.MEDIA.getValue();
        goto L18
    L15:
        r105 = SupportLiveMode.AUDIO.getValue();
        goto L18
    L16:
        r105 = SupportLiveMode.OBS.getValue();
        goto L18
    L17:
        r105 = SupportLiveMode.VIDEO.getValue();
    L12:
        r105 = SupportLiveMode.UNKNOWN.getValue();
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TempAreaDynamicLoader(e r100, x3 r101, Context r102, Function1<? super String, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "env");
        Intrinsics.checkNotNullParameter(r101, "mToolbarManager");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "update");
        super(r100);
        this.f116458q = r101;
        this.f116459r = r102;
        this.f116460s = r103;
        this.f116451j = new ArrayList();
        this.f116452k = new ArrayList();
        this.f116453l = new ArrayList();
        this.f116457p = "TempAreaDynamicLoader";
    }

    public static ExtendedToolbarButton.c j(String r100, String r101, String r102, String r103, long r104, long r105, boolean r106) {
        ArrayList r107 = new ArrayList();
        r107.add(r100);
        ExtendedToolbarButton.c r108 = new ExtendedToolbarButton.c(r107, r101, r106, r103);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r108.f115630l = r102;
        r108.f115619a = r104;
        r108.f115632n = r104;
        r108.f115631m = r105;
        r108.f115627i = R.drawable.ttlive_more_dialog_temp_state_area_icon;
        return r108;
    }
}
