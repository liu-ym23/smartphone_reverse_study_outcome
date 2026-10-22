package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.larus.nova.R;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vg3.i0;
import vg3.w;

/* JADX INFO: loaded from: classes13.dex */
public final class m extends com.bytedance.android.shopping.prepurchase.business.pdp.components.m {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f181493s = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MoreVideoComponent f181494m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LivingIconComponent f181495n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public BackToTopEntryComponent f181496o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ShopFloatEntryComponent f181497p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public QuestionnaireEntranceComponent f181498q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public AbsComponent<?, ?> f181499r;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{vg3.a.class, w.class, i0.class, vg3.l.class});
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        Z1(vg3.a.class, new NAPendentLayerComponent$tryLoadChildComponent$1(this, null));
    }

    public m() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        com.bytedance.android.shopping.prepurchase.business.pdp.view.k r102 = new com.bytedance.android.shopping.prepurchase.business.pdp.view.k(r100.getContext());
        r102.setId(R.id.na_pendant_container);
        return r102;
    }
}
