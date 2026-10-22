package com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right;

import android.view.View;
import android.view.animation.ScaleAnimation;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdk.config.qy0;
import com.bytedance.android.livesdk.widget.VisibilityFrameLayout;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScaleAnimation f117655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f117656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f117657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f117658d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f117659a;

        public a(g r100) {
            this.f117659a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f117659a.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void b() {
        View r100 = this.f117656b;
        if (r100 != null) goto L5;
        return;
    L5:
        ScaleAnimation r110 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.0f, 1, 0.8f);
        r110.setDuration(440);
        Unit r101 = Unit.INSTANCE;
        this.f117655a = r110;
        UtilityKotlinExtentionsKt.w(r100);
        r100.startAnimation(this.f117655a);
    }

    public final void a(boolean r100) {
        View r101 = this.f117656b;
        if (r101 != null) goto L5;
        return;
    L5:
        ScaleAnimation r102 = this.f117655a;
        if (r102 == null) goto L8;
        r102.cancel();
    L8:
        if (r100 == false) goto L13;
        this.f117657c.invoke();
        if (qy0.f121092a.getValue().h() == true) goto L12;
        b();
        return;
    L12:
        i0.c().postDelayed(new a(this), 500);
        return;
    L13:
        UtilityKotlinExtentionsKt.w(r101);
        r101.setScaleX(1.0f);
        r101.setScaleY(1.0f);
        r101.setAlpha(1.0f);
        this.f117657c.invoke();
    }

    public g(VisibilityFrameLayout r100, Function0 r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onShow);
        Intrinsics.checkNotNullParameter(r102, "onDismiss");
        this.f117656b = r100;
        this.f117657c = r101;
        this.f117658d = r102;
    }
}
