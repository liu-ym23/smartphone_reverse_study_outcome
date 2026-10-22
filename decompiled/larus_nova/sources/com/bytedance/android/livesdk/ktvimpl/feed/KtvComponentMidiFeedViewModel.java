package com.bytedance.android.livesdk.ktvimpl.feed;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.sei.v;
import com.bytedance.android.livesdk.ktvimpl.base.sei.w;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class KtvComponentMidiFeedViewModel implements com.bytedance.android.livesdk.ktvimpl.base.sei.c, db0.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f143838q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f143839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f143840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f143841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ScheduledFuture<?> f143842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<List<cb0.c>> f143843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<Boolean> f143844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<Boolean> f143845g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<com.bytedance.android.livesdk.ktvimpl.base.sei.h> f143846h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData<com.bytedance.android.live.ktv.common.midi.k> f143847i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CompositeDisposable f143848j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Disposable f143849k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f143850l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f143851m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final k f143852n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f143853o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final KtvComponentFeedViewModel f143854p;

    public static final class a {
    }

    public static final class b<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f143855a = null;

        static {
            f143855a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return !r101.isEmpty();
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f143856a = null;

        static {
            f143856a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return Observable.fromIterable(r101);
        }
    }

    public static final class d<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f143857a;

        public d(long r100) {
            this.f143857a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            cb0.c r101 = (cb0.c) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            cb0.a r102 = r101.f22991a;
            long r103 = r102.f22988a;
            long r104 = this.f143857a;
            if (r103 < r104) goto L5;
        L7:
            return false;
        L5:
            if (r102.f22989b < r104) goto L7;
            return true;
        }
    }

    public static final class e<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f143858a = null;

        static {
            f143858a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return !r101.isEmpty();
        }
    }

    public static final class f<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f143859a = null;

        static {
            f143859a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return Observable.fromIterable(r101);
        }
    }

    public static final class g<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f143860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f143861b;

        public g(long r100, long r101) {
            this.f143860a = r100;
            this.f143861b = r101;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            cb0.c r101 = (cb0.c) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            cb0.a r102 = r101.f22991a;
            if (r102.f22988a < this.f143860a) goto L5;
        L7:
            return false;
        L5:
            if (r102.f22989b <= this.f143861b) goto L7;
            return true;
        }
    }

    public static final class h<T> implements SingleOnSubscribe {
        public h(String r100) {
        }

        @Override // io.reactivex.SingleOnSubscribe
        public final void subscribe(SingleEmitter<List<cb0.c>> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            if (vm2.h.d() == false) goto L7;
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r101 = ILiveWrappedLivePusher.a.b();
            if (r101 == null) goto L10;
            r101.getLiveCoreKaraokFilter();
        L10:
            r100.onError(new Exception("getMidiDrawingData error"));
            return;
        L7:
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r102 = ILiveWrappedLivePusher.a.b();
            if (r102 == null) goto L10;
            r102.getLiveCoreKaraokFilter();
            goto L10
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentMidiFeedViewModel f143862a;

        public i(KtvComponentMidiFeedViewModel r100) {
            this.f143862a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.ktv.common.midi.e.b("KtvComponentMidiFeedViewModel", "initMidiRes success");
            MutableLiveData<List<cb0.c>> r101 = this.f143862a.f143843e;
            r101.setValue((List) r100);
            this.f143862a.f143844f.setValue(Boolean.FALSE);
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentMidiFeedViewModel f143863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f143864b;

        public j(KtvComponentMidiFeedViewModel r100, long r101) {
            this.f143863a = r100;
            this.f143864b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.ktv.common.midi.e.b("KtvComponentMidiFeedViewModel", "initMidiRes failed");
            ((Throwable) r100).printStackTrace();
            pd2.d.f528658n.F(this.f143864b);
            this.f143863a.f143844f.setValue(Boolean.TRUE);
        }
    }

    public static final class k implements com.bytedance.android.live.ktv.common.music.download.k.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentMidiFeedViewModel f143865a;

        @Override // com.bytedance.android.live.ktv.common.music.download.k.b
        public final void onFailed(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "errorMsg");
        }

        public k(KtvComponentMidiFeedViewModel r100) {
            this.f143865a = r100;
        }

        @Override // com.bytedance.android.live.ktv.common.music.download.k.b
        public final void a(long r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "midiSavePath");
            KtvComponentMidiFeedViewModel r103 = this.f143865a;
            if (r103.f143841c != r100) goto L6;
            r103.a(r100, r101);
            return;
        }
    }

    static {
    }

    @Override // db0.a
    public final cb0.c findMidiSegmentOpt(long r100) {
        return null;
    }

    @Override // db0.a
    public final List<cb0.c> findMidiSegmentsOpt(long r100, long r101) {
        return null;
    }

    public KtvComponentMidiFeedViewModel(KtvComponentFeedViewModel r100) {
        this.f143854p = r100;
        this.f143840b = LazyKt.lazy(new KtvComponentMidiFeedViewModel$loadMidiSoRunnable$2(this));
        this.f143843e = new MutableLiveData();
        this.f143844f = new MutableLiveData();
        this.f143845g = new MutableLiveData();
        this.f143846h = new MutableLiveData();
        this.f143847i = new MutableLiveData();
        this.f143848j = new CompositeDisposable();
        this.f143852n = new k(this);
        this.f143853o = new AtomicBoolean(false);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final boolean accept(w r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r100, "result");
        return true;
    }

    public final void b(com.bytedance.android.livesdk.ktvimpl.base.sei.k r100) {
        if (KtvSettingHelper.f() == true) goto L5;
        return;
    L5:
        boolean r101 = false;
        if (r100.j() > 0) goto L8;
    L17:
        boolean r102 = false;
    L18:
        if (r102 == true) goto L20;
        return;
    L20:
        if (r100.j() != this.f143841c) goto L27;
        List<cb0.c> r103 = this.f143843e.getValue();
        if (r103 != null) goto L24;
    L25:
        r101 = true;
    L26:
        if (r101 == true) goto L27;
        return;
    L24:
        if (r103.isEmpty() == false) goto L26;
    L27:
        this.f143841c = r100.j();
        com.bytedance.android.live.ktv.common.music.download.h r104 = com.bytedance.android.live.ktv.common.music.download.h.f70063a;
        String r105 = com.bytedance.android.live.ktv.common.music.download.h.e(r100.t(), this.f143841c);
        if (new PolarisFileWrapper(r105).exists() == false) goto L30;
        a(this.f143841c, r105);
        return;
    L30:
        com.bytedance.android.live.ktv.common.music.download.k.a r106 = com.bytedance.android.live.ktv.common.music.download.k.f70071a;
        long r107 = this.f143841c;
        String r108 = r100.t();
        if (r108 != null) goto L33;
        r108 = "";
    L33:
        com.bytedance.android.live.ktv.common.music.download.k.c r109 = new com.bytedance.android.live.ktv.common.music.download.k.c(r107, r108, r105);
        WeakReference r110 = new WeakReference(this.f143852n);
        r106.getClass();
        com.bytedance.android.live.ktv.common.music.download.k.a.b(r109, r110);
        return;
    L8:
        if (r100.n() == 2) goto L17;
        String r111 = r100.t();
        if (r111 == null) goto L17;
        if (r111.length() <= 0) goto L14;
        boolean r112 = true;
    L15:
        if (r112 != true) goto L17;
        r102 = true;
        goto L18
    L14:
        r112 = false;
        goto L15
    }

    @Override // db0.a
    public final Observable<cb0.c> findMidiSegment(long r100) {
        List<cb0.c> r101 = this.f143843e.getValue();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L13;
        return Observable.empty();
    L13:
        return Observable.just(this.f143843e.getValue()).filter(b.f143855a).flatMap(c.f143856a).filter(new d(r100));
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final void onSeiResult(w r110) {
        Intrinsics.checkNotNullParameter(r110, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r111 = r110.f143344b;
        boolean r100 = false;
        if ((r111 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L52;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r112 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r111;
        int r101 = r112.d();
        if (r101 == 0) goto L32;
        if (r101 == 3) goto L15;
        if (r101 == 4) goto L32;
        if (r101 != 5) goto L87;
        b(r112);
        return;
    L87:
        return;
    L15:
        if (r112.j() <= 0) goto L74;
        List<v> r102 = r112.l();
        if (r102 != null) goto L19;
    L22:
        boolean r103 = true;
    L23:
        if (r103 == false) goto L75;
        String r113 = r112.t();
        if (r113 != null) goto L27;
    L28:
        r100 = true;
    L29:
        if (r100 == false) goto L76;
        this.f143844f.setValue(Boolean.TRUE);
        return;
    L76:
        return;
    L27:
        if (r113.length() != 0) goto L29;
    L75:
        return;
    L19:
        if (r102.isEmpty() == true) goto L22;
        r103 = false;
        goto L23
    L74:
        return;
    L32:
        if (KtvSettingHelper.f() == false) goto L35;
        b(r112);
        return;
    L35:
        if (r112.j() > 0) goto L37;
        return;
    L37:
        if (r112.j() != this.f143841c) goto L39;
        return;
    L39:
        if (r112.n() == 2) goto L81;
        String r104 = r112.t();
        if (r104 != null) goto L43;
    L44:
        r100 = true;
    L45:
        if (r100 == true) goto L50;
        long r105 = r112.j();
        this.f143841c = r105;
        com.bytedance.android.live.ktv.common.music.download.h r114 = com.bytedance.android.live.ktv.common.music.download.h.f70063a;
        String r115 = com.bytedance.android.live.ktv.common.music.download.h.e(r104, r105);
        if (new PolarisFileWrapper(r115).exists() == false) goto L49;
        a(this.f143841c, r115);
        return;
    L49:
        com.bytedance.android.live.ktv.common.music.download.k.a r106 = com.bytedance.android.live.ktv.common.music.download.k.f70071a;
        com.bytedance.android.live.ktv.common.music.download.k.c r107 = new com.bytedance.android.live.ktv.common.music.download.k.c(this.f143841c, r104, r115);
        WeakReference r116 = new WeakReference(this.f143852n);
        r106.getClass();
        com.bytedance.android.live.ktv.common.music.download.k.a.b(r107, r116);
        return;
    L50:
        this.f143844f.setValue(Boolean.TRUE);
        return;
    L43:
        if (r104.length() != 0) goto L45;
    L81:
        return;
    L52:
        if ((r111 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.i) == false) goto L70;
        if (this.f143839a == true) goto L56;
        this.f143839a = true;
        this.f143842d = TTExecutors.getScheduledThreadPool().schedule((Runnable) this.f143840b.getValue(), 0, TimeUnit.SECONDS);
    L56:
        com.bytedance.android.livesdk.ktvimpl.base.sei.i r117 = (com.bytedance.android.livesdk.ktvimpl.base.sei.i) r111;
        List<cb0.c> r108 = this.f143843e.getValue();
        if (r108 != null) goto L59;
    L60:
        r100 = true;
    L61:
        if (r100 == false) goto L64;
        return;
    L64:
        if ((System.currentTimeMillis() - this.f143851m) < ((Number) KtvSettingHelper.G0.getValue()).longValue()) goto L66;
    L68:
        this.f143851m = System.currentTimeMillis();
        com.bytedance.android.live.ktv.common.midi.e.b("KtvComponentMidiFeedViewModel", String.valueOf(r117));
        this.f143847i.setValue(new com.bytedance.android.live.ktv.common.midi.k(r117.j(), r117.i(), 0.0f, r117.g(), r117.f(), Integer.valueOf(r117.e()), r117.c(), false, 128));
        return;
    L66:
        if (this.f143851m == 0) goto L68;
        return;
    L59:
        if (r108.isEmpty() == false) goto L61;
    L70:
        if ((r111 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.h) == false) goto L86;
        this.f143846h.setValue((com.bytedance.android.livesdk.ktvimpl.base.sei.h) r111);
        return;
    }

    public final void a(long r100, String r101) {
        if (this.f143839a == true) goto L5;
        return;
    L5:
        if (this.f143853o.get() == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        this.f143844f.setValue(Boolean.TRUE);
        return;
    L11:
        RxUtilKt.c(Single.create(new h(r101)).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(this), new j(this, r100)), this.f143848j);
    }

    @Override // db0.a
    public final Single<List<cb0.c>> findMidiSegments(long r100, long r101) {
        List<cb0.c> r102 = this.f143843e.getValue();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L13;
        return null;
    L13:
        return Observable.just(this.f143843e.getValue()).filter(e.f143858a).flatMap(f.f143859a).filter(new g(r101, r100)).toList();
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }
}
