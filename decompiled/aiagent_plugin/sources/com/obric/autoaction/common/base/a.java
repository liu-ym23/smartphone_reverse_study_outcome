package com.obric.autoaction.common.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.obric.autoaction.common.ext.DarkModeExtension;
import com.obric.autoaction.common.ext.FragmentPageReportExtension;
import com.obric.autoaction.common.ext.PageReportExtension;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ExtensionHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class<? extends b>, b> f24634a;

    public a() {
        this.f24634a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public final <C extends b> void a(C r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "config");
        this.f24634a.put((Class<? extends b>) r4.getClass(), r4);
    }

    private final <C extends b> C b(C r3) {
        C r4 = (C) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        b r2 = this.f24634a.get(r4.getClass());
        if (ZeusTransformUtils.instanceOf(r2, b.class) == false) goto L5;
        b r5 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin");
    L6:
        if (r5 != null) goto L9;
        return r4;
    L9:
        return (C) r5;
    L5:
        r5 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [com.obric.autoaction.common.base.b] */
    public final void a(AppCompatActivity r9) {
        AppCompatActivity r10 = (AppCompatActivity) ZeusTransformUtils.wrapperContextForParams(r9, AppCompatActivity.class, "com.obric.aiagent.plugin");
        o.e(r10, "host");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(p.b(new ActivityExtension[]{new DarkModeExtension((com.obric.autoaction.common.ext.a) ZeusTransformUtils.preCheckCast(b((b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.common.ext.a(false, 1, null), b.class, "com.obric.aiagent.plugin")), com.obric.autoaction.common.ext.a.class, "com.obric.aiagent.plugin"), r10), new PageReportExtension((com.obric.autoaction.common.ext.b) ZeusTransformUtils.preCheckCast(b((b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.common.ext.b(null, false, 3, null), b.class, "com.obric.aiagent.plugin")), com.obric.autoaction.common.ext.b.class, "com.obric.aiagent.plugin"), r10)}), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r2 = r11.next();
        if (((ActivityExtension) ZeusTransformUtils.preCheckCast(r2, ActivityExtension.class, "com.obric.aiagent.plugin")).a().a() == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        r10.getLifecycle().a((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast((ActivityExtension) ZeusTransformUtils.preCheckCast(r12.next(), ActivityExtension.class, "com.obric.aiagent.plugin"), androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));
        goto L10
    }

    public final void a(Fragment r6) {
        o.e(r6, "host");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(p.a(new FragmentPageReportExtension((com.obric.autoaction.common.ext.b) ZeusTransformUtils.preCheckCast(b((b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.common.ext.b(null, false, 3, null), b.class, "com.obric.aiagent.plugin")), com.obric.autoaction.common.ext.b.class, "com.obric.aiagent.plugin"), r6)), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        Object r1 = r7.next();
        if (((com.obric.autoaction.common.ext.b) ZeusTransformUtils.preCheckCast(((FragmentPageReportExtension) ZeusTransformUtils.preCheckCast(r1, FragmentPageReportExtension.class, "com.obric.aiagent.plugin")).a(), com.obric.autoaction.common.ext.b.class, "com.obric.aiagent.plugin")).a() == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r8.hasNext() == false) goto L12;
        FragmentPageReportExtension r2 = (FragmentPageReportExtension) ZeusTransformUtils.preCheckCast(r8.next(), FragmentPageReportExtension.class, "com.obric.aiagent.plugin");
        r6.getLifecycle().a((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast(r2, androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));
        goto L10
    }
}
