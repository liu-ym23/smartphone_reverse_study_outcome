package ka;

import kotlin.reflect.jvm.internal.impl.types.checker.b;
import ya.v0;

/* renamed from: ka.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4825e implements b.a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f34647a;

    /* renamed from: b, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.descriptors.a f34648b;

    /* renamed from: c, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.descriptors.a f34649c;

    public C4825e(boolean z10, kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        this.f34647a = z10;
        this.f34648b = aVar;
        this.f34649c = aVar2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b.a
    public boolean a(v0 v0Var, v0 v0Var2) {
        return kotlin.reflect.jvm.internal.impl.resolve.a.h(this.f34647a, this.f34648b, this.f34649c, v0Var, v0Var2);
    }
}
