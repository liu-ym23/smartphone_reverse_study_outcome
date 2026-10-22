package com.google.protobuf;

import com.google.protobuf.FieldSet.FieldDescriptorLite;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
abstract class ExtensionSchema<T extends FieldSet.FieldDescriptorLite<T>> {
    abstract int extensionNumber(Map.Entry<?, ?> r1);

    abstract Object findExtensionByNumber(ExtensionRegistryLite r1, MessageLite r2, int r3);

    abstract FieldSet<T> getExtensions(Object r1);

    abstract FieldSet<T> getMutableExtensions(Object r1);

    abstract boolean hasExtensions(MessageLite r1);

    abstract void makeImmutable(Object r1);

    abstract <UT, UB> UB parseExtension(Object r1, Reader r2, Object r3, ExtensionRegistryLite r4, FieldSet<T> r5, UB r6, UnknownFieldSchema<UT, UB> r7);

    abstract void parseLengthPrefixedMessageSetItem(Reader r1, Object r2, ExtensionRegistryLite r3, FieldSet<T> r4);

    abstract void parseMessageSetItem(ByteString r1, Object r2, ExtensionRegistryLite r3, FieldSet<T> r4);

    abstract void serializeExtension(Writer r1, Map.Entry<?, ?> r2);

    abstract void setExtensions(Object r1, FieldSet<T> r2);

    ExtensionSchema() {
    }
}
