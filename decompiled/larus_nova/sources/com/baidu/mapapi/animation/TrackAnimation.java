package com.baidu.mapapi.animation;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayUtil;
import com.baidu.mapapi.map.TrackAnimationUpdateListener;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.animation.BmAccelerateDecelerateInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmAccelerateInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;
import com.baidu.platform.comapi.bmsdk.animation.BmAnticipateInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmAnticipateOvershootInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmBounceInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmCycleInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmDecelerateInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmLinearInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmOvershootInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmTrackAnimation;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class TrackAnimation extends Animation {

    public class a implements BmTrackAnimation.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TrackAnimation f30533a;

        public a(TrackAnimation r100) {
            this.f30533a = r100;
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmTrackAnimation.a
        public void a(com.baidu.platform.comapi.bmsdk.b r100, float r101, float r102) {
            if (((BmTrackAnimation) this.f30533a.bmAnimation).trackAnimationUpdateListener == null) goto L6;
            GeoPoint r103 = new GeoPoint(r100.f32818b, r100.f32817a);
            ((BmTrackAnimation) this.f30533a.bmAnimation).trackAnimationUpdateListener.onTrackUpdate(CoordUtil.mc2ll(r103), r101, r102);
            return;
        }
    }

    public class b implements BmAnimation.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TrackAnimation f30534a;

        public b(TrackAnimation r100) {
            this.f30534a = r100;
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmAnimation.a
        public void a(BmAnimation r100) {
            if (r100 == null) goto L7;
            Animation.AnimationListener r101 = r100.animationListener;
            if (r101 == null) goto L8;
            r101.onAnimationStart();
            return;
        L8:
            return;
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmAnimation.a
        public void b(BmAnimation r100) {
            if (r100 == null) goto L7;
            Animation.AnimationListener r101 = r100.animationListener;
            if (r101 == null) goto L8;
            r101.onAnimationEnd();
            return;
        L8:
            return;
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmAnimation.a
        public void c(BmAnimation r100) {
            if (r100 == null) goto L7;
            Animation.AnimationListener r101 = r100.animationListener;
            if (r101 == null) goto L8;
            r101.onAnimationRepeat();
            return;
        L8:
            return;
        }
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void cancel() {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.bmAnimation.cancel();
        return;
    }

    public TrackAnimation(List<LatLng> r100) {
        if (r100 == null) goto L17;
        if (r100.isEmpty() == true) goto L17;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L15;
        this.bmAnimation = new BmTrackAnimation();
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L10:
        if (r102 >= r100.size()) goto L12;
        GeoPoint r103 = CoordUtil.ll2mc((LatLng) ListProtector.get(r100, r102));
        r101.add(new com.baidu.platform.comapi.bmsdk.b(r103.getLongitudeE6(), r103.getLatitudeE6()));
        r102 = r102 + 1;
        goto L10
    L12:
        BmGeoElement r104 = new BmGeoElement();
        r104.a(r101);
        ((BmTrackAnimation) this.bmAnimation).setTrackPath(r104);
        return;
    L15:
        throw new NullPointerException("BDMapSDKException: TrackAnimation must be used in Overlay2.0");
    L17:
        throw new NullPointerException("BDMapSDKException: the trackPath is null");
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setAnimationListener(Animation.AnimationListener r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmAnimation r101 = this.bmAnimation;
        if (r101 != null) goto L7;
        return;
    L7:
        r101.setAnimationListener(r100);
        this.bmAnimation.setAnimationListener(new b(this));
        return;
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setDuration(long r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.bmAnimation.setDuration(r100);
        return;
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setInterpolator(Interpolator r100) {
        if (OverlayUtil.isOverlayUpgrade() == true) goto L5;
        return;
    L5:
        if ((r100 instanceof LinearInterpolator) == false) goto L8;
        com.baidu.platform.comapi.bmsdk.animation.a r101 = new BmLinearInterpolator();
    L32:
        if (r101 == null) goto L36;
        this.bmAnimation.setInterpolator(r101);
        return;
    L36:
        return;
    L8:
        if ((r100 instanceof CycleInterpolator) == false) goto L11;
        r101 = new BmCycleInterpolator();
        goto L32
    L11:
        if ((r100 instanceof BounceInterpolator) == false) goto L14;
        r101 = new BmBounceInterpolator();
        goto L32
    L14:
        if ((r100 instanceof DecelerateInterpolator) == false) goto L17;
        r101 = new BmDecelerateInterpolator();
        goto L32
    L17:
        if ((r100 instanceof OvershootInterpolator) == false) goto L20;
        r101 = new BmOvershootInterpolator();
        goto L32
    L20:
        if ((r100 instanceof AccelerateInterpolator) == false) goto L23;
        r101 = new BmAccelerateInterpolator();
        goto L32
    L23:
        if ((r100 instanceof AccelerateDecelerateInterpolator) == false) goto L26;
        r101 = new BmAccelerateDecelerateInterpolator();
        goto L32
    L26:
        if ((r100 instanceof AnticipateInterpolator) == false) goto L29;
        r101 = new BmAnticipateInterpolator();
        goto L32
    L29:
        if ((r100 instanceof AnticipateOvershootInterpolator) == false) goto L31;
        r101 = new BmAnticipateOvershootInterpolator();
        goto L32
    L31:
        r101 = null;
        goto L32
    }

    public void setRepeatDelay(long r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmAnimation r101 = this.bmAnimation;
        if (r101 != null) goto L7;
        return;
    L7:
        r101.setRepeatDelay(r100);
        return;
    }

    public void setStartDelay(long r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmAnimation r101 = this.bmAnimation;
        if (r101 != null) goto L7;
        return;
    L7:
        r101.setStartDelay(r100);
        return;
    }

    public void setTrackLine(Overlay r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L8;
        ((BmTrackAnimation) this.bmAnimation).setTrackLine(r100.getDrawItem());
        return;
    }

    public void setTrackPath(List<LatLng> r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L13;
        if (r100 != null) goto L6;
        return;
    L6:
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L8:
        if (r102 >= r100.size()) goto L10;
        GeoPoint r103 = CoordUtil.ll2mc((LatLng) ListProtector.get(r100, r102));
        r101.add(new com.baidu.platform.comapi.bmsdk.b(r103.getLongitudeE6(), r103.getLatitudeE6()));
        r102 = r102 + 1;
        goto L8
    L10:
        BmGeoElement r104 = new BmGeoElement();
        r104.a(r101);
        ((BmTrackAnimation) this.bmAnimation).setTrackPath(r104);
        return;
    }

    public void setTrackPos(LatLng r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        GeoPoint r101 = CoordUtil.ll2mc(r100);
        ((BmTrackAnimation) this.bmAnimation).setTrackPos(new com.baidu.platform.comapi.bmsdk.b(r101.getLongitudeE6(), r101.getLatitudeE6()));
        return;
    }

    public void setTrackPosRadio(float r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        ((BmTrackAnimation) this.bmAnimation).setTrackPosRadio(r100);
        return;
    }

    public void setTrackUpdateListener(TrackAnimationUpdateListener r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        ((BmTrackAnimation) this.bmAnimation).setTrackAnimationUpdateListener(r100);
        ((BmTrackAnimation) this.bmAnimation).setTrackUpdateListener(new a(this));
        return;
    }

    public void setTrackPos(LatLng r100, LatLng r101) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        GeoPoint r102 = CoordUtil.ll2mc(r100);
        GeoPoint r103 = CoordUtil.ll2mc(r101);
        ((BmTrackAnimation) this.bmAnimation).setTrackPos(new com.baidu.platform.comapi.bmsdk.b(r102.getLongitudeE6(), r102.getLatitudeE6()), new com.baidu.platform.comapi.bmsdk.b(r103.getLongitudeE6(), r103.getLatitudeE6()));
        return;
    }

    public void setTrackPosRadio(float r100, float r101) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        ((BmTrackAnimation) this.bmAnimation).setTrackPosRadio(r100, r101);
        return;
    }
}
