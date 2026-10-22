package com.bytedance.android.window.shop.holder;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.util.k;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import com.bytedance.android.window.shop.repository.tab.entity.n;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowGroupHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Lcom/bytedance/android/window/shop/holder/ShopWindowItemHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/n;", "Lcom/bytedance/android/ec/hybrid/card/api/IECLynxCardLifeCycle;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowGroupHolder<A extends f, B extends f> extends ShopWindowItemHolder<n> implements IECLynxCardLifeCycle {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f187852q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f187853r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ShopWindowItemHolder<A> f187854s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ShopWindowItemHolder<B> f187855t;

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void createViewDuration(long r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onCreateKitViewEnd(long r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onDestroy() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onFirstScreen() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadStart() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadSuccess() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onPreCreateView(boolean r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onRealSuccess() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onReceivedError(com.bytedance.lynx.service.model.b r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onRuntimeReady() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTimingSetup(Map<String, ? extends Object> r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTimingSetupPref(k r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTimingUpdatePref(k r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTransDataTime(long r100, long r101) {
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        if (this.f187854s.s4() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f187855t.s4() == true) goto L8;
        return false;
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final void t4() {
        this.f187854s.t4();
        this.f187855t.t4();
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final void q4(f r100) {
        n r101 = (n) r100;
        Intrinsics.checkNotNullParameter(r101, "vo");
        ShopWindowItemHolder<A> r102 = this.f187854s;
        f r103 = r101.f189605k;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "vo");
        r102.q4(r103);
        ShopWindowItemHolder<B> r104 = this.f187855t;
        f r105 = r101.f189606l;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "vo");
        r104.q4(r105);
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final Rect r4(int r100) {
        ViewGroup.LayoutParams r101 = this.itemView.getLayoutParams();
        if (r101 == null) goto L13;
        int r102 = ((StaggeredGridLayoutManager.LayoutParams) r101).getSpanIndex();
        if (s4() == false) goto L8;
        return new Rect(d.a(12), 0, d.a(12), d.a(8));
    L8:
        if ((r102 % 2) != 1) goto L11;
        return new Rect(d.a(Double.valueOf(4.5d)), 0, d.a(12), d.a(9));
    L11:
        return new Rect(d.a(12), 0, d.a(Double.valueOf(4.5d)), d.a(9));
    L13:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
    }

    public final void u4(WindowLayoutType r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutType");
        ShopWindowItemHolder<A> r101 = this.f187854s;
        ShopWindowItemHolder<B> r102 = null;
        if ((r101 instanceof WindowGroupHolder) == true) goto L5;
        r101 = null;
    L5:
        WindowGroupHolder r103 = (WindowGroupHolder) r101;
        if (r103 == null) goto L8;
        r103.u4(r100);
    L8:
        ShopWindowItemHolder<B> r104 = this.f187855t;
        if ((r104 instanceof WindowGroupHolder) == false) goto L12;
        r102 = r104;
    L12:
        WindowGroupHolder r105 = (WindowGroupHolder) r102;
        if (r105 == null) goto L15;
        r105.u4(r100);
    L15:
        Iterator r106 = ((List) this.f187852q.getValue()).iterator();
    L17:
        if (r106.hasNext() == false) goto L20;
        WindowLynxHolder r107 = (WindowLynxHolder) r106.next();
        r107.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r107.f187877w = r100;
        goto L17
    L20:
        if (((List) this.f187853r.getValue()).isEmpty() == true) goto L66;
        List r108 = (List) this.f187853r.getValue();
        boolean r109 = false;
        if ((r108 instanceof Collection) == true) goto L25;
    L27:
        Iterator r110 = r108.iterator();
    L29:
        if (r110.hasNext() == false) goto L33;
        if (((ShopWindowItemHolder) r110.next()).s4() == false) goto L29;
        boolean r111 = false;
    L34:
        if (r111 == false) goto L39;
        Iterator r112 = ((List) this.f187852q.getValue()).iterator();
    L37:
        if (r112.hasNext() == false) goto L67;
        WindowLynxHolder r113 = (WindowLynxHolder) r112.next();
        WindowLayoutType r114 = WindowLayoutType.DOUBLECOLUMN;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r113.f187877w = r114;
        goto L37
    L67:
        return;
    L39:
        List r115 = (List) this.f187853r.getValue();
        if ((r115 instanceof Collection) == true) goto L42;
    L44:
        Iterator r116 = r115.iterator();
    L46:
        if (r116.hasNext() == false) goto L50;
        if (((ShopWindowItemHolder) r116.next()).s4() == true) goto L46;
    L51:
        if (r109 == false) goto L56;
        Iterator r117 = ((List) this.f187852q.getValue()).iterator();
    L54:
        if (r117.hasNext() == false) goto L68;
        WindowLynxHolder r118 = (WindowLynxHolder) r117.next();
        WindowLayoutType r119 = WindowLayoutType.SINGLECOLUMN;
        r118.getClass();
        Intrinsics.checkNotNullParameter(r119, "<set-?>");
        r118.f187877w = r119;
        goto L54
    L68:
        return;
    L56:
        return;
    L50:
        r109 = true;
        goto L51
    L42:
        if (r115.isEmpty() == false) goto L44;
    L33:
        r111 = true;
        goto L34
    L25:
        if (r108.isEmpty() == false) goto L27;
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void useCache(@IECLynxCardLifeCycle.ECLynxCardCacheType String r100) {
        Intrinsics.checkNotNullParameter(r100, "cache");
        Intrinsics.checkNotNullParameter(r100, "cache");
    }

    public WindowGroupHolder(ShopWindowItemHolder<A> r100, ShopWindowItemHolder<B> r101) {
        Intrinsics.checkNotNullParameter(r100, "firstHolder");
        Intrinsics.checkNotNullParameter(r101, "secondHolder");
        LinearLayout r102 = new LinearLayout(r100.itemView.getContext());
        r102.setOrientation(1);
        r102.addView(r100.itemView);
        r102.addView(new View(r100.itemView.getContext()), 0, d.a(9));
        r102.addView(r101.itemView);
        Unit r103 = Unit.INSTANCE;
        super(r102);
        this.f187854s = r100;
        this.f187855t = r101;
        this.f187852q = LazyKt.lazy(new WindowGroupHolder$lynxHolders$2(this));
        this.f187853r = LazyKt.lazy(new WindowGroupHolder$nativeHolders$2(this));
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadFailed(ECLynxCardErrorType r100, Integer r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r100, "type");
    }
}
