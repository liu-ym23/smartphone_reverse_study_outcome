package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.ec.hybrid.tools.TransitionAnimationHelper;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderSliceModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.d0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.ItemMediaLayer;
import com.facebook.imagepipeline.image.ImageInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class HeadMultiPreview extends LinearLayout implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f169574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f169575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<HeaderContentModel> f169576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HeaderContentModel f169577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<ItemMediaLayer> f169578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f169579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f169580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s f169581h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b f169582i;

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HeadMultiPreview f169583a;

        public a(HeadMultiPreview r100) {
            this.f169583a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f169583a.f169581h.eh().x(this.f169583a);
            this.f169583a.r();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f169583a.f169581h.eh().z(this.f169583a);
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f169584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HeadMultiPreview f169585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ HeaderContentModel f169586c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f169587d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.headv2.k f169588e;

        public b(View r100, HeadMultiPreview r101, HeaderContentModel r102, int r103, com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r104) {
            this.f169584a = r100;
            this.f169585b = r101;
            this.f169586c = r102;
            this.f169587d = r103;
            this.f169588e = r104;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            IAction r101 = this.f169586c.getClickAction();
            if (r101 == null) goto L13;
            d0 r102 = this.f169585b.f169581h.yd();
            View r103 = this.f169584a;
            Pair[] r104 = new Pair[3];
            HeaderMediaModel r105 = this.f169586c.getMedia();
            if (r105 == null) goto L7;
            VideoModel r106 = r105.getVideo();
        L9:
            if (r106 == null) goto L11;
            boolean r107 = true;
        L12:
            r104[0] = TuplesKt.to("disable_gallery_anim", Boolean.valueOf(r107));
            r104[1] = TuplesKt.to("multi_position", Integer.valueOf(this.f169587d));
            r104[2] = TuplesKt.to("index", Integer.valueOf(this.f169585b.f169579f));
            r102.d(r101, r103, MapsKt.mutableMapOf(r104));
            goto L13
        L11:
            r107 = false;
            goto L12
        L7:
            r106 = null;
        L13:
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r108 = this.f169588e;
            if (r108 == null) goto L19;
            IAction r109 = r108.b();
            if (r109 == null) goto L20;
            this.f169585b.f169581h.yd().d(r109, this.f169585b, null);
            return;
        L20:
            return;
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void a(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void c(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void d(boolean r100, int r101) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void e() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void f(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void h(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void j(int r100, ImageInfo r101, boolean r102, int r103) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void k() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void m() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void n(int r100, Boolean r101) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onDestroy() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPageSelected(int r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPause() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onResume() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void p(String r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void s() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void t() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void u() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void v() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void w(int r100) {
    }

    public final void r() {
        if (this.f169581h.wq() == false) goto L5;
        setPadding(0, 0, 0, 0);
        return;
    L5:
        int r100 = com.bytedance.android.shopping.utils.x.f187159a;
        float r101 = com.bytedance.android.ec.core.utils.q.a(12);
        float r102 = com.bytedance.android.ec.core.utils.q.a(44);
        float r103 = r102 - r101;
        int r104 = (int) (r101 + (r103 * this.f169581h.HG()));
        int r105 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        setPadding(com.bytedance.android.ec.hybrid.list.util.c.d(12), r104, com.bytedance.android.ec.hybrid.list.util.c.d(12), com.bytedance.android.ec.hybrid.list.util.c.d(20));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f169581h.rR().b0() == true) goto L33;
        List<HeaderContentModel> r100 = this.f169576c;
        if (r100 == null) goto L16;
        Iterator r101 = ((ArrayList) r100).iterator();
    L8:
        if (r101.hasNext() == false) goto L16;
        HeaderContentModel r102 = (HeaderContentModel) r101.next();
        if (r102 == null) goto L8;
        HeaderSliceModel r103 = r102.getSlice();
        if (r103 == null) goto L8;
        IAction r104 = r103.getShowActions();
        if (r104 == null) goto L8;
        this.f169581h.yd().d(r104, this, null);
    L16:
        HeaderContentModel r105 = this.f169577d;
        if (r105 == null) goto L34;
        HeaderSliceModel r106 = r105.getSlice();
        if (r106 == null) goto L35;
        IAction r107 = r106.getShowActions();
        if (r107 == null) goto L36;
        this.f169581h.yd().d(r107, this, null);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void A(boolean r100) {
        r();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void i(float r100) {
        r();
    }

    public final HeaderContentModel l(com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r100) {
        HeaderContentModel r101 = r100.a();
        if (r101 != null) goto L12;
        Integer r102 = r100.c();
        if (r102 == null) goto L13;
        int r103 = r102.intValue();
        AnchorV4HeadV2VO r104 = this.f169581h.K10();
        if (r104 == null) goto L14;
        List<HeaderContentModel> r105 = r104.getCells();
        if (r105 != null) goto L11;
        return null;
    L11:
        return (HeaderContentModel) CollectionsKt.getOrNull(r105, r103);
    L14:
        return null;
    L13:
        return null;
    L12:
        return r101;
    }

    public final void o(View r100) {
        if (r100 != null) goto L7;
        ItemMediaLayer r101 = (ItemMediaLayer) CollectionsKt.firstOrNull(this.f169578e);
        if (r101 == null) goto L6;
        r100 = r101.f169660b;
        goto L7
    L6:
        r100 = null;
    L7:
        if (r100 == null) goto L10;
        TransitionAnimationHelper.e(r100, 0.0f, true);
        r100.setPadding(0, 0, 0, 0);
        r100.setBackgroundColor(0);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void q(AnchorV4HeadV2VO r100) {
        Intrinsics.checkNotNullParameter(r100, "headVo");
        Intrinsics.checkNotNullParameter(r100, "headVo");
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        g(r102, this.f169574a, 0);
        g(r102, this.f169575b, 1);
        super.onMeasure(r100, r101);
    }

    public HeadMultiPreview(Context r100, com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s r101, com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "headAbility");
        Intrinsics.checkNotNullParameter(r102, "sizeHelper");
        super(r100);
        this.f169581h = r101;
        this.f169582i = r102;
        this.f169578e = new ArrayList();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(0);
        LinearLayout r103 = new LinearLayout(getContext());
        r103.setOrientation(1);
        r103.setClipChildren(false);
        r103.setClipToPadding(false);
        this.f169574a = r103;
        Unit r104 = Unit.INSTANCE;
        addView(r103, -2, -2);
        LinearLayout r105 = new LinearLayout(getContext());
        r105.setOrientation(1);
        r105.setClipChildren(false);
        r105.setClipToPadding(false);
        this.f169575b = r105;
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(-2, -2);
        int r107 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r106.leftMargin = com.bytedance.android.ec.hybrid.list.util.c.d(6);
        addView(r105, r106);
        addOnAttachStateChangeListener(new a(this));
    }

    public final void g(int r100, ViewGroup r101, int r102) {
        boolean r103 = this.f169581h.wq();
        int r104 = k83.a.f502092a;
        int r105 = (int) (r100 * k83.a.a(this.f169581h.XU(), r102));
        if (r102 == 0) goto L5;
        int r106 = -2;
    L9:
        int r107 = r101.getChildCount();
        int r108 = 0;
    L10:
        if (r108 >= r107) goto L12;
        View r109 = r101.getChildAt(r108);
        r109.getLayoutParams().width = r105;
        r109.getLayoutParams().height = r105;
        r108 = r108 + 1;
        goto L10
    L12:
        if (r102 == 0) goto L14;
    L15:
        r101.getLayoutParams().width = r106;
        r101.getLayoutParams().height = r106;
        return;
    L14:
        if (this.f169580g == false) goto L15;
        return;
    L5:
        if (r103 == false) goto L7;
        r105 = -1;
    L7:
        r106 = r105;
        r105 = -1;
        goto L9
    }

    public final void b(ItemMediaLayer r110, HeaderContentModel r111, com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r112, int r113) {
        if (r111.getMedia() != null) goto L5;
    L8:
        ViewGroup r100 = r110.f169660b;
        if ((r100 instanceof ViewGroup) == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L30;
        int r101 = r100.getChildCount() - 1;
    L15:
        if (r101 < 0) goto L24;
        View r102 = r100.getChildAt(r101);
        if (r102 == null) goto L19;
        Object r103 = r102.getTag();
    L21:
        if (Intrinsics.areEqual(r103, "head_multi_preview_slice") == false) goto L23;
        r100.removeViewAt(r101);
    L23:
        r101 = r101 - 1;
        goto L15
    L19:
        r103 = null;
        goto L21
    L24:
        HeaderSliceModel r104 = r111.getSlice();
        if (r104 == null) goto L30;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i r105 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.i(this.f169581h);
        r105.b(r104, this.f169579f, Integer.valueOf(r113));
        View r106 = r105.f169695a;
        if (r106 == null) goto L30;
        wg.a.a(r106);
        r106.setTag("head_multi_preview_slice");
        r100.addView(r106, new ViewGroup.LayoutParams(-1, -1));
    L30:
        ViewGroup r114 = r110.f169660b;
        Lazy r107 = TransitionAnimationHelper.f47620a;
        if (this.f169581h.wq() == false) goto L33;
        float r108 = 0.0f;
    L34:
        TransitionAnimationHelper.e(r114, r108, true);
        r114.setOnClickListener(new b(r114, this, r111, r113, r112));
        return;
    L33:
        r108 = 12.0f;
        goto L34
    L5:
        if (r111.getMedia().getVideo() != null) goto L7;
        r110.f169660b.setBackgroundColor(-1);
    L7:
        r110.f169667i = new HeadMultiPreview$bindMediaLayer$1(this, r110, r111, r112);
        r110.B(r111.getMedia(), this.f169579f, Integer.valueOf(r113));
        goto L8
    }
}
