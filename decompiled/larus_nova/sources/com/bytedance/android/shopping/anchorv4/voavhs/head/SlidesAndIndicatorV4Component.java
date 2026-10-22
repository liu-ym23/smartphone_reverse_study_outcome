package com.bytedance.android.shopping.anchorv4.voavhs.head;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.anchorv4.containers.FullScreenGalleryDialogActivity;
import com.bytedance.android.shopping.anchorv4.containers.GalleryViewerParams;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.HeadViewHolderBuilder;
import com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4GalleryDialogFragment;
import com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4GalleryViewerCompat;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4DownTabIndicator;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4HeadIndicator;
import com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.TransSmallComponent;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeadScrollStateManager;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnDismissListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnPageSelectedListener;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class SlidesAndIndicatorV4Component implements d83.b {
    public static final /* synthetic */ int I = 0;
    public final g A;
    public final d83.a B;
    public final c63.b C;
    public final d83.d D;
    public final Function0<AnchorV4VM> E;
    public final Function0<SlcRenderContext> F;
    public final View G;
    public final View H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.containers.e f168447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.containers.i f168448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g83.a f168449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f168450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AnchorV4HeadViewPager f168451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f83.k f168452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> f168453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, String>> f168454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CommonFindSameElement f168455i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f168456j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AnchorV4HeadIndicator f168457k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AnchorV4DownTabIndicator f168458l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f168459m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final u f168460n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f168461o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f168462p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TransSmallComponent f168463q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f168464r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final t f168465s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public l53.b f168466t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f168467u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final FrameLayout f168468v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final FrameLayout f168469w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final FrameLayout f168470x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final c63.d f168471y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final o f168472z;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlidesAndIndicatorV4Component f168473a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i
        public final Map<String, Object> d() {
            return null;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i
        public final String c() {
            int r100 = t0.f45720a;     // Catch: Exception -> L8
            Gson r101 = t0.a.f45722b;     // Catch: Exception -> L8
            AnchorV4VM r102 = this.f168473a.E.invoke();     // Catch: Exception -> L8
            if (r102 == null) goto L5;
            Map<String, Object> r103 = r102.getEventParams();     // Catch: Exception -> L8
        L6:
            return r101.toJson(r103);
        L5:
            r103 = null;
        L8:
            e = move-exception;
            ECExceptionMonitor.e(e);
            return "";
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i
        public final String e() {
            SlidesAndIndicatorV4Component r100 = this.f168473a;
            if (r100.f168451e == null) goto L20;
            List<Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, String>> r101 = r100.f168454h;
            Intrinsics.checkNotNullParameter(r101, "displayData");
            Iterator<T> r102 = r101.iterator();
        L6:
            if (r102.hasNext() == false) goto L10;
            Object r103 = r102.next();
            if (((com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f) ((Pair) r103).getFirst()).f168660h == false) goto L6;
        L11:
            Pair r104 = (Pair) r103;
            if (r104 == null) goto L21;
            com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f r105 = (com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f) r104.getFirst();
            if (r105 != null) goto L16;
            return null;
        L16:
            return r105.f168662j;
        L21:
            return null;
        L10:
            r103 = null;
            goto L11
        L20:
            return null;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i
        public final String f() {
            AnchorV4VM r100 = this.f168473a.E.invoke();
            if (r100 == null) goto L7;
            CommonMeta r101 = r100.commonMeta();
            if (r101 == null) goto L7;
            return r101.getProductId();
        L7:
            return null;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i
        public final Float h() {
            SlidesAndIndicatorV4Component r100 = this.f168473a;
            if (r100.f168451e == null) goto L20;
            List<Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, String>> r101 = r100.f168454h;
            Intrinsics.checkNotNullParameter(r101, "displayData");
            Iterator<T> r102 = r101.iterator();
        L6:
            if (r102.hasNext() == false) goto L10;
            Object r103 = r102.next();
            if (((com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f) ((Pair) r103).getFirst()).f168660h == false) goto L6;
        L11:
            Pair r104 = (Pair) r103;
            if (r104 == null) goto L21;
            com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f r105 = (com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f) r104.getFirst();
            if (r105 != null) goto L16;
            return null;
        L16:
            return r105.f168661i;
        L21:
            return null;
        L10:
            r103 = null;
            goto L11
        L20:
            return null;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i
        public final Boolean g() {
            return Boolean.FALSE;
        }

        public b(SlidesAndIndicatorV4Component r100) {
            this.f168473a = r100;
        }
    }

    public static final class c implements OnPageSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4GalleryDialogFragment f168474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SlidesAndIndicatorV4Component f168475b;

        @Override // com.bytedance.android.ui.ec.widget.photodraweeview.OnPageSelectedListener
        public final void onPageSelected(int r100) {
            AnchorV4HeadViewPager r101 = this.f168475b.f168451e;
            if (r101 == null) goto L5;
            Pair<Integer, Integer> r102 = r101.k(r100);
        L6:
            if (r102 == null) goto L8;
            Integer r103 = r102.getFirst();
        L9:
            AnchorV4HeadViewPager r104 = this.f168475b.f168451e;
            if (r104 == null) goto L12;
            Integer r105 = Integer.valueOf(r104.getCurrentItem());
        L14:
            if ((!Intrinsics.areEqual(r103, r105)) == false) goto L23;
            c63.d r106 = this.f168475b.f168471y;
            AnchorV4GalleryDialogFragment r107 = this.f168474a;
            String r108 = (String) ((HashMap) r107.f168568r.f168640e).get(Integer.valueOf(r100));
            if (com.bytedance.android.shopping.extensions.k.c(r108) == true) goto L22;
            String r109 = (String) ((HashMap) r107.f168568r.f168639d).get(Integer.valueOf(r100));
            if (r109 != null) goto L21;
            r109 = "0";
        L21:
            int r110 = com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.g.f168664a;
            Intrinsics.checkNotNullParameter(r109, "titleType");
            r108 = com.bytedance.android.shopping.anchorv4.voavhs.head.c.f168527J.get(Integer.valueOf(com.bytedance.android.shopping.anchorv4.voavhs.head.c.a.a(r109)));
        L22:
            r106.H(r100, r108);
        L23:
            if (r102 == null) goto L29;
            AnchorV4HeadViewPager r111 = this.f168475b.f168451e;
            if (r111 == null) goto L27;
            r111.setCurrentItem(r102.getFirst().intValue());
        L27:
            this.f168475b.D.a(true, r102.getFirst(), null);
            e83.a r112 = e83.a.f471296d;
            r102.getSecond().intValue();
            e83.b r113 = new e83.b();
            r112.getClass();
            e83.a.c(r113);
            return;
        L29:
            return;
        L12:
            r105 = null;
            goto L14
        L8:
            r103 = null;
            goto L9
        L5:
            r102 = null;
            goto L6
        }

        public c(AnchorV4GalleryDialogFragment r100, SlidesAndIndicatorV4Component r101) {
            this.f168474a = r100;
            this.f168475b = r101;
        }
    }

    public static final class d implements OnPageSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4GalleryViewerCompat f168476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SlidesAndIndicatorV4Component f168477b;

        @Override // com.bytedance.android.ui.ec.widget.photodraweeview.OnPageSelectedListener
        public final void onPageSelected(int r100) {
            AnchorV4HeadViewPager r101 = this.f168477b.f168451e;
            if (r101 == null) goto L5;
            Pair<Integer, Integer> r102 = r101.k(r100);
        L6:
            if (r102 == null) goto L8;
            Integer r103 = r102.getFirst();
        L9:
            AnchorV4HeadViewPager r104 = this.f168477b.f168451e;
            if (r104 == null) goto L12;
            Integer r105 = Integer.valueOf(r104.getCurrentItem());
        L14:
            if ((!Intrinsics.areEqual(r103, r105)) == false) goto L19;
            c63.d r106 = this.f168477b.f168471y;
            String r107 = (String) ((HashMap) this.f168476a.f168576d.f168639d).get(Integer.valueOf(r100));
            if (r107 != null) goto L18;
            r107 = "0";
        L18:
            int r108 = com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.g.f168664a;
            Intrinsics.checkNotNullParameter(r107, "titleType");
            r106.H(r100, com.bytedance.android.shopping.anchorv4.voavhs.head.c.f168527J.get(Integer.valueOf(com.bytedance.android.shopping.anchorv4.voavhs.head.c.a.a(r107))));
        L19:
            if (r102 == null) goto L25;
            AnchorV4HeadViewPager r109 = this.f168477b.f168451e;
            if (r109 == null) goto L23;
            r109.setCurrentItem(r102.getFirst().intValue());
        L23:
            this.f168477b.D.a(true, r102.getFirst(), null);
            e83.a r110 = e83.a.f471296d;
            r102.getSecond().intValue();
            e83.b r111 = new e83.b();
            r110.getClass();
            e83.a.c(r111);
            return;
        L25:
            return;
        L12:
            r105 = null;
            goto L14
        L8:
            r103 = null;
            goto L9
        L5:
            r102 = null;
            goto L6
        }

        public d(AnchorV4GalleryViewerCompat r100, SlidesAndIndicatorV4Component r101) {
            this.f168476a = r100;
            this.f168477b = r101;
        }
    }

    public static final class e implements OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlidesAndIndicatorV4Component f168478a;

        public e(SlidesAndIndicatorV4Component r100) {
            this.f168478a = r100;
        }

        @Override // com.bytedance.android.ui.ec.widget.photodraweeview.OnDismissListener
        public final void onDismiss(int r100) {
            SlidesAndIndicatorV4Component r101 = this.f168478a;
            r101.f168462p = false;
            r101.A.a(false);
            AnchorV4VM r102 = this.f168478a.E.invoke();
            if (r102 == null) goto L8;
            HeadScrollStateManager r103 = r102.getHeadScrollStateManager();
            if (r103 == null) goto L9;
            int r104 = HeadScrollStateManager.f169016n;
            r103.l(null);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public SlidesAndIndicatorV4Component() {
        throw null;
    }

    @Override // d83.b
    public final void j(View r100) {
        throw null;
    }

    @Override // d83.b
    public final void onResume() {
    }

    @Override // d83.b
    public final List<ECUrlModel> c() {
        AnchorV4HeadViewPager r100 = this.f168451e;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTotalNavBlurTabCount();
    }

    @Override // d83.b
    public final void d() {
        AnchorV4HeadViewPager r100 = this.f168451e;
        if (r100 == null) goto L15;
        HeadViewHolderBuilder r101 = r100.f168430g;
        if (r101 == null) goto L21;
        Iterator<com.bytedance.android.shopping.anchorv4.voavhs.head.base.n> r102 = r101.f168503d.keySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L22;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.n r103 = r102.next();
        if ((r103 instanceof com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) == true) goto L12;
        r103 = null;
    L12:
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.h r104 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) r103;
        if (r104 == null) goto L8;
        r104.d();
        goto L8
    L22:
        return;
    L21:
        return;
    }

    @Override // d83.b
    public final String f() {
        AnchorV4HeadViewPager r100 = this.f168451e;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCurrentImageUri();
    }

    @Override // d83.b
    public final boolean g() {
        AnchorV4VM r100 = this.E.invoke();
        if (r100 == null) goto L7;
        CommonMeta r101 = r100.commonMeta();
        if (r101 == null) goto L7;
        Boolean r102 = Boolean.valueOf(r101.getEnablePDPOptimize());
    L9:
        return com.bytedance.android.shopping.extensions.k.i(r102);
    L7:
        r102 = null;
        goto L9
    }

    @Override // d83.b
    public final boolean i() {
        return this.f168465s.i();
    }

    @Override // d83.b
    public final List<ECUrlModel> k() {
        AnchorV4HeadViewPager r100 = this.f168451e;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTotalBottomTabCount();
    }

    @Override // d83.b
    public final boolean a() {
        return this.f168462p;
    }

    @Override // d83.b
    public final View e() {
        return this.G;
    }

    @Override // d83.b
    public final View h() {
        return this.f168459m;
    }

    @Override // d83.b
    public final void b(boolean r100) {
        AnchorV4HeadViewPager r101 = this.f168451e;
        if (r101 == null) goto L15;
        HeadViewHolderBuilder r102 = r101.f168430g;
        if (r102 == null) goto L21;
        Iterator<com.bytedance.android.shopping.anchorv4.voavhs.head.base.n> r103 = r102.f168503d.keySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L22;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.n r104 = r103.next();
        if ((r104 instanceof com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) == true) goto L12;
        r104 = null;
    L12:
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.h r105 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) r104;
        if (r105 == null) goto L8;
        r105.b(r100);
        goto L8
    L22:
        return;
    L21:
        return;
    }

    public final void m(int r100) {
        AnchorV4HeadViewPager r101 = this.f168451e;
        if (r101 != null) goto L5;
    L6:
        AnchorV4HeadViewPager r102 = this.f168451e;
        if (r102 == null) goto L11;
        r102.setCurrentItem(r100);
        return;
    L11:
        return;
    L5:
        if (r101.getCurrentItem() != r100) goto L6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.util.List<kotlin.Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, java.lang.String>>] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.util.ArrayList] */
    public final void l(Integer r100, final int r101, final boolean r102) {
        AnchorV4HeadViewPager r103 = this.f168451e;
        if (r103 == null) goto L6;
        List<Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, String>> r104 = r103.getGalleryDisplayData();
        if (r104 == null) goto L6;
    L7:
        this.f168454h = r104;
        if (this.f168463q != null) goto L10;
    L23:
        boolean r105 = true;
        this.f168462p = true;
        this.A.a(true);
        if (r100 != null) goto L30;
        AnchorV4HeadViewPager r106 = this.f168451e;
        if (r106 == null) goto L28;
        r100 = Integer.valueOf(r106.getCurrentItem());
        goto L30
    L28:
        r100 = null;
    L30:
        if (r100 == null) goto L32;
        final int r107 = r100.intValue();
    L33:
        int r108 = -1;
        if (com.bytedance.android.ec.core.opt.ab.c.d() == false) goto L64;
        Fragment r109 = com.bytedance.android.shopping.anchorv4.containers.a.f166214a;
        AnchorV4GalleryDialogFragment r110 = new AnchorV4GalleryDialogFragment(new r(this));
        r110.f168569s = new b(this);
        r110.ca0(this.f168454h);
        r110.f168621f = new c(r110, this);
        r110.f168622g = new SlidesAndIndicatorV4Component$openGalleryViewer$$inlined$apply$lambda$3(this, r107, r101, r102);
        AnchorV4HeadViewPager r111 = this.f168451e;
        if (r111 == null) goto L38;
        int r112 = r111.j(r107, r101);
    L39:
        if (r102 == true) goto L54;
        Iterator<Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, String>> r113 = this.f168454h.iterator();
        int r114 = 0;
    L42:
        if (r113.hasNext() == false) goto L47;
        if (r113.next().getFirst().f168660h == true) goto L45;
        r114 = r114 + 1;
        goto L42
    L45:
        r108 = r114;
    L47:
        if (r112 == r108) goto L50;
        r105 = false;
    L50:
        if (r105 == false) goto L52;
        AnchorV4HeadViewPager r115 = null;
    L53:
        r110.f168572v = r115;
        goto L54
    L52:
        r115 = this.f168451e;
    L54:
        if (r112 < 0) goto L62;
        AnchorV4HeadViewPager r116 = this.f168451e;
        if (r116 == null) goto L58;
        Context r117 = r116.getContext();
    L59:
        if (r117 == null) goto L63;
        int r118 = FullScreenGalleryDialogActivity.f166173l;
        FullScreenGalleryDialogActivity.a.a(r117, new GalleryViewerParams(r112), null);
    L63:
        Unit r119 = Unit.INSTANCE;
        com.bytedance.android.shopping.anchorv4.containers.a.f166214a = r110;
    L76:
        this.f168471y.l();
        this.f168471y.f();
        return;
    L58:
        r117 = null;
        goto L59
    L62:
        this.f168462p = false;
        goto L63
    L38:
        r112 = -1;
        goto L39
    L64:
        AnchorV4GalleryViewerCompat r120 = new AnchorV4GalleryViewerCompat(this.f168468v.getContext(), new r(this));
        r120.b(this.f168454h);
        r120.setOnPageSelectedListener(new d(r120, this));
        RecyclerView.OnScrollListener r121 = new SlidesAndIndicatorV4Component$openGalleryViewer$$inlined$apply$lambda$5(this);
        Intrinsics.checkNotNullParameter(r121, "listener");
        r120.getPager().addOnScrollListener(r121);
        r120.setOnDismissListener(new e(this));
        AnchorV4HeadViewPager r122 = this.f168451e;
        if (r122 == null) goto L67;
        r108 = r122.j(r107, r101);
    L67:
        if (r108 < 0) goto L75;
        if (r102 == false) goto L70;
        r120.show(r108);
        goto L76
    L70:
        AnchorV4HeadViewPager r123 = this.f168451e;
        if (r123 == null) goto L74;
        r120.showAnimated(r108, r123);
        goto L76
    L74:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L75:
        this.f168462p = false;
        goto L76
    L32:
        r107 = 0;
        goto L33
    L10:
        if (this.f168472z.a() == true) goto L23;
        TransSmallComponent r124 = this.f168463q;
        if (r124 == null) goto L21;
        ArrayList<com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> r125 = r124.f168843h;
        ArrayList r126 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r125, 10));
        Iterator<com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> r127 = r125.iterator();
    L15:
        if (r127.hasNext() == false) goto L17;
        r126.add(r127.next().f());
        goto L15
    L17:
        ?? r128 = new ArrayList();
        Iterator r129 = r126.iterator();
    L19:
        if (r129.hasNext() == false) goto L22;
        r128.addAll((List) r129.next());
    L22:
        this.f168454h = r128;
        goto L23
    L21:
        r128 = CollectionsKt.emptyList();
    L6:
        r104 = CollectionsKt.emptyList();
        goto L7
    }

    public SlidesAndIndicatorV4Component(FrameLayout r100, FrameLayout r101, FrameLayout r102, AnchorV4HeadView$slidesAndIndicatorComponent$2.a r103, AnchorV4HeadView$slidesAndIndicatorComponent$2.b r104, AnchorV4HeadView$slidesAndIndicatorComponent$2.c r105, AnchorV4HeadView$slidesAndIndicatorComponent$2.d r106, AnchorV4HeadView$slidesAndIndicatorComponent$2.e r107, AnchorV4HeadView$slidesAndIndicatorComponent$2.f r110, AnchorV4HeadView$slidesAndIndicatorComponent$2.g r111, Function0 r112, Function0 r113, AnchorV4HeadView r114) {
        Intrinsics.checkNotNullParameter(r100, "slidesContainer");
        Intrinsics.checkNotNullParameter(r101, "indicatorContainer");
        Intrinsics.checkNotNullParameter(r102, "downTabIndicatorContainer");
        Intrinsics.checkNotNullParameter(r103, "logAction");
        Intrinsics.checkNotNullParameter(r104, "guessULikeAction");
        Intrinsics.checkNotNullParameter(r105, "statusTracker");
        Intrinsics.checkNotNullParameter(r106, "galleryStatusChecker");
        Intrinsics.checkNotNullParameter(r107, "findSameAction");
        Intrinsics.checkNotNullParameter(r110, "videoPlayListener");
        Intrinsics.checkNotNullParameter(r111, "pageScrollAction");
        Intrinsics.checkNotNullParameter(r112, "anchorV4VM");
        Intrinsics.checkNotNullParameter(r113, "slcRenderContext");
        Intrinsics.checkNotNullParameter(r114, "headView");
        this.f168468v = r100;
        this.f168469w = r101;
        this.f168470x = r102;
        this.f168471y = r103;
        this.f168472z = r105;
        this.A = r106;
        this.B = r107;
        this.C = r110;
        this.D = r111;
        this.E = r112;
        this.F = r113;
        this.G = r114;
        this.H = null;
        this.f168453g = CollectionsKt.emptyList();
        this.f168454h = CollectionsKt.emptyList();
        this.f168460n = new u();
        this.f168461o = LazyKt.lazy(new SlidesAndIndicatorV4Component$tabLogicInterceptor$2(this));
        this.f168465s = new t(this);
        this.f168467u = LazyKt.lazy(new SlidesAndIndicatorV4Component$headFloatVideoHandler$2(this));
    }
}
