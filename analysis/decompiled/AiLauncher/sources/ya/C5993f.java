package ya;

import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import p9.InterfaceC5063a;

/* renamed from: ya.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5993f implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final TypeCheckerState f44081a;

    /* renamed from: b, reason: collision with root package name */
    public final Ca.q f44082b;

    /* renamed from: c, reason: collision with root package name */
    public final Ca.h f44083c;

    /* renamed from: d, reason: collision with root package name */
    public final Ca.h f44084d;

    public C5993f(TypeCheckerState typeCheckerState, Ca.q qVar, Ca.h hVar, Ca.h hVar2) {
        this.f44081a = typeCheckerState;
        this.f44082b = qVar;
        this.f44083c = hVar;
        this.f44084d = hVar2;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return Boolean.valueOf(kotlin.reflect.jvm.internal.impl.types.b.z(this.f44081a, this.f44082b, this.f44083c, this.f44084d));
    }
}
