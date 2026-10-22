package com.bytedance.android.shopping.prepurchase.business.pdp.debug;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import cl.d;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.anchorv4.helper.JisooManager;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.component.b;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.m;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vg3.f0;
import vg3.i;
import vg3.o;

/* JADX INFO: loaded from: classes13.dex */
public final class ProductDetailDebugComponent extends m implements i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f181843n = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f181844m;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(f0.class);
    }

    public ProductDetailDebugComponent() {
        this.f181844m = LazyKt.lazy(new ProductDetailDebugComponent$jissoAbility$2(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        d r100 = k.a();
        if (r100 == null) goto L5;
        r100.q();
    L5:
        b.a(this, "initLightLeakTool: customOpt=false");
        boolean r101 = ECServiceManager.f42805a;
        ((IECHostService) ECServiceManager.c(IECHostService.class)).initECLightLeakTool(false);
        AbsComponent.Y1(this, i.class, this, false, 12);
        AbsComponent.Y1(this, o.class, (a) this.f181844m.getValue(), false, 12);
        a r102 = (a) this.f181844m.getValue();
        r102.getClass();
        Disposable r103 = JisooManager.f166873a;
        JisooManager.a(r102.f181845a);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        a r100 = (a) this.f181844m.getValue();
        r100.getClass();
        Disposable r101 = JisooManager.f166873a;
        JisooManager.c(r100.f181845a);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        FrameLayout r102 = new FrameLayout(r100.getContext());
        TextView r103 = new TextView(r100.getContext());
        r103.setText("组件化商详");
        r103.setTextColor(FakePickerAvatarCreator.BLUE);
        r103.setTextSize(5.0f);
        r103.setAlpha(0.2f);
        r102.addView(r103, new FrameLayout.LayoutParams(-2, -2));
        return r102;
    }
}
