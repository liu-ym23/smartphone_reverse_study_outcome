package oa;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import p9.InterfaceC5074l;

/* renamed from: oa.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5017d implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f37497a;

    public C5017d(boolean z10) {
        this.f37497a = z10;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return DescriptorUtilsKt.A(this.f37497a, (CallableMemberDescriptor) obj);
    }
}
