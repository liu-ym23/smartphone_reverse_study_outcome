package com.obric.aiagent.product.a;

import aiassistant.version.AssistantVersion;
import com.aiassistant.utils.AssistantFeatureValidator;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.utils.ObricFeatureValidator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import obric.version.ObricVersion;

/* JADX INFO: compiled from: OsFeatureUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18770a = null;

    static {
        f18770a = new b();
    }

    private b() {
    }

    public final boolean a() {
        if (b() < 10) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean a(String r3) {
        o.e(r3, "osFeatures");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return true;
    L9:
        if (a() == false) goto L12;
        return AssistantFeatureValidator.hasFeature(r3);
    L12:
        return ObricFeatureValidator.hasFeature(r3);
    L5:
        r0 = false;
        goto L6
    }

    public final boolean a(List<String> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "osFeatures");
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L5;
        return true;
    L5:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L8;
    L10:
        Iterator r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L21;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");
        if (f18770a.a(r7) == true) goto L12;
        return false;
    L21:
        return true;
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L10;
        return true;
    }

    public final int b() {
        int r1 = AssistantVersion.getVersion();     // Catch: Throwable -> L5
    L11:
        ILogDepend.Companion r2 = ILogDepend.Companion;
        String r0 = b.class.getSimpleName();
        o.c(r0, "getSimpleName(...)");
        r2.i(r0, "getObricApiVersion, version: " + r1);
        return r1;
    L5:
        th = move-exception;
        ILogDepend.Companion r3 = ILogDepend.Companion;
        String r4 = b.class.getSimpleName();
        o.c(r4, "getSimpleName(...)");
        r3.i(r4, "getAssistantVersion failed, e: " + th);
        r1 = ObricVersion.getVersion();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        ILogDepend.Companion r5 = ILogDepend.Companion;
        String r6 = b.class.getSimpleName();
        o.c(r6, "getSimpleName(...)");
        r5.w(r6, "getObricVersion failed, e: " + th);
        r1 = -1;
        goto L11
    }
}
