package com.obric.matrix.a;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: StartPicoLinksResponse.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ak extends Message<ak, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<ak> f33334a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f33335b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("phase")
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksResponse$Phase#ADAPTER", tag = 1)
    public final b f33336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("phaseData")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, String> f33337d;

    /* JADX INFO: compiled from: StartPicoLinksResponse.java */
    public static final class a extends Message.Builder<ak, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f33338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f33339b;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33338a = b.f33340a;
            this.f33339b = Internal.newMutableMap();
        }

        public a a(b r1) {
            this.f33338a = r1;
            return this;
        }

        public ak a() {
            return new ak(this.f33338a, this.f33339b, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: StartPicoLinksResponse.java */
    public static final enum b extends Enum<b> implements WireEnum {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f33340a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f33341b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f33342c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final ProtoAdapter<b> f33343d = null;
        private static final /* synthetic */ b[] f = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f33344e;

        /* JADX INFO: compiled from: StartPicoLinksResponse.java */
        private static final class a extends EnumAdapter<b> {
            @Override // com.squareup.wire.EnumAdapter
            public /* synthetic */ WireEnum fromValue(int r1) {
                return a(r1);
            }

            a() {
                super(b.class);
            }

            public b a(int r1) {
                return b.a(r1);
            }
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        static {
            b r0 = new b("SYNC_INVOKE", 0, 0);
            f33340a = r0;
            b r1 = new b("ASYNC_CALLBACK", 1, 1);
            f33341b = r1;
            b r3 = new b("URL_REDIRECT", 2, 2);
            f33342c = r3;
            f = new b[]{r0, r1, r3};
            f33343d = new a();
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.f33344e = r3;
        }

        public static b a(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return f33342c;
        L12:
            return f33341b;
        L14:
            return f33340a;
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.f33344e;
        }
    }

    /* JADX INFO: compiled from: StartPicoLinksResponse.java */
    private static final class c extends ProtoAdapter<ak> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f33345a;

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ak decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, ak r4) {
            a(r3, (ak) ZeusTransformUtils.preCheckCast(r4, ak.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(ak r3) {
            return a((ak) ZeusTransformUtils.preCheckCast(r3, ak.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ak redact(ak r3) {
            return b((ak) ZeusTransformUtils.preCheckCast(r3, ak.class, "com.obric.aiagent.plugin"));
        }

        public c() {
            super(FieldEncoding.LENGTH_DELIMITED, ak.class);
            this.f33345a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(ak r4) {
            return (b.f33343d.encodedSizeWithTag(1, r4.f33336c) + this.f33345a.encodedSizeWithTag(2, r4.f33337d)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r4, ak r5) {
            b.f33343d.encodeWithTag(r4, 1, r5.f33336c);
            this.f33345a.encodeWithTag(r4, 2, r5.f33337d);
            r4.writeBytes(r5.unknownFields());
        }

        public ak a(ProtoReader r9) {
            a r0 = new a();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.a((b) ZeusTransformUtils.preCheckCast(b.f33343d.decode(r9), b.class, "com.obric.aiagent.plugin"));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.f33339b.putAll((Map) ZeusTransformUtils.preCheckCast(this.f33345a.decode(r9), Map.class, "com.obric.aiagent.plugin"));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.a();
        }

        public ak b(ak r1) {
            a r0 = r1.a();
            r0.clearUnknownFields();
            return r0.a();
        }
    }

    @Override // com.squareup.wire.Message
    public /* synthetic */ Message.Builder newBuilder() {
        return a();
    }

    static {
        f33334a = new c();
        f33335b = b.f33340a;
    }

    public ak(b r3, Map<String, String> r4, e.h r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        super(f33334a, r5);
        this.f33336c = r3;
        this.f33337d = Internal.immutableCopyOf("phaseData", r6);
    }

    public a a() {
        a r0 = new a();
        r0.f33338a = this.f33336c;
        r0.f33339b = Internal.copyOf("phaseData", this.f33337d);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ak.class) == true) goto L8;
        return false;
    L8:
        ak r6 = (ak) ZeusTransformUtils.preCheckCast(r5, ak.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f33336c, r6.f33336c) == false) goto L16;
        if (this.f33337d.equals(r6.f33337d) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        b r2 = this.f33336c;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = ((r1 + r3) * 37) + this.f33337d.hashCode();
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
        if (this.f33336c == null) goto L5;
        r0.append(", phase=").append(this.f33336c);
    L5:
        Map<String, String> r1 = this.f33337d;
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.append(", phaseData=").append(this.f33337d);
    L11:
        return r0.replace(0, 2, "StartPicoLinksResponse{").append('}').toString();
    }
}
