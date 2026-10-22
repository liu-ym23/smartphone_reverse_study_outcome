package com.obric.matrix.proto;

import com.bytedanceos.common.toolbox.ServerElements;
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
public final class GenericNetworkRequest extends Message<GenericNetworkRequest, a> {
    public static final ProtoAdapter<GenericNetworkRequest> ADAPTER = null;
    public static final String DEFAULT_ACCESSTOKEN = "";
    public static final ByteString DEFAULT_BODY = null;
    public static final NETWORK_METHOD DEFAULT_METHOD = null;
    public static final Boolean DEFAULT_NEEDACCESSTOKEN = null;
    public static final String DEFAULT_PATH = "";
    private static final long serialVersionUID = 0;

    @SerializedName("accessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String accessToken;

    @SerializedName(ServerElements.BODY)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 5)
    public final ByteString body;

    @SerializedName("headerParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, String> headerParams;

    @SerializedName("method")
    @WireField(adapter = "com.obric.matrix.proto.NETWORK_METHOD#ADAPTER", label = WireField.Label.REQUIRED, tag = 2)
    public final NETWORK_METHOD method;

    @SerializedName("needAccessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean needAccessToken;

    @SerializedName("path")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    public final String path;

    @SerializedName("queryParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> queryParams;

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public NETWORK_METHOD f11990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map f11991c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map f11992d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ByteString f11993e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Boolean f11994f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f11995g;

        public a() {
            this.f11989a = "";
            this.f11990b = NETWORK_METHOD.METHOD_GET;
            this.f11993e = ByteString.EMPTY;
            this.f11994f = Boolean.FALSE;
            this.f11995g = "";
            this.f11991c = Internal.newMutableMap();
            this.f11992d = Internal.newMutableMap();
        }

        public a a(String r10) {
            this.f11995g = r10;
            return this;
        }

        public a b(ByteString r10) {
            this.f11993e = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return c();
        }

        public GenericNetworkRequest c() {
            String r10 = this.f11989a;
            if (r10 == null) goto L9;
            if (this.f11990b == null) goto L9;
            return new GenericNetworkRequest(this.f11989a, this.f11990b, this.f11991c, this.f11992d, this.f11993e, this.f11994f, this.f11995g, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r10, "path", this.f11990b, "method"});
        }

        public a d(NETWORK_METHOD r10) {
            this.f11990b = r10;
            return this;
        }

        public a e(Boolean r10) {
            this.f11994f = r10;
            return this;
        }

        public a f(String r10) {
            this.f11989a = r10;
            return this;
        }
    }

    public static final class b extends ProtoAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ProtoAdapter f11996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ProtoAdapter f11997b;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, GenericNetworkRequest.class);
            ProtoAdapter<String> r10 = ProtoAdapter.STRING;
            this.f11996a = ProtoAdapter.newMapAdapter(r10, r10);
            this.f11997b = ProtoAdapter.newMapAdapter(r10, r10);
        }

        public GenericNetworkRequest a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L17;
            switch(r13) {
                case 1: goto L16;
                case 2: goto L19;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r11.d(NETWORK_METHOD.ADAPTER.decode(r10));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r11.addUnknownField(r13, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r11.a(ProtoAdapter.STRING.decode(r10));
            goto L3
        L8:
            r11.e(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L9:
            r11.b(ProtoAdapter.BYTES.decode(r10));
            goto L3
        L10:
            r11.f11992d.putAll((Map) this.f11997b.decode(r10));
            goto L3
        L11:
            r11.f11991c.putAll((Map) this.f11996a.decode(r10));
            goto L3
        L16:
            r11.f(ProtoAdapter.STRING.decode(r10));
            goto L3
        L6:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L17:
            r10.endMessage(r12);
            return r11.c();
        }

        public void b(ProtoWriter r10, GenericNetworkRequest r11) {
            ProtoAdapter<String> r12 = ProtoAdapter.STRING;
            r12.encodeWithTag(r10, 1, r11.path);
            NETWORK_METHOD.ADAPTER.encodeWithTag(r10, 2, r11.method);
            this.f11996a.encodeWithTag(r10, 3, r11.headerParams);
            this.f11997b.encodeWithTag(r10, 4, r11.queryParams);
            ProtoAdapter.BYTES.encodeWithTag(r10, 5, r11.body);
            ProtoAdapter.BOOL.encodeWithTag(r10, 6, r11.needAccessToken);
            r12.encodeWithTag(r10, 7, r11.accessToken);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(GenericNetworkRequest r10) {
            ProtoAdapter<String> r11 = ProtoAdapter.STRING;
            return ((((((r11.encodedSizeWithTag(1, r10.path) + NETWORK_METHOD.ADAPTER.encodedSizeWithTag(2, r10.method)) + this.f11996a.encodedSizeWithTag(3, r10.headerParams)) + this.f11997b.encodedSizeWithTag(4, r10.queryParams)) + ProtoAdapter.BYTES.encodedSizeWithTag(5, r10.body)) + ProtoAdapter.BOOL.encodedSizeWithTag(6, r10.needAccessToken)) + r11.encodedSizeWithTag(7, r10.accessToken)) + r10.unknownFields().size();
        }

        public GenericNetworkRequest d(GenericNetworkRequest r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.c();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) {
            b(r10, (GenericNetworkRequest) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((GenericNetworkRequest) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((GenericNetworkRequest) r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_METHOD = NETWORK_METHOD.METHOD_GET;
        DEFAULT_BODY = ByteString.EMPTY;
        DEFAULT_NEEDACCESSTOKEN = Boolean.FALSE;
    }

    public GenericNetworkRequest(String r10, NETWORK_METHOD r11, Map<String, String> r12, Map<String, String> r13, ByteString r14, Boolean r15, String r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof GenericNetworkRequest) == true) goto L8;
        return false;
    L8:
        GenericNetworkRequest r11 = (GenericNetworkRequest) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L26;
        if (this.path.equals(r11.path) == false) goto L26;
        if (this.method.equals(r11.method) == false) goto L26;
        if (this.headerParams.equals(r11.headerParams) == false) goto L26;
        if (this.queryParams.equals(r11.queryParams) == false) goto L26;
        if (Internal.equals(this.body, r11.body) == false) goto L26;
        if (Internal.equals(this.needAccessToken, r11.needAccessToken) == false) goto L26;
        if (Internal.equals(this.accessToken, r11.accessToken) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L17;
        int r11 = ((((((((unknownFields().hashCode() * 37) + this.path.hashCode()) * 37) + this.method.hashCode()) * 37) + this.headerParams.hashCode()) * 37) + this.queryParams.hashCode()) * 37;
        ByteString r12 = this.body;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        Boolean r16 = this.needAccessToken;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        String r19 = this.accessToken;
        if (r19 == null) goto L15;
        r13 = r19.hashCode();
    L15:
        int r20 = r18 + r13;
        this.hashCode = r20;
        return r20;
    L11:
        r17 = 0;
        goto L12
    L7:
        r14 = 0;
        goto L8
    L17:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(", path=");
        r10.append(this.path);
        r10.append(", method=");
        r10.append(this.method);
        Map<String, String> r11 = this.headerParams;
        if (r11 != null) goto L5;
    L7:
        Map<String, String> r12 = this.queryParams;
        if (r12 == null) goto L13;
        if (r12.isEmpty() == true) goto L13;
        r10.append(", queryParams=");
        r10.append(this.queryParams);
    L13:
        if (this.body == null) goto L16;
        r10.append(", body=");
        r10.append(this.body);
    L16:
        if (this.needAccessToken == null) goto L19;
        r10.append(", needAccessToken=");
        r10.append(this.needAccessToken);
    L19:
        if (this.accessToken == null) goto L21;
        r10.append(", accessToken=");
        r10.append(this.accessToken);
    L21:
        StringBuilder r13 = r10.replace(0, 2, "GenericNetworkRequest{");
        r13.append('}');
        return r13.toString();
    L5:
        if (r11.isEmpty() == true) goto L7;
        r10.append(", headerParams=");
        r10.append(this.headerParams);
        goto L7
    }

    public GenericNetworkRequest(String r10, NETWORK_METHOD r11, Map<String, String> r12, Map<String, String> r13, ByteString r14, Boolean r15, String r16, ByteString r17) {
        super(ADAPTER, r17);
        this.path = r10;
        this.method = r11;
        this.headerParams = Internal.immutableCopyOf("headerParams", r12);
        this.queryParams = Internal.immutableCopyOf("queryParams", r13);
        this.body = r14;
        this.needAccessToken = r15;
        this.accessToken = r16;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f11989a = this.path;
        r10.f11990b = this.method;
        r10.f11991c = Internal.copyOf("headerParams", this.headerParams);
        r10.f11992d = Internal.copyOf("queryParams", this.queryParams);
        r10.f11993e = this.body;
        r10.f11994f = this.needAccessToken;
        r10.f11995g = this.accessToken;
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
