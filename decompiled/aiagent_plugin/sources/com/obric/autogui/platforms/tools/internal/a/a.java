package com.obric.autogui.platforms.tools.internal.a;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.platforms.tools.internal.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;
import d.n;

/* JADX INFO: compiled from: ReflectedClipboardManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "ReflectedClipboardManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30337a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f30338b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f f30339c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final f f30340d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final f f30341e = null;
    private static final f f = null;

    /* JADX INFO: renamed from: lambda$Clb-po9RnOTKumjA1sfAIlMSj1s, reason: not valid java name */
    public static /* synthetic */ c m866lambda$Clbpo9RnOTKumjA1sfAIlMSj1s() {
        return j();
    }

    /* JADX INFO: renamed from: lambda$FuSlvjB7sEVbTqDpC-7Q8TwkYpA, reason: not valid java name */
    public static /* synthetic */ c m867lambda$FuSlvjB7sEVbTqDpC7Q8TwkYpA() {
        return i();
    }

    /* JADX INFO: renamed from: lambda$Q5j-sNrxdkefqprP2etJSydjMkU, reason: not valid java name */
    public static /* synthetic */ c m868lambda$Q5jsNrxdkefqprP2etJSydjMkU() {
        return k();
    }

    public static /* synthetic */ c lambda$kNpAj5TvQpohxp0XWERS3j7Be9E() {
        return h();
    }

    /* JADX INFO: renamed from: lambda$wUsxm0bW9XqXKkSg-IUkqfNs1DY, reason: not valid java name */
    public static /* synthetic */ c m869lambda$wUsxm0bW9XqXKkSgIUkqfNs1DY() {
        return g();
    }

    private a() {
    }

    static {
        f30337a = new a();
        f30338b = g.a($$Lambda$a$wUsxm0bW9XqXKkSgIUkqfNs1DY.INSTANCE);
        f30339c = g.a($$Lambda$a$kNpAj5TvQpohxp0XWERS3j7Be9E.INSTANCE);
        f30340d = g.a($$Lambda$a$FuSlvjB7sEVbTqDpC7Q8TwkYpA.INSTANCE);
        f30341e = g.a($$Lambda$a$Clbpo9RnOTKumjA1sfAIlMSj1s.INSTANCE);
        f = g.a($$Lambda$a$Q5jsNrxdkefqprP2etJSydjMkU.INSTANCE);
    }

    private final c a() {
        return (c) ZeusTransformUtils.preCheckCast(f30338b.b(), c.class, "com.obric.aiagent.plugin");
    }

    private static final c g() {
        return f30337a.a("setOautoClipdataToUser");
    }

    private final c b() {
        return (c) ZeusTransformUtils.preCheckCast(f30339c.b(), c.class, "com.obric.aiagent.plugin");
    }

    private static final c h() {
        return f30337a.a("clearOautoPrimaryClip");
    }

    private final c c() {
        return (c) ZeusTransformUtils.preCheckCast(f30340d.b(), c.class, "com.obric.aiagent.plugin");
    }

    private static final c i() {
        return f30337a.a("addOautoPrimaryClipChangedListener");
    }

    private final c d() {
        return (c) ZeusTransformUtils.preCheckCast(f30341e.b(), c.class, "com.obric.aiagent.plugin");
    }

    private static final c j() {
        return f30337a.a("removeOautoPrimaryClipChangedListener");
    }

    private final c e() {
        return (c) ZeusTransformUtils.preCheckCast(f.b(), c.class, "com.obric.aiagent.plugin");
    }

    private static final c k() {
        return f30337a.a("getOautoPrimaryClip");
    }

    public final void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        a().a(new Object[]{r4});
    }

    public final void b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        b().a(new Object[]{r4});
    }

    public final void a(Context r3, ClipboardManager.OnPrimaryClipChangedListener r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        ClipboardManager.OnPrimaryClipChangedListener r6 = (ClipboardManager.OnPrimaryClipChangedListener) ZeusTransformUtils.wrapperContextForParams(r4, ClipboardManager.OnPrimaryClipChangedListener.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r6, "listener");
        c().a(new Object[]{r5, r6});
    }

    public final void b(Context r3, ClipboardManager.OnPrimaryClipChangedListener r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        ClipboardManager.OnPrimaryClipChangedListener r6 = (ClipboardManager.OnPrimaryClipChangedListener) ZeusTransformUtils.wrapperContextForParams(r4, ClipboardManager.OnPrimaryClipChangedListener.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r6, "listener");
        d().a(new Object[]{r5, r6});
    }

    public final ClipData c(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        return (ClipData) ZeusTransformUtils.preCheckCast(e().a(new Object[]{r5}), ClipData.class, "com.obric.aiagent.plugin");
    }

    private final c a(String r2) {
        return new c(f(), r2);
    }

    private final String f() {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        a r4 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r5 = n.f(Boolean.valueOf(ObricProductSdk.INSTANCE.platformService().romInfo().useAssistantApi()));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = n.c(r5);
        if (r2 == null) goto L12;
        Loog.INSTANCE.w(TAG, "read useAssistantApi failed, fallback to obric clipboard api: " + r2);
        r5 = false;
    L12:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L14;
        return "android.content.AssistantClipboardManager";
    L14:
        return "android.content.ObricClipboardManager";
    L5:
        th = move-exception;
        n.a r3 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L7
    }
}
