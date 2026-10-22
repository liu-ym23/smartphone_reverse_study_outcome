package com.bytedance.android.live.broadcastgame.opengame.service;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.message.ReviewApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.p;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0001:\u0001\u0007B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/service/PanelStateReportService;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/p;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "PanelState", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PanelStateReportService implements y10.a, com.bytedance.android.live.broadcastgame.opengame.panel.i, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f60949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f60950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f60951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f60952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PanelStateReportService$lifecycleObserver$1 f60953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PluginContext f60954f;

    public static final class PanelState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EnumC1009PanelState f60955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f60956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f60957c;

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.service.PanelStateReportService$PanelState$PanelState, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/service/PanelStateReportService$PanelState$PanelState;", "", "Show", "Hide", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum EnumC1009PanelState extends Enum<EnumC1009PanelState> {
            public static final EnumC1009PanelState Hide = null;
            public static final EnumC1009PanelState Show = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ EnumC1009PanelState[] f60958a = null;

            static {
                EnumC1009PanelState r100 = new EnumC1009PanelState("Show", 0);
                Show = r100;
                EnumC1009PanelState r101 = new EnumC1009PanelState("Hide", 1);
                Hide = r101;
                f60958a = new EnumC1009PanelState[]{r100, r101};
            }

            public static EnumC1009PanelState valueOf(String r100) {
                return (EnumC1009PanelState) r27.a.a(EnumC1009PanelState.class, r100);
            }

            public static EnumC1009PanelState[] values() {
                return (EnumC1009PanelState[]) f60958a.clone();
            }

            public EnumC1009PanelState(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f60959a = null;

            static {
                f60959a = new a();
            }

            public a() {
            }

            @Override // io.reactivex.functions.Consumer
            public final /* bridge */ /* synthetic */ void accept(Object r100) {
                Response r101 = (Response) r100;
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ EnumC1009PanelState f60960a;

            public b(EnumC1009PanelState r100) {
                this.f60960a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                ALogger.d("ReportHelper", "report: " + this.f60960a + ' ' + ((Throwable) r100).getMessage());
            }
        }

        public final Disposable a(EnumC1009PanelState r100) {
            if (StringsKt.isBlank(this.f60956b) == false) goto L5;
        L21:
            return null;
        L5:
            if (this.f60957c <= 0) goto L21;
            if (this.f60955a != r100) goto L10;
            boolean r101 = false;
        L11:
            if (r101 == false) goto L21;
            int r102 = f.f61001a[r100.ordinal()];
            if (r102 != 1) goto L15;
            Lazy r103 = LiveOpenGameClient.f60290d;
            Observable<Response<Object>> r104 = ((ReviewApi) LiveOpenGameClient.a.a().a(ReviewApi.class)).reportPanelShow(this.f60956b, this.f60957c);
        L23:
            return r104.subscribe(a.f60959a, new b(r100));
        L15:
            if (r102 != 2) goto L18;
            Lazy r105 = LiveOpenGameClient.f60290d;
            r104 = ((ReviewApi) LiveOpenGameClient.a.a().a(ReviewApi.class)).reportPanelHide(this.f60956b, this.f60957c);
            goto L23
        L18:
            throw new NoWhenBranchMatchedException();
        L10:
            this.f60955a = r100;
            r101 = true;
            goto L11
        }

        public PanelState(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "appId");
            this.f60956b = r100;
            this.f60957c = r101;
            this.f60955a = EnumC1009PanelState.Hide;
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void c() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void fail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
    }

    @Override // y10.a
    public final void g() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void launch() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void onBackPressed() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void onPanelCancel() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void start() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void a() {
        if (this.f60954f.m() != PluginType.LYNX) goto L5;
    L6:
        Context r100 = this.f60954f.getContext();
        if ((r100 instanceof AppCompatActivity) == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L14;
        ((AppCompatActivity) r100).getLifecycle().addObserver(this.f60953e);
        return;
    L14:
        return;
    L5:
        if (this.f60954f.m() == PluginType.SONIC_GAME) goto L6;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void b() {
        if (this.f60954f.m() != PluginType.LYNX) goto L5;
    L6:
        Context r100 = this.f60954f.getContext();
        if ((r100 instanceof AppCompatActivity) == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L12;
        ((AppCompatActivity) r100).getLifecycle().removeObserver(this.f60953e);
    L12:
        d();
        return;
    L5:
        if (this.f60954f.m() != PluginType.SONIC_GAME) goto L12;
        goto L6
    }

    public final void d() {
        PanelState r100 = (PanelState) this.f60952d.getValue();
        r100.getClass();
        r100.a(PanelState.EnumC1009PanelState.Hide);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void hide() {
        d();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void stop() {
        d();
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.android.live.broadcastgame.opengame.service.PanelStateReportService$lifecycleObserver$1] */
    public PanelStateReportService(PluginContext r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        new CompositeDisposable();
        this.f60954f = r100;
        this.f60949a = LazyKt.lazy(new PanelStateReportService$appId$2(this));
        this.f60950b = LazyKt.lazy(new PanelStateReportService$roomId$2(this));
        this.f60952d = LazyKt.lazy(new PanelStateReportService$panelState$2(this));
        this.f60953e = new PanelStateReportService$lifecycleObserver$1(this);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void l(Map<String, String> r100) {
        PanelState r101 = (PanelState) this.f60952d.getValue();
        r101.getClass();
        r101.a(PanelState.EnumC1009PanelState.Show);
    }
}
