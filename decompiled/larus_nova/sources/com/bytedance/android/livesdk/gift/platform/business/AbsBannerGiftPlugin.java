package com.bytedance.android.livesdk.gift.platform.business;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.model.e0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public abstract class AbsBannerGiftPlugin extends l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h1 f126478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f126479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PublishSubject<Boolean> f126480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f126481h;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.livesdk.gift.platform.business.dialog.topview.b {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final AbsBannerGiftPlugin f126482k;

        @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.b, com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a
        public final void d() {
            e0 r100 = this.f126585d;
            String r101 = "";
            if (r100 == null) goto L6;
            String r102 = r100.uri;
            if (r102 == null) goto L6;
        L7:
            Uri r103 = UriProtector.parse(r102);
            if (r103 == null) goto L12;
            String r104 = UriProtector.getQueryParameter(r103, "hide_panel");
            if (r104 == null) goto L12;
            int r105 = CastIntegerProtector.parseInt(r104);
        L14:
            if (r105 != 1) goto L16;
            com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
        L16:
            AbsBannerGiftPlugin r106 = this.f126482k;
            e0 r107 = this.f126585d;
            if (r107 == null) goto L19;
            String r108 = r107.uri;
        L20:
            r106.getClass();
            Context r109 = r106.getContext();     // Catch: Throwable -> L29
            if (r109 == null) goto L34;
            if (r108 == null) goto L27;
            r101 = r108;
        L27:
            zz0.h.a(r109, UriProtector.parse(r101));     // Catch: Throwable -> L29
            r106.N(r108, ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).b().getIdString());     // Catch: Throwable -> L29
            return;
        L34:
            return;
        L29:
            th = move-exception;
            jy0.b.b("ttlive_default_banner", "failed to open uri " + r108, th);
            return;
        L19:
            r108 = null;
        L12:
            r105 = 0;
        L6:
            r102 = "";
            goto L7
        }

        public b(Context r100, DataCenter r101, AbsBannerGiftPlugin r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "dataCenter");
            Intrinsics.checkNotNullParameter(r102, CloudControlInf.PLUGIN);
            super(r100, r101);
            this.f126482k = r102;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsBannerGiftPlugin f126483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f126484b;

        public c(AbsBannerGiftPlugin r100, long r101) {
            this.f126483a = r100;
            this.f126484b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AbsBannerGiftPlugin r100 = this.f126483a;     // Catch: Throwable -> L9
            h1 r101 = null;
            h1 r102 = GiftManagerKt.j(this.f126484b, null);     // Catch: Throwable -> L9
            if (r102 != null) goto L5;
        L7:
            AbsBannerGiftPlugin.I(r100, r101);     // Catch: Throwable -> L9
            return;
        L5:
            if (this.f126483a.J(r102) == false) goto L7;
            r101 = r102;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L13;
            return;
        L13:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsBannerGiftPlugin f126485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbsPanel f126486b;

        public d(AbsBannerGiftPlugin r100, AbsPanel r101) {
            this.f126485a = r100;
            this.f126486b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AbsBannerGiftPlugin r100 = this.f126485a;     // Catch: Throwable -> L16
            AbsPanel r101 = this.f126486b;     // Catch: Throwable -> L16
            r100.getClass();     // Catch: Throwable -> L16
            h1 r102 = null;
            if (r101 == null) goto L5;
            Object r103 = r101.f126620h;     // Catch: Throwable -> L16
        L7:
            if ((r103 instanceof h1) == true) goto L9;
            r103 = null;
        L9:
            h1 r104 = (h1) r103;     // Catch: Throwable -> L16
            if (r104 != null) goto L12;
        L14:
            AbsBannerGiftPlugin.I(r100, r102);     // Catch: Throwable -> L16
            return;
        L12:
            if (r100.J(r104) == false) goto L14;
            r102 = r104;
            goto L14
        L5:
            r103 = null;
        L16:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L20;
            return;
        L20:
            throw th;
        }
    }

    static {
    }

    public abstract boolean J(h1 r100);

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.h
    public com.bytedance.android.livesdk.gift.platform.business.dialog.topview.i<Boolean> E() {
        return new com.bytedance.android.livesdk.gift.platform.business.dialog.topview.i(this.f126480g, new AbsBannerGiftPlugin$provideTopViewController$1(this));
    }

    public final com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a K() {
        return L(getContext(), this.f129749b);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final void c() {
        com.bytedance.android.livesdk.gift.platform.business.dialog.topview.c.a();
        this.f126481h = null;
        super.c();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.h
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.gift.platform.business.dialog.topview.c.a();
        this.f126481h = null;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final void i(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, PbRequest.SwitchType.GIFT);
        com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a r101 = K();
        if (r101 == null) goto L6;
        r101.e(r100.getId());
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final void y(p2 r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a r101 = K();
        if (r101 == null) goto L6;
        r101.f(r100);
        return;
    }

    public AbsBannerGiftPlugin(DataCenter r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f126480g = PublishSubject.create();
    }

    public static final void I(AbsBannerGiftPlugin r100, h1 r101) {
        r100.f126478e = r101;
        if (r101 == null) goto L11;
        r100.f126479f = Long.valueOf(r101.getId());
        com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a r102 = r100.K();
        if (r102 == null) goto L7;
        r102.f126584c = r101;
    L7:
        com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a r103 = r100.K();
        if (r103 == null) goto L10;
        r103.g(r101.getGiftBanner());
    L10:
        r100.f126480g.onNext(Boolean.TRUE);
        return;
    L11:
        r100.f126479f = 0L;
        r100.f126480g.onNext(Boolean.FALSE);
    }

    public com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a L(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        if (r100 == null) goto L8;
        if (this.f126481h != null) goto L8;
        this.f126481h = new b(r100, r101, this);
    L8:
        return this.f126481h;
    }

    public final void N(String r110, String r111) {
        Map r100 = MapsKt.mapOf(TuplesKt.to("uri", String.valueOf(r110)));
        boolean r101 = d0.f130477a;
        if (r110 != null) goto L5;
        r110 = "";
    L5:
        Intrinsics.checkNotNullParameter(r110, "uriString");
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        JSONObject r112 = new JSONObject();
        Intrinsics.checkNotNullParameter(r112, "extra");
        Intrinsics.checkNotNullParameter(r103, "metric");
        EventModule r104 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r104, "eventModule");
        String r105 = r104.getValue();
        r103.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r112, "map");
        Intrinsics.checkNotNullParameter("uri", "key");
        Intrinsics.checkNotNullParameter(r110, "value");
        r112.put("uri", r110);
        cy0.e.f465759a.getClass();
        cy0.j r106 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r113 = m.b(r106).b(n97.a.class);
        Intrinsics.checkNotNull(r113);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r113)).g("ttlive_default_gift_banner_click", r105, "bussiness_api_call", r102, r103, r112);
        jy0.b.a("ttlive_default_banner", "ttlive_default_gift_banner_click " + r100);
        Pair[] r114 = new Pair[2];
        Object r107 = this.f126479f;
        if (r107 != null) goto L8;
        r107 = "";
    L8:
        r114[0] = TuplesKt.to(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, r107.toString());
        if (r111 != null) goto L11;
        r111 = "";
    L11:
        r114[1] = TuplesKt.to("user_id", r111);
        Map<? extends String, ? extends String> r115 = MapsKt.mapOf(r114);
        n r116 = new n();
        Map<String, String> r108 = r116.f516447a;
        Intrinsics.checkNotNullParameter(r108, "map");
        Intrinsics.checkNotNullParameter(r115, "map");
        r108.putAll(r115);
        mz0.m r117 = new mz0.m();
        r117.b(LogCommon.ROOM);
        r117.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r116.f516448b).addAll(r117.f516446a);
        Object r118 = m.b(r106).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r118);
        ((mz0.i) ((f80.a) r118)).w3("livesdk_gift_bubble_banner_click", r116.f516447a, r116.f516448b);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final void j(long r100, Integer r101) {
        new Handler(Looper.getMainLooper()).post(new c(this, r100));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean x(AbsPanel<?> r100, SelectedStatus r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r101, "selectedStatus");
        new Handler(Looper.getMainLooper()).post(new d(this, r100));
        Intrinsics.checkNotNullParameter(r101, "selectedStatus");
        return false;
    }
}
