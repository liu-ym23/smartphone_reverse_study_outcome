package com.bytedance.android.livesdk.feedback.view.preview;

import android.animation.ObjectAnimator;
import com.bytedance.android.live.core.widget.HSImageView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class q<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f125046a;

    public q(n r100) {
        this.f125046a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if ((!Intrinsics.areEqual((Boolean) r100, Boolean.TRUE)) == true) goto L7;
        HSImageView r101 = this.f125046a.f125038c;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, "alpha", new float[]{1.0f, 0.0f});
        r102.setDuration(200);
        r102.addListener(new p(r101));
        r102.start();
        return;
    }
}
