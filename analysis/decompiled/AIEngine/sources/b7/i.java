package b7;

import com.stepos.core.model.manager.ModelLoaderImpl;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlinx.coroutines.channels.BufferedChannel;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements zb.q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3083a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3084b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3085c;

    public /* synthetic */ i(int i10, Object obj, Object obj2) {
        this.f3083a = i10;
        this.f3084b = obj;
        this.f3085c = obj2;
    }

    @Override // zb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i10 = this.f3083a;
        Object obj4 = this.f3085c;
        Object obj5 = this.f3084b;
        switch (i10) {
            case 0:
                Ref$BooleanRef ref$BooleanRef = (Ref$BooleanRef) obj5;
                Ref$LongRef ref$LongRef = (Ref$LongRef) obj4;
                byte[] b10 = (byte[]) obj;
                int iIntValue = ((Integer) obj2).intValue();
                int iIntValue2 = ((Integer) obj3).intValue();
                kotlin.jvm.internal.g.f(b10, "b");
                if (!ref$BooleanRef.f10073a) {
                    ThreadLocal<byte[]> threadLocal = l7.d.f10346a;
                    if (l7.d.g(b10, iIntValue, iIntValue2, com.stepos.base.model.b.f6350c)) {
                        long jB = l7.d.b(b10, iIntValue, iIntValue2);
                        if (jB >= 0) {
                            ref$LongRef.f10075a = jB;
                            ref$BooleanRef.f10073a = true;
                        }
                    }
                }
                return lb.n.f10413a;
            case 1:
                return ModelLoaderImpl.loadAsync$lambda$4$lambda$3((ModelLoaderImpl) obj5, (String) obj4, null, ((Integer) obj).intValue(), (String) obj2, (k) obj3);
            default:
                return BufferedChannel.bindCancellationFun$lambda$89((zb.l) obj5, obj4, (Throwable) obj, obj2, (kotlin.coroutines.d) obj3);
        }
    }
}
