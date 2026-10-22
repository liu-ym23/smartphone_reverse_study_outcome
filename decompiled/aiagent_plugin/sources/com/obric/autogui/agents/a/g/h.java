package com.obric.autogui.agents.a.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectPipelineModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    /* JADX INFO: compiled from: ActionEffectPipelineModels.kt */
    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.agents.a.f.h f26489a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f26489a == r6.f26489a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f26489a.hashCode();
        }

        public String toString() {
            return "ExecutionResultReady(action=" + this.f26489a + ')';
        }

        public final com.obric.autogui.agents.a.f.h a() {
            return this.f26489a;
        }

        public a(com.obric.autogui.agents.a.f.h r2) {
            o.e(r2, "action");
            super(null);
            this.f26489a = r2;
        }
    }

    /* JADX INFO: compiled from: ActionEffectPipelineModels.kt */
    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.agents.a.a.g f26490a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f26490a, r6.f26490a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f26490a.hashCode();
        }

        public String toString() {
            return "Ready(handle=" + this.f26490a + ')';
        }

        public final com.obric.autogui.agents.a.a.g a() {
            return this.f26490a;
        }

        public b(com.obric.autogui.agents.a.a.g r2) {
            o.e(r2, "handle");
            super(null);
            this.f26490a = r2;
        }
    }

    /* JADX INFO: compiled from: ActionEffectPipelineModels.kt */
    public static final class c extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f26491a = null;

        static {
            f26491a = new c();
        }

        private c() {
            super(null);
        }
    }

    public /* synthetic */ h(d.h.b.h r1) {
        this();
    }

    private h() {
    }
}
