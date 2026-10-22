package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: SkillFileInputPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum bw extends Enum<bw> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bw f19620a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bw f19621b = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ bw[] f19622e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<String> f19623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<String> f19624d;

    private static final /* synthetic */ bw[] c() {
        return new bw[]{f19620a, f19621b};
    }

    private bw(String r3, int r4, Set r5, List r6) {
        Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        super(r3, r4);
        this.f19623c = r7;
        this.f19624d = r8;
    }

    public final List<String> a() {
        return this.f19624d;
    }

    static {
        f19620a = new bw("PACKAGE_IMPORT", 0, d.a.ax.a(new String[]{".md", ".zip"}), d.a.p.b(new String[]{"text/markdown", "application/zip", "application/x-zip-compressed"}));
        f19621b = new bw("MARKDOWN_FORM", 1, d.a.ax.a(".md"), d.a.p.a("text/markdown"));
        bw[] r0 = c();
        f19622e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public final String b() {
        String r2 = (String) ZeusTransformUtils.preCheckCast(d.a.p.p(this.f19624d), String.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L6;
        return "*/*";
    L6:
        return r2;
    }

    public final boolean a(String r6) {
        d.h.b.o.e(r6, "fileName");
        Locale r0 = Locale.US;
        d.h.b.o.c(r0, "US");
        String r7 = r6.toLowerCase(r0);
        d.h.b.o.c(r7, "toLowerCase(...)");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.f19623c, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r5.iterator();
    L9:
        if (r8.hasNext() == false) goto L18;
        if (d.o.o.c(r7, (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return false;
    }

    public static bw valueOf(String r2) {
        return (bw) ZeusTransformUtils.preCheckCast(Enum.valueOf(bw.class, r2), bw.class, "com.obric.aiagent.plugin");
    }

    public static bw[] values() {
        return (bw[]) ZeusTransformUtils.preCheckCast(f19622e.clone(), bw[].class, "com.obric.aiagent.plugin");
    }
}
