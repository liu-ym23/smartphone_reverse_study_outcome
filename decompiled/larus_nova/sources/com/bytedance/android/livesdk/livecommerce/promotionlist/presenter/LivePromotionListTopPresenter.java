package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.live.ECPromotionInterationData;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes10.dex */
public final class LivePromotionListTopPresenter extends com.bytedance.android.livesdk.livecommerce.promotionlist.base.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a> f151002j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b f151003k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f151004l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f151005m;

    public static final class a {
    }

    public static final class b implements ul.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LivePromotionListTopPresenter f151006a;

        public b(LivePromotionListTopPresenter r100) {
            this.f151006a = r100;
        }

        @Override // ul.c
        public final void a(boolean r100) {
            if (r100 == false) goto L9;
            LivePromotionListTopPresenter r101 = this.f151006a;
            r101.f151004l = false;
            com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b r102 = r101.f151003k;
            if (r102 != null) goto L6;
            return;
        L6:
            if (r102.f151013o == true) goto L8;
            r102.j();
        L8:
            r102.f151014p = false;
            return;
        L9:
            LivePromotionListTopPresenter r103 = this.f151006a;
            r103.f151004l = true;
            com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b r104 = r103.f151003k;
            if (r104 == null) goto L15;
            r104.f45698l.setVisibility(8);
            r104.f151014p = true;
            r104.a();
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LivePromotionListTopPresenter f151007a;

        public c(LivePromotionListTopPresenter r100) {
            this.f151007a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f151007a.d0().isInSplitScreen() == false) goto L5;
            return;
        L5:
            this.f151007a.d0().closePromotionListFragmentNow();
        }
    }

    static {
    }

    public final void clear() {
        ((ArrayList) this.f151002j).clear();
        com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b r100 = this.f151003k;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f151003k = null;
        View r101 = a0();
        if (r101 == null) goto L10;
        ((FrameLayout) r101).removeAllViews();
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.a, com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void c0() {
        super.c0();
        s0.e(this);
        clear();
        List<ul.c> r100 = ul.b.f550585a;
        ul.b.a(this.f151005m);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.a
    public final void e0() {
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.a0.class), new LivePromotionListTopPresenter$init$1(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.s.class), new LivePromotionListTopPresenter$init$2(this));
        a0().setOnClickListener(new c(this));
        s0.c(this);
        wj2.g r100 = d0().getInitialAction();
        if ((r100 instanceof wj2.g.c) == true) goto L5;
        r100 = null;
    L5:
        wj2.g.c r101 = (wj2.g.c) r100;
        if (r101 != null) goto L8;
    L13:
        List<ul.c> r102 = ul.b.f550585a;
        ul.b.b(this.f151005m);
        return;
    L8:
        if (r101.f559977b != true) goto L13;
        this.f151004l = true;
        com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b r103 = this.f151003k;
        if (r103 == null) goto L12;
        r103.f45698l.setVisibility(8);
        r103.f151014p = true;
        r103.a();
    L12:
        List<ul.c> r104 = ul.b.f550585a;
        b r105 = this.f151005m;
        Intrinsics.checkNotNullParameter(r105, "listener");
        List<ul.c> r106 = ul.b.f550585a;
        ListProtector.add(r106, Math.max(0, ((ArrayList) r106).size() - 1), r105);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onReceiveTopFragmentStatusChanged(wk.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        throw null;
    }

    public LivePromotionListTopPresenter(Fragment r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100, r101);
        this.f151002j = new ArrayList();
        this.f151005m = new b(this);
    }

    public static final void h0(LivePromotionListTopPresenter r100, boolean r101, List r102) {
        com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b r103 = r100.f151003k;
        boolean r104 = true;
        if (r103 != null) goto L5;
    L17:
        r100.clear();
        List<com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a> r105 = r100.f151002j;
        List r106 = CollectionsKt.sortedWith(r102, new a0());
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r108 = r106.iterator();
    L19:
        if (r108.hasNext() == false) goto L21;
        r107.add(new com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a((ECPromotionInterationData) r108.next()));
        goto L19
    L21:
        ((ArrayList) r105).addAll(r107);
        List<com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a> r109 = r100.f151002j;
        if (r109 != null) goto L24;
    L27:
        if (r104 == true) goto L46;
        View r110 = r100.a0();
        if (r110 == null) goto L40;
        com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b r111 = new com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b((FrameLayout) r110, r100.d0().getPromotionListParams(), r100.d0().getRoomContextController());
        r100.f151003k = r111;
        if (r100.d0().isInSplitScreen() == false) goto L34;
        float r112 = 0.74f;
    L35:
        r111.f151011m = r112;
        List<com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a> r113 = r100.f151002j;
        Intrinsics.checkNotNullParameter(r113, "barrages");
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r111.f45708a = r113;
        r111.a();
        if (r100.f151004l == true) goto L45;
        r111.j();
        return;
    L45:
        return;
    L34:
        r112 = 0.64f;
        goto L35
    L40:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    L46:
        return;
    L24:
        if (((ArrayList) r109).isEmpty() == true) goto L27;
        r104 = false;
        goto L27
    L5:
        if (r103.f151013o == true) goto L17;
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r115 = r102.iterator();
    L9:
        if (r115.hasNext() == false) goto L11;
        r114.add(new com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a((ECPromotionInterationData) r115.next()));
        goto L9
    L11:
        com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b r116 = r100.f151003k;
        if (r116 == null) goto L43;
        r116.f151016r = r101;
        if (r101 == false) goto L16;
        ((ArrayList) r116.f151015q).clear();
    L16:
        ((ArrayList) r116.f151015q).addAll(r114);
        return;
    }
}
