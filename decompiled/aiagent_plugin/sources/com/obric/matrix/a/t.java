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

/* JADX INFO: compiled from: NullableMap.java */
/* JADX INFO: loaded from: classes4.dex */
public final class t extends Message<t, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<t> f33549a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("_value")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final Map<String, String> f33550b;

    /* JADX INFO: compiled from: NullableMap.java */
    public static final class a extends Message.Builder<t, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, String> f33551a;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33551a = Internal.newMutableMap();
        }

        public t a() {
            return new t(this.f33551a, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: NullableMap.java */
    private static final class b extends ProtoAdapter<t> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f33552a;

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ t decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, t r4) {
            a(r3, (t) ZeusTransformUtils.preCheckCast(r4, t.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(t r3) {
            return a((t) ZeusTransformUtils.preCheckCast(r3, t.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ t redact(t r3) {
            return b((t) ZeusTransformUtils.preCheckCast(r3, t.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, t.class);
            this.f33552a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(t r3) {
            return this.f33552a.encodedSizeWithTag(1, r3.f33550b) + r3.unknownFields().k();
        }

        public void a(ProtoWriter r3, t r4) {
            this.f33552a.encodeWithTag(r3, 1, r4.f33550b);
            r3.writeBytes(r4.unknownFields());
        }

        public t a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.f33551a.putAll((Map) ZeusTransformUtils.preCheckCast(this.f33552a.decode(r8), Map.class, "com.obric.aiagent.plugin"));
            goto L3
        L7:
            FieldEncoding r4 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r8));
            goto L3
        L9:
            r8.endMessage(r1);
            return r0.a();
        }

        public t b(t r1) {
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
        f33549a = new b();
    }

    public t(Map<String, String> r3, e.h r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        super(f33549a, r4);
        this.f33550b = Internal.immutableCopyOf("_value", r5);
    }

    public a a() {
        a r0 = new a();
        r0.f33551a = Internal.copyOf("_value", this.f33550b);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, t.class) == true) goto L8;
        return false;
    L8:
        t r6 = (t) ZeusTransformUtils.preCheckCast(r5, t.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this.f33550b.equals(r6.f33550b) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.f33550b.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        Map<String, String> r1 = this.f33550b;
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        r0.append(", _value=").append(this.f33550b);
    L8:
        return r0.replace(0, 2, "NullableMap{").append('}').toString();
    }
}
