package com.bytedance.android.live.revlink.impl.pk.feedview;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.android.live.revlink.impl.lynxcontainer.PkLynxDataContextKt$convertPkResultToInt$1$1;
import com.bytedance.android.live.revlink.impl.lynxcontainer.PkLynxDataContextKt$sendDataToLynx$$inlined$also$lambda$1;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.FormatType;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.MultiRegisterViewListenContext;
import com.bytedance.android.live.revlink.impl.pk.feedview.layout.FeedPkWindowManager;
import com.bytedance.android.live.revlink.impl.pk.ui.PKMeasureOptFrameLayout;
import com.bytedance.android.live.revlink.impl.settings.dynamic.LinkMultiDynamicSettingsKt;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting;
import com.bytedance.android.livesdk.link.model.a9;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w20.ae;

/* JADX INFO: loaded from: classes47.dex */
public final class FeedPkLynxWidget implements com.bytedance.android.live.revlink.impl.lynxcontainer.a {
    public static final /* synthetic */ int G = 0;
    public final com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c A;
    public final com.bytedance.android.live.revlink.impl.pk.scopeservice.a B;
    public final boolean C;
    public final boolean D;
    public final Function0<Pair<Integer, Integer>> E;
    public final com.bytedance.android.live.revlink.impl.pk.feedview.layout.c F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, zy0.b> f96351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, com.bytedance.android.live.revlink.impl.lynxcontainer.b> f96352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, PKMeasureOptFrameLayout> f96353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.a f96354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, ArrayList<JSONObject>> f96355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<String> f96356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f96357g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e41.a f96358h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap<String, LiveData<?>> f96359i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MultiRegisterViewListenContext f96360j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap<String, LiveData<? extends Object>> f96361k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Context f96362l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public zy0.b f96363m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.lynxcontainer.b f96364n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HashMap<IBaseBattleSetting, JsonElement> f96365o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public pc0.a f96366p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public IRoom f96367q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList<JSONObject> f96368r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final HashMap<String, com.bytedance.ies.web.jsbridge2.f.b> f96369s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f96370t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f96371u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f96372v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final j f96373w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Map<String, LiveData<Pair<String, JSONObject>>> f96374x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final FrameLayout f96375y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b f96376z;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeedPkLynxWidget f96377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f96378b;

        public b(FeedPkLynxWidget r100, String r101) {
            this.f96377a = r100;
            this.f96378b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.live.revlink.impl.pk.feedview.layout.c r100 = this.f96377a.F;     // Catch: Throwable -> L9
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.a() != true) goto L16;
            this.f96377a.t(this.f96378b);     // Catch: Throwable -> L9
            return;
        L16:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zy0.b f96379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f96380b;

