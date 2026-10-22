package com.bytedance.android.live.profit.redpacket;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profit.redpacket.trace.RedPacketTraceMonitor;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.sti.IRevIconModel;
import com.bytedance.android.livesdk.revenue.sti.RevStiElementType;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import zg1.q2;

/* JADX INFO: loaded from: classes47.dex */
public final class RedPacketIconModel extends com.bytedance.android.live.revenue.common.a<y0.a> {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final com.bytedance.android.live.revenue.common.u0 f88528w = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f88529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f88530g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f88531h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f88532i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f88533j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PropertyOwner<Integer> f88534k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f88535l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f88536m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f88537n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f88538o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final w0 f88539p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final y0 f88540q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final bv0.b f88541r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c01.a f88542s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final yz0.k f88543t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RedPacketHybridService f88544u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final r0 f88545v;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RedPacketIconModel f88546a;

        public b(RedPacketIconModel r100) {
            this.f88546a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ALogger.i("RedPacketIconMode", "on red packet check event");
            if (((Boolean) r100).booleanValue() == false) goto L15;
            RedPacketIconModel r101 = this.f88546a;
            r101.getClass();
            if (((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).isLogin() == true) goto L8;
            ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).z4(r101.getContext(), RedPacketIconModel$login$1.INSTANCE);
        L11:
            Disposable r102 = this.f88546a.f88531h;
            if (r102 == null) goto L16;
            r102.dispose();
            return;
        L16:
            return;
        L8:
            if (((List) r101.f88540q.f88784k.f88708e.f267520d).isEmpty() == false) goto L10;
            ToastUtil.a(R.string.ttlive_red_packet_empty, 0);
            goto L11
        L10:
            r101.h(false);
            goto L11
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RedPacketIconModel f88547a;

        public c(RedPacketIconModel r100) {
            this.f88547a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            RedPacketIconModel r101 = this.f88547a;
            r101.moveToState((y0.a) r100);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RedPacketIconModel f88548a;

        public d(RedPacketIconModel r100) {
            this.f88548a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((q2) r100).f571919a != 0) goto L9;
            RedPacketIconModel r101 = this.f88548a;
            r101.getClass();
            l01.d r102 = (l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class);
            if (r102.isLogin() == true) goto L7;
            r102.z4(r101.getContext(), RedPacketIconModel$wannaSend$1.INSTANCE);
            return;
        L7:
            r101.j();
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RedPacketIconModel f88549a;

        public e(RedPacketIconModel r100) {
            this.f88549a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            PropertyOwner<Integer> r101 = this.f88549a.f88534k;
            r101.a((Integer) r100);
        }
    }

    @Override // com.bytedance.android.livesdk.revenue.sti.IRevIconModel
    public final void onClick() {
        h(false);
        com.bytedance.android.live.profit.util.e.a(this.f88539p, com.bytedance.android.live.profit.util.m.f89112b);
    }

    static {
        com.bytedance.android.live.revenue.common.u0 r100 = com.bytedance.android.live.revenue.common.u0.f90999f;
        f88528w = com.bytedance.android.live.revenue.common.u0.a.a(5);
    }

    @Override // com.bytedance.android.live.revenue.common.a
    public final void g() {
        bindModel(com.bytedance.android.live.core.arch.mvvm.f.b(this.f88540q.f88777d).subscribe(new c(this)));
        bindModel(xs2.b.a().b(q2.class).subscribe(new d(this)));
        bindModel(this.f88540q.f88781h.subscribe(new k0(this)));
        bindModel(com.bytedance.android.live.core.arch.mvvm.f.b(this.f88540q.f88783j).subscribe(new l0(this)));
        RxUtilKt.c(com.bytedance.android.live.core.arch.mvvm.f.b(this.f88545v.f88718o).subscribe(new f0(this)), this.f88529f);
        RxUtilKt.c(com.bytedance.android.live.core.arch.mvvm.f.b(this.f88545v.f88722s).subscribe(new h0(this)), this.f88529f);
        RxUtilKt.c(com.bytedance.android.live.core.arch.mvvm.f.b(this.f88545v.f88720q).subscribe(new i0(this)), this.f88529f);
        bindModel(com.bytedance.android.live.core.arch.mvvm.f.b(this.f88540q.f88784k.f88712i).subscribe(new e(this)));
    }

    public final void j() {
        Uri.Builder r100 = UriProtector.parse("sslocal://webcast_webview").buildUpon();
        ReadOnlyProperty r101 = i1.f88622e;
        KProperty<?>[] r102 = i1.f88618a;
        String r103 = (String) r101.getValue(null, r102[3]);
        Integer r104 = (Integer) ((wh6.a) vh6.c.b(wh6.a.class)).getClientABValue(i1.f88630m);
        boolean r105 = true;
        if (((Boolean) i1.f88628k.getValue(null, r102[9])).booleanValue() == true) goto L8;
        if (r104 != null) goto L7;
    L9:
        Uri.Builder r106 = UriProtector.parse(r103).buildUpon();
        IBaseUser r107 = this.f88543t.getRoom().getOwner();
        if (r107 == null) goto L12;
        r106.appendQueryParameter("anchor_id", r107.getIdString());
    L12:
        r106.appendQueryParameter("room_id", String.valueOf(this.f88543t.getRoom().getId()));
        IBaseUser r108 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).b();
        Intrinsics.checkNotNullParameter(r108, "$this$isFirstConsume");
        py.d r109 = r108.getUserHonor();
        if (r109 != null) goto L15;
    L17:
        r105 = false;
    L18:
        if (r105 == false) goto L20;
        String r110 = "1";
    L21:
        r106.appendQueryParameter("is_first_consume", r110);
        r106.appendQueryParameter(IPerformanceManager.Params.room_type, o.c());
        Uri r111 = r106.build();
        Set<String> r112 = UriProtector.getQueryParameterNames(r111);
        if (r112 == null) goto L27;
        Iterator<String> r113 = r112.iterator();
    L25:
        if (r113.hasNext() == false) goto L27;
        String r114 = r113.next();
        r100.appendQueryParameter(r114, UriProtector.getQueryParameter(r111, r114));
    L27:
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(getContext(), r100.build().toString());
        return;
    L20:
        r110 = "0";
        goto L21
    L15:
        if (r109.getLevel() != 0) goto L17;
    L7:
        if (r104.intValue() != 1) goto L9;
    L8:
        r100 = UriProtector.parse("sslocal://webcast_lynxview").buildUpon();
        r103 = (String) i1.f88629l.getValue(null, r102[10]);
        goto L9
    }

