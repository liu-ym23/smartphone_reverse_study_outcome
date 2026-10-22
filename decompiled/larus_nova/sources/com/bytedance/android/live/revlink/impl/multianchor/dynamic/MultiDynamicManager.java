package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.settings.dynamic.LinkMultiDynamicSettingsKt;
import com.bytedance.android.live.revlink.scopeui.LynxBizType;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.revenue.platform.api.core.rx.p;
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
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import w20.ae;

/* JADX INFO: loaded from: classes47.dex */
public final class MultiDynamicManager implements com.bytedance.android.live.revlink.impl.lynxcontainer.a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f93859x = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f93860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, zy0.b> f93861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, com.bytedance.android.live.revlink.impl.lynxcontainer.b> f93862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, ArrayList<JSONObject>> f93863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<String> f93864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<JSONObject> f93865f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<JSONObject> f93866g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MultiDynamicLayoutManager f93867h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public zy0.b f93868i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f93869j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IRoom f93870k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.android.live.revlink.impl.multianchor.service.h f93871l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MultiDynamicManager$screenChangeObserver$1 f93872m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f93873n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HashMap<String, LiveData<?>> f93874o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final MultiRegisterViewListenContext f93875p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<String, LiveData<Pair<String, JSONObject>>> f93876q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final MultiDynamicManager$sendDataToLynxObserver$1 f93877r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Function0<Integer> f93878s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final x51.a f93879t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.room.c f93880u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d f93881v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final h f93882w;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public zy0.b f93883a;

        public a() {
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zy0.b f93884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f93885b;

        public c(zy0.b r100, String r101) {
            this.f93884a = r100;
            this.f93885b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = (String) r100;
            xy0.a<?> r102 = this.f93884a.g();
            if (r102 != null) goto L5;
            return;
        L5:
            if (r102.isDisposed() == true) goto L9;
            r102.sendJsEvent(this.f93885b, r101);
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f93886a = null;

        static {
            f93886a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            jy0.b.b("MultiDynamicManager", "sendJsEvent error", (Throwable) r100);
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

    public final void o() {
        this.f93869j = true;
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r100 = this.f93881v;
        if (r100 == null) goto L7;
        LiveData<Boolean> r101 = r100.getChangeScreenEvent();
        if (r101 == null) goto L7;
        r101.observeForever(this.f93872m);
    L7:
        f31.i r102 = null;
        if (Intrinsics.areEqual(this.f93882w, h.b.f94081b) == false) goto L16;
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r103 = this.f93881v;
        if (r103 == null) goto L12;
        MultiEnterRoomTracer r104 = r103.e();
    L13:
        if (r104 == null) goto L16;
        i97.a r105 = i97.a.f488802a;
        r104.f94852p = System.currentTimeMillis();
        goto L16
    L12:
        r104 = null;
    L16:
        if ((true ^ Intrinsics.areEqual(this.f93882w, h.a.f94080b)) == true) goto L19;
        y41.f r106 = y41.f.N;
        r106.getClass();
        if (((Boolean) y41.f.D.getValue(r106, y41.f.f565960a[28])).booleanValue() == false) goto L19;
    L20:
        MultiDynamicLayoutManager r107 = this.f93867h;
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r108 = r107.f93856e;
        if (r108 == null) goto L25;
        LiveData<f31.i> r109 = r108.getWindowStatus();
        if (r109 == null) goto L25;
        r109.observeForever(r107.f93854c);
    L25:
        MultiDynamicLayoutManager$windowStatusObserver$1 r110 = r107.f93854c;
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r111 = r107.f93856e;
        if (r111 == null) goto L30;
        LiveData<f31.i> r112 = r111.getWindowStatus();
        if (r112 == null) goto L30;
        r102 = r112.getValue();
    L30:
        r110.a(r102);
        this.f93875p.a();
        Iterator<String> r113 = this.f93874o.keySet().iterator();
    L32:
        if (r113.hasNext() == false) goto L36;
        LiveData<Pair<String, JSONObject>> r114 = this.f93876q.get(r113.next());
        if (r114 == null) goto L32;
        x.e(r114, this.f93877r);
        goto L32
    L36:
        return;
    L19:
        this.f93878s.invoke().intValue();
        p();
        goto L20
    }

    public final void q() {
        this.f93869j = false;
        Iterator<String> r100 = this.f93874o.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        String r101 = r100.next();
        LiveData<Pair<String, JSONObject>> r102 = this.f93876q.get(r101);
        if (r102 == null) goto L4;
        r102.removeObserver(this.f93877r);
        goto L4
    L8:
        this.f93860a.clear();
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r103 = this.f93881v;
        if (r103 == null) goto L13;
        LiveData<Boolean> r104 = r103.getChangeScreenEvent();
        if (r104 == null) goto L13;
        r104.removeObserver(this.f93872m);
    L13:
        Iterator<T> r105 = this.f93861b.values().iterator();
    L15:
        if (r105.hasNext() == false) goto L19;
        zy0.b r106 = (zy0.b) r105.next();
        if (r106 == null) goto L15;
        r106.dispose();
        goto L15
    L19:
        this.f93861b.clear();
        this.f93862c.clear();
        this.f93863d.clear();
        MultiDynamicLayoutManager r107 = this.f93867h;
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r108 = r107.f93856e;
        if (r108 == null) goto L24;
        LiveData<f31.i> r109 = r108.getWindowStatus();
        if (r109 == null) goto L24;
        r109.removeObserver(r107.f93854c);
    L24:
        r107.f93852a.clear();
        r107.f93855d.removeAll();
        this.f93875p.b();
        this.f93868i = null;
        this.f93870k = null;
    }

    public static String r() {
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.g() == false) goto L6;
        return "H5_revenueInteractData";
    L6:
        return "H5_webcastNotification";
    }

    public final void p() {
        if ((!Intrinsics.areEqual(this.f93882w, h.b.f94081b)) == false) goto L7;
        if (this.f93870k != null) goto L7;
        return;
    L7:
        if (this.f93869j == true) goto L10;
        return;
    L10:
        if (this.f93868i == null) goto L13;
        return;
    L13:
        if (this.f93878s.invoke().intValue() != 7) goto L15;
        final boolean r100 = true;
    L16:
        com.bytedance.android.live.revlink.impl.settings.dynamic.b r101 = com.bytedance.android.live.revlink.impl.settings.dynamic.b.f97568m;
        r101.getClass();
        if (r100 == false) goto L22;
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r102 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        r102.getClass();
        ReadOnlyProperty r103 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.D;
        KProperty<?>[] r104 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.f97530a;
        if (((Boolean) r103.getValue(r102, r104[28])).booleanValue() == false) goto L21;
        String r105 = (String) com.bytedance.android.live.revlink.impl.settings.dynamic.a.E.getValue(r102, r104[29]);
    L23:
        this.f93868i = n((com.bytedance.android.live.revlink.impl.lynxcontainer.b) GsonProtectorUtils.fromJson(l97.a.f508113a, r105, TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.revlink.impl.lynxcontainer.b.class))), true, new MultiDynamicManager$checkAndLoadCentral$1(this, r100));
        return;
    L21:
        r105 = r101.a().m8();
        goto L23
    L22:
        r105 = com.bytedance.android.live.revlink.impl.settings.dynamic.b.e(false);
        goto L23
    L15:
        r100 = false;
        goto L16
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
        if (r103.hasNext() == false) goto L15;
        v(com.bytedance.android.live.revlink.impl.lynxcontainer.d.a(r103.next()));
        goto L13
    L15:
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final String c(List<String> r100) {
        JSONObject r101 = new JSONObject();
        List<String> r102 = r100;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        Iterator<String> r104 = r100.iterator();
    L14:
        if (r104.hasNext() == false) goto L22;
        String r105 = r104.next();
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r106 = this.f93881v;
        if (r106 == null) goto L19;
        String r107 = r106.f(r105);
        if (r107 == null) goto L19;
    L20:
        r101.put(r105, r107);
    L19:
        r107 = "";
        goto L20
    L22:
        return r101.toString();
    L11:
        return r101.toString();
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
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
        if (r104.hasNext() == false) goto L20;
        String r105 = r104.next();
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r106 = this.f93881v;
        if (r106 == null) goto L18;
        String r107 = r106.f(r105);
        if (r107 == null) goto L18;
    L19:
        r101.put(r105, r107);
    L18:
        r107 = "";
        goto L19
    L20:
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
        this.f93862c.put(r104.o(), r104);
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
        this.f93862c.remove(r104.o());
        zy0.b r105 = this.f93861b.remove(r104.o());
        if (r105 == null) goto L13;
        MultiDynamicLayoutManager r106 = this.f93867h;
        String r107 = r104.o();
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "tag");
        r106.f93855d.d(r107, r105);
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
        Iterator<T> r103 = r100.iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        String r104 = (String) r103.next();
        Intrinsics.checkNotNullParameter(r104, "$this$toLynxViewParams");
        n(com.bytedance.android.live.revlink.impl.lynxcontainer.d.a(r104), false, null);
        goto L13
    L15:
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void l(CallContext r100) {
        Intrinsics.checkNotNullParameter(r100, "callContext");
        this.f93875p.d(r100);
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
        if (this.f93861b.get(r104) == null) goto L9;
        u(this.f93861b.get(r104), r(), r105.toString());
        goto L6
    L9:
        r102 = 1;
    L11:
        return r102;
    }

    public final void v(com.bytedance.android.live.revlink.impl.lynxcontainer.b r100) {
        zy0.b r101 = this.f93861b.get(r100.o());
        if (r101 != null) goto L5;
        return;
    L5:
        this.f93867h.a(r100, r101);
        this.f93862c.put(r100.o(), r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "action");
        JSONObject r102 = new JSONObject();
        r102.put("type", r100);
        r102.put("data", r101);
        Iterator<Map.Entry<String, com.bytedance.android.live.revlink.impl.lynxcontainer.b>> r103 = this.f93862c.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<String, com.bytedance.android.live.revlink.impl.lynxcontainer.b> r104 = r103.next();
        String r105 = r104.getKey();
        com.bytedance.android.live.revlink.impl.lynxcontainer.b r106 = r104.getValue();
        u(this.f93861b.get(r105), r(), r102.toString());
        goto L4
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void d(CallContext r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, PromotionProductPrivilegesStruct.TAGS);
        this.f93875p.c(r100, r101);
    }

    public final boolean s(com.bytedance.android.live.revlink.impl.lynxcontainer.b r100, String r101) {
        if (Intrinsics.areEqual(this.f93882w, h.a.f94080b) == false) goto L13;
        if (r100 == null) goto L20;
        List<String> r102 = r100.n();
        if (r102 != null) goto L8;
        return false;
    L8:
        if (r102.contains(r101) == true) goto L10;
        return false;
    L10:
        if (ArraysKt.contains(com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.a(), r101) == true) goto L23;
        return true;
    L23:
        return false;
    L20:
        return false;
    L13:
        if (r100 == null) goto L24;
        List<String> r103 = r100.n();
        if (r103 != null) goto L17;
        return false;
    L17:
        if (r103.contains(r101) != true) goto L26;
        return true;
    L26:
        return false;
    L24:
        return false;
    }

    public final boolean t(com.bytedance.android.live.revlink.impl.lynxcontainer.b r100, Function1<? super Boolean, Unit> r110) {
        if (this.f93869j == true) goto L6;
        jy0.b.c("MultiDynamicManager", "block card load success for not in lifecycle for " + r100.o(), null, 4);
        return true;
    L6:
        this.f93864e.remove(r100.o());
        this.f93862c.put(r100.o(), r100);
        zy0.b r101 = this.f93861b.get(r100.o());
        if (r101 == null) goto L9;
        e.getType(r101);
    L9:
        zy0.b r102 = this.f93861b.get(r100.o());
        jy0.b.c("MultiDynamicManager", r100.o() + " lynx load success ", null, 4);
        this.f93867h.a(r100, r102);
        zy0.b r103 = this.f93861b.get(r100.o());
        if (r103 == null) goto L27;
        Map<String, LiveData<Pair<String, JSONObject>>> r104 = this.f93876q;
        if (r104 == null) goto L27;
        LinkedHashMap r105 = new LinkedHashMap();
        Iterator<Map.Entry<String, LiveData<Pair<String, JSONObject>>>> r106 = r104.entrySet().iterator();
    L16:
        if (r106.hasNext() == false) goto L20;
        Map.Entry<String, LiveData<Pair<String, JSONObject>>> r107 = r106.next();
        if (s(r100, r107.getKey()) == false) goto L16;
        r105.put(r107.getKey(), r107.getValue());
        goto L16
    L20:
        Iterator r108 = r105.entrySet().iterator();
    L22:
        if (r108.hasNext() == false) goto L27;
        Map.Entry r109 = (Map.Entry) r108.next();
        String r111 = (String) r109.getKey();
        Pair r112 = (Pair) ((LiveData) r109.getValue()).getValue();
        if (r112 == null) goto L22;
        String r113 = (String) r112.component1();
        u(r103, r(), ((JSONObject) r112.component2()).toString());
        jy0.b.c("MultiDynamicManager", "send data " + r113 + " to view " + r100.o(), null, 4);
    L27:
        HybridType r114 = HybridType.H5;
        String r115 = r100.e();
        String r116 = r100.o();
        Intrinsics.checkNotNullParameter(r115, "lynxUrl");
        Intrinsics.checkNotNullParameter(r116, "tag");
        ArrayList<JSONObject> r117 = this.f93863d.get(r116);
        if (r117 == null) goto L33;
        Iterator<T> r118 = r117.iterator();
    L31:
        if (r118.hasNext() == false) goto L33;
        u(this.f93861b.get(r116), r(), ((JSONObject) r118.next()).toString());
    L33:
        this.f93863d.remove(r116);
        this.f93867h.getClass();
        Intrinsics.checkNotNullParameter(r115, "lynxUrl");
        if (r110 == null) goto L49;
        Unit r119 = r110.invoke(Boolean.TRUE);
        return false;
    L49:
        return false;
    }

    public static final void j(MultiDynamicManager r100, boolean r101, boolean r102) {
        if (Intrinsics.areEqual(r100.f93882w, h.b.f94081b) == false) goto L27;
        com.bytedance.android.live.revlink.impl.monitor.b r103 = null;
        MultiEnterRoomTracer r104 = null;
        if (r102 == false) goto L16;
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r105 = r100.f93881v;
        if (r105 == null) goto L9;
        r104 = r105.e();
    L9:
        if (r104 != null) goto L11;
        return;
    L11:
        if (r104.f94853q != 0) goto L31;
        if (r101 == false) goto L32;
        i97.a r106 = i97.a.f488802a;
        r104.f94853q = System.currentTimeMillis();
        return;
    L32:
        return;
    L31:
        return;
    L16:
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r107 = r100.f93881v;
        if (r107 == null) goto L19;
        r103 = r107.a();
    L19:
        if (r103 != null) goto L21;
        return;
    L21:
        if (r103.f93059a != 0) goto L33;
        if (r101 == false) goto L34;
        i97.a r108 = i97.a.f488802a;
        r103.f93059a = System.currentTimeMillis();
        return;
    L34:
        return;
    L33:
        return;
    }

    public final zy0.b n(com.bytedance.android.live.revlink.impl.lynxcontainer.b r110, boolean r111, Function2<? super zy0.b, ? super Boolean, Unit> r112) {
        x0 r100 = new x0(r110.e());
        x0 r101 = r100.d("url");
        Iterator r102 = CollectionsKt.toList(r110.d()).iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        String r103 = (String) r102.next();
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r104 = this.f93881v;
        if (r104 == null) goto L9;
        String r105 = r104.f(r103);
        if (r105 == null) goto L9;
    L10:
        r101.b(r103, r105);
    L9:
        r105 = "";
        goto L10
    L11:
        com.bytedance.android.live.revlink.impl.settings.dynamic.b r106 = com.bytedance.android.live.revlink.impl.settings.dynamic.b.f97568m;
        String r107 = "1";
        if (r106.a().getDebugMode() == false) goto L14;
        r101.b("debug_mode", "1");
    L14:
        r101.b("load_source", String.valueOf(this.f93882w.f94079a));
        h r108 = this.f93882w;
        if (Intrinsics.areEqual(r108, h.b.f94081b) == false) goto L18;
        boolean r109 = r106.a().N1();
    L21:
        if (d51.c.A0.o().G1() == false) goto L24;
        r101.b("pk_prop_card_enable", "1");
    L24:
        if (r109 == false) goto L26;
        r101.b("control_native_enable", "1");
    L26:
        r101.b("live_pk_enable_double_lynx_mic", "1");
        r101.b("live_pk_enable_lynx_double_link_score", "1");
        r101.b("live_pk_enable_lynx_interact_comment", "1");
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r113 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        String r114 = "0";
        if (r113.g() == false) goto L29;
        String r115 = "1";
    L30:
        r101.b("live_revenue_interact_dynamic_data_format", r115);
        if (r113.b() == false) goto L33;
        String r116 = "1";
    L34:
        r101.b("live_pk_enable_lynx_anchor_mic_panel", r116);
        if (r113.c() == false) goto L37;
        String r117 = "1";
    L38:
        r101.b("panel_list_opt", r117);
        if (r41.f.f536019a == false) goto L41;
        String r118 = "1";
    L42:
        r101.b("support_nine_linker", r118);
        if (y41.f.N.c() == false) goto L45;
        String r119 = "1";
    L46:
        r101.b("live_multi_pk_sofa_opt", r119);
        r101.b("android_use_scope", "1");
        r101.b("android_merge_data_source", "1");
        r101.b("android_kmp", "1");
        r101.b("interact_merge_scene", "1");
        b03.a r120 = b03.a.f16857a;
        if (PadConfigUtils.a() == false) goto L49;
        String r121 = "1";
    L50:
        r101.b("is_pad", r121);
        r101.b("interact_time_cnt", String.valueOf(LinkMultiDynamicSettingsKt.a()));
        com.bytedance.android.livesdk.revenue.service.room.c r122 = this.f93880u;
        boolean r123 = true;
        String r124 = null;
        if (r122 == null) goto L73;
        if (this.f93878s.invoke().intValue() != 1) goto L73;
        IBaseUser r125 = r122.getRoomContext().getCommonRoom().getOwnerKt();
        if (r125 == null) goto L58;
        String r126 = r125.getIdString();
    L59:
        r101.b("anchor_id", r126);
        IBaseUser r127 = r122.getRoomContext().getCommonRoom().getOwnerKt();
        if (r127 == null) goto L62;
        Intrinsics.checkNotNullParameter(r127, "$this$secUidExt");
        String r128 = r127.getCastSecUid();
    L63:
        r101.b("sec_anchor_id", r128);
        r101.b("user_id", r122.getRoomContext().getCommonUser().getIdString());
        r101.b("sec_user_id", o.a(r122.getRoomContext().getCommonUser()));
        r101.b("room_id", r122.getRoomContext().getCommonRoom().getIdStr());
        r101.b("load_source", "0");
        if (r113.e() == false) goto L66;
        String r129 = "1";
    L67:
        r101.b("control_native_enable", r129);
        if (r122.getRoomContext().getCommonIsAnchor() == true) goto L71;
        r107 = "0";
    L71:
        r101.b(IPerformanceManager.Params.is_anchor, r107);
        goto L73
    L66:
        r129 = "0";
        goto L67
    L62:
        r128 = null;
        goto L63
    L58:
        r126 = null;
    L73:
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.a.f97538i.getValue(r113, com.bytedance.android.live.revlink.impl.settings.dynamic.a.f97530a[7])).booleanValue() == false) goto L83;
        String r130 = r101.a("business_type");
        if (r130 != null) goto L77;
    L80:
        boolean r131 = true;
    L81:
        if (r131 == false) goto L83;
        r101.b("business_type", "rev_link");
        goto L83
    L77:
        if (StringsKt.isBlank(r130) == true) goto L80;
        r131 = false;
    L83:
        IRoom r132 = this.f93870k;
        if (r132 == null) goto L96;
        IBaseUser r133 = r132.getOwnerKt();
        if (r133 == null) goto L88;
        r124 = iz.a.a(r133);
    L88:
        r101.b("anchor_id", r124);
        String r134 = r132.getIdStr();
        if (r134.length() == 0) goto L92;
        r123 = false;
    L92:
        if (r123 == true) goto L95;
        r114 = r134;
    L95:
        r101.b("room_id", r114);
    L96:
        this.f93864e.add(r110.o());
        a r135 = new a();
        zy0.b r136 = this.f93879t.c(LynxBizType.DynamicCentral, this.f93882w, r100.c(), new MultiDynamicManager$addLynxView$hybridCard$1(this, r110, r112, r135, r111));
        r135.f93883a = r136;
        this.f93861b.put(r110.o(), r136);
        if (r136 == null) goto L101;
        xy0.a<?> r137 = r136.g();
        if (r137 == null) goto L101;
        r137.load();
    L101:
        return r136;
    L49:
        r121 = "0";
        goto L50
    L45:
        r119 = "0";
        goto L46
    L41:
        r118 = "0";
        goto L42
    L37:
        r117 = "0";
        goto L38
    L33:
        r116 = "0";
        goto L34
    L29:
        r115 = "0";
        goto L30
    L18:
        if (Intrinsics.areEqual(r108, h.a.f94080b) == false) goto L103;
        r109 = r106.a().h7();
        goto L21
    L103:
        throw new NoWhenBranchMatchedException();
    }

    public final void u(zy0.b r100, String r101, String r102) {
        if (this.f93869j == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L8;
        return;
    L8:
        if (((Boolean) this.f93873n.getValue()).booleanValue() == true) goto L13;
        xy0.a<?> r103 = r100.g();
        if (r103 == null) goto L20;
        r103.sendJsEvent(r101, r102);
        return;
    L20:
        return;
    L13:
        xy0.a<?> r104 = r100.g();
        if (r104 != null) goto L16;
        return;
    L16:
        if (r104.isDisposed() == true) goto L22;
        com.bytedance.revenue.platform.api.core.rx.l r105 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
        Observable r106 = Observable.just(r102);
        int r107 = p.f267522a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r106.observeOn(Schedulers.single()).subscribe(new c(r100, r101), d.f93886a), this.f93860a);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v16, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.MultiDynamicManager$sendDataToLynxObserver$1] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.MultiDynamicManager$screenChangeObserver$1] */
    public MultiDynamicManager(Function0<Integer> r100, x51.a r101, com.bytedance.android.livesdk.revenue.service.room.c r102, com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r103, h r104) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "linkLynxCentralService");
        Intrinsics.checkNotNullParameter(r104, "loadSource");
        this.f93878s = r100;
        this.f93879t = r101;
        this.f93880u = r102;
        this.f93881v = r103;
        this.f93882w = r104;
        this.f93860a = new CompositeDisposable();
        this.f93861b = new HashMap();
        this.f93862c = new HashMap();
        this.f93863d = new HashMap();
        this.f93864e = new ArrayList();
        this.f93865f = new MutableLiveData();
        this.f93866g = new ArrayList();
        this.f93867h = new MultiDynamicLayoutManager(r101, r103, new MultiDynamicManager$layoutManager$1(this));
        this.f93872m = new MultiDynamicManager$screenChangeObserver$1(this);
        this.f93873n = LazyKt.lazy(MultiDynamicManager$isMeasureOpt$2.INSTANCE);
        if (r103 == null) goto L6;
        HashMap<String, LiveData<?>> r105 = r103.b();
        if (r105 == null) goto L6;
    L7:
        this.f93874o = r105;
        this.f93875p = new MultiRegisterViewListenContext(r105);
        if (r103 == null) goto L11;
        Map<String, LiveData<Pair<String, JSONObject>>> r106 = r103.h();
        if (r106 == null) goto L11;
    L12:
        this.f93876q = r106;
        this.f93877r = new MultiDynamicManager$sendDataToLynxObserver$1(this);
        return;
    L11:
        r106 = new HashMap();
    L6:
        r105 = new HashMap();
        goto L7
    }
}
