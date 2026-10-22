package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.View;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMvMidiWidget f145790a;

    public e0(KtvMvMidiWidget r100) {
        this.f145790a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if ((!Intrinsics.areEqual((Boolean) r100, Boolean.TRUE)) == false) goto L17;
        Object r101 = this.f145790a.f145636d;
        if ((r101 instanceof View) == true) goto L7;
        r101 = null;
    L7:
        View r102 = (View) r101;
        if (r102 == null) goto L10;
        r102.setVisibility(8);
    L10:
        View r103 = this.f145790a.f145642j;
        if (r103 == null) goto L13;
        r103.setBackgroundColor(0);
    L13:
        View r104 = this.f145790a.f145642j;
        if (r104 == null) goto L18;
        r104.setVisibility(8);
        return;
    L18:
        return;
    }
}
