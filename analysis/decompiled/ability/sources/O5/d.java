package O5;

import B0.f;
import F9.v;
import com.stepos.ability.App;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public App f1038a;
    public String b;
    public String c;
    public R5.d d;
    public f e;
    public A5.c f;
    public v g;
    public ScheduledFuture h;
    public long i;

    public final S5.a a() {
        R5.d dVar = this.d;
        if (dVar != null) {
            return (S5.a) dVar.d;
        }
        W5.c.b("SDKInstanceImpl", "getSubject fail, tracker is null");
        return null;
    }
}
