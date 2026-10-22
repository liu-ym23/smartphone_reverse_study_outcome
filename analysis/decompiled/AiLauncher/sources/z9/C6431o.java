package z9;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import p9.InterfaceC5063a;

/* renamed from: z9.o, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C6431o implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final CallableMemberDescriptor f45373a;

    /* renamed from: b, reason: collision with root package name */
    public final int f45374b;

    public C6431o(CallableMemberDescriptor callableMemberDescriptor, int i10) {
        this.f45373a = callableMemberDescriptor;
        this.f45374b = i10;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return kotlin.reflect.jvm.internal.d.w(this.f45373a, this.f45374b);
    }
}
