package ca7;

import java.util.Objects;

/* JADX INFO: loaded from: classes11.dex */
public final class d extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f22958c;

    public final int hashCode() {
        Object r100 = this.f22958c;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public d() {
    }

    public d(Object r100) {
        this.f22958c = r100;
    }

    @Override // ca7.c
    public final Object d(da7.b r100) {
        return this.f22958c;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (d.class == r100.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.f22958c, ((d) r100).f22958c);
    }
}
