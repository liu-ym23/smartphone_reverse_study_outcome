package com.obric.agent.intents.skill.a;

import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IntentActionExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g<T> {

    /* JADX INFO: compiled from: IntentActionExecutor.kt */
    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IntentResult<Empty> f14892a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14892a, r6.f14892a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f14892a.hashCode();
        }

        public String toString() {
            return "Invalid(result=" + this.f14892a + ')';
        }

        public a(IntentResult<Empty> r2) {
            o.e(r2, "result");
            super(null);
            this.f14892a = r2;
        }

        public final IntentResult<Empty> a() {
            return this.f14892a;
        }
    }

    /* JADX INFO: compiled from: IntentActionExecutor.kt */
    public static final class b<T> extends g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f14893a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14893a, r6.f14893a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            T r0 = this.f14893a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "Valid(request=" + this.f14893a + ')';
        }

        public b(T r2) {
            super(null);
            this.f14893a = r2;
        }

        public final T a() {
            return this.f14893a;
        }
    }

    public /* synthetic */ g(d.h.b.h r1) {
        this();
    }

    private g() {
    }
}
