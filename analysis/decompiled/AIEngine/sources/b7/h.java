package b7;

import java.util.HashMap;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.selects.SelectInstance;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements zb.q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3081a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3082b;

    public /* synthetic */ h(com.stepos.base.model.b bVar, HashMap map) {
        this.f3081a = 0;
        this.f3082b = map;
    }

    @Override // zb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int iE;
        int i10 = this.f3081a;
        Object obj4 = this.f3082b;
        switch (i10) {
            case 0:
                HashMap map = (HashMap) obj4;
                byte[] b10 = (byte[]) obj;
                int iIntValue = ((Integer) obj2).intValue();
                int iIntValue2 = ((Integer) obj3).intValue();
                kotlin.jvm.internal.g.f(b10, "b");
                ThreadLocal<byte[]> threadLocal = l7.d.f10346a;
                int iE2 = l7.d.e(b10, iIntValue, iIntValue2, 5);
                if (iE2 >= 0 && l7.d.g(b10, iE2, iIntValue2, com.stepos.base.model.b.f6354g)) {
                    long jC = l7.d.c(b10, iIntValue, iIntValue2, 4, -1L);
                    if (jC >= 0 && (iE = l7.d.e(b10, iIntValue, iIntValue2, 0)) >= 0) {
                        int iD = l7.d.d(b10, iE, iIntValue2);
                        int i11 = iE;
                        while (i11 < iD && b10[i11] != 45) {
                            i11++;
                        }
                        if (i11 > iE && i11 < iD - 1) {
                            ThreadLocal<byte[]> threadLocal2 = l7.d.f10346a;
                            long jI = l7.d.i(b10, iE, i11);
                            long jI2 = l7.d.i(b10, i11 + 1, iD);
                            if (jI >= 0 && jI2 >= jI) {
                                long j10 = jI2 - jI;
                                if (!map.containsKey(Long.valueOf(jC))) {
                                    map.put(Long.valueOf(jC), Long.valueOf(j10));
                                }
                            }
                        }
                    }
                }
                return lb.n.f10413a;
            case 1:
                return CancellableContinuationImpl.resume$lambda$13$lambda$12((zb.l) obj4, (Throwable) obj, obj2, (kotlin.coroutines.d) obj3);
            default:
                return BufferedChannel.onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56((BufferedChannel) obj4, (SelectInstance) obj, obj2, obj3);
        }
    }

    public /* synthetic */ h(Object obj, int i10) {
        this.f3081a = i10;
        this.f3082b = obj;
    }
}
