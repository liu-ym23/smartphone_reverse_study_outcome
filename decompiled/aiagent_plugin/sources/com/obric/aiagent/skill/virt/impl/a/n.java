package com.obric.aiagent.skill.virt.impl.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: VirtBackendFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface n {

    /* JADX INFO: compiled from: VirtBackendFactory.kt */
    public static final class a implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k f22064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f22065b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f22064a, r6.f22064a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f22064a.hashCode();
        }

        public String toString() {
            return "Selected(backend=" + this.f22064a + ')';
        }

        public a(k r3) {
            k r4 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.aiagent.plugin");
            o.e(r4, "backend");
            this.f22064a = r4;
            this.f22065b = r4.a();
        }

        public final k b() {
            return this.f22064a;
        }

        @Override // com.obric.aiagent.skill.virt.impl.a.n
        public String a() {
            return this.f22065b;
        }
    }

    /* JADX INFO: compiled from: VirtBackendFactory.kt */
    public static final class b implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f22066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f22067b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f22066a, r6.f22066a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f22066a.hashCode();
        }

        public String toString() {
            return "Unavailable(reason=" + this.f22066a + ')';
        }

        public b(String r2) {
            o.e(r2, "reason");
            this.f22066a = r2;
        }

        public final String b() {
            return this.f22066a;
        }

        @Override // com.obric.aiagent.skill.virt.impl.a.n
        public String a() {
            return this.f22067b;
        }
    }

    String a();
}
