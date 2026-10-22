package com.amap.api.maps.model;

import android.graphics.Point;
import android.text.TextUtils;
import com.amap.api.mapcore.util.a9;
import com.amap.api.mapcore.util.v3;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.interfaces.INativeOverlayLayer;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes28.dex */
public final class Marker extends BasePointOverlay {
    private IPoint geoPoint;
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private boolean isClickable;
    private boolean isInfoWindowEnable;
    private boolean isRemoved;
    private boolean isUseAnimation;
    private Animation mCurAnimation;
    private Animation.AnimationListener mCurAnimationListener;
    private b mCurInnerAnimationListener;
    private WeakReference<INativeOverlayLayer> nativeOverlayLayerRef;
    private Object object;
    private MarkerOptions options;
    private LatLng viewModeLatLng;
    private DPoint viewModeLatLngDp;

    public static /* synthetic */ class a {
    }

    public class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a9 f28656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a9 f28657b;

        public class a extends a9 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Animation.AnimationListener f28658b;

            @Override // com.amap.api.mapcore.util.a9
            public void runTask() {
                Animation.AnimationListener r100 = this.f28658b;     // Catch: Throwable -> L6
                if (r100 == null) goto L11;
                r100.onAnimationStart();     // Catch: Throwable -> L6
                return;
            L11:
                return;
            L6:
                th = move-exception;
                th.printStackTrace();
            }

