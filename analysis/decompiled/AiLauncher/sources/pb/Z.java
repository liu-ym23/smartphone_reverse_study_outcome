package pb;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import o9.C5013a;
import w9.C5757p;
import w9.InterfaceC5745d;
import w9.InterfaceC5746e;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lpb/Z;", "Lw9/n;", "origin", "<init>", "(Lw9/n;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Lw9/n;", "", "Lw9/p;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/List;", "arguments", "Lw9/e;", "c", "()Lw9/e;", "classifier", "e", "()Z", "isMarkedNullable", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Z implements InterfaceC5755n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5755n origin;

    public Z(InterfaceC5755n origin) {
        kotlin.jvm.internal.p.i(origin, "origin");
        this.origin = origin;
    }

    @Override // w9.InterfaceC5755n
    public InterfaceC5746e c() {
        return this.origin.c();
    }

    @Override // w9.InterfaceC5755n
    public boolean e() {
        return this.origin.e();
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        InterfaceC5755n interfaceC5755n = this.origin;
        Z z10 = other instanceof Z ? (Z) other : null;
        if (!kotlin.jvm.internal.p.d(interfaceC5755n, z10 != null ? z10.origin : null)) {
            return false;
        }
        InterfaceC5746e interfaceC5746eC = c();
        if (interfaceC5746eC instanceof InterfaceC5745d) {
            InterfaceC5755n interfaceC5755n2 = other instanceof InterfaceC5755n ? (InterfaceC5755n) other : null;
            InterfaceC5746e interfaceC5746eC2 = interfaceC5755n2 != null ? interfaceC5755n2.c() : null;
            if (interfaceC5746eC2 != null && (interfaceC5746eC2 instanceof InterfaceC5745d)) {
                return kotlin.jvm.internal.p.d(C5013a.b((InterfaceC5745d) interfaceC5746eC), C5013a.b((InterfaceC5745d) interfaceC5746eC2));
            }
        }
        return false;
    }

    @Override // w9.InterfaceC5755n
    public List<C5757p> g() {
        return this.origin.g();
    }

    public int hashCode() {
        return this.origin.hashCode();
    }

    public String toString() {
        return "KTypeWrapper: " + this.origin;
    }
}
