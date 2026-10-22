package com.bytedance.android.live.profit.vote.ui;

import com.bytedance.android.live.profit.vote.VoteUtilsKt;
import com.bytedance.android.live.revenue.common.PropertyOwnersKt;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.scope.o;
import com.bytedance.lark.pb.space.drive.v1.CoverDownloadInfo;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.n;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;

/* JADX INFO: loaded from: classes47.dex */
public final class VoteViewModel implements o {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f89326h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f89327i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f89328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f89329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f89330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n<com.bytedance.android.live.profit.vote.model.b> f89331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f89332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.profit.vote.model.f f89333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.profit.vote.f f89334g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoteViewModel f89335a;

        public b(VoteViewModel r100) {
            this.f89335a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            this.f89335a.f89329b.clear();
            VoteViewModel r102 = this.f89335a;
            com.bytedance.android.live.profit.vote.b r103 = (com.bytedance.android.live.profit.vote.b) sh6.c.b(r101);
            r102.getClass();
            int r104 = v.f91009a;
            v.a("VoteViewModel", "vote changed to " + r103);
            if (r103 != null) goto L6;
            r102.f89331d.a(com.bytedance.android.live.profit.vote.model.b.c.f89239a);
        L10:
            Object r105 = sh6.c.b(r101);
            if (r105 == null) goto L14;
            com.bytedance.android.live.profit.vote.model.c r106 = (com.bytedance.android.live.profit.vote.model.c) r105;
            com.bytedance.revenue.platform.api.core.rx.f.a(PropertyOwnersKt.c(r106.f89243a).subscribe(new i(r106, this)), this.f89335a.f89329b);
            return;
        L14:
            return;
        L6:
            if (VoteUtilsKt.h(r103) == false) goto L10;
            if (VoteUtilsKt.g() == false) goto L10;
            LinkedHashMap r107 = new LinkedHashMap();
            com.bytedance.android.live.profit.vote.f r108 = r102.f89334g;
            r108.c(r107);
            r108.a(r107);
            r108.d(r107);
            VoteUtilsKt.i(r107);
            mz0.n r109 = new mz0.n();
            Map<String, String> r110 = r109.f516447a;
            Intrinsics.checkNotNullParameter(r110, "map");
            Intrinsics.checkNotNullParameter(r107, "map");
            r110.putAll(r107);
            m r111 = new m();
            r111.b(LogCommon.ROOM);
            ((ArrayList) r109.f516448b).addAll(r111.f516446a);
            cy0.e.f465759a.getClass();
            cy0.j r112 = cy0.e.a.f465760a;
            com.bytedance.android.scope.m.f163449e.getClass();
            Object r113 = com.bytedance.android.scope.m.b(r112).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r113);
            ((mz0.i) ((f80.a) r113)).w3("livesdk_ksong_poll_start", r109.f516447a, r109.f516448b);
            goto L10
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.vote.ui.VoteViewModel$onStart$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/profit/vote/model/b;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/profit/vote/model/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<com.bytedance.android.live.profit.vote.model.b, Unit> {
        public AnonymousClass2(VoteViewModel r100) {
            super(1, r100, VoteViewModel.class, "onIconStateChanged", "onIconStateChanged(Lcom/bytedance/android/live/profit/vote/model/IconState;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.bytedance.android.live.profit.vote.model.b r210) {
            Intrinsics.checkNotNullParameter(r210, "p1");
            VoteViewModel r100 = (VoteViewModel) this.receiver;
            r100.f89330c.clear();
            int r101 = v.f91009a;
            v.a("VoteViewModel", "icon state changed to " + r210);
            if ((r210 instanceof com.bytedance.android.live.profit.vote.model.b.d) == false) goto L9;
            com.bytedance.android.live.profit.vote.model.b.d r102 = (com.bytedance.android.live.profit.vote.model.b.d) r210;
            com.bytedance.android.live.profit.vote.b r103 = r102.f89240a;
            long r104 = r103.a();
            if (r104 >= 0) goto L7;
            r104 = 0;
        L7:
            long r110 = r104 % 1000;
            l r105 = l.f267516a;
            int r106 = p.f267522a;
            Scheduler r111 = Schedulers.computation();
            TimeUnit r107 = TimeUnit.MILLISECONDS;
            com.bytedance.revenue.platform.api.core.rx.f.a(Observable.interval(0, 1000, r107, r111).delay(r110, r107, Schedulers.computation(), false).startWith(0L).observeOn(AndroidSchedulers.mainThread()).map(new j(r103)).subscribe(new k(r100, r102, r103)), r100.f89330c);
            return;
        L9:
            if ((r210 instanceof com.bytedance.android.live.profit.vote.model.b.a) == false) goto L12;
            l r108 = l.f267516a;
            long r109 = VoteViewModel.f89326h * ((long) 1000);
            int r112 = p.f267522a;
            com.bytedance.revenue.platform.api.core.rx.f.a(Observable.timer(r109, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(r100, r210)), r100.f89330c);
            return;
        L12:
            if ((r210 instanceof com.bytedance.android.live.profit.vote.model.b.C1370b) == false) goto L41;
            l r113 = l.f267516a;
            int r114 = p.f267522a;
            com.bytedance.revenue.platform.api.core.rx.f.a(Observable.timer(((long) 1000) * 5, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(r100)), r100.f89330c);
            com.bytedance.android.live.profit.vote.model.b.C1370b r115 = (com.bytedance.android.live.profit.vote.model.b.C1370b) r210;
            if (VoteUtilsKt.h(r115.f89238a) == true) goto L16;
            return;
        L16:
            if (VoteUtilsKt.g() == false) goto L43;
            LinkedHashMap r116 = new LinkedHashMap();
            com.bytedance.android.live.profit.vote.f r117 = r100.f89334g;
            r117.c(r116);
            r117.a(r116);
            r117.d(r116);
            VoteUtilsKt.i(r116);
            Object r118 = r115.f89238a.getItems().f267520d;
            if (((List) r118).size() < 2) goto L20;
            boolean r119 = true;
        L21:
            if (r119 == true) goto L24;
            r118 = null;
        L24:
            List r120 = (List) r118;
            if (r120 == null) goto L37;
            com.bytedance.android.live.profit.vote.g r121 = (com.bytedance.android.live.profit.vote.g) ListProtector.get(r120, 0);
            com.bytedance.android.live.profit.vote.g r122 = (com.bytedance.android.live.profit.vote.g) ListProtector.get(r120, 1);
            int r123 = f.f89349b[VoteUtilsKt.a(r121, r122).ordinal()];
            if (r123 == 1) goto L35;
            if (r123 != 2) goto L30;
            String r124 = com.bytedance.android.ec.core.event.a.VALUE_NEGATIVE;
        L36:
            r116.put("poll_result", r124);
            r116.put("positive_score", String.valueOf(r122.f89199a));
            r116.put("negative_score", String.valueOf(r121.f89199a));
            r116.put(com.bytedance.android.ec.core.event.a.KEY_SCORE, String.valueOf(r122.f89199a) + String.valueOf(r121.f89199a));
            goto L37
        L30:
            if (r123 != 3) goto L33;
            r124 = com.bytedance.android.ec.core.event.a.VALUE_POSITIVE;
            goto L36
        L33:
            throw new NoWhenBranchMatchedException();
        L35:
            r124 = CoverDownloadInfo.DEFAULT_POLICY;
        L37:
            mz0.n r125 = new mz0.n();
            Map<String, String> r126 = r125.f516447a;
            Intrinsics.checkNotNullParameter(r126, "map");
            Intrinsics.checkNotNullParameter(r116, "map");
            r126.putAll(r116);
            m r127 = new m();
            r127.b(LogCommon.ROOM);
            ((ArrayList) r125.f516448b).addAll(r127.f516446a);
            cy0.e.f465759a.getClass();
            cy0.j r128 = cy0.e.a.f465760a;
            com.bytedance.android.scope.m.f163449e.getClass();
            Object r129 = com.bytedance.android.scope.m.b(r128).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r129);
            ((mz0.i) ((f80.a) r129)).w3("livesdk_ksong_poll_end", r125.f516447a, r125.f516448b);
            return;
        L20:
            r119 = false;
            goto L21
        L43:
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.live.profit.vote.model.b r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    static {
        f89326h = 9;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        com.bytedance.revenue.platform.api.core.rx.f.a(PropertyOwnersKt.c(this.f89333f.f89252a).subscribe(new b(this)), this.f89328a);
        n<com.bytedance.android.live.profit.vote.model.b> r100 = this.f89331d;
        final AnonymousClass2 r101 = new AnonymousClass2(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r100.subscribe(new c(r101)), this.f89328a);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f89328a.dispose();
        this.f89329b.dispose();
        this.f89330c.dispose();
        this.f89331d.onComplete();
    }

    public VoteViewModel(com.bytedance.android.live.profit.vote.model.f r100, com.bytedance.android.live.profit.vote.f r101) {
        Intrinsics.checkNotNullParameter(r100, "repo");
        Intrinsics.checkNotNullParameter(r101, "etHelper");
        this.f89333f = r100;
        this.f89334g = r101;
        this.f89328a = new CompositeDisposable();
        this.f89329b = new CompositeDisposable();
        this.f89330c = new CompositeDisposable();
        n<com.bytedance.android.live.profit.vote.model.b> r102 = PropertyOwnersKt.b(com.bytedance.android.live.profit.vote.model.b.c.f89239a);
        this.f89331d = r102;
        this.f89332e = r102;
    }
}
