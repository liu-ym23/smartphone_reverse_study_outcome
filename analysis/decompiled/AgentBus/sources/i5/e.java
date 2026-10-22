package i5;

import com.stepos.agentbus.domain.queue.OfflineQueueDatabase_Impl;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class e implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4649a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f4650b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4651c;

    public /* synthetic */ e(int i2, long j2, Object obj) {
        this.f4649a = i2;
        this.f4651c = obj;
        this.f4650b = j2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        d dVar;
        OfflineQueueDatabase_Impl offlineQueueDatabase_Impl;
        n3.j jVarA;
        switch (this.f4649a) {
            case 0:
                f fVar = (f) this.f4651c;
                dVar = (d) fVar.f4655i;
                offlineQueueDatabase_Impl = (OfflineQueueDatabase_Impl) fVar.f4653g;
                jVarA = dVar.a();
                jVarA.G(1, this.f4650b);
                try {
                    offlineQueueDatabase_Impl.b();
                    try {
                        Integer numValueOf = Integer.valueOf(jVarA.b());
                        offlineQueueDatabase_Impl.n();
                        return numValueOf;
                    } finally {
                    }
                } finally {
                }
            case 1:
                f fVar2 = (f) this.f4651c;
                dVar = (d) fVar2.f4656j;
                offlineQueueDatabase_Impl = (OfflineQueueDatabase_Impl) fVar2.f4653g;
                jVarA = dVar.a();
                jVarA.G(1, this.f4650b);
                try {
                    offlineQueueDatabase_Impl.b();
                    try {
                        jVarA.b();
                        offlineQueueDatabase_Impl.n();
                        dVar.j(jVarA);
                        return c7.r.f1986a;
                    } finally {
                    }
                } finally {
                }
            default:
                l lVar = (l) this.f4651c;
                dVar = (d) lVar.f4689i;
                offlineQueueDatabase_Impl = (OfflineQueueDatabase_Impl) lVar.f4687g;
                jVarA = dVar.a();
                jVarA.G(1, this.f4650b);
                try {
                    offlineQueueDatabase_Impl.b();
                    try {
                        Integer numValueOf2 = Integer.valueOf(jVarA.b());
                        offlineQueueDatabase_Impl.n();
                        return numValueOf2;
                    } finally {
                    }
                } finally {
                }
        }
    }
}
