package com.obric.matrix.a;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SendApplogEventResponse.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ag extends Message<ag, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<ag> f33313a = null;

    /* JADX INFO: compiled from: SendApplogEventResponse.java */
    public static final class a extends Message.Builder<ag, a> {
        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
        }

        public ag a() {
            return new ag(super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: SendApplogEventResponse.java */
    private static final class b extends ProtoAdapter<ag> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ag decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, ag r4) {
            a(r3, (ag) ZeusTransformUtils.preCheckCast(r4, ag.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(ag r3) {
            return a((ag) ZeusTransformUtils.preCheckCast(r3, ag.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ag redact(ag r3) {
            return b((ag) ZeusTransformUtils.preCheckCast(r3, ag.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, ag.class);
        }

        public int a(ag r1) {
            return r1.unknownFields().k();
        }

        public void a(ProtoWriter r1, ag r2) {
            r1.writeBytes(r2.unknownFields());
        }

        public ag a(ProtoReader r6) {
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

        public ag b(ag r1) {
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
        f33313a = new b();
    }

    public ag() {
        this(e.h.f38723b);
    }

    public ag(e.h r2) {
        super(f33313a, r2);
    }

    public a a() {
        a r0 = new a();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, ag.class);
    }

    public int hashCode() {
        return unknownFields().hashCode();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return new StringBuilder().replace(0, 2, "SendApplogEventResponse{").append('}').toString();
    }
}
