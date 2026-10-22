package com.obric.oui.orecyclerview.base;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: VelocityTrackerFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35543a = null;

    /* JADX INFO: compiled from: VelocityTrackerFactory.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final h a(Context r2, int r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            if (r3 == 1) goto L11;
            if (r3 != 2) goto L9;
            return (h) ZeusTransformUtils.preCheckCast(new e(r1), h.class, "com.obric.aiagent.plugin");
        L9:
            throw new RuntimeException("impl is not supported");
        L11:
            return (h) ZeusTransformUtils.preCheckCast(new g(), h.class, "com.obric.aiagent.plugin");
        }

        public final h a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r4, "context");
            return a(r4, 1);
        }
    }

    static {
        f35543a = new a(null);
    }

    public static final h a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return f35543a.a(r3);
    }
}
