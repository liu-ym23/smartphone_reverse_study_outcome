package com.bytedance.android.livesdk.ktvimpl.feed;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f143918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f143919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f143920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function2 f143921d;

    public d(View r100, View r101, Function0 r102, Function2 r103) {
        this.f143918a = r100;
        this.f143919b = r101;
        this.f143920c = r102;
        this.f143921d = r103;
    }

    public final void a() {
        int r100 = s1.w();
        int r101 = this.f143918a.getHeight();
        int r102 = this.f143918a.getWidth();
        float r103 = r100;
        int r104 = (int) (0.5625f * r103);
        a1.p(this.f143919b, r104);
        a1.k(this.f143919b, r100);
        Function0 r105 = this.f143920c;
        if (r105 == null) goto L5;
        Unit r106 = (Unit) r105.invoke();
    L5:
        float r107 = r101 / r103;
        this.f143919b.setPivotX(0.0f);
        this.f143919b.setPivotY(0.0f);
        this.f143919b.setScaleX(r107);
        this.f143919b.setScaleY(r107);
        float r108 = (r102 - (r104 * r107)) / 2;
        if ((this.f143919b.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        ViewGroup.LayoutParams r109 = this.f143919b.getLayoutParams();
        if (r109 == null) goto L11;
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r109;
        r110.leftMargin = (int) r108;
        this.f143919b.setLayoutParams(r110);
        this.f143919b.requestLayout();
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L12:
        Function2 r111 = this.f143921d;
        if (r111 == null) goto L16;
        Unit r112 = (Unit) r111.invoke(Float.valueOf(r107), Float.valueOf(r107));
        return;
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
