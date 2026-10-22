package stepos.support.v7.app.palette;

import O6.s;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.lang.reflect.Array;
import stepos.support.v7.app.palette.StepOSPalettePopupActivity;
import stepos.support.v7.appcompat.R$id;
import stepos.support.v7.appcompat.R$layout;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: o, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static d f40686o;

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f40687a;

    /* renamed from: b, reason: collision with root package name */
    public WindowManager f40688b;

    /* renamed from: c, reason: collision with root package name */
    public View f40689c;

    /* renamed from: d, reason: collision with root package name */
    public int f40690d;

    /* renamed from: e, reason: collision with root package name */
    public int f40691e;

    /* renamed from: f, reason: collision with root package name */
    public ShapeDrawable f40692f;

    /* renamed from: g, reason: collision with root package name */
    public ColorGridView f40693g;

    /* renamed from: h, reason: collision with root package name */
    public int f40694h;

    /* renamed from: i, reason: collision with root package name */
    public float f40695i;

    /* renamed from: j, reason: collision with root package name */
    public float f40696j;

    /* renamed from: k, reason: collision with root package name */
    public float f40697k;

    /* renamed from: l, reason: collision with root package name */
    public float f40698l;

    /* renamed from: m, reason: collision with root package name */
    public View f40699m;

    /* renamed from: n, reason: collision with root package name */
    public Boolean f40700n = Boolean.FALSE;

    public class a implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f40701a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f40702b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f40703c;

        public a(Context context, int[] iArr, StepOSPalettePopupActivity.a aVar, Context context2) {
            this.f40701a = context;
            this.f40702b = iArr;
            this.f40703c = context2;
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                d dVar = d.this;
                dVar.f40695i = dVar.f40689c.getX();
                d dVar2 = d.this;
                dVar2.f40696j = dVar2.f40689c.getY();
                d.this.f40697k = motionEvent.getRawX();
                d.this.f40698l = motionEvent.getRawY();
                d dVar3 = d.this;
                if (dVar3.u(dVar3.f40697k, d.this.f40698l, d.this.f40689c)) {
                    return true;
                }
                float width = d.this.f40697k - (d.this.f40695i + (d.this.f40689c.getWidth() / 2));
                float height = d.this.f40698l - (((d.this.f40696j + (d.this.f40689c.getHeight() / 2)) + s.d(this.f40701a)) + s.a(48.0f, this.f40701a));
                d.this.f40689c.setX(d.this.f40695i + width);
                d.this.f40689c.setY(d.this.f40696j + height);
                d dVar4 = d.this;
                dVar4.f40695i = dVar4.f40689c.getX();
                d dVar5 = d.this;
                dVar5.f40696j = dVar5.f40689c.getY();
                return true;
            }
            if (action == 1) {
                d.this.f40688b.removeView(d.this.f40699m);
                StepOSPalettePopupActivity.D(this.f40703c, d.this.t());
                d.this.t();
                throw null;
            }
            if (action == 2) {
                float rawX = d.this.f40695i + (motionEvent.getRawX() - d.this.f40697k);
                float rawY = d.this.f40696j + (motionEvent.getRawY() - d.this.f40698l);
                d.this.f40689c.getLocationOnScreen(this.f40702b);
                d.this.f40689c.setX(rawX);
                d.this.f40689c.setY(rawY);
                int i10 = this.f40702b[0] + (d.this.f40690d / 2);
                int i11 = this.f40702b[1] + (d.this.f40691e / 2);
                if (i10 > 4 && i10 < d.this.f40687a.getWidth() - 4 && i11 > 4 && i11 < d.this.f40687a.getHeight() - 4) {
                    d.this.y(this.f40702b);
                    d.this.t();
                    throw null;
                }
            }
            return true;
        }
    }

    public static /* synthetic */ void a(d dVar, int[] iArr) {
        dVar.f40689c.getLocationOnScreen(iArr);
        dVar.y(iArr);
    }

    public static d s() {
        if (f40686o == null) {
            f40686o = new d();
        }
        return f40686o;
    }

    public final int[][] r(int i10, int i11) {
        int i12 = i10 - 3;
        int i13 = i10 + 3;
        int i14 = i11 - 3;
        int i15 = i11 + 3;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 7, 7);
        for (int i16 = i14; i16 <= i15; i16++) {
            for (int i17 = i12; i17 <= i13; i17++) {
                iArr[i16 - i14][i17 - i12] = this.f40687a.getPixel(i17, i16);
            }
        }
        return iArr;
    }

    public int t() {
        return this.f40694h;
    }

    public final boolean u(float f10, float f11, View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i10 = iArr[0];
        rect.left = i10;
        rect.top = iArr[1];
        rect.right = i10 + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        return rect.contains((int) f10, (int) f11);
    }

    public void v() {
        View view = this.f40699m;
        if (view == null || !view.isAttachedToWindow()) {
            return;
        }
        this.f40688b.removeView(this.f40699m);
        this.f40687a.recycle();
    }

    public void w(Bitmap bitmap) {
        this.f40687a = bitmap;
    }

    @SuppressLint({"InflateParams"})
    public void x(Context context, StepOSPalettePopupActivity.a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.f40688b = (WindowManager) applicationContext.getSystemService("window");
        int iA = (int) s.a(130.0f, applicationContext);
        this.f40691e = iA;
        this.f40690d = iA;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2038, 776, -3);
        layoutParams.layoutInDisplayCutoutMode = 3;
        View viewInflate = LayoutInflater.from(applicationContext).inflate(R$layout.layout_my_window, (ViewGroup) null);
        this.f40699m = viewInflate;
        this.f40693g = (ColorGridView) viewInflate.findViewById(R$id.scale_magnifier);
        this.f40689c = this.f40699m.findViewById(R$id.out_bkg);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        this.f40692f = shapeDrawable;
        shapeDrawable.setIntrinsicWidth(this.f40690d);
        this.f40692f.setIntrinsicHeight(this.f40691e);
        this.f40689c.setBackground(this.f40692f);
        this.f40688b.addView(this.f40699m, layoutParams);
        final int[] iArr = new int[2];
        this.f40689c.post(new Runnable() { // from class: stepos.support.v7.app.palette.c
            @Override // java.lang.Runnable
            public final void run() {
                d.a(this.f40684a, iArr);
            }
        });
        this.f40699m.setOnTouchListener(new a(context, iArr, aVar, applicationContext));
    }

    public final void y(int[] iArr) {
        int[][] iArrR = r(iArr[0] + (this.f40690d / 2), iArr[1] + (this.f40691e / 2));
        this.f40693g.a(iArrR);
        int i10 = iArrR[3][3];
        this.f40694h = i10;
        this.f40692f.setTint(i10);
    }
}
