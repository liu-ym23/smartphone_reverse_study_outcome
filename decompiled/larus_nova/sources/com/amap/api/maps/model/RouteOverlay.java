package com.amap.api.maps.model;

import android.util.Pair;
import com.amap.api.mapcore.util.r4;
import com.amap.api.mapcore.util.s4;
import com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class RouteOverlay {
    private IRouteOverlayInner mBaseRouteOverlay;

    public static final enum MapRouteScene extends Enum<MapRouteScene> {
        private static final /* synthetic */ MapRouteScene[] $VALUES = null;
        public static final MapRouteScene CHARGE = null;
        public static final MapRouteScene CIMMUTE = null;
        public static final MapRouteScene HD = null;
        public static final MapRouteScene LIMIT = null;
        public static final MapRouteScene NORMAL = null;
        public static final MapRouteScene SHARE = null;
        public static final MapRouteScene WRONG = null;

        static {
            MapRouteScene r100 = new MapRouteScene(EffectConstants.NORMAL, 0);
            NORMAL = r100;
            MapRouteScene r101 = new MapRouteScene("CHARGE", 1);
            CHARGE = r101;
            MapRouteScene r102 = new MapRouteScene("LIMIT", 2);
            LIMIT = r102;
            MapRouteScene r103 = new MapRouteScene("CIMMUTE", 3);
            CIMMUTE = r103;
            MapRouteScene r104 = new MapRouteScene("WRONG", 4);
            WRONG = r104;
            MapRouteScene r105 = new MapRouteScene("SHARE", 5);
            SHARE = r105;
            MapRouteScene r110 = new MapRouteScene("HD", 6);
            HD = r110;
            $VALUES = new MapRouteScene[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static MapRouteScene[] values() {
            return (MapRouteScene[]) $VALUES.clone();
        }

        public static MapRouteScene valueOf(String r100) {
            return (MapRouteScene) r27.a.a(MapRouteScene.class, r100);
        }

        private MapRouteScene(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class RouteOverlayHighLightParam {
        public int arrowColorNormal;
        public int borderColorHightLight;
        public int borderColorNormal;
        public int fillColorHightLight;
        public int fillColorNormal;

        public RouteOverlayHighLightParam() {
        }
    }

    public Pair<Float, Float> getDisplayRange() {
        IRouteOverlayInner r100 = this.mBaseRouteOverlay;     // Catch: Exception -> L8
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getDisplayRange();
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public void addRouteName() {
        IRouteOverlayInner r100 = this.mBaseRouteOverlay;     // Catch: Exception -> L6
        if (r100 == null) goto L11;
        r100.addRouteName();     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public int getOverlayPriority() {
        IRouteOverlayInner r100 = this.mBaseRouteOverlay;     // Catch: Exception -> L6
        if (r100 == null) goto L12;
        return r100.getOverlayProperty();
    L12:
        return 0;
    L6:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public boolean isVisible() {
        IRouteOverlayInner r100 = this.mBaseRouteOverlay;     // Catch: Exception -> L6
        if (r100 == null) goto L12;
        return r100.isVisible();
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void remove() {
        IRouteOverlayInner r100 = this.mBaseRouteOverlay;     // Catch: Exception -> L6
        if (r100 == null) goto L11;
        r100.remove();     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void removeRouteName() {
        IRouteOverlayInner r100 = this.mBaseRouteOverlay;     // Catch: Exception -> L6
        if (r100 == null) goto L11;
        r100.removeRouteName();     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public RouteOverlay(IRouteOverlayInner r100) {
        this.mBaseRouteOverlay = r100;
    }

    public void setArrow3DTexture(BitmapDescriptor r100) {
        IRouteOverlayInner r101 = this.mBaseRouteOverlay;     // Catch: Exception -> L6
        if (r101 == null) goto L11;
        r101.setArrow3DTexture(r100);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void setArrowFlow(boolean r100) {
        IRouteOverlayInner r101 = this.mBaseRouteOverlay;     // Catch: Exception -> L6
        if (r101 == null) goto L11;
        r101.setArrowFlow(r100);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void setHighlightParam(RouteOverlayHighLightParam r100) {
        IRouteOverlayInner r101 = this.mBaseRouteOverlay;     // Catch: Exception -> L6
        if (r101 == null) goto L11;
        r101.setHighlightParam(r100);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void setHighlightType(int r100) {
        IRouteOverlayInner r101 = this.mBaseRouteOverlay;     // Catch: Exception -> L6
        if (r101 == null) goto L11;
        r101.setHighlightType(r100);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void setLineWidthScale(float r100) {
        IRouteOverlayInner r101 = this.mBaseRouteOverlay;     // Catch: Exception -> L6
        if (r101 == null) goto L11;
        r101.setLineWidthScale(r100);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void setOverlayPriority(int r100) {
        IRouteOverlayInner r101 = this.mBaseRouteOverlay;     // Catch: Exception -> L7
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setOverlayProperty(r100);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public void setRouteItemParam(s4 r100) {
        IRouteOverlayInner r101 = this.mBaseRouteOverlay;     // Catch: Exception -> L6
        if (r101 == null) goto L11;
        r101.setRouteItemParam(r100);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void setSelectStatus(boolean r100) {
        IRouteOverlayInner r101 = this.mBaseRouteOverlay;     // Catch: Exception -> L6
        if (r101 == null) goto L11;
        r101.setSelectStatus(r100);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void setShowArrow(boolean r100) {
        IRouteOverlayInner r101 = this.mBaseRouteOverlay;     // Catch: Exception -> L6
        if (r101 == null) goto L11;
        r101.setShowArrow(r100);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void setShowNaviRouteNameCountMap(Map<Integer, Integer> r100) {
        IRouteOverlayInner r101 = this.mBaseRouteOverlay;     // Catch: Exception -> L6
        if (r101 == null) goto L11;
        r101.setShowNaviRouteNameCountMap(r100);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void setVisible(boolean r100) {
        IRouteOverlayInner r101 = this.mBaseRouteOverlay;     // Catch: Exception -> L6
        if (r101 == null) goto L11;
        r101.setVisible(r100);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void setCar2DPosition(int r100, float r101) {
        IRouteOverlayInner r102 = this.mBaseRouteOverlay;     // Catch: Exception -> L6
        if (r102 == null) goto L11;
        r102.setCar2DPosition(r100, r101);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void setDisplayRange(float r100, float r101) {
        IRouteOverlayInner r102 = this.mBaseRouteOverlay;     // Catch: Exception -> L7
        if (r102 != null) goto L5;
        return;
    L5:
        r102.setDisplayRange(r100, r101);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public void setLine2DWidth(int r100, int r101) {
        IRouteOverlayInner r102 = this.mBaseRouteOverlay;     // Catch: Exception -> L6
        if (r102 == null) goto L11;
        r102.setLine2DWidth(r100, r101);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void addRouteItem(int r100, s4[] r101, boolean r102, r4 r110, int[] r111) {
        IRouteOverlayInner r103 = this.mBaseRouteOverlay;     // Catch: Exception -> L6
        if (r103 == null) goto L11;
        r103.addRouteItem(r100, r101, r102 ? 1 : 0, r110, r111);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }
}
