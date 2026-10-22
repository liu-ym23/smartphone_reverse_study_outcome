package com.bytedance.android.shopping.anchorv4.video.p007float;

import android.view.View;
import com.bytedance.android.shopping.extensions.b;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
public final class j implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f167624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f167625b;

    public j(Function1 r100, View r101) {
        this.f167624a = r100;
        this.f167625b = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        this.f167624a.invoke(Integer.valueOf(this.f167625b.getBottom() + b.a(2)));
    }
}
