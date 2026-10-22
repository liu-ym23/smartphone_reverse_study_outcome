package stepos.support.v7.app;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;
import stepos.support.v7.widget.C0897q;

/* loaded from: classes2.dex */
public final class L extends K3.c implements L3.i {

    /* renamed from: e, reason: collision with root package name */
    public final Context f14293e;

    /* renamed from: f, reason: collision with root package name */
    public final L3.k f14294f;

    /* renamed from: g, reason: collision with root package name */
    public K3.b f14295g;

    /* renamed from: h, reason: collision with root package name */
    public WeakReference f14296h;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ AbstractC0860e f14299k;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f14292d = 0;

    /* renamed from: i, reason: collision with root package name */
    public final C0872q f14297i = new C0872q(1, this);

    /* renamed from: j, reason: collision with root package name */
    public final boolean f14298j = true;

    public L(M m4, Context context, B0.e eVar) {
        this.f14299k = m4;
        this.f14293e = context;
        this.f14295g = eVar;
        L3.k kVar = new L3.k(context);
        kVar.f1291k = 1;
        this.f14294f = kVar;
        kVar.f1284d = this;
        this.f1051c = this.f14297i;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    @Override // K3.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r6 = this;
            int r0 = r6.f14292d
            r1 = 32
            r2 = 0
            r3 = 0
            stepos.support.v7.app.e r4 = r6.f14299k
            switch(r0) {
                case 0: goto L53;
                default: goto Lb;
            }
        Lb:
            stepos.support.v7.app.g0 r4 = (stepos.support.v7.app.g0) r4
            stepos.support.v7.app.L r5 = r4.f14489j
            if (r5 == r6) goto L12
            goto L52
        L12:
            boolean r5 = r4.f14497r
            r5 = r5 ^ 1
            if (r5 != 0) goto L29
            switch(r0) {
                case 0: goto L1e;
                default: goto L1b;
            }
        L1b:
            boolean r0 = r6.f14298j
            goto L20
        L1e:
            boolean r0 = r6.f14298j
        L20:
            if (r0 == 0) goto L29
            r4.f14490k = r6
            K3.b r0 = r6.f14295g
            r4.f14491l = r0
            goto L2e
        L29:
            K3.b r0 = r6.f14295g
            r0.e(r6)
        L2e:
            r6.f14295g = r2
            r4.w(r3, r2)
            stepos.support.v7.widget.ActionBarContextView r6 = r4.f14485f
            android.view.View r0 = r6.f14716n
            if (r0 != 0) goto L40
            boolean r0 = r6.f14726x
            if (r0 != 0) goto L40
            r6.j()
        L40:
            stepos.support.v7.widget.D r6 = r4.f14484e
            android.view.ViewGroup r6 = r6.n()
            r6.sendAccessibilityEvent(r1)
            stepos.support.v7.widget.ActionBarOverlayLayout r6 = r4.f14482c
            boolean r0 = r4.f14502w
            r6.setHideOnContentScrollEnabled(r0)
            r4.f14489j = r2
        L52:
            return
        L53:
            stepos.support.v7.app.M r4 = (stepos.support.v7.app.M) r4
            stepos.support.v7.app.L r0 = r4.f14309j
            if (r0 == r6) goto L5a
            goto La3
        L5a:
            K3.b r0 = r6.f14295g
            r0.e(r6)
            r6.f14295g = r2
            r4.w(r3, r2)
            stepos.support.v7.widget.ActionBarContextView r6 = r4.f14306g
            android.view.View r0 = r6.f14716n
            if (r0 != 0) goto L71
            boolean r0 = r6.f14726x
            if (r0 != 0) goto L71
            r6.j()
        L71:
            stepos.support.v7.widget.StepOSCollapsingToolbarLayout r6 = r4.f14305f
            java.lang.CharSequence r0 = r6.getTitle()
            stepos.support.v7.widget.w r3 = r6.f15238k
            r3.n(r0)
            r0 = 1132396544(0x437f0000, float:255.0)
            int r0 = (int) r0
            android.text.TextPaint r3 = r3.f15164D
            r3.setAlpha(r0)
            stepos.support.v7.widget.A r0 = r6.f14904C
            if (r0 == 0) goto L92
            java.util.ArrayList r0 = r0.f14703y
            if (r0 != 0) goto L8d
            goto L92
        L8d:
            stepos.support.v7.widget.U r3 = r6.f14906E
            r0.remove(r3)
        L92:
            r6.f14904C = r2
            r6.f14903B = r2
            stepos.support.v7.widget.z r6 = r4.f14303d
            stepos.support.v7.widget.D r6 = r6.f15255b
            android.view.ViewGroup r6 = r6.n()
            r6.sendAccessibilityEvent(r1)
            r4.f14309j = r2
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.L.a():void");
    }

    @Override // L3.i
    public final boolean b(L3.k kVar, MenuItem menuItem) {
        switch (this.f14292d) {
            case 0:
                K3.b bVar = this.f14295g;
                if (bVar != null) {
                    return bVar.d(this, menuItem);
                }
                return false;
            default:
                K3.b bVar2 = this.f14295g;
                if (bVar2 != null) {
                    return bVar2.d(this, menuItem);
                }
                return false;
        }
    }

    @Override // L3.i
    public final void c(L3.k kVar) {
        int i4 = this.f14292d;
        AbstractC0860e abstractC0860e = this.f14299k;
        switch (i4) {
            case 0:
                if (this.f14295g != null) {
                    i();
                    C0897q c0897q = ((M) abstractC0860e).f14306g.f15055d;
                    if (c0897q != null) {
                        c0897q.o();
                        break;
                    }
                }
                break;
            default:
                if (this.f14295g != null) {
                    i();
                    C0897q c0897q2 = ((g0) abstractC0860e).f14485f.f15055d;
                    if (c0897q2 != null) {
                        c0897q2.o();
                        break;
                    }
                }
                break;
        }
    }

