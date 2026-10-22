package na;

import org.yaml.snakeyaml.error.Mark;

/* renamed from: na.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1753c {

    /* renamed from: a, reason: collision with root package name */
    public final int f5376a;
    public final boolean b;
    public final int c;
    public final int d;
    public final int e;
    public final Mark f;

    public C1753c(int i, boolean z10, int i6, int i10, int i11, Mark mark) {
        this.f5376a = i;
        this.b = z10;
        this.c = i6;
        this.d = i10;
        this.e = i11;
        this.f = mark;
    }

    public final String toString() {
        return "SimpleKey - tokenNumber=" + this.f5376a + " required=" + this.b + " index=" + this.c + " line=" + this.d + " column=" + this.e;
    }
}
