package com.obric.aiagent.ttnet;

import com.bytedance.retrofit2.ak;
import com.bytedance.retrofit2.c.ae;
import com.bytedance.retrofit2.c.ag;
import com.bytedance.retrofit2.c.o;
import com.bytedance.retrofit2.c.u;
import com.bytedance.retrofit2.q;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.f.t;
import d.n;
import d.x;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: TTNetFileTransferImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TTNetFileTransferImpl implements ITTNetFileTransfer {
    private static final a Companion = null;
    private static final String HEADER_CONTENT_LENGTH = "Content-Length";
    private static final String HEADER_LOCATION = "Location";
    private static final Set<Integer> HTTP_REDIRECT_CODES = null;
    private static final d.l.j HTTP_SUCCESS_RANGE = null;
    private static final int MAX_REDIRECTS_LIMIT = 10;
    private static final String OPERATION_DOWNLOAD = "download";
    private static final String OPERATION_UPLOAD = "upload";
    private static final int RESPONSE_DRAIN_BUFFER_SIZE = 4096;
    private static final String TAG = "TTNetFileTransfer";
    private static final int UNLIMITED_RESPONSE_LENGTH = -1;

    /* JADX INFO: compiled from: TTNetFileTransferImpl.kt */
    private interface TTNetFileTransferApi {
        @ae
        @com.bytedance.retrofit2.c.h
        com.bytedance.retrofit2.e<com.bytedance.retrofit2.e.i> download(@com.bytedance.retrofit2.c.a boolean r1, @o int r2, @ag String r3, @com.bytedance.retrofit2.c.l List<com.bytedance.retrofit2.b.b> r4, @com.bytedance.retrofit2.c.d Object r5);

        @u
        @ae
        com.bytedance.retrofit2.e<com.bytedance.retrofit2.e.i> put(@com.bytedance.retrofit2.c.a boolean r1, @o int r2, @ag String r3, @com.bytedance.retrofit2.c.b com.bytedance.retrofit2.e.h r4, @com.bytedance.retrofit2.c.l List<com.bytedance.retrofit2.b.b> r5, @com.bytedance.retrofit2.c.d Object r6);
    }

    /* JADX INFO: compiled from: TTNetFileTransferImpl.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: TTNetFileTransferImpl.kt */
    private static final class b extends IOException {
        public b() {
            super("Response exceeded byte limit");
        }
    }

    /* JADX INFO: compiled from: TTNetFileTransferImpl.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22194a = null;

        static {
            int[] r0 = new int[m.values().length];
            r0[m.f22287a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[m.f22288b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f22194a = r0;
        }
    }

    public TTNetFileTransferImpl() {
    }

    @Override // com.obric.aiagent.ttnet.ITTNetFileTransfer
    public l downloadToFile(i r2) {
        d.h.b.o.e(r2, Ext.KEY_REQUEST);
        l.a r0 = validateDownloadRequest(r2);
        if (r0 == null) goto L7;
        return (l) ZeusTransformUtils.preCheckCast(r0, l.class, "com.obric.aiagent.plugin");
    L7:
        return downloadFollowingPolicy(r2, null);
    }

    private final l downloadFollowingPolicy(i r23, String r24) {
        String r0 = r23.a();
        boolean r13 = false;
        int r14 = 0;
    L4:
        if (isAllowedBy(r0, r23.g()) == false) goto L5;
        if (r23.g() != m.f22288b) goto L10;
        boolean r17 = true;
    L115:
        com.bytedance.retrofit2.e<com.bytedance.retrofit2.e.i> r7 = createApi(r0).download(false, retrofitMaxLength(r23), r0, toRetrofitHeaders(r23.c()), requestContext(r23.d(), r23.e(), r23.e(), r17, r23.i()));     // Catch: Exception -> L104
        ak<com.bytedance.retrofit2.e.i> r1 = r7.a();     // Catch: Throwable -> L96 Exception -> L98
        int r8 = r1.c();     // Catch: Throwable -> L96 Exception -> L98
        d.h.b.o.a(r1);     // Catch: Throwable -> L96 Exception -> L98
        String r9 = ttLogId(r1);     // Catch: Throwable -> L96 Exception -> L98
        String r2 = null;
        if (r24 == null) goto L17;
        String r3 = r1.b().c().toString();     // Catch: Throwable -> L96 Exception -> L98
        if (r23.j() == true) goto L17;
        String r4 = r3;
    L18:
        if (r17 == false) goto L41;
        if (HTTP_REDIRECT_CODES.contains(Integer.valueOf(r8)) == false) goto L41;
        closeStream(responseBody(r1));     // Catch: Throwable -> L96 Exception -> L98
        if (r14 >= r23.h()) goto L23;
        com.bytedance.retrofit2.b.b r5 = r1.b().a(HEADER_LOCATION);     // Catch: Throwable -> L96 Exception -> L98
        if (r5 == null) goto L29;
        String r6 = r5.b();     // Catch: Throwable -> L96 Exception -> L98
    L30:
        if (r6 == null) goto L32;
        r0 = resolveAgainst(r6, r0);     // Catch: Throwable -> L96 Exception -> L98
    L33:
        if (r0 == null) goto L38;
        if (isAllowedBy(r0, r23.g()) == false) goto L38;
        r14 = r14 + 1;
        collectMetrics(r7);
    L38:
        deleteIfExists(r23.b());     // Catch: Throwable -> L96 Exception -> L98
        l r10 = (l) ZeusTransformUtils.preCheckCast(failure(OPERATION_DOWNLOAD, k.f22277b, Integer.valueOf(r8), r9), l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L96 Exception -> L98
        collectMetrics(r7);
        return r10;
    L32:
        r0 = null;
        goto L33
    L29:
        r6 = null;
        goto L30
    L23:
        deleteIfExists(r23.b());     // Catch: Throwable -> L96 Exception -> L98
        l r11 = (l) ZeusTransformUtils.preCheckCast(failure(OPERATION_DOWNLOAD, k.f22278c, Integer.valueOf(r8), r9), l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L96 Exception -> L98
        collectMetrics(r7);
        return r11;
    L41:
        d.l.j r12 = HTTP_SUCCESS_RANGE;     // Catch: Throwable -> L96 Exception -> L98
        int r15 = r12.a();     // Catch: Throwable -> L96 Exception -> L98
        if (r8 > r12.b()) goto L45;
        if (r15 > r8) goto L45;
        r13 = true;
    L45:
        if (r13 == true) goto L56;
        deleteIfExists(r23.b());     // Catch: Throwable -> L96 Exception -> L98
        com.bytedance.retrofit2.e.i r16 = responseBody(r1);     // Catch: Throwable -> L96 Exception -> L98
        if (r23.j() == true) goto L49;
        r2 = r24;
    L49:
        String r18 = readDebugText(r16, r2);     // Catch: Throwable -> L96 Exception -> L98
        if (r24 == null) goto L52;
        com.obric.autogui.net.ttnet.d.f29242a.a(r24, Integer.valueOf(r8), r4, r18, r9);     // Catch: Throwable -> L96 Exception -> L98
    L52:
        l r19 = (l) ZeusTransformUtils.preCheckCast(failure(OPERATION_DOWNLOAD, k.f22280e, Integer.valueOf(r8), r9), l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L96 Exception -> L98
        collectMetrics(r7);
        return r19;
    L56:
        if (exceedsContentLength(r1, r23.f()) == false) goto L60;
        closeStream(responseBody(r1));     // Catch: Throwable -> L96 Exception -> L98
        deleteIfExists(r23.b());     // Catch: Throwable -> L96 Exception -> L98
        l r20 = (l) ZeusTransformUtils.preCheckCast(failure(OPERATION_DOWNLOAD, k.f22279d, Integer.valueOf(r8), r9), l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L96 Exception -> L98
        collectMetrics(r7);
        return r20;
    L60:
        com.bytedance.retrofit2.e.i r21 = (com.bytedance.retrofit2.e.i) ZeusTransformUtils.preCheckCast(r1.f(), com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L96 Exception -> L98
        if (r21 != null) goto L109;
        deleteIfExists(r23.b());     // Catch: Throwable -> L96 Exception -> L98
        l r22 = (l) ZeusTransformUtils.preCheckCast(failure(OPERATION_DOWNLOAD, k.f, Integer.valueOf(r8), r9), l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L96 Exception -> L98
        collectMetrics(r7);
        return r22;
    L109:
        Closeable r25 = (Closeable) ZeusTransformUtils.preCheckCast(r21.e_(), Closeable.class, "com.obric.aiagent.plugin");     // Catch: b -> L93 Throwable -> L96 Exception -> L98
        InputStream r26 = (InputStream) ZeusTransformUtils.preCheckCast(r25, InputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L86
        OutputStream r27 = (OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r23.b()), OutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L86
        if (ZeusTransformUtils.instanceOf(r27, BufferedOutputStream.class) == false) goto L69;
        BufferedOutputStream r28 = (BufferedOutputStream) ZeusTransformUtils.preCheckCast(r27, BufferedOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L86
    L70:
        Closeable r29 = (Closeable) ZeusTransformUtils.preCheckCast(r28, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L86
        BufferedOutputStream r30 = (BufferedOutputStream) ZeusTransformUtils.preCheckCast(r29, BufferedOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L79
        d.h.b.o.a(r26);     // Catch: Throwable -> L79
        long r110 = copyBoundedTo(r26, (OutputStream) ZeusTransformUtils.preCheckCast(r30, OutputStream.class, "com.obric.aiagent.plugin"), r23.f());     // Catch: Throwable -> L79
        d.f.c.a(r29, null);     // Catch: Throwable -> L86
        d.f.c.a(r25, null);     // Catch: b -> L93 Throwable -> L96 Exception -> L98
        if (r24 == null) goto L76;
        com.obric.autogui.net.ttnet.d.f29242a.a(r24, Integer.valueOf(r8), r4, "<streamed " + r110 + " bytes to " + r23.b().getAbsolutePath() + '>', r9);     // Catch: Throwable -> L96 Exception -> L98
    L76:
        l r31 = (l) ZeusTransformUtils.preCheckCast(success(OPERATION_DOWNLOAD, r8, r110, r9), l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L96 Exception -> L98
        collectMetrics(r7);
        return r31;
    L79:
        th = move-exception;
        throw th;     // Catch: Throwable -> L82
    L82:
        th = move-exception;
        d.f.c.a(r29, th);     // Catch: Throwable -> L86
        throw th;     // Catch: Throwable -> L86
    L69:
        r28 = new BufferedOutputStream(r27, 8192);     // Catch: Throwable -> L86
    L86:
        th = move-exception;
        throw th;     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        d.f.c.a(r25, th);     // Catch: b -> L93 Throwable -> L96 Exception -> L98
        throw th;     // Catch: b -> L93 Throwable -> L96 Exception -> L98
    L93:
        deleteIfExists(r23.b());     // Catch: Throwable -> L96 Exception -> L98
        l r32 = (l) ZeusTransformUtils.preCheckCast(failure(OPERATION_DOWNLOAD, k.f22279d, Integer.valueOf(r8), r9), l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L96 Exception -> L98
        collectMetrics(r7);
        return r32;
    L17:
        r4 = null;
    L96:
        th = move-exception;
        collectMetrics(r7);
        throw th;
    L98:
        e = move-exception;
        deleteIfExists(r23.b());     // Catch: Throwable -> L96
        logTransferFailure(r24, e, r23.j());     // Catch: Throwable -> L96
        l r33 = (l) ZeusTransformUtils.preCheckCast(failure(OPERATION_DOWNLOAD, e), l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L96
        collectMetrics(r7);
        return r33;
    L104:
        e = move-exception;
        logTransferFailure(r24, e, r23.j());
        return (l) ZeusTransformUtils.preCheckCast(failure(OPERATION_DOWNLOAD, e), l.class, "com.obric.aiagent.plugin");
    L10:
        r17 = false;
        goto L115
    L5:
        deleteIfExists(r23.b());
        return (l) ZeusTransformUtils.preCheckCast(failure$default(this, OPERATION_DOWNLOAD, k.f22277b, null, null, 12, null), l.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.ttnet.ITTNetFileTransfer
    public l putFile(j r23) {
        d.h.b.o.e(r23, Ext.KEY_REQUEST);
        l.a r0 = validatePutRequest(r23);
        if (r0 != null) goto L5;
        com.bytedance.retrofit2.e<com.bytedance.retrofit2.e.i> r7 = createApi(r23.a()).put(false, -1, r23.a(), new com.bytedance.retrofit2.e.h(r23.c(), r23.b()), toRetrofitHeaders(r23.d()), requestContext$default(this, r23.e(), r23.f(), r23.g(), false, false, 24, null));     // Catch: Exception -> L24
        ak<com.bytedance.retrofit2.e.i> r1 = r7.a();     // Catch: Throwable -> L15 Exception -> L17
        int r3 = r1.c();     // Catch: Throwable -> L15 Exception -> L17
        d.h.b.o.a(r1);     // Catch: Throwable -> L15 Exception -> L17
        String r6 = ttLogId(r1);     // Catch: Throwable -> L15 Exception -> L17
        readDebugText((com.bytedance.retrofit2.e.i) ZeusTransformUtils.preCheckCast(r1.f(), com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin"), null);     // Catch: Throwable -> L15 Exception -> L17
        d.l.j r2 = HTTP_SUCCESS_RANGE;     // Catch: Throwable -> L15 Exception -> L17
        int r4 = r2.a();     // Catch: Throwable -> L15 Exception -> L17
        boolean r5 = false;
        if (r3 > r2.b()) goto L11;
        if (r4 > r3) goto L11;
        r5 = true;
    L11:
        if (r5 == false) goto L13;
        l r8 = (l) ZeusTransformUtils.preCheckCast(success(OPERATION_UPLOAD, r3, r23.b().length(), r6), l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15 Exception -> L17
    L27:
    L20:
        collectMetrics(r7);
        return r8;
    L13:
        r8 = (l) ZeusTransformUtils.preCheckCast(failure(OPERATION_UPLOAD, k.f22280e, Integer.valueOf(r3), r6), l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15 Exception -> L17
    L17:
        e = move-exception;
        logTransferFailure$default(this, null, e, false, 4, null);     // Catch: Throwable -> L15
        r8 = (l) ZeusTransformUtils.preCheckCast(failure(OPERATION_UPLOAD, e), l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        collectMetrics(r7);
        throw th;
    L24:
        e = move-exception;
        return (l) ZeusTransformUtils.preCheckCast(failure(OPERATION_UPLOAD, e), l.class, "com.obric.aiagent.plugin");
    L5:
        return (l) ZeusTransformUtils.preCheckCast(r0, l.class, "com.obric.aiagent.plugin");
    }

    private final l.a validateDownloadRequest(i r8) {
        if (isAllowedBy(r8.a(), r8.g()) == true) goto L5;
    L28:
        deleteIfExists(r8.b());
        return failure$default(this, OPERATION_DOWNLOAD, k.f22276a, null, null, 12, null);
    L5:
        if (hasValidTimeouts(r8) == false) goto L28;
        Long r0 = r8.f();
        boolean r1 = true;
        if (r0 != null) goto L9;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == true) goto L28;
        int r3 = r8.h();
        if (r3 >= 0) goto L19;
    L21:
        r1 = false;
    L22:
        if (r1 == false) goto L28;
        if (prepareDestination(r8.b()) == false) goto L28;
        return null;
    L19:
        if (r3 >= 11) goto L21;
    L9:
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).longValue() > 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 != true) goto L14;
        r2 = true;
        goto L15
    L11:
        r4 = false;
        goto L12
    }

    private final l.a validatePutRequest(j r8) {
        if (isSupportedHttpUrl(r8.a()) == false) goto L14;
        if (hasValidTimeouts(r8) == false) goto L14;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8.c(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L14;
        if (r8.b().isFile() == false) goto L14;
        return null;
    L14:
        return failure$default(this, OPERATION_UPLOAD, k.f22276a, null, null, 12, null);
    }

    private final boolean hasValidTimeouts(i r5) {
        if (r5.d() > 0) goto L5;
    L7:
        return false;
    L5:
        if (r5.e() <= 0) goto L7;
        return true;
    }

    private final boolean hasValidTimeouts(j r5) {
        if (r5.e() > 0) goto L5;
    L9:
        return false;
    L5:
        if (r5.f() <= 0) goto L9;
        if (r5.g() <= 0) goto L9;
        return true;
    }

    private final boolean isSupportedHttpUrl(String r5) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L21
        URI r2 = new URI(r5);     // Catch: Throwable -> L21
        boolean r3 = true;
        if (r2.isAbsolute() == false) goto L18;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.getHost(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r6 != null) goto L8;
    L11:
        boolean r7 = true;
    L12:
        if (r7 == true) goto L18;
        if (d.o.o.a(r2.getScheme(), "http", true) == false) goto L16;
    L19:
        Object r8 = n.f(Boolean.valueOf(r3));     // Catch: Throwable -> L21
    L24:
        if (n.b(r8) == false) goto L27;
        r8 = false;
    L27:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L16:
        if (d.o.o.a(r2.getScheme(), "https", true) == false) goto L18;
    L8:
        if (d.o.o.d(r6) == true) goto L11;
        r7 = false;
    L18:
        r3 = false;
    L21:
        th = move-exception;
        n.a r4 = n.f38560a;
        r8 = n.f(d.o.a(th));
        goto L24
    }

    private final boolean prepareDestination(File r3) {
        if (r3.exists() == true) goto L5;
    L7:
        File r2 = r3.getParentFile();
        if (r2 != null) goto L11;
        return false;
    L11:
        if (r2.isDirectory() == true) goto L15;
        if (r2.mkdirs() == true) goto L15;
        return false;
    L15:
        if (r3.exists() == true) goto L19;
        return true;
    L19:
        return false;
    L5:
        if (r3.delete() == true) goto L7;
        return false;
    }

    private final void deleteIfExists(File r2) {
        if (r2.exists() == true) goto L5;
        return;
    L5:
        if (r2.delete() == true) goto L9;
        ILogDepend.Companion.w(TAG, "file transfer partial destination cleanup failed");
        return;
    }

    private final TTNetFileTransferApi createApi(String r2) {
        URI r1 = new URI(r2);
        StringBuilder r3 = new StringBuilder();
        r3.append(r1.getScheme());
        r3.append("://");
        r3.append(r1.getHost());
        if (r1.getPort() < 0) goto L5;
        r3.append(':');
        r3.append(r1.getPort());
    L5:
        String r4 = r3.toString();
        d.h.b.o.c(r4, "toString(...)");
        Object r5 = com.bytedance.ttnet.utils.d.a(r4, TTNetFileTransferApi.class);
        d.h.b.o.c(r5, "createSsService(...)");
        return (TTNetFileTransferApi) ZeusTransformUtils.preCheckCast(r5, TTNetFileTransferApi.class, "com.obric.aiagent.plugin");
    }

    static /* synthetic */ com.bytedance.ttnet.d.d requestContext$default(TTNetFileTransferImpl r11, long r12, long r14, long r16, boolean r18, boolean r19, int r20, Object r21) {
        if ((r20 & 8) == 0) goto L5;
        boolean r9 = false;
    L7:
        if ((r20 & 16) == 0) goto L9;
        boolean r10 = false;
    L11:
        return r11.requestContext(r12, r14, r16, r9, r10);
    L9:
        r10 = r19;
        goto L11
    L5:
        r9 = r18;
        goto L7
    }

    private final com.bytedance.ttnet.d.d requestContext(long r1, long r3, long r5, boolean r7, boolean r8) {
        com.bytedance.ttnet.d.d r0 = new com.bytedance.ttnet.d.d();
        r0.f8189c = r1;
        r0.f8190d = r3;
        r0.f8191e = r5;
        r0.t = !r7;
        r0.j = r7;
        r0.w = r8;
        r0.x = r8;
        return r0;
    }

    private final int retrofitMaxLength(i r3) {
        Long r2 = r3.f();
        if (r2 != null) goto L5;
        return -1;
    L5:
        return (int) (d.l.n.b(r2.longValue(), 2147483646) + 1);
    }

    private final boolean isAllowedBy(String r2, m r3) {
        int r4 = c.f22194a[r3.ordinal()];
        if (r4 == 1) goto L10;
        if (r4 != 2) goto L8;
        return isPublicHttpsUrl(r2);
    L8:
        throw new d.k();
    L10:
        return isSupportedHttpUrl(r2);
    }

    private final boolean isPublicHttpsUrl(String r8) {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L4
        Object r9 = n.f(new URI(r8));     // Catch: Throwable -> L4
    L6:
        Object r1 = null;
        if (n.b(r9) == false) goto L9;
        r9 = null;
    L9:
        URI r10 = (URI) ZeusTransformUtils.preCheckCast(r9, URI.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L12;
        return false;
    L12:
        String r3 = r10.getHost();
        if (r3 == null) goto L17;
        String r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r4 == null) goto L17;
        String r5 = r4.toLowerCase(Locale.ROOT);
        d.h.b.o.c(r5, "toLowerCase(...)");
    L18:
        if (r5 != null) goto L21;
        r5 = "";
    L21:
        if (r10.isAbsolute() == true) goto L23;
        return false;
    L23:
        if (d.o.o.a(r10.getScheme(), "https", true) == true) goto L25;
        return false;
    L25:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L27;
        return false;
    L27:
        if (r10.getUserInfo() == null) goto L29;
        return false;
    L29:
        if (r10.getFragment() == null) goto L31;
        return false;
    L31:
        if (d.h.b.o.a(r5, "localhost") == false) goto L33;
        return false;
    L33:
        if (d.o.o.c(r5, ".localhost", false, 2, null) == false) goto L35;
        return false;
    L35:
        if (d.o.o.c(r5, ".local", false, 2, null) == false) goto L37;
        return false;
    L37:
        if (isIpLiteral(r5) == true) goto L83;
        n.a r11 = n.f38560a;     // Catch: Throwable -> L41
        InetAddress[] r12 = InetAddress.getAllByName(r5);     // Catch: Throwable -> L41
        d.h.b.o.c(r12, "getAllByName(...)");     // Catch: Throwable -> L41
        Object r13 = n.f(d.a.i.g((Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L41
    L44:
        if (n.b(r13) == true) goto L47;
        r1 = r13;
    L47:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L51;
        return false;
    L51:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L81;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L55;
    L57:
        Iterator r16 = r15.iterator();
    L59:
        if (r16.hasNext() == false) goto L56;
        InetAddress r2 = (InetAddress) ZeusTransformUtils.preCheckCast(r16.next(), InetAddress.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r2);
        if (isPublicNetworkAddress(r2) == true) goto L59;
        boolean r7 = false;
    L63:
        if (r7 == true) goto L65;
        return false;
    L65:
        return true;
    L56:
        r7 = true;
        goto L63
    L55:
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L57;
    L81:
        return false;
    L41:
        th = move-exception;
        n.a r6 = n.f38560a;
        r13 = n.f(d.o.a(th));
        goto L44
    L83:
        return false;
    L17:
        r5 = null;
    L4:
        th = move-exception;
        n.a r17 = n.f38560a;
        r9 = n.f(d.o.a(th));
        goto L6
    }

    private final boolean isIpLiteral(String r10) {
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"), ':', false, 2, null) == false) goto L5;
        return true;
    L5:
        List r9 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'.'}, false, 0, 6, null);
        if (r9.size() != 4) goto L55;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, Collection.class) == true) goto L10;
    L12:
        Iterator r12 = r11.iterator();
    L14:
        if (r12.hasNext() == false) goto L11;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.aiagent.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L18;
        boolean r3 = true;
    L19:
        if (r3 == false) goto L42;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin");
        int r5 = 0;
    L22:
        if (r5 >= r4.length()) goto L27;
        if (Character.isDigit(r4.charAt(r5)) == false) goto L25;
        r5 = r5 + 1;
        goto L22
    L25:
        boolean r6 = false;
    L28:
        if (r6 == false) goto L42;
        Integer r14 = d.o.o.d(r13);
        if (r14 == null) goto L39;
        int r15 = ((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r15 >= 0) goto L34;
    L36:
        boolean r16 = false;
    L37:
        if (r16 != true) goto L39;
        boolean r17 = true;
    L40:
        if (r17 == false) goto L42;
        boolean r18 = true;
    L43:
        if (r18 == true) goto L14;
        boolean r19 = false;
    L45:
        if (r19 == true) goto L47;
        return false;
    L47:
        return true;
    L34:
        if (r15 >= 256) goto L36;
        r16 = true;
    L39:
        r17 = false;
        goto L40
    L27:
        r6 = true;
    L42:
        r18 = false;
        goto L43
    L18:
        r3 = false;
    L11:
        r19 = true;
        goto L45
    L10:
        if (((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L12;
    L55:
        return false;
    }

    private final boolean isPublicNetworkAddress(InetAddress r5) {
        if (r5.isAnyLocalAddress() == false) goto L5;
        return false;
    L5:
        if (r5.isLoopbackAddress() == false) goto L7;
        return false;
    L7:
        if (r5.isLinkLocalAddress() == false) goto L9;
        return false;
    L9:
        if (r5.isSiteLocalAddress() == false) goto L11;
        return false;
    L11:
        if (r5.isMulticastAddress() == false) goto L14;
        return false;
    L14:
        if (ZeusTransformUtils.instanceOf(r5, Inet4Address.class) == false) goto L17;
        byte[] r6 = ((Inet4Address) ZeusTransformUtils.preCheckCast(r5, Inet4Address.class, "com.obric.aiagent.plugin")).getAddress();
        d.h.b.o.c(r6, "getAddress(...)");
        return isPublicIpv4(r6);
    L17:
        if (ZeusTransformUtils.instanceOf(r5, Inet6Address.class) == false) goto L31;
        byte[] r4 = ((Inet6Address) ZeusTransformUtils.preCheckCast(r5, Inet6Address.class, "com.obric.aiagent.plugin")).getAddress();
        d.h.b.o.c(r4, "getAddress(...)");
        Byte r7 = d.a.i.a(r4);
        if (r7 == null) goto L32;
        int r8 = r7.byteValue() & 255;
        if (32 <= r8) goto L23;
        return false;
    L23:
        if (r8 >= 64) goto L34;
        return true;
    L34:
        return false;
    L32:
        return false;
    L31:
        return false;
    }

    private final boolean isPublicIpv4(byte[] r8) {
        if (r8.length == 4) goto L5;
        return false;
    L5:
        int r7 = r8[0] & 255;
        int r2 = r8[1] & 255;
        if (r7 != 0) goto L8;
        return false;
    L8:
        if (r7 != 10) goto L10;
        return false;
    L10:
        if (r7 != 127) goto L12;
        return false;
    L12:
        if (r7 < 224) goto L15;
        return false;
    L15:
        if (r7 != 100) goto L25;
        if (64 <= r2) goto L19;
    L21:
        boolean r4 = false;
    L22:
        if (r4 == false) goto L25;
        return false;
    L19:
        if (r2 >= 128) goto L21;
        r4 = true;
    L25:
        if (r7 != 169) goto L30;
        if (r2 != 254) goto L30;
        return false;
    L30:
        if (r7 != 172) goto L40;
        if (16 <= r2) goto L34;
    L36:
        boolean r5 = false;
    L37:
        if (r5 == false) goto L40;
        return false;
    L34:
        if (r2 >= 32) goto L36;
        r5 = true;
    L40:
        if (r7 != 192) goto L43;
        if (r2 != 0) goto L43;
        return false;
    L43:
        if (r7 != 192) goto L48;
        if (r2 != 168) goto L48;
        return false;
    L48:
        if (r7 != 192) goto L55;
        if (r2 != 88) goto L55;
        if ((r8[2] & 255) != 99) goto L55;
        return false;
    L55:
        if (r7 == 198) goto L57;
    L64:
        if (r7 != 198) goto L71;
        if (r2 != 51) goto L71;
        if ((r8[2] & 255) != 100) goto L71;
        return false;
    L71:
        if (r7 != 203) goto L77;
        if (r2 != 0) goto L77;
        if ((r8[2] & 255) != 113) goto L77;
        return false;
    L77:
        return true;
    L57:
        if (18 <= r2) goto L59;
    L61:
        boolean r6 = false;
    L62:
        if (r6 == false) goto L64;
        return false;
    L59:
        if (r2 >= 20) goto L61;
        r6 = true;
        goto L62
    }

    private final String resolveAgainst(String r1, String r2) {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L4
        Object r3 = n.f(new URI(r2).resolve(r1).toString());     // Catch: Throwable -> L4
    L7:
        if (n.b(r3) == false) goto L10;
        r3 = null;
    L10:
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    L4:
        th = move-exception;
        n.a r4 = n.f38560a;
        r3 = n.f(d.o.a(th));
        goto L7
    }

    private final String urlForLog(String r1, boolean r2) {
        if (r2 == true) goto L16;
        return r1;
    L16:
        n.a r0 = n.f38560a;     // Catch: Throwable -> L9
        URI r3 = new URI(r1);     // Catch: Throwable -> L9
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L9
        r4.append(r3.getScheme());     // Catch: Throwable -> L9
        r4.append("://");     // Catch: Throwable -> L9
        r4.append(r3.getHost());     // Catch: Throwable -> L9
        if (r3.getPort() < 0) goto L7;
        r4.append(':').append(r3.getPort());     // Catch: Throwable -> L9
    L7:
        String r5 = r4.toString();     // Catch: Throwable -> L9
        d.h.b.o.c(r5, "toString(...)");     // Catch: Throwable -> L9
        Object r6 = n.f(r5);     // Catch: Throwable -> L9
    L12:
        if (n.b(r6) == false) goto L15;
        r6 = "<redacted-url>";
    L15:
        return (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin");
    L9:
        th = move-exception;
        n.a r7 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L12
    }

    private final com.bytedance.retrofit2.e.i responseBody(ak<com.bytedance.retrofit2.e.i> r3) {
        com.bytedance.retrofit2.e.i r2 = (com.bytedance.retrofit2.e.i) ZeusTransformUtils.preCheckCast(r3.f(), com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        return r2;
    L5:
        return r3.g();
    }

    private final boolean exceedsContentLength(ak<?> r4, Long r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        com.bytedance.retrofit2.b.b r6 = r4.b().a("Content-Length");
        if (r6 == null) goto L19;
        String r7 = r6.b();
        if (r7 == null) goto L22;
        Long r8 = d.o.o.e(r7);
        if (r8 != null) goto L13;
        return false;
    L13:
        if (((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).longValue() <= r5.longValue()) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == true) goto L18;
        return false;
    L18:
        return true;
    L15:
        r9 = false;
        goto L16
    L22:
        return false;
    L19:
        return false;
    }

    private final void drain(com.bytedance.retrofit2.e.i r5) {
        com.bytedance.retrofit2.e.i r4 = (com.bytedance.retrofit2.e.i) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L19;
        InputStream r6 = r4.e_();
        if (r6 == null) goto L26;
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r6, Closeable.class, "com.obric.aiagent.plugin");
        InputStream r0 = (InputStream) ZeusTransformUtils.preCheckCast(r7, InputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        byte[] r1 = new byte[4096];     // Catch: Throwable -> L14
    L10:
        if (r0.read(r1) != (-1)) goto L10;
        x r2 = x.f38692a;     // Catch: Throwable -> L14
        d.f.c.a(r7, null);
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        d.f.c.a(r7, th);
        throw th;
    L26:
        return;
    }

    private final void closeStream(com.bytedance.retrofit2.e.i r2) {
        com.bytedance.retrofit2.e.i r1 = (com.bytedance.retrofit2.e.i) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin");
        n.a r3 = n.f38560a;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        InputStream r4 = r1.e_();     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        r4.close();     // Catch: Throwable -> L11
        x r5 = x.f38692a;     // Catch: Throwable -> L11
    L9:
        Object r6 = n.f(r5);     // Catch: Throwable -> L11
    L14:
        if (n.c(r6) == null) goto L19;
        ILogDepend.Companion.w(TAG, "file transfer response close failed");
        return;
    L19:
        return;
    L8:
        r5 = null;
    L11:
        th = move-exception;
        n.a r7 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L14
    }

    private final long copyBoundedTo(InputStream r9, OutputStream r10, Long r11) {
        if (r11 == null) goto L5;
        byte[] r0 = new byte[8192];
        long r1 = 0;
    L7:
        int r3 = r9.read(r0);
        if (r3 < 0) goto L9;
        long r6 = r3;
        if (r1 > (r11.longValue() - r6)) goto L14;
        r10.write(r0, 0, r3);
        r1 = r1 + r6;
        goto L7
    L14:
        throw new b();
    L9:
        return r1;
    L5:
        return d.f.b.a(r9, r10, 0, 2, null);
    }

    private final String ttLogId(ak<?> r1) {
        return com.obric.autogui.net.ttnet.e.f29244a.a(r1.b().c());
    }

    private final String readDebugText(com.bytedance.retrofit2.e.i r4, String r5) {
        com.bytedance.retrofit2.e.i r3 = (com.bytedance.retrofit2.e.i) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L27;
        InputStream r6 = r3.e_();
        if (r6 == null) goto L27;
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r6, Closeable.class, "com.obric.aiagent.plugin");
        InputStream r1 = (InputStream) ZeusTransformUtils.preCheckCast(r7, InputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (r5 == null) goto L18;
        Reader r8 = (Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r1, d.o.d.f38623b), Reader.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (ZeusTransformUtils.instanceOf(r8, BufferedReader.class) == false) goto L13;
        BufferedReader r9 = (BufferedReader) ZeusTransformUtils.preCheckCast(r8, BufferedReader.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
    L14:
        String r10 = t.a((Reader) ZeusTransformUtils.preCheckCast(r9, Reader.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L22
    L20:
        d.f.c.a(r7, null);
        return r10;
    L13:
        r9 = new BufferedReader(r8, 8192);     // Catch: Throwable -> L22
    L18:
        if (r1.read(new byte[4096]) != (-1)) goto L18;
        r10 = null;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        d.f.c.a(r7, th);
        throw th;
    L27:
        return null;
    }

    static /* synthetic */ void logTransferFailure$default(TTNetFileTransferImpl r0, String r1, Exception r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.logTransferFailure(r1, r2, r3);
    }

    private final void logTransferFailure(String r10, Exception r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(r11, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class) == false) goto L7;
        com.bytedance.frameworks.baselib.network.http.cronet.b.c r1 = (com.bytedance.frameworks.baselib.network.http.cronet.b.c) ZeusTransformUtils.preCheckCast(r11, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class, "com.obric.aiagent.plugin");
    L8:
        boolean r4 = true;
        if (r12 == false) goto L30;
        com.obric.autogui.net.ttnet.d r6 = com.obric.autogui.net.ttnet.d.f29242a;
        if (ZeusTransformUtils.instanceOf(r11, com.bytedance.frameworks.baselib.network.http.c.d.class) == false) goto L15;
        Integer r0 = Integer.valueOf(((com.bytedance.frameworks.baselib.network.http.c.d) ZeusTransformUtils.preCheckCast(r11, com.bytedance.frameworks.baselib.network.http.c.d.class, "com.obric.aiagent.plugin")).a());
    L13:
        Integer r2 = r0;
    L23:
        com.obric.autogui.net.ttnet.e r5 = com.obric.autogui.net.ttnet.e.f29244a;
        if (r1 == null) goto L28;
        com.bytedance.frameworks.baselib.network.http.b r7 = r1.a();
        if (r7 == null) goto L28;
        r3 = r7.N;
    L28:
        r6.a(r10, r2, null, "<redacted download failure>", r5.a(r3));
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r11, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class) == false) goto L22;
        r0 = Integer.valueOf(((com.bytedance.frameworks.baselib.network.http.cronet.b.c) ZeusTransformUtils.preCheckCast(r11, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class, "com.obric.aiagent.plugin")).c());
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue() > 0) goto L20;
        r4 = false;
    L20:
        if (r4 == true) goto L13;
    L22:
        r2 = null;
        goto L23
    L30:
        com.obric.autogui.net.ttnet.d r8 = com.obric.autogui.net.ttnet.d.f29242a;
        if (ZeusTransformUtils.instanceOf(r11, com.bytedance.frameworks.baselib.network.http.c.d.class) == false) goto L34;
        Integer r9 = Integer.valueOf(((com.bytedance.frameworks.baselib.network.http.c.d) ZeusTransformUtils.preCheckCast(r11, com.bytedance.frameworks.baselib.network.http.c.d.class, "com.obric.aiagent.plugin")).a());
    L42:
        if (r1 == null) goto L46;
        com.bytedance.frameworks.baselib.network.http.b r13 = r1.a();
        if (r13 == null) goto L46;
        String r14 = r13.N;
    L47:
        com.obric.autogui.net.ttnet.e r15 = com.obric.autogui.net.ttnet.e.f29244a;
        if (r1 == null) goto L52;
        com.bytedance.frameworks.baselib.network.http.b r16 = r1.a();
        if (r16 == null) goto L52;
        r3 = r16.N;
    L52:
        r8.a(r10, r9, r14, r15.a(r3), (Throwable) ZeusTransformUtils.preCheckCast(r11, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L46:
        r14 = null;
        goto L47
    L34:
        if (ZeusTransformUtils.instanceOf(r11, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class) == false) goto L41;
        Integer r17 = Integer.valueOf(((com.bytedance.frameworks.baselib.network.http.cronet.b.c) ZeusTransformUtils.preCheckCast(r11, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class, "com.obric.aiagent.plugin")).c());
        if (((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.aiagent.plugin")).intValue() > 0) goto L39;
        r4 = false;
    L39:
        if (r4 == false) goto L41;
        r9 = r17;
    L41:
        r9 = null;
        goto L42
    L7:
        r1 = null;
        goto L8
    }

    private final void collectMetrics(com.bytedance.retrofit2.e<?> r2) {
        com.bytedance.retrofit2.e r1 = (com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, q.class) == false) goto L14;
        n.a r3 = n.f38560a;     // Catch: Throwable -> L6
        ((q) ZeusTransformUtils.preCheckCast(r1, q.class, "com.obric.aiagent.plugin")).f();     // Catch: Throwable -> L6
        Object r4 = n.f(x.f38692a);     // Catch: Throwable -> L6
    L9:
        if (n.c(r4) == null) goto L15;
        ILogDepend.Companion.w(TAG, "file transfer metrics collection failed");
        return;
    L15:
        return;
    L6:
        th = move-exception;
        n.a r5 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L9
    }

    private final l.b success(String r2, int r3, long r4, String r6) {
        ILogDepend.Companion r1 = ILogDepend.Companion;
        StringBuilder r5 = new StringBuilder().append(r2).append(" success httpCode=").append(r3).append(" transferredBytes=").append(r4).append(" ttLogId=");
        if (r6 != null) goto L5;
        String r0 = "-";
    L6:
        r1.i(TAG, r5.append(r0).toString());
        return new l.b(r3, r4, r6);
    L5:
        r0 = r6;
        goto L6
    }

    private final l.a failure(String r9, Exception r10) {
        if (ZeusTransformUtils.instanceOf(r10, com.bytedance.frameworks.baselib.network.http.c.d.class) == false) goto L7;
        k r0 = k.f22280e;
    L5:
        k r3 = r0;
        if (ZeusTransformUtils.instanceOf(r10, com.bytedance.frameworks.baselib.network.http.c.d.class) == false) goto L18;
        Integer r11 = Integer.valueOf(((com.bytedance.frameworks.baselib.network.http.c.d) ZeusTransformUtils.preCheckCast(r10, com.bytedance.frameworks.baselib.network.http.c.d.class, "com.obric.aiagent.plugin")).a());
    L16:
        Integer r4 = r11;
    L27:
        return failure$default(this, r9, r3, r4, null, 8, null);
    L18:
        if (ZeusTransformUtils.instanceOf(r10, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class) == false) goto L25;
        r11 = Integer.valueOf(((com.bytedance.frameworks.baselib.network.http.cronet.b.c) ZeusTransformUtils.preCheckCast(r10, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class, "com.obric.aiagent.plugin")).c());
        if (((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L22;
        boolean r1 = true;
    L23:
        if (r1 == false) goto L25;
    L22:
        r1 = false;
    L25:
        r4 = null;
        goto L27
    L7:
        if (ZeusTransformUtils.instanceOf(r10, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class) == false) goto L10;
        r0 = k.f;
        goto L5
    L10:
        if (ZeusTransformUtils.instanceOf(r10, IOException.class) == false) goto L12;
        r0 = k.g;
        goto L5
    L12:
        r0 = k.h;
        goto L5
    }

    static /* synthetic */ l.a failure$default(TTNetFileTransferImpl r1, String r2, k r3, Integer r4, String r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = null;
    L9:
        return r1.failure(r2, r3, r4, r5);
    }

    private final l.a failure(String r2, k r3, Integer r4, String r5) {
        ILogDepend.Companion r1 = ILogDepend.Companion;
        StringBuilder r6 = new StringBuilder().append(r2).append(" failed reason=").append(r3).append(" httpCode=");
        if (r4 == null) goto L5;
        int r0 = r4.intValue();
    L6:
        StringBuilder r7 = r6.append(r0).append(" ttLogId=");
        if (r5 != null) goto L9;
        String r8 = "-";
    L10:
        r1.w(TAG, r7.append(r8).toString());
        return new l.a(r3, r4, r5);
    L9:
        r8 = r5;
        goto L10
    L5:
        r0 = -1;
        goto L6
    }

    static {
        Companion = new a(null);
        HTTP_SUCCESS_RANGE = new d.l.j(200, 299);
        HTTP_REDIRECT_CODES = ax.a(new Integer[]{301, 302, 303, 307, 308});
    }

    private final List<com.bytedance.retrofit2.b.b> toRetrofitHeaders(Map<String, String> r5) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r4.size()), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r4.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L7;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r6.add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.aiagent.plugin")));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
    }
}
