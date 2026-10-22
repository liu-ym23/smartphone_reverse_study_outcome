package M4;

import Xa.t;
import Xa.u;
import android.view.C;
import android.view.InterfaceC1387e;
import android.view.LifecycleOwner;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"LM4/j;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_PKGNAME, "LXa/k;", "", "LXa/k;", "_isForeground", "LXa/t;", "c", "LXa/t;", "isForeground", "()LXa/t;", Const.INTENT_KEY_UMID, "Z", "attached", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f4631a = new j();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Xa.k<Boolean> _isForeground;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final t<Boolean> isForeground;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static volatile boolean attached;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"M4/j$a", "Landroidx/lifecycle/e;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "LY8/t;", UxipConstants.f30640D, "(Landroidx/lifecycle/LifecycleOwner;)V", "onStop", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements InterfaceC1387e {
        @Override // android.view.InterfaceC1387e
        public void onStart(LifecycleOwner owner) {
            kotlin.jvm.internal.p.i(owner, "owner");
            j._isForeground.setValue(Boolean.TRUE);
        }

        @Override // android.view.InterfaceC1387e
        public void onStop(LifecycleOwner owner) {
            kotlin.jvm.internal.p.i(owner, "owner");
            j._isForeground.setValue(Boolean.FALSE);
        }
    }

    static {
        Xa.k<Boolean> kVarA = u.a(Boolean.TRUE);
        _isForeground = kVarA;
        isForeground = kVarA;
    }

    public final synchronized void b() {
        if (attached) {
            return;
        }
        attached = true;
        try {
            Result.Companion companion = Result.INSTANCE;
            C.INSTANCE.a().getLifecycle().a(new a());
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }
}
