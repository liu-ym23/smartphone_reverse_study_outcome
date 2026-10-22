package com.baidu.mapapi.map;

import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.bmsdk.ui.RichView;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.animation.BDAnimation;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmIconMarker;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.bmsdk.BmTextMarker;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.style.BmFrameResource;
import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;
import com.baidu.platform.comapi.bmsdk.ui.BmLabelUI;
import com.baidu.platform.comapi.bmsdk.ui.BmRichView;
import com.baidu.platform.comjni.tools.ParcelItem;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public final class Marker extends Overlay {
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    int E;
    int F;
    ArrayList<BitmapDescriptor> G;
    BmFrameResource H;
    int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    int f31108J;
    Animation K;
    float L;
    float M;
    float N;
    Point O;
    InfoWindow P;
    InfoWindow.a Q;
    boolean R;
    int S;
    int T;
    int U;
    int V;
    int W;
    InfoWindowAdapter X;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    LatLng f31109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    BitmapDescriptor f31110h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    BmBitmapResource f31111i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    BmIconMarker f31112j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f31113k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    float f31114l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    float f31115m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f31116n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f31117o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    float f31118p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    String f31119q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    TitleOptions f31120r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    BmTextMarker f31121s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f31122t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f31123u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    boolean f31124v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f31125w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    float f31126x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    int f31127y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    boolean f31128z;

    public void setToTop() {
        this.f31125w = true;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L12;
        BmIconMarker r100 = this.f31112j;
        if (r100 == null) goto L14;
        BmLayer r101 = this.f31207f;
        if (r101 == null) goto L15;
        BmDrawItem r102 = r101.a(r100.getName());
        if (r102 == null) goto L11;
        this.f31207f.a(r102);
    L11:
        this.f31207f.a(this.f31112j.getName(), this.f31112j);
        this.f31207f.b();
        return;
    L15:
        return;
    L14:
        return;
    L12:
        this.listener.c(this);
    }

    public void cancelAnimation() {
        if (this.K != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L7;
        this.K.bmAnimation.cancel();
        this.f31207f.b();
        return;
    L7:
        this.K.bdAnimation.cancelAnimation();
    }

    public void hideInfoWindow() {
        InfoWindow.a r100 = this.Q;
        if (r100 == null) goto L5;
        r100.a(this.P);
        this.R = false;
    L5:
        this.P = null;
    }

    public void pauseAnimation() {
        if (this.K != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.K.bmAnimation.pause();
        this.f31207f.b();
        return;
    }

    public void resumeAnimation() {
        if (this.K != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.K.bmAnimation.resume();
        this.f31207f.b();
        return;
    }

    public void showInfoWindow() {
        InfoWindowAdapter r100 = this.X;
        if (r100 != null) goto L5;
        return;
    L5:
        InfoWindow r101 = r100.getInfoWindow(this);
        if (r101 != null) goto L12;
        View r102 = this.X.getInfoWindowView(this);
        int r103 = this.X.getInfoWindowViewYOffset();
        if (r102 == null) goto L12;
        LatLng r104 = this.f31109g;
        if (r104 == null) goto L12;
        r101 = new InfoWindow(r102, r104, r103);
    L12:
        if (r101 == null) goto L24;
        InfoWindow r105 = this.P;
        if (r105 != null) goto L16;
        this.P = r101;
    L20:
        InfoWindow.a r106 = this.Q;
        if (r106 == null) goto L25;
        r106.b(this.P);
        this.R = true;
        return;
    L25:
        return;
    L16:
        InfoWindow.a r107 = this.Q;
        if (r107 == null) goto L19;
        r107.a(r105);
    L19:
        a(this.P, r101);
        goto L20
    }

    public void startAnimation() {
        if (this.K != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L7;
        this.K.bmAnimation.start();
        this.f31207f.b();
        return;
    L7:
        this.K.bdAnimation.startAnimation();
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
    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmIconMarker r100 = new BmIconMarker();
        this.f31112j = r100;
        r100.a(this);
        setDrawItem(this.f31112j);
        super.toDrawItem();
        if (this.G == null) goto L15;
        ArrayList r101 = new ArrayList();
        Iterator<BitmapDescriptor> r102 = this.G.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r101.add(new BmBitmapResource(r102.next().getBitmap()));
        goto L6
    L8:
        this.H = new BmFrameResource(r101, this.F, Integer.MAX_VALUE);
        this.I = r101.size();
        this.f31112j.a(this.H);
        Iterator r103 = r101.iterator();
    L10:
        if (r103.hasNext() == false) goto L21;
        ((BmBitmapResource) r103.next()).close();     // Catch: Exception -> L14
    L21:
        LatLng r104 = this.f31109g;
        if (r104 == null) goto L24;
        GeoPoint r105 = CoordUtil.ll2mc(r104);
        this.f31112j.a(new com.baidu.platform.comapi.bmsdk.b(r105.getLongitudeE6(), r105.getLatitudeE6()));
    L24:
        this.f31112j.k(this.f31113k);
        this.f31112j.a(this.f31126x);
        this.f31112j.a(this.A);
        this.f31112j.a(this.U, this.V);
        this.f31112j.d(this.f31204c);
        this.f31112j.e(this.N);
        this.f31112j.f(this.L);
        this.f31112j.g(this.M);
        this.f31112j.l(this.f31123u);
        this.f31112j.m(this.f31122t);
        this.f31112j.d(this.f31118p);
        this.f31112j.o(this.f31127y);
        Animation r106 = this.K;
        if (r106 == null) goto L27;
        this.f31112j.a(r106.bmAnimation);
    L27:
        this.f31112j.a(this.f31202a);
        this.f31112j.d(this.f31204c);
        this.f31112j.j(this.f31128z ? 1 : 0);
        this.f31112j.n(this.f31116n ? 1 : 0);
        if (this.B == false) goto L31;
        this.T |= CollisionBehavior.COLLIDE_WITH_INNER.getNumber();
    L31:
        if (this.D == false) goto L34;
        this.T |= CollisionBehavior.ALWAYS_SHOW.getNumber();
    L34:
        if (this.C == false) goto L36;
        this.T |= CollisionBehavior.COLLIDE_WITH_BASEPOI.getNumber();
    L36:
        Point r107 = this.O;
        if (r107 == null) goto L39;
        this.f31112j.g(r107.x);
        this.f31112j.h(this.O.y);
        this.T = CollisionBehavior.NOT_COLLIDE.getNumber();
    L39:
        this.f31112j.e(this.T);
        this.f31112j.f(this.S);
        if (this.f31124v == false) goto L42;
        this.f31112j.i(3);
    L43:
        this.f31112j.b(this.f31114l);
        this.f31112j.c(this.f31115m);
        if (this.f31120r == null) goto L59;
        BmTextMarker r108 = this.f31121s;
        if (r108 == null) goto L48;
        this.f31207f.a(r108);
        this.f31121s = null;
    L48:
        BmTextMarker r109 = new BmTextMarker();
        this.f31121s = r109;
        r109.setName("titleOption");
        this.f31121s.b(this.f31120r.getText());
        if (this.B == false) goto L53;
        BmTextMarker r110 = this.f31121s;
        CollisionBehavior r111 = CollisionBehavior.ALWAYS_SHOW;
        r110.e(r111.getNumber());
        this.f31112j.e(r111.getNumber());
        if (this.C == false) goto L54;
        BmTextMarker r112 = this.f31121s;
        int r113 = r111.getNumber();
        CollisionBehavior r114 = CollisionBehavior.COLLIDE_WITH_BASEPOI;
        r112.e(r113 | r114.getNumber());
        this.f31112j.e(r111.getNumber() | r114.getNumber());
    L54:
        BmTextStyle r115 = new BmTextStyle();
        r115.f(this.f31120r.getTitleFontSizeType().ordinal());
        r115.e(this.f31120r.getTitleFontSize());
        r115.d(this.f31120r.getTitleFontColor());
        r115.c(0);
        this.f31121s.d(this.f31120r.getTitleRotate());
        GeoPoint r116 = CoordUtil.ll2mc(this.f31109g);
        this.f31121s.a(new com.baidu.platform.comapi.bmsdk.b(r116.getLongitudeE6(), r116.getLatitudeE6()));
        this.f31121s.b(this.f31120r.getTitleAnchorX());
        this.f31121s.c(this.f31120r.getTitleAnchorY());
        this.f31121s.l((this.f31120r.getTitleXOffset() * 310) / SysOSUtil.getDensityDpi());
        int r117 = this.f31120r.getTitleYOffset();
        BitmapDescriptor r118 = this.f31110h;
        if (r118 == null) goto L57;
        r117 = r117 - ((int) (r118.getBitmap().getHeight() * this.M));
    L57:
        this.f31121s.m((r117 * 310) / SysOSUtil.getDensityDpi());
        this.f31121s.a(r115);
        this.f31207f.a(this.f31121s, this.f31112j.b() + 1);
        this.f31207f.b();
        goto L59
    L53:
        this.f31121s.e(this.T);
        this.f31121s.f(this.S);
    L59:
        return this.f31112j;
    L42:
        this.f31112j.i(0);
        goto L43
    L15:
        BmBitmapResource r119 = this.f31111i;
        if (r119 == null) goto L19;
        this.f31112j.a(r119);
        goto L21
    L19:
        if (this.f31110h == null) goto L21;
        this.f31112j.a(new BmBitmapResource(this.f31110h.getBitmap()));
        goto L21
    }

    public Marker() {
        this.f31124v = false;
        this.f31125w = false;
        this.f31128z = false;
        this.A = true;
        this.B = false;
        this.C = false;
        this.D = false;
        this.F = 160;
        this.f31108J = 20;
        this.L = 1.0f;
        this.M = 1.0f;
        this.N = 1.0f;
        this.R = false;
        this.S = Integer.MAX_VALUE;
        this.T = 0;
        this.U = 4;
        this.V = 22;
        this.W = 0;
        this.type = com.baidu.mapsdkplatform.comapi.map.d.f32143c;
    }

    public void clearRichViews() {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L10;
        BmIconMarker r100 = this.f31112j;
        if (r100 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r100.c();
        this.f31207f.b();
        return;
    L12:
        return;
    }

    public int getPeriod() {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L5;
        return 0;
    L5:
        return this.f31108J;
    }

    public void updateRichView() {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L8;
        BmLayer r100 = this.f31207f;
        if (r100 == null) goto L9;
        r100.b();
        return;
    L9:
        return;
    }

    public float getAlpha() {
        return this.f31126x;
    }

    public float getAnchorX() {
        return this.f31114l;
    }

    public float getAnchorY() {
        return this.f31115m;
    }

    public int getEndLevel() {
        return this.V;
    }

    public Point getFixedPosition() {
        return this.O;
    }

    public Point getFixedScreenPosition() {
        return this.O;
    }

    public BitmapDescriptor getIcon() {
        return this.f31110h;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.G;
    }

    public String getId() {
        return this.f31202a;
    }

    public InfoWindow getInfoWindow() {
        return this.P;
    }

    public LatLng getPosition() {
        return this.f31109g;
    }

    public int getPriority() {
        return this.S;
    }

    public float getRotate() {
        return this.f31118p;
    }

    public float getScale() {
        return this.N;
    }

    public float getScaleX() {
        return this.L;
    }

    public float getScaleY() {
        return this.M;
    }

    public int getStartLevel() {
        return this.U;
    }

    public String getTitle() {
        return this.f31119q;
    }

    public TitleOptions getTitleOptions() {
        return this.f31120r;
    }

    public int getXOffset() {
        return this.f31123u;
    }

    public int getYOffset() {
        return this.f31122t;
    }

    public boolean isClickable() {
        return this.A;
    }

    public boolean isDraggable() {
        return this.f31117o;
    }

    public boolean isFixed() {
        return this.f31128z;
    }

    public boolean isFlat() {
        return this.f31124v;
    }

    public boolean isForceDisplay() {
        return this.D;
    }

    public boolean isInfoWindowEnabled() {
        return this.R;
    }

    public boolean isJoinCollision() {
        return this.B;
    }

    public boolean isPerspective() {
        return this.f31116n;
    }

    public boolean isPoiCollided() {
        return this.C;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle r100) {
        super.a(r100);
        Bundle r101 = new Bundle();
        BitmapDescriptor r102 = this.f31110h;
        if (r102 == null) goto L5;
        r100.putBundle("image_info", r102.a());
    L5:
        GeoPoint r103 = CoordUtil.ll2mc(this.f31109g);
        r100.putInt("animatetype", this.f31127y);
        r100.putDouble("location_x", r103.getLongitudeE6());
        r100.putDouble("location_y", r103.getLatitudeE6());
        r100.putInt("perspective", this.f31116n ? 1 : 0);
        r100.putFloat("anchor_x", this.f31114l);
        r100.putFloat("anchor_y", this.f31115m);
        r100.putFloat("rotate", this.f31118p);
        r100.putInt("y_offset", this.f31122t);
        r100.putInt("x_offset", this.f31123u);
        r100.putInt("isflat", this.f31124v ? 1 : 0);
        r100.putInt("istop", this.f31125w ? 1 : 0);
        r100.putInt("period", this.f31108J);
        r100.putFloat("alpha", this.f31126x);
        r100.putInt("m_height", this.E);
        r100.putFloat(LiveDegradeFpsAnimator.SCALE_X, this.L);
        r100.putFloat(LiveDegradeFpsAnimator.SCALE_Y, this.M);
        r100.putInt("isClickable", this.A ? 1 : 0);
        r100.putInt("priority", this.S);
        r100.putInt("isJoinCollision", this.B ? 1 : 0);
        r100.putInt("isForceDisplay", this.D ? 1 : 0);
        r100.putInt("startLevel", this.U);
        r100.putInt("endLevel", this.V);
        Point r104 = this.O;
        if (r104 == null) goto L8;
        r100.putInt("fix_x", r104.x);
        r100.putInt("fix_y", this.O.y);
    L8:
        r100.putInt("isfixed", this.f31128z ? 1 : 0);
        ArrayList<BitmapDescriptor> r105 = this.G;
        if (r105 != null) goto L11;
    L13:
        r101.putBundle("param", r100);
        TitleOptions r106 = this.f31120r;
        if (r106 == null) goto L21;
        r100.putBundle("m_title", r106.a());
        int r107 = this.f31120r.getTitleYOffset();
        BitmapDescriptor r108 = this.f31110h;
        if (r108 == null) goto L18;
        r107 = r107 - ((int) (r108.getBitmap().getHeight() * this.M));
    L18:
        Bundle r109 = r100.getBundle("m_title");
        if (r109 == null) goto L21;
        r109.putInt("title_y_offset", r107);
    L21:
        r100.putInt("update", this.W);
        r100.putInt("poi_collied", this.C ? 1 : 0);
        return r100;
    L11:
        if (r105.size() <= 0) goto L13;
        a(this.G, r100);
        goto L13
    }

    public void addRichView(RichView r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L12;
        BmIconMarker r101 = this.f31112j;
        if (r101 != null) goto L9;
        return;
    L9:
        if (this.f31207f == null) goto L14;
        r101.a(r100.getBmRichView());
        this.f31207f.b();
        return;
    L14:
        return;
    }

    public void poiCollided(boolean r100) {
        this.C = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L8;
        if (r100 == false) goto L6;
        this.T |= CollisionBehavior.COLLIDE_WITH_BASEPOI.getNumber();
    L7:
        this.f31112j.e(this.T);
        this.f31207f.b();
        return;
    L6:
        this.T = (~CollisionBehavior.COLLIDE_WITH_BASEPOI.getNumber()) & this.T;
        goto L7
    L8:
        this.listener.c(this);
    }

    public void removeRichView(RichView r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L12;
        BmIconMarker r101 = this.f31112j;
        if (r101 != null) goto L9;
        return;
    L9:
        if (this.f31207f == null) goto L14;
        r101.b(r100.getBmRichView());
        this.f31207f.b();
        return;
    L14:
        return;
    }

    public void setAlpha(float r100) {
        if (r100 >= 0.0f) goto L5;
    L16:
        this.f31126x = 1.0f;
        return;
    L5:
        if (r100 > 1.0d) goto L16;
        this.f31126x = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L14;
        BmIconMarker r101 = this.f31112j;
        if (r101 != null) goto L12;
        return;
    L12:
        if (this.f31207f == null) goto L19;
        r101.a(this.f31126x);
        this.f31207f.b();
        return;
    L19:
        return;
    L14:
        this.listener.c(this);
    }

    public void setAnimateType(int r100) {
        this.f31127y = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmIconMarker r101 = this.f31112j;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.o(r100);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setAnimation(Animation r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.K = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L13;
        BmAnimation r101 = this.K.bmAnimation;
        if (r101 == null) goto L17;
        BmIconMarker r102 = this.f31112j;
        if (r102 != null) goto L11;
        return;
    L11:
        if (this.f31207f == null) goto L19;
        r102.a(r101);
        this.f31207f.b();
        return;
    L19:
        return;
    L17:
        return;
    L13:
        BDAnimation r103 = this.K.bdAnimation;
        if (r103 == null) goto L21;
        r103.setAnimation(this, r100);
        return;
    }

    public void setBmBitmapResource(BmBitmapResource r100) {
        if (r100 == null) goto L12;
        this.f31111i = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L13;
        BmIconMarker r101 = this.f31112j;
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f31207f == null) goto L15;
        r101.a(this.f31111i);
        this.f31207f.b();
        return;
    L15:
        return;
    L13:
        return;
    L12:
        throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
    }

    public void setClickable(boolean r100) {
        this.A = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmIconMarker r101 = this.f31112j;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.a(r100);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setDraggable(boolean r100) {
        this.f31117o = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L6;
        this.listener.c(this);
        return;
    }

    public void setEndLevel(int r100) {
        this.V = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmIconMarker r101 = this.f31112j;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.a(r100);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
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
    public void setFixedScreenPosition(Point r100) {
        if (r100 == null) goto L13;
        this.O = r100;
        this.f31128z = true;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L10;
        BmIconMarker r101 = this.f31112j;
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f31207f == null) goto L15;
        r101.j(this.f31128z ? 1 : 0);
        this.f31112j.g(this.O.x);
        this.f31112j.h(this.O.y);
        this.f31207f.b();
        return;
    L15:
        return;
    L10:
        this.listener.c(this);
        return;
    L13:
        throw new IllegalArgumentException("BDMapSDKException: the screenPosition can not be null");
    }

    public void setFlat(boolean r100) {
        this.f31124v = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L12;
        BmIconMarker r101 = this.f31112j;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L15;
        if (r100 == false) goto L10;
        r101.i(3);
    L11:
        this.f31207f.b();
        return;
    L10:
        r101.i(0);
        goto L11
    L15:
        return;
    L12:
        this.listener.c(this);
    }

    public void setForceDisplay(boolean r100) {
        this.D = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L8;
        if (r100 == false) goto L6;
        this.T |= CollisionBehavior.ALWAYS_SHOW.getNumber();
    L7:
        this.f31112j.e(this.T);
        this.f31207f.b();
        return;
    L6:
        this.T = (~CollisionBehavior.ALWAYS_SHOW.getNumber()) & this.T;
        goto L7
    L8:
        this.listener.c(this);
    }

    public void setIcon(BitmapDescriptor r100) {
        if (r100 == null) goto L13;
        this.f31110h = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L10;
        BmIconMarker r101 = this.f31112j;
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f31207f == null) goto L15;
        r101.a(new BmBitmapResource(this.f31110h.getBitmap()));
        this.f31207f.b();
        return;
    L15:
        return;
    L10:
        this.listener.c(this);
        return;
    L13:
        throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
    }

    public void setIcons(ArrayList<BitmapDescriptor> r100) {
        if (r100 == null) goto L45;
        if (r100.isEmpty() == false) goto L6;
        return;
    L6:
        int r101 = 0;
        if (r100.size() != 1) goto L10;
        this.f31110h = (BitmapDescriptor) ListProtector.get(r100, 0);
    L20:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L42;
        BmIconMarker r102 = this.f31112j;
        if (r102 != null) goto L24;
        return;
    L24:
        if (this.f31207f != null) goto L26;
        return;
    L26:
        if (this.G == null) goto L39;
        ArrayList r103 = new ArrayList();
        Iterator<BitmapDescriptor> r104 = this.G.iterator();
    L29:
        if (r104.hasNext() == false) goto L31;
        r103.add(new BmBitmapResource(r104.next().getBitmap()));
        goto L29
    L31:
        BmFrameResource r105 = new BmFrameResource(r103, this.F, Integer.MAX_VALUE);
        this.H = r105;
        this.f31112j.a(r105);
        Iterator r106 = r103.iterator();
    L33:
        if (r106.hasNext() == false) goto L41;
        ((BmBitmapResource) r106.next()).close();     // Catch: Exception -> L37
    L41:
        this.f31207f.b();
        return;
    L39:
        if (this.f31110h == null) goto L41;
        r102.a(new BmBitmapResource(this.f31110h.getBitmap()));
        goto L41
    L42:
        this.listener.c(this);
        return;
    L10:
        if (r101 >= r100.size()) goto L18;
        if (ListProtector.get(r100, r101) == null) goto L17;
        if (((BitmapDescriptor) ListProtector.get(r100, r101)).f30786a == null) goto L56;
        r101 = r101 + 1;
        goto L10
    L56:
        return;
    L17:
        return;
    L18:
        this.G = (ArrayList) r100.clone();
        this.f31110h = null;
        goto L20
    L45:
        throw new IllegalArgumentException("BDMapSDKException: marker's icons can not be null");
    }

    public void setInterval(int r100) {
        if (r100 > 0) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L12;
        BmFrameResource r101 = this.H;
        if (r101 == null) goto L13;
        int r102 = this.I;
        if (r102 <= 0) goto L14;
        this.F = r100;
        r101.a(r102, r100);
        this.f31207f.b();
        return;
    L14:
        return;
    L13:
        return;
    }

    public void setJoinCollision(boolean r100) {
        this.B = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L8;
        if (r100 == false) goto L6;
        this.T |= CollisionBehavior.COLLIDE_WITH_INNER.getNumber();
    L7:
        this.f31112j.e(this.T);
        this.f31207f.b();
        return;
    L6:
        this.T = (~CollisionBehavior.COLLIDE_WITH_INNER.getNumber()) & this.T;
        goto L7
    L8:
        this.listener.c(this);
    }

    public void setPeriod(int r100) {
        if (OverlayUtil.isOverlayUpgrade() == true) goto L8;
        if (r100 <= 0) goto L7;
        this.f31108J = r100;
        this.listener.c(this);
        return;
    L7:
        throw new IllegalArgumentException("BDMapSDKException: marker's period must be greater than zero ");
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
    public void setPerspective(boolean r100) {
        this.f31116n = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmIconMarker r101 = this.f31112j;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.n(this.f31116n ? 1 : 0);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setPosition(LatLng r100) {
        if (r100 == null) goto L16;
        this.f31109g = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L6;
        this.listener.c(this);
        return;
    L6:
        if (this.f31112j != null) goto L8;
        return;
    L8:
        if (this.f31207f == null) goto L18;
        GeoPoint r101 = CoordUtil.ll2mc(this.f31109g);
        this.f31112j.a(new com.baidu.platform.comapi.bmsdk.b(r101.getLongitudeE6(), r101.getLatitudeE6()));
        BmTextMarker r102 = this.f31121s;
        if (r102 == null) goto L12;
        r102.a(new com.baidu.platform.comapi.bmsdk.b(r101.getLongitudeE6(), r101.getLatitudeE6()));
    L12:
        this.f31207f.b();
        return;
    L18:
        return;
    L16:
        throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
    }

    public void setPositionWithInfoWindow(LatLng r100) {
        if (r100 == null) goto L16;
        this.f31109g = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L6;
        this.listener.c(this);
    L11:
        InfoWindow r101 = this.P;
        if (r101 == null) goto L17;
        r101.setPosition(r100);
        return;
    L17:
        return;
    L6:
        if (this.f31112j == null) goto L11;
        if (this.f31207f == null) goto L11;
        GeoPoint r102 = CoordUtil.ll2mc(this.f31109g);
        this.f31112j.a(new com.baidu.platform.comapi.bmsdk.b(r102.getLongitudeE6(), r102.getLatitudeE6()));
        this.f31207f.b();
        goto L11
    L16:
        throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
    }

    public void setPriority(int r100) {
        this.S = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmIconMarker r101 = this.f31112j;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.f(r100);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setRotate(float r100) {
    L3:
        if (r100 >= 0.0f) goto L5;
        r100 = r100 + 360.0f;
        goto L3
    L5:
        float r101 = r100 % 360.0f;
        this.f31118p = r101;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L12;
        BmIconMarker r102 = this.f31112j;
        if (r102 != null) goto L10;
        return;
    L10:
        if (this.f31207f == null) goto L16;
        r102.d(r101);
        this.f31207f.b();
        return;
    L16:
        return;
    L12:
        this.listener.c(this);
    }

    public void setScale(float r100) {
        if (r100 >= 0.0f) goto L5;
        r100 = 1.0f;
    L5:
        this.L = r100;
        this.M = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L18;
        BmIconMarker r101 = this.f31112j;
        if (r101 != null) goto L10;
        return;
    L10:
        if (this.f31207f == null) goto L21;
        r101.e(r100);
        if (this.f31121s == null) goto L17;
        int r102 = this.f31120r.getTitleYOffset();
        BitmapDescriptor r103 = this.f31110h;
        if (r103 == null) goto L16;
        r102 = r102 - ((int) (r103.getBitmap().getHeight() * this.M));
    L16:
        this.f31121s.m((r102 * 310) / SysOSUtil.getDensityDpi());
    L17:
        this.f31207f.b();
        return;
    L21:
        return;
    L18:
        this.listener.c(this);
    }

    public void setScaleX(float r100) {
        if (r100 >= 0.0f) goto L5;
        r100 = 1.0f;
    L5:
        this.L = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L12;
        BmIconMarker r101 = this.f31112j;
        if (r101 != null) goto L10;
        return;
    L10:
        if (this.f31207f == null) goto L15;
        r101.f(r100);
        this.f31207f.b();
        return;
    L15:
        return;
    L12:
        this.listener.c(this);
    }

    public void setScaleY(float r100) {
        if (r100 >= 0.0f) goto L5;
        r100 = 1.0f;
    L5:
        this.M = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L18;
        BmIconMarker r101 = this.f31112j;
        if (r101 != null) goto L10;
        return;
    L10:
        if (this.f31207f == null) goto L21;
        r101.g(r100);
        if (this.f31121s == null) goto L17;
        int r102 = this.f31120r.getTitleYOffset();
        BitmapDescriptor r103 = this.f31110h;
        if (r103 == null) goto L16;
        r102 = r102 - ((int) (r103.getBitmap().getHeight() * this.M));
    L16:
        this.f31121s.m((r102 * 310) / SysOSUtil.getDensityDpi());
    L17:
        this.f31207f.b();
        return;
    L21:
        return;
    L18:
        this.listener.c(this);
    }

    public void setStartLevel(int r100) {
        this.U = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmIconMarker r101 = this.f31112j;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.b(r100);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setTitle(String r100) {
        this.f31119q = r100;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L6;
        this.listener.c(this);
        return;
    }

    public void setTitleOptions(TitleOptions r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f31120r = r100;
        this.W = 1;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L7;
        this.listener.c(this);
        return;
    L7:
        if (this.f31112j != null) goto L9;
        return;
    L9:
        if (this.f31207f == null) goto L14;
        BmLabelUI r101 = new BmLabelUI();
        r101.setName("titleOption");
        r101.b(this.f31120r.getText());
        r101.b(this.f31120r.getTitleXOffset(), this.f31120r.getTitleYOffset(), 0, 0);
        r101.b(this.f31120r.getTitleBgColor());
        BmTextStyle r102 = new BmTextStyle();
        r102.d(this.f31120r.getTitleFontColor());
        r102.e(this.f31120r.getTitleFontSize());
        r101.a(r102);
        BmRichView r103 = new BmRichView();
        r103.a(r101);
        this.f31112j.a(r103);
        this.f31207f.b();
        return;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public void setVisible(boolean r100) {
        this.f31205d = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmIconMarker r101 = this.f31112j;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.c(r100 ? 1 : 0);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setXOffset(int r100) {
        this.f31123u = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmIconMarker r101 = this.f31112j;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.l(r100);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setYOffset(int r100) {
        this.f31122t = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmIconMarker r101 = this.f31112j;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.m(r100);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    @Override // com.baidu.mapapi.map.Overlay
    public void setZIndex(int r100) {
        this.f31204c = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L12;
        BmIconMarker r101 = this.f31112j;
        if (r101 == null) goto L14;
        BmLayer r102 = this.f31207f;
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.a(r101.getName()) == null) goto L11;
        this.f31207f.a(this.f31112j);
    L11:
        this.f31207f.a(this.f31112j, r100);
        this.f31207f.b();
        return;
    L14:
        return;
    L12:
        this.listener.c(this);
    }

    public void showInfoWindow(InfoWindow r100) {
        if (r100 == null) goto L15;
        InfoWindow r101 = this.P;
        if (r101 != null) goto L6;
        this.P = r100;
    L10:
        InfoWindow.a r102 = this.Q;
        if (r102 == null) goto L16;
        r102.b(this.P);
        this.R = true;
        return;
    L16:
        return;
    L6:
        InfoWindow.a r103 = this.Q;
        if (r103 == null) goto L9;
        r103.a(r101);
    L9:
        a(this.P, r100);
        goto L10
    L15:
        throw new IllegalArgumentException("BDMapSDKException: the InfoWindow can not be null");
    }

    public void showSmoothMoveInfoWindow(InfoWindow r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f31004n == false) goto L19;
        if (r100.f30993c == null) goto L17;
        InfoWindow r101 = this.P;
        if (r101 != null) goto L11;
        this.P = r100;
    L12:
        InfoWindow r102 = this.P;
        r102.f31003m = true;
        InfoWindow.a r103 = this.Q;
        if (r103 == null) goto L20;
        r103.b(r102);
        this.R = true;
        return;
    L20:
        return;
    L11:
        a(r101, r100);
        goto L12
    L17:
        throw new IllegalArgumentException("BDMapSDKException: the SmoothMoveInfoWindow's View can not be null");
    L19:
        throw new IllegalArgumentException("BDMapSDKException: the SmoothMoveInfoWindow must build with View");
    }

    public void updateInfoWindowBitmapDescriptor(BitmapDescriptor r100) {
        InfoWindow r101 = this.P;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f31005o == true) goto L9;
        r101.setBitmapDescriptor(r100);
        return;
    }

    public void updateInfoWindowPosition(LatLng r100) {
        InfoWindow r101 = this.P;
        if (r101 == null) goto L6;
        r101.setPosition(r100);
        return;
    }

    public void updateInfoWindowView(View r100) {
        InfoWindow r101 = this.P;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f31004n == false) goto L9;
        r101.setView(r100);
        return;
    }

    public void updateInfoWindowYOffset(int r100) {
        InfoWindow r101 = this.P;
        if (r101 == null) goto L6;
        r101.setYOffset(r100);
        return;
    }

    private void a(ArrayList<BitmapDescriptor> r100, Bundle r110) {
        ArrayList r101 = new ArrayList();
        Iterator<BitmapDescriptor> r102 = r100.iterator();
    L3:
        int r103 = 0;
        if (r102.hasNext() == false) goto L18;
        BitmapDescriptor r104 = r102.next();
        ParcelItem r105 = new ParcelItem();
        Bundle r106 = new Bundle();
        Bitmap r107 = r104.f30786a;
        ByteBuffer r108 = ByteBuffer.allocate((r107.getWidth() * r107.getHeight()) * 4);
        r107.copyPixelsToBuffer(r108);
        byte[] r109 = r108.array();
        r106.putByteArray("image_data", r109);
        r106.putInt("image_width", r107.getWidth());
        r106.putInt("image_height", r107.getHeight());
        MessageDigest r111 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L8
    L10:
        if (r111 == null) goto L16;
        r111.update(r109, 0, r109.length);
        byte[] r112 = r111.digest();
        StringBuilder r113 = new StringBuilder("");
    L13:
        if (r103 >= r112.length) goto L15;
        r113.append(Integer.toString((r112[r103] & UByte.MAX_VALUE) + 256, 16).substring(1));
        r103 = r103 + 1;
        goto L13
    L15:
        r106.putString("image_hashcode", r113.toString());
    L16:
        r105.setBundle(r106);
        r101.add(r105);
    L8:
        e = move-exception;
        e.printStackTrace();
        r111 = null;
        goto L10
    L18:
        if (r101.size() <= 0) goto L32;
        ParcelItem[] r114 = new ParcelItem[r101.size()];
    L21:
        if (r103 >= r101.size()) goto L23;
        r114[r103] = (ParcelItem) ListProtector.get(r101, r103);
        r103 = r103 + 1;
        goto L21
    L23:
        r110.putParcelableArray("icons", r114);
        return;
    }

    public void setAnchor(float r100, float r101) {
        if (r100 >= 0.0f) goto L5;
        return;
    L5:
        if (r100 <= 1.0f) goto L8;
        return;
    L8:
        if (r101 >= 0.0f) goto L10;
        return;
    L10:
        if (r101 > 1.0f) goto L30;
        this.f31114l = r100;
        this.f31115m = r101;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L22;
        BmIconMarker r102 = this.f31112j;
        if (r102 != null) goto L17;
        return;
    L17:
        if (this.f31207f == null) goto L27;
        r102.b(r100);
        this.f31112j.c(r101);
        BmTextMarker r103 = this.f31121s;
        if (r103 == null) goto L21;
        r103.b(r100);
        this.f31121s.c(r101);
    L21:
        this.f31207f.b();
        return;
    L27:
        return;
    L22:
        this.listener.c(this);
        return;
    }

    public void setAnimation(Animation r100, TypeEvaluator r101) {
        if (r100 == null) goto L5;
        this.K = r100;
        r100.bdAnimation.setTypeEvaluator(r101);
        this.K.bdAnimation.setAnimation(this, r100);
        return;
    }

    private void a(InfoWindow r100, InfoWindow r101) {
        r100.f30992b = r101.getBitmapDescriptor();
        r100.f30994d = r101.getPosition();
        r100.f30991a = r101.getTag();
        r100.f30993c = r101.getView();
        r100.f31000j = r101.getYOffset();
        r100.f31004n = r101.f31004n;
        r100.f30998h = r101.f30998h;
    }

    public void setIcons(ArrayList<BitmapDescriptor> r100, int[] r101, int r102) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L57;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isEmpty() == false) goto L8;
        return;
    L8:
        if (r100.size() > r101.length) goto L60;
        if (r102 < 0) goto L63;
        int r103 = 0;
        if (r100.size() != 1) goto L15;
        this.f31110h = (BitmapDescriptor) ListProtector.get(r100, 0);
    L24:
        BmIconMarker r104 = this.f31112j;
        if (r104 != null) goto L27;
        return;
    L27:
        if (this.f31207f != null) goto L29;
        return;
    L29:
        if (this.G == null) goto L42;
        ArrayList r105 = new ArrayList();
        Iterator<BitmapDescriptor> r106 = this.G.iterator();
    L32:
        if (r106.hasNext() == false) goto L34;
        r105.add(new BmBitmapResource(r106.next().getBitmap()));
        goto L32
    L34:
        BmFrameResource r107 = new BmFrameResource(r105, r101, r102);
        this.H = r107;
        this.f31112j.a(r107);
        Iterator r108 = r105.iterator();
    L36:
        if (r108.hasNext() == false) goto L44;
        ((BmBitmapResource) r108.next()).close();     // Catch: Exception -> L40
    L44:
        this.f31207f.b();
        return;
    L42:
        if (this.f31110h == null) goto L44;
        r104.a(new BmBitmapResource(this.f31110h.getBitmap()));
    L15:
        if (r103 >= r100.size()) goto L23;
        if (ListProtector.get(r100, r103) == null) goto L22;
        if (((BitmapDescriptor) ListProtector.get(r100, r103)).f30786a == null) goto L56;
        r103 = r103 + 1;
        goto L15
    L56:
        return;
    L22:
        return;
    L23:
        this.G = (ArrayList) r100.clone();
        this.f31110h = null;
        goto L24
    L63:
        return;
    L60:
        return;
    }
}
