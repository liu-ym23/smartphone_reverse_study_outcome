package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.util.AttributeSet;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.utils.h;
import com.bytedance.android.shopping.extensions.f;
import com.bytedance.android.shopping.store.tabkit.model.k;
import com.bytedance.android.shopping.store.tabkit.model.o;
import com.bytedance.android.shopping.store.tabkit.model.w;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import hk3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0014R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/TopTabItemView;", "Lcom/bytedance/android/shopping/store/tabkit/view/ABSTabItemView;", "", "getResourceId", "", ce.f26395j, "Z", "getEnableImageIcon", "()Z", "setEnableImageIcon", "(Z)V", "enableImageIcon", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class TopTabItemView extends ABSTabItemView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f186899j;

    public TopTabItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TopTabItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.store.tabkit.view.ABSTabItemView
    public int getResourceId() {
        return R.layout.ec_tabkit_top_tab_item_view;
    }

    public final boolean getEnableImageIcon() {
        return this.f186899j;
    }

    public final void setEnableImageIcon(boolean r100) {
        this.f186899j = r100;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.view.ABSTabItemView, com.bytedance.android.shopping.store.tabkit.view.BaseTabItemView
    public void a(boolean r100, boolean r101) {
        k r102 = getTab();
        if (r102 == null) goto L5;
        k r103 = r102.f186825a;
    L6:
        boolean r104 = false;
        if (r103 != null) goto L9;
        setEnableBadge(false);
    L9:
        super.a(r100, r101);
        w r105 = getTabStyle();
        if (r105 == null) goto L43;
        o r106 = getTabBarStyle();
        if (r106 == null) goto L18;
        String r107 = r106.e();
        if (r107 == null) goto L18;
        Integer r108 = s.b(r107);
        if (r108 == null) goto L18;
        getTitleTV().setTextColor(r108.intValue());
    L18:
        ECUrlModel r109 = r105.a();
        if (r109 != null) goto L22;
        r109 = r105.b();
    L22:
        if (r109 != null) goto L24;
    L32:
        ExtensionsKt.visible(getTitleTV());
        ExtensionsKt.gone(getIconView());
        getTitleTV().setText(r105.e());
        o r110 = getTabBarStyle();
        if (r110 == null) goto L37;
        Integer r111 = r110.a();
        if (r111 == null) goto L37;
        getTitleTV().setTextSize(1, r111.intValue());
    L37:
        o r112 = getTabBarStyle();
        if (r112 == null) goto L45;
        Integer r113 = r112.b();
        if (r113 == null) goto L46;
        f.e(getTitleTV(), Integer.valueOf(r113.intValue()));
        return;
    L46:
        return;
    L45:
        return;
    L24:
        if (this.f186899j == false) goto L32;
        int r114 = h.f48668a;
        if (e.a() == 0) goto L28;
        r104 = true;
    L28:
        if (r104 == false) goto L30;
        com.bytedance.android.shopping.store.tabkit.e.h(getIconView(), r105.b());
    L31:
        ExtensionsKt.visible(getIconView());
        ExtensionsKt.gone(getTitleTV());
        return;
    L30:
        h0 r115 = h0.f44678a;
        com.bytedance.android.shopping.store.tabkit.e.g(getIconView(), r105.b());
        goto L31
    L43:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public TopTabItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f186899j = true;
        setClipChildren(false);
    }

    public /* synthetic */ TopTabItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
