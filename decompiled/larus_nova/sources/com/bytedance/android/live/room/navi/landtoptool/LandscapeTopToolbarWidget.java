package com.bytedance.android.live.room.navi.landtoptool;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.landscape.d;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l81.t;
import zg1.x0;

/* JADX INFO: loaded from: classes47.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.LandscapeTopToolBar, type = PlayerViewControl.Type.TOP)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/room/navi/landtoptool/LandscapeTopToolbarWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeTopToolbarWidget extends MiddlewareRoomRecyclableWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f99705h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f99706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f99707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f99708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public x3 f99709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<ToolbarButton> f99710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<ExtendedToolbarButton, View> f99711f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<ExtendedToolbarButton, View> f99712g;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeTopToolbarWidget f99713a;

        public b(LandscapeTopToolbarWidget r100) {
            this.f99713a = r100;
        }

        public final void a() {
            if (this.f99713a.contentView.getWidth() <= 0) goto L5;
            float r100 = this.f99713a.contentView.getWidth() - UIUtils.dip2Px(this.f99713a.context, 14.0f);
        L6:
            MiddlewareRoomContext r101 = this.f99713a.getMiddlewareRoomContext();
            if (r101 == null) goto L12;
            m<Float> r102 = r101.getLandscapeToolbarWidth();
            if (r102 == null) goto L13;
            r102.setValue(Float.valueOf(r100));
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r100 = UIUtils.dip2Px(this.f99713a.context, 14.0f);
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final class c implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f99714a;

        public c(Function1 r100) {
            this.f99714a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Object r100) {
            this.f99714a.invoke(r100);
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_view_live_toolbar_landscape;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public final String getSpm() {
        return "a100.a100.a266";
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f99708c.clear();
        this.dataCenter.removeObserver(this);
        Iterator r100 = ((ArrayList) this.f99710e).iterator();
    L4:
        if (r100.hasNext() == false) goto L14;
        ToolbarButton r101 = (ToolbarButton) r100.next();
        Map<ExtendedToolbarButton, View> r102 = this.f99712g;
        ExtendedToolbarButton.a r103 = ExtendedToolbarButton.f115618h;
        r103.getClass();
        LinkedHashMap r104 = (LinkedHashMap) r102;
        View r105 = (View) r104.get(ExtendedToolbarButton.a.a(r101));
        if (r105 == null) goto L4;
        ViewGroup r106 = this.f99707b;
        if (r106 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
    L10:
        r106.removeView(r105);
        x3 r107 = this.f99709d;
        if (r107 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarManager");
    L13:
        r107.getClass();
        r103.getClass();
        r107.C(ExtendedToolbarButton.a.a(r101), r105);
        goto L4
    L14:
        ((ArrayList) this.f99710e).clear();
        ((LinkedHashMap) this.f99712g).clear();
    }

    public LandscapeTopToolbarWidget() {
        this.f99706a = "LandscapeTopToolbarWidget";
        this.f99708c = new CompositeDisposable();
        this.f99710e = new ArrayList();
        this.f99711f = new LinkedHashMap();
        this.f99712g = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onClear() {
        super.onClear();
        this.f99708c.clear();
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L6:
        if (r102 == null) goto L38;
        int r103 = r102.hashCode();
        int r104 = 4;
        if (r103 == 309908432) goto L24;
        if (r103 == 1939188655) goto L14;
        return;
    L14:
        if (r102.equals("data_screen_record_is_open") == false) goto L35;
        Boolean r105 = Boolean.FALSE;
        Boolean r106 = (Boolean) r101.getData(r105);
        if (r106 == null) goto L20;
        r105 = r106;
    L20:
        if (r105.booleanValue() == true) goto L22;
        r104 = 0;
    L22:
        this.contentView.setVisibility(r104);
        return;
    L35:
        return;
    L24:
        if (r102.equals("data_media_introduction_showing") == false) goto L37;
        Boolean r107 = Boolean.FALSE;
        Boolean r108 = (Boolean) r101.getData(r107);
        if (r108 == null) goto L29;
        r107 = r108;
    L29:
        boolean r109 = r107.booleanValue();
        View r110 = this.contentView;
        if (r109 == true) goto L33;
        r104 = 0;
    L33:
        r110.setVisibility(r104);
        return;
    L37:
        return;
    L38:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f99707b = (ViewGroup) this.contentView.findViewById(R.id.landscape_top_action_container);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r110) {
        boolean r111 = isScreenPortrait();
        int r100 = d.f159073a;
        if ((!r111) == false) goto L8;
        ViewGroup r112 = this.f99707b;
        if (r112 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
    L7:
        UIUtils.updateLayoutMargin(r112, -3, -3, 0, 0);
    L8:
        c0 r113 = y3.i(this.dataCenter);
        if (r113 == null) goto L80;
        x3 r114 = (x3) r113;
        this.f99709d = r114;
        r114.E(this.dataCenter);
        x3 r115 = this.f99709d;
        if (r115 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarManager");
    L13:
        this.f99711f = r115.f116829c;
        this.dataCenter.observe("data_screen_record_is_open", this).observe("data_media_introduction_showing", this);
        if ((!isScreenPortrait()) == false) goto L23;
        o r116 = z51.a.h(this.dataCenter, 2);
        if (r116 == null) goto L23;
        m<x0> r117 = r116.G2();
        if (r117 == null) goto L23;
        x0 r101 = r117.getValue();
        ViewGroup r102 = this.f99707b;
        if (r102 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
    L22:
        UIUtils.updateLayoutMargin(r102, -3, -3, s1.f(0.0f), -3);
        ((ObservableSubscribeProxy) r117.a().observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new c(new LandscapeTopToolbarWidget$onLoad$1$1(this)));
    L23:
        x3 r118 = this.f99709d;
        if (r118 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarManager");
    L26:
        this.f99708c.add(r118.f116835i.subscribe(new com.bytedance.android.live.room.navi.landtoptool.a(this), com.bytedance.android.live.room.navi.landtoptool.b.f99716a));
        t r119 = ((INavigationProxyService) k.n(INavigationProxyService.class)).getToolbarConfig();
        if (r119 == null) goto L29;
        r119.a(this.dataCenter, this.f99710e);
    L29:
        LayoutInflater r120 = LayoutInflater.from(this.context);
        if (r120 == null) goto L74;
        Iterator r103 = ((ArrayList) this.f99710e).iterator();
    L34:
        if (r103.hasNext() == false) goto L74;
        ToolbarButton r104 = (ToolbarButton) r103.next();
        if (r104 != ToolbarButton.SWITCH_VIDEO_QUALITY) goto L38;
    L39:
        INavigationProxyService r105 = (INavigationProxyService) k.f(INavigationProxyService.class);
        if (r105 == null) goto L46;
        l81.k r106 = r105.getLivePlatformPlayerManager();
        if (r106 == null) goto L46;
        ILivePlayerClient r107 = r106.getCurrentClient();
        if (r107 == null) goto L46;
        ILivePlayerExtraRenderController r108 = r107.extraRenderController();
    L47:
        if (r108 != null) goto L49;
    L51:
        boolean r109 = false;
    L52:
        if (r109 == true) goto L34;
    L54:
        ExtendedToolbarButton.f115618h.getClass();
        ExtendedToolbarButton.b r121 = ExtendedToolbarButton.a.a(r104);
        ViewGroup r122 = this.f99707b;
        if (r122 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
    L57:
        View r123 = r120.inflate(r104.getLayoutId(), r122, false);
        if (r104.getLayoutId() != R.layout.ttlive_view_toolbar_common) goto L60;
        r123.setBackgroundResource(r104.getDrawableUnfolded());
    L60:
        r123.setTag(r104);
        r123.setVisibility(8);
        boolean r124 = isScreenPortrait();
        int r125 = d.f159073a;
        if ((!r124) == false) goto L63;
        int r126 = 0;
    L64:
        UIUtils.updateLayoutMargin(r123, (int) UtilityKotlinExtentionsKt.h(14.0f), -3, -3, r126);
        r3.i(r123, r104);
        this.f99711f.put(r121, r123);
        this.f99712g.put(r121, r123);
        ViewParent r127 = r123.getParent();
        if ((r127 instanceof ViewGroup) == false) goto L67;
        ((ViewGroup) r127).removeView(r123);
    L67:
        ViewGroup r128 = this.f99707b;
        if (r128 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
    L70:
        r128.addView(r123);
        x3 r129 = this.f99709d;
        if (r129 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarManager");
    L73:
        r129.D(r121, r123);
        goto L34
    L63:
        r126 = -3;
        goto L64
    L49:
        if (r108.isUgcRoom() != true) goto L51;
        r109 = true;
    L46:
        r108 = null;
        goto L47
    L38:
        if (r104 != ToolbarButton.RECORD_LANDSCAPE) goto L54;
    L74:
        View r130 = this.contentView;
        if (r130 == null) goto L77;
        r130.post(new b(this));
    L77:
        ALogger.d(this.f99706a, "LandscapeTopToolbarWidget = " + System.currentTimeMillis());
        return;
    L80:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    }
}
