package com.bytedance.android.live.liveinteract.plantform.linksecurity.rts;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import hg6.g;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kg6.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/linksecurity/rts/RTSVoiceWidget;", "Lcom/bytedance/android/live/liveinteract/linkbase/api/BaseMultiLinkWidget;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RTSVoiceWidget extends BaseMultiLinkWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f77196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f77197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f77198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i<ILinkPlayerInfoBridge> f77199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b f77200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final dn0.c f77201f;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RTSVoiceWidget f77202a;

        public a(RTSVoiceWidget r100) {
            this.f77202a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            ph0.c r102 = (ph0.c) sh6.c.b(r101);
            String r103 = null;
            if (r102 == null) goto L5;
            String r104 = r102.f529236b;
        L7:
            if (r104 != null) goto L9;
        L12:
            boolean r105 = true;
        L13:
            if (r105 == true) goto L81;
            g r106 = this.f77202a.f77198c;
            if (r106 != null) goto L17;
            return;
        L17:
            if (r106.A() != true) goto L83;
            ph0.c r107 = (ph0.c) sh6.c.b(r101);
            if (r107 == null) goto L67;
            String r108 = r107.f529236b;
            if (r108 == null) goto L67;
            if ((!StringsKt.isBlank(r108)) != true) goto L67;
            ph0.c r109 = (ph0.c) sh6.c.b(r101);
            if (r109 == null) goto L27;
            String r110 = r109.f529236b;
        L29:
            if (Intrinsics.areEqual(r110, tc0.c.h().f545349f) == false) goto L39;
            ph0.c r111 = (ph0.c) sh6.c.b(r101);
            if (r111 != null) goto L33;
        L34:
            jg6.a r112 = this.f77202a.wq();
            if (r112 == null) goto L67;
            e r113 = r112.b();
            if (r113 == null) goto L67;
            r113.t(new kg6.b(false, false, LiveCommonConstants.REASON_RTS_AUDIO_MUTE, 8));
            goto L67
        L33:
            if (r111.f529237c == 0) goto L67;
        L39:
            ph0.c r114 = (ph0.c) sh6.c.b(r101);
            if (r114 == null) goto L42;
            Integer r115 = Integer.valueOf(r114.f529237c);
        L43:
            Intrinsics.checkNotNull(r115);
            if (r115.intValue() <= 0) goto L58;
            ph0.c r116 = (ph0.c) sh6.c.b(r101);
            if (r116 == null) goto L58;
            if (r116.f529238d == true) goto L58;
            jg6.a r117 = this.f77202a.wq();
            if (r117 == null) goto L67;
            e r118 = r117.b();
            if (r118 == null) goto L67;
            ph0.c r119 = (ph0.c) sh6.c.b(r101);
            if (r119 == null) goto L56;
            String r120 = r119.f529236b;
        L57:
            Intrinsics.checkNotNull(r120);
            r118.h(r120, true, LiveCommonConstants.REASON_RTS_AUDIO_MUTE);
            goto L67
        L56:
            r120 = null;
        L58:
            jg6.a r121 = this.f77202a.wq();
            if (r121 == null) goto L67;
            e r122 = r121.b();
            if (r122 == null) goto L67;
            ph0.c r123 = (ph0.c) sh6.c.b(r101);
            if (r123 == null) goto L65;
            String r124 = r123.f529236b;
        L66:
            Intrinsics.checkNotNull(r124);
            r122.h(r124, false, LiveCommonConstants.REASON_RTS_AUDIO_MUTE);
            goto L67
        L65:
            r124 = null;
            goto L66
        L42:
            r115 = null;
            goto L43
        L27:
            r110 = null;
        L67:
            int r125 = d.f77208a;
            i<ILinkPlayerInfoBridge> r126 = this.f77202a.f77199d;
            ph0.c r127 = (ph0.c) sh6.c.b(r101);
            if (r127 == null) goto L71;
            String r128 = r127.f529235a;
            if (r128 == null) goto L71;
        L72:
            ph0.c r129 = (ph0.c) sh6.c.b(r101);
            if (r129 == null) goto L75;
            r103 = r129.f529236b;
        L75:
            Intrinsics.checkNotNull(r103);
            ph0.c r130 = (ph0.c) sh6.c.b(r101);
            if (r130 == null) goto L78;
            int r131 = r130.f529237c;
        L79:
            d.a.b(r126, r128, r103, r131);
            return;
        L78:
            r131 = -1;
        L71:
            r128 = "";
            goto L72
        L83:
            return;
        L81:
            return;
        L9:
            if (StringsKt.isBlank(r104) == true) goto L12;
            r105 = false;
            goto L13
        L5:
            r104 = null;
            goto L7
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RTSVoiceWidget f77203a;

        public b(RTSVoiceWidget r100) {
            this.f77203a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            ph0.a r102 = (ph0.a) sh6.c.b(r101);
            if (r102 == null) goto L5;
            String r103 = r102.f529230a;
        L7:
            if (Intrinsics.areEqual(r103, tc0.c.h().f545349f) == false) goto L16;
            com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b r104 = this.f77203a.f77200e;
            if (r104 == null) goto L11;
            r104.c();
        L11:
            g r105 = this.f77203a.f77198c;
            if (r105 != null) goto L14;
            return;
        L14:
            if (r105.isEngineOn() != true) goto L28;
            this.f77203a.f77198c.n();
            return;
        L28:
            return;
        L16:
            jg6.a r106 = this.f77203a.wq();
            if (r106 == null) goto L30;
            e r107 = r106.b();
            if (r107 == null) goto L31;
            ph0.a r108 = (ph0.a) sh6.c.b(r101);
            if (r108 == null) goto L24;
            String r109 = r108.f529230a;
            if (r109 == null) goto L24;
        L25:
            r107.h(r109, true, LiveCommonConstants.REASON_RTS_KICK_OUT);
            return;
        L24:
            r109 = "";
            goto L25
        L31:
            return;
        L30:
            return;
        L5:
            r103 = null;
            goto L7
        }
    }

    public final jg6.a wq() {
        cg6.a r100 = (cg6.a) getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.e5();
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return o.c();
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        g r100 = this.f77198c;
        if (r100 == null) goto L5;
        r100.z((com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a) this.f77196a.getValue());
    L5:
        Pair r101 = com.bytedance.live.datacontext.d.a(RTSVoiceWidget$onCreate$pair$1.INSTANCE);
        com.bytedance.live.datacontext.b.a((DataContext) r101.getFirst(), RTSDataContext.class);
        this.f77197b.add((Disposable) r101.getSecond());
        i<ILinkPlayerInfoBridge> r102 = this.f77199d;
        if (r102 == null) goto L8;
        r102.Q4(new c(this));
    L8:
        com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a r103 = (com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a) this.f77196a.getValue();
        com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.c r104 = (com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.c) r101.getFirst();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "listener");
        if (r103.f77204a.contains(r104) == true) goto L11;
        r103.f77204a.add(r104);
    L11:
        RTSDataContext.a r105 = RTSDataContext.Companion;
        RTSDataContext r106 = r105.getContext();
        if (r106 == null) goto L20;
        n<ph0.c> r107 = r106.getSilenceEvent();
        if (r107 == null) goto L20;
        Observable<sh6.b<ph0.c>> r108 = r107.a();
        if (r108 == null) goto L20;
        Disposable r109 = r108.subscribe(new a(this));
        if (r109 == null) goto L20;
        RxUtilKt.c(r109, this.f77197b);
    L20:
        RTSDataContext r110 = r105.getContext();
        if (r110 == null) goto L30;
        n<ph0.a> r111 = r110.getKickOutEvent();
        if (r111 == null) goto L31;
        Observable<sh6.b<ph0.a>> r112 = r111.a();
        if (r112 == null) goto L32;
        Disposable r113 = r112.subscribe(new b(this));
        if (r113 == null) goto L33;
        RxUtilKt.c(r113, this.f77197b);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        this.f77197b.clear();
        ((com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a) this.f77196a.getValue()).f77204a.clear();
    }

    public final void xq(List<? extends ILinkPlayerInfoBridge> r100) {
        if (r100 == null) goto L20;
        Iterator<T> r101 = r100.iterator();
    L5:
        if (r101.hasNext() == false) goto L34;
        ILinkPlayerInfoBridge r102 = (ILinkPlayerInfoBridge) r101.next();
        if (r2.a(r102.getMInteractIdStr()) == false) goto L5;
        if ((!Intrinsics.areEqual(r102.getMInteractIdStr(), tc0.c.h().f545349f)) == false) goto L5;
        if (r102.getSilenceStatus() != 0) goto L5;
        jg6.a r103 = wq();
        if (r103 == null) goto L5;
        e r104 = r103.b();
        if (r104 == null) goto L5;
        String r105 = r102.getMInteractIdStr();
        if (r105 != null) goto L19;
        r105 = "";
    L19:
        r104.h(r105, false, LiveCommonConstants.REASON_RTS_USER_LIST_CHANGED_VOICE);
        goto L5
    L34:
        return;
    }

    public RTSVoiceWidget(g r100, y r101, com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b r102, dn0.c r103) {
        this.f77198c = r100;
        this.f77199d = r101;
        this.f77200e = r102;
        this.f77201f = r103;
        this.f77196a = LazyKt.lazy(new RTSVoiceWidget$mRTSHandler$2(this));
        this.f77197b = new CompositeDisposable();
    }

    public /* synthetic */ RTSVoiceWidget(g r100, y r101, com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102, null);
    }
}
