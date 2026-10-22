package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.containers.GalleryViewerParams;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z0 f169323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.android.ec.model.k> f169324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c0> f169325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f169326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LifecycleOwner f169327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final GalleryViewModel f169328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m f169329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i0 f169330h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final GalleryLayerItemStateManager f169331i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final GalleryViewerParams f169332j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PageFinder f169333k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public EventChain f169334l;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        i0 r100 = this.f169330h;
        if (r100 == null) goto L5;
        GalleryFromType r101 = r100.c();
    L7:
        if (r101 != GalleryFromType.Head) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    public final boolean b() {
        i0 r100 = this.f169330h;
        if (r100 == null) goto L5;
        GalleryFromType r101 = r100.c();
    L7:
        if (r101 != GalleryFromType.MoreVideo) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    public final Context getContext() {
        return this.f169326d;
    }

    public l(List r110, List r111, Context r112, LifecycleOwner r113, GalleryViewModel r210, m r211, i0 r212, GalleryLayerItemStateManager r213, GalleryViewerParams r214, PageFinder r215) {
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r210, "viewModel");
        Intrinsics.checkNotNullParameter(r211, "eventManager");
        Intrinsics.checkNotNullParameter(r215, "pageFinder");
        this.f169324b = r110;
        this.f169325c = r111;
        this.f169326d = r112;
        this.f169327e = r113;
        this.f169328f = r210;
        this.f169329g = r211;
        this.f169330h = r212;
        this.f169331i = r213;
        this.f169332j = r214;
        this.f169333k = r215;
        List<s> r100 = null;
        this.f169334l = null;
        r211.f169336b = this;
        if (r110 == null) goto L45;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r102 = r110.iterator();
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L44;
        Object r104 = r102.next();
        int r114 = r103 + 1;
        if (r103 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        com.bytedance.android.ec.model.k r105 = (com.bytedance.android.ec.model.k) r104;
        if ((r105 instanceof g0) == true) goto L13;
        com.bytedance.android.ec.model.k r106 = null;
    L14:
        g0 r107 = (g0) r106;
        if (r107 == null) goto L42;
        q r108 = r107.f169311p;
        if (r108 == null) goto L42;
        if (r108.f169374l == true) goto L22;
        r108 = null;
    L22:
        if (r108 == null) goto L42;
        int r109 = f0.f169307a;
        c0 r115 = r108.f169375m;
        if (r115 == null) goto L26;
        String r116 = r115.a(r103);
    L27:
        String r117 = f0.a(r116);
        if (r117 != null) goto L30;
        r117 = "";
    L30:
        String r118 = r117;
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r119 = r108.f169366d;
        if (r119 == null) goto L36;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r120 = r119.getPlayInfo();
        if (r120 == null) goto L36;
        String r121 = r120.f();
        if (r121 == null) goto L36;
    L38:
        if (r108.f169366d == null) goto L40;
        boolean r122 = true;
    L41:
        s r123 = new s(r118, r121, r103, r122, r118, false);
    L43:
        r101.add(r123);
        r103 = r114;
        goto L6
    L40:
        r122 = false;
    L36:
        r121 = r105.f47873b;
        goto L38
    L26:
        r116 = null;
    L42:
        r123 = null;
        goto L43
    L13:
        r106 = r105;
        goto L14
    L44:
        r100 = r101;
    L45:
        if (r100 != null) goto L47;
        r100 = CollectionsKt.emptyList();
    L47:
        r210.setFullThumbList(r100);
        this.f169323a = new z0();
    }
}
