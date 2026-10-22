package com.bytedance.android.live.room.navi.userinfo_p.flipper.core;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements w91.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f100039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w91.f f100040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseTabFlipper f100041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w91.f f100042d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f100043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f100044b;

        public a(View r100, d r101) {
            this.f100043a = r100;
            this.f100044b = r101;
        }

        public final void a() {
            View r100 = this.f100043a;
            WeakReference<View> r101 = this.f100044b.f100041c.getDisplayView();
            if (r101 == null) goto L5;
            View r102 = r101.get();
        L6:
            boolean r103 = !Intrinsics.areEqual(r100, r102);
            int r104 = BaseTabFlipper.f100014l;
            ALogger.d("BaseTabFlipper", "remove view onExitEnd.the view index:" + this.f100044b.f100041c.indexOfChild(this.f100043a) + "， should release:" + r103);
            if (r103 == false) goto L10;
            BaseTabFlipper r105 = this.f100044b.f100041c;
            View r106 = this.f100043a;
            r105.getClass();
            Intrinsics.checkNotNullParameter(r106, "view");
            r105.k(r106);
            r106.clearAnimation();
            r105.removeViewInLayout(r106);
            return;
        L10:
            return;
        L5:
            r102 = null;
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

    @Override // w91.c.a
    public final void b() {
    }

    @Override // w91.c.a
    public final void a() {
        this.f100041c.e(this.f100040b, this.f100039a);
    }

    @Override // w91.c.a
    public final void c() {
        w91.f r100 = this.f100042d;
        if (r100 == null) goto L8;
        View r101 = r100.a();
        if (r101 == null) goto L9;
        this.f100041c.post(new a(r101, this));
        return;
    L9:
        return;
    }

    @Override // w91.c.a
    public final void d() {
        this.f100041c.setDisplayView(new WeakReference(this.f100039a));
    }

    public d(View r100, w91.f r101, BaseTabFlipper r102, w91.f r103, w91.b r104) {
        this.f100039a = r100;
        this.f100040b = r101;
        this.f100041c = r102;
        this.f100042d = r103;
    }
}
