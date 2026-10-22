package w9;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import com.stepos.deepbinder.core.log.IPCLog;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f13611a;

    public d(long j10) {
        this.f13611a = j10;
    }

    @Override // androidx.lifecycle.o
    public final void a(q qVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            IPCLog iPCLog = IPCLog.INSTANCE;
            long j10 = this.f13611a;
            iPCLog.d("IPCRecycle", "[onStateChanged][onDestroy]", "timeStamp", Long.valueOf(j10));
            n9.b bVar = n9.b.f10675a;
            n9.b.a(j10);
            qVar.getLifecycle().c(this);
        }
    }
}
