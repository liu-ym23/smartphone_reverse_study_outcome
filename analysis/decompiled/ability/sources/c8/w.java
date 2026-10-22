package c8;

import g1.AbstractC1451a;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.collections.EmptyList;

/* loaded from: classes4.dex */
public final class w extends y implements d {
    public final Object d;

    public w(Method method, Object obj) {
        super(method, EmptyList.f4893a);
        this.d = obj;
    }

    @Override // c8.e
    public final Object call(Object[] args) {
        kotlin.jvm.internal.k.f(args, "args");
        AbstractC1451a.r(this, args);
        return this.f2101a.invoke(this.d, Arrays.copyOf(args, args.length));
    }
}
