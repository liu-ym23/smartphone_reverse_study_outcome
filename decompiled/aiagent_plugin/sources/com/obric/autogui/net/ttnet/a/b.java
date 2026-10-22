package com.obric.autogui.net.ttnet.a;

import android.content.Context;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.net.ttnet.a.b.d;
import com.obric.autogui.net.ttnet.a.b.e;
import com.obric.autogui.net.ttnet.a.b.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.h;
import d.h.b.o;
import java.util.Collection;

/* JADX INFO: compiled from: TTNetExceptionAnalyser.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "ExpAnal/TTNet";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29206a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.obric.autogui.net.ttnet.a.a[] f29207c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h<com.obric.autogui.net.ttnet.a.a.b> f29208b;

    /* JADX INFO: compiled from: TTNetExceptionAnalyser.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    public b() {
        this.f29208b = new h(10);
    }

    static {
        f29206a = new a(null);
        f29207c = new com.obric.autogui.net.ttnet.a.a[]{new com.obric.autogui.net.ttnet.a.b.a(), new com.obric.autogui.net.ttnet.a.b.b(), new com.obric.autogui.net.ttnet.a.b.c(), new f(), new d(), new e()};
    }

    public com.obric.autogui.net.ttnet.a.a.b a(Context r11, Throwable r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        o.e(r13, "context");
        o.e(r12, "throwable");
        long r2 = AOSystemTools.INSTANCE.nowTimeMillis();
        com.obric.autogui.net.ttnet.a.a.C0737a r0 = new com.obric.autogui.net.ttnet.a.a.C0737a(r12, (Collection) ZeusTransformUtils.preCheckCast(this.f29208b, Collection.class, "com.obric.aiagent.plugin"), null, 4, null);
        com.obric.autogui.net.ttnet.a.a[] r1 = f29207c;
        int r4 = r1.length;
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L8;
        com.obric.autogui.net.ttnet.a.a.b r6 = r1[r5].a(r13, r0);
        if (r6 != null) goto L10;
        r5 = r5 + 1;
    L10:
        if (r6 != null) goto L13;
        Loog.INSTANCE.e(TAG, " - analyse() - No analyser may handle this exception: " + r12 + '.', r12);
        r6 = new com.obric.autogui.net.ttnet.a.a.b(com.obric.autogui.tools.api.net.c.i, r12, "UnknownException_" + r12.getClass().getSimpleName());
    L13:
        if (this.f29208b.size() < 10) goto L15;
        this.f29208b.b();
    L15:
        this.f29208b.b(r6);
        Loog.INSTANCE.d(TAG, " - analyse() - analysis result: " + r6 + ", cost=" + (AOSystemTools.INSTANCE.nowTimeMillis() - r2) + "ms.");
        r6.b();
        return r6;
    L8:
        r6 = null;
        goto L10
    }
}
