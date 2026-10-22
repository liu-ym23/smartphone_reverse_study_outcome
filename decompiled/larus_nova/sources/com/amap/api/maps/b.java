package com.amap.api.maps;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
class b implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewGroup f28627a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f28628a;

        @Override // java.lang.Runnable
        public void run() {
            com_amap_api_maps_b$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_amap_api_maps_b$a__run$___twin___() {
            ((ViewGroup) this.f28628a.f28627a.getParent()).removeView(this.f28628a.f28627a);
        }

        public a(b r100) {
            this.f28628a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_amap_api_maps_b$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_amap_api_maps_b$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation r100) {
        new Handler(Looper.getMainLooper()).post(new a(this));
    }

    public b(c r100, ViewGroup r101) {
        this.f28627a = r101;
    }
}
