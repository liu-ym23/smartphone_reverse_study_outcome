package com.bytedance.ai.applet.login;

import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes43.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f34781a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, b> f34782b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static WeakReference<f> f34783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CoroutineScope f34784d = null;

    public p() {
    }

    static {
        f34781a = new p();
        f34782b = new LinkedHashMap();
        f34783c = new WeakReference(null);
        f34784d = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static void b(String r100) {
        if (f2.k.b() != null) goto L6;
        com.bytedance.ai.utils.g.f37637a.e("McpLoginManager", "Top activity is null");
        return;
    L6:
        b r101 = (b) ((LinkedHashMap) f34782b).get(r100);
        com.bytedance.ai.utils.g.f37637a.e("McpLoginManager", "loadAddShowWidget: renderContext is null");
    }

    public static final void a(p r100, String r101, o r102) {
        r100.getClass();
        LinkedHashMap r103 = (LinkedHashMap) f34782b;
        if (((b) r103.get(r101)) != null) goto L5;
        com.bytedance.ai.utils.g.f37637a.e("McpLoginManager", "transitionTo: Can not find loginContext: " + r101);
        return;
    L5:
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        com.bytedance.ai.utils.g r104 = com.bytedance.ai.utils.g.f37637a;
        r104.i("McpLoginManager", "Applet [" + r101 + "] transitioned to " + r102);
        if ((r102 instanceof o.d) == false) goto L9;
        b(r101);
        return;
    L9:
        if ((r102 instanceof o.c) == false) goto L12;
        b(r101);
        return;
    L12:
        if ((r102 instanceof o.a) == false) goto L15;
        b(r101);
        return;
    L15:
        if ((r102 instanceof o.b) == false) goto L22;
        r104.i("McpLoginManager", "finishLoginProcessing reason: " + ((o.b) r102).f34778a.getDescription());
        b r105 = (b) r103.get(r101);
        r104.e("McpLoginManager", "finishLoginProcessing: messageId is null");
        return;
    }
}
