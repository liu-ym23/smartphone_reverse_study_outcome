package I4;

import C7.r;
import com.stepos.motionkit.FxConfig;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes3.dex */
public final /* synthetic */ class j implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f801a;
    public final /* synthetic */ com.stepos.ability.voicewakeup.training.motionkit.a b;

    public /* synthetic */ j(com.stepos.ability.voicewakeup.training.motionkit.a aVar, int i) {
        this.f801a = i;
        this.b = aVar;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f801a) {
            case 0:
                FxConfig start = (FxConfig) obj;
                kotlin.jvm.internal.k.f(start, "$this$start");
                int iOrdinal = this.b.e.ordinal();
                if (iOrdinal == 0) {
                    start.sf();
                } else if (iOrdinal == 1) {
                    start.surface(new Ba.f(15));
                } else {
                    if (iOrdinal != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    start.surface(new Ba.f(16));
                }
                return r.f317a;
            default:
                String name = (String) obj;
                kotlin.jvm.internal.k.f(name, "name");
                return Float.valueOf(this.b.i.t(name));
        }
    }
}
