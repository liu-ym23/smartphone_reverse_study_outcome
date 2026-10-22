package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.extensions.f;
import com.bytedance.android.shopping.store.tabkit.e;
import com.bytedance.android.shopping.store.tabkit.model.o;
import com.bytedance.android.shopping.store.tabkit.model.w;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/BottomTabItemView;", "Lcom/bytedance/android/shopping/store/tabkit/view/ABSTabItemView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BottomTabItemView extends ABSTabItemView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ECUrlModel f186863j;

    public BottomTabItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BottomTabItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public void e(ECUrlModel r100) {
        Intrinsics.checkNotNullParameter(getIconView(), "draweeView");
        if (Intrinsics.areEqual(this.f186863j, r100) == true) goto L7;
        this.f186863j = r100;
        e.h(getIconView(), r100);
        return;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.view.ABSTabItemView, com.bytedance.android.shopping.store.tabkit.view.BaseTabItemView
    public void a(boolean r100, boolean r101) {
        super.a(r100, r101);
        w r102 = getTabStyle();
        if (r102 == null) goto L5;
        String r103 = r102.e();
    L7:
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        getTitleTV().setVisibility(8);
    L16:
        w r105 = getTabStyle();
        if (r105 == null) goto L39;
        o r106 = getTabBarStyle();
        if (r106 == null) goto L25;
        String r107 = r106.e();
        if (r107 == null) goto L25;
        Integer r108 = s.b(r107);
        if (r108 == null) goto L25;
        getTitleTV().setTextColor(r108.intValue());
    L25:
        getTitleTV().setText(r105.e());
        ECUrlModel r109 = r105.a();
        if (r109 != null) goto L28;
        r109 = r105.b();
    L28:
        e(r109);
        o r110 = getTabBarStyle();
        if (r110 == null) goto L33;
        Integer r111 = r110.a();
        if (r111 == null) goto L33;
        getTitleTV().setTextSize(2, r111.intValue());
    L33:
        o r112 = getTabBarStyle();
        if (r112 == null) goto L40;
        Integer r113 = r112.b();
        if (r113 == null) goto L41;
        f.e(getTitleTV(), Integer.valueOf(r113.intValue()));
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L15:
        getTitleTV().setVisibility(0);
        goto L16
    L9:
        if (r103.length() == 0) goto L12;
        r104 = false;
        goto L13
    L5:
        r103 = null;
        goto L7
    }

    public BottomTabItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ECDraweeView.setPlaceholderImage$default(getIconView(), R.drawable.ec_store_ic_tab_placeholder, null, 2, null);
    }

    public /* synthetic */ BottomTabItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
