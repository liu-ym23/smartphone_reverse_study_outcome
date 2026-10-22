package com.bytedance.android.live.matchroom;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f82882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f82883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f82884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f82885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f82886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f82887f;

    public h(g r100, View r101, View r102, View r103, boolean r104, boolean r105) {
        this.f82882a = r100;
        this.f82883b = r101;
        this.f82884c = r102;
        this.f82885d = r103;
        this.f82886e = r104;
        this.f82887f = r105;
    }

    public final void a() {
        g r100 = this.f82882a;
        if (this.f82887f == false) goto L5;
        float r101 = 0.0f;
    L6:
        r100.f82878b = r101;
        g r102 = this.f82882a;
        if (this.f82887f == false) goto L9;
        float r103 = 1.0f;
    L10:
        r102.f82879c = r103;
        this.f82883b.setTranslationX(this.f82884c.getTranslationX());
        this.f82883b.setScaleY(this.f82884c.getScaleY());
        this.f82883b.setScaleX(this.f82884c.getScaleX());
        if (this.f82886e == false) goto L14;
        this.f82883b.setOutlineProvider(new o());
        this.f82883b.setClipToOutline(true);
        return;
    L14:
        return;
    L9:
        r103 = this.f82883b.getScaleX();
        goto L10
    L5:
        r101 = this.f82883b.getTranslationX();
        goto L6
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
