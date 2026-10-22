package ya;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import p9.InterfaceC5074l;

/* renamed from: ya.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5991e implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final Collection f44072a;

    /* renamed from: b, reason: collision with root package name */
    public final TypeCheckerState f44073b;

    /* renamed from: c, reason: collision with root package name */
    public final Ca.q f44074c;

    /* renamed from: d, reason: collision with root package name */
    public final Ca.h f44075d;

    public C5991e(Collection collection, TypeCheckerState typeCheckerState, Ca.q qVar, Ca.h hVar) {
        this.f44072a = collection;
        this.f44073b = typeCheckerState;
        this.f44074c = qVar;
        this.f44075d = hVar;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return kotlin.reflect.jvm.internal.impl.types.b.y(this.f44072a, this.f44073b, this.f44074c, this.f44075d, (TypeCheckerState.a) obj);
    }
}
