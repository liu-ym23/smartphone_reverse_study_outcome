package com.google.protobuf;

/* renamed from: com.google.protobuf.b2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0923b2 implements InterfaceC0927c2 {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0916a f2908a;
    public boolean b = true;

    public C0923b2(AbstractC0916a abstractC0916a) {
        this.f2908a = abstractC0916a;
    }

    public final AbstractC0916a a(D0 d02) {
        if (!this.b) {
            return null;
        }
        try {
            return this.f2908a.o(d02);
        } catch (UnsupportedOperationException unused) {
            this.b = false;
            return null;
        }
    }

    @Override // com.google.protobuf.InterfaceC0927c2
    public final InterfaceC0927c2 e(D0 d02, Object obj) {
        boolean zIsRepeated = d02.isRepeated();
        AbstractC0916a abstractC0916a = this.f2908a;
        if (zIsRepeated || !(obj instanceof W1)) {
            abstractC0916a.y(d02, obj);
            return this;
        }
        if (obj != a(d02)) {
            abstractC0916a.y(d02, ((W1) obj).m());
        }
        return this;
    }

    @Override // com.google.protobuf.InterfaceC0927c2
    public final void f(AbstractC0972o abstractC0972o, R0 r02, D0 d02) {
        AbstractC0916a abstractC0916aW;
        boolean zIsRepeated = d02.isRepeated();
        AbstractC0916a abstractC0916a = this.f2908a;
        if (zIsRepeated) {
            AbstractC0916a abstractC0916aW2 = abstractC0916a.w(d02);
            abstractC0972o.v(abstractC0916aW2, r02);
            l(d02, abstractC0916aW2.m());
            return;
        }
        if (abstractC0916a.d(d02)) {
            W1 w1A = a(d02);
            if (w1A != null) {
                abstractC0972o.v(w1A, r02);
                return;
            } else {
                abstractC0916aW = abstractC0916a.w(d02);
                abstractC0916aW.t((AbstractC0924c) abstractC0916a.a(d02));
            }
        } else {
            abstractC0916aW = abstractC0916a.w(d02);
        }
        abstractC0972o.v(abstractC0916aW, r02);
        e(d02, abstractC0916aW.m());
    }

    @Override // com.google.protobuf.InterfaceC0927c2
    public final void g(O0 o02, C1004w0 c1004w0, int i) {
        if (o02.f.get(new N0(c1004w0, i)) != null) {
            throw new ClassCastException();
        }
    }

    @Override // com.google.protobuf.InterfaceC0927c2
    public final WireFormat$Utf8Validation i(D0 d02) {
        if (d02.p()) {
            return WireFormat$Utf8Validation.b;
        }
        d02.isRepeated();
        return WireFormat$Utf8Validation.f2890a;
    }

    @Override // com.google.protobuf.InterfaceC0927c2
    public final void j(AbstractC0972o abstractC0972o, R0 r02, D0 d02) {
        AbstractC0916a abstractC0916aW;
        boolean zIsRepeated = d02.isRepeated();
        DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = d02.b;
        AbstractC0916a abstractC0916a = this.f2908a;
        if (zIsRepeated) {
            AbstractC0916a abstractC0916aW2 = abstractC0916a.w(d02);
            abstractC0972o.r(descriptorProtos$FieldDescriptorProto.e, abstractC0916aW2, r02);
            l(d02, abstractC0916aW2.m());
            return;
        }
        if (abstractC0916a.d(d02)) {
            W1 w1A = a(d02);
            if (w1A != null) {
                abstractC0972o.r(descriptorProtos$FieldDescriptorProto.e, w1A, r02);
                return;
            } else {
                abstractC0916aW = abstractC0916a.w(d02);
                abstractC0916aW.t((AbstractC0924c) abstractC0916a.a(d02));
            }
        } else {
            abstractC0916aW = abstractC0916a.w(d02);
        }
        abstractC0972o.r(descriptorProtos$FieldDescriptorProto.e, abstractC0916aW, r02);
        e(d02, abstractC0916aW.m());
    }

    @Override // com.google.protobuf.InterfaceC0927c2
    public final MessageReflection$MergeTarget$ContainerType k() {
        return MessageReflection$MergeTarget$ContainerType.f2857a;
    }

    @Override // com.google.protobuf.InterfaceC0927c2
    public final InterfaceC0927c2 l(D0 d02, Object obj) {
        if (obj instanceof W1) {
            obj = ((W1) obj).m();
        }
        this.f2908a.j(d02, obj);
        return this;
    }
}
