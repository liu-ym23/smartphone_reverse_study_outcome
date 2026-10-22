package com.bytedance.android.live.openplatform.impl.miniappaudience.shelf;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.AudienceShelfDisplayDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f84945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f84946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f84947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f84948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StateMachine<AbstractC1313d, b, c> f84949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f84950f;

    public interface a {
        void a();

        void b(long r100, long r101);
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f84951a = null;

            static {
                f84951a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d$b$b, reason: collision with other inner class name */
        public static final class C1309b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1309b f84952a = null;

            static {
                f84952a = new C1309b();
            }

            public C1309b() {
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f84953a = null;

            static {
                f84953a = new c();
            }

            public c() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d$b$d, reason: collision with other inner class name */
        public static final class C1310d extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1310d f84954a = null;

            static {
                f84954a = new C1310d();
            }

            public C1310d() {
            }
        }

        public b() {
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f84955a = null;

            static {
                f84955a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f84956a = null;

            static {
                f84956a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d$c$c, reason: collision with other inner class name */
        public static final class C1311c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1311c f84957a = null;

            static {
                f84957a = new C1311c();
            }

            public C1311c() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d$c$d, reason: collision with other inner class name */
        public static final class C1312d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1312d f84958a = null;

            static {
                f84958a = new C1312d();
            }

            public C1312d() {
            }
        }

        public static final class e extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f84959a = null;

            static {
                f84959a = new e();
            }

            public e() {
            }
        }

        public static final class f extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final f f84960a = null;

            static {
                f84960a = new f();
            }

            public f() {
            }
        }

        public c() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d$d, reason: collision with other inner class name */
    public static abstract class AbstractC1313d {

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d$d$a */
        public static final class a extends AbstractC1313d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f84961a = null;

            static {
                f84961a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d$d$b */
        public static final class b extends AbstractC1313d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f84962a = null;

            static {
                f84962a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d$d$c */
        public static final class c extends AbstractC1313d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f84963a = null;

            static {
                f84963a = new c();
            }

            public c() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d$d$d, reason: collision with other inner class name */
        public static final class C1314d extends AbstractC1313d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1314d f84964a = null;

            static {
                f84964a = new C1314d();
            }

            public C1314d() {
            }
        }

        public AbstractC1313d() {
        }
    }

    public d(AudienceShelfDisplayDialog.f r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f84950f = r100;
        StateMachine.a r101 = StateMachine.f66079c;
        Function1<StateMachine.GraphBuilder<AbstractC1313d, b, c>, Unit> r102 = new AudienceShelfState$shelfState$1(this);
        r101.getClass();
        this.f84949e = StateMachine.a.a(r102);
    }

    public final void a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        StateMachine<AbstractC1313d, b, c> r101 = this.f84949e;
        StateMachine.a r102 = StateMachine.f66079c;
        r101.d(r100, null);
    }
}
