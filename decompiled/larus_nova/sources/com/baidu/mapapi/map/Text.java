package com.baidu.mapapi.map;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.bmsdk.ui.RichView;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmTextMarker;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;
import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;
import com.baidu.vi.EnvDrawText;

/* JADX INFO: loaded from: classes39.dex */
public final class Text extends Overlay {
    int A;
    int B;
    float C;
    float D;
    CollisionBehavior E;
    int F;
    Point G;
    boolean H;
    Animation I;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    BmTextMarker f31357g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    BmTextStyle f31358h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String f31359i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    LatLng f31360j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f31361k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f31362l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    TextFontSizeType f31363m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f31364n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Typeface f31365o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f31366p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    float f31367q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    float f31368r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f31369s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f31370t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    float f31371u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f31372v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f31373w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    int f31374x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    int f31375y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    boolean f31376z;

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a() {
        Typeface r100 = this.f31365o;
        if (r100 == null) goto L6;
        EnvDrawText.removeFontCache(r100.hashCode());
    L6:
        return super.a();
    }

    public void cancelAnimation() {
        if (this.I != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.I.bmAnimation.cancel();
        this.f31207f.b();
        return;
    }

    public float getAlignX() {
        return this.f31369s;
    }

    public float getAlignY() {
        return this.f31370t;
    }

    public void pauseAnimation() {
        if (this.I != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.I.bmAnimation.pause();
        this.f31207f.b();
        return;
    }

    public void resumeAnimation() {
        if (this.I != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.I.bmAnimation.resume();
        this.f31207f.b();
        return;
    }

    public void startAnimation() {
        if (this.I != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.I.bmAnimation.start();
        this.f31207f.b();
        return;
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
        this.f31357g = new BmTextMarker();
        this.f31358h = new BmTextStyle();
        this.f31357g.a(this);
        setDrawItem(this.f31357g);
        super.toDrawItem();
        GeoPoint r100 = CoordUtil.ll2mc(this.f31360j);
        this.f31357g.a(new com.baidu.platform.comapi.bmsdk.b(r100.getLongitudeE6(), r100.getLatitudeE6()));
        this.f31357g.b(this.f31359i);
        this.f31358h.c(this.f31365o.getStyle());
        this.f31358h.f(this.f31363m.ordinal());
        this.f31358h.e(this.f31364n);
        this.f31358h.d(this.f31362l);
        this.f31358h.c(this.f31366p);
        this.f31357g.a(this.f31358h);
        this.f31357g.d(this.f31371u);
        this.f31357g.b(this.f31367q);
        this.f31357g.c(this.f31368r);
        this.f31357g.n(this.f31376z ? 1 : 0);
        this.f31357g.l(this.B);
        this.f31357g.m(this.A);
        this.f31357g.n(this.f31376z ? 1 : 0);
        this.f31357g.l(this.B);
        this.f31357g.m(this.A);
        this.f31357g.f(this.C);
        this.f31357g.g(this.D);
        CollisionBehavior r101 = this.E;
        if (r101 == null) goto L5;
        this.f31357g.e(r101.ordinal());
    L5:
        this.f31357g.f(this.F);
        Animation r102 = this.I;
        if (r102 == null) goto L9;
        this.f31357g.a(r102.bmAnimation);
    L9:
        return this.f31357g;
    }

    public Text() {
        this.f31363m = TextFontSizeType.AdaptTextFontSize;
        this.f31365o = Typeface.DEFAULT;
        this.f31367q = 0.5f;
        this.f31368r = 0.5f;
        this.f31373w = true;
        this.C = 1.0f;
        this.D = 1.0f;
        this.F = Integer.MAX_VALUE;
        this.H = false;
        this.type = com.baidu.mapsdkplatform.comapi.map.d.f32145e;
    }

    public void clearRichViews() {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f31357g.c();
        this.f31207f.b();
        return;
    }

    public float getAnchorX() {
        return this.f31367q;
    }

    public float getAnchorY() {
        return this.f31368r;
    }

    public int getBgColor() {
        return this.f31361k;
    }

    public CollisionBehavior getCollisionBehavior() {
        return this.E;
    }

    public int getEndLevel() {
        return this.f31375y;
    }

    public Point getFixedPosition() {
        return this.G;
    }

    public int getFontColor() {
        return this.f31362l;
    }

    public int getFontSize() {
        return this.f31364n;
    }

    public TextFontSizeType getFontSizeType() {
        return this.f31363m;
    }

    public LatLng getPosition() {
        return this.f31360j;
    }

    public int getPriority() {
        return this.F;
    }

    public float getRotate() {
        return this.f31371u;
    }

    public float getScaleX() {
        return this.C;
    }

    public float getScaleY() {
        return this.D;
    }

    public int getStartLevel() {
        return this.f31374x;
    }

    public String getText() {
        return this.f31359i;
    }

    public Typeface getTypeface() {
        return this.f31365o;
    }

    public int getXOffset() {
        return this.B;
    }

    public int getYOffset() {
        return this.A;
    }

    public boolean isClickable() {
        return this.f31373w;
    }

    public boolean isFixed() {
        return this.H;
    }

    public boolean isPerspective() {
        return this.f31376z;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle r100) {
        super.a(r100);
        if (this.f31360j == null) goto L24;
        r100.putString("text", this.f31359i);
        GeoPoint r101 = CoordUtil.ll2mc(this.f31360j);
        r100.putDouble("location_x", r101.getLongitudeE6());
        r100.putDouble("location_y", r101.getLatitudeE6());
        int r102 = this.f31362l;
        int r103 = (r102 >> 16) & 255;
        int r104 = (r102 >> 8) & 255;
        r100.putInt("font_color", Color.argb(r102 >>> 24, r102 & 255, r104, r103));
        int r105 = this.f31361k;
        int r106 = (r105 >> 16) & 255;
        int r107 = (r105 >> 8) & 255;
        r100.putInt("bg_color", Color.argb(r105 >>> 24, r105 & 255, r107, r106));
        r100.putInt("font_size", this.f31364n);
        Typeface r108 = this.f31365o;
        if (r108 == null) goto L7;
        EnvDrawText.registFontCache(r108.hashCode(), this.f31365o);
        r100.putInt("type_face", this.f31365o.hashCode());
    L7:
        int r109 = this.f31369s;
        float r110 = 0.5f;
        if (r109 != 1) goto L10;
        float r111 = 0.0f;
    L14:
        r100.putFloat("align_x", r111);
        int r112 = this.f31370t;
        if (r112 != 8) goto L17;
        r110 = 0.0f;
    L21:
        r100.putFloat("align_y", r110);
        r100.putFloat("rotate", this.f31371u);
        r100.putInt("update", this.f31372v);
        r100.putInt("isClickable", this.f31373w ? 1 : 0);
        return r100;
    L17:
        if (r112 != 16) goto L21;
        r110 = 1.0f;
        goto L21
    L10:
        if (r109 == 2) goto L12;
        r111 = 0.5f;
        goto L14
    L12:
        r111 = 1.0f;
        goto L14
    L24:
        throw new IllegalStateException("BDMapSDKException: when you add a text overlay, you must provide text and the position info.");
    }

    public void addRichView(RichView r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L8;
        this.f31357g.a(r100.getBmRichView());
        this.f31207f.b();
        return;
    }

    public void removeRichView(RichView r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L8;
        this.f31357g.b(r100.getBmRichView());
        this.f31207f.b();
        return;
    }

    public void setAnimation(Animation r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.I = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L10;
        BmAnimation r101 = this.I.bmAnimation;
        if (r101 == null) goto L11;
        this.f31357g.a(r101);
        this.f31207f.b();
        return;
    L11:
        return;
    }

    public void setBgColor(int r100) {
        this.f31361k = r100;
        this.f31372v = 1;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L6;
        this.listener.c(this);
        return;
    }

    public void setBorderColor(int r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f31358h.a(r100);
        this.f31207f.b();
        return;
    }

    public void setBorderWidth(int r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L6;
        this.f31358h.b(r100);
        this.f31207f.b();
        return;
    }

    public void setClickable(boolean r100) {
        this.f31373w = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmTextMarker r101 = this.f31357g;
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

    public void setCollisionBehavior(CollisionBehavior r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L10;
        BmTextMarker r101 = this.f31357g;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        this.E = r100;
        r101.e(r100.getNumber());
        this.f31207f.b();
        return;
    L12:
        return;
    }

    public void setEndLevel(int r100) {
        this.f31375y = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L10;
        BmTextMarker r101 = this.f31357g;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.a(r100);
        this.f31207f.b();
        return;
    L12:
        return;
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
        this.G = r100;
        this.H = true;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L10;
        BmTextMarker r101 = this.f31357g;
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f31207f == null) goto L15;
        r101.j(this.H ? 1 : 0);
        this.f31357g.g(this.G.x);
        this.f31357g.h(this.G.y);
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

    public void setFontColor(int r100) {
        this.f31362l = r100;
        this.f31372v = 1;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L5;
        this.f31358h.d(r100);
        this.f31207f.b();
        return;
    L5:
        this.listener.c(this);
    }

    public void setFontSize(int r100) {
        this.f31364n = r100;
        this.f31372v = 1;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L5;
        this.f31358h.e(r100);
        this.f31207f.b();
        return;
    L5:
        this.listener.c(this);
    }

    public void setFontSizeType(TextFontSizeType r100) {
        if (this.f31363m != r100) goto L5;
        return;
    L5:
        this.f31363m = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.f31358h.f(r100.ordinal());
        this.f31358h.e(this.f31364n);
        this.f31207f.b();
        return;
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
        this.f31376z = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L10;
        BmTextMarker r101 = this.f31357g;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.n(this.f31376z ? 1 : 0);
        this.f31207f.b();
        return;
    L12:
        return;
    }

    public void setPosition(LatLng r100) {
        if (r100 == null) goto L13;
        this.f31360j = r100;
        this.f31372v = 1;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L6;
        this.listener.c(this);
        return;
    L6:
        if (this.f31357g != null) goto L8;
        return;
    L8:
        if (this.f31207f == null) goto L15;
        GeoPoint r101 = CoordUtil.ll2mc(this.f31360j);
        this.f31357g.a(new com.baidu.platform.comapi.bmsdk.b(r101.getLongitudeE6(), r101.getLatitudeE6()));
        this.f31207f.b();
        return;
    L15:
        return;
    L13:
        throw new IllegalArgumentException("BDMapSDKException: position can not be null");
    }

    public void setPriority(int r100) {
        this.F = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L10;
        BmTextMarker r101 = this.f31357g;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.f((short) r100);
        this.f31207f.b();
        return;
    L12:
        return;
    }

    public void setRotate(float r100) {
        this.f31371u = r100;
        this.f31372v = 1;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmTextMarker r101 = this.f31357g;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.d(r100);
        this.f31207f.b();
        return;
    L12:
        return;
    L9:
        this.listener.c(this);
    }

    public void setScale(float r100) {
        if (r100 >= 0.0f) goto L5;
        r100 = 1.0f;
    L5:
        this.C = r100;
        this.D = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L13;
        BmTextMarker r101 = this.f31357g;
        if (r101 != null) goto L10;
        return;
    L10:
        if (this.f31207f == null) goto L15;
        r101.e(r100);
        this.f31207f.b();
        return;
    L15:
        return;
    }

    public void setScaleX(float r100) {
        if (r100 >= 0.0f) goto L5;
        r100 = 1.0f;
    L5:
        this.C = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L13;
        BmTextMarker r101 = this.f31357g;
        if (r101 != null) goto L10;
        return;
    L10:
        if (this.f31207f == null) goto L15;
        r101.f(r100);
        this.f31207f.b();
        return;
    L15:
        return;
    }

    public void setScaleY(float r100) {
        if (r100 >= 0.0f) goto L5;
        r100 = 1.0f;
    L5:
        this.D = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L13;
        BmTextMarker r101 = this.f31357g;
        if (r101 != null) goto L10;
        return;
    L10:
        if (this.f31207f == null) goto L15;
        r101.g(r100);
        this.f31207f.b();
        return;
    L15:
        return;
    }

    public void setStartLevel(int r100) {
        this.f31374x = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L10;
        BmTextMarker r101 = this.f31357g;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.b(r100);
        this.f31207f.b();
        return;
    L12:
        return;
    }

    public void setText(String r100) {
        if (r100 == null) goto L11;
        if (r100.equals("") == true) goto L11;
        this.f31359i = r100;
        this.f31372v = 1;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L8;
        this.f31357g.b(r100);
        this.f31207f.b();
        return;
    L8:
        this.listener.c(this);
        return;
    L11:
        throw new IllegalArgumentException("BDMapSDKException: text can not be null or empty");
    }

    public void setTypeface(Typeface r100) {
        this.f31365o = r100;
        this.f31372v = 1;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L5;
        this.f31358h.c(r100.getStyle());
        this.f31207f.b();
        return;
    L5:
        this.listener.c(this);
    }

    public void setXOffset(int r100) {
        this.B = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L10;
        BmTextMarker r101 = this.f31357g;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.l(r100);
        this.f31207f.b();
        return;
    L12:
        return;
    }

    public void setYOffset(int r100) {
        this.A = r100;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L10;
        BmTextMarker r101 = this.f31357g;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.f31207f == null) goto L12;
        r101.m(r100);
        this.f31207f.b();
        return;
    L12:
        return;
    }

    public void setAlign(int r100, int r101) {
        this.f31369s = r100;
        this.f31370t = r101;
        this.f31372v = 1;
        if (OverlayUtil.isOverlayUpgrade() == true) goto L6;
        this.listener.c(this);
        return;
    }

    public void setAnchor(float r100, float r101) {
        if (r100 >= 0.0f) goto L5;
        return;
    L5:
        if (r101 >= 0.0f) goto L7;
        return;
    L7:
        if (r100 <= 1.0f) goto L9;
        return;
    L9:
        if (r101 <= 1.0f) goto L12;
        return;
    L12:
        if (OverlayUtil.isOverlayUpgrade() == false) goto L18;
        this.f31367q = r100;
        this.f31368r = r101;
        this.f31357g.b(r100);
        this.f31357g.c(r101);
        this.f31207f.b();
        return;
    }
}
