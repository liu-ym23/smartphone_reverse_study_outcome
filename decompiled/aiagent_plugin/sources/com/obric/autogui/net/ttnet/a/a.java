package com.obric.autogui.net.ttnet.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: ITTNetExceptionHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: com.obric.autogui.net.ttnet.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ITTNetExceptionHandler.kt */
    public static final class C0737a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Throwable f29197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Collection<com.obric.autogui.net.ttnet.a.a.b> f29198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map<String, Object> f29199c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0737a.class) == true) goto L8;
            return false;
        L8:
            C0737a r6 = (C0737a) ZeusTransformUtils.preCheckCast(r5, C0737a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29197a, r6.f29197a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f29198b, r6.f29198b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f29199c, r6.f29199c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f29197a.hashCode() * 31) + this.f29198b.hashCode()) * 31) + this.f29199c.hashCode();
        }

        public String toString() {
            return "AnalyseContext(throwable=" + this.f29197a + ", historyOfAnalysis=" + this.f29198b + ", extras=" + this.f29199c + ')';
        }

        public C0737a(Throwable r3, Collection<? extends com.obric.autogui.net.ttnet.a.a.b> r4, Map<String, Object> r5) {
            Collection<com.obric.autogui.net.ttnet.a.a.b> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
            Map<String, Object> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            o.e(r3, "throwable");
            o.e(r6, "historyOfAnalysis");
            o.e(r7, "extras");
            this.f29197a = r3;
            this.f29198b = r6;
            this.f29199c = r7;
        }

        public final Throwable a() {
            return this.f29197a;
        }

        public /* synthetic */ C0737a(Throwable r2, Collection r3, Map r4, int r5, h r6) {
            Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            if ((r5 & 4) == 0) goto L5;
            r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        L5:
            this(r2, r7, r8);
        }

        public final Map<String, Object> b() {
            return this.f29199c;
        }
    }

    com.obric.autogui.net.ttnet.a.a.b a(Context r1, C0737a r2);
}
