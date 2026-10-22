package v2;

import com.stepos.alphame.awareness.AwarenessDataItem;
import java.io.Serializable;
import y2.g;

/* renamed from: v2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0954a implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final g f15721a;

    /* renamed from: b, reason: collision with root package name */
    public final g f15722b;

    public C0954a(g gVar, g gVar2) {
        g gVar3 = new g();
        this.f15721a = gVar3;
        g gVar4 = new g();
        this.f15722b = gVar4;
        gVar3.d(gVar);
        gVar4.d(gVar2);
        gVar4.b();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C0954a.class) {
            return false;
        }
        C0954a c0954a = (C0954a) obj;
        return this.f15722b.equals(c0954a.f15722b) && this.f15721a.equals(c0954a.f15721a);
    }

    public final int hashCode() {
        return this.f15721a.hashCode() + ((this.f15722b.hashCode() + 73) * 73);
    }

    public final String toString() {
        return "ray [" + this.f15721a + AwarenessDataItem.USERID_SPLITTER + this.f15722b + "]";
    }
}
