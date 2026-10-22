package A1;

import android.view.InterfaceC1387e;
import android.view.InterfaceC1397o;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\r\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"LA1/f;", "Landroidx/lifecycle/Lifecycle;", "<init>", "()V", "Landroidx/lifecycle/o;", "observer", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroidx/lifecycle/o;)V", Const.INTENT_KEY_UMID, "", "toString", "()Ljava/lang/String;", "A1/f$a", "c", "LA1/f$a;", "owner", "Landroidx/lifecycle/Lifecycle$State;", Const.INTENT_KEY_PKGNAME, "()Landroidx/lifecycle/Lifecycle$State;", "currentState", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class f extends Lifecycle {

    /* renamed from: b, reason: collision with root package name */
    public static final f f140b = new f();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final a owner = new a();

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"A1/f$a", "Landroidx/lifecycle/LifecycleOwner;", "LA1/f;", Const.INTENT_KEY_APIKEY, "()LA1/f;", "lifecycle", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements LifecycleOwner {
        @Override // android.view.LifecycleOwner
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f getLifecycle() {
            return f.f140b;
        }
    }

    @Override // android.view.Lifecycle
    public void a(InterfaceC1397o observer) {
        if (!(observer instanceof InterfaceC1387e)) {
            throw new IllegalArgumentException((observer + " must implement androidx.lifecycle.DefaultLifecycleObserver.").toString());
        }
        InterfaceC1387e interfaceC1387e = (InterfaceC1387e) observer;
        a aVar = owner;
        interfaceC1387e.b(aVar);
        interfaceC1387e.onStart(aVar);
        interfaceC1387e.onResume(aVar);
    }

    @Override // android.view.Lifecycle
    /* renamed from: b */
    public Lifecycle.State getState() {
        return Lifecycle.State.RESUMED;
    }

    @Override // android.view.Lifecycle
    public void d(InterfaceC1397o observer) {
    }

    public String toString() {
        return "coil.request.GlobalLifecycle";
    }
}
