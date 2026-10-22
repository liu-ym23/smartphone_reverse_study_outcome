package yb;

import com.autonavi.aps.amapapi.config.Const;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import tb.C5532E;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000f¨\u0006\u0011"}, d2 = {"Lyb/s;", "", "<init>", "()V", "Ltb/E;", "failedRoute", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ltb/E;)V", M5.a.CARD_TYPE_ROUTE, Const.INTENT_KEY_APIKEY, "", "c", "(Ltb/E;)Z", "", "Ljava/util/Set;", "_failedRoutes", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: yb.s, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6038s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Set<C5532E> _failedRoutes = new LinkedHashSet();

    public final synchronized void a(C5532E route) {
        kotlin.jvm.internal.p.i(route, "route");
        this._failedRoutes.remove(route);
    }

    public final synchronized void b(C5532E failedRoute) {
        kotlin.jvm.internal.p.i(failedRoute, "failedRoute");
        this._failedRoutes.add(failedRoute);
    }

    public final synchronized boolean c(C5532E route) {
        kotlin.jvm.internal.p.i(route, "route");
        return this._failedRoutes.contains(route);
    }
}
