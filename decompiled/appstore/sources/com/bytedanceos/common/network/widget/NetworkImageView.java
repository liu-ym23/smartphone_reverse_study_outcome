package com.bytedanceos.common.network.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bytedanceos.common.R$color;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$styleable;
import com.bytedanceos.common.toolbox.glide.GlideRoundTransform;
import com.bytedanceos.common.toolbox.glide.b;
import com.bytedanceos.common.toolbox.glide.c;
import com.bytedanceos.common.toolbox.i;
import com.google.common.primitives.Ints;
import com.obric.oui.image.OImage;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkImageView extends OImage {
    public boolean A;
    public final RectF B;
    public final Paint C;
    public final float D;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f9880m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f9881n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f9882o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f9883p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f9884q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f9885r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f9886s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f9887t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public GlideRoundTransform f9888u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public c f9889v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Target f9890w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Request f9891x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ArrayList f9892y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f9893z;

    public class a implements Target {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NetworkImageView f9894a;

        public a(NetworkImageView r10) {
            this.f9894a = r10;
        }

        public void a(Bitmap r10, Transition r11) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (r10.isRecycled() == true) goto L8;
            this.f9894a.setImageBitmap(r10);
            return;
        }

        @Override // com.bumptech.glide.request.target.Target
        public Request getRequest() {
            return NetworkImageView.a(this.f9894a);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void getSize(SizeReadyCallback r10) {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onDestroy() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable r10) {
            this.f9894a.setImageDrawable(r10);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable r10) {
            this.f9894a.setImageDrawable(r10);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadStarted(Drawable r10) {
            this.f9894a.setImageDrawable(r10);
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object r10, Transition r11) {
            a((Bitmap) r10, r11);
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStart() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStop() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void removeCallback(SizeReadyCallback r10) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void setRequest(Request r10) {
            NetworkImageView.b(this.f9894a, r10);
        }
    }

    public NetworkImageView(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ Request a(NetworkImageView r10) {
        return r10.f9891x;
    }

    public static /* synthetic */ Request b(NetworkImageView r10, Request r11) {
        r10.f9891x = r11;
        return r11;
    }

    private c getRotateTransformation() {
        if (this.f9885r != 0.0f) goto L7;
        return null;
    L7:
        if (this.f9889v != null) goto L9;
        this.f9889v = new c();
    L9:
        this.f9889v.a(this.f9885r);
        return this.f9889v;
    }

    private GlideRoundTransform getRoundTransform() {
        if (this.f9884q > 0.0f) goto L7;
        return null;
    L7:
        if (this.f9888u != null) goto L9;
        this.f9888u = new GlideRoundTransform();
    L9:
        this.f9888u.f(15).e((int) this.f9884q);
        return this.f9888u;
    }

    public void c(boolean r12, boolean r13) {
        if (TextUtils.isEmpty(this.f9880m) == false) goto L6;
        d();
        return;
    L6:
        int r14 = getMeasuredWidth();
        int r10 = getMeasuredHeight();
        if (this.A == false) goto L18;
        ViewGroup.LayoutParams r11 = getLayoutParams();
        if (r11 == null) goto L18;
        if (r11.width != (-2)) goto L14;
        r14 = Integer.MIN_VALUE;
    L14:
        if (r11.height != (-2)) goto L18;
        if (this.f9893z != 0.0f) goto L18;
        int r15 = r14;
        int r16 = Integer.MIN_VALUE;
    L19:
        if (r12 == false) goto L24;
        if (this.f9887t == true) goto L24;
        return;
    L24:
        if (this.f9890w != null) goto L26;
        this.f9890w = new a(this);
    L26:
        this.f9892y.clear();
        if (getRoundTransform() == null) goto L30;
        this.f9892y.add(getRoundTransform());
    L30:
        if (getRotateTransformation() == null) goto L33;
        this.f9892y.add(getRotateTransformation());
    L33:
        if (this.f9892y.isEmpty() == true) goto L36;
        BitmapTransformation[] r17 = (BitmapTransformation[]) this.f9892y.toArray(new BitmapTransformation[this.f9892y.size()]);
    L37:
        this.f9890w = b.f(getContext(), this.f9880m, this.f9882o, r15, r16, r17, this.f9890w);
        return;
    L36:
        r17 = null;
    L18:
        r15 = r14;
        r16 = r10;
        goto L19
    }

    public void d() {
        int r10 = this.f9882o;
        if (r10 == 0) goto L5;
        setImageResource(r10);
        return;
    L5:
        setImageBitmap(null);
    }

    public void e(String r10, float r11) {
        f(r10, r11, false);
    }

    public void f(String r10, float r11, boolean r12) {
        g(r10, r11, r12, 0.0f);
    }

    public void g(String r10, float r11, boolean r12, float r13) {
        this.f9880m = r10;
        this.f9881n = null;
        setRoundRX(r11);
        this.f9886s = r12;
        this.f9885r = r13;
        c(false, r12);
    }

    public float getRoundRX() {
        return this.f9884q;
    }

    public String getUrl() {
        return this.f9880m;
    }

    public void h(String r10, boolean r11) {
        f(r10, 0.0f, r11);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (TextUtils.isEmpty(this.f9881n) == false) goto L5;
        return;
    L5:
        if (this.f9881n.equals(this.f9880m) == false) goto L9;
        i.e("收到的的圆角为传递towindow", "radius: " + this.f9884q);
        g(this.f9881n, this.f9884q, this.f9886s, this.f9885r);
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Target r10 = this.f9890w;
        if (r10 == null) goto L5;
        b.d(this, r10);
    L5:
        this.f9881n = this.f9880m;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        c(true, this.f9886s);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getSize(r10);
        float r13 = this.f9893z;
        if (r13 == 0.0f) goto L5;
        r11 = View.MeasureSpec.makeMeasureSpec((int) (r12 / r13), Ints.MAX_POWER_OF_TWO);
    L5:
        super.onMeasure(r10, r11);
    }

    public void setDefaultImageResId(int r10) {
        this.f9882o = r10;
    }

    public void setErrorImageResId(int r10) {
        this.f9883p = r10;
    }

    public void setImageUrl(String r10) {
        h(r10, true);
    }

    public void setLoadOriginalSize(boolean r10) {
        this.A = r10;
    }

    public void setReloadBitmap(boolean r10) {
        this.f9887t = r10;
    }

    public void setRoundRX(float r10) {
        this.f9884q = r10;
        setRadiusPx(r10);
    }

    public NetworkImageView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.NetworkImageView);
        this.f9893z = r12.getFloat(R$styleable.NetworkImageView_ratio, 0.0f);
        r12.recycle();
    }

    public NetworkImageView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        int r13 = R$drawable.oui_default_app_icon;
        this.f9882o = r13;
        this.f9883p = r13;
        this.f9884q = 0.0f;
        this.f9885r = 0.0f;
        this.f9887t = true;
        this.f9892y = new ArrayList();
        this.f9893z = 0.0f;
        this.A = false;
        this.B = new RectF();
        Paint r14 = new Paint(1);
        this.C = r14;
        float r15 = r10.getResources().getDimension(R$dimen.oui_image_stroke_width);
        this.D = r15;
        r14.setStyle(Paint.Style.STROKE);
        r14.setStrokeWidth(r15);
        r14.setColor(ContextCompat.b(r10, R$color.oui_line_1));
    }
}
