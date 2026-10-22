package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryBottom;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryBottomConfig;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryPendants;
import com.bytedance.android.shopping.anchorv4.dto.business.GallerySliceVisibilityConfig;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryVO;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class w0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f169448k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v0 f169449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f169450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public x0 f169451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t0 f169452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public GalleryVO f169453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f169454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FragmentActivity f169455g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final GalleryLayerItemStateManager f169456h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l f169457i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l0 f169458j;

    public static final class a {
    }

    static {
    }

    public final void b(GalleryVO r110) {
        if (this.f169453e != null) goto L5;
        boolean r100 = true;
    L6:
        this.f169453e = r110;
        c r101 = this.f169450b;
        x0 r102 = null;
        if (r101 == null) goto L16;
        if (r110 == null) goto L10;
        GalleryBottom r103 = r110.getBottom();
    L11:
        com.bytedance.android.shopping.anchorv4.helper.n r104 = r101.f169282b;
        if (r103 == null) goto L14;
        List<com.bytedance.android.ecom.arch.slice.g> r105 = r103.getSlices();
    L15:
        r104.a(r105, r101.f169283c);
        goto L16
    L14:
        r105 = null;
        goto L15
    L10:
        r103 = null;
    L16:
        l r106 = this.f169457i;
        if (r106 != null) goto L19;
    L30:
        x0 r111 = this.f169451c;
        if (r111 == null) goto L35;
        GalleryLayerItemStateManager r107 = this.f169456h;
        if (r107 == null) goto L35;
        r107.h(r111);
    L35:
        c r112 = this.f169450b;
        if (r112 == null) goto L50;
        GalleryVO r108 = this.f169453e;
        if (r108 == null) goto L50;
        GalleryBottom r109 = r108.getBottom();
        if (r109 == null) goto L50;
        GalleryBottomConfig r113 = r109.getConfig();
        if (r113 == null) goto L50;
        Map<String, GallerySliceVisibilityConfig> r114 = r113.getVisibility();
        if (r114 == null) goto L50;
        GallerySliceVisibilityConfig r115 = r114.get("bottom");
        if (r115 == null) goto L50;
        r102 = new x0(this, r115, r112.f169281a, new m0(false, true, false, r115.getAnimType(), false, 52));
    L50:
        if (r102 == null) goto L54;
        this.f169451c = r102;
        GalleryLayerItemStateManager r116 = this.f169456h;
        if (r116 == null) goto L54;
        r116.c(r102);
    L54:
        if (r100 == false) goto L60;
        String r117 = this.f169458j.a();
        if (r117 != null) goto L58;
        r117 = "";
    L58:
        c(r117);
        return;
    L60:
        return;
    L19:
        if (r106.a() != true) goto L30;
        t0 r118 = this.f169452d;
        if (r118 == null) goto L30;
        if (r110 == null) goto L24;
        GalleryPendants r119 = r110.getPendants();
    L25:
        com.bytedance.android.shopping.anchorv4.helper.n r120 = r118.f169402b;
        if (r119 == null) goto L28;
        List<com.bytedance.android.ecom.arch.slice.g> r121 = r119.getSlices();
    L29:
        int r122 = com.bytedance.android.shopping.anchorv4.helper.n.f166964f;
        r120.a(r121, null);
        goto L30
    L28:
        r121 = null;
        goto L29
    L24:
        r119 = null;
        goto L25
    L5:
        r100 = false;
        goto L6
    }

    public final void c(String r110) {
        if (Intrinsics.areEqual(this.f169454f, r110) == false) goto L5;
        return;
    L5:
        this.f169454f = r110;
        int r100 = fi3.c0.f477247e;
        SlcCommonAction r101 = fi3.c0.a.a(GalleryVO.SLICE_ID_SKU_PREVIEW, MapsKt.mapOf(TuplesKt.to("spec_id", r110)), null, 10);
        int r111 = com.bytedance.android.shopping.anchorv4.event_chain.c.f166550a;
        l r112 = this.f169457i;
        if (r112 == null) goto L8;
        EventChain r102 = r112.f169334l;
    L9:
        com.bytedance.android.shopping.anchorv4.event_chain.c.a(r102, null, this.f169449a.f169407a, r101, null, null, null, new com.bytedance.android.ecom.arch.slice.action.c(null, null));
        return;
    L8:
        r102 = null;
        goto L9
    }

    public static final boolean a(w0 r100, GallerySliceVisibilityConfig r101, int r102) {
        r100.getClass();
        List<Integer> r103 = r101.getShow();
        if (r103 != null) goto L5;
    L7:
        List<Integer> r104 = r101.getHide();
        if (r104 != null) goto L10;
        return true;
    L10:
        if ((!r104.isEmpty()) == true) goto L12;
        return true;
    L12:
        if (r101.getHide().contains(Integer.valueOf(r102)) == false) goto L19;
        return false;
    L19:
        return true;
    L5:
        if ((!r103.isEmpty()) != true) goto L7;
        return r101.getShow().contains(Integer.valueOf(r102));
    }

    public w0(FragmentActivity r100, GalleryLayerItemStateManager r101, l r102, GalleryFragment.k r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.f169455g = r100;
        this.f169456h = r101;
        this.f169457i = r102;
        this.f169458j = r103;
        this.f169449a = new v0(r100, r103, r103.d(), r102);
    }
}
