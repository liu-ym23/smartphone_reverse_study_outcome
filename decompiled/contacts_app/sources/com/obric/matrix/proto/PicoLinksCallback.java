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
public final class PicoLinksCallback extends Message<PicoLinksCallback, Builder> {
    public static final ProtoAdapter<PicoLinksCallback> ADAPTER = null;
    public static final Integer DEFAULT_CALLBACKID = null;
    private static final long serialVersionUID = 0;

    @SerializedName("callbackData")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, String> callbackData;

    @SerializedName("callbackId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer callbackId;

    public static final class Builder extends Message.Builder<PicoLinksCallback, Builder> {
        public Map<String, String> callbackData;
        public Integer callbackId;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.callbackId = 0;
            this.callbackData = Internal.newMutableMap();
        }

        public Builder callbackId(Integer r1) {
            this.callbackId = r1;
            return this;
        }

        public Builder callbackData(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.callbackData = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public PicoLinksCallback build() {
            return new PicoLinksCallback(this.callbackId, this.callbackData, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_PicoLinksCallback extends ProtoAdapter<PicoLinksCallback> {
        private final ProtoAdapter<Map<String, String>> callbackData;

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PicoLinksCallback decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, PicoLinksCallback r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PicoLinksCallback r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PicoLinksCallback redact(PicoLinksCallback r1) {
            return redact2(r1);
        }

        public ProtoAdapter_PicoLinksCallback() {
            super(FieldEncoding.LENGTH_DELIMITED, PicoLinksCallback.class);
            this.callbackData = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PicoLinksCallback r4) {
            return (ProtoAdapter.INT32.encodedSizeWithTag(1, r4.callbackId) + this.callbackData.encodedSizeWithTag(2, r4.callbackData)) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r4, PicoLinksCallback r5) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r5.callbackId);
            this.callbackData.encodeWithTag(r4, 2, r5.callbackData);
            r4.writeBytes(r5.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PicoLinksCallback decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.callbackId(ProtoAdapter.INT32.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.callbackData.putAll(this.callbackData.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public PicoLinksCallback redact2(PicoLinksCallback r1) {
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
        ADAPTER = new ProtoAdapter_PicoLinksCallback();
        DEFAULT_CALLBACKID = 0;
    }

    public PicoLinksCallback(Integer r2, Map<String, String> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PicoLinksCallback(Integer r2, Map<String, String> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.callbackId = r2;
        this.callbackData = Internal.immutableCopyOf("callbackData", r3);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.callbackId = this.callbackId;
        r0.callbackData = Internal.copyOf("callbackData", this.callbackData);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof PicoLinksCallback) == true) goto L8;
        return false;
    L8:
        PicoLinksCallback r6 = (PicoLinksCallback) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.callbackId, r6.callbackId) == false) goto L16;
        if (this.callbackData.equals(r6.callbackData) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.callbackId;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = ((r1 + r3) * 37) + this.callbackData.hashCode();
        this.hashCode = r4;
        return r4;
    L7:
        r3 = 0;
        goto L8
    L10:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.callbackId == null) goto L5;
        r0.append(", callbackId=").append(this.callbackId);
    L5:
        Map<String, String> r1 = this.callbackData;
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.append(", callbackData=").append(this.callbackData);
    L11:
        return r0.replace(0, 2, "PicoLinksCallback{").append('}').toString();
    }
}
