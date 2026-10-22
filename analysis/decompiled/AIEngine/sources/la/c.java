package la;

import android.app.Application;
import com.stepos.core.ota.download.control.HysteresisStrategy;
import java.util.concurrent.ScheduledFuture;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public Application f10383a;

    /* renamed from: b, reason: collision with root package name */
    public String f10384b;

    /* renamed from: c, reason: collision with root package name */
    public String f10385c;

    /* renamed from: d, reason: collision with root package name */
    public oa.b f10386d;

    /* renamed from: e, reason: collision with root package name */
    public la.a f10387e;

    /* renamed from: f, reason: collision with root package name */
    public na.b f10388f;

    /* renamed from: g, reason: collision with root package name */
    public ha.c f10389g;
    public ScheduledFuture<?> h;

    /* renamed from: i, reason: collision with root package name */
    public long f10390i;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final c f10391a;

        static {
            c cVar = new c();
            cVar.f10390i = HysteresisStrategy.DEFAULT_DWELL_MS;
            f10391a = cVar;
        }
    }
}
