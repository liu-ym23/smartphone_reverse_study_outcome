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

/* JADX INFO: compiled from: PicoLinksCallback.java */
/* JADX INFO: loaded from: classes4.dex */
public final class w extends Message<w, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<w> f33577a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Integer f33578b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("callbackId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer f33579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("callbackData")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, String> f33580d;

    /* JADX INFO: compiled from: PicoLinksCallback.java */
    public static final class a extends Message.Builder<w, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f33581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f33582b;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33581a = 0;
            this.f33582b = Internal.newMutableMap();
        }

        public a a(Integer r1) {
            this.f33581a = r1;
            return this;
        }

        public w a() {
            return new w(this.f33581a, this.f33582b, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: PicoLinksCallback.java */
    private static final class b extends ProtoAdapter<w> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f33583a;

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ w decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, w r4) {
            a(r3, (w) ZeusTransformUtils.preCheckCast(r4, w.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(w r3) {
            return a((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ w redact(w r3) {
            return b((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, w.class);
            this.f33583a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(w r4) {
            return (ProtoAdapter.INT32.encodedSizeWithTag(1, r4.f33579c) + this.f33583a.encodedSizeWithTag(2, r4.f33580d)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r4, w r5) {
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r5.f33579c);
            this.f33583a.encodeWithTag(r4, 2, r5.f33580d);
            r4.writeBytes(r5.unknownFields());
        }

        public w a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.a((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.aiagent.plugin"));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.f33582b.putAll((Map) ZeusTransformUtils.preCheckCast(this.f33583a.decode(r8), Map.class, "com.obric.aiagent.plugin"));
            goto L3
        L9:
            FieldEncoding r4 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r8));
            goto L3
        L12:
            r8.endMessage(r1);
            return r0.a();
        }

        public w b(w r1) {
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
        f33577a = new b();
        f33578b = 0;
    }

    public w(Integer r3, Map<String, String> r4, e.h r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        super(f33577a, r5);
        this.f33579c = r3;
        this.f33580d = Internal.immutableCopyOf("callbackData", r6);
    }

    public a a() {
        a r0 = new a();
        r0.f33581a = this.f33579c;
        r0.f33582b = Internal.copyOf("callbackData", this.f33580d);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, w.class) == true) goto L8;
        return false;
    L8:
        w r6 = (w) ZeusTransformUtils.preCheckCast(r5, w.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f33579c, r6.f33579c) == false) goto L16;
        if (this.f33580d.equals(r6.f33580d) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f33579c;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = ((r1 + r3) * 37) + this.f33580d.hashCode();
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
        if (this.f33579c == null) goto L5;
        r0.append(", callbackId=").append(this.f33579c);
    L5:
        Map<String, String> r1 = this.f33580d;
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.append(", callbackData=").append(this.f33580d);
    L11:
        return r0.replace(0, 2, "PicoLinksCallback{").append('}').toString();
    }
}
