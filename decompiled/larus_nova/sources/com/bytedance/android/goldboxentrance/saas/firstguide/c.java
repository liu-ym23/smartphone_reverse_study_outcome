package com.bytedance.android.goldboxentrance.saas.firstguide;

import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewBoxGuider f58156a;

    public c(NewBoxGuider r100) {
        this.f58156a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Disposable r102 = this.f58156a.f58146i;
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        LottieAnimationView r103 = this.f58156a.f58141d;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.isAnimating() == true) goto L11;
        r103 = null;
    L11:
        if (r103 == null) goto L15;
        r103.cancelAnimation();
        UIUtils.setViewVisibility(r103, 8);
        NewBoxGuider r104 = this.f58156a;
        UIUtils.setViewVisibility(r104.f58138a, 8);
        r104.f58151n.removeView(r104.f58138a);
        this.f58156a.f58147j = false;
        return;
    }
}
