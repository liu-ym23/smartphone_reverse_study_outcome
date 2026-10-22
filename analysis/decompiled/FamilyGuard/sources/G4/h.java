package G4;

import C4.G;
import C4.y;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class h extends G {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f1932b;

    /* renamed from: c, reason: collision with root package name */
    private final long f1933c;

    /* renamed from: d, reason: collision with root package name */
    private final L4.g f1934d;

    public h(@Nullable String str, long j5, L4.g gVar) {
        this.f1932b = str;
        this.f1933c = j5;
        this.f1934d = gVar;
    }

    @Override // C4.G
    public long o() {
        return this.f1933c;
    }

    @Override // C4.G
    public y r() {
        String str = this.f1932b;
        if (str != null) {
            return y.c(str);
        }
        return null;
    }

    @Override // C4.G
    public L4.g w() {
        return this.f1934d;
    }
}
