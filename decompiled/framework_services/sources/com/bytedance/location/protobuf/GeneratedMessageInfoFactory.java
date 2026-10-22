package com.bytedance.location.protobuf;

/* JADX INFO: loaded from: classes3.dex */
class GeneratedMessageInfoFactory implements MessageInfoFactory {
    private static final GeneratedMessageInfoFactory instance = null;

    static {
        instance = new GeneratedMessageInfoFactory();
    }

    private GeneratedMessageInfoFactory() {
    }

    public static GeneratedMessageInfoFactory getInstance() {
        return instance;
    }

    @Override // com.bytedance.location.protobuf.MessageInfoFactory
    public boolean isSupported(Class<?> messageType) {
        return GeneratedMessageLite.class.isAssignableFrom(messageType);
    }

    @Override // com.bytedance.location.protobuf.MessageInfoFactory
    public MessageInfo messageInfoFor(Class<?> messageType) {
        if (GeneratedMessageLite.class.isAssignableFrom(messageType) == false) goto L10;
        return (MessageInfo) GeneratedMessageLite.getDefaultInstance(messageType.asSubclass(GeneratedMessageLite.class)).buildMessageInfo();
    L6:
        e = move-exception;
        throw new RuntimeException("Unable to get message info for " + messageType.getName(), e);
    L10:
        throw new IllegalArgumentException("Unsupported message type: " + messageType.getName());
    }
}
