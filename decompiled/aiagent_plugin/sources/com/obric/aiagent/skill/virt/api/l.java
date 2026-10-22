package com.obric.aiagent.skill.virt.api;

import com.bytedance.apm.battery.dao.DBHelper;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: ShellCommandSummary.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f21577a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f21578b = null;

    private l() {
    }

    public final m a(String r7) {
        d.h.b.o.e(r7, "command");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(b(r7), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r0.add(d.o.o.c((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.aiagent.plugin"), '/', null, 2, null));
        goto L4
    L6:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L12;
        Object r2 = r11.next();
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
        if (f21577a.c(r3) == false) goto L8;
        r1.add(r2);
        goto L8
    L12:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(d.a.p.l(r12), String.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L16;
        r4 = "other";
    L16:
        return new m(r4, d(r4), d.l.n.d(r12.size(), 8));
    }

    private final List<String> b(String r15) {
        String r14 = d.o.o.e(r15, 512);
        ArrayList r16 = new ArrayList(8);
        StringBuilder r1 = new StringBuilder();
        d.h.b.z.a r2 = new d.h.b.z.a();
        r2.f38499a = true;
        d.h.b.z.a r4 = new d.h.b.z.a();
        r4.f38499a = true;
        int r5 = r14.length();
        Character r10 = null;
        int r8 = 0;
        boolean r9 = false;
    L4:
        if (r8 >= r5) goto L58;
        char r12 = r14.charAt(r8);
        if (r16.size() >= 8) goto L58;
        if (r9 == false) goto L13;
        if (r4.f38499a == false) goto L11;
        r1.append(r12);
    L11:
        r9 = false;
    L57:
        r8 = r8 + 1;
        goto L4
    L13:
        if (r12 != '\\') goto L15;
        r9 = true;
        goto L57
    L15:
        if (r10 == null) goto L23;
        if (r12 != r10.charValue()) goto L20;
        r10 = null;
        goto L57
    L20:
        if (r4.f38499a == false) goto L57;
        r1.append(r12);
        goto L57
    L23:
        if (r12 != '\t') goto L25;
    L54:
        a(r1, r2, r4, r16);
        if (r2.f38499a == false) goto L57;
        r4.f38499a = true;
        goto L57
    L25:
        if (r12 == '\n') goto L54;
        if (r12 == '\r') goto L54;
        if (r12 == ' ') goto L54;
        if (r12 != '\"') goto L33;
    L53:
        r10 = Character.valueOf(r12);
        r4.f38499a = false;
        goto L57
    L33:
        if (r12 != ';') goto L35;
    L52:
        a(r1, r2, r4, r16);
        r2.f38499a = true;
        r4.f38499a = true;
        goto L57
    L35:
        if (r12 != '=') goto L37;
        r4.f38499a = false;
        r1.append(r12);
        goto L57
    L37:
        if (r12 == '|') goto L52;
        if (r12 == '&') goto L52;
        if (r12 == '\'') goto L53;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L45;
        boolean r11 = true;
    L46:
        if (r11 == false) goto L49;
        r4.f38499a = r2.f38499a;
    L49:
        if (r4.f38499a == false) goto L57;
        r1.append(r12);
        goto L57
    L45:
        r11 = false;
    L58:
        a(r1, r2, r4, r16);
        return (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin");
    }

    private static final void a(StringBuilder r8, d.h.b.z.a r9, d.h.b.z.a r10, ArrayList<String> r11) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        String r1 = r8.toString();
        d.h.b.o.c(r1, "toString(...)");
        if (r9.f38499a == true) goto L11;
    L19:
        d.o.o.a(r8);
        r10.f38499a = false;
        return;
    L11:
        if (r10.f38499a == false) goto L19;
        if (f21578b.contains(r1) == false) goto L15;
    L18:
        r9.f38499a = true;
        goto L19
    L15:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("=", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L18;
        ((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")).add(r1);
        r9.f38499a = false;
        goto L19
    L5:
        r0 = false;
        goto L6
    }

    private final boolean c(String r5) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return false;
    L5:
        if (r5.length() > 64) goto L30;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        int r6 = 0;
    L8:
        boolean r2 = true;
        if (r6 >= r4.length()) goto L26;
        char r0 = r4.charAt(r6);
        if (Character.isLetterOrDigit(r0) == false) goto L13;
    L22:
        if (r2 == false) goto L31;
        r6 = r6 + 1;
        goto L8
    L31:
        return false;
    L13:
        if (r0 == '_') goto L22;
        if (r0 == '-') goto L22;
        if (r0 == '.') goto L22;
        if (r0 == '+') goto L22;
        r2 = false;
        goto L22
    L26:
        return true;
    L30:
        return false;
    }

    private final String d(String r3) {
        Locale r2 = Locale.US;
        d.h.b.o.c(r2, "US");
        String r4 = r3.toLowerCase(r2);
        d.h.b.o.c(r4, "toLowerCase(...)");
        switch(r4.hashCode()) {
            case -1497521855: goto L118;
            case -1289153612: goto L114;
            case -979983527: goto L111;
            case -973197092: goto L107;
            case -896505829: goto L104;
            case -104338729: goto L101;
            case 46: goto L98;
            case 3169: goto L95;
            case 3399: goto L91;
            case 3463: goto L87;
            case 3788: goto L84;
            case 97013: goto L81;
            case 98262: goto L77;
            case 109291: goto L73;
            case 109302: goto L70;
            case 110999: goto L67;
            case 111421: goto L64;
            case 113746: goto L61;
            case 3065388: goto L57;
            case 3107365: goto L54;
            case 3143097: goto L51;
            case 3181270: goto L48;
            case 3198432: goto L45;
            case 3318169: goto L42;
            case 3357525: goto L39;
            case 3386882: goto L36;
            case 3441020: goto L33;
            case 3445883: goto L30;
            case 3536286: goto L27;
            case 3552336: goto L24;
            case 3556498: goto L21;
            case 3568542: goto L18;
            case 3594625: goto L15;
            case 3647359: goto L12;
            case 3701572: goto L9;
            case 106069776: goto L6;
            default: goto L121;
        };
    L121:
        return MonitorConstants.CUSTOM;
    L6:
        if (r4.equals("other") == false) goto L121;
        return "other";
    L9:
        if (r4.equals("yarn") == false) goto L121;
    L75:
        return "package_manager";
    L12:
        if (r4.equals("wget") == false) goto L121;
    L59:
        return "http";
    L15:
        if (r4.equals("uniq") == false) goto L121;
    L93:
        return "text_process";
    L18:
        if (r4.equals("tree") == false) goto L121;
    L89:
        return "file_list";
    L21:
        if (r4.equals("test") == false) goto L121;
    L116:
        return "shell_builtin";
    L24:
        if (r4.equals("tail") == false) goto L121;
    L79:
        return "file_read";
    L27:
        if (r4.equals("sort") == true) goto L93;
    L30:
        if (r4.equals("pnpm") == true) goto L75;
    L33:
        if (r4.equals("pip3") == false) goto L121;
    L129:
        return "python";
    L36:
        if (r4.equals("node") == true) goto L75;
    L39:
        if (r4.equals("more") == true) goto L79;
    L42:
        if (r4.equals("less") == true) goto L79;
    L45:
        if (r4.equals("head") == true) goto L79;
    L48:
        if (r4.equals("grep") == true) goto L93;
    L51:
        if (r4.equals("find") == true) goto L89;
    L54:
        if (r4.equals("echo") == true) goto L116;
    L57:
        if (r4.equals("curl") == true) goto L59;
    L61:
        if (r4.equals("sed") == true) goto L93;
    L64:
        if (r4.equals("pwd") == true) goto L89;
    L67:
        if (r4.equals("pip") == true) goto L129;
    L70:
        if (r4.equals("npx") == true) goto L75;
    L73:
        if (r4.equals("npm") == true) goto L75;
    L77:
        if (r4.equals("cat") == true) goto L79;
    L81:
        if (r4.equals("awk") == true) goto L93;
    L84:
        if (r4.equals("wc") == true) goto L93;
    L87:
        if (r4.equals("ls") == true) goto L89;
    L91:
        if (r4.equals("jq") == true) goto L93;
    L95:
        if (r4.equals("cd") == true) goto L116;
    L98:
        if (r4.equals(".") == true) goto L116;
    L101:
        if (r4.equals("python3") == true) goto L129;
    L104:
        if (r4.equals(DBHelper.BATTERY_COL_SOURCE) == true) goto L116;
    L107:
        if (r4.equals("python") == true) goto L129;
    L111:
        if (r4.equals("printf") == true) goto L116;
    L114:
        if (r4.equals("export") == true) goto L116;
    L118:
        if (r4.equals("lark-cli") == false) goto L121;
        return "lark_cli";
    }

    static {
        f21577a = new l();
        f21578b = ax.a(new String[]{"env", "command", "time", "sudo"});
    }
}
