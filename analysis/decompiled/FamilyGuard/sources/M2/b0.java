package M2;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class b0 implements K2.s {

    /* renamed from: d, reason: collision with root package name */
    private static final a f4056d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<View> f4057a;

    /* renamed from: b, reason: collision with root package name */
    private final GradientDrawable f4058b;

    /* renamed from: c, reason: collision with root package name */
    private final Drawable f4059c;

    private static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
        }
    }

    public b0(View view) {
        j4.k.g(view, "view");
        this.f4057a = new WeakReference<>(view);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        this.f4058b = gradientDrawable;
        this.f4059c = view.getBackground();
        view.setBackground(gradientDrawable);
    }

    @Override // K2.s
    public void a() {
        View view = this.f4057a.get();
        if (view != null && view.getBackground() == this.f4058b) {
            view.setBackground(this.f4059c);
        }
    }

    public void b(K2.E e6) {
        View view;
        j4.k.g(e6, "params");
        C0378o c0378o = e6 instanceof C0378o ? (C0378o) e6 : null;
        if (c0378o == null || (view = this.f4057a.get()) == null) {
            return;
        }
        this.f4058b.setCornerRadius(c0378o.a());
        this.f4058b.setColor(-434431205);
        this.f4058b.setStroke(1, 620756991);
        view.invalidate();
    }
}
