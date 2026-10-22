package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.r;
import com.bytedance.android.shopping.gallery2.GalleryAdapter;
import com.bytedance.android.shopping.gallery2.GalleryViewer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/gallery/AnchorV4GalleryViewerCompat;", "Lcom/bytedance/android/shopping/gallery2/GalleryViewer;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4GalleryViewerCompat extends GalleryViewer {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f168576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f168577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f168578f;

    public final void b(List<Pair<f, String>> r210) {
        Intrinsics.checkNotNullParameter(r210, "galleryDisplayData");
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        r102.addAll(r210);
        r102.add(new Pair(new f(null, null, null, null, null, null, false, null, null, 2047), ""));
        String r103 = "0";
        int r104 = 0;
    L3:
        boolean r105 = true;
        Integer r110 = null;
        if (r104 >= r102.size()) goto L47;
        String r106 = (String) ((Pair) ListProtector.get(r102, r104)).getSecond();
        f r111 = (f) ((Pair) ListProtector.get(r102, r104)).getFirst();
        String r112 = r111.f168663k;
        if ((!Intrinsics.areEqual(r106, r103)) == true) goto L8;
    L15:
        ECUrlModel r113 = r111.f168654b;
        if (r113 == null) goto L25;
        String r114 = r111.f168658f;
        if (r114 != null) goto L24;
        int r115 = com.bytedance.android.ec.model.k.f47871n;
        HashMap<Integer, String> r116 = com.bytedance.android.shopping.anchorv4.voavhs.head.c.f168527J;
        if (com.bytedance.android.shopping.anchorv4.voavhs.head.c.a.a(r106) == 1) goto L23;
        r105 = false;
    L23:
        r101.add(com.bytedance.android.ec.model.k.a.a(r113, r105, r111.f168659g, r111.f168655c));
    L46:
        r104 = r104 + 1;
        goto L3
    L24:
        int r107 = com.bytedance.android.ec.model.k.f47871n;
        r101.add(com.bytedance.android.ec.model.k.a.b(r113, r114, r111.f168659g, r111.f168655c));
        goto L46
    L25:
        View r108 = r111.f168653a;
        if (r108 == null) goto L28;
        int r109 = com.bytedance.android.ec.model.k.f47871n;
        String r117 = r111.f168659g;
        com.bytedance.android.ec.model.k r118 = new com.bytedance.android.ec.model.k();
        r118.f47872a = 3;
        r118.f47881j = r108;
        r118.f47883l = r117;
        r101.add(r118);
        goto L46
    L28:
        b r119 = r111.f168656d;
        if (r119 == null) goto L44;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r120 = r119.getPlayInfo();
        int r121 = com.bytedance.android.ec.model.k.f47871n;
        if (r120 == null) goto L33;
        String r122 = r120.e();
    L34:
        if (r120 == null) goto L36;
        String r123 = r120.f();
    L37:
        if (r120 == null) goto L39;
        Integer r124 = r120.l();
    L40:
        if (r120 == null) goto L42;
        r110 = r120.c();
    L42:
        r101.add(com.bytedance.android.ec.model.k.a.d(r122, r123, r124, r110, r111.f168659g));
        goto L46
    L39:
        r124 = null;
        goto L40
    L36:
        r123 = null;
        goto L37
    L33:
        r122 = null;
        goto L34
    L44:
        if (r111.f168660h == false) goto L46;
        int r125 = com.bytedance.android.ec.model.k.f47871n;
        com.bytedance.android.ec.model.k r126 = new com.bytedance.android.ec.model.k();
        r126.f47872a = 9;
        r101.add(r126);
        goto L46
    L8:
        if ((!r101.isEmpty()) == false) goto L14;
        ArrayList r127 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r128 = r101.iterator();
    L11:
        if (r128.hasNext() == false) goto L13;
        r127.add((com.bytedance.android.ec.model.k) r128.next());
        goto L11
    L13:
        r100.add(new h(r103, r127, r112));
    L14:
        r101.clear();
        r103 = r106;
        goto L15
    L47:
        this.f168576d.b(r100);
        ArrayList r129 = new ArrayList();
        Iterator r130 = r100.iterator();
    L49:
        if (r130.hasNext() == false) goto L51;
        r129.addAll(((h) r130.next()).f168667b);
        goto L49
    L51:
        ArrayList r131 = new ArrayList();
        List<Pair<f, String>> r132 = r210;
        ArrayList r133 = new ArrayList();
        Iterator<T> r134 = r132.iterator();
    L53:
        if (r134.hasNext() == false) goto L87;
        Pair r135 = (Pair) r134.next();
        if (((f) r135.getFirst()).f168656d == null) goto L58;
        Integer r136 = 2;
    L83:
        if (r136 == null) goto L85;
        r131.add(Integer.valueOf(((f) r135.getFirst()).f168657e));
    L85:
        if (r136 == null) goto L53;
        r133.add(r136);
        goto L53
    L58:
        if (((f) r135.getFirst()).f168653a == null) goto L61;
        r136 = 4;
        goto L83
    L61:
        if (((f) r135.getFirst()).f168654b == null) goto L80;
        if (com.bytedance.android.shopping.extensions.k.c(((f) r135.getFirst()).f168655c) == false) goto L65;
        this.f168577e = true;
        int r137 = 7;
    L78:
        r136 = Integer.valueOf(r137);
        goto L83
    L65:
        String r138 = ((f) r135.getFirst()).f168658f;
        if (r138 != null) goto L68;
    L71:
        boolean r139 = true;
    L72:
        if (r139 == true) goto L74;
        r137 = 5;
        goto L78
    L74:
        if (((f) r135.getFirst()).f168657e != 0) goto L76;
        r137 = 1;
        goto L78
    L76:
        r137 = 6;
        goto L78
    L68:
        if (r138.length() == 0) goto L71;
        r139 = false;
        goto L72
    L80:
        if (((f) r135.getFirst()).f168660h == false) goto L82;
        r136 = 8;
        goto L83
    L82:
        r136 = null;
        goto L83
    L87:
        GalleryAdapter r140 = this.f176146c;
        if (r140 == null) goto L116;
        ((AnchorV4GalleryCompatAdapter) r140).B2(r133, r131);
        GalleryAdapter r141 = this.f176146c;
        if (r141 == null) goto L114;
        Function0<Unit> r142 = new AnchorV4GalleryViewerCompat$setMediaGroup$1(this);
        Intrinsics.checkNotNullParameter(r142, "listener");
        ((AnchorV4GalleryCompatAdapter) r141).f168563k = r142;
        ArrayList r143 = new ArrayList();
        Iterator<T> r144 = r132.iterator();
    L93:
        if (r144.hasNext() == false) goto L97;
        b r145 = ((f) ((Pair) r144.next()).getFirst()).f168656d;
        if (r145 == null) goto L93;
        r143.add(r145);
        goto L93
    L97:
        GalleryAdapter r146 = this.f176146c;
        if (r146 == null) goto L112;
        ((AnchorV4GalleryCompatAdapter) r146).D2(r143);
        ArrayList r147 = new ArrayList();
        Iterator<T> r148 = r132.iterator();
    L101:
        if (r148.hasNext() == false) goto L105;
        View r149 = ((f) ((Pair) r148.next()).getFirst()).f168653a;
        if (r149 == null) goto L101;
        r147.add(r149);
        goto L101
    L105:
        GalleryAdapter r150 = this.f176146c;
        if (r150 == null) goto L110;
        ((AnchorV4GalleryCompatAdapter) r150).C2(r147);
        a(r129, false);
        this.f176146c.f176134a = 1;
        return;
    L110:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4GalleryCompatAdapter");
    L112:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4GalleryCompatAdapter");
    L114:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4GalleryCompatAdapter");
    L116:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4GalleryCompatAdapter");
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.PhotoViewerDialog
    public final void onPageSelected(int r100) {
        if (this.f168577e == false) goto L9;
        GalleryAdapter r101 = this.f176146c;
        if (r101 == null) goto L8;
        Pair<Integer, Integer> r102 = ((AnchorV4GalleryCompatAdapter) r101).E2(r100);
        this.f176144a.setCurrentPos(r102.getFirst().intValue());
        this.f176144a.setCount(r102.getSecond().intValue());
    L10:
        this.f168578f = r100;
        this.f168576d.c(r100);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4GalleryCompatAdapter");
    L9:
        super.onPageSelected(r100);
        goto L10
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryViewer, com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionEnd(int r100) {
        if (r100 != 0) goto L6;
        this.f168576d.a(getRootContainer());
        onPageSelected(getCurrentPosition());
        this.f168576d.c(this.f168578f);
        return;
    }

    public AnchorV4GalleryViewerCompat(Context r100, r r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "galleryLog");
        super(r100, new AnchorV4GalleryCompatAdapter(r101));
        e r102 = new e();
        this.f168576d = r102;
        r102.f168637b = new c(this);
        r102.f168638c = new d(this);
    }
}
