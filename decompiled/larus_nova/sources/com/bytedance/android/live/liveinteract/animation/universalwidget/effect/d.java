package com.bytedance.android.live.liveinteract.animation.universalwidget.effect;

import android.view.SurfaceView;
import android.view.View;
import androidx.lifecycle.Observer;
import ca0.i;
import com.bytedance.ies.sdk.widgets.KVData;
import kotlin.Pair;
import uf2.d0;

/* JADX INFO: loaded from: classes46.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f71358a;

    public d(a r100) {
        this.f71358a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        Pair<Integer, Integer> r102 = this.f71358a.d();
        vc0.a r103 = this.f71358a.a();
        View r104 = null;
        if (r103 == null) goto L5;
        Object r105 = r103.f554080b;
    L7:
        if ((r105 instanceof d0) == true) goto L9;
        r105 = null;
    L9:
        d0 r106 = (d0) r105;
        if (r106 == null) goto L12;
        View r107 = r106.Y();
    L14:
        if ((r107 instanceof SurfaceView) == false) goto L17;
        r104 = r107;
    L17:
        SurfaceView r108 = (SurfaceView) r104;
        i r109 = this.f71358a.f71341e;
        if (r109 == null) goto L27;
        if (r108 == null) goto L21;
        int r110 = r108.getMeasuredWidth();
    L22:
        if (r108 == null) goto L24;
        int r111 = r108.getMeasuredHeight();
    L25:
        r109.k(r110, r111, true);
        return;
    L24:
        r111 = r102.getSecond().intValue();
        goto L25
    L21:
        r110 = r102.getFirst().intValue();
        goto L22
    L27:
        return;
    L12:
        r107 = null;
        goto L14
    L5:
        r105 = null;
        goto L7
    }
}
