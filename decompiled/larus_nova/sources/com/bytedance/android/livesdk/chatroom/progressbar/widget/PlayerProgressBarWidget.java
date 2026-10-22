package com.bytedance.android.livesdk.chatroom.progressbar.widget;

import am2.x;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.l;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.progressbar.IProgressCastService;
import com.bytedance.android.livesdk.chatroom.progressbar.ui.PlayerSeekBar;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSSeekBarMarkRepelStack;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/progressbar/widget/PlayerProgressBarWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/progressbar/ui/PlayerSeekBar$b;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PlayerProgressListener", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class PlayerProgressBarWidget extends LiveRecyclableWidget implements PlayerSeekBar.b {
    public static final /* synthetic */ int B = 0;
    public Rect A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f107895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f107896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f107897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f107898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f107899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f107900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f107901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CompositeDisposable f107902h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public o f107903i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public IPlayerProgressService f107904j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PlayerProgressServiceContext f107905k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.progressbar.a f107906l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.progressbar.c f107907m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.progressbar.b f107908n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public IProgressCastService f107909o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f107910p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f107911q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f107912r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f107913s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f107914t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f107915u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f107916v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f107917w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f107918x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f107919y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f107920z;

    public static final class PlayerProgressListener implements com.bytedance.android.livesdk.chatroom.progressbar.ui.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PlayerProgressServiceContext f107921a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IPlayerProgressService f107922b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f107923c;

        @Override // com.bytedance.android.livesdk.chatroom.progressbar.ui.a
        public final void B() {
            IPlayerProgressService r100 = this.f107922b;
            if (r100 == null) goto L6;
            r100.handleProgressListener(PlayerProgressBarWidget$PlayerProgressListener$onPlayerSeekStart$1.INSTANCE);
            return;
        }

        @Override // com.bytedance.android.livesdk.chatroom.progressbar.ui.a
        public final void C() {
            PlayerProgressServiceContext r100 = this.f107921a;
            if (r100 == null) goto L11;
            m<Boolean> r101 = r100.getAtLatest();
            if (r101 == null) goto L11;
            if (r101.getValue().booleanValue() == true) goto L11;
            if (this.f107923c == false) goto L11;
            this.f107921a.getShowLatestEvent().post(Boolean.TRUE);
        L11:
            IPlayerProgressService r102 = this.f107922b;
            if (r102 == null) goto L15;
            r102.handleProgressListener(PlayerProgressBarWidget$PlayerProgressListener$onPlayerSeekComplete$1.INSTANCE);
            return;
        }

        @Override // com.bytedance.android.livesdk.chatroom.progressbar.ui.a
        public final void D() {
            PlayerProgressServiceContext r100 = this.f107921a;
            if (r100 == null) goto L7;
            com.bytedance.live.datacontext.k<Boolean> r101 = r100.getShowLatestEvent();
            if (r101 == null) goto L7;
            r101.post(Boolean.FALSE);
        L7:
            IPlayerProgressService r102 = this.f107922b;
            if (r102 == null) goto L11;
            r102.handleProgressListener(PlayerProgressBarWidget$PlayerProgressListener$onPlayerBackToLatestComplete$1.INSTANCE);
            return;
        }

        @Override // com.bytedance.android.livesdk.chatroom.progressbar.ui.a
        public final void E() {
            IPlayerProgressService r100 = this.f107922b;
            if (r100 == null) goto L6;
            r100.handleProgressListener(PlayerProgressBarWidget$PlayerProgressListener$onPlayerBackToLatestStart$1.INSTANCE);
            return;
        }

        @Override // com.bytedance.android.livesdk.chatroom.progressbar.ui.a
        public final void onRenderStart() {
            IPlayerProgressService r100 = this.f107922b;
            if (r100 == null) goto L6;
            r100.handleProgressListener(PlayerProgressBarWidget$PlayerProgressListener$onRenderStart$1.INSTANCE);
            return;
        }

        @Override // com.bytedance.android.livesdk.chatroom.progressbar.ui.a
        public final void z() {
            IPlayerProgressService r100 = this.f107922b;
            if (r100 == null) goto L6;
            r100.handleProgressListener(PlayerProgressBarWidget$PlayerProgressListener$onVideoEnd$1.INSTANCE);
            return;
        }

        @Override // com.bytedance.android.livesdk.chatroom.progressbar.ui.a
        public final void A(long r100, long r101) {
            PlayerProgressServiceContext r102 = this.f107921a;
            if (r102 == null) goto L6;
            r102.getTotalTime().setValue(Long.valueOf(r101));
            r102.getCurrentTime().setValue(Long.valueOf(r100));
            r102.getPlayTimeInfo().setValue(new com.bytedance.android.livesdk.chatroom.vsplayer.model.b(r100, r101));
            return;
        }

        public PlayerProgressListener(PlayerProgressServiceContext r100, IPlayerProgressService r101, boolean r102) {
            this.f107921a = r100;
            this.f107922b = r101;
            this.f107923c = r102;
        }
    }

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerProgressBarWidget f107924a;

        public b(PlayerProgressBarWidget r100) {
            this.f107924a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Disposable r101 = this.f107924a.f107895a;
            if (r101 == null) goto L11;
            if ((!r101.isDisposed()) == true) goto L8;
            r101 = null;
        L8:
            if (r101 == null) goto L11;
            r101.dispose();
        L11:
            if (this.f107924a.Kq() == false) goto L29;
            IProgressCastService r102 = this.f107924a.f107909o;
            if (r102 == null) goto L15;
            r102.liveGoRealTime();
        L15:
            com.bytedance.android.livesdk.chatroom.progressbar.b r103 = this.f107924a.f107908n;
            if (r103 == null) goto L23;
            m<mf1.b> r104 = r103.c();
            if (r104 == null) goto L23;
            mf1.b r105 = r104.getValue();
            if (r105 == null) goto L23;
            if (r105.f513592a != true) goto L23;
            return;
        L23:
            com.bytedance.android.livesdk.chatroom.progressbar.b r106 = this.f107924a.f107908n;
            if (r106 == null) goto L48;
            m<mf1.b> r107 = r106.c();
            if (r107 == null) goto L49;
            r107.setValue(new mf1.b(true, true));
            return;
        L49:
            return;
        L48:
            return;
        L29:
            PlayerProgressServiceContext r108 = this.f107924a.f107905k;
            if (r108 == null) goto L34;
            m<Boolean> r109 = r108.getAtLatest();
            if (r109 == null) goto L34;
            r109.setValue(Boolean.TRUE);
        L34:
            PlayerProgressBarWidget r110 = this.f107924a;
            com.bytedance.android.livesdk.chatroom.progressbar.a r111 = r110.f107906l;
            if (r111 == null) goto L45;
            o r112 = r110.f107903i;
            if (r112 == null) goto L43;
            m<IRoom> r113 = r112.getRoom();
            if (r113 == null) goto L43;
            IRoom r114 = r113.getValue();
            if (r114 == null) goto L43;
            long r115 = r114.getId();
        L44:
            r111.a(r115, -1, true);
        L43:
            r115 = 0;
        L45:
            j0.l().sendLog("livesdk_reach_the_latest_icon_click", null, new Object[]{new x(), IRoom.class});
            this.f107924a.Pq();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerProgressBarWidget f107925a;

        public c(PlayerProgressBarWidget r100) {
            this.f107925a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            com.bytedance.android.livesdk.chatroom.vsplayer.model.d r111 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.d) r110;
            int r100 = r111.f118414a;
            if (r100 == 0) goto L36;
            Long r101 = null;
            if (r100 != 1) goto L7;
            PlayerProgressBarWidget r112 = this.f107925a;
            int r102 = PlayerProgressBarWidget.B;
            r112.Zq(null);
            return;
        L7:
            if (r100 != 2) goto L9;
            PlayerProgressBarWidget r103 = this.f107925a;
            IProgressCastService r104 = r103.f107909o;
            if (r104 == null) goto L19;
            m<Boolean> r105 = r104.castScreenMode(r103.dataCenter);
            if (r105 == null) goto L19;
            if (r105.getValue().booleanValue() != true) goto L19;
            return;
        L19:
            this.f107925a.Gq().o();
            if (this.f107925a.Kq() == true) goto L23;
            PlayerSeekBar.m(this.f107925a.Gq(), r111.f118415b, r111.f118416c, true, false, 0, 24);
        L23:
            if (this.f107925a.Mq() == true) goto L25;
            PlayerSeekBar.m(this.f107925a.Gq(), r111.f118415b, r111.f118416c, true, false, 0, 24);
        L32:
            IPlayerProgressService r113 = this.f107925a.f107904j;
            if (r113 == null) goto L41;
            r113.handleProgressListener2(PlayerProgressBarWidget$onLoad$12$3.INSTANCE, Boolean.TRUE);
            return;
        L41:
            return;
        L25:
            PlayerProgressServiceContext r106 = this.f107925a.f107905k;
            if (r106 == null) goto L30;
            m<Long> r107 = r106.getLimitStartTime();
            if (r107 == null) goto L30;
            r101 = r107.getValue();
        L30:
            if (r101 == null) goto L32;
            long r108 = r101.longValue();
            PlayerSeekBar.m(this.f107925a.Gq(), r111.f118415b, r111.f118416c, true, false, r108, 8);
            goto L32
        L9:
            if (r100 != 3) goto L45;
            PlayerProgressBarWidget r114 = this.f107925a;
            int r109 = PlayerProgressBarWidget.B;
            r114.Zq(null);
            return;
        L45:
            return;
        L36:
            PlayerProgressBarWidget r115 = this.f107925a;
            int r116 = PlayerProgressBarWidget.B;
            r115.Yq();
            IPlayerProgressService r117 = this.f107925a.f107904j;
            if (r117 == null) goto L44;
            r117.handleProgressListener2(PlayerProgressBarWidget$onLoad$12$1.INSTANCE, Boolean.TRUE);
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerProgressBarWidget f107926a;

        public d(PlayerProgressBarWidget r100) {
            this.f107926a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            PlayerProgressServiceContext r102 = this.f107926a.f107905k;
            if (r102 == null) goto L7;
            m<Long> r103 = r102.getCurrentTime();
            if (r103 == null) goto L7;
            r103.setValue(0L);
        L7:
            PlayerProgressServiceContext r104 = this.f107926a.f107905k;
            if (r104 == null) goto L12;
            m<Long> r105 = r104.getCurrentDisplayTime();
            if (r105 == null) goto L12;
            r105.setValue(0L);
        L12:
            PlayerProgressServiceContext r106 = this.f107926a.f107905k;
            if (r106 == null) goto L17;
            m<Long> r107 = r106.getTotalTime();
            if (r107 == null) goto L17;
            r107.setValue(0L);
        L17:
            this.f107926a.Gq().setMHideMarks(PlayerProgressBarWidget.xq(this.f107926a.f107903i));
            this.f107926a.Iq().setVisibility(8);
            PlayerProgressServiceContext r108 = this.f107926a.f107905k;
            if (r108 == null) goto L22;
            m<Boolean> r109 = r108.getAtLatest();
            if (r109 == null) goto L22;
            r109.setValue(Boolean.TRUE);
        L22:
            this.f107926a.Jq();
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerProgressBarWidget f107927a;

        public e(PlayerProgressBarWidget r100) {
            this.f107927a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = 0;
            if (((Boolean) r100).booleanValue() == false) goto L15;
            PlayerProgressBarWidget r102 = this.f107927a;
            View r103 = r102.contentView;
            int r104 = PlayerProgressBarWidget.B;
            if (r102.Kq() == false) goto L13;
            com.bytedance.android.livesdk.chatroom.progressbar.b r105 = this.f107927a.f107908n;
            if (r105 == null) goto L13;
            m<Boolean> r106 = r105.d();
            if (r106 == null) goto L13;
            if (r106.getValue().booleanValue() != true) goto L13;
        L14:
            r103.setVisibility(r101);
            return;
        L13:
            r101 = 8;
            goto L14
        L15:
            this.f107927a.contentView.setVisibility(0);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerProgressBarWidget f107928a;

        public f(PlayerProgressBarWidget r100) {
            this.f107928a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            PlayerProgressBarWidget r102 = this.f107928a;
            IProgressCastService r103 = r102.f107909o;
            if (r103 == null) goto L14;
            m<Boolean> r104 = r103.castScreenMode(r102.dataCenter);
            if (r104 == null) goto L14;
            if (r104.getValue().booleanValue() != true) goto L14;
            if (r101.booleanValue() == true) goto L11;
        L13:
            this.f107928a.contentView.setVisibility(8);
            return;
        L11:
            if (this.f107928a.Kq() == false) goto L13;
            this.f107928a.contentView.setVisibility(0);
            return;
        L14:
            this.f107928a.contentView.setVisibility(0);
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerProgressBarWidget f107929a;

        public g(PlayerProgressBarWidget r100) {
            this.f107929a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Long r111 = (Long) r110;
            PlayerProgressBarWidget r100 = this.f107929a;
            int r101 = PlayerProgressBarWidget.B;
            if (r100.Kq() == false) goto L49;
            com.bytedance.android.livesdk.chatroom.progressbar.b r102 = this.f107929a.f107908n;
            if (r102 == null) goto L10;
            m<Long> r103 = r102.a();
            if (r103 == null) goto L10;
            r103.setValue(r111);
        L10:
            PlayerProgressBarWidget r104 = this.f107929a;
            if (r104.f107915u == false) goto L13;
            return;
        L13:
            if (r104.containerView.getAlpha() <= 0) goto L15;
            boolean r112 = true;
        L16:
            com.bytedance.android.livesdk.chatroom.progressbar.b r105 = this.f107929a.f107908n;
            if (r105 == null) goto L23;
            m<Long> r106 = r105.getTotalTime();
            if (r106 == null) goto L23;
            Long r107 = r106.getValue();
            if (r107 == null) goto L23;
            long r108 = r107.longValue();
        L24:
            long r109 = r108;
            com.bytedance.android.livesdk.chatroom.progressbar.b r113 = this.f107929a.f107908n;
            if (r113 == null) goto L34;
            m<mf1.b> r114 = r113.c();
            if (r114 == null) goto L34;
            mf1.b r115 = r114.getValue();
            if (r115 == null) goto L34;
            if (r115.f513592a != true) goto L34;
            PlayerSeekBar.m(this.f107929a.Gq(), 1, 1, false, r112, 0, 16);
            return;
        L34:
            if (this.f107929a.Mq() == true) goto L36;
            PlayerSeekBar.m(this.f107929a.Gq(), r111.longValue(), r109, false, r112, 0, 16);
            return;
        L36:
            PlayerProgressServiceContext r116 = this.f107929a.f107905k;
            if (r116 == null) goto L41;
            m<Long> r117 = r116.getLimitStartTime();
            if (r117 == null) goto L41;
            Long r118 = r117.getValue();
        L42:
            if (r118 == null) goto L48;
            this.f107929a.Gq().l(r111.longValue(), r109, false, r112, r118.longValue());
            return;
        L48:
            return;
        L41:
            r118 = null;
        L23:
            r108 = 0;
            goto L24
        L15:
            r112 = false;
            goto L16
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerProgressBarWidget f107930a;

        public h(PlayerProgressBarWidget r100) {
            this.f107930a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L5;
            this.f107930a.Iq().setVisibility(0);
            return;
        L5:
            this.f107930a.Iq().setVisibility(8);
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerProgressBarWidget f107931a;

        public i(PlayerProgressBarWidget r100) {
            this.f107931a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L5;
            this.f107931a.Gq().setTouchAble(false);
            this.f107931a.Gq().setForceStayAtLatest(true);
            return;
        L5:
            this.f107931a.Gq().setForceStayAtLatest(false);
            this.f107931a.Gq().setTouchAble(true);
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerProgressBarWidget f107932a;

        public j(PlayerProgressBarWidget r100) {
            this.f107932a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            View r102 = this.f107932a.Iq();
            if (r101.booleanValue() == false) goto L18;
            o r103 = this.f107932a.f107903i;
            if (r103 == null) goto L9;
            com.bytedance.live.datacontext.j<l> r104 = r103.a2();
            if (r104 == null) goto L9;
            r104.c(PlayerProgressBarWidget$onLoad$8$1.INSTANCE);
        L9:
            Disposable r105 = this.f107932a.f107895a;
            if (r105 != null) goto L12;
        L17:
            this.f107932a.gr();
            int r106 = 0;
        L19:
            r102.setVisibility(r106);
            View r107 = this.f107932a.Iq();
            if (r101.booleanValue() == false) goto L22;
            float r108 = 1.0f;
        L23:
            r107.setAlpha(r108);
            com.bytedance.android.livesdk.chatroom.progressbar.c r109 = this.f107932a.f107907m;
            if (r109 == null) goto L26;
            r109.c();
        L26:
            this.f107932a.hr();
            Boolean r110 = Boolean.FALSE;
            if (Intrinsics.areEqual(r101, r110) == false) goto L41;
            PlayerProgressBarWidget r111 = this.f107932a;
            IProgressCastService r112 = r111.f107909o;
            if (r112 == null) goto L35;
            m<Boolean> r113 = r112.castScreenMode(r111.dataCenter);
            if (r113 == null) goto L35;
            if (r113.getValue().booleanValue() != true) goto L35;
            return;
        L35:
            if (((Boolean) this.f107932a.dataCenter.get("data_live_nomore_seek_to_latest_toast", r110)).booleanValue() == true) goto L43;
            this.f107932a.dataCenter.put("data_live_nomore_seek_to_latest_toast", r110);
            if (((Boolean) this.f107932a.dataCenter.get("data_live_jsb_seek_to_latest_toast", r110)).booleanValue() == true) goto L39;
            this.f107932a.fr();
        L39:
            this.f107932a.dataCenter.put("data_live_jsb_seek_to_latest_toast", r110);
            return;
        L43:
            return;
        L41:
            return;
        L22:
            r108 = 0.0f;
            goto L23
        L12:
            if ((!r105.isDisposed()) == true) goto L15;
            r105 = null;
        L15:
            if (r105 == null) goto L17;
            r105.dispose();
            goto L17
        L18:
            r106 = 8;
            goto L19
        }
    }

    public static final class k<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerProgressBarWidget f107933a;

        public k(PlayerProgressBarWidget r100) {
            this.f107933a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            mf1.b r101 = (mf1.b) r100;
            PlayerProgressBarWidget r102 = this.f107933a;
            int r103 = PlayerProgressBarWidget.B;
            if (r102.Kq() == false) goto L36;
            View r104 = this.f107933a.Iq();
            if (r101.f513592a == false) goto L8;
            int r105 = 8;
        L9:
            r104.setVisibility(r105);
            this.f107933a.hr();
            if (r101.f513592a == true) goto L12;
            return;
        L12:
            if (r101.f513593b == false) goto L33;
            PlayerProgressBarWidget r106 = this.f107933a;
            IProgressCastService r107 = r106.f107909o;
            if (r107 == null) goto L19;
            m<Boolean> r108 = r107.castScreenMode(r106.dataCenter);
            if (r108 == null) goto L19;
            if (r108.getValue().booleanValue() != true) goto L19;
            return;
        L19:
            DataCenter r109 = this.f107933a.dataCenter;
            Boolean r110 = Boolean.FALSE;
            if (((Boolean) r109.get("data_live_nomore_seek_to_latest_toast", r110)).booleanValue() == true) goto L35;
            this.f107933a.dataCenter.put("data_live_nomore_seek_to_latest_toast", r110);
            o r111 = this.f107933a.f107903i;
            if (r111 == null) goto L24;
            Boolean r112 = r111.isVSRoom();
        L26:
            if ((!Intrinsics.areEqual(r112, Boolean.TRUE)) == false) goto L28;
        L29:
            f2.c(this.f107933a.Eq(), 0);
        L30:
            this.f107933a.dataCenter.put("data_live_jsb_seek_to_latest_toast", r110);
            return;
        L28:
            if (((Boolean) this.f107933a.dataCenter.get("data_live_jsb_seek_to_latest_toast", r110)).booleanValue() == true) goto L30;
        L24:
            r112 = null;
            goto L26
        L35:
            return;
        L33:
            return;
        L8:
            r105 = 0;
            goto L9
        }
    }

    static {
    }

    private final TextView Fq() {
        return (TextView) this.f107896b.getValue();
    }

    public abstract com.bytedance.android.livesdk.chatroom.progressbar.c Aq(ConstraintLayout r100, View r101, PlayerSeekBar r102, DataCenter r103);

    public abstract long Bq();

    public abstract com.bytedance.android.livesdk.chatroom.progressbar.a Cq(PlayerProgressServiceContext r100, DataCenter r101, long r102, LifecycleOwner r103);

    public abstract String Eq();

    public final PlayerSeekBar Gq() {
        return (PlayerSeekBar) this.f107897c.getValue();
    }

    public final View Iq() {
        return (View) this.f107899e.getValue();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.ui.PlayerSeekBar.b
    public final void O3() {
    }

    public void Pq() {
    }

    public void Qq() {
    }

    public abstract void Rq();

    public abstract void Sq();

    public abstract void Wq();

    public final void Yq() {
        dr(true);
        if (this.f107910p == false) goto L5;
        this.f107914t = System.currentTimeMillis();
        br();
    L5:
        PlayerProgressServiceContext r100 = this.f107905k;
        if (r100 == null) goto L12;
        m<Float> r101 = r100.getProgress();
        if (r101 == null) goto L12;
        Float r102 = r101.getValue();
        if (r102 == null) goto L12;
        float r103 = r102.floatValue();
    L13:
        this.f107917w = r103;
        this.f107916v = -1.0f;
        this.f107918x = System.currentTimeMillis();
        PlayerProgressServiceContext r104 = this.f107905k;
        if (r104 == null) goto L20;
        n<com.bytedance.android.livesdk.chatroom.vsplayer.model.b> r105 = r104.getPlayTimeInfo();
        if (r105 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.b r106 = r105.getValue();
        if (r106 == null) goto L20;
        long r107 = r106.f118397a;
    L21:
        this.f107919y = r107;
        DataCenter r108 = this.dataCenter;
        if (r108 == null) goto L24;
        r108.put("video_pre_seek_record", Long.valueOf(r107));
    L24:
        Gq().o();
        return;
    L20:
        r107 = 0;
    L12:
        r103 = 0.0f;
        goto L13
    }

    public abstract boolean ar();

    public abstract void cr();

    public abstract boolean er();

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public int getLayoutId() {
        return R.layout.ttlive_progress_bar_widget_layout;
    }

    public void gr() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    public abstract boolean yq();

    public abstract IProgressCastService zq();

    public final void Jq() {
        com.bytedance.android.livesdk.chatroom.progressbar.a r100 = this.f107906l;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        o r101 = this.f107903i;
        if (r101 == null) goto L10;
        Long r102 = r101.a();
        if (r102 == null) goto L10;
        long r103 = r102.longValue();
    L11:
        long r104 = r103 * 1000;
        if (xq(this.f107903i) == false) goto L45;
        StringBuilder r105 = new StringBuilder("initFirstShowBridge: start initTime from cameraId:");
        o r106 = this.f107903i;
        Object r107 = null;
        if (r106 == null) goto L18;
        m<Long> r108 = r106.getCameraId();
        if (r108 == null) goto L18;
        Long r109 = r108.getValue();
    L19:
        r105.append(r109);
        ALogger.i("VSProgressBarWidget", r105.toString());
        o r110 = this.f107903i;
        if (r110 == null) goto L45;
        m<IRoom> r111 = r110.getRoom();
        if (r111 == null) goto L45;
        IRoom r112 = r111.getValue();
        if (r112 == null) goto L45;
        IEpisodeExtraInfo r113 = r112.getEpisodeComponentData();
        if (r113 == null) goto L45;
        List<IVSCameraInfo> r114 = r113.getCameraInfos();
        if (r114 == null) goto L45;
        Iterator<T> r115 = r114.iterator();
    L31:
        if (r115.hasNext() == false) goto L42;
        Object r116 = r115.next();
        long r117 = ((IVSCameraInfo) r116).getCameraId();
        o r118 = this.f107903i;
        if (r118 == null) goto L39;
        m<Long> r119 = r118.getCameraId();
        if (r119 == null) goto L39;
        if (r117 != r119.getValue().longValue()) goto L39;
        boolean r120 = true;
    L40:
        if (r120 == false) goto L31;
        r107 = r116;
    L39:
        r120 = false;
    L42:
        IVSCameraInfo r121 = (IVSCameraInfo) r107;
        if (r121 == null) goto L45;
        r104 = Math.max(r104, r121.getStartTime() * 1000);
    L18:
        r109 = null;
    L45:
        this.f107906l = Cq(this.f107905k, this.dataCenter, r104, this);
        PlayerProgressListener r122 = new PlayerProgressListener(this.f107905k, this.f107904j, yq());
        com.bytedance.android.livesdk.chatroom.progressbar.a r123 = this.f107906l;
        if (r123 == null) goto L48;
        r123.b(r122);
    L48:
        Unit r124 = Unit.INSTANCE;
        com.bytedance.android.livesdk.chatroom.progressbar.a r125 = this.f107906l;
        if (r125 == null) goto L51;
        r125.start();
    L51:
        ALogger.i("VSProgressBarWidget", "initFirstShowBridge, startTime:" + r104);
        return;
    L10:
        r103 = 0;
        goto L11
    }

    public final boolean Kq() {
        IProgressCastService r100 = this.f107909o;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isByteMatchCasting(this.dataCenter) != true) goto L7;
        return true;
    }

    public final boolean Mq() {
        PlayerProgressServiceContext r100 = this.f107905k;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getLimitTimeLength().getValue().longValue() != 0) goto L7;
        return false;
    L7:
        if (r100.getTotalTime().getValue().longValue() <= r100.getLimitTimeLength().getValue().longValue()) goto L13;
        return true;
    L13:
        return false;
    }

    public final void br() {
        if (this.f107911q == null) goto L13;
        Rect r100 = new Rect();
        Gq().getGlobalVisibleRect(r100);
        Rect r101 = this.A;
        if (r101 != null) goto L7;
    L8:
        this.A = r100;
        PlayerSeekBar r102 = Gq();
        Rect r103 = new Rect();
        View r104 = this.f107911q;
        if (r104 == null) goto L11;
        r104.getGlobalVisibleRect(r103);
    L11:
        float r105 = 14;
        float r106 = -((r100.left - r103.left) - UtilityKotlinExtentionsKt.h(r105));
        float r107 = r102.getWidth() + ((r103.right - r100.right) - UtilityKotlinExtentionsKt.h(r105));
        r102.setSlideLeft(r106);
        r102.setSlideRight(r107);
        return;
    L7:
        if ((!Intrinsics.areEqual(r100, r101)) == true) goto L8;
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onUnload() {
        this.f107902h.dispose();
        Disposable r100 = this.f107895a;
        if (r100 != null) goto L5;
    L10:
        this.f107902h.clear();
        this.f107905k = null;
        com.bytedance.android.livesdk.chatroom.progressbar.a r101 = this.f107906l;
        if (r101 == null) goto L13;
        r101.clear();
    L13:
        Gq().j();
        this.f107914t = 0;
        com.bytedance.android.livesdk.chatroom.progressbar.c r102 = this.f107907m;
        if (r102 == null) goto L16;
        r102.release();
    L16:
        this.f107911q = null;
        return;
    L5:
        if ((!r100.isDisposed()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r100.dispose();
        goto L10
    }

    public PlayerProgressBarWidget() {
        this.f107896b = LazyKt.lazy(new PlayerProgressBarWidget$vsProgressCurrentTime$2(this));
        this.f107897c = LazyKt.lazy(new PlayerProgressBarWidget$vsProgressSeekBar$2(this));
        this.f107898d = LazyKt.lazy(new PlayerProgressBarWidget$progressEndArea$2(this));
        this.f107899e = LazyKt.lazy(new PlayerProgressBarWidget$vsSeekToNow$2(this));
        this.f107900f = LazyKt.lazy(new PlayerProgressBarWidget$vsSeekToNowTip$2(this));
        this.f107901g = LazyKt.lazy(new PlayerProgressBarWidget$vsHighLightPopHolder$2(this));
        this.f107902h = new CompositeDisposable();
    }

    public void fr() {
        MiddlewareRoomContext r100 = o3.b();
        if (r100 == null) goto L8;
        m<Boolean> r101 = r100.getVsInChorusConcert();
        if (r101 == null) goto L8;
        if (r101.getValue().booleanValue() != true) goto L8;
        return;
    L8:
        f2.c(Eq(), 0);
    }

    public void hr() {
        if (Iq().getVisibility() != 8) goto L7;
        View r100 = (View) this.f107898d.getValue();
        if (r100 == null) goto L11;
        UtilityKotlinExtentionsKt.t(r100);
    L11:
        if (isScreenPortrait() != true) goto L18;
        View r101 = (View) this.f107898d.getValue();
        if (r101 == null) goto L16;
        a1.n(r101, 0);
    L16:
        if (Iq().getVisibility() != 0) goto L33;
        a1.n(Iq(), 0);
        return;
    L33:
        return;
    L18:
        View r102 = (View) this.f107898d.getValue();
        if (r102 == null) goto L26;
        if (PadConfigUtils.c() == false) goto L23;
        float r103 = UtilityKotlinExtentionsKt.h(24.0f);
    L24:
        a1.n(r102, (int) r103);
        goto L26
    L23:
        r103 = UtilityKotlinExtentionsKt.h(12.0f);
    L26:
        if (Iq().getVisibility() != 0) goto L35;
        View r104 = Iq();
        if (PadConfigUtils.c() == false) goto L30;
        float r105 = UtilityKotlinExtentionsKt.h(24.0f);
    L31:
        a1.n(r104, (int) r105);
        return;
    L30:
        r105 = UtilityKotlinExtentionsKt.h(12.0f);
        goto L31
    L35:
        return;
    L7:
        View r106 = (View) this.f107898d.getValue();
        if (r106 == null) goto L11;
        UtilityKotlinExtentionsKt.w(r106);
        goto L11
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public void onResume() {
        super.onResume();
        if (this.f107920z == true) goto L10;
        o r100 = this.f107903i;
        if (r100 == null) goto L11;
        com.bytedance.live.datacontext.j<l> r101 = r100.a2();
        if (r101 == null) goto L12;
        r101.c(new PlayerProgressBarWidget$logShow$1(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onClear() {
        super.onClear();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onPause() {
        super.onPause();
    }

    public static final /* synthetic */ TextView wq(PlayerProgressBarWidget r100) {
        return r100.Fq();
    }

    public static boolean xq(o r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        m<Long> r101 = r100.getCameraId();
        if (r101 == null) goto L10;
        Long r102 = r101.getValue();
        if (r102 == null) goto L10;
        long r103 = r102.longValue();
    L12:
        if (r103 <= 0) goto L28;
        m<Long> r104 = r100.getCameraId();
        Long r105 = null;
        if (r104 == null) goto L16;
        Long r106 = r104.getValue();
    L17:
        m<IRoom> r107 = r100.getRoom();
        if (r107 == null) goto L25;
        IRoom r108 = r107.getValue();
        if (r108 == null) goto L25;
        IEpisodeExtraInfo r109 = r108.getEpisodeComponentData();
        if (r109 == null) goto L25;
        r105 = Long.valueOf(r109.getDefaultCameraId());
    L25:
        if ((!Intrinsics.areEqual(r106, r105)) == false) goto L29;
        return true;
    L29:
        return false;
    L16:
        r106 = null;
        goto L17
    L28:
        return false;
    L10:
        r103 = 0;
        goto L12
    }

    public final void Lq(com.bytedance.android.livesdk.chatroom.vsplayer.model.e r210) {
        PlayerProgressServiceContext r100 = this.f107905k;
        if (r100 == null) goto L54;
        float r101 = this.f107916v;
        if (r101 != (-1.0f)) goto L7;
        return;
    L7:
        if (Nq(r101) == false) goto L10;
        long r102 = r100.getTotalTime().getValue().longValue();
    L13:
        IPlayerProgressService r103 = this.f107904j;
        if (r103 == null) goto L17;
        r103.seekTo(r102);
    L17:
        if (this.f107918x > 0) goto L25;
        o r104 = this.f107903i;
        if (r104 == null) goto L21;
        Boolean r105 = r104.isVSRoom();
    L23:
        if ((!Intrinsics.areEqual(r105, Boolean.TRUE)) == true) goto L25;
        return;
    L21:
        r105 = null;
    L25:
        if (Mq() == true) goto L27;
        m<Long> r106 = r100.getTotalTime();
    L28:
        String r107 = String.valueOf((int) ((Math.abs(this.f107916v - this.f107917w) * r106.getValue().longValue()) / 100000));
        if (this.f107916v <= this.f107917w) goto L31;
        String r108 = "forward";
    L32:
        long r110 = System.currentTimeMillis() - this.f107918x;
        this.f107918x = 0;
        o r109 = this.f107903i;
        if (r109 == null) goto L35;
        Boolean r111 = r109.isVSRoom();
    L36:
        Boolean r112 = Boolean.TRUE;
        if (Intrinsics.areEqual(r111, r112) == false) goto L47;
        Pair[] r113 = new Pair[7];
        if (Intrinsics.areEqual(r100.isPlaying(), r112) == false) goto L41;
        Object r114 = "0";
    L42:
        r113[0] = TuplesKt.to("vs_is_pause", r114);
        r113[1] = TuplesKt.to("vs_slide_duration", r107);
        r113[2] = TuplesKt.to("vs_slide_direction", r108);
        r113[3] = TuplesKt.to("duration", String.valueOf(r110));
        r113[4] = TuplesKt.to("vs_start_watch_record", String.valueOf(this.f107919y));
        r113[5] = TuplesKt.to("vs_exit_watch_record", String.valueOf(r102));
        if (r210 == null) goto L45;
        Object r115 = "1";
    L46:
        r113[6] = TuplesKt.to("is_bubble_info", r115);
        Map<String, String> r116 = MapsKt.mapOf(r113);
    L52:
        j0.l().sendLog("livesdk_progress_bar_slide", r116, new Object[]{new x(), IRoom.class});
        return;
    L45:
        r115 = null;
        goto L46
    L41:
        r114 = "1";
        goto L42
    L47:
        Pair[] r117 = new Pair[6];
        if (Intrinsics.areEqual(r100.isPlaying(), r112) == false) goto L50;
        Object r118 = "0";
    L51:
        r117[0] = TuplesKt.to("is_pause", r118);
        r117[1] = TuplesKt.to("slide_duration", r107);
        r117[2] = TuplesKt.to("slide_direction", r108);
        r117[3] = TuplesKt.to("duration", String.valueOf(r110));
        r117[4] = TuplesKt.to("start_watch_record", String.valueOf(this.f107919y));
        r117[5] = TuplesKt.to("exit_watch_record", String.valueOf(r102));
        r116 = MapsKt.mapOf(r117);
        goto L52
    L50:
        r118 = "1";
        goto L51
    L35:
        r111 = null;
        goto L36
    L31:
        r108 = "back";
        goto L32
    L27:
        r106 = r100.getLimitTimeLength();
        goto L28
    L10:
        if (Mq() == true) goto L12;
        r102 = MathKt.roundToLong((this.f107916v / 100) * r100.getTotalTime().getValue().floatValue());
        goto L13
    L12:
        r102 = MathKt.roundToLong(r100.getTotalTime().getValue().floatValue() - (r100.getLimitTimeLength().getValue().floatValue() * (1 - (this.f107916v / 100))));
        goto L13
    }

    public boolean Nq(float r100) {
        if (MathKt.roundToInt(r100) != 100) goto L5;
        return true;
    L5:
        return false;
    }

    public final void Tq(boolean r100) {
        if (isScreenPortrait() == true) goto L5;
        return;
    L5:
        if (r100 == true) goto L7;
    L10:
        if (r100 == true) goto L21;
        PlayerProgressServiceContext r101 = this.f107905k;
        if (r101 == null) goto L22;
        m<Boolean> r102 = r101.getAtLatest();
        if (r102 != null) goto L16;
        return;
    L16:
        if (r102.getValue().booleanValue() == false) goto L18;
        return;
    L18:
        if (Iq().getVisibility() != 8) goto L25;
        UtilityKotlinExtentionsKt.w(Iq());
        return;
    L25:
        return;
    L22:
        return;
    L21:
        return;
    L7:
        if (Iq().getVisibility() != 0) goto L10;
        UtilityKotlinExtentionsKt.t(Iq());
    }

    public void Zq(com.bytedance.android.livesdk.chatroom.vsplayer.model.e r100) {
        dr(false);
        if (this.f107910p == true) goto L5;
    L11:
        Lq(r100);
        Gq().g();
        IPlayerProgressService r101 = this.f107904j;
        if (r101 == null) goto L15;
        r101.hideThumbProcessView();
        return;
    L15:
        return;
    L5:
        if (this.f107912r == false) goto L11;
        this.f107912r = false;
        ALogger.i("VSProgressBarWidget", "start shrink seek bar.");
        Gq().k();
        Wq();
        if (isScreenPortrait() == true) goto L11;
        if (er() == false) goto L11;
        UtilityKotlinExtentionsKt.w(Fq());
        goto L11
    }

    public final boolean bind(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bind");
        return this.f107902h.add(r100);
    }

    public final void dr(boolean r100) {
        this.f107915u = r100;
        PlayerProgressServiceContext r101 = this.f107905k;
        if (r101 == null) goto L8;
        m<Boolean> r102 = r101.isSeekbarOnTracking();
        if (r102 == null) goto L9;
        r102.setValue(Boolean.valueOf(this.f107915u));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.ui.PlayerSeekBar.b
    public final void od(PlayerSeekBar r110) {
        Intrinsics.checkNotNullParameter(r110, "seekBar");
        long r100 = System.currentTimeMillis();
        Iq().setAlpha(0.0f);
        if (this.f107910p == true) goto L5;
        return;
    L5:
        if (this.f107915u == true) goto L7;
        return;
    L7:
        if (this.f107912r == false) goto L9;
        return;
    L9:
        if ((r100 - this.f107914t) <= 50) goto L22;
        this.f107912r = true;
        ALogger.i("VSProgressBarWidget", "start expand seek bar.");
        Rq();
        PlayerSeekBar r101 = Gq();
        r101.B = true;
        int r111 = r101.f107829e;
        r101.G1 = r111;
        r101.p(r101.P0, r101.V0, r101.f107851r, r101.f107846p, r101.f107852s, r101.f107850q, r101.f107828d, r111);
        View r112 = (View) this.f107898d.getValue();
        if (r112 == null) goto L14;
        UtilityKotlinExtentionsKt.u(r112);
    L14:
        if (isScreenPortrait() == false) goto L16;
        return;
    L16:
        if (er() == false) goto L24;
        UtilityKotlinExtentionsKt.u(Fq());
        return;
    L24:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onLoad(Object[] r110) {
        StringBuilder r100 = new StringBuilder("start to Load, dataCenter:");
        DataCenter r101 = this.dataCenter;
        mf1.b r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.hashCode());
    L6:
        r100.append(r103);
        ALogger.i("VSProgressBarWidget", r100.toString());
        IPlayerProgressService r104 = ((rk1.a) jc1.k.n(rk1.a.class)).M4(this.dataCenter);
        this.f107904j = r104;
        this.f107920z = false;
        if (r104 == null) goto L9;
        PlayerProgressServiceContext r105 = r104.provideContext(this.dataCenter);
    L10:
        this.f107905k = r105;
        Iq().setVisibility(8);
        this.f107902h = new CompositeDisposable();
        this.f107903i = ((IRoomContextService) jc1.k.n(IRoomContextService.class)).getRoomDataContext(this.dataCenter, 0);
        IProgressCastService r106 = zq();
        this.f107909o = r106;
        if (r106 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.progressbar.b r107 = r106.getProgressCastStreamShiftService();
    L14:
        this.f107908n = r107;
        Gq().setMIsFullScreen(!isScreenPortrait());
        PlayerSeekBar r108 = Gq();
        if (isScreenPortrait() != true) goto L17;
        int r109 = s1.f(4.0f);
    L18:
        r108.n(r109, -1.0f);
        o r111 = this.f107903i;
        if (r111 != null) goto L21;
    L25:
        TextView r112 = (TextView) this.f107900f.getValue();
        if (r112 == null) goto L28;
        r112.setText("看最新");
    L28:
        this.f107910p = true;
        PlayerSeekBar r113 = Gq();
        float r114 = s1.f(8.0f);
        Gq().n(r114, 2 * r114);
        float r115 = UtilityKotlinExtentionsKt.h(5);
        if (isScreenPortrait() == false) goto L31;
        int r116 = 20;
    L32:
        r113.post(new com.bytedance.android.livesdk.chatroom.progressbar.widget.a(r113, r115, UtilityKotlinExtentionsKt.h(r116), this, r110));
        if (er() == true) goto L35;
        UtilityKotlinExtentionsKt.t(Fq());
    L35:
        Gq().setOnSSSeekBarChangeListener(this);
        Gq().setDataCenter(this.dataCenter);
        if (this.f107905k == null) goto L155;
        long r117 = Bq();
        if (r117 <= 0) goto L44;
        PlayerProgressServiceContext r118 = this.f107905k;
        if (r118 == null) goto L44;
        m<Long> r119 = r118.getLimitTimeLength();
        if (r119 == null) goto L44;
        r119.setValue(Long.valueOf(r117));
    L44:
        o r120 = this.f107903i;
        if (r120 == null) goto L47;
        Boolean r121 = r120.isVSRoom();
    L48:
        Boolean r122 = Boolean.TRUE;
        if (Intrinsics.areEqual(r121, r122) == false) goto L52;
        this.f107907m = Aq((ConstraintLayout) this.f107901g.getValue(), Iq(), Gq(), this.dataCenter);
    L52:
        if (PadConfigUtils.c() == true) goto L63;
        o r123 = this.f107903i;
        if (r123 == null) goto L57;
        Boolean r124 = r123.isVSVerticalStream();
    L59:
        if (Intrinsics.areEqual(r124, r122) == true) goto L63;
        if (isScreenPortrait() == false) goto L63;
        boolean r125 = false;
    L66:
        if (er() == false) goto L68;
        UtilityKotlinExtentionsKt.z(Fq(), r125);
    L68:
        PlayerProgressServiceContext r126 = this.f107905k;
        if (r126 == null) goto L75;
        m<Long> r127 = r126.getCurrentDisplayTime();
        if (r127 == null) goto L75;
        Disposable r128 = i80.a.a(r127, new AnonymousClass1(this));
        if (r128 == null) goto L75;
        bind(r128);
    L75:
        com.bytedance.android.livesdk.chatroom.progressbar.b r129 = this.f107908n;
        if (r129 == null) goto L82;
        m<Long> r130 = r129.a();
        if (r130 == null) goto L82;
        Disposable r131 = i80.a.a(r130, new AnonymousClass2(this));
        if (r131 == null) goto L82;
        bind(r131);
    L82:
        PlayerProgressServiceContext r132 = this.f107905k;
        if (r132 == null) goto L89;
        m<Long> r133 = r132.getCurrentTime();
        if (r133 == null) goto L89;
        Disposable r134 = i80.a.a(r133, new AnonymousClass3(this));
        if (r134 == null) goto L89;
        bind(r134);
    L89:
        PlayerProgressServiceContext r135 = this.f107905k;
        if (r135 == null) goto L96;
        m<Long> r136 = r135.getTotalTime();
        if (r136 == null) goto L96;
        Disposable r137 = i80.a.a(r136, new AnonymousClass4(this));
        if (r137 == null) goto L96;
        bind(r137);
    L96:
        PlayerProgressServiceContext r138 = this.f107905k;
        if (r138 == null) goto L105;
        m<Boolean> r139 = r138.getShowSeekToNow();
        if (r139 == null) goto L105;
        Observable<Boolean> r140 = r139.a();
        if (r140 == null) goto L105;
        Disposable r141 = r140.subscribe(new h(this));
        if (r141 == null) goto L105;
        bind(r141);
    L105:
        PlayerProgressServiceContext r142 = this.f107905k;
        if (r142 == null) goto L112;
        m<Boolean> r143 = r142.getDisableSeek();
        if (r143 == null) goto L112;
        Boolean r144 = r143.getValue();
        if (r144 == null) goto L112;
        Gq().setTouchAble(!r144.booleanValue());
    L112:
        PlayerProgressServiceContext r145 = this.f107905k;
        if (r145 == null) goto L121;
        m<Boolean> r146 = r145.getDisableSeek();
        if (r146 == null) goto L121;
        Observable<Boolean> r147 = r146.a();
        if (r147 == null) goto L121;
        Disposable r148 = r147.subscribe(new i(this));
        if (r148 == null) goto L121;
        bind(r148);
    L121:
        PlayerProgressServiceContext r149 = this.f107905k;
        if (r149 == null) goto L130;
        com.bytedance.live.datacontext.k<Boolean> r150 = r149.getShowLatestEvent();
        if (r150 == null) goto L130;
        PublishSubject r151 = r150.onEvent();
        if (r151 == null) goto L130;
        Disposable r152 = r151.subscribe(new j(this));
        if (r152 == null) goto L130;
        bind(r152);
    L130:
        com.bytedance.android.livesdk.chatroom.progressbar.b r153 = this.f107908n;
        if (r153 == null) goto L139;
        m<mf1.b> r154 = r153.c();
        if (r154 == null) goto L139;
        Observable<mf1.b> r155 = r154.a();
        if (r155 == null) goto L139;
        Disposable r156 = r155.subscribe(new k(this));
        if (r156 == null) goto L139;
        bind(r156);
    L139:
        Iq().setOnClickListener(new b(this));
        PlayerProgressServiceContext r157 = this.f107905k;
        if (r157 == null) goto L146;
        VSSeekBarMarkRepelStack r158 = r157.getProgressMarkStack();
        if (r158 == null) goto L146;
        Function2<VSSeekBarMarkRepelStack, String, Unit> r159 = new AnonymousClass11(this);
        Intrinsics.checkNotNullParameter(r159, "action");
        r159.invoke(r158, "notify_change_type_init");
        Disposable r160 = r158.f118396c.subscribe(new com.bytedance.android.livesdk.chatroom.vsplayer.model.f(r158, r159));
        if (r160 == null) goto L146;
        bind(r160);
    L146:
        PlayerProgressServiceContext r161 = this.f107905k;
        if (r161 == null) goto L155;
        com.bytedance.live.datacontext.k<com.bytedance.android.livesdk.chatroom.vsplayer.model.d> r162 = r161.getProgressGestureEvent();
        if (r162 == null) goto L155;
        PublishSubject r163 = r162.onEvent();
        if (r163 == null) goto L155;
        Disposable r164 = r163.subscribe(new c(this));
        if (r164 == null) goto L155;
        bind(r164);
        goto L155
    L57:
        r124 = null;
    L63:
        r125 = true;
        goto L66
    L47:
        r121 = null;
    L155:
        PlayerProgressServiceContext r165 = this.f107905k;
        if (r165 == null) goto L166;
        m<Boolean> r166 = r165.getAtLatest();
        if (r166 == null) goto L166;
        if (r166.getValue().booleanValue() == true) goto L166;
        Iq().setVisibility(0);
        gr();
        o r167 = this.f107903i;
        if (r167 == null) goto L166;
        com.bytedance.live.datacontext.j<l> r168 = r167.a2();
        if (r168 == null) goto L166;
        r168.c(AnonymousClass13.INSTANCE);
    L166:
        Jq();
        o r169 = this.f107903i;
        if (r169 == null) goto L175;
        m<Long> r170 = r169.getCameraId();
        if (r170 == null) goto L175;
        Observable<Long> r171 = r170.a();
        if (r171 == null) goto L175;
        Disposable r172 = r171.subscribe(new d(this));
        if (r172 == null) goto L175;
        bind(r172);
    L175:
        hr();
        IProgressCastService r173 = this.f107909o;
        if (r173 == null) goto L206;
        m<Boolean> r174 = r173.castScreenMode(this.dataCenter);
        if (r174 == null) goto L206;
        if (r174.getValue().booleanValue() != true) goto L206;
        if (Kq() == false) goto L205;
        com.bytedance.android.livesdk.chatroom.progressbar.b r175 = this.f107908n;
        if (r175 == null) goto L190;
        m<Boolean> r176 = r175.d();
        if (r176 == null) goto L190;
        if (r176.getValue().booleanValue() != true) goto L190;
        this.contentView.setVisibility(0);
    L191:
        com.bytedance.android.livesdk.chatroom.progressbar.b r177 = this.f107908n;
        if (r177 == null) goto L196;
        m<mf1.b> r178 = r177.c();
        if (r178 == null) goto L196;
        r102 = r178.getValue();
    L196:
        com.bytedance.android.livesdk.chatroom.progressbar.b r179 = this.f107908n;
        if (r179 == null) goto L207;
        m<mf1.b> r180 = r179.c();
        if (r180 == null) goto L207;
        if (r102 == null) goto L203;
        boolean r181 = r102.f513592a;
    L204:
        r180.setValue(new mf1.b(r181, false));
        goto L207
    L203:
        r181 = true;
    L207:
        IProgressCastService r182 = this.f107909o;
        if (r182 == null) goto L216;
        m<Boolean> r183 = r182.castScreenMode(this.dataCenter);
        if (r183 == null) goto L216;
        Observable<Boolean> r184 = r183.a();
        if (r184 == null) goto L216;
        Disposable r185 = r184.subscribe(new e(this));
        if (r185 == null) goto L216;
        bind(r185);
    L216:
        com.bytedance.android.livesdk.chatroom.progressbar.b r186 = this.f107908n;
        if (r186 == null) goto L225;
        m<Boolean> r187 = r186.d();
        if (r187 == null) goto L225;
        Observable<Boolean> r188 = r187.a();
        if (r188 == null) goto L225;
        Disposable r189 = r188.subscribe(new f(this));
        if (r189 == null) goto L225;
        bind(r189);
    L225:
        cr();
        com.bytedance.android.livesdk.chatroom.progressbar.b r190 = this.f107908n;
        if (r190 == null) goto L234;
        m<Long> r191 = r190.getCurrentTime();
        if (r191 == null) goto L234;
        Observable<Long> r192 = r191.a();
        if (r192 == null) goto L234;
        Disposable r193 = r192.subscribe(new g(this));
        if (r193 == null) goto L234;
        bind(r193);
    L234:
        r3.c(Iq(), s1.B(R.string.ttlive_match_seek_to_now_text), true);
        TextView r194 = Fq();
        Function0<String> r195 = new AnonymousClass18(this);
        Intrinsics.checkNotNullParameter(r195, "getDescription");
        if (r194 == null) goto L239;
        r3.a r196 = new r3.a(r194);
        r196.f156926b = r195;
        r196.f156927c = "播放进度";
        ViewCompat.setAccessibilityDelegate(r194, r196);
        return;
    L239:
        return;
    L190:
        this.contentView.setVisibility(8);
        goto L191
    L205:
        this.contentView.setVisibility(8);
    L206:
        this.contentView.setVisibility(0);
        goto L207
    L31:
        r116 = 24;
        goto L32
    L21:
        if (r111.isVSLive() != true) goto L25;
        TextView r197 = (TextView) this.f107900f.getValue();
        if (r197 == null) goto L28;
        r197.setText("回直播");
        goto L28
    L17:
        r109 = s1.f(5.0f);
        goto L18
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.ui.PlayerSeekBar.b
    public final void tq(PlayerSeekBar r100) {
        Intrinsics.checkNotNullParameter(r100, "seekBar");
        if (Kq() == false) goto L9;
        dr(true);
        if (this.f107910p == false) goto L7;
        this.f107914t = System.currentTimeMillis();
        br();
    L7:
        Gq().o();
        return;
    L9:
        Yq();
        IPlayerProgressService r101 = this.f107904j;
        if (r101 == null) goto L13;
        r101.handleProgressListener2(PlayerProgressBarWidget$onStartTrackingTouch$1.INSTANCE, Boolean.FALSE);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.ui.PlayerSeekBar.b
    public void Jk(PlayerSeekBar r100, com.bytedance.android.livesdk.chatroom.vsplayer.model.e r101) {
        Intrinsics.checkNotNullParameter(r100, "seekBar");
        Intrinsics.checkNotNullParameter(r101, "vsSeekBarMark");
        dr(false);
        PlayerProgressServiceContext r102 = this.f107905k;
        EpisodeHighLight r103 = null;
        if (r102 == null) goto L16;
        n<List<EpisodeHighLight>> r104 = r102.getHighLightList();
        if (r104 == null) goto L16;
        List<EpisodeHighLight> r105 = r104.getValue();
        if (r105 == null) goto L16;
        Iterator<T> r106 = r105.iterator();
    L10:
        if (r106.hasNext() == false) goto L14;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((EpisodeHighLight) r107).getDescription(), r101.f118421e) == false) goto L10;
    L15:
        final EpisodeHighLight r108 = (EpisodeHighLight) r107;
    L17:
        if (r108 != null) goto L20;
        ALogger.e("VSProgressBarWidget", "showHighLightBubbleView: can not find highLightItem for " + r101.f118421e + ", context:" + this.f107905k);
        return;
    L20:
        Function0<Unit> r109 = new PlayerProgressBarWidget$onCustomMarkClicked$1(this, r108);
        if (isScreenPortrait() == true) goto L23;
    L25:
        com.bytedance.android.livesdk.chatroom.progressbar.c r110 = this.f107907m;
        if (r110 != null) goto L28;
    L35:
        com.bytedance.android.livesdk.chatroom.progressbar.c r111 = this.f107907m;
        if (r111 == null) goto L38;
        r111.d(r101);
    L38:
        IPlayerProgressService r112 = this.f107904j;
        if (r112 == null) goto L45;
        r112.handleProgressListener3(PlayerProgressBarWidget$onCustomMarkClicked$2.INSTANCE, r108, Boolean.valueOf(ar()));
        return;
    L45:
        return;
    L28:
        if (r110.isShowing() != true) goto L35;
        com.bytedance.android.livesdk.chatroom.progressbar.c r113 = this.f107907m;
        if (r113 == null) goto L33;
        r103 = r113.a();
    L33:
        if (Intrinsics.areEqual(r103, r108) == false) goto L35;
        r109.invoke2();
        goto L38
    L23:
        if (PadConfigUtils.c() == true) goto L25;
        r109.invoke2();
        goto L38
    L14:
        r107 = null;
    L16:
        r108 = null;
        goto L17
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.ui.PlayerSeekBar.b
    public final void d7(PlayerSeekBar r100, com.bytedance.android.livesdk.chatroom.vsplayer.model.e r101) {
        Intrinsics.checkNotNullParameter(r100, "seekBar");
        if (Kq() == false) goto L64;
        int r102 = r100.getProgress();
        dr(false);
        if (r102 != 100) goto L11;
        com.bytedance.android.livesdk.chatroom.progressbar.b r103 = this.f107908n;
        if (r103 == null) goto L17;
        m<mf1.b> r104 = r103.c();
        if (r104 == null) goto L17;
        r104.setValue(new mf1.b(true, true));
    L17:
        if (this.f107910p == true) goto L19;
    L30:
        Iq().setAlpha(1.0f);
        com.bytedance.android.livesdk.chatroom.progressbar.b r105 = this.f107908n;
        long r106 = 0;
        if (r105 == null) goto L37;
        m<Long> r107 = r105.getTotalTime();
        if (r107 == null) goto L37;
        Long r108 = r107.getValue();
        if (r108 == null) goto L37;
        long r109 = r108.longValue();
    L39:
        if (Nq(this.f107916v) == false) goto L42;
        long r110 = r109;
    L52:
        com.bytedance.android.livesdk.chatroom.progressbar.b r111 = this.f107908n;
        if (r111 == null) goto L57;
        m<Long> r112 = r111.getCurrentTime();
        if (r112 == null) goto L57;
        r112.setValue(Long.valueOf(r110));
    L57:
        IProgressCastService r113 = this.f107909o;
        if (r113 == null) goto L60;
        r113.seekTo(r109 - r110);
    L60:
        Gq().g();
        IPlayerProgressService r114 = this.f107904j;
        if (r114 == null) goto L68;
        r114.hideThumbProcessView();
        return;
    L68:
        return;
    L42:
        if (Mq() == true) goto L44;
        r110 = MathKt.roundToLong((this.f107916v / 100) * r109);
        goto L52
    L44:
        float r115 = r109;
        PlayerProgressServiceContext r116 = this.f107905k;
        if (r116 == null) goto L51;
        m<Long> r117 = r116.getLimitTimeLength();
        if (r117 == null) goto L51;
        Long r118 = r117.getValue();
        if (r118 == null) goto L51;
        r106 = r118.longValue();
    L51:
        r110 = MathKt.roundToLong(r115 - (r106 * (1 - (this.f107916v / 100))));
    L37:
        r109 = 0;
        goto L39
    L19:
        if (this.f107912r == false) goto L30;
        this.f107912r = false;
        ALogger.i("VSProgressBarWidget", "start shrink seek bar.");
        Gq().k();
        if (isScreenPortrait() == true) goto L29;
        o r119 = this.f107903i;
        if (r119 == null) goto L29;
        if (r119.isVSLive() != true) goto L29;
        if (er() == false) goto L29;
        UtilityKotlinExtentionsKt.w(Fq());
    L29:
        Wq();
        goto L30
    L11:
        com.bytedance.android.livesdk.chatroom.progressbar.b r120 = this.f107908n;
        if (r120 == null) goto L17;
        m<mf1.b> r121 = r120.c();
        if (r121 == null) goto L17;
        r121.setValue(new mf1.b(false, false));
        goto L17
    L64:
        Zq(r101);
        IPlayerProgressService r122 = this.f107904j;
        if (r122 == null) goto L69;
        r122.handleProgressListener2(PlayerProgressBarWidget$onStopTrackingTouch$1.INSTANCE, Boolean.FALSE);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.ui.PlayerSeekBar.b
    public final void lg(PlayerSeekBar r100, boolean r101, com.bytedance.android.livesdk.chatroom.vsplayer.model.e r102) {
        Intrinsics.checkNotNullParameter(r100, "seekBar");
        if (r101 == false) goto L9;
        PlayerProgressServiceContext r103 = this.f107905k;
        if (r103 == null) goto L24;
        if (r102 == null) goto L25;
        r103.getThumbTitle().setValue(r102.f118421e);
        r103.getThumbHotLabel().setValue(Boolean.valueOf(r102.f118432p));
        return;
    L25:
        return;
    L24:
        return;
    L9:
        if (r100.H == true) goto L27;
        PlayerProgressServiceContext r104 = this.f107905k;
        if (r104 == null) goto L15;
        m<String> r105 = r104.getThumbTitle();
        if (r105 == null) goto L15;
        r105.setValue("");
    L15:
        PlayerProgressServiceContext r106 = this.f107905k;
        if (r106 == null) goto L20;
        m<Boolean> r107 = r106.getThumbHotLabel();
        if (r107 == null) goto L20;
        r107.setValue(Boolean.FALSE);
    L20:
        com.bytedance.android.livesdk.chatroom.progressbar.c r108 = this.f107907m;
        if (r108 == null) goto L28;
        r108.b();
        return;
    L28:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.ui.PlayerSeekBar.b
    public void n8(PlayerSeekBar r100, float r101, boolean r102, float r110) {
        Intrinsics.checkNotNullParameter(r100, "seekBar");
        PlayerProgressServiceContext r103 = this.f107905k;
        if (r103 == null) goto L8;
        if (r103.isCleared() != true) goto L8;
        return;
    L8:
        if (Kq() == false) goto L48;
        if (r102 == false) goto L65;
        long r104 = 0;
        if (Mq() == true) goto L24;
        com.bytedance.android.livesdk.chatroom.progressbar.b r105 = this.f107908n;
        if (r105 == null) goto L44;
        m<Long> r106 = r105.a();
        if (r106 == null) goto L44;
        com.bytedance.android.livesdk.chatroom.progressbar.b r107 = this.f107908n;
        if (r107 == null) goto L23;
        m<Long> r108 = r107.getTotalTime();
        if (r108 == null) goto L23;
        Long r109 = r108.getValue();
        if (r109 == null) goto L23;
        r104 = r109.longValue();
    L23:
        r106.setValue(Long.valueOf((long) ((r104 * r101) / 100)));
    L44:
        this.f107916v = r101;
        IPlayerProgressService r111 = this.f107904j;
        if (r111 == null) goto L66;
        r111.showThumbProcessViewDelay(100);
        return;
    L66:
        return;
    L24:
        com.bytedance.android.livesdk.chatroom.progressbar.b r112 = this.f107908n;
        if (r112 == null) goto L44;
        m<Long> r113 = r112.a();
        if (r113 == null) goto L44;
        com.bytedance.android.livesdk.chatroom.progressbar.b r114 = this.f107908n;
        if (r114 == null) goto L35;
        m<Long> r115 = r114.getTotalTime();
        if (r115 == null) goto L35;
        Long r116 = r115.getValue();
        if (r116 == null) goto L35;
        long r117 = r116.longValue();
    L36:
        float r118 = r117;
        PlayerProgressServiceContext r119 = this.f107905k;
        if (r119 == null) goto L43;
        m<Long> r120 = r119.getLimitTimeLength();
        if (r120 == null) goto L43;
        Long r121 = r120.getValue();
        if (r121 == null) goto L43;
        r104 = r121.longValue();
    L43:
        r113.setValue(Long.valueOf((long) (r118 - (r104 * (1 - (r101 / 100))))));
    L35:
        r117 = 0;
        goto L36
    L65:
        return;
    L48:
        PlayerProgressServiceContext r122 = this.f107905k;
        if (r122 == null) goto L51;
        r122.getProgress().setValue(Float.valueOf(r101));
        r122.getXVelocity().setValue(Float.valueOf(r110));
    L51:
        IPlayerProgressService r123 = this.f107904j;
        if (r123 == null) goto L54;
        r123.handleProgressListener3(PlayerProgressBarWidget$onProgressChanged$2.INSTANCE, Float.valueOf(r101), Boolean.valueOf(r102));
    L54:
        if (r102 == false) goto L67;
        PlayerProgressServiceContext r124 = this.f107905k;
        if (r124 != null) goto L58;
    L61:
        this.f107916v = r101;
        IPlayerProgressService r125 = this.f107904j;
        if (r125 == null) goto L68;
        r125.showThumbProcessViewDelay(100);
        return;
    L68:
        return;
    L58:
        if (Mq() == true) goto L60;
        r124.getCurrentDisplayTime().setValue(Long.valueOf((long) ((r124.getTotalTime().getValue().floatValue() * r101) / 100)));
        goto L61
    L60:
        r124.getCurrentDisplayTime().setValue(Long.valueOf((long) (r124.getTotalTime().getValue().floatValue() - (r124.getLimitTimeLength().getValue().floatValue() * (1 - (r101 / 100))))));
        goto L61
    }
}
