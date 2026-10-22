package com.bytedance.android.livesdk.gift.platform.business.effect.service.feed;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.feed.IRevenueFeedGameEffectServiceContainer;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import yz0.j;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements IRevenueFeedGameEffectServiceContainer, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zy0.b f129532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Pair<String, com.bytedance.ies.web.jsbridge2.f.b>> f129533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f129534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.a> f129535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f129536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f129537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final rh6.a f129538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final vh6.b f129539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.b f129540i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f129541a;

        public b(e r100) {
            this.f129541a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            this.f129541a.attach();
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdkapi.feed.IRevenueFeedGameEffectServiceContainer
    public final void attach() {
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r100 = null;
        jy0.b.c("RevenueFeedGameEffectService", "effectService attach isLiveTypeAudio: " + this.f129537f.getRoom().isLiveTypeAudio(), null, 4);
        if (this.f129537f.getRoom().isLiveTypeAudio() == true) goto L5;
        return;
    L5:
        if (this.f129532a == null) goto L7;
        jy0.b.c("RevenueFeedGameEffectService", "effectService has loaded", null, 4);
        return;
    L7:
        Context r101 = (Context) this.f129539h.a(com.bytedance.android.live.revenue.core.d.f91024a);
        if (r101 == null) goto L45;
        cy0.e.f465759a.getClass();
        cy0.j r102 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r103 = m.b(r102).a(Reflection.getOrCreateKotlinClass(vy0.c.class));
        Intrinsics.checkNotNull(r103);
        vy0.c r104 = (vy0.c) ((f80.a) r103);
        boolean r105 = false;
        String r106 = (String) g.f129544b.getValue(null, g.f129543a[0]);
        LinkedHashMap r107 = new LinkedHashMap();
        IRoomBase r108 = this.f129537f.getRoom();
        if (r108 == null) goto L13;
        String r109 = r108.getIdStr();
        if (r109 == null) goto L13;
    L14:
        r107.put("room_id", r109);
        if (this.f129540i.f129525a == false) goto L17;
        String r110 = "0";
    L18:
        r107.put("first_feed", r110);
        Intrinsics.checkNotNullParameter(r106, "url");
        Intrinsics.checkNotNullParameter(r107, "params");
        if (r106.length() <= 0) goto L21;
        r105 = true;
    L21:
        if (r105 == false) goto L27;
        Uri.Builder r111 = UriProtector.parse(r106).buildUpon();
        Iterator r112 = r107.entrySet().iterator();
    L24:
        if (r112.hasNext() == false) goto L26;
        Map.Entry r113 = (Map.Entry) r112.next();
        r111.appendQueryParameter((String) r113.getKey(), (String) r113.getValue());
        goto L24
    L26:
        Uri r114 = r111.build();
    L28:
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r115 = r104.q8(r101, r114, RevenueFeedGameEffectServiceContainer$createService$1$1.INSTANCE);
        if (r115 == null) goto L45;
        Intrinsics.checkNotNullParameter(r115, "hybridCard");
        jy0.b.c("RevenueFeedGameEffectService", "register aio link", null, 4);
        cy0.e.f465759a.getClass();
        cy0.j r116 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r117 = m.b(r116).a(Reflection.getOrCreateKotlinClass(uh6.b.class));
        Intrinsics.checkNotNull(r117);
        com.bytedance.revenue.platform.api.core.rx.f.a(((uh6.b) ((f80.a) r117)).h(r115, this.f129538g), this.f129536e);
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a.b r118 = r115.f91467d;
        if (r118 == null) goto L33;
        r118.registerMethod("live.requireGiftEffectLynxView", new f(this));
    L33:
        Iterator r119 = ((ArrayList) this.f129533b).iterator();
    L35:
        if (r119.hasNext() == false) goto L41;
        Pair r120 = (Pair) r119.next();
        zy0.b r121 = this.f129532a;
        if (r121 == null) goto L35;
        xy0.a<?> r122 = r121.g();
        if (r122 == null) goto L35;
        r122.registerMethod((String) r120.getFirst(), (com.bytedance.ies.web.jsbridge2.f.b) r120.getSecond());
        goto L35
    L41:
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a.b r123 = r115.f91467d;
        if (r123 == null) goto L44;
        r123.load(null, null);
    L44:
        ((ArrayList) this.f129533b).clear();
        r100 = r115;
        goto L45
    L27:
        r114 = Uri.EMPTY;
        goto L28
    L17:
        r110 = "1";
    L13:
        r109 = "";
    L45:
        this.f129532a = r100;
        this.f129540i.f129525a = true;
    }

    @Override // com.bytedance.android.livesdkapi.feed.IRevenueFeedGameEffectServiceContainer
    public final void deattach() {
        jy0.b.c("RevenueFeedGameEffectService", "effectService deattach", null, 4);
        zy0.b r100 = this.f129532a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f129532a = null;
        this.f129536e.clear();
        ((ArrayList) this.f129533b).clear();
        ((ArrayList) this.f129535d).clear();
        this.f129534c = false;
    }

    @Override // com.bytedance.android.livesdkapi.feed.IRevenueFeedGameEffectServiceContainer
    public final void onMultiLinkFeedViewCreate() {
        jy0.b.c("RevenueFeedGameEffectService", "onMultiLinkFeedViewCreate", null, 4);
        this.f129534c = true;
        com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.a r100 = (com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.a) CollectionsKt.getOrNull(this.f129535d, 0);
        if (r100 == null) goto L7;
        rh6.a r101 = this.f129538g;
        d r102 = (d) m.f163449e.d(r101, d.class);
        if (r102 == null) goto L7;
        r102.a(r100.f129518a, r100.getType(), r100.f129520c, r100.f129521d, r100.f129522e, r100.f129523f, r100.f129524g);
    L7:
        ((ArrayList) this.f129535d).clear();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        ReadOnlyProperty r100 = g.f129546d;
        KProperty<?>[] r101 = g.f129543a;
        if (((Boolean) r100.getValue(null, r101[2])).booleanValue() == true) goto L6;
        return;
    L6:
        if (((Boolean) g.f129547e.getValue(null, r101[3])).booleanValue() == false) goto L8;
        return;
    L8:
        com.bytedance.revenue.platform.api.core.rx.f.a(Observable.timer(((Number) g.f129545c.getValue(null, r101[1])).longValue(), TimeUnit.MILLISECONDS).subscribe(new b(this)), this.f129536e);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        deattach();
    }

    @Override // com.bytedance.android.livesdkapi.feed.IRevenueFeedGameEffectServiceContainer
    public final void onMultiLinkFeedTypeChanged(int r100) {
        jy0.b.c("RevenueFeedGameEffectService", "onMultiLinkFeedTypeChanged, uiLayout: " + r100, null, 4);
        if (r100 != 66) goto L8;
        if (((Boolean) g.f129547e.getValue(null, g.f129543a[3])).booleanValue() == false) goto L8;
        attach();
    L8:
        if (((Boolean) g.f129548f.getValue(null, g.f129543a[4])).booleanValue() == false) goto L18;
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L13
        r101.put("ui_layout", r100);     // Catch: Exception -> L13
        zy0.b r102 = this.f129532a;     // Catch: Exception -> L13
        if (r102 == null) goto L19;
        r102.sendJsEvent("live_revenue_game_effect_multilink_feed_type_changed", r101);     // Catch: Exception -> L13
        return;
    L19:
        return;
    L13:
        e = move-exception;
        jy0.b.c("RevenueFeedGameEffectService", "json parse error, detail: " + e.getMessage(), null, 4);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.feed.IRevenueFeedGameEffectServiceContainer
    public final void registerFeedJsbMethod(String r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "jsbName");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        com.bytedance.ies.web.jsbridge2.f.b r102 = ((com.bytedance.android.livesdk.revenue.service.interact.d) vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class)).getFeedMultiLinkDynamicJsbMethodProvider(r100, r101);
        xy0.a<?> r103 = null;
        jy0.b.c("RevenueFeedGameEffectService", "registerFeedJsbMethod, " + r100 + ", " + r102, null, 4);
        zy0.b r104 = this.f129532a;
        if (r104 == null) goto L5;
        r103 = r104.g();
    L5:
        if (r103 != null) goto L7;
        ((ArrayList) this.f129533b).add(new Pair(r100, r102));
        return;
    L7:
        zy0.b r105 = this.f129532a;
        if (r105 == null) goto L14;
        xy0.a<?> r106 = r105.g();
        if (r106 == null) goto L15;
        r106.registerMethod(r100, r102);
        return;
    L15:
        return;
    }

    public e(j r100, rh6.a r101, vh6.b r102, com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.b r103) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "dependencyResolver");
        Intrinsics.checkNotNullParameter(r103, "gameEffectGlobalService");
        this.f129537f = r100;
        this.f129538g = r101;
        this.f129539h = r102;
        this.f129540i = r103;
        this.f129533b = new ArrayList();
        this.f129535d = new ArrayList();
        this.f129536e = new CompositeDisposable();
    }
}
