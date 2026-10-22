package com.obric.autoaction.presentation.island;

import com.obric.livecard.api.entity.IslandWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: IslandSessionManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: compiled from: IslandSessionManager.kt */
    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IslandWidget f25079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final IslandWidget f25080b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f25079a, r6.f25079a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f25080b, r6.f25080b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            IslandWidget r0 = this.f25079a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            IslandWidget r4 = this.f25080b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "Create(collapseWidget=" + this.f25079a + ", expandWidget=" + this.f25080b + ')';
        }

        public final IslandWidget a() {
            return this.f25079a;
        }

        public final IslandWidget b() {
            return this.f25080b;
        }

        public a(IslandWidget r2, IslandWidget r3) {
            super(null);
            this.f25079a = r2;
            this.f25080b = r3;
        }
    }

    /* JADX INFO: compiled from: IslandSessionManager.kt */
    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f25081a;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L8;
            return false;
        L8:
            b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
            if (this.f25081a == r8.f25081a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Long.hashCode(this.f25081a);
        }

        public String toString() {
            return "Destroy(delay=" + this.f25081a + ')';
        }

        public b(long r2) {
            super(null);
            this.f25081a = r2;
        }

        public final long a() {
            return this.f25081a;
        }
    }

    /* JADX INFO: compiled from: IslandSessionManager.kt */
    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f25082a;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, c.class) == true) goto L8;
            return false;
        L8:
            c r8 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin");
            if (this.f25082a == r8.f25082a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Long.hashCode(this.f25082a);
        }

        public String toString() {
            return "Hide(delay=" + this.f25082a + ')';
        }

        public c(long r2) {
            super(null);
            this.f25082a = r2;
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.presentation.island.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IslandSessionManager.kt */
    public static final class C0600d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f25083a;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, C0600d.class) == true) goto L8;
            return false;
        L8:
            C0600d r8 = (C0600d) ZeusTransformUtils.preCheckCast(r7, C0600d.class, "com.obric.aiagent.plugin");
            if (this.f25083a == r8.f25083a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Long.hashCode(this.f25083a);
        }

        public String toString() {
            return "Show(delay=" + this.f25083a + ')';
        }

        public C0600d(long r2) {
            super(null);
            this.f25083a = r2;
        }
    }

    /* JADX INFO: compiled from: IslandSessionManager.kt */
    public static final class e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IslandWidget f25084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final IslandWidget f25085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f25086c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (o.a(this.f25084a, r6.f25084a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f25085b, r6.f25085b) == true) goto L15;
            return false;
        L15:
            if (this.f25086c == r6.f25086c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            IslandWidget r0 = this.f25084a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            IslandWidget r4 = this.f25085b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return ((r3 + r1) * 31) + Boolean.hashCode(this.f25086c);
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "Update(collapseWidget=" + this.f25084a + ", expandWidget=" + this.f25085b + ", mayCreate=" + this.f25086c + ')';
        }

        public final IslandWidget a() {
            return this.f25084a;
        }

        public final IslandWidget b() {
            return this.f25085b;
        }

        public final boolean c() {
            return this.f25086c;
        }

        public e(IslandWidget r2, IslandWidget r3, boolean r4) {
            super(null);
            this.f25084a = r2;
            this.f25085b = r3;
            this.f25086c = r4;
        }
    }

    public /* synthetic */ d(h r1) {
        this();
    }

    private d() {
    }
}
