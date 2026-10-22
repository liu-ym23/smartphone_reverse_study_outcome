package com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class ShowEntranceTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f84793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f84794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EntranceSource f84795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StateMachine<d, a, c> f84796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EntranceType f84797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f84798f;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/entrancemonitor/ShowEntranceTask$Stage;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Begin", "Running", "Success", CheckStatus.FAIL, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Stage extends Enum<Stage> {
        public static final Stage Begin = null;
        public static final Stage Fail = null;
        public static final Stage Running = null;
        public static final Stage Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Stage[] f84799a = null;
        private final String value;

        static {
            Stage r100 = new Stage("Begin", 0, GearStrategyConsts.EV_SELECT_BEGIN);
            Begin = r100;
            Stage r101 = new Stage("Running", 1, "running");
            Running = r101;
            Stage r102 = new Stage("Success", 2, "success");
            Success = r102;
            Stage r103 = new Stage(CheckStatus.FAIL, 3, "fail");
            Fail = r103;
            f84799a = new Stage[]{r100, r101, r102, r103};
        }

        public static Stage valueOf(String r100) {
            return (Stage) r27.a.a(Stage.class, r100);
        }

        public static Stage[] values() {
            return (Stage[]) f84799a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public Stage(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.ShowEntranceTask$a$a, reason: collision with other inner class name */
        public static final class C1290a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1290a f84800a = null;

            static {
                f84800a = new C1290a();
            }

            public C1290a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f84801a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final JSONObject f84802b;

            public b(String r100, JSONObject r101) {
                Intrinsics.checkNotNullParameter(r100, "stageDesc");
                this.f84801a = r100;
                this.f84802b = r101;
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f84803a = null;

            static {
                f84803a = new c();
            }

            public c() {
            }
        }

        public static final class d extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f84804a = null;

            static {
                f84804a = new d();
            }

            public d() {
            }
        }

        public static final class e extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f84805a = null;

            static {
                f84805a = new e();
            }

            public e() {
            }
        }

        public a() {
        }
    }

    public interface b {
        void a(String r100, EntranceType r101, EntranceSource r102, long r103, String r104, JSONObject r105);

        void b(String r100, EntranceType r101, EntranceSource r102, long r103);

        void c(String r100, EntranceType r101, EntranceSource r102);

        void d(String r100, EntranceType r101, EntranceSource r102, long r103, String r104);
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f84806a = null;

            static {
                f84806a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f84807a = null;

            static {
                f84807a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.ShowEntranceTask$c$c, reason: collision with other inner class name */
        public static final class C1291c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1291c f84808a = null;

            static {
                f84808a = new C1291c();
            }

            public C1291c() {
            }
        }

        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f84809a = null;

            static {
                f84809a = new d();
            }

            public d() {
            }
        }

        public static final class e extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f84810a = null;

            static {
                f84810a = new e();
            }

            public e() {
            }
        }

        public c() {
        }
    }

    public static abstract class d {

        public static final class a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f84811a = null;

            static {
                f84811a = new a();
            }

            public a() {
            }
        }

        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f84812a = null;

            static {
                f84812a = new b();
            }

            public b() {
            }
        }

        public static final class c extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f84813a = null;

            static {
                f84813a = new c();
            }

            public c() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.ShowEntranceTask$d$d, reason: collision with other inner class name */
        public static final class C1292d extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1292d f84814a = null;

            static {
                f84814a = new C1292d();
            }

            public C1292d() {
            }
        }

        public static final class e extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f84815a = null;

            static {
                f84815a = new e();
            }

            public e() {
            }
        }

        public d() {
        }
    }

    public ShowEntranceTask(EntranceType r100, EntranceMonitorContextService.b r101) {
        Intrinsics.checkNotNullParameter(r100, "entranceType");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f84797e = r100;
        this.f84798f = r101;
        StateMachine.a r102 = StateMachine.f66079c;
        Function1<StateMachine.GraphBuilder<d, a, c>, Unit> r103 = new ShowEntranceTask$stateMachine$1(this);
        r102.getClass();
        this.f84796d = StateMachine.a.a(r103);
    }

    public final void a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "stageDesc");
        StateMachine<d, a, c> r102 = this.f84796d;
        a.b r103 = new a.b(r100, r101);
        StateMachine.a r104 = StateMachine.f66079c;
        r102.d(r103, null);
    }
}
