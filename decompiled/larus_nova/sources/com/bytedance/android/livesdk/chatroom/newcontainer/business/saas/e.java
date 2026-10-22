package com.bytedance.android.livesdk.chatroom.newcontainer.business.saas;

import android.widget.FrameLayout;
import com.bytedance.android.livesdk.chatroom.widget.SlideGuideView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f107551a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik1.h f107552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ls2.d f107553b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f107554c;

        public a(ik1.h r100, ls2.d r101, FrameLayout r102) {
            this.f107552a = r100;
            this.f107553b = r101;
            this.f107554c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SlideGuideView r100 = this.f107552a.f490259c;     // Catch: Throwable -> L8
            if (((ck1.d) this.f107553b.a(ck1.d.class)).Um() == false) goto L11;
            if (r100 == null) goto L15;
            this.f107554c.removeView(r100);     // Catch: Throwable -> L8
            r100.b();     // Catch: Throwable -> L8
            this.f107552a.f490259c = null;     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    static {
    }

    public static void a(ls2.d r100, ik1.h r101, FrameLayout r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionContext");
        Intrinsics.checkNotNullParameter(r101, "roomSlideContext");
        SlideGuideView r103 = r101.f490259c;
        if (r103 == null) goto L7;
        r103.setClickable(false);
        r103.f();
        if (r102 == null) goto L7;
        r102.postDelayed(new a(r101, r100, r102), 320);
    L7:
        com.bytedance.android.livesdk.e.b().d();
        ((ck1.e) r100.a(ck1.e.class)).Uk(true);
    }
}
