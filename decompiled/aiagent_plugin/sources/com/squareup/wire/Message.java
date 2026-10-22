package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import e.e;
import e.f;
import e.h;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Message<M extends Message<M, B>, B extends Builder<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;
    private final transient ProtoAdapter<M> adapter;
    transient int cachedSerializedSize;
    protected transient int hashCode;
    private final transient h unknownFields;

    public static abstract class Builder<M extends Message<M, B>, B extends Builder<M, B>> {
        transient e unknownFieldsBuffer;
        transient h unknownFieldsByteString;
        transient ProtoWriter unknownFieldsWriter;

        public abstract M build();

        public Builder() {
            this.unknownFieldsByteString = h.f38723b;
        }

        public final Builder<M, B> addUnknownFields(h r2) {
            if (r2.k() <= 0) goto L9;
            prepareForNewUnknownFields();
            this.unknownFieldsWriter.writeBytes(r2);     // Catch: IOException -> L7
        L8:
            throw new AssertionError();
        L9:
            return this;
        }

        public final Builder<M, B> addUnknownField(int r2, FieldEncoding r3, Object r4) {
            prepareForNewUnknownFields();
            r3.rawProtoAdapter().encodeWithTag(this.unknownFieldsWriter, r2, r4);     // Catch: IOException -> L5
            return this;
        L6:
            throw new AssertionError();
        }

        public final Builder<M, B> clearUnknownFields() {
            this.unknownFieldsByteString = h.f38723b;
            e r0 = this.unknownFieldsBuffer;
            if (r0 == null) goto L5;
            r0.x();
            this.unknownFieldsBuffer = null;
        L5:
            this.unknownFieldsWriter = null;
            return this;
        }

        public final h buildUnknownFields() {
            e r0 = this.unknownFieldsBuffer;
            if (r0 == null) goto L6;
            this.unknownFieldsByteString = r0.t();
            this.unknownFieldsBuffer = null;
            this.unknownFieldsWriter = null;
        L6:
            return this.unknownFieldsByteString;
        }

        private void prepareForNewUnknownFields() {
            if (this.unknownFieldsBuffer != null) goto L9;
            this.unknownFieldsBuffer = new e();
            ProtoWriter r0 = new ProtoWriter(this.unknownFieldsBuffer);
            this.unknownFieldsWriter = r0;
            r0.writeBytes(this.unknownFieldsByteString);     // Catch: IOException -> L7
            this.unknownFieldsByteString = h.f38723b;
            return;
        L8:
            throw new AssertionError();
        }
    }

    public abstract Builder<M, B> newBuilder();

    public Message(ProtoAdapter<M> r2, h r3) {
        this.cachedSerializedSize = 0;
        this.hashCode = 0;
        Objects.requireNonNull(r2, "adapter == null");
        Objects.requireNonNull(r3, "unknownFields == null");
        this.adapter = r2;
        this.unknownFields = r3;
    }

    public final h unknownFields() {
        h r0 = this.unknownFields;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return h.f38723b;
    }

    public final M withoutUnknownFields() {
        return (M) newBuilder().clearUnknownFields().build();
    }

    public String toString() {
        return this.adapter.toString(this);
    }

    public final Object writeReplace() {
        return new MessageSerializedForm(encode(), getClass());
    }

    public final ProtoAdapter<M> adapter() {
        return this.adapter;
    }

    public final void encode(f r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");
        this.adapter.encode(r4, this);
    }

    public final byte[] encode() {
        return this.adapter.encode(this);
    }

    public final void encode(OutputStream r2) {
        this.adapter.encode(r2, this);
    }
}
