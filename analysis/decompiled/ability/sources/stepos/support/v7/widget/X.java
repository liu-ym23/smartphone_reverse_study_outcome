package stepos.support.v7.widget;

/* loaded from: classes4.dex */
public final class X {

    /* renamed from: a, reason: collision with root package name */
    public int f6599a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;

    public final void a(int i, int i6) {
        this.c = i;
        this.d = i6;
        this.h = true;
        if (this.g) {
            if (i6 != Integer.MIN_VALUE) {
                this.f6599a = i6;
            }
            if (i != Integer.MIN_VALUE) {
                this.b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f6599a = i;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.b = i6;
        }
    }
}
