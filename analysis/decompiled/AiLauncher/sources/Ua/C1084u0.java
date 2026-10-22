package Ua;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.JobSupport;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000b\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u000e\u0010\tR\u001a\u0010\u0012\u001a\u00020\u00078\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\u0014\u0010\u0014\u001a\u00020\u00078PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\t¨\u0006\u0015"}, d2 = {"LUa/u0;", "Lkotlinx/coroutines/JobSupport;", "LUa/x;", "Lkotlinx/coroutines/g;", "parent", "<init>", "(Lkotlinx/coroutines/g;)V", "", "complete", "()Z", "", "exception", "e", "(Ljava/lang/Throwable;)Z", "U0", "c", "Z", ExifInterface.LONGITUDE_WEST, "handlesException", "Y", "onCancelComplete", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Ua.u0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C1084u0 extends JobSupport implements InterfaceC1089x {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final boolean handlesException;

    public C1084u0(kotlinx.coroutines.g gVar) {
        super(true);
        i0(gVar);
        this.handlesException = U0();
    }

    public final boolean U0() {
        JobSupport jobSupportT;
        r rVarB0 = b0();
        C1079s c1079s = rVarB0 instanceof C1079s ? (C1079s) rVarB0 : null;
        if (c1079s != null && (jobSupportT = c1079s.t()) != null) {
            while (!jobSupportT.getHandlesException()) {
                r rVarB02 = jobSupportT.b0();
                C1079s c1079s2 = rVarB02 instanceof C1079s ? (C1079s) rVarB02 : null;
                if (c1079s2 == null || (jobSupportT = c1079s2.t()) == null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.JobSupport
    /* renamed from: W, reason: from getter */
    public boolean getHandlesException() {
        return this.handlesException;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean Y() {
        return true;
    }

    @Override // Ua.InterfaceC1089x
    public boolean complete() {
        return p0(Y8.t.f7040a);
    }

    @Override // Ua.InterfaceC1089x
    public boolean e(Throwable exception) {
        return p0(new C1091z(exception, false, 2, null));
    }
}
