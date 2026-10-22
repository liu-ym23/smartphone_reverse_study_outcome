package stepos.support.v7.app.palette;

import N1.i;
import X4.h;
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

/* loaded from: classes.dex */
final class d {

    /* renamed from: o, reason: collision with root package name */
    private static d f20950o;

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f20951a;

    /* renamed from: b, reason: collision with root package name */
    private WindowManager f20952b;

    /* renamed from: c, reason: collision with root package name */
    private View f20953c;

    /* renamed from: d, reason: collision with root package name */
    private int f20954d;

    /* renamed from: e, reason: collision with root package name */
    private int f20955e;

    /* renamed from: f, reason: collision with root package name */
    private ShapeDrawable f20956f;

    /* renamed from: g, reason: collision with root package name */
    private ColorGridView f20957g;

    /* renamed from: h, reason: collision with root package name */
    private int f20958h;

    /* renamed from: i, reason: collision with root package name */
    private float f20959i;

    /* renamed from: j, reason: collision with root package name */
    private float f20960j;

    /* renamed from: k, reason: collision with root package name */
    private float f20961k;

    /* renamed from: l, reason: collision with root package name */
    private float f20962l;

    /* renamed from: m, reason: collision with root package name */
    private View f20963m;

    /* renamed from: n, reason: collision with root package name */
    Boolean f20964n = Boolean.FALSE;

    class a implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f20965a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int[] f20966b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f20967c;

        a(Context context, int[] iArr, StepOSPalettePopupActivity.a aVar, Context context2) {
            this.f20965a = context;
            this.f20966b = iArr;
            this.f20967c = context2;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                d dVar = d.this;
                dVar.f20959i = dVar.f20953c.getX();
                d dVar2 = d.this;
                dVar2.f20960j = dVar2.f20953c.getY();
                d.this.f20961k = motionEvent.getRawX();
                d.this.f20962l = motionEvent.getRawY();
                d dVar3 = d.this;
                if (dVar3.u(dVar3.f20961k, d.this.f20962l, d.this.f20953c)) {
                    return true;
                }
                float width = d.this.f20961k - (d.this.f20959i + (d.this.f20953c.getWidth() / 2));
                float height = d.this.f20962l - (((d.this.f20960j + (d.this.f20953c.getHeight() / 2)) + i.e(this.f20965a)) + i.a(48.0f, this.f20965a));
                d.this.f20953c.setX(d.this.f20959i + width);
                d.this.f20953c.setY(d.this.f20960j + height);
                d dVar4 = d.this;
                dVar4.f20959i = dVar4.f20953c.getX();
                d dVar5 = d.this;
                dVar5.f20960j = dVar5.f20953c.getY();
                return true;
            }
            if (action == 1) {
                d.this.f20952b.removeView(d.this.f20963m);
                StepOSPalettePopupActivity.F(this.f20967c, d.this.t());
                d.this.t();
                throw null;
            }
            if (action == 2) {
                float rawX = d.this.f20959i + (motionEvent.getRawX() - d.this.f20961k);
                float rawY = d.this.f20960j + (motionEvent.getRawY() - d.this.f20962l);
                d.this.f20953c.getLocationOnScreen(this.f20966b);
                d.this.f20953c.setX(rawX);
                d.this.f20953c.setY(rawY);
                int i5 = this.f20966b[0] + (d.this.f20954d / 2);
                int i6 = this.f20966b[1] + (d.this.f20955e / 2);
                if (i5 > 4 && i5 < d.this.f20951a.getWidth() - 4 && i6 > 4 && i6 < d.this.f20951a.getHeight() - 4) {
                    d.this.y(this.f20966b);
                    d.this.t();
                    throw null;
                }
            }
            return true;
        }
    }

    private d() {
    }

    public static /* synthetic */ void a(d dVar, int[] iArr) {
        dVar.f20953c.getLocationOnScreen(iArr);
        dVar.y(iArr);
    }

    private int[][] r(int i5, int i6) {
        int i7 = i5 - 3;
        int i8 = i5 + 3;
        int i9 = i6 - 3;
        int i10 = i6 + 3;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 7, 7);
        for (int i11 = i9; i11 <= i10; i11++) {
            for (int i12 = i7; i12 <= i8; i12++) {
                iArr[i11 - i9][i12 - i7] = this.f20951a.getPixel(i12, i11);
            }
        }
        return iArr;
    }

    public static d s() {
        if (f20950o == null) {
            f20950o = new d();
        }
        return f20950o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(float f5, float f6, View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i5 = iArr[0];
        rect.left = i5;
        rect.top = iArr[1];
        rect.right = i5 + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        return rect.contains((int) f5, (int) f6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int[] iArr) {
        int[][] iArrR = r(iArr[0] + (this.f20954d / 2), iArr[1] + (this.f20955e / 2));
        this.f20957g.a(iArrR);
        int i5 = iArrR[3][3];
        this.f20958h = i5;
        this.f20956f.setTint(i5);
    }

    public int t() {
        return this.f20958h;
    }

    public void v() {
        View view = this.f20963m;
        if (view == null || !view.isAttachedToWindow()) {
            return;
        }
        this.f20952b.removeView(this.f20963m);
        this.f20951a.recycle();
    }

    public void w(Bitmap bitmap) {
        this.f20951a = bitmap;
    }

    public void x(Context context, StepOSPalettePopupActivity.a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.f20952b = (WindowManager) applicationContext.getSystemService("window");
        int iA = (int) i.a(130.0f, applicationContext);
        this.f20955e = iA;
        this.f20954d = iA;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2038, 776, -3);
        layoutParams.layoutInDisplayCutoutMode = 3;
        View viewInflate = LayoutInflater.from(applicationContext).inflate(h.f6030b, (ViewGroup) null);
        this.f20963m = viewInflate;
        this.f20957g = (ColorGridView) viewInflate.findViewById(X4.f.f5960H);
        this.f20953c = this.f20963m.findViewById(X4.f.f5956D);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        this.f20956f = shapeDrawable;
        shapeDrawable.setIntrinsicWidth(this.f20954d);
        this.f20956f.setIntrinsicHeight(this.f20955e);
        this.f20953c.setBackground(this.f20956f);
        this.f20952b.addView(this.f20963m, layoutParams);
        final int[] iArr = new int[2];
        this.f20953c.post(new Runnable() { // from class: stepos.support.v7.app.palette.c
            @Override // java.lang.Runnable
            public final void run() {
                d.a(this.f20948a, iArr);
            }
        });
        this.f20963m.setOnTouchListener(new a(context, iArr, aVar, applicationContext));
    }
}
