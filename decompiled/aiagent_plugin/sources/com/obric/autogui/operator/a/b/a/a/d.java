package com.obric.autogui.operator.a.b.a.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.n.j;
import d.n.m;

/* JADX INFO: compiled from: OpenableAppNameCollector.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface d {

    /* JADX INFO: compiled from: OpenableAppNameCollector.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0758a f29442a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.autogui.operator.a.b.a.c f29443b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final j<com.obric.autogui.operator.a.b.a.b.a> f29444c;

        /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.a.a.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OpenableAppNameCollector.kt */
        public static final class C0758a {
            public /* synthetic */ C0758a(h r1) {
                this();
            }

            private C0758a() {
            }

            public final a a(com.obric.autogui.operator.a.b.a.c r2) {
                o.e(r2, "status");
                return new a(r2, m.a());
            }
        }

        static {
            f29442a = new C0758a(null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29443b, r6.f29443b) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f29444c, r6.f29444c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f29443b.hashCode() * 31) + this.f29444c.hashCode();
        }

        public String toString() {
            return "CollectResult(collectResult=" + this.f29443b + ", candidates=" + this.f29444c + ')';
        }

        public a(com.obric.autogui.operator.a.b.a.c r3, j<? extends com.obric.autogui.operator.a.b.a.b.a> r4) {
            j<com.obric.autogui.operator.a.b.a.b.a> r5 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.aiagent.plugin");
            o.e(r3, "collectResult");
            o.e(r5, "candidates");
            this.f29443b = r3;
            this.f29444c = r5;
        }

        public final com.obric.autogui.operator.a.b.a.c a() {
            return this.f29443b;
        }

        public final j<com.obric.autogui.operator.a.b.a.b.a> b() {
            return this.f29444c;
        }
    }

    a a(Context r1, String r2);
}
