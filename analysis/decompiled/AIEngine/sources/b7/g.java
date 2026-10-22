package b7;

import com.stepos.core.common.telemetry.CpuPerCoreSampler;
import java.io.Serializable;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements zb.q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3077a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Serializable f3078b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Serializable f3079c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3080d;

    public /* synthetic */ g(Serializable serializable, Serializable serializable2, Object obj, int i10) {
        this.f3077a = i10;
        this.f3078b = serializable;
        this.f3079c = serializable2;
        this.f3080d = obj;
    }

    @Override // zb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i10 = this.f3077a;
        Object obj4 = this.f3080d;
        Serializable serializable = this.f3079c;
        Serializable serializable2 = this.f3078b;
        switch (i10) {
            case 0:
                Ref$BooleanRef ref$BooleanRef = (Ref$BooleanRef) serializable2;
                Ref$LongRef ref$LongRef = (Ref$LongRef) serializable;
                Ref$LongRef ref$LongRef2 = (Ref$LongRef) obj4;
                byte[] b10 = (byte[]) obj;
                int iIntValue = ((Integer) obj2).intValue();
                int iIntValue2 = ((Integer) obj3).intValue();
                kotlin.jvm.internal.g.f(b10, "b");
                ThreadLocal<byte[]> threadLocal = l7.d.f10346a;
                if (l7.d.g(b10, iIntValue, iIntValue2, com.stepos.base.model.b.f6351d)) {
                    ref$BooleanRef.f10073a = true;
                } else if (l7.d.g(b10, iIntValue, iIntValue2, com.stepos.base.model.b.f6352e)) {
                    ref$LongRef.f10075a = l7.d.b(b10, iIntValue, iIntValue2);
                } else if (l7.d.g(b10, iIntValue, iIntValue2, com.stepos.base.model.b.f6353f)) {
                    ref$LongRef2.f10075a = l7.d.b(b10, iIntValue, iIntValue2);
                }
                return lb.n.f10413a;
            default:
                return CpuPerCoreSampler.parseProcStat$lambda$3$lambda$2((Ref$IntRef) serializable2, (Ref$ObjectRef) serializable, (CpuPerCoreSampler) obj4, (byte[]) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
        }
    }
}
