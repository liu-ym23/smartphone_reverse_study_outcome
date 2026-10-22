package com.bytedance.android.livesdk.interactivity.like;

import android.content.Context;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements h80.a<Throwable>, Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DigAccessibilityWidget f137572a;

    public b(DigAccessibilityWidget r100) {
        this.f137572a = r100;
    }

    @Override // h80.a
    public final void accept(Throwable r100) {
        Throwable r101 = r100;
        Context r102 = this.f137572a.context;
        if (r102 == null) goto L6;
        ExceptionUtils.handleException(r102, r101);
        return;
    }
}