    @Override // com.bytedance.android.live.revenue.common.a, com.bytedance.android.livesdk.revenue.sti.IRevIconModel
    public final void onAppear() {
        ALogger.i("RedPacketIconMode", "on appear");
        if (this.f88531h != null) goto L6;
        this.f88531h = com.bytedance.android.live.core.arch.mvvm.f.b(this.f88540q.f88784k.f88714k).subscribe(new b(this));
        return;
    }

    @Override // com.bytedance.android.live.revenue.common.a, com.bytedance.android.livesdk.revenue.sti.IRevIconModel
    public final void onDestroy() {
        this.f88529f.dispose();
    }

    @Override // com.bytedance.android.live.revenue.common.a, com.bytedance.android.livesdk.revenue.sti.IRevIconModel
    public final void onHideTempState() {
        this.f88530g.clear();
    }

    @Override // com.bytedance.android.livesdk.revenue.sti.IRevIconModel
    public final xr2.h getViewForState(Object r110) {
        y0.a r111 = (y0.a) r110;
        Intrinsics.checkNotNullParameter(r111, "state");
        View r100 = null;
        if ((r111 instanceof y0.a.e) == false) goto L11;
        xr2.f r101 = (xr2.f) createIconTemplate(xr2.f.class);
        r101.setContentView(r101.inflateContentView(R.layout.ttlive_view_lucky_box_sti_wait));
        View r102 = r101.getContentView();
        if ((r102 instanceof ViewGroup) == false) goto L8;
        r100 = r102;
    L8:
        b0.c((ViewGroup) r100, r111, this.f88541r);
        r101.setContentRightMargin(com.bytedance.android.live.revenue.common.i.b(10));
        r101.setContentTopMargin(com.bytedance.android.live.revenue.common.i.b(6));
        xr2.h r103 = r101;
    L30:
        return r103;
    L11:
        if ((r111 instanceof y0.a.C1363a) == false) goto L18;
        xr2.h r104 = createIconTemplate(xr2.f.class);
        xr2.f r105 = (xr2.f) r104;
        r105.setContentView(r105.inflateContentView(R.layout.ttlive_view_lucky_box_sti_rush));
        View r106 = r105.getContentView();
        if ((r106 instanceof ViewGroup) == false) goto L16;
        r100 = r106;
    L16:
        b0.c((ViewGroup) r100, r111, this.f88541r);
        r105.setContentRightMargin(com.bytedance.android.live.revenue.common.i.b(10));
        r105.setContentTopMargin(com.bytedance.android.live.revenue.common.i.b(6));
        r103 = r104;
        goto L30
    L18:
        if ((r111 instanceof y0.a.b) == false) goto L29;
        xr2.h r112 = createIconTemplate(xr2.b.class);
        xr2.b r107 = (xr2.b) r112;
        HSImageView r108 = new HSImageView(getContext());
        GenericDraweeHierarchyBuilder r109 = GenericDraweeHierarchyBuilder.newInstance(getContext().getResources()).setFadeDuration(0);
        xr2.h r113 = getCurrentView();
        if (r113 == null) goto L22;
        r100 = r113.getView();
    L22:
        if (r100 == null) goto L27;
        int r114 = r100.getMeasuredWidth();
        int r115 = r100.getMeasuredHeight();
        if (r114 <= 0) goto L27;
        if (r115 <= 0) goto L27;
        Bitmap r116 = Bitmap.createBitmap(r114, r115, Bitmap.Config.ARGB_8888);
        Canvas r117 = new Canvas(r116);
        r100.layout(0, 0, r116.getWidth(), r116.getHeight());
        r100.draw(r117);
        r109.setPlaceholderImage(new BitmapDrawable(getContext().getResources(), r116));
    L27:
        r108.setHierarchy(r109.build());
        Unit r118 = Unit.INSTANCE;
        r107.setContentView(r108);
        return r112;
    L29:
        if ((r111 instanceof y0.a.c) == false) goto L32;
        return null;
    L32:
        throw new NoWhenBranchMatchedException();
    }

