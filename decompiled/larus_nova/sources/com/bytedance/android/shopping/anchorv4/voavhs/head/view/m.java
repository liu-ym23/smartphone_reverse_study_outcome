package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.view.ViewGroup;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: classes13.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4SizeView f168949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f168950b;

    public m(AnchorV4SizeView r100, float r101) {
        this.f168949a = r100;
        this.f168950b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SimpleDraweeView r100 = this.f168949a.f168895a;     // Catch: Throwable -> L4
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();     // Catch: Throwable -> L4
        float r102 = this.f168950b;     // Catch: Throwable -> L4
        r101.width = (int) r102;     // Catch: Throwable -> L4
        r101.height = (int) (this.f168949a.f168897c * r102);     // Catch: Throwable -> L4
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L4
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
