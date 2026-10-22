package g;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.r;
import androidx.core.view.s;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f19770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f19771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Interpolator f19772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewPropertyAnimatorListener f19773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f19774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s f19775f;

    public class a extends s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f19776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f19778c;

        public a(d r10) {
            this.f19778c = r10;
            this.f19776a = false;
            this.f19777b = 0;
        }

        public void a() {
            this.f19777b = 0;
            this.f19776a = false;
            this.f19778c.b();
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View r10) {
            int r11 = this.f19777b + 1;
            this.f19777b = r11;
            if (r11 != this.f19778c.f19770a.size()) goto L9;
            ViewPropertyAnimatorListener r12 = this.f19778c.f19773d;
            if (r12 == null) goto L7;
            r12.onAnimationEnd(null);
        L7:
            a();
            return;
        }

        @Override // androidx.core.view.s, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View r10) {
            if (this.f19776a == false) goto L5;
            return;
        L5:
            this.f19776a = true;
            ViewPropertyAnimatorListener r11 = this.f19778c.f19773d;
            if (r11 == null) goto L9;
            r11.onAnimationStart(null);
            return;
        }
    }

    public d() {
        this.f19771b = -1;
        this.f19775f = new a(this);
        this.f19770a = new ArrayList();
    }

    public void a() {
        if (this.f19774e == true) goto L5;
        return;
    L5:
        Iterator r10 = this.f19770a.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        ((r) r10.next()).c();
        goto L7
    L9:
        this.f19774e = false;
    }

    public void b() {
        this.f19774e = false;
    }

    public d c(r r10) {
        if (this.f19774e == true) goto L5;
        this.f19770a.add(r10);
    L5:
        return this;
    }

    public d d(r r10, r r11) {
        this.f19770a.add(r10);
        r11.j(r10.d());
        this.f19770a.add(r11);
        return this;
    }

    public d e(long r10) {
        if (this.f19774e == true) goto L5;
        this.f19771b = r10;
    L5:
        return this;
    }

    public d f(Interpolator r10) {
        if (this.f19774e == true) goto L5;
        this.f19772c = r10;
    L5:
        return this;
    }

    public d g(ViewPropertyAnimatorListener r10) {
        if (this.f19774e == true) goto L5;
        this.f19773d = r10;
    L5:
        return this;
    }

    public void h() {
        if (this.f19774e == false) goto L5;
        return;
    L5:
        Iterator r10 = this.f19770a.iterator();
    L7:
        if (r10.hasNext() == false) goto L18;
        r r11 = (r) r10.next();
        long r12 = this.f19771b;
        if (r12 < 0) goto L11;
        r11.f(r12);
    L11:
        Interpolator r13 = this.f19772c;
        if (r13 == null) goto L15;
        r11.g(r13);
    L15:
        if (this.f19773d == null) goto L17;
        r11.h(this.f19775f);
    L17:
        r11.l();
        goto L7
    L18:
        this.f19774e = true;
    }
}
