package com.bytedance.android.shopping.anchorv4.video.p007float;

import android.view.View;
import com.bytedance.android.shopping.extensions.b;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
public final class k implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f167626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f167627b;

    public k(View r100, Function1 r101) {
        this.f167626a = r100;
        this.f167627b = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        this.f167627b.invoke(Integer.valueOf(this.f167626a.getBottom() + b.a(2)));
    }
}
