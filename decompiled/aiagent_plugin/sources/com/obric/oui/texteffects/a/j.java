package com.obric.oui.texteffects.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class j {

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f36407a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f36407a == r6.f36407a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Integer.hashCode(this.f36407a);
        }

        public String toString() {
            return "Count(count=" + this.f36407a + ')';
        }

        public final int a() {
            return this.f36407a;
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    public static final class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f36408a = null;

        static {
            f36408a = new b();
        }

        private b() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    public static final class c extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f36409a = null;

        static {
            f36409a = new c();
        }

        private c() {
            super(null);
        }
    }

    public /* synthetic */ j(d.h.b.h r1) {
        this();
    }

    private j() {
    }
}
