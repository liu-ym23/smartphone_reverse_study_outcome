package y;

import android.util.AttributeSet;
import v.C0941a;
import v.C0944d;

/* renamed from: y.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0982a extends AbstractC0984c {

    /* renamed from: h, reason: collision with root package name */
    public int f15935h;

    /* renamed from: i, reason: collision with root package name */
    public int f15936i;

    /* renamed from: j, reason: collision with root package name */
    public C0941a f15937j;

    @Override // y.AbstractC0984c
    public final void g(AttributeSet attributeSet) {
        C0941a c0941a = new C0941a();
        c0941a.f15494s0 = 0;
        c0941a.f15495t0 = true;
        c0941a.f15496u0 = 0;
        c0941a.f15497v0 = false;
        this.f15937j = c0941a;
        this.f15948d = c0941a;
        i();
    }

    public boolean getAllowsGoneWidget() {
        return this.f15937j.f15495t0;
    }

    public int getMargin() {
        return this.f15937j.f15496u0;
    }

    public int getType() {
        return this.f15935h;
    }

    @Override // y.AbstractC0984c
    public final void h(C0944d c0944d, boolean z4) {
        int i4 = this.f15935h;
        this.f15936i = i4;
        if (z4) {
            if (i4 == 5) {
                this.f15936i = 1;
            } else if (i4 == 6) {
                this.f15936i = 0;
            }
        } else if (i4 == 5) {
            this.f15936i = 0;
        } else if (i4 == 6) {
            this.f15936i = 1;
        }
        if (c0944d instanceof C0941a) {
            ((C0941a) c0944d).f15494s0 = this.f15936i;
        }
    }

    public void setAllowsGoneWidget(boolean z4) {
        this.f15937j.f15495t0 = z4;
    }

    public void setDpMargin(int i4) {
        this.f15937j.f15496u0 = (int) ((i4 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i4) {
        this.f15937j.f15496u0 = i4;
    }

    public void setType(int i4) {
        this.f15935h = i4;
    }
}
