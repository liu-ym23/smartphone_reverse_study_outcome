package com.blankj.utilcode.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.N;
import com.blankj.utilcode.R$id;
import com.blankj.utilcode.R$layout;
import com.blankj.utilcode.util.p;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class ToastUtils {

    /* renamed from: l, reason: collision with root package name */
    public static final ToastUtils f19202l = o();

    /* renamed from: m, reason: collision with root package name */
    public static WeakReference<e> f19203m;

    /* renamed from: a, reason: collision with root package name */
    public String f19204a;

    /* renamed from: b, reason: collision with root package name */
    public int f19205b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f19206c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f19207d = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f19208e = -16777217;

    /* renamed from: f, reason: collision with root package name */
    public int f19209f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f19210g = -16777217;

    /* renamed from: h, reason: collision with root package name */
    public int f19211h = -1;

    /* renamed from: i, reason: collision with root package name */
    public boolean f19212i = false;

    /* renamed from: j, reason: collision with root package name */
    public Drawable[] f19213j = new Drawable[4];

    /* renamed from: k, reason: collision with root package name */
    public boolean f19214k = false;

    public static final class UtilsMaxWidthRelativeLayout extends RelativeLayout {

        /* renamed from: a, reason: collision with root package name */
        public static final int f19215a = r.b(80.0f);

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.widget.RelativeLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(r.f() - f19215a, Integer.MIN_VALUE), i11);
        }
    }

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (ToastUtils.f19203m != null) {
                e eVar = (e) ToastUtils.f19203m.get();
                if (eVar != null) {
                    eVar.cancel();
                }
                WeakReference unused = ToastUtils.f19203m = null;
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f19217b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CharSequence f19218c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f19219d;

        public b(View view, CharSequence charSequence, int i10) {
            this.f19217b = view;
            this.f19218c = charSequence;
            this.f19219d = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ToastUtils.l();
            e eVarP = ToastUtils.p(ToastUtils.this);
            WeakReference unused = ToastUtils.f19203m = new WeakReference(eVarP);
            View view = this.f19217b;
            if (view != null) {
                eVarP.a(view);
            } else {
                eVarP.b(this.f19218c);
            }
            eVarP.show(this.f19219d);
        }
    }

    public static abstract class c implements e {

        /* renamed from: a, reason: collision with root package name */
        public Toast f19220a = new Toast(p.a());

        /* renamed from: b, reason: collision with root package name */
        public ToastUtils f19221b;

        /* renamed from: c, reason: collision with root package name */
        public View f19222c;

        public c(ToastUtils toastUtils) {
            this.f19221b = toastUtils;
            if (toastUtils.f19205b == -1 && this.f19221b.f19206c == -1 && this.f19221b.f19207d == -1) {
                return;
            }
            this.f19220a.setGravity(this.f19221b.f19205b, this.f19221b.f19206c, this.f19221b.f19207d);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.e
        public void a(View view) {
            this.f19222c = view;
            this.f19220a.setView(view);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.e
        public void b(CharSequence charSequence) {
            View viewX = this.f19221b.x(charSequence);
            if (viewX != null) {
                a(viewX);
                d();
                return;
            }
            View view = this.f19220a.getView();
            this.f19222c = view;
            if (view == null || view.findViewById(R.id.message) == null) {
                a(r.t(R$layout.utils_toast_view));
            }
            TextView textView = (TextView) this.f19222c.findViewById(R.id.message);
            textView.setText(charSequence);
            if (this.f19221b.f19210g != -16777217) {
                textView.setTextColor(this.f19221b.f19210g);
            }
            if (this.f19221b.f19211h != -1) {
                textView.setTextSize(this.f19221b.f19211h);
            }
            e(textView);
            d();
        }

        public View c(int i10) {
            Bitmap bitmapA = r.A(this.f19222c);
            ImageView imageView = new ImageView(p.a());
            imageView.setTag("TAG_TOAST" + i10);
            imageView.setImageBitmap(bitmapA);
            return imageView;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.e
        public void cancel() {
            Toast toast = this.f19220a;
            if (toast != null) {
                toast.cancel();
            }
            this.f19220a = null;
            this.f19222c = null;
        }

        public final void d() {
            if (r.s()) {
                a(c(-1));
            }
        }

        public final void e(TextView textView) {
            if (this.f19221b.f19209f != -1) {
                this.f19222c.setBackgroundResource(this.f19221b.f19209f);
                textView.setBackgroundColor(0);
                return;
            }
            if (this.f19221b.f19208e != -16777217) {
                Drawable background = this.f19222c.getBackground();
                Drawable background2 = textView.getBackground();
                if (background != null && background2 != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.f19221b.f19208e, PorterDuff.Mode.SRC_IN));
                    textView.setBackgroundColor(0);
                } else if (background != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.f19221b.f19208e, PorterDuff.Mode.SRC_IN));
                } else if (background2 != null) {
                    background2.mutate().setColorFilter(new PorterDuffColorFilter(this.f19221b.f19208e, PorterDuff.Mode.SRC_IN));
                } else {
                    this.f19222c.setBackgroundColor(this.f19221b.f19208e);
                }
            }
        }
    }

    public static final class d extends c {

        /* renamed from: f, reason: collision with root package name */
        public static int f19223f;

        /* renamed from: d, reason: collision with root package name */
        public p.a f19224d;

        /* renamed from: e, reason: collision with root package name */
        public e f19225e;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.cancel();
            }
        }

        public class b extends p.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f19227a;

            public b(int i10) {
                this.f19227a = i10;
            }

            @Override // com.blankj.utilcode.util.p.a
            public void a(Activity activity) {
                if (d.this.h()) {
                    d.this.k(activity, this.f19227a, false);
                }
            }
        }

        public d(ToastUtils toastUtils) {
            super(toastUtils);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.c, com.blankj.utilcode.util.ToastUtils.e
        public void cancel() {
            Window window;
            if (h()) {
                m();
                for (Activity activity : r.e()) {
                    if (r.o(activity) && (window = activity.getWindow()) != null) {
                        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("TAG_TOAST");
                        sb2.append(f19223f - 1);
                        View viewFindViewWithTag = viewGroup.findViewWithTag(sb2.toString());
                        if (viewFindViewWithTag != null) {
                            try {
                                viewGroup.removeView(viewFindViewWithTag);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            e eVar = this.f19225e;
            if (eVar != null) {
                eVar.cancel();
                this.f19225e = null;
            }
            super.cancel();
        }

        public final boolean h() {
            return this.f19224d != null;
        }

        public final void i() {
            b bVar = new b(f19223f);
            this.f19224d = bVar;
            r.a(bVar);
        }

        public final e j(int i10) {
            f fVar = new f(this.f19221b);
            fVar.f19220a = this.f19220a;
            fVar.show(i10);
            return fVar;
        }

        public final void k(Activity activity, int i10, boolean z10) {
            Window window = activity.getWindow();
            if (window != null) {
                ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = this.f19220a.getGravity();
                layoutParams.bottomMargin = this.f19220a.getYOffset() + r.j();
                layoutParams.topMargin = this.f19220a.getYOffset() + r.m();
                layoutParams.leftMargin = this.f19220a.getXOffset();
                View viewC = c(i10);
                if (z10) {
                    viewC.setAlpha(0.0f);
                    viewC.animate().alpha(1.0f).setDuration(200L).start();
                }
                viewGroup.addView(viewC, layoutParams);
            }
        }

        public final e l(Activity activity, int i10) {
            g gVar = new g(this.f19221b, activity.getWindowManager(), 99);
            gVar.f19222c = c(-1);
            gVar.f19220a = this.f19220a;
            gVar.show(i10);
            return gVar;
        }

        public final void m() {
            r.w(this.f19224d);
            this.f19224d = null;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.e
        public void show(int i10) {
            if (this.f19220a == null) {
                return;
            }
            if (!r.p()) {
                this.f19225e = j(i10);
                return;
            }
            boolean z10 = false;
            for (Activity activity : r.e()) {
                if (r.o(activity)) {
                    if (z10) {
                        k(activity, f19223f, true);
                    } else {
                        this.f19225e = l(activity, i10);
                        z10 = true;
                    }
                }
            }
            if (!z10) {
                this.f19225e = j(i10);
                return;
            }
            i();
            r.y(new a(), i10 == 0 ? 2000L : 3500L);
            f19223f++;
        }
    }

    public interface e {
        void a(View view);

        void b(CharSequence charSequence);

        void cancel();

        void show(int i10);
    }

    public static final class f extends c {
        public f(ToastUtils toastUtils) {
            super(toastUtils);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.e
        public void show(int i10) {
            Toast toast = this.f19220a;
            if (toast == null) {
                return;
            }
            toast.setDuration(i10);
            this.f19220a.show();
        }
    }

    public static void l() {
        r.x(new a());
    }

    public static CharSequence n(CharSequence charSequence) {
        return charSequence == null ? "toast null" : charSequence.length() == 0 ? "toast nothing" : charSequence;
    }

    public static ToastUtils o() {
        return new ToastUtils();
    }

    public static e p(ToastUtils toastUtils) {
        return (toastUtils.f19214k || !androidx.core.app.m.b(p.a()).a() || r.q()) ? r.q() ? new g(toastUtils, 2038) : new d(toastUtils) : new f(toastUtils);
    }

    public static void s(View view, CharSequence charSequence, int i10, ToastUtils toastUtils) {
        r.x(toastUtils.new b(view, charSequence, i10));
    }

    public static void u(CharSequence charSequence, int i10, ToastUtils toastUtils) {
        s(null, n(charSequence), i10, toastUtils);
    }

    public static void w(String str, Object... objArr) {
        u(r.d(str, objArr), 1, f19202l);
    }

    public final int m() {
        return this.f19212i ? 1 : 0;
    }

    public final ToastUtils q(int i10) {
        this.f19208e = i10;
        return this;
    }

    public final ToastUtils r(int i10) {
        this.f19210g = i10;
        return this;
    }

    public final void t(CharSequence charSequence) {
        u(charSequence, m(), this);
    }

    public final void v(String str, Object... objArr) {
        u(r.d(str, objArr), m(), this);
    }

    public final View x(CharSequence charSequence) {
        if (!"dark".equals(this.f19204a) && !"light".equals(this.f19204a)) {
            Drawable[] drawableArr = this.f19213j;
            if (drawableArr[0] == null && drawableArr[1] == null && drawableArr[2] == null && drawableArr[3] == null) {
                return null;
            }
        }
        View viewT = r.t(R$layout.utils_toast_view);
        TextView textView = (TextView) viewT.findViewById(R.id.message);
        if ("dark".equals(this.f19204a)) {
            ((GradientDrawable) viewT.getBackground().mutate()).setColor(Color.parseColor("#BB000000"));
            textView.setTextColor(-1);
        }
        textView.setText(charSequence);
        if (this.f19213j[0] != null) {
            View viewFindViewById = viewT.findViewById(R$id.utvLeftIconView);
            N.m0(viewFindViewById, this.f19213j[0]);
            viewFindViewById.setVisibility(0);
        }
        if (this.f19213j[1] != null) {
            View viewFindViewById2 = viewT.findViewById(R$id.utvTopIconView);
            N.m0(viewFindViewById2, this.f19213j[1]);
            viewFindViewById2.setVisibility(0);
        }
        if (this.f19213j[2] != null) {
            View viewFindViewById3 = viewT.findViewById(R$id.utvRightIconView);
            N.m0(viewFindViewById3, this.f19213j[2]);
            viewFindViewById3.setVisibility(0);
        }
        if (this.f19213j[3] != null) {
            View viewFindViewById4 = viewT.findViewById(R$id.utvBottomIconView);
            N.m0(viewFindViewById4, this.f19213j[3]);
            viewFindViewById4.setVisibility(0);
        }
        return viewT;
    }

    public static final class g extends c {

        /* renamed from: d, reason: collision with root package name */
        public WindowManager f19229d;

        /* renamed from: e, reason: collision with root package name */
        public WindowManager.LayoutParams f19230e;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.cancel();
            }
        }

        public g(ToastUtils toastUtils, int i10) {
            super(toastUtils);
            this.f19230e = new WindowManager.LayoutParams();
            this.f19229d = (WindowManager) p.a().getSystemService("window");
            this.f19230e.type = i10;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.c, com.blankj.utilcode.util.ToastUtils.e
        public void cancel() {
            try {
                WindowManager windowManager = this.f19229d;
                if (windowManager != null) {
                    windowManager.removeViewImmediate(this.f19222c);
                    this.f19229d = null;
                }
            } catch (Exception unused) {
            }
            super.cancel();
        }

        @Override // com.blankj.utilcode.util.ToastUtils.e
        public void show(int i10) {
            if (this.f19220a == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = this.f19230e;
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = R.style.Animation.Toast;
            layoutParams.setTitle("ToastWithoutNotification");
            WindowManager.LayoutParams layoutParams2 = this.f19230e;
            layoutParams2.flags = 152;
            layoutParams2.packageName = p.a().getPackageName();
            this.f19230e.gravity = this.f19220a.getGravity();
            WindowManager.LayoutParams layoutParams3 = this.f19230e;
            int i11 = layoutParams3.gravity;
            if ((i11 & 7) == 7) {
                layoutParams3.horizontalWeight = 1.0f;
            }
            if ((i11 & 112) == 112) {
                layoutParams3.verticalWeight = 1.0f;
            }
            layoutParams3.x = this.f19220a.getXOffset();
            this.f19230e.y = this.f19220a.getYOffset();
            this.f19230e.horizontalMargin = this.f19220a.getHorizontalMargin();
            this.f19230e.verticalMargin = this.f19220a.getVerticalMargin();
            try {
                WindowManager windowManager = this.f19229d;
                if (windowManager != null) {
                    windowManager.addView(this.f19222c, this.f19230e);
                }
            } catch (Exception unused) {
            }
            r.y(new a(), i10 == 0 ? 2000L : 3500L);
        }

        public g(ToastUtils toastUtils, WindowManager windowManager, int i10) {
            super(toastUtils);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f19230e = layoutParams;
            this.f19229d = windowManager;
            layoutParams.type = i10;
        }
    }
}
