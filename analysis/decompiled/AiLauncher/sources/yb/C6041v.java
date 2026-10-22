package yb;

import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import kotlin.Metadata;
import yb.InterfaceC6039t;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lyb/v;", "Lyb/i;", "Lyb/t;", "routePlanner", "<init>", "(Lyb/t;)V", "Lyb/n;", Const.INTENT_KEY_APIKEY, "()Lyb/n;", "Lyb/t;", Const.INTENT_KEY_PKGNAME, "()Lyb/t;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: yb.v, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6041v implements InterfaceC6028i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC6039t routePlanner;

    public C6041v(InterfaceC6039t routePlanner) {
        kotlin.jvm.internal.p.i(routePlanner, "routePlanner");
        this.routePlanner = routePlanner;
    }

    @Override // yb.InterfaceC6028i
    public C6033n a() throws Throwable {
        InterfaceC6039t.b bVarD;
        IOException iOException = null;
        while (!getRoutePlanner().e()) {
            try {
                bVarD = getRoutePlanner().d();
            } catch (IOException e10) {
                if (iOException == null) {
                    iOException = e10;
                } else {
                    Y8.d.a(iOException, e10);
                }
                if (!InterfaceC6039t.f(getRoutePlanner(), null, 1, null)) {
                    throw iOException;
                }
            }
            if (!bVarD.getIsReady()) {
                InterfaceC6039t.ConnectResult connectResultG = bVarD.g();
                if (connectResultG.f()) {
                    connectResultG = bVarD.getResult();
                }
                InterfaceC6039t.b nextPlan = connectResultG.getNextPlan();
                Throwable throwable = connectResultG.getThrowable();
                if (throwable != null) {
                    throw throwable;
                }
                if (nextPlan != null) {
                    getRoutePlanner().c().addFirst(nextPlan);
                }
            }
            return bVarD.getConnection();
        }
        throw new IOException("Canceled");
    }

    @Override // yb.InterfaceC6028i
    /* renamed from: b, reason: from getter */
    public InterfaceC6039t getRoutePlanner() {
        return this.routePlanner;
    }
}
