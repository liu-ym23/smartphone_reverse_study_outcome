package com.obric.aiagent.skill.credentials.api;

import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CredentialModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface c {

    /* JADX INFO: compiled from: CredentialModels.kt */
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h f18945a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f18945a, r6.f18945a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f18945a.hashCode();
        }

        public String toString() {
            return "Completed(envelope=" + this.f18945a + ')';
        }

        public a(h r2) {
            d.h.b.o.e(r2, "envelope");
            this.f18945a = r2;
        }

        public final h a() {
            return this.f18945a;
        }
    }

    /* JADX INFO: compiled from: CredentialModels.kt */
    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j f18946a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f18946a, r6.f18946a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f18946a.hashCode();
        }

        public String toString() {
            return "VerificationUrl(request=" + this.f18946a + ')';
        }

        public b(j r2) {
            d.h.b.o.e(r2, Ext.KEY_REQUEST);
            this.f18946a = r2;
        }

        public final j a() {
            return this.f18946a;
        }
    }
}
