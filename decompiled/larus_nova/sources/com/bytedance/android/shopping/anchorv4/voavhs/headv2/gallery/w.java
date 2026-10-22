package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.bytedance.android.shopping.anchorv4.widgets.EdgeGradientFrameLayout;
import kotlin.Unit;

/* JADX INFO: loaded from: classes13.dex */
public final class w<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f169447a;

    public w(t r100) {
        this.f169447a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        EdgeGradientFrameLayout r102 = this.f169447a.f169393a;
        if (r102 == null) goto L12;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        r103 = null;
    L7:
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
        if (r104 != null) goto L10;
        r104 = new ViewGroup.MarginLayoutParams(-2, -2);
    L10:
        r104.bottomMargin = r101.intValue();
        Unit r105 = Unit.INSTANCE;
        r102.setLayoutParams(r104);
        return;
    }
}
