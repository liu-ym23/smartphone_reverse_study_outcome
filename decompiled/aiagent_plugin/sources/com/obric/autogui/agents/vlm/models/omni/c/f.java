package com.obric.autogui.agents.vlm.models.omni.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: AppPredictionProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: compiled from: AppPredictionProvider.kt */
    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28260a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f28260a, r6.f28260a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f28260a.hashCode();
        }

        public String toString() {
            return "Failure(reason=" + this.f28260a + ')';
        }

        public a(String r2) {
            d.h.b.o.e(r2, "reason");
            super(null);
            this.f28260a = r2;
        }

        public final String a() {
            return this.f28260a;
        }
    }

    /* JADX INFO: compiled from: AppPredictionProvider.kt */
    public static final class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<com.obric.autogui.agents.vlm.models.omni.c.b> f28261a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f28261a, r6.f28261a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f28261a.hashCode();
        }

        public String toString() {
            return "Success(apps=" + this.f28261a + ')';
        }

        public b(List<com.obric.autogui.agents.vlm.models.omni.c.b> r3) {
            List<com.obric.autogui.agents.vlm.models.omni.c.b> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "apps");
            super(null);
            this.f28261a = r4;
        }

        public final List<com.obric.autogui.agents.vlm.models.omni.c.b> a() {
            return this.f28261a;
        }
    }

    public /* synthetic */ f(d.h.b.h r1) {
        this();
    }

    private f() {
    }
}
