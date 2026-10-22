package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/* JADX INFO: loaded from: classes4.dex */
final class MessageSerializedForm<M extends Message<M, B>, B extends Message.Builder<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;
    private final byte[] bytes;
    private final Class<M> messageClass;

    public MessageSerializedForm(byte[] r10, Class<M> r11) {
        this.bytes = r10;
        this.messageClass = r11;
    }

    public Object readResolve() throws ObjectStreamException {
        ProtoAdapter r10 = ProtoAdapter.get(this.messageClass);
        return r10.decode(this.bytes);
    L5:
        e = move-exception;
        throw new StreamCorruptedException(e.getMessage());
    }
}
