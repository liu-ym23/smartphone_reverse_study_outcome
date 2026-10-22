package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.ScrollMoreText;
import com.bytedance.android.shopping.anchorv4.voavhs.head.more.AnchorV4LoadMoreRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class BaseHeadViewHolderBuilder$buildHeadViewHolders$2 extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b f168489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.head.c f168490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f168491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ m f168492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f168493h;

    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.l
    public final void d() {
        i r100 = this.f168489d.u(this.f168492g, Integer.valueOf(this.f168493h));
        if (r100 == null) goto L6;
        this.f168490e.getType();
        r100.a(this.f168490e.f168543p);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.l
    public final void e() {
        b.p(this.f168489d, this.f168490e, this.f168491f);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.a
    public final List<Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, String>> f() {
        if ((!Intrinsics.areEqual(this.f168490e.f168542o, Boolean.FALSE)) == false) goto L10;
        List<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f> r100 = this.f168489d.v(this.f168492g, new BaseHeadViewHolderBuilder$buildHeadViewHolders$2$extractBrowseNodeWithType$browseNode$1(this));
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f r103 = (com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f) r102.next();
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r104 = this.f168490e;
        r101.add(new Pair(com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f.a(r103, r104.f168541n, r104.H), this.f168490e.f168540m));
        goto L6
    L8:
        return r101;
    L10:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.a
    public final p g() {
        String r100 = this.f168490e.getType();
        if (r100 != null) goto L6;
        r100 = HeadViewType.PICTURE.getType();
    L6:
        return new p(r100, this.f168509c);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.a, com.bytedance.android.shopping.anchorv4.vm.h
    public final void b2(boolean r100) {
        AnchorV4LoadMoreRecyclerView r101 = com.bytedance.android.shopping.anchorv4.voavhs.head.more.c.f168804f;
        if (r101 == null) goto L6;
        r101.setScrollState(r100);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.l
    public final View c(LayoutInflater r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutInflater");
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r101 = this.f168490e;
        if (r101.f168547t == null) goto L19;
        List<ECUrlModel> r102 = r101.f168551x;
        boolean r103 = false;
        if (r102 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == false) goto L19;
        com.bytedance.android.shopping.anchorv4.voavhs.head.more.c r105 = new com.bytedance.android.shopping.anchorv4.voavhs.head.more.c(this.f168491f, this.f168489d.f168516g);
        ScrollMoreText r106 = this.f168490e.f168547t;
        d r107 = this.f168489d.f168516g;
        if (r107 == null) goto L20;
        if (r107.n() != true) goto L20;
        r103 = true;
    L20:
        return r105.a(r106, r103);
    L7:
        if (r102.isEmpty() == true) goto L10;
        r104 = false;
    L19:
        return this.f168491f;
    }

    public BaseHeadViewHolderBuilder$buildHeadViewHolders$2(b r100, com.bytedance.android.shopping.anchorv4.voavhs.head.c r101, ViewGroup r102, m r103, int r104, Context r105, int r106) {
        this.f168489d = r100;
        this.f168490e = r101;
        this.f168491f = r102;
        this.f168492g = r103;
        this.f168493h = r104;
        super(r105, r106);
    }
}