    @Override // K3.c
    public final View d() {
        switch (this.f14292d) {
            case 0:
                WeakReference weakReference = this.f14296h;
                if (weakReference != null) {
                    return (View) weakReference.get();
                }
                return null;
            default:
                WeakReference weakReference2 = this.f14296h;
                if (weakReference2 != null) {
                    return (View) weakReference2.get();
                }
                return null;
        }
    }

    @Override // K3.c
    public final Menu e() {
        return this.f14294f;
    }

    @Override // K3.c
    public final MenuInflater f() {
        int i4 = this.f14292d;
        Context context = this.f14293e;
        switch (i4) {
        }
        return new K3.k(context);
    }

    @Override // K3.c
    public final CharSequence g() {
        int i4 = this.f14292d;
        AbstractC0860e abstractC0860e = this.f14299k;
        switch (i4) {
            case 0:
                return ((M) abstractC0860e).f14306g.getSubtitle();
            default:
                return ((g0) abstractC0860e).f14485f.getSubtitle();
        }
    }

    @Override // K3.c
    public final CharSequence h() {
        int i4 = this.f14292d;
        AbstractC0860e abstractC0860e = this.f14299k;
        switch (i4) {
            case 0:
                return ((M) abstractC0860e).f14306g.getTitle();
            default:
                return ((g0) abstractC0860e).f14485f.getTitle();
        }
    }

    @Override // K3.c
    public final void i() {
        L3.k kVar = this.f14294f;
        int i4 = this.f14292d;
        AbstractC0860e abstractC0860e = this.f14299k;
        switch (i4) {
            case 0:
                if (((M) abstractC0860e).f14309j != this) {
                    return;
                }
                kVar.v();
                try {
                    this.f14295g.h(this, kVar);
                    return;
                } finally {
                }
            default:
                if (((g0) abstractC0860e).f14489j != this) {
                    return;
                }
                kVar.v();
                try {
                    this.f14295g.h(this, kVar);
                    return;
                } finally {
                }
        }
    }

    @Override // K3.c
    public final boolean j() {
        int i4 = this.f14292d;
        AbstractC0860e abstractC0860e = this.f14299k;
        switch (i4) {
            case 0:
                return ((M) abstractC0860e).f14306g.f14723u;
            default:
                return ((g0) abstractC0860e).f14485f.f14723u;
        }
    }

    @Override // K3.c
    public final void k(View view) {
        int i4 = this.f14292d;
        AbstractC0860e abstractC0860e = this.f14299k;
        switch (i4) {
            case 0:
                ((M) abstractC0860e).f14306g.setCustomView(view);
                this.f14296h = new WeakReference(view);
                break;
            default:
                ((g0) abstractC0860e).f14485f.setCustomView(view);
                this.f14296h = new WeakReference(view);
                break;
        }
    }

    @Override // K3.c
    public final void l(int i4) {
        int i5 = this.f14292d;
        AbstractC0860e abstractC0860e = this.f14299k;
        switch (i5) {
            case 0:
                m(((M) abstractC0860e).f14300a.getResources().getString(i4));
                break;
            default:
                m(((g0) abstractC0860e).f14480a.getResources().getString(i4));
                break;
        }
    }

    @Override // K3.c
    public final void m(CharSequence charSequence) {
        int i4 = this.f14292d;
        AbstractC0860e abstractC0860e = this.f14299k;
        switch (i4) {
            case 0:
                ((M) abstractC0860e).f14306g.setSubtitle(charSequence);
                break;
            default:
                ((g0) abstractC0860e).f14485f.setSubtitle(charSequence);
                break;
        }
    }

    @Override // K3.c
    public final void n(int i4) {
        int i5 = this.f14292d;
        AbstractC0860e abstractC0860e = this.f14299k;
        switch (i5) {
            case 0:
                o(((M) abstractC0860e).f14300a.getResources().getString(i4));
                break;
            default:
                o(((g0) abstractC0860e).f14480a.getResources().getString(i4));
                break;
        }
    }

    @Override // K3.c
    public final void o(CharSequence charSequence) {
        int i4 = this.f14292d;
        AbstractC0860e abstractC0860e = this.f14299k;
        switch (i4) {
            case 0:
                ((M) abstractC0860e).f14306g.setTitle(charSequence);
                break;
            default:
                ((g0) abstractC0860e).f14485f.setTitle(charSequence);
                break;
        }
    }

    @Override // K3.c
    public final void p(boolean z4) {
        int i4 = this.f14292d;
        AbstractC0860e abstractC0860e = this.f14299k;
        switch (i4) {
            case 0:
                this.f1050b = z4;
                ((M) abstractC0860e).f14306g.setTitleOptional(z4);
                break;
            default:
                this.f1050b = z4;
                ((g0) abstractC0860e).f14485f.setTitleOptional(z4);
                break;
        }
    }

    public final boolean q() {
        L3.k kVar = this.f14294f;
        switch (this.f14292d) {
            case 0:
                kVar.v();
                try {
                    return this.f14295g.b(this, kVar);
                } finally {
                }
            default:
                kVar.v();
                try {
                    return this.f14295g.b(this, kVar);
                } finally {
                }
        }
    }

    public L(g0 g0Var, Context context, B0.e eVar) {
        this.f14299k = g0Var;
        this.f14293e = context;
        this.f14295g = eVar;
        L3.k kVar = new L3.k(context);
        kVar.f1291k = 1;
        this.f14294f = kVar;
        kVar.f1284d = this;
        this.f1051c = this.f14297i;
    }
}
