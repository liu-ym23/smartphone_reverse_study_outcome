package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv4.voavhs.head.ScrollMoreText;
import com.bytedance.android.shopping.anchorv4.voavhs.head.holder.r;
import com.bytedance.android.shopping.anchorv4.voavhs.head.more.AnchorV4LoadMoreRecyclerView;
import com.bytedance.android.shopping.anchorv4.voavhs.head.view.AnchorV4VideoView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes13.dex */
public final class BaseHeadViewHolderBuilder$buildHeadViewHoldersV2$2 extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b f168494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.head.c f168495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ m f168496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f168497g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f168498h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f168499i;

    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.l
    public final void d() {
        i r100 = this.f168494d.u(this.f168496f, Integer.valueOf(this.f168497g));
        if (r100 == null) goto L6;
        this.f168495e.getType();
        r100.a(this.f168495e.f168543p);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.l
    public final void e() {
        b.p(this.f168494d, this.f168495e, (View) this.f168499i.element);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.a
    public final List<Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, String>> f() {
        if ((!Intrinsics.areEqual(this.f168495e.f168542o, Boolean.FALSE)) == false) goto L5;
    L9:
        List<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f> r100 = this.f168494d.v(this.f168496f, new BaseHeadViewHolderBuilder$buildHeadViewHoldersV2$2$extractBrowseNodeWithType$browseNode$1(this));
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L11:
        if (r102.hasNext() == false) goto L13;
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f r103 = (com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f) r102.next();
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r104 = this.f168495e;
        r101.add(new Pair(com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f.a(r103, r104.f168541n, r104.H), this.f168495e.f168540m));
        goto L11
    L13:
        return r101;
    L5:
        if (this.f168495e.D == true) goto L9;
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.a
    public final p g() {
        String r100 = this.f168495e.getType();
        if (r100 != null) goto L5;
        r100 = HeadViewType.PICTURE.getType();
    L5:
        p r101 = new p(r100, this.f168509c);
        b r102 = this.f168494d;
        PlayerBlock r103 = null;
        if ((r102 instanceof r) == true) goto L9;
        r102 = null;
    L9:
        if (((r) r102) == null) goto L14;
        AnchorV4VideoView r104 = r.A((View) this.f168499i.element);
        if (r104 == null) goto L13;
        r103 = r104.getPlayerBlock();
    L13:
        r101.f168524a = r103;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.a, com.bytedance.android.shopping.anchorv4.vm.h
    public final void b2(boolean r100) {
        AnchorV4LoadMoreRecyclerView r101 = com.bytedance.android.shopping.anchorv4.voavhs.head.more.c.f168804f;
        if (r101 == null) goto L6;
        r101.setScrollState(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5, types: [T, android.view.View, android.view.ViewGroup] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.l
    public final View c(LayoutInflater r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutInflater");
        View r101 = View.inflate(this.f168494d.getContext(), R.layout.ec_commerce_layout_anchor_v4_head_background_view, null);
        if (r101 == null) goto L28;
        ?? r102 = (ViewGroup) r101;
        ECDraweeView r103 = (ECDraweeView) r102.findViewById(R.id.anchor_v4_head_background_image);
        this.f168494d.s(r102, this.f168495e.getType(), this.f168496f, Integer.valueOf(this.f168497g));
        this.f168494d.r(r103, this.f168496f.a(), new BaseHeadViewHolderBuilder$buildHeadViewHoldersV2$2$getView$1(this));
        b r104 = this.f168494d;
        SimpleDraweeView r105 = (SimpleDraweeView) r102.findViewById(R.id.anchor_v4_head_atmosphere_image);
        ECUrlModel r106 = this.f168495e.f168530c;
        r104.getClass();
        b.q(r105, r106);
        View r107 = this.f168494d.x(this.f168496f, Integer.valueOf(this.f168497g), this.f168498h);
        if (r107 == null) goto L7;
        r102.addView(r107, r102.getChildCount());
    L7:
        this.f168494d.t(r102, this.f168495e);
        b r108 = this.f168494d;
        r108.z(r108.getContext(), r102, this.f168496f, this.f168498h);
        this.f168499i.element = r102;
        Function0 r109 = (Function0) CollectionsKt.getOrNull(this.f168494d.f168512c, this.f168498h);
        if (r109 == null) goto L10;
        Unit r110 = (Unit) r109.invoke();
    L10:
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r111 = this.f168495e;
        if (r111.f168547t == null) goto L29;
        List<ECUrlModel> r112 = r111.f168551x;
        boolean r113 = false;
        if (r112 != null) goto L15;
    L18:
        boolean r114 = true;
    L19:
        if (r114 == false) goto L30;
        com.bytedance.android.shopping.anchorv4.voavhs.head.more.c r115 = new com.bytedance.android.shopping.anchorv4.voavhs.head.more.c(r102, this.f168494d.f168516g);
        b r116 = this.f168494d;
        r116.f168514e = r115;
        ScrollMoreText r117 = this.f168495e.f168547t;
        d r118 = r116.f168516g;
        if (r118 == null) goto L26;
        if (r118.n() != true) goto L26;
        r113 = true;
    L26:
        return r115.a(r117, r113);
    L30:
        return r102;
    L15:
        if (r112.isEmpty() == true) goto L18;
        r114 = false;
        goto L19
    L29:
        return r102;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public BaseHeadViewHolderBuilder$buildHeadViewHoldersV2$2(b r100, com.bytedance.android.shopping.anchorv4.voavhs.head.c r101, m r102, int r103, int r104, Ref.ObjectRef r105, Context r106, int r107) {
        this.f168494d = r100;
        this.f168495e = r101;
        this.f168496f = r102;
        this.f168497g = r103;
        this.f168498h = r104;
        this.f168499i = r105;
        super(r106, r107);
    }
}
