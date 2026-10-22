package com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.e;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.pk.service.IPkAudienceLoadService;
import com.bytedance.android.live.revlink.impl.utils.v;
import com.bytedance.android.live.revlink.link.biz.service.d;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.service.room.c;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.revenue.platform.api.core.rx.f;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.p;
import com.ss.android.lark.utils.statistics.PerfLog;
import cy0.j;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import mz0.m;
import mz0.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class DoubleAudiencePKComponent implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f98112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f98113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f98114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f98115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v f98116e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f98117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f98118g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f98119h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f98120i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f98121j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DoubleAudienceBizDataContext f98122k;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubleAudiencePKComponent f98123a;

        public a(DoubleAudiencePKComponent r100) {
            this.f98123a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Integer r101 = (Integer) r100;
            this.f98123a.f98115d = false;
            DoubleAudiencePKComponent.b(false);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.DoubleAudiencePKComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public AnonymousClass1(DoubleAudiencePKComponent r100) {
            super(1, r100, DoubleAudiencePKComponent.class, "onPKTimeLeftChange", "onPKTimeLeftChange(Ljava/lang/Long;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long r110) {
            DoubleAudiencePKComponent r100 = (DoubleAudiencePKComponent) this.receiver;
            r100.getClass();
            if (r110 == null) goto L30;
            r110.longValue();
            if (r100.f98119h == true) goto L31;
            r100.f98119h = true;
            long r101 = r110.longValue() * ((long) 1000);
            r100.f98114c.clear();
            if (r101 <= 0) goto L32;
            s41.a r102 = s41.a.f540541e;
            if (r102.a().K6() == false) goto L11;
            List<Long> r103 = r102.a().A();
        L12:
            List<Long> r104 = r103;
            Iterator<T> r105 = r104.iterator();
        L14:
            if (r105.hasNext() == false) goto L21;
            long r106 = ((Number) r105.next()).longValue();
            if (1 > r106) goto L14;
            if (r101 <= r106) goto L14;
            l r111 = l.f267516a;
            Observable r112 = Observable.just(1);
            long r113 = r101 - r106;
            int r107 = p.f267522a;
            Scheduler r114 = Schedulers.computation();
            f.a(r112.delay(r113, TimeUnit.MILLISECONDS, r114, false).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.a(r100)), r100.f98114c);
            goto L14
        L21:
            v r108 = r100.f98116e;
            r108.getClass();
            Intrinsics.checkNotNullParameter(r103, "delayTimeInMills");
            JSONObject r109 = new JSONObject();
            int r115 = y50.b.f566204a;
            y50.b.a.c(r109, "time_left", r101);
            r109.put("delay_time", CollectionsKt.toList(r104));
            r108.b("delay_sync", r109);
            return;
        L11:
            r103 = ((ys1.b) s41.a.f540538b.getValue(r102, s41.a.f540537a[0])).A();
            goto L12
        L32:
            return;
        L31:
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.DoubleAudiencePKComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<PkBaseStateMachine.c, Unit> {
        public AnonymousClass2(DoubleAudiencePKComponent r100) {
            super(1, r100, DoubleAudiencePKComponent.class, "onPKStateChange", "onPKStateChange(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$State;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PkBaseStateMachine.c r100) {
            DoubleAudiencePKComponent r101 = (DoubleAudiencePKComponent) this.receiver;
            if (r100 != null) goto L5;
            r101.getClass();
            return;
        L5:
            DoubleAudienceBizDataContext r102 = r101.f98122k;
            boolean r103 = r100 instanceof PkBaseStateMachine.c.C1444c;
            if (r103 == false) goto L15;
            e r104 = i.S(r101);
            if (r104 == null) goto L10;
            aa r105 = r104.getVoteSetting();
        L11:
            r102.f98097a = r105;
            e r106 = i.S(r101);
            if (r106 == null) goto L18;
            r106.isOnceMoreBattle();
        L18:
            if (r101.f98117f == false) goto L30;
            if (r103 == false) goto L22;
            r101.f98114c.clear();
            r101.f98119h = false;
            r101.f98115d = false;
            goto L30
        L22:
            if (r101.f98118g == false) goto L30;
            if (r101.f98115d == false) goto L30;
            if ((r100 instanceof PkBaseStateMachine.c.b) == false) goto L28;
        L29:
            r101.a(1000, "finish_or_penal");
            goto L30
        L28:
            if ((r100 instanceof PkBaseStateMachine.c.d) == true) goto L29;
        L30:
            LinkedHashMap r107 = new LinkedHashMap();
            if (r103 == false) goto L41;
            r107.put("pk_status", "1");
            e r108 = i.S(r101);
            if (r108 == null) goto L38;
            LiveData<Long> r109 = r108.getBaseTimeLeft();
            if (r109 == null) goto L38;
            Long r110 = r109.getValue();
            if (r110 == null) goto L38;
        L39:
            r107.put("pkleft_time", String.valueOf(r110.longValue()));
        L45:
            n r111 = new n();
            Map<String, String> r112 = r111.f516447a;
            Intrinsics.checkNotNullParameter(r112, "map");
            Intrinsics.checkNotNullParameter(r107, "map");
            r112.putAll(r107);
            m r113 = new m();
            r113.b(LogCommon.ROOM);
            List<Object> r114 = r111.f516448b;
            ArrayList r115 = (ArrayList) r114;
            r115.addAll(r113.f516446a);
            cy0.e.f465759a.getClass();
            j r116 = cy0.e.a.f465760a;
            com.bytedance.android.scope.m.f163449e.getClass();
            Object r117 = com.bytedance.android.scope.m.b(r116).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r117);
            ((mz0.i) ((f80.a) r117)).w3("livesdk_transfer_pk_context", r111.f516447a, r111.f516448b);
            if ((r100 instanceof PkBaseStateMachine.c.a) == true) goto L54;
            i.l(r101);
            if (IPkAudienceLoadService.LoadType.MessageLoad == null) goto L55;
            Intrinsics.checkNotNullParameter(r101, "$this$pkAudienceDataService");
            com.bytedance.android.live.revlink.impl.pk.service.f r118 = i.getContext(r101).Aa();
            if (r118 == null) goto L56;
            r118.reportUiFirstLoad();
            return;
        L56:
            return;
        L55:
            return;
        L54:
            return;
        L38:
            r110 = -1L;
            goto L39
        L41:
            if ((r100 instanceof PkBaseStateMachine.c.b) == false) goto L43;
        L44:
            r107.put("pk_status", "0");
            goto L45
        L43:
            if ((r100 instanceof PkBaseStateMachine.c.d) == false) goto L45;
        L10:
            r105 = null;
            goto L11
        L15:
            if ((r100 instanceof PkBaseStateMachine.c.b) == false) goto L18;
            r102.getClass();
            goto L18
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PkBaseStateMachine.c r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAudienceComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        Intrinsics.checkNotNullParameter(this, "$this$pkEnterRoomTracer");
        i.getContext(this).getPkEnterRoomTracer().getClass();
        i97.a r100 = i97.a.f488802a;
        System.currentTimeMillis();
        if (this.f98117f == false) goto L11;
        e r101 = i.S(this);
        if (r101 == null) goto L11;
        LiveData<Long> r102 = r101.getBaseTimeLeft();
        if (r102 == null) goto L11;
        Disposable r103 = UtilsKt.d(r102, new AnonymousClass1(this));
        if (r103 == null) goto L11;
        f.a(r103, this.f98113b);
    L11:
        e r104 = i.S(this);
        if (r104 == null) goto L18;
        LiveData<PkBaseStateMachine.c> r105 = r104.getPkBaseState();
        if (r105 == null) goto L18;
        Disposable r106 = UtilsKt.d(r105, new AnonymousClass2(this));
        if (r106 == null) goto L18;
        f.a(r106, this.f98113b);
    L18:
        getContext().md().b();
        Intrinsics.checkNotNullParameter(this, "$this$pkEnterRoomTracer");
        i.getContext(this).getPkEnterRoomTracer().getClass();
        System.currentTimeMillis();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.f98113b.clear();
        getContext().md().a();
        this.f98119h = false;
        if (this.f98118g == true) goto L5;
    L7:
        this.f98114c.dispose();
        return;
    L5:
        if (this.f98115d == false) goto L7;
        a(0, "widget_destroy");
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.f98112a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public b getContext() {
        return this.f98120i;
    }

    public static void b(boolean r100) {
        if (s41.a.f540541e.a().K6() == false) goto L9;
        JSONObject r101 = new JSONObject();
        if (r100 == false) goto L7;
        String r102 = "livesdk_pk_start";
    L8:
        r101.put("trigger_name", r102);
        cy0.e.f465759a.getClass();
        j r103 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r104 = com.bytedance.android.scope.m.b(r103).b(com.bytedance.android.livesdk.revenue.service.gift.a.class);
        Intrinsics.checkNotNull(r104);
        ((com.bytedance.android.livesdk.revenue.service.gift.a) ((com.bytedance.live.kmp.core.c) r104)).triggerGiftAsyncSort(r101);
        return;
    L7:
        r102 = "livesdk_pk_end";
        goto L8
    L9:
        cy0.e.f465759a.getClass();
        j r105 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r106 = com.bytedance.android.scope.m.b(r105).b(com.bytedance.android.livesdk.revenue.service.gift.a.class);
        Intrinsics.checkNotNull(r106);
        ((com.bytedance.android.livesdk.revenue.service.gift.a) ((com.bytedance.live.kmp.core.c) r106)).qi();
    }

    public final void a(long r100, String r110) {
        this.f98114c.clear();
        if (r100 <= 0) goto L5;
        l r101 = l.f267516a;
        Observable r102 = Observable.just(1);
        int r103 = p.f267522a;
        Scheduler r104 = Schedulers.computation();
        f.a(r102.delay(r100, TimeUnit.MILLISECONDS, r104, false).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)), this.f98114c);
    L6:
        v r105 = this.f98116e;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r110, "reason");
        JSONObject r106 = new JSONObject();
        int r107 = y50.b.f566204a;
        y50.b.a.d(r106, "reason", r110);
        r105.b("reset_gift_to_broadcast", r106);
        return;
    L5:
        this.f98115d = false;
        b(false);
        goto L6
    }

    public DoubleAudiencePKComponent(b r100, c r101, DoubleAudienceBizDataContext r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "roomService");
        Intrinsics.checkNotNullParameter(r102, "bizDataContext");
        this.f98120i = r100;
        this.f98121j = r101;
        this.f98122k = r102;
        this.f98112a = "DoubleAudiencePKComponent";
        this.f98113b = new CompositeDisposable();
        this.f98114c = new CompositeDisposable();
        this.f98116e = new v(r101, getContext());
        s41.a r103 = s41.a.f540541e;
        r103.getClass();
        ReadOnlyProperty r104 = s41.a.f540538b;
        KProperty<?>[] r105 = s41.a.f540537a;
        boolean r106 = false;
        ys1.b r107 = (ys1.b) r104.getValue(r103, r105[0]);
        Intrinsics.checkNotNullParameter(r107, "$this$isPkFeatureEnable");
        if (r107.Q7() != true) goto L9;
        List<Long> r108 = r107.A();
        if (r108 == null) goto L9;
        if (r108.isEmpty() == true) goto L9;
        boolean r109 = true;
    L10:
        if (r109 == false) goto L12;
    L15:
        boolean r110 = true;
    L16:
        this.f98117f = r110;
        ys1.b r111 = (ys1.b) r104.getValue(r103, r105[0]);
        Intrinsics.checkNotNullParameter(r111, "$this$isResetGiftAfterPk");
        Intrinsics.checkNotNullParameter(r111, "$this$isPkFeatureEnable");
        if (r111.Q7() != true) goto L23;
        List<Long> r112 = r111.A();
        if (r112 == null) goto L23;
        if (r112.isEmpty() == true) goto L23;
        boolean r113 = true;
    L24:
        if (r113 == true) goto L26;
    L28:
        boolean r114 = false;
    L29:
        if (r114 == false) goto L31;
    L34:
        r106 = true;
    L35:
        this.f98118g = r106;
        return;
    L31:
        if (r103.a().K6() == false) goto L35;
        if (r103.a().u3() == false) goto L35;
    L26:
        if (r111.o6() != true) goto L28;
        r114 = true;
    L23:
        r113 = false;
        goto L24
    L12:
        if (r103.a().K6() == true) goto L15;
        r110 = false;
    L9:
        r109 = false;
        goto L10
    }
}
