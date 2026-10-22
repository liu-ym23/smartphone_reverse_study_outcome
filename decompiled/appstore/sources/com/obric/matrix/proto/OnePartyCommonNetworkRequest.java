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
public final class OnePartyCommonNetworkRequest extends Message<OnePartyCommonNetworkRequest, a> {
    public static final ProtoAdapter<OnePartyCommonNetworkRequest> ADAPTER = null;
    public static final Boolean DEFAULT_ADDCOMMONPARAM = null;
    public static final ByteString DEFAULT_BODY = null;
    public static final String DEFAULT_HOST = "";
    public static final NETWORK_METHOD DEFAULT_METHOD = null;
    public static final String DEFAULT_PATH = "";
    private static final long serialVersionUID = 0;

    @SerializedName("addCommonParam")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean addCommonParam;

    @SerializedName(ServerElements.BODY)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 6)
    public final ByteString body;

    @SerializedName("extraMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final Map<String, String> extraMap;

    @SerializedName("fieldMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final Map<String, String> fieldMap;

    @SerializedName("headerParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> headerParams;

    @SerializedName("host")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String host;

    @SerializedName("method")
    @WireField(adapter = "com.obric.matrix.proto.NETWORK_METHOD#ADAPTER", label = WireField.Label.REQUIRED, tag = 3)
    public final NETWORK_METHOD method;

    @SerializedName("path")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String path;

    @SerializedName("queryParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final Map<String, String> queryParams;

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public NETWORK_METHOD f12040c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map f12041d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map f12042e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ByteString f12043f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Map f12044g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Boolean f12045h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Map f12046i;

        public a() {
            this.f12038a = "";
            this.f12039b = "";
            this.f12040c = NETWORK_METHOD.METHOD_GET;
            this.f12043f = ByteString.EMPTY;
            this.f12045h = Boolean.FALSE;
            this.f12041d = Internal.newMutableMap();
            this.f12042e = Internal.newMutableMap();
            this.f12044g = Internal.newMutableMap();
            this.f12046i = Internal.newMutableMap();
        }

        public a a(Boolean r10) {
            this.f12045h = r10;
            return this;
        }

        public a b(ByteString r10) {
            this.f12043f = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return c();
        }

        public OnePartyCommonNetworkRequest c() {
            NETWORK_METHOD r10 = this.f12040c;
            if (r10 == null) goto L7;
            return new OnePartyCommonNetworkRequest(this.f12038a, this.f12039b, this.f12040c, this.f12041d, this.f12042e, this.f12043f, this.f12044g, this.f12045h, this.f12046i, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r10, "method"});
        }

        public a d(String r10) {
            this.f12039b = r10;
            return this;
        }

        public a e(NETWORK_METHOD r10) {
            this.f12040c = r10;
            return this;
        }

        public a f(String r10) {
            this.f12038a = r10;
            return this;
        }
    }

    public static final class b extends ProtoAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ProtoAdapter f12047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ProtoAdapter f12048b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ProtoAdapter f12049c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ProtoAdapter f12050d;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, OnePartyCommonNetworkRequest.class);
            ProtoAdapter<String> r10 = ProtoAdapter.STRING;
            this.f12047a = ProtoAdapter.newMapAdapter(r10, r10);
            this.f12048b = ProtoAdapter.newMapAdapter(r10, r10);
            this.f12049c = ProtoAdapter.newMapAdapter(r10, r10);
            this.f12050d = ProtoAdapter.newMapAdapter(r10, r10);
        }

        public OnePartyCommonNetworkRequest a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L19;
            switch(r13) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L21;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L21:
            r11.e(NETWORK_METHOD.ADAPTER.decode(r10));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r11.addUnknownField(r13, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r11.f12046i.putAll((Map) this.f12050d.decode(r10));
            goto L3
        L8:
            r11.a(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L9:
            r11.f12044g.putAll((Map) this.f12049c.decode(r10));
            goto L3
        L10:
            r11.b(ProtoAdapter.BYTES.decode(r10));
            goto L3
        L11:
            r11.f12042e.putAll((Map) this.f12048b.decode(r10));
            goto L3
        L12:
            r11.f12041d.putAll((Map) this.f12047a.decode(r10));
            goto L3
        L17:
            r11.d(ProtoAdapter.STRING.decode(r10));
            goto L3
        L18:
            r11.f(ProtoAdapter.STRING.decode(r10));
            goto L3
        L6:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L19:
            r10.endMessage(r12);
            return r11.c();
        }

        public void b(ProtoWriter r10, OnePartyCommonNetworkRequest r11) {
            ProtoAdapter<String> r12 = ProtoAdapter.STRING;
            r12.encodeWithTag(r10, 1, r11.path);
            r12.encodeWithTag(r10, 2, r11.host);
            NETWORK_METHOD.ADAPTER.encodeWithTag(r10, 3, r11.method);
            this.f12047a.encodeWithTag(r10, 4, r11.headerParams);
            this.f12048b.encodeWithTag(r10, 5, r11.queryParams);
            ProtoAdapter.BYTES.encodeWithTag(r10, 6, r11.body);
            this.f12049c.encodeWithTag(r10, 7, r11.fieldMap);
            ProtoAdapter.BOOL.encodeWithTag(r10, 8, r11.addCommonParam);
            this.f12050d.encodeWithTag(r10, 9, r11.extraMap);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(OnePartyCommonNetworkRequest r10) {
            ProtoAdapter<String> r11 = ProtoAdapter.STRING;
            return ((((((((r11.encodedSizeWithTag(1, r10.path) + r11.encodedSizeWithTag(2, r10.host)) + NETWORK_METHOD.ADAPTER.encodedSizeWithTag(3, r10.method)) + this.f12047a.encodedSizeWithTag(4, r10.headerParams)) + this.f12048b.encodedSizeWithTag(5, r10.queryParams)) + ProtoAdapter.BYTES.encodedSizeWithTag(6, r10.body)) + this.f12049c.encodedSizeWithTag(7, r10.fieldMap)) + ProtoAdapter.BOOL.encodedSizeWithTag(8, r10.addCommonParam)) + this.f12050d.encodedSizeWithTag(9, r10.extraMap)) + r10.unknownFields().size();
        }

        public OnePartyCommonNetworkRequest d(OnePartyCommonNetworkRequest r10) {
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
            b(r10, (OnePartyCommonNetworkRequest) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((OnePartyCommonNetworkRequest) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((OnePartyCommonNetworkRequest) r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_METHOD = NETWORK_METHOD.METHOD_GET;
        DEFAULT_BODY = ByteString.EMPTY;
        DEFAULT_ADDCOMMONPARAM = Boolean.FALSE;
    }

    public OnePartyCommonNetworkRequest(String r12, String r13, NETWORK_METHOD r14, Map<String, String> r15, Map<String, String> r16, ByteString r17, Map<String, String> r18, Boolean r19, Map<String, String> r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof OnePartyCommonNetworkRequest) == true) goto L8;
        return false;
    L8:
        OnePartyCommonNetworkRequest r11 = (OnePartyCommonNetworkRequest) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L30;
        if (Internal.equals(this.path, r11.path) == false) goto L30;
        if (Internal.equals(this.host, r11.host) == false) goto L30;
        if (this.method.equals(r11.method) == false) goto L30;
        if (this.headerParams.equals(r11.headerParams) == false) goto L30;
        if (this.queryParams.equals(r11.queryParams) == false) goto L30;
        if (Internal.equals(this.body, r11.body) == false) goto L30;
        if (this.fieldMap.equals(r11.fieldMap) == false) goto L30;
        if (Internal.equals(this.addCommonParam, r11.addCommonParam) == false) goto L30;
        if (this.extraMap.equals(r11.extraMap) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L21;
        int r11 = unknownFields().hashCode() * 37;
        String r12 = this.path;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        String r16 = this.host;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (((((((r15 + r17) * 37) + this.method.hashCode()) * 37) + this.headerParams.hashCode()) * 37) + this.queryParams.hashCode()) * 37;
        ByteString r19 = this.body;
        if (r19 == null) goto L15;
        int r20 = r19.hashCode();
    L16:
        int r21 = (((r18 + r20) * 37) + this.fieldMap.hashCode()) * 37;
        Boolean r22 = this.addCommonParam;
        if (r22 == null) goto L19;
        r13 = r22.hashCode();
    L19:
        int r23 = ((r21 + r13) * 37) + this.extraMap.hashCode();
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
        if (this.path == null) goto L6;
        r10.append(", path=");
        r10.append(this.path);
    L6:
        if (this.host == null) goto L8;
        r10.append(", host=");
        r10.append(this.host);
    L8:
        r10.append(", method=");
        r10.append(this.method);
        Map<String, String> r11 = this.headerParams;
        if (r11 != null) goto L11;
    L13:
        Map<String, String> r12 = this.queryParams;
        if (r12 == null) goto L19;
        if (r12.isEmpty() == true) goto L19;
        r10.append(", queryParams=");
        r10.append(this.queryParams);
    L19:
        if (this.body == null) goto L21;
        r10.append(", body=");
        r10.append(this.body);
    L21:
        Map<String, String> r13 = this.fieldMap;
        if (r13 == null) goto L27;
        if (r13.isEmpty() == true) goto L27;
        r10.append(", fieldMap=");
        r10.append(this.fieldMap);
    L27:
        if (this.addCommonParam == null) goto L29;
        r10.append(", addCommonParam=");
        r10.append(this.addCommonParam);
    L29:
        Map<String, String> r14 = this.extraMap;
        if (r14 != null) goto L32;
    L34:
        StringBuilder r15 = r10.replace(0, 2, "OnePartyCommonNetworkRequest{");
        r15.append('}');
        return r15.toString();
    L32:
        if (r14.isEmpty() == true) goto L34;
        r10.append(", extraMap=");
        r10.append(this.extraMap);
        goto L34
    L11:
        if (r11.isEmpty() == true) goto L13;
        r10.append(", headerParams=");
        r10.append(this.headerParams);
        goto L13
    }

    public OnePartyCommonNetworkRequest(String r10, String r11, NETWORK_METHOD r12, Map<String, String> r13, Map<String, String> r14, ByteString r15, Map<String, String> r16, Boolean r17, Map<String, String> r18, ByteString r19) {
        super(ADAPTER, r19);
        this.path = r10;
        this.host = r11;
        this.method = r12;
        this.headerParams = Internal.immutableCopyOf("headerParams", r13);
        this.queryParams = Internal.immutableCopyOf("queryParams", r14);
        this.body = r15;
        this.fieldMap = Internal.immutableCopyOf("fieldMap", r16);
        this.addCommonParam = r17;
        this.extraMap = Internal.immutableCopyOf("extraMap", r18);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f12038a = this.path;
        r10.f12039b = this.host;
        r10.f12040c = this.method;
        r10.f12041d = Internal.copyOf("headerParams", this.headerParams);
        r10.f12042e = Internal.copyOf("queryParams", this.queryParams);
        r10.f12043f = this.body;
        r10.f12044g = Internal.copyOf("fieldMap", this.fieldMap);
        r10.f12045h = this.addCommonParam;
        r10.f12046i = Internal.copyOf("extraMap", this.extraMap);
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
