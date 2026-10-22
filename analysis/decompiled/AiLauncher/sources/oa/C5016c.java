package oa;

import Ia.b;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* renamed from: oa.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5016c implements b.c {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f37496a;

    public C5016c(boolean z10) {
        this.f37496a = z10;
    }

    @Override // Ia.b.c
    public Iterable a(Object obj) {
        return DescriptorUtilsKt.j(this.f37496a, (CallableMemberDescriptor) obj);
    }
}
