package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class NullableMap extends Message<NullableMap, Builder> {
    public static final ProtoAdapter<NullableMap> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("_value")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final Map<String, String> _value;

    public static final class Builder extends Message.Builder<NullableMap, Builder> {
        public Map<String, String> _value;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this._value = Internal.newMutableMap();
        }

        public Builder _value(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this._value = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public NullableMap build() {
            return new NullableMap(this._value, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_NullableMap extends ProtoAdapter<NullableMap> {
        private final ProtoAdapter<Map<String, String>> _value;

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ NullableMap decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, NullableMap r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(NullableMap r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ NullableMap redact(NullableMap r1) {
            return redact2(r1);
        }

        public ProtoAdapter_NullableMap() {
            super(FieldEncoding.LENGTH_DELIMITED, NullableMap.class);
            this._value = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(NullableMap r3) {
            return this._value.encodedSizeWithTag(1, r3._value) + r3.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, NullableMap r4) throws IOException {
            this._value.encodeWithTag(r3, 1, r4._value);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public NullableMap decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0._value.putAll(this._value.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public NullableMap redact2(NullableMap r1) {
            Builder r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.build();
        }
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    static {
        ADAPTER = new ProtoAdapter_NullableMap();
    }

    public NullableMap(Map<String, String> r2) {
        this(r2, ByteString.EMPTY);
    }

    public NullableMap(Map<String, String> r2, ByteString r3) {
        super(ADAPTER, r3);
        this._value = Internal.immutableCopyOf("_value", r2);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0._value = Internal.copyOf("_value", this._value);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof NullableMap) == true) goto L8;
        return false;
    L8:
        NullableMap r6 = (NullableMap) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this._value.equals(r6._value) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this._value.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        Map<String, String> r1 = this._value;
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        r0.append(", _value=").append(this._value);
    L8:
        return r0.replace(0, 2, "NullableMap{").append('}').toString();
    }
}
