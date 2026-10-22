package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public final /* synthetic */ class DescriptorRendererImpl$renderFlexibleType$3 extends FunctionReferenceImpl implements InterfaceC5074l<String, String> {
    public DescriptorRendererImpl$renderFlexibleType$3(Object obj) {
        super(1, obj, DescriptorRendererImpl.class, "escape", "escape(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    @Override // p9.InterfaceC5074l
    public final String invoke(String p02) {
        p.i(p02, "p0");
        return ((DescriptorRendererImpl) this.receiver).t0(p02);
    }
}
