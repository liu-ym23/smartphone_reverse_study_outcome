package okhttp3.internal.e;

import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.ad;
import okhttp3.m;
import okhttp3.n;
import okhttp3.u;
import okhttp3.v;

/* JADX INFO: compiled from: HttpHeaders.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final e.h f39921a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e.h f39922b = null;

    static {
        f39921a = e.h.f38722a.a("\"\\");
        f39922b = e.h.f38722a.a("\t ,=");
    }

    public static final List<okhttp3.h> a(u r8, String r9) {
        o.e(r8, "<this>");
        o.e(r9, "headerName");
        List<okhttp3.h> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        int r1 = r8.a();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L12;
        if (d.o.o.a(r9, r8.a(r3), true) == false) goto L11;
        a(new e.e().a(r8.b(r3)), r0);     // Catch: EOFException -> L9
    L9:
        e = move-exception;
        okhttp3.internal.i.h.f40147b.a().a("Unable to parse challenge", 5, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L11:
        r3 = r3 + 1;
        goto L3
    L12:
        return r0;
    }

    private static final void a(e.e r8, List<okhttp3.h> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
    L3:
        String r2 = null;
    L4:
        if (r2 != null) goto L8;
        a(r8);
        r2 = c(r8);
        if (r2 != null) goto L8;
        return;
    L8:
        boolean r3 = a(r8);
        String r4 = c(r8);
        if (r4 == null) goto L11;
        int r6 = okhttp3.internal.c.a(r8, (byte) 61);
        boolean r7 = a(r8);
        if (r3 == true) goto L21;
        if (r7 == true) goto L20;
        if (r8.h() == false) goto L21;
    L20:
        Map r5 = Collections.singletonMap(null, r4 + d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast("=", CharSequence.class, "com.obric.aiagent.plugin"), r6));
        o.c(r5, "singletonMap<String, Str…ek + \"=\".repeat(eqCount))");
        r10.add(new okhttp3.h(r2, r5));
    L21:
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        int r12 = r6 + okhttp3.internal.c.a(r8, (byte) 61);
    L22:
        if (r4 != null) goto L26;
        r4 = c(r8);
        if (a(r8) == true) goto L48;
        r12 = okhttp3.internal.c.a(r8, (byte) 61);
    L48:
        r10.add(new okhttp3.h(r2, r11));
        r2 = r4;
    L26:
        if (r12 == 0) goto L48;
        if (r12 > 1) goto L29;
        if (a(r8) == true) goto L32;
        if (a(r8, (byte) 34) == false) goto L36;
        String r13 = b(r8);
    L37:
        if (r13 == null) goto L38;
        if (((String) ZeusTransformUtils.preCheckCast(r11.put(r4, r13), String.class, "com.obric.aiagent.plugin")) != null) goto L41;
        if (a(r8) == true) goto L47;
        if (r8.h() == true) goto L47;
        return;
    L47:
        r4 = null;
        goto L22
    L41:
        return;
    L38:
        return;
    L36:
        r13 = c(r8);
        goto L37
    L32:
        return;
    L29:
        return;
    L11:
        if (r8.h() == true) goto L13;
        return;
    L13:
        r10.add(new okhttp3.h(r2, ao.b()));
    }

    private static final boolean a(e.e r5) {
        boolean r2 = false;
    L4:
        if (r5.h() == true) goto L17;
        byte r3 = r5.c(0);
        if (r3 == 44) goto L7;
        if (r3 != 32) goto L12;
    L10:
        boolean r4 = true;
    L15:
        if (r4 == false) goto L17;
        r5.k();
        goto L4
    L12:
        if (r3 == 9) goto L10;
        r4 = false;
        goto L15
    L7:
        r5.k();
        r2 = true;
    L17:
        return r2;
    }

    private static final boolean a(e.e r2, byte r3) {
        if (r2.h() == false) goto L5;
    L7:
        return false;
    L5:
        if (r2.c(0) != r3) goto L7;
        return true;
    }

    private static final String b(e.e r12) {
        if (r12.k() != 34) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L20;
        e.e r1 = new e.e();
    L8:
        long r2 = r12.b(f39921a);
        if (r2 == (-1)) goto L10;
        if (r12.c(r2) == 34) goto L13;
        if (r12.b() == (r2 + 1)) goto L17;
        r1.a_(r12, r2);
        r12.k();
        r1.a_(r12, 1);
        goto L8
    L17:
        return null;
    L13:
        r1.a_(r12, r2);
        r12.k();
        return r1.u();
    L10:
        return null;
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r0 = false;
        goto L6
    }

    private static final String c(e.e r4) {
        long r0 = r4.b(f39922b);
        if (r0 != (-1)) goto L6;
        r0 = r4.b();
    L6:
        if (r0 != 0) goto L10;
        return null;
    L10:
        return r4.e(r0);
    }

    public static final void a(n r2, v r3, u r4) {
        n r5 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.aiagent.plugin");
        o.e(r5, "<this>");
        o.e(r3, "url");
        o.e(r4, "headers");
        if (r5 != n.f40179b) goto L5;
        return;
    L5:
        List<m> r6 = m.f40173a.a(r3, r4);
        if (r6.isEmpty() == false) goto L8;
        return;
    L8:
        r5.a(r3, r6);
    }

    public static final boolean a(ad r8) {
        o.e(r8, "<this>");
        if (o.a(r8.a().b(), "HEAD") == false) goto L5;
        return false;
    L5:
        int r0 = r8.d();
        if (r0 < 100) goto L10;
        if (r0 >= 200) goto L10;
    L15:
        if (okhttp3.internal.c.a(r8) == (-1)) goto L17;
    L20:
        return true;
    L17:
        if (d.o.o.a(DownloadHelper.VALUE_CHUNKED, ad.a(r8, DownloadHelper.TRANSFER_ENCODING, null, 2, null), true) == true) goto L20;
        return false;
    L10:
        if (r0 == 204) goto L15;
        if (r0 == 304) goto L15;
        return true;
    }
}
