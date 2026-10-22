package com.obric.autoaction.app.launcherpage.knowledge;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: KnowledgeViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.knowledge.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: KnowledgeViewModel.kt */
    public static final class C0540a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f23928a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0540a.class) == true) goto L8;
            return false;
        L8:
            C0540a r6 = (C0540a) ZeusTransformUtils.preCheckCast(r5, C0540a.class, "com.obric.aiagent.plugin");
            if (this.f23928a == r6.f23928a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f23928a);
        }

        public String toString() {
            return "ConfirmAutoLearnSwitch(enabled=" + this.f23928a + ')';
        }

        public C0540a(boolean r2) {
            super(null);
            this.f23928a = r2;
        }

        public final boolean a() {
            return this.f23928a;
        }
    }

    /* JADX INFO: compiled from: KnowledgeViewModel.kt */
    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f23929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f23930b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f23929a == r6.f23929a) goto L12;
            return false;
        L12:
            if (o.a(this.f23930b, r6.f23930b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.f23929a) * 31;
            Context r1 = this.f23930b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "Delete(needCheckDialog=" + this.f23929a + ", dialogContext=" + this.f23930b + ')';
        }

        public b(boolean r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            super(null);
            this.f23929a = r3;
            this.f23930b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        }

        public /* synthetic */ b(boolean r2, Context r3, int r4, h r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            if ((r4 & 2) == 0) goto L5;
            r6 = null;
        L5:
            this(r2, r6);
        }

        public final boolean a() {
            return this.f23929a;
        }

        public final Context b() {
            return this.f23930b;
        }
    }

    /* JADX INFO: compiled from: KnowledgeViewModel.kt */
    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f23931a;

        public c(String r2) {
            o.e(r2, "knowledge");
            super(null);
            this.f23931a = r2;
        }

        public final String a() {
            return this.f23931a;
        }
    }

    public /* synthetic */ a(h r1) {
        this();
    }

    private a() {
    }
}
