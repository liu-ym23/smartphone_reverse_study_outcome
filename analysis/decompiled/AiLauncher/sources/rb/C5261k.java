package rb;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lrb/k;", "Lrb/j;", "Lrb/q;", "writer", "", "forceQuoting", "<init>", "(Lrb/q;Z)V", "", UxipConstants.f30680s, "LY8/t;", "n", "(Ljava/lang/String;)V", "c", "Z", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: rb.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5261k extends C5260j {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final boolean forceQuoting;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5261k(InterfaceC5267q writer, boolean z10) {
        super(writer);
        kotlin.jvm.internal.p.i(writer, "writer");
        this.forceQuoting = z10;
    }

    @Override // rb.C5260j
    public void n(String value) {
        kotlin.jvm.internal.p.i(value, "value");
        if (this.forceQuoting) {
            super.n(value);
        } else {
            super.k(value);
        }
    }
}
