package V0;

import W0.f;
import W0.h;
import android.view.Q;
import android.view.U;
import android.view.V;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ1\u0010\u0010\u001a\u00028\u0000\"\b\b\u0000\u0010\u000b*\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0019¨\u0006\u001b"}, d2 = {"LV0/c;", "", "Landroidx/lifecycle/V;", "store", "Landroidx/lifecycle/U$c;", "factory", "LV0/a;", "defaultExtras", "<init>", "(Landroidx/lifecycle/V;Landroidx/lifecycle/U$c;LV0/a;)V", "Landroidx/lifecycle/Q;", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "modelClass", "", "key", Const.INTENT_KEY_UMID, "(Lw9/d;Ljava/lang/String;)Landroidx/lifecycle/Q;", Const.INTENT_KEY_APIKEY, "Landroidx/lifecycle/V;", Const.INTENT_KEY_PKGNAME, "Landroidx/lifecycle/U$c;", "c", "LV0/a;", "LW0/f;", "LW0/f;", "lock", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final V store;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final U.c factory;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final CreationExtras defaultExtras;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final f lock;

    public c(V store, U.c factory, CreationExtras defaultExtras) {
        p.i(store, "store");
        p.i(factory, "factory");
        p.i(defaultExtras, "defaultExtras");
        this.store = store;
        this.factory = factory;
        this.defaultExtras = defaultExtras;
        this.lock = new f();
    }

    public static /* synthetic */ Q e(c cVar, InterfaceC5745d interfaceC5745d, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = h.f6590a.c(interfaceC5745d);
        }
        return cVar.d(interfaceC5745d, str);
    }

    public final <T extends Q> T d(InterfaceC5745d<T> modelClass, String key) {
        T t10;
        p.i(modelClass, "modelClass");
        p.i(key, "key");
        synchronized (this.lock) {
            try {
                t10 = (T) this.store.b(key);
                if (modelClass.k(t10)) {
                    if (this.factory instanceof U.e) {
                        U.e eVar = (U.e) this.factory;
                        p.f(t10);
                        eVar.d(t10);
                    }
                    p.g(t10, "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.ViewModelProviderImpl.getViewModel");
                } else {
                    b bVar = new b(this.defaultExtras);
                    bVar.c(U.f14251c, key);
                    t10 = (T) d.a(this.factory, modelClass, bVar);
                    this.store.d(key, t10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t10;
    }
}
