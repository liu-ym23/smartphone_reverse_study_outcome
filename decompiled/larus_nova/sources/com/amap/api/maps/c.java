package com.amap.api.maps;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AMap.OnMapSnapshotListener f28629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AMap.c f28630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Runnable f28631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AMap f28632d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f28633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f28634b;

        /* JADX INFO: renamed from: com.amap.api.maps.c$a$a, reason: collision with other inner class name */
        public class C0513a implements AMap.OnMapScreenShotListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f28635a;

            @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
            public void onMapScreenShot(Bitmap r100) {
            }

            public C0513a(a r100) {
                this.f28635a = r100;
            }

            @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
            public void onMapScreenShot(Bitmap r110, int r111) {
                a r100 = this.f28635a;
                c r101 = r100.f28634b;
                ViewGroup r102 = r100.f28633a;
                r101.getClass();
                ImageView r103 = new ImageView(r102.getContext());
                r103.setImageBitmap(r110);
                r103.setScaleType(ImageView.ScaleType.CENTER_CROP);
                r103.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                r102.addView(r103);
                ScaleAnimation r104 = new ScaleAnimation(0.2f, 0.2f, 0.2f, 0.2f);
                TranslateAnimation r105 = new TranslateAnimation((float) (((double) r102.getWidth()) * 0.05d), -((float) (((double) r102.getWidth()) * 0.5d)), (float) (((double) r102.getHeight()) * 0.75d), (float) (((double) r102.getHeight()) * 0.75d));
                AnimationSet r106 = new AnimationSet(true);
                r106.addAnimation(r104);
                r106.addAnimation(r105);
                r106.setStartOffset(1500);
                r106.setDuration(200);
                r106.setFillBefore(true);
                r106.setFillAfter(true);
                r106.setInterpolator(new AccelerateInterpolator());
                r102.startAnimation(r106);
                r106.setAnimationListener(new b(r101, r102));
                c r107 = this.f28635a.f28634b;
                r107.f28629a.onMapTile(r107.f28630b.b(), r110, r111);
                if (this.f28635a.f28634b.f28630b.e() == false) goto L5;
                c r112 = this.f28635a.f28634b;
                AMap r113 = r112.f28632d;
                AMap.c r108 = r112.f28630b;
                AMap.OnMapSnapshotListener r109 = r112.f28629a;
                Runnable r114 = r112.f28631c;
                r113.getClass();
                c r115 = new c(r113, r109, r108, r114);
                r113.animateCamera(r108.a(), new d(r113, r115, r114));
                return;
            L5:
                this.f28635a.f28634b.f28631c.run();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com_amap_api_maps_c$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_amap_api_maps_c$a__run$___twin___() {
            AMap.a(this.f28634b.f28632d).getMapScreenShot(new C0513a(this), this.f28634b.f28630b.d());
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_amap_api_maps_c$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_amap_api_maps_c$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c r100, ViewGroup r101) {
            this.f28634b = r100;
            this.f28633a = r101;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com_amap_api_maps_c_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_amap_api_maps_c__run$___twin___() {
        if ((AMap.a(this.f28632d) instanceof com.amap.api.mapcore.util.b) == false) goto L5;
        ViewGroup r100 = (ViewGroup) ((com.amap.api.mapcore.util.b) AMap.a(this.f28632d)).getGLMapView().getParent();
        FrameLayout r101 = new FrameLayout(r100.getContext());
        r101.setBackgroundColor(-1);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        int r102 = r100.getWidth() / 20;
        r101.setPadding(r102, r102, r102, r102);
        r100.addView(r101);
    L6:
        a r103 = new a(this, r101);
        ViewGroup r104 = (ViewGroup) r101.getParent();
        ScaleAnimation r105 = new ScaleAnimation(1.0f, 0.2f, 1.0f, 0.2f);
        TranslateAnimation r106 = new TranslateAnimation(0.0f, (float) (((double) r104.getWidth()) * 0.05d), 0.0f, (float) (((double) r104.getHeight()) * 0.75d));
        AnimationSet r107 = new AnimationSet(true);
        r107.addAnimation(r105);
        r107.addAnimation(r106);
        r107.setDuration(600);
        r107.setFillAfter(true);
        r107.setInterpolator(new DecelerateInterpolator());
        r101.startAnimation(r107);
        r107.setAnimationListener(new com.amap.api.maps.a(this, r103));
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_amap_api_maps_c_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
        r100.com_amap_api_maps_c__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(AMap r100, AMap.OnMapSnapshotListener r101, AMap.c r102, Runnable r103) {
        this.f28632d = r100;
        this.f28629a = r101;
        this.f28630b = r102;
        this.f28631c = r103;
    }
}
