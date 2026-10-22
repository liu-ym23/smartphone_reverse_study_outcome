package androidx.work;

import android.content.Context;
import com.stepos.statsrpk.h;
import g5.e;
import g5.t;
import kc.w;
import nb.g;
import pb.c;
import t2.m;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class CoroutineWorker extends t {

    /* renamed from: e, reason: collision with root package name */
    public final WorkerParameters f1657e;

    /* renamed from: f, reason: collision with root package name */
    public final e f1658f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f1657e = workerParameters;
        this.f1658f = e.f4306f;
    }

    @Override // g5.t
    public final m a() {
        e eVar = e.f4306f;
        g gVar = this.f1658f;
        if (k.a(gVar, eVar)) {
            gVar = this.f1657e.f1661b;
        }
        gVar.getClass();
        return h.w(gVar.plus(w.b()), new androidx.room.e(this, null, 2));
    }

    public abstract Object b(c cVar);
}
