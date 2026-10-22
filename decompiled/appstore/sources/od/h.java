package od;

import com.obric.oui.texteffects.core.Direction;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Direction f22583a;

    public h(Direction r10) {
        q.g(r10, "blurDirection");
        this.f22583a = r10;
    }

    public final Direction a() {
        return this.f22583a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof h) == true) goto L9;
        return false;
    L9:
        if (this.f22583a == ((h) r10).f22583a) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f22583a.hashCode();
    }

    public String toString() {
        return "MaterialLayerSpec(blurDirection=" + this.f22583a + ')';
    }
}
