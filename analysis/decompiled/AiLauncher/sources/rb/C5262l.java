package rb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lrb/l;", "Lrb/j;", "Lrb/q;", "writer", "", "forceQuoting", "<init>", "(Lrb/q;Z)V", "", "v", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(J)V", "", "e", "(B)V", "", "l", "(S)V", "c", "Z", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: rb.l, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5262l extends C5260j {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final boolean forceQuoting;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5262l(InterfaceC5267q writer, boolean z10) {
        super(writer);
        kotlin.jvm.internal.p.i(writer, "writer");
        this.forceQuoting = z10;
    }

    @Override // rb.C5260j
    public void e(byte v10) {
        boolean z10 = this.forceQuoting;
        String strJ = Y8.k.j(Y8.k.b(v10));
        if (z10) {
            n(strJ);
        } else {
            k(strJ);
        }
    }

    @Override // rb.C5260j
    public void i(int v10) {
        boolean z10 = this.forceQuoting;
        String unsignedString = Integer.toUnsignedString(Y8.m.b(v10));
        if (z10) {
            n(unsignedString);
        } else {
            k(unsignedString);
        }
    }

    @Override // rb.C5260j
    public void j(long v10) {
        boolean z10 = this.forceQuoting;
        String unsignedString = Long.toUnsignedString(Y8.o.b(v10));
        if (z10) {
            n(unsignedString);
        } else {
            k(unsignedString);
        }
    }

    @Override // rb.C5260j
    public void l(short v10) {
        boolean z10 = this.forceQuoting;
        String strI = Y8.r.i(Y8.r.b(v10));
        if (z10) {
            n(strI);
        } else {
            k(strI);
        }
    }
}
