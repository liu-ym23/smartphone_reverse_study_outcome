package com.bytedance.android.live.profit.redpacket;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.ShareViewCard;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.revenue.sti.IRevIconModel;
import com.bytedance.android.livesdk.revenue.sti.RevStiElementType;
import com.bytedance.android.livesdkapi.performance.ILiveReleasable;
import com.bytedance.android.livesdkapi.service.ILiveOptManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import zg1.q2;

/* JADX INFO: loaded from: classes47.dex */
public final class b1 extends com.bytedance.android.live.revenue.common.a<h1> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final boolean f88584m = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public zy0.b f88585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public zy0.b f88586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ShareViewCard f88587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f88588i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ny0.a f88589j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final yz0.k f88590k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LuckyBoxClientService f88591l;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b1 f88592a;

        public b(b1 r100) {
            this.f88592a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((q2) r100).f571919a != 0) goto L9;
            b1 r101 = this.f88592a;
            r101.getClass();
            l01.d r102 = (l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class);
            if (r102.isLogin() == true) goto L7;
            r102.z4(r101.getContext(), RedpacketClientIconModel$wannaSend$1.INSTANCE);
            return;
        L7:
            ((cv0.b) ny0.a.C6992a.a(r101.f88589j, Reflection.getOrCreateKotlinClass(cv0.b.class))).openSendLuckyBoxView();
            return;
        }
    }

    public static final class c implements ILiveReleasable {
        public c() {
        }

        @Override // com.bytedance.android.livesdkapi.performance.ILiveReleasable
        public final void releaseByFixer() {
        }
    }

    static {
        f88584m = ((Boolean) i1.f88635r.getValue(null, i1.f88618a[15])).booleanValue();
    }

    @Override // com.bytedance.android.live.revenue.common.a
    public final void g() {
        LuckyBoxClientService r100 = this.f88591l;
        r100.getClass();
        Intrinsics.checkNotNullParameter(this, "iconModel");
        r100.f88483b = this;
        Iterator r101 = ((ArrayList) r100.f88482a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((Function1) r101.next()).invoke(this);
        goto L4
    L6:
        ((ArrayList) r100.f88482a).clear();
        bindModel(xs2.b.a().b(q2.class).subscribe(new b(this)));
        ILiveOptManager r102 = (ILiveOptManager) jc1.k.f(ILiveOptManager.class);
        if (r102 == null) goto L11;
        r102.bindReleasable(null, this.f88588i);
        return;
    }

    @Override // com.bytedance.android.livesdk.revenue.sti.IRevIconModel
    public final void onClick() {
        int r100 = h.f88608a;
        bindModel(RxUtilKt.r(h.a(this.f88590k.getRoom()), "RedpacketClientIconModel"));
        if (((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).isLogin() == true) goto L5;
        ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).z4(getContext(), RedpacketClientIconModel$login$1.INSTANCE);
        return;
    L5:
        ((cv0.b) ny0.a.C6992a.a(this.f88589j, Reflection.getOrCreateKotlinClass(cv0.b.class))).openGrabLuckyBoxView();
    }

    @Override // com.bytedance.android.live.revenue.common.a, com.bytedance.android.livesdk.revenue.sti.IRevIconModel
    public final void onDestroy() {
        ALogger.i("RedpacketClientIconModel", "RedpacketClientIconModel.onDestroy");
        zy0.b r100 = this.f88585f;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        zy0.b r101 = this.f88586g;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        ShareViewCard r102 = this.f88587h;
        if (r102 == null) goto L11;
        r102.c();
    L11:
        StringBuilder r103 = new StringBuilder("shortTouchCard ");
        zy0.b r104 = this.f88585f;
        if (r104 == null) goto L16;
        View r105 = r104.c();
        if (r105 == null) goto L16;
        String r106 = r105.getClass().getSimpleName();
    L17:
        r103.append(r106);
        ALogger.i("RedpacketClientIconModel", r103.toString());
        return;
    L16:
        r106 = null;
        goto L17
    }

    @Override // com.bytedance.android.livesdk.revenue.sti.IRevIconModel
    public final xr2.h getViewForState(Object r210) {
        h1 r100 = (h1) r210;
        Intrinsics.checkNotNullParameter(r100, "state");
        View r101 = null;
        if ((r100 instanceof h1.b) == false) goto L23;
        xr2.h r102 = createIconTemplate(xr2.g.class);
        xr2.g r110 = (xr2.g) r102;
        r110.setRotated(Boolean.FALSE);
        r110.setResizeContentView(Boolean.TRUE);
        long r111 = System.currentTimeMillis();
        RedpacketClientIconModel$getViewForState$$inlined$apply$lambda$1 r112 = new RedpacketClientIconModel$getViewForState$$inlined$apply$lambda$1(r110, r111, this, r100);
        ReadOnlyProperty r103 = i1.f88636s;
        KProperty<?>[] r104 = i1.f88618a;
        if (((Boolean) r103.getValue(null, r104[16])).booleanValue() == true) goto L8;
        r112.invoke2();
    L13:
        if (r110.getContentView() == null) goto L22;
        View r105 = r110.getView();
        if ((r105 instanceof ViewGroup) == false) goto L18;
        r101 = r105;
    L18:
        ViewGroup r106 = (ViewGroup) r101;
        if (r106 == null) goto L22;
        r3.h(r106);
    L22:
        return r102;
    L8:
        ShareViewCard r107 = new ShareViewCard(getContext());
        r110.setContentView(r107.f91380a);
        View r108 = r110.getContentView();
        if (r108 == null) goto L11;
        r108.setOnClickListener(new e1(r110, this));
    L11:
        r107.a(new com.bytedance.android.live.revenue.platform.hybrid.api.shareview.d(UriProtector.parse((String) i1.f88632o.getValue(null, r104[12])), MapsKt.mapOf(new Pair[]{TuplesKt.to("timestamp", String.valueOf(r111)), TuplesKt.to("data", ((h1.b) r100).f88615c)}), new f1(r110, r112), null, 56));
        Unit r109 = Unit.INSTANCE;
        this.f88587h = r107;
        goto L13
    L23:
        return null;
    }

    @Override // com.bytedance.android.live.revenue.common.a, com.bytedance.android.livesdk.revenue.sti.IRevIconModel
    public final void onShowTempState(int r100) {
        if (r100 != 1) goto L19;
        Class<?> r101 = ((JsonAdapter) com.bytedance.android.live.profit.redpacket.model.h.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r102 = vh7.b.f554981a;
        Constructor r103 = r102.get(r101);
        if (r103 != null) goto L14;
        r103 = r101.getConstructor(new Class[0]);
        if (r103 == null) goto L13;
        Constructor<? extends SerializableObjectJsonAdapterBase> r104 = r102.putIfAbsent(r101, (Constructor<? extends SerializableObjectJsonAdapterBase>) r103);
        if (r104 == null) goto L14;
        r103 = r104;
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L14:
        Object r105 = ((SerializableObjectJsonAdapterBase) r103.newInstance(new Object[0])).createInstance();
        if (r105 == null) goto L18;
        com.bytedance.android.live.profit.redpacket.model.h r106 = (com.bytedance.android.live.profit.redpacket.model.h) r105;
        r106.y1();
        this.f88591l.f88484c.onNext(r106);
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profit.redpacket.model.ObserveLuckyBoxShortTouchTempStateResponse");
    }

    @Override // com.bytedance.android.livesdk.revenue.sti.IRevIconModel
    public final IRevIconModel.a getEntryViewForState(Object r110, Object r111) {
        h1 r112 = (h1) r110;
        h1 r113 = (h1) r111;
        Intrinsics.checkNotNullParameter(r112, "state");
        StringBuilder r114 = new StringBuilder("RedpacketClientIconModel.getEntryViewForState: ");
        r114.append(r112.getClass().getSimpleName());
        r114.append("+ ");
        boolean r100 = r112 instanceof h1.b;
        if (r100 == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        r114.append(r101);
        ALogger.i("RedpacketClientIconModel", r114.toString());
        View r115 = null;
        Integer r116 = null;
        if (r100 == false) goto L81;
        h1.b r117 = (h1.b) r112;
        if (r117.f88613a == true) goto L13;
        return null;
    L13:
        if (f88584m == false) goto L63;
        IRevIconModel.a r102 = inflateEntryView(R.layout.ttlive_red_packet_new_sti_entry);
        View r103 = r102.f157513a;
        if (r103 == null) goto L62;
        ViewGroup r104 = (ViewGroup) r103;
        String r118 = r117.f88615c;
        Intrinsics.checkNotNullParameter(r104, "rootView");
        Intrinsics.checkNotNullParameter(r118, "luckyBoxInitData");
        d r119 = (d) GsonHelper.get().fromJson(r118, new a0().getType());     // Catch: Exception -> L82
        TextView r105 = (TextView) r104.findViewById(R.id.coin_count);     // Catch: Exception -> L82
        if (r119 == null) goto L20;
        String r106 = String.valueOf(r119.a());     // Catch: Exception -> L82
    L21:
        r105.setText(r106);     // Catch: Exception -> L82
        ViewGroup r107 = (ViewGroup) r104.findViewById(R.id.avatar_container);     // Catch: Exception -> L82
        HSImageView r108 = (HSImageView) r104.findViewById(R.id.coin_mark);     // Catch: Exception -> L82
        if (r108 == null) goto L25;
        py.k r109 = com.bytedance.android.livesdk.utils.r3.a();     // Catch: Exception -> L82
        Intrinsics.checkNotNullParameter(r108, "$this$bindImage");     // Catch: Exception -> L82
        ImageLoader.bindImage(r108, r109);     // Catch: Exception -> L82
    L25:
        LayoutInflater r120 = LayoutInflater.from(r104.getContext());     // Catch: Exception -> L82
        if (r119 == null) goto L28;
        List<String> r121 = r119.b();     // Catch: Exception -> L82
    L29:
        if (r121 == null) goto L34;
        List<String> r122 = r121;     // Catch: Exception -> L82
        ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r122, 10));     // Catch: Exception -> L82
        Iterator<T> r124 = r122.iterator();     // Catch: Exception -> L82
    L32:
        if (r124.hasNext() == false) goto L35;
        String r125 = (String) r124.next();     // Catch: Exception -> L82
        py.k r126 = (py.k) vh7.f.c(py.k.class);     // Catch: Exception -> L82
        r126.setUrls(CollectionsKt.listOf(r125));     // Catch: Exception -> L82
        r123.add(r126);     // Catch: Exception -> L82
    L35:
        if (r123 == null) goto L38;
        r116 = Integer.valueOf(r123.size());     // Catch: Exception -> L82
    L38:
        if (r116 != null) goto L41;
    L43:
        if (r116 != null) goto L46;
    L48:
        r120.inflate(R.layout.ttlive_red_packet_new_sti_entry_avatar_3, r107);     // Catch: Exception -> L82
    L49:
        Integer[] r127 = {Integer.valueOf(R.id.avatar1), Integer.valueOf(R.id.avatar2), Integer.valueOf(R.id.avatar3)};     // Catch: Exception -> L82
        if (r123 == null) goto L60;
        List r128 = CollectionsKt.zip(r123, r127);     // Catch: Exception -> L82
        if (r128 == null) goto L60;
        Iterator r129 = r128.iterator();     // Catch: Exception -> L82
    L54:
        if (r129.hasNext() == false) goto L60;
        Pair r130 = (Pair) r129.next();     // Catch: Exception -> L82
        py.k r131 = (py.k) r130.component1();     // Catch: Exception -> L82
        HSImageView r132 = (HSImageView) r107.findViewById(((Number) r130.component2()).intValue());     // Catch: Exception -> L82
        if (r132 == null) goto L54;
        Intrinsics.checkNotNullParameter(r132, "$this$bindImage");     // Catch: Exception -> L82
        ImageLoader.bindImage(r132, r131);     // Catch: Exception -> L82
        goto L54
    L46:
        if (r116.intValue() != 2) goto L48;
        r120.inflate(R.layout.ttlive_red_packet_new_sti_entry_avatar_2, r107);     // Catch: Exception -> L82
        goto L49
    L41:
        if (r116.intValue() != 1) goto L43;
        r120.inflate(R.layout.ttlive_red_packet_new_sti_entry_avatar_1, r107);     // Catch: Exception -> L82
        goto L49
    L34:
        r123 = null;
        goto L35
    L28:
        r121 = null;
        goto L29
    L20:
        r106 = null;
    L60:
        r104.setOnClickListener(new d1(this));
        return r102;
    L62:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L63:
        com.bytedance.android.live.revenue.common.x0 r133 = new com.bytedance.android.live.revenue.common.x0((String) i1.f88633p.getValue(null, i1.f88618a[13]));
        r133.d("url").b("timestamp", String.valueOf(System.currentTimeMillis()));
        ALogger.i("RedpacketClientIconModel", "RedpacketClientIconModel.getEntryViewForState: " + r133.c());
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r134 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).q8(getContext(), r133.c(), RedpacketClientIconModel$getEntryViewForState$2.INSTANCE);
        if (r134 == null) goto L72;
        String r135 = r117.f88615c;
        xy0.a<?> r136 = r134.g();
        if (r136 == null) goto L68;
        r136.updateGlobalProps(MapsKt.mapOf(TuplesKt.to("data_from_native", r135)));
    L68:
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a.b r137 = r134.f91467d;
        if (r137 == null) goto L71;
        r137.load(null, null);
    L71:
        r134.f91466c.setOnClickListener(new c1(this));
        Unit r138 = Unit.INSTANCE;
    L73:
        this.f88586g = r134;
        IRevIconModel.a r139 = inflateEntryView(R.layout.ttlive_red_packet_new_sti_entry_empty);
        View r140 = r139.f157513a;
        if (r140 == null) goto L80;
        ViewGroup r141 = (ViewGroup) r140;
        zy0.b r142 = this.f88586g;
        if (r142 == null) goto L78;
        r115 = r142.c();
    L78:
        r141.addView(r115);
        ALogger.i("RedpacketClientIconModel", "RedpacketClientIconModel.getEntryViewForState: ".concat(r139.f157513a.getClass().getSimpleName()));
        return r139;
    L80:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L72:
        r134 = null;
        goto L73
    L81:
        return null;
    L5:
        if (((h1.b) r112).f88613a == false) goto L7;
        r101 = true;
        goto L8
    }

    public b1(ny0.a r100, yz0.k r101, LuckyBoxClientService r102) {
        Intrinsics.checkNotNullParameter(r100, "rpcService");
        Intrinsics.checkNotNullParameter(r101, "roomDataService");
        Intrinsics.checkNotNullParameter(r102, "clientService");
        super(h1.a.f88612a, RevStiElementType.RegularLuckyBox.getTypeId());
        this.f88589j = r100;
        this.f88590k = r101;
        this.f88591l = r102;
        new PropertyOwner(Unit.INSTANCE);
        this.f88588i = new c();
    }

    @Override // com.bytedance.android.livesdk.revenue.sti.IRevIconModel
    public final void c(Object r100, Object r101, xr2.h r102) {
        h1 r103 = (h1) r100;
        Intrinsics.checkNotNullParameter((h1) r101, "curState");
    }
}
