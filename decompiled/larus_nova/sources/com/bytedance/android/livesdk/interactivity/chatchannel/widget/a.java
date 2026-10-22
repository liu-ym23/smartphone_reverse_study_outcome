package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.widget.HSImageView;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements yo2.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f134548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f134549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f134550c;

    public a(HSImageView r100, Map r101, View r102) {
        this.f134548a = r100;
        this.f134549b = r101;
        this.f134550c = r102;
    }

    @Override // yo2.e.a
    public final void a(View r100, yo2.e r101) {
        View r102 = this.f134548a.getRootView();
        if ((r102 instanceof ViewGroup) == true) goto L5;
        r102 = null;
    L5:
        ViewGroup r103 = (ViewGroup) r102;
        if (r103 == null) goto L19;
        int r104 = r103.getChildCount();
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L14;
        View r106 = r103.getChildAt(r105);
        if (r106 == null) goto L13;
        this.f134549b.put(r106, Integer.valueOf(r106.getImportantForAccessibility()));
        r106.setImportantForAccessibility(4);
    L13:
        r105 = r105 + 1;
        goto L8
    L14:
        r103.addView(this.f134550c, new ViewGroup.LayoutParams(-1, -1));
        return;
    }
}
