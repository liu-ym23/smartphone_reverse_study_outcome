package com.google.protobuf;

import com.google.protobuf.h2;
import com.google.protobuf.z;

/* loaded from: classes.dex */
public interface GeneratedMessageLite$ExtendableMessageOrBuilder<MessageType extends h2, BuilderType extends z> {
    /* synthetic */ MessageLite getDefaultInstanceForType();

    <Type> Type getExtension(r1 r1Var);

    <Type> Type getExtension(r1 r1Var, int i2);

    <Type> int getExtensionCount(r1 r1Var);

    <Type> boolean hasExtension(r1 r1Var);

    /* synthetic */ boolean isInitialized();
}
