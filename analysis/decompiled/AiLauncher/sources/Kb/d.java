package Kb;

import Kb.a;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import tb.C5528A;
import tb.InterfaceC5538e;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"LKb/d;", "", "<init>", "()V", "Ltb/e$a;", "callFactory", "LKb/a$a;", Const.INTENT_KEY_PKGNAME, "(Ltb/e$a;)LKb/a$a;", "okhttp-sse"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f4257a = new d();

    public static final a.InterfaceC0068a b(final InterfaceC5538e.a callFactory) {
        p.i(callFactory, "callFactory");
        return new a.InterfaceC0068a() { // from class: Kb.c
            @Override // Kb.a.InterfaceC0068a
            public final a a(C5528A c5528a, b bVar) {
                return d.c(callFactory, c5528a, bVar);
            }
        };
    }

    public static final a c(InterfaceC5538e.a aVar, C5528A request, b listener) {
        p.i(request, "request");
        p.i(listener, "listener");
        if (request.e("Accept") == null) {
            request = request.i().a("Accept", "text/event-stream").b();
        }
        Lb.a aVar2 = new Lb.a(request, listener);
        aVar2.e(aVar);
        return aVar2;
    }
}
