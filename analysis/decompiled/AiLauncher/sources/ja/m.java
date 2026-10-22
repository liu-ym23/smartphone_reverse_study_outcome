package ja;

import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl;
import p9.InterfaceC5063a;

/* loaded from: classes5.dex */
public class m implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final DescriptorRendererImpl f34549a;

    /* renamed from: b, reason: collision with root package name */
    public final C9.j f34550b;

    public m(DescriptorRendererImpl descriptorRendererImpl, C9.j jVar) {
        this.f34549a = descriptorRendererImpl;
        this.f34550b = jVar;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return DescriptorRendererImpl.Q1(this.f34549a, this.f34550b);
    }
}
