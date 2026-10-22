package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class KtvRoomLyricsStateMachineConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final KtvRoomLyricsStateMachineConfig f145381a = null;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f145382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f145383b;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig$a$a, reason: collision with other inner class name */
        public static final class C2264a extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final C2264a f145384c = null;

            static {
                f145384c = new C2264a();
            }

            public C2264a() {
                super("CloseKtvRoom");
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final MusicPanel f145385c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final long f145386d;

            public b() {
                this(0);
            }

            public /* synthetic */ b(int r100) {
                this(null, 0);
            }

            public b(MusicPanel r100, long r101) {
                super("PauseSing");
                this.f145385c = r100;
                this.f145386d = r101;
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final MusicPanel f145387c;

            public c(MusicPanel r100) {
                Intrinsics.checkNotNullParameter(r100, "musicPanel");
                super("Prepare");
                this.f145387c = r100;
            }
        }

        public static final class d extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final com.bytedance.android.livesdk.ktvimpl.base.sei.k f145388c;

            public d() {
                this(null);
            }

            public d(com.bytedance.android.livesdk.ktvimpl.base.sei.k r100) {
                super("ResumeSing");
                this.f145388c = r100;
            }
        }

        public static final class e extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final MusicPanel f145389c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final com.bytedance.android.livesdk.ktvimpl.base.sei.k f145390d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final long f145391e;

            public e(MusicPanel r100, com.bytedance.android.livesdk.ktvimpl.base.sei.k r101, long r102) {
                super("Sing");
                this.f145389c = r100;
                this.f145390d = r101;
                this.f145391e = r102;
            }
        }

        public static final class f extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final List<com.bytedance.component.lyric.model.b> f145392c;

            public f(List<com.bytedance.component.lyric.model.b> r100) {
                Intrinsics.checkNotNullParameter(r100, "lyricsList");
                super("SingerBeginSing");
                this.f145392c = r100;
            }
        }

        public static final class g extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final g f145393c = null;

            static {
                f145393c = new g();
            }

            public g() {
                super("StartKtvRoom");
            }
        }

        public static final class h extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final h f145394c = null;

            static {
                f145394c = new h();
            }

            public h() {
                super("StopSing");
            }
        }

        public static final class i extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final MusicPanel f145395c;

            public i(MusicPanel r100) {
                Intrinsics.checkNotNullParameter(r100, "nextMusic");
                super("TuningNext");
                this.f145395c = r100;
            }
        }

        public final String toString() {
            return String.valueOf(this.f145382a);
        }

        public a(String r100) {
            this.f145382a = r100;
            this.f145383b = "";
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f145396a = null;

            static {
                f145396a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig$b$b, reason: collision with other inner class name */
        public static final class C2265b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C2265b f145397a = null;

            static {
                f145397a = new C2265b();
            }

            public C2265b() {
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f145398a = null;

            static {
                f145398a = new c();
            }

            public c() {
            }
        }

        public static final class d extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f145399a = null;

            static {
                f145399a = new d();
            }

            public d() {
            }
        }

        public static final class e extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final MusicPanel f145400a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final c f145401b;

            public e(MusicPanel r100, c r101) {
                Intrinsics.checkNotNullParameter(r100, "musicPanel");
                Intrinsics.checkNotNullParameter(r101, "snapshot");
                this.f145400a = r100;
                this.f145401b = r101;
            }
        }

        public static final class f extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final boolean f145402a;

            public f() {
                this(true);
            }

            public f(boolean r100) {
                this.f145402a = r100;
            }
        }

        public b() {
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f145403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MusicPanel f145404b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<com.bytedance.component.lyric.model.b> f145405c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L12;
            c r101 = (c) r100;
            if (this.f145403a == r101.f145403a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f145404b, r101.f145404b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f145405c, r101.f145405c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            long r100 = this.f145403a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            MusicPanel r102 = this.f145404b;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = r102.hashCode();
        L6:
            int r105 = (r101 + r104) * 31;
            List<com.bytedance.component.lyric.model.b> r106 = this.f145405c;
            if (r106 == null) goto L10;
            r103 = r106.hashCode();
        L10:
            return r105 + r103;
        L5:
            r104 = 0;
            goto L6
        }

        public final String toString() {
            return "SingStateSnapshot(progress=" + this.f145403a + ", currentMusic=" + this.f145404b + ", currentLyricsLines=" + this.f145405c + ")";
        }

        public c(long r100, MusicPanel r101, List<com.bytedance.component.lyric.model.b> r102) {
            Intrinsics.checkNotNullParameter(r101, "currentMusic");
            Intrinsics.checkNotNullParameter(r102, "currentLyricsLines");
            this.f145403a = r100;
            this.f145404b = r101;
            this.f145405c = r102;
        }

        public static c a(c r100, long r101, MusicPanel r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.f145403a;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.f145404b;
        L9:
            if ((r103 & 4) == 0) goto L11;
            List<com.bytedance.component.lyric.model.b> r104 = r100.f145405c;
        L12:
            r100.getClass();
            Intrinsics.checkNotNullParameter(r102, "currentMusic");
            Intrinsics.checkNotNullParameter(r104, "currentLyricsLines");
            return new c(r101, r102, r104);
        L11:
            r104 = null;
            goto L12
        }
    }

    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f145406a;

        public static final class a extends d {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final a f145407b = null;

            static {
                f145407b = new a();
            }

            public a() {
                super("Closed");
            }
        }

        public static final class b extends d {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final b f145408b = null;

            static {
                f145408b = new b();
            }

            public b() {
                super("Idle");
            }
        }

        public static abstract class c extends d {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final MusicPanel f145409b;

            public c(MusicPanel r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "currentMusic");
                Intrinsics.checkNotNullParameter(r101, "tag");
                super(r101);
                this.f145409b = r100;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig$d$d, reason: collision with other inner class name */
        public static final class C2274d extends c {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final c f145410c;

            public C2274d(MusicPanel r100, c r101) {
                Intrinsics.checkNotNullParameter(r100, "currentMusic");
                Intrinsics.checkNotNullParameter(r101, "snapshot");
                super(r100, "Paused");
                this.f145410c = r101;
            }
        }

        public static final class e extends c {
            public e(MusicPanel r100) {
                Intrinsics.checkNotNullParameter(r100, "currentMusic");
                super(r100, "Preparing");
            }
        }

        public static final class f extends c {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final com.bytedance.android.livesdk.ktvimpl.base.sei.k f145411c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final c f145412d;

            public f(MusicPanel r100, com.bytedance.android.livesdk.ktvimpl.base.sei.k r101, c r102) {
                Intrinsics.checkNotNullParameter(r100, "currentMusic");
                Intrinsics.checkNotNullParameter(r102, "snapshot");
                super(r100, "Singing");
                this.f145411c = r101;
                this.f145412d = r102;
            }
        }

        public final List<com.bytedance.component.lyric.model.b> a() {
            if ((this instanceof f) == false) goto L6;
            return ((f) this).f145412d.f145405c;
        L6:
            if ((this instanceof C2274d) == true) goto L11;
            return null;
        L11:
            return ((C2274d) this).f145410c.f145405c;
        }

        public final MusicPanel b() {
            if ((this instanceof c) == true) goto L7;
            return null;
        L7:
            return ((c) this).f145409b;
        }

        public final com.bytedance.android.livesdk.ktvimpl.base.sei.k c() {
            if ((this instanceof f) == true) goto L7;
            return null;
        L7:
            return ((f) this).f145411c;
        }

        public final String toString() {
            return String.valueOf(this.f145406a);
        }

        public d(String r100) {
            this.f145406a = r100;
        }
    }

    public KtvRoomLyricsStateMachineConfig() {
    }

    static {
        f145381a = new KtvRoomLyricsStateMachineConfig();
    }

    public static StateMachine a(Function1 r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ALogger.i("logKtvMainPath", "createStateMachine for listener, invoke class :".concat(KtvRoomLyricsStateMachineConfig.class.getSimpleName()));
        StateMachine.a r102 = StateMachine.f66079c;
        KtvRoomLyricsStateMachineConfig$createStateMachine$1 r103 = new KtvRoomLyricsStateMachineConfig$createStateMachine$1(r101, r100);
        r102.getClass();
        return StateMachine.a.a(r103);
    }

    public static StateMachine b(Function1 r100, d r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Intrinsics.checkNotNullParameter(r101, "initState");
        ALogger.i("logKtvMainPath", "createStateMachineForSinger, invoke class :".concat(KtvRoomLyricsStateMachineConfig.class.getSimpleName()));
        StateMachine.a r103 = StateMachine.f66079c;
        KtvRoomLyricsStateMachineConfig$createStateMachineForSinger$1 r104 = new KtvRoomLyricsStateMachineConfig$createStateMachineForSinger$1(r101, r102, r100);
        r103.getClass();
        return StateMachine.a.a(r104);
    }
}
