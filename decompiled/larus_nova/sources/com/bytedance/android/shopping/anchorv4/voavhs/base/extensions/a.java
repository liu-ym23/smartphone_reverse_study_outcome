package com.bytedance.android.shopping.anchorv4.voavhs.base.extensions;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExtensionsKt.a f167883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f167884b;

    public a(ExtensionsKt.a r100, Bitmap r101) {
        this.f167883a = r100;
        this.f167884b = r101;
    }

    public final void a() {
        Drawable r100 = ExtensionsKt.h(this.f167884b, this.f167883a.f167879a.getContext(), this.f167883a.f167880b.getMaskColor());
        if (r100 == null) goto L5;
        this.f167883a.f167879a.setBackground(r100);
    L5:
        ExtensionsKt.f167878a.put(this.f167883a.f167881c, new WeakReference(this.f167884b));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
