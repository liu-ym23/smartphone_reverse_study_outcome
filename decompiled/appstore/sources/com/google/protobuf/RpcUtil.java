package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public final class RpcUtil {

    public static final class AlreadyCalledException extends RuntimeException {
        private static final long serialVersionUID = 5469741279507848266L;

        public AlreadyCalledException() {
            super("This RpcCallback was already called and cannot be called multiple times.");
        }
    }

    private RpcUtil() {
    }

    public static /* synthetic */ Message access$000(Message r10, Message r11) {
        return copyAsType(r10, r11);
    }

    private static <Type extends Message> Type copyAsType(Type r10, Message r11) {
        return (Type) r10.newBuilderForType().mergeFrom(r11).build();
    }

    public static <Type extends Message> RpcCallback<Message> generalizeCallback(final RpcCallback<Type> r10, final Class<Type> r11, final Type r12) {
        return new AnonymousClass1(r11, r12, r10);
    }

    public static <ParameterType> RpcCallback<ParameterType> newOneTimeCallback(final RpcCallback<ParameterType> r10) {
        return new AnonymousClass2(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <Type extends Message> RpcCallback<Type> specializeCallback(RpcCallback<Message> r10) {
        return r10;
    }
}
