package com.bytedanceos.appstore.buss.utilities;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8856a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f8857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f8858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f8859d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final void a(Object r10) {
            f(3, null, r10);
        }

        public final void b(String r10, Object r11) {
            kotlin.jvm.internal.q.g(r10, "tag");
            f(3, r10, r11);
        }

        public final void c(Object r10) {
            f(6, null, r10);
        }

        public final void d(Throwable r10) {
            if (r10 == null) goto L5;
            String r11 = r10.toString();
        L6:
            f(6, null, r11);
            qg.a.a(r10);
            return;
        L5:
            r11 = null;
            goto L6
        }

        public final String e(Object r10) {
            return String.valueOf(r10);
        }

        public final void f(int r10, String r11, Object r12) {
            if (j.a() <= r10) goto L5;
            return;
        L5:
            String[] r13 = i(r11, r12);
            String r14 = r13[0];
            String r15 = r13[1];
            h(r10, r14, r13[2] + r15);
        }

        public final void g(int r10, String r11, String r12) {
            if (r10 != 2) goto L5;
            qg.a.b(r11).e(r12, new Object[0]);
            return;
        L5:
            if (r10 != 3) goto L7;
            qg.a.b(r11).a(r12, new Object[0]);
            return;
        L7:
            if (r10 != 4) goto L9;
            qg.a.b(r11).d(r12, new Object[0]);
            return;
        L9:
            if (r10 != 5) goto L11;
            qg.a.b(r11).f(r12, new Object[0]);
            return;
        L11:
            if (r10 != 6) goto L23;
            qg.a.b(r11).b(r12, new Object[0]);
            return;
        }

        public final void h(int r10, String r11, String r12) {
            int r13 = r12.length() / 4000;
            if (r13 <= 0) goto L9;
            int r14 = 0;
            int r15 = 0;
        L6:
            if (r14 >= r13) goto L8;
            int r16 = r15 + 4000;
            String r17 = r12.substring(r15, r16);
            kotlin.jvm.internal.q.f(r17, "substring(...)");
            g(r10, r11, r17);
            r14 = r14 + 1;
            r15 = r16;
            goto L6
        L8:
            String r18 = r12.substring(r15);
            kotlin.jvm.internal.q.f(r18, "substring(...)");
            g(r10, r11, r18);
            return;
        L9:
            g(r10, r11, r12);
        }

        public final String[] i(String r10, Object r11) {
            StackTraceElement r12 = Thread.currentThread().getStackTrace()[5];
            String r13 = r12.getFileName();
            String r14 = r12.getMethodName();
            int r15 = r12.getLineNumber();
            if (r15 >= 0) goto L5;
            r15 = 0;
        L5:
            if (r10 == null) goto L7;
        L10:
            if (r11 != null) goto L12;
            String r16 = "Log`s object is null";
        L14:
            return new String[]{r10, r16, "[ (" + r13 + ':' + r15 + ")=>" + r14 + " ] "};
        L12:
            r16 = e(r11);
            goto L14
        L7:
            if (j.b() == false) goto L9;
            r10 = "TvLog";
            goto L10
        L9:
            r10 = j.c();
            goto L10
        }

        public a() {
        }
    }

    static {
        f8856a = new a(null);
        f8857b = true;
        f8858c = "TvLog";
        f8859d = 2;
    }

    public static final /* synthetic */ int a() {
        return f8859d;
    }

    public static final /* synthetic */ boolean b() {
        return f8857b;
    }

    public static final /* synthetic */ String c() {
        return f8858c;
    }

    public static final void d(String r10, Object r11) {
        f8856a.b(r10, r11);
    }
}
