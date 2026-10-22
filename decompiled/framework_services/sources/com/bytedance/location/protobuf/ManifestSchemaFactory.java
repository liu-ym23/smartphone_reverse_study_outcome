package com.bytedance.location.protobuf;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class ManifestSchemaFactory implements SchemaFactory {
    private static final MessageInfoFactory EMPTY_FACTORY = null;
    private final MessageInfoFactory messageInfoFactory;

    private static class CompositeMessageInfoFactory implements MessageInfoFactory {
        private MessageInfoFactory[] factories;

        CompositeMessageInfoFactory(MessageInfoFactory... factories) {
            this.factories = factories;
        }

        @Override // com.bytedance.location.protobuf.MessageInfoFactory
        public boolean isSupported(Class<?> clazz) {
            MessageInfoFactory[] r0 = this.factories;
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L9;
            MessageInfoFactory factory = r0[r3];
            if (factory.isSupported(clazz) == true) goto L6;
            r3 = r3 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // com.bytedance.location.protobuf.MessageInfoFactory
        public MessageInfo messageInfoFor(Class<?> clazz) {
            MessageInfoFactory[] r0 = this.factories;
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L10;
            MessageInfoFactory factory = r0[r2];
            if (factory.isSupported(clazz) == true) goto L7;
            r2 = r2 + 1;
            goto L3
        L7:
            return factory.messageInfoFor(clazz);
        L10:
            throw new UnsupportedOperationException("No factory is available for message type: " + clazz.getName());
        }
    }

    public ManifestSchemaFactory() {
        this(getDefaultMessageInfoFactory());
    }

    private ManifestSchemaFactory(MessageInfoFactory messageInfoFactory) {
        this.messageInfoFactory = (MessageInfoFactory) Internal.checkNotNull(messageInfoFactory, "messageInfoFactory");
    }

    @Override // com.bytedance.location.protobuf.SchemaFactory
    public <T> Schema<T> createSchema(Class<T> messageType) {
        SchemaUtil.requireGeneratedMessage(messageType);
        MessageInfo messageInfo = this.messageInfoFactory.messageInfoFor(messageType);
        if (messageInfo.isMessageSetWireFormat() == false) goto L11;
        if (GeneratedMessageLite.class.isAssignableFrom(messageType) == false) goto L9;
        return MessageSetSchema.newSchema(SchemaUtil.unknownFieldSetLiteSchema(), ExtensionSchemas.lite(), messageInfo.getDefaultInstance());
    L9:
        return MessageSetSchema.newSchema(SchemaUtil.proto2UnknownFieldSetSchema(), ExtensionSchemas.full(), messageInfo.getDefaultInstance());
    L11:
        return newSchema(messageType, messageInfo);
    }

    private static <T> Schema<T> newSchema(Class<T> messageType, MessageInfo messageInfo) {
        if (GeneratedMessageLite.class.isAssignableFrom(messageType) == false) goto L10;
        if (isProto2(messageInfo) == false) goto L8;
        return MessageSchema.newSchema(messageType, messageInfo, NewInstanceSchemas.lite(), ListFieldSchema.lite(), SchemaUtil.unknownFieldSetLiteSchema(), ExtensionSchemas.lite(), MapFieldSchemas.lite());
    L8:
        return MessageSchema.newSchema(messageType, messageInfo, NewInstanceSchemas.lite(), ListFieldSchema.lite(), SchemaUtil.unknownFieldSetLiteSchema(), null, MapFieldSchemas.lite());
    L10:
        if (isProto2(messageInfo) == false) goto L13;
        return MessageSchema.newSchema(messageType, messageInfo, NewInstanceSchemas.full(), ListFieldSchema.full(), SchemaUtil.proto2UnknownFieldSetSchema(), ExtensionSchemas.full(), MapFieldSchemas.full());
    L13:
        return MessageSchema.newSchema(messageType, messageInfo, NewInstanceSchemas.full(), ListFieldSchema.full(), SchemaUtil.proto3UnknownFieldSetSchema(), null, MapFieldSchemas.full());
    }

    private static boolean isProto2(MessageInfo messageInfo) {
        if (messageInfo.getSyntax() != ProtoSyntax.PROTO2) goto L5;
        return true;
    L5:
        return false;
    }

    private static MessageInfoFactory getDefaultMessageInfoFactory() {
        return new CompositeMessageInfoFactory(new MessageInfoFactory[]{GeneratedMessageInfoFactory.getInstance(), getDescriptorMessageInfoFactory()});
    }

    static {
        EMPTY_FACTORY = new AnonymousClass1();
    }

    private static MessageInfoFactory getDescriptorMessageInfoFactory() {
        Class<?> clazz = Class.forName("com.bytedance.location.protobuf.DescriptorMessageInfoFactory");     // Catch: Exception -> L4
        return (MessageInfoFactory) clazz.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
    L6:
        return EMPTY_FACTORY;
    }
}
