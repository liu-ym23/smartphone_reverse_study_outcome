package com.bytedance.android.livesdk.chatroom.replay.element;

import android.animation.AnimatorSet;
import com.bytedance.android.uicomponent.popover.PopLayout;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayPlayerViewLockGuideWidget f108567a;

    public q(ReplayPlayerViewLockGuideWidget r100) {
        this.f108567a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        ReplayPlayerViewLockGuideWidget r102 = this.f108567a;
        int r103 = ReplayPlayerViewLockGuideWidget.f108452g;
        PopLayout r104 = (PopLayout) r102.f108453a.getValue();
        r104.post(new o(r104, false, new AnimatorSet()));
        Disposable r105 = this.f108567a.f108456d;
        if (r105 == null) goto L6;
        r105.dispose();
        return;
    }
}
