package com.bytedance.android.livesdk.interactivity.like.controller;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.message.model.d4;
import com.bytedance.android.livesdkapi.message.Text;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateMachine<e, AbstractC2184b, d> f137629a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f137630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.android.livesdk.interactivity.api.like.model.a f137631b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<d4> f137632c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Text f137633d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Text f137634e;

        public a() {
            this(0, null, null, null, null, 31);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L16;
            a r101 = (a) r100;
            if (this.f137630a == r101.f137630a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f137631b, r101.f137631b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f137632c, r101.f137632c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f137633d, r101.f137633d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f137634e, r101.f137634e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            long r100 = this.f137630a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            com.bytedance.android.livesdk.interactivity.api.like.model.a r102 = this.f137631b;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = r102.hashCode();
        L6:
            int r105 = (r101 + r104) * 31;
            List<d4> r106 = this.f137632c;
            if (r106 == null) goto L9;
            int r107 = r106.hashCode();
        L10:
            int r108 = (r105 + r107) * 31;
            Text r109 = this.f137633d;
            if (r109 == null) goto L13;
            int r110 = r109.hashCode();
        L14:
            int r111 = (r108 + r110) * 31;
            Text r112 = this.f137634e;
            if (r112 == null) goto L18;
            r103 = r112.hashCode();
        L18:
            return r111 + r103;
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        public final String toString() {
            return "DoubleLikeInfo(msgId=" + this.f137630a + ", detail=" + this.f137631b + ", rankList=" + this.f137632c + ", normalSummary=" + this.f137633d + ", joinSummary=" + this.f137634e + ")";
        }

        public a(long r100, com.bytedance.android.livesdk.interactivity.api.like.model.a r101, List r102, Text r103, Text r104, int r105) {
            if ((r105 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r102 = null;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r103 = null;
        L15:
            if ((r105 & 16) == 0) goto L17;
            r104 = null;
        L17:
            this.f137630a = r100;
            this.f137631b = r101;
            this.f137632c = r102;
            this.f137633d = r103;
            this.f137634e = r104;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.like.controller.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC2184b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f137635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f137636b;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.like.controller.b$b$a */
        public static final class a extends AbstractC2184b {
            public a(a r100) {
                Intrinsics.checkNotNullParameter(r100, "info");
                super("EndEvent", r100);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.like.controller.b$b$b, reason: collision with other inner class name */
        public static final class C2185b extends AbstractC2184b {
            public C2185b(a r100) {
                Intrinsics.checkNotNullParameter(r100, "info");
                super("StartEvent", r100);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.like.controller.b$b$c */
        public static final class c extends AbstractC2184b {
            public c(a r100) {
                Intrinsics.checkNotNullParameter(r100, "info");
                super("SummaryEvent", r100);
            }
        }

        public AbstractC2184b(String r100, a r101) {
            this.f137635a = r100;
            this.f137636b = r101;
        }
    }

    public interface c {
        void a(a r100);

        void b(a r100);

        void c(a r100);

        void d(a r100);
    }

    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f137637a;

        public static final class a extends d {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final a f137638b = null;

            static {
                f137638b = new a();
            }

            public a() {
                super("EndActivity");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.like.controller.b$d$b, reason: collision with other inner class name */
        public static final class C2186b extends d {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C2186b f137639b = null;

            static {
                f137639b = new C2186b();
            }

            public C2186b() {
                super("StartActivity");
            }
        }

        public static final class c extends d {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final c f137640b = null;

            static {
                f137640b = new c();
            }

            public c() {
                super("SummaryActivity");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.like.controller.b$d$d, reason: collision with other inner class name */
        public static final class C2187d extends d {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C2187d f137641b = null;

            static {
                f137641b = new C2187d();
            }

            public C2187d() {
                super("UpdateActivity");
            }
        }

        public d(String r100) {
            this.f137637a = r100;
        }
    }

    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f137642a;

        public static final class a extends e {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final a f137643b = null;

            static {
                f137643b = new a();
            }

            public a() {
                super("Activity");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.like.controller.b$e$b, reason: collision with other inner class name */
        public static final class C2188b extends e {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C2188b f137644b = null;

            static {
                f137644b = new C2188b();
            }

            public C2188b() {
                super("Idle");
            }
        }

        public static final class c extends e {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final c f137645b = null;

            static {
                f137645b = new c();
            }

            public c() {
                super("Summary");
            }
        }

        public e(String r100) {
            this.f137642a = r100;
        }
    }

    public b(final DoubleLikeManager.a r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        StateMachine.a r101 = StateMachine.f66079c;
        Function1<StateMachine.GraphBuilder<e, AbstractC2184b, d>, Unit> r102 = new DoubleLikeStateMachine$stateMachine$1(r100);
        r101.getClass();
        this.f137629a = StateMachine.a.a(r102);
    }

    public final void a(AbstractC2184b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        StateMachine<e, AbstractC2184b, d> r101 = this.f137629a;
        StateMachine.a r102 = StateMachine.f66079c;
        r101.d(r100, null);
    }
}
