package com.bytedance.android.ec.store.product.presenter.element.title;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.utils.p1;
import com.bytedance.android.ec.core.utils.s1;
import com.bytedance.android.ec.core.utils.t1;
import com.bytedance.android.ec.core.utils.u1;
import com.bytedance.android.ec.core.utils.x1;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.window.ShopWindowConstDef;
import com.bytedance.android.shopping.store.utils.o;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sm.l;

/* JADX INFO: loaded from: classes44.dex */
public class ECProductCardTitleElementDefaultPresenter extends l<StoreV2ProductItemVO> implements View.OnClickListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Disposable f48344m;

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void c0() {
        Disposable r100 = this.f48344m;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public ECProductCardTitleElementDefaultPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        if (((Boolean) ShopWindowConstDef.f48999a.getValue()).booleanValue() == false) goto L5;
        new ECProductCardTitleElementDefaultPresenter$imageBinder$1(p1.f45668d);
        return;
    L5:
        new ECProductCardTitleElementDefaultPresenter$imageBinder$2(p1.f45668d);
    }

    @Override // sm.l
    public final void e0(StoreV2ProductItemVO r110) {
        if (r110 == null) goto L84;
        a r100 = (a) this;
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        Disposable r101 = r100.f48344m;
        if (r101 == null) goto L7;
        r101.dispose();
    L7:
        String r102 = r110.f48424d;
        TextView r103 = (TextView) r100.Z().b(R.id.store_product_card_title).f();
        boolean r104 = true;
        if (r100.f542549f.c() != LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE) goto L16;
        Integer r105 = r100.f542549f.n();
        if (r105 == null) goto L12;
        int r106 = r105.intValue();
    L13:
        Lazy r107 = ExtensionsKt.f48229a;
        Intrinsics.checkNotNullParameter(r103, "$this$setMaxLinesOpt");
        if (r106 == r103.getMaxLines()) goto L19;
        r103.setMaxLines(r106);
    L19:
        p1 r108 = p1.f45668d;
        Map<String, ? extends List<ECRitTag>> r109 = r110.f48436p;
        float r111 = o.f186937a * 14.0f;
        TextView r112 = (TextView) r100.Z().b(R.id.store_product_card_title).f();
        r108.getClass();
        Intrinsics.checkNotNullParameter("ecom_shop_product_before", "ritTagKey");
        Intrinsics.checkNotNullParameter(r112, CommonCmd.AIDL_PLATFORM_TYPE_TV);
        Disposable r113 = null;
        if (r109 == null) goto L22;
        List<ECRitTag> r114 = r109.get("ecom_shop_product_before");
    L23:
        int r115 = 0;
        if (r114 == null) goto L35;
        ArrayList r116 = new ArrayList();
        Iterator r117 = r114.iterator();
        int r118 = 0;
    L27:
        if (r117.hasNext() == false) goto L36;
        Object r119 = r117.next();
        int r120 = r118 + 1;
        if (r118 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        String r121 = ((ECRitTag) r119).getFirstIconUrl();
        if (r121 == null) goto L34;
        r116.add(r121);
    L34:
        r118 = r120;
    L36:
        if (r116 != null) goto L38;
    L48:
        if (r116 != null) goto L50;
    L53:
        if (r104 == false) goto L55;
        r112.setText(r102);
    L69:
        if (r113 == null) goto L71;
        r100.f48344m = r113;
    L71:
        r103.setOnClickListener(r100);
        return;
    L55:
        r112.setText(r102);
        ArrayList r122 = new ArrayList();
        ArrayList r123 = new ArrayList();
        Iterator r124 = r114.iterator();
    L57:
        if (r124.hasNext() == false) goto L68;
        Object r125 = r124.next();
        int r126 = r115 + 1;
        if (r115 >= 0) goto L61;
        CollectionsKt.throwIndexOverflow();
    L61:
        String r127 = ((ECRitTag) r125).getFirstIconUrl();
        if (r127 == null) goto L64;
        p1.f45668d.getClass();
        Observable r128 = Observable.create(new x1(r127, r115));
    L65:
        if (r128 == null) goto L67;
        r123.add(r128);
    L67:
        r115 = r126;
        goto L57
    L64:
        r128 = null;
        goto L65
    L68:
        r113 = Observable.zip(r123, new s1(r122)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new t1(r122, r102, r111, r112), u1.f45731a);
        goto L69
    L50:
        if (r116.isEmpty() == true) goto L53;
        r104 = false;
        goto L53
    L38:
        if ((!r116.isEmpty()) != true) goto L48;
        ArrayList r129 = new ArrayList();
        Iterator r130 = r116.iterator();
    L41:
        if (r130.hasNext() == false) goto L46;
        Bitmap r131 = p1.f45667c.b((String) r130.next());
        if (r131 == null) goto L41;
        r129.add(r131);
        goto L41
    L46:
        if (r129.size() != r116.size()) goto L55;
        p1.h(r108, r129, r102, 3.0f, r111, r112);
        goto L69
    L35:
        r116 = null;
        goto L36
    L22:
        r114 = null;
        goto L23
    L12:
        r106 = 1;
        goto L13
    L16:
        Lazy r132 = ExtensionsKt.f48229a;
        Intrinsics.checkNotNullParameter(r103, "$this$setMaxLinesOpt");
        if (2 == r103.getMaxLines()) goto L19;
        r103.setMaxLines(2);
        goto L19
    }
}
