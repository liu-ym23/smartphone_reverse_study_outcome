package com.obric.matrix.a;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MATRIX_CMD.java */
/* JADX INFO: loaded from: classes4.dex */
public final enum p extends Enum<p> implements WireEnum {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f33526a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f33527b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final p f33528c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p f33529d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final p f33530e = null;
    public static final p f = null;
    public static final p g = null;
    public static final p h = null;
    public static final p i = null;
    public static final p j = null;
    public static final p k = null;
    public static final p l = null;
    public static final p m = null;
    public static final p n = null;
    public static final p o = null;
    public static final p p = null;
    public static final p q = null;
    public static final p r = null;
    public static final ProtoAdapter<p> s = null;
    private static final /* synthetic */ p[] u = null;
    private final int t;

    public static p valueOf(String r2) {
        return (p) ZeusTransformUtils.preCheckCast(Enum.valueOf(p.class, r2), p.class, "com.obric.aiagent.plugin");
    }

    public static p[] values() {
        return (p[]) ZeusTransformUtils.preCheckCast(u.clone(), p[].class, "com.obric.aiagent.plugin");
    }

    static {
        p r0 = new p("CMD_NOT_USED", 0, 0);
        f33526a = r0;
        p r1 = new p("CMD_BIZ_EXAMPLE", 1, 100000);
        f33527b = r1;
        p r3 = new p("CMD_SEND_WS_MESSAGE", 2, 101001);
        f33528c = r3;
        p r5 = new p("CMD_SUBSCRIBE_WS_MSG", 3, 101002);
        f33529d = r5;
        p r7 = new p("CMD_SUBSCRIBE_WS_STATUS", 4, 101003);
        f33530e = r7;
        p r9 = new p("CMD_SUBSCRIBE_WS_MSG_PROVIDER", 5, 101004);
        f = r9;
        p r11 = new p("CMD_SUBSCRIBE_WS_MSG_BY_CALLBACK", 6, 101005);
        g = r11;
        p r13 = new p("CMD_SUBSCRIBE_WS_MSG_BY_BROADCAST", 7, 101006);
        h = r13;
        p r12 = new p("CMD_GET_LOCATION", 8, 102001);
        i = r12;
        p r10 = new p("CMD_REFRESH_LOCATION", 9, 102002);
        j = r10;
        p r8 = new p("CMD_DECODE_LOCATION", 10, 102003);
        k = r8;
        p r6 = new p("CMD_GET_INTERSECT_FENCES", 11, 102004);
        l = r6;
        p r4 = new p("CMD_PRIVATE_START_PICO_LINKS", 12, 111001);
        m = r4;
        p r2 = new p("CMD_PRIVATE_PICO_LINKS_CALLBACK", 13, 111002);
        n = r2;
        p r14 = new p("CMD_PRIVATE_COMMON_NET_REQUEST", 14, 112001);
        o = r14;
        p r15 = new p("CMD_PRIVATE_SEND_APPLOG_EVENT", 15, 112002);
        p = r15;
        p r16 = new p("CMD_SEND_NETWORK_REQUEST", 16, 112003);
        q = r16;
        p r17 = new p("CMD_GET_TTNET_PARAMETERS", 17, 112004);
        r = r17;
        u = new p[]{r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4, r2, r14, r15, r16, r17};
        s = new a();
    }

    private p(String r1, int r2, int r3) {
        super(r1, r2);
        this.t = r3;
    }

    public static p a(int r1) {
        if (r1 == 0) goto L46;
        if (r1 == 100000) goto L44;
        switch(r1) {
            case 101001: goto L42;
            case 101002: goto L40;
            case 101003: goto L38;
            case 101004: goto L36;
            case 101005: goto L34;
            case 101006: goto L32;
            default: goto L6;
        };
    L6:
        switch(r1) {
            case 102001: goto L30;
            case 102002: goto L28;
            case 102003: goto L26;
            case 102004: goto L24;
            default: goto L7;
        };
    L7:
        switch(r1) {
            case 111001: goto L22;
            case 111002: goto L20;
            default: goto L8;
        };
    L8:
        switch(r1) {
            case 112001: goto L18;
            case 112002: goto L16;
            case 112003: goto L14;
            case 112004: goto L12;
            default: goto L9;
        };
    L9:
        return null;
    L12:
        return r;
    L14:
        return q;
    L16:
        return p;
    L18:
        return o;
    L20:
        return n;
    L22:
        return m;
    L24:
        return l;
    L26:
        return k;
    L28:
        return j;
    L30:
        return i;
    L32:
        return h;
    L34:
        return g;
    L36:
        return f;
    L38:
        return f33530e;
    L40:
        return f33529d;
    L42:
        return f33528c;
    L44:
        return f33527b;
    L46:
        return f33526a;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.t;
    }
}
