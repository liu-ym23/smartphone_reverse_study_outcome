package c8;

import g1.AbstractC1451a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class g extends v {
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(Member member, Type type, Class cls, Type[] typeArr, int i) {
        super(member, type, cls, typeArr);
        this.e = i;
    }

    @Override // c8.e
    public final Object call(Object[] args) {
        switch (this.e) {
            case 0:
                kotlin.jvm.internal.k.f(args, "args");
                AbstractC1451a.r(this, args);
                Constructor constructor = (Constructor) this.f2100a;
                Z0.a aVar = new Z0.a(2);
                aVar.E(args);
                aVar.D(null);
                ArrayList arrayList = (ArrayList) aVar.f1582a;
                return constructor.newInstance(arrayList.toArray(new Object[arrayList.size()]));
            default:
                kotlin.jvm.internal.k.f(args, "args");
                AbstractC1451a.r(this, args);
                return ((Constructor) this.f2100a).newInstance(Arrays.copyOf(args, args.length));
        }
    }
}
