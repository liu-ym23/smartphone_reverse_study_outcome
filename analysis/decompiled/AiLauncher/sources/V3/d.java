package V3;

import Y8.h;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\b\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\t"}, d2 = {"LV3/d;", "", "<init>", "()V", "Landroid/os/Handler;", Const.INTENT_KEY_PKGNAME, "LY8/h;", "()Landroid/os/Handler;", "mainHandler", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f6476a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final h mainHandler = C4848b.b(new InterfaceC5063a() { // from class: V3.c
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return d.c();
        }
    });

    public static final Handler c() {
        return new Handler(Looper.getMainLooper());
    }

    public final Handler b() {
        return (Handler) mainHandler.getValue();
    }
}
