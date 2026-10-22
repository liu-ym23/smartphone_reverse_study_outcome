package androidx.lifecycle;

/* loaded from: classes.dex */
public abstract class O {

    /* renamed from: a, reason: collision with root package name */
    public final V f3884a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3885b;

    /* renamed from: c, reason: collision with root package name */
    public int f3886c = -1;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ P f3887d;

    public O(P p4, V v4) {
        this.f3887d = p4;
        this.f3884a = v4;
    }

    public final void b(boolean z4) {
        if (z4 == this.f3885b) {
            return;
        }
        this.f3885b = z4;
        int i4 = z4 ? 1 : -1;
        P p4 = this.f3887d;
        int i5 = p4.f3891c;
        p4.f3891c = i4 + i5;
        if (!p4.f3892d) {
            p4.f3892d = true;
            while (true) {
                try {
                    int i6 = p4.f3891c;
                    if (i5 == i6) {
                        break;
                    }
                    boolean z5 = i5 == 0 && i6 > 0;
                    boolean z6 = i5 > 0 && i6 == 0;
                    if (z5) {
                        p4.e();
                    } else if (z6) {
                        p4.f();
                    }
                    i5 = i6;
                } catch (Throwable th) {
                    p4.f3892d = false;
                    throw th;
                }
            }
            p4.f3892d = false;
        }
        if (this.f3885b) {
            p4.c(this);
        }
    }

    public void c() {
    }

    public boolean d(G g4) {
        return false;
    }

    public abstract boolean e();
}
