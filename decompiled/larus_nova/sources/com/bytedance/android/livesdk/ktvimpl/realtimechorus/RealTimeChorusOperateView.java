package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.RealTimeChorusAnchorWidget;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00012B'\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010/\u001a\u00020\b¢\u0006\u0004\b0\u00101J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\n8B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010*\u001a\u0004\u0018\u00010\u00048B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealTimeChorusOperateView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "getCurPlayingMusicPanel", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/l1;", "infoProvider", "", "setSingInfoProvider", "", "getJoinBtnStatus", "Lxe2/c;", "b", "Lxe2/c;", "getJoinChorusMonitor", "()Lxe2/c;", "joinChorusMonitor", "Lnd2/d;", "c", "Lnd2/d;", "getKtvMusicDownloadOptWrapper", "()Lnd2/d;", "ktvMusicDownloadOptWrapper", "", "value", "d", "Z", "isJoiningChorus", "()Z", "setJoiningChorus", "(Z)V", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealtimeChorusProgressImageView;", ce.f26396k, "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealtimeChorusProgressImageView;", "getChorusContainer", "()Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealtimeChorusProgressImageView;", "setChorusContainer", "(Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealtimeChorusProgressImageView;)V", "chorusContainer", "o", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/l1;", "getSingInfoProvider", "()Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/l1;", "singInfoProvider", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusOperateView extends ConstraintLayout {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f146392r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f146393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xe2.c f146394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public nd2.d f146395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f146396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f146397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConstraintLayout f146398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f146399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f146400h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f146401i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f146402j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RealtimeChorusProgressImageView f146403k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FrameLayout f146404l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f146405m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public WeakReference<l1> f146406n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public l1 f146407o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<MusicPanel> f146408p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RealTimeChorusOperateView$musicDownloadCallback$1 f146409q;

    public static final class a {
    }

    static {
    }

    public RealTimeChorusOperateView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RealTimeChorusOperateView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final MusicPanel getCurPlayingMusicPanel() {
        KtvModeOrderedSongDataContext r100 = KtvModeOrderedSongDataContext.Companion.getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getKtvPublicFirstOrderedSong();
    }

    private final xe2.c getJoinChorusMonitor() {
        if (this.f146394b != null) goto L14;
        fd2.s r100 = RealTimeChorusBusinessContext.Companion.c();
        xe2.c r101 = null;
        if (r100 == null) goto L7;
        xe2.c r102 = r100.Qe();
    L9:
        if ((r102 instanceof xe2.c) == false) goto L12;
        r101 = r102;
    L12:
        this.f146394b = r101;
        goto L14
    L7:
        r102 = null;
    L14:
        return this.f146394b;
    }

    private final nd2.d getKtvMusicDownloadOptWrapper() {
        if (this.f146395c != null) goto L14;
        fd2.s r100 = RealTimeChorusBusinessContext.Companion.c();
        nd2.d r101 = null;
        if (r100 == null) goto L7;
        nd2.d r102 = r100.oj();
    L9:
        if ((r102 instanceof nd2.d) == false) goto L12;
        r101 = r102;
    L12:
        this.f146395c = r101;
        goto L14
    L7:
        r102 = null;
    L14:
        return this.f146395c;
    }

    public final void Z5() {
        int r100 = this.f146405m;
        if (r100 != 1) goto L5;
    L8:
        RealtimeChorusProgressImageView r101 = this.f146403k;
        if (r101 == null) goto L17;
        l1 r102 = getSingInfoProvider();
        if (r102 == null) goto L13;
        py.k r103 = r102.dp();
    L14:
        r101.a(r103);
        return;
    L13:
        r103 = null;
        goto L14
    L17:
        return;
    L5:
        if (r100 == 2) goto L8;
        if (r100 == 3) goto L8;
    }

    public final void b6() {
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r100 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
        Boolean r101 = null;
        if ((r100 instanceof RealTimeChorusAnchorWidget) == true) goto L5;
        r100 = null;
    L5:
        RealTimeChorusAnchorWidget r102 = (RealTimeChorusAnchorWidget) r100;
        if (r102 == null) goto L9;
        r101 = r102.t0();
    L9:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L13;
        ImageView r103 = this.f146402j;
        if (r103 == null) goto L17;
        r103.setImageResource(R.drawable.ttlive_real_time_chorus_mic_off_img);
        return;
    L17:
        return;
    L13:
        ImageView r104 = this.f146402j;
        if (r104 == null) goto L19;
        r104.setImageResource(R.drawable.ttlive_real_time_chorus_mic_on_img);
        return;
    }

    private final l1 getSingInfoProvider() {
        if (KtvSettingHelper.r().booleanValue() == false) goto L9;
        WeakReference<l1> r100 = this.f146406n;
        if (r100 != null) goto L10;
        return null;
    L10:
        return r100.get();
    L9:
        return this.f146407o;
    }

    public final RealtimeChorusProgressImageView getChorusContainer() {
        return this.f146403k;
    }

    public final int getJoinBtnStatus() {
        return this.f146405m;
    }

    public static final /* synthetic */ MusicPanel R5(RealTimeChorusOperateView r100) {
        return r100.getCurPlayingMusicPanel();
    }

    public static final /* synthetic */ xe2.c S5(RealTimeChorusOperateView r100) {
        return r100.getJoinChorusMonitor();
    }

    public static final void T5(RealTimeChorusOperateView r110) {
        r110.getClass();
        if (KtvSettingHelper.v().getEnableOptimize() == false) goto L5;
        r110.setJoiningChorus(false);
    L5:
        xe2.h.k("exit");
        RealTimeChorusBusinessContext.a r100 = RealTimeChorusBusinessContext.Companion;
        l1 r101 = r110.getSingInfoProvider();
        if (r101 == null) goto L8;
        double r102 = r101.Uc();
    L9:
        r100.l(r102, 1, RealTimeChorusOperateView$tryLeaveChorus$1.INSTANCE);
        MusicPanel r111 = r110.getCurPlayingMusicPanel();
        xe2.b.f563350b.getClass();
        Long r103 = null;
        if (r111 == null) goto L17;
        JSONObject r104 = new JSONObject();
        r104.put("music_name", r111.f153577a.getTitle());
        r104.put("music_id", r111.f153577a.getMId());
        InteractiveSongUserInfo r105 = r111.f();
        if (r105 == null) goto L15;
        Long r106 = Long.valueOf(r105.getId());
    L16:
        r104.put("order_user_id", String.valueOf(r106));
        xe2.b.s(LinkMonitorData.LeaveChorusBtnClicked, r104);
        goto L17
    L15:
        r106 = null;
    L17:
        int r107 = xe2.g.f563356a;
        if (r111 == null) goto L25;
        JSONObject r112 = new JSONObject();
        r112.put("music_name", r111.f153577a.getTitle());
        r112.put("music_id", r111.f153577a.getMId());
        InteractiveSongUserInfo r113 = r111.f();
        if (r113 == null) goto L23;
        r103 = Long.valueOf(r113.getId());
    L23:
        r112.put("order_user_id", String.valueOf(r103));
        xe2.g.f(r112);
        int r114 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.RTChorus, MultiTraceData$TraceEvent.LeaveChorus, "LeaveChorusClick", 0, null, r112, 88);
        return;
    L25:
        return;
    L8:
        r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L9
    }

    public final void U5(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (((Boolean) KtvSettingHelper.f70640m.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (this.f146405m == 1) goto L8;
        return;
    L8:
        final RealtimeChorusProgressImageView r101 = this.f146403k;
        if (r101 == null) goto L21;
        Intrinsics.checkNotNullParameter(r100, "url");
        HSImageView r102 = r101.f146456e;
        if (r102 == null) goto L13;
        r102.setVisibility(0);
    L13:
        HSImageView r103 = r101.f146456e;
        Function0<Unit> r104 = new RealtimeChorusProgressImageView$showAnimView$1(r101);
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r104, "onAnimationEnd");
        PipelineDraweeControllerBuilder r105 = Fresco.newDraweeControllerBuilder();
        if (r103 == null) goto L16;
        DraweeController r106 = r103.getController();
    L17:
        AbstractDraweeController r107 = r105.setOldController(r106).setUri(UriProtector.parse(r100)).setControllerListener(new g1(r104)).build();
        if (r103 == null) goto L22;
        r103.setController(r107);
        return;
    L22:
        return;
    L16:
        r106 = null;
        goto L17
    }

    public final void V5(String r110) {
        if (KtvSettingHelper.v().getEnableOptimize() == true) goto L5;
    L9:
        MusicPanel r100 = getCurPlayingMusicPanel();
        xe2.h.k("join");
        Long r101 = null;
        if (r100 == null) goto L38;
        xe2.c r102 = getJoinChorusMonitor();
        if (r102 == null) goto L20;
        r102.a();
        BehaviorSubject<Long> r103 = r102.f563351a.get(ILoadStallMonitor.START_TIME);
        if (r103 == null) goto L16;
        r103.onNext(Long.valueOf(System.currentTimeMillis()));
    L16:
        Disposable r104 = Observable.combineLatest(r102.f563351a.values(), new xe2.d(r102)).subscribe(xe2.e.f563354a, xe2.f.f563355a);
        if (r104 == null) goto L20;
        RxUtilKt.c(r104, r102.f563352b);
    L20:
        if (((Boolean) KtvSettingHelper.f70643n.getValue()).booleanValue() == false) goto L35;
        Iterator r105 = ((ArrayList) this.f146408p).iterator();
    L23:
        if (r105.hasNext() == false) goto L27;
        Object r106 = r105.next();
        if ((!((MusicPanel) r106).f153577a.isSameKtvMusic(r100.f153577a)) == false) goto L23;
    L29:
        if (((MusicPanel) r106) == null) goto L34;
        Iterator r107 = ((ArrayList) this.f146408p).iterator();
    L32:
        if (r107.hasNext() == false) goto L34;
        MusicPanel r108 = (MusicPanel) r107.next();
        com.bytedance.android.live.ktv.common.music.download.m r109 = KtvMusicManager.f70032a;
        KtvMusicManager.a(r108);
    L34:
        ((ArrayList) this.f146408p).add(r100);
        goto L35
    L27:
        r106 = null;
    L35:
        nd2.d r111 = getKtvMusicDownloadOptWrapper();
        if (r111 == null) goto L39;
        nd2.d.a(r111, r100, this.f146409q, ((Boolean) KtvSettingHelper.f70643n.getValue()).booleanValue());
    L39:
        xe2.b.f563350b.getClass();
        if (r100 == null) goto L47;
        JSONObject r112 = new JSONObject();
        r112.put("music_name", r100.f153577a.getTitle());
        r112.put("music_id", r100.f153577a.getMId());
        InteractiveSongUserInfo r113 = r100.f();
        if (r113 == null) goto L45;
        Long r114 = Long.valueOf(r113.getId());
    L46:
        r112.put("order_user_id", String.valueOf(r114));
        xe2.b.s(LinkMonitorData.JoinChorusBtnClicked, r112);
        goto L47
    L45:
        r114 = null;
    L47:
        int r115 = xe2.g.f563356a;
        Intrinsics.checkNotNullParameter(r110, "source");
        if (r100 == null) goto L59;
        JSONObject r116 = new JSONObject();
        r116.put("music_name", r100.f153577a.getTitle());
        r116.put("music_id", r100.f153577a.getMId());
        InteractiveSongUserInfo r117 = r100.f();
        if (r117 == null) goto L53;
        r101 = Long.valueOf(r117.getId());
    L53:
        r116.put("order_user_id", String.valueOf(r101));
        r116.put("source", r110);
        r116.put("log_trace", Log.getStackTraceString(new Throwable()));
        int r118 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.RTChorus, MultiTraceData$TraceEvent.JoinChorus, "JoinChorusClick", 0, null, r116, 88);
        return;
    L59:
        return;
    L38:
        setJoiningChorus(false);
        goto L39
    L5:
        if (this.f146396d == false) goto L8;
        w.a("RealTimeChorusOperateView", "isJoiningChorus so return");
        return;
    L8:
        setJoiningChorus(true);
        goto L9
    }

    public final void Y5(int r110) {
        if (KtvSettingHelper.v().getEnableOptimize() == false) goto L24;
        if (r110 != 4) goto L24;
        RealTimeChorusBusinessContext.a r100 = RealTimeChorusBusinessContext.Companion;
        boolean r101 = r100.j();
        if (r100.b() != 1) goto L8;
        boolean r102 = true;
    L9:
        fd2.s r103 = r100.c();
        if (r103 != null) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r102 == true) goto L19;
        if (r101 == false) goto L20;
        if (r104 == true) goto L19;
    L20:
        boolean r105 = false;
    L21:
        if (r105 == true) goto L24;
        w.a("RealTimeChorusOperateView", "updateChorusBtnStatus ;; music not ready ;; isViceSinger == " + r101 + " ;; isLeadSinger == " + r102 + " ;; isPlaying == " + r104);
        return;
    L19:
        r105 = true;
        goto L21
    L12:
        if (r103.isPlaying() != true) goto L14;
        r104 = true;
        goto L15
    L8:
        r102 = false;
    L24:
        int r106 = this.f146405m;
        if (r106 != r110) goto L28;
        return;
    L28:
        if (r106 != 1) goto L30;
        if (r110 != 2) goto L30;
    L34:
        boolean r107 = true;
    L36:
        this.f146405m = r110;
        if (getVisibility() != 0) goto L58;
        if (r107 == true) goto L58;
        if (r110 == 1) goto L43;
        if (r110 == 2) goto L43;
        if (r110 == 4) goto L43;
        if (r110 != 5) goto L58;
    L43:
        if (r110 == 1) goto L47;
        if (r110 == 2) goto L47;
        String r108 = "exit";
    L48:
        String r109 = "0";
        if (r110 == 1) goto L53;
        if (r110 == 4) goto L53;
        Object r111 = "0";
    L54:
        Intrinsics.checkNotNullParameter(r108, "buttonType");
        Intrinsics.checkNotNullParameter(r111, "isUsed");
        HashMap r112 = new HashMap();
        xe2.h.a(r112);
        xe2.h.c(r112);
        xe2.h.b(r112);
        r112.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r108);
        r112.put("is_used", r111);
        if (xe2.h.h() == false) goto L57;
        r109 = "1";
    L57:
        r112.put("is_fixed_guest", r109);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_chorus_join_icon_show", r112, new Object[]{IRoom.class, am2.x.class});
    L53:
        r111 = "1";
    L47:
        r108 = "join";
    L58:
        py.k r113 = null;
        if (r110 != 1) goto L61;
        RealtimeChorusProgressImageView r114 = this.f146403k;
        if (r114 == null) goto L171;
        r114.setText(s1.B(R.string.ttlive_real_time_chorus_join));
    L171:
        RealtimeChorusProgressImageView r115 = this.f146403k;
        if (r115 == null) goto L176;
        RoundCornerProgressBar r116 = r115.f146452a;
        if (r116 == null) goto L176;
        r116.setProgress(0.0f);
    L176:
        RealtimeChorusProgressImageView r117 = this.f146403k;
        if (r117 == null) goto L182;
        l1 r118 = getSingInfoProvider();
        if (r118 == null) goto L181;
        r113 = r118.dp();
    L181:
        r117.a(r113);
    L182:
        RealtimeChorusProgressImageView r119 = this.f146403k;
        if (r119 == null) goto L185;
        r119.setAlpha(1.0f);
    L185:
        RealtimeChorusProgressImageView r120 = this.f146403k;
        if (r120 == null) goto L188;
        r120.setClickable(true);
    L188:
        RealtimeChorusProgressImageView r121 = this.f146403k;
        if (r121 == null) goto L204;
        r121.setTextColor(ColorProtector.parseColor("#2E2929"));
        return;
    L204:
        return;
    L61:
        if (r110 == 2) goto L140;
        if (r110 != 3) goto L64;
        RealtimeChorusProgressImageView r122 = this.f146403k;
        if (r122 == null) goto L120;
        r122.setText(s1.B(R.string.ttlive_real_time_chorus_download_bgm));
    L120:
        RealtimeChorusProgressImageView r123 = this.f146403k;
        if (r123 == null) goto L126;
        l1 r124 = getSingInfoProvider();
        if (r124 == null) goto L125;
        r113 = r124.dp();
    L125:
        r123.a(r113);
    L126:
        RealtimeChorusProgressImageView r125 = this.f146403k;
        if (r125 == null) goto L129;
        r125.setAlpha(1.0f);
    L129:
        RealtimeChorusProgressImageView r126 = this.f146403k;
        if (r126 == null) goto L132;
        r126.setClickable(true);
    L132:
        RealtimeChorusProgressImageView r127 = this.f146403k;
        if (r127 == null) goto L135;
        r127.setTextColor(ColorProtector.parseColor("#2E2929"));
    L135:
        RealtimeChorusProgressImageView r128 = this.f146403k;
        if (r128 == null) goto L198;
        HSImageView r129 = r128.f146456e;
        if (r129 == null) goto L199;
        r129.setVisibility(8);
        return;
    L199:
        return;
    L198:
        return;
    L64:
        if (r110 == 4) goto L92;
        if (r110 != 5) goto L205;
        RealtimeChorusProgressImageView r130 = this.f146403k;
        if (r130 == null) goto L70;
        r130.setText(s1.B(R.string.ttlive_real_time_chorus_leave));
    L70:
        RealtimeChorusProgressImageView r131 = this.f146403k;
        if (r131 == null) goto L75;
        RoundCornerProgressBar r132 = r131.f146452a;
        if (r132 == null) goto L75;
        r132.setProgress(0.0f);
    L75:
        RealtimeChorusProgressImageView r133 = this.f146403k;
        if (r133 == null) goto L78;
        int r134 = qy.a.f535172a;
        r133.a(qy.a.a(com.bytedance.android.live.ktv.common.midi.i.f69853b));
    L78:
        RealtimeChorusProgressImageView r135 = this.f146403k;
        if (r135 == null) goto L81;
        r135.setAlpha(0.34f);
    L81:
        RealtimeChorusProgressImageView r136 = this.f146403k;
        if (r136 == null) goto L84;
        r136.setClickable(false);
    L84:
        RealtimeChorusProgressImageView r137 = this.f146403k;
        if (r137 == null) goto L87;
        r137.setTextColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
    L87:
        RealtimeChorusProgressImageView r138 = this.f146403k;
        if (r138 == null) goto L192;
        HSImageView r139 = r138.f146456e;
        if (r139 == null) goto L193;
        r139.setVisibility(8);
        return;
    L193:
        return;
    L192:
        return;
    L205:
        return;
    L92:
        RealtimeChorusProgressImageView r140 = this.f146403k;
        if (r140 == null) goto L95;
        r140.setText(s1.B(R.string.ttlive_real_time_chorus_leave));
    L95:
        RealtimeChorusProgressImageView r141 = this.f146403k;
        if (r141 == null) goto L100;
        RoundCornerProgressBar r142 = r141.f146452a;
        if (r142 == null) goto L100;
        r142.setProgress(0.0f);
    L100:
        RealtimeChorusProgressImageView r143 = this.f146403k;
        if (r143 == null) goto L103;
        int r144 = qy.a.f535172a;
        r143.a(qy.a.a(com.bytedance.android.live.ktv.common.midi.i.f69853b));
    L103:
        RealtimeChorusProgressImageView r145 = this.f146403k;
        if (r145 == null) goto L106;
        r145.setAlpha(1.0f);
    L106:
        RealtimeChorusProgressImageView r146 = this.f146403k;
        if (r146 == null) goto L109;
        r146.setClickable(true);
    L109:
        RealtimeChorusProgressImageView r147 = this.f146403k;
        if (r147 == null) goto L112;
        r147.setTextColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
    L112:
        RealtimeChorusProgressImageView r148 = this.f146403k;
        if (r148 == null) goto L195;
        HSImageView r149 = r148.f146456e;
        if (r149 == null) goto L196;
        r149.setVisibility(8);
        return;
    L196:
        return;
    L195:
        return;
    L140:
        RealtimeChorusProgressImageView r150 = this.f146403k;
        if (r150 == null) goto L143;
        r150.setText(s1.B(R.string.ttlive_real_time_chorus_join));
    L143:
        RealtimeChorusProgressImageView r151 = this.f146403k;
        if (r151 == null) goto L148;
        RoundCornerProgressBar r152 = r151.f146452a;
        if (r152 == null) goto L148;
        r152.setProgress(0.0f);
    L148:
        RealtimeChorusProgressImageView r153 = this.f146403k;
        if (r153 == null) goto L154;
        l1 r154 = getSingInfoProvider();
        if (r154 == null) goto L153;
        r113 = r154.dp();
    L153:
        r153.a(r113);
    L154:
        RealtimeChorusProgressImageView r155 = this.f146403k;
        if (r155 == null) goto L157;
        r155.setAlpha(0.5f);
    L157:
        RealtimeChorusProgressImageView r156 = this.f146403k;
        if (r156 == null) goto L160;
        r156.setClickable(false);
    L160:
        RealtimeChorusProgressImageView r157 = this.f146403k;
        if (r157 == null) goto L163;
        r157.setTextColor(ColorProtector.parseColor("#2E2929"));
    L163:
        RealtimeChorusProgressImageView r158 = this.f146403k;
        if (r158 == null) goto L201;
        HSImageView r159 = r158.f146456e;
        if (r159 == null) goto L202;
        r159.setVisibility(8);
        return;
    L202:
        return;
    L201:
        return;
    L30:
        if (r106 != 2) goto L32;
        if (r110 == 1) goto L34;
    L32:
        if (r106 != 3) goto L35;
        if (r110 == 1) goto L34;
    L35:
        r107 = false;
        goto L36
    }

    public final void c6(int r100) {
        if (r100 <= 0) goto L26;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.f143561l.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.i() == true) goto L26;
        TextView r101 = this.f146400h;
        if (r101 == null) goto L9;
        r101.setVisibility(8);
    L9:
        TextView r102 = this.f146399g;
        if (r102 == null) goto L12;
        r102.setVisibility(0);
    L12:
        TextView r103 = this.f146399g;
        if (r103 != null) goto L15;
    L19:
        TextView r104 = this.f146397e;
        if (r104 == null) goto L22;
        com.bytedance.android.live.core.utils.a1.o(r104, s1.f(7.0f));
    L22:
        TextView r105 = this.f146397e;
        if (r105 == null) goto L50;
        com.bytedance.android.live.core.utils.a1.n(r105, s1.f(7.0f));
        return;
    L50:
        return;
    L15:
        if (r100 <= 99) goto L17;
        String r106 = "99+";
    L18:
        r103.setText(r106);
        goto L19
    L17:
        r106 = String.valueOf(r100);
    L26:
        if (KtvSettingHelper.C() == true) goto L28;
    L34:
        TextView r107 = this.f146400h;
        if (r107 == null) goto L37;
        r107.setVisibility(8);
    L37:
        TextView r108 = this.f146399g;
        if (r108 == null) goto L40;
        r108.setVisibility(8);
    L40:
        TextView r109 = this.f146399g;
        if (r109 == null) goto L43;
        r109.setText("");
    L43:
        TextView r110 = this.f146397e;
        if (r110 == null) goto L46;
        com.bytedance.android.live.core.utils.a1.o(r110, 0);
    L46:
        TextView r111 = this.f146397e;
        if (r111 == null) goto L52;
        com.bytedance.android.live.core.utils.a1.n(r111, 0);
        return;
    L52:
        return;
    L28:
        if (com.bytedance.android.livesdk.sharedpref.c.X.getValue().booleanValue() == true) goto L34;
        if ((((long) ((Number) KtvSettingHelper.f70651p1.getValue()).intValue()) * 1000) <= System.currentTimeMillis()) goto L34;
        TextView r112 = this.f146400h;
        if (r112 == null) goto L37;
        r112.setVisibility(0);
        goto L37
    }

    public final void i6(boolean r100) {
        if (KtvSettingHelper.v().getEnableOptimize() == false) goto L25;
        if (r100 == false) goto L25;
        RealTimeChorusBusinessContext.a r101 = RealTimeChorusBusinessContext.Companion;
        boolean r102 = r101.j();
        boolean r103 = true;
        if (r101.b() != 1) goto L8;
        boolean r104 = true;
    L9:
        fd2.s r105 = r101.c();
        if (r105 != null) goto L12;
    L14:
        boolean r106 = false;
    L15:
        if (r104 == true) goto L21;
        if (r102 == false) goto L20;
        if (r106 == true) goto L21;
    L20:
        r103 = false;
    L21:
        if (r103 == true) goto L25;
        w.a("RealTimeChorusOperateView", "updateSingStatus ;; music not ready ;; isViceSinger == " + r102 + " ;; isLeadSinger == " + r104 + " ;; isPlaying == " + r106);
        return;
    L12:
        if (r105.isPlaying() != true) goto L14;
        r106 = true;
        goto L15
    L8:
        r104 = false;
    L25:
        if (r100 == false) goto L37;
        ImageView r107 = this.f146401i;
        if (r107 == null) goto L30;
        r107.setVisibility(0);
    L30:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L34;
        FrameLayout r108 = this.f146404l;
        if (r108 == null) goto L49;
        r108.setVisibility(0);
        return;
    L49:
        return;
    L34:
        FrameLayout r109 = this.f146404l;
        if (r109 == null) goto L51;
        r109.setVisibility(8);
        return;
    L51:
        return;
    L37:
        ImageView r110 = this.f146401i;
        if (r110 == null) goto L41;
        r110.setVisibility(8);
    L41:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L45;
        FrameLayout r111 = this.f146404l;
        if (r111 == null) goto L53;
        r111.setVisibility(0);
        return;
    L53:
        return;
    L45:
        FrameLayout r112 = this.f146404l;
        if (r112 == null) goto L55;
        r112.setVisibility(8);
        return;
    }

    public final void setChorusContainer(RealtimeChorusProgressImageView r100) {
        this.f146403k = r100;
    }

    public final void setJoiningChorus(boolean r100) {
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L8;
        if (this.f146396d == r100) goto L8;
        ALogger.i("RealTimeChorusOperateView", "isJoiningChorus " + this.f146396d + " to " + r100 + " ;; " + Log.getStackTraceString(new Throwable()));
    L8:
        if (this.f146396d == r100) goto L11;
        this.f146396d = r100;
        return;
    }

    public final void setSingInfoProvider(l1 r100) {
        Intrinsics.checkNotNullParameter(r100, "infoProvider");
        if (KtvSettingHelper.r().booleanValue() == false) goto L5;
        this.f146406n = new WeakReference(r100);
        return;
    L5:
        this.f146407o = r100;
    }

    /* JADX WARN: Type inference failed for: r7v4, types: [com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusOperateView$musicDownloadCallback$1] */
    public RealTimeChorusOperateView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f146393a = new CompositeDisposable();
        new Pair(null, Boolean.TRUE);
        this.f146408p = new ArrayList();
        this.f146409q = new RealTimeChorusOperateView$musicDownloadCallback$1(this);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_real_time_chorus_operate_layout, this);
        this.f146398f = (ConstraintLayout) findViewById(R.id.chorus_order_song_container);
        this.f146397e = (TextView) findViewById(R.id.chorus_order_song);
        this.f146399g = (TextView) findViewById(R.id.chorus_order_song_count);
        this.f146400h = (TextView) findViewById(R.id.chorus_order_song_red_dot);
        this.f146401i = (ImageView) findViewById(R.id.chorus_adjust);
        this.f146402j = (ImageView) findViewById(R.id.chorus_mic);
        this.f146404l = (FrameLayout) findViewById(R.id.chorus_mic_container);
        RealtimeChorusProgressImageView r103 = (RealtimeChorusProgressImageView) findViewById(R.id.chorus_btn_container);
        this.f146403k = r103;
        if (r103 == null) goto L8;
        HSImageView r104 = new HSImageView(r103.getContext());
        r103.f146454c = r104;
        r103.addView(r104, new FrameLayout.LayoutParams(-1, -1, 17));
        RoundCornerProgressBar r105 = new RoundCornerProgressBar(r103.getContext(), null);
        r103.f146452a = r105;
        r103.addView(r105, new FrameLayout.LayoutParams(-1, -1, 17));
        HSImageView r106 = new HSImageView(r103.getContext());
        r106.setScaleType(ImageView.ScaleType.FIT_XY);
        Unit r107 = Unit.INSTANCE;
        r103.f146456e = r106;
        r103.addView(r106, new FrameLayout.LayoutParams(s1.f(165.0f), s1.f(68.0f), 17));
        HSImageView r108 = r103.f146456e;
        if (r108 == null) goto L7;
        r108.setVisibility(8);
    L7:
        TextView r109 = new TextView(r103.getContext());
        r109.setTextColor(ColorProtector.parseColor("#2E2929"));
        r109.setTextSize(12.0f);
        r109.setGravity(17);
        r109.setText(R.string.ttlive_real_time_chorus_join);
        r103.f146453b = r109;
        r103.addView(r109, new FrameLayout.LayoutParams(-1, -1, 17));
    L8:
        ImageView r110 = this.f146401i;
        if (r110 == null) goto L12;
        r110.setVisibility(8);
    L12:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L16;
        FrameLayout r111 = this.f146404l;
        if (r111 == null) goto L19;
        r111.setVisibility(8);
    L19:
        RealtimeChorusProgressImageView r112 = this.f146403k;
        if (r112 == null) goto L22;
        r112.setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new RealTimeChorusOperateView$initView$1(this)));
    L22:
        ImageView r113 = this.f146401i;
        if (r113 == null) goto L25;
        r113.setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new RealTimeChorusOperateView$initView$2(this)));
    L25:
        ConstraintLayout r114 = this.f146398f;
        if (r114 == null) goto L28;
        r114.setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new RealTimeChorusOperateView$initView$3(this)));
    L28:
        FrameLayout r115 = this.f146404l;
        if (r115 == null) goto L32;
        r115.setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new RealTimeChorusOperateView$initView$4(this)));
        return;
    L32:
        return;
    L16:
        FrameLayout r116 = this.f146404l;
        if (r116 == null) goto L19;
        r116.setVisibility(0);
        goto L19
    }

    public /* synthetic */ RealTimeChorusOperateView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
