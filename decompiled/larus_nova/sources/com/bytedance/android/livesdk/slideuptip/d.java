package com.bytedance.android.livesdk.slideuptip;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSlideUpTipsGuideStrategy f158404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f158405b;

    public d(LiveSlideUpTipsGuideStrategy r100, String r101) {
        this.f158404a = r100;
        this.f158405b = r101;
    }

    public final void a() {
        a r100 = this.f158404a.f158381o;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L14:
        boolean r102 = false;
    L15:
        if (r102 == true) goto L17;
    L33:
        LiveSlideUpTipsGuideStrategy r103 = this.f158404a;
        String r104 = "delay action not support, " + this.f158404a.f158368b + ", " + this.f158404a.f158369c;
        r103.getClass();
        LiveSlideUpTipsGuideStrategy.b(r104);
        return;
    L17:
        if (k.a(this.f158405b) == false) goto L33;
        LiveSlideUpTipsGuideStrategy r105 = this.f158404a;
        String r106 = "isCanShow: " + this.f158404a.f158382p + ", hasEnter: " + this.f158404a.f158375i + ", hasValidLoad: " + this.f158404a.f158371e + ", isNotChanged:" + this.f158404a.f158376j + ", isLiveGuideWidgetShown:" + this.f158404a.f158380n;
        r105.getClass();
        LiveSlideUpTipsGuideStrategy.b(r106);
        LiveSlideUpTipsGuideStrategy r107 = this.f158404a;
        if (r107.f158376j == true) goto L21;
    L29:
        if (r101 == false) goto L35;
        Function0<Unit> r108 = r107.f158367a;
        if (r108 == null) goto L36;
        Unit r109 = r108.invoke();
        return;
    L36:
        return;
    L35:
        return;
    L21:
        if (r107.f158382p == false) goto L29;
        if (r107.f158375i == false) goto L29;
        if (r107.f158371e == false) goto L29;
        if (r107.f158380n == true) goto L29;
        r101 = true;
        goto L29
    L5:
        if (r100.feedSlideGuide != true) goto L14;
        String r110 = r100.slideGuideText;
        if (r110 == null) goto L14;
        if (r110.length() <= 0) goto L11;
        boolean r111 = true;
    L12:
        if (r111 != true) goto L14;
        r102 = true;
        goto L15
    L11:
        r111 = false;
        goto L12
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
