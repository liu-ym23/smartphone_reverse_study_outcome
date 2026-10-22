package com.google.protobuf;

import com.google.protobuf.MessageLite;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Extension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

    protected static final enum ExtensionType extends java.lang.Enum<ExtensionType> {
        private static final /* synthetic */ ExtensionType[] $VALUES = null;
        public static final ExtensionType IMMUTABLE = null;
        public static final ExtensionType MUTABLE = null;
        public static final ExtensionType PROTO1 = null;

        private static /* synthetic */ ExtensionType[] $values() {
            return new ExtensionType[]{IMMUTABLE, MUTABLE, PROTO1};
        }

        private ExtensionType(String r1, int r2) {
            super(r1, r2);
        }

        public static ExtensionType valueOf(String r2) {
            return (ExtensionType) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(ExtensionType.class, r2), ExtensionType.class, "com.obric.aiagent.plugin");
        }

        public static ExtensionType[] values() {
            return (ExtensionType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ExtensionType[].class, "com.obric.aiagent.plugin");
        }

        static {
            IMMUTABLE = new ExtensionType("IMMUTABLE", 0);
            MUTABLE = new ExtensionType("MUTABLE", 1);
            PROTO1 = new ExtensionType("PROTO1", 2);
            $VALUES = $values();
        }
    }

    public static final enum MessageType extends java.lang.Enum<MessageType> {
        private static final /* synthetic */ MessageType[] $VALUES = null;
        public static final MessageType PROTO1 = null;
        public static final MessageType PROTO2 = null;

        private static /* synthetic */ MessageType[] $values() {
            return new MessageType[]{PROTO1, PROTO2};
        }

        private MessageType(String r1, int r2) {
            super(r1, r2);
        }

        public static MessageType valueOf(String r2) {
            return (MessageType) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(MessageType.class, r2), MessageType.class, "com.obric.aiagent.plugin");
        }

        public static MessageType[] values() {
            return (MessageType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MessageType[].class, "com.obric.aiagent.plugin");
        }

        static {
            PROTO1 = new MessageType("PROTO1", 0);
            PROTO2 = new MessageType("PROTO2", 1);
            $VALUES = $values();
        }
    }

    public abstract Object fromReflectionType(Object r1);

    public abstract Descriptors.FieldDescriptor getDescriptor();

    public abstract ExtensionType getExtensionType();

    @Override // com.google.protobuf.ExtensionLite
    public abstract Message getMessageDefaultInstance();

    @Override // com.google.protobuf.ExtensionLite
    final boolean isLite() {
        return false;
    }

    public abstract Object singularFromReflectionType(Object r1);

    public abstract Object singularToReflectionType(Object r1);

    public abstract Object toReflectionType(Object r1);

    public Extension() {
    }

    @Override // com.google.protobuf.ExtensionLite
    public /* bridge */ /* synthetic */ MessageLite getMessageDefaultInstance() {
        return getMessageDefaultInstance();
    }

    public MessageType getMessageType() {
        return MessageType.PROTO2;
    }
}
