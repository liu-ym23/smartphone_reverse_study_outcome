package com.obric.oui.d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;

/* JADX INFO: compiled from: L.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f35007a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f35008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f35009c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f35010d;

    /* JADX INFO: compiled from: L.kt */
    public interface a {
        void a(String r1, int r2, String r3, Throwable r4);
    }

    private b() {
    }

    static {
        f35007a = new b();
        f35009c = (a) ZeusTransformUtils.preCheckCast(new com.obric.oui.d.a.a("OUI_SDK", false, 2, null), a.class, "com.obric.aiagent.plugin");
        f35010d = 31;
    }

    public final a a() {
        a r0 = f35008b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return f35009c;
    }

    public static final void a(String r9, String r10) {
        o.e(r9, "tag");
        o.e(r10, "msg");
        a(f35007a, r9, 1, r10, null, false, 24, null);
    }

    public static final void b(String r9, String r10) {
        o.e(r9, "tag");
        o.e(r10, "msg");
        a(f35007a, r9, 2, r10, null, false, 24, null);
    }

    public static final void c(String r9, String r10) {
        o.e(r9, "tag");
        o.e(r10, "msg");
        a(f35007a, r9, 4, r10, null, false, 24, null);
    }

    public static final void d(String r9, String r10) {
        o.e(r9, "tag");
        o.e(r10, "msg");
        a(f35007a, r9, 8, r10, null, false, 24, null);
    }

    public static final void a(String r9, String r10, Throwable r11) {
        o.e(r9, "tag");
        o.e(r10, "msg");
        a(f35007a, r9, 8, r10, r11, false, 16, null);
    }

    public static final void e(String r9, String r10) {
        o.e(r9, "tag");
        o.e(r10, "msg");
        a(f35007a, r9, 16, r10, null, false, 24, null);
    }

    public static final void b(String r9, String r10, Throwable r11) {
        o.e(r9, "tag");
        o.e(r10, "msg");
        a(f35007a, r9, 16, r10, r11, false, 16, null);
    }

    static /* synthetic */ void a(b r6, String r7, int r8, String r9, Throwable r10, boolean r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = null;
    L5:
        Throwable r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        r11 = false;
    L8:
        r6.a(r7, r8, r9, r4, r11);
    }

    private final void a(String r7, int r8, String r9, Throwable r10, boolean r11) {
        if (a(r8) == false) goto L5;
        return;
    L5:
        if (r11 == true) goto L7;
        a().a(r7, r8, r9, r10);
        return;
    L7:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"\n"}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");
        f35007a.a().a(r7, r8, r12, null);
        goto L9
    }

    public final boolean a(int r1) {
        if ((f35010d & r1) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
