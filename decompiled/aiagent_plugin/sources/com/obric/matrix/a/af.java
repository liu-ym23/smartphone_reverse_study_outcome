package com.obric.matrix.a;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: SendApplogEventRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class af extends Message<af, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<af> f33307a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("appid")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String f33308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("eventMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, String> f33309c;

    /* JADX INFO: compiled from: SendApplogEventRequest.java */
    public static final class a extends Message.Builder<af, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f33310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f33311b;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33310a = "";
            this.f33311b = Internal.newMutableMap();
        }

        public a a(String r1) {
            this.f33310a = r1;
            return this;
        }

        public af a() {
            return new af(this.f33310a, this.f33311b, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: SendApplogEventRequest.java */
    private static final class b extends ProtoAdapter<af> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f33312a;

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ af decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, af r4) {
            a(r3, (af) ZeusTransformUtils.preCheckCast(r4, af.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(af r3) {
            return a((af) ZeusTransformUtils.preCheckCast(r3, af.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ af redact(af r3) {
            return b((af) ZeusTransformUtils.preCheckCast(r3, af.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, af.class);
            this.f33312a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(af r4) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r4.f33308b) + this.f33312a.encodedSizeWithTag(2, r4.f33309c)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r4, af r5) {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.f33308b);
            this.f33312a.encodeWithTag(r4, 2, r5.f33309c);
            r4.writeBytes(r5.unknownFields());
        }

        public af a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.f33311b.putAll((Map) ZeusTransformUtils.preCheckCast(this.f33312a.decode(r8), Map.class, "com.obric.aiagent.plugin"));
            goto L3
        L9:
            FieldEncoding r4 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r8));
            goto L3
        L12:
            r8.endMessage(r1);
            return r0.a();
        }

        public af b(af r1) {
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
        f33307a = new b();
    }

    public af(String r3, Map<String, String> r4, e.h r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        super(f33307a, r5);
        this.f33308b = r3;
        this.f33309c = Internal.immutableCopyOf("eventMap", r6);
    }

    public a a() {
        a r0 = new a();
        r0.f33310a = this.f33308b;
        r0.f33311b = Internal.copyOf("eventMap", this.f33309c);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, af.class) == true) goto L8;
        return false;
    L8:
        af r6 = (af) ZeusTransformUtils.preCheckCast(r5, af.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f33308b, r6.f33308b) == false) goto L16;
        if (this.f33309c.equals(r6.f33309c) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f33308b;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = ((r1 + r3) * 37) + this.f33309c.hashCode();
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
        if (this.f33308b == null) goto L5;
        r0.append(", appid=").append(this.f33308b);
    L5:
        Map<String, String> r1 = this.f33309c;
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.append(", eventMap=").append(this.f33309c);
    L11:
        return r0.replace(0, 2, "SendApplogEventRequest{").append('}').toString();
    }
}
