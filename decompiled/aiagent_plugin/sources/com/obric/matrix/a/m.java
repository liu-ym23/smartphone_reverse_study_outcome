package com.obric.matrix.a;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: GetTTNetParametersRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class m extends Message<m, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<m> f33512a = null;

    /* JADX INFO: compiled from: GetTTNetParametersRequest.java */
    public static final class a extends Message.Builder<m, a> {
        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
        }

        public m a() {
            return new m(super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: GetTTNetParametersRequest.java */
    private static final class b extends ProtoAdapter<m> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ m decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, m r4) {
            a(r3, (m) ZeusTransformUtils.preCheckCast(r4, m.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(m r3) {
            return a((m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ m redact(m r3) {
            return b((m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, m.class);
        }

        public int a(m r1) {
            return r1.unknownFields().k();
        }

        public void a(ProtoWriter r1, m r2) {
            r1.writeBytes(r2.unknownFields());
        }

        public m a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L6;
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L6:
            r6.endMessage(r0);
            return r5.a();
        }

        public m b(m r1) {
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
        f33512a = new b();
    }

    public m() {
        this(e.h.f38723b);
    }

    public m(e.h r2) {
        super(f33512a, r2);
    }

    public a a() {
        a r0 = new a();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, m.class);
    }

    public int hashCode() {
        return unknownFields().hashCode();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return new StringBuilder().replace(0, 2, "GetTTNetParametersRequest{").append('}').toString();
    }
}
