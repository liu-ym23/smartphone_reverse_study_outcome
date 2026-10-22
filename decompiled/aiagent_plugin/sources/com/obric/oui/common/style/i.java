package com.obric.oui.common.style;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OUIStyleProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f34534a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.obric.oui.common.a f34535e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f34536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f34537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f34538d;

    /* JADX INFO: compiled from: OUIStyleProvider.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    public i(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        this.f34536b = new f(r7, r8, r5, r6);
        this.f34537c = new c(r7, r8, r5, r6);
    }

    public final void a(View r2) {
        o.e(r2, "owner");
        this.f34536b.a(r2);
        this.f34537c.a(r2);
        this.f34538d = new e(r2);
    }

    public com.obric.oui.common.style.a a() {
        return (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(this.f34537c, com.obric.oui.common.style.a.class, "com.obric.aiagent.plugin");
    }

    public b b() {
        return (b) ZeusTransformUtils.preCheckCast(this.f34536b, b.class, "com.obric.aiagent.plugin");
    }

    public e c() {
        e r0 = this.f34538d;
        if (r0 != null) goto L6;
        o.c("mOUIEffectHelper");
        return null;
    L6:
        return r0;
    }

    static {
        f34534a = new a(null);
        f34535e = new com.obric.oui.common.a();
    }
}
