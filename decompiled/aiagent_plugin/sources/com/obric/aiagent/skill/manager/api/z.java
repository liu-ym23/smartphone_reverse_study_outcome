package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface z {

    /* JADX INFO: compiled from: SkillManagerContracts.kt */
    public static final class a implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f19330a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f19330a, r6.f19330a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f19330a.hashCode();
        }

        public String toString() {
            return "HostFile(file=" + this.f19330a + ')';
        }

        public a(File r2) {
            d.h.b.o.e(r2, "file");
            this.f19330a = r2;
        }

        public final File a() {
            return this.f19330a;
        }
    }

    /* JADX INFO: compiled from: SkillManagerContracts.kt */
    public static final class b implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f19331a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f19331a, r6.f19331a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f19331a.hashCode();
        }

        public String toString() {
            return "RemoteUrl(url=" + this.f19331a + ')';
        }

        public b(String r2) {
            d.h.b.o.e(r2, "url");
            this.f19331a = r2;
        }

        public final String a() {
            return this.f19331a;
        }
    }
}
