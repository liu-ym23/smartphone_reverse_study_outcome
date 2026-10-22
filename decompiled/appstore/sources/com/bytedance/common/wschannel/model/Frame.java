package com.bytedance.common.wschannel.model;

import com.bytedance.apm.constant.CommonKey;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
public final class Frame extends Message<Frame, a> {
    public static final ProtoAdapter<Frame> ADAPTER = null;
    public static final Long DEFAULT_LOGID = null;
    public static final Integer DEFAULT_METHOD = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final String DEFAULT_PAYLOAD_ENCODING = "";
    public static final String DEFAULT_PAYLOAD_TYPE = "";
    public static final Long DEFAULT_SEQID = null;
    public static final Integer DEFAULT_SERVICE = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.bytedance.article.wschannel.model.Frame$ExtendedEntry#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<ExtendedEntry> headers;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", label = WireField.Label.REQUIRED, tag = 2)
    public final Long logid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 4)
    public final Integer method;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 8)
    public final ByteString payload;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String payload_encoding;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String payload_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", label = WireField.Label.REQUIRED, tag = 1)
    public final Long seqid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 3)
    public final Integer service;

    public static final class ExtendedEntry extends Message<ExtendedEntry, a> {
        public static final ProtoAdapter<ExtendedEntry> ADAPTER = null;
        public static final String DEFAULT_KEY = "";
        public static final String DEFAULT_VALUE = "";
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
        public final String key;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
        public final String value;

        public static final class a extends Message.Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f7041a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f7042b;

            public a() {
            }

            public ExtendedEntry a() {
                String r10 = this.f7041a;
                if (r10 == null) goto L9;
                if (this.f7042b == null) goto L9;
                return new ExtendedEntry(this.f7041a, this.f7042b, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r10, "key", this.f7042b, CommonKey.KEY_VALUE});
            }

            public a b(String r10) {
                this.f7041a = r10;
                return this;
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return a();
            }

            public a c(String r10) {
                this.f7042b = r10;
                return this;
            }
        }

        public static final class b extends ProtoAdapter {
            public b() {
                super(FieldEncoding.LENGTH_DELIMITED, ExtendedEntry.class);
            }

            public ExtendedEntry a(ProtoReader r10) {
                a r11 = new a();
                long r12 = r10.beginMessage();
            L3:
                int r13 = r10.nextTag();
                if (r13 == (-1)) goto L12;
                if (r13 == 1) goto L7;
                if (r13 == 2) goto L10;
                FieldEncoding r14 = r10.peekFieldEncoding();
                r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
                goto L3
            L10:
                r11.c(ProtoAdapter.STRING.decode(r10));
                goto L3
            L7:
                r11.b(ProtoAdapter.STRING.decode(r10));
                goto L3
            L12:
                r10.endMessage(r12);
                return r11.a();
            }

            public void b(ProtoWriter r10, ExtendedEntry r11) {
                ProtoAdapter<String> r12 = ProtoAdapter.STRING;
                r12.encodeWithTag(r10, 1, r11.key);
                r12.encodeWithTag(r10, 2, r11.value);
                r10.writeBytes(r11.unknownFields());
            }

            public int c(ExtendedEntry r10) {
                ProtoAdapter<String> r11 = ProtoAdapter.STRING;
                return (r11.encodedSizeWithTag(1, r10.key) + r11.encodedSizeWithTag(2, r10.value)) + r10.unknownFields().size();
            }

            public ExtendedEntry d(ExtendedEntry r10) {
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
                b(r10, (ExtendedEntry) r11);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
                return c((ExtendedEntry) r10);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Object redact(Object r10) {
                return d((ExtendedEntry) r10);
            }
        }

        static {
            ADAPTER = new b();
        }

        public ExtendedEntry(String r10, String r11) {
            this(r10, r11, ByteString.EMPTY);
        }

        public boolean equals(Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof ExtendedEntry) == true) goto L8;
            return false;
        L8:
            ExtendedEntry r11 = (ExtendedEntry) r10;
            if (unknownFields().equals(r11.unknownFields()) == false) goto L16;
            if (this.key.equals(r11.key) == false) goto L16;
            if (this.value.equals(r11.value) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            int r10 = this.hashCode;
            if (r10 != 0) goto L6;
            int r11 = (((unknownFields().hashCode() * 37) + this.key.hashCode()) * 37) + this.value.hashCode();
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
            r10.append(", key=");
            r10.append(this.key);
            r10.append(", value=");
            r10.append(this.value);
            StringBuilder r11 = r10.replace(0, 2, "ExtendedEntry{");
            r11.append('}');
            return r11.toString();
        }

        public ExtendedEntry(String r10, String r11, ByteString r12) {
            super(ADAPTER, r12);
            this.key = r10;
            this.value = r11;
        }

        @Override // com.squareup.wire.Message
        public a newBuilder() {
            a r10 = new a();
            r10.f7041a = this.key;
            r10.f7042b = this.value;
            r10.addUnknownFields(unknownFields());
            return r10;
        }
    }

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f7043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f7044b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f7045c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f7046d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List f7047e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f7048f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f7049g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ByteString f7050h;

        public a() {
            this.f7047e = Internal.newMutableList();
        }

        public Frame a() {
            Long r10 = this.f7043a;
            if (r10 == null) goto L13;
            if (this.f7044b == null) goto L13;
            if (this.f7045c == null) goto L13;
            if (this.f7046d == null) goto L13;
            return new Frame(this.f7043a, this.f7044b, this.f7045c, this.f7046d, this.f7047e, this.f7048f, this.f7049g, this.f7050h, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r10, "seqid", this.f7044b, "logid", this.f7045c, "service", this.f7046d, "method"});
        }

        public a b(List r10) {
            Internal.checkElementsNotNull(r10);
            this.f7047e = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Long r10) {
            this.f7044b = r10;
            return this;
        }

        public a d(Integer r10) {
            this.f7046d = r10;
            return this;
        }

        public a e(ByteString r10) {
            this.f7050h = r10;
            return this;
        }

        public a f(String r10) {
            this.f7048f = r10;
            return this;
        }

        public a g(String r10) {
            this.f7049g = r10;
            return this;
        }

        public a h(Long r10) {
            this.f7043a = r10;
            return this;
        }

        public a i(Integer r10) {
            this.f7045c = r10;
            return this;
        }
    }

    public static final class b extends ProtoAdapter {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, Frame.class);
        }

        public Frame a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L30;
            if (r13 == 1) goto L7;
            if (r13 == 2) goto L10;
            if (r13 == 3) goto L13;
            if (r13 == 4) goto L16;
            if (r13 == 5) goto L19;
            if (r13 == 6) goto L22;
            if (r13 == 7) goto L25;
            if (r13 == 8) goto L28;
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L28:
            r11.e(ProtoAdapter.BYTES.decode(r10));
            goto L3
        L25:
            r11.g(ProtoAdapter.STRING.decode(r10));
            goto L3
        L22:
            r11.f(ProtoAdapter.STRING.decode(r10));
            goto L3
        L19:
            r11.f7047e.add(ExtendedEntry.ADAPTER.decode(r10));
            goto L3
        L16:
            r11.d(ProtoAdapter.INT32.decode(r10));
            goto L3
        L13:
            r11.i(ProtoAdapter.INT32.decode(r10));
            goto L3
        L10:
            r11.c(ProtoAdapter.UINT64.decode(r10));
            goto L3
        L7:
            r11.h(ProtoAdapter.UINT64.decode(r10));
            goto L3
        L30:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, Frame r11) {
            ProtoAdapter<Long> r12 = ProtoAdapter.UINT64;
            r12.encodeWithTag(r10, 1, r11.seqid);
            r12.encodeWithTag(r10, 2, r11.logid);
            ProtoAdapter<Integer> r13 = ProtoAdapter.INT32;
            r13.encodeWithTag(r10, 3, r11.service);
            r13.encodeWithTag(r10, 4, r11.method);
            ExtendedEntry.ADAPTER.asRepeated().encodeWithTag(r10, 5, r11.headers);
            ProtoAdapter<String> r14 = ProtoAdapter.STRING;
            r14.encodeWithTag(r10, 6, r11.payload_encoding);
            r14.encodeWithTag(r10, 7, r11.payload_type);
            ProtoAdapter.BYTES.encodeWithTag(r10, 8, r11.payload);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(Frame r10) {
            ProtoAdapter<Long> r11 = ProtoAdapter.UINT64;
            int r12 = r11.encodedSizeWithTag(1, r10.seqid) + r11.encodedSizeWithTag(2, r10.logid);
            ProtoAdapter<Integer> r13 = ProtoAdapter.INT32;
            int r14 = ((r12 + r13.encodedSizeWithTag(3, r10.service)) + r13.encodedSizeWithTag(4, r10.method)) + ExtendedEntry.ADAPTER.asRepeated().encodedSizeWithTag(5, r10.headers);
            ProtoAdapter<String> r15 = ProtoAdapter.STRING;
            return (((r14 + r15.encodedSizeWithTag(6, r10.payload_encoding)) + r15.encodedSizeWithTag(7, r10.payload_type)) + ProtoAdapter.BYTES.encodedSizeWithTag(8, r10.payload)) + r10.unknownFields().size();
        }

        public Frame d(Frame r10) {
            a r11 = r10.newBuilder();
            Internal.redactElements(r11.f7047e, ExtendedEntry.ADAPTER);
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) {
            b(r10, (Frame) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((Frame) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((Frame) r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_SEQID = 0L;
        DEFAULT_LOGID = 0L;
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = 0;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
    }

    public Frame(Long r11, Long r12, Integer r13, Integer r14, List<ExtendedEntry> r15, String r16, String r17, ByteString r18) {
        this(r11, r12, r13, r14, r15, r16, r17, r18, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Frame) == true) goto L8;
        return false;
    L8:
        Frame r11 = (Frame) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L28;
        if (this.seqid.equals(r11.seqid) == false) goto L28;
        if (this.logid.equals(r11.logid) == false) goto L28;
        if (this.service.equals(r11.service) == false) goto L28;
        if (this.method.equals(r11.method) == false) goto L28;
        if (this.headers.equals(r11.headers) == false) goto L28;
        if (Internal.equals(this.payload_encoding, r11.payload_encoding) == false) goto L28;
        if (Internal.equals(this.payload_type, r11.payload_type) == false) goto L28;
        if (Internal.equals(this.payload, r11.payload) == false) goto L28;
        return true;
    L28:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L17;
        int r11 = ((((((((((unknownFields().hashCode() * 37) + this.seqid.hashCode()) * 37) + this.logid.hashCode()) * 37) + this.service.hashCode()) * 37) + this.method.hashCode()) * 37) + this.headers.hashCode()) * 37;
        String r12 = this.payload_encoding;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        String r16 = this.payload_type;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        ByteString r19 = this.payload;
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
        r10.append(", seqid=");
        r10.append(this.seqid);
        r10.append(", logid=");
        r10.append(this.logid);
        r10.append(", service=");
        r10.append(this.service);
        r10.append(", method=");
        r10.append(this.method);
        if (this.headers.isEmpty() == true) goto L6;
        r10.append(", headers=");
        r10.append(this.headers);
    L6:
        if (this.payload_encoding == null) goto L9;
        r10.append(", payload_encoding=");
        r10.append(this.payload_encoding);
    L9:
        if (this.payload_type == null) goto L12;
        r10.append(", payload_type=");
        r10.append(this.payload_type);
    L12:
        if (this.payload == null) goto L14;
        r10.append(", payload=");
        r10.append(this.payload);
    L14:
        StringBuilder r11 = r10.replace(0, 2, "Frame{");
        r11.append('}');
        return r11.toString();
    }

    public Frame(Long r10, Long r11, Integer r12, Integer r13, List<ExtendedEntry> r14, String r15, String r16, ByteString r17, ByteString r18) {
        super(ADAPTER, r18);
        this.seqid = r10;
        this.logid = r11;
        this.service = r12;
        this.method = r13;
        this.headers = Internal.immutableCopyOf("headers", r14);
        this.payload_encoding = r15;
        this.payload_type = r16;
        this.payload = r17;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f7043a = this.seqid;
        r10.f7044b = this.logid;
        r10.f7045c = this.service;
        r10.f7046d = this.method;
        r10.f7047e = Internal.copyOf("headers", this.headers);
        r10.f7048f = this.payload_encoding;
        r10.f7049g = this.payload_type;
        r10.f7050h = this.payload;
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
