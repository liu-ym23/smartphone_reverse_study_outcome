package com.google.protobuf;

import com.google.protobuf.MessageLite;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Extension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

    public static final enum ExtensionType extends java.lang.Enum<ExtensionType> {
        private static final /* synthetic */ ExtensionType[] $VALUES = null;
        public static final ExtensionType IMMUTABLE = null;
        public static final ExtensionType MUTABLE = null;
        public static final ExtensionType PROTO1 = null;

        static {
            ExtensionType r10 = new ExtensionType("IMMUTABLE", 0);
            IMMUTABLE = r10;
            ExtensionType r11 = new ExtensionType("MUTABLE", 1);
            MUTABLE = r11;
            ExtensionType r12 = new ExtensionType("PROTO1", 2);
            PROTO1 = r12;
            $VALUES = new ExtensionType[]{r10, r11, r12};
        }

        private ExtensionType(String r10, int r11) {
            super(r10, r11);
        }

        public static ExtensionType valueOf(String r10) {
            return (ExtensionType) java.lang.Enum.valueOf(ExtensionType.class, r10);
        }

        public static ExtensionType[] values() {
            return (ExtensionType[]) $VALUES.clone();
        }
    }

    public static final enum MessageType extends java.lang.Enum<MessageType> {
        private static final /* synthetic */ MessageType[] $VALUES = null;
        public static final MessageType PROTO1 = null;
        public static final MessageType PROTO2 = null;

        static {
            MessageType r10 = new MessageType("PROTO1", 0);
            PROTO1 = r10;
            MessageType r11 = new MessageType("PROTO2", 1);
            PROTO2 = r11;
            $VALUES = new MessageType[]{r10, r11};
        }

        private MessageType(String r10, int r11) {
            super(r10, r11);
        }

        public static MessageType valueOf(String r10) {
            return (MessageType) java.lang.Enum.valueOf(MessageType.class, r10);
        }

        public static MessageType[] values() {
            return (MessageType[]) $VALUES.clone();
        }
    }

    public Extension() {
    }

    public abstract Object fromReflectionType(Object r10);

    public abstract Descriptors.FieldDescriptor getDescriptor();

    public ExtensionType getExtensionType() {
        return ExtensionType.IMMUTABLE;
    }

    public MessageType getMessageType() {
        return MessageType.PROTO2;
    }

    @Override // com.google.protobuf.ExtensionLite
    public final boolean isLite() {
        return false;
    }

    public abstract Object singularFromReflectionType(Object r10);

    public abstract Object singularToReflectionType(Object r10);

    public abstract Object toReflectionType(Object r10);
}