    public final void h(boolean r100) {
        Object r101 = getCurrentState();
        com.bytedance.android.live.profit.redpacket.e r102 = null;
        if ((r101 instanceof y0.a.d) == true) goto L5;
        r101 = null;
    L5:
        y0.a.d r103 = (y0.a.d) r101;
        if (r103 != null) goto L8;
        return;
    L8:
        com.bytedance.android.live.profit.redpacket.e r104 = r103.a();
        if ((r103 instanceof y0.a.b) == true) goto L11;
        r103 = null;
    L11:
        y0.a.b r105 = (y0.a.b) r103;
        if (r105 == null) goto L15;
        r102 = r105.f88786a;
    L15:
        if (((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).isLogin() == true) goto L17;
        ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).z4(getContext(), RedPacketIconModel$login$1.INSTANCE);
    L18:
        n0 r106 = r104.getState().getInfo();
        boolean r107 = this.f88543t.isAnchor();
        Intrinsics.checkNotNullParameter(r106, "currentPacket");
        long r108 = RangesKt.coerceAtLeast(r106.f88672h.b(x0.d()).f91006a / com.bytedance.android.live.revenue.common.u0.f90995b, 0);
        int r109 = r106.f88677m;
        Intrinsics.checkNotNullParameter(r106, "currentPacket");
        Pair[] r110 = new Pair[3];
        if (r100 == false) goto L21;
        String r111 = "all";
    L22:
        r110[0] = TuplesKt.to("click_from", r111);
        r110[1] = TuplesKt.to("money", String.valueOf(r109));
        r110[2] = TuplesKt.to("time", String.valueOf(r108));
        Map<? extends String, ? extends String> r112 = MapsKt.mutableMapOf(r110);
        o.a(r112, r106, r107);
        mz0.n r113 = new mz0.n();
        Map<String, String> r114 = r113.f516447a;
        Intrinsics.checkNotNullParameter(r114, "map");
        Intrinsics.checkNotNullParameter(r112, "map");
        r114.putAll(r112);
        mz0.m r115 = new mz0.m();
        r115.b(LogCommon.PAGE_SOURCE_LOG);
        r115.b(LogCommon.ROOM);
        ((ArrayList) r113.f516448b).addAll(r115.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r116 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r117 = com.bytedance.android.scope.m.b(r116).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r117);
        ((mz0.i) ((f80.a) r117)).w3("livesdk_redpackage_click", r113.f516447a, r113.f516448b);
        int r118 = RedPacketTraceMonitor.f88756a;
        RedPacketTraceMonitor.a(RedPacketTraceMonitor.EventName.TTLIVE_RED_PACKET_CLICK.getEventName(), "", MapsKt.emptyMap());
        int r119 = h.f88608a;
        bindModel(RxUtilKt.r(h.a(this.f88543t.getRoom()), "RedPacketIconModel"));
        return;
    L21:
        r111 = "normal";
        goto L22
    L17:
        i(r102, CollectionsKt.emptyList(), RedPacketDialogShowFrom.STI_CLICK);
        goto L18
    }

