package b9;

import com.stepos.core.model.concurrency.ThreadPoolManagerImpl;
import com.stepos.core.ota.confirm.InteractiveSessionRegistry;
import java.util.Map;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3136a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3137b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f3138c;

    public /* synthetic */ a(long j10, long j11, int i10) {
        this.f3136a = i10;
        this.f3137b = j10;
        this.f3138c = j11;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        boolean zSweepExpired$lambda$0;
        switch (this.f3136a) {
            case 0:
                zSweepExpired$lambda$0 = InteractiveSessionRegistry.sweepExpired$lambda$0(this.f3137b, this.f3138c, (Map.Entry) obj);
                break;
            default:
                zSweepExpired$lambda$0 = ThreadPoolManagerImpl.hasForegroundTaskInWindow$lambda$13(this.f3137b, this.f3138c, (Map.Entry) obj);
                break;
        }
        return Boolean.valueOf(zSweepExpired$lambda$0);
    }
}
