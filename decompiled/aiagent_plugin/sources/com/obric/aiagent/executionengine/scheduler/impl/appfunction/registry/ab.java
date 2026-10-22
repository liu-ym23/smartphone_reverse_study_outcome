package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AppFunctionSkillMarkdownEditor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ab {
    private static final String TAG = "AppFunctionSkillMarkdown";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ab f18205a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Gson f18206b = null;

    private ab() {
    }

    static {
        f18205a = new ab();
        f18206b = new GsonBuilder().disableHtmlEscaping().create();
    }

    public final String a(String r14, String r15) {
        d.h.b.o.e(r14, "markdown");
        d.h.b.o.e(r15, "packageName");
        List r16 = d.a.p.g((Collection) ZeusTransformUtils.preCheckCast(d.o.o.g((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.b(d.o.o.a(d.o.o.a(r14, "\r\n", "\n", false, 4, null), '\r', '\n', false, 4, null), new char[]{65279, '\n'}), CharSequence.class, "com.obric.aiagent.plugin")), Collection.class, "com.obric.aiagent.plugin"));
        String r0 = (String) ZeusTransformUtils.preCheckCast(d.a.p.l(r16), String.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        String r1 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L7:
        if (d.h.b.o.a(r1, "---") == true) goto L10;
        ILogDepend.Companion.w(TAG, "invalid frontmatter boundary, package=" + r15);
        return null;
    L10:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(d.l.n.b(1, r16.size()), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r2.hasNext() == false) goto L26;
        Object r6 = r2.next();
        int r8 = ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue();
        Character r9 = d.o.o.i((CharSequence) ZeusTransformUtils.preCheckCast(r16.get(r8), CharSequence.class, "com.obric.aiagent.plugin"));
        if (r9 != null) goto L16;
    L18:
        boolean r10 = false;
    L19:
        if (r10 == false) goto L21;
    L23:
        boolean r11 = false;
    L24:
        if (r11 == false) goto L12;
    L27:
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L63;
        int r4 = r3.intValue();
        String r13 = a(r15);
        if (r13 != null) goto L32;
        return null;
    L32:
        int r5 = r4 - 1;
    L33:
        if (r5 < 1) goto L61;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.get(r5), String.class, "com.obric.aiagent.plugin");
        Character r7 = d.o.o.i((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r7 != null) goto L37;
    L39:
        boolean r12 = false;
    L40:
        if (r12 == false) goto L42;
    L44:
        boolean r18 = false;
    L45:
        if (r18 == false) goto L60;
        int r19 = r5 + 1;
    L48:
        if (r19 >= r16.size()) goto L59;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r16.get(r19), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L58;
        Character r20 = d.o.o.i((CharSequence) ZeusTransformUtils.preCheckCast(r16.get(r19), CharSequence.class, "com.obric.aiagent.plugin"));
        if (r20 != null) goto L54;
    L56:
        boolean r21 = false;
    L57:
        if (r21 == false) goto L59;
    L54:
        if (d.o.a.a(r20.charValue()) != true) goto L56;
        r21 = true;
    L58:
        r19 = r19 + 1;
    L59:
        r16.subList(r5, r19).clear();
    L60:
        r5 = r5 - 1;
        goto L33
    L42:
        if (d.o.o.a(d.o.o.c(d.o.o.c(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a(r17, ':', ""), CharSequence.class, "com.obric.aiagent.plugin")).toString(), (CharSequence) ZeusTransformUtils.preCheckCast("\"", CharSequence.class, "com.obric.aiagent.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast("'", CharSequence.class, "com.obric.aiagent.plugin")), "display_name", true) == false) goto L44;
        r18 = true;
        goto L45
    L37:
        if (d.o.a.a(r7.charValue()) != true) goto L39;
        r12 = true;
        goto L40
    L61:
        r16.add(1, "display_name: " + f18206b.toJson(r13));
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    L63:
        ab r110 = (ab) ZeusTransformUtils.preCheckCast(this, ab.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.w(TAG, "frontmatter is not closed, package=" + r15);
        return null;
    L21:
        if (d.h.b.o.a(d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r16.get(r8), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString(), "---") == false) goto L23;
        r11 = true;
        goto L24
    L16:
        if (d.o.a.a(r9.charValue()) != true) goto L18;
        r10 = true;
        goto L19
    L26:
        r6 = null;
        goto L27
    L5:
        r1 = null;
        goto L7
    }

    public final String a(String r5) {
        d.h.b.o.e(r5, "packageName");
        PackageManager r4 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager();
        ApplicationInfo r1 = r4.getApplicationInfo(r5, 0);     // Catch: Exception -> L7
        d.h.b.o.c(r1, "getApplicationInfo(...)");     // Catch: Exception -> L7
        String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4.getApplicationLabel(r1).toString(), CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Exception -> L7
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L13;
        return null;
    L13:
        return r6;
    L7:
        e = move-exception;
        ILogDepend.Companion.w(TAG, "read app name failed, package=" + r5 + ": " + e.getMessage());
        return null;
    }
}
