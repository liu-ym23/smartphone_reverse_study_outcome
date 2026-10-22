package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class GuestBattleStateMachine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateMachine<c, a, b> f77955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<StateMachine.c<? extends c, ? extends a, ? extends b>, Unit> f77956b;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f77957a;

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleStateMachine$a$a, reason: collision with other inner class name */
        public static final class C1202a extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 f77958b;

            public C1202a(com.bytedance.android.livesdk.chatroom.model.interact.a0 r100) {
                Intrinsics.checkNotNullParameter(r100, "battleInfo");
                super("CreateMsg");
                this.f77958b = r100;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 f77959b;

            public b(com.bytedance.android.livesdk.chatroom.model.interact.a0 r100) {
                Intrinsics.checkNotNullParameter(r100, "battleInfo");
                super("FinishApi");
                this.f77959b = r100;
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 f77960b;

            public c(com.bytedance.android.livesdk.chatroom.model.interact.a0 r100) {
                Intrinsics.checkNotNullParameter(r100, "battleInfo");
                super("FinishMsg");
                this.f77960b = r100;
            }
        }

        public static final class d extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 f77961b;

            public d(com.bytedance.android.livesdk.chatroom.model.interact.a0 r100) {
                Intrinsics.checkNotNullParameter(r100, "battleInfo");
                super("ForceClose");
                this.f77961b = r100;
            }
        }

        public static final class e extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 f77962b;

            public e(com.bytedance.android.livesdk.chatroom.model.interact.a0 r100) {
                Intrinsics.checkNotNullParameter(r100, "battleInfo");
                super("GetInfo");
                this.f77962b = r100;
            }
        }

        public static final class f extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 f77963b;

            public f(com.bytedance.android.livesdk.chatroom.model.interact.a0 r100) {
                Intrinsics.checkNotNullParameter(r100, "battleInfo");
                super("PauseMsg");
                this.f77963b = r100;
            }
        }

        public static final class g extends a {
        }

        public static final class h extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 f77964b;

            public h(com.bytedance.android.livesdk.chatroom.model.interact.a0 r100) {
                Intrinsics.checkNotNullParameter(r100, "battleInfo");
                super("ResumeMsg");
                this.f77964b = r100;
            }
        }

        public static final class i extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 f77965b;

            public i(com.bytedance.android.livesdk.chatroom.model.interact.a0 r100) {
                Intrinsics.checkNotNullParameter(r100, "battleInfo");
                super("ShowResultMsg");
                this.f77965b = r100;
            }
        }

        public static final class j extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final j f77966b = null;

            static {
                f77966b = new j();
            }

            public j() {
                super("ShowResultTimeout");
            }
        }

        public static final class k extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 f77967b;

            public k(com.bytedance.android.livesdk.chatroom.model.interact.a0 r100) {
                Intrinsics.checkNotNullParameter(r100, "battleInfo");
                super("StartApi");
                this.f77967b = r100;
            }
        }

        public static final class l extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 f77968b;

            public l(com.bytedance.android.livesdk.chatroom.model.interact.a0 r100) {
                Intrinsics.checkNotNullParameter(r100, "battleInfo");
                super("UpdateMsg");
                this.f77968b = r100;
            }
        }

        public final String toString() {
            return this.f77957a;
        }

        public a(String r100) {
            this.f77957a = r100;
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f77969a;

        public static final class a extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final a f77970b = null;

            static {
                f77970b = new a();
            }

            public a() {
                super("None");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleStateMachine$b$b, reason: collision with other inner class name */
        public static final class C1203b extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f77971b;

            public C1203b() {
                this(false);
            }

            public C1203b(boolean r100) {
                super("PauseBattle");
                this.f77971b = r100;
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final c f77972b = null;

            static {
                f77972b = new c();
            }

            public c() {
                super("Reset");
            }
        }

        public static final class d extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final d f77973b = null;

            static {
                f77973b = new d();
            }

            public d() {
                super("RestartBattle");
            }
        }

        public static final class e extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f77974b;

            public e() {
                this(false);
            }

            public e(boolean r100) {
                super("ResumeBattle");
                this.f77974b = r100;
            }
        }

        public static final class f extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final f f77975b = null;

            static {
                f77975b = new f();
            }

            public f() {
                super("ShowBattle");
            }
        }

        public static final class g extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g f77976b = null;

            static {
                f77976b = new g();
            }

            public g() {
                super("ShowBattleFromPause");
            }
        }

        public static final class h extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final h f77977b = null;

            static {
                f77977b = new h();
            }

            public h() {
                super("ShowResult");
            }
        }

        public static final class i extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final i f77978b = null;

            static {
                f77978b = new i();
            }

            public i() {
                super("UpdateBattle");
            }
        }

        public final String toString() {
            return this.f77969a;
        }

        public b(String r100) {
            this.f77969a = r100;
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.livesdk.chatroom.model.interact.a0 f77979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f77980b;

        public static final class a extends c {
            public a(com.bytedance.android.livesdk.chatroom.model.interact.a0 r100) {
                Intrinsics.checkNotNullParameter(r100, "battleInfo");
                super(r100, "Finished");
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final b f77981c = null;

            static {
                f77981c = new b();
            }

            public b() {
                super((com.bytedance.android.livesdk.chatroom.model.interact.a0) vh7.f.c(com.bytedance.android.livesdk.chatroom.model.interact.a0.class), "None");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleStateMachine$c$c, reason: collision with other inner class name */
        public static final class C1204c extends c {
            public C1204c(com.bytedance.android.livesdk.chatroom.model.interact.a0 r100) {
                Intrinsics.checkNotNullParameter(r100, "battleInfo");
                super(r100, "OnGoing");
            }
        }

        public static final class d extends c {
            public d(com.bytedance.android.livesdk.chatroom.model.interact.a0 r100) {
                Intrinsics.checkNotNullParameter(r100, "battleInfo");
                super(r100, "OnPausing");
            }
        }

        public static final class e extends c {
            public e(com.bytedance.android.livesdk.chatroom.model.interact.a0 r100) {
                Intrinsics.checkNotNullParameter(r100, "battleInfo");
                super(r100, "ShowResult");
            }
        }

        public final boolean a() {
            if ((this instanceof C1204c) == false) goto L5;
        L10:
            return true;
        L5:
            if ((this instanceof e) == true) goto L10;
            if ((this instanceof d) == true) goto L10;
            return false;
        }

        public final boolean b() {
            if ((this instanceof b) == false) goto L5;
        L8:
            return true;
        L5:
            if ((this instanceof a) == true) goto L8;
            return false;
        }

        public final String toString() {
            return this.f77980b;
        }

        public c(com.bytedance.android.livesdk.chatroom.model.interact.a0 r100, String r101) {
            this.f77979a = r100;
            this.f77980b = r101;
        }
    }

    public final c a() {
        return this.f77955a.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuestBattleStateMachine(Function1<? super StateMachine.c<? extends c, ? extends a, ? extends b>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f77956b = r100;
        StateMachine.a r101 = StateMachine.f66079c;
        GuestBattleStateMachine$stateMachine$1 r102 = new GuestBattleStateMachine$stateMachine$1(this);
        r101.getClass();
        this.f77955a = StateMachine.a.a(r102);
    }

    public final void b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        StateMachine<c, a, b> r101 = this.f77955a;
        StateMachine.a r102 = StateMachine.f66079c;
        r101.d(r100, null);
    }
}
