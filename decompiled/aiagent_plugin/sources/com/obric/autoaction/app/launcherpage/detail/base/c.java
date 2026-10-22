package com.obric.autoaction.app.launcherpage.detail.base;

import com.obric.eventkit.task.model.EventTaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: Contract.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface c {

    /* JADX INFO: compiled from: Contract.kt */
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EventTaskResult f23290a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f23290a, r6.f23290a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            EventTaskResult r0 = this.f23290a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "ClosePage(result=" + this.f23290a + ')';
        }

        public a(EventTaskResult r1) {
            this.f23290a = r1;
        }

        public final EventTaskResult a() {
            return this.f23290a;
        }
    }

    /* JADX INFO: compiled from: Contract.kt */
    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f23291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f23292b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f23291a, r6.f23291a) == true) goto L12;
            return false;
        L12:
            if (this.f23292b == r6.f23292b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f23291a.hashCode() * 31) + Boolean.hashCode(this.f23292b);
        }

        public String toString() {
            return "ShowError(message=" + this.f23291a + ", dismissLoading=" + this.f23292b + ')';
        }

        public b(String r2, boolean r3) {
            o.e(r2, "message");
            this.f23291a = r2;
            this.f23292b = r3;
        }

        public /* synthetic */ b(String r1, boolean r2, int r3, d.h.b.h r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = true;
        L5:
            this(r1, r2);
        }

        public final String a() {
            return this.f23291a;
        }

        public final boolean b() {
            return this.f23292b;
        }
    }
}
