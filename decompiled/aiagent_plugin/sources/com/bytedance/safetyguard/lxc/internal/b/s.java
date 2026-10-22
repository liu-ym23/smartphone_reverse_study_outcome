package com.bytedance.safetyguard.lxc.internal.b;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import java.net.IDN;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: TargetNormalizer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f9797a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<Character> f9798b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d.o.k f9799c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final d.o.k f9800d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final d.o.k f9801e = null;
    private static final d.o.k f = null;
    private static final d.o.k g = null;

    /* JADX INFO: compiled from: TargetNormalizer.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9802a = null;

        static {
            int[] r0 = new int[com.bytedance.safetyguard.lxc.internal.c.m.values().length];
            r0[com.bytedance.safetyguard.lxc.internal.c.m.f9854c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[com.bytedance.safetyguard.lxc.internal.c.m.f9855d.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[com.bytedance.safetyguard.lxc.internal.c.m.f9853b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f9802a = r0;
        }
    }

    private s() {
    }

    public final g a(o r6) {
        o r7 = (o) ZeusTransformUtils.wrapperContextForParams(r6, o.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "target");
        if (ZeusTransformUtils.instanceOf(r7, o.a.class) == false) goto L6;
        return (g) ZeusTransformUtils.preCheckCast(new g.a(a(((o.a) ZeusTransformUtils.preCheckCast(r7, o.a.class, "com.obric.aiagent.plugin")).b()), r7.a()), g.class, "com.obric.aiagent.plugin");
    L6:
        if (ZeusTransformUtils.instanceOf(r7, o.b.class) == false) goto L22;
        com.bytedance.safetyguard.lxc.internal.c.m r5 = ((o.b) ZeusTransformUtils.preCheckCast(r7, o.b.class, "com.obric.aiagent.plugin")).getType();
        int r8 = a.f9802a[r5.ordinal()];
        if (r8 != 1) goto L10;
        InetAddress r9 = InetAddress.getByAddress(((o.b) ZeusTransformUtils.preCheckCast(r7, o.b.class, "com.obric.aiagent.plugin")).b());
    L19:
        d.h.b.o.a(r9);
        byte[] r2 = ((o.b) ZeusTransformUtils.preCheckCast(r7, o.b.class, "com.obric.aiagent.plugin")).b();
        byte[] r3 = Arrays.copyOf(r2, r2.length);
        d.h.b.o.c(r3, "copyOf(...)");
        return (g) ZeusTransformUtils.preCheckCast(new g.b(r9, r3, r7.a(), ((o.b) ZeusTransformUtils.preCheckCast(r7, o.b.class, "com.obric.aiagent.plugin")).getType()), g.class, "com.obric.aiagent.plugin");
    L10:
        if (r8 != 2) goto L12;
        r9 = (InetAddress) ZeusTransformUtils.preCheckCast(Inet6Address.getByAddress(null, ((o.b) ZeusTransformUtils.preCheckCast(r7, o.b.class, "com.obric.aiagent.plugin")).b(), -1), InetAddress.class, "com.obric.aiagent.plugin");
        goto L19
    L12:
        if (r8 == 3) goto L16;
        throw new d.k();
    L16:
        throw new t("Domain target cannot contain IP address bytes", null, 2, null);
    L22:
        throw new d.k();
    }

    public final String a(String r15) {
        d.h.b.o.e(r15, "domain");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L86;
        if (r15.length() > 253) goto L84;
        if (d.o.o.h((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin")) == '.') goto L82;
        if (d.o.o.j((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin")) == '.') goto L82;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(DownloadConstants.VULNERABILITY_PATH, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L80;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin");
        int r8 = 0;
    L18:
        if (r8 >= r1.length()) goto L87;
        char r10 = r1.charAt(r8);
        if (Character.isISOControl(r10) == true) goto L29;
        if (d.o.a.a(r10) == true) goto L29;
        if (f9798b.contains(Character.valueOf(r10)) == true) goto L27;
        r8 = r8 + 1;
        goto L18
    L27:
        throw new t("Domain contains a non-host character", null, 2, null);
    L29:
        throw new t("Domain contains control or whitespace characters", null, 2, null);
    L87:
        String r16 = IDN.toASCII(r15, 2);     // Catch: IllegalArgumentException -> L76
        d.h.b.o.c(r16, "toASCII(...)");     // Catch: IllegalArgumentException -> L76
        Locale r2 = Locale.US;     // Catch: IllegalArgumentException -> L76
        d.h.b.o.c(r2, "US");     // Catch: IllegalArgumentException -> L76
        String r17 = r16.toLowerCase(r2);     // Catch: IllegalArgumentException -> L76
        d.h.b.o.c(r17, "toLowerCase(...)");     // Catch: IllegalArgumentException -> L76
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L34;
        boolean r3 = true;
    L35:
        if (r3 == true) goto L75;
        if (r17.length() > 253) goto L75;
        if (d.o.o.h((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin")) == '.') goto L73;
        if (d.o.o.j((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin")) == '.') goto L73;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(DownloadConstants.VULNERABILITY_PATH, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L73;
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'.'}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L46:
        if (r4.hasNext() == false) goto L68;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin");
        int r7 = r6.length();
        if (1 <= r7) goto L50;
    L52:
        boolean r9 = false;
    L53:
        if (r9 == false) goto L66;
        if (d.o.o.h((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == '-') goto L64;
        if (d.o.o.j((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == '-') goto L64;
        if (f9799c.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L46;
        throw new t("Domain label contains invalid characters", null, 2, null);
    L64:
        throw new t("Domain label must not start or end with '-'", null, 2, null);
    L66:
        throw new t("Domain label length is invalid", null, 2, null);
    L50:
        if (r7 >= 64) goto L52;
        r9 = true;
        goto L53
    L68:
        if (b(r17) == true) goto L71;
        return r17;
    L71:
        throw new t("Ambiguous numeric IP form is not a domain", null, 2, null);
    L73:
        throw new t("Normalized domain contains an empty label", null, 2, null);
    L75:
        throw new t("Normalized domain length is invalid", null, 2, null);
    L34:
        r3 = false;
    L76:
        e = move-exception;
        throw new t("Domain is not valid IDN", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L80:
        throw new t("Domain contains an empty label", null, 2, null);
    L82:
        throw new t("Domain must not start or end with a dot", null, 2, null);
    L84:
        throw new t("Domain input is too long", null, 2, null);
    L86:
        throw new t("Domain must not be empty", null, 2, null);
    L5:
        r0 = false;
        goto L7
    }

    private final boolean b(String r3) {
        if (f9800d.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
    L12:
        return true;
    L5:
        if (f9801e.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L12;
        if (f.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L12;
        if (g.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L12;
        return false;
    }

    static {
        f9797a = new s();
        f9798b = ax.a(new Character[]{'@', '/', '\\', ':', '[', ']', '#', '?', '%'});
        f9799c = new d.o.k("[a-z0-9-]+");
        f9800d = new d.o.k("[0-9.]+");
        f9801e = new d.o.k("0x[0-9a-f]+");
        f = new d.o.k("(?=.*[0-9])(?=.*[a-f])[0-9a-f]{8}");
        g = new d.o.k("(?:0x[0-9a-f]+|[0-9]+)(?:\\.(?:0x[0-9a-f]+|[0-9]+))+");
    }
}
