package com.android.ttcjpaysdk.base.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ProgressBar;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/CJPayNewLoadingWrapper;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "loadingView", "Landroid/widget/ProgressBar;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayNewLoadingWrapper {
    private final ProgressBar loadingView;

    public CJPayNewLoadingWrapper(View r100) {
        Drawable r101 = null;
        if (r100 == null) goto L5;
        ProgressBar r102 = (ProgressBar) r100.findViewById(R.id.cj_pay_loading_view);
    L6:
        this.loadingView = r102;
        boolean r103 = CJPaySettingsManager.getInstance().getBrandPromotion().show_new_loading;
        if (r102 == null) goto L12;
        Drawable r104 = r102.getIndeterminateDrawable();
        if (r104 == null) goto L12;
        Rect r105 = r104.getBounds();
        if (r105 == null) goto L12;
    L13:
        if (r102 == null) goto L30;
        if (r103 == false) goto L22;
        if (r100 == null) goto L28;
        Context r106 = r100.getContext();
        if (r106 == null) goto L28;
        Resources r107 = r106.getResources();
        if (r107 == null) goto L28;
        Drawable r108 = r107.getDrawable(R.drawable.cj_pay_gif_loading_animal);
    L29:
        r102.setIndeterminateDrawable(r108);
    L28:
        r108 = null;
        goto L29
    L22:
        if (r100 == null) goto L28;
        Context r109 = r100.getContext();
        if (r109 == null) goto L28;
        Resources r110 = r109.getResources();
        if (r110 == null) goto L28;
        r108 = r110.getDrawable(R.drawable.cj_pay_bg_loading_circle);
    L30:
        if (r102 == null) goto L32;
        r101 = r102.getIndeterminateDrawable();
    L32:
        if (r101 == null) goto L35;
        r101.setBounds(r105);
    L35:
        if (r102 == null) goto L38;
        r102.setVisibility(4);
    L38:
        if (r102 == null) goto L41;
        r102.setVisibility(0);
    L41:
        if (r100 == null) goto L44;
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r100, AnonymousClass1.INSTANCE);
        return;
    L44:
        return;
    L12:
        r105 = new Rect();
        goto L13
    L5:
        r102 = null;
        goto L6
    }
}
