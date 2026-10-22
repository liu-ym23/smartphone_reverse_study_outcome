package qb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lqb/a;", "from", "Lkotlin/Function1;", "Lqb/d;", "LY8/t;", "builderAction", Const.INTENT_KEY_APIKEY, "(Lqb/a;Lp9/l;)Lqb/a;", "kotlinx-serialization-json"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class v {
    public static final AbstractC5171a a(AbstractC5171a from, InterfaceC5074l<? super C5174d, Y8.t> builderAction) {
        kotlin.jvm.internal.p.i(from, "from");
        kotlin.jvm.internal.p.i(builderAction, "builderAction");
        C5174d c5174d = new C5174d(from);
        builderAction.invoke(c5174d);
        return new u(c5174d.a(), c5174d.getSerializersModule());
    }

    public static /* synthetic */ AbstractC5171a b(AbstractC5171a abstractC5171a, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            abstractC5171a = AbstractC5171a.INSTANCE;
        }
        return a(abstractC5171a, interfaceC5074l);
    }
}
