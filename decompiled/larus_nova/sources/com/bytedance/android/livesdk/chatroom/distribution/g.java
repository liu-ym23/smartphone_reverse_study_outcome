package com.bytedance.android.livesdk.chatroom.distribution;

import android.os.Bundle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.room.data.EndReason;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f105752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StateMachine<c, a, b> f105753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f105754c;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f105755a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.distribution.g$a$a, reason: collision with other inner class name */
        public static final class C1590a extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f105756b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final EndReason f105757c;

            public C1590a(String r100, EndReason.LIVE_DISTRIBUTION_EXIT r101) {
                super(true);
                this.f105756b = r100;
                this.f105757c = r101;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f105758b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Bundle f105759c;

            public b(String r100, Bundle r101, boolean r102) {
                Intrinsics.checkNotNullParameter(r100, "roomId");
                Intrinsics.checkNotNullParameter(r101, "bundle");
                super(r102);
                this.f105758b = r100;
                this.f105759c = r101;
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f105760b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final EndReason f105761c;

            public c(boolean r100, String r101, EndReason r102) {
                super(r100);
                this.f105760b = r101;
                this.f105761c = r102;
            }
        }

        public static final class d extends a {
            public d() {
                super(true);
            }
        }

        public static final class e extends a {
            public e() {
                super(true);
            }

            public e(int r100) {
                super(true);
            }
        }

        public static final class f extends a {
            public f() {
                super(true);
            }

            public f(int r100) {
                super(true);
            }
        }

        public a(boolean r100) {
            this.f105755a = r100;
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f105762a = null;

            static {
                f105762a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.distribution.g$b$b, reason: collision with other inner class name */
        public static final class C1591b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1591b f105763a = null;

            static {
                f105763a = new C1591b();
            }

            public C1591b() {
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f105764a = null;

            static {
                f105764a = new c();
            }

            public c() {
            }
        }

        public static final class d extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f105765a = null;

            static {
                f105765a = new d();
            }

            public d() {
            }
        }

        public static final class e extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f105766a = null;

            static {
                f105766a = new e();
            }

            public e() {
            }
        }

        public static final class f extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final f f105767a = null;

            static {
                f105767a = new f();
            }

            public f() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.distribution.g$b$g, reason: collision with other inner class name */
        public static final class C1592g extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1592g f105768a = null;

            static {
                f105768a = new C1592g();
            }

            public C1592g() {
            }
        }

        public b() {
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f105769a = null;

            static {
                f105769a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f105770a = null;

            static {
                f105770a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.distribution.g$c$c, reason: collision with other inner class name */
        public static final class C1593c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1593c f105771a = null;

            static {
                f105771a = new C1593c();
            }

            public C1593c() {
            }
        }

        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f105772a = null;

            static {
                f105772a = new d();
            }

            public d() {
            }
        }

        public static final class e extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f105773a = null;

            static {
                f105773a = new e();
            }

            public e() {
            }
        }

        public c() {
        }
    }

    public g(j.b r100) {
        Intrinsics.checkNotNullParameter(r100, "flowAction");
        this.f105754c = r100;
        this.f105752a = "LiveDistributionStateMachine";
        StateMachine.a r101 = StateMachine.f66079c;
        LiveDistributionStateMachine$stateMachine$1 r102 = new LiveDistributionStateMachine$stateMachine$1(this);
        r101.getClass();
        this.f105753b = StateMachine.a.a(r102);
    }

    public final void c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        StateMachine<c, a, b> r101 = this.f105753b;     // Catch: Exception -> L5
        StateMachine.a r102 = StateMachine.f66079c;     // Catch: Exception -> L5
        r101.d(r100, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ALogger.i(this.f105752a, "transition error, " + e.getMessage());
    }

    public static final void b(g r100, a r101) {
        r100.getClass();
        if ((r101 instanceof a.c) == false) goto L6;
        a.c r102 = (a.c) r101;
        r100.f105754c.d(r102.f105760b, r102.f105761c);
        return;
    L6:
        if ((r101 instanceof a.C1590a) == false) goto L10;
        a.C1590a r103 = (a.C1590a) r101;
        r100.f105754c.d(r103.f105756b, r103.f105757c);
        return;
    }

    public static final void a(g r100, boolean r101, Function0 r102) {
        r100.getClass();
        if (r101 == false) goto L6;
        r102.invoke();
        return;
    }
}
