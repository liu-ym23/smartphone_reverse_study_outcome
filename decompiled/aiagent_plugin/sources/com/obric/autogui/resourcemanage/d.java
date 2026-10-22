package com.obric.autogui.resourcemanage;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: DirectoryManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f30616a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f30617b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d.f f30618c = null;

    public static /* synthetic */ Keva lambda$Uhk4H5jvrePjV3jGY5csEU2OefM() {
        return c();
    }

    /* JADX INFO: renamed from: lambda$WbvvpNK2-WDLl1jr1SZ3VmOC4tE, reason: not valid java name */
    public static /* synthetic */ Keva m878lambda$WbvvpNK2WDLl1jr1SZ3VmOC4tE() {
        return d();
    }

    private d() {
    }

    static {
        f30616a = new d();
        f30617b = d.g.a($$Lambda$d$Uhk4H5jvrePjV3jGY5csEU2OefM.INSTANCE);
        f30618c = d.g.a($$Lambda$d$WbvvpNK2WDLl1jr1SZ3VmOC4tE.INSTANCE);
    }

    private final Keva a() {
        Object r2 = f30617b.b();
        d.h.b.o.c(r2, "getValue(...)");
        return (Keva) ZeusTransformUtils.preCheckCast(r2, Keva.class, "com.obric.aiagent.plugin");
    }

    private static final Keva c() {
        return Keva.getRepo("resource_manager_description", 0);
    }

    private final Keva b() {
        Object r2 = f30618c.b();
        d.h.b.o.c(r2, "getValue(...)");
        return (Keva) ZeusTransformUtils.preCheckCast(r2, Keva.class, "com.obric.aiagent.plugin");
    }

    private static final Keva d() {
        return Keva.getRepo("resource_manager_strategy", 0);
    }

    public final File a(Context r2, p r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        d.h.b.o.e(r3, "config");
        File r4 = new File(r1.getFilesDir(), r3.f());
        if (r4.exists() == false) goto L5;
    L11:
        return r4;
    L5:
        if (r4.mkdirs() == true) goto L11;
        if (r4.exists() == true) goto L11;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L11;
        Loog.INSTANCE.d("resource_downloader", "ensureBaseDir: mkdirs failed: " + r4.getAbsolutePath());
        goto L11
    }

    public final void a(Context r3, o r4, p r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "context");
        d.h.b.o.e(r4, "description");
        d.h.b.o.e(r5, "config");
        File r7 = r4.b(new File(r6.getFilesDir(), r5.f()));
        a().storeString(b(r4.d()), r7.getAbsolutePath());
        a().storeString(c(r4.d()), r4.i());
    }

    public final void a(o r3) {
        d.h.b.o.e(r3, "description");
        a().erase(b(r3.d()));
        a().erase(c(r3.d()));
    }

    public final void b(Context r3, o r4, p r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "context");
        d.h.b.o.e(r4, "description");
        d.h.b.o.e(r5, "config");
        File r7 = r4.b(new File(r6.getFilesDir(), r5.f()));
        if (r7.exists() == false) goto L6;
        a(r7);
        return;
    }

    public final n a(Context r7, String r8, String r9, String r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "context");
        d.h.b.o.e(r8, "packageName");
        d.h.b.o.e(r9, "baseDirName");
        d.h.b.o.e(r10, "appPkg");
        o r0 = a(r8);
        String r2 = b(r8);
        String r4 = null;
        String r3 = a().getString(r2, null);
        File r5 = new File(r11.getFilesDir(), r9);
        if (r3 != null) goto L5;
    L12:
        if (r0 == null) goto L14;
        File r12 = r0.b(r5);
    L15:
        List<String> r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        List<String> r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        a(r12, r13, r6);
        if (r12.exists() == false) goto L18;
        List r14 = d.a.p.a(r12.getAbsolutePath());
    L20:
        if (r14.isEmpty() == false) goto L22;
        a().erase(r2);
        a().erase(c(r8));
    L22:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(a(r8, r10, r0), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L24:
        if (r15.hasNext() == false) goto L27;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");
        d r1 = f30616a;
        r1.b().erase(r1.d(r16));
        r1.b().erase(r1.e(r16));
        r1.b().erase(r1.f(r16));
        r1.b().erase(r1.g(r16));
        r1.b().erase(r1.h(r16));
        goto L24
    L27:
        return new n(r8, r13, r6, r14);
    L18:
        r14 = d.a.p.b();
        goto L20
    L14:
        r12 = new File(new File(r5, r8), "install");
        goto L15
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L7;
        boolean r17 = true;
    L8:
        if (r17 == false) goto L10;
        r4 = r3;
    L10:
        if (r4 == null) goto L12;
        r12 = new File(r4);
        goto L15
    L7:
        r17 = false;
        goto L8
    }

    private final void a(File r6, List<String> r7, List<String> r8) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (r6.exists() == true) goto L23;
        return;
    L23:
        boolean r10 = Files.isSymbolicLink(r6.toPath());     // Catch: Exception -> L7
    L9:
        if (r6.isDirectory() == false) goto L17;
        if (r10 == true) goto L17;
        File[] r11 = r6.listFiles();
        if (r11 == null) goto L17;
        int r1 = 0;
        int r2 = r11.length;
    L14:
        if (r1 >= r2) goto L17;
        File r3 = r11[r1];
        d r4 = f30616a;
        d.h.b.o.a(r3);
        r4.a(r3, r5, r9);
        r1 = r1 + 1;
    L17:
        if (r6.delete() == false) goto L20;
        ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).add(r6.getAbsolutePath());
        return;
    L20:
        if (r6.exists() == false) goto L27;
        ((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).add(r6.getAbsolutePath());
        return;
    L27:
        return;
    L7:
        r10 = true;
        goto L9
    }

    public final File a(Context r3, String r4) {
        d.h.b.o.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "context");
        d.h.b.o.e(r4, "packageName");
        String r2 = a().getString(b(r4), null);
        if (r2 != null) goto L6;
        return null;
    L6:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == true) goto L11;
        File r6 = new File(r2);
        if (r6.isDirectory() == true) goto L17;
        return null;
    L17:
        return r6;
    L11:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L13;
        Loog.INSTANCE.d("resource_downloader", "getCurrentInstallDir: installDirPath empty for pkg=" + r4);
    L13:
        return null;
    L8:
        r5 = false;
        goto L9
    }

    public final o a(String r5) {
        d.h.b.o.e(r5, "packageName");
        String r4 = a().getString(c(r5), null);
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L18;
        return null;
    L18:
        return o.f30643a.a(r4);
    L13:
        e = move-exception;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L20;
        Loog.INSTANCE.d("resource_downloader", "getCurrentDescription: parse failed for pkg=" + r5 + ", error=" + e);
        return null;
    L20:
        return null;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private final String b(String r2) {
        return "current_key_" + r2;
    }

    private final String c(String r2) {
        return "description_json_" + r2;
    }

    private final Set<String> a(String r3, String r4, o r5) {
        boolean r2 = true;
        Set<String> r6 = ax.b(new String[]{r3 + '#' + r4});
        if (r5 == null) goto L17;
        v r7 = r5.a();
        if (r7 == null) goto L17;
        String r8 = r7.b();
        if (r8 == null) goto L17;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L12;
        r2 = false;
    L12:
        if (r2 == true) goto L15;
        r8 = null;
    L15:
        if (r8 == null) goto L17;
        r6.add(r8);
    L17:
        return r6;
    }

    public final long a(v r6) {
        d.h.b.o.e(r6, "requestParams");
        long r0 = b().getLong(f(r6.b()), 0);
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        return b().getLong(d(r6.b()), 0);
    }

    public final long b(v r4) {
        d.h.b.o.e(r4, "requestParams");
        return b().getLong(e(r4.b()), 0);
    }

    public final void a(v r2, long r3) {
        d.h.b.o.e(r2, "requestParams");
        b().storeLong(e(r2.b()), r3);
    }

    public final void b(v r3, long r4) {
        d.h.b.o.e(r3, "requestParams");
        b().storeLong(f(r3.b()), r4);
        b().storeLong(d(r3.b()), r4);
    }

    public final void c(v r2, long r3) {
        d.h.b.o.e(r2, "requestParams");
        b().storeLong(g(r2.b()), r3);
    }

    public final void d(v r2, long r3) {
        d.h.b.o.e(r2, "requestParams");
        b().storeLong(h(r2.b()), r3);
    }

    private final String d(String r2) {
        return "last_request_" + r2;
    }

    private final String e(String r2) {
        return "last_config_attempt_" + r2;
    }

    private final String f(String r2) {
        return "last_check_success_" + r2;
    }

    private final String g(String r2) {
        return "last_download_success_" + r2;
    }

    private final String h(String r2) {
        return "last_install_success_" + r2;
    }

    private final void a(File r5) {
        if (r5.isDirectory() == false) goto L9;
        File[] r4 = r5.listFiles();
        if (r4 == null) goto L9;
        int r0 = 0;
        int r1 = r4.length;
    L7:
        if (r0 >= r1) goto L9;
        File r2 = r4[r0];
        d r3 = f30616a;
        d.h.b.o.a(r2);
        r3.a(r2);
        r0 = r0 + 1;
    L9:
        r5.delete();
    }
}
