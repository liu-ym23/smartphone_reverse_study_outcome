package com.bytedance.android.livesdk.ktvimpl.feed;

import android.view.View;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f143922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f143923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f143924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function2 f143925d;

    public g(View r100, Function0 r101, View r102, Function2 r103) {
        this.f143922a = r100;
        this.f143923b = r101;
        this.f143924c = r102;
        this.f143925d = r103;
    }

    public final void a() {
        a1.p(this.f143922a, s1.y());
        a1.k(this.f143922a, (int) (s1.y() * 1.7777778f));
        Function0 r100 = this.f143923b;
        if (r100 == null) goto L6;
        Unit r101 = (Unit) r100.invoke();
    L6:
        if (this.f143924c.getWidth() <= this.f143924c.getHeight()) goto L8;
        float r102 = this.f143924c.getWidth();
        int r103 = s1.w();
    L9:
        float r104 = r102 / r103;
        this.f143922a.setPivotX(0.0f);
        this.f143922a.setPivotY(0.0f);
        this.f143922a.setScaleX(r104);
        this.f143922a.setScaleY(r104);
        if (this.f143924c.getWidth() <= this.f143924c.getHeight()) goto L12;
        this.f143922a.setPivotX(this.f143924c.getWidth() / 2.0f);
    L12:
        Function2 r105 = this.f143925d;
        if (r105 == null) goto L16;
        Unit r106 = (Unit) r105.invoke(Float.valueOf(r104), Float.valueOf(r104));
        return;
    L16:
        return;
    L8:
        r102 = this.f143924c.getWidth();
        r103 = s1.y();
        goto L9
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
