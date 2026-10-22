package c8;

import g1.AbstractC1451a;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public final class h extends k implements d {
    public final Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Object obj, Field field) {
        super(field, false);
        kotlin.jvm.internal.k.f(field, "field");
        this.e = obj;
    }

    @Override // c8.k, c8.e
    public final Object call(Object[] args) {
        kotlin.jvm.internal.k.f(args, "args");
        AbstractC1451a.r(this, args);
        return ((Field) this.f2100a).get(this.e);
    }
}
