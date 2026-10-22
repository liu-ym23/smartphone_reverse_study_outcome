package com.bytedance.safetyguard.lxc.internal.d;

import com.bytedance.safetyguard.lxc.api.SidecarAuthRequest;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: HttpRequestParser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10239a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte[] f10240e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ByteArrayOutputStream f10243d;

    /* JADX INFO: compiled from: HttpRequestParser.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    public k() {
        int r0 = 0;
        this(r0, r0, 3, null);
    }

    public k(int r1, int r2) {
        this.f10241b = r1;
        this.f10242c = r2;
        this.f10243d = new ByteArrayOutputStream();
    }

    public /* synthetic */ k(int r1, int r2, int r3, d.h.b.h r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 16384;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 1048576;
    L8:
        this(r1, r2);
    }

    public final SidecarAuthRequest a(byte[] r25) {
        d.h.b.o.e(r25, "payload");
        this.f10243d.write(r25);
        byte[] r1 = this.f10243d.toByteArray();
        d.h.b.o.a(r1);
        int r2 = a(r1, f10240e);
        if (r2 >= 0) goto L10;
        if (r1.length > this.f10241b) goto L8;
        return null;
    L8:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("HTTP headers exceed limit", null, 2, null);
    L10:
        if (r2 > this.f10241b) goto L69;
        Charset r3 = StandardCharsets.ISO_8859_1;
        d.h.b.o.c(r3, "ISO_8859_1");
        int r7 = 0;
        List r4 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(new String(r1, 0, r2, r3), CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"\r\n"}, false, 0, 6, null);
        if (r4.isEmpty() == true) goto L67;
        List r6 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r4.get(0), CharSequence.class, "com.obric.aiagent.plugin"), new String[]{" "}, false, 3, 2, null);
        if (r6.size() < 3) goto L65;
        LinkedHashMap r9 = new LinkedHashMap();
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin"), 1), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L17:
        if (r5.hasNext() == false) goto L22;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");
        int r14 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), ':', 0, false, 6, null);
        if (r14 <= 0) goto L21;
        Map r15 = (Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.aiagent.plugin");
        String r8 = r11.substring(r7, r14);
        d.h.b.o.c(r8, "substring(...)");
        String r10 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        Locale r12 = Locale.US;
        d.h.b.o.c(r12, "US");
        String r13 = r10.toLowerCase(r12);
        d.h.b.o.c(r13, "toLowerCase(...)");
        String r16 = r11.substring(r14 + 1);
        d.h.b.o.c(r16, "substring(...)");
        r15.put(r13, d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin")).toString());
    L21:
        r7 = 0;
        goto L17
    L22:
        String r17 = (String) ZeusTransformUtils.preCheckCast(r9.get("transfer-encoding"), String.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L43;
        Locale r18 = Locale.US;
        d.h.b.o.c(r18, "US");
        String r19 = r17.toLowerCase(r18);
        d.h.b.o.c(r19, "toLowerCase(...)");
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{','}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin");
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r20, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r22 = r20.iterator();
    L26:
        if (r22.hasNext() == false) goto L28;
        r21.add(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r22.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString());
        goto L26
    L28:
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r23, Collection.class) == true) goto L31;
    L33:
        Iterator r24 = r23.iterator();
    L35:
        if (r24.hasNext() == false) goto L32;
        if (d.h.b.o.a((String) ZeusTransformUtils.preCheckCast(r24.next(), String.class, "com.obric.aiagent.plugin"), DownloadHelper.VALUE_CHUNKED) == false) goto L35;
        boolean r26 = true;
    L39:
        if (r26 == false) goto L43;
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Chunked request body is not supported", null, 2, null);
    L32:
        r26 = false;
        goto L39
    L31:
        if (((Collection) ZeusTransformUtils.preCheckCast(r23, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L33;
    L43:
        String r27 = (String) ZeusTransformUtils.preCheckCast(r9.get("content-length"), String.class, "com.obric.aiagent.plugin");
        if (r27 != null) goto L46;
        int r28 = 0;
    L49:
        if (r28 < 0) goto L61;
        if (r28 > this.f10242c) goto L59;
        int r29 = r2 + f10240e.length;
        int r30 = r28 + r29;
        if (r1.length >= r30) goto L57;
        return null;
    L57:
        return new SidecarAuthRequest((String) ZeusTransformUtils.preCheckCast(r6.get(0), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r6.get(1), String.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.aiagent.plugin"), d.a.i.a(r1, r29, r30));
    L59:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("HTTP body exceeds limit", null, 2, null);
    L61:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Invalid Content-Length", null, 2, null);
    L46:
        Integer r31 = d.o.o.d(r27);
        if (r31 == null) goto L63;
        r28 = r31.intValue();
        goto L49
    L63:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Invalid Content-Length", null, 2, null);
    L65:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Malformed HTTP request line", null, 2, null);
    L67:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Missing HTTP request line", null, 2, null);
    L69:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("HTTP headers exceed limit", null, 2, null);
    }

    private final int a(byte[] r9, byte[] r10) {
        if (r10.length != 0) goto L5;
        boolean r8 = true;
    L7:
        if (r8 == false) goto L9;
    L25:
        return -1;
    L9:
        if (r9.length < r10.length) goto L25;
        int r11 = r9.length - r10.length;
        if (r11 < 0) goto L25;
        int r3 = 0;
    L14:
        int r4 = r10.length;
        int r5 = 0;
    L15:
        if (r5 >= r4) goto L20;
        if (r9[r3 + r5] != r10[r5]) goto L18;
        r5 = r5 + 1;
        goto L15
    L18:
        boolean r6 = false;
    L21:
        if (r6 == true) goto L22;
        if (r3 == r11) goto L25;
        r3 = r3 + 1;
        goto L14
    L22:
        return r3;
    L20:
        r6 = true;
        goto L21
    L5:
        r8 = false;
        goto L7
    }

    static {
        f10239a = new a(null);
        f10240e = new byte[]{13, 10, 13, 10};
    }
}
