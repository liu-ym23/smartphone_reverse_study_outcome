package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class NullableMap extends Message<NullableMap, a> {
    public static final ProtoAdapter<NullableMap> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("_value")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final Map<String, String> _value;

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map f12036a;

        public a() {
            this.f12036a = Internal.newMutableMap();
        }

        public NullableMap a() {
            return new NullableMap(this.f12036a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ProtoAdapter f12037a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, NullableMap.class);
            ProtoAdapter<String> r10 = ProtoAdapter.STRING;
            this.f12037a = ProtoAdapter.newMapAdapter(r10, r10);
        }

        public NullableMap a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L9;
            if (r13 != 1) goto L7;
            r11.f12036a.putAll((Map) this.f12037a.decode(r10));
            goto L3
        L7:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L9:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, NullableMap r11) {
            this.f12037a.encodeWithTag(r10, 1, r11._value);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(NullableMap r10) {
            return this.f12037a.encodedSizeWithTag(1, r10._value) + r10.unknownFields().size();
        }

        public NullableMap d(NullableMap r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) {
            b(r10, (NullableMap) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((NullableMap) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((NullableMap) r10);
        }
    }

    static {
        ADAPTER = new b();
    }

    public NullableMap(Map<String, String> r10) {
        this(r10, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof NullableMap) == true) goto L8;
        return false;
    L8:
        NullableMap r11 = (NullableMap) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L14;
        if (this._value.equals(r11._value) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L6;
        int r11 = (unknownFields().hashCode() * 37) + this._value.hashCode();
        this.hashCode = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        Map<String, String> r11 = this._value;
        if (r11 != null) goto L5;
    L7:
        StringBuilder r12 = r10.replace(0, 2, "NullableMap{");
        r12.append('}');
        return r12.toString();
    L5:
        if (r11.isEmpty() == true) goto L7;
        r10.append(", _value=");
        r10.append(this._value);
        goto L7
    }

    public NullableMap(Map<String, String> r10, ByteString r11) {
        super(ADAPTER, r11);
        this._value = Internal.immutableCopyOf("_value", r10);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f12036a = Internal.copyOf("_value", this._value);
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
