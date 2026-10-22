package com.bytedance.android.window.shop.holder;

import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import com.bytedance.android.window.shop.repository.tab.entity.v;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/window/shop/holder/ShopWindowItemHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ShopWindowGenericHolder<T extends f> extends ShopWindowItemHolder<T> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final QUIManager f187817q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f187818r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f187819s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f187820t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Function1<T, QModel> f187821u;

    public abstract QIPresenter u4(Fragment r100);

    public boolean v4() {
        return ((Boolean) this.f187819s.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final void t4() {
        com.bytedance.android.ec.window.base.utils.quick.f.b(this.f187817q);
        if (v4() == false) goto L16;
        this.f187817q.r(a.class);
        ViewGroup r100 = (ViewGroup) this.itemView.findViewById(R.id.ec_window_lynx_extension_group);
        if (r100 == null) goto L12;
        List<View> r101 = com.bytedance.commerce.base.view.b.a(r100);
        if (r101 == null) goto L12;
        Iterator<T> r102 = r101.iterator();
    L10:
        if (r102.hasNext() == false) goto L12;
        ((View) r102.next()).setVisibility(8);
    L12:
        if (r100 == null) goto L17;
        r100.setPadding(0, 0, 0, 0);
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public void q4(T r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        Unit r101 = (Unit) this.f187818r.getValue();
        if (v4() == false) goto L17;
        Unit r102 = (Unit) this.f187820t.getValue();
        ViewGroup r103 = (ViewGroup) this.itemView.findViewById(R.id.ec_window_lynx_extension_group);
        if (r103 == null) goto L7;
        r103.setVisibility(0);
    L7:
        v r104 = r100.f189552a;
        if (r104 != null) goto L10;
    L14:
        if (r103 == null) goto L16;
        r103.setPadding(0, 0, 0, 0);
    L16:
        this.f187817q.c(a.class, r100.f189552a);
        goto L17
    L10:
        if (r104.e() == true) goto L14;
        if (r103 == null) goto L16;
        r103.setPadding(0, com.bytedance.android.shopping.extensions.b.b(8), 0, 0);
    L17:
        com.bytedance.android.ec.window.base.utils.quick.f.a(this.f187817q, this.f187821u.invoke(r100));
    }

    public /* synthetic */ ShopWindowGenericHolder(Fragment r100, View r101) {
        this(r100, r101, WindowGenericHolderKt.f187851a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShopWindowGenericHolder(final Fragment r100, final View r101, Function1<? super T, ? extends QModel> r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "modelTransformer");
        super(r101);
        this.f187821u = r102;
        this.f187817q = new QUIManager();
        this.f187818r = LazyKt.lazy(new ShopWindowGenericHolder$initMgrOnceHelper$2(this, r101, r100));
        this.f187819s = LazyKt.lazy(new ShopWindowGenericHolder$hasExtensionModule$2(this));
        this.f187820t = LazyKt.lazy(new ShopWindowGenericHolder$initLynxExtensionMgrOnceHelper$2(this, r100));
    }
}
