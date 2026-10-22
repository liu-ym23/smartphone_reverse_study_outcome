package com.bytedance.android.ec.store.common.uiext;

import android.view.View;
import com.bytedance.android.ec.core.widget.flow.FlowLayout;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f48238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f48239b;

    public d(FlowLayout r100, Function1 r101) {
        this.f48238a = r100;
        this.f48239b = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f48238a.removeOnLayoutChangeListener(this);
        this.f48239b.invoke(r100);
    }
}
