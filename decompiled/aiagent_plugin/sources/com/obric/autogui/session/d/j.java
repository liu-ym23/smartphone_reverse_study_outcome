package com.obric.autogui.session.d;

import android.content.Context;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.AOAgentRobotsTools;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SaepPackagesAsyncResource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends com.obric.autogui.session.d.a<String> {
    private static final String TAG = "SaepPackagesAsyncResource";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f30918b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.session.a f30919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c<String> f30920d;

    /* JADX INFO: compiled from: SaepPackagesAsyncResource.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SaepPackagesAsyncResource.kt */
    /* synthetic */ class b extends d.h.b.l implements d.h.a.b<d.c.d<? super String>, Object> {
        b(Object r8) {
            super(1, r8, j.class, "querySaepPackages", "querySaepPackages(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final Object a(d.c.d<? super String> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return j.a((j) ZeusTransformUtils.preCheckCast(this.receiver, j.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super String> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f30918b = new a(null);
    }

    private static final String f() {
        return "";
    }

    public static /* synthetic */ String lambda$eePMUTw7188OzjqODC_i3f0dv9w() {
        return f();
    }

    public static final /* synthetic */ Object a(j r2, d.c.d r3) {
        return r2.b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public j(com.obric.autogui.session.a r11) {
        o.e(r11, SensitiveType.SESSION);
        super(null, 1, null);
        this.f30919c = r11;
        this.f30920d = new c(TAG, (d.h.a.b) ZeusTransformUtils.preCheckCast(new b(this), d.h.a.b.class, "com.obric.aiagent.plugin"), $$Lambda$j$eePMUTw7188OzjqODC_i3f0dv9w.INSTANCE, null, null, 24, null);
    }

    @Override // com.obric.autogui.session.d.a
    public c<String> a() {
        return this.f30920d;
    }

    private final Object b(d.c.d<? super String> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        String r3 = AOAgentRobotsTools.INSTANCE.querySaepPackagesJson((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f30919c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (r3 != null) goto L5;
        Loog.INSTANCE.w(TAG, "query SAEP packages returned null");
    L6:
        return r3;
    L5:
        Loog.INSTANCE.d(TAG, "query SAEP packages success, length=" + r3.length());
        goto L6
    }
}
