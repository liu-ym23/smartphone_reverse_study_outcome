package com.obric.autogui.operator.a.b.a.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.operator.a.b.a.b.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ImplicitIntentOpener.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f29462c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f29463b;

    /* JADX INFO: compiled from: ImplicitIntentOpener.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f29462c = new a(null);
    }

    public b(Intent r4, String r5) {
        o.e(r4, "implicitIntent");
        super(r4, r5);
        c r6 = new c(r4);
        this.f29463b = r6;
        long r3 = AOSystemTools.INSTANCE.nowTimeMillis();
        if (r6.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L6;
        Loog.INSTANCE.d("Op-OpenApp/ImplicitIntent", " - [resolve] latency=" + (AOSystemTools.INSTANCE.nowTimeMillis() - r3) + "ms, data=" + (r6.a() + '/' + r6.b()));
        return;
    }

    @Override // com.obric.autogui.operator.a.b.a.b.d
    public ComponentName d() {
        return this.f29463b.b();
    }

    @Override // com.obric.autogui.operator.a.b.a.b.d, com.obric.autogui.operator.a.b.a.b.c
    public String b() {
        return this.f29463b.a();
    }
}
