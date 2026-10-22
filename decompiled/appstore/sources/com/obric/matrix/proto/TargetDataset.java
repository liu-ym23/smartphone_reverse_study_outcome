package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class TargetDataset extends Message<TargetDataset, a> {
    public static final ProtoAdapter<TargetDataset> ADAPTER = null;
    public static final String DEFAULT_APPID = "";
    public static final String DEFAULT_APPKEY = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;

    @SerializedName("appid")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String appid;

    @SerializedName("appkey")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String appkey;

    @SerializedName("name")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;

    @SerializedName("properties")
    @WireField(adapter = "com.obric.matrix.proto.NullableMap#ADAPTER", tag = 4)
    public final NullableMap properties;

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f12185c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public NullableMap f12186d;

        public a() {
            this.f12183a = "";
            this.f12184b = "";
            this.f12185c = "";
        }

        public a a(String r10) {
            this.f12184b = r10;
            return this;
        }

        public a b(String r10) {
            this.f12185c = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return c();
        }

        public TargetDataset c() {
            return new TargetDataset(this.f12183a, this.f12184b, this.f12185c, this.f12186d, super.buildUnknownFields());
        }

        public a d(String r10) {
            this.f12183a = r10;
            return this;
        }

        public a e(NullableMap r10) {
            this.f12186d = r10;
            return this;
        }
    }

    public static final class b extends ProtoAdapter {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, TargetDataset.class);
        }

        public TargetDataset a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L18;
            if (r13 != 1) goto L8;
            r11.d(ProtoAdapter.STRING.decode(r10));
            goto L3
        L8:
            if (r13 != 2) goto L10;
            r11.a(ProtoAdapter.STRING.decode(r10));
            goto L3
        L10:
            if (r13 != 3) goto L12;
            r11.b(ProtoAdapter.STRING.decode(r10));
            goto L3
        L12:
            if (r13 != 4) goto L13;
            r11.e(NullableMap.ADAPTER.decode(r10));
            goto L3
        L13:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L18:
            r10.endMessage(r12);
            return r11.c();
        }

        public void b(ProtoWriter r10, TargetDataset r11) {
            ProtoAdapter<String> r12 = ProtoAdapter.STRING;
            r12.encodeWithTag(r10, 1, r11.name);
            r12.encodeWithTag(r10, 2, r11.appid);
            r12.encodeWithTag(r10, 3, r11.appkey);
            NullableMap.ADAPTER.encodeWithTag(r10, 4, r11.properties);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(TargetDataset r10) {
            ProtoAdapter<String> r11 = ProtoAdapter.STRING;
            return (((r11.encodedSizeWithTag(1, r10.name) + r11.encodedSizeWithTag(2, r10.appid)) + r11.encodedSizeWithTag(3, r10.appkey)) + NullableMap.ADAPTER.encodedSizeWithTag(4, r10.properties)) + r10.unknownFields().size();
        }

        public TargetDataset d(TargetDataset r10) {
            a r11 = r10.newBuilder();
            NullableMap r12 = r11.f12186d;
            if (r12 == null) goto L5;
            r11.f12186d = NullableMap.ADAPTER.redact(r12);
        L5:
            r11.clearUnknownFields();
            return r11.c();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) {
            b(r10, (TargetDataset) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((TargetDataset) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((TargetDataset) r10);
        }
    }

    static {
        ADAPTER = new b();
    }

    public TargetDataset(String r10, String r11, String r12, NullableMap r13) {
        this(r10, r11, r12, r13, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof TargetDataset) == true) goto L8;
        return false;
    L8:
        TargetDataset r11 = (TargetDataset) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L20;
        if (Internal.equals(this.name, r11.name) == false) goto L20;
        if (Internal.equals(this.appid, r11.appid) == false) goto L20;
        if (Internal.equals(this.appkey, r11.appkey) == false) goto L20;
        if (Internal.equals(this.properties, r11.properties) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L21;
        int r11 = unknownFields().hashCode() * 37;
        String r12 = this.name;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        String r16 = this.appid;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        String r19 = this.appkey;
        if (r19 == null) goto L15;
        int r20 = r19.hashCode();
    L16:
        int r21 = (r18 + r20) * 37;
        NullableMap r22 = this.properties;
        if (r22 == null) goto L19;
        r13 = r22.hashCode();
    L19:
        int r23 = r21 + r13;
        this.hashCode = r23;
        return r23;
    L15:
        r20 = 0;
        goto L16
    L11:
        r17 = 0;
        goto L12
    L7:
        r14 = 0;
        goto L8
    L21:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.name == null) goto L6;
        r10.append(", name=");
        r10.append(this.name);
    L6:
        if (this.appid == null) goto L9;
        r10.append(", appid=");
        r10.append(this.appid);
    L9:
        if (this.appkey == null) goto L12;
        r10.append(", appkey=");
        r10.append(this.appkey);
    L12:
        if (this.properties == null) goto L14;
        r10.append(", properties=");
        r10.append(this.properties);
    L14:
        StringBuilder r11 = r10.replace(0, 2, "TargetDataset{");
        r11.append('}');
        return r11.toString();
    }

    public TargetDataset(String r10, String r11, String r12, NullableMap r13, ByteString r14) {
        super(ADAPTER, r14);
        this.name = r10;
        this.appid = r11;
        this.appkey = r12;
        this.properties = r13;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f12183a = this.name;
        r10.f12184b = this.appid;
        r10.f12185c = this.appkey;
        r10.f12186d = this.properties;
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
