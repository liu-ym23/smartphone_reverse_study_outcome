package com.bytedance.android.live.broadcastgame.opengame.service;

import android.text.TextUtils;
import com.bytedance.android.live.broadcastgame.opengame.message.m0;
import com.bytedance.android.live.broadcastgame.opengame.message.r;
import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.j;
import com.bytedance.android.live.broadcastgame.opengame.runtime.p;
import com.bytedance.android.live.broadcastgame.opengame.t;
import com.bytedance.android.live.broadcastgame.opengame.view.PayFlowView;
import com.bytedance.android.live.broadcastgame.opengame.view.RewardMsgContainer;
import com.bytedance.android.live.broadcastgame.opengame.view.c0;
import com.bytedance.android.live.broadcastgame.opengame.view.m;
import com.bytedance.android.live.broadcastgame.opengame.view.u;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.common.utility.Logger;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/service/CommercialService;", "Ly10/a;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/p;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommercialService implements y10.a, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PanelType f60929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u f60930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PayFlowView f60931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f60932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f60933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f60934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c0 f60935g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RewardMsgContainer f60936h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function1<? super RewardMsgContainer, Unit> f60937i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PluginContext f60938j;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommercialService f60939a;

        public a(CommercialService r100) {
            this.f60939a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            r r101 = (r) r100;
            CommercialService r102 = this.f60939a;
            if (r102.a() == true) goto L6;
            return;
        L6:
            if (r102.f60931c != null) goto L10;
            Function0<Unit> r103 = r102.f60933e;
            if (r103 == null) goto L10;
            Unit r104 = r103.invoke();
        L10:
            u r105 = r102.f60930b;
            if (r105 == null) goto L17;
            Intrinsics.checkNotNullParameter(r101, "msg");
            if (r105.f61329a.size() < 1000) goto L15;
            r105.f61329a.pop();
        L15:
            r105.f61329a.add(new m(System.currentTimeMillis(), r101));
        L17:
            if (v.a() == true) goto L19;
        L23:
            PayFlowView r106 = r102.f60931c;
            if (r106 != null) goto L26;
            return;
        L26:
            if (r106.T5() == false) goto L28;
            return;
        L28:
            if (v.a() == false) goto L30;
            Logger.d("PayFlowView", "新流水来了，没有老流水，直接从队列获取展示");
        L30:
            PayFlowView r107 = r102.f60931c;
            if (r107 == null) goto L36;
            r107.f61240e = r102.f60934f;
            r107.S5();
            return;
        L36:
            return;
        L19:
            if (r102.f60931c != null) goto L23;
            throw new RuntimeException("payFlowView is null");
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f60940a = null;

        static {
            f60940a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommercialService f60941a;

        public c(CommercialService r100) {
            this.f60941a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            m0 r101 = (m0) r100;
            CommercialService r102 = this.f60941a;
            if (r102.b() == false) goto L27;
            String r103 = r102.f60938j.f60809m.f61083i;
            if (TextUtils.equals(r101.f60252b, r103) == true) goto L9;
            Logger.d("OpenReward", "appId 不匹配，curAppId=" + r103 + ", rewardAppId=" + r101.f60252b);
            return;
        L9:
            if (r102.f60936h != null) goto L13;
            Function1<? super RewardMsgContainer, Unit> r104 = r102.f60937i;
            if (r104 == null) goto L13;
            r102.f60935g = new c0();
            RewardMsgContainer r105 = new RewardMsgContainer(r102.f60938j);
            c0 r106 = r102.f60935g;
            Intrinsics.checkNotNull(r106);
            Intrinsics.checkNotNullParameter(r106, "queue");
            r105.f61267a = r106;
            t r107 = r102.f60938j.f60809m;
            Intrinsics.checkNotNullParameter(r107, "info");
            r105.f61268b = r107;
            Unit r108 = Unit.INSTANCE;
            r102.f60936h = r105;
            Intrinsics.checkNotNull(r105);
            Unit r109 = r104.invoke(r105);
        L13:
            c0 r110 = r102.f60935g;
            if (r110 == null) goto L16;
            Intrinsics.checkNotNullParameter(r101, "reward");
            r110.f61288a.add(r101);
            r110.f61289b.add(r101);
        L16:
            RewardMsgContainer r111 = r102.f60936h;
            if (r111 != null) goto L19;
        L20:
            RewardMsgContainer r112 = r102.f60936h;
            if (r112 == null) goto L26;
            r112.c();
            return;
        L26:
            return;
        L19:
            if (r111.d() != true) goto L20;
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f60942a = null;

        static {
            f60942a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void fail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
    }

    @Override // y10.a
    public final void g() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void hide() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void l(Map<String, String> r100) {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void launch() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void start() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void stop() {
    }

    public final boolean a() {
        PluginContext r100 = this.f60938j;
        if (r100.f60811o == true) goto L5;
        return false;
    L5:
        com.bytedance.android.live.broadcastgame.opengame.runtime.g r101 = ((BootInfoService) r100.o(BootInfoService.class)).c();
        if (r101 == null) goto L20;
        j r102 = r101.f60835b;
        if (r102 == null) goto L20;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a> r103 = r102.f60839a;
        if (r103 == null) goto L20;
        Iterator<T> r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L20;
        com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a r105 = (com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a) r104.next();
        if (Intrinsics.areEqual(r105.c(), "payDiamonds") == true) goto L16;
        if (Intrinsics.areEqual(r105.c(), "payDiamondsV3") == false) goto L13;
    L16:
        boolean r106 = true;
    L22:
        if (r106 == true) goto L24;
        com.bytedance.android.live.broadcastgame.api.model.u r107 = this.f60938j.f60809m.e();
        if (r107 == null) goto L32;
        com.bytedance.android.live.broadcastgame.api.model.r r108 = r107.c();
        if (r108 == null) goto L32;
        Integer r109 = Integer.valueOf(r108.g());
    L33:
        if (r109 != null) goto L36;
    L37:
        if (r109 == null) goto L43;
        if (r109.intValue() != 2) goto L43;
    L47:
        if (v.a() == false) goto L49;
        Logger.d("PayFlowView", "payEnabled is true, businessType = " + r109);
    L49:
        return true;
    L43:
        if (v.a() == false) goto L45;
        Logger.d("PayFlowView", "payEnabled is false");
    L45:
        return false;
    L36:
        if (r109.intValue() == 1) goto L47;
    L32:
        r109 = null;
        goto L33
    L24:
        if (v.a() == false) goto L26;
        Logger.d("PayFlowView", "payEnabled is true, bootconfig");
    L26:
        return true;
    L20:
        r106 = false;
        goto L22
    }

    public final boolean b() {
        PluginContext r100 = this.f60938j;
        if (r100.f60811o == false) goto L5;
        return false;
    L5:
        com.bytedance.android.live.broadcastgame.opengame.runtime.g r101 = ((BootInfoService) r100.o(BootInfoService.class)).c();
        if (r101 == null) goto L17;
        j r102 = r101.f60835b;
        if (r102 == null) goto L17;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a> r103 = r102.f60839a;
        if (r103 == null) goto L17;
        Iterator<T> r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L17;
        if (Intrinsics.areEqual(((com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a) r104.next()).c(), "propRewardMsgNotifyCenter") == false) goto L13;
        boolean r105 = true;
    L19:
        if (r105 == true) goto L21;
        Object r106 = this.f60938j.f60809m.f61085k.get("business_type");
        Integer r107 = null;
        if ((r106 instanceof Integer) == true) goto L27;
        r106 = null;
    L27:
        Integer r108 = (Integer) r106;
        if (r108 == null) goto L30;
        int r109 = r108.intValue();
    L32:
        if (r109 != 2) goto L43;
        if (v.a() == false) goto L41;
        StringBuilder r110 = new StringBuilder("rewardEnabled is true, businessType = ");
        com.bytedance.android.live.broadcastgame.api.model.u r111 = this.f60938j.f60809m.e();
        if (r111 == null) goto L40;
        com.bytedance.android.live.broadcastgame.api.model.r r112 = r111.c();
        if (r112 == null) goto L40;
        r107 = Integer.valueOf(r112.g());
    L40:
        r110.append(r107);
        Logger.d("PayFlowView", r110.toString());
    L41:
        return true;
    L43:
        if (v.a() == false) goto L45;
        Logger.d("PayFlowView", "rewardEnabled is false");
    L45:
        return false;
    L30:
        r109 = 0;
        goto L32
    L21:
        if (v.a() == false) goto L23;
        Logger.d("PayFlowView", "rewardEnabled is true, bootconfig");
    L23:
        return true;
    L17:
        r105 = false;
        goto L19
    }

    public CommercialService(PluginContext r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        i20.a r101 = new i20.a();
        this.f60938j = r100;
        this.f60929a = PanelType.PANEL_TYPE_X_SCREEN_LOW;
        com.bytedance.android.live.broadcastgame.opengame.message.c0 r102 = r100.f60808l;
        if (r102 == null) goto L9;
        Observable r103 = r102.a(r.class);
        if (r103 == null) goto L9;
        Disposable r104 = r103.subscribe(new a(this), b.f60940a);
        if (r104 == null) goto L9;
        Intrinsics.checkNotNullParameter(r104, "$this$autoDispose");
        r101.a(r104);
    L9:
        com.bytedance.android.live.broadcastgame.opengame.message.c0 r105 = r100.f60808l;
        if (r105 == null) goto L17;
        Observable r106 = r105.a(m0.class);
        if (r106 == null) goto L18;
        Disposable r107 = r106.subscribe(new c(this), d.f60942a);
        if (r107 == null) goto L19;
        Intrinsics.checkNotNullParameter(r107, "$this$autoDispose");
        r101.a(r107);
        return;
    L19:
        return;
    L18:
        return;
    }
}
