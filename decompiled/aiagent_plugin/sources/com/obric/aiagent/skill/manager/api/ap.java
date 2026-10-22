package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ap {

    /* JADX INFO: compiled from: SkillManagerContracts.kt */
    public static final class a implements ap {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f19210a = null;

        static {
            f19210a = new a();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, a.class) == true) goto L9;
            return false;
        L9:
            a r2 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 1218148327;
        }

        public String toString() {
            return "AllInstalled";
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SkillManagerContracts.kt */
    public static final class b implements ap {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<String> f19211a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f19211a, r6.f19211a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f19211a.hashCode();
        }

        public String toString() {
            return "Selected(slugs=" + this.f19211a + ')';
        }

        public b(Set<String> r3) {
            Set<String> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "slugs");
            this.f19211a = r4;
        }

        public final Set<String> a() {
            return this.f19211a;
        }
    }
}
