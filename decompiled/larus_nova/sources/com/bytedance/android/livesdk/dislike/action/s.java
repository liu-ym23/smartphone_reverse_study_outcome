package com.bytedance.android.livesdk.dislike.action;

import com.bytedance.android.livesdk.dislike.NotificationSettingBottomDialog;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f122094a;

    public s(t r100) {
        this.f122094a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        NotificationSettingBottomDialog.b r102 = this.f122094a.f122097g;
        if (r102 == null) goto L6;
        r102.onFailure();
        return;
    }
}
