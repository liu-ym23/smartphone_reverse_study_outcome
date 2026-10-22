package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class n5<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ToolbarTransformWidgetBehavior f117314a;

    public n5(ToolbarTransformWidgetBehavior r100) {
        this.f117314a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        ToolbarTransformWidgetBehavior.b(this.f117314a);
    }
}
