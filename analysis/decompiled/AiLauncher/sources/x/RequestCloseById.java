package x;

import Ua.C1087w;
import Ua.InterfaceC1083u;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import w.C5708n;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f¨\u0006\u0011"}, d2 = {"Lx/D0;", "Lx/j0;", "Lw/n;", "activeCameraId", "<init>", "(Ljava/lang/String;Lkotlin/jvm/internal/i;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "LUa/u;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "LUa/u;", "()LUa/u;", "deferred", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.D0, reason: from toString */
/* loaded from: classes.dex */
public final class RequestCloseById extends AbstractC5822j0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String activeCameraId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC1083u<Y8.t> deferred;

    public /* synthetic */ RequestCloseById(String str, kotlin.jvm.internal.i iVar) {
        this(str);
    }

    /* renamed from: a, reason: from getter */
    public final String getActiveCameraId() {
        return this.activeCameraId;
    }

    public final InterfaceC1083u<Y8.t> b() {
        return this.deferred;
    }

    public String toString() {
        return "RequestCloseById(" + ((Object) C5708n.f(this.activeCameraId)) + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestCloseById(String activeCameraId) {
        super(null);
        kotlin.jvm.internal.p.i(activeCameraId, "activeCameraId");
        this.activeCameraId = activeCameraId;
        this.deferred = C1087w.c(null, 1, null);
    }
}