            public a(b r100, Marker r101, Animation.AnimationListener r102) {
                this.f28658b = r102;
            }
        }

        /* JADX INFO: renamed from: com.amap.api.maps.model.Marker$b$b, reason: collision with other inner class name */
        public class C0514b extends a9 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Animation.AnimationListener f28659b;

            @Override // com.amap.api.mapcore.util.a9
            public void runTask() {
                Animation.AnimationListener r100 = this.f28659b;     // Catch: Throwable -> L6
                if (r100 == null) goto L11;
                r100.onAnimationEnd();     // Catch: Throwable -> L6
                return;
            L11:
                return;
            L6:
                th = move-exception;
                th.printStackTrace();
            }

            public C0514b(b r100, Marker r101, Animation.AnimationListener r102) {
                this.f28659b = r102;
            }
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public void onAnimationEnd() {
            v3.b().a(this.f28657b);
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public void onAnimationStart() {
            v3.b().a(this.f28656a);
        }

        private b(Marker r100, Animation.AnimationListener r101) {
            this.f28656a = new a(this, r100, r101);
            this.f28657b = new C0514b(this, r100, r101);
        }

        public /* synthetic */ b(Marker r100, Animation.AnimationListener r101, a r102) {
            this(r100, r101);
        }
    }

    public int getDisplayLevel() {
        return 5;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public LatLng getPosition() {
    L24:
        th = move-exception;
        th.printStackTrace();
    L26:
        return null;
    L4:
        if (this.options == null) goto L26;
        if (isViewMode() == false) goto L17;
        this.glOverlayLayerRef.get().getMap().getPixel2LatLng(this.options.getScreenX(), this.options.getScreenY(), this.viewModeLatLngDp);     // Catch: Throwable -> L24
        LatLng r100 = this.viewModeLatLng;     // Catch: Throwable -> L24
        if (r100 == null) goto L14;
        double r101 = r100.latitude;     // Catch: Throwable -> L24
        DPoint r102 = this.viewModeLatLngDp;     // Catch: Throwable -> L24
        if (r101 != r102.f30022y) goto L14;
        if (r100.longitude != r102.f30021x) goto L14;
        return r100;
    L14:
        DPoint r103 = this.viewModeLatLngDp;     // Catch: Throwable -> L24
        return new LatLng(r103.f30022y, r103.f30021x);
    L17:
        if (this.isUseAnimation == false) goto L23;
        Object r104 = callNativeFunction("getPosition", null);     // Catch: Throwable -> L24
        if (r104 == null) goto L23;
        return (LatLng) r104;
    L23:
        return this.options.getPosition();
    }

    public boolean isInfoWindowAutoOverturn() {
        return false;
    }

    public boolean isPerspective() {
        return false;
    }

    public void setAutoOverturnInfoWindow(boolean r100) {
    }

    public void setDisplayLevel(int r100) {
    }

    public void setFixingPointEnable(boolean r100) {
    }

    public void setPerspective(boolean r100) {
    }

    public void setRotateAngleNotUpdate(float r100) {
    }

    public float getAlpha() {
        if (this.options != null) goto L5;
        return 1.0f;
    L5:
        if (this.isUseAnimation == false) goto L11;
        Object r100 = callNativeFunction("getAlpha", null);
        if (r100 == null) goto L11;
        return ((Double) r100).floatValue();
    L11:
        return this.options.getAlpha();
    }

    public float getAltitude() {
        MarkerOptions r100 = this.options;     // Catch: Exception -> L6
        if (r100 == null) goto L12;
        return r100.getAltitude();
    L12:
        return 0.0f;
    L6:
        e = move-exception;
        e.printStackTrace();
        return 0.0f;
    }

    public float getAnchorU() {
        MarkerOptions r100 = this.options;
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        return r100.getAnchorU();
    }

    public float getAnchorV() {
        MarkerOptions r100 = this.options;
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        return r100.getAnchorV();
    }

    public IPoint getGeoPoint() {
        if (this.geoPoint != null) goto L5;
        this.geoPoint = new IPoint();
    L5:
        LatLng r100 = getPosition();
        if (r100 == null) goto L9;
        VirtualEarthProjection.latLongToPixels(r100.latitude, r100.longitude, 20, this.geoPoint);
    L9:
        return this.geoPoint;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.options.getIcons();
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getId() {
        return this.overlayName;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public MarkerOptions getOptions() {
        MarkerOptions r100 = this.options;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return null;
    }

    public int getPeriod() {
        return this.options.getPeriod();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public float getRotateAngle() {
        if (this.options != null) goto L5;
        return 0.0f;
    L5:
        if (this.isUseAnimation == false) goto L11;
        Object r100 = callNativeFunction("getRotateAngle", null);
        Objects.toString(r100);
        if (r100 == null) goto L11;
        return ((Double) r100).floatValue();
    L11:
        return this.options.getRotateAngle();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getSnippet() {
        MarkerOptions r100 = this.options;     // Catch: Throwable -> L6
        if (r100 == null) goto L12;
        return r100.getSnippet();
    L12:
        return null;
    L6:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getTitle() {
        MarkerOptions r100 = this.options;     // Catch: Throwable -> L6
        if (r100 == null) goto L12;
        return r100.getTitle();
    L12:
        return null;
    L6:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public float getZIndex() {
        MarkerOptions r100 = this.options;
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        return r100.getZIndex();
    }

    public int hashCode() {
        if (this.options == null) goto L11;
        String r100 = this.overlayName;
        if (r100 != null) goto L7;
        int r101 = 0;
    L9:
        return ((r101 + 31) * 31) + this.options.hashCode();
    L7:
        r101 = r100.hashCode();
        goto L9
    L11:
        return super.hashCode();
    }

    public boolean isClickable() {
        Object r100 = callNativeFunction("isClickable", null);
        if ((r100 instanceof Boolean) == false) goto L7;
        return ((Boolean) r100).booleanValue();
    L7:
        return this.isClickable;
    }

    public boolean isDraggable() {
        MarkerOptions r100 = this.options;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isDraggable();
    }

    public boolean isFlat() {
        MarkerOptions r100 = this.options;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isFlat();
    }

    public boolean isIconView() {
        MarkerOptions r100 = this.options;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getIconView() == null) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean isInfoWindowEnable() {
        MarkerOptions r100 = this.options;
        if (r100 == null) goto L7;
        return r100.isInfoWindowEnable();
    L7:
        return this.isInfoWindowEnable;
    }

    public boolean isViewMode() {
        MarkerOptions r100 = this.options;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isViewMode();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean isVisible() {
        MarkerOptions r100 = this.options;     // Catch: Throwable -> L6
        if (r100 == null) goto L12;
        return r100.isVisible();
    L12:
        return false;
    L6:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public void setToTop() {
        IGlOverlayLayer r100 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(this.overlayName) == true) goto L12;
        if (r100 == null) goto L13;
        r100.set2Top(this.overlayName);     // Catch: Throwable -> L7
        return;
    L13:
        return;
    L12:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean startAnimation() {
        Object r100 = callNativeFunction("startAnimation", null);
        if ((r100 instanceof Boolean) == true) goto L5;
        return false;
    L5:
        return ((Boolean) r100).booleanValue();
    }

    private void updateOption() {
        if (isIconView() == false) goto L8;
        INativeOverlayLayer r100 = this.nativeOverlayLayerRef.get();     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(this.overlayName) == true) goto L14;
        if (r100 == null) goto L14;
        r100.updateOverlayOption(this.overlayName, this.options);     // Catch: Throwable -> L13
    L14:
        return;
    L8:
        IGlOverlayLayer r101 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(this.overlayName) == true) goto L14;
        if (r101 == null) goto L14;
        r101.updateOption(this.overlayName, this.options);     // Catch: Throwable -> L13
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void destroy() {
        remove();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void hideInfoWindow() {
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (isIconView() == false) goto L8;
        INativeOverlayLayer r100 = this.nativeOverlayLayerRef.get();     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(this.overlayName) == true) goto L16;
        if (r100 == null) goto L16;
        r100.hideInfoWindow(this.overlayName);     // Catch: Throwable -> L13
    L16:
        return;
    L8:
        IGlOverlayLayer r101 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(this.overlayName) == true) goto L16;
        if (r101 == null) goto L16;
        r101.hideInfoWindow(this.overlayName);     // Catch: Throwable -> L13
        goto L16
    }

    public boolean isInfoWindowShown() {
        if (isIconView() == false) goto L9;
        INativeOverlayLayer r100 = this.nativeOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) == true) goto L16;
        if (r100 != null) goto L8;
        return false;
    L8:
        return r100.isInfoWindowShown(this.overlayName);
    L16:
        return false;
    L9:
        IGlOverlayLayer r101 = this.glOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) == true) goto L19;
        if (r101 == null) goto L20;
        Object r102 = callNativeFunction("isInfoWindowShown", null);
        if ((r102 instanceof Boolean) == true) goto L15;
        return false;
    L15:
        return ((Boolean) r102).booleanValue();
    L20:
        return false;
    L19:
        return false;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void remove() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (isInfoWindowShown() == false) goto L6;
        hideInfoWindow();     // Catch: Throwable -> L15
    L6:
        if (isIconView() == false) goto L10;
        INativeOverlayLayer r100 = this.nativeOverlayLayerRef.get();     // Catch: Throwable -> L15
        if (r100 == null) goto L13;
        r100.removeNativeOverlay(this.overlayName);     // Catch: Throwable -> L15
    L13:
        this.isRemoved = true;     // Catch: Throwable -> L15
        return;
    L10:
        IGlOverlayLayer r101 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L15
        if (r101 == null) goto L13;
        r101.removeOverlay(this.overlayName);     // Catch: Throwable -> L15
        goto L13
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void showInfoWindow() {
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (isIconView() == false) goto L8;
        INativeOverlayLayer r100 = this.nativeOverlayLayerRef.get();     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(this.overlayName) == true) goto L16;
        if (r100 == null) goto L16;
        r100.showInfoWindow(this.overlayName);     // Catch: Throwable -> L13
    L16:
        return;
    L8:
        IGlOverlayLayer r101 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(this.overlayName) == true) goto L16;
        if (r101 == null) goto L16;
        r101.showInfoWindow(this.overlayName);     // Catch: Throwable -> L13
        goto L16
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public Object getObject() {
        return this.object;
    }

    public boolean isRemoved() {
        return this.isRemoved;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L18;
    L17:
        return false;
    L18:
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L17
    L5:
        if ((r100 instanceof Marker) == false) goto L17;
        MarkerOptions r101 = this.options;     // Catch: Throwable -> L15
        if (r101 == null) goto L17;
        if (r101.equals(((Marker) r100).options) == false) goto L20;
        if (this.overlayName.equals(((Marker) r100).overlayName) == false) goto L21;
        return true;
    L21:
        return false;
    L20:
        return false;
    }

    public void setAlpha(float r100) {
        MarkerOptions r101 = this.options;
        if (r101 == null) goto L6;
        r101.alpha(r100);
        updateOption();
        return;
    }

    public void setAltitude(float r100) {
        MarkerOptions r101 = this.options;     // Catch: Exception -> L6
        if (r101 == null) goto L11;
        r101.altitude(r100);     // Catch: Exception -> L6
        updateOption();     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setAnimation(Animation r100) {
        if (r100 != null) goto L17;
    L6:
        this.mCurAnimation = r100;     // Catch: Throwable -> L16
        if (r100 == null) goto L9;
        boolean r101 = true;
    L10:
        this.isUseAnimation = r101;     // Catch: Throwable -> L16
        callNativeFunction("setAnimation", new Object[]{r100});     // Catch: Throwable -> L16
        if (r100 == null) goto L19;
        r100.resetUpdateFlags();     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L19:
        return;
    L9:
        r101 = false;
        goto L10
    L17:
        Animation.AnimationListener r102 = this.mCurAnimationListener;     // Catch: Throwable -> L16
        if (r102 == null) goto L6;
        r100.setAnimationListener(r102);     // Catch: Throwable -> L16
        goto L6
    }

    public void setAnimationListener(Animation.AnimationListener r100) {
        this.mCurAnimationListener = r100;
        b r101 = new b(this, r100, null);
        this.mCurInnerAnimationListener = r101;
        if (this.mCurAnimation == null) goto L6;
        callNativeFunction("setAnimationListener", new Object[]{r101});
        return;
    }

    public void setBelowMaskLayer(boolean r100) {
        MarkerOptions r101 = this.options;
        if (r101 == null) goto L6;
        r101.belowMaskLayer(r100);
        updateOption();
        return;
    }

    public void setClickable(boolean r100) {
        this.isClickable = r100;
        callNativeFunction("setClickable", new Object[]{Boolean.valueOf(r100)});
    }

    public void setDraggable(boolean r100) {
        MarkerOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.draggable(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setFlat(boolean r100) {
        MarkerOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.setFlat(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setGeoPoint(IPoint r100) {
        this.geoPoint = r100;
        if (r100 == null) goto L6;
        DPoint r101 = VirtualEarthProjection.pixelsToLatLong(((Point) r100).x, ((Point) r100).y, 20);
        LatLng r102 = new LatLng(r101.f30022y, r101.f30021x, false);
        r101.recycle();
        this.options.position(r102);
        updateOption();
        return;
    }

    public void setIcon(BitmapDescriptor r100) {
        if (r100 == null) goto L12;
        MarkerOptions r101 = this.options;     // Catch: Throwable -> L7
        if (r101 == null) goto L13;
        r101.icon(r100);     // Catch: Throwable -> L7
        updateOption();     // Catch: Throwable -> L7
        return;
    L13:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void setIcons(ArrayList<BitmapDescriptor> r100) {
        this.options.icons(r100);     // Catch: Throwable -> L4
        updateOption();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setInfoWindowEnable(boolean r100) {
        this.isInfoWindowEnable = r100;
        MarkerOptions r101 = this.options;
        if (r101 == null) goto L6;
        r101.infoWindowEnable(r100);
        updateOption();
        return;
    }

    public void setMarkerOptions(MarkerOptions r100) {
        this.options = r100;
        updateOption();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setObject(Object r100) {
        this.object = r100;
    }

    public void setPeriod(int r100) {
        this.options.period(r100);     // Catch: Throwable -> L4
        updateOption();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setPosition(LatLng r100) {
        MarkerOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.position(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setPositionNotUpdate(LatLng r100) {
        setPosition(r100);
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setRotateAngle(float r100) {
        MarkerOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.rotateAngle(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setSnippet(String r100) {
        MarkerOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.snippet(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setTitle(String r100) {
        MarkerOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.title(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setVisible(boolean r100) {
        MarkerOptions r101 = this.options;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.visible(r100);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setZIndex(float r100) {
        MarkerOptions r101 = this.options;
        if (r101 == null) goto L6;
        r101.zIndex(r100);
        updateOption();
        return;
    }

    private Object callNativeFunction(String r100, Object[] r101) {
        IGlOverlayLayer r102 = this.glOverlayLayerRef.get();     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(this.overlayName) == true) goto L7;
        if (r102 == null) goto L12;
        return r102.getNativeProperties(this.overlayName, r100, r101);
    L12:
        return null;
    L7:
        return null;
    L13:
        return null;
    }

    public void setAnchor(float r100, float r101) {
        MarkerOptions r102 = this.options;     // Catch: Throwable -> L6
        if (r102 == null) goto L11;
        r102.anchor(r100, r101);     // Catch: Throwable -> L6
        updateOption();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void setPositionByPixels(int r100, int r101) {
        MarkerOptions r102 = this.options;
        if (r102 == null) goto L6;
        r102.setScreenPosition(r100, r101);
        updateOption();
        return;
    }

    public Marker(IGlOverlayLayer r100, INativeOverlayLayer r101, MarkerOptions r102, String r103) {
        super(r103);
        this.isRemoved = false;
        this.viewModeLatLngDp = new DPoint();
        this.viewModeLatLng = null;
        this.isUseAnimation = false;
        this.mCurAnimation = null;
        this.mCurAnimationListener = null;
        this.mCurInnerAnimationListener = null;
        this.isClickable = true;
        this.isInfoWindowEnable = true;
        this.glOverlayLayerRef = new WeakReference(r100);
        this.nativeOverlayLayerRef = new WeakReference(r101);
        this.options = r102;
    }
}
