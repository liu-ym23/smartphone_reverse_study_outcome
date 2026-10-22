package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public abstract class Overlay {
    protected static GeoPoint mcLocation;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f31202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    EncodePointType f31203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f31204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f31205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Bundle f31206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    BmLayer f31207f;
    protected a listener;
    protected BmDrawItem mDrawItem;
    public com.baidu.mapsdkplatform.comapi.map.d type;

    public interface a {
        void a(Overlay r100);

        boolean b(Overlay r100);

        void c(Overlay r100);

        LatLngBounds d(Overlay r100);
    }

    public Bundle a() {
        Bundle r100 = new Bundle();
        r100.putString("id", this.f31202a);
        r100.putInt("type", this.type.ordinal());
        return r100;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public BmDrawItem b() {
        BmDrawItem r100 = this.mDrawItem;
        if (r100 == null) goto L6;
        r100.c(this.f31205d ? 1 : 0);
        this.mDrawItem.d(this.f31204c);
    L6:
        return this.mDrawItem;
    }

    public LatLngBounds getOverlayLatLngBounds() {
        return this.listener.d(this);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public BmDrawItem toDrawItem() {
        BmDrawItem r100 = this.mDrawItem;
        if (r100 != null) goto L6;
        return null;
    L6:
        r100.setName(getName());
        this.mDrawItem.c(this.f31205d ? 1 : 0);
        this.mDrawItem.d(this.f31204c);
        return this.mDrawItem;
    }

    public Overlay() {
        this.f31202a = System.currentTimeMillis() + "_" + hashCode();
    }

    public boolean isRemoved() {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L12;
        BmLayer r100 = this.f31207f;
        if (r100 != null) goto L7;
        return true;
    L7:
        if (r100.a(getName()) == null) goto L14;
        return false;
    L14:
        return true;
    L12:
        return this.listener.b(this);
    }

    public void remove() {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L11;
        BmLayer r100 = this.f31207f;
        if (r100 == null) goto L11;
        BmDrawItem r101 = this.mDrawItem;
        if (r101 == null) goto L11;
        r100.a(r101);
        this.f31207f.b();
        this.mDrawItem.close();     // Catch: Exception -> L13
    L10:
        this.mDrawItem = null;
    L11:
        this.listener.a(this);
    }

    public BmLayer getBmLayer() {
        return this.f31207f;
    }

    public BmDrawItem getDrawItem() {
        return this.mDrawItem;
    }

    public Bundle getExtraInfo() {
        return this.f31206e;
    }

    public String getName() {
        return this.f31202a;
    }

    public int getZIndex() {
        return this.f31204c;
    }

    public boolean isVisible() {
        return this.f31205d;
    }

    public static List<List<com.baidu.platform.comapi.bmsdk.b>> circleHoleInfo2BmGeo(List<CircleHoleOptions> r210) {
        int r100 = r210.size();
        double[] r101 = new double[r100];
        double[] r102 = new double[r100];
        int[] r103 = new int[r100];
        int[] r104 = new int[r100];
        int r105 = 0;
    L3:
        if (r105 >= r100) goto L11;
        LatLng r106 = ((CircleHoleOptions) ListProtector.get(r210, r105)).getHoleCenter();
        int r107 = ((CircleHoleOptions) ListProtector.get(r210, r105)).getHoleRadius();
        if (r106 == null) goto L9;
        if (r107 <= 0) goto L24;
        int r108 = CoordUtil.getMCDistanceByOneLatLngAndRadius(r106, r107);
        GeoPoint r109 = CoordUtil.ll2mc(r106);
        r101[r105] = r109.getLongitudeE6();
        r102[r105] = r109.getLatitudeE6();
        r103[r105] = r108;
        r104[r105] = r105;
        r105 = r105 + 1;
        goto L3
    L24:
        return null;
    L9:
        return null;
    L11:
        ArrayList r110 = new ArrayList();
        int r111 = 0;
    L12:
        if (r111 >= r100) goto L18;
        double r112 = r101[r111];
        double r113 = r102[r111];
        ArrayList r114 = new ArrayList();
        int r115 = 0;
    L15:
        if (r115 >= 360) goto L17;
        int r211 = r111;
        int r116 = r100;
        double r117 = ((((double) r115) * 3.141592653589793d) * 2.0d) / ((double) 360);
        double r118 = (Math.cos(r117) * ((double) r103[r211])) + (r112 - mcLocation.getLongitudeE6());
        double r119 = (Math.sin(r117) * ((double) r103[r211])) + (r113 - mcLocation.getLatitudeE6());
        r114.add(new com.baidu.platform.comapi.bmsdk.b(r118 + mcLocation.getLongitudeE6(), r119 + mcLocation.getLatitudeE6()));
        r115 = r115 + 1;
        r111 = r211;
        r100 = r116;
        r101 = r101;
        goto L15
    L17:
        int r120 = r100;
        int r212 = r111;
        int r121 = r104[r212];
        r110.add(r114);
        r111 = r212 + 1;
        r100 = r120;
        goto L12
    L18:
        return r110;
    }

    public static List<List<com.baidu.platform.comapi.bmsdk.b>> holeInfo2BmGeo(List<HoleOptions> r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.size() == 0) goto L32;
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        Iterator<HoleOptions> r104 = r100.iterator();
    L8:
        if (r104.hasNext() == false) goto L16;
        HoleOptions r105 = r104.next();
        if ((r105 instanceof CircleHoleOptions) == true) goto L11;
        if ((r105 instanceof PolygonHoleOptions) == false) goto L8;
        r103.add((PolygonHoleOptions) r105);
        goto L8
    L11:
        r102.add((CircleHoleOptions) r105);
        goto L8
    L16:
        if (r102.size() == 0) goto L19;
        r101.addAll(circleHoleInfo2BmGeo(r102));
    L19:
        if (r103.size() == 0) goto L21;
        r101.addAll(polygonHoleInfo2BmGeo(r103));
    L21:
        return r101;
    L32:
        return null;
    }

    public static List<List<com.baidu.platform.comapi.bmsdk.b>> polygonHoleInfo2BmGeo(List<PolygonHoleOptions> r110) {
        int r100 = r110.size();
        int[] r101 = new int[r100];
        int[] r102 = new int[r100];
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        int r105 = 0;
    L3:
        if (r105 >= r100) goto L13;
        List<LatLng> r106 = ((PolygonHoleOptions) ListProtector.get(r110, r105)).getHolePoints();
        if (r106 == null) goto L6;
        ArrayList r107 = new ArrayList();
        Iterator<LatLng> r108 = r106.iterator();
    L10:
        if (r108.hasNext() == false) goto L12;
        GeoPoint r109 = CoordUtil.ll2mc(r108.next());
        r107.add(new com.baidu.platform.comapi.bmsdk.b(r109.getLongitudeE6(), r109.getLatitudeE6()));
        goto L10
    L12:
        r103.addAll(r106);
        r101[r105] = r106.size();
        r102[r105] = r105;
        r104.add(r107);
        r105 = r105 + 1;
        goto L3
    L6:
        return null;
    L13:
        return r104;
    }

    public Bundle a(Bundle r100) {
        r100.putString("id", this.f31202a);
        r100.putInt("type", this.type.ordinal());
        r100.putInt(RemoteMessageConst.Notification.VISIBILITY, this.f31205d ? 1 : 0);
        r100.putInt("z_index", this.f31204c);
        return r100;
    }

    public void setBmLayer(BmLayer r100) {
        this.f31207f = r100;
    }

    public void setDrawItem(BmDrawItem r100) {
        this.mDrawItem = r100;
    }

    public void setExtraInfo(Bundle r100) {
        this.f31206e = r100;
    }

    public void setVisible(boolean r100) {
        this.f31205d = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L5;
        this.listener.c(this);
        return;
    L5:
        if (this.f31207f == null) goto L11;
        BmDrawItem r101 = this.mDrawItem;
        if (r101 == null) goto L12;
        r101.c(r100 ? 1 : 0);
        this.f31207f.b();
        return;
    L12:
        return;
    }

    public void setZIndex(int r100) {
        this.f31204c = r100;
        this.listener.c(this);
    }

    private static boolean a(List<CircleHoleOptions> r110, Bundle r111) {
        int r100 = r110.size();
        double[] r101 = new double[r100];
        double[] r102 = new double[r100];
        int[] r103 = new int[r100];
        int[] r104 = new int[r100];
        int r105 = 0;
    L3:
        if (r105 >= r100) goto L10;
        LatLng r106 = ((CircleHoleOptions) ListProtector.get(r110, r105)).getHoleCenter();
        int r107 = ((CircleHoleOptions) ListProtector.get(r110, r105)).getHoleRadius();
        if (r106 == null) goto L9;
        if (r107 <= 0) goto L9;
        GeoPoint r108 = CoordUtil.ll2mc(r106);
        r101[r105] = r108.getLongitudeE6();
        r102[r105] = r108.getLatitudeE6();
        r103[r105] = r107;
        r104[r105] = r105;
        r105 = r105 + 1;
    L9:
        return false;
    L10:
        r111.putDoubleArray("circle_hole_x_array", r101);
        r111.putDoubleArray("circle_hole_y_array", r102);
        r111.putIntArray("circle_hole_radius_array", r103);
        r111.putIntArray("circle_hole_index_array", r104);
        return true;
    }

    public static boolean b(List<HoleOptions> r100, Bundle r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.size() == 0) goto L38;
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        Iterator<HoleOptions> r104 = r100.iterator();
    L9:
        if (r104.hasNext() == false) goto L17;
        HoleOptions r105 = r104.next();
        if ((r105 instanceof CircleHoleOptions) == true) goto L12;
        if ((r105 instanceof PolygonHoleOptions) == false) goto L9;
        r103.add((PolygonHoleOptions) r105);
        goto L9
    L12:
        r102.add((CircleHoleOptions) r105);
        goto L9
    L17:
        if (r102.size() == 0) goto L19;
        boolean r106 = a(r102, r101);
        r101.putInt("has_circle_hole", r106 ? 1 : 0);
    L21:
        if (r103.size() == 0) goto L23;
        boolean r107 = d(r103, r101);
        r101.putInt("has_polygon_hole", r107 ? 1 : 0);
    L24:
        if (r106 == true) goto L26;
        if (r107 == true) goto L26;
        return false;
    L26:
        return true;
    L23:
        r101.putInt("has_polygon_hole", 0);
        r107 = false;
        goto L24
    L19:
        r101.putInt("has_circle_hole", 0);
        r106 = false;
        goto L21
    L38:
        return false;
    }

    public static void c(int r100, Bundle r101) {
        Bundle r102 = new Bundle();
        r102.putFloat("red", ((r100 >> 16) & 255) / 255.0f);
        r102.putFloat("green", ((r100 >> 8) & 255) / 255.0f);
        r102.putFloat("blue", (r100 & 255) / 255.0f);
        r102.putFloat("alpha", (r100 >>> 24) / 255.0f);
        r101.putBundle("m_side_color", r102);
    }

    private static boolean d(List<PolygonHoleOptions> r100, Bundle r101) {
        int r102 = r100.size();
        int[] r103 = new int[r102];
        int[] r104 = new int[r102];
        ArrayList r105 = new ArrayList();
        int r106 = 0;
        int r107 = 0;
    L3:
        if (r107 >= r102) goto L8;
        List<LatLng> r108 = ((PolygonHoleOptions) ListProtector.get(r100, r107)).getHolePoints();
        if (r108 == null) goto L6;
        r105.addAll(r108);
        r103[r107] = r108.size();
        r104[r107] = r107;
        r107 = r107 + 1;
        goto L3
    L6:
        return false;
    L8:
        int r109 = r105.size();
        if (r109 != 0) goto L11;
        return false;
    L11:
        r101.putIntArray("polygon_hole_count_array", r103);
        r101.putIntArray("polygon_hole_index_array", r104);
        double[] r110 = new double[r109];
        double[] r111 = new double[r109];
    L12:
        if (r106 >= r109) goto L14;
        GeoPoint r112 = CoordUtil.ll2mc((LatLng) ListProtector.get(r105, r106));
        r110[r106] = r112.getLongitudeE6();
        r111[r106] = r112.getLatitudeE6();
        r106 = r106 + 1;
        goto L12
    L14:
        r101.putDoubleArray("polygon_hole_x_array", r110);
        r101.putDoubleArray("polygon_hole_y_array", r111);
        return true;
    }

    public static void e(int r100, Bundle r101) {
        Bundle r102 = new Bundle();
        r102.putFloat("red", ((r100 >> 16) & 255) / 255.0f);
        r102.putFloat("green", ((r100 >> 8) & 255) / 255.0f);
        r102.putFloat("blue", (r100 & 255) / 255.0f);
        r102.putFloat("alpha", (r100 >>> 24) / 255.0f);
        r101.putBundle("m_sideFaceColor", r102);
    }

    public static void f(int r100, Bundle r101) {
        Bundle r102 = new Bundle();
        r102.putFloat("red", ((r100 >> 16) & 255) / 255.0f);
        r102.putFloat("green", ((r100 >> 8) & 255) / 255.0f);
        r102.putFloat("blue", (r100 & 255) / 255.0f);
        r102.putFloat("alpha", (r100 >>> 24) / 255.0f);
        r101.putBundle("m_topFaceColor", r102);
    }

    public void setDottedBitmapResource(BmLineStyle r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r102 = 2;
        if (r101 != 1) goto L7;
        String r103 = "CircleDashTexture.png";
    L11:
        r100.b(r102);
        BitmapDescriptor r104 = BitmapDescriptorFactory.fromAsset(r103);
        if (r104 == null) goto L15;
        r100.a(new BmBitmapResource(r104.getBitmap()));
        return;
    L15:
        return;
    L7:
        if (r101 != 2) goto L9;
        r103 = "lineDash_Rectangle.png";
    L10:
        r102 = 1;
        goto L11
    L9:
        r103 = "lineDashTexture.png";
        goto L10
    }

    public static void a(int r100, Bundle r101) {
        Bundle r102 = new Bundle();
        r102.putFloat("red", ((r100 >> 16) & 255) / 255.0f);
        r102.putFloat("green", ((r100 >> 8) & 255) / 255.0f);
        r102.putFloat("blue", (r100 & 255) / 255.0f);
        r102.putFloat("alpha", (r100 >>> 24) / 255.0f);
        r101.putBundle("m_floorColor", r102);
    }

    public static void b(int r100, Bundle r101) {
        Bundle r102 = new Bundle();
        r102.putFloat("red", ((r100 >> 16) & 255) / 255.0f);
        r102.putFloat("green", ((r100 >> 8) & 255) / 255.0f);
        r102.putFloat("blue", (r100 & 255) / 255.0f);
        r102.putFloat("alpha", (r100 >>> 24) / 255.0f);
        r101.putBundle("m_center_color", r102);
    }

    public static void c(List<LatLng> r100, Bundle r101) {
        int r102 = r100.size();
        double[] r103 = new double[r102];
        double[] r104 = new double[r102];
        int r105 = 0;
    L3:
        if (r105 >= r102) goto L5;
        GeoPoint r106 = CoordUtil.ll2mc((LatLng) ListProtector.get(r100, r105));
        r103[r105] = r106.getLongitudeE6();
        r104[r105] = r106.getLatitudeE6();
        r105 = r105 + 1;
        goto L3
    L5:
        r101.putDoubleArray("x_array", r103);
        r101.putDoubleArray("y_array", r104);
    }

    public static void d(int r100, Bundle r101) {
        Bundle r102 = new Bundle();
        r102.putFloat("red", ((r100 >> 16) & 255) / 255.0f);
        r102.putFloat("green", ((r100 >> 8) & 255) / 255.0f);
        r102.putFloat("blue", (r100 & 255) / 255.0f);
        r102.putFloat("alpha", (r100 >>> 24) / 255.0f);
        r101.putBundle("color", r102);
    }
}
