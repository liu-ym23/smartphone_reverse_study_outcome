package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation;

import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f129936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f129937b;

    public c(b r100, Ref.BooleanRef r101) {
        this.f129936a = r100;
        this.f129937b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    L19:
        return;
    L3:
        if (this.f129937b.element == true) goto L15;
        b r100 = this.f129936a;     // Catch: Throwable -> L12
        HSImageView r101 = r100.f129926c;     // Catch: Throwable -> L12
        if (r101 == null) goto L7;
        r101.setVisibility(8);     // Catch: Throwable -> L12
    L7:
        r100.a(false);     // Catch: Throwable -> L12
        AnimatedDrawable2 r102 = r100.f129924a;     // Catch: Throwable -> L12
        if (r102 == null) goto L10;
        r102.stop();     // Catch: Throwable -> L12
    L10:
        r100.f129924a = null;     // Catch: Throwable -> L12
        return;
    }
}
