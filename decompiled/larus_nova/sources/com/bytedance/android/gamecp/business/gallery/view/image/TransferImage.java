package com.bytedance.android.gamecp.business.gallery.view.image;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeHolder;

/* JADX INFO: loaded from: classes44.dex */
public class TransferImage extends PhotoView {
    public int H0;
    public int L0;
    public int P0;
    public DraweeHolder<GenericDraweeHierarchy> V;
    public int V0;
    public int W;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public long f53342b1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public boolean f53343g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public Paint f53344h1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f53345k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public Matrix f53346k1;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final int f53347p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public c f53348p1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public b f53349v1;

    public class a implements Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f53350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f53351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f53352c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f53353d;

        public final String toString() {
            return "[left:" + this.f53350a + " top:" + this.f53351b + " width:" + this.f53352c + " height:" + this.f53353d + "]";
        }

        public final Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public a() {
        }
    }

    public interface b {
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f53354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f53355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f53356c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a f53357d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public a f53358e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public a f53359f;

        public c() {
        }
    }

    private DraweeHolder getDraweeHolder() {
        if (this.V != null) goto L6;
        this.V = DraweeHolder.create(new GenericDraweeHierarchyBuilder(getResources()).build(), getContext());
    L6:
        return this.V;
    }

    public DraweeController getController() {
        return getDraweeHolder().getController();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        DraweeHolder<GenericDraweeHierarchy> r100 = this.V;
        if (r100 == null) goto L6;
        r100.onAttach();
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DraweeHolder<GenericDraweeHierarchy> r100 = this.V;
        if (r100 == null) goto L6;
        r100.onDetach();
        return;
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        DraweeHolder<GenericDraweeHierarchy> r100 = this.V;
        if (r100 == null) goto L6;
        r100.onAttach();
        return;
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        DraweeHolder<GenericDraweeHierarchy> r100 = this.V;
        if (r100 == null) goto L6;
        r100.onDetach();
        return;
    }

    public long getDuration() {
        return this.f53342b1;
    }

    public int getState() {
        return this.W;
    }

    public TransferImage(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r110) {
        if (getDrawable() != null) goto L6;
        return;
    L6:
        if (this.W != 0) goto L8;
        r110.drawPaint(this.f53344h1);
        super.onDraw(r110);     // Catch: Exception -> L124
        return;
    L124:
        e = move-exception;
        e.printStackTrace();
        return;
    L8:
        if (this.f53343g1 == false) goto L32;
        Drawable r100 = getDrawable();
        if (r100 == null) goto L32;
        if (getWidth() == 0) goto L32;
        if (getHeight() == 0) goto L32;
        this.f53348p1 = new c();
        float r101 = this.H0 / r100.getIntrinsicWidth();
        float r102 = this.L0 / r100.getIntrinsicHeight();
        if (r101 > r102) goto L21;
        r101 = r102;
    L21:
        this.f53348p1.f53354a = r101;
        float r103 = getWidth() / r100.getIntrinsicWidth();
        float r104 = getHeight() / r100.getIntrinsicHeight();
        if (r103 < r104) goto L26;
        r103 = r104;
    L26:
        if (this.f53345k0 == 200) goto L28;
    L30:
        this.f53348p1.f53355b = r103;
    L31:
        c r105 = this.f53348p1;
        a r106 = new a();
        r105.f53357d = r106;
        r106.f53350a = this.P0;
        r106.f53351b = this.V0;
        r106.f53352c = this.H0;
        r106.f53353d = this.L0;
        r105.f53358e = new a();
        float r107 = r100.getIntrinsicWidth() * this.f53348p1.f53355b;
        float r108 = r100.getIntrinsicHeight();
        c r109 = this.f53348p1;
        float r111 = r108 * r109.f53355b;
        r109.f53358e.f53350a = (getWidth() - r107) / 2.0f;
        this.f53348p1.f53358e.f53351b = (getHeight() - r111) / 2.0f;
        c r112 = this.f53348p1;
        a r113 = r112.f53358e;
        r113.f53352c = r107;
        r113.f53353d = r111;
        r112.f53359f = new a();
        goto L32
    L28:
        if (this.f53347p0 != 201) goto L30;
        this.f53348p1.f53355b = r101;
    L32:
        c r114 = this.f53348p1;
        if (r114 != null) goto L37;
        super.onDraw(r110);
        return;
    L37:
        if (this.f53343g1 == false) goto L64;
        int r115 = this.W;
        if (r115 == 1) goto L57;
        if (r115 == 2) goto L50;
        if (r115 != 3) goto L64;
        r114.f53356c = r114.f53354a;
        a r116 = r114.f53358e;     // Catch: CloneNotSupportedException -> L48
        if (r116 == null) goto L64;
        r114.f53359f = (a) r116.clone();     // Catch: CloneNotSupportedException -> L48
    L48:
        e = move-exception;
        e.printStackTrace();
        goto L64
    L50:
        r114.f53356c = r114.f53355b;
        a r117 = r114.f53358e;     // Catch: CloneNotSupportedException -> L55
        if (r117 == null) goto L64;
        r114.f53359f = (a) r117.clone();     // Catch: CloneNotSupportedException -> L55
    L55:
        e = move-exception;
        e.printStackTrace();
        goto L64
    L57:
        r114.f53356c = r114.f53354a;
        a r118 = r114.f53357d;     // Catch: CloneNotSupportedException -> L62
        if (r118 == null) goto L64;
        r114.f53359f = (a) r118.clone();     // Catch: CloneNotSupportedException -> L62
    L62:
        e = move-exception;
        e.printStackTrace();
    L64:
        r110.drawPaint(this.f53344h1);
        int r119 = r110.getSaveCount();
        r110.save();
        Drawable r120 = getDrawable();
        if (r120 == null) goto L74;
        c r121 = this.f53348p1;
        if (r121 == null) goto L74;
        if (r121.f53359f == null) goto L74;
        Matrix r122 = this.f53346k1;
        if (r122 == null) goto L74;
        float r123 = r121.f53356c;
        r122.setScale(r123, r123);
        Matrix r124 = this.f53346k1;
        float r125 = (this.f53348p1.f53356c * r120.getIntrinsicWidth()) / 2.0f;
        c r126 = this.f53348p1;
        r124.postTranslate(-(r125 - (r126.f53359f.f53352c / 2.0f)), -(((r126.f53356c * r120.getIntrinsicHeight()) / 2.0f) - (this.f53348p1.f53359f.f53353d / 2.0f)));
    L74:
        a r127 = this.f53348p1.f53359f;
        r110.translate(r127.f53350a, r127.f53351b);
        a r128 = this.f53348p1.f53359f;
        r110.clipRect(0.0f, 0.0f, r128.f53352c, r128.f53353d);
        r110.concat(this.f53346k1);
        getDrawable().draw(r110);
        r110.restoreToCount(r119);
        if (this.f53343g1 == true) goto L77;
        return;
    L77:
        if (this.W == 3) goto L136;
        this.f53343g1 = false;
        int r129 = this.f53345k0;
        if (r129 == 100) goto L97;
        if (r129 != 200) goto L145;
        c r130 = this.f53348p1;
        if (r130 != null) goto L85;
        return;
    L85:
        if (r130.f53357d != null) goto L87;
        return;
    L87:
        if (r130.f53358e == null) goto L146;
        ValueAnimator r131 = new ValueAnimator();
        r131.setDuration(this.f53342b1);
        r131.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.f53347p0 != 201) goto L92;
        c r132 = this.f53348p1;
        PropertyValuesHolder r133 = PropertyValuesHolder.ofFloat("left", new float[]{r132.f53357d.f53350a, r132.f53358e.f53350a});
        c r134 = this.f53348p1;
        PropertyValuesHolder r135 = PropertyValuesHolder.ofFloat("top", new float[]{r134.f53357d.f53351b, r134.f53358e.f53351b});
        c r136 = this.f53348p1;
        PropertyValuesHolder r137 = PropertyValuesHolder.ofFloat("width", new float[]{r136.f53357d.f53352c, r136.f53358e.f53352c});
        c r138 = this.f53348p1;
        r131.setValues(new PropertyValuesHolder[]{r133, r135, r137, PropertyValuesHolder.ofFloat("height", new float[]{r138.f53357d.f53353d, r138.f53358e.f53353d})});
        r131.addUpdateListener(new com.bytedance.android.gamecp.business.gallery.view.image.a(this));
    L93:
        r131.addListener(new com.bytedance.android.gamecp.business.gallery.view.image.c(this));
        if (this.W != 1) goto L96;
        r131.start();
        return;
    L96:
        r131.reverse();
        return;
    L92:
        c r139 = this.f53348p1;
        PropertyValuesHolder r140 = PropertyValuesHolder.ofFloat("left", new float[]{r139.f53357d.f53350a, r139.f53358e.f53350a});
        c r141 = this.f53348p1;
        PropertyValuesHolder r142 = PropertyValuesHolder.ofFloat("top", new float[]{r141.f53357d.f53351b, r141.f53358e.f53351b});
        c r143 = this.f53348p1;
        PropertyValuesHolder r144 = PropertyValuesHolder.ofFloat("width", new float[]{r143.f53357d.f53352c, r143.f53358e.f53352c});
        c r145 = this.f53348p1;
        PropertyValuesHolder r146 = PropertyValuesHolder.ofFloat("height", new float[]{r145.f53357d.f53353d, r145.f53358e.f53353d});
        c r147 = this.f53348p1;
        r131.setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scale", new float[]{r147.f53354a, r147.f53355b}), r140, r142, r144, r146});
        r131.addUpdateListener(new com.bytedance.android.gamecp.business.gallery.view.image.b(this));
        goto L93
    L146:
        return;
    L145:
        return;
    L97:
        c r148 = this.f53348p1;
        if (r148 != null) goto L100;
        return;
    L100:
        if (r148.f53357d != null) goto L102;
        return;
    L102:
        if (r148.f53358e == null) goto L147;
        ValueAnimator r149 = new ValueAnimator();
        r149.setDuration(this.f53342b1);
        r149.setInterpolator(new AccelerateDecelerateInterpolator());
        c r150 = this.f53348p1;
        a r151 = r150.f53357d;
        if (r151.f53352c != 0.0f) goto L107;
    L116:
        float r152 = r150.f53355b;
        PropertyValuesHolder r153 = PropertyValuesHolder.ofFloat("scale", new float[]{r152, r152});
        float r154 = this.f53348p1.f53358e.f53350a;
        PropertyValuesHolder r155 = PropertyValuesHolder.ofFloat("left", new float[]{r154, r154});
        float r156 = this.f53348p1.f53358e.f53351b;
        PropertyValuesHolder r157 = PropertyValuesHolder.ofFloat("top", new float[]{r156, r156});
        float r158 = this.f53348p1.f53358e.f53352c;
        PropertyValuesHolder r159 = PropertyValuesHolder.ofFloat("width", new float[]{r158, r158});
        float r160 = this.f53348p1.f53358e.f53353d;
        PropertyValuesHolder r161 = PropertyValuesHolder.ofFloat("height", new float[]{r160, r160});
    L117:
        r149.setValues(new PropertyValuesHolder[]{r153, r155, r157, r159, r161});
        r149.addUpdateListener(new d(this));
        r149.addListener(new e(this));
        if (this.W != 1) goto L120;
        r149.start();
        return;
    L120:
        r149.reverse();
        return;
    L107:
        if (r151.f53353d == 0.0f) goto L116;
        a r162 = r150.f53358e;
        if (r162.f53352c != 0.0f) goto L112;
    L115:
        float r163 = r150.f53354a;
        r153 = PropertyValuesHolder.ofFloat("scale", new float[]{r163, r163});
        float r164 = this.f53348p1.f53357d.f53350a;
        r155 = PropertyValuesHolder.ofFloat("left", new float[]{r164, r164});
        float r165 = this.f53348p1.f53357d.f53351b;
        r157 = PropertyValuesHolder.ofFloat("top", new float[]{r165, r165});
        float r166 = this.f53348p1.f53357d.f53352c;
        r159 = PropertyValuesHolder.ofFloat("width", new float[]{r166, r166});
        float r167 = this.f53348p1.f53357d.f53353d;
        r161 = PropertyValuesHolder.ofFloat("height", new float[]{r167, r167});
        goto L117
    L112:
        if (r162.f53353d == 0.0f) goto L115;
        r153 = PropertyValuesHolder.ofFloat("scale", new float[]{r150.f53354a, r150.f53355b});
        c r168 = this.f53348p1;
        r155 = PropertyValuesHolder.ofFloat("left", new float[]{r168.f53357d.f53350a, r168.f53358e.f53350a});
        c r169 = this.f53348p1;
        r157 = PropertyValuesHolder.ofFloat("top", new float[]{r169.f53357d.f53351b, r169.f53358e.f53351b});
        c r170 = this.f53348p1;
        r159 = PropertyValuesHolder.ofFloat("width", new float[]{r170.f53357d.f53352c, r170.f53358e.f53352c});
        c r171 = this.f53348p1;
        r161 = PropertyValuesHolder.ofFloat("height", new float[]{r171.f53357d.f53353d, r171.f53358e.f53353d});
        goto L117
    L147:
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (getDraweeHolder().onTouchEvent(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.onTouchEvent(r100) == true) goto L8;
        return false;
    }

    public void setController(DraweeController r100) {
        getDraweeHolder().setController(r100);
    }

    public void setDuration(long r100) {
        this.f53342b1 = r100;
    }

    public void setOnTransferListener(b r100) {
        this.f53349v1 = r100;
    }

    public void setState(int r100) {
        this.W = r100;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean verifyDrawable(Drawable r100) {
        super.verifyDrawable(r100);
        if (r100 != getDraweeHolder().getHierarchy().getTopLevelDrawable()) goto L5;
        return true;
    L5:
        return false;
    }

    public TransferImage(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public TransferImage(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.W = 0;
        this.f53345k0 = 100;
        this.f53347p0 = 201;
        this.f53342b1 = 300;
        this.f53343g1 = false;
        this.f53346k1 = new Matrix();
        Paint r103 = new Paint();
        this.f53344h1 = r103;
        r103.setAlpha(0);
        this.V = getDraweeHolder();
    }
}
