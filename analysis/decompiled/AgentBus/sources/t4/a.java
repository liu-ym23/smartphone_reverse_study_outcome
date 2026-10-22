package t4;

import com.stepos.zeroclaw.ipc.IZeroClawService;
import q7.k;

/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final IZeroClawService f9731a;

    public a(IZeroClawService iZeroClawService) {
        this.f9731a = iZeroClawService;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && k.a(this.f9731a, ((a) obj).f9731a);
    }

    public final int hashCode() {
        return this.f9731a.hashCode();
    }

    public final String toString() {
        return "Connected(service=" + this.f9731a + ")";
    }
}
