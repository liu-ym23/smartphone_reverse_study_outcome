package d9;

/* loaded from: classes4.dex */
public abstract class w implements InterfaceC1384e {

    /* renamed from: a, reason: collision with root package name */
    public final S7.k f4329a;
    public final String b;

    public w(String str, S7.k kVar) {
        this.f4329a = kVar;
        this.b = "must return ".concat(str);
    }

    @Override // d9.InterfaceC1384e
    public final boolean a(kotlin.reflect.jvm.internal.impl.load.java.descriptors.a aVar) {
        return kotlin.jvm.internal.k.b(aVar.g, this.f4329a.invoke(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(aVar)));
    }

    @Override // d9.InterfaceC1384e
    public final String b(kotlin.reflect.jvm.internal.impl.load.java.descriptors.a aVar) {
        return com.stepos.ability.task.executor.e.F(this, aVar);
    }

    @Override // d9.InterfaceC1384e
    public final String getDescription() {
        return this.b;
    }
}
