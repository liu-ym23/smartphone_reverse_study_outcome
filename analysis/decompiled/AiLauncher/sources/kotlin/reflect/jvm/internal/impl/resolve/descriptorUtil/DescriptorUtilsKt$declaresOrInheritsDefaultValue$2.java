package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import E9.i0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public final /* synthetic */ class DescriptorUtilsKt$declaresOrInheritsDefaultValue$2 extends FunctionReferenceImpl implements InterfaceC5074l<i0, Boolean> {

    /* renamed from: a, reason: collision with root package name */
    public static final DescriptorUtilsKt$declaresOrInheritsDefaultValue$2 f36005a = new DescriptorUtilsKt$declaresOrInheritsDefaultValue$2();

    public DescriptorUtilsKt$declaresOrInheritsDefaultValue$2() {
        super(1, i0.class, "declaresDefaultValue", "declaresDefaultValue()Z", 0);
    }

    @Override // p9.InterfaceC5074l
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(i0 p02) {
        p.i(p02, "p0");
        return Boolean.valueOf(p02.v0());
    }
}
