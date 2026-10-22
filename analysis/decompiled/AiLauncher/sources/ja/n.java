package ja;

import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl;
import p9.InterfaceC5063a;

/* loaded from: classes5.dex */
public class n implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final DescriptorRendererImpl f34551a;

    /* renamed from: b, reason: collision with root package name */
    public final C9.j f34552b;

    public n(DescriptorRendererImpl descriptorRendererImpl, C9.j jVar) {
        this.f34551a = descriptorRendererImpl;
        this.f34552b = jVar;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return DescriptorRendererImpl.R1(this.f34551a, this.f34552b);
    }
}
