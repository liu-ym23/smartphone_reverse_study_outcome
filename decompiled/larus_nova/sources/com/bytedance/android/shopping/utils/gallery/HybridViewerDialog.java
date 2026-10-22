package com.bytedance.android.shopping.utils.gallery;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.shopping.gallery2.GalleryViewer;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/utils/gallery/HybridViewerDialog;", "Lcom/bytedance/android/shopping/gallery2/GalleryViewer;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridViewerDialog extends GalleryViewer {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ee3.f f187103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f187104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f187105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HybridGalleryAdapter f187106g;

    public HybridViewerDialog(ECGalleryActivity r100) {
        HybridGalleryAdapter r101 = new HybridGalleryAdapter();
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "hybridAdapter");
        super(r100, new HybridGalleryAdapter());
        this.f187106g = r101;
        ee3.f r102 = new ee3.f();
        this.f187103d = r102;
        this.f187104e = new e(r100);
        this.f187105f = CollectionsKt.emptyList();
        r102.f472282d = new l(this);
        r102.f472283e = new m(this);
        getPager().addOnScrollListener(new AnonymousClass3(this));
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.PhotoViewerDialog
    public final void onPageSelected(int r100) {
        super.onPageSelected(r100);
        if (this.f187106g.B2() == false) goto L8;
        if (r100 != 0) goto L6;
        this.f187103d.d();
        return;
    L6:
        this.f187103d.c();
        return;
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryViewer, com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionEnd(int r100) {
        if (r100 == 0) goto L5;
        return;
    L5:
        if (this.f187106g.B2() == false) goto L7;
        this.f187103d.a(getRootContainer());
    L7:
        e r101 = this.f187104e;
        FrameLayout r102 = getRootContainer();
        List<String> r103 = this.f187105f;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r103, "titles");
        RecyclerView.Adapter r104 = null;
        View r105 = th.a.d(r102.getContext(), R.layout.ec_commerce_banner_indicator_layout, null, 6);
        r101.f187117a = r105;
        if (r105 == null) goto L10;
        RecyclerView r106 = (RecyclerView) r105.findViewById(R.id.indicator_recyclerview);
    L11:
        r101.f187118b = r106;
        if (r106 == null) goto L14;
        r106.setVisibility(4);
        LinearLayoutManager r107 = new LinearLayoutManager(r102.getContext());
        r107.setOrientation(0);
        Unit r108 = Unit.INSTANCE;
        r106.setLayoutManager(r107);
        r106.setAdapter(new BannerAdapter(r102.getContext(), r103, r101.f187122f));
        r106.addItemDecoration(new BannerListDecoration(r101.f187123g));
    L14:
        View r109 = r101.f187117a;
        if (r109 == null) goto L17;
        View r110 = r109.findViewById(R.id.indicator_sub_line);
    L18:
        r101.f187119c = r110;
        View r111 = r101.f187117a;
        if (r111 == null) goto L21;
        r111.post(new c(r101));
    L21:
        View r112 = r101.f187117a;
        FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams(-1, -2);
        r113.gravity = 1;
        Unit r114 = Unit.INSTANCE;
        r102.addView(r112, r113);
        RecyclerView r115 = r101.f187118b;
        if (r115 == null) goto L24;
        RecyclerView.Adapter r116 = r115.getAdapter();
    L26:
        if ((r116 instanceof BannerAdapter) == false) goto L29;
        r104 = r116;
    L29:
        BannerAdapter r117 = (BannerAdapter) r104;
        if (r117 == null) goto L39;
        List<String> r118 = r117.f187093d;
        if (r118 != null) goto L34;
        return;
    L34:
        if (r118.size() <= 0) goto L41;
        View r119 = r101.f187117a;
        if (r119 == null) goto L42;
        r119.postDelayed(new d(r101), 200);
        return;
    L42:
        return;
    L41:
        return;
    L39:
        return;
    L24:
        r116 = null;
        goto L26
    L17:
        r110 = null;
        goto L18
    L10:
        r106 = null;
        goto L11
    }
}
