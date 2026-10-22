package com.obric.autoaction.app.launcherpage.detail.base;

import com.obric.eventkit.task.model.EventTask;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: Contract.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k implements i {

    /* JADX INFO: compiled from: Contract.kt */
    public static final class a extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f23396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final EventTask f23397b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f23396a, r6.f23396a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f23397b, r6.f23397b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f23396a.hashCode() * 31;
            EventTask r1 = this.f23397b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "InitState(taskId=" + this.f23396a + ", task=" + this.f23397b + ')';
        }

        public a(String r2, EventTask r3) {
            o.e(r2, DBDefinition.TASK_ID);
            super(null);
            this.f23396a = r2;
            this.f23397b = r3;
        }
    }

    /* JADX INFO: compiled from: Contract.kt */
    public static final class b extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f23398a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f23398a, r6.f23398a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            String r0 = this.f23398a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "UpdateHistory(count=" + this.f23398a + ')';
        }

        public b(String r2) {
            super(null);
            this.f23398a = r2;
        }
    }

    /* JADX INFO: compiled from: Contract.kt */
    public static final class c extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f23399a = null;

        static {
            f23399a = new c();
        }

        private c() {
            super(null);
        }
    }

    public /* synthetic */ k(d.h.b.h r1) {
        this();
    }

    private k() {
    }
}
