package com.bytedance.android.livesdk.widgetdescriptor.delegate;

import android.view.ViewPropertyAnimator;
import com.bytedance.android.live.core.widget.g;
import com.bytedance.android.livesdk.widgetdescriptor.data.FlingViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes11.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v70.a f162359a;

    public b(v70.a r100) {
        this.f162359a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        FlingViewModel.a r101 = (FlingViewModel.a) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f162298a == false) goto L21;
        int r102 = c.f162360a;
        v70.a r103 = this.f162359a;
        boolean r104 = r101.f162300c;
        ViewPropertyAnimator r105 = r103.a();
        if (r104 == false) goto L13;
        r103.setVisibility(0);
        if (r105 == null) goto L15;
        ViewPropertyAnimator r106 = r105.alpha(1.0f);
        if (r106 == null) goto L15;
        r106.setListener(null);
    L15:
        if (r105 == null) goto L37;
        ViewPropertyAnimator r107 = r105.setDuration(200);
        if (r107 == null) goto L38;
        ViewPropertyAnimator r108 = r107.setInterpolator(new g());
        if (r108 == null) goto L39;
        r108.start();
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L13:
        if (r105 == null) goto L15;
        r105.x(0.0f);
        goto L15
    L21:
        int r109 = c.f162360a;
        v70.a r110 = this.f162359a;
        float r111 = r101.f162299b;
        boolean r112 = r101.f162300c;
        ViewPropertyAnimator r113 = r110.a();
        if (r112 == false) goto L27;
        if (r113 == null) goto L29;
        ViewPropertyAnimator r114 = r113.alpha(0.0f);
        if (r114 == null) goto L29;
        r114.setListener(new a(r110));
    L29:
        if (r113 == null) goto L41;
        ViewPropertyAnimator r115 = r113.setDuration(200);
        if (r115 == null) goto L42;
        ViewPropertyAnimator r116 = r115.setInterpolator(new g());
        if (r116 == null) goto L43;
        r116.start();
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L27:
        if (r113 == null) goto L29;
        r113.x(r111);
        goto L29
    }
}
