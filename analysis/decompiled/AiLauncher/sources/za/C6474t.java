package za;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector;
import p9.InterfaceC5063a;

/* renamed from: za.t, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C6474t implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final Set f45426a;

    public C6474t(Set set) {
        this.f45426a = set;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return TypeIntersector.f(this.f45426a);
    }
}
