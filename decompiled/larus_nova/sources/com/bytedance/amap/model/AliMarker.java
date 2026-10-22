package com.bytedance.amap.model;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.animation.AlphaAnimation;
import com.amap.api.maps.model.animation.Animation;
import com.amap.api.maps.model.animation.AnimationSet;
import com.amap.api.maps.model.animation.ScaleAnimation;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.IMarker;
import com.bytedance.map.api.monitor.MapMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public class AliMarker implements IMarker {
    private static final String TAG = "AliMarker";
    private String mId;
    private boolean mIsSelected;
    private boolean mIsVisible;
    private Marker mMarker;
    private Point mScreenPoint;

    @Override // com.bytedance.map.api.model.IMarker
    public final /* synthetic */ boolean isCollideWithPoi() {
        return IMarker.CC.$default$isCollideWithPoi(this);
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final /* synthetic */ void setCollideWithPoi(boolean r100) {
        IMarker.CC.$default$setCollideWithPoi(this, r100);
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final /* synthetic */ void updateMarker(Map r100) {
        IMarker.CC.$default$updateMarker(this, r100);
    }

    private Animation getHideAnimation() {
        AnimationSet r100 = new AnimationSet(true);
        r100.setDuration(300);
        AlphaAnimation r101 = new AlphaAnimation(1.0f, 0.5f);
        ScaleAnimation r102 = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f);
        r100.addAnimation(r101);
        r100.addAnimation(r102);
        r100.setFillMode(0);
        return r100;
    }

    private Animation getShowAnimation() {
        AnimationSet r100 = new AnimationSet(true);
        r100.setDuration(300);
        AlphaAnimation r101 = new AlphaAnimation(0.5f, 1.0f);
        ScaleAnimation r102 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f);
        r100.addAnimation(r101);
        r100.addAnimation(r102);
        r100.setFillMode(0);
        return r100;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void destroy() {
        this.mMarker.destroy();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "destroy error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IMarker
    public Object getData() {
        Marker r100 = this.mMarker;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getObject();
    }

    @Override // com.bytedance.map.api.model.IMarker
    public BDLatLng getPosition() {
        LatLng r100 = this.mMarker.getPosition();     // Catch: Exception -> L4
        return new BDLatLng(r100.latitude, r100.longitude);
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "getPosition error:" + e.getMessage());
        return new BDLatLng(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    @Override // com.bytedance.map.api.model.IMarker
    public String getSnippet() {
        return this.mMarker.getSnippet();
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "getTitle error:" + e.getMessage());
        return null;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public String getTitle() {
        return this.mMarker.getTitle();
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "getTitle error:" + e.getMessage());
        return null;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public float getZIndex() {
        Marker r100 = this.mMarker;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getZIndex();
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void hideInfoWindow() {
        this.mMarker.hideInfoWindow();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "hideInfoWindow error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IMarker
    public boolean isDraggable() {
        Marker r100 = this.mMarker;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isDraggable();
    }

    @Override // com.bytedance.map.api.model.IMarker
    public boolean isInfoWindowShown() {
        return this.mMarker.isInfoWindowShown();
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "isInfoWindowShown error:" + e.getMessage());
        return false;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public boolean isVisible() {
        return this.mMarker.isVisible();
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "isVisible error:" + e.getMessage());
        return false;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void remove() {
        this.mMarker.remove();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "remove error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void setToTop() {
        this.mMarker.setToTop();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setToTop error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void showInfoWindow() {
        this.mMarker.showInfoWindow();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "showInfoWindow error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IMarker
    public String getId() {
        return this.mId;
    }

    public Marker getMarker() {
        return this.mMarker;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public Point getScreenPoint() {
        return this.mScreenPoint;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public boolean isSelected() {
        return this.mIsSelected;
    }

    public static /* synthetic */ Marker access$000(AliMarker r100) {
        return r100.mMarker;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public Rect getVisibleRect(Point r100) {
        Rect r101 = new Rect();
        Marker r102 = this.mMarker;
        if (r102 == null) goto L15;
        if (r100 == null) goto L15;
        if (r102.getOptions() == null) goto L15;
        if (this.mMarker.getOptions().getIcon() == null) goto L15;
        Bitmap r103 = this.mMarker.getOptions().getIcon().getBitmap();
        if (r103 != null) goto L14;
        return r101;
    L14:
        float r104 = this.mMarker.getOptions().getAnchorU();
        float r105 = this.mMarker.getOptions().getAnchorV();
        int r106 = r100.x - ((int) (r103.getWidth() * r104));
        r101.left = r106;
        r101.right = r106 + r103.getWidth();
        int r107 = r100.y - ((int) (r103.getHeight() * r105));
        r101.top = r107;
        r101.bottom = r107 + r103.getHeight();
    L15:
        return r101;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void setAlpha(float r100) {
        this.mMarker.setAlpha(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setAlpha error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void setClickable(boolean r100) {
        this.mMarker.setClickable(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setClickable error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void setData(Object r100) {
        Marker r101 = this.mMarker;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setObject(r100);
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void setDraggable(boolean r100) {
        Marker r101 = this.mMarker;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setDraggable(r100);
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void setIcons(List<Bitmap> r100) {
        ArrayList<BitmapDescriptor> r101 = new ArrayList();     // Catch: Exception -> L8
        Iterator<Bitmap> r102 = r100.iterator();     // Catch: Exception -> L8
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(BitmapDescriptorFactory.fromBitmap(r102.next()));     // Catch: Exception -> L8
        goto L4
    L6:
        this.mMarker.setIcons(r101);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setIcons error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void setRotateAngle(float r100) {
        this.mMarker.setRotateAngle(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setRotateAngle error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void setScreenPoint(Point r100) {
        Marker r101 = this.mMarker;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setPositionByPixels(r100.x, r100.y);
        this.mScreenPoint = r100;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void setSelected(boolean r100) {
        this.mIsSelected = r100;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void setVisible(boolean r100) {
        this.mMarker.setVisible(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setVisible error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void setZIndex(float r100) {
        this.mMarker.setZIndex(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setZIndex error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void startAnimation(Object r100) {
    L6:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "startAnimation error:" + e.getMessage());
        return;
    L3:
        if ((r100 instanceof AnimationSet) == false) goto L11;
        this.mMarker.setAnimation((Animation) r100);     // Catch: Exception -> L6
        this.mMarker.startAnimation();     // Catch: Exception -> L6
        return;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void updateMarkerIcon(Bitmap r100) {
        this.mMarker.setIcon(BitmapDescriptorFactory.fromBitmap(r100));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "updateMarkerIcon error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void updatePosition(BDLatLng r100) {
        this.mMarker.setPosition(new LatLng(r100.getLatitude(), r100.getLongitude()));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "updatePosition error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void updateMarkerIcon(View r100) {
        this.mMarker.setIcon(BitmapDescriptorFactory.fromView(r100));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "updateMarkerIcon error:" + e.getMessage());
    }

    public AliMarker(Marker r100, String r101) {
        this.mIsSelected = false;
        this.mIsVisible = true;
        this.mScreenPoint = null;
        this.mMarker = r100;
        this.mId = r101;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void setAnchor(float r100, float r101) {
        Marker r102 = this.mMarker;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.setAnchor(r100, r101);
    }

    @Override // com.bytedance.map.api.model.IMarker
    public void setVisible(boolean r100, boolean r101) {
        if (r100 == this.mIsVisible) goto L14;
        Marker r102 = this.mMarker;
        if (r102 == null) goto L17;
        this.mIsVisible = r100;
        if (r101 == true) goto L10;
        r102.setVisible(r100);
        return;
    L10:
        if (r100 == false) goto L12;
        r102.setVisible(true);
        Animation r103 = getShowAnimation();
        this.mMarker.setAnimation(r103);
        this.mMarker.startAnimation();
        return;
    L12:
        Animation r104 = getHideAnimation();
        this.mMarker.setAnimation(r104);
        this.mMarker.setAnimationListener(new AnonymousClass1(this));
        this.mMarker.startAnimation();
        return;
    L17:
        return;
    }

    public AliMarker(Marker r100, String r101, Point r102) {
        this.mIsSelected = false;
        this.mIsVisible = true;
        this.mMarker = r100;
        this.mId = r101;
        this.mScreenPoint = r102;
        if (r100 == null) goto L6;
        this.mIsVisible = r100.isVisible();
        return;
    }
}
