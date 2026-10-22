package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.animation.ObjectAnimator;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f127854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f127855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ObjectAnimator f127856c;

    public j(i r100, Ref.IntRef r101, ObjectAnimator r102) {
        this.f127854a = r100;
        this.f127855b = r101;
        this.f127856c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Ref.IntRef r102 = this.f127855b;
        int r103 = r102.element + 1;
        r102.element = r103;
        if (r103 <= 2) goto L7;
        Disposable r104 = this.f127854a.f127852r;
        if (r104 == null) goto L9;
        r104.dispose();
        return;
    L9:
        return;
    L7:
        this.f127856c.start();
    }
}
