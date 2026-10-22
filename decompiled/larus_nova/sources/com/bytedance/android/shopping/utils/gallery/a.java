package com.bytedance.android.shopping.utils.gallery;

import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BannerAdapter f187109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f187110b;

    public a(BannerAdapter r100, View r101) {
        this.f187109a = r100;
        this.f187110b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f187110b;     // Catch: Throwable -> L4
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();     // Catch: Throwable -> L4
        r101.width = this.f187109a.f187094e;     // Catch: Throwable -> L4
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L4
        r100.setLayoutParams(r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
