package com.obric.aiagent.skill.virt.api;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: VirtPaths.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21622a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f21625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j f21626e;

    /* JADX INFO: compiled from: VirtPaths.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final y a(String r2, String r3) {
            d.h.b.o.e(r2, "homeDir");
            return new y(r2, r3, null);
        }
    }

    static {
        f21622a = new a(null);
    }

    public /* synthetic */ y(String r1, String r2, d.h.b.h r3) {
        this(r1, r2);
    }

    private y(String r4, String r5) {
        String r6 = f(r4);
        this.f21623b = r6;
        j r0 = null;
        if (r5 == null) goto L5;
        String r7 = f(r5);
    L6:
        this.f21624c = r7;
        this.f21625d = new e("", r6);
        if (r7 == null) goto L9;
        r0 = new j("", r7);
    L9:
        this.f21626e = r0;
        return;
    L5:
        r7 = null;
        goto L6
    }

    public final e a() {
        return this.f21625d;
    }

    public final j b() {
        return this.f21626e;
    }

    public static /* synthetic */ e a(y r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = "";
    L6:
        return r0.a(r1);
    }

    public final e a(String r3) {
        d.h.b.o.e(r3, "relativePath");
        String r4 = e(r3);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return this.f21625d;
    L9:
        return new e(r4, this.f21623b + '/' + r4);
    L5:
        r0 = false;
        goto L6
    }

    public final j b(String r3) {
        d.h.b.o.e(r3, "relativePath");
        String r0 = this.f21624c;
        if (r0 == null) goto L13;
        String r2 = e(r3);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L11;
        return new j("", r0);
    L11:
        return new j(r2, r0 + '/' + r2);
    L7:
        r4 = false;
        goto L8
    L13:
        throw new k();
    }

    public final com.obric.aiagent.skill.virt.api.a c(String r12) {
        d.h.b.o.e(r12, DownloadConstants.PATH_KEY);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r11 = true;
    L7:
        if (r11 == true) goto L38;
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == false) goto L38;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), 0, false, 2, null) == true) goto L36;
        List r13 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a(r12, new char[]{'/'}), CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'/'}, false, 0, 6, null);
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r5.hasNext() == false) goto L34;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == true) goto L32;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L30;
        if (d.h.b.o.a(r6, ".") == true) goto L28;
        if (d.h.b.o.a(r6, DownloadConstants.VULNERABILITY_PATH) == false) goto L14;
    L28:
        throw new i("Absolute path must not contain '.' or '..' segments: '" + r12 + '\'');
    L30:
        throw new i("Absolute path must not contain whitespace-only segments: '" + r12 + '\'');
    L32:
        throw new i("Absolute path must not contain empty segments: '" + r12 + '\'');
    L18:
        r7 = false;
        goto L19
    L34:
        return new com.obric.aiagent.skill.virt.api.a('/' + d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("/", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null));
    L36:
        throw new i("Absolute path must not contain NUL");
    L38:
        throw new i("Absolute path must start with '/': '" + r12 + '\'');
    L5:
        r11 = false;
        goto L7
    }

    public final String d(String r7) {
        d.h.b.o.e(r7, "absolutePath");
        String r0 = f(r7);
        if (d.h.b.o.a(r0, this.f21623b) == false) goto L6;
        return "~";
    L6:
        if (d.o.o.b(r0, this.f21623b + '/', false, 2, null) == true) goto L8;
        return r7;
    L8:
        return "~/" + d.o.o.a(r0, (CharSequence) ZeusTransformUtils.preCheckCast(this.f21623b + '/', CharSequence.class, "com.obric.aiagent.plugin"));
    }

    private final String e(String r15) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r14 = true;
    L7:
        if (r14 == false) goto L10;
        return "";
    L10:
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == true) goto L44;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"), 0, false, 2, null) == true) goto L42;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'/'}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r16.iterator();
    L15:
        if (r17.hasNext() == false) goto L22;
        Object r5 = r17.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == false) goto L15;
        r4.add(r5);
        goto L15
    L19:
        r6 = false;
        goto L20
    L22:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        if (r18.isEmpty() == false) goto L25;
        return "";
    L25:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L27:
        if (r1.hasNext() == false) goto L40;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L38;
        if (d.h.b.o.a(r2, ".") == true) goto L36;
        if (d.h.b.o.a(r2, DownloadConstants.VULNERABILITY_PATH) == false) goto L27;
    L36:
        throw new i("Relative path must not contain '.' or '..' segments: '" + r15 + '\'');
    L38:
        throw new i("Relative path must not contain whitespace-only segments: '" + r15 + '\'');
    L40:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("/", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    L42:
        throw new i("Relative path must not contain NUL");
    L44:
        throw new i("Relative path must not start with '/': '" + r15 + '\'');
    L5:
        r14 = false;
        goto L7
    }

    private final String f(String r6) {
        if (r6.length() > 1) goto L5;
        return r6;
    L5:
        if (d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == true) goto L7;
        return r6;
    L7:
        return d.o.o.c(r6, new char[]{'/'});
    }
}
