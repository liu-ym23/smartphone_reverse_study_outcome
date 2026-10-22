package x;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import w.C5706l;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0014"}, d2 = {"Lx/m0;", "Lx/k0;", "Lw/l;", "cameraErrorCode", "<init>", "(Lw/l;Lkotlin/jvm/internal/i;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Lw/l;", "()Lw/l;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.m0, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class CameraStateClosing extends AbstractC5824k0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final C5706l cameraErrorCode;

    public /* synthetic */ CameraStateClosing(C5706l c5706l, kotlin.jvm.internal.i iVar) {
        this(c5706l);
    }

    /* renamed from: a, reason: from getter */
    public final C5706l getCameraErrorCode() {
        return this.cameraErrorCode;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CameraStateClosing) && kotlin.jvm.internal.p.d(this.cameraErrorCode, ((CameraStateClosing) other).cameraErrorCode);
    }

    public int hashCode() {
        C5706l c5706l = this.cameraErrorCode;
        if (c5706l == null) {
            return 0;
        }
        return C5706l.s(c5706l.getValue());
    }

    public String toString() {
        return "CameraStateClosing(cameraErrorCode=" + this.cameraErrorCode + ')';
    }

    public CameraStateClosing(C5706l c5706l) {
        super(null);
        this.cameraErrorCode = c5706l;
    }

    public /* synthetic */ CameraStateClosing(C5706l c5706l, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : c5706l, null);
    }
}