    @Override // com.bytedance.android.live.revenue.common.a, com.bytedance.android.livesdk.revenue.sti.IRevIconModel
    public final void onShowTempState(int r100) {
        Object r101 = getCurrentState();
        com.bytedance.android.live.revenue.common.u0 r102 = null;
        if ((r101 instanceof y0.a.d) == true) goto L5;
        r101 = null;
    L5:
        y0.a.d r103 = (y0.a.d) r101;
        if (r103 == null) goto L12;
        com.bytedance.android.live.profit.redpacket.e r104 = r103.a();
        if (r104 == null) goto L12;
        RedPacketState r105 = r104.getState();
        if (r105 == null) goto L12;
        n0 r106 = r105.getInfo();
    L13:
        if (r106 == null) goto L16;
        com.bytedance.android.live.revenue.common.u0 r107 = r106.f88672h;
        if (r107 == null) goto L16;
    L17:
        com.bytedance.android.live.revenue.common.u0 r108 = r107.b(x0.d());
        com.bytedance.android.live.revenue.common.u0 r109 = f88528w;
        r108.a(r109);
        StringBuilder r110 = new StringBuilder("curPacket?.waitDuration = ");
        if (r106 == null) goto L20;
        r102 = r106.f88671g;
    L20:
        r110.append(r102);
        r110.append("  + TEMP_STATUS_SMALLEST_SHOW_TIME=");
        r110.append(r109);
        ALogger.i("RedPacketIconMode", r110.toString());
        if (r106 != null) goto L23;
    L25:
        showNormalState();
        return;
    L23:
        if ((getCurrentState() instanceof y0.a.C1363a) == true) goto L25;
        this.f88536m = r106.f88668d;
        return;
    L16:
        r107 = com.bytedance.android.live.revenue.common.u0.f90999f;
    L12:
        r106 = null;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.revenue.sti.IRevIconModel
    public final IRevIconModel.a getEntryViewForState(Object r110, Object r210) {
        Object r100 = (y0.a) r110;
        y0.a r101 = (y0.a) r210;
        Intrinsics.checkNotNullParameter(r100, "state");
        if ((r100 instanceof y0.a.d) == true) goto L5;
    L136:
        return null;
    L5:
        if ((r101 instanceof y0.a.c) == false) goto L136;
        int r102 = ((Number) i1.f88625h.getValue(null, i1.f88618a[6])).intValue();
        ArraysKt.contains(new Integer[]{1, 2, 6, 7}, Integer.valueOf(r102));
        ArraysKt.contains(new Integer[]{2, 7}, Integer.valueOf(r102));
        ArraysKt.contains(new Integer[]{3, 5, 6, 7}, Integer.valueOf(r102));
        if (ArraysKt.contains(new Integer[]{4, 5, 6, 7}, Integer.valueOf(r102)) == false) goto L126;
        IRevIconModel.a r103 = inflateEntryView(R.layout.ttlive_red_packet_new_sti_entry);
        View r104 = r103.f157513a;
        if (r104 == null) goto L125;
        ViewGroup r105 = (ViewGroup) r104;
        int r111 = this.f88540q.c();
        Iterable r106 = (Iterable) this.f88540q.f88784k.f88708e.f267520d;
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r107 = r106.iterator();
    L12:
        if (r107.hasNext() == false) goto L14;
        r112.add(((RedPacket) r107.next()).getState().getInfo());
        goto L12
    L14:
        Intrinsics.checkNotNullParameter(r112, "infoList");
        Iterator r113 = r112.iterator();
        if (r113.hasNext() == true) goto L17;
        Object r108 = null;
    L26:
        final n0 r109 = (n0) r108;
        if (r109 == null) goto L29;
        py.k r114 = x0.c(r109);
    L30:
        LinkedHashMap r115 = new LinkedHashMap();
        Iterator r116 = r112.iterator();
    L32:
        if (r116.hasNext() == false) goto L53;
        Object r117 = r116.next();
        n0 r118 = (n0) r117;
        IBaseUser r119 = r118.f88674j;
        String r120 = r119.getWebcastUid();
        if (r120 != null) goto L36;
    L39:
        boolean r121 = true;
    L40:
        if (r121 == true) goto L43;
        r119 = null;
    L43:
        if (r119 == null) goto L46;
        String r122 = r119.getIdString();
        if (r122 == null) goto L46;
    L47:
        if (r122 != null) goto L49;
        r122 = "";
    L49:
        Object r123 = r115.get(r122);
        if (r123 != null) goto L52;
        r123 = new ArrayList();
        r115.put(r122, r123);
    L52:
        ((List) r123).add(r117);
    L46:
        r122 = r118.f88674j.getWebcastUid();
        goto L47
    L36:
        if (r120.length() == 0) goto L39;
        r121 = false;
        goto L40
    L53:
        List r124 = SequencesKt.toList(SequencesKt.sortedWith(SequencesKt.map(CollectionsKt.asSequence(r115.values()), RedPacketIconHelpersKt$generateEntryList$topUsers$2.INSTANCE), z.f88792a));
        List r125 = SequencesKt.toList(SequencesKt.map(SequencesKt.take(SequencesKt.filter(CollectionsKt.asSequence(r124), new RedPacketIconHelpersKt$generateEntryList$topTwoUsers$1(r109)), 2), RedPacketIconHelpersKt$generateEntryList$topTwoUsers$2.INSTANCE));
        List r126 = SequencesKt.toList(SequencesKt.take(CollectionsKt.asSequence(r124), 3));
        ArrayList r127 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r126, 10));
        Iterator r128 = r126.iterator();
    L55:
        if (r128.hasNext() == false) goto L57;
        r127.add(((RedPacketIconHelpersKt$generateEntryList$topUsers$2.a) r128.next()).f88526b);
        goto L55
    L57:
        ArrayList r129 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r127, 10));
        Iterator r130 = r127.iterator();
    L59:
        if (r130.hasNext() == false) goto L61;
        r129.add(((n0) r130.next()).f88674j);
        goto L59
    L61:
        com.bytedance.android.live.profit.redpacket.c r131 = new com.bytedance.android.live.profit.redpacket.c(CollectionsKt.filterNotNull(CollectionsKt.plus(r125, CollectionsKt.listOf(r114))));
        bv0.b r132 = this.f88541r;
        Intrinsics.checkNotNullParameter(r105, "rootView");
        Intrinsics.checkNotNullParameter(r131, "entryInfo");
        Intrinsics.checkNotNullParameter(r132, "redPacketDressService");
        List<py.k> r133 = r131.f88593a;
        ((TextView) r105.findViewById(R.id.coin_count)).setText(String.valueOf(r111));
        ViewGroup r134 = (ViewGroup) r105.findViewById(R.id.avatar_container);
        HSImageView r135 = (HSImageView) r105.findViewById(R.id.coin_mark);
        if (r135 == null) goto L64;
        py.k r136 = r3.a();
        Intrinsics.checkNotNullParameter(r135, "$this$bindImage");
        ImageLoader.bindImage(r135, r136);
    L64:
        LayoutInflater r137 = LayoutInflater.from(r105.getContext());
        int r138 = r133.size();
        if (r138 == 1) goto L69;
        if (r138 == 2) goto L68;
        r137.inflate(R.layout.ttlive_red_packet_new_sti_entry_avatar_3, r134);
    L70:
        Iterator r139 = CollectionsKt.zip(r133, new Integer[]{Integer.valueOf(R.id.avatar1), Integer.valueOf(R.id.avatar2), Integer.valueOf(R.id.avatar3)}).iterator();
    L72:
        if (r139.hasNext() == false) goto L76;
        Pair r140 = (Pair) r139.next();
        py.k r141 = (py.k) r140.component1();
        HSImageView r142 = (HSImageView) r134.findViewById(((Number) r140.component2()).intValue());
        if (r142 == null) goto L72;
        Intrinsics.checkNotNullParameter(r142, "$this$bindImage");
        ImageLoader.bindImage(r142, r141);
        goto L72
    L76:
        HSImageView r143 = (HSImageView) r105.findViewById(R.id.background);
        String r144 = r131.f88594b;
        if (r144 == null) goto L121;
        RedPacketDressType r145 = RedPacketDressType.EnterSkinPng;
        r132.getClass();
        Intrinsics.checkNotNullParameter(r144, "dressId");
        Intrinsics.checkNotNullParameter(r145, "dressType");
        if (StringsKt.isBlank(r144) == true) goto L121;
        if (((LinkedHashMap) r132.f20776a).keySet().contains(r144) == true) goto L84;
    L85:
        zt0.d r146 = yt0.c.b();
        if (r146 == null) goto L88;
        zt0.c r147 = r146.d2();
    L89:
        Map<String, com.bytedance.android.live.profit.dress.w> r148 = r132.f20776a;
        if (r147 == null) goto L94;
        com.bytedance.android.live.profit.dress.config.y r149 = (com.bytedance.android.live.profit.dress.config.y) r147.a(r144, Reflection.getOrCreateKotlinClass(com.bytedance.android.live.profit.dress.config.y.class));
        if (r149 == null) goto L94;
        com.bytedance.android.live.profit.dress.w r150 = r149.f87107c;
    L95:
        r148.put(r144, r150);
    L96:
        com.bytedance.android.live.profit.dress.w r151 = (com.bytedance.android.live.profit.dress.w) ((LinkedHashMap) r132.f20776a).get(r144);
        switch(bv0.a.f20775a[r145.ordinal()]) {
            case 1: goto L119;
            case 2: goto L117;
            case 3: goto L115;
            case 4: goto L113;
            case 5: goto L111;
            case 6: goto L109;
            case 7: goto L107;
            case 8: goto L105;
            case 9: goto L103;
            case 10: goto L101;
            case 11: goto L99;
            default: goto L121;
        };
    L99:
        if (r151 == null) goto L121;
        py.k r152 = r151.f87203l;
    L122:
        ImageUtil.loadImage(r143, r152, 0);
        r105.setOnClickListener(new e0(this));
        return r103;
    L101:
        if (r151 == null) goto L121;
        r152 = r151.f87200i;
        goto L122
    L103:
        if (r151 == null) goto L121;
        r152 = r151.f87202k;
        goto L122
    L105:
        if (r151 == null) goto L121;
        r152 = r151.f87201j;
        goto L122
    L107:
        if (r151 == null) goto L121;
        r152 = r151.f87199h;
        goto L122
    L109:
        if (r151 == null) goto L121;
        r152 = r151.f87198g;
        goto L122
    L111:
        if (r151 == null) goto L121;
        r152 = r151.f87197f;
        goto L122
    L113:
        if (r151 == null) goto L121;
        r152 = r151.f87196e;
        goto L122
    L115:
        if (r151 == null) goto L121;
        r152 = r151.f87195d;
        goto L122
    L117:
        if (r151 == null) goto L121;
        r152 = r151.f87194c;
        goto L122
    L119:
        if (r151 == null) goto L121;
        r152 = r151.f87193b;
    L94:
        r150 = null;
        goto L95
    L88:
        r147 = null;
        goto L89
    L84:
        if (((LinkedHashMap) r132.f20776a).get(r144) != null) goto L96;
    L121:
        r152 = null;
        goto L122
    L68:
        r137.inflate(R.layout.ttlive_red_packet_new_sti_entry_avatar_2, r134);
        goto L70
    L69:
        r137.inflate(R.layout.ttlive_red_packet_new_sti_entry_avatar_1, r134);
        goto L70
    L29:
        r114 = null;
        goto L30
    L17:
        r108 = r113.next();
        if (r113.hasNext() == false) goto L26;
        com.bytedance.android.live.revenue.common.u0 r153 = ((n0) r108).f88672h;
    L21:
        Object r154 = r113.next();
        com.bytedance.android.live.revenue.common.u0 r155 = ((n0) r154).f88672h;
        if (r153.compareTo(r155) <= 0) goto L25;
        r153 = r155;
        r108 = r154;
    L25:
        if (r113.hasNext() == true) goto L21;
    L125:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L126:
        IRevIconModel.a r156 = inflateEntryView(R.layout.ttlive_view_lucky_box_sti_entry);
        View r157 = r156.f157513a;
        if (r157 == null) goto L135;
        ViewGroup r158 = (ViewGroup) r157;
        HSImageView r159 = (HSImageView) r158.findViewById(R.id.iv_user_avatar);
        TextView r160 = (TextView) r158.findViewById(R.id.tv_coin_count);
        HSImageView r161 = (HSImageView) r158.findViewById(R.id.coin_mark);
        n0 r162 = ((y0.a.d) r100).a().getState().getInfo();
        if (r159 == null) goto L131;
        py.k r163 = x0.c(r162);
        Intrinsics.checkNotNullParameter(r159, "$this$bindImage");
        ImageLoader.bindImage(r159, r163);
    L131:
        if (r161 == null) goto L133;
        py.k r164 = r3.a();
        Intrinsics.checkNotNullParameter(r161, "$this$bindImage");
        ImageLoader.bindImage(r161, r164);
    L133:
        r160.setText(String.valueOf(r162.f88677m));
        return r156;
    L135:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.revenue.sti.IRevIconModel
    public final void c(Object r110, Object r111, xr2.h r112) {
        y0.a r100 = (y0.a) r110;
        y0.a r101 = (y0.a) r111;
        Intrinsics.checkNotNullParameter(r101, "curState");
        boolean r113 = r101 instanceof y0.a.d;
        if (r113 == false) goto L41;
        if ((r112 instanceof xr2.a) == false) goto L41;
        bindState(RxUtilKt.e(com.bytedance.android.live.core.arch.mvvm.f.b(this.f88540q.f88779f)).subscribe(new c0(this, r112)));
        if ((r101 instanceof y0.a.e) == false) goto L14;
        y0.a.d r114 = (y0.a.d) r101;
        startCountDown(r114.a().getState().getInfo().f88672h.b(x0.d()).f91006a, null, null, null);
        bindModel(getCountDownObservable().subscribe(new j0(this)));
        View r102 = r112.getView();
        if (r102 == null) goto L12;
        HSImageView r103 = (HSImageView) ((ViewGroup) r102).findViewById(R.id.iv_user_avatar);
        r103.setActualImageResource(0);
        py.k r104 = x0.c(r114.a().getState().getInfo());
        Intrinsics.checkNotNullParameter(r103, "$this$bindImage");
        ImageLoader.bindImage(r103, r104);
    L37:
        String r105 = ((y0.a.d) r101).a().getState().getInfo().f88668d;
        if ((!Intrinsics.areEqual(this.f88533j, r105)) == false) goto L41;
        com.bytedance.android.live.profit.util.e.b(this.f88539p, com.bytedance.android.live.profit.util.m.f89112b);
        this.f88533j = r105;
        goto L41
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L14:
        if ((r101 instanceof y0.a.b) == false) goto L25;
        if ((r112 instanceof xr2.b) == false) goto L37;
        View r106 = ((xr2.b) r112).getContentView();
        if ((r106 instanceof HSImageView) == false) goto L37;
        if (((Number) this.f88540q.f88779f.f64752a).intValue() != 0) goto L22;
        b0.b(r101, this.f88541r, RedPacketDressType.ShortTouchEmptyHideWebp);
        String r107 = "asset://com.ss.android.ies.live.sdk/ttlive_red_packet_sti_empty_hide.webp";
    L23:
        HSImageView r108 = (HSImageView) r106;
        r108.setController(Fresco.newDraweeControllerBuilder().setUri(r107).setControllerListener(com.bytedance.android.live.profit.util.k.a(null, ((y0.a.b) r101).f88787b, false, 13)).build());
        r108.getHierarchy();
        goto L37
    L22:
        b0.b(r101, this.f88541r, RedPacketDressType.ShortTouchEmptyMoreWebp);
        r107 = "asset://com.ss.android.ies.live.sdk/ttlive_red_packet_sti_empty_more.webp";
        goto L23
    L25:
        if ((r101 instanceof y0.a.C1363a) == false) goto L37;
        if ((r100 instanceof y0.a.C1363a) == true) goto L32;
        if ((r112 instanceof xr2.f) == false) goto L32;
        ((xr2.f) r112).shake();
        bindState(Disposables.fromAction(new d0(r112)));
    L32:
        if (Intrinsics.areEqual(((y0.a.d) r101).a().getState().getInfo().f88668d, this.f88536m.toString()) == false) goto L37;
        if (this.f88535l == false) goto L36;
        this.f88535l = false;
    L36:
        showNormalState();
    L41:
        if (this.f88532i == true) goto L65;
        if (r113 == true) goto L44;
        return;
    L44:
        if ((r100 instanceof y0.a.d) == true) goto L67;
        long r109 = System.currentTimeMillis() - this.f88539p.p().f88652b;
        n0 r115 = ((y0.a.d) r101).a().getState().getInfo();
        int r116 = ((Number) this.f88540q.f88779f.f64752a).intValue();
        int r117 = this.f88540q.c();
        boolean r118 = this.f88543t.isAnchor();
        Long r119 = Long.valueOf(r109);
        Intrinsics.checkNotNullParameter(r115, "currentPacket");
        long r120 = RangesKt.coerceAtLeast(r115.f88672h.b(x0.d()).f91006a / com.bytedance.android.live.revenue.common.u0.f90995b, 0);
        RedPacketDataSource r121 = r115.f88679o;
        Intrinsics.checkNotNullParameter(r115, "currentPacket");
        Intrinsics.checkNotNullParameter(r121, "dataSource");
        Pair[] r122 = new Pair[4];
        r122[0] = TuplesKt.to("count", String.valueOf(r116));
        r122[1] = TuplesKt.to("time", String.valueOf(r120));
        r122[2] = TuplesKt.to("money", String.valueOf(r117));
        int[] r123 = n.f88664a;
        int r124 = r123[r121.ordinal()];
        String r125 = "send";
        if (r124 == 1) goto L51;
        if (r124 != 2) goto L50;
        Object r126 = "send";
    L52:
        r122[3] = TuplesKt.to("show_time", r126);
        Map<? extends String, ? extends String> r127 = MapsKt.mutableMapOf(r122);
        o.a(r127, r115, r118);
        mz0.n r128 = new mz0.n();
        Map<String, String> r129 = r128.f516447a;
        Intrinsics.checkNotNullParameter(r129, "map");
        Intrinsics.checkNotNullParameter(r127, "map");
        r129.putAll(r127);
        mz0.m r130 = new mz0.m();
        LogCommon r131 = LogCommon.PAGE_SOURCE_LOG;
        r130.b(r131);
        LogCommon r132 = LogCommon.ROOM;
        r130.b(r132);
        ((ArrayList) r128.f516448b).addAll(r130.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r133 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r134 = com.bytedance.android.scope.m.b(r133).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r134);
        ((mz0.i) ((f80.a) r134)).w3("livesdk_redpackage_show", r128.f516447a, r128.f516448b);
        int r135 = r123[r121.ordinal()];
        if (r135 != 1) goto L55;
        r125 = "enter";
    L61:
        if (Intrinsics.areEqual(r125, "enter") == false) goto L63;
        r127.put("duration", String.valueOf(r119));
    L63:
        mz0.n r136 = new mz0.n();
        Map<String, String> r137 = r136.f516447a;
        Intrinsics.checkNotNullParameter(r137, "map");
        Intrinsics.checkNotNullParameter(r127, "map");
        r137.putAll(r127);
        mz0.m r138 = new mz0.m();
        r138.b(r131);
        r138.b(r132);
        ((ArrayList) r136.f516448b).addAll(r138.f516446a);
        Object r139 = com.bytedance.android.scope.m.b(r133).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r139);
        ((mz0.i) ((f80.a) r139)).w3("livesdk_lucky_box_item_enter_room_show", r136.f516447a, r136.f516448b);
        this.f88532i = true;
        return;
    L55:
        if (r135 == 2) goto L61;
        throw new NoWhenBranchMatchedException();
    L50:
        throw new NoWhenBranchMatchedException();
    L51:
        r126 = "enter";
        goto L52
    L67:
        return;
    }

    public final void i(com.bytedance.android.live.profit.redpacket.e r110, List<? extends com.bytedance.android.livesdk.chatroom.model.n1.e> r111, RedPacketDialogShowFrom r112) {
        if (r110 != null) goto L17;
        Iterator r113 = ((Iterable) this.f88540q.f88784k.f88708e.f267520d).iterator();
    L5:
        if (r113.hasNext() == false) goto L9;
        Object r100 = r113.next();
        if ((!f.a(((RedPacket) r100).getState())) == false) goto L5;
    L10:
        RedPacket r101 = (RedPacket) r100;
        if (r101 == null) goto L18;
        this.f88544u.f(getContext(), r101, getCountDownSec(), this.f88543t.getRoom(), r111, r112, null, RedPacketIconModel$showRushDialog$2$1.INSTANCE);
        Unit r114 = Unit.INSTANCE;
        return;
    L18:
        return;
    L9:
        r100 = null;
        goto L10
    }

    public RedPacketIconModel(w0 r100, y0 r101, bv0.b r102, c01.a r103, yz0.k r104, RedPacketHybridService r105, r0 r106) {
        Intrinsics.checkNotNullParameter(r100, "redPacketScope");
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        Intrinsics.checkNotNullParameter(r102, "redPacketDressService");
        Intrinsics.checkNotNullParameter(r103, "stiService");
        Intrinsics.checkNotNullParameter(r104, "roomDataService");
        Intrinsics.checkNotNullParameter(r105, "redPackerHybridService");
        Intrinsics.checkNotNullParameter(r106, "redPacketRepository");
        super(y0.a.c.f88788a, RevStiElementType.RegularLuckyBox.getTypeId());
        this.f88539p = r100;
        this.f88540q = r101;
        this.f88541r = r102;
        this.f88542s = r103;
        this.f88543t = r104;
        this.f88544u = r105;
        this.f88545v = r106;
        this.f88529f = new CompositeDisposable();
        this.f88530g = new CompositeDisposable();
        this.f88533j = "";
        this.f88534k = new PropertyOwner(0);
        this.f88536m = "";
        this.f88537n = "";
        this.f88538o = "";
        new PropertyOwner(Boolean.FALSE);
    }
}
