package com.bytedance.android.live.openplatform.impl.miniappaudience.shelf;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class EnterRoomShelfInfoStateMachine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateMachine<c, a, b> f84923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f84924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OpenPlatformContext f84925c;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.EnterRoomShelfInfoStateMachine$a$a, reason: collision with other inner class name */
        public static final class C1304a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1304a f84926a = null;

            static {
                f84926a = new C1304a();
            }

            public C1304a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final tq0.a f84927a;

            public b(tq0.a r100) {
                Intrinsics.checkNotNullParameter(r100, "response");
                this.f84927a = r100;
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final e f84928a;

            public c(e r100) {
                Intrinsics.checkNotNullParameter(r100, "toolbarData");
                this.f84928a = r100;
            }
        }

        public static final class d extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f84929a = null;

            static {
                f84929a = new d();
            }

            public d() {
            }
        }

        public a() {
        }

        public final String toString() {
            if (Intrinsics.areEqual(this, d.f84929a) == false) goto L6;
            return "Start";
        L6:
            if ((this instanceof b) == false) goto L9;
            return "BackendSuccess";
        L9:
            if (Intrinsics.areEqual(this, C1304a.f84926a) == false) goto L12;
            return "BackendFail";
        L12:
            if ((this instanceof c) == false) goto L16;
            return "ReceiveToolbarData";
        L16:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f84930a = null;

            static {
                f84930a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.EnterRoomShelfInfoStateMachine$b$b, reason: collision with other inner class name */
        public static final class C1305b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1305b f84931a = null;

            static {
                f84931a = new C1305b();
            }

            public C1305b() {
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f84932a = null;

            static {
                f84932a = new c();
            }

            public c() {
            }
        }

        public static final class d extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f84933a = null;

            static {
                f84933a = new d();
            }

            public d() {
            }
        }

        public b() {
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f84934a = null;

            static {
                f84934a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final e f84935a;

            public b() {
                this(null);
            }

            public b(e r100) {
                this.f84935a = r100;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.EnterRoomShelfInfoStateMachine$c$c, reason: collision with other inner class name */
        public static final class C1306c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final tq0.a f84936a;

            public C1306c(tq0.a r100) {
                Intrinsics.checkNotNullParameter(r100, "response");
                this.f84936a = r100;
            }
        }

        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final e f84937a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final tq0.a f84938b;

            public d(e r100, tq0.a r101) {
                Intrinsics.checkNotNullParameter(r100, "toolbarData");
                this.f84937a = r100;
                this.f84938b = r101;
            }
        }

        public static final class e extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f84939a = null;

            static {
                f84939a = new e();
            }

            public e() {
            }
        }

        public c() {
        }

        public final String toString() {
            if (Intrinsics.areEqual(this, e.f84939a) == false) goto L6;
            return "Init";
        L6:
            if ((this instanceof b) == false) goto L9;
            return "BackendProcessing";
        L9:
            if ((this instanceof C1306c) == false) goto L12;
            return "BackendSuccessful";
        L12:
            if (Intrinsics.areEqual(this, a.f84934a) == false) goto L15;
            return "BackendFailed";
        L15:
            if ((this instanceof d) == false) goto L19;
            return "Finished";
        L19:
            throw new NoWhenBranchMatchedException();
        }
    }

    public interface d {
        void a();

        void b(tq0.a r100);

        void c(e r100, tq0.a r101, boolean r102);

        void d(e r100, boolean r101);
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ToolbarMatchInterface f84940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f84941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<String, Unit> f84942c;

        /* JADX WARN: Multi-variable type inference failed */
        public e(ToolbarMatchInterface r100, Function0<Unit> r101, Function1<? super String, Unit> r102) {
            Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            Intrinsics.checkNotNullParameter(r101, "loadButton");
            Intrinsics.checkNotNullParameter(r102, "loadFail");
            this.f84940a = r100;
            this.f84941b = r101;
            this.f84942c = r102;
        }
    }

    public EnterRoomShelfInfoStateMachine(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        this.f84925c = r100;
        StateMachine.a r101 = StateMachine.f66079c;
        EnterRoomShelfInfoStateMachine$stateMachine$1 r102 = new EnterRoomShelfInfoStateMachine$stateMachine$1(this);
        r101.getClass();
        this.f84923a = StateMachine.a.a(r102);
    }
}
