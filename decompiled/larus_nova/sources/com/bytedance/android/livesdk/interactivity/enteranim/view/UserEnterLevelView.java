package com.bytedance.android.livesdk.interactivity.enteranim.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.livesdk.gift.effect.normal.utils.BitmapTranslateUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public class UserEnterLevelView extends FrameLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseEnterView f136836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f136837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f136838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Matrix f136839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Shader f136840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RectF f136841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Shader f136842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Shader f136843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ComposeShader f136844i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Bitmap f136845j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Canvas f136846k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Matrix f136847l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f136848m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Matrix f136849n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Paint f136850o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Paint f136851p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Paint f136852q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f136853r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f136854s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f136855t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f136856u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f136857v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f136858w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f136859x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f136860y;

    public final void c() {
        if (this.f136858w != 2) goto L9;
        float r100 = this.f136853r;
        float r101 = this.f136854s;
        if (this.f136856u == true) goto L16;
        this.f136856u = true;
        this.f136839d = new Matrix();
        this.f136838c = (-r100) * 3.0f;
        int r102 = getResources().getColor(R.color.ttlive_user_enter_text_color_gold);
        this.f136841f = new RectF(0.0f, 0.0f, r100, r101);
        float r110 = r100 * 4.0f;
        LinearGradient r111 = new LinearGradient(0.0f, 0.0f, r110, 0.0f, ColorUtils.setAlphaComponent(r102, 180), ColorUtils.setAlphaComponent(r102, 180), Shader.TileMode.CLAMP);
        Bitmap r103 = Bitmap.createBitmap((int) r110, (int) r101, Bitmap.Config.ARGB_8888);
        Canvas r104 = new Canvas(r103);
        Shader.TileMode r112 = Shader.TileMode.CLAMP;
        this.f136840e = new BitmapShader(r103, r112, r112);
        float r105 = r100 / 4.0f;
        float r106 = r101 / 4.0f;
        float r113 = getResources().getDimension(R.dimen.ttlive_user_enter_line_width);
        float r114 = getResources().getDimension(R.dimen.ttlive_user_enter_line_height);
        float r115 = r105 * 2.0f;
        float r107 = r106 * 2.0f;
        float r108 = r115 + r113;
        float r109 = r105 * 1.0f;
        float r116 = r106 * 3.0f;
        float r117 = 0.0f * r105;
        float r118 = r117 + r113;
        float r119 = r105 * 3.0f;
        float r120 = r106 * 1.0f;
        float r121 = r113 + r119;
        float r122 = 2.0f * r100;
        float r123 = r100 * 3.0f;
        r104.drawPaint(this.f136852q);
        this.f136851p.setShader(r111);
        this.f136851p.setStrokeWidth(r114);
        r104.drawLines(new float[]{r115, r107, r108, r107, r109, r116, r109 + r113, r116, r117 + r100, r107, r118 + r100, r107, r115 + r100, r116, r108 + r100, r116, r119 + r100, r120, r121 + r100, r120, r117 + r122, r116, r118 + r122, r116, r119 + r122, r120, r122 + r121, r120, r117 + r123, r116, r118 + r123, r116, r119 + r123, r120, r121 + r123, r120}, this.f136851p);
        this.f136840e.setLocalMatrix(this.f136849n);
    L16:
        invalidate();
        return;
    L9:
        if (this.f136857v == true) goto L16;
        this.f136857v = true;
        int r124 = getResources().getColor(R.color.ttlive_user_enter_light_white);
        int r125 = getResources().getColor(R.color.ttlive_user_enter_mask_alpha_ff);
        int r126 = getResources().getColor(R.color.ttlive_user_enter_mask_alpha_00);
        this.f136847l = new Matrix();
        this.f136848m = 0.0f;
        this.f136841f = new RectF(0.0f, 0.0f, this.f136853r, this.f136854s);
        this.f136842g = new LinearGradient(0.0f, 0.0f, this.f136853r, this.f136854s, r124, r124, Shader.TileMode.CLAMP);
        this.f136843h = new LinearGradient(0.0f, 0.0f, 30.0f, 7.0f, new int[]{r126, r125, r126}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        this.f136844i = new ComposeShader(this.f136842g, this.f136843h, PorterDuff.Mode.DST_ATOP);
        int r127 = (int) this.f136854s;
        int r128 = (int) this.f136853r;
        if (r127 <= 0) goto L15;
        if (r128 <= 0) goto L15;
        this.f136845j = Bitmap.createBitmap(r128, r127, Bitmap.Config.ARGB_8888);
        this.f136846k = new Canvas(this.f136845j);
    L15:
        this.f136842g.setLocalMatrix(this.f136849n);
        this.f136843h.setLocalMatrix(this.f136849n);
        this.f136844i.setLocalMatrix(this.f136849n);
        goto L16
    }

    public UserEnterLevelView(Context r100) {
        this(r100, null);
    }

    public final void a(Canvas r100) {
        Canvas r101 = this.f136846k;
        if (r101 == null) goto L16;
        r101.drawPaint(this.f136852q);
        float r102 = this.f136848m + 30.0f;
        this.f136848m = r102;
        this.f136847l.setTranslate(r102, 0.0f);
        this.f136843h.setLocalMatrix(this.f136847l);
        ComposeShader r103 = new ComposeShader(this.f136842g, this.f136843h, PorterDuff.Mode.DST_ATOP);
        this.f136844i = r103;
        r103.setLocalMatrix(this.f136849n);
        this.f136850o.setShader(this.f136844i);
        this.f136846k.drawRoundRect(this.f136841f, 10.0f, 10.0f, this.f136850o);
        this.f136850o.setAlpha(128);
        Bitmap r104 = this.f136845j;
        if (r104 == null) goto L7;
        r100.drawBitmap(r104, 0.0f, 0.0f, this.f136850o);
    L7:
        float r105 = this.f136848m;
        float r106 = this.f136853r;
        if (r105 < (r106 * 1.5f)) goto L11;
        this.f136857v = false;
        this.f136848m = (-r106) / 2.0f;
    L11:
        if (this.f136857v == true) goto L13;
        return;
    L13:
        if (this.f136848m > (r106 * 1.5f)) goto L18;
        postInvalidateDelayed(20);
        return;
    L18:
        return;
    }

    public final void b(Canvas r100) {
        float r101 = this.f136838c + 60.0f;
        this.f136838c = r101;
        this.f136839d.setTranslate(r101, 0.0f);
        this.f136840e.setLocalMatrix(this.f136839d);
        this.f136850o.setAlpha(240);
        this.f136850o.setShader(this.f136840e);
        r100.drawRoundRect(this.f136841f, 10.0f, 10.0f, this.f136850o);
        float r102 = this.f136838c;
        float r103 = this.f136853r;
        if (r102 < (r103 * 4.0f)) goto L6;
        this.f136856u = false;
        this.f136838c = -r103;
    L6:
        if (this.f136856u == true) goto L8;
        return;
    L8:
        if (this.f136838c > (r103 * 4.0f)) goto L12;
        postInvalidateDelayed(20);
        return;
    }

    public final void e(BaseEnterView r100) {
        this.f136837b = BitmapTranslateUtils.a(r100);
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (this.f136855t == false) goto L5;
        return;
    L5:
        if (this.f136860y == false) goto L22;
        this.f136850o.reset();
        r100.drawBitmap(this.f136837b, 0.0f, 0.0f, this.f136850o);
        if (this.f136859x == true) goto L19;
        return;
    L19:
        if (this.f136856u == false) goto L14;
        b(r100);     // Catch: Exception -> L17
    L18:
        return;
    L14:
        if (this.f136857v == false) goto L18;
        a(r100);     // Catch: Exception -> L17
    L23:
        return;
    }

    public void setEnableBitmap(boolean r100) {
        this.f136860y = r100;
    }

    public void setEnableShader(boolean r100) {
        this.f136859x = r100;
    }

    public void setUI(k32.a r100) {
        this.f136858w = r100.f501691h;
        this.f136836a.setUI(r100);
        this.f136837b = BitmapTranslateUtils.a(this.f136836a);
        this.f136853r = this.f136836a.getWidth();
        this.f136854s = this.f136836a.getHeight();
        invalidate();
    }

    public UserEnterLevelView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f136853r = this.f136836a.getWidth();
        float r102 = this.f136836a.getHeight();
        this.f136854s = r102;
        setMeasuredDimension((int) this.f136853r, (int) r102);
    }

    public UserEnterLevelView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f136855t = false;
        this.f136856u = false;
        this.f136857v = false;
        this.f136859x = true;
        this.f136860y = true;
        BaseEnterView r103 = new BaseEnterView(r100);
        this.f136836a = r103;
        r103.setDrawingCacheListener(this);
        this.f136837b = BitmapTranslateUtils.a(this.f136836a);
        Paint r104 = new Paint();
        this.f136850o = r104;
        r104.setAntiAlias(true);
        Paint r105 = new Paint();
        this.f136851p = r105;
        r105.setAntiAlias(true);
        Paint r106 = new Paint();
        this.f136852q = r106;
        r106.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Matrix r107 = new Matrix();
        this.f136849n = r107;
        r107.setTranslate(1.0f, 0.0f);
        setWillNotDraw(false);
    }

    public final void d(k32.a r100, int r101, CharSequence r102) {
        if (r100 == null) goto L41;
        BaseEnterView r103 = this.f136836a;
        if (r103 == null) goto L42;
        this.f136858w = r100.f501691h;
        View r104 = r103.f136810f;
        if (r104 == null) goto L39;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L12;
        r105.height = r101;
    L12:
        View r106 = r103.f136810f;
        if (r106 == null) goto L15;
        r106.setLayoutParams(r105);
    L15:
        View r107 = r103.f136810f;
        if (r107 == null) goto L18;
        r107.setBackgroundResource(R.drawable.ttlive_bg_drive_enter);
    L18:
        ImageView r108 = r103.f136809e;
        if (r108 == null) goto L22;
        r108.setVisibility(8);
    L22:
        if (TextUtils.isEmpty(r102) == true) goto L26;
        TextView r109 = r103.f136808d;
        if (r109 == null) goto L29;
        r109.setText(r102);
    L29:
        TextView r110 = r103.f136807c;
        if (r110 == null) goto L32;
        r110.setText(r100.f501685b);
    L32:
        TextView r111 = r103.f136807c;
        if (r111 == null) goto L35;
        r111.setTextColor(r103.getResources().getColor(R.color.ttlive_drive_enter_text_color));
    L35:
        TextView r112 = r103.f136808d;
        if (r112 == null) goto L38;
        r112.setTextColor(r103.getResources().getColor(R.color.ttlive_drive_enter_text_color));
    L38:
        ImageLoader.loadBitmapSynchronized(r100.f501690g, 0, 0, new b(r103));
        goto L39
    L26:
        TextView r113 = r103.f136808d;
        if (r113 == null) goto L29;
        r113.setText(R.string.ttlive_entry_description_level_mid);
    L39:
        this.f136837b = BitmapTranslateUtils.a(this.f136836a);
        this.f136853r = this.f136836a.getWidth();
        this.f136854s = this.f136836a.getHeight();
        invalidate();
        return;
    L42:
        return;
    }
}
