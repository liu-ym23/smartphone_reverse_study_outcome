package com.bytedance.android.livesdk.dynamicstrategy.impl;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.m;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.s;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.g0;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.j;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.l;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lu1.n;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<d<?, ?>> f123037a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<f<?>> f123038b = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.dynamicstrategy.impl.a$a, reason: collision with other inner class name */
    public interface InterfaceC1961a<T, R> {
        R convert(T r100);
    }

    public static final class b implements InterfaceC1961a<Integer, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f123039a = null;

        public b() {
        }

        static {
            f123039a = new b();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.a.InterfaceC1961a
        public final Integer convert(Integer r100) {
            return Integer.valueOf(r100.intValue());
        }
    }

    public static final class c implements InterfaceC1961a<Long, Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f123040a = null;

        public c() {
        }

        static {
            f123040a = new c();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.a.InterfaceC1961a
        public final Long convert(Long r100) {
            return Long.valueOf(r100.longValue());
        }
    }

    public static final class d<T, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f123041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f123042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f123043c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final R f123044d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final InterfaceC1961a<T, R> f123045e;

        public d(String r100, T r101, String r102, R r103, InterfaceC1961a<T, R> r104) {
            Intrinsics.checkNotNullParameter(r100, "featureName");
            Intrinsics.checkNotNullParameter(r102, "factorName");
            Intrinsics.checkNotNullParameter(r104, "convert");
            this.f123041a = r100;
            this.f123042b = r101;
            this.f123043c = r102;
            this.f123044d = r103;
            this.f123045e = r104;
        }
    }

    public static final class e extends DynamicFactor<Object> implements z90.a.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z90.a f123046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d<Object, Object> f123047c;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.dynamicstrategy.impl.a$e$a, reason: collision with other inner class name */
        public static final class RunnableC1962a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f123048a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f123049b;

            public RunnableC1962a(Object r100, e r101) {
                this.f123048a = r100;
                this.f123049b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f123049b.update(this.f123048a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public final Object b() {
            z90.a r100 = this.f123046b;
            if (r100 == null) goto L6;
            d<Object, Object> r101 = this.f123047c;
            Object r102 = r100.getFeature(r101.f123041a, r101.f123042b);
            if (r102 == null) goto L6;
        L8:
            return this.f123047c.f123045e.convert(r102);
        L6:
            r102 = this.f123047c.f123042b;
            goto L8
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public final String c() {
            return this.f123047c.f123043c;
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public final void d() {
            z90.a r100 = this.f123046b;
            if (r100 == null) goto L6;
            r100.e(this, CollectionsKt.listOf(this.f123047c.f123041a));
            return;
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public final void e() {
            z90.a r100 = this.f123046b;
            if (r100 == null) goto L6;
            r100.h(this);
            return;
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public DynamicFactor.Type getType() {
            return DynamicFactor.Type.SMART_MIX;
        }

        public e(d<Object, Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "mixFeature");
            this.f123047c = r100;
            IFeatureService r101 = (IFeatureService) k.f(IFeatureService.class);
            if (r101 == null) goto L5;
            z90.a r102 = r101.getFeatureManager();
        L6:
            this.f123046b = r102;
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // z90.a.b
        public final <T> void a(String r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            if (r101 == null) goto L8;
            Object r102 = this.f123047c.f123045e.convert(r101);
            if (r102 == null) goto L9;
            MainThreadPostUtils.e(new RunnableC1962a(r102, this));
            return;
        L9:
            return;
        }
    }

    public static final class f<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f123050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final R f123051b;

        public f(String r100, R r101) {
            Intrinsics.checkNotNullParameter(r100, "factorName");
            this.f123050a = r100;
            this.f123051b = r101;
        }
    }

    public static final class g extends DynamicFactor<Object> implements z90.a.b, Observer<KVData> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z90.a f123052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f<Object> f123053c;

        @Override // z90.a.b
        public final <T> void a(String r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public final Object b() {
            return this.f123053c.f123051b;
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public final String c() {
            return this.f123053c.f123050a;
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public final void d() {
            z90.a r100 = this.f123052b;
            if (r100 == null) goto L6;
            r100.e(this, CollectionsKt.listOf(this.f123053c.f123050a));
            return;
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public final void e() {
            z90.a r100 = this.f123052b;
            if (r100 == null) goto L6;
            r100.h(this);
            return;
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public DynamicFactor.Type getType() {
            return DynamicFactor.Type.SMART_MIX;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            KVData r101 = (KVData) r100;
            if (r101 == null) goto L17;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
            if (TextUtils.isEmpty(r101.getKey()) == false) goto L7;
        L9:
            Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        L13:
            Result.m9448boximpl(r103);
            return;
        L7:
            if (TextUtils.equals(r101.getKey(), this.f123053c.f123050a) == false) goto L9;
            MainThreadPostUtils.e(new com.bytedance.android.livesdk.dynamicstrategy.impl.b(this, r101));     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            Result.Companion r104 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L13
        }

        public g(f<Object> r100, DataCenter r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "mixFeature");
            Intrinsics.checkNotNullParameter(r101, "dataCenter");
            Intrinsics.checkNotNullParameter(r102, "key");
            this.f123053c = r100;
            IFeatureService r103 = (IFeatureService) k.f(IFeatureService.class);
            if (r103 == null) goto L5;
            z90.a r104 = r103.getFeatureManager();
        L6:
            this.f123052b = r104;
            if (TextUtils.isEmpty(r102) == true) goto L10;
            r101.observe(r102, this);
            return;
        L10:
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    public static final class h implements InterfaceC1961a<Float, Integer> {
        public h() {
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.a.InterfaceC1961a
        public final Integer convert(Float r100) {
            return Integer.valueOf((int) r100.floatValue());
        }
    }

    public static final class i implements InterfaceC1961a<Integer, Boolean> {
        public i() {
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.a.InterfaceC1961a
        public final Boolean convert(Integer r100) {
            int r101 = r100.intValue();
            if (r101 != 2) goto L5;
        L8:
            boolean r102 = true;
        L10:
            return Boolean.valueOf(r102);
        L5:
            if (r101 == 5) goto L8;
            r102 = false;
            goto L10
        }
    }

    static {
        b r110 = b.f123039a;
        f123037a = CollectionsKt.mutableListOf(new d[]{new d("live_ecom_live_cart_tag_click_count", 0, "live_ecom_live_cart_tag_click_count", 0, r110), new d("live_comment_count", 0, "live_comment_count", 0, r110), new d("live_gift_send_count", 0, "live_gift_send_count", 0, r110), new d("live_like_amount", 0, "live_like_amount", 0, r110), new d("live_watch_duration", 0L, "live_watch_duration", 0L, c.f123040a), new d("solaria_features_cl_is_wifi", -1, "network_type", 0, r110), new d("net_quality", 0, "net_quality", 0, r110), new d("battery_level", Float.valueOf(0.0f), "battery_level", 0, new h()), new d(IPerformanceManager.Battery.battery_state_android, 0, "is_charging", Boolean.FALSE, new i())});
        f123038b = CollectionsKt.mutableListOf(new f[]{new f("live_short_touch_ecom_redpack_type", 0), new f("live_short_touch_ecom_redpack_total_amount", 0), new f("live_short_touch_ecom_redpack_total_stock", 0), new f("live_short_touch_ecom_redpack_sub_type", 0)});
    }

    public static List a() {
        ArrayList r100 = new ArrayList();
        List r101 = CollectionsKt.listOf(new DynamicFactor[]{com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.e.f123153b, com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.c.f123150b, com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.d.f123151b, com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.b.f123147b, com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.f.f123155b, com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.g.f123158b, com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.h.f123160b, l.f123168b, j.f123166b, com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.k.f123167b, g0.f123159b});
        if (r101 == null) goto L5;
        r100.addAll(r101);
    L5:
        boolean r102 = com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.f123267a;
        List r103 = com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.c();
        ArrayList r104 = new ArrayList();
        Iterator r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L21;
        m r106 = (m) r105.next();
        Intrinsics.checkNotNullParameter(r106, "$this$isNFALiveRoom");
        if (r106.featureType != 6) goto L15;
        s r107 = r106.nfaInfo;
        if (r107 == null) goto L15;
        if (r107.c() != 3) goto L15;
        boolean r108 = true;
    L16:
        if (r108 == true) goto L18;
        n r109 = lu1.j.a(r106);
    L19:
        if (r109 == null) goto L7;
        r104.add(r109);
        goto L7
    L18:
        r109 = null;
    L15:
        r108 = false;
        goto L16
    L21:
        List r110 = CollectionsKt.toList(r104);
        if (r110 == null) goto L24;
        r100.addAll(r110);
    L24:
        return r100;
    }
}
