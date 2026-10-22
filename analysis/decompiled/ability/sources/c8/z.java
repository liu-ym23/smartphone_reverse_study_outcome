package c8;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.collections.EmptyList;

/* loaded from: classes4.dex */
public final class z implements e {

    /* renamed from: a, reason: collision with root package name */
    public static final z f2102a = new z();

    @Override // c8.e
    public final List a() {
        return EmptyList.f4893a;
    }

    @Override // c8.e
    public final Object call(Object[] args) {
        kotlin.jvm.internal.k.f(args, "args");
        throw new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    }

    @Override // c8.e
    public final /* bridge */ /* synthetic */ Member getMember() {
        return null;
    }

    @Override // c8.e
    public final Type getReturnType() {
        Class TYPE = Void.TYPE;
        kotlin.jvm.internal.k.e(TYPE, "TYPE");
        return TYPE;
    }
}
