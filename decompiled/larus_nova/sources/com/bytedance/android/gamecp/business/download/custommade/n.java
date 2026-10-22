package com.bytedance.android.gamecp.business.download.custommade;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Intent;
import com.bytedance.android.gamecp.business.download.custommade.bean.CustomInstallInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewSessionInstaller f52694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CustomInstallInfo f52695b;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f52696a;

        public a(n r100) {
            this.f52696a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if ((r101 instanceof Integer) == true) goto L5;
            r101 = null;
        L5:
            Integer r102 = (Integer) r101;
            if (r102 == null) goto L14;
            int r103 = r102.intValue();
            f r104 = this.f52696a.f52694a.f52623c;
            if (r104 == null) goto L10;
            r104.b(r103);
        L10:
            ConcurrentHashMap<String, Intent> r105 = CustomInstaller.f52577a;
            ls.a r106 = CustomInstaller.f52580d;
            if (r106 == null) goto L15;
            r106.f510488d = r103;
            return;
        L15:
            return;
        }
    }

    public static final class b implements TimeInterpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f52697a = null;

        static {
            f52697a = new b();
        }

        public b() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            return ((float) Math.log10((100 * r100) + 1)) / 2;
        }
    }

    public n(NewSessionInstaller r100, CustomInstallInfo r101) {
        this.f52694a = r100;
        this.f52695b = r101;
    }

    public final void a() {
        NewSessionInstaller r100 = this.f52694a;
        ValueAnimator r101 = ValueAnimator.ofInt(new int[]{0, 950});
        BeforeInstallGuide r102 = this.f52695b.getBeforeInstallGuide();
        if (r102 == null) goto L7;
        Integer r103 = r102.stayDuration;
        if (r103 == null) goto L7;
        int r104 = r103.intValue();
    L8:
        r101.setDuration(((long) r104) * 1000);
        r101.addUpdateListener(new a(this));
        r101.setInterpolator(b.f52697a);
        Unit r105 = Unit.INSTANCE;
        r100.f52624d = r101;
        ValueAnimator r106 = this.f52694a.f52624d;
        if (r106 == null) goto L12;
        r106.start();
        return;
    L12:
        return;
    L7:
        r104 = 20;
        goto L8
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
