package aa;

import android.content.res.ColorStateList;
import android.graphics.Path;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n implements y9.d {

    /* renamed from: c, reason: collision with root package name */
    public p5.c f334c;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference f335f;

    /* renamed from: g, reason: collision with root package name */
    public o f336g;

    /* renamed from: h, reason: collision with root package name */
    public Path f337h;
    public Object i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f338j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f339k;

    /* renamed from: l, reason: collision with root package name */
    public WeakReference f340l;

    /* renamed from: m, reason: collision with root package name */
    public int f341m;

    /* renamed from: n, reason: collision with root package name */
    public ColorStateList f342n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f343o;

    /* renamed from: p, reason: collision with root package name */
    public i f344p;

    /* renamed from: q, reason: collision with root package name */
    public m f345q;

    /* renamed from: r, reason: collision with root package name */
    public l f346r;

    /* renamed from: s, reason: collision with root package name */
    public Class f347s;

    @Override // y9.d
    public final void a() {
        View view = (View) this.f335f.get();
        if (view != null) {
            view.removeOnLayoutChangeListener(this.f344p);
        }
        boolean z10 = view instanceof TextView;
        TextView textView = z10 ? (TextView) view : null;
        if (textView != null) {
            textView.removeTextChangedListener(this.f345q);
        }
        if (this.f343o) {
            this.f343o = false;
            ColorStateList colorStateList = this.f342n;
            this.f342n = null;
            TextView textView2 = z10 ? (TextView) view : null;
            if (textView2 != null && colorStateList != null) {
                textView2.setTextColor(colorStateList);
            }
        }
        b();
        this.f336g = null;
        this.i = null;
        this.f338j = false;
        this.f337h.reset();
        Class cls = this.f347s;
        p5.c cVar = this.f334c;
        a9.e eVar = new a9.e(1);
        eVar.f257f = cls;
        VarHandle.storeStoreFence();
        cVar.n(eVar);
    }

    public final void b() {
        ViewTreeObserver viewTreeObserver;
        WeakReference weakReference = this.f340l;
        if (weakReference != null && (viewTreeObserver = (ViewTreeObserver) weakReference.get()) != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.f346r);
        }
        this.f340l = null;
        this.f339k = false;
    }

    public final void c() {
        View view = (View) this.f335f.get();
        if (view == null || this.f339k) {
            return;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        int i = 1;
        if (viewTreeObserver.isAlive()) {
            this.f339k = true;
            this.f340l = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnPreDrawListener(this.f346r);
        } else {
            a4.t tVar = new a4.t(i);
            tVar.f200f = this;
            VarHandle.storeStoreFence();
            view.post(tVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(y9.j r21) {
        /*
            Method dump skipped, instructions count: 441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: aa.n.d(y9.j):void");
    }
}
