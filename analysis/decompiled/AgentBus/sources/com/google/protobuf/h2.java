package com.google.protobuf;

import com.google.protobuf.MessageLite;

/* loaded from: classes.dex */
public abstract class h2 extends i2 implements GeneratedMessageLite$ExtendableMessageOrBuilder {
    protected b2 extensions = b2.f2317c;

    @Override // com.google.protobuf.i2, com.google.protobuf.MessageLite, com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return (i2) d(6, null);
    }

    @Override // com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    public final Object getExtension(r1 r1Var) {
        throw null;
    }

    @Override // com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    public final int getExtensionCount(r1 r1Var) {
        throw null;
    }

    @Override // com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    public final boolean hasExtension(r1 r1Var) {
        throw null;
    }

    @Override // com.google.protobuf.i2, com.google.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return (f2) d(5, null);
    }

    public final b2 p() {
        b2 b2Var = this.extensions;
        if (b2Var.f2319b) {
            this.extensions = b2Var.clone();
        }
        return this.extensions;
    }

    @Override // com.google.protobuf.i2, com.google.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        f2 f2Var = (f2) d(5, null);
        if (f2Var.f2350f.equals(this)) {
            return f2Var;
        }
        f2Var.d();
        f2.h(f2Var.f2351g, this);
        return f2Var;
    }

    @Override // com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder
    public final Object getExtension(r1 r1Var, int i2) {
        throw null;
    }
}
