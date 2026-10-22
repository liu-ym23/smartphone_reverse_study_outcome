package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes10.dex */
public final class w implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f152492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f152493b;

    public w(Function0 r100, View r101) {
        this.f152492a = r100;
        this.f152493b = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        this.f152492a.invoke();
        this.f152493b.removeOnLayoutChangeListener(this);
    }
}
