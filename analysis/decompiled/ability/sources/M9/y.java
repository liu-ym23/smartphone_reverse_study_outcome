package M9;

import java.io.Serializable;

/* loaded from: classes4.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1001a;
    public int b;
    public int c;
    public Serializable d;

    /* JADX WARN: Type inference failed for: r1v2, types: [M9.y[], java.io.Serializable] */
    public y(int i) {
        this.f1001a = i;
        switch (i) {
            case 1:
                break;
            default:
                this.d = new y[256];
                this.b = 0;
                this.c = 0;
                break;
        }
    }

    public String toString() {
        switch (this.f1001a) {
            case 1:
                StringBuilder sb = new StringBuilder(this.c);
                sb.append("-");
                sb.append((String) this.d);
                sb.append("-");
                sb.append(this.b);
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public y(int i, int i6) {
        this.f1001a = 0;
        this.d = null;
        this.b = i;
        int i10 = i6 & 7;
        this.c = i10 == 0 ? 8 : i10;
    }
}
