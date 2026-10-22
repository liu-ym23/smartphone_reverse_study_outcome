package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.bytedance.android.live.core.widget.HSImageView;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f134598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f134599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f134600c;

    public b(HSImageView r100, View r101, Map r102) {
        this.f134598a = r100;
        this.f134599b = r101;
        this.f134600c = r102;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        View r100 = this.f134598a.getRootView();
        if ((r100 instanceof ViewGroup) == true) goto L5;
        r100 = null;
    L5:
        ViewGroup r101 = (ViewGroup) r100;
        if (r101 == null) goto L22;
        r101.removeView(this.f134599b);
        int r102 = r101.getChildCount();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L16;
        View r104 = r101.getChildAt(r103);
        if (r104 == null) goto L15;
        Integer r105 = (Integer) this.f134600c.get(r104);
        if (r105 == null) goto L15;
        r104.setImportantForAccessibility(r105.intValue());
    L15:
        r103 = r103 + 1;
        goto L8
    L16:
        this.f134600c.clear();
        return;
    }
}
