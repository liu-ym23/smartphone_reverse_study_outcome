package com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine;

import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.live.kmp.statemachine.StateMachine;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class PkBaseStateMachine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateMachine<c, a, b> f92840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<StateMachine.c<? extends c, ? extends a, ? extends b>, Unit> f92841b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$Source;", "", "", "reqSrc", "Ljava/lang/String;", "getReqSrc", "()Ljava/lang/String;", "Init", "BattleMsg", "MetaUpdate", "PKTimeUp", "BattleFinishInstantKill", "BattleFinishTimeUp", "PunishTimeUp", "LinkerLeave", "RtcLinkerLeave", "CutShort", "MultipleInvite", "BattleFinishResponse", "DoublePkLinkInPeak", "RoomClose", "NormalToMultiple", "ScoreControl", "ChangeMode", "RelinkSuccess", "StartOpenGame", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Source extends Enum<Source> {
        public static final Source BattleFinishInstantKill = null;
        public static final Source BattleFinishResponse = null;
        public static final Source BattleFinishTimeUp = null;
        public static final Source BattleMsg = null;
        public static final Source ChangeMode = null;
        public static final Source CutShort = null;
        public static final Source DoublePkLinkInPeak = null;
        public static final Source Init = null;
        public static final Source LinkerLeave = null;
        public static final Source MetaUpdate = null;
        public static final Source MultipleInvite = null;
        public static final Source NormalToMultiple = null;
        public static final Source PKTimeUp = null;
        public static final Source PunishTimeUp = null;
        public static final Source RelinkSuccess = null;
        public static final Source RoomClose = null;
        public static final Source RtcLinkerLeave = null;
        public static final Source ScoreControl = null;
        public static final Source StartOpenGame = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Source[] f92842a = null;
        private final String reqSrc;

        public static Source valueOf(String r100) {
            return (Source) r27.a.a(Source.class, r100);
        }

        public static Source[] values() {
            return (Source[]) f92842a.clone();
        }

        /* JADX WARN: Multi-variable type inference failed */
        static {
            Source r100 = new Source("Init", 0, null, 1, null);
            Init = r100;
            Source r101 = new Source("BattleMsg", 1, null, 1, null);
            BattleMsg = r101;
            Source r102 = new Source("MetaUpdate", 2, 0 == true ? 1 : 0, 1, null);
            MetaUpdate = r102;
            Source r103 = new Source("PKTimeUp", 3, "PKTimeUp");
            PKTimeUp = r103;
            DefaultConstructorMarker r104 = null;
            Source r105 = new Source("BattleFinishInstantKill", 4, null, 1, r104);
            BattleFinishInstantKill = r105;
            Source r106 = new Source("BattleFinishTimeUp", 5, null, 1, null);
            BattleFinishTimeUp = r106;
            Source r107 = new Source("PunishTimeUp", 6, "PunishTimeUp");
            PunishTimeUp = r107;
            String r108 = null;
            int r109 = 1;
            Source r110 = new Source("LinkerLeave", 7, r108, r109, r104);
            LinkerLeave = r110;
            Source r111 = new Source("RtcLinkerLeave", 8, "RtcLinkerLeave");
            RtcLinkerLeave = r111;
            Source r112 = new Source("CutShort", 9, "CutShort");
            CutShort = r112;
            Source r113 = new Source("MultipleInvite", 10, r108, r109, r104);
            MultipleInvite = r113;
            String r114 = null;
            int r115 = 1;
            DefaultConstructorMarker r116 = null;
            Source r117 = new Source("BattleFinishResponse", 11, r114, r115, r116);
            BattleFinishResponse = r117;
            Source r118 = new Source("DoublePkLinkInPeak", 12, r114, r115, r116);
            DoublePkLinkInPeak = r118;
            Source r119 = new Source("RoomClose", 13, "RoomClose");
            RoomClose = r119;
            Source r120 = new Source("NormalToMultiple", 14, null, 1, r104);
            NormalToMultiple = r120;
            String r121 = null;
            int r122 = 1;
            DefaultConstructorMarker r123 = null;
            Source r124 = new Source("ScoreControl", 15, r121, r122, r123);
            ScoreControl = r124;
            Source r125 = new Source("ChangeMode", 16, r121, r122, r123);
            ChangeMode = r125;
            Source r126 = new Source("RelinkSuccess", 17, r121, r122, r123);
            RelinkSuccess = r126;
            Source r127 = new Source("StartOpenGame", 18, r121, r122, r123);
            StartOpenGame = r127;
            f92842a = new Source[]{r100, r101, r102, r103, r105, r106, r107, r110, r111, r112, r113, r117, r118, r119, r120, r124, r125, r126, r127};
        }

        public final String getReqSrc() {
            return this.reqSrc;
        }

        public Source(String r100, int r101, String r102) {
            super(r100, r101);
            this.reqSrc = r102;
        }

        public /* synthetic */ Source(String r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L5;
            r102 = "";
        L5:
            this(r100, r101, r102);
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Source f92843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f92844b;

        /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine$a$a, reason: collision with other inner class name */
        public static final class C1442a extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a f92845c;

            public C1442a(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r100, Source r101) {
                Intrinsics.checkNotNullParameter(r100, "pkInfo");
                Intrinsics.checkNotNullParameter(r101, "source");
                super(r101, "BattleFinishEvent");
                this.f92845c = r100;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final b f92846c = null;

            static {
                f92846c = new b();
            }

            public b() {
                super(Source.Init, "BattleForceReset");
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a f92847c;

            public c(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r100, Source r101) {
                Intrinsics.checkNotNullParameter(r100, "pkInfo");
                Intrinsics.checkNotNullParameter(r101, "source");
                super(r101, "BattleInterrupt");
                this.f92847c = r100;
            }
        }

        public static final class d extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a f92848c;

            public d(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r100, Source r101) {
                Intrinsics.checkNotNullParameter(r100, "pkInfo");
                Intrinsics.checkNotNullParameter(r101, "source");
                super(r101, "BattleLinkerLeave");
                this.f92848c = r100;
            }
        }

        public static final class e extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a f92849c;

            public e(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r100) {
                Intrinsics.checkNotNullParameter(r100, "pkInfo");
                super(Source.MetaUpdate, "BattleMetaUpdate");
                this.f92849c = r100;
            }
        }

        public static final class f extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a f92850c;

            public f(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r100) {
                Intrinsics.checkNotNullParameter(r100, "pkInfo");
                super(Source.BattleMsg, "BattleMsg");
                this.f92850c = r100;
            }
        }

        public static final class g extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final g f92851c = null;

            static {
                f92851c = new g();
            }

            public g() {
                super(Source.PunishTimeUp, "BattlePunishTimeUp");
            }
        }

        public static final class h extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final h f92852c = null;

            static {
                f92852c = new h();
            }

            public h() {
                super(Source.DoublePkLinkInPeak, "BattleToLinkInPeak");
            }
        }

        public static final class i extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a f92853c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final boolean f92854d;

            public i(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r100, Source r101, boolean r102) {
                Intrinsics.checkNotNullParameter(r100, "pkInfo");
                Intrinsics.checkNotNullParameter(r101, "source");
                super(r101, "GetBattleState");
                this.f92853c = r100;
                this.f92854d = r102;
            }
        }

        public static final class j extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final j f92855c = null;

            static {
                f92855c = new j();
            }

            public j() {
                super(Source.Init, "OpenGameForceToLink");
            }
        }

        public final String toString() {
            return this.f92844b + '(' + this.f92843a + ')';
        }

        public a(Source r100, String r101) {
            this.f92843a = r100;
            this.f92844b = r101;
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f92856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f92857b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f92858c;

        public static final class a extends b {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final boolean f92859d;

            public a(c r100, c.b r101, boolean r102) {
                Intrinsics.checkNotNullParameter(r100, "from");
                Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
                super(r100, r101, "Finish");
                this.f92859d = r102;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine$b$b, reason: collision with other inner class name */
        public static final class C1443b extends b {
            public C1443b(c r100, c.a r101) {
                Intrinsics.checkNotNullParameter(r100, "from");
                Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
                super(r100, r101, "ForceReset");
            }
        }

        public static final class c extends b {
            public c(c r100, c.C1444c r101) {
                Intrinsics.checkNotNullParameter(r100, "from");
                Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
                super(r100, r101, "ShowPK");
            }
        }

        public static final class d extends b {
            public d(c r100, c.d r101) {
                Intrinsics.checkNotNullParameter(r100, "from");
                Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
                super(r100, r101, "ShowPenal");
            }
        }

        public final String toString() {
            return this.f92858c;
        }

        public b(c r100, c r101, String r102) {
            this.f92856a = r100;
            this.f92857b = r101;
            this.f92858c = r102;
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a f92860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Source f92861b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f92862c;

        public static final class a extends c {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final a f92863d = null;

            static {
                f92863d = new a();
            }

            public a() {
                super(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a(null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 32767), Source.Init, "Disable");
            }
        }

        public static final class b extends c {
            public b(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r100, Source r101) {
                Intrinsics.checkNotNullParameter(r100, "pkInfo");
                Intrinsics.checkNotNullParameter(r101, "source");
                super(r100, r101, "Finished");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine$c$c, reason: collision with other inner class name */
        public static final class C1444c extends c {
            public C1444c(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r100, Source r101) {
                Intrinsics.checkNotNullParameter(r100, "pkInfo");
                Intrinsics.checkNotNullParameter(r101, "source");
                super(r100, r101, "PK");
            }
        }

        public static final class d extends c {
            public d(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r100, Source r101) {
                Intrinsics.checkNotNullParameter(r100, "pkInfo");
                Intrinsics.checkNotNullParameter(r101, "source");
                super(r100, r101, "Penal");
            }
        }

        public final boolean a() {
            if ((this instanceof C1444c) == false) goto L5;
        L8:
            return true;
        L5:
            if ((this instanceof d) == true) goto L8;
            return false;
        }

        public final boolean b() {
            if ((this instanceof a) == false) goto L5;
        L8:
            return true;
        L5:
            if ((this instanceof b) == true) goto L8;
            return false;
        }

        public final RevPkState c() {
            if ((this instanceof a) == false) goto L6;
            return RevPkState.DISABLE;
        L6:
            if ((this instanceof C1444c) == false) goto L9;
            return RevPkState.PK;
        L9:
            if ((this instanceof d) == false) goto L12;
            return RevPkState.PENAL;
        L12:
            if ((this instanceof b) == false) goto L16;
            return RevPkState.FINISHED;
        L16:
            throw new NoWhenBranchMatchedException();
        }

        public final String toString() {
            return this.f92862c;
        }

        public c(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r100, Source r101, String r102) {
            this.f92860a = r100;
            this.f92861b = r101;
            this.f92862c = r102;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PkBaseStateMachine(Function1<? super StateMachine.c<? extends c, ? extends a, ? extends b>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f92841b = r100;
        StateMachine.a r101 = StateMachine.f255141c;
        Function1<StateMachine.GraphBuilder<c, a, b>, Unit> r102 = new PkBaseStateMachine$stateMachine$1(this);
        r101.getClass();
        this.f92840a = StateMachine.a.a(r102);
    }

    public final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        StateMachine.c(this.f92840a, r100);
    }
}