        public c(zy0.b r100, String r101) {
            this.f96379a = r100;
            this.f96380b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = (String) r100;
            zy0.b r102 = this.f96379a;
            if (r102 == null) goto L5;
            xy0.a<?> r103 = r102.g();
        L6:
            if (r103 != null) goto L8;
            return;
        L8:
            if (r103.isDisposed() == true) goto L12;
            r103.sendJsEvent(this.f96380b, r101);
            return;
        L12:
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f96381a = null;

        static {
            f96381a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            jy0.b.b("FeedPkLynxWidget", "sendJsEvent error", (Throwable) r100);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void e() {
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void k() {
    }

    public final boolean u() {
        return ((Boolean) this.f96372v.getValue()).booleanValue();
    }

    public static String s() {
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.g() == false) goto L6;
        return "H5_revenueInteractData";
    L6:
        return "H5_webcastNotification";
    }

    private final HybridType getType(zy0.b r100) {
        if (r100 == null) goto L6;
        xy0.a<?> r101 = r100.g();
        if (r101 == null) goto L6;
        return r101.o();
    L6:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void a(List<String> r100) {
        List<String> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        Iterator<String> r103 = r100.iterator();
    L13:
        if (r103.hasNext() == false) goto L38;
        com.bytedance.android.live.revlink.impl.lynxcontainer.b r104 = com.bytedance.android.live.revlink.impl.lynxcontainer.d.a(r103.next());
        zy0.b r105 = this.f96351a.get(r104.o());
        if (r105 == null) goto L13;
        View r106 = r105.c();
        if (r106 == null) goto L13;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        ViewGroup.LayoutParams r108 = null;
        if ((r107 instanceof FrameLayout.LayoutParams) == true) goto L22;
        r107 = null;
    L22:
        FrameLayout.LayoutParams r109 = (FrameLayout.LayoutParams) r107;
        if (r109 == null) goto L13;
        if (u() == false) goto L27;
        View r110 = this.f96353c.get(r104.o());
    L28:
        if (r110 == null) goto L37;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if ((r111 instanceof FrameLayout.LayoutParams) == false) goto L34;
        r108 = r111;
    L34:
        FrameLayout.LayoutParams r112 = (FrameLayout.LayoutParams) r108;
        if (r112 == null) goto L37;
        com.bytedance.android.live.revlink.impl.lynxcontainer.c.a(r104, r112, this.f96375y.getWidth(), this.f96375y.getHeight());
        r110.setLayoutParams(r112);
    L37:
        r106.setLayoutParams(r109);
        goto L13
    L27:
        r110 = r106;
        goto L28
    L38:
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final String c(List<String> r100) {
        if (r100 != null) goto L5;
    L42:
        return "";
    L5:
        if (r100.size() == 0) goto L42;
        JSONObject r101 = new JSONObject();
        Iterator<T> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L41;
        String r103 = (String) r102.next();
        JSONObject r104 = null;
        if (this.f96359i.containsKey(r103) == false) goto L20;
        LiveData<?> r105 = this.f96359i.get(r103);
        if (r105 == null) goto L17;
        Object r106 = r105.getValue();
        if (r106 == null) goto L17;
        JSONObject r107 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r106);
    L18:
        r101.put(r103, r107);
    L17:
        r107 = null;
    L20:
        if (Intrinsics.areEqual(r103, "linkmic_score") == false) goto L23;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r108 = this.A;
    L37:
        if (r108 == null) goto L39;
        r104 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r108);
    L39:
        r101.put(r103, r104);
        goto L9
    L23:
        if (Intrinsics.areEqual(r103, "play_scores") == false) goto L29;
        MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> r109 = this.A.f96459f;
        if (r109 == null) goto L27;
        r108 = r109.getValue();
        goto L37
    L27:
        r108 = null;
        goto L37
    L29:
        if (Intrinsics.areEqual(r103, "contribution_list") == false) goto L32;
    L30:
        r108 = "";
        goto L37
    L32:
        if (Intrinsics.areEqual(r103, "battle_settings") == false) goto L35;
        r108 = this.f96376z.b();
        goto L37
    L35:
        if (Intrinsics.areEqual(r103, "play_anchor_list") == false) goto L30;
        r108 = this.f96376z.f96658f;
        goto L37
    L41:
        return r101.toString();
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final JSONObject f(List<String> r100) {
        JSONObject r101 = new JSONObject();
        List<String> r102 = r100;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return r101;
    L11:
        Iterator<String> r104 = r100.iterator();
    L13:
        if (r104.hasNext() == false) goto L15;
        String r105 = r104.next();
        r101.put(r105, r(r105));
        goto L13
    L15:
        return r101;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void g(List<String> r100) {
        List<String> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        Iterator<String> r103 = r100.iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        com.bytedance.android.live.revlink.impl.lynxcontainer.b r104 = com.bytedance.android.live.revlink.impl.lynxcontainer.d.a(r103.next());
        this.f96352b.put(r104.o(), r104);
        goto L13
    L15:
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void h(List<String> r100) {
        List<String> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        Iterator<String> r103 = r100.iterator();
    L13:
        if (r103.hasNext() == false) goto L19;
        com.bytedance.android.live.revlink.impl.lynxcontainer.b r104 = com.bytedance.android.live.revlink.impl.lynxcontainer.d.a(r103.next());
        this.f96352b.remove(r104.o());
        zy0.b r105 = this.f96351a.remove(r104.o());
        if (r105 == null) goto L13;
        w(r104, this.f96375y, r105.c());
        if (r105.isDisposed() == true) goto L13;
        r105.dispose();
        goto L13
    L19:
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void i(List<String> r100) {
        List<String> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        Iterator<String> r103 = r100.iterator();
    L13:
        if (r103.hasNext() == false) goto L35;
        com.bytedance.android.live.revlink.impl.lynxcontainer.b r104 = com.bytedance.android.live.revlink.impl.lynxcontainer.d.a(r103.next());
        if (this.f96351a.containsKey(r104.o()) == true) goto L16;
        u6 r105 = new u6(r104.e());
        u6 r106 = r105.d("url");
        Iterator<String> r107 = r104.d().iterator();
    L28:
        if (r107.hasNext() == false) goto L30;
        String r108 = r107.next();
        r106.b(r108, r(r108));
        goto L28
    L30:
        this.f96356f.add(r104.o());
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r109 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(this.f96362l, r105.c(), new FeedPkLynxWidget$addLynxView$hybridCard$1(this, r104));
        this.f96351a.put(r104.o(), r109);
        this.f96352b.put(r104.o(), r104);
        if (r109 == null) goto L13;
        xy0.a<?> r110 = r109.g();
        if (r110 == null) goto L13;
        ((com.bytedance.android.live.revenue.platform.hybrid.impl.component.b) r110).load(null, null);
        goto L13
    L16:
        zy0.b r111 = this.f96351a.get(r104.o());
        if (r111 == null) goto L13;
        View r112 = r111.c();
        if (r112 == null) goto L13;
        w(r104, this.f96375y, r112);
        zy0.b r113 = this.f96351a.get(r104.o());
        if (r113 == null) goto L13;
        xy0.a<?> r114 = r113.g();
        if (r114 == null) goto L13;
        r114.load();
        goto L13
    L35:
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void l(CallContext r100) {
        Intrinsics.checkNotNullParameter(r100, "callContext");
        this.f96360j.d(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final int m(ae r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        List<String> r101 = r100.f557963b;
        int r102 = 0;
        if (r101 == null) goto L11;
        Iterator<String> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        String r104 = r103.next();
        JSONObject r105 = new JSONObject();
        r105.put("type", "message_from_other");
        r105.put("from", r100.f557962a);
        r105.put("data", r100.f557964c);
        if (this.f96351a.get(r104) == null) goto L9;
        x(this.f96351a.get(r104), s(), r105.toString());
        goto L6
    L9:
        r102 = 1;
    L11:
        return r102;
    }

    public final void q(String r100) {
        if (this.f96358h != null) goto L5;
    L11:
        t(r100);
        return;
    L5:
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.d() <= 0) goto L11;
        e41.a r101 = this.f96358h;
        if (r101 == null) goto L13;
        r101.b(new b(this, r100));
        return;
    }

    public final String r(String r100) {
        Gson r101 = GsonHelper.get();
        Object r102 = null;
        if (this.f96359i.containsKey(r100) == false) goto L23;
        LiveData<?> r103 = this.f96359i.get(r100);
        if (r103 == null) goto L7;
        Object r104 = r103.getValue();
    L9:
        if ((r104 instanceof String) == false) goto L17;
        LiveData<?> r105 = this.f96359i.get(r100);
        if (r105 == null) goto L13;
        r102 = r105.getValue();
    L13:
        if (r102 == null) goto L16;
        return (String) r102;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L17:
        LiveData<?> r106 = this.f96359i.get(r100);
        if (r106 == null) goto L21;
        r102 = r106.getValue();
    L21:
        return GsonProtectorUtils.toJson(r101, r102);
    L7:
        r104 = null;
        goto L9
    L23:
        if (this.f96361k.containsKey(r100) == false) goto L43;
        LiveData<? extends Object> r107 = this.f96361k.get(r100);
        if (r107 == null) goto L27;
        Object r108 = r107.getValue();
    L29:
        if ((r108 instanceof String) == false) goto L37;
        LiveData<? extends Object> r109 = this.f96361k.get(r100);
        if (r109 == null) goto L33;
        r102 = r109.getValue();
    L33:
        if (r102 == null) goto L36;
        return (String) r102;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L37:
        LiveData<? extends Object> r110 = this.f96361k.get(r100);
        if (r110 == null) goto L41;
        r102 = r110.getValue();
    L41:
        return GsonProtectorUtils.toJson(r101, r102);
    L27:
        r108 = null;
        goto L29
    L43:
        if (Intrinsics.areEqual(r100, "channel_id") == false) goto L45;
    L75:
        pc0.a r111 = this.f96366p;
        if (r111 == null) goto L93;
        String r112 = r111.getChannelId();
        if (r112 != null) goto L81;
        return "";
    L81:
        return r112;
    L93:
        return "";
    L45:
        if (Intrinsics.areEqual(r100, "channel_id_str") == true) goto L75;
        if (Intrinsics.areEqual(r100, "scene") == false) goto L52;
        return "1";
    L52:
        if (Intrinsics.areEqual(r100, "skin_type") == false) goto L56;
        return String.valueOf(this.f96376z.d());
    L56:
        if (Intrinsics.areEqual(r100, "skin_config") == true) goto L58;
        IBaseBattleSetting r113 = this.f96376z.b();
        if (this.f96365o.get(r113) != null) goto L83;
        this.f96365o.put(r113, GsonProtectorUtils.toJsonTree(r101, r113));
    L83:
        HashMap<IBaseBattleSetting, JsonElement> r114 = this.f96365o;     // Catch: Exception -> L82
        if (r114 == null) goto L87;
        JsonElement r115 = r114.get(r113);     // Catch: Exception -> L82
        if (r115 == null) goto L88;
        JsonObject r116 = r115.getAsJsonObject();     // Catch: Exception -> L82
        if (r116 == null) goto L89;
        JsonElement r117 = r116.get(r100);     // Catch: Exception -> L82
        if (r117 == null) goto L90;
        String r118 = r117.toString();     // Catch: Exception -> L82
        if (r118 != null) goto L74;
        return "";
    L74:
        return r118;
    L90:
        return "";
    L89:
        return "";
    L88:
        return "";
    L87:
        return "";
    L92:
        return "";
    L58:
        return GsonProtectorUtils.toJson(r101, this.f96376z.c());
    }

    public final void t(String r110) {
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r100 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        if (r100.f() == true) goto L5;
        return;
    L5:
        if (this.f96367q != null) goto L7;
        return;
    L7:
        if (this.f96371u == true) goto L9;
        return;
    L9:
        if (this.f96370t == true) goto L12;
        return;
    L12:
        if (this.f96363m == null) goto L14;
        return;
    L14:
        String r101 = this.f96364n.e();
        u6 r102 = new u6(r101);
        u6 r103 = r102.d("url");
        String r104 = "1";
        if (this.C == false) goto L18;
        String r105 = "2";
    L21:
        r103.b("load_source", r105);
        r103.b("interact_time_cnt", String.valueOf(LinkMultiDynamicSettingsKt.a()));
        r103.b("from_type", "");
        if (r100.e() == false) goto L24;
        String r106 = "1";
    L25:
        r103.b("control_native_enable", r106);
        IRoom r107 = this.f96367q;
        if (r107 == null) goto L28;
        String r108 = r107.getAnchorId();
    L29:
        r103.b("anchor_id", r108);
        IRoom r109 = this.f96367q;
        if (r109 == null) goto L39;
        IRoomLinkExt r111 = (IRoomLinkExt) r109.castToOrNull(IRoomLinkExt.class);
        if (r111 == null) goto L39;
        a9 r112 = r111.getLinkMicInfo();
        if (r112 == null) goto L39;
        ILinkMicBattleSetting r113 = r112.getBattleSetting();
        if (r113 == null) goto L39;
        r103.b("battle_id", String.valueOf(r113.getBattleId()));
        r103.b("base_play_mode", String.valueOf(r113.getPlayMode()));
        r103.b("base_team_mode", String.valueOf(r113.getTeamMode()));
        r103.b("base_activity_mode", String.valueOf(r113.getActivityMode()));
    L39:
        if (r100.g() == false) goto L41;
        String r114 = "1";
    L42:
        r103.b("live_revenue_interact_dynamic_data_format", r114);
        if (r41.f.f536019a == true) goto L46;
        r104 = "0";
    L46:
        r103.b("support_nine_linker", r104);
        jy0.b.d("FeedPkLynxWidget", "init lynx from " + r110);
        long r115 = SystemClock.elapsedRealtime();
        if (u() == false) goto L49;
        this.f96363m = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).q8(this.f96362l, r102.c(), new FeedPkLynxWidget$initHubLynx$2(this, r115, r101));
    L50:
        zy0.b r116 = this.f96363m;
        if (r116 == null) goto L55;
        xy0.a<?> r117 = r116.g();
        if (r117 == null) goto L55;
        r117.load();
    L55:
        zy0.b r118 = this.f96363m;
        if (r118 == null) goto L58;
        r118.l1(new FeedPkLynxWidget$initHubLynx$4(this));
    L58:
        this.f96376z.f96674v = new FeedPkLynxWidget$initHubLynx$5(this);
        this.f96376z.f96672t = this.f96363m;
        return;
    L49:
        this.f96363m = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(this.f96362l, r102.c(), new FeedPkLynxWidget$initHubLynx$3(this, r115, r101));
        goto L50
    L41:
        r114 = "0";
        goto L42
    L28:
        r108 = null;
        goto L29
    L24:
        r106 = "0";
        goto L25
    L18:
        if (this.D == false) goto L20;
        r105 = "3";
        goto L21
    L20:
        r105 = "1";
        goto L21
    }

    public static final /* synthetic */ HybridType j(FeedPkLynxWidget r100, zy0.b r101) {
        return r100.getType(r101);
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "action");
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void d(CallContext r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, PromotionProductPrivilegesStruct.TAGS);
        MultiRegisterViewListenContext r102 = this.f96360j;
        if (r102 == null) goto L6;
        r102.c(r100, r101);
        return;
    }

    public final boolean v(com.bytedance.android.live.revlink.impl.lynxcontainer.b r100, String r101) {
        if (r100 == null) goto L10;
        List<String> r102 = r100.n();
        if (r102 == null) goto L10;
        if (r102.contains(r101) != true) goto L10;
        if (ArraysKt.contains(com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.a(), r101) == true) goto L10;
        return true;
    L10:
        return false;
    }

    public static final void n(FeedPkLynxWidget r100, String r101, String r110) {
        if (r100.C == false) goto L6;
        int r102 = 2;
    L9:
        com.bytedance.android.live.revlink.impl.global.c r103 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r103 == null) goto L21;
        LiveFullLinkPKMonitor r104 = r103.getLiveFullLinkPKMonitor();
        if (r104 == null) goto L21;
        if (r101 != null) goto L16;
        String r105 = "";
    L17:
        if (r110 != null) goto L19;
        String r106 = "";
    L20:
        LiveFullLinkPKMonitor.o(r104, "link_dynamic_central_load_failed", r105, r106, 0, r102, 8);
        goto L21
    L19:
        r106 = r110;
        goto L20
    L16:
        r105 = r101;
    L21:
        jy0.b.c("LynxContainerWidget", "lynx load error errMsg = " + r110, null, 4);
        FrameLayout r107 = r100.f96375y;
        if (r107 == null) goto L24;
        r107.removeAllViews();
    L24:
        r100.f96376z.f96673u = false;
        return;
    L6:
        if (r100.D == false) goto L8;
        r102 = 3;
        goto L9
    L8:
        r102 = 1;
        goto L9
    }

    public final void w(com.bytedance.android.live.revlink.impl.lynxcontainer.b r100, ViewGroup r101, View r102) {
        if (u() == false) goto L9;
        PKMeasureOptFrameLayout r103 = this.f96353c.get(r100.o());
        if (r103 == null) goto L17;
        if (r101 == null) goto L8;
        r101.removeView(r103);
    L8:
        this.f96353c.remove(r100.o());
        return;
    L17:
        return;
    L9:
        if (r102 == null) goto L11;
        ViewParent r104 = r102.getParent();
    L13:
        if (Intrinsics.areEqual(r104, r101) == false) goto L19;
        if (r101 == null) goto L20;
        r101.removeView(r102);
        return;
    L20:
        return;
    L19:
        return;
    L11:
        r104 = null;
        goto L13
    }

    public final void x(zy0.b r100, String r101, String r102) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (u() == true) goto L10;
        xy0.a<?> r103 = r100.g();
        if (r103 == null) goto L17;
        r103.sendJsEvent(r101, r102);
        return;
    L17:
        return;
    L10:
        xy0.a<?> r104 = r100.g();
        if (r104 != null) goto L13;
        return;
    L13:
        if (r104.isDisposed() == true) goto L19;
        RxUtilKt.c(Observable.just(r102).observeOn(Schedulers.single()).subscribe(new c(r100, r101), d.f96381a), this.f96357g);
        return;
    }

    public static final void o(FeedPkLynxWidget r100, View r101, long r102, String r110) {
        r100.getClass();
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r103 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        r103.getClass();
        boolean r104 = false;
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.a.f97535f.getValue(r103, com.bytedance.android.live.revlink.impl.settings.dynamic.a.f97530a[4])).booleanValue() == false) goto L15;
        com.bytedance.android.live.revlink.impl.global.c r105 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r105 == null) goto L15;
        LiveFullLinkPKMonitor r106 = r105.getLiveFullLinkPKMonitor();
        if (r106 == null) goto L15;
        com.bytedance.android.live.revlink.impl.pk.utils.q r107 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r107 == null) goto L13;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r108 = r107.g();
        if (r108 == null) goto L13;
        int r109 = r108.isBattleStatsObtained();
    L14:
        LiveFullLinkPKMonitor.n(r106, r109, SystemClock.elapsedRealtime() - r102, 0);
    L13:
        r109 = 0;
    L15:
        Logger.i("FeedPkLynxWidget", "load success time = " + SystemClock.elapsedRealtime());
        jy0.b.d("FeedPkLynxWidget", "lynx load success ");
        HybridType r111 = r100.getType(r100.f96363m);
        zy0.b r112 = r100.f96363m;
        if (r112 == null) goto L18;
        View r113 = r112.c();
    L20:
        if (r111 != HybridType.H5) goto L25;
        if (r101 == null) goto L24;
        ((WebView) r101).setBackgroundColor(0);
        goto L25
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.webkit.WebView");
    L25:
        FrameLayout.LayoutParams r114 = new FrameLayout.LayoutParams(-2, -2);
        if (r100.f96375y.getWidth() != 0) goto L28;
    L31:
        r100.f96375y.post(new i(r100, r114, r113));
    L33:
        if (r111 != HybridType.LYNX) goto L35;
        char r115 = 1;
    L36:
        Iterator<String> r116 = r100.f96359i.keySet().iterator();
    L38:
        if (r116.hasNext() == false) goto L52;
        String r117 = r116.next();
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.g() == false) goto L42;
        LiveData r118 = (LiveData) ((LinkedHashMap) r100.f96374x).get(r117);
    L46:
        if (r118 == null) goto L38;
        Pair r119 = (Pair) r118.getValue();
        if (r119 == null) goto L38;
        if (r100.v(r100.f96364n, (String) r119.getFirst()) == false) goto L38;
        r100.x(r100.f96363m, s(), ((JSONObject) r119.getSecond()).toString());
        goto L38
    L42:
        LiveData<?> r120 = r100.f96359i.get(r117);
        if (r120 == null) goto L45;
        Intrinsics.checkNotNullParameter(r120, "$this$sendDataToLynx");
        Intrinsics.checkNotNullParameter(r117, "tag");
        MediatorLiveData r121 = new MediatorLiveData();
        r121.addSource(r120, new PkLynxDataContextKt$sendDataToLynx$$inlined$also$lambda$1(r121, r117));
        r118 = r121;
        goto L46
    L45:
        r118 = null;
        goto L46
    L52:
        Iterator<JSONObject> r122 = r100.f96368r.iterator();
    L54:
        if (r122.hasNext() == false) goto L56;
        r100.x(r100.f96363m, s(), r122.next().toString());
        goto L54
    L56:
        ArrayList<JSONObject> r123 = r100.f96368r;
        if (r123 == null) goto L59;
        r123.clear();
    L59:
        FrameLayout r124 = r100.f96375y;
        if (r124 == null) goto L65;
        vy0.c r125 = (vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class);
        Context r126 = r100.f96362l;
        if (r115 != 1) goto L64;
        r104 = true;
    L64:
        r125.addHybridDebugTool(r126, r124, r110, r104);
    L65:
        r100.f96376z.f96673u = true;
        MultiRegisterViewListenContext r127 = r100.f96360j;
        if (r127 == null) goto L79;
        r127.a();
        return;
    L79:
        return;
    L35:
        r115 = 2;
        goto L36
    L28:
        if (r100.f96375y.getHeight() == 0) goto L31;
        com.bytedance.android.live.revlink.impl.lynxcontainer.c.a(r100.f96364n, r114, r100.f96375y.getWidth(), r100.f96375y.getHeight());
        r100.p(r100.f96364n, r114, r100.f96375y, r113);
        goto L33
    L18:
        r113 = null;
        goto L20
    }

    public final void p(com.bytedance.android.live.revlink.impl.lynxcontainer.b r100, FrameLayout.LayoutParams r101, ViewGroup r102, View r103) {
        if (r103 != null) goto L4;
        return;
    L4:
        ViewParent r104 = null;
        if (u() == false) goto L18;
        View r105 = (PKMeasureOptFrameLayout) this.f96353c.remove(r100.o());
        if (r105 == null) goto L9;
        r102.removeView(r105);
    L9:
        PKMeasureOptFrameLayout r106 = new PKMeasureOptFrameLayout(r102.getContext());
        ViewParent r107 = r103.getParent();
        if ((r107 instanceof ViewGroup) == false) goto L13;
        r104 = r107;
    L13:
        ViewGroup r108 = (ViewGroup) r104;
        if (r108 == null) goto L16;
        r108.removeView(r103);
    L16:
        r106.addView(r103, new FrameLayout.LayoutParams(-1, -1));
        r106.setHasFixSize(true);
        this.f96353c.put(r100.o(), r106);
        r106.setTranslationZ(r100.s());
        Unit r109 = Unit.INSTANCE;
        r102.addView(r106, r101);
        return;
    L18:
        if ((!Intrinsics.areEqual(r103.getParent(), r102)) == false) goto L27;
        ViewParent r110 = r103.getParent();
        if ((r110 instanceof ViewGroup) == false) goto L23;
        r104 = r110;
    L23:
        ViewGroup r111 = (ViewGroup) r104;
        if (r111 == null) goto L26;
        r111.removeView(r103);
    L26:
        r102.addView(r103, r101);
    L27:
        r103.setTranslationZ(r100.s());
    }

    public FeedPkLynxWidget(FrameLayout r110, com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r111, com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c r112, com.bytedance.android.live.revlink.impl.pk.scopeservice.a r210, boolean r211, boolean r212, Function0 r213, FeedPkWindowManager r214) {
        Intrinsics.checkNotNullParameter(r110, "lynxContainer");
        Intrinsics.checkNotNullParameter(r111, "viewState");
        Intrinsics.checkNotNullParameter(r112, "bridget");
        Intrinsics.checkNotNullParameter(r210, "service");
        Intrinsics.checkNotNullParameter(r213, "getPlayerWH");
        this.f96375y = r110;
        this.f96376z = r111;
        this.A = r112;
        this.B = r210;
        this.C = r211;
        this.D = r212;
        this.E = r213;
        this.F = r214;
        this.f96351a = new HashMap();
        this.f96352b = new HashMap();
        this.f96353c = new HashMap();
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.a r113 = new com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.a(r110, r111, r112, r210, r213);
        this.f96354d = r113;
        this.f96355e = new HashMap();
        this.f96356f = new ArrayList();
        CompositeDisposable r100 = new CompositeDisposable();
        this.f96357g = r100;
        HashMap<String, LiveData<?>> r101 = new HashMap();
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r102 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        if (r102.g() == true) goto L5;
        r101.put("pk_status", q.b(r112.f96458e, r111, new FeedPkLynxWidget$$special$$inlined$apply$lambda$1(this)));
        r101.put("remain_time", r112.f96457d);
        r101.put("pk_score", r112.f96459f);
        MutableLiveData<q11.a> r103 = r112.f96461h;
        Intrinsics.checkNotNullParameter(r103, "$this$convertPkResultToInt");
        final MediatorLiveData r104 = new MediatorLiveData();
        r104.addSource(r103, new PkLynxDataContextKt$convertPkResultToInt$1$1(r104));
        r101.put("pk_result", r104);
        r101.put("team_task", r112.f96460g);
        r101.put("pk_prop_card_info", r112.f96462i);
    L6:
        Unit r105 = Unit.INSTANCE;
        this.f96359i = r101;
        this.f96360j = new MultiRegisterViewListenContext(r101);
        HashMap<String, LiveData<? extends Object>> r106 = new HashMap();
        if (r102.g() == false) goto L9;
        r106.put("pk_status", q.b(r112.f96458e, r111, new FeedPkLynxWidget$$special$$inlined$apply$lambda$2(this)));
        r106.put("remain_time", r112.f96457d);
        r106.put("pk_score", r112.f96459f);
        MutableLiveData<q11.a> r107 = r112.f96461h;
        Intrinsics.checkNotNullParameter(r107, "$this$convertPkResultToInt");
        final MediatorLiveData r108 = new MediatorLiveData();
        r108.addSource(r107, new PkLynxDataContextKt$convertPkResultToInt$1$1(r108));
        r106.put("pk_result", r108);
        r106.put("team_task", r112.f96460g);
        r106.put("pk_prop_card_info", r112.f96462i);
    L9:
        this.f96361k = r106;
        this.f96362l = r110.getContext();
        com.bytedance.android.live.revlink.impl.settings.dynamic.b.f97568m.getClass();
        this.f96364n = com.bytedance.android.live.revlink.impl.lynxcontainer.d.a(com.bytedance.android.live.revlink.impl.settings.dynamic.b.e(true));
        this.f96365o = new HashMap();
        this.f96368r = new ArrayList();
        this.f96369s = new HashMap();
        this.f96371u = true;
        this.f96372v = LazyKt.lazy(FeedPkLynxWidget$isFeedOpt$2.INSTANCE);
        this.f96373w = new j(this);
        LinkedHashMap r109 = new LinkedHashMap(MapsKt.mapCapacity(r101.size()));
        Iterator r114 = r101.entrySet().iterator();
    L11:
        if (r114.hasNext() == false) goto L13;
        Map.Entry r115 = (Map.Entry) r114.next();
        Object r116 = r115.getKey();
        String r117 = (String) r115.getKey();
        r109.put(r116, com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.b((LiveData) r115.getValue(), r117, FormatType.NEW));
        goto L11
    L13:
        this.f96374x = r109;
        return;
    L5:
        r101.put("channel_id", r113.f96638a);
        r101.put("sei", r113.f96639b);
        r101.put("screen_info", r113.f96640c);
        r101.put("interact_timer_count", r113.f96642e);
        r101.put("interact_start_time", r113.f96641d);
        r101.put("clean_screen", r113.f96643f);
        r101.put("team_task", r113.f96648k.f96460g);
        MutableLiveData<Integer> r118 = r112.f96457d;
        Intrinsics.checkNotNullParameter(r118, "$this$packagePkRemainTime");
        Intrinsics.checkNotNullParameter(r112, "bridge");
        MediatorLiveData r119 = new MediatorLiveData();
        r119.addSource(r118, new l(r119, r112));
        r101.put("play_remain_time", r119);
        MutableLiveData<com.bytedance.android.live.revlink.impl.pk.feedview.machine.l> r120 = r112.f96458e;
        Intrinsics.checkNotNullParameter(r120, "$this$packagePlayStatus");
        Intrinsics.checkNotNullParameter(r112, "bridget");
        Intrinsics.checkNotNullParameter(r111, "viewState");
        MediatorLiveData r121 = new MediatorLiveData();
        r121.addSource(r120, new o(r121, r112, r111, r100));
        r101.put("play_status", r121);
        goto L6
    }
}
