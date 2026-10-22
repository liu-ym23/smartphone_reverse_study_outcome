package com.obric.aiagent.skill.virt.impl.a.a;

import android.content.Context;
import android.os.SystemClock;
import androidx.core.provider.FontsContractCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.bytedance.virt.Ctrd;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.virt.impl.Virt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dg;
import org.json.JSONObject;

/* JADX INFO: compiled from: CtrdLogCollector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f f21804a = null;
    private static final Set<String> k = null;
    private static final d.o.k l = null;
    private static final d.o.k m = null;
    private static final d.o.k n = null;
    private static final char[] o = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.b<com.obric.aiagent.skill.virt.api.w, Boolean> f21805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f21806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final am f21807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlinx.coroutines.f.a f21808e;
    private final d f;
    private final AtomicBoolean g;
    private final AtomicBoolean h;
    private final ExecutorService i;
    private volatile e j;

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f21809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f21810b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f21811c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Long f21812d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Long f21813e;
        private Long f;
        private Long g;
        private long h;
        private long i;
        private long j;
        private long k;
        private long l;
        private long m;
        private long n;
        private long o;
        private long p;
        private long q;
        private long r;
        private boolean s;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.a.a.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CtrdLogCollector.kt */
        public /* synthetic */ class C0465a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f21814a = null;

            static {
                int[] r0 = new int[q.values().length];
                r0[q.f21858a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[q.f21859b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[q.f21860c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f21814a = r0;
            }
        }

        public a() {
        }

        public final long a() {
            return this.f21809a;
        }

        public final long b() {
            return this.f21810b;
        }

        public final long c() {
            return this.f21811c;
        }

        public final Long d() {
            return this.f21812d;
        }

        public final Long e() {
            return this.f21813e;
        }

        public final Long f() {
            return this.f;
        }

        public final Long g() {
            return this.g;
        }

        public final long h() {
            return this.h;
        }

        public final long i() {
            return this.i;
        }

        public final long j() {
            return this.j;
        }

        public final long k() {
            return this.k;
        }

        public final long l() {
            return this.l;
        }

        public final long m() {
            return this.m;
        }

        public final long n() {
            return this.n;
        }

        public final long o() {
            return this.o;
        }

        public final long p() {
            return this.p;
        }

        public final long q() {
            return this.q;
        }

        public final long r() {
            return this.r;
        }

        public final boolean s() {
            return this.s;
        }

        public final void a(p r5, b r6) {
            d.h.b.o.e(r5, "descriptor");
            d.h.b.o.e(r6, "line");
            this.f21809a += r6.b();
            this.f21810b++;
            if (this.s == false) goto L5;
        L8:
            boolean r0 = true;
        L9:
            this.s = r0;
            String r1 = r6.a();
            if (r6.c() == true) goto L25;
            if (r1 == null) goto L25;
            int r7 = C0465a.f21814a[r5.b().ordinal()];
            if (r7 != 1) goto L16;
            a(r1);
            return;
        L16:
            if (r7 != 2) goto L18;
            b(r1);
            return;
        L18:
            if (r7 != 3) goto L21;
            this.f21811c++;
            return;
        L21:
            throw new d.k();
        L25:
            this.f21811c++;
            return;
        L5:
            if (r5.c() == true) goto L8;
            r0 = false;
            goto L9
        }

        private final void a(String r6) {
            String r4 = null;
            d.o.i r7 = d.o.k.a(c.b().a(), (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
            if (r7 == null) goto L8;
            List<String> r8 = r7.d();
            if (r8 == null) goto L8;
            r4 = (String) ZeusTransformUtils.preCheckCast(d.a.p.d(r8, 1), String.class, "com.obric.aiagent.plugin");
        L8:
            if (r4 == null) goto L27;
            int r9 = r4.hashCode();
            if (r9 == 69) goto L24;
            if (r9 == 73) goto L21;
            if (r9 != 87) goto L27;
            if (r4.equals("W") == false) goto L27;
            this.i++;
            return;
        L21:
            if (r4.equals("I") == false) goto L27;
            this.h++;
            return;
        L24:
            if (r4.equals("E") == false) goto L27;
            this.j++;
            return;
        L27:
            this.f21811c++;
        }

        private final void b(String r11) {
            d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
            Object r12 = d.n.f(new JSONObject(r11));     // Catch: Throwable -> L5
        L8:
            if (d.n.b(r12) == false) goto L10;
            r12 = null;
        L10:
            JSONObject r13 = (JSONObject) ZeusTransformUtils.preCheckCast(r12, JSONObject.class, "com.obric.aiagent.plugin");
            if (r13 != null) goto L14;
            this.f21811c++;
            return;
        L14:
            Long r3 = c.b().a(r13, "timestamp_ms");
            if (r3 == null) goto L17;
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).longValue());
        L17:
            Long r4 = c.b().a(r13, "monotonic_ns");
            if (r4 == null) goto L20;
            b(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).longValue());
        L20:
            String r5 = r13.optString("event_type", "");
            d.h.b.o.c(r5, "optString(...)");
            String r6 = r5.toLowerCase(Locale.ROOT);
            d.h.b.o.c(r6, "toLowerCase(...)");
            if (d.o.o.b(r6, "runtime_", false, 2, null) == false) goto L23;
        L35:
            this.k++;
        L37:
            if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("fail", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L39;
        L44:
            this.p++;
        L46:
            if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("timeout", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L49;
            this.q++;
        L49:
            if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("kill", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L54;
            this.r++;
            return;
        L54:
            return;
        L39:
            if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(WsConstants.KEY_CONNECTION_ERROR, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L44;
            if (c.b().b(r13, FontsContractCompat.Columns.RESULT_CODE) == true) goto L44;
            if (c.b().b(r13, "exit_code") == false) goto L46;
        L23:
            if (d.o.o.b(r6, "workspace_", false, 2, null) == true) goto L35;
            if (d.o.o.b(r6, "shell_", false, 2, null) == false) goto L29;
            this.l++;
            goto L37
        L29:
            if (d.o.o.b(r6, "process_", false, 2, null) == false) goto L32;
            this.m++;
            goto L37
        L32:
            if (d.o.o.b(r6, "file_", false, 2, null) == false) goto L34;
            this.n++;
            goto L37
        L34:
            this.o++;
        L5:
            th = move-exception;
            d.n.a r7 = d.n.f38560a;
            r12 = d.n.f(d.o.a(th));
            goto L8
        }

        private final void a(long r5) {
            Long r0 = this.f21812d;
            if (r0 == null) goto L5;
            Long r1 = Long.valueOf(Math.min(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).longValue(), r5));
        L6:
            this.f21812d = r1;
            Long r2 = this.f21813e;
            if (r2 == null) goto L9;
            r5 = Math.max(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).longValue(), r5);
        L9:
            this.f21813e = Long.valueOf(r5);
            return;
        L5:
            r1 = Long.valueOf(r5);
            goto L6
        }

        private final void b(long r5) {
            Long r0 = this.f;
            if (r0 == null) goto L5;
            Long r1 = Long.valueOf(Math.min(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).longValue(), r5));
        L6:
            this.f = r1;
            Long r2 = this.g;
            if (r2 == null) goto L9;
            r5 = Math.max(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).longValue(), r5);
        L9:
            this.g = Long.valueOf(r5);
            return;
        L5:
            r1 = Long.valueOf(r5);
            goto L6
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f21815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f21816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f21817c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f21818d;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f21815a, r10.f21815a) == true) goto L12;
            return false;
        L12:
            if (this.f21816b == r10.f21816b) goto L15;
            return false;
        L15:
            if (this.f21817c == r10.f21817c) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f21818d, r10.f21818d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            String r0 = this.f21815a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((((r1 * 31) + Long.hashCode(this.f21816b)) * 31) + Boolean.hashCode(this.f21817c)) * 31) + this.f21818d.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "BoundedLine(text=" + this.f21815a + ", byteCount=" + this.f21816b + ", tooLong=" + this.f21817c + ", fingerprint=" + this.f21818d + ')';
        }

        public b(String r2, long r3, boolean r5, String r6) {
            d.h.b.o.e(r6, "fingerprint");
            this.f21815a = r2;
            this.f21816b = r3;
            this.f21817c = r5;
            this.f21818d = r6;
        }

        public final String a() {
            return this.f21815a;
        }

        public final long b() {
            return this.f21816b;
        }

        public final boolean c() {
            return this.f21817c;
        }

        public final String d() {
            return this.f21818d;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.skill.virt.impl.a.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    private static final class C0466c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InputStream f21819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f21820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final byte[] f21821c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final MessageDigest f21822d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f21823e;
        private long f;
        private boolean g;
        private int h;
        private int i;

        public C0466c(InputStream r2, int r3) {
            d.h.b.o.e(r2, "input");
            this.f21819a = r2;
            this.f21820b = r3;
            this.f21821c = new byte[8192];
            this.f21822d = MessageDigest.getInstance("SHA-256");
            long r4 = SystemClock.elapsedRealtime();
            this.f21823e = r4;
            this.f = r4;
        }

        public final b a() {
            this.f21822d.reset();
            ByteArrayOutputStream r0 = new ByteArrayOutputStream(Math.min(this.f21820b, 1024));
            long r3 = 0;
            boolean r5 = false;
        L3:
            boolean r10 = r5;
        L4:
            int r6 = b();
            if (r6 < 0) goto L13;
            r3 = r3 + 1;
            if (r6 == 10) goto L12;
            this.f21822d.update((byte) r6);
            if (r0.size() >= this.f21820b) goto L11;
            r0.write(r6);
            r5 = true;
            goto L4
        L11:
            r5 = true;
            goto L3
        L12:
            r5 = true;
        L13:
            long r8 = r3;
            if (r5 == true) goto L16;
            return null;
        L16:
            if (r10 == false) goto L18;
            String r7 = null;
        L19:
            f r1 = c.b();
            byte[] r12 = this.f21822d.digest();
            d.h.b.o.c(r12, "digest(...)");
            return new b(r7, r8, r10, r1.a(r12));
        L18:
            String r2 = r0.toString(StandardCharsets.UTF_8.name());
            d.h.b.o.c(r2, "toString(...)");
            r7 = d.o.o.c(r2, new char[]{'\r'});
            goto L19
        }

        private final int b() {
            if (this.h < this.i) goto L8;
            int r0 = c();
            this.i = r0;
            this.h = 0;
            if (r0 > 0) goto L8;
            return -1;
        L8:
            byte[] r1 = this.f21821c;
            int r2 = this.h;
            this.h = r2 + 1;
            return r1[r2] & 255;
        }

        private final int c() {
        L2:
            long r0 = SystemClock.elapsedRealtime();
            if ((r0 - this.f21823e) >= 60000) goto L21;
            int r2 = this.f21819a.available();
            if (r2 <= 0) goto L13;
            InputStream r4 = this.f21819a;
            byte[] r5 = this.f21821c;
            int r3 = r4.read(r5, 0, Math.min(r5.length, r2));
            if (r3 > 0) goto L8;
            if (r3 >= 0) goto L13;
            return -1;
        L8:
            this.g = true;
            this.f = SystemClock.elapsedRealtime();
            return r3;
        L13:
            if (this.g == false) goto L15;
            long r6 = 5000;
        L17:
            if ((r0 - this.f) >= r6) goto L18;
            Thread.sleep(20);
            goto L2
        L18:
            return -1;
        L15:
            r6 = 10000;
            goto L17
        L21:
            throw new j();
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f21824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Gson f21825b;

        public d(File r2) {
            d.h.b.o.e(r2, "file");
            this.f21824a = r2;
            Gson r3 = new GsonBuilder().create();
            d.h.b.o.c(r3, "create(...)");
            this.f21825b = r3;
        }

        public final g a() {
            if (this.f21824a.isFile() == false) goto L5;
            d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L11
            d r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
            g r3 = (g) ZeusTransformUtils.preCheckCast(r2.f21825b.fromJson(d.f.k.a(r2.f21824a, null, 1, null), g.class), g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
            if (r3 == null) goto L10;
            Object r4 = d.n.f(r3);     // Catch: Throwable -> L11
        L13:
            Throwable r5 = d.n.c(r4);
            if (r5 == null) goto L18;
            a(r5);
            String r11 = "checkpoint_corrupt";
            r4 = new g(0, null, null, null, null, null, null, r11, 127, null);
        L18:
            return (g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.aiagent.plugin");
        L10:
            throw new IllegalStateException("Ctrd diagnostics checkpoint is null".toString());     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            d.n.a r6 = d.n.f38560a;
            r4 = d.n.f(d.o.a(th));
            goto L13
        L5:
            return new g(0, null, null, null, null, null, null, null, 255, null);
        }

        public final boolean a(g r8) {
            d.h.b.o.e(r8, "checkpoint");
            d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L24
            d r7 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
            File r3 = r7.f21824a.getParentFile();     // Catch: Throwable -> L24
            if (r3 == null) goto L6;
            r3.mkdirs();     // Catch: Throwable -> L24
        L6:
            File r4 = new File(r7.f21824a.getParentFile(), r7.f21824a.getName() + ".tmp");     // Catch: Throwable -> L24
            String r9 = r7.f21825b.toJson(r8);     // Catch: Throwable -> L24
            d.h.b.o.c(r9, "toJson(...)");     // Catch: Throwable -> L24
            d.f.k.a(r4, r9, null, 2, null);     // Catch: Throwable -> L24
            d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L10
            Object r6 = d.n.f(Files.move(r4.toPath(), r7.f21824a.toPath(), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE}));     // Catch: Throwable -> L10
        L12:
            Throwable r10 = d.n.c(r6);     // Catch: Throwable -> L24
            if (r10 != null) goto L39;
        L22:
            d.o.a(r6);     // Catch: Throwable -> L24
            Object r11 = d.n.f(true);     // Catch: Throwable -> L24
        L26:
            Throwable r12 = d.n.c(r11);
            if (r12 == null) goto L33;
            if (IAppContext.Companion.isDebug() == false) goto L31;
            ILogDepend.Companion.w("Virt/CtrdLogs", "Ctrd diagnostics checkpoint write failed type=" + r12.getClass().getSimpleName());
            goto L33
        L31:
            ILogDepend.Companion.w("Virt/CtrdLogs", "Ctrd diagnostics checkpoint write failed");
        L33:
            if (d.n.b(r11) == false) goto L36;
            r11 = false;
        L36:
            return ((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        L39:
            d.n.a r13 = d.n.f38560a;     // Catch: Throwable -> L19
            if (ZeusTransformUtils.instanceOf(r10, AtomicMoveNotSupportedException.class) == false) goto L18;
            Object r14 = d.n.f(Files.move(r4.toPath(), r7.f21824a.toPath(), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING}));     // Catch: Throwable -> L19
        L21:
            r6 = r14;
            goto L22
        L18:
            throw r10;     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            d.n.a r15 = d.n.f38560a;     // Catch: Throwable -> L24
            r14 = d.n.f(d.o.a(th));     // Catch: Throwable -> L24
            goto L21
        L10:
            th = move-exception;
            d.n.a r16 = d.n.f38560a;     // Catch: Throwable -> L24
            r6 = d.n.f(d.o.a(th));     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            d.n.a r17 = d.n.f38560a;
            r11 = d.n.f(d.o.a(th));
            goto L26
        }

        private final void a(Throwable r7) {
            File r1 = new File(this.f21824a.getParentFile(), this.f21824a.getName() + ".corrupt." + System.currentTimeMillis());
            d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L5
            Object r6 = d.n.f(Boolean.valueOf(((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin")).f21824a.renameTo(r1)));     // Catch: Throwable -> L5
        L8:
            if (d.n.b(r6) == false) goto L10;
            r6 = false;
        L10:
            boolean r8 = ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
            if (IAppContext.Companion.isDebug() == false) goto L13;
            ILogDepend.Companion.w("Virt/CtrdLogs", "Ctrd diagnostics checkpoint corrupt moved=" + r8 + " type=" + r7.getClass().getSimpleName());
            return;
        L13:
            ILogDepend.Companion.w("Virt/CtrdLogs", "Ctrd diagnostics checkpoint corrupt");
            return;
        L5:
            th = move-exception;
            d.n.a r3 = d.n.f38560a;
            r6 = d.n.f(d.o.a(th));
            goto L8
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f21826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f21827b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f21828c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f21829d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f21830e;
        private final int f;
        private final long g;
        private final String h;

        public e() {
            this(false, null, null, null, null, 0, 0, null, 255, null);
        }

        public static /* synthetic */ e a(e r10, boolean r11, String r12, String r13, String r14, String r15, int r16, long r17, String r19, int r20, Object r21) {
            if ((r20 & 1) == 0) goto L5;
            boolean r2 = r10.f21826a;
        L7:
            if ((r20 & 2) == 0) goto L9;
            String r3 = r10.f21827b;
        L11:
            if ((r20 & 4) == 0) goto L13;
            String r4 = r10.f21828c;
        L15:
            if ((r20 & 8) == 0) goto L17;
            String r5 = r10.f21829d;
        L19:
            if ((r20 & 16) == 0) goto L21;
            String r6 = r10.f21830e;
        L23:
            if ((r20 & 32) == 0) goto L25;
            int r7 = r10.f;
        L27:
            if ((r20 & 64) == 0) goto L29;
            long r8 = r10.g;
        L31:
            if ((r20 & 128) == 0) goto L33;
            String r1 = r10.h;
        L35:
            return r10.a(r2, r3, r4, r5, r6, r7, r8, r1);
        L33:
            r1 = r19;
            goto L35
        L29:
            r8 = r17;
            goto L31
        L25:
            r7 = r16;
            goto L27
        L21:
            r6 = r15;
            goto L23
        L17:
            r5 = r14;
            goto L19
        L13:
            r4 = r13;
            goto L15
        L9:
            r3 = r12;
            goto L11
        L5:
            r2 = r11;
            goto L7
        }

        public final e a(boolean r12, String r13, String r14, String r15, String r16, int r17, long r18, String r20) {
            d.h.b.o.e(r13, "lastTrigger");
            d.h.b.o.e(r14, "lastResult");
            d.h.b.o.e(r15, "lastFailure");
            d.h.b.o.e(r16, "lastBatchId");
            d.h.b.o.e(r20, "lastPhase");
            return new e(r12, r13, r14, r15, r16, r17, r18, r20);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, e.class) == true) goto L8;
            return false;
        L8:
            e r10 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.aiagent.plugin");
            if (this.f21826a == r10.f21826a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f21827b, r10.f21827b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f21828c, r10.f21828c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f21829d, r10.f21829d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f21830e, r10.f21830e) == true) goto L24;
            return false;
        L24:
            if (this.f == r10.f) goto L27;
            return false;
        L27:
            if (this.g == r10.g) goto L30;
            return false;
        L30:
            if (d.h.b.o.a(this.h, r10.h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public int hashCode() {
            return (((((((((((((Boolean.hashCode(this.f21826a) * 31) + this.f21827b.hashCode()) * 31) + this.f21828c.hashCode()) * 31) + this.f21829d.hashCode()) * 31) + this.f21830e.hashCode()) * 31) + Integer.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + this.h.hashCode();
        }

        public String toString() {
            return "CollectorStatus(running=" + this.f21826a + ", lastTrigger=" + this.f21827b + ", lastResult=" + this.f21828c + ", lastFailure=" + this.f21829d + ", lastBatchId=" + this.f21830e + ", lastReportCount=" + this.f + ", lastLineCount=" + this.g + ", lastPhase=" + this.h + ')';
        }

        public e(boolean r2, String r3, String r4, String r5, String r6, int r7, long r8, String r10) {
            d.h.b.o.e(r3, "lastTrigger");
            d.h.b.o.e(r4, "lastResult");
            d.h.b.o.e(r5, "lastFailure");
            d.h.b.o.e(r6, "lastBatchId");
            d.h.b.o.e(r10, "lastPhase");
            this.f21826a = r2;
            this.f21827b = r3;
            this.f21828c = r4;
            this.f21829d = r5;
            this.f21830e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r10;
        }

        public /* synthetic */ e(boolean r3, String r4, String r5, String r6, String r7, int r8, long r9, String r11, int r12, d.h.b.h r13) {
            if ((r12 & 1) == 0) goto L6;
            r3 = false;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r4 = "";
        L9:
            if ((r12 & 4) == 0) goto L12;
            r5 = "never_run";
        L12:
            if ((r12 & 8) == 0) goto L15;
            r6 = "";
        L15:
            if ((r12 & 16) == 0) goto L18;
            r7 = "";
        L18:
            if ((r12 & 32) == 0) goto L21;
            r8 = 0;
        L21:
            if ((r12 & 64) == 0) goto L24;
            r9 = 0;
        L24:
            if ((r12 & 128) == 0) goto L26;
            r11 = "idle";
        L26:
            this(r3, r4, r5, r6, r7, r8, r9, r11);
        }

        public final boolean a() {
            return this.f21826a;
        }

        public final String b() {
            return this.f21827b;
        }

        public final String c() {
            return this.f21828c;
        }

        public final String d() {
            return this.f21829d;
        }

        public final String e() {
            return this.f21830e;
        }

        public final int f() {
            return this.f;
        }

        public final long g() {
            return this.g;
        }

        public final String h() {
            return this.h;
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    private static final class f {
        public /* synthetic */ f(d.h.b.h r1) {
            this();
        }

        private f() {
        }

        public final d.o.k a() {
            return c.c();
        }

        public final void a(ArrayDeque<String> r2, String r3) {
            d.h.b.o.e(r2, "queue");
            d.h.b.o.e(r3, "value");
            if (r2.size() != 64) goto L5;
            r2.removeFirst();
        L5:
            r2.addLast(r3);
        }

        public final void a(ArrayDeque<String> r1, String r2, int r3) {
            d.h.b.o.e(r1, "queue");
            d.h.b.o.e(r2, "value");
            if (r1.size() != r3) goto L5;
            r1.removeFirst();
        L5:
            r1.addLast(r2);
        }

        public final String a(String r4) {
            d.h.b.o.e(r4, "value");
            MessageDigest r0 = MessageDigest.getInstance("SHA-256");
            Charset r1 = StandardCharsets.UTF_8;
            d.h.b.o.c(r1, "UTF_8");
            byte[] r5 = r4.getBytes(r1);
            d.h.b.o.c(r5, "getBytes(...)");
            byte[] r6 = r0.digest(r5);
            d.h.b.o.c(r6, "digest(...)");
            return a(r6);
        }

        public final String a(byte[] r6) {
            d.h.b.o.e(r6, "<this>");
            StringBuilder r0 = new StringBuilder(r6.length * 2);
            int r5 = r6.length;
            int r1 = 0;
        L3:
            if (r1 >= r5) goto L5;
            int r2 = r6[r1] & 255;
            r0.append(c.b().b()[r2 >>> 4]);
            r0.append(c.b().b()[r2 & 15]);
            r1 = r1 + 1;
            goto L3
        L5:
            String r7 = r0.toString();
            d.h.b.o.c(r7, "toString(...)");
            return r7;
        }

        public final Long a(JSONObject r2, String r3) {
            d.h.b.o.e(r2, "<this>");
            d.h.b.o.e(r3, "key");
            Object r0 = null;
            if (r2.has(r3) == true) goto L5;
        L17:
            return null;
        L5:
            if (r2.isNull(r3) == true) goto L17;
            d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L9
            Object r4 = d.n.f(Long.valueOf(r2.getLong(r3)));     // Catch: Throwable -> L9
        L12:
            if (d.n.b(r4) == true) goto L16;
            r0 = r4;
        L16:
            return (Long) ZeusTransformUtils.preCheckCast(r0, Long.class, "com.obric.aiagent.plugin");
        L9:
            th = move-exception;
            d.n.a r5 = d.n.f38560a;
            r4 = d.n.f(d.o.a(th));
            goto L12
        }

        public final boolean b(JSONObject r5, String r6) {
            d.h.b.o.e(r5, "<this>");
            d.h.b.o.e(r6, "key");
            Long r4 = a(r5, r6);
            if (r4 == null) goto L11;
            if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).longValue() == 0) goto L7;
            boolean r7 = true;
        L8:
            if (r7 != true) goto L11;
            return true;
        L7:
            r7 = false;
        L11:
            return false;
        }

        public final char[] b() {
            return c.d();
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f21831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f21832b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map<String, o> f21833c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f21834d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<String> f21835e;
        private final String f;
        private final Long g;
        private final String h;

        public g() {
            this(0, null, null, null, null, null, null, null, 255, null);
        }

        public static /* synthetic */ g a(g r9, int r10, String r11, Map r12, String r13, List r14, String r15, Long r16, String r17, int r18, Object r19) {
            Map<String, o> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
            List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
            if ((r18 & 1) == 0) goto L5;
            int r4 = r9.f21831a;
        L7:
            if ((r18 & 2) == 0) goto L9;
            String r5 = r9.f21832b;
        L11:
            if ((r18 & 4) == 0) goto L14;
            r2 = r9.f21833c;
        L14:
            if ((r18 & 8) == 0) goto L16;
            String r6 = r9.f21834d;
        L18:
            if ((r18 & 16) == 0) goto L21;
            r3 = r9.f21835e;
        L21:
            if ((r18 & 32) == 0) goto L23;
            String r7 = r9.f;
        L25:
            if ((r18 & 64) == 0) goto L27;
            Long r8 = r9.g;
        L29:
            if ((r18 & 128) == 0) goto L31;
            String r1 = r9.h;
        L33:
            return r9.a(r4, r5, r2, r6, r3, r7, r8, r1);
        L31:
            r1 = r17;
            goto L33
        L27:
            r8 = r16;
            goto L29
        L23:
            r7 = r15;
            goto L25
        L16:
            r6 = r13;
            goto L18
        L9:
            r5 = r11;
            goto L11
        L5:
            r4 = r10;
            goto L7
        }

        public final g a(int r12, String r13, Map<String, o> r14, String r15, List<String> r16, String r17, Long r18, String r19) {
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r13, "bootId");
            d.h.b.o.e(r5, "sources");
            d.h.b.o.e(r7, "completedChunks");
            d.h.b.o.e(r17, "lastClearStatus");
            return new g(r12, r13, r5, r15, r7, r17, r18, r19);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
            return false;
        L8:
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
            if (this.f21831a == r6.f21831a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f21832b, r6.f21832b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f21833c, r6.f21833c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f21834d, r6.f21834d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f21835e, r6.f21835e) == true) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (d.h.b.o.a(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (d.h.b.o.a(this.h, r6.h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public int hashCode() {
            int r0 = ((((Integer.hashCode(this.f21831a) * 31) + this.f21832b.hashCode()) * 31) + this.f21833c.hashCode()) * 31;
            String r1 = this.f21834d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((((r0 + r3) * 31) + this.f21835e.hashCode()) * 31) + this.f.hashCode()) * 31;
            Long r5 = this.g;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.h;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "CtrdLogCheckpoint(schemaVersion=" + this.f21831a + ", bootId=" + this.f21832b + ", sources=" + this.f21833c + ", pendingBatchId=" + this.f21834d + ", completedChunks=" + this.f21835e + ", lastClearStatus=" + this.f + ", lastClearAtMs=" + this.g + ", lastFailureReason=" + this.h + ')';
        }

        public g(int r3, String r4, Map<String, o> r5, String r6, List<String> r7, String r8, Long r9, String r10) {
            Map<String, o> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "bootId");
            d.h.b.o.e(r11, "sources");
            d.h.b.o.e(r12, "completedChunks");
            d.h.b.o.e(r8, "lastClearStatus");
            this.f21831a = r3;
            this.f21832b = r4;
            this.f21833c = r11;
            this.f21834d = r6;
            this.f21835e = r12;
            this.f = r8;
            this.g = r9;
            this.h = r10;
        }

        public final String a() {
            return this.f21832b;
        }

        public /* synthetic */ g(int r10, String r11, Map r12, String r13, List r14, String r15, Long r16, String r17, int r18, d.h.b.h r19) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
            List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
            if ((r18 & 1) == 0) goto L5;
            int r3 = 1;
        L7:
            if ((r18 & 2) == 0) goto L9;
            String r4 = SensitiveType.UNKNOWN;
        L11:
            if ((r18 & 4) == 0) goto L13;
            r1 = ao.b();
        L13:
            String r6 = null;
            if ((r18 & 8) == 0) goto L16;
            String r5 = null;
        L18:
            if ((r18 & 16) == 0) goto L21;
            r2 = d.a.p.b();
        L21:
            if ((r18 & 32) == 0) goto L23;
            String r7 = "never_run";
        L25:
            if ((r18 & 64) == 0) goto L27;
            Long r8 = null;
        L29:
            if ((r18 & 128) != 0) goto L32;
            r6 = r17;
        L32:
            this(r3, r4, r1, r5, r2, r7, r8, r6);
            return;
        L27:
            r8 = r16;
            goto L29
        L23:
            r7 = r15;
            goto L25
        L16:
            r5 = r13;
            goto L18
        L9:
            r4 = r11;
            goto L11
        L5:
            r3 = r10;
            goto L7
        }

        public final Map<String, o> b() {
            return this.f21833c;
        }

        public final String c() {
            return this.f21834d;
        }

        public final List<String> d() {
            return this.f21835e;
        }

        public final String e() {
            return this.f;
        }

        public final String f() {
            return this.h;
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    private static final class h extends Exception {
        public h() {
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    private static final class i extends Exception {
        public i() {
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    private static final class j extends Exception {
        public j() {
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    private static final class k extends Exception {
        /* JADX WARN: Multi-variable type inference failed */
        public k() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public /* synthetic */ k(LinkageError r1, int r2, d.h.b.h r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }

        public k(LinkageError r3) {
            super("unsupported_system_api", (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    private static final class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f21836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<n> f21837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f21838c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f21839d;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, l.class) == true) goto L8;
            return false;
        L8:
            l r8 = (l) ZeusTransformUtils.preCheckCast(r7, l.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f21836a, r8.f21836a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f21837b, r8.f21837b) == true) goto L15;
            return false;
        L15:
            if (this.f21838c == r8.f21838c) goto L18;
            return false;
        L18:
            if (this.f21839d == r8.f21839d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f21836a.hashCode() * 31) + this.f21837b.hashCode()) * 31) + Boolean.hashCode(this.f21838c)) * 31) + Long.hashCode(this.f21839d);
        }

        public String toString() {
            return "ParsedSnapshot(batchId=" + this.f21836a + ", chunks=" + this.f21837b + ", hadAnyLines=" + this.f21838c + ", newLineCount=" + this.f21839d + ')';
        }

        public l(String r3, List<n> r4, boolean r5, long r6) {
            List<n> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "batchId");
            d.h.b.o.e(r7, "chunks");
            this.f21836a = r3;
            this.f21837b = r7;
            this.f21838c = r5;
            this.f21839d = r6;
        }

        public final String a() {
            return this.f21836a;
        }

        public final List<n> b() {
            return this.f21837b;
        }

        public final boolean c() {
            return this.f21838c;
        }

        public final long d() {
            return this.f21839d;
        }

        public final boolean e() {
            n r8 = (n) ZeusTransformUtils.preCheckCast(d.a.p.p(this.f21837b), n.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L5;
            return false;
        L5:
            a r1 = r8.c();
            if (d.h.b.o.a(r8.b(), "daemon") == true) goto L8;
            return false;
        L8:
            if (r1.b() == 1) goto L10;
            return false;
        L10:
            if (r1.c() == 0) goto L12;
            return false;
        L12:
            if (r1.h() == 1) goto L14;
            return false;
        L14:
            if (r1.i() == 0) goto L16;
            return false;
        L16:
            if (r1.j() != 0) goto L24;
            return true;
        L24:
            return false;
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    private final class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f21840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private p f21841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<String> f21842c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f21843d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Set<List<String>> f21844e;
        private final ArrayDeque<String> f;
        private boolean g;
        private final a h;
        private a i;
        private final ArrayDeque<String> j;

        public m(c r8, p r9, o r10) {
            d.h.b.o.e(r9, "descriptor");
            this.f21840a = r8;
            this.f21841b = r9;
            if (r10 == null) goto L5;
            List<String> r11 = r10.a();
        L6:
            if (r11 != null) goto L8;
            r11 = d.a.p.b();
        L8:
            this.f21842c = r11;
            int r12 = Math.min(r11.size(), 8);
            this.f21843d = r12;
            if (r12 != 0) goto L11;
            Set<List<String>> r13 = ax.b();
        L12:
            this.f21844e = r13;
            this.f = new ArrayDeque(r12);
            this.g = r11.isEmpty();
            this.h = new a();
            this.i = new a();
            this.j = new ArrayDeque(64);
            return;
        L11:
            r13 = d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin"), r12, 0, false, 6, null), Iterable.class, "com.obric.aiagent.plugin"));
            goto L12
        L5:
            r11 = null;
            goto L6
        }

        public final void a(b r7) {
            d.h.b.o.e(r7, "line");
            String r0 = c.b().a(this.f21841b.a() + ':' + r7.d());
            c.b().a(this.j, r0);
            this.h.a(this.f21841b, r7);
            if ((!((Collection) ZeusTransformUtils.preCheckCast(this.f21844e, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L11;
            c.b().a(this.f, r0, this.f21843d);
            if (this.f.size() != this.f21843d) goto L11;
            if (this.f21844e.contains(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.aiagent.plugin"))) == false) goto L11;
            this.g = true;
            this.i = new a();
            return;
        L11:
            if (this.g == true) goto L13;
            return;
        L13:
            this.i.a(this.f21841b, r7);
        }

        public final n a() {
            if (this.g == false) goto L5;
            a r0 = this.i;
        L6:
            a r4 = r0;
            if (r4.b() != 0) goto L11;
            return null;
        L11:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(this.f21842c, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L13;
        L15:
            boolean r6 = false;
        L17:
            return new n(this.f21841b.a(), this.f21841b.getType(), r4, new o(this.h.g(), this.h.e(), d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.j, Iterable.class, "com.obric.aiagent.plugin"))), r6, this.h.s());
        L13:
            if (this.g == true) goto L15;
            r6 = true;
            goto L17
        L5:
            r0 = this.h;
            goto L6
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    private static final class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f21845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f21846b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final a f21847c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final o f21848d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f21849e;
        private final boolean f;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, n.class) == true) goto L8;
            return false;
        L8:
            n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f21845a, r6.f21845a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f21846b, r6.f21846b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f21847c, r6.f21847c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f21848d, r6.f21848d) == true) goto L21;
            return false;
        L21:
            if (this.f21849e == r6.f21849e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            return (((((((((this.f21845a.hashCode() * 31) + this.f21846b.hashCode()) * 31) + this.f21847c.hashCode()) * 31) + this.f21848d.hashCode()) * 31) + Boolean.hashCode(this.f21849e)) * 31) + Boolean.hashCode(this.f);
        }

        public String toString() {
            return "SourceChunk(sourceKey=" + this.f21845a + ", sourceType=" + this.f21846b + ", aggregate=" + this.f21847c + ", nextCursor=" + this.f21848d + ", cursorReset=" + this.f21849e + ", rotated=" + this.f + ')';
        }

        public n(String r2, String r3, a r4, o r5, boolean r6, boolean r7) {
            d.h.b.o.e(r2, "sourceKey");
            d.h.b.o.e(r3, "sourceType");
            d.h.b.o.e(r4, "aggregate");
            d.h.b.o.e(r5, "nextCursor");
            this.f21845a = r2;
            this.f21846b = r3;
            this.f21847c = r4;
            this.f21848d = r5;
            this.f21849e = r6;
            this.f = r7;
        }

        public final String a() {
            return this.f21845a;
        }

        public final String b() {
            return this.f21846b;
        }

        public final a c() {
            return this.f21847c;
        }

        public final o d() {
            return this.f21848d;
        }

        public final com.obric.aiagent.skill.virt.api.w a(String r47, String r48, int r49, int r50) {
            d.h.b.o.e(r47, "trigger");
            d.h.b.o.e(r48, "batchId");
            return new com.obric.aiagent.skill.virt.api.w("ctrd", r47, r48, r49, r50, this.f21846b, this.f21847c.a(), this.f21847c.b(), this.f21847c.c(), this.f21847c.d(), this.f21847c.e(), this.f21847c.f(), this.f21847c.g(), this.f21847c.h(), this.f21847c.i(), this.f21847c.j(), this.f21847c.k(), this.f21847c.l(), this.f21847c.m(), this.f21847c.n(), this.f21847c.o(), this.f21847c.p(), this.f21847c.q(), this.f21847c.r(), this.f21849e, this.f, null, 67108864, null);
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    private static final class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Long f21850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Long f21851b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<String> f21852c;

        public o() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ o a(o r1, Long r2, Long r3, List r4, int r5, Object r6) {
            List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            if ((r5 & 1) == 0) goto L6;
            r2 = r1.f21850a;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = r1.f21851b;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r7 = r1.f21852c;
        L12:
            return r1.a(r2, r3, r7);
        }

        public final o a(Long r2, Long r3, List<String> r4) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "tailFingerprints");
            return new o(r2, r3, r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, o.class) == true) goto L8;
            return false;
        L8:
            o r6 = (o) ZeusTransformUtils.preCheckCast(r5, o.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f21850a, r6.f21850a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f21851b, r6.f21851b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f21852c, r6.f21852c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            Long r0 = this.f21850a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Long r4 = this.f21851b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return ((r3 + r1) * 31) + this.f21852c.hashCode();
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "SourceCursor(highWatermarkNs=" + this.f21850a + ", lastTimestampMs=" + this.f21851b + ", tailFingerprints=" + this.f21852c + ')';
        }

        public o(Long r3, Long r4, List<String> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "tailFingerprints");
            this.f21850a = r3;
            this.f21851b = r4;
            this.f21852c = r6;
        }

        public /* synthetic */ o(Long r2, Long r3, List r4, int r5, d.h.b.h r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r7 = d.a.p.b();
        L11:
            this(r2, r3, r7);
        }

        public final List<String> a() {
            return this.f21852c;
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    private static final class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f21853a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f21854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f21855c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final q f21856d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f21857e;

        /* JADX INFO: compiled from: CtrdLogCollector.kt */
        public static final class a {
            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            private a() {
            }

            public final p a(String r7) {
                d.h.b.o.e(r7, "section");
                return new p("unknown:" + d.o.o.e(c.b().a(r7), 12), SensitiveType.UNKNOWN, q.f21860c, d.o.o.c(r7, ".1", false, 2, null));
            }
        }

        static {
            f21853a = new a(null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, p.class) == true) goto L8;
            return false;
        L8:
            p r6 = (p) ZeusTransformUtils.preCheckCast(r5, p.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f21854b, r6.f21854b) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f21855c, r6.f21855c) == true) goto L15;
            return false;
        L15:
            if (this.f21856d == r6.f21856d) goto L18;
            return false;
        L18:
            if (this.f21857e == r6.f21857e) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f21854b.hashCode() * 31) + this.f21855c.hashCode()) * 31) + this.f21856d.hashCode()) * 31) + Boolean.hashCode(this.f21857e);
        }

        public String toString() {
            return "SourceDescriptor(key=" + this.f21854b + ", type=" + this.f21855c + ", format=" + this.f21856d + ", rotated=" + this.f21857e + ')';
        }

        public p(String r2, String r3, q r4, boolean r5) {
            d.h.b.o.e(r2, "key");
            d.h.b.o.e(r3, "type");
            d.h.b.o.e(r4, "format");
            this.f21854b = r2;
            this.f21855c = r3;
            this.f21856d = r4;
            this.f21857e = r5;
        }

        public final String a() {
            return this.f21854b;
        }

        public final String getType() {
            return this.f21855c;
        }

        public final q b() {
            return this.f21856d;
        }

        public final boolean c() {
            return this.f21857e;
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    private static final enum q extends Enum<q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f21858a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final q f21859b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final q f21860c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ q[] f21861d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f21862e = null;

        private static final /* synthetic */ q[] a() {
            return new q[]{f21858a, f21859b, f21860c};
        }

        static {
            f21858a = new q("TEXT", 0);
            f21859b = new q("JSON", 1);
            f21860c = new q("UNKNOWN", 2);
            q[] r0 = a();
            f21861d = r0;
            f21862e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        private q(String r1, int r2) {
            super(r1, r2);
        }

        public static q valueOf(String r2) {
            return (q) ZeusTransformUtils.preCheckCast(Enum.valueOf(q.class, r2), q.class, "com.obric.aiagent.plugin");
        }

        public static q[] values() {
            return (q[]) ZeusTransformUtils.preCheckCast(f21861d.clone(), q[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class r<T> implements Comparator {
        public r() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(((n) ZeusTransformUtils.preCheckCast(r2, n.class, "com.obric.aiagent.plugin")).a(), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.aiagent.plugin")).a(), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    @d.c.b.a.f(b = "CtrdLogCollector.kt", c = {374}, d = "clearLogs", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdLogCollector")
    static final class s extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21864b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f21865c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f21866d;

        s(c r3, d.c.d<? super s> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21865c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21864b = r3;
            this.f21866d |= Integer.MIN_VALUE;
            return c.b(this.f21865c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    @d.c.b.a.f(b = "CtrdLogCollector.kt", c = {374}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdLogCollector$clearLogs$result$1")
    static final class t extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Ctrd.c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21867a;

        t(d.c.d<? super t> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super Ctrd.c> r4) {
            return ((t) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), t.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new t((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Ctrd.c> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21867a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            Ctrd r6 = Ctrd.INSTANCE;
            d.c.d<? super Ctrd.c> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21867a = 1;
            r5 = r6.clearLogs(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    @d.c.b.a.f(b = "CtrdLogCollector.kt", c = {969, 84}, d = "drain", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdLogCollector")
    static final class u extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21869b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21870c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f21871d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f21872e;
        int f;

        u(c r3, d.c.d<? super u> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21872e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21871d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f21872e.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    @d.c.b.a.f(b = "CtrdLogCollector.kt", c = {150, 210}, d = "drainLocked", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdLogCollector")
    static final class v extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21874b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f21875c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f21876d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f21877e;
        int f;
        int g;
        long h;
        /* synthetic */ Object i;
        final /* synthetic */ c j;
        int k;

        v(c r3, d.c.d<? super v> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.i = r3;
            this.k |= Integer.MIN_VALUE;
            return c.a(this.j, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    @d.c.b.a.f(b = "CtrdLogCollector.kt", c = {309}, d = "openLogStream", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdLogCollector")
    static final class w extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f21880c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f21881d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f21882e;

        w(c r3, d.c.d<? super w> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21881d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21880c = r3;
            this.f21882e |= Integer.MIN_VALUE;
            return c.a(this.f21881d, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    @d.c.b.a.f(b = "CtrdLogCollector.kt", c = {301}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdLogCollector$openLogStream$future$1$input$1")
    static final class x extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super InputStream>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21883a;

        x(d.c.d<? super x> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super InputStream> r4) {
            return ((x) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), x.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new x((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super InputStream> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21883a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            Ctrd r7 = Ctrd.INSTANCE;
            d.c.d<? super InputStream> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21883a = 1;
            r6 = r7.queryLogsStream(10485760, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    @d.c.b.a.f(b = "CtrdLogCollector.kt", c = {287, 290}, d = "readSnapshot", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdLogCollector")
    static final class y extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f21885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f21886c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f21887d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f21888e;

        y(c r3, d.c.d<? super y> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21887d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21886c = r3;
            this.f21888e |= Integer.MIN_VALUE;
            return c.a(this.f21887d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CtrdLogCollector.kt */
    @d.c.b.a.f(b = "CtrdLogCollector.kt", c = {66}, d = "invokeSuspend", e = "com.obric.aiagent.skill.virt.impl.backend.ctrd.CtrdLogCollector$schedule$1")
    static final class z extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f21890b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21891c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f21892d;

        z(c r3, String r4, d.c.d<? super z> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21890b = r3;
            this.f21891c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((z) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), z.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            z r0 = new z(this.f21890b, this.f21891c, r6);
            r0.f21892d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21889a;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            d.o.a(r6);     // Catch: Throwable -> L15
        L13:
            Object r7 = d.n.f((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
        L17:
            c r5 = this.f21890b;
            Throwable r8 = d.n.c(r7);
            if (r8 == null) goto L24;
            if (ZeusTransformUtils.instanceOf(r8, CancellationException.class) == true) goto L22;
            c.a(r5, "Scheduled Ctrd diagnostics drain failed", r8);
            goto L24
        L22:
            throw r8;
        L24:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r6);
            am r9 = (am) ZeusTransformUtils.preCheckCast(this.f21892d, am.class, "com.obric.aiagent.plugin");
            c r10 = this.f21890b;
            String r2 = this.f21891c;
            d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L15
            this.f21889a = 1;     // Catch: Throwable -> L15
            r6 = r10.a(r2, this);     // Catch: Throwable -> L15
            if (r6 != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            d.n.a r3 = d.n.f38560a;
            r7 = d.n.f(d.o.a(th));
            goto L17
        }
    }

    /* JADX INFO: renamed from: lambda$CZJRLtZzM516pEJbx-QzBRd8yzM, reason: not valid java name */
    public static /* synthetic */ Thread m377lambda$CZJRLtZzM516pEJbxQzBRd8yzM(Runnable r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$a5dWVt2EKhG6knfBZ-FD-S_5CmQ, reason: not valid java name */
    public static /* synthetic */ l m378lambda$a5dWVt2EKhG6knfBZFDS_5CmQ(c r0, InputStream r1, g r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ InputStream lambda$hhB5Ze0DH8PKTApoH82qQbnGsDo(Future r0) {
        return a(r0);
    }

    public static /* synthetic */ InputStream lambda$zkvsQ7xR0riaTxw_wAQuoeC7apE(c r0) {
        return a(r0);
    }

    public c(Context r13, d.h.a.b<? super com.obric.aiagent.skill.virt.api.w, Boolean> r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        d.h.a.b<com.obric.aiagent.skill.virt.api.w, Boolean> r16 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r15, "context");
        d.h.b.o.e(r16, "onDiagnostics");
        this.f21805b = r16;
        Context r17 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r15.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f21806c = r17;
        this.f21807d = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
        this.f21808e = kotlinx.coroutines.f.c.a(false, 1, null);
        this.f = new d(new File(r17.getFilesDir(), "virt/ctrd-log-checkpoint-v1.json"));
        this.g = new AtomicBoolean(false);
        this.h = new AtomicBoolean(false);
        this.i = Executors.newSingleThreadExecutor($$Lambda$c$CZJRLtZzM516pEJbxQzBRd8yzM.INSTANCE);
        this.j = new e(false, null, null, null, null, 0, 0, null, 255, null);
    }

    public static final /* synthetic */ Object a(c r2, g r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r2, String r3, d.c.d r4) {
        return r2.b(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(c r0, String r1, Throwable r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ f b() {
        return f21804a;
    }

    public static final /* synthetic */ Object b(c r2, d.c.d r3) {
        return r2.b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ d.o.k c() {
        return n;
    }

    public static final /* synthetic */ char[] d() {
        return o;
    }

    private static final Thread a(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "CtrdLogQuery");
        r0.setDaemon(true);
        return r0;
    }

    public final void a(String r8) {
        d.h.b.o.e(r8, "trigger");
        if (this.g.get() == false) goto L5;
        return;
    L5:
        kotlinx.coroutines.i.a(this.f21807d, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new z(this, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [kotlinx.coroutines.f.a] */
    /* JADX WARN: Type inference failed for: r5v2 */
    public final Object a(String r23, d.c.d<? super String> r24) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, u.class) == false) goto L7;
        u r4 = (u) ZeusTransformUtils.preCheckCast(r2, u.class, "com.obric.aiagent.plugin");
        if ((r4.f & Integer.MIN_VALUE) == 0) goto L7;
        r4.f -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f21871d;
        ?? r5 = d.c.a.b.a();
        int r6 = r4.f;
        if (r6 == 0) goto L24;
        if (r6 == 1) goto L23;
        if (r6 != 2) goto L22;
        kotlinx.coroutines.f.a r7 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r4.f21869b, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        c r1 = (c) ZeusTransformUtils.preCheckCast(r4.f21868a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L15 Exception -> L17 CancellationException -> L19
    L42:
        String r0 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15 Exception -> L17 CancellationException -> L19
    L43:
        kotlinx.coroutines.f.a r8 = r7;
    L56:
        r8.b(null);
        return r0;
    L19:
        e = e;
    L60:
        r1.j = e.a(r1.j, false, null, "cancelled", "cancelled", null, 0, 0, "idle", 114, null);     // Catch: Throwable -> L15
        throw e;     // Catch: Throwable -> L15
    L17:
        e = e;
    L47:
        if (ZeusTransformUtils.instanceOf(e, k.class) == false) goto L50;
        String r9 = "unsupported_system_api";
    L49:
        String r14 = r9;
        e r10 = r1.j;     // Catch: Throwable -> L15
        d.h.b.o.a(r14);     // Catch: Throwable -> L15
        r1.j = e.a(r10, false, null, "failed", r14, null, 0, 0, "idle", 114, null);     // Catch: Throwable -> L15
        r1.a("Ctrd diagnostics drain failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
        r0 = r1.a();     // Catch: Throwable -> L15
        goto L43
    L50:
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(e.getClass().getSimpleName(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (d.o.o.d(r11) == false) goto L53;
        r11 = "Exception";
    L53:
        r9 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        goto L49
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L23:
        kotlinx.coroutines.f.a r12 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r4.f21870c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r4.f21869b, String.class, "com.obric.aiagent.plugin");
        r1 = (c) ZeusTransformUtils.preCheckCast(r4.f21868a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        String r15 = r13;
        r8 = r12;
    L66:
    L62:
        th = th;
        r5 = r8;
    L64:
        r5.b(null);
        throw th;
    L29:
        if (r1.g.get() == false) goto L32;
        r0 = r1.a();     // Catch: Throwable -> L62
        goto L56
    L32:
        if (k.contains(r15) == true) goto L35;
        r15 = null;
    L35:
        if (r15 != null) goto L37;
        r15 = Virt.TRIGGER_MANUAL;
    L37:
        r1.j = e.a(r1.j, true, r15, "running", null, null, 0, 0, "starting", 120, null);     // Catch: Throwable -> L62
        r4.f21868a = r1;     // Catch: Exception -> L44 CancellationException -> L58 Throwable -> L62
        r4.f21869b = r8;     // Catch: Exception -> L44 CancellationException -> L58 Throwable -> L62
        r4.f21870c = null;     // Catch: Exception -> L44 CancellationException -> L58 Throwable -> L62
        r4.f = 2;     // Catch: Exception -> L44 CancellationException -> L58 Throwable -> L62
        r3 = r1.b(r15, r4);     // Catch: Exception -> L44 CancellationException -> L58 Throwable -> L62
        if (r3 != r5) goto L41;
        return r5;
    L41:
        r7 = r8;
        goto L42
    L58:
        e = e;
    L44:
        e = e;
        r7 = r8;
        goto L47
    L24:
        d.o.a(r3);
        kotlinx.coroutines.f.a r16 = this.f21808e;
        r4.f21868a = this;
        r15 = r23;
        r4.f21869b = r15;
        r4.f21870c = r16;
        r4.f = 1;
        if (r16.a(null, r4) != r5) goto L27;
        return r5;
    L27:
        r8 = r16;
        r1 = this;
    L15:
        th = th;
    L7:
        r4 = new u(this, r2);
        goto L8
    }

    public final String a() {
        g r0 = this.f.a();
        e r1 = this.j;
        StringBuilder r2 = new StringBuilder();
        StringBuilder r7 = r2.append("supported=" + (!this.g.get()));
        d.h.b.o.c(r7, "append(...)");
        d.h.b.o.c(r7.append('\n'), "append(...)");
        StringBuilder r8 = r2.append("running=" + r1.a());
        d.h.b.o.c(r8, "append(...)");
        d.h.b.o.c(r8.append('\n'), "append(...)");
        StringBuilder r9 = r2.append("lastTrigger=" + r1.b());
        d.h.b.o.c(r9, "append(...)");
        d.h.b.o.c(r9.append('\n'), "append(...)");
        StringBuilder r10 = r2.append("lastResult=" + r1.c());
        d.h.b.o.c(r10, "append(...)");
        d.h.b.o.c(r10.append('\n'), "append(...)");
        StringBuilder r11 = r2.append("lastPhase=" + r1.h());
        d.h.b.o.c(r11, "append(...)");
        d.h.b.o.c(r11.append('\n'), "append(...)");
        StringBuilder r12 = r2.append("lastFailure=" + r1.d());
        d.h.b.o.c(r12, "append(...)");
        d.h.b.o.c(r12.append('\n'), "append(...)");
        StringBuilder r13 = r2.append("lastBatchId=" + r1.e());
        d.h.b.o.c(r13, "append(...)");
        d.h.b.o.c(r13.append('\n'), "append(...)");
        StringBuilder r14 = r2.append("lastReportCount=" + r1.f());
        d.h.b.o.c(r14, "append(...)");
        d.h.b.o.c(r14.append('\n'), "append(...)");
        StringBuilder r15 = r2.append("lastLineCount=" + r1.g());
        d.h.b.o.c(r15, "append(...)");
        d.h.b.o.c(r15.append('\n'), "append(...)");
        StringBuilder r16 = r2.append("lastClearStatus=" + r0.e());
        d.h.b.o.c(r16, "append(...)");
        d.h.b.o.c(r16.append('\n'), "append(...)");
        StringBuilder r17 = r2.append("checkpointSourceCount=" + r0.b().size());
        d.h.b.o.c(r17, "append(...)");
        d.h.b.o.c(r17.append('\n'), "append(...)");
        StringBuilder r18 = new StringBuilder().append("checkpointPendingBatch=");
        String r3 = r0.c();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r2.append(r18.append(r3).toString());
        String r19 = r2.toString();
        d.h.b.o.c(r19, "toString(...)");
        return r19;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x017d -> B:30:0x0184). Please report as a decompilation issue!!! */
    private final Object b(String r62, d.c.d<? super String> r63) {
        c r0 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r63, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, v.class) == false) goto L7;
        v r4 = (v) ZeusTransformUtils.preCheckCast(r2, v.class, "com.obric.aiagent.plugin");
        if ((r4.k & Integer.MIN_VALUE) == 0) goto L7;
        r4.k -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.i;
        Object r5 = d.c.a.b.a();
        int r6 = r4.k;
        String r8 = "";
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        int r1 = r4.g;
        int r7 = r4.f;
        long r9 = r4.h;
        int r10 = r4.f21877e;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r4.f21876d, String.class, "com.obric.aiagent.plugin");
        g r12 = (g) ZeusTransformUtils.preCheckCast(r4.f21875c, g.class, "com.obric.aiagent.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r4.f21874b, String.class, "com.obric.aiagent.plugin");
        c r14 = (c) ZeusTransformUtils.preCheckCast(r4.f21873a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
    L66:
        String r15 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
        int r53 = r10;
        long r54 = r9;
        g r16 = r12;
        String r17 = r13;
        int r18 = r1;
        String r19 = r11;
    L69:
        if (d.h.b.o.a(r15, "success") == false) goto L71;
        String r56 = "success";
        g r20 = g.a(r16, 0, null, ao.b(), null, d.a.p.b(), "success", d.c.b.a.b.a(System.currentTimeMillis()), null, 3, null);
    L75:
        boolean r57 = r14.f.a(r20);
        if (r18 == 0) goto L82;
        d.h.a.b<com.obric.aiagent.skill.virt.api.w, Boolean> r21 = r14.f21805b;
        CharSequence r22 = (CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r22) == false) goto L80;
        r22 = r14.f();
    L80:
        r21.invoke(new com.obric.aiagent.skill.virt.api.w("ctrd", r17, (String) ZeusTransformUtils.preCheckCast(r22, String.class, "com.obric.aiagent.plugin"), r53, r53 + 1, "collector", 0, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false, r15, 67108352, null));
    L82:
        if (r57 == true) goto L84;
    L83:
        String r110 = "failed";
    L91:
        if (r57 == false) goto L96;
        String r23 = r20.f();
        if (r23 == null) goto L97;
        String r111 = r23;
    L98:
        r14.j = new e(false, r17, r110, r111, r19, r53, r54, "idle");
        return r14.a();
    L97:
        r111 = r8;
        goto L98
    L96:
        r8 = "checkpoint_write_failed";
        goto L97
    L84:
        if (r7 != 0) goto L87;
        r110 = "deferred_active";
        goto L91
    L87:
        if (d.h.b.o.a(r15, "failed") == true) goto L83;
        r110 = r56;
        goto L91
    L71:
        r56 = "success";
        if (d.h.b.o.a(r15, "not_needed") == false) goto L74;
        r20 = g.a(r16, 0, null, null, null, d.a.p.b(), "not_needed", null, null, 71, null);
        goto L75
    L74:
        r20 = g.a(r16, 0, null, null, null, null, r15, null, "clear_failed", 95, null);
        goto L75
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r24 = r4.g;
        int r25 = r4.f;
        long r112 = r4.h;
        int r113 = r4.f21877e;
        String r114 = (String) ZeusTransformUtils.preCheckCast(r4.f21876d, String.class, "com.obric.aiagent.plugin");
        g r26 = (g) ZeusTransformUtils.preCheckCast(r4.f21875c, g.class, "com.obric.aiagent.plugin");
        String r115 = (String) ZeusTransformUtils.preCheckCast(r4.f21874b, String.class, "com.obric.aiagent.plugin");
        c r27 = (c) ZeusTransformUtils.preCheckCast(r4.f21873a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        g r116 = r26;
        int r28 = r25;
        Object r29 = r5;
        v r30 = r4;
        int r31 = r24;
        r0 = r27;
        String r32 = r115;
    L30:
        l r33 = (l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.aiagent.plugin");
        boolean r117 = r33.c();
        r112 = r112 + r33.d();
        if (r33.b().isEmpty() == false) goto L33;
    L52:
        Object r210 = r29;
        r4 = r30;
        String r34 = r114;
        r9 = r112;
        r10 = r113;
        r12 = r116;
        r7 = 1;
        r13 = r32;
        r14 = r0;
        Object r35 = r210;
    L54:
        if (r7 == 0) goto L60;
        if (r117 == true) goto L59;
        int r118 = 1;
        if ((!r12.b().isEmpty()) == false) goto L60;
    L61:
        if (r118 == 0) goto L67;
        r4.f21873a = r14;
        r4.f21874b = r13;
        r4.f21875c = r12;
        r4.f21876d = r34;
        r4.f21877e = r10;
        r4.h = r9;
        r4.f = r7;
        r4.g = r118;
        r4.k = 2;
        Object r36 = r14.b(r4);
        if (r36 != r35) goto L65;
        return r35;
    L65:
        r11 = r34;
        r3 = r36;
        r1 = r118;
        goto L66
    L67:
        r19 = r34;
        r53 = r10;
        r15 = "not_needed";
        r54 = r9;
        r16 = r12;
        r17 = r13;
        r18 = r118;
        goto L69
    L59:
        r118 = 1;
    L60:
        r118 = 0;
        goto L61
    L33:
        if (r33.e() == true) goto L52;
        r114 = r33.a();
        g r119 = g.a(r116, 0, null, null, r114, d.a.p.b(), null, null, null, 103, null);
        int r61 = r31;
        if (r0.f.a(r119) == false) goto L38;
        int r37 = r33.b().size();
        v r64 = r30;
        Iterator r38 = ((Iterable) ZeusTransformUtils.preCheckCast(r33.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        g r120 = r119;
        int r39 = 0;
    L41:
        if (r38.hasNext() == false) goto L51;
        int r121 = r39 + 1;
        Object r211 = r29;
        Iterator r310 = r38;
        n r40 = (n) ZeusTransformUtils.preCheckCast(r38.next(), n.class, "com.obric.aiagent.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r0.f21805b.invoke(r40.a(r32, r114, r39, r37)), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L44;
        r113 = r113 + 1;
        int r311 = r37;
        g r41 = g.a(r120, 0, null, ao.a(r120.b(), d.s.a(r40.a(), r40.d())), null, d.a.p.a((Collection) ZeusTransformUtils.preCheckCast(r120.d(), Collection.class, "com.obric.aiagent.plugin"), r40.a()), null, null, null, 107, null);
        if (r0.f.a(r41) == false) goto L49;
        r120 = r41;
        r39 = r121;
        r29 = r211;
        r38 = r310;
        r37 = r311;
        goto L41
    L49:
        return r0.a(r32, r114);
    L44:
        r0.f.a(g.a(r120, 0, null, null, null, null, "not_attempted", null, "report_rejected", 95, null));
        String r212 = r32;
        r0.j = new e(false, r212, "failed", "report_rejected", r114, r113, r112, null, 128, null);
        return r0.a();
    L51:
        Object r213 = r29;
        int r42 = r61;
        r4 = r64;
        int r43 = r28;
        g r44 = r120;
        r5 = r213;
    L25:
        if (r42 >= 3) goto L53;
        int r45 = r42 + 1;
        r4.f21873a = r0;
        r4.f21874b = r32;
        r4.f21875c = r44;
        r4.f21876d = r114;
        r4.f21877e = r113;
        r4.h = r112;
        r4.f = r43;
        r4.g = r45;
        r4.k = 1;
        Object r122 = r0.a(r44, r4);
        if (r122 != r5) goto L29;
        return r5;
    L29:
        r116 = r44;
        r28 = r43;
        r29 = r5;
        r30 = r4;
        r31 = r45;
        r3 = r122;
        goto L30
    L53:
        r34 = r114;
        String r58 = r32;
        r14 = r0;
        r35 = r5;
        r7 = r43;
        r10 = r113;
        long r59 = r112;
        r13 = r58;
        r12 = r44;
        r9 = r59;
        goto L54
    L38:
        return r0.a(r32, r114);
    L16:
        d.o.a(r3);
        g r123 = r0.f.a();
        String r46 = e();
        if (d.h.b.o.a(r123.a(), r46) == true) goto L23;
        Map<String, o> r47 = r123.b();
        Map r48 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(ao.a(r47.size())), Map.class, "com.obric.aiagent.plugin");
        Iterator r49 = ((Iterable) ZeusTransformUtils.preCheckCast(r47.entrySet(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L20:
        if (r49.hasNext() == false) goto L22;
        Object r50 = r49.next();
        r48.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r50, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), o.a((o) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r50, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), o.class, "com.obric.aiagent.plugin"), null, null, null, 6, null));
        goto L20
    L22:
        r123 = g.a(r123, 0, r46, r48, null, null, null, null, null, 249, null);
    L23:
        r112 = 0;
        r114 = "";
        r44 = r123;
        r42 = 0;
        r43 = 0;
        r117 = false;
        r113 = 0;
        r32 = r62;
    L7:
        r4 = new v(r0, r2);
        goto L8
    }

    private final String a(String r14, String r15) {
        this.j = new e(false, r14, "failed", "checkpoint_write_failed", r15, 0, 0, "idle", 96, null);
        return a();
    }

    private final Object a(g r23, d.c.d<? super l> r24) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, y.class) == false) goto L7;
        y r4 = (y) ZeusTransformUtils.preCheckCast(r2, y.class, "com.obric.aiagent.plugin");
        if ((r4.f21888e & Integer.MIN_VALUE) == 0) goto L7;
        r4.f21888e -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f21886c;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f21888e;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 != 2) goto L18;
        InputStream r7 = (InputStream) ZeusTransformUtils.preCheckCast(r4.f21885b, InputStream.class, "com.obric.aiagent.plugin");
        c r8 = (c) ZeusTransformUtils.preCheckCast(r4.f21884a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L15
    L29:
        l r9 = (l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L32
        c r1 = (c) ZeusTransformUtils.preCheckCast(r8, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        r7.close();     // Catch: Throwable -> L32
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L32
    L34:
        r8.j = e.a(r8.j, false, null, null, null, null, 0, 0, "processing", 127, null);
        return r9;
    L32:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        d.n.f(d.o.a(th));
    L15:
        th = move-exception;
        Throwable r11 = th;
    L44:
        d.n.a r12 = d.n.f38560a;     // Catch: Throwable -> L40
        r7.close();     // Catch: Throwable -> L40
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L40
    L42:
        r8.j = e.a(r8.j, false, null, null, null, null, 0, 0, "processing", 127, null);
        throw r11;
    L40:
        th = move-exception;
        d.n.a r13 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L42
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        final g r14 = (g) ZeusTransformUtils.preCheckCast(r4.f21885b, g.class, "com.obric.aiagent.plugin");
        final c r15 = (c) ZeusTransformUtils.preCheckCast(r4.f21884a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
    L24:
        final InputStream r16 = (InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.aiagent.plugin");
        r15.j = e.a(r15.j, false, null, null, null, null, 0, 0, "reading", 127, null);
        d.c.g r17 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
        d.h.a.a r18 = new $$Lambda$c$a5dWVt2EKhG6knfBZFDS_5CmQ(r15, r16, r14);     // Catch: Throwable -> L36
        r4.f21884a = r15;     // Catch: Throwable -> L36
        r4.f21885b = r16;     // Catch: Throwable -> L36
        r4.f21888e = 2;     // Catch: Throwable -> L36
        Object r19 = bx.a(r17, r18, r4);     // Catch: Throwable -> L36
        if (r19 != r5) goto L28;
        return r5;
    L28:
        r7 = r16;
        r8 = r15;
        r3 = r19;
    L36:
        th = move-exception;
        r11 = th;
        r7 = r16;
        r8 = r15;
        goto L44
    L20:
        d.o.a(r3);
        this.j = e.a(this.j, false, null, null, null, null, 0, 0, "querying", 127, null);
        r4.f21884a = this;
        r4.f21885b = r23;
        r4.f21888e = 1;
        Object r20 = a(r4);
        if (r20 != r5) goto L23;
        return r5;
    L23:
        r15 = this;
        r14 = r23;
        r3 = r20;
    L7:
        r4 = new y(this, r2);
        goto L8
    }

    private static final l a(c r0, InputStream r1, g r2) {
        return r0.a(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object a(d.c.d<? super InputStream> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, w.class) == false) goto L7;
        w r0 = (w) ZeusTransformUtils.preCheckCast(r9, w.class, "com.obric.aiagent.plugin");
        if ((r0.f21882e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21882e -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f21880c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f21882e;
        int r4 = 1;
        if (r3 == 0) goto L21;
        if (r3 != 1) goto L20;
        Future r7 = (Future) ZeusTransformUtils.preCheckCast(r0.f21879b, Future.class, "com.obric.aiagent.plugin");
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0.f21878a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r10);     // Catch: ExecutionException -> L14 TimeoutException -> L16 CancellationException -> L17
    L30:
        d.h.b.o.a(r10);     // Catch: ExecutionException -> L14 TimeoutException -> L16 CancellationException -> L17
        return (InputStream) ZeusTransformUtils.preCheckCast(r10, InputStream.class, "com.obric.aiagent.plugin");
    L17:
        CancellationException e2 = e;
    L50:
        r7.cancel(true);
        throw e2;
    L14:
        ExecutionException e3 = e;
    L34:
        Throwable r11 = e3.getCause();
        if (ZeusTransformUtils.instanceOf(r11, CancellationException.class) == false) goto L37;
        throw r11;
    L37:
        if (ZeusTransformUtils.instanceOf(r11, LinkageError.class) == false) goto L39;
        r1.g.set(true);
        r1.h.set(true);
        r1.i.shutdownNow();
        throw new k((LinkageError) ZeusTransformUtils.preCheckCast(r11, LinkageError.class, "com.obric.aiagent.plugin"));
    L39:
        if (ZeusTransformUtils.instanceOf(r11, Exception.class) == false) goto L42;
        throw r11;
    L42:
        throw new IllegalStateException("Ctrd log query failed", r11);
    L16:
        final Future r12 = r7;
        final c this = r1;
    L46:
        this.h.set(true);
        r12.cancel(true);
        this.i.shutdownNow();
        throw new h();
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        d.o.a(r10);
        if (this.g.get() == true) goto L55;
        if (this.h.get() == true) goto L53;
        r12 = this.i.submit(new $$Lambda$c$zkvsQ7xR0riaTxw_wAQuoeC7apE(this));
        d.c.g r5 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin");     // Catch: ExecutionException -> L32 TimeoutException -> L56 CancellationException -> L48
        d.h.a.a r6 = new $$Lambda$c$hhB5Ze0DH8PKTApoH82qQbnGsDo(r12);     // Catch: ExecutionException -> L32 TimeoutException -> L56 CancellationException -> L48
        r0.f21878a = this;     // Catch: ExecutionException -> L32 TimeoutException -> L56 CancellationException -> L48
        r0.f21879b = r12;     // Catch: ExecutionException -> L32 TimeoutException -> L56 CancellationException -> L48
        r0.f21882e = 1;     // Catch: ExecutionException -> L32 TimeoutException -> L56 CancellationException -> L48
        Object r13 = bx.a(r5, r6, r0);     // Catch: ExecutionException -> L32 TimeoutException -> L56 CancellationException -> L48
        if (r13 != r2) goto L29;
        return r2;
    L29:
        r1 = this;
        r7 = r12;
        r10 = r13;
        goto L30
    L48:
        e = move-exception;
        e2 = e;
        r7 = r12;
    L32:
        e = move-exception;
        r1 = this;
        e3 = e;
        goto L34
    L53:
        throw new i();
    L55:
        throw new k(null, r4, 0 == true ? 1 : 0);
    L7:
        r0 = new w(this, r9);
        goto L8
    }

    private static final InputStream a(c r4) {
        InputStream r0 = (InputStream) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new x(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), InputStream.class, "com.obric.aiagent.plugin");
        if (r4.h.get() == true) goto L11;
        return r0;
    L11:
        d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L7
        r0.close();     // Catch: Throwable -> L7
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L7
    L10:
        throw new i();
    L7:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L10
    }

    private static final InputStream a(Future r4) {
        return (InputStream) ZeusTransformUtils.preCheckCast(((Future) ZeusTransformUtils.wrapperContextForParams(r4, Future.class, "com.obric.aiagent.plugin")).get(10000, TimeUnit.MILLISECONDS), InputStream.class, "com.obric.aiagent.plugin");
    }

    private final l a(InputStream r11, g r12) {
        C0466c r0 = new C0466c(r11, 65536);
        LinkedHashMap r13 = new LinkedHashMap();
        p r1 = p.f21853a.a("preamble");
        boolean r5 = false;
    L3:
        b r2 = r0.a();
        if (r2 == null) goto L5;
        String r4 = r2.a();
        if (r4 == null) goto L20;
        p r6 = b(r4);
    L21:
        if (r6 != null) goto L22;
        r5 = true;
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.aiagent.plugin");
        String r8 = r1.a();
        Object r9 = r7.get(r8);
        if (r9 != null) goto L26;
        r9 = new m(this, r1, (o) ZeusTransformUtils.preCheckCast(r12.b().get(r1.a()), o.class, "com.obric.aiagent.plugin"));
        r7.put(r8, r9);
    L26:
        ((m) ZeusTransformUtils.preCheckCast(r9, m.class, "com.obric.aiagent.plugin")).a(r2);
        goto L3
    L22:
        r1 = r6;
        goto L3
    L20:
        r6 = null;
        goto L21
    L5:
        Collection r14 = r13.values();
        d.h.b.o.c(r14, "<get-values>(...)");
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r15.iterator();
    L7:
        if (r17.hasNext() == false) goto L11;
        n r3 = ((m) ZeusTransformUtils.preCheckCast(r17.next(), m.class, "com.obric.aiagent.plugin")).a();
        if (r3 == null) goto L7;
        r16.add(r3);
        goto L7
    L11:
        List<n> r10 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin");
        String r18 = a(r10);
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        long r20 = 0;
    L13:
        if (r19.hasNext() == false) goto L16;
        r20 = r20 + ((n) ZeusTransformUtils.preCheckCast(r19.next(), n.class, "com.obric.aiagent.plugin")).c().b();
        goto L13
    L16:
        return new l(r18, r10, r5, r20);
    }

    private final Object b(d.c.d<? super String> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, s.class) == false) goto L7;
        s r0 = (s) ZeusTransformUtils.preCheckCast(r10, s.class, "com.obric.aiagent.plugin");
        if ((r0.f21866d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21866d -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f21864b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f21866d;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        c this = (c) ZeusTransformUtils.preCheckCast(r0.f21863a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r11);     // Catch: Exception -> L24 CancellationException -> L27
    L20:
        if (((Ctrd.c) ZeusTransformUtils.preCheckCast(r11, Ctrd.c.class, "com.obric.aiagent.plugin")).d() == true) goto L32;
        return "failed";
    L32:
        return "success";
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r11);
        d.h.a.m r12 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new t(null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L24 CancellationException -> L27
        r0.f21863a = this;     // Catch: Exception -> L24 CancellationException -> L27
        r0.f21866d = 1;     // Catch: Exception -> L24 CancellationException -> L27
        r11 = dg.a(15000, r12, r0);     // Catch: Exception -> L24 CancellationException -> L27
        if (r11 != r2) goto L20;
        return r2;
    L27:
        e = move-exception;
        throw e;
    L24:
        e = move-exception;
        this.a("Ctrd diagnostics clear failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return "failed";
    L7:
        r0 = new s(this, r10);
        goto L8
    }

    private final p b(String r8) {
        d.o.i r7 = l.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r7 != null) goto L5;
        return null;
    L5:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r7.d().get(1), String.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r9, "ctrd.log") == false) goto L9;
        return new p("daemon", "daemon", q.f21858a, false);
    L9:
        if (d.h.b.o.a(r9, "ctrd/events.jsonl") == true) goto L18;
        if (d.h.b.o.a(r9, "ctrd/events.jsonl.1") == true) goto L18;
        if (m.a((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L21;
        return new p("workspace:" + d.o.o.e(f21804a.a(d.o.o.a(r9, '/', null, 2, null)), 12), "workspace", q.f21859b, d.o.o.c(r9, ".1", false, 2, null));
    L21:
        return p.f21853a.a(r9);
    L18:
        return new p("global", "global", q.f21859b, d.o.o.c(r9, ".1", false, 2, null));
    }

    private final String a(List<n> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (r6.isEmpty() == false) goto L5;
        return "";
    L5:
        StringBuilder r8 = new StringBuilder();
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new r(), Comparator.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r9.hasNext() == false) goto L12;
        n r2 = (n) ZeusTransformUtils.preCheckCast(r9.next(), n.class, "com.obric.aiagent.plugin");
        r8.append(r2.a());
        r8.append(':');
        String r4 = (String) ZeusTransformUtils.preCheckCast(d.a.p.n(r2.d().a()), String.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        r8.append(r4);
        r8.append(':');
        r8.append(r2.c().b());
        r8.append(';');
        goto L7
    L12:
        String r10 = r8.toString();
        d.h.b.o.c(r10, "toString(...)");
        return d.o.o.e(f21804a.a(r10), 24);
    }

    private final String e() {
        String r2 = null;
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L5
        c r4 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r5 = d.n.f(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(d.f.k.a(new File("/proc/sys/kernel/random/boot_id"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin")).toString());     // Catch: Throwable -> L5
    L8:
        if (d.n.b(r5) == false) goto L10;
        r5 = null;
    L10:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L13;
    L17:
        return SensitiveType.UNKNOWN;
    L13:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L15;
        r2 = r6;
    L15:
        if (r2 == null) goto L17;
        return r2;
    L5:
        th = move-exception;
        d.n.a r7 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L8
    }

    private final String f() {
        String r0 = UUID.randomUUID().toString();
        d.h.b.o.c(r0, "toString(...)");
        return d.o.o.a(r0, "-", "", false, 4, null);
    }

    private final void a(String r3, Throwable r4) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.w("Virt/CtrdLogs", r3 + " type=" + r4.getClass().getSimpleName());
        return;
    L5:
        ILogDepend.Companion.w("Virt/CtrdLogs", r3);
    }

    static {
        f21804a = new f(null);
        k = ax.a(new String[]{Virt.TRIGGER_STARTUP, "close", Virt.TRIGGER_MANUAL});
        l = new d.o.k("^===== (.+) =====$");
        m = new d.o.k("^ctr\\d+/log/events\\.jsonl(?:\\.1)?$");
        n = new d.o.k("^\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}:\\d{2}\\s+([IWE])\\b");
        char[] r0 = "0123456789abcdef".toCharArray();
        d.h.b.o.c(r0, "toCharArray(...)");
        o = r0;
    }
}
