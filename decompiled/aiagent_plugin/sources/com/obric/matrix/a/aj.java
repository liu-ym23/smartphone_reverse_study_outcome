package com.obric.matrix.a;

import com.bytedance.apm.battery.dao.DBHelper;
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

/* JADX INFO: compiled from: StartPicoLinksRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class aj extends Message<aj, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<aj> f33321a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f33322b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName(DBHelper.BATTERY_COL_SCENE)
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksRequest$SCENE#ADAPTER", tag = 1)
    public final c f33323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("referrer")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String f33324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("targetUrl")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String f33325e;

    /* JADX INFO: compiled from: StartPicoLinksRequest.java */
    public static final class a extends Message.Builder<aj, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f33326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f33327b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f33328c;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33326a = c.f33329a;
            this.f33327b = "";
            this.f33328c = "";
        }

        public a a(c r1) {
            this.f33326a = r1;
            return this;
        }

        public a a(String r1) {
            this.f33327b = r1;
            return this;
        }

        public a b(String r1) {
            this.f33328c = r1;
            return this;
        }

        public aj a() {
            return new aj(this.f33326a, this.f33327b, this.f33328c, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: StartPicoLinksRequest.java */
    private static final class b extends ProtoAdapter<aj> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ aj decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, aj r4) {
            a(r3, (aj) ZeusTransformUtils.preCheckCast(r4, aj.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(aj r3) {
            return a((aj) ZeusTransformUtils.preCheckCast(r3, aj.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ aj redact(aj r3) {
            return b((aj) ZeusTransformUtils.preCheckCast(r3, aj.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, aj.class);
        }

        public int a(aj r4) {
            return ((c.f33333e.encodedSizeWithTag(1, r4.f33323c) + ProtoAdapter.STRING.encodedSizeWithTag(2, r4.f33324d)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r4.f33325e)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r3, aj r4) {
            c.f33333e.encodeWithTag(r3, 1, r4.f33323c);
            ProtoAdapter.STRING.encodeWithTag(r3, 2, r4.f33324d);
            ProtoAdapter.STRING.encodeWithTag(r3, 3, r4.f33325e);
            r3.writeBytes(r4.unknownFields());
        }

        public aj a(ProtoReader r8) {
            a r7 = new a();
            long r0 = r8.beginMessage();
        L3:
            int r2 = r8.nextTag();
            if (r2 == (-1)) goto L18;
            if (r2 != 1) goto L8;
            r7.a((c) ZeusTransformUtils.preCheckCast(c.f33333e.decode(r8), c.class, "com.obric.aiagent.plugin"));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r7.addUnknownField(r2, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r7.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L10:
            if (r2 != 3) goto L11;
            r7.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L11:
            FieldEncoding r3 = r8.peekFieldEncoding();
            r7.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r8));
            goto L3
        L18:
            r8.endMessage(r0);
            return r7.a();
        }

        public aj b(aj r1) {
            a r0 = r1.a();
            r0.clearUnknownFields();
            return r0.a();
        }
    }

    /* JADX INFO: compiled from: StartPicoLinksRequest.java */
    public static final enum c extends Enum<c> implements WireEnum {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f33329a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f33330b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f33331c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f33332d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final ProtoAdapter<c> f33333e = null;
        private static final /* synthetic */ c[] g = null;
        private final int f;

        /* JADX INFO: compiled from: StartPicoLinksRequest.java */
        private static final class a extends EnumAdapter<c> {
            @Override // com.squareup.wire.EnumAdapter
            public /* synthetic */ WireEnum fromValue(int r1) {
                return a(r1);
            }

            a() {
                super(c.class);
            }

            public c a(int r1) {
                return c.a(r1);
            }
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(g.clone(), c[].class, "com.obric.aiagent.plugin");
        }

        static {
            c r0 = new c("BROWSER", 0, 0);
            f33329a = r0;
            c r1 = new c("WEB_VIEW", 1, 1);
            f33330b = r1;
            c r3 = new c("NATIVE_APP", 2, 2);
            f33331c = r3;
            c r5 = new c("SYSTEM", 3, 3);
            f33332d = r5;
            g = new c[]{r0, r1, r3, r5};
            f33333e = new a();
        }

        private c(String r1, int r2, int r3) {
            super(r1, r2);
            this.f = r3;
        }

        public static c a(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return f33332d;
        L14:
            return f33331c;
        L16:
            return f33330b;
        L18:
            return f33329a;
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.f;
        }
    }

    @Override // com.squareup.wire.Message
    public /* synthetic */ Message.Builder newBuilder() {
        return a();
    }

    static {
        f33321a = new b();
        f33322b = c.f33329a;
    }

    public aj(c r2, String r3, String r4, e.h r5) {
        super(f33321a, r5);
        this.f33323c = r2;
        this.f33324d = r3;
        this.f33325e = r4;
    }

    public a a() {
        a r0 = new a();
        r0.f33326a = this.f33323c;
        r0.f33327b = this.f33324d;
        r0.f33328c = this.f33325e;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, aj.class) == true) goto L8;
        return false;
    L8:
        aj r6 = (aj) ZeusTransformUtils.preCheckCast(r5, aj.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L18;
        if (Internal.equals(this.f33323c, r6.f33323c) == false) goto L18;
        if (Internal.equals(this.f33324d, r6.f33324d) == false) goto L18;
        if (Internal.equals(this.f33325e, r6.f33325e) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        c r2 = this.f33323c;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f33324d;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f33325e;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = r8 + r3;
        this.hashCode = r10;
        return r10;
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L17:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f33323c == null) goto L6;
        r0.append(", scene=").append(this.f33323c);
    L6:
        if (this.f33324d == null) goto L9;
        r0.append(", referrer=").append(this.f33324d);
    L9:
        if (this.f33325e == null) goto L12;
        r0.append(", targetUrl=").append(this.f33325e);
    L12:
        return r0.replace(0, 2, "StartPicoLinksRequest{").append('}').toString();
    }
}
