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
import com.stepos.alphame.sleep.SleepModeData;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class Text extends Overlay {

    /* renamed from: A, reason: collision with root package name */
    int f6903A;

    /* renamed from: D, reason: collision with root package name */
    CollisionBehavior f6906D;

    /* renamed from: F, reason: collision with root package name */
    Point f6908F;

    /* renamed from: H, reason: collision with root package name */
    Animation f6910H;

    /* renamed from: g, reason: collision with root package name */
    BmTextMarker f6911g;

    /* renamed from: h, reason: collision with root package name */
    BmTextStyle f6912h;

    /* renamed from: i, reason: collision with root package name */
    String f6913i;

    /* renamed from: j, reason: collision with root package name */
    LatLng f6914j;

    /* renamed from: k, reason: collision with root package name */
    int f6915k;

    /* renamed from: l, reason: collision with root package name */
    int f6916l;

    /* renamed from: m, reason: collision with root package name */
    int f6917m;

    /* renamed from: o, reason: collision with root package name */
    int f6919o;

    /* renamed from: r, reason: collision with root package name */
    int f6922r;

    /* renamed from: s, reason: collision with root package name */
    int f6923s;

    /* renamed from: t, reason: collision with root package name */
    float f6924t;

    /* renamed from: u, reason: collision with root package name */
    int f6925u;

    /* renamed from: w, reason: collision with root package name */
    int f6927w;

    /* renamed from: x, reason: collision with root package name */
    int f6928x;

    /* renamed from: y, reason: collision with root package name */
    boolean f6929y;

    /* renamed from: z, reason: collision with root package name */
    int f6930z;

    /* renamed from: n, reason: collision with root package name */
    Typeface f6918n = Typeface.DEFAULT;

    /* renamed from: p, reason: collision with root package name */
    float f6920p = 0.5f;

    /* renamed from: q, reason: collision with root package name */
    float f6921q = 0.5f;

    /* renamed from: v, reason: collision with root package name */
    boolean f6926v = true;

    /* renamed from: B, reason: collision with root package name */
    float f6904B = 1.0f;

    /* renamed from: C, reason: collision with root package name */
    float f6905C = 1.0f;

    /* renamed from: E, reason: collision with root package name */
    int f6907E = Integer.MAX_VALUE;

    /* renamed from: G, reason: collision with root package name */
    boolean f6909G = false;

    public Text() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.text;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        if (this.f6914j == null) {
            throw new IllegalStateException("BDMapSDKException: when you add a text overlay, you must provide text and the position info.");
        }
        bundle.putString("text", this.f6913i);
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6914j);
        bundle.putDouble(SleepModeData.LOCATION_X, geoPointLl2mc.getLongitudeE6());
        bundle.putDouble(SleepModeData.LOCATION_Y, geoPointLl2mc.getLatitudeE6());
        int i4 = this.f6916l;
        bundle.putInt("font_color", Color.argb(i4 >>> 24, i4 & 255, (i4 >> 8) & 255, (i4 >> 16) & 255));
        int i5 = this.f6915k;
        bundle.putInt("bg_color", Color.argb(i5 >>> 24, i5 & 255, (i5 >> 8) & 255, (i5 >> 16) & 255));
        bundle.putInt("font_size", this.f6917m);
        Typeface typeface = this.f6918n;
        if (typeface != null) {
            EnvDrawText.registFontCache(typeface.hashCode(), this.f6918n);
            bundle.putInt("type_face", this.f6918n.hashCode());
        }
        int i6 = this.f6922r;
        float f4 = Property.DEFAULT_FLOAT_VALUE;
        bundle.putFloat("align_x", i6 != 1 ? i6 != 2 ? 0.5f : 1.0f : 0.0f);
        int i7 = this.f6923s;
        if (i7 != 8) {
            f4 = i7 != 16 ? 0.5f : 1.0f;
        }
        bundle.putFloat("align_y", f4);
        bundle.putFloat("rotate", this.f6924t);
        bundle.putInt("update", this.f6925u);
        bundle.putInt("isClickable", this.f6926v ? 1 : 0);
        return bundle;
    }

    public void addRichView(RichView richView) {
        if (richView != null && OverlayUtil.isOverlayUpgrade()) {
            this.f6911g.a(richView.getBmRichView());
            this.f6723f.b();
        }
    }

    public void cancelAnimation() {
        if (this.f6910H == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.f6910H.bmAnimation.cancel();
        this.f6723f.b();
    }

    public void clearRichViews() {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6911g.c();
            this.f6723f.b();
        }
    }

    public float getAlignX() {
        return this.f6922r;
    }

    public float getAlignY() {
        return this.f6923s;
    }

    public float getAnchorX() {
        return this.f6920p;
    }

    public float getAnchorY() {
        return this.f6921q;
    }

    public int getBgColor() {
        return this.f6915k;
    }

    public CollisionBehavior getCollisionBehavior() {
        return this.f6906D;
    }

    public int getEndLevel() {
        return this.f6928x;
    }

    public Point getFixedPosition() {
        return this.f6908F;
    }

    public int getFontColor() {
        return this.f6916l;
    }

    public int getFontSize() {
        return this.f6917m;
    }

    public LatLng getPosition() {
        return this.f6914j;
    }

    public int getPriority() {
        return this.f6907E;
    }

    public float getRotate() {
        return this.f6924t;
    }

    public float getScaleX() {
        return this.f6904B;
    }

    public float getScaleY() {
        return this.f6905C;
    }

    public int getStartLevel() {
        return this.f6927w;
    }

    public String getText() {
        return this.f6913i;
    }

    public Typeface getTypeface() {
        return this.f6918n;
    }

    public int getXOffset() {
        return this.f6903A;
    }

    public int getYOffset() {
        return this.f6930z;
    }

    public boolean isClickable() {
        return this.f6926v;
    }

    public boolean isFixed() {
        return this.f6909G;
    }

    public boolean isPerspective() {
        return this.f6929y;
    }

    public void pauseAnimation() {
        if (this.f6910H == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.f6910H.bmAnimation.pause();
        this.f6723f.b();
    }

    public void removeRichView(RichView richView) {
        if (richView != null && OverlayUtil.isOverlayUpgrade()) {
            this.f6911g.b(richView.getBmRichView());
            this.f6723f.b();
        }
    }

    public void resumeAnimation() {
        if (this.f6910H == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.f6910H.bmAnimation.resume();
        this.f6723f.b();
    }

    public void setAlign(int i4, int i5) {
        this.f6922r = i4;
        this.f6923s = i5;
        this.f6925u = 1;
        if (OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.listener.c(this);
    }

    public void setAnchor(float f4, float f5) {
        if (f4 < Property.DEFAULT_FLOAT_VALUE || f5 < Property.DEFAULT_FLOAT_VALUE || f4 > 1.0f || f5 > 1.0f || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.f6920p = f4;
        this.f6921q = f5;
        this.f6911g.b(f4);
        this.f6911g.c(f5);
        this.f6723f.b();
    }

    public void setAnimation(Animation animation) {
        BmAnimation bmAnimation;
        if (animation == null) {
            return;
        }
        this.f6910H = animation;
        if (!OverlayUtil.isOverlayUpgrade() || (bmAnimation = this.f6910H.bmAnimation) == null) {
            return;
        }
        this.f6911g.a(bmAnimation);
        this.f6723f.b();
    }

    public void setBgColor(int i4) {
        this.f6915k = i4;
        this.f6925u = 1;
        if (OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.listener.c(this);
    }

    public void setBorderColor(int i4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6912h.a(i4);
            this.f6723f.b();
        }
    }

    public void setBorderWidth(int i4) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f6912h.b(i4);
            this.f6723f.b();
        }
    }

    public void setClickable(boolean z4) {
        this.f6926v = z4;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmTextMarker bmTextMarker = this.f6911g;
        if (bmTextMarker == null || this.f6723f == null) {
            return;
        }
        bmTextMarker.a(z4);
        this.f6723f.b();
    }

    public void setCollisionBehavior(CollisionBehavior collisionBehavior) {
        BmTextMarker bmTextMarker;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.f6911g) == null || this.f6723f == null) {
            return;
        }
        this.f6906D = collisionBehavior;
        bmTextMarker.e(collisionBehavior.getNumber());
        this.f6723f.b();
    }

    public void setEndLevel(int i4) {
        BmTextMarker bmTextMarker;
        this.f6928x = i4;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.f6911g) == null || this.f6723f == null) {
            return;
        }
        bmTextMarker.a(i4);
        this.f6723f.b();
    }

    public void setFixedScreenPosition(Point point) {
        if (point == null) {
            throw new IllegalArgumentException("BDMapSDKException: the screenPosition can not be null");
        }
        this.f6908F = point;
        this.f6909G = true;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmTextMarker bmTextMarker = this.f6911g;
        if (bmTextMarker == null || this.f6723f == null) {
            return;
        }
        bmTextMarker.j(this.f6909G ? 1 : 0);
        this.f6911g.g(this.f6908F.x);
        this.f6911g.h(this.f6908F.y);
        this.f6723f.b();
    }

    public void setFontColor(int i4) {
        this.f6916l = i4;
        this.f6925u = 1;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            this.f6912h.d(i4);
            this.f6723f.b();
        }
    }

    public void setFontSize(int i4) {
        this.f6917m = i4;
        this.f6925u = 1;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            this.f6912h.e(i4);
            this.f6723f.b();
        }
    }

    public void setPerspective(boolean z4) {
        BmTextMarker bmTextMarker;
        this.f6929y = z4;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.f6911g) == null || this.f6723f == null) {
            return;
        }
        bmTextMarker.n(this.f6929y ? 1 : 0);
        this.f6723f.b();
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: position can not be null");
        }
        this.f6914j = latLng;
        this.f6925u = 1;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            if (this.f6911g == null || this.f6723f == null) {
                return;
            }
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6914j);
            this.f6911g.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
            this.f6723f.b();
        }
    }

    public void setPriority(int i4) {
        BmTextMarker bmTextMarker;
        this.f6907E = i4;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.f6911g) == null || this.f6723f == null) {
            return;
        }
        bmTextMarker.f((int) ((short) i4));
        this.f6723f.b();
    }

    public void setRotate(float f4) {
        this.f6924t = f4;
        this.f6925u = 1;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmTextMarker bmTextMarker = this.f6911g;
        if (bmTextMarker == null || this.f6723f == null) {
            return;
        }
        bmTextMarker.d(f4);
        this.f6723f.b();
    }

    public void setScale(float f4) {
        BmTextMarker bmTextMarker;
        if (f4 < Property.DEFAULT_FLOAT_VALUE) {
            f4 = 1.0f;
        }
        this.f6904B = f4;
        this.f6905C = f4;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.f6911g) == null || this.f6723f == null) {
            return;
        }
        bmTextMarker.e(f4);
        this.f6723f.b();
    }

    public void setScaleX(float f4) {
        BmTextMarker bmTextMarker;
        if (f4 < Property.DEFAULT_FLOAT_VALUE) {
            f4 = 1.0f;
        }
        this.f6904B = f4;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.f6911g) == null || this.f6723f == null) {
            return;
        }
        bmTextMarker.f(f4);
        this.f6723f.b();
    }

    public void setScaleY(float f4) {
        BmTextMarker bmTextMarker;
        if (f4 < Property.DEFAULT_FLOAT_VALUE) {
            f4 = 1.0f;
        }
        this.f6905C = f4;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.f6911g) == null || this.f6723f == null) {
            return;
        }
        bmTextMarker.g(f4);
        this.f6723f.b();
    }

    public void setStartLevel(int i4) {
        BmTextMarker bmTextMarker;
        this.f6927w = i4;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.f6911g) == null || this.f6723f == null) {
            return;
        }
        bmTextMarker.b(i4);
        this.f6723f.b();
    }

    public void setText(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("BDMapSDKException: text can not be null or empty");
        }
        this.f6913i = str;
        this.f6925u = 1;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            this.f6911g.b(str);
            this.f6723f.b();
        }
    }

    public void setTypeface(Typeface typeface) {
        this.f6918n = typeface;
        this.f6925u = 1;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            this.f6912h.c(typeface.getStyle());
            this.f6723f.b();
        }
    }

    public void setXOffset(int i4) {
        BmTextMarker bmTextMarker;
        this.f6903A = i4;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.f6911g) == null || this.f6723f == null) {
            return;
        }
        bmTextMarker.l(i4);
        this.f6723f.b();
    }

    public void setYOffset(int i4) {
        BmTextMarker bmTextMarker;
        this.f6930z = i4;
        if (!OverlayUtil.isOverlayUpgrade() || (bmTextMarker = this.f6911g) == null || this.f6723f == null) {
            return;
        }
        bmTextMarker.m(i4);
        this.f6723f.b();
    }

    public void startAnimation() {
        if (this.f6910H == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.f6910H.bmAnimation.start();
        this.f6723f.b();
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        this.f6911g = new BmTextMarker();
        this.f6912h = new BmTextStyle();
        this.f6911g.a(this);
        setDrawItem(this.f6911g);
        super.toDrawItem();
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6914j);
        this.f6911g.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
        this.f6911g.b(this.f6913i);
        this.f6912h.c(this.f6918n.getStyle());
        this.f6912h.e(this.f6917m);
        this.f6912h.d(this.f6916l);
        this.f6912h.c(this.f6919o);
        this.f6911g.a(this.f6912h);
        this.f6911g.d(this.f6924t);
        this.f6911g.b(this.f6920p);
        this.f6911g.c(this.f6921q);
        this.f6911g.n(this.f6929y ? 1 : 0);
        this.f6911g.l(this.f6903A);
        this.f6911g.m(this.f6930z);
        this.f6911g.n(this.f6929y ? 1 : 0);
        this.f6911g.l(this.f6903A);
        this.f6911g.m(this.f6930z);
        this.f6911g.f(this.f6904B);
        this.f6911g.g(this.f6905C);
        CollisionBehavior collisionBehavior = this.f6906D;
        if (collisionBehavior != null) {
            this.f6911g.e(collisionBehavior.ordinal());
        }
        this.f6911g.f(this.f6907E);
        Animation animation = this.f6910H;
        if (animation != null) {
            this.f6911g.a(animation.bmAnimation);
        }
        return this.f6911g;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a() {
        Typeface typeface = this.f6918n;
        if (typeface != null) {
            EnvDrawText.removeFontCache(typeface.hashCode());
        }
        return super.a();
    }
}
